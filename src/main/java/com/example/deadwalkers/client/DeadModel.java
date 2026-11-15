package com.example.deadwalkers.client;

import com.example.deadwalkers.entity.DeadEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

/** style: 0 walker, 1 runner, 2 spitter, 3 bloater, 4 crawler */
public class DeadModel extends HierarchicalModel<DeadEntity> {
    private final ModelPart root, head, rightArm, leftArm, rightLeg, leftLeg;
    private final int style;
    private final float armRaise;

    public DeadModel(ModelPart root, int style, float armRaise) {
        this.root = root;
        this.head = root.getChild("head");
        this.rightArm = root.getChild("right_arm");
        this.leftArm = root.getChild("left_arm");
        this.rightLeg = root.getChild("right_leg");
        this.leftLeg = root.getChild("left_leg");
        this.style = style;
        this.armRaise = armRaise;
    }

    @Override
    public ModelPart root() { return root; }

    @Override
    public void setupAnim(DeadEntity e, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        boolean aggro = e.isAggressive();
        float t = ageInTicks;

        head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
        head.xRot = headPitch * Mth.DEG_TO_RAD;
        head.zRot = Mth.sin(t * 0.05F) * 0.08F;

        // กระตุกหัวแบบผิดธรรมชาติเป็นระยะ
        if ((e.tickCount + e.getId() * 7) % 90 < 8) {
            head.yRot += Mth.sin(t * 2.7F) * 0.35F;
            head.zRot += Mth.sin(t * 3.1F) * 0.2F;
        }

        float speed = style == 1 ? 1.5F : 1.0F;
        float s = Mth.cos(limbSwing * 0.6662F * speed) * limbSwingAmount;

        if (style == 4) {
            // คลานสี่ขา: แขนขาสลับแนวทแยง + หัวส่ายไปมา
            rightArm.xRot = s * 1.3F;
            leftArm.xRot = -s * 1.3F;
            rightLeg.xRot = -s * 1.3F;
            leftLeg.xRot = s * 1.3F;
            head.yRot += Mth.sin(limbSwing * 0.6662F) * 0.25F * limbSwingAmount;
            head.xRot += aggro ? -0.25F : 0.1F;
        } else {
            float raise = aggro ? armRaise : armRaise * 0.35F;
            head.xRot += aggro ? -0.1F : 0.4F;                 // ไม่เจอเหยื่อ: หัวห้อย / เจอแล้ว: เงยหน้าคำราม
            if (aggro) head.zRot += Mth.sin(t * 1.9F) * 0.12F; // สั่นตอนเดือด

            float sway = Mth.sin(t * 0.067F) * 0.05F;
            float shake = aggro ? Mth.sin(t * 1.5F) * 0.06F : 0.0F;
            rightArm.xRot = -raise + s * 0.5F + sway + shake;
            leftArm.xRot = -raise - s * 0.5F - sway - shake;
            rightArm.yRot = -0.1F;
            leftArm.yRot = 0.1F;
            rightArm.zRot = aggro ? 0.1F : 0.05F;
            leftArm.zRot = aggro ? -0.1F : -0.05F;

            rightLeg.xRot = s * 1.4F;
            leftLeg.xRot = -s * 1.4F;
            if (style == 0) {            // Walker: ขาซ้ายลาก เดินกะเผลก
                leftLeg.xRot *= 0.45F;
                leftLeg.yRot = 0.15F;
            }
            if (style == 3) {            // Bloater: เดินหนักช้า
                rightLeg.xRot *= 0.6F;
                leftLeg.xRot *= 0.6F;
            }
        }

        // อนิเมชันโจมตี: ฟาดแขนลง + พุ่งหัวกัด
        if (attackTime > 0.0F) {
            float a = Mth.sin(attackTime * Mth.PI);
            rightArm.xRot += a * 1.6F;
            leftArm.xRot += a * 1.6F;
            head.xRot += a * 0.45F;
        }
    }
}
