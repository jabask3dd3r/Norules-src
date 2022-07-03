package net.minecraft.client.renderer;

import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import me.nrules.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.entity.*;
import shadersmod.client.*;
import me.nrules.module.combat.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.entity.*;
import com.google.common.base.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.entity.*;
import optifine.*;
import net.minecraft.world.*;
import net.minecraft.world.storage.*;

public class ItemRenderer
{
    private /* synthetic */ float equippedProgressOffHand;
    private final /* synthetic */ RenderItem itemRenderer;
    private /* synthetic */ ItemStack itemStackOffHand;
    private /* synthetic */ float prevEquippedProgressOffHand;
    private /* synthetic */ ItemStack itemStackMainHand;
    private final /* synthetic */ Minecraft mc;
    private /* synthetic */ float equippedProgressMainHand;
    private static final /* synthetic */ ResourceLocation RES_UNDERWATER_OVERLAY;
    private /* synthetic */ float prevEquippedProgressMainHand;
    private static final /* synthetic */ ResourceLocation RES_MAP_BACKGROUND;
    private final /* synthetic */ RenderManager renderManager;
    
    private void renderArms() {
        if (!this.mc.player.isInvisible()) {
            GlStateManager.disableCull();
            GlStateManager.pushMatrix();
            GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
            this.renderArm(EnumHandSide.RIGHT);
            this.renderArm(EnumHandSide.LEFT);
            GlStateManager.popMatrix();
            GlStateManager.enableCull();
        }
    }
    
    private void renderMapFirstPerson(final float lllllllllllllIIIIIIllIIlIIllIlll, final float lllllllllllllIIIIIIllIIlIIllIllI, final float lllllllllllllIIIIIIllIIlIIlllllI) {
        final float lllllllllllllIIIIIIllIIlIIllllIl = MathHelper.sqrt(lllllllllllllIIIIIIllIIlIIlllllI);
        final float lllllllllllllIIIIIIllIIlIIllllII = -0.2f * MathHelper.sin(lllllllllllllIIIIIIllIIlIIlllllI * 3.1415927f);
        final float lllllllllllllIIIIIIllIIlIIlllIll = -0.4f * MathHelper.sin(lllllllllllllIIIIIIllIIlIIllllIl * 3.1415927f);
        GlStateManager.translate(0.0f, -lllllllllllllIIIIIIllIIlIIllllII / 2.0f, lllllllllllllIIIIIIllIIlIIlllIll);
        final float lllllllllllllIIIIIIllIIlIIlllIlI = this.getMapAngleFromPitch(lllllllllllllIIIIIIllIIlIIllIlll);
        GlStateManager.translate(0.0f, 0.04f + lllllllllllllIIIIIIllIIlIIllIllI * -1.2f + lllllllllllllIIIIIIllIIlIIlllIlI * -0.5f, -0.72f);
        GlStateManager.rotate(lllllllllllllIIIIIIllIIlIIlllIlI * -85.0f, 1.0f, 0.0f, 0.0f);
        this.renderArms();
        final float lllllllllllllIIIIIIllIIlIIlllIIl = MathHelper.sin(lllllllllllllIIIIIIllIIlIIllllIl * 3.1415927f);
        GlStateManager.rotate(lllllllllllllIIIIIIllIIlIIlllIIl * 20.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.scale(2.0f, 2.0f, 2.0f);
        this.renderMapFirstPerson(this.itemStackMainHand);
    }
    
    private void rotateArm(final float lllllllllllllIIIIIIllIIllIIIllIl) {
        final EntityPlayerSP lllllllllllllIIIIIIllIIllIIIllII = this.mc.player;
        final float lllllllllllllIIIIIIllIIllIIIlIll = lllllllllllllIIIIIIllIIllIIIllII.prevRenderArmPitch + (lllllllllllllIIIIIIllIIllIIIllII.renderArmPitch - lllllllllllllIIIIIIllIIllIIIllII.prevRenderArmPitch) * lllllllllllllIIIIIIllIIllIIIllIl;
        final float lllllllllllllIIIIIIllIIllIIIlIlI = lllllllllllllIIIIIIllIIllIIIllII.prevRenderArmYaw + (lllllllllllllIIIIIIllIIllIIIllII.renderArmYaw - lllllllllllllIIIIIIllIIllIIIllII.prevRenderArmYaw) * lllllllllllllIIIIIIllIIllIIIllIl;
        GlStateManager.rotate((lllllllllllllIIIIIIllIIllIIIllII.rotationPitch - lllllllllllllIIIIIIllIIllIIIlIll) * 0.1f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate((lllllllllllllIIIIIIllIIllIIIllII.rotationYaw - lllllllllllllIIIIIIllIIllIIIlIlI) * 0.1f, 0.0f, 1.0f, 0.0f);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$item$EnumAction() {
        final int[] $switch_TABLE$net$minecraft$item$EnumAction = ItemRenderer.$SWITCH_TABLE$net$minecraft$item$EnumAction;
        if ($switch_TABLE$net$minecraft$item$EnumAction != null) {
            return $switch_TABLE$net$minecraft$item$EnumAction;
        }
        final boolean lllllllllllllIIIIIIlIllllIlIlIlI = (Object)new int[EnumAction.values().length];
        try {
            lllllllllllllIIIIIIlIllllIlIlIlI[EnumAction.BLOCK.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIIIIIlIllllIlIlIlI[EnumAction.BOW.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIIIIIlIllllIlIlIlI[EnumAction.DRINK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIIIIIlIllllIlIlIlI[EnumAction.EAT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIIIIIlIllllIlIlIlI[EnumAction.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        return ItemRenderer.$SWITCH_TABLE$net$minecraft$item$EnumAction = (int[])(Object)lllllllllllllIIIIIIlIllllIlIlIlI;
    }
    
    private void transformSideFirstPerson(final EnumHandSide lllllllllllllIIIIIIllIIIllIIlIIl, final float lllllllllllllIIIIIIllIIIllIIlIII) {
        final int lllllllllllllIIIIIIllIIIllIIIlll = (lllllllllllllIIIIIIllIIIllIIlIIl == EnumHandSide.RIGHT) ? 1 : -1;
        GlStateManager.translate(lllllllllllllIIIIIIllIIIllIIIlll * 0.56f, -0.52f + lllllllllllllIIIIIIllIIIllIIlIII * -0.6f, -0.72f);
    }
    
    public void renderOverlays(final float lllllllllllllIIIIIIllIIIIlIIllII) {
        GlStateManager.disableAlpha();
        if (this.mc.player.isEntityInsideOpaqueBlock()) {
            IBlockState lllllllllllllIIIIIIllIIIIlIlIlll = this.mc.world.getBlockState(new BlockPos(this.mc.player));
            BlockPos lllllllllllllIIIIIIllIIIIlIlIllI = new BlockPos(this.mc.player);
            final EntityPlayer lllllllllllllIIIIIIllIIIIlIlIlIl = this.mc.player;
            for (int lllllllllllllIIIIIIllIIIIlIlIlII = 0; lllllllllllllIIIIIIllIIIIlIlIlII < 8; ++lllllllllllllIIIIIIllIIIIlIlIlII) {
                final double lllllllllllllIIIIIIllIIIIlIlIIll = lllllllllllllIIIIIIllIIIIlIlIlIl.posX + ((lllllllllllllIIIIIIllIIIIlIlIlII >> 0) % 2 - 0.5f) * lllllllllllllIIIIIIllIIIIlIlIlIl.width * 0.8f;
                final double lllllllllllllIIIIIIllIIIIlIlIIlI = lllllllllllllIIIIIIllIIIIlIlIlIl.posY + ((lllllllllllllIIIIIIllIIIIlIlIlII >> 1) % 2 - 0.5f) * 0.1f;
                final double lllllllllllllIIIIIIllIIIIlIlIIIl = lllllllllllllIIIIIIllIIIIlIlIlIl.posZ + ((lllllllllllllIIIIIIllIIIIlIlIlII >> 2) % 2 - 0.5f) * lllllllllllllIIIIIIllIIIIlIlIlIl.width * 0.8f;
                final BlockPos lllllllllllllIIIIIIllIIIIlIlIIII = new BlockPos(lllllllllllllIIIIIIllIIIIlIlIIll, lllllllllllllIIIIIIllIIIIlIlIIlI + lllllllllllllIIIIIIllIIIIlIlIlIl.getEyeHeight(), lllllllllllllIIIIIIllIIIIlIlIIIl);
                final IBlockState lllllllllllllIIIIIIllIIIIlIIllll = this.mc.world.getBlockState(lllllllllllllIIIIIIllIIIIlIlIIII);
                if (lllllllllllllIIIIIIllIIIIlIIllll.func_191058_s()) {
                    lllllllllllllIIIIIIllIIIIlIlIlll = lllllllllllllIIIIIIllIIIIlIIllll;
                    lllllllllllllIIIIIIllIIIIlIlIllI = lllllllllllllIIIIIIllIIIIlIlIIII;
                }
            }
            if (lllllllllllllIIIIIIllIIIIlIlIlll.getRenderType() != EnumBlockRenderType.INVISIBLE) {
                final Object lllllllllllllIIIIIIllIIIIlIIlllI = Reflector.getFieldValue(Reflector.RenderBlockOverlayEvent_OverlayType_BLOCK);
                if (!Reflector.callBoolean(Reflector.ForgeEventFactory_renderBlockOverlay, this.mc.player, lllllllllllllIIIIIIllIIIIlIIllII, lllllllllllllIIIIIIllIIIIlIIlllI, lllllllllllllIIIIIIllIIIIlIlIlll, lllllllllllllIIIIIIllIIIIlIlIllI)) {
                    this.renderBlockInHand(this.mc.getBlockRendererDispatcher().getBlockModelShapes().getTexture(lllllllllllllIIIIIIllIIIIlIlIlll));
                }
            }
        }
        if (!this.mc.player.isSpectator()) {
            if (this.mc.player.isInsideOfMaterial(Material.WATER) && !Main.moduleManager.getModuleByName("NoOverlay").isToggled() && !Reflector.callBoolean(Reflector.ForgeEventFactory_renderWaterOverlay, this.mc.player, lllllllllllllIIIIIIllIIIIlIIllII)) {
                this.renderWaterOverlayTexture(lllllllllllllIIIIIIllIIIIlIIllII);
            }
            if (this.mc.player.isBurning() && !Main.moduleManager.getModuleByName("NoOverlay").isToggled() && !Reflector.callBoolean(Reflector.ForgeEventFactory_renderFireOverlay, this.mc.player, lllllllllllllIIIIIIllIIIIlIIllII)) {
                this.renderFireInFirstPerson();
            }
        }
        GlStateManager.enableAlpha();
    }
    
    public void renderItemInFirstPerson(final AbstractClientPlayer lllllllllllllIIIIIIllIIIlIIIllII, final float lllllllllllllIIIIIIllIIIlIIIlIll, final float lllllllllllllIIIIIIllIIIIlllIIlI, final EnumHand lllllllllllllIIIIIIllIIIIlllIIIl, final float lllllllllllllIIIIIIllIIIlIIIlIII, final ItemStack lllllllllllllIIIIIIllIIIlIIIIlll, final float lllllllllllllIIIIIIllIIIlIIIIllI) {
        if (!Config.isShaders() || !Shaders.isSkipRenderHand(lllllllllllllIIIIIIllIIIIlllIIIl)) {
            final boolean lllllllllllllIIIIIIllIIIlIIIIlIl = lllllllllllllIIIIIIllIIIIlllIIIl == EnumHand.MAIN_HAND;
            final EnumHandSide lllllllllllllIIIIIIllIIIlIIIIlII = lllllllllllllIIIIIIllIIIlIIIIlIl ? lllllllllllllIIIIIIllIIIlIIIllII.getPrimaryHand() : lllllllllllllIIIIIIllIIIlIIIllII.getPrimaryHand().opposite();
            GlStateManager.pushMatrix();
            if (lllllllllllllIIIIIIllIIIlIIIIlll.func_190926_b()) {
                if (lllllllllllllIIIIIIllIIIlIIIIlIl && !lllllllllllllIIIIIIllIIIlIIIllII.isInvisible()) {
                    this.renderArmFirstPerson(lllllllllllllIIIIIIllIIIlIIIIllI, lllllllllllllIIIIIIllIIIlIIIlIII, lllllllllllllIIIIIIllIIIlIIIIlII);
                }
            }
            else if (lllllllllllllIIIIIIllIIIlIIIIlll.getItem() instanceof ItemMap) {
                if (lllllllllllllIIIIIIllIIIlIIIIlIl && this.itemStackOffHand.func_190926_b()) {
                    this.renderMapFirstPerson(lllllllllllllIIIIIIllIIIIlllIIlI, lllllllllllllIIIIIIllIIIlIIIIllI, lllllllllllllIIIIIIllIIIlIIIlIII);
                }
                else {
                    this.renderMapFirstPersonSide(lllllllllllllIIIIIIllIIIlIIIIllI, lllllllllllllIIIIIIllIIIlIIIIlII, lllllllllllllIIIIIIllIIIlIIIlIII, lllllllllllllIIIIIIllIIIlIIIIlll);
                }
            }
            else {
                final boolean lllllllllllllIIIIIIllIIIlIIIIIll = lllllllllllllIIIIIIllIIIlIIIIlII == EnumHandSide.RIGHT;
                if (lllllllllllllIIIIIIllIIIlIIIllII.isHandActive() && lllllllllllllIIIIIIllIIIlIIIllII.getItemInUseCount() > 0 && lllllllllllllIIIIIIllIIIlIIIllII.getActiveHand() == lllllllllllllIIIIIIllIIIIlllIIIl) {
                    final int lllllllllllllIIIIIIllIIIlIIIIIlI = lllllllllllllIIIIIIllIIIlIIIIIll ? 1 : -1;
                    switch ($SWITCH_TABLE$net$minecraft$item$EnumAction()[lllllllllllllIIIIIIllIIIlIIIIlll.getItemUseAction().ordinal()]) {
                        case 1: {
                            this.transformSideFirstPerson(lllllllllllllIIIIIIllIIIlIIIIlII, lllllllllllllIIIIIIllIIIlIIIIllI);
                            break;
                        }
                        case 2:
                        case 3: {
                            this.transformEatFirstPerson(lllllllllllllIIIIIIllIIIlIIIlIll, lllllllllllllIIIIIIllIIIlIIIIlII, lllllllllllllIIIIIIllIIIlIIIIlll);
                            this.transformSideFirstPerson(lllllllllllllIIIIIIllIIIlIIIIlII, lllllllllllllIIIIIIllIIIlIIIIllI);
                            break;
                        }
                        case 4: {
                            this.transformSideFirstPerson(lllllllllllllIIIIIIllIIIlIIIIlII, lllllllllllllIIIIIIllIIIlIIIIllI);
                            break;
                        }
                        case 5: {
                            this.transformSideFirstPerson(lllllllllllllIIIIIIllIIIlIIIIlII, lllllllllllllIIIIIIllIIIlIIIIllI);
                            GlStateManager.translate(lllllllllllllIIIIIIllIIIlIIIIIlI * -0.2785682f, 0.18344387f, 0.15731531f);
                            GlStateManager.rotate(-13.935f, 1.0f, 0.0f, 0.0f);
                            GlStateManager.rotate(lllllllllllllIIIIIIllIIIlIIIIIlI * 35.3f, 0.0f, 1.0f, 0.0f);
                            GlStateManager.rotate(lllllllllllllIIIIIIllIIIlIIIIIlI * -9.785f, 0.0f, 0.0f, 1.0f);
                            final float lllllllllllllIIIIIIllIIIlIIIIIIl = lllllllllllllIIIIIIllIIIlIIIIlll.getMaxItemUseDuration() - (this.mc.player.getItemInUseCount() - lllllllllllllIIIIIIllIIIlIIIlIll + 1.0f);
                            float lllllllllllllIIIIIIllIIIlIIIIIII = lllllllllllllIIIIIIllIIIlIIIIIIl / 20.0f;
                            lllllllllllllIIIIIIllIIIlIIIIIII = (lllllllllllllIIIIIIllIIIlIIIIIII * lllllllllllllIIIIIIllIIIlIIIIIII + lllllllllllllIIIIIIllIIIlIIIIIII * 2.0f) / 3.0f;
                            if (lllllllllllllIIIIIIllIIIlIIIIIII > 1.0f) {
                                lllllllllllllIIIIIIllIIIlIIIIIII = 1.0f;
                            }
                            if (lllllllllllllIIIIIIllIIIlIIIIIII > 0.1f) {
                                final float lllllllllllllIIIIIIllIIIIlllllll = MathHelper.sin((lllllllllllllIIIIIIllIIIlIIIIIIl - 0.1f) * 1.3f);
                                final float lllllllllllllIIIIIIllIIIIllllllI = lllllllllllllIIIIIIllIIIlIIIIIII - 0.1f;
                                final float lllllllllllllIIIIIIllIIIIlllllIl = lllllllllllllIIIIIIllIIIIlllllll * lllllllllllllIIIIIIllIIIIllllllI;
                                GlStateManager.translate(lllllllllllllIIIIIIllIIIIlllllIl * 0.0f, lllllllllllllIIIIIIllIIIIlllllIl * 0.004f, lllllllllllllIIIIIIllIIIIlllllIl * 0.0f);
                            }
                            GlStateManager.translate(lllllllllllllIIIIIIllIIIlIIIIIII * 0.0f, lllllllllllllIIIIIIllIIIlIIIIIII * 0.0f, lllllllllllllIIIIIIllIIIlIIIIIII * 0.04f);
                            GlStateManager.scale(1.0f, 1.0f, 1.0f + lllllllllllllIIIIIIllIIIlIIIIIII * 0.2f);
                            GlStateManager.rotate(lllllllllllllIIIIIIllIIIlIIIIIlI * 45.0f, 0.0f, -1.0f, 0.0f);
                            break;
                        }
                    }
                }
                else {
                    final float lllllllllllllIIIIIIllIIIIlllllII = -0.4f * MathHelper.sin(MathHelper.sqrt(lllllllllllllIIIIIIllIIIlIIIlIII) * 3.1415927f);
                    final float lllllllllllllIIIIIIllIIIIllllIll = 0.2f * MathHelper.sin(MathHelper.sqrt(lllllllllllllIIIIIIllIIIlIIIlIII) * 6.2831855f);
                    final float lllllllllllllIIIIIIllIIIIllllIlI = -0.2f * MathHelper.sin(lllllllllllllIIIIIIllIIIlIIIlIII * 3.1415927f);
                    final int lllllllllllllIIIIIIllIIIIllllIIl = lllllllllllllIIIIIIllIIIlIIIIIll ? 1 : -1;
                    GlStateManager.translate(lllllllllllllIIIIIIllIIIIllllIIl * lllllllllllllIIIIIIllIIIIlllllII, lllllllllllllIIIIIIllIIIIllllIll, lllllllllllllIIIIIIllIIIIllllIlI);
                    this.transformSideFirstPerson(lllllllllllllIIIIIIllIIIlIIIIlII, lllllllllllllIIIIIIllIIIlIIIIllI);
                    this.transformFirstPerson(lllllllllllllIIIIIIllIIIlIIIIlII, lllllllllllllIIIIIIllIIIlIIIlIII);
                }
                final Killaura lllllllllllllIIIIIIllIIIIllllIII = (Killaura)Main.moduleManager.get(Killaura.class);
                for (final Entity lllllllllllllIIIIIIllIIIIlllIlll : this.mc.world.loadedEntityList) {
                    if (lllllllllllllIIIIIIllIIIIlllIlll != this.mc.player && !lllllllllllllIIIIIIllIIIIlllIlll.isDead && lllllllllllllIIIIIIllIIIIllllIII.isToggled() && lllllllllllllIIIIIIllIIIIllllIII.hitAnimation.getValBoolean() && this.mc.player.getDistanceToEntity(lllllllllllllIIIIIIllIIIIlllIlll) < 4.0f && lllllllllllllIIIIIIllIIIIlllIlll != null && lllllllllllllIIIIIIllIIIlIIIIlll.getItem() instanceof ItemSword) {
                        final int lllllllllllllIIIIIIllIIIIlllIllI = (lllllllllllllIIIIIIllIIIlIIIllII.getPrimaryHand() == EnumHandSide.RIGHT) ? 1 : -1;
                        GlStateManager.translate(lllllllllllllIIIIIIllIIIIlllIllI * -0.14142136f, 0.18f, 0.14142136f);
                        GlStateManager.rotate(-102.25f, 1.0f, 0.0f, 0.0f);
                        GlStateManager.rotate(lllllllllllllIIIIIIllIIIIlllIllI * 5.365f, 0.0f, 1.0f, 0.0f);
                        GlStateManager.rotate(lllllllllllllIIIIIIllIIIIlllIllI * 78.05f, 0.0f, 0.0f, 1.0f);
                    }
                }
                this.renderItemSide(lllllllllllllIIIIIIllIIIlIIIllII, lllllllllllllIIIIIIllIIIlIIIIlll, lllllllllllllIIIIIIllIIIlIIIIIll ? ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND : ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND, !lllllllllllllIIIIIIllIIIlIIIIIll);
            }
            GlStateManager.popMatrix();
        }
    }
    
    private void transformFirstPerson(final EnumHandSide lllllllllllllIIIIIIllIIIllIlIIlI, final float lllllllllllllIIIIIIllIIIllIlIIIl) {
        final int lllllllllllllIIIIIIllIIIllIlIlIl = (lllllllllllllIIIIIIllIIIllIlIIlI == EnumHandSide.RIGHT) ? 1 : -1;
        final float lllllllllllllIIIIIIllIIIllIlIlII = MathHelper.sin(lllllllllllllIIIIIIllIIIllIlIIIl * lllllllllllllIIIIIIllIIIllIlIIIl * 3.1415927f);
        GlStateManager.rotate(lllllllllllllIIIIIIllIIIllIlIlIl * (45.0f + lllllllllllllIIIIIIllIIIllIlIlII * -20.0f), 0.0f, 1.0f, 0.0f);
        final float lllllllllllllIIIIIIllIIIllIlIIll = MathHelper.sin(MathHelper.sqrt(lllllllllllllIIIIIIllIIIllIlIIIl) * 3.1415927f);
        GlStateManager.rotate(lllllllllllllIIIIIIllIIIllIlIlIl * lllllllllllllIIIIIIllIIIllIlIIll * -20.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(lllllllllllllIIIIIIllIIIllIlIIll * -80.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(lllllllllllllIIIIIIllIIIllIlIlIl * -45.0f, 0.0f, 1.0f, 0.0f);
    }
    
    public void resetEquippedProgress(final EnumHand lllllllllllllIIIIIIlIllllIlIlllI) {
        if (lllllllllllllIIIIIIlIllllIlIlllI == EnumHand.MAIN_HAND) {
            this.equippedProgressMainHand = 0.0f;
        }
        else {
            this.equippedProgressOffHand = 0.0f;
        }
    }
    
    private void rotateArroundXAndY(final float lllllllllllllIIIIIIllIIllIlIIllI, final float lllllllllllllIIIIIIllIIllIlIIlIl) {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(lllllllllllllIIIIIIllIIllIlIIllI, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(lllllllllllllIIIIIIllIIllIlIIlIl, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.popMatrix();
    }
    
    public ItemRenderer(final Minecraft lllllllllllllIIIIIIllIIlllIlIIII) {
        this.itemStackMainHand = ItemStack.field_190927_a;
        this.itemStackOffHand = ItemStack.field_190927_a;
        this.mc = lllllllllllllIIIIIIllIIlllIlIIII;
        this.renderManager = lllllllllllllIIIIIIllIIlllIlIIII.getRenderManager();
        this.itemRenderer = lllllllllllllIIIIIIllIIlllIlIIII.getRenderItem();
    }
    
    public void renderItemInFirstPerson(final float lllllllllllllIIIIIIllIIIlIlIlIII) {
        final AbstractClientPlayer lllllllllllllIIIIIIllIIIlIllIllI = this.mc.player;
        final float lllllllllllllIIIIIIllIIIlIllIlIl = lllllllllllllIIIIIIllIIIlIllIllI.getSwingProgress(lllllllllllllIIIIIIllIIIlIlIlIII);
        final EnumHand lllllllllllllIIIIIIllIIIlIllIlII = (EnumHand)MoreObjects.firstNonNull((Object)lllllllllllllIIIIIIllIIIlIllIllI.swingingHand, (Object)EnumHand.MAIN_HAND);
        final float lllllllllllllIIIIIIllIIIlIllIIll = lllllllllllllIIIIIIllIIIlIllIllI.prevRotationPitch + (lllllllllllllIIIIIIllIIIlIllIllI.rotationPitch - lllllllllllllIIIIIIllIIIlIllIllI.prevRotationPitch) * lllllllllllllIIIIIIllIIIlIlIlIII;
        final float lllllllllllllIIIIIIllIIIlIllIIlI = lllllllllllllIIIIIIllIIIlIllIllI.prevRotationYaw + (lllllllllllllIIIIIIllIIIlIllIllI.rotationYaw - lllllllllllllIIIIIIllIIIlIllIllI.prevRotationYaw) * lllllllllllllIIIIIIllIIIlIlIlIII;
        boolean lllllllllllllIIIIIIllIIIlIllIIIl = true;
        boolean lllllllllllllIIIIIIllIIIlIllIIII = true;
        if (lllllllllllllIIIIIIllIIIlIllIllI.isHandActive()) {
            final ItemStack lllllllllllllIIIIIIllIIIlIlIllll = lllllllllllllIIIIIIllIIIlIllIllI.getActiveItemStack();
            if (!lllllllllllllIIIIIIllIIIlIlIllll.func_190926_b() && lllllllllllllIIIIIIllIIIlIlIllll.getItem() == Items.BOW) {
                final EnumHand lllllllllllllIIIIIIllIIIlIlIlllI = lllllllllllllIIIIIIllIIIlIllIllI.getActiveHand();
                lllllllllllllIIIIIIllIIIlIllIIIl = (lllllllllllllIIIIIIllIIIlIlIlllI == EnumHand.MAIN_HAND);
                lllllllllllllIIIIIIllIIIlIllIIII = !lllllllllllllIIIIIIllIIIlIllIIIl;
            }
        }
        this.rotateArroundXAndY(lllllllllllllIIIIIIllIIIlIllIIll, lllllllllllllIIIIIIllIIIlIllIIlI);
        this.setLightmap();
        this.rotateArm(lllllllllllllIIIIIIllIIIlIlIlIII);
        GlStateManager.enableRescaleNormal();
        if (lllllllllllllIIIIIIllIIIlIllIIIl) {
            final float lllllllllllllIIIIIIllIIIlIlIllIl = (lllllllllllllIIIIIIllIIIlIllIlII == EnumHand.MAIN_HAND) ? lllllllllllllIIIIIIllIIIlIllIlIl : 0.0f;
            final float lllllllllllllIIIIIIllIIIlIlIllII = 1.0f - (this.prevEquippedProgressMainHand + (this.equippedProgressMainHand - this.prevEquippedProgressMainHand) * lllllllllllllIIIIIIllIIIlIlIlIII);
            if (!Reflector.ForgeHooksClient_renderSpecificFirstPersonHand.exists() || !Reflector.callBoolean(Reflector.ForgeHooksClient_renderSpecificFirstPersonHand, EnumHand.MAIN_HAND, lllllllllllllIIIIIIllIIIlIlIlIII, lllllllllllllIIIIIIllIIIlIllIIll, lllllllllllllIIIIIIllIIIlIlIllIl, lllllllllllllIIIIIIllIIIlIlIllII, this.itemStackMainHand)) {
                this.renderItemInFirstPerson(lllllllllllllIIIIIIllIIIlIllIllI, lllllllllllllIIIIIIllIIIlIlIlIII, lllllllllllllIIIIIIllIIIlIllIIll, EnumHand.MAIN_HAND, lllllllllllllIIIIIIllIIIlIlIllIl, this.itemStackMainHand, lllllllllllllIIIIIIllIIIlIlIllII);
            }
        }
        if (lllllllllllllIIIIIIllIIIlIllIIII) {
            final float lllllllllllllIIIIIIllIIIlIlIlIll = (lllllllllllllIIIIIIllIIIlIllIlII == EnumHand.OFF_HAND) ? lllllllllllllIIIIIIllIIIlIllIlIl : 0.0f;
            final float lllllllllllllIIIIIIllIIIlIlIlIlI = 1.0f - (this.prevEquippedProgressOffHand + (this.equippedProgressOffHand - this.prevEquippedProgressOffHand) * lllllllllllllIIIIIIllIIIlIlIlIII);
            if (!Reflector.ForgeHooksClient_renderSpecificFirstPersonHand.exists() || !Reflector.callBoolean(Reflector.ForgeHooksClient_renderSpecificFirstPersonHand, EnumHand.OFF_HAND, lllllllllllllIIIIIIllIIIlIlIlIII, lllllllllllllIIIIIIllIIIlIllIIll, lllllllllllllIIIIIIllIIIlIlIlIll, lllllllllllllIIIIIIllIIIlIlIlIlI, this.itemStackOffHand)) {
                this.renderItemInFirstPerson(lllllllllllllIIIIIIllIIIlIllIllI, lllllllllllllIIIIIIllIIIlIlIlIII, lllllllllllllIIIIIIllIIIlIllIIll, EnumHand.OFF_HAND, lllllllllllllIIIIIIllIIIlIlIlIll, this.itemStackOffHand, lllllllllllllIIIIIIllIIIlIlIlIlI);
            }
        }
        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
    }
    
    public void updateEquippedItem() {
        this.prevEquippedProgressMainHand = this.equippedProgressMainHand;
        this.prevEquippedProgressOffHand = this.equippedProgressOffHand;
        final EntityPlayerSP lllllllllllllIIIIIIlIllllIlllllI = this.mc.player;
        final ItemStack lllllllllllllIIIIIIlIllllIllllIl = lllllllllllllIIIIIIlIllllIlllllI.getHeldItemMainhand();
        final ItemStack lllllllllllllIIIIIIlIllllIllllII = lllllllllllllIIIIIIlIllllIlllllI.getHeldItemOffhand();
        if (lllllllllllllIIIIIIlIllllIlllllI.isRowingBoat()) {
            this.equippedProgressMainHand = MathHelper.clamp(this.equippedProgressMainHand - 0.4f, 0.0f, 1.0f);
            this.equippedProgressOffHand = MathHelper.clamp(this.equippedProgressOffHand - 0.4f, 0.0f, 1.0f);
        }
        else {
            final float lllllllllllllIIIIIIlIllllIlllIll = lllllllllllllIIIIIIlIllllIlllllI.getCooledAttackStrength(1.0f);
            if (Reflector.ForgeHooksClient_shouldCauseReequipAnimation.exists()) {
                final boolean lllllllllllllIIIIIIlIllllIlllIlI = Reflector.callBoolean(Reflector.ForgeHooksClient_shouldCauseReequipAnimation, this.itemStackMainHand, lllllllllllllIIIIIIlIllllIllllIl, lllllllllllllIIIIIIlIllllIlllllI.inventory.currentItem);
                final boolean lllllllllllllIIIIIIlIllllIlllIIl = Reflector.callBoolean(Reflector.ForgeHooksClient_shouldCauseReequipAnimation, this.itemStackOffHand, lllllllllllllIIIIIIlIllllIllllII, -1);
                if (!lllllllllllllIIIIIIlIllllIlllIlI && !Objects.equals(this.itemStackMainHand, lllllllllllllIIIIIIlIllllIllllIl)) {
                    this.itemStackMainHand = lllllllllllllIIIIIIlIllllIllllIl;
                }
                if (!lllllllllllllIIIIIIlIllllIlllIlI && !Objects.equals(this.itemStackOffHand, lllllllllllllIIIIIIlIllllIllllII)) {
                    this.itemStackOffHand = lllllllllllllIIIIIIlIllllIllllII;
                }
                this.equippedProgressMainHand += MathHelper.clamp((lllllllllllllIIIIIIlIllllIlllIlI ? 0.0f : (lllllllllllllIIIIIIlIllllIlllIll * lllllllllllllIIIIIIlIllllIlllIll * lllllllllllllIIIIIIlIllllIlllIll)) - this.equippedProgressMainHand, -0.4f, 0.4f);
                this.equippedProgressOffHand += MathHelper.clamp((float)(lllllllllllllIIIIIIlIllllIlllIIl ? 0 : 1) - this.equippedProgressOffHand, -0.4f, 0.4f);
            }
            else {
                this.equippedProgressMainHand += MathHelper.clamp((Objects.equals(this.itemStackMainHand, lllllllllllllIIIIIIlIllllIllllIl) ? (lllllllllllllIIIIIIlIllllIlllIll * lllllllllllllIIIIIIlIllllIlllIll * lllllllllllllIIIIIIlIllllIlllIll) : 0.0f) - this.equippedProgressMainHand, -0.4f, 0.4f);
                this.equippedProgressOffHand += MathHelper.clamp((float)(Objects.equals(this.itemStackOffHand, lllllllllllllIIIIIIlIllllIllllII) ? 1 : 0) - this.equippedProgressOffHand, -0.4f, 0.4f);
            }
        }
        if (this.equippedProgressMainHand < 0.1f) {
            this.itemStackMainHand = lllllllllllllIIIIIIlIllllIllllIl;
            if (Config.isShaders()) {
                Shaders.setItemToRenderMain(this.itemStackMainHand);
            }
        }
        if (this.equippedProgressOffHand < 0.1f) {
            this.itemStackOffHand = lllllllllllllIIIIIIlIllllIllllII;
            if (Config.isShaders()) {
                Shaders.setItemToRenderOff(this.itemStackOffHand);
            }
        }
    }
    
    private void renderBlockInHand(final TextureAtlasSprite lllllllllllllIIIIIIllIIIIIllIIll) {
        this.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        final Tessellator lllllllllllllIIIIIIllIIIIIllIIlI = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIIIIIllIIIIIllIIIl = lllllllllllllIIIIIIllIIIIIllIIlI.getBuffer();
        final float lllllllllllllIIIIIIllIIIIIllIIII = 0.1f;
        GlStateManager.color(0.1f, 0.1f, 0.1f, 0.5f);
        GlStateManager.pushMatrix();
        final float lllllllllllllIIIIIIllIIIIIlIllll = -1.0f;
        final float lllllllllllllIIIIIIllIIIIIlIlllI = 1.0f;
        final float lllllllllllllIIIIIIllIIIIIlIllIl = -1.0f;
        final float lllllllllllllIIIIIIllIIIIIlIllII = 1.0f;
        final float lllllllllllllIIIIIIllIIIIIlIlIll = -0.5f;
        final float lllllllllllllIIIIIIllIIIIIlIlIlI = lllllllllllllIIIIIIllIIIIIllIIll.getMinU();
        final float lllllllllllllIIIIIIllIIIIIlIlIIl = lllllllllllllIIIIIIllIIIIIllIIll.getMaxU();
        final float lllllllllllllIIIIIIllIIIIIlIlIII = lllllllllllllIIIIIIllIIIIIllIIll.getMinV();
        final float lllllllllllllIIIIIIllIIIIIlIIlll = lllllllllllllIIIIIIllIIIIIllIIll.getMaxV();
        lllllllllllllIIIIIIllIIIIIllIIIl.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIIIIIIllIIIIIllIIIl.pos(-1.0, -1.0, -0.5).tex(lllllllllllllIIIIIIllIIIIIlIlIIl, lllllllllllllIIIIIIllIIIIIlIIlll).endVertex();
        lllllllllllllIIIIIIllIIIIIllIIIl.pos(1.0, -1.0, -0.5).tex(lllllllllllllIIIIIIllIIIIIlIlIlI, lllllllllllllIIIIIIllIIIIIlIIlll).endVertex();
        lllllllllllllIIIIIIllIIIIIllIIIl.pos(1.0, 1.0, -0.5).tex(lllllllllllllIIIIIIllIIIIIlIlIlI, lllllllllllllIIIIIIllIIIIIlIlIII).endVertex();
        lllllllllllllIIIIIIllIIIIIllIIIl.pos(-1.0, 1.0, -0.5).tex(lllllllllllllIIIIIIllIIIIIlIlIIl, lllllllllllllIIIIIIllIIIIIlIlIII).endVertex();
        lllllllllllllIIIIIIllIIIIIllIIlI.draw();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    public void renderItemSide(final EntityLivingBase lllllllllllllIIIIIIllIIllIllIIII, final ItemStack lllllllllllllIIIIIIllIIllIllIlll, final ItemCameraTransforms.TransformType lllllllllllllIIIIIIllIIllIllIllI, final boolean lllllllllllllIIIIIIllIIllIllIlIl) {
        if (!lllllllllllllIIIIIIllIIllIllIlll.func_190926_b()) {
            final Item lllllllllllllIIIIIIllIIllIllIlII = lllllllllllllIIIIIIllIIllIllIlll.getItem();
            final Block lllllllllllllIIIIIIllIIllIllIIll = Block.getBlockFromItem(lllllllllllllIIIIIIllIIllIllIlII);
            GlStateManager.pushMatrix();
            final boolean lllllllllllllIIIIIIllIIllIllIIlI = this.itemRenderer.shouldRenderItemIn3D(lllllllllllllIIIIIIllIIllIllIlll) && lllllllllllllIIIIIIllIIllIllIIll.getBlockLayer() == BlockRenderLayer.TRANSLUCENT;
            if (lllllllllllllIIIIIIllIIllIllIIlI && (!Config.isShaders() || !Shaders.renderItemKeepDepthMask)) {
                GlStateManager.depthMask(false);
            }
            this.itemRenderer.renderItem(lllllllllllllIIIIIIllIIllIllIlll, lllllllllllllIIIIIIllIIllIllIIII, lllllllllllllIIIIIIllIIllIllIllI, lllllllllllllIIIIIIllIIllIllIlIl);
            if (lllllllllllllIIIIIIllIIllIllIIlI) {
                GlStateManager.depthMask(true);
            }
            GlStateManager.popMatrix();
        }
    }
    
    private void renderWaterOverlayTexture(final float lllllllllllllIIIIIIllIIIIIIIlIll) {
        if (!Config.isShaders() || Shaders.isUnderwaterOverlay()) {
            this.mc.getTextureManager().bindTexture(ItemRenderer.RES_UNDERWATER_OVERLAY);
            final Tessellator lllllllllllllIIIIIIllIIIIIIIlIlI = Tessellator.getInstance();
            final BufferBuilder lllllllllllllIIIIIIllIIIIIIIlIIl = lllllllllllllIIIIIIllIIIIIIIlIlI.getBuffer();
            final float lllllllllllllIIIIIIllIIIIIIIlIII = this.mc.player.getBrightness();
            GlStateManager.color(lllllllllllllIIIIIIllIIIIIIIlIII, lllllllllllllIIIIIIllIIIIIIIlIII, lllllllllllllIIIIIIllIIIIIIIlIII, 0.5f);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.pushMatrix();
            final float lllllllllllllIIIIIIllIIIIIIIIlll = 4.0f;
            final float lllllllllllllIIIIIIllIIIIIIIIllI = -1.0f;
            final float lllllllllllllIIIIIIllIIIIIIIIlIl = 1.0f;
            final float lllllllllllllIIIIIIllIIIIIIIIlII = -1.0f;
            final float lllllllllllllIIIIIIllIIIIIIIIIll = 1.0f;
            final float lllllllllllllIIIIIIllIIIIIIIIIlI = -0.5f;
            final float lllllllllllllIIIIIIllIIIIIIIIIIl = -this.mc.player.rotationYaw / 64.0f;
            final float lllllllllllllIIIIIIllIIIIIIIIIII = this.mc.player.rotationPitch / 64.0f;
            lllllllllllllIIIIIIllIIIIIIIlIIl.begin(7, DefaultVertexFormats.POSITION_TEX);
            lllllllllllllIIIIIIllIIIIIIIlIIl.pos(-1.0, -1.0, -0.5).tex(4.0f + lllllllllllllIIIIIIllIIIIIIIIIIl, 4.0f + lllllllllllllIIIIIIllIIIIIIIIIII).endVertex();
            lllllllllllllIIIIIIllIIIIIIIlIIl.pos(1.0, -1.0, -0.5).tex(0.0f + lllllllllllllIIIIIIllIIIIIIIIIIl, 4.0f + lllllllllllllIIIIIIllIIIIIIIIIII).endVertex();
            lllllllllllllIIIIIIllIIIIIIIlIIl.pos(1.0, 1.0, -0.5).tex(0.0f + lllllllllllllIIIIIIllIIIIIIIIIIl, 0.0f + lllllllllllllIIIIIIllIIIIIIIIIII).endVertex();
            lllllllllllllIIIIIIllIIIIIIIlIIl.pos(-1.0, 1.0, -0.5).tex(4.0f + lllllllllllllIIIIIIllIIIIIIIIIIl, 0.0f + lllllllllllllIIIIIIllIIIIIIIIIII).endVertex();
            lllllllllllllIIIIIIllIIIIIIIlIlI.draw();
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableBlend();
        }
    }
    
    private void renderArm(final EnumHandSide lllllllllllllIIIIIIllIIlIlllIlII) {
        this.mc.getTextureManager().bindTexture(this.mc.player.getLocationSkin());
        final Render<AbstractClientPlayer> lllllllllllllIIIIIIllIIlIlllIIll = this.renderManager.getEntityRenderObject(this.mc.player);
        final RenderPlayer lllllllllllllIIIIIIllIIlIlllIIlI = (RenderPlayer)lllllllllllllIIIIIIllIIlIlllIIll;
        GlStateManager.pushMatrix();
        final float lllllllllllllIIIIIIllIIlIlllIIIl = (lllllllllllllIIIIIIllIIlIlllIlII == EnumHandSide.RIGHT) ? 1.0f : -1.0f;
        GlStateManager.rotate(92.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(45.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(lllllllllllllIIIIIIllIIlIlllIIIl * -41.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.translate(lllllllllllllIIIIIIllIIlIlllIIIl * 0.3f, -1.1f, 0.45f);
        if (lllllllllllllIIIIIIllIIlIlllIlII == EnumHandSide.RIGHT) {
            lllllllllllllIIIIIIllIIlIlllIIlI.renderRightArm(this.mc.player);
        }
        else {
            lllllllllllllIIIIIIllIIlIlllIIlI.renderLeftArm(this.mc.player);
        }
        GlStateManager.popMatrix();
    }
    
    private void renderMapFirstPersonSide(final float lllllllllllllIIIIIIllIIlIlIlllll, final EnumHandSide lllllllllllllIIIIIIllIIlIlIllllI, final float lllllllllllllIIIIIIllIIlIlIlllIl, final ItemStack lllllllllllllIIIIIIllIIlIlIlIIIl) {
        final float lllllllllllllIIIIIIllIIlIlIllIll = (lllllllllllllIIIIIIllIIlIlIllllI == EnumHandSide.RIGHT) ? 1.0f : -1.0f;
        GlStateManager.translate(lllllllllllllIIIIIIllIIlIlIllIll * 0.125f, -0.125f, 0.0f);
        if (!this.mc.player.isInvisible()) {
            GlStateManager.pushMatrix();
            GlStateManager.rotate(lllllllllllllIIIIIIllIIlIlIllIll * 10.0f, 0.0f, 0.0f, 1.0f);
            this.renderArmFirstPerson(lllllllllllllIIIIIIllIIlIlIlllll, lllllllllllllIIIIIIllIIlIlIlllIl, lllllllllllllIIIIIIllIIlIlIllllI);
            GlStateManager.popMatrix();
        }
        GlStateManager.pushMatrix();
        GlStateManager.translate(lllllllllllllIIIIIIllIIlIlIllIll * 0.51f, -0.08f + lllllllllllllIIIIIIllIIlIlIlllll * -1.2f, -0.75f);
        final float lllllllllllllIIIIIIllIIlIlIllIlI = MathHelper.sqrt(lllllllllllllIIIIIIllIIlIlIlllIl);
        final float lllllllllllllIIIIIIllIIlIlIllIIl = MathHelper.sin(lllllllllllllIIIIIIllIIlIlIllIlI * 3.1415927f);
        final float lllllllllllllIIIIIIllIIlIlIllIII = -0.5f * lllllllllllllIIIIIIllIIlIlIllIIl;
        final float lllllllllllllIIIIIIllIIlIlIlIlll = 0.4f * MathHelper.sin(lllllllllllllIIIIIIllIIlIlIllIlI * 6.2831855f);
        final float lllllllllllllIIIIIIllIIlIlIlIllI = -0.3f * MathHelper.sin(lllllllllllllIIIIIIllIIlIlIlllIl * 3.1415927f);
        GlStateManager.translate(lllllllllllllIIIIIIllIIlIlIllIll * lllllllllllllIIIIIIllIIlIlIllIII, lllllllllllllIIIIIIllIIlIlIlIlll - 0.3f * lllllllllllllIIIIIIllIIlIlIllIIl, lllllllllllllIIIIIIllIIlIlIlIllI);
        GlStateManager.rotate(lllllllllllllIIIIIIllIIlIlIllIIl * -45.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(lllllllllllllIIIIIIllIIlIlIllIll * lllllllllllllIIIIIIllIIlIlIllIIl * -30.0f, 0.0f, 1.0f, 0.0f);
        this.renderMapFirstPerson(lllllllllllllIIIIIIllIIlIlIlIIIl);
        GlStateManager.popMatrix();
    }
    
    private void renderArmFirstPerson(final float lllllllllllllIIIIIIllIIlIIIIIIll, final float lllllllllllllIIIIIIllIIlIIIIIIlI, final EnumHandSide lllllllllllllIIIIIIllIIlIIIIllll) {
        final boolean lllllllllllllIIIIIIllIIlIIIIlllI = lllllllllllllIIIIIIllIIlIIIIllll != EnumHandSide.LEFT;
        final float lllllllllllllIIIIIIllIIlIIIIllIl = lllllllllllllIIIIIIllIIlIIIIlllI ? 1.0f : -1.0f;
        final float lllllllllllllIIIIIIllIIlIIIIllII = MathHelper.sqrt(lllllllllllllIIIIIIllIIlIIIIIIlI);
        final float lllllllllllllIIIIIIllIIlIIIIlIll = -0.3f * MathHelper.sin(lllllllllllllIIIIIIllIIlIIIIllII * 3.1415927f);
        final float lllllllllllllIIIIIIllIIlIIIIlIlI = 0.4f * MathHelper.sin(lllllllllllllIIIIIIllIIlIIIIllII * 6.2831855f);
        final float lllllllllllllIIIIIIllIIlIIIIlIIl = -0.4f * MathHelper.sin(lllllllllllllIIIIIIllIIlIIIIIIlI * 3.1415927f);
        GlStateManager.translate(lllllllllllllIIIIIIllIIlIIIIllIl * (lllllllllllllIIIIIIllIIlIIIIlIll + 0.64000005f), lllllllllllllIIIIIIllIIlIIIIlIlI - 0.6f + lllllllllllllIIIIIIllIIlIIIIIIll * -0.6f, lllllllllllllIIIIIIllIIlIIIIlIIl - 0.71999997f);
        GlStateManager.rotate(lllllllllllllIIIIIIllIIlIIIIllIl * 45.0f, 0.0f, 1.0f, 0.0f);
        final float lllllllllllllIIIIIIllIIlIIIIlIII = MathHelper.sin(lllllllllllllIIIIIIllIIlIIIIIIlI * lllllllllllllIIIIIIllIIlIIIIIIlI * 3.1415927f);
        final float lllllllllllllIIIIIIllIIlIIIIIlll = MathHelper.sin(lllllllllllllIIIIIIllIIlIIIIllII * 3.1415927f);
        GlStateManager.rotate(lllllllllllllIIIIIIllIIlIIIIllIl * lllllllllllllIIIIIIllIIlIIIIIlll * 70.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(lllllllllllllIIIIIIllIIlIIIIllIl * lllllllllllllIIIIIIllIIlIIIIlIII * -20.0f, 0.0f, 0.0f, 1.0f);
        final AbstractClientPlayer lllllllllllllIIIIIIllIIlIIIIIllI = this.mc.player;
        this.mc.getTextureManager().bindTexture(lllllllllllllIIIIIIllIIlIIIIIllI.getLocationSkin());
        GlStateManager.translate(lllllllllllllIIIIIIllIIlIIIIllIl * -1.0f, 3.6f, 3.5f);
        GlStateManager.rotate(lllllllllllllIIIIIIllIIlIIIIllIl * 120.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.rotate(200.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(lllllllllllllIIIIIIllIIlIIIIllIl * -135.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.translate(lllllllllllllIIIIIIllIIlIIIIllIl * 5.6f, 0.0f, 0.0f);
        final RenderPlayer lllllllllllllIIIIIIllIIlIIIIIlIl = (RenderPlayer)this.renderManager.getEntityRenderObject(lllllllllllllIIIIIIllIIlIIIIIllI);
        GlStateManager.disableCull();
        if (lllllllllllllIIIIIIllIIlIIIIlllI) {
            lllllllllllllIIIIIIllIIlIIIIIlIl.renderRightArm(lllllllllllllIIIIIIllIIlIIIIIllI);
        }
        else {
            lllllllllllllIIIIIIllIIlIIIIIlIl.renderLeftArm(lllllllllllllIIIIIIllIIlIIIIIllI);
        }
        GlStateManager.enableCull();
    }
    
    private void transformEatFirstPerson(final float lllllllllllllIIIIIIllIIIlllIllIl, final EnumHandSide lllllllllllllIIIIIIllIIIlllIllII, final ItemStack lllllllllllllIIIIIIllIIIlllIIIlI) {
        final float lllllllllllllIIIIIIllIIIlllIlIlI = this.mc.player.getItemInUseCount() - lllllllllllllIIIIIIllIIIlllIllIl + 1.0f;
        final float lllllllllllllIIIIIIllIIIlllIlIIl = lllllllllllllIIIIIIllIIIlllIlIlI / lllllllllllllIIIIIIllIIIlllIIIlI.getMaxItemUseDuration();
        if (lllllllllllllIIIIIIllIIIlllIlIIl < 0.8f) {
            final float lllllllllllllIIIIIIllIIIlllIlIII = MathHelper.abs(MathHelper.cos(lllllllllllllIIIIIIllIIIlllIlIlI / 4.0f * 3.1415927f) * 0.1f);
            GlStateManager.translate(0.0f, lllllllllllllIIIIIIllIIIlllIlIII, 0.0f);
        }
        final float lllllllllllllIIIIIIllIIIlllIIlll = 1.0f - (float)Math.pow(lllllllllllllIIIIIIllIIIlllIlIIl, 27.0);
        final int lllllllllllllIIIIIIllIIIlllIIllI = (lllllllllllllIIIIIIllIIIlllIllII == EnumHandSide.RIGHT) ? 1 : -1;
        GlStateManager.translate(lllllllllllllIIIIIIllIIIlllIIlll * 0.6f * lllllllllllllIIIIIIllIIIlllIIllI, lllllllllllllIIIIIIllIIIlllIIlll * -0.5f, lllllllllllllIIIIIIllIIIlllIIlll * 0.0f);
        GlStateManager.rotate(lllllllllllllIIIIIIllIIIlllIIllI * lllllllllllllIIIIIIllIIIlllIIlll * 90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(lllllllllllllIIIIIIllIIIlllIIlll * 10.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(lllllllllllllIIIIIIllIIIlllIIllI * lllllllllllllIIIIIIllIIIlllIIlll * 30.0f, 0.0f, 0.0f, 1.0f);
    }
    
    private float getMapAngleFromPitch(final float lllllllllllllIIIIIIllIIlIlllllll) {
        float lllllllllllllIIIIIIllIIllIIIIIII = 1.0f - lllllllllllllIIIIIIllIIlIlllllll / 45.0f + 0.1f;
        lllllllllllllIIIIIIllIIllIIIIIII = MathHelper.clamp(lllllllllllllIIIIIIllIIllIIIIIII, 0.0f, 1.0f);
        lllllllllllllIIIIIIllIIllIIIIIII = -MathHelper.cos(lllllllllllllIIIIIIllIIllIIIIIII * 3.1415927f) * 0.5f + 0.5f;
        return lllllllllllllIIIIIIllIIllIIIIIII;
    }
    
    private void setLightmap() {
        final AbstractClientPlayer lllllllllllllIIIIIIllIIllIIlllII = this.mc.player;
        int lllllllllllllIIIIIIllIIllIIllIll = this.mc.world.getCombinedLight(new BlockPos(lllllllllllllIIIIIIllIIllIIlllII.posX, lllllllllllllIIIIIIllIIllIIlllII.posY + lllllllllllllIIIIIIllIIllIIlllII.getEyeHeight(), lllllllllllllIIIIIIllIIllIIlllII.posZ), 0);
        if (Config.isDynamicLights()) {
            lllllllllllllIIIIIIllIIllIIllIll = DynamicLights.getCombinedLight(this.mc.getRenderViewEntity(), lllllllllllllIIIIIIllIIllIIllIll);
        }
        final float lllllllllllllIIIIIIllIIllIIllIlI = (float)(lllllllllllllIIIIIIllIIllIIllIll & 0xFFFF);
        final float lllllllllllllIIIIIIllIIllIIllIIl = (float)(lllllllllllllIIIIIIllIIllIIllIll >> 16);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lllllllllllllIIIIIIllIIllIIllIlI, lllllllllllllIIIIIIllIIllIIllIIl);
    }
    
    private void renderFireInFirstPerson() {
        final Tessellator lllllllllllllIIIIIIlIllllllIIIll = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIIIIIlIllllllIIIlI = lllllllllllllIIIIIIlIllllllIIIll.getBuffer();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 0.9f);
        GlStateManager.depthFunc(519);
        GlStateManager.depthMask(false);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        final float lllllllllllllIIIIIIlIllllllIIIIl = 1.0f;
        for (int lllllllllllllIIIIIIlIllllllIIIII = 0; lllllllllllllIIIIIIlIllllllIIIII < 2; ++lllllllllllllIIIIIIlIllllllIIIII) {
            GlStateManager.pushMatrix();
            final TextureAtlasSprite lllllllllllllIIIIIIlIlllllIlllll = this.mc.getTextureMapBlocks().getAtlasSprite("minecraft:blocks/fire_layer_1");
            this.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            final float lllllllllllllIIIIIIlIlllllIllllI = lllllllllllllIIIIIIlIlllllIlllll.getMinU();
            final float lllllllllllllIIIIIIlIlllllIlllIl = lllllllllllllIIIIIIlIlllllIlllll.getMaxU();
            final float lllllllllllllIIIIIIlIlllllIlllII = lllllllllllllIIIIIIlIlllllIlllll.getMinV();
            final float lllllllllllllIIIIIIlIlllllIllIll = lllllllllllllIIIIIIlIlllllIlllll.getMaxV();
            final float lllllllllllllIIIIIIlIlllllIllIlI = -0.5f;
            final float lllllllllllllIIIIIIlIlllllIllIIl = 0.5f;
            final float lllllllllllllIIIIIIlIlllllIllIII = -0.5f;
            final float lllllllllllllIIIIIIlIlllllIlIlll = 0.5f;
            final float lllllllllllllIIIIIIlIlllllIlIllI = -0.5f;
            GlStateManager.translate(-(lllllllllllllIIIIIIlIllllllIIIII * 2 - 1) * 0.24f, -0.3f, 0.0f);
            GlStateManager.rotate((lllllllllllllIIIIIIlIllllllIIIII * 2 - 1) * 10.0f, 0.0f, 1.0f, 0.0f);
            lllllllllllllIIIIIIlIllllllIIIlI.begin(7, DefaultVertexFormats.POSITION_TEX);
            lllllllllllllIIIIIIlIllllllIIIlI.pos(-0.5, -0.5, -0.5).tex(lllllllllllllIIIIIIlIlllllIlllIl, lllllllllllllIIIIIIlIlllllIllIll).endVertex();
            lllllllllllllIIIIIIlIllllllIIIlI.pos(0.5, -0.5, -0.5).tex(lllllllllllllIIIIIIlIlllllIllllI, lllllllllllllIIIIIIlIlllllIllIll).endVertex();
            lllllllllllllIIIIIIlIllllllIIIlI.pos(0.5, 0.5, -0.5).tex(lllllllllllllIIIIIIlIlllllIllllI, lllllllllllllIIIIIIlIlllllIlllII).endVertex();
            lllllllllllllIIIIIIlIllllllIIIlI.pos(-0.5, 0.5, -0.5).tex(lllllllllllllIIIIIIlIlllllIlllIl, lllllllllllllIIIIIIlIlllllIlllII).endVertex();
            lllllllllllllIIIIIIlIllllllIIIll.draw();
            GlStateManager.popMatrix();
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.depthFunc(515);
    }
    
    static {
        RES_MAP_BACKGROUND = new ResourceLocation("textures/map/map_background.png");
        RES_UNDERWATER_OVERLAY = new ResourceLocation("textures/misc/underwater.png");
    }
    
    private void renderMapFirstPerson(final ItemStack lllllllllllllIIIIIIllIIlIIlIIlII) {
        GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        GlStateManager.scale(0.38f, 0.38f, 0.38f);
        GlStateManager.disableLighting();
        this.mc.getTextureManager().bindTexture(ItemRenderer.RES_MAP_BACKGROUND);
        final Tessellator lllllllllllllIIIIIIllIIlIIlIlIII = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIIIIIllIIlIIlIIlll = lllllllllllllIIIIIIllIIlIIlIlIII.getBuffer();
        GlStateManager.translate(-0.5f, -0.5f, 0.0f);
        GlStateManager.scale(0.0078125f, 0.0078125f, 0.0078125f);
        lllllllllllllIIIIIIllIIlIIlIIlll.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIIIIIIllIIlIIlIIlll.pos(-7.0, 135.0, 0.0).tex(0.0, 1.0).endVertex();
        lllllllllllllIIIIIIllIIlIIlIIlll.pos(135.0, 135.0, 0.0).tex(1.0, 1.0).endVertex();
        lllllllllllllIIIIIIllIIlIIlIIlll.pos(135.0, -7.0, 0.0).tex(1.0, 0.0).endVertex();
        lllllllllllllIIIIIIllIIlIIlIIlll.pos(-7.0, -7.0, 0.0).tex(0.0, 0.0).endVertex();
        lllllllllllllIIIIIIllIIlIIlIlIII.draw();
        final MapData lllllllllllllIIIIIIllIIlIIlIIllI = ReflectorForge.getMapData(Items.FILLED_MAP, lllllllllllllIIIIIIllIIlIIlIIlII, this.mc.world);
        if (lllllllllllllIIIIIIllIIlIIlIIllI != null) {
            this.mc.entityRenderer.getMapItemRenderer().renderMap(lllllllllllllIIIIIIllIIlIIlIIllI, false);
        }
        GlStateManager.enableLighting();
    }
    
    public void renderItem(final EntityLivingBase lllllllllllllIIIIIIllIIlllIIIlII, final ItemStack lllllllllllllIIIIIIllIIlllIIIIll, final ItemCameraTransforms.TransformType lllllllllllllIIIIIIllIIlllIIIllI) {
        this.renderItemSide(lllllllllllllIIIIIIllIIlllIIIlII, lllllllllllllIIIIIIllIIlllIIIIll, lllllllllllllIIIIIIllIIlllIIIllI, false);
    }
}
