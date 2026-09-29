package sh.fluorine.skeletorsmod;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(targets = "net.minecraft.world.WorldRegion")
public class WorldRegionMixin {

    @ModifyConstant(
        method = "getRawBrightness(IIIZ)I", 
        constant = @Constant(intValue = 32000000),
        remap = false
    )
    private int modPosInt(int original) {
        return Integer.MAX_VALUE;
    }
    
    @ModifyConstant(
        method = "getRawBrightness(IIIZ)I", 
        constant = @Constant(intValue = -32000000),
        remap = false
    )
    private int modNegInt(int original) {
        return Integer.MIN_VALUE;
    }
}
