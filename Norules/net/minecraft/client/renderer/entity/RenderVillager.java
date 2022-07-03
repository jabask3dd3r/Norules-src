package net.minecraft.client.renderer.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;

public class RenderVillager extends RenderLiving<EntityVillager>
{
    private static final /* synthetic */ ResourceLocation BUTCHER_VILLAGER_TEXTURES;
    private static final /* synthetic */ ResourceLocation LIBRARIAN_VILLAGER_TEXTURES;
    private static final /* synthetic */ ResourceLocation PRIEST_VILLAGER_TEXTURES;
    private static final /* synthetic */ ResourceLocation SMITH_VILLAGER_TEXTURES;
    private static final /* synthetic */ ResourceLocation FARMER_VILLAGER_TEXTURES;
    private static final /* synthetic */ ResourceLocation VILLAGER_TEXTURES;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityVillager lllllllllllllIlIIlIlIIllllIIllII) {
        switch (lllllllllllllIlIIlIlIIllllIIllII.getProfession()) {
            case 0: {
                return RenderVillager.FARMER_VILLAGER_TEXTURES;
            }
            case 1: {
                return RenderVillager.LIBRARIAN_VILLAGER_TEXTURES;
            }
            case 2: {
                return RenderVillager.PRIEST_VILLAGER_TEXTURES;
            }
            case 3: {
                return RenderVillager.SMITH_VILLAGER_TEXTURES;
            }
            case 4: {
                return RenderVillager.BUTCHER_VILLAGER_TEXTURES;
            }
            default: {
                return RenderVillager.VILLAGER_TEXTURES;
            }
        }
    }
    
    @Override
    protected void preRenderCallback(final EntityVillager lllllllllllllIlIIlIlIIllllIIIlll, final float lllllllllllllIlIIlIlIIllllIIIllI) {
        float lllllllllllllIlIIlIlIIllllIIIlIl = 0.9375f;
        if (lllllllllllllIlIIlIlIIllllIIIlll.getGrowingAge() < 0) {
            lllllllllllllIlIIlIlIIllllIIIlIl *= 0.5;
            this.shadowSize = 0.25f;
        }
        else {
            this.shadowSize = 0.5f;
        }
        GlStateManager.scale(lllllllllllllIlIIlIlIIllllIIIlIl, lllllllllllllIlIIlIlIIllllIIIlIl, lllllllllllllIlIIlIlIIllllIIIlIl);
    }
    
    static {
        VILLAGER_TEXTURES = new ResourceLocation("textures/entity/villager/villager.png");
        FARMER_VILLAGER_TEXTURES = new ResourceLocation("textures/entity/villager/farmer.png");
        LIBRARIAN_VILLAGER_TEXTURES = new ResourceLocation("textures/entity/villager/librarian.png");
        PRIEST_VILLAGER_TEXTURES = new ResourceLocation("textures/entity/villager/priest.png");
        SMITH_VILLAGER_TEXTURES = new ResourceLocation("textures/entity/villager/smith.png");
        BUTCHER_VILLAGER_TEXTURES = new ResourceLocation("textures/entity/villager/butcher.png");
    }
    
    public RenderVillager(final RenderManager lllllllllllllIlIIlIlIIllllIlIlIl) {
        super(lllllllllllllIlIIlIlIIllllIlIlIl, new ModelVillager(0.0f), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerCustomHead(this.getMainModel().villagerHead));
    }
    
    @Override
    public ModelVillager getMainModel() {
        return (ModelVillager)super.getMainModel();
    }
}
