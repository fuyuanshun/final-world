package com.fys.entity;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

/**
 * TODO 自定义增益状态
 * @author fys
 * @since 2025-10-21
 */
public class ModStatusEffects {

    public static final RegistryEntry<StatusEffect> LIGHTNING = register(
            "lightning",
            new StatusEffect(StatusEffectCategory.BENEFICIAL, 5882118){
            }
            .addAttributeModifier(EntityAttributes.MOVEMENT_SPEED, Identifier.ofVanilla("effect.speed"), 0.2, EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    private static RegistryEntry<StatusEffect> register(String id, StatusEffect statusEffect) {
//        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(ModConstants.MOD_ID, id), statusEffect);
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.ofVanilla(id), statusEffect);
    }

    public static void registerStatusEffects(){

    }
}
