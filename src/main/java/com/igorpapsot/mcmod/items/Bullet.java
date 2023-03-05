package com.igorpapsot.mcmod.items;

import com.igorpapsot.mcmod.init.EntitiesInit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Bullet extends ArrowItem {
    public Bullet(Properties props) {
        super(props);
    }

    @Override
    public AbstractArrow createArrow(Level world, ItemStack ammoStack, LivingEntity shooter) {
        return new com.igorpapsot.mcmod.entities.Bullet(EntitiesInit.Bullet.get(), shooter, world);
    }
}
