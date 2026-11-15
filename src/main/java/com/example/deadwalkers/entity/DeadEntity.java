package com.example.deadwalkers.entity;

import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

/**
 * ฐานของซอมบี้ทุกพันธุ์ สืบทอดจาก Monster (ไม่ใช่ Zombie)
 * => ไม่โดนแดดเผา ไม่แปลงร่างในน้ำ และเกิดได้ทุกระดับแสง
 */
public abstract class DeadEntity extends Monster {
    protected int skillCooldown = 60;
    private int screamCooldown = 0;

    protected DeadEntity(EntityType<? extends DeadEntity> type, Level level) {
        super(type, level);
        this.xpReward = 8;
    }

    protected static AttributeSupplier.Builder attrs(double hp, double speed, double dmg, double follow) {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, hp)
                .add(Attributes.MOVEMENT_SPEED, speed)
                .add(Attributes.ATTACK_DAMAGE, dmg)
                .add(Attributes.FOLLOW_RANGE, follow);
    }

    public static boolean checkDeadSpawn(EntityType<? extends DeadEntity> type, ServerLevelAccessor level,
                                         MobSpawnType reason, BlockPos pos, RandomSource random) {
        return level.getDifficulty() != Difficulty.PEACEFUL
                && Mob.checkMobSpawnRules(type, level, reason, pos, random);
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(0, new FloatGoal(this));
        goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
        goalSelector.addGoal(5, new MoveTowardsRestrictionGoal(this, 1.0D));
        goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 0.8D));
        goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        targetSelector.addGoal(1, new HurtByTargetGoal(this));
        targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
    }

    /** เสียงกรีดร้องตอนเห็นเหยื่อครั้งแรก */
    protected SoundEvent aggroSound() { return SoundEvents.ZOMBIE_VILLAGER_CURE; }

    /** ระดับเสียงพื้นฐานของพันธุ์ (ต่ำ = ทุ้มน่ากลัว) */
    protected float basePitch() { return 0.6F; }

    // ไม่ใส่ @Override เพื่อไม่ผูกกับระดับการเข้าถึงของเมธอดต้นทาง (public ได้ทั้งสองกรณี)
    public float getVoicePitch() {
        return basePitch() + (random.nextFloat() - random.nextFloat()) * 0.12F;
    }

    public float getSoundVolume() { return 1.4F; }

    public int getAmbientSoundInterval() { return 60; }

    @Override
    public void setTarget(@Nullable LivingEntity target) {
        boolean spotted = getTarget() == null && target != null;
        super.setTarget(target);
        if (spotted && !level().isClientSide && screamCooldown <= 0) {
            playSound(aggroSound(), 1.8F, basePitch());
            screamCooldown = 120;
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (screamCooldown > 0) screamCooldown--;
        if (!level().isClientSide && isAlive()) {
            if (skillCooldown > 0) {
                skillCooldown--;
            } else if (getTarget() != null) {
                useSkill(getTarget());
            }
        }
    }

    /** สกิลประจำพันธุ์ (ถูกเรียกเมื่อคูลดาวน์หมดและมีเป้าหมาย) */
    protected void useSkill(LivingEntity target) { }

    @Override public MobType getMobType() { return MobType.UNDEAD; }
    @Override protected SoundEvent getAmbientSound() { return SoundEvents.ZOMBIE_AMBIENT; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return SoundEvents.ZOMBIE_HURT; }
    @Override protected SoundEvent getDeathSound() { return SoundEvents.ZOMBIE_DEATH; }
    @Override protected void playStepSound(BlockPos pos, BlockState state) {
        playSound(SoundEvents.ZOMBIE_STEP, 0.15F, 1.0F);
    }
}
