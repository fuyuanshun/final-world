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
    //修复末影工具的物品标签
    public static final TagKey<Item> ENDER_TOOL_MATERIALS = of("ender_tool_materials");
    //修复末影盔甲的物品标签
    public static final TagKey<Item> REPAIRS_ENDER_ARMOR = of("repairs_ender_armor");

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(ModConstants.MOD_ID, id));
    }

    public static void register() {

    }
}
