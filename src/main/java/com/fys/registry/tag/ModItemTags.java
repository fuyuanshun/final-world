package com.fys.registry.tag;

import com.fys.constants.ModConstants;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

/**
 * @author fys
 * @date 2025/10/19
 * @description
 */
public class ModItemTags {
    public static final TagKey<Item> RAW_LIST = of("raw_list");

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(ModConstants.MOD_ID, id));
    }

    public static void register() {

    }
}
