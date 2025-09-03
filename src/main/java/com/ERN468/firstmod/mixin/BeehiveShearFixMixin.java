package com.ERN468.firstmod.mixin;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BeehiveBlock.class)
public abstract class BeehiveShearFixMixin extends Block {

    protected BeehiveShearFixMixin(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Shadow public static void dropHoneycomb(World world, BlockPos pos) {
        dropStack(world, pos, new ItemStack(Items.HONEYCOMB, 3));
    }

    @Shadow abstract void angerNearbyBees(World world, BlockPos pos);

    @Shadow abstract boolean hasBees(World world, BlockPos pos);

    @Shadow abstract void takeHoney(World world, BlockState state, BlockPos pos, @Nullable PlayerEntity player, BeehiveBlockEntity.BeeState beeState);

    @Inject(method = "onUse", at = @At("HEAD"), cancellable = true)
    private void acceptAnyShears(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
        ActionResult result;
        ItemStack itemStack = player.getStackInHand(hand);
        int i = (Integer) state.get(BeehiveBlock.HONEY_LEVEL);
        boolean bl = false;
        if (i >= 5) {
            if (itemStack.getItem().isIn(FabricToolTags.SHEARS) && !(itemStack.getItem() == Items.SHEARS)) {
                world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_BEEHIVE_SHEAR, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                dropHoneycomb(world, pos);
                itemStack.damage(1, player, ((playerx) -> {
                    playerx.sendToolBreakStatus(hand);
                }));
                if (!CampfireBlock.isLitCampfireInRange(world, pos)) {
                    if (this.hasBees(world, pos)) {
                        this.angerNearbyBees(world, pos);
                    }

                    this.takeHoney(world, state, pos, player, BeehiveBlockEntity.BeeState.EMERGENCY);
                } else {
                    this.takeHoney(world, state, pos, null, null);
                }
                cir.setReturnValue(ActionResult.SUCCESS);
            }
        }
    }
}