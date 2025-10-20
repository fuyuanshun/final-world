package com.fys.item.custom;

import com.fys.constants.ModConstants;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.Input;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.Window;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.lwjgl.glfw.GLFW;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * 直接使用：
 *  模糊搜索，选定方块周围5*5范围向下探测，找到基岩结束
 *
 * shift：精确搜索
 *  向某个方块下方探测，找到基岩结束
 *
 * 右SHIFT+⬆️+⬇️+⬅️+➡️： 模糊搜索，并且将搜索到的除了矿之外，全部移除
 *
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
        //按下shift，精确搜索，只搜索点击的方块下面的所有方块
        Window window = MinecraftClient.getInstance().getWindow();
        if(InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_LEFT_SHIFT)){
            for(int i = y; i >= ModConstants.MIN_LEVEL_NUM; i--){
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
            //减少耐久度
            context.getStack().damage(1, player);
        //没有按shift，模糊搜索，点击方块为中心的周围的5*5方块下所有的方块
        } else {
            for(int i = 0; i <= y - ModConstants.MIN_LEVEL_NUM; i++){
                for(int j = 0; j < 5; j++){
                    for(int k = 0; k < 5; k++){
                        //西北
                        BlockPos fpos = blockPos.down(i).north(j).west(k);
                        Block block = world.getBlockState(fpos).getBlock();
                        if(ModConstants.SCAN_SET.contains(block)){
                            player.sendMessage(Text.of("找到矿石：" + new ItemStack(block).getName().getString()), false);
                        } else {
                            if(InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_UP) &&
                                    InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_DOWN) &&
                                    InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_LEFT) &&
                                    InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_RIGHT)&&
                                    InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_RIGHT_SHIFT)){
                                world.removeBlock(fpos, false);
                            }
                        }

                        //东南
                        BlockPos fpos2 = blockPos.down(i).east(j).south(k);
                        Block block2= world.getBlockState(fpos2).getBlock();

                        if(ModConstants.SCAN_SET.contains(block2)){
                            player.sendMessage(Text.of("(找到矿石：" + new ItemStack(block2).getName().getString()), false);
                        } else {
                            if(InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_UP) &&
                                    InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_DOWN) &&
                                    InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_LEFT) &&
                                    InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_RIGHT)&&
                                    InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_RIGHT_SHIFT)){
                                world.removeBlock(fpos2, false);
                            }
                        }

                        //东北
                        BlockPos fpos3 = blockPos.down(i).east(j).north(k);
                        Block block3= world.getBlockState(fpos3).getBlock();

                        if(ModConstants.SCAN_SET.contains(block3)){
                            player.sendMessage(Text.of("(找到矿石：" + new ItemStack(block3).getName().getString()), false);
                        } else {
                            if(InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_UP) &&
                                    InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_DOWN) &&
                                    InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_LEFT) &&
                                    InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_RIGHT)&&
                                    InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_RIGHT_SHIFT)){
                                world.removeBlock(fpos3, false);
                            }
                        }

                        //西南
                        BlockPos fpos4 = blockPos.down(i).west(j).south(k);
                        Block block4= world.getBlockState(fpos4).getBlock();

                        if(ModConstants.SCAN_SET.contains(block4)){
                            player.sendMessage(Text.of("(找到矿石：" + new ItemStack(block4).getName().getString()), false);
                        } else {
                            if(InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_UP) &&
                                    InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_DOWN) &&
                                    InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_LEFT) &&
                                    InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_RIGHT) &&
                                            InputUtil.isKeyPressed(window, GLFW.GLFW_KEY_RIGHT_SHIFT)){
                                world.removeBlock(fpos4, false);
                            }
                        }
                    }
                }
            }
            context.getStack().damage(25, player);
        }
        player.sendMessage(Text.of("探测结束."), false);

        player.getItemCooldownManager().set(this.getDefaultStack(), 20 * ModConstants.PROSPECTOR_COOLDOWN_SECOND);
        return ActionResult.SUCCESS;
    }
}
