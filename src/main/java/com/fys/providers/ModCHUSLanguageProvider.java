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
public class ModCHUSLanguageProvider extends FabricLanguageProvider {


    public ModCHUSLanguageProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, "ch_us", registriesFuture);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("item.final-world.raw_end_block", "end powder");
        translationBuilder.add("block.final-world.end_block_ore", "end block ore");
        translationBuilder.add("block.final-world.end_block", "end block");

        translationBuilder.add("block.final-world.sun_block_ore", "sun block ore");
        translationBuilder.add("block.final-world.sun_block", "sun block");

        translationBuilder.add("item.final-world.demon_fruit_sun", "sun of demon fruit");
        translationBuilder.add("item.final-world.demon_fruit_sun_tooltip", "\u00A76Curse from the Ancient Demon-Sun Demon");
        translationBuilder.add("item.final-world.demon_fruit_moon", "moon of demon fruit");
        translationBuilder.add("item.final-world.demon_fruit_moon_tooltip", "\u00A76Curse from the Ancient Demon-Moon Demon");
//        translationBuilder.add("block.final-world.prismarine_amp_block", "prismarine amp block");
        //
        translationBuilder.add("item.final-world.prospector", "prospector");
        //物品栏
        translationBuilder.add("itemGroup.finalWorld", "Final World");
        translationBuilder.add("itemGroup.demonGroup", "Demon Fruit");
    }
}
