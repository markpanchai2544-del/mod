package com.example.deadwalkers;

import com.example.deadwalkers.entity.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DeadWalkers.MODID);

    public static final RegistryObject<EntityType<WalkerEntity>> WALKER = ENTITIES.register("walker",
            () -> EntityType.Builder.of(WalkerEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f).clientTrackingRange(8).build("walker"));
    public static final RegistryObject<EntityType<RunnerEntity>> RUNNER = ENTITIES.register("runner",
            () -> EntityType.Builder.of(RunnerEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f).clientTrackingRange(8).build("runner"));
    public static final RegistryObject<EntityType<SpitterEntity>> SPITTER = ENTITIES.register("spitter",
            () -> EntityType.Builder.of(SpitterEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f).clientTrackingRange(8).build("spitter"));
    public static final RegistryObject<EntityType<BloaterEntity>> BLOATER = ENTITIES.register("bloater",
            () -> EntityType.Builder.of(BloaterEntity::new, MobCategory.MONSTER)
                    .sized(1.2f, 2.1f).clientTrackingRange(8).build("bloater"));
    public static final RegistryObject<EntityType<CrawlerEntity>> CRAWLER = ENTITIES.register("crawler",
            () -> EntityType.Builder.of(CrawlerEntity::new, MobCategory.MONSTER)
                    .sized(0.9f, 0.7f).clientTrackingRange(8).build("crawler"));

    public static void registerAttributes(EntityAttributeCreationEvent e) {
        e.put(WALKER.get(), WalkerEntity.createAttributes().build());
        e.put(RUNNER.get(), RunnerEntity.createAttributes().build());
        e.put(SPITTER.get(), SpitterEntity.createAttributes().build());
        e.put(BLOATER.get(), BloaterEntity.createAttributes().build());
        e.put(CRAWLER.get(), CrawlerEntity.createAttributes().build());
    }

    /** กติกาเกิด: ไม่สนระดับแสง => เกิดได้ทั้งกลางวันและกลางคืน */
    public static void registerSpawns(SpawnPlacementRegisterEvent e) {
        var op = SpawnPlacementRegisterEvent.Operation.REPLACE;
        var type = SpawnPlacements.Type.ON_GROUND;
        var hm = Heightmap.Types.MOTION_BLOCKING_NO_LEAVES;
        e.register(WALKER.get(), type, hm, DeadEntity::checkDeadSpawn, op);
        e.register(RUNNER.get(), type, hm, DeadEntity::checkDeadSpawn, op);
        e.register(SPITTER.get(), type, hm, DeadEntity::checkDeadSpawn, op);
        e.register(BLOATER.get(), type, hm, DeadEntity::checkDeadSpawn, op);
        e.register(CRAWLER.get(), type, hm, DeadEntity::checkDeadSpawn, op);
    }
}
