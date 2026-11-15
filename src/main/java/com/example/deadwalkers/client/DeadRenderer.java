package com.example.deadwalkers.client;

import com.example.deadwalkers.DeadWalkers;
import com.example.deadwalkers.entity.DeadEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DeadRenderer extends MobRenderer<DeadEntity, DeadModel> {
    private final ResourceLocation texture;

    public DeadRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation layer, String name,
                        int style, float armRaise, float shadow) {
        super(ctx, new DeadModel(ctx.bakeLayer(layer), style, armRaise), shadow);
        this.texture = new ResourceLocation(DeadWalkers.MODID, "textures/entity/" + name + ".png");
        this.addLayer(new DeadEyesLayer(this,
                new ResourceLocation(DeadWalkers.MODID, "textures/entity/" + name + "_eyes.png")));
    }

    @Override
    public ResourceLocation getTextureLocation(DeadEntity entity) { return texture; }
}
