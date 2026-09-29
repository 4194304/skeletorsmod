package sh.fluorine.skeletorsmod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GameGui;
import net.minecraft.client.render.TextRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.Shadow;
import java.text.DecimalFormat;

@Mixin(targets = "net.minecraft.client.gui.GameGui")
public class GameGuiMixin {

    @Shadow 
    private Minecraft minecraft;

    @Redirect (
            method = "render(FZII)V",
            at = {
                @At (value = "INVOKE", target = "Lnet/minecraft/client/gui/GameGui;drawString(Lnet/minecraft/client/render/TextRenderer;Ljava/lang/String;III)V", ordinal = 2),
                @At (value = "INVOKE", target = "Lnet/minecraft/client/gui/GameGui;drawString(Lnet/minecraft/client/render/TextRenderer;Ljava/lang/String;III)V", ordinal = 3),
                @At (value = "INVOKE", target = "Lnet/minecraft/client/gui/GameGui;drawString(Lnet/minecraft/client/render/TextRenderer;Ljava/lang/String;III)V", ordinal = 4)
            }
    )
    private void fixcoordinates(GameGui instance, TextRenderer textRenderer, String text, int x, int y, int color) {
        if (text.startsWith("x: ")) {
            instance.drawString(textRenderer, "x: " + new java.text.DecimalFormat("#.################").format(this.minecraft.player.x), x, y, color);
        } else if (text.startsWith("y: ")) {
            instance.drawString(textRenderer, "y: " + new java.text.DecimalFormat("#.################").format(this.minecraft.player.y), x, y, color);
        } else if (text.startsWith("z: ")) {
            instance.drawString(textRenderer, "z: " + new java.text.DecimalFormat("#.################").format(this.minecraft.player.z), x, y, color);
        } else {
            instance.drawString(textRenderer, text, x,  y, color);
        }
    }   
}
