package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.model.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import org.apache.commons.lang3.*;
import com.mojang.authlib.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.block.*;

public class TileEntityItemStackRenderer
{
    private static final /* synthetic */ TileEntityShulkerBox[] field_191274_b;
    public static /* synthetic */ TileEntityItemStackRenderer instance;
    private final /* synthetic */ ModelShield modelShield;
    private final /* synthetic */ TileEntitySkull skull;
    private final /* synthetic */ TileEntityEnderChest enderChest;
    private final /* synthetic */ TileEntityChest chestTrap;
    private final /* synthetic */ TileEntityChest chestBasic;
    private final /* synthetic */ TileEntityBanner banner;
    private final /* synthetic */ TileEntityBed field_193843_g;
    
    static {
        field_191274_b = new TileEntityShulkerBox[16];
        final int lIIIllllIIlIIII;
        final char lIIIllllIIlIIIl = (char)((EnumDyeColor[])(Object)(lIIIllllIIlIIII = (int)(Object)EnumDyeColor.values())).length;
        for (short lIIIllllIIlIIlI = 0; lIIIllllIIlIIlI < lIIIllllIIlIIIl; ++lIIIllllIIlIIlI) {
            final EnumDyeColor lIIIllllIIlIlII = lIIIllllIIlIIII[lIIIllllIIlIIlI];
            TileEntityItemStackRenderer.field_191274_b[lIIIllllIIlIlII.getMetadata()] = new TileEntityShulkerBox(lIIIllllIIlIlII);
        }
        TileEntityItemStackRenderer.instance = new TileEntityItemStackRenderer();
    }
    
    public void func_192838_a(final ItemStack lIIIlllIllllllI, final float lIIIlllIlllIllI) {
        final Item lIIIlllIlllllII = lIIIlllIllllllI.getItem();
        if (lIIIlllIlllllII == Items.BANNER) {
            this.banner.setItemValues(lIIIlllIllllllI, false);
            TileEntityRendererDispatcher.instance.func_192855_a(this.banner, 0.0, 0.0, 0.0, 0.0f, lIIIlllIlllIllI);
        }
        else if (lIIIlllIlllllII == Items.BED) {
            this.field_193843_g.func_193051_a(lIIIlllIllllllI);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.field_193843_g, 0.0, 0.0, 0.0, 0.0f);
        }
        else if (lIIIlllIlllllII == Items.SHIELD) {
            if (lIIIlllIllllllI.getSubCompound("BlockEntityTag") != null) {
                this.banner.setItemValues(lIIIlllIllllllI, true);
                Minecraft.getMinecraft().getTextureManager().bindTexture(BannerTextures.SHIELD_DESIGNS.getResourceLocation(this.banner.getPatternResourceLocation(), this.banner.getPatternList(), this.banner.getColorList()));
            }
            else {
                Minecraft.getMinecraft().getTextureManager().bindTexture(BannerTextures.SHIELD_BASE_TEXTURE);
            }
            GlStateManager.pushMatrix();
            GlStateManager.scale(1.0f, -1.0f, -1.0f);
            this.modelShield.render();
            GlStateManager.popMatrix();
        }
        else if (lIIIlllIlllllII == Items.SKULL) {
            GameProfile lIIIlllIllllIll = null;
            if (lIIIlllIllllllI.hasTagCompound()) {
                final NBTTagCompound lIIIlllIllllIlI = lIIIlllIllllllI.getTagCompound();
                if (lIIIlllIllllIlI.hasKey("SkullOwner", 10)) {
                    lIIIlllIllllIll = NBTUtil.readGameProfileFromNBT(lIIIlllIllllIlI.getCompoundTag("SkullOwner"));
                }
                else if (lIIIlllIllllIlI.hasKey("SkullOwner", 8) && !StringUtils.isBlank((CharSequence)lIIIlllIllllIlI.getString("SkullOwner"))) {
                    final GameProfile lIIIlllIllllIIl = new GameProfile((UUID)null, lIIIlllIllllIlI.getString("SkullOwner"));
                    lIIIlllIllllIll = TileEntitySkull.updateGameprofile(lIIIlllIllllIIl);
                    lIIIlllIllllIlI.removeTag("SkullOwner");
                    lIIIlllIllllIlI.setTag("SkullOwner", NBTUtil.writeGameProfile(new NBTTagCompound(), lIIIlllIllllIll));
                }
            }
            if (TileEntitySkullRenderer.instance != null) {
                GlStateManager.pushMatrix();
                GlStateManager.disableCull();
                TileEntitySkullRenderer.instance.renderSkull(0.0f, 0.0f, 0.0f, EnumFacing.UP, 180.0f, lIIIlllIllllllI.getMetadata(), lIIIlllIllllIll, -1, 0.0f);
                GlStateManager.enableCull();
                GlStateManager.popMatrix();
            }
        }
        else if (lIIIlllIlllllII == Item.getItemFromBlock(Blocks.ENDER_CHEST)) {
            TileEntityRendererDispatcher.instance.func_192855_a(this.enderChest, 0.0, 0.0, 0.0, 0.0f, lIIIlllIlllIllI);
        }
        else if (lIIIlllIlllllII == Item.getItemFromBlock(Blocks.TRAPPED_CHEST)) {
            TileEntityRendererDispatcher.instance.func_192855_a(this.chestTrap, 0.0, 0.0, 0.0, 0.0f, lIIIlllIlllIllI);
        }
        else if (Block.getBlockFromItem(lIIIlllIlllllII) instanceof BlockShulkerBox) {
            TileEntityRendererDispatcher.instance.func_192855_a(TileEntityItemStackRenderer.field_191274_b[BlockShulkerBox.func_190955_b(lIIIlllIlllllII).getMetadata()], 0.0, 0.0, 0.0, 0.0f, lIIIlllIlllIllI);
        }
        else {
            TileEntityRendererDispatcher.instance.func_192855_a(this.chestBasic, 0.0, 0.0, 0.0, 0.0f, lIIIlllIlllIllI);
        }
    }
    
    public void renderByItem(final ItemStack lIIIllllIIIlIIl) {
        this.func_192838_a(lIIIllllIIIlIIl, 1.0f);
    }
    
    public TileEntityItemStackRenderer() {
        this.chestBasic = new TileEntityChest(BlockChest.Type.BASIC);
        this.chestTrap = new TileEntityChest(BlockChest.Type.TRAP);
        this.enderChest = new TileEntityEnderChest();
        this.banner = new TileEntityBanner();
        this.field_193843_g = new TileEntityBed();
        this.skull = new TileEntitySkull();
        this.modelShield = new ModelShield();
    }
}
