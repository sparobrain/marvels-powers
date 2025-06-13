package net.shahar.marvels_powers;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.shahar.marvels_powers.item.ModItems;
import org.slf4j.Logger;

@Mod(MarvelsPowers.MOD_ID)
public class MarvelsPowers {
    public static final String MOD_ID = "marvels_powers";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MarvelsPowers() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus); // Register items

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::buildCreativeTab); // Register Creative Tab handler

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void buildCreativeTab(BuildCreativeModeTabContentsEvent event) {
        // Add items to creative tab here if needed
if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
    event.accept(ModItems.VIBRANIUM);
}

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Common setup for MarvelsPowers");
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Client setup for MarvelsPowers");
    }
}
