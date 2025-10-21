package com.fys.item;

import com.fys.constants.ModConstants;
import com.fys.item.armor.ModArmorMaterial;
import com.fys.item.custom.Prospector;
import com.fys.item.custom.demonfruit.DemonFruitMoon;
import com.fys.item.custom.demonfruit.DemonFruitSun;
import com.fys.item.weapon.LightningWeapon;
import com.fys.registry.tag.ModBlockTags;
import com.fys.registry.tag.ModItemTags;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.function.Function;

/**
 * @author fys
 * @since  2025-10-17
 * @description 模组物品注册类
 */
public class ModItems {

    public static final Item RAW_END_BLOCK = register("raw_end_block",
            Item::new, new Item.Settings());

    public static final Item MAGIC_WAND = register("magic_wand",
            Item::new, new Item.Settings());


    //恶魔果实
    public static final Item DEMON_FRUIT_SUN = register("demon_fruit_sun",
            DemonFruitSun::new, new Item.Settings().rarity(Rarity.RARE).maxCount(1));

    public static final Item DEMON_FRUIT_MOON = register("demon_fruit_moon",
            DemonFruitMoon::new, new Item.Settings().rarity(Rarity.RARE).maxCount(1));

    //------------自定义工具 start
    public static final Item PROSPECTOR = register("prospector",
            Prospector::new,
            new Item.Settings().maxCount(1).maxDamage(ModConstants.PROSPECTOR_DAMAGE));

    public static final Item ENDER_SWORD = register(
            "ender_sword",
            Item::new,
            new Item.Settings().sword(ModToolMaterial.ENDER_MATERIAL, 15f, 1f)
    );

    public static final Item ENDER_AXE = register(
            "ender_axe",
            Item::new,
            new Item.Settings().axe(ModToolMaterial.ENDER_MATERIAL, 18f, .8f)
    );

    public static final Item ENDER_PICKAXE = register(
            "ender_pickaxe",
            Item::new,
            new Item.Settings().pickaxe(ModToolMaterial.ENDER_MATERIAL, 12f, .8f)
    );

    public static final Item ENDER_HOE = register(
            "ender_hoe",
            Item::new,
            new Item.Settings().hoe(ModToolMaterial.ENDER_MATERIAL, 8f, .8f)
    );

    public static final Item ENDER_SHOVEL = register(
            "ender_shovel",
            Item::new,
            new Item.Settings().shovel(ModToolMaterial.ENDER_MATERIAL, 6f, .8f)
    );
    //----------------------自定义工具 end

    //----------------------自定义盔甲 start
    //头盔
    public static final Item ENDER_HELMET = register("ender_helmet", Item::new, new Item.Settings()
            .armor(ModArmorMaterial.ENDER, EquipmentType.HELMET));
//            .maxDamage(EquipmentType.HELMET.getMaxDamage(ModConstants.BASE_DURABILITY)));
    //胸甲
    public static final Item ENDER_CHESTPLATE = register("ender_chestplate", Item::new, new Item.Settings()
            .armor(ModArmorMaterial.ENDER, EquipmentType.CHESTPLATE));
//            .maxDamage(EquipmentType.HELMET.getMaxDamage(ModConstants.BASE_DURABILITY)));
    //绑腿
    public static final Item ENDER_LEGGINGS = register("ender_leggings", Item::new, new Item.Settings()
            .armor(ModArmorMaterial.ENDER, EquipmentType.LEGGINGS));
//            .maxDamage(EquipmentType.HELMET.getMaxDamage(ModConstants.BASE_DURABILITY)));
    //靴子
    public static final Item ENDER_BOOTS = register("ender_boots", Item::new, new Item.Settings()
            .armor(ModArmorMaterial.ENDER, EquipmentType.BOOTS));
//            .maxDamage(EquipmentType.HELMET.getMaxDamage(ModConstants.BASE_DURABILITY)));
    //----------------------自定义盔甲 end

    public static Item register(String key, Function<Item.Settings, Item> factory, Item.Settings settings) {
        return Items.register(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ModConstants.MOD_ID, key)), factory, settings);
    }

    /**
     * 入口类
     */
    public static void registerItems(){

    }
}
