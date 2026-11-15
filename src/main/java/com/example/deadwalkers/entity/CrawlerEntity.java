package com.example.deadwalkers.entity;

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
}
