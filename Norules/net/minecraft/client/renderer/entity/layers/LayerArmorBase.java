package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.inventory.*;
import shadersmod.client.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import com.google.common.collect.*;
import net.minecraft.item.*;
import optifine.*;

public abstract class LayerArmorBase<T extends ModelBase> implements LayerRenderer<EntityLivingBase>
{
    private final /* synthetic */ RenderLivingBase<?> renderer;
    private /* synthetic */ float alpha;
    private /* synthetic */ boolean skipRenderGlint;
    protected /* synthetic */ T modelLeggings;
    private /* synthetic */ float colorR;
    private /* synthetic */ float colorB;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial;
    protected /* synthetic */ T modelArmor;
    private /* synthetic */ float colorG;
    protected static final /* synthetic */ ResourceLocation ENCHANTED_ITEM_GLINT_RES;
    private static final /* synthetic */ Map<String, ResourceLocation> ARMOR_TEXTURE_RES_MAP;
    
    public T getModelFromSlot(final EntityEquipmentSlot lllllllllllllIIIllIlIIlIIIIIIlIl) {
        return this.isLegSlot(lllllllllllllIIIllIlIIlIIIIIIlIl) ? this.modelLeggings : this.modelArmor;
    }
    
    protected abstract void setModelSlotVisible(final T p0, final EntityEquipmentSlot p1);
    
    private boolean isLegSlot(final EntityEquipmentSlot lllllllllllllIIIllIlIIlIIIIIIIlI) {
        return lllllllllllllIIIllIlIIlIIIIIIIlI == EntityEquipmentSlot.LEGS;
    }
    
    public LayerArmorBase(final RenderLivingBase<?> lllllllllllllIIIllIlIIlIIllIIIIl) {
        this.alpha = 1.0f;
        this.colorR = 1.0f;
        this.colorG = 1.0f;
        this.colorB = 1.0f;
        this.renderer = lllllllllllllIIIllIlIIlIIllIIIIl;
        this.initArmor();
    }
    
    protected abstract void initArmor();
    
    private ResourceLocation getArmorResource(final ItemArmor lllllllllllllIIIllIlIIIlllIIIlII, final boolean lllllllllllllIIIllIlIIIllIlllllI, final String lllllllllllllIIIllIlIIIllIllllIl) {
        final String lllllllllllllIIIllIlIIIlllIIIIIl = String.format("textures/models/armor/%s_layer_%d%s.png", lllllllllllllIIIllIlIIIlllIIIlII.getArmorMaterial().getName(), lllllllllllllIIIllIlIIIllIlllllI ? 2 : 1, (lllllllllllllIIIllIlIIIllIllllIl == null) ? "" : String.format("_%s", lllllllllllllIIIllIlIIIllIllllIl));
        ResourceLocation lllllllllllllIIIllIlIIIlllIIIIII = LayerArmorBase.ARMOR_TEXTURE_RES_MAP.get(lllllllllllllIIIllIlIIIlllIIIIIl);
        if (lllllllllllllIIIllIlIIIlllIIIIII == null) {
            lllllllllllllIIIllIlIIIlllIIIIII = new ResourceLocation(lllllllllllllIIIllIlIIIlllIIIIIl);
            LayerArmorBase.ARMOR_TEXTURE_RES_MAP.put(lllllllllllllIIIllIlIIIlllIIIIIl, lllllllllllllIIIllIlIIIlllIIIIII);
        }
        return lllllllllllllIIIllIlIIIlllIIIIII;
    }
    
    public static void renderEnchantedGlint(final RenderLivingBase<?> lllllllllllllIIIllIlIIIlllllIIIl, final EntityLivingBase lllllllllllllIIIllIlIIIlllllIIII, final ModelBase lllllllllllllIIIllIlIIIllllIllll, final float lllllllllllllIIIllIlIIIlllIlllll, final float lllllllllllllIIIllIlIIIllllIllIl, final float lllllllllllllIIIllIlIIIlllIlllIl, final float lllllllllllllIIIllIlIIIlllIlllII, final float lllllllllllllIIIllIlIIIllllIlIlI, final float lllllllllllllIIIllIlIIIlllIllIlI, final float lllllllllllllIIIllIlIIIlllIllIIl) {
        if (!Config.isShaders() || !Shaders.isShadowPass) {
            final float lllllllllllllIIIllIlIIIllllIIlll = lllllllllllllIIIllIlIIIlllllIIII.ticksExisted + lllllllllllllIIIllIlIIIlllIlllIl;
            lllllllllllllIIIllIlIIIlllllIIIl.bindTexture(LayerArmorBase.ENCHANTED_ITEM_GLINT_RES);
            if (Config.isShaders()) {
                ShadersRender.renderEnchantedGlintBegin();
            }
            Minecraft.getMinecraft().entityRenderer.func_191514_d(true);
            GlStateManager.enableBlend();
            GlStateManager.depthFunc(514);
            GlStateManager.depthMask(false);
            final float lllllllllllllIIIllIlIIIllllIIllI = 0.5f;
            GlStateManager.color(0.5f, 0.5f, 0.5f, 1.0f);
            for (int lllllllllllllIIIllIlIIIllllIIlIl = 0; lllllllllllllIIIllIlIIIllllIIlIl < 2; ++lllllllllllllIIIllIlIIIllllIIlIl) {
                GlStateManager.disableLighting();
                GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_COLOR, GlStateManager.DestFactor.ONE);
                final float lllllllllllllIIIllIlIIIllllIIlII = 0.76f;
                GlStateManager.color(0.38f, 0.19f, 0.608f, 1.0f);
                GlStateManager.matrixMode(5890);
                GlStateManager.loadIdentity();
                final float lllllllllllllIIIllIlIIIllllIIIll = 0.33333334f;
                GlStateManager.scale(0.33333334f, 0.33333334f, 0.33333334f);
                GlStateManager.rotate(30.0f - lllllllllllllIIIllIlIIIllllIIlIl * 60.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.translate(0.0f, lllllllllllllIIIllIlIIIllllIIlll * (0.001f + lllllllllllllIIIllIlIIIllllIIlIl * 0.003f) * 20.0f, 0.0f);
                GlStateManager.matrixMode(5888);
                lllllllllllllIIIllIlIIIllllIllll.render(lllllllllllllIIIllIlIIIlllllIIII, lllllllllllllIIIllIlIIIlllIlllll, lllllllllllllIIIllIlIIIllllIllIl, lllllllllllllIIIllIlIIIlllIlllII, lllllllllllllIIIllIlIIIllllIlIlI, lllllllllllllIIIllIlIIIlllIllIlI, lllllllllllllIIIllIlIIIlllIllIIl);
                GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            }
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.depthMask(true);
            GlStateManager.depthFunc(515);
            GlStateManager.disableBlend();
            Minecraft.getMinecraft().entityRenderer.func_191514_d(false);
            if (Config.isShaders()) {
                ShadersRender.renderEnchantedGlintEnd();
            }
        }
    }
    
    private ResourceLocation getArmorResource(final ItemArmor lllllllllllllIIIllIlIIIlllIIllII, final boolean lllllllllllllIIIllIlIIIlllIIlIll) {
        return this.getArmorResource(lllllllllllllIIIllIlIIIlllIIllII, lllllllllllllIIIllIlIIIlllIIlIll, null);
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase lllllllllllllIIIllIlIIlIIlIlIllI, final float lllllllllllllIIIllIlIIlIIlIlIlIl, final float lllllllllllllIIIllIlIIlIIlIIlIll, final float lllllllllllllIIIllIlIIlIIlIIlIlI, final float lllllllllllllIIIllIlIIlIIlIlIIlI, final float lllllllllllllIIIllIlIIlIIlIlIIIl, final float lllllllllllllIIIllIlIIlIIlIlIIII, final float lllllllllllllIIIllIlIIlIIlIIIllI) {
        this.renderArmorLayer(lllllllllllllIIIllIlIIlIIlIlIllI, lllllllllllllIIIllIlIIlIIlIlIlIl, lllllllllllllIIIllIlIIlIIlIIlIll, lllllllllllllIIIllIlIIlIIlIIlIlI, lllllllllllllIIIllIlIIlIIlIlIIlI, lllllllllllllIIIllIlIIlIIlIlIIIl, lllllllllllllIIIllIlIIlIIlIlIIII, lllllllllllllIIIllIlIIlIIlIIIllI, EntityEquipmentSlot.CHEST);
        this.renderArmorLayer(lllllllllllllIIIllIlIIlIIlIlIllI, lllllllllllllIIIllIlIIlIIlIlIlIl, lllllllllllllIIIllIlIIlIIlIIlIll, lllllllllllllIIIllIlIIlIIlIIlIlI, lllllllllllllIIIllIlIIlIIlIlIIlI, lllllllllllllIIIllIlIIlIIlIlIIIl, lllllllllllllIIIllIlIIlIIlIlIIII, lllllllllllllIIIllIlIIlIIlIIIllI, EntityEquipmentSlot.LEGS);
        this.renderArmorLayer(lllllllllllllIIIllIlIIlIIlIlIllI, lllllllllllllIIIllIlIIlIIlIlIlIl, lllllllllllllIIIllIlIIlIIlIIlIll, lllllllllllllIIIllIlIIlIIlIIlIlI, lllllllllllllIIIllIlIIlIIlIlIIlI, lllllllllllllIIIllIlIIlIIlIlIIIl, lllllllllllllIIIllIlIIlIIlIlIIII, lllllllllllllIIIllIlIIlIIlIIIllI, EntityEquipmentSlot.FEET);
        this.renderArmorLayer(lllllllllllllIIIllIlIIlIIlIlIllI, lllllllllllllIIIllIlIIlIIlIlIlIl, lllllllllllllIIIllIlIIlIIlIIlIll, lllllllllllllIIIllIlIIlIIlIIlIlI, lllllllllllllIIIllIlIIlIIlIlIIlI, lllllllllllllIIIllIlIIlIIlIlIIIl, lllllllllllllIIIllIlIIlIIlIlIIII, lllllllllllllIIIllIlIIlIIlIIIllI, EntityEquipmentSlot.HEAD);
    }
    
    static {
        ENCHANTED_ITEM_GLINT_RES = new ResourceLocation("textures/misc/enchanted_item_glint.png");
        ARMOR_TEXTURE_RES_MAP = Maps.newHashMap();
    }
    
    protected T getArmorModelHook(final EntityLivingBase lllllllllllllIIIllIlIIIllIlllIII, final ItemStack lllllllllllllIIIllIlIIIllIllIlll, final EntityEquipmentSlot lllllllllllllIIIllIlIIIllIllIllI, final T lllllllllllllIIIllIlIIIllIllIlIl) {
        return lllllllllllllIIIllIlIIIllIllIlIl;
    }
    
    public ResourceLocation getArmorResource(final Entity lllllllllllllIIIllIlIIIllIIlllII, final ItemStack lllllllllllllIIIllIlIIIllIlIIllI, final EntityEquipmentSlot lllllllllllllIIIllIlIIIllIIllIlI, final String lllllllllllllIIIllIlIIIllIlIIlII) {
        final ItemArmor lllllllllllllIIIllIlIIIllIlIIIll = (ItemArmor)lllllllllllllIIIllIlIIIllIlIIllI.getItem();
        String lllllllllllllIIIllIlIIIllIlIIIlI = lllllllllllllIIIllIlIIIllIlIIIll.getArmorMaterial().getName();
        String lllllllllllllIIIllIlIIIllIlIIIIl = "minecraft";
        final int lllllllllllllIIIllIlIIIllIlIIIII = lllllllllllllIIIllIlIIIllIlIIIlI.indexOf(58);
        if (lllllllllllllIIIllIlIIIllIlIIIII != -1) {
            lllllllllllllIIIllIlIIIllIlIIIIl = lllllllllllllIIIllIlIIIllIlIIIlI.substring(0, lllllllllllllIIIllIlIIIllIlIIIII);
            lllllllllllllIIIllIlIIIllIlIIIlI = lllllllllllllIIIllIlIIIllIlIIIlI.substring(lllllllllllllIIIllIlIIIllIlIIIII + 1);
        }
        String lllllllllllllIIIllIlIIIllIIlllll = String.format("%s:textures/models/armor/%s_layer_%d%s.png", lllllllllllllIIIllIlIIIllIlIIIIl, lllllllllllllIIIllIlIIIllIlIIIlI, this.isLegSlot(lllllllllllllIIIllIlIIIllIIllIlI) ? 2 : 1, (lllllllllllllIIIllIlIIIllIlIIlII == null) ? "" : String.format("_%s", lllllllllllllIIIllIlIIIllIlIIlII));
        lllllllllllllIIIllIlIIIllIIlllll = Reflector.callString(Reflector.ForgeHooksClient_getArmorTexture, lllllllllllllIIIllIlIIIllIIlllII, lllllllllllllIIIllIlIIIllIlIIllI, lllllllllllllIIIllIlIIIllIIlllll, lllllllllllllIIIllIlIIIllIIllIlI, lllllllllllllIIIllIlIIIllIlIIlII);
        ResourceLocation lllllllllllllIIIllIlIIIllIIllllI = LayerArmorBase.ARMOR_TEXTURE_RES_MAP.get(lllllllllllllIIIllIlIIIllIIlllll);
        if (lllllllllllllIIIllIlIIIllIIllllI == null) {
            lllllllllllllIIIllIlIIIllIIllllI = new ResourceLocation(lllllllllllllIIIllIlIIIllIIlllll);
            LayerArmorBase.ARMOR_TEXTURE_RES_MAP.put(lllllllllllllIIIllIlIIIllIIlllll, lllllllllllllIIIllIlIIIllIIllllI);
        }
        return lllllllllllllIIIllIlIIIllIIllllI;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    private void renderArmorLayer(final EntityLivingBase lllllllllllllIIIllIlIIlIIIIllIll, final float lllllllllllllIIIllIlIIlIIIIllIlI, final float lllllllllllllIIIllIlIIlIIIIllIIl, final float lllllllllllllIIIllIlIIlIIIlIlllI, final float lllllllllllllIIIllIlIIlIIIlIllIl, final float lllllllllllllIIIllIlIIlIIIlIllII, final float lllllllllllllIIIllIlIIlIIIIlIlIl, final float lllllllllllllIIIllIlIIlIIIlIlIlI, final EntityEquipmentSlot lllllllllllllIIIllIlIIlIIIIlIIll) {
        final ItemStack lllllllllllllIIIllIlIIlIIIlIlIII = lllllllllllllIIIllIlIIlIIIIllIll.getItemStackFromSlot(lllllllllllllIIIllIlIIlIIIIlIIll);
        if (lllllllllllllIIIllIlIIlIIIlIlIII.getItem() instanceof ItemArmor) {
            final ItemArmor lllllllllllllIIIllIlIIlIIIlIIlll = (ItemArmor)lllllllllllllIIIllIlIIlIIIlIlIII.getItem();
            if (lllllllllllllIIIllIlIIlIIIlIIlll.getEquipmentSlot() == lllllllllllllIIIllIlIIlIIIIlIIll) {
                T lllllllllllllIIIllIlIIlIIIlIIllI = this.getModelFromSlot(lllllllllllllIIIllIlIIlIIIIlIIll);
                if (Reflector.ForgeHooksClient.exists()) {
                    lllllllllllllIIIllIlIIlIIIlIIllI = this.getArmorModelHook(lllllllllllllIIIllIlIIlIIIIllIll, lllllllllllllIIIllIlIIlIIIlIlIII, lllllllllllllIIIllIlIIlIIIIlIIll, lllllllllllllIIIllIlIIlIIIlIIllI);
                }
                lllllllllllllIIIllIlIIlIIIlIIllI.setModelAttributes(this.renderer.getMainModel());
                lllllllllllllIIIllIlIIlIIIlIIllI.setLivingAnimations(lllllllllllllIIIllIlIIlIIIIllIll, lllllllllllllIIIllIlIIlIIIIllIlI, lllllllllllllIIIllIlIIlIIIIllIIl, lllllllllllllIIIllIlIIlIIIlIlllI);
                this.setModelSlotVisible(lllllllllllllIIIllIlIIlIIIlIIllI, lllllllllllllIIIllIlIIlIIIIlIIll);
                final boolean lllllllllllllIIIllIlIIlIIIlIIlIl = this.isLegSlot(lllllllllllllIIIllIlIIlIIIIlIIll);
                if (!Config.isCustomItems() || !CustomItems.bindCustomArmorTexture(lllllllllllllIIIllIlIIlIIIlIlIII, lllllllllllllIIIllIlIIlIIIIlIIll, null)) {
                    if (Reflector.ForgeHooksClient_getArmorTexture.exists()) {
                        this.renderer.bindTexture(this.getArmorResource(lllllllllllllIIIllIlIIlIIIIllIll, lllllllllllllIIIllIlIIlIIIlIlIII, lllllllllllllIIIllIlIIlIIIIlIIll, null));
                    }
                    else {
                        this.renderer.bindTexture(this.getArmorResource(lllllllllllllIIIllIlIIlIIIlIIlll, lllllllllllllIIIllIlIIlIIIlIIlIl));
                    }
                }
                if (Reflector.ForgeHooksClient_getArmorTexture.exists()) {
                    if (ReflectorForge.armorHasOverlay(lllllllllllllIIIllIlIIlIIIlIIlll, lllllllllllllIIIllIlIIlIIIlIlIII)) {
                        final int lllllllllllllIIIllIlIIlIIIlIIlII = lllllllllllllIIIllIlIIlIIIlIIlll.getColor(lllllllllllllIIIllIlIIlIIIlIlIII);
                        final float lllllllllllllIIIllIlIIlIIIlIIIll = (lllllllllllllIIIllIlIIlIIIlIIlII >> 16 & 0xFF) / 255.0f;
                        final float lllllllllllllIIIllIlIIlIIIlIIIlI = (lllllllllllllIIIllIlIIlIIIlIIlII >> 8 & 0xFF) / 255.0f;
                        final float lllllllllllllIIIllIlIIlIIIlIIIIl = (lllllllllllllIIIllIlIIlIIIlIIlII & 0xFF) / 255.0f;
                        GlStateManager.color(this.colorR * lllllllllllllIIIllIlIIlIIIlIIIll, this.colorG * lllllllllllllIIIllIlIIlIIIlIIIlI, this.colorB * lllllllllllllIIIllIlIIlIIIlIIIIl, this.alpha);
                        lllllllllllllIIIllIlIIlIIIlIIllI.render(lllllllllllllIIIllIlIIlIIIIllIll, lllllllllllllIIIllIlIIlIIIIllIlI, lllllllllllllIIIllIlIIlIIIIllIIl, lllllllllllllIIIllIlIIlIIIlIllIl, lllllllllllllIIIllIlIIlIIIlIllII, lllllllllllllIIIllIlIIlIIIIlIlIl, lllllllllllllIIIllIlIIlIIIlIlIlI);
                        if (!Config.isCustomItems() || !CustomItems.bindCustomArmorTexture(lllllllllllllIIIllIlIIlIIIlIlIII, lllllllllllllIIIllIlIIlIIIIlIIll, "overlay")) {
                            this.renderer.bindTexture(this.getArmorResource(lllllllllllllIIIllIlIIlIIIIllIll, lllllllllllllIIIllIlIIlIIIlIlIII, lllllllllllllIIIllIlIIlIIIIlIIll, "overlay"));
                        }
                    }
                    GlStateManager.color(this.colorR, this.colorG, this.colorB, this.alpha);
                    lllllllllllllIIIllIlIIlIIIlIIllI.render(lllllllllllllIIIllIlIIlIIIIllIll, lllllllllllllIIIllIlIIlIIIIllIlI, lllllllllllllIIIllIlIIlIIIIllIIl, lllllllllllllIIIllIlIIlIIIlIllIl, lllllllllllllIIIllIlIIlIIIlIllII, lllllllllllllIIIllIlIIlIIIIlIlIl, lllllllllllllIIIllIlIIlIIIlIlIlI);
                    if (!this.skipRenderGlint && lllllllllllllIIIllIlIIlIIIlIlIII.hasEffect() && (!Config.isCustomItems() || !CustomItems.renderCustomArmorEffect(lllllllllllllIIIllIlIIlIIIIllIll, lllllllllllllIIIllIlIIlIIIlIlIII, lllllllllllllIIIllIlIIlIIIlIIllI, lllllllllllllIIIllIlIIlIIIIllIlI, lllllllllllllIIIllIlIIlIIIIllIIl, lllllllllllllIIIllIlIIlIIIlIlllI, lllllllllllllIIIllIlIIlIIIlIllIl, lllllllllllllIIIllIlIIlIIIlIllII, lllllllllllllIIIllIlIIlIIIIlIlIl, lllllllllllllIIIllIlIIlIIIlIlIlI))) {
                        renderEnchantedGlint(this.renderer, lllllllllllllIIIllIlIIlIIIIllIll, lllllllllllllIIIllIlIIlIIIlIIllI, lllllllllllllIIIllIlIIlIIIIllIlI, lllllllllllllIIIllIlIIlIIIIllIIl, lllllllllllllIIIllIlIIlIIIlIlllI, lllllllllllllIIIllIlIIlIIIlIllIl, lllllllllllllIIIllIlIIlIIIlIllII, lllllllllllllIIIllIlIIlIIIIlIlIl, lllllllllllllIIIllIlIIlIIIlIlIlI);
                    }
                    return;
                }
                switch ($SWITCH_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial()[lllllllllllllIIIllIlIIlIIIlIIlll.getArmorMaterial().ordinal()]) {
                    case 1: {
                        final int lllllllllllllIIIllIlIIlIIIlIIIII = lllllllllllllIIIllIlIIlIIIlIIlll.getColor(lllllllllllllIIIllIlIIlIIIlIlIII);
                        final float lllllllllllllIIIllIlIIlIIIIlllll = (lllllllllllllIIIllIlIIlIIIlIIIII >> 16 & 0xFF) / 255.0f;
                        final float lllllllllllllIIIllIlIIlIIIIllllI = (lllllllllllllIIIllIlIIlIIIlIIIII >> 8 & 0xFF) / 255.0f;
                        final float lllllllllllllIIIllIlIIlIIIIlllIl = (lllllllllllllIIIllIlIIlIIIlIIIII & 0xFF) / 255.0f;
                        GlStateManager.color(this.colorR * lllllllllllllIIIllIlIIlIIIIlllll, this.colorG * lllllllllllllIIIllIlIIlIIIIllllI, this.colorB * lllllllllllllIIIllIlIIlIIIIlllIl, this.alpha);
                        lllllllllllllIIIllIlIIlIIIlIIllI.render(lllllllllllllIIIllIlIIlIIIIllIll, lllllllllllllIIIllIlIIlIIIIllIlI, lllllllllllllIIIllIlIIlIIIIllIIl, lllllllllllllIIIllIlIIlIIIlIllIl, lllllllllllllIIIllIlIIlIIIlIllII, lllllllllllllIIIllIlIIlIIIIlIlIl, lllllllllllllIIIllIlIIlIIIlIlIlI);
                        if (!Config.isCustomItems() || !CustomItems.bindCustomArmorTexture(lllllllllllllIIIllIlIIlIIIlIlIII, lllllllllllllIIIllIlIIlIIIIlIIll, "overlay")) {
                            this.renderer.bindTexture(this.getArmorResource(lllllllllllllIIIllIlIIlIIIlIIlll, lllllllllllllIIIllIlIIlIIIlIIlIl, "overlay"));
                        }
                    }
                    case 2:
                    case 3:
                    case 4:
                    case 5: {
                        GlStateManager.color(this.colorR, this.colorG, this.colorB, this.alpha);
                        lllllllllllllIIIllIlIIlIIIlIIllI.render(lllllllllllllIIIllIlIIlIIIIllIll, lllllllllllllIIIllIlIIlIIIIllIlI, lllllllllllllIIIllIlIIlIIIIllIIl, lllllllllllllIIIllIlIIlIIIlIllIl, lllllllllllllIIIllIlIIlIIIlIllII, lllllllllllllIIIllIlIIlIIIIlIlIl, lllllllllllllIIIllIlIIlIIIlIlIlI);
                        break;
                    }
                }
                if (!this.skipRenderGlint && lllllllllllllIIIllIlIIlIIIlIlIII.isItemEnchanted() && (!Config.isCustomItems() || !CustomItems.renderCustomArmorEffect(lllllllllllllIIIllIlIIlIIIIllIll, lllllllllllllIIIllIlIIlIIIlIlIII, lllllllllllllIIIllIlIIlIIIlIIllI, lllllllllllllIIIllIlIIlIIIIllIlI, lllllllllllllIIIllIlIIlIIIIllIIl, lllllllllllllIIIllIlIIlIIIlIlllI, lllllllllllllIIIllIlIIlIIIlIllIl, lllllllllllllIIIllIlIIlIIIlIllII, lllllllllllllIIIllIlIIlIIIIlIlIl, lllllllllllllIIIllIlIIlIIIlIlIlI))) {
                    renderEnchantedGlint(this.renderer, lllllllllllllIIIllIlIIlIIIIllIll, lllllllllllllIIIllIlIIlIIIlIIllI, lllllllllllllIIIllIlIIlIIIIllIlI, lllllllllllllIIIllIlIIlIIIIllIIl, lllllllllllllIIIllIlIIlIIIlIlllI, lllllllllllllIIIllIlIIlIIIlIllIl, lllllllllllllIIIllIlIIlIIIlIllII, lllllllllllllIIIllIlIIlIIIIlIlIl, lllllllllllllIIIllIlIIlIIIlIlIlI);
                }
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial() {
        final int[] $switch_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial = LayerArmorBase.$SWITCH_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial;
        if ($switch_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial != null) {
            return $switch_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial;
        }
        final char lllllllllllllIIIllIlIIIllIIlIIIl = (Object)new int[ItemArmor.ArmorMaterial.values().length];
        try {
            lllllllllllllIIIllIlIIIllIIlIIIl[ItemArmor.ArmorMaterial.CHAIN.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIIllIlIIIllIIlIIIl[ItemArmor.ArmorMaterial.DIAMOND.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIIllIlIIIllIIlIIIl[ItemArmor.ArmorMaterial.GOLD.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIIllIlIIIllIIlIIIl[ItemArmor.ArmorMaterial.IRON.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIIllIlIIIllIIlIIIl[ItemArmor.ArmorMaterial.LEATHER.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        return LayerArmorBase.$SWITCH_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial = (int[])(Object)lllllllllllllIIIllIlIIIllIIlIIIl;
    }
}
