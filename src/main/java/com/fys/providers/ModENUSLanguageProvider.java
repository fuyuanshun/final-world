package com.fys.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

/**
 * @author fys
 * @date 2025/10/18
 * @description
 */
public class ModENUSLanguageProvider extends FabricLanguageProvider {


    public ModENUSLanguageProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, "en_us", registriesFuture);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("item.final-world.raw_end_block", "末影粉末");
        translationBuilder.add("item.final-world.magic_wand", "魔杖");
        translationBuilder.add("block.final-world.end_ore", "末影原矿");
        translationBuilder.add("block.final-world.end_block", "末影石");

        translationBuilder.add("block.final-world.sun_ore", "太阳原矿");
        translationBuilder.add("block.final-world.sun_block", "太阳石");

        translationBuilder.add("item.final-world.demon_fruit_sun", "太阳之恶魔果实");
        translationBuilder.add("item.final-world.demon_fruit_sun_tooltip", "\u00A76来自远古恶魔的诅咒-太阳恶魔");
        translationBuilder.add("item.final-world.demon_fruit_moon", "月亮之恶魔果实");
        translationBuilder.add("item.final-world.demon_fruit_moon_tooltip", "\u00A76来自远古恶魔的诅咒-月亮恶魔");
        translationBuilder.add("block.final-world.prismarine_amp_block", "海晶灯");

        translationBuilder.add("item.final-world.prospector", "探矿器");

        translationBuilder.add("item.final-world.ender_sword", "末影之剑");
        translationBuilder.add("item.final-world.ender_axe", "末影之斧");
        translationBuilder.add("item.final-world.ender_pickaxe", "末影稿");
        translationBuilder.add("item.final-world.ender_hoe", "末影锄");
        translationBuilder.add("item.final-world.ender_shovel", "末影铲");
        //盔甲
        translationBuilder.add("item.final-world.ender_helmet", "末影头盔");
        translationBuilder.add("item.final-world.ender_chestplate", "末影胸甲");
        translationBuilder.add("item.final-world.ender_leggings", "末影护腿");
        translationBuilder.add("item.final-world.ender_boots", "末影靴");
        //物品栏
        translationBuilder.add("itemGroup.finalWorld", "终末地");
        translationBuilder.add("itemGroup.demonGroup", "恶魔果实");
    }
}
