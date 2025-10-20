package com.fys;

import com.fys.block.ModBlocks;
import com.fys.constants.ModConstants;
import com.fys.item.ModItemGroups;
import com.fys.item.ModItems;
import com.fys.listener.ModModifyLootTableListener;
import com.fys.registry.tag.ModBlockTags;
import com.fys.registry.tag.ModItemTags;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FinalWorld implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger(ModConstants.MOD_ID);

	@Override
	public void onInitialize() {
		//注册物品
		ModItems.registerItems();
		//注册方块
		ModBlocks.registerBlocks();
		//注册物品栏
		ModItemGroups.registerItemGroups();
        //自定义tag
        ModItemTags.register();
        ModBlockTags.register();
		ModModifyLootTableListener.register();

        LOGGER.info("Final-World 加载成功");
	}
}