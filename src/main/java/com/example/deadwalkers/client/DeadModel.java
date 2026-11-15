package com.example.deadwalkers.client;

import com.example.deadwalkers.entity.DeadEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

public class DeadModel extends HierarchicalModel<DeadEntity> {
    private final ModelPart root, head, rightArm, leftArm, rightLeg, leftLeg;
    private final boolean crawler;
    private final float armRaise;

    public DeadModel(ModelPart root, boolean crawler, float armRaise) {
        this.root = root;
        this.head = root.getChild("head");
        this.rightArm = root.getChild("right_arm");
        this.leftArm = root.getChild("left_arm");
        this.rightLeg = root.getChild("right_leg");
        this.leftLeg = root.getChild("left_leg");
        this.crawler = crawler;
        this.armRaise = armRaise;
    }

    @Override
    public ModelPart root() { return root; }

    @Override
    public void setupAnim(DeadEntity e, float limbSwing, float limbSwingAmount,
                          float ageInTicks, float netHeadYaw, float headPitch) {
        head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
        head.xRot = headPitch * Mth.DEG_TO_RAD;
        head.zRot = Mth.sin(ageInTicks * 0.05F) * 0.08F;

        float s = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
        float idle = Mth.sin(ageInTicks * 0.067F) * 0.05F;
        if (crawler) {
            rightArm.xRot = s * 1.2F;
            leftArm.xRot = -s * 1.2F;
            rightLeg.xRot = -s * 1.2F;
            leftLeg.xRot = s * 1.2F;
        } else {
            rightArm.xRot = -armRaise + s * 0.5F + idle;
            leftArm.xRot = -armRaise - s * 0.5F - idle;
            rightArm.yRot = -0.1F;
            leftArm.yRot = 0.1F;
            rightLeg.xRot = s * 1.4F;
            leftLeg.xRot = -s * 1.4F;
        }
    }
}
