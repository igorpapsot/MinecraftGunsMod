package com.igorpapsot.mcmod.init;

import com.igorpapsot.mcmod.McModMain;
import com.igorpapsot.mcmod.entities.Bullet;
import com.igorpapsot.mcmod.items.Gun;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntitiesInit {

    public static final DeferredRegister<EntityType<?>> Entities = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, McModMain.MODID);

    public static final RegistryObject<EntityType<Bullet>> Bullet = Entities.register("bullet",
            () -> EntityType.Builder.of((EntityType.EntityFactory<Bullet>) Bullet::new, MobCategory.MISC).sized(0.5F, 0.5F).build("bullet"));


}
