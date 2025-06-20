package net.shahar.marvels_powers.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.shahar.marvels_powers.MarvelsPowers;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MarvelsPowers.MOD_ID);

    public static final RegistryObject<Item> RAW_VIBRANIUM =
            ITEMS.register("raw_vibranium", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VIBRANIUM_ORE =
            ITEMS.register("vibranium_ore", () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
