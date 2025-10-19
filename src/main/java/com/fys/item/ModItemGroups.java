package com.fys.item;

import com.fys.block.ModBlocks;
import com.fys.constants.ModConstants;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * 模组物品栏注册
 *
 * @author fys
 * @since  2025-10-17
 */
public class ModItemGroups {


    public static final ItemGroup FINAL_WORLD_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(ModConstants.MOD_ID, "final_world"),
            ItemGroup.create(null, -1)
                    .displayName(Text.translatable("itemGroup.finalWorld"))
                    .icon(() -> new ItemStack(ModBlocks.SUN_BLOCK))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_END_BLOCK);
                        //方块
                        entries.add(ModBlocks.END_BLOCK_ORE);
                        entries.add(ModBlocks.END_BLOCK);
                        //太阳矿
                        entries.add(ModBlocks.SUN_BLOCK_ORE);
                        entries.add(ModBlocks.SUN_BLOCK);
                        //
                        entries.add(ModItems.PROSPECTOR);
//                        entries.add(ModBlocks.PRISMARINE_AMP_BLOCK);

                    })
                    .build()
            );

    public static final ItemGroup DEMON_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(ModConstants.MOD_ID, "demon_group"),
            ItemGroup.create(null, -1)
                    .displayName(Text.translatable("itemGroup.demonGroup"))
                    .icon(() -> new ItemStack(ModItems.DEMON_FRUIT_SUN))
                    .entries((displayContext, entries) -> {
                        //恶魔果实
                        entries.add(ModItems.DEMON_FRUIT_SUN);
                        entries.add(ModItems.DEMON_FRUIT_MOON);
                    })
                    .build()
    );

    public static void registerItemGroups(){

    }
}
