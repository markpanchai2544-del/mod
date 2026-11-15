package com.example.deadwalkers.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/** สกิล 2: Lunge - กระโจนพุ่งใส่เป้าหมายเมื่ออยู่ในระยะ 3-10 บล็อก */
public class RunnerEntity extends DeadEntity {
    public RunnerEntity(EntityType<? extends RunnerEntity> type, Level level) { super(type, level); }

    public static AttributeSupplier.Builder createAttributes() { return attrs(12, 0.32, 2, 30); }

    @Override
    protected void useSkill(LivingEntity target) {
        double d = distanceTo(target);
        if (onGround() && d > 3.0 && d < 10.0 && hasLineOfSight(target)) {
            Vec3 dir = target.position().subtract(position()).multiply(1, 0, 1).normalize();
            setDeltaMovement(dir.x * 1.0, 0.45, dir.z * 1.0);
            this.hasImpulse = true;
            playSound(SoundEvents.ZOMBIE_ATTACK_IRON_DOOR, 0.8F, 1.4F);
            skillCooldown = 80;
        }
    }

    @Override protected SoundEvent getAmbientSound() { return SoundEvents.HUSK_AMBIENT; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return SoundEvents.HUSK_HURT; }
    @Override protected SoundEvent getDeathSound() { return SoundEvents.HUSK_DEATH; }
    @Override protected SoundEvent aggroSound() { return SoundEvents.ENDERMAN_SCREAM; }
    @Override protected float basePitch() { return 1.25F; }
}
