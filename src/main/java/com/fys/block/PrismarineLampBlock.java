package com.fys.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * 海晶灯
 * @author fys
 * @since 2025-10-17
 */
public class PrismarineLampBlock extends Block {

    public PrismarineLampBlock(Settings settings) {
        super(settings);

        setDefaultState(getDefaultState().with(ACTIVATED, false));
    }

    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");

    /**
     * 将属性添加到方块中
     * @param builder
     */
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVATED);
    }

    /**
     * 右键使用逻辑
     * @param state
     * @param world
     * @param pos
     * @param player
     * @param hit
     * @return
     */
    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.getAbilities().allowModifyWorld) {
            return ActionResult.PASS;
        } else {
            boolean activated = state.get(ACTIVATED);

            world.setBlockState(pos, state.with(ACTIVATED, !activated));

            world.playSound(player, pos, SoundEvents.BLOCK_COMPARATOR_CLICK, SoundCategory.BLOCKS, 1.0F, 1.0F);

            return ActionResult.SUCCESS;
        }
    }

    /**
     * 激活时亮度为15，未激活为0
     * @param currentBlockState
     * @return
     */
    public static int getLuminance(BlockState currentBlockState) {
        boolean activated = currentBlockState.get(PrismarineLampBlock.ACTIVATED);

        return activated ? 15 : 0;
    }
}
