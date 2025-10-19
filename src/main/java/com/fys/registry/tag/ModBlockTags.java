package com.fys.registry.tag;

import com.fys.constants.ModConstants;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

/**
 * @author fys
 * @date 2025/10/19
 * @description
 */
public class ModBlockTags {
    public static final TagKey<Block> ORE_LIST = of("ore_list");


    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ModConstants.MOD_ID, id));
    }

    public static void register() {

    }
}
