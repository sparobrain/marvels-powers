package net.shahar.marvels_powers.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.shahar.marvels_powers.MarvelsPowers;
import net.shahar.marvels_powers.item.ModItems;

import javax.swing.text.html.BlockView;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MarvelsPowers.MOD_ID);

    public static final RegistryObject<Block> VIBRANIUM_BLOCK = registerBlock("vibranium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.NETHERITE_BLOCK))) ;

    public static final RegistryObject<Block> RAW_VIBRANIUM_BLOCK = registerBlock("raw_vibranium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.BASALT)));

    public static final RegistryObject<Block> STONE_VIBRANIUM_ORE = registerBlock("stone_vibranium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f) .requiresCorrectToolForDrops(), UniformInt.of(3, 10)));

    public static final RegistryObject<Block> DEEPSLATE_VIBRANIUM_ORE = registerBlock("deepslate_vibranium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(7f) .requiresCorrectToolForDrops(), UniformInt.of(3, 12)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;

    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }







    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
