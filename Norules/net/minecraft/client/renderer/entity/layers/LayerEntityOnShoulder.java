package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import java.util.*;
import javax.annotation.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class LayerEntityOnShoulder implements LayerRenderer<EntityPlayer>
{
    private /* synthetic */ ResourceLocation field_192873_i;
    private /* synthetic */ Class<?> field_192871_g;
    protected /* synthetic */ RenderLivingBase<? extends EntityLivingBase> field_192865_a;
    protected /* synthetic */ RenderLivingBase<? extends EntityLivingBase> field_192866_b;
    private final /* synthetic */ RenderManager field_192867_c;
    private /* synthetic */ ResourceLocation field_192869_e;
    private /* synthetic */ UUID field_192874_j;
    private /* synthetic */ ModelBase field_192872_h;
    private /* synthetic */ UUID field_192870_f;
    private /* synthetic */ ModelBase field_192868_d;
    private /* synthetic */ Class<?> field_192875_k;
    
    private DataHolder func_192864_a(final EntityPlayer lllllllllllllIlIIlllllIIIIllIIll, @Nullable UUID lllllllllllllIlIIlllllIIIIlIIIII, final NBTTagCompound lllllllllllllIlIIlllllIIIIllIIIl, RenderLivingBase<? extends EntityLivingBase> lllllllllllllIlIIlllllIIIIIllllI, ModelBase lllllllllllllIlIIlllllIIIIIlllIl, ResourceLocation lllllllllllllIlIIlllllIIIIIlllII, Class<?> lllllllllllllIlIIlllllIIIIlIllIl, final float lllllllllllllIlIIlllllIIIIlIllII, final float lllllllllllllIlIIlllllIIIIlIlIll, final float lllllllllllllIlIIlllllIIIIIllIII, float lllllllllllllIlIIlllllIIIIIlIlll, final float lllllllllllllIlIIlllllIIIIIlIllI, final float lllllllllllllIlIIlllllIIIIIlIlIl, final float lllllllllllllIlIIlllllIIIIlIIllI, final boolean lllllllllllllIlIIlllllIIIIIlIIll) {
        if (lllllllllllllIlIIlllllIIIIlIIIII == null || !lllllllllllllIlIIlllllIIIIlIIIII.equals(lllllllllllllIlIIlllllIIIIllIIIl.getUniqueId("UUID"))) {
            lllllllllllllIlIIlllllIIIIlIIIII = lllllllllllllIlIIlllllIIIIllIIIl.getUniqueId("UUID");
            lllllllllllllIlIIlllllIIIIlIllIl = EntityList.func_192839_a(lllllllllllllIlIIlllllIIIIllIIIl.getString("id"));
            if (lllllllllllllIlIIlllllIIIIlIllIl == EntityParrot.class) {
                lllllllllllllIlIIlllllIIIIIllllI = new RenderParrot(this.field_192867_c);
                lllllllllllllIlIIlllllIIIIIlllIl = new ModelParrot();
                lllllllllllllIlIIlllllIIIIIlllII = RenderParrot.field_192862_a[lllllllllllllIlIIlllllIIIIllIIIl.getInteger("Variant")];
            }
        }
        lllllllllllllIlIIlllllIIIIIllllI.bindTexture((ResourceLocation)lllllllllllllIlIIlllllIIIIIlllII);
        GlStateManager.pushMatrix();
        final float lllllllllllllIlIIlllllIIIIlIIlII = lllllllllllllIlIIlllllIIIIllIIll.isSneaking() ? -1.3f : -1.5f;
        final float lllllllllllllIlIIlllllIIIIlIIIll = lllllllllllllIlIIlllllIIIIIlIIll ? 0.4f : -0.4f;
        GlStateManager.translate(lllllllllllllIlIIlllllIIIIlIIIll, lllllllllllllIlIIlllllIIIIlIIlII, 0.0f);
        if (lllllllllllllIlIIlllllIIIIlIllIl == EntityParrot.class) {
            lllllllllllllIlIIlllllIIIIIlIlll = 0.0f;
        }
        lllllllllllllIlIIlllllIIIIIlllIl.setLivingAnimations(lllllllllllllIlIIlllllIIIIllIIll, lllllllllllllIlIIlllllIIIIlIllII, lllllllllllllIlIIlllllIIIIlIlIll, lllllllllllllIlIIlllllIIIIIllIII);
        lllllllllllllIlIIlllllIIIIIlllIl.setRotationAngles(lllllllllllllIlIIlllllIIIIlIllII, lllllllllllllIlIIlllllIIIIlIlIll, lllllllllllllIlIIlllllIIIIIlIlll, lllllllllllllIlIIlllllIIIIIlIllI, lllllllllllllIlIIlllllIIIIIlIlIl, lllllllllllllIlIIlllllIIIIlIIllI, lllllllllllllIlIIlllllIIIIllIIll);
        lllllllllllllIlIIlllllIIIIIlllIl.render(lllllllllllllIlIIlllllIIIIllIIll, lllllllllllllIlIIlllllIIIIlIllII, lllllllllllllIlIIlllllIIIIlIlIll, lllllllllllllIlIIlllllIIIIIlIlll, lllllllllllllIlIIlllllIIIIIlIllI, lllllllllllllIlIIlllllIIIIIlIlIl, lllllllllllllIlIIlllllIIIIlIIllI);
        GlStateManager.popMatrix();
        return new DataHolder(lllllllllllllIlIIlllllIIIIlIIIII, lllllllllllllIlIIlllllIIIIIllllI, lllllllllllllIlIIlllllIIIIIlllIl, (ResourceLocation)lllllllllllllIlIIlllllIIIIIlllII, lllllllllllllIlIIlllllIIIIlIllIl);
    }
    
    @Override
    public void doRenderLayer(final EntityPlayer lllllllllllllIlIIlllllIIIlIlIIIl, final float lllllllllllllIlIIlllllIIIlIlllIl, final float lllllllllllllIlIIlllllIIIlIIllll, final float lllllllllllllIlIIlllllIIIlIllIll, final float lllllllllllllIlIIlllllIIIlIIllIl, final float lllllllllllllIlIIlllllIIIlIllIIl, final float lllllllllllllIlIIlllllIIIlIllIII, final float lllllllllllllIlIIlllllIIIlIlIlll) {
        if (lllllllllllllIlIIlllllIIIlIlIIIl.func_192023_dk() != null || lllllllllllllIlIIlllllIIIlIlIIIl.func_192025_dl() != null) {
            GlStateManager.enableRescaleNormal();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final NBTTagCompound lllllllllllllIlIIlllllIIIlIlIllI = lllllllllllllIlIIlllllIIIlIlIIIl.func_192023_dk();
            if (!lllllllllllllIlIIlllllIIIlIlIllI.hasNoTags()) {
                final DataHolder lllllllllllllIlIIlllllIIIlIlIlIl = this.func_192864_a(lllllllllllllIlIIlllllIIIlIlIIIl, this.field_192870_f, lllllllllllllIlIIlllllIIIlIlIllI, this.field_192865_a, this.field_192868_d, this.field_192869_e, this.field_192871_g, lllllllllllllIlIIlllllIIIlIlllIl, lllllllllllllIlIIlllllIIIlIIllll, lllllllllllllIlIIlllllIIIlIllIll, lllllllllllllIlIIlllllIIIlIIllIl, lllllllllllllIlIIlllllIIIlIllIIl, lllllllllllllIlIIlllllIIIlIllIII, lllllllllllllIlIIlllllIIIlIlIlll, true);
                this.field_192870_f = lllllllllllllIlIIlllllIIIlIlIlIl.field_192882_a;
                this.field_192865_a = lllllllllllllIlIIlllllIIIlIlIlIl.field_192883_b;
                this.field_192869_e = lllllllllllllIlIIlllllIIIlIlIlIl.field_192885_d;
                this.field_192868_d = lllllllllllllIlIIlllllIIIlIlIlIl.field_192884_c;
                this.field_192871_g = lllllllllllllIlIIlllllIIIlIlIlIl.field_192886_e;
            }
            final NBTTagCompound lllllllllllllIlIIlllllIIIlIlIlII = lllllllllllllIlIIlllllIIIlIlIIIl.func_192025_dl();
            if (!lllllllllllllIlIIlllllIIIlIlIlII.hasNoTags()) {
                final DataHolder lllllllllllllIlIIlllllIIIlIlIIll = this.func_192864_a(lllllllllllllIlIIlllllIIIlIlIIIl, this.field_192874_j, lllllllllllllIlIIlllllIIIlIlIlII, this.field_192866_b, this.field_192872_h, this.field_192873_i, this.field_192875_k, lllllllllllllIlIIlllllIIIlIlllIl, lllllllllllllIlIIlllllIIIlIIllll, lllllllllllllIlIIlllllIIIlIllIll, lllllllllllllIlIIlllllIIIlIIllIl, lllllllllllllIlIIlllllIIIlIllIIl, lllllllllllllIlIIlllllIIIlIllIII, lllllllllllllIlIIlllllIIIlIlIlll, false);
                this.field_192874_j = lllllllllllllIlIIlllllIIIlIlIIll.field_192882_a;
                this.field_192866_b = lllllllllllllIlIIlllllIIIlIlIIll.field_192883_b;
                this.field_192873_i = lllllllllllllIlIIlllllIIIlIlIIll.field_192885_d;
                this.field_192872_h = lllllllllllllIlIIlllllIIIlIlIIll.field_192884_c;
                this.field_192875_k = lllllllllllllIlIIlllllIIIlIlIIll.field_192886_e;
            }
            GlStateManager.disableRescaleNormal();
        }
    }
    
    public LayerEntityOnShoulder(final RenderManager lllllllllllllIlIIlllllIIIllIlllI) {
        this.field_192867_c = lllllllllllllIlIIlllllIIIllIlllI;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    class DataHolder
    {
        public /* synthetic */ RenderLivingBase<? extends EntityLivingBase> field_192883_b;
        public /* synthetic */ ResourceLocation field_192885_d;
        public /* synthetic */ UUID field_192882_a;
        public /* synthetic */ ModelBase field_192884_c;
        public /* synthetic */ Class<?> field_192886_e;
        
        public DataHolder(final UUID llllIlllIllIlll, final RenderLivingBase<? extends EntityLivingBase> llllIlllIllIllI, final ModelBase llllIlllIlIlllI, final ResourceLocation llllIlllIllIlII, final Class<?> llllIlllIlIllII) {
            this.field_192882_a = llllIlllIllIlll;
            this.field_192883_b = llllIlllIllIllI;
            this.field_192884_c = llllIlllIlIlllI;
            this.field_192885_d = llllIlllIllIlII;
            this.field_192886_e = llllIlllIlIllII;
        }
    }
}
