package com.example.deadwalkers.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;

/** สกิล 5: Ankle Grab - คว้าข้อเท้า โจมตีโดนแล้วเป้าหมายเคลื่อนที่ช้าลงมาก */
public class CrawlerEntity extends DeadEntity {
    public CrawlerEntity(EntityType<? extends CrawlerEntity> type, Level level) { super(type, level); }

    public static AttributeSupplier.Builder createAttributes() { return attrs(10, 0.20, 2, 30); }

    @Override
    public boolean doHurtTarget(Entity target) {
        boolean hit = super.doHurtTarget(target);
        if (hit && target instanceof LivingEntity le) {
            le.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 80, 2), this);
        }
        return hit;
    }

    @Override protected SoundEvent getAmbientSound() { return SoundEvents.SPIDER_AMBIENT; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return SoundEvents.SPIDER_HURT; }
    @Override protected SoundEvent getDeathSound() { return SoundEvents.SPIDER_DEATH; }
    @Override protected SoundEvent aggroSound() { return SoundEvents.CAT_HISS; }
    @Override protected float basePitch() { return 0.55F; }
}
