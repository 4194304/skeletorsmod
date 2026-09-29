package sh.fluorine.skeletorsmod;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(targets = "net.minecraft.world.dimension.Dimension")
public class DimensionMixin {

    @ModifyConstant(
        method = "initBrightnessTable()V", 
        constant = @Constant(floatValue = 0.05F),
        remap = false
    )
    private float modifyDarknessConstant(float original) {
        return 0.2F;
    }
}
