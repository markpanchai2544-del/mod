package com.example.deadwalkers;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DeadWalkers.MODID);

    public static final RegistryObject<Item> WALKER_EGG = ITEMS.register("walker_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WALKER, 0x5F7650, 0x3B2A1A, new Item.Properties()));
    public static final RegistryObject<Item> RUNNER_EGG = ITEMS.register("runner_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.RUNNER, 0x827D64, 0x5A1E1E, new Item.Properties()));
    public static final RegistryObject<Item> SPITTER_EGG = ITEMS.register("spitter_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SPITTER, 0x5A8246, 0x96BE3C, new Item.Properties()));
    public static final RegistryObject<Item> BLOATER_EGG = ITEMS.register("bloater_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.BLOATER, 0x8C8264, 0x78A03C, new Item.Properties()));
    public static final RegistryObject<Item> CRAWLER_EGG = ITEMS.register("crawler_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CRAWLER, 0x50555F, 0xD2CDBE, new Item.Properties()));

    public static void addToCreativeTab(BuildCreativeModeTabContentsEvent e) {
        if (e.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            e.accept(WALKER_EGG);
            e.accept(RUNNER_EGG);
            e.accept(SPITTER_EGG);
            e.accept(BLOATER_EGG);
            e.accept(CRAWLER_EGG);
        }
    }
}
