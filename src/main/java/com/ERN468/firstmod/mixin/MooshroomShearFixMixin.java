package com.ERN468.firstmod.mixin;

import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.MooshroomEntity;
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

@Mixin(MooshroomEntity.class)
public abstract class MooshroomShearFixMixin extends AnimalEntity {

    protected MooshroomShearFixMixin (EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow abstract public boolean isShearable();
    @Shadow abstract public void sheared(SoundCategory players);

    @Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
    private void acceptAnyShears(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir)
    {
        ActionResult result;
        ItemStack itemStack = player.getStackInHand(hand);

        if (itemStack.getItem().isIn(FabricToolTags.SHEARS) && !(itemStack.getItem() == Items.SHEARS))
        {
            if (this.isShearable() && !this.world.isClient)
            {
                this.sheared(SoundCategory.PLAYERS);
                itemStack.damage(1, player, ((playerEntity) -> {
                    playerEntity.sendToolBreakStatus(hand);
                }));

                result = ActionResult.SUCCESS;
            }
            else
            {
                result = ActionResult.PASS;
            }

            cir.setReturnValue(result);
        }
    }
}
