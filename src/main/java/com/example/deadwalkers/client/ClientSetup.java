package com.example.deadwalkers.client;

import com.example.deadwalkers.DeadWalkers;
import com.example.deadwalkers.ModEntities;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DeadWalkers.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    public static final ModelLayerLocation WALKER = layer("walker");
    public static final ModelLayerLocation RUNNER = layer("runner");
    public static final ModelLayerLocation SPITTER = layer("spitter");
    public static final ModelLayerLocation BLOATER = layer("bloater");
    public static final ModelLayerLocation CRAWLER = layer("crawler");

    private static ModelLayerLocation layer(String name) {
        return new ModelLayerLocation(new ResourceLocation(DeadWalkers.MODID, name), "main");
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions e) {
        e.registerLayerDefinition(WALKER, ModelDefs::walker);
        e.registerLayerDefinition(RUNNER, ModelDefs::runner);
        e.registerLayerDefinition(SPITTER, ModelDefs::spitter);
        e.registerLayerDefinition(BLOATER, ModelDefs::bloater);
        e.registerLayerDefinition(CRAWLER, ModelDefs::crawler);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers e) {
        e.registerEntityRenderer(ModEntities.WALKER.get(),
                c -> new DeadRenderer(c, WALKER, "walker", 0, 1.4F, 0.5F));
        e.registerEntityRenderer(ModEntities.RUNNER.get(),
                c -> new DeadRenderer(c, RUNNER, "runner", 1, 1.2F, 0.4F));
        e.registerEntityRenderer(ModEntities.SPITTER.get(),
                c -> new DeadRenderer(c, SPITTER, "spitter", 2, 1.2F, 0.5F));
        e.registerEntityRenderer(ModEntities.BLOATER.get(),
                c -> new DeadRenderer(c, BLOATER, "bloater", 3, 0.9F, 0.9F));
        e.registerEntityRenderer(ModEntities.CRAWLER.get(),
                c -> new DeadRenderer(c, CRAWLER, "crawler", 4, 0.0F, 0.4F));
    }
}
