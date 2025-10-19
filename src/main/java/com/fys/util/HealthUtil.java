package com.fys.util;

import com.fys.constants.ModConstants;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

/**
 * @author fys
 * @date 2025/10/18
 * @description
 */
public class HealthUtil {

    // 给玩家添加生命值上限加成（参数为增加的生命值，如 2.0 = 1颗心）
    public static void addMaxHealth(PlayerEntity player, double amount, String name) {
        // 获取玩家的最大生命值属性实例
        EntityAttributeInstance healthAttribute = player.getAttributeInstance(EntityAttributes.MAX_HEALTH);
        if (healthAttribute == null) return;
        //每种恶魔果实只能加一滴血，重复吃了也不加
        Identifier identifier = Identifier.of(ModConstants.MOD_ID + ":" + name);
        healthAttribute.removeModifier(identifier);

        EntityAttributeModifier modifier = new EntityAttributeModifier(
                identifier,
                amount,
                EntityAttributeModifier.Operation.ADD_VALUE // 加法：基础值 + 加成值
        );
        healthAttribute.addPersistentModifier(modifier);
    }
}
