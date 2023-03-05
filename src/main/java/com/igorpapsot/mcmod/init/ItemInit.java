package com.igorpapsot.mcmod.init;

import com.igorpapsot.mcmod.McModMain;
import com.igorpapsot.mcmod.items.Bullet;
import com.igorpapsot.mcmod.items.BulletCasing;
import com.igorpapsot.mcmod.items.Gun;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, McModMain.MODID);

    public static final RegistryObject<Item> GUN = Items.register("gun", () -> new Gun(new Item.Properties().stacksTo(1).tab(ModCreativeTab.instance)));
    public static final RegistryObject<Item> Bullet = Items.register("bullet",
            () -> new Bullet(new Item.Properties().tab(ModCreativeTab.instance)));

    public static final RegistryObject<Item> BulletCasing = Items.register("bulletcasing", () -> new BulletCasing(new Item.Properties().tab(ModCreativeTab.instance)));

    public static class ModCreativeTab extends CreativeModeTab {

        public ModCreativeTab(int index, String label) {
            super(index, label);

        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(GUN.get());
        }

        public static final ModCreativeTab instance = new ModCreativeTab(CreativeModeTab.TABS.length, "mcmod");

    }




}
