package optifine;

import java.awt.image.*;
import java.awt.*;
import net.minecraft.util.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.model.*;

public class PlayerItemModel
{
    private /* synthetic */ DynamicTexture texture;
    private /* synthetic */ BufferedImage textureImage;
    private /* synthetic */ PlayerItemRenderer[] modelRenderers;
    private /* synthetic */ boolean usePlayerTexture;
    private /* synthetic */ Dimension textureSize;
    private /* synthetic */ ResourceLocation textureLocation;
    private /* synthetic */ ResourceLocation locationMissing;
    
    public ResourceLocation getTextureLocation() {
        return this.textureLocation;
    }
    
    static {
        ATTACH_CAPE = 6;
        ATTACH_RIGHT_LEG = 5;
        ATTACH_RIGHT_ARM = 3;
        ATTACH_LEFT_LEG = 4;
        ATTACH_HEAD = 1;
        ATTACH_LEFT_ARM = 2;
        ATTACH_BODY = 0;
    }
    
    public void setTextureImage(final BufferedImage lllllllllllllIlIIlIlllIlllIlIIlI) {
        this.textureImage = lllllllllllllIlIIlIlllIlllIlIIlI;
    }
    
    public boolean isUsePlayerTexture() {
        return this.usePlayerTexture;
    }
    
    public void setTextureLocation(final ResourceLocation lllllllllllllIlIIlIlllIlllIIIllI) {
        this.textureLocation = lllllllllllllIlIIlIlllIlllIIIllI;
    }
    
    public void render(final ModelBiped lllllllllllllIlIIlIlllIllllIlllI, final AbstractClientPlayer lllllllllllllIlIIlIlllIllllIIlIl, final float lllllllllllllIlIIlIlllIllllIIlII, final float lllllllllllllIlIIlIlllIllllIlIll) {
        final TextureManager lllllllllllllIlIIlIlllIllllIlIlI = Config.getTextureManager();
        if (this.usePlayerTexture) {
            lllllllllllllIlIIlIlllIllllIlIlI.bindTexture(lllllllllllllIlIIlIlllIllllIIlIl.getLocationSkin());
        }
        else if (this.textureLocation != null) {
            if (this.texture == null && this.textureImage != null) {
                this.texture = new DynamicTexture(this.textureImage);
                Minecraft.getMinecraft().getTextureManager().loadTexture(this.textureLocation, this.texture);
            }
            lllllllllllllIlIIlIlllIllllIlIlI.bindTexture(this.textureLocation);
        }
        else {
            lllllllllllllIlIIlIlllIllllIlIlI.bindTexture(this.locationMissing);
        }
        for (int lllllllllllllIlIIlIlllIllllIlIIl = 0; lllllllllllllIlIIlIlllIllllIlIIl < this.modelRenderers.length; ++lllllllllllllIlIIlIlllIllllIlIIl) {
            final PlayerItemRenderer lllllllllllllIlIIlIlllIllllIlIII = this.modelRenderers[lllllllllllllIlIIlIlllIllllIlIIl];
            GlStateManager.pushMatrix();
            if (lllllllllllllIlIIlIlllIllllIIlIl.isSneaking()) {
                GlStateManager.translate(0.0f, 0.2f, 0.0f);
            }
            lllllllllllllIlIIlIlllIllllIlIII.render(lllllllllllllIlIIlIlllIllllIlllI, lllllllllllllIlIIlIlllIllllIIlII);
            GlStateManager.popMatrix();
        }
    }
    
    public static ModelRenderer getAttachModel(final ModelBiped lllllllllllllIlIIlIlllIlllIlllII, final int lllllllllllllIlIIlIlllIlllIllIll) {
        switch (lllllllllllllIlIIlIlllIlllIllIll) {
            case 0: {
                return lllllllllllllIlIIlIlllIlllIlllII.bipedBody;
            }
            case 1: {
                return lllllllllllllIlIIlIlllIlllIlllII.bipedHead;
            }
            case 2: {
                return lllllllllllllIlIIlIlllIlllIlllII.bipedLeftArm;
            }
            case 3: {
                return lllllllllllllIlIIlIlllIlllIlllII.bipedRightArm;
            }
            case 4: {
                return lllllllllllllIlIIlIlllIlllIlllII.bipedLeftLeg;
            }
            case 5: {
                return lllllllllllllIlIIlIlllIlllIlllII.bipedRightLeg;
            }
            default: {
                return null;
            }
        }
    }
    
    public PlayerItemModel(final Dimension lllllllllllllIlIIlIlllIllllllIIl, final boolean lllllllllllllIlIIlIlllIlllllllII, final PlayerItemRenderer[] lllllllllllllIlIIlIlllIllllllIll) {
        this.textureSize = null;
        this.usePlayerTexture = false;
        this.modelRenderers = new PlayerItemRenderer[0];
        this.textureLocation = null;
        this.textureImage = null;
        this.texture = null;
        this.locationMissing = new ResourceLocation("textures/blocks/wool_colored_red.png");
        this.textureSize = lllllllllllllIlIIlIlllIllllllIIl;
        this.usePlayerTexture = lllllllllllllIlIIlIlllIlllllllII;
        this.modelRenderers = lllllllllllllIlIIlIlllIllllllIll;
    }
    
    public BufferedImage getTextureImage() {
        return this.textureImage;
    }
    
    public DynamicTexture getTexture() {
        return this.texture;
    }
}
