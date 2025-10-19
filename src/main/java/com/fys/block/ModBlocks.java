package com.fys.block;

import com.fys.constants.ModConstants;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

/**
 * 注册方块
 * @author fys
 * @since 2025-10-17
 */
public class ModBlocks {


    //末影矿
    public static final Block END_BLOCK_ORE = register("end_block_ore", Block::new,
            AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(1.5F, 6.0F));

    //末影石
    public static final Block END_BLOCK = register("end_block", Block::new,
            AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(1.5F, 6.0F));

    //太阳矿
    public static final Block SUN_BLOCK_ORE = register("sun_block_ore", Block::new,
            AbstractBlock.Settings.create()
//                    .requiresTool()
                    .strength(1.5F, 6.0F));

    //太阳石
    public static final Block SUN_BLOCK = register("sun_block", Block::new,
            AbstractBlock.Settings.create()
//                    .requiresTool()
                    .strength(1.5F, 6.0F));



    //海晶灯
    public static final Block PRISMARINE_AMP_BLOCK = register("prismarine_amp_block", PrismarineLampBlock::new,
            AbstractBlock.Settings.create()
                    .luminance(PrismarineLampBlock::getLuminance)
                    .strength(1.5F, 6.0F));

    /**
     * 注册物品
     * @param key
     * @param block
     * @return
     */
    public static Item registerBlockItem(String key, Block block){
        return Items.register(block, BlockItem::new);
    }

    /**
     * 注册方块
     * @param key
     * @param factory
     * @param settings
     * @return
     */
    public static Block register(String key, Function<AbstractBlock.Settings, Block> factory,  AbstractBlock.Settings settings) {
        Block item = Blocks.register(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ModConstants.MOD_ID, key)), factory, settings);
        //
        registerBlockItem(key, item);
        return item;
    }



    /**
     * 注册方块入口类
     */
    public static void registerBlocks(){

    }
}
