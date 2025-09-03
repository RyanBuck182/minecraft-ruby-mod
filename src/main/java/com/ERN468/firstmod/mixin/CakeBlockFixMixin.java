package com.ERN468.firstmod.mixin;

import com.ERN468.firstmod.main.FirstModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CakeBlock.class)
public class CakeBlockFixMixin extends Block {

    protected CakeBlockFixMixin(Settings settings) {
        super(settings);
    }

    @Shadow @Final public static IntProperty BITES;

    @Inject(method = "tryEat", at = @At("HEAD"), cancellable = true)
    private void tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player, CallbackInfoReturnable<ActionResult> cir) {
        if (this == FirstModBlocks.CHEESECAKE) {
            ActionResult result;

            if (!player.canConsume(false)) {
                result = ActionResult.PASS;
            } else {
                player.incrementStat(Stats.EAT_CAKE_SLICE);
                player.getHungerManager().add(20, 0.5f); //defaults are 2 and 0.1f
                int i = (Integer) state.get(BITES);
                if (i < 6) {
                    world.setBlockState(pos, (BlockState) state.with(BITES, i + 1), 3);
                } else {
                    world.removeBlock(pos, false);
                }

                result = ActionResult.SUCCESS;
            }
            cir.setReturnValue(result);
        }
    }
}
