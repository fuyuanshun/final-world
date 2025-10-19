package com.fys.item.custom.demonfruit;

import com.fys.util.HealthUtil;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.function.Consumer;

/**
 * 太阳之恶魔果实
 *
 * @author fys
 * @date 2025/10/18
 * @description
 */
public class DemonFruitSun extends Item {

    public static final FoodComponent PERMANENT_FOOD_COMPONENT = new FoodComponent.Builder()
            .nutrition(1)
            .saturationModifier(0.8F)
            .alwaysEdible()
            .build();

    public DemonFruitSun(Settings settings) {
        super(settings.food(PERMANENT_FOOD_COMPONENT));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);
        if (user instanceof PlayerEntity player && !world.isClient()) {
            StatusEffectInstance statusEffectInstance = new StatusEffectInstance(
                    StatusEffects.NIGHT_VISION,
                    Integer.MAX_VALUE,
                    3,
                    true,
                    false,
                    false
            );
            HealthUtil.addMaxHealth(player, 2D, this.getTranslationKey());
            player.addStatusEffect(statusEffectInstance);
        }
        return itemStack;
    }

    @Deprecated
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        textConsumer.accept(Text.translatable("item.final-world.demon_fruit_sun_tooltip"));

    }
}
