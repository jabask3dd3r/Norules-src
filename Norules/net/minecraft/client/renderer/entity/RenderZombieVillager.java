package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;

public class RenderZombieVillager extends RenderBiped<EntityZombieVillager>
{
    private static final /* synthetic */ ResourceLocation ZOMBIE_VILLAGER_SMITH_LOCATION;
    private static final /* synthetic */ ResourceLocation ZOMBIE_VILLAGER_BUTCHER_LOCATION;
    private static final /* synthetic */ ResourceLocation ZOMBIE_VILLAGER_PRIEST_LOCATION;
    private static final /* synthetic */ ResourceLocation ZOMBIE_VILLAGER_FARMER_LOCATION;
    private static final /* synthetic */ ResourceLocation ZOMBIE_VILLAGER_LIBRARIAN_LOC;
    private static final /* synthetic */ ResourceLocation ZOMBIE_VILLAGER_TEXTURES;
    
    public RenderZombieVillager(final RenderManager llllllllllllllIlllIIlllIllIllIIl) {
        super(llllllllllllllIlllIIlllIllIllIIl, new ModelZombieVillager(), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerVillagerArmor(this));
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityZombieVillager llllllllllllllIlllIIlllIllIlIIll) {
        switch (llllllllllllllIlllIIlllIllIlIIll.func_190736_dl()) {
            case 0: {
                return RenderZombieVillager.ZOMBIE_VILLAGER_FARMER_LOCATION;
            }
            case 1: {
                return RenderZombieVillager.ZOMBIE_VILLAGER_LIBRARIAN_LOC;
            }
            case 2: {
                return RenderZombieVillager.ZOMBIE_VILLAGER_PRIEST_LOCATION;
            }
            case 3: {
                return RenderZombieVillager.ZOMBIE_VILLAGER_SMITH_LOCATION;
            }
            case 4: {
                return RenderZombieVillager.ZOMBIE_VILLAGER_BUTCHER_LOCATION;
            }
            default: {
                return RenderZombieVillager.ZOMBIE_VILLAGER_TEXTURES;
            }
        }
    }
    
    @Override
    protected void rotateCorpse(final EntityZombieVillager llllllllllllllIlllIIlllIllIIllII, final float llllllllllllllIlllIIlllIllIIlIll, float llllllllllllllIlllIIlllIllIIIlIl, final float llllllllllllllIlllIIlllIllIIlIIl) {
        if (llllllllllllllIlllIIlllIllIIllII.isConverting()) {
            llllllllllllllIlllIIlllIllIIIlIl += (float)(Math.cos(llllllllllllllIlllIIlllIllIIllII.ticksExisted * 3.25) * 3.141592653589793 * 0.25);
        }
        super.rotateCorpse(llllllllllllllIlllIIlllIllIIllII, llllllllllllllIlllIIlllIllIIlIll, llllllllllllllIlllIIlllIllIIIlIl, llllllllllllllIlllIIlllIllIIlIIl);
    }
    
    static {
        ZOMBIE_VILLAGER_TEXTURES = new ResourceLocation("textures/entity/zombie_villager/zombie_villager.png");
        ZOMBIE_VILLAGER_FARMER_LOCATION = new ResourceLocation("textures/entity/zombie_villager/zombie_farmer.png");
        ZOMBIE_VILLAGER_LIBRARIAN_LOC = new ResourceLocation("textures/entity/zombie_villager/zombie_librarian.png");
        ZOMBIE_VILLAGER_PRIEST_LOCATION = new ResourceLocation("textures/entity/zombie_villager/zombie_priest.png");
        ZOMBIE_VILLAGER_SMITH_LOCATION = new ResourceLocation("textures/entity/zombie_villager/zombie_smith.png");
        ZOMBIE_VILLAGER_BUTCHER_LOCATION = new ResourceLocation("textures/entity/zombie_villager/zombie_butcher.png");
    }
}
