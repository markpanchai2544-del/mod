package com.example.deadwalkers.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/** สกิล 3: Toxic Spit - คายพิษใส่จากระยะไกล (พิษ + หิว) ไม่สร้างเอนทิตีกระสุน จึงเบาเครื่อง */
public class SpitterEntity extends DeadEntity {
    public SpitterEntity(EntityType<? extends SpitterEntity> type, Level level) { super(type, level); }

    public static AttributeSupplier.Builder createAttributes() { return attrs(16, 0.22, 2, 30); }

    @Override
    protected void useSkill(LivingEntity target) {
        double d = distanceTo(target);
        if (d > 3.0 && d < 14.0 && hasLineOfSight(target)) {
            skillCooldown = 70;
            target.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0), this);
            target.addEffect(new MobEffectInstance(MobEffects.HUNGER, 100, 1), this);
            playSound(SoundEvents.LLAMA_SPIT, 1.0F, 0.8F);
            if (level() instanceof ServerLevel sl) {
                Vec3 a = getEyePosition();
                Vec3 b = target.getEyePosition();
                for (int i = 0; i <= 10; i++) {
                    Vec3 p = a.lerp(b, i / 10.0);
                    sl.sendParticles(ParticleTypes.ITEM_SLIME, p.x, p.y, p.z, 2, 0.05, 0.05, 0.05, 0.0);
                }
            }
        }
    }

    @Override protected SoundEvent getAmbientSound() { return SoundEvents.PHANTOM_AMBIENT; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return SoundEvents.PHANTOM_HURT; }
    @Override protected SoundEvent getDeathSound() { return SoundEvents.PHANTOM_DEATH; }
    @Override protected SoundEvent aggroSound() { return SoundEvents.GHAST_WARN; }
    @Override protected float basePitch() { return 0.8F; }
}
