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
                        boolean crawler, float armRaise, float shadow) {
        super(ctx, new DeadModel(ctx.bakeLayer(layer), crawler, armRaise), shadow);
        this.texture = new ResourceLocation(DeadWalkers.MODID, "textures/entity/" + name + ".png");
    }

    @Override
    public ResourceLocation getTextureLocation(DeadEntity entity) { return texture; }
}
