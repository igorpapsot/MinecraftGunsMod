package com.igorpapsot.mcmod.client;

import com.igorpapsot.mcmod.McModMain;
import com.igorpapsot.mcmod.client.render.BulletRender;
import com.igorpapsot.mcmod.init.EntitiesInit;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = McModMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void doSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(EntitiesInit.Bullet.get(), BulletRender::new);
    }
}
