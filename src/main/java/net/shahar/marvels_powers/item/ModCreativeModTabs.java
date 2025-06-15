package net.shahar.marvels_powers.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.shahar.marvels_powers.MarvelsPowers;
import net.shahar.marvels_powers.block.ModBlocks;

import java.awt.*;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MarvelsPowers.MOD_ID);

public static final RegistryObject<CreativeModeTab> marvels_tab = CREATIVE_MODE_TABS.register("marvels_tab",
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.VIBRANIUM_ORE.get()))
                .title(Component.translatable("creative.marvels_tab"))
                .displayItems((itemDisplayParameters, output) -> {
                    output.accept(ModItems.VIBRANIUM_ORE.get());
                    output.accept(ModItems.RAW_VIBRANIUM.get());

                    output.accept(ModBlocks.VIBRANIUM_BLOCK.get());
                    output.accept(ModBlocks.RAW_VIBRANIUM_BLOCK.get());




                })
        .build());




    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
