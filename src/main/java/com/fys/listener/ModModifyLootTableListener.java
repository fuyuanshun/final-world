package com.fys.listener;

import com.fys.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

/**
 * @author fys
 * @since 2025-10-20
 */
public class ModModifyLootTableListener {

    // 远古城市的战利品表ID
    // 路径参考原版data/minecraft/loot_table下的目录
    public static final Identifier ANCIENT_CITY_LOOT_TABLE_ID = Identifier.ofVanilla("chests/ancient_city");

    public static void register(){
        LootTableEvents.MODIFY.register((key, tableBuilder, tableSource, lookup)->{
            if( ANCIENT_CITY_LOOT_TABLE_ID.equals(key.getValue())){
                // 创建一个新的战利品池
                LootPool.Builder newPool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) // 每次获取1个物品
                        //生成的物品
                        .with(ItemEntry.builder(ModItems.PROSPECTOR)
                                //概率
                                .conditionally(RandomChanceLootCondition.builder(0.2f)))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)));
                tableBuilder.pool(newPool);
            }
        });
    }
}
