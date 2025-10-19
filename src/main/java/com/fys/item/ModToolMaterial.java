package com.fys.item;

import com.fys.registry.tag.ModBlockTags;
import com.fys.registry.tag.ModItemTags;
import net.minecraft.item.ToolMaterial;

/**
 * @author fys
 * @date 2025/10/19
 * @description
 */
public class ModToolMaterial {
    public static final ToolMaterial ENDER_MATERIAL = new ToolMaterial(
            //使用该工具采集INCORRECT_FOR_ENDER_TOOL标签中的方块时，不会有掉落物
            ModBlockTags.INCORRECT_FOR_ENDER_TOOL,
            3033,
            15.0F,
            5.0F,
            18,
            ModItemTags.ENDER_TOOL_MATERIALS
    );
}
