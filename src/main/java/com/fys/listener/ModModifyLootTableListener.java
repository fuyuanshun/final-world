package com.fys.listener;

import com.fys.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

/**
 * @author fys
 * @since 2025-10-20
 */
public class ModModifyLootTableListener {

    // 远古城市的战利品表ID
    public static final Identifier ANCIENT_CITY_LOOT_TABLE_ID = Identifier.of("minecraft", "structures/ancient_city/chest");

    public static void register(){
        LootTableEvents.MODIFY.register((table, tableBuilder, tableSource, lookup)->{
            if( ANCIENT_CITY_LOOT_TABLE_ID == table.getRegistry()){
                ItemEntry.Builder prospector = ItemEntry.builder(ModItems.PROSPECTOR)
                        .weight(10) // 设置权重，数值越大出现概率相对越高
                        .conditionally(RandomChanceLootCondition.builder(0.2f));

                // 创建一个新的战利品池
                LootPool.Builder newPool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1)) // 每次获取1个物品
                        .with(prospector);
                tableBuilder.pool(newPool);
            }
        });
    }
}
