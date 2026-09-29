package sh.fluorine.skeletorsmod;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(targets = "net.minecraft.world.World")
public class WorldMixin {

    @ModifyConstant(
        method = {
            "getBlock(III)I", 
            "setBlockWithMetadataQuietly(IIIII)Z",
            "setBlockQuietly(IIII)Z",
            "getBlockMetadata(III)I", 
            "setBlockMetadataQuietly(IIII)Z",
            "getRawBrightness(IIIZ)I", 
            "hasSkyLight(III)Z", 
            "getHeight(II)I", 
            "getLight(Lnet/minecraft/world/LightType;III)I", 
            "setLight(Lnet/minecraft/world/LightType;IIII)V"
        },
        constant = @Constant(intValue = 32000000),
        remap = false
    )
    private int modPosInt(int original) {
        return Integer.MAX_VALUE;
    }
    
    @ModifyConstant(
        method = {
            "getBlock(III)I", 
            "setBlockWithMetadataQuietly(IIIII)Z",
            "setBlockQuietly(IIII)Z",
            "getBlockMetadata(III)I", 
            "setBlockMetadataQuietly(IIII)Z",
            "getRawBrightness(IIIZ)I", 
            "hasSkyLight(III)Z", 
            "getHeight(II)I", 
            "getLight(Lnet/minecraft/world/LightType;III)I", 
            "setLight(Lnet/minecraft/world/LightType;IIII)V"
        },
        constant = @Constant(intValue = -32000000),
        remap = false
    )
    private int modNegInt(int original) {
        return Integer.MIN_VALUE;
    }
}
