package com.example.deadwalkers.entity;

import java.util.List;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;

/** สกิล 1: Horde Call - ส่งเสียงเรียกฝูง ทำให้ซอมบี้รอบข้างหันมาล่าเป้าหมายเดียวกัน */
public class WalkerEntity extends DeadEntity {
    public WalkerEntity(EntityType<? extends WalkerEntity> type, Level level) { super(type, level); }

    public static AttributeSupplier.Builder createAttributes() { return attrs(20, 0.23, 3, 35); }

    @Override
    protected void useSkill(LivingEntity target) {
        skillCooldown = 200;
        level().playSound(null, blockPosition(), SoundEvents.ZOMBIE_AMBIENT, SoundSource.HOSTILE, 2.0F, 0.5F);
        List<DeadEntity> others = level().getEntitiesOfClass(DeadEntity.class, getBoundingBox().inflate(24.0),
                e -> e != this && e.isAlive() && e.getTarget() == null);
        int n = 0;
        for (DeadEntity e : others) {
            if (n++ >= 8) break;
            e.setTarget(target);
        }
    }
}
