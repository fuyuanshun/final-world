package com.fys.constants;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import java.util.Set;

/**
 * @author fys
 * @since  2025-10-17
 */
public class ModConstants {
    public static final String MOD_ID = "final-world";

    //Z轴坐标最小值
    public static final Integer MIN_LEVEL_NUM = -64;

    //探矿器可以扫描到的矿石
    public static final Set<Block> SCAN_SET = Sets.newHashSet(
            Blocks.DIAMOND_ORE,
            Blocks.DEEPSLATE_DIAMOND_ORE,
            Blocks.IRON_ORE,
            Blocks.DEEPSLATE_IRON_ORE,
            Blocks.COAL_ORE,
            Blocks.DEEPSLATE_COAL_ORE
    );

    //探矿器冷却时间 单位：Second
    public static final Integer PROSPECTOR_COOLDOWN_SECOND = 3;

    //探矿器耐久度
    public static final Integer PROSPECTOR_DAMAGE = 128;

    //盔甲基础耐久
    public static final int BASE_DURABILITY = 15;
}
