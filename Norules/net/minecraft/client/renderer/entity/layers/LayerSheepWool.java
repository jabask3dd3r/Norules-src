package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.passive.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import optifine.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class LayerSheepWool implements LayerRenderer<EntitySheep>
{
    public /* synthetic */ ModelSheep1 sheepModel;
    private final /* synthetic */ RenderSheep sheepRenderer;
    private static final /* synthetic */ ResourceLocation TEXTURE;
    
    public LayerSheepWool(final RenderSheep llllllllllllllllIIIlIlIIlIlllIII) {
        this.sheepModel = new ModelSheep1();
        this.sheepRenderer = llllllllllllllllIIIlIlIIlIlllIII;
    }
    
    @Override
    public void doRenderLayer(final EntitySheep llllllllllllllllIIIlIlIIlIlIIlIl, final float llllllllllllllllIIIlIlIIlIlIIlII, final float llllllllllllllllIIIlIlIIlIlIIIll, final float llllllllllllllllIIIlIlIIlIlIIIlI, final float llllllllllllllllIIIlIlIIlIlIIIIl, final float llllllllllllllllIIIlIlIIlIIIlllI, final float llllllllllllllllIIIlIlIIlIIlllll, final float llllllllllllllllIIIlIlIIlIIllllI) {
        if (!llllllllllllllllIIIlIlIIlIlIIlIl.getSheared() && !llllllllllllllllIIIlIlIIlIlIIlIl.isInvisible()) {
            this.sheepRenderer.bindTexture(LayerSheepWool.TEXTURE);
            if (llllllllllllllllIIIlIlIIlIlIIlIl.hasCustomName() && "jeb_".equals(llllllllllllllllIIIlIlIIlIlIIlIl.getCustomNameTag())) {
                final int llllllllllllllllIIIlIlIIlIIlllIl = 25;
                final int llllllllllllllllIIIlIlIIlIIlllII = llllllllllllllllIIIlIlIIlIlIIlIl.ticksExisted / 25 + llllllllllllllllIIIlIlIIlIlIIlIl.getEntityId();
                final int llllllllllllllllIIIlIlIIlIIllIll = EnumDyeColor.values().length;
                final int llllllllllllllllIIIlIlIIlIIllIlI = llllllllllllllllIIIlIlIIlIIlllII % llllllllllllllllIIIlIlIIlIIllIll;
                final int llllllllllllllllIIIlIlIIlIIllIIl = (llllllllllllllllIIIlIlIIlIIlllII + 1) % llllllllllllllllIIIlIlIIlIIllIll;
                final float llllllllllllllllIIIlIlIIlIIllIII = (llllllllllllllllIIIlIlIIlIlIIlIl.ticksExisted % 25 + llllllllllllllllIIIlIlIIlIlIIIlI) / 25.0f;
                float[] llllllllllllllllIIIlIlIIlIIlIlll = EntitySheep.getDyeRgb(EnumDyeColor.byMetadata(llllllllllllllllIIIlIlIIlIIllIlI));
                float[] llllllllllllllllIIIlIlIIlIIlIllI = EntitySheep.getDyeRgb(EnumDyeColor.byMetadata(llllllllllllllllIIIlIlIIlIIllIIl));
                if (Config.isCustomColors()) {
                    llllllllllllllllIIIlIlIIlIIlIlll = CustomColors.getSheepColors(EnumDyeColor.byMetadata(llllllllllllllllIIIlIlIIlIIllIlI), llllllllllllllllIIIlIlIIlIIlIlll);
                    llllllllllllllllIIIlIlIIlIIlIllI = CustomColors.getSheepColors(EnumDyeColor.byMetadata(llllllllllllllllIIIlIlIIlIIllIIl), llllllllllllllllIIIlIlIIlIIlIllI);
                }
                GlStateManager.color(llllllllllllllllIIIlIlIIlIIlIlll[0] * (1.0f - llllllllllllllllIIIlIlIIlIIllIII) + llllllllllllllllIIIlIlIIlIIlIllI[0] * llllllllllllllllIIIlIlIIlIIllIII, llllllllllllllllIIIlIlIIlIIlIlll[1] * (1.0f - llllllllllllllllIIIlIlIIlIIllIII) + llllllllllllllllIIIlIlIIlIIlIllI[1] * llllllllllllllllIIIlIlIIlIIllIII, llllllllllllllllIIIlIlIIlIIlIlll[2] * (1.0f - llllllllllllllllIIIlIlIIlIIllIII) + llllllllllllllllIIIlIlIIlIIlIllI[2] * llllllllllllllllIIIlIlIIlIIllIII);
            }
            else {
                float[] llllllllllllllllIIIlIlIIlIIlIlIl = EntitySheep.getDyeRgb(llllllllllllllllIIIlIlIIlIlIIlIl.getFleeceColor());
                if (Config.isCustomColors()) {
                    llllllllllllllllIIIlIlIIlIIlIlIl = CustomColors.getSheepColors(llllllllllllllllIIIlIlIIlIlIIlIl.getFleeceColor(), llllllllllllllllIIIlIlIIlIIlIlIl);
                }
                GlStateManager.color(llllllllllllllllIIIlIlIIlIIlIlIl[0], llllllllllllllllIIIlIlIIlIIlIlIl[1], llllllllllllllllIIIlIlIIlIIlIlIl[2]);
            }
            this.sheepModel.setModelAttributes(this.sheepRenderer.getMainModel());
            this.sheepModel.setLivingAnimations(llllllllllllllllIIIlIlIIlIlIIlIl, llllllllllllllllIIIlIlIIlIlIIlII, llllllllllllllllIIIlIlIIlIlIIIll, llllllllllllllllIIIlIlIIlIlIIIlI);
            this.sheepModel.render(llllllllllllllllIIIlIlIIlIlIIlIl, llllllllllllllllIIIlIlIIlIlIIlII, llllllllllllllllIIIlIlIIlIlIIIll, llllllllllllllllIIIlIlIIlIlIIIIl, llllllllllllllllIIIlIlIIlIIIlllI, llllllllllllllllIIIlIlIIlIIlllll, llllllllllllllllIIIlIlIIlIIllllI);
        }
    }
    
    static {
        TEXTURE = new ResourceLocation("textures/entity/sheep/sheep_fur.png");
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}
