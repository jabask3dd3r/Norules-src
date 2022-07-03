package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.inventory.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.monster.*;
import net.minecraft.init.*;
import org.apache.commons.lang3.*;
import com.mojang.authlib.*;
import java.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.nbt.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.item.*;

public class LayerCustomHead implements LayerRenderer<EntityLivingBase>
{
    private final /* synthetic */ ModelRenderer modelRenderer;
    
    @Override
    public void doRenderLayer(final EntityLivingBase llllllllllllIlllllIlllIIllIIIIII, final float llllllllllllIlllllIlllIIlIlIlIlI, final float llllllllllllIlllllIlllIIlIlllllI, final float llllllllllllIlllllIlllIIlIllllIl, final float llllllllllllIlllllIlllIIlIllllII, final float llllllllllllIlllllIlllIIlIlllIll, final float llllllllllllIlllllIlllIIlIlllIlI, final float llllllllllllIlllllIlllIIlIlllIIl) {
        final ItemStack llllllllllllIlllllIlllIIlIlllIII = llllllllllllIlllllIlllIIllIIIIII.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
        if (!llllllllllllIlllllIlllIIlIlllIII.func_190926_b()) {
            final Item llllllllllllIlllllIlllIIlIllIlll = llllllllllllIlllllIlllIIlIlllIII.getItem();
            final Minecraft llllllllllllIlllllIlllIIlIllIllI = Minecraft.getMinecraft();
            GlStateManager.pushMatrix();
            if (llllllllllllIlllllIlllIIllIIIIII.isSneaking()) {
                GlStateManager.translate(0.0f, 0.2f, 0.0f);
            }
            final boolean llllllllllllIlllllIlllIIlIllIlIl = llllllllllllIlllllIlllIIllIIIIII instanceof EntityVillager || llllllllllllIlllllIlllIIllIIIIII instanceof EntityZombieVillager;
            if (llllllllllllIlllllIlllIIllIIIIII.isChild() && !(llllllllllllIlllllIlllIIllIIIIII instanceof EntityVillager)) {
                final float llllllllllllIlllllIlllIIlIllIlII = 2.0f;
                final float llllllllllllIlllllIlllIIlIllIIll = 1.4f;
                GlStateManager.translate(0.0f, 0.5f * llllllllllllIlllllIlllIIlIlllIIl, 0.0f);
                GlStateManager.scale(0.7f, 0.7f, 0.7f);
                GlStateManager.translate(0.0f, 16.0f * llllllllllllIlllllIlllIIlIlllIIl, 0.0f);
            }
            this.modelRenderer.postRender(0.0625f);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            if (llllllllllllIlllllIlllIIlIllIlll == Items.SKULL) {
                final float llllllllllllIlllllIlllIIlIllIIlI = 1.1875f;
                GlStateManager.scale(1.1875f, -1.1875f, -1.1875f);
                if (llllllllllllIlllllIlllIIlIllIlIl) {
                    GlStateManager.translate(0.0f, 0.0625f, 0.0f);
                }
                GameProfile llllllllllllIlllllIlllIIlIllIIIl = null;
                if (llllllllllllIlllllIlllIIlIlllIII.hasTagCompound()) {
                    final NBTTagCompound llllllllllllIlllllIlllIIlIllIIII = llllllllllllIlllllIlllIIlIlllIII.getTagCompound();
                    if (llllllllllllIlllllIlllIIlIllIIII.hasKey("SkullOwner", 10)) {
                        llllllllllllIlllllIlllIIlIllIIIl = NBTUtil.readGameProfileFromNBT(llllllllllllIlllllIlllIIlIllIIII.getCompoundTag("SkullOwner"));
                    }
                    else if (llllllllllllIlllllIlllIIlIllIIII.hasKey("SkullOwner", 8)) {
                        final String llllllllllllIlllllIlllIIlIlIllll = llllllllllllIlllllIlllIIlIllIIII.getString("SkullOwner");
                        if (!StringUtils.isBlank((CharSequence)llllllllllllIlllllIlllIIlIlIllll)) {
                            llllllllllllIlllllIlllIIlIllIIIl = TileEntitySkull.updateGameprofile(new GameProfile((UUID)null, llllllllllllIlllllIlllIIlIlIllll));
                            llllllllllllIlllllIlllIIlIllIIII.setTag("SkullOwner", NBTUtil.writeGameProfile(new NBTTagCompound(), llllllllllllIlllllIlllIIlIllIIIl));
                        }
                    }
                }
                TileEntitySkullRenderer.instance.renderSkull(-0.5f, 0.0f, -0.5f, EnumFacing.UP, 180.0f, llllllllllllIlllllIlllIIlIlllIII.getMetadata(), llllllllllllIlllllIlllIIlIllIIIl, -1, llllllllllllIlllllIlllIIlIlIlIlI);
            }
            else if (!(llllllllllllIlllllIlllIIlIllIlll instanceof ItemArmor) || ((ItemArmor)llllllllllllIlllllIlllIIlIllIlll).getEquipmentSlot() != EntityEquipmentSlot.HEAD) {
                final float llllllllllllIlllllIlllIIlIlIlllI = 0.625f;
                GlStateManager.translate(0.0f, -0.25f, 0.0f);
                GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                GlStateManager.scale(0.625f, -0.625f, -0.625f);
                if (llllllllllllIlllllIlllIIlIllIlIl) {
                    GlStateManager.translate(0.0f, 0.1875f, 0.0f);
                }
                llllllllllllIlllllIlllIIlIllIllI.getItemRenderer().renderItem(llllllllllllIlllllIlllIIllIIIIII, llllllllllllIlllllIlllIIlIlllIII, ItemCameraTransforms.TransformType.HEAD);
            }
            GlStateManager.popMatrix();
        }
    }
    
    public LayerCustomHead(final ModelRenderer llllllllllllIlllllIlllIIllIIlllI) {
        this.modelRenderer = llllllllllllIlllllIlllIIllIIlllI;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
