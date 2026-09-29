package sh.fluorine.skeletorsmod;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.lwjgl.opengl.GL11;

@Mixin(targets = "net.minecraft.client.render.world.ChunkRenderer")
public class ChunkRendererMixin {
	@Shadow private int x;
	@Shadow private int y;
	@Shadow private int z;
    @Unique private double dOffsetX;
    @Unique private double dOffsetY;
    @Unique private double dOffsetZ;
    
    @Inject(method = "init(IIIDDD)V", at = @At("RETURN"))
	public void init(int x, int y, int z, double offsetX, double offsetY, double offsetZ, CallbackInfo ci) {
		this.dOffsetX = offsetX;
		this.dOffsetY = offsetY;
		this.dOffsetZ = offsetZ;
	}
    @Redirect(
        method = "render()V",
        at = @At(
            value = "INVOKE", 
            target = "Lorg/lwjgl/opengl/GL11;glTranslatef(FFF)V", 
            remap = false
        )
    )
    private void translate(float offsetX, float offsetY, float offsetZ) {
		GL11.glTranslated(this.x - this.dOffsetX, this.y - this.dOffsetY, this.z - this.dOffsetZ);
    }
}
