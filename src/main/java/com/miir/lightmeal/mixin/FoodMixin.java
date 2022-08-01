package com.miir.lightmeal.mixin;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class FoodMixin {
    @Inject(method = "isFood", at = @At("HEAD"), cancellable = true)
    private void mixin(CallbackInfoReturnable<Boolean> cir) {
        if (((Item)(Object) this) == Items.AMETHYST_SHARD){
            cir.setReturnValue(true);
        }

    }
    @Inject(method = "getFoodComponent", at = @At("HEAD"), cancellable = true)
    private void foodCompMixin(CallbackInfoReturnable<FoodComponent> cir) {
                if (((Item)(Object) this) == Items.AMETHYST_SHARD){
                    FoodComponent.Builder component = new FoodComponent.Builder();
                    cir.setReturnValue(component.hunger(4).snack().build());
                }

    }

}
