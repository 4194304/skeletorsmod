package sh.fluorine.skeletorsmod;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.block.CactusBlock")
public class CactusBlockMixin {

    @Inject(
        method = "getRenderType()I", 
        at = @At("HEAD"), 
        cancellable = true,
        remap = false
    )
    private void overrideRenderType(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(0);
    }
}
