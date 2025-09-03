package com.ERN468.firstmod.mixin;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SnowGolemEntity.class)
public abstract class SnowGolemShearFixMixin extends GolemEntity { //animation for shearing doesn't play

    protected SnowGolemShearFixMixin(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow abstract public boolean isShearable();
    @Shadow abstract public void sheared(SoundCategory players);

    @Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
    private void acceptAnyShears(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        ActionResult result;
        ItemStack itemStack = player.getStackInHand(hand);

        if (itemStack.getItem().isIn(FabricToolTags.SHEARS) && !(itemStack.getItem() == Items.SHEARS) && this.isShearable()) {
            if (!this.world.isClient && this.isShearable()) {
                this.sheared(SoundCategory.PLAYERS);
                itemStack.damage(1, player, ((playerEntity) -> {
                    playerEntity.sendToolBreakStatus(hand);
                }));

                result = ActionResult.success(this.world.isClient);
            }
            else {
                result = ActionResult.PASS;
            }

            cir.setReturnValue(result);
        }
    }
}
