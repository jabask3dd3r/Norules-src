package net.minecraft.client.renderer.tileentity;

import net.minecraft.util.*;
import com.mojang.authlib.*;
import javax.annotation.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.*;
import com.mojang.authlib.minecraft.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import java.util.*;
import net.minecraft.tileentity.*;

public class TileEntitySkullRenderer extends TileEntitySpecialRenderer<TileEntitySkull>
{
    private final /* synthetic */ ModelSkeletonHead skeletonHead;
    private static final /* synthetic */ ResourceLocation WITHER_SKELETON_TEXTURES;
    private static final /* synthetic */ ResourceLocation SKELETON_TEXTURES;
    private static final /* synthetic */ ResourceLocation DRAGON_TEXTURES;
    private final /* synthetic */ ModelDragonHead dragonHead;
    private final /* synthetic */ ModelSkeletonHead humanoidHead;
    public static /* synthetic */ TileEntitySkullRenderer instance;
    private static final /* synthetic */ ResourceLocation ZOMBIE_TEXTURES;
    private static final /* synthetic */ ResourceLocation CREEPER_TEXTURES;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = TileEntitySkullRenderer.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final short llllllllllllIllllllllIllllIIlIII = (Object)new int[EnumFacing.values().length];
        try {
            llllllllllllIllllllllIllllIIlIII[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIllllllllIllllIIlIII[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIllllllllIllllIIlIII[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIllllllllIllllIIlIII[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllIllllllllIllllIIlIII[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllIllllllllIllllIIlIII[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return TileEntitySkullRenderer.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllIllllllllIllllIIlIII;
    }
    
    @Override
    public void func_192841_a(final TileEntitySkull llllllllllllIlllllllllIIIIIlIlIl, final double llllllllllllIlllllllllIIIIIllllI, final double llllllllllllIlllllllllIIIIIlllIl, final double llllllllllllIlllllllllIIIIIlIIlI, final float llllllllllllIlllllllllIIIIIllIll, final int llllllllllllIlllllllllIIIIIlIIII, final float llllllllllllIlllllllllIIIIIllIIl) {
        final EnumFacing llllllllllllIlllllllllIIIIIllIII = EnumFacing.getFront(llllllllllllIlllllllllIIIIIlIlIl.getBlockMetadata() & 0x7);
        final float llllllllllllIlllllllllIIIIIlIlll = llllllllllllIlllllllllIIIIIlIlIl.getAnimationProgress(llllllllllllIlllllllllIIIIIllIll);
        this.renderSkull((float)llllllllllllIlllllllllIIIIIllllI, (float)llllllllllllIlllllllllIIIIIlllIl, (float)llllllllllllIlllllllllIIIIIlIIlI, llllllllllllIlllllllllIIIIIllIII, llllllllllllIlllllllllIIIIIlIlIl.getSkullRotation() * 360 / 16.0f, llllllllllllIlllllllllIIIIIlIlIl.getSkullType(), llllllllllllIlllllllllIIIIIlIlIl.getPlayerProfile(), llllllllllllIlllllllllIIIIIlIIII, llllllllllllIlllllllllIIIIIlIlll);
    }
    
    public TileEntitySkullRenderer() {
        this.dragonHead = new ModelDragonHead(0.0f);
        this.skeletonHead = new ModelSkeletonHead(0, 0, 64, 32);
        this.humanoidHead = new ModelHumanoidHead();
    }
    
    static {
        SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/skeleton.png");
        WITHER_SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");
        ZOMBIE_TEXTURES = new ResourceLocation("textures/entity/zombie/zombie.png");
        CREEPER_TEXTURES = new ResourceLocation("textures/entity/creeper/creeper.png");
        DRAGON_TEXTURES = new ResourceLocation("textures/entity/enderdragon/dragon.png");
    }
    
    @Override
    public void setRendererDispatcher(final TileEntityRendererDispatcher llllllllllllIlllllllllIIIIIIlIlI) {
        super.setRendererDispatcher(llllllllllllIlllllllllIIIIIIlIlI);
        TileEntitySkullRenderer.instance = this;
    }
    
    public void renderSkull(final float llllllllllllIllllllllIlllllIIlll, final float llllllllllllIllllllllIllllllIllI, final float llllllllllllIllllllllIlllllIIlIl, final EnumFacing llllllllllllIllllllllIlllllIIlII, float llllllllllllIllllllllIlllllIIIll, final int llllllllllllIllllllllIllllllIIlI, @Nullable final GameProfile llllllllllllIllllllllIlllllIIIIl, final int llllllllllllIllllllllIlllllIIIII, final float llllllllllllIllllllllIllllIlllll) {
        ModelBase llllllllllllIllllllllIlllllIlllI = this.skeletonHead;
        if (llllllllllllIllllllllIlllllIIIII >= 0) {
            this.bindTexture(TileEntitySkullRenderer.DESTROY_STAGES[llllllllllllIllllllllIlllllIIIII]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0f, 2.0f, 1.0f);
            GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
            GlStateManager.matrixMode(5888);
        }
        else {
            switch (llllllllllllIllllllllIllllllIIlI) {
                default: {
                    this.bindTexture(TileEntitySkullRenderer.SKELETON_TEXTURES);
                    break;
                }
                case 1: {
                    this.bindTexture(TileEntitySkullRenderer.WITHER_SKELETON_TEXTURES);
                    break;
                }
                case 2: {
                    this.bindTexture(TileEntitySkullRenderer.ZOMBIE_TEXTURES);
                    llllllllllllIllllllllIlllllIlllI = this.humanoidHead;
                    break;
                }
                case 3: {
                    llllllllllllIllllllllIlllllIlllI = this.humanoidHead;
                    ResourceLocation llllllllllllIllllllllIlllllIllIl = DefaultPlayerSkin.getDefaultSkinLegacy();
                    if (llllllllllllIllllllllIlllllIIIIl != null) {
                        final Minecraft llllllllllllIllllllllIlllllIllII = Minecraft.getMinecraft();
                        final Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> llllllllllllIllllllllIlllllIlIll = llllllllllllIllllllllIlllllIllII.getSkinManager().loadSkinFromCache(llllllllllllIllllllllIlllllIIIIl);
                        if (llllllllllllIllllllllIlllllIlIll.containsKey(MinecraftProfileTexture.Type.SKIN)) {
                            llllllllllllIllllllllIlllllIllIl = llllllllllllIllllllllIlllllIllII.getSkinManager().loadSkin(llllllllllllIllllllllIlllllIlIll.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN);
                        }
                        else {
                            final UUID llllllllllllIllllllllIlllllIlIlI = EntityPlayer.getUUID(llllllllllllIllllllllIlllllIIIIl);
                            llllllllllllIllllllllIlllllIllIl = DefaultPlayerSkin.getDefaultSkin(llllllllllllIllllllllIlllllIlIlI);
                        }
                    }
                    this.bindTexture(llllllllllllIllllllllIlllllIllIl);
                    break;
                }
                case 4: {
                    this.bindTexture(TileEntitySkullRenderer.CREEPER_TEXTURES);
                    break;
                }
                case 5: {
                    this.bindTexture(TileEntitySkullRenderer.DRAGON_TEXTURES);
                    llllllllllllIllllllllIlllllIlllI = this.dragonHead;
                    break;
                }
            }
        }
        GlStateManager.pushMatrix();
        GlStateManager.disableCull();
        if (llllllllllllIllllllllIlllllIIlII == EnumFacing.UP) {
            GlStateManager.translate(llllllllllllIllllllllIlllllIIlll + 0.5f, llllllllllllIllllllllIllllllIllI, llllllllllllIllllllllIlllllIIlIl + 0.5f);
        }
        else {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllIllllllllIlllllIIlII.ordinal()]) {
                case 3: {
                    GlStateManager.translate(llllllllllllIllllllllIlllllIIlll + 0.5f, llllllllllllIllllllllIllllllIllI + 0.25f, llllllllllllIllllllllIlllllIIlIl + 0.74f);
                    break;
                }
                case 4: {
                    GlStateManager.translate(llllllllllllIllllllllIlllllIIlll + 0.5f, llllllllllllIllllllllIllllllIllI + 0.25f, llllllllllllIllllllllIlllllIIlIl + 0.26f);
                    llllllllllllIllllllllIlllllIIIll = 180.0f;
                    break;
                }
                case 5: {
                    GlStateManager.translate(llllllllllllIllllllllIlllllIIlll + 0.74f, llllllllllllIllllllllIllllllIllI + 0.25f, llllllllllllIllllllllIlllllIIlIl + 0.5f);
                    llllllllllllIllllllllIlllllIIIll = 270.0f;
                    break;
                }
                default: {
                    GlStateManager.translate(llllllllllllIllllllllIlllllIIlll + 0.26f, llllllllllllIllllllllIllllllIllI + 0.25f, llllllllllllIllllllllIlllllIIlIl + 0.5f);
                    llllllllllllIllllllllIlllllIIIll = 90.0f;
                    break;
                }
            }
        }
        final float llllllllllllIllllllllIlllllIlIIl = 0.0625f;
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
        GlStateManager.enableAlpha();
        if (llllllllllllIllllllllIllllllIIlI == 3) {
            GlStateManager.enableBlendProfile(GlStateManager.Profile.PLAYER_SKIN);
        }
        llllllllllllIllllllllIlllllIlllI.render(null, llllllllllllIllllllllIllllIlllll, 0.0f, 0.0f, llllllllllllIllllllllIlllllIIIll, 0.0f, 0.0625f);
        GlStateManager.popMatrix();
        if (llllllllllllIllllllllIlllllIIIII >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
}
