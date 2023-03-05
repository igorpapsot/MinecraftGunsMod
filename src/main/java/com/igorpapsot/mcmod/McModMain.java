package com.igorpapsot.mcmod;

import com.igorpapsot.mcmod.init.EntitiesInit;
import com.igorpapsot.mcmod.init.ItemInit;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(McModMain.MODID)
public class McModMain
{
    public static final String MODID = "mcmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public McModMain()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        ItemInit.Items.register((modEventBus));
        EntitiesInit.Entities.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }
}
