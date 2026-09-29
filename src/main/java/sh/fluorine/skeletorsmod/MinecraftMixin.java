package sh.fluorine.skeletorsmod;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(targets = "net.minecraft.client.Minecraft")
public class MinecraftMixin {

    @Overwrite
    private void renderProfilerChart(long tickTime) {
        if (0 == 0) {
            return;
        }
    }
}
