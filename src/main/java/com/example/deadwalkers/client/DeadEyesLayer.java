package com.example.deadwalkers.client;

import com.example.deadwalkers.entity.DeadEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

/** ดวงตาเรืองแสง (สว่างแม้ในที่มืด) */
public class DeadEyesLayer extends EyesLayer<DeadEntity, DeadModel> {
    private final RenderType type;

    public DeadEyesLayer(RenderLayerParent<DeadEntity, DeadModel> parent, ResourceLocation texture) {
        super(parent);
        this.type = RenderType.eyes(texture);
    }

    @Override
    public RenderType renderType() { return type; }
}
