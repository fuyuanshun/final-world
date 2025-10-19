package com.fys.item.armor;

import com.fys.constants.ModConstants;
import com.fys.registry.tag.ModItemTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

/**
 * @author fys
 * @date 2025/10/19
 * @description
 */
public class ModArmorMaterial {

    //EquipmentAssetKeys.REGISTRY_KEY这个要使用minecraft的
    public static final RegistryKey<EquipmentAsset> ENDER_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(ModConstants.MOD_ID, "ender"));

    public static final ArmorMaterial ENDER = new ArmorMaterial(
            ModConstants.BASE_DURABILITY,
            Map.of(
                    //防御值
                    EquipmentType.BOOTS, 5,
                    EquipmentType.LEGGINGS, 9,
                    EquipmentType.CHESTPLATE, 11,
                    EquipmentType.HELMET, 5,
                    EquipmentType.BODY, 15
            ),
            //可附魔性
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            //韧性
            4.0F,
            //击退抗性
            0.15F,
            ModItemTags.REPAIRS_ENDER_ARMOR,
            ENDER_ARMOR_MATERIAL_KEY
    );
}
