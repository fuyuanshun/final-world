package com.fys.item.custom;

import com.fys.constants.ModConstants;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 探矿器，向某个方块下方探测，找到基岩结束
 * @author fys
 * @date 2025/10/18
 * @description
 */
public class Prospector extends Item {

    public Prospector(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        int y = blockPos.getY();
        if(player == null){
            return ActionResult.PASS;
        }
        if(world.isClient()){
            return ActionResult.PASS;
        }
        player.sendMessage(Text.of("开始探测:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))), false);

        for(int i = y-1; i >= ModConstants.MIN_LEVEL_NUM; i--){
            BlockState blockState = world.getBlockState(blockPos);
            Block block = blockState.getBlock();
            if(blockState.isOf(Blocks.BEDROCK)){
                break;
            }
            if(ModConstants.SCAN_SET.contains(block)){
//                player.sendMessage(Text.of("找到矿石：" + Text.translatable(block.getTranslationKey()).getString()), false);
                player.sendMessage(Text.of("找到矿石：" + new ItemStack(block).getName().getString()), false);
            }
            blockPos = blockPos.down();
        }
        player.sendMessage(Text.of("探测结束."), false);
        //减少耐久度
        context.getStack().damage(1, player);
        player.getItemCooldownManager().set(this.getDefaultStack(), 20 * ModConstants.PROSPECTOR_COOLDOWN_SECOND);
        return ActionResult.SUCCESS;
    }
}
