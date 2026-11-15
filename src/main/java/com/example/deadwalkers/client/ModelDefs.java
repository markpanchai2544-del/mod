package com.example.deadwalkers.client;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

/** AUTO-GENERATED: โมเดลของซอมบี้ทั้ง 5 พันธุ์ (texture 64x64) */
public class ModelDefs {
    public static LayerDefinition walker() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition p_head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 1.5F, -2.0F));
        PartDefinition p_jaw = p_head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(32, 0).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 3.0F, 6.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition p_body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition p_hump = root.addOrReplaceChild("hump", CubeListBuilder.create().texOffs(0, 32).addBox(-3.0F, -3.0F, 2.0F, 6.0F, 5.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition p_hem = root.addOrReplaceChild("hem", CubeListBuilder.create().texOffs(24, 32).addBox(-4.5F, 10.0F, -2.5F, 9.0F, 4.0F, 5.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition p_right_arm = root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(-5.0F, 2.0F, 0.0F));
        PartDefinition p_left_arm = root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(5.0F, 2.0F, 0.0F));
        PartDefinition p_right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(-1.9F, 12.0F, 0.0F));
        PartDefinition p_left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(1.9F, 12.0F, 0.0F));
        return LayerDefinition.create(mesh, 64, 64);
    }

    public static LayerDefinition runner() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition p_head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 1.0F, -1.0F));
        PartDefinition p_band = p_head.addOrReplaceChild("band", CubeListBuilder.create().texOffs(0, 32).addBox(-4.5F, -5.0F, -4.5F, 9.0F, 2.0F, 9.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition p_body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-3.0F, 0.0F, -1.5F, 6.0F, 12.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition p_spine = root.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(32, 0).addBox(-1.5F, 1.0F, 1.5F, 3.0F, 9.0F, 2.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition p_right_arm = root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-2.5F, -2.0F, -1.5F, 3.0F, 14.0F, 3.0F), PartPose.offset(-4.5F, 2.0F, 0.0F));
        PartDefinition p_left_arm = root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-0.5F, -2.0F, -1.5F, 3.0F, 14.0F, 3.0F), PartPose.offset(4.5F, 2.0F, 0.0F));
        PartDefinition p_right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F), PartPose.offset(-1.5F, 11.0F, 0.0F));
        PartDefinition p_left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 13.0F, 3.0F), PartPose.offset(1.5F, 11.0F, 0.0F));
        return LayerDefinition.create(mesh, 64, 64);
    }

    public static LayerDefinition spitter() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition p_head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 1.0F, -1.5F));
        PartDefinition p_sac = p_head.addOrReplaceChild("sac", CubeListBuilder.create().texOffs(32, 0).addBox(-3.0F, -1.0F, -7.0F, 6.0F, 5.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition p_body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition p_tank = p_body.addOrReplaceChild("tank", CubeListBuilder.create().texOffs(0, 32).addBox(-3.0F, 1.0F, 2.0F, 6.0F, 8.0F, 3.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition p_right_arm = root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(-5.0F, 2.0F, 0.0F));
        PartDefinition p_left_arm = root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(5.0F, 2.0F, 0.0F));
        PartDefinition p_right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(-1.9F, 12.0F, 0.0F));
        PartDefinition p_left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), PartPose.offset(1.9F, 12.0F, 0.0F));
        return LayerDefinition.create(mesh, 64, 64);
    }

    public static LayerDefinition bloater() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition p_head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, -1.0F, -3.0F));
        PartDefinition p_body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 32).addBox(-6.0F, 0.0F, -4.0F, 12.0F, 14.0F, 8.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition p_right_arm = root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-4.0F, -2.0F, -2.5F, 5.0F, 13.0F, 5.0F), PartPose.offset(-7.0F, 1.0F, 0.0F));
        PartDefinition p_left_arm = root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.5F, 5.0F, 13.0F, 5.0F), PartPose.offset(7.0F, 1.0F, 0.0F));
        PartDefinition p_right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F), PartPose.offset(-3.5F, 14.0F, 0.0F));
        PartDefinition p_left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.5F, 0.0F, -2.5F, 5.0F, 10.0F, 5.0F), PartPose.offset(3.5F, 14.0F, 0.0F));
        PartDefinition p_boil1 = root.addOrReplaceChild("boil1", CubeListBuilder.create().texOffs(40, 0).addBox(-3.0F, 3.0F, -5.0F, 4.0F, 4.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition p_boil2 = root.addOrReplaceChild("boil2", CubeListBuilder.create().texOffs(50, 0).addBox(1.0F, 5.0F, 4.0F, 5.0F, 5.0F, 1.0F), PartPose.offset(0.0F, 0.0F, 0.0F));
        return LayerDefinition.create(mesh, 64, 64);
    }

    public static LayerDefinition crawler() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();
        PartDefinition p_head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F), PartPose.offset(0.0F, 18.0F, -7.0F));
        PartDefinition p_body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -2.0F, -6.0F, 8.0F, 4.0F, 12.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
        PartDefinition p_spine = root.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(28, 0).addBox(-1.0F, -4.0F, -5.0F, 2.0F, 2.0F, 10.0F), PartPose.offset(0.0F, 16.0F, 0.0F));
        PartDefinition p_right_arm = root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 16).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offset(-4.5F, 18.0F, -4.0F));
        PartDefinition p_left_arm = root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offset(4.5F, 18.0F, -4.0F));
        PartDefinition p_right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 32).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offset(-3.5F, 18.0F, 5.0F));
        PartDefinition p_left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F), PartPose.offset(3.5F, 18.0F, 5.0F));
        return LayerDefinition.create(mesh, 64, 64);
    }

}