package com.example.deadwalkers.entity;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

/** สกิล 4: Death Burst - ตายแล้วท้องแตก ปล่อยกลุ่มก๊าซพิษ */
public class BloaterEntity extends DeadEntity {
    public BloaterEntity(EntityType<? extends BloaterEntity> type, Level level) { super(type, level); }

    public static AttributeSupplier.Builder createAttributes() {
        return attrs(50, 0.16, 5, 28).add(Attributes.KNOCKBACK_RESISTANCE, 0.6);
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        if (!level().isClientSide) {
            AreaEffectCloud cloud = new AreaEffectCloud(level(), getX(), getY(), getZ());
            cloud.setRadius(3.0F);
            cloud.setDuration(200);
            cloud.setRadiusPerTick(-0.01F);
            cloud.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0));
            cloud.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0));
            cloud.setFixedColor(0x7FA03A);
            level().addFreshEntity(cloud);
            playSound(SoundEvents.SLIME_SQUISH, 2.0F, 0.6F);
        }
    }
}
