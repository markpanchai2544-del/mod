package com.example.deadwalkers;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DeadWalkers.MODID)
public class DeadWalkers {
    public static final String MODID = "deadwalkers";

    public DeadWalkers() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEntities.ENTITIES.register(bus);
        ModItems.ITEMS.register(bus);
        bus.addListener(ModEntities::registerAttributes);
        bus.addListener(ModEntities::registerSpawns);
        bus.addListener(ModItems::addToCreativeTab);
    }
}
