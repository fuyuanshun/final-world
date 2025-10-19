package com.fys.item;

import com.fys.constants.ModConstants;
import com.fys.item.custom.Prospector;
import com.fys.item.custom.demonfruit.DemonFruitMoon;
import com.fys.item.custom.demonfruit.DemonFruitSun;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

/**
 * @author fys
 * @since  2025-10-17
 * @description 模组物品注册类
 */
public class ModItems {

    public static final Item RAW_END_BLOCK = register("raw_end_block", Item::new, new Item.Settings());

    //恶魔果实
    public static final Item DEMON_FRUIT_SUN = register("demon_fruit_sun", DemonFruitSun::new, new Item.Settings().rarity(Rarity.RARE).maxCount(1));

    public static final Item DEMON_FRUIT_MOON = register("demon_fruit_moon", DemonFruitMoon::new, new Item.Settings().rarity(Rarity.RARE).maxCount(1));

    public static final Item PROSPECTOR = register("prospector", Prospector::new, new Item.Settings().maxCount(1).maxDamage(ModConstants.PROSPECTOR_DAMAGE));

    public static Item register(String key, Function<Item.Settings, Item> factory, Item.Settings settings) {
        return Items.register(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ModConstants.MOD_ID, key)), factory, settings);
    }

    /**
     * 入口类
     */
    public static void registerItems(){

    }
}
