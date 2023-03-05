package com.igorpapsot.mcmod.items;

import com.igorpapsot.mcmod.entities.Bullet;
import com.igorpapsot.mcmod.init.EntitiesInit;
import com.igorpapsot.mcmod.init.ItemInit;
import com.mojang.logging.LogUtils;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import static net.minecraft.world.item.BowItem.getPowerForTime;

public class Gun extends Item {

    private static final Logger LOGGER = LogUtils.getLogger();

    public Gun(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack bullets = getBullets(player);

        if(bullets != null) {
            player.getCooldowns().addCooldown(this, 10);
            float f = getPowerForTime(100);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.DRAGON_FIREBALL_EXPLODE, SoundSource.PLAYERS, 1.0F, 1.0F);

            if (!player.level.isClientSide()){
                if(!player.getAbilities().instabuild) {
                    bullets.shrink(1);
                }
                player.getInventory().setChanged();
                Bullet arrow = new Bullet(EntitiesInit.Bullet.get(), player, player.level);
                arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F, 1.0F);
                player.level.addFreshEntity(arrow);

                player.drop(new ItemStack(ItemInit.BulletCasing.get()), true, false);
            }

        }
        else {
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.GHAST_WARN, SoundSource.PLAYERS, 1.0F, 1.0F);
        }
        return super.use(world, player, hand);

    }

    @Nullable
    private static ItemStack getBullets(Player player) {
        NonNullList<ItemStack> inventory = player.getInventory().items;
        ItemStack bullets = null;
        if (inventory.size() != 0)
            for (ItemStack stack : inventory) {
                if (!stack.isEmpty() && stack.getItem() instanceof com.igorpapsot.mcmod.items.Bullet){
                    bullets = stack;
                    break;
                }
            }
        return bullets;
    }
}
