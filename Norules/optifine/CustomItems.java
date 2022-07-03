package optifine;

import net.minecraft.client.model.*;
import shadersmod.client.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.renderer.*;
import net.minecraft.inventory.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.potion.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import java.util.*;

public class CustomItems
{
    private static /* synthetic */ ItemModelGenerator itemModelGenerator;
    private static /* synthetic */ boolean renderOffHand;
    private static /* synthetic */ CustomItemProperties[][] itemProperties;
    private static /* synthetic */ boolean useGlint;
    private static /* synthetic */ CustomItemProperties[][] enchantmentProperties;
    private static final /* synthetic */ int[][] EMPTY_INT2_ARRAY;
    private static /* synthetic */ Map mapPotionIds;
    private static final /* synthetic */ Map<String, Integer> mapPotionDamages;
    
    public static boolean renderCustomArmorEffect(final EntityLivingBase lllllllllllllIllllIlIlIIIlIlllII, final ItemStack lllllllllllllIllllIlIlIIIlIIIlIl, final ModelBase lllllllllllllIllllIlIlIIIlIIIlII, final float lllllllllllllIllllIlIlIIIlIIIIll, final float lllllllllllllIllllIlIlIIIlIIIIlI, final float lllllllllllllIllllIlIlIIIlIlIlll, final float lllllllllllllIllllIlIlIIIlIIIIIl, final float lllllllllllllIllllIlIlIIIlIIIIII, final float lllllllllllllIllllIlIlIIIIllllll, final float lllllllllllllIllllIlIlIIIIlllllI) {
        if (CustomItems.enchantmentProperties == null) {
            return false;
        }
        if (Config.isShaders() && Shaders.isShadowPass) {
            return false;
        }
        if (lllllllllllllIllllIlIlIIIlIIIlIl == null) {
            return false;
        }
        final int[][] lllllllllllllIllllIlIlIIIlIlIIlI = getEnchantmentIdLevels(lllllllllllllIllllIlIlIIIlIIIlIl);
        if (lllllllllllllIllllIlIlIIIlIlIIlI.length <= 0) {
            return false;
        }
        Set lllllllllllllIllllIlIlIIIlIlIIIl = null;
        boolean lllllllllllllIllllIlIlIIIlIlIIII = false;
        final TextureManager lllllllllllllIllllIlIlIIIlIIllll = Config.getTextureManager();
        for (int lllllllllllllIllllIlIlIIIlIIlllI = 0; lllllllllllllIllllIlIlIIIlIIlllI < lllllllllllllIllllIlIlIIIlIlIIlI.length; ++lllllllllllllIllllIlIlIIIlIIlllI) {
            final int lllllllllllllIllllIlIlIIIlIIllIl = lllllllllllllIllllIlIlIIIlIlIIlI[lllllllllllllIllllIlIlIIIlIIlllI][0];
            if (lllllllllllllIllllIlIlIIIlIIllIl >= 0 && lllllllllllllIllllIlIlIIIlIIllIl < CustomItems.enchantmentProperties.length) {
                final CustomItemProperties[] lllllllllllllIllllIlIlIIIlIIllII = CustomItems.enchantmentProperties[lllllllllllllIllllIlIlIIIlIIllIl];
                if (lllllllllllllIllllIlIlIIIlIIllII != null) {
                    for (int lllllllllllllIllllIlIlIIIlIIlIll = 0; lllllllllllllIllllIlIlIIIlIIlIll < lllllllllllllIllllIlIlIIIlIIllII.length; ++lllllllllllllIllllIlIlIIIlIIlIll) {
                        final CustomItemProperties lllllllllllllIllllIlIlIIIlIIlIlI = lllllllllllllIllllIlIlIIIlIIllII[lllllllllllllIllllIlIlIIIlIIlIll];
                        if (lllllllllllllIllllIlIlIIIlIlIIIl == null) {
                            lllllllllllllIllllIlIlIIIlIlIIIl = new HashSet();
                        }
                        if (lllllllllllllIllllIlIlIIIlIlIIIl.add(lllllllllllllIllllIlIlIIIlIIllIl) && matchesProperties(lllllllllllllIllllIlIlIIIlIIlIlI, lllllllllllllIllllIlIlIIIlIIIlIl, lllllllllllllIllllIlIlIIIlIlIIlI) && lllllllllllllIllllIlIlIIIlIIlIlI.textureLocation != null) {
                            lllllllllllllIllllIlIlIIIlIIllll.bindTexture(lllllllllllllIllllIlIlIIIlIIlIlI.textureLocation);
                            final float lllllllllllllIllllIlIlIIIlIIlIIl = lllllllllllllIllllIlIlIIIlIIlIlI.getTextureWidth(lllllllllllllIllllIlIlIIIlIIllll);
                            if (!lllllllllllllIllllIlIlIIIlIlIIII) {
                                lllllllllllllIllllIlIlIIIlIlIIII = true;
                                if (Config.isShaders()) {
                                    ShadersRender.renderEnchantedGlintBegin();
                                }
                                GlStateManager.enableBlend();
                                GlStateManager.depthFunc(514);
                                GlStateManager.depthMask(false);
                            }
                            Blender.setupBlend(lllllllllllllIllllIlIlIIIlIIlIlI.blend, 1.0f);
                            GlStateManager.disableLighting();
                            GlStateManager.matrixMode(5890);
                            GlStateManager.loadIdentity();
                            GlStateManager.rotate(lllllllllllllIllllIlIlIIIlIIlIlI.rotation, 0.0f, 0.0f, 1.0f);
                            final float lllllllllllllIllllIlIlIIIlIIlIII = lllllllllllllIllllIlIlIIIlIIlIIl / 8.0f;
                            GlStateManager.scale(lllllllllllllIllllIlIlIIIlIIlIII, lllllllllllllIllllIlIlIIIlIIlIII / 2.0f, lllllllllllllIllllIlIlIIIlIIlIII);
                            final float lllllllllllllIllllIlIlIIIlIIIlll = lllllllllllllIllllIlIlIIIlIIlIlI.speed * (Minecraft.getSystemTime() % 3000L) / 3000.0f / 8.0f;
                            GlStateManager.translate(0.0f, lllllllllllllIllllIlIlIIIlIIIlll, 0.0f);
                            GlStateManager.matrixMode(5888);
                            lllllllllllllIllllIlIlIIIlIIIlII.render(lllllllllllllIllllIlIlIIIlIlllII, lllllllllllllIllllIlIlIIIlIIIIll, lllllllllllllIllllIlIlIIIlIIIIlI, lllllllllllllIllllIlIlIIIlIIIIIl, lllllllllllllIllllIlIlIIIlIIIIII, lllllllllllllIllllIlIlIIIIllllll, lllllllllllllIllllIlIlIIIIlllllI);
                        }
                    }
                }
            }
        }
        if (lllllllllllllIllllIlIlIIIlIlIIII) {
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.depthMask(true);
            GlStateManager.depthFunc(515);
            GlStateManager.disableBlend();
            if (Config.isShaders()) {
                ShadersRender.renderEnchantedGlintEnd();
            }
        }
        return lllllllllllllIllllIlIlIIIlIlIIII;
    }
    
    private static int getPotionDamage(final ItemStack lllllllllllllIllllIlIlIIllIlIlll) {
        final NBTTagCompound lllllllllllllIllllIlIlIIllIlIllI = lllllllllllllIllllIlIlIIllIlIlll.getTagCompound();
        if (lllllllllllllIllllIlIlIIllIlIllI == null) {
            return 0;
        }
        final String lllllllllllllIllllIlIlIIllIlIlIl = lllllllllllllIllllIlIlIIllIlIllI.getString("Potion");
        if (lllllllllllllIllllIlIlIIllIlIlIl == null) {
            return 0;
        }
        final Integer lllllllllllllIllllIlIlIIllIlIlII = CustomItems.mapPotionDamages.get(lllllllllllllIllllIlIlIIllIlIlIl);
        if (lllllllllllllIllllIlIlIIllIlIlII == null) {
            return -1;
        }
        int lllllllllllllIllllIlIlIIllIlIIll = lllllllllllllIllllIlIlIIllIlIlII;
        if (lllllllllllllIllllIlIlIIllIlIlll.getItem() == Items.SPLASH_POTION) {
            lllllllllllllIllllIlIlIIllIlIIll |= 0x4000;
        }
        return lllllllllllllIllllIlIlIIllIlIIll;
    }
    
    public static void updateModels() {
        for (final CustomItemProperties lllllllllllllIllllIlIllIIIIlllIl : getAllProperties()) {
            if (lllllllllllllIllllIlIllIIIIlllIl.type == 1) {
                final TextureMap lllllllllllllIllllIlIllIIIIlllII = Minecraft.getMinecraft().getTextureMapBlocks();
                lllllllllllllIllllIlIllIIIIlllIl.updateModelTexture(lllllllllllllIllllIlIllIIIIlllII, CustomItems.itemModelGenerator);
                lllllllllllllIllllIlIllIIIIlllIl.updateModelsFull();
            }
        }
    }
    
    private static int[] getPotionId(final int lllllllllllllIllllIlIlIllIllIIIl, final int lllllllllllllIllllIlIlIllIllIIlI) {
        return new int[] { lllllllllllllIllllIlIlIllIllIIIl + lllllllllllllIllllIlIlIllIllIIlI * 16 };
    }
    
    private static Map<String, Integer> makeMapPotionDamages() {
        final Map<String, Integer> lllllllllllllIllllIlIlIIllIIllII = new HashMap<String, Integer>();
        addPotion("water", 0, false, lllllllllllllIllllIlIlIIllIIllII);
        addPotion("awkward", 16, false, lllllllllllllIllllIlIlIIllIIllII);
        addPotion("thick", 32, false, lllllllllllllIllllIlIlIIllIIllII);
        addPotion("mundane", 64, false, lllllllllllllIllllIlIlIIllIIllII);
        addPotion("regeneration", 1, true, lllllllllllllIllllIlIlIIllIIllII);
        addPotion("swiftness", 2, true, lllllllllllllIllllIlIlIIllIIllII);
        addPotion("fire_resistance", 3, true, lllllllllllllIllllIlIlIIllIIllII);
        addPotion("poison", 4, true, lllllllllllllIllllIlIlIIllIIllII);
        addPotion("healing", 5, true, lllllllllllllIllllIlIlIIllIIllII);
        addPotion("night_vision", 6, true, lllllllllllllIllllIlIlIIllIIllII);
        addPotion("weakness", 8, true, lllllllllllllIllllIlIlIIllIIllII);
        addPotion("strength", 9, true, lllllllllllllIllllIlIlIIllIIllII);
        addPotion("slowness", 10, true, lllllllllllllIllllIlIlIIllIIllII);
        addPotion("leaping", 11, true, lllllllllllllIllllIlIlIIllIIllII);
        addPotion("harming", 12, true, lllllllllllllIllllIlIlIIllIIllII);
        addPotion("water_breathing", 13, true, lllllllllllllIllllIlIlIIllIIllII);
        addPotion("invisibility", 14, true, lllllllllllllIllllIlIlIIllIIllII);
        return lllllllllllllIllllIlIlIIllIIllII;
    }
    
    public static void updateIcons(final TextureMap lllllllllllllIllllIlIllIIIlIllIl) {
        for (final CustomItemProperties lllllllllllllIllllIlIllIIIlIllII : getAllProperties()) {
            lllllllllllllIllllIlIllIIIlIllII.updateIcons(lllllllllllllIllllIlIllIIIlIllIl);
        }
    }
    
    private static Properties makePotionProperties(final String lllllllllllllIllllIlIlIlllIIlIll, final String lllllllllllllIllllIlIlIllIllllll, int lllllllllllllIllllIlIlIllIlllllI, final String lllllllllllllIllllIlIlIlllIIlIII) {
        if (StrUtils.endsWith(lllllllllllllIllllIlIlIlllIIlIll, new String[] { "_n", "_s" })) {
            return null;
        }
        if (lllllllllllllIllllIlIlIlllIIlIll.equals("empty") && lllllllllllllIllllIlIlIllIllllll.equals("normal")) {
            lllllllllllllIllllIlIlIllIlllllI = Item.getIdFromItem(Items.GLASS_BOTTLE);
            final Properties lllllllllllllIllllIlIlIlllIIIlll = new Properties();
            ((Hashtable<String, String>)lllllllllllllIllllIlIlIlllIIIlll).put("type", "item");
            ((Hashtable<String, String>)lllllllllllllIllllIlIlIlllIIIlll).put("items", String.valueOf(new StringBuilder().append(lllllllllllllIllllIlIlIllIlllllI)));
            return lllllllllllllIllllIlIlIlllIIIlll;
        }
        final int[] lllllllllllllIllllIlIlIlllIIIllI = getMapPotionIds().get(lllllllllllllIllllIlIlIlllIIlIll);
        if (lllllllllllllIllllIlIlIlllIIIllI == null) {
            Config.warn(String.valueOf(new StringBuilder("Potion not found for image: ").append(lllllllllllllIllllIlIlIlllIIlIII)));
            return null;
        }
        final StringBuffer lllllllllllllIllllIlIlIlllIIIlIl = new StringBuffer();
        for (int lllllllllllllIllllIlIlIlllIIIlII = 0; lllllllllllllIllllIlIlIlllIIIlII < lllllllllllllIllllIlIlIlllIIIllI.length; ++lllllllllllllIllllIlIlIlllIIIlII) {
            int lllllllllllllIllllIlIlIlllIIIIll = lllllllllllllIllllIlIlIlllIIIllI[lllllllllllllIllllIlIlIlllIIIlII];
            if (lllllllllllllIllllIlIlIllIllllll.equals("splash")) {
                lllllllllllllIllllIlIlIlllIIIIll |= 0x4000;
            }
            if (lllllllllllllIllllIlIlIlllIIIlII > 0) {
                lllllllllllllIllllIlIlIlllIIIlIl.append(" ");
            }
            lllllllllllllIllllIlIlIlllIIIlIl.append(lllllllllllllIllllIlIlIlllIIIIll);
        }
        int lllllllllllllIllllIlIlIlllIIIIlI = 16447;
        if (lllllllllllllIllllIlIlIlllIIlIll.equals("water") || lllllllllllllIllllIlIlIlllIIlIll.equals("mundane")) {
            lllllllllllllIllllIlIlIlllIIIIlI |= 0x40;
        }
        final Properties lllllllllllllIllllIlIlIlllIIIIIl = new Properties();
        ((Hashtable<String, String>)lllllllllllllIllllIlIlIlllIIIIIl).put("type", "item");
        ((Hashtable<String, String>)lllllllllllllIllllIlIlIlllIIIIIl).put("items", String.valueOf(new StringBuilder().append(lllllllllllllIllllIlIlIllIlllllI)));
        ((Hashtable<String, String>)lllllllllllllIllllIlIlIlllIIIIIl).put("damage", String.valueOf(new StringBuilder().append(lllllllllllllIllllIlIlIlllIIIlIl.toString())));
        ((Hashtable<String, String>)lllllllllllllIllllIlIlIlllIIIIIl).put("damageMask", String.valueOf(new StringBuilder().append(lllllllllllllIllllIlIlIlllIIIIlI)));
        if (lllllllllllllIllllIlIlIllIllllll.equals("splash")) {
            ((Hashtable<String, String>)lllllllllllllIllllIlIlIlllIIIIIl).put("texture.potion_bottle_splash", lllllllllllllIllllIlIlIlllIIlIll);
        }
        else {
            ((Hashtable<String, String>)lllllllllllllIllllIlIlIlllIIIIIl).put("texture.potion_bottle_drinkable", lllllllllllllIllllIlIlIlllIIlIll);
        }
        return lllllllllllllIllllIlIlIlllIIIIIl;
    }
    
    private static void readCitProperties(final String lllllllllllllIllllIlIllIIllIIIIl) {
        try {
            final ResourceLocation lllllllllllllIllllIlIllIIllIIllI = new ResourceLocation(lllllllllllllIllllIlIllIIllIIIIl);
            final InputStream lllllllllllllIllllIlIllIIllIIlIl = Config.getResourceStream(lllllllllllllIllllIlIllIIllIIllI);
            if (lllllllllllllIllllIlIllIIllIIlIl == null) {
                return;
            }
            Config.dbg(String.valueOf(new StringBuilder("CustomItems: Loading ").append(lllllllllllllIllllIlIllIIllIIIIl)));
            final Properties lllllllllllllIllllIlIllIIllIIlII = new Properties();
            lllllllllllllIllllIlIllIIllIIlII.load(lllllllllllllIllllIlIllIIllIIlIl);
            lllllllllllllIllllIlIllIIllIIlIl.close();
            CustomItems.useGlint = Config.parseBoolean(lllllllllllllIllllIlIllIIllIIlII.getProperty("useGlint"), true);
        }
        catch (FileNotFoundException lllllllllllllIllllIlIllIIllIIIll) {}
        catch (IOException lllllllllllllIllllIlIllIIllIIIlI) {
            lllllllllllllIllllIlIllIIllIIIlI.printStackTrace();
        }
    }
    
    private static void addToItemList(final CustomItemProperties lllllllllllllIllllIlIlIlIllllIII, final List lllllllllllllIllllIlIlIlIllllIll) {
        if (lllllllllllllIllllIlIlIlIllllIII.items != null) {
            for (int lllllllllllllIllllIlIlIlIllllIlI = 0; lllllllllllllIllllIlIlIlIllllIlI < lllllllllllllIllllIlIlIlIllllIII.items.length; ++lllllllllllllIllllIlIlIlIllllIlI) {
                final int lllllllllllllIllllIlIlIlIllllIIl = lllllllllllllIllllIlIlIlIllllIII.items[lllllllllllllIllllIlIlIlIllllIlI];
                if (lllllllllllllIllllIlIlIlIllllIIl <= 0) {
                    Config.warn(String.valueOf(new StringBuilder("Invalid item ID: ").append(lllllllllllllIllllIlIlIlIllllIIl)));
                }
                else {
                    addToList(lllllllllllllIllllIlIlIlIllllIII, lllllllllllllIllllIlIlIlIllllIll, lllllllllllllIllllIlIlIlIllllIIl);
                }
            }
        }
    }
    
    private static int getItemStackDamage(final ItemStack lllllllllllllIllllIlIlIIlllIIIII) {
        final Item lllllllllllllIllllIlIlIIllIlllll = lllllllllllllIllllIlIlIIlllIIIII.getItem();
        return (lllllllllllllIllllIlIlIIllIlllll instanceof ItemPotion) ? getPotionDamage(lllllllllllllIllllIlIlIIlllIIIII) : lllllllllllllIllllIlIlIIlllIIIII.getItemDamage();
    }
    
    private static void update(final IResourcePack lllllllllllllIllllIlIllIIlIlIIlI) {
        String[] lllllllllllllIllllIlIllIIlIlIIIl = ResUtils.collectFiles(lllllllllllllIllllIlIllIIlIlIIlI, "mcpatcher/cit/", ".properties", null);
        final Map lllllllllllllIllllIlIllIIlIlIIII = makeAutoImageProperties(lllllllllllllIllllIlIllIIlIlIIlI);
        if (lllllllllllllIllllIlIllIIlIlIIII.size() > 0) {
            final Set lllllllllllllIllllIlIllIIlIIllll = lllllllllllllIllllIlIllIIlIlIIII.keySet();
            final String[] lllllllllllllIllllIlIllIIlIIlllI = lllllllllllllIllllIlIllIIlIIllll.toArray(new String[lllllllllllllIllllIlIllIIlIIllll.size()]);
            lllllllllllllIllllIlIllIIlIlIIIl = (String[])Config.addObjectsToArray(lllllllllllllIllllIlIllIIlIlIIIl, lllllllllllllIllllIlIllIIlIIlllI);
        }
        Arrays.sort(lllllllllllllIllllIlIllIIlIlIIIl);
        final List lllllllllllllIllllIlIllIIlIIllIl = makePropertyList(CustomItems.itemProperties);
        final List lllllllllllllIllllIlIllIIlIIllII = makePropertyList(CustomItems.enchantmentProperties);
        for (int lllllllllllllIllllIlIllIIlIIlIll = 0; lllllllllllllIllllIlIllIIlIIlIll < lllllllllllllIllllIlIllIIlIlIIIl.length; ++lllllllllllllIllllIlIllIIlIIlIll) {
            final String lllllllllllllIllllIlIllIIlIIlIlI = lllllllllllllIllllIlIllIIlIlIIIl[lllllllllllllIllllIlIllIIlIIlIll];
            Config.dbg(String.valueOf(new StringBuilder("CustomItems: ").append(lllllllllllllIllllIlIllIIlIIlIlI)));
            try {
                CustomItemProperties lllllllllllllIllllIlIllIIlIIlIIl = null;
                if (lllllllllllllIllllIlIllIIlIlIIII.containsKey(lllllllllllllIllllIlIllIIlIIlIlI)) {
                    lllllllllllllIllllIlIllIIlIIlIIl = lllllllllllllIllllIlIllIIlIlIIII.get(lllllllllllllIllllIlIllIIlIIlIlI);
                }
                if (lllllllllllllIllllIlIllIIlIIlIIl == null) {
                    final ResourceLocation lllllllllllllIllllIlIllIIlIIlIII = new ResourceLocation(lllllllllllllIllllIlIllIIlIIlIlI);
                    final InputStream lllllllllllllIllllIlIllIIlIIIlll = lllllllllllllIllllIlIllIIlIlIIlI.getInputStream(lllllllllllllIllllIlIllIIlIIlIII);
                    if (lllllllllllllIllllIlIllIIlIIIlll == null) {
                        Config.warn(String.valueOf(new StringBuilder("CustomItems file not found: ").append(lllllllllllllIllllIlIllIIlIIlIlI)));
                        continue;
                    }
                    final Properties lllllllllllllIllllIlIllIIlIIIllI = new Properties();
                    lllllllllllllIllllIlIllIIlIIIllI.load(lllllllllllllIllllIlIllIIlIIIlll);
                    lllllllllllllIllllIlIllIIlIIlIIl = new CustomItemProperties(lllllllllllllIllllIlIllIIlIIIllI, lllllllllllllIllllIlIllIIlIIlIlI);
                }
                if (lllllllllllllIllllIlIllIIlIIlIIl.isValid(lllllllllllllIllllIlIllIIlIIlIlI)) {
                    addToItemList(lllllllllllllIllllIlIllIIlIIlIIl, lllllllllllllIllllIlIllIIlIIllIl);
                    addToEnchantmentList(lllllllllllllIllllIlIllIIlIIlIIl, lllllllllllllIllllIlIllIIlIIllII);
                }
            }
            catch (FileNotFoundException lllllllllllllIllllIlIllIIlIIIlIl) {
                Config.warn(String.valueOf(new StringBuilder("CustomItems file not found: ").append(lllllllllllllIllllIlIllIIlIIlIlI)));
            }
            catch (Exception lllllllllllllIllllIlIllIIlIIIlII) {
                lllllllllllllIllllIlIllIIlIIIlII.printStackTrace();
            }
        }
        CustomItems.itemProperties = propertyListToArray(lllllllllllllIllllIlIllIIlIIllIl);
        CustomItems.enchantmentProperties = propertyListToArray(lllllllllllllIllllIlIllIIlIIllII);
        final Comparator lllllllllllllIllllIlIllIIlIIIIll = getPropertiesComparator();
        for (int lllllllllllllIllllIlIllIIlIIIIlI = 0; lllllllllllllIllllIlIllIIlIIIIlI < CustomItems.itemProperties.length; ++lllllllllllllIllllIlIllIIlIIIIlI) {
            final CustomItemProperties[] lllllllllllllIllllIlIllIIlIIIIIl = CustomItems.itemProperties[lllllllllllllIllllIlIllIIlIIIIlI];
            if (lllllllllllllIllllIlIllIIlIIIIIl != null) {
                Arrays.sort(lllllllllllllIllllIlIllIIlIIIIIl, lllllllllllllIllllIlIllIIlIIIIll);
            }
        }
        for (int lllllllllllllIllllIlIllIIlIIIIII = 0; lllllllllllllIllllIlIllIIlIIIIII < CustomItems.enchantmentProperties.length; ++lllllllllllllIllllIlIllIIlIIIIII) {
            final CustomItemProperties[] lllllllllllllIllllIlIllIIIllllll = CustomItems.enchantmentProperties[lllllllllllllIllllIlIllIIlIIIIII];
            if (lllllllllllllIllllIlIllIIIllllll != null) {
                Arrays.sort(lllllllllllllIllllIlIllIIIllllll, lllllllllllllIllllIlIllIIlIIIIll);
            }
        }
    }
    
    public static boolean renderCustomEffect(final RenderItem lllllllllllllIllllIlIlIIlIIIllIl, final ItemStack lllllllllllllIllllIlIlIIIllllllI, final IBakedModel lllllllllllllIllllIlIlIIlIIIlIll) {
        if (CustomItems.enchantmentProperties == null) {
            return false;
        }
        if (lllllllllllllIllllIlIlIIIllllllI == null) {
            return false;
        }
        final int[][] lllllllllllllIllllIlIlIIlIIIlIlI = getEnchantmentIdLevels(lllllllllllllIllllIlIlIIIllllllI);
        if (lllllllllllllIllllIlIlIIlIIIlIlI.length <= 0) {
            return false;
        }
        Set lllllllllllllIllllIlIlIIlIIIlIIl = null;
        boolean lllllllllllllIllllIlIlIIlIIIlIII = false;
        final TextureManager lllllllllllllIllllIlIlIIlIIIIlll = Config.getTextureManager();
        for (int lllllllllllllIllllIlIlIIlIIIIllI = 0; lllllllllllllIllllIlIlIIlIIIIllI < lllllllllllllIllllIlIlIIlIIIlIlI.length; ++lllllllllllllIllllIlIlIIlIIIIllI) {
            final int lllllllllllllIllllIlIlIIlIIIIlIl = lllllllllllllIllllIlIlIIlIIIlIlI[lllllllllllllIllllIlIlIIlIIIIllI][0];
            if (lllllllllllllIllllIlIlIIlIIIIlIl >= 0 && lllllllllllllIllllIlIlIIlIIIIlIl < CustomItems.enchantmentProperties.length) {
                final CustomItemProperties[] lllllllllllllIllllIlIlIIlIIIIlII = CustomItems.enchantmentProperties[lllllllllllllIllllIlIlIIlIIIIlIl];
                if (lllllllllllllIllllIlIlIIlIIIIlII != null) {
                    for (int lllllllllllllIllllIlIlIIlIIIIIll = 0; lllllllllllllIllllIlIlIIlIIIIIll < lllllllllllllIllllIlIlIIlIIIIlII.length; ++lllllllllllllIllllIlIlIIlIIIIIll) {
                        final CustomItemProperties lllllllllllllIllllIlIlIIlIIIIIlI = lllllllllllllIllllIlIlIIlIIIIlII[lllllllllllllIllllIlIlIIlIIIIIll];
                        if (lllllllllllllIllllIlIlIIlIIIlIIl == null) {
                            lllllllllllllIllllIlIlIIlIIIlIIl = new HashSet();
                        }
                        if (lllllllllllllIllllIlIlIIlIIIlIIl.add(lllllllllllllIllllIlIlIIlIIIIlIl) && matchesProperties(lllllllllllllIllllIlIlIIlIIIIIlI, lllllllllllllIllllIlIlIIIllllllI, lllllllllllllIllllIlIlIIlIIIlIlI) && lllllllllllllIllllIlIlIIlIIIIIlI.textureLocation != null) {
                            lllllllllllllIllllIlIlIIlIIIIlll.bindTexture(lllllllllllllIllllIlIlIIlIIIIIlI.textureLocation);
                            final float lllllllllllllIllllIlIlIIlIIIIIIl = lllllllllllllIllllIlIlIIlIIIIIlI.getTextureWidth(lllllllllllllIllllIlIlIIlIIIIlll);
                            if (!lllllllllllllIllllIlIlIIlIIIlIII) {
                                lllllllllllllIllllIlIlIIlIIIlIII = true;
                                GlStateManager.depthMask(false);
                                GlStateManager.depthFunc(514);
                                GlStateManager.disableLighting();
                                GlStateManager.matrixMode(5890);
                            }
                            Blender.setupBlend(lllllllllllllIllllIlIlIIlIIIIIlI.blend, 1.0f);
                            GlStateManager.pushMatrix();
                            GlStateManager.scale(lllllllllllllIllllIlIlIIlIIIIIIl / 2.0f, lllllllllllllIllllIlIlIIlIIIIIIl / 2.0f, lllllllllllllIllllIlIlIIlIIIIIIl / 2.0f);
                            final float lllllllllllllIllllIlIlIIlIIIIIII = lllllllllllllIllllIlIlIIlIIIIIlI.speed * (Minecraft.getSystemTime() % 3000L) / 3000.0f / 8.0f;
                            GlStateManager.translate(lllllllllllllIllllIlIlIIlIIIIIII, 0.0f, 0.0f);
                            GlStateManager.rotate(lllllllllllllIllllIlIlIIlIIIIIlI.rotation, 0.0f, 0.0f, 1.0f);
                            lllllllllllllIllllIlIlIIlIIIllIl.func_191965_a(lllllllllllllIllllIlIlIIlIIIlIll, -1);
                            GlStateManager.popMatrix();
                        }
                    }
                }
            }
        }
        if (lllllllllllllIllllIlIlIIlIIIlIII) {
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.depthFunc(515);
            GlStateManager.depthMask(true);
            lllllllllllllIllllIlIlIIlIIIIlll.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        }
        return lllllllllllllIllllIlIlIIlIIIlIII;
    }
    
    private static void addToEnchantmentList(final CustomItemProperties lllllllllllllIllllIlIlIlIlllIIIl, final List lllllllllllllIllllIlIlIlIllIllIl) {
        if (lllllllllllllIllllIlIlIlIlllIIIl.type == 2 && lllllllllllllIllllIlIlIlIlllIIIl.enchantmentIds != null) {
            for (int lllllllllllllIllllIlIlIlIllIllll = 0; lllllllllllllIllllIlIlIlIllIllll < 256; ++lllllllllllllIllllIlIlIlIllIllll) {
                if (lllllllllllllIllllIlIlIlIlllIIIl.enchantmentIds.isInRange(lllllllllllllIllllIlIlIlIllIllll)) {
                    addToList(lllllllllllllIllllIlIlIlIlllIIIl, lllllllllllllIllllIlIlIlIllIllIl, lllllllllllllIllllIlIlIlIllIllll);
                }
            }
        }
    }
    
    public static boolean bindCustomArmorTexture(final ItemStack lllllllllllllIllllIlIlIlIlIIlIIl, final EntityEquipmentSlot lllllllllllllIllllIlIlIlIlIIIlII, final String lllllllllllllIllllIlIlIlIlIIIIll) {
        if (CustomItems.itemProperties == null) {
            return false;
        }
        final ResourceLocation lllllllllllllIllllIlIlIlIlIIIllI = getCustomArmorLocation(lllllllllllllIllllIlIlIlIlIIlIIl, lllllllllllllIllllIlIlIlIlIIIlII, lllllllllllllIllllIlIlIlIlIIIIll);
        if (lllllllllllllIllllIlIlIlIlIIIllI == null) {
            return false;
        }
        Config.getTextureManager().bindTexture(lllllllllllllIllllIlIlIlIlIIIllI);
        return true;
    }
    
    public static void loadModels(final ModelBakery lllllllllllllIllllIlIllIIIlIIlIl) {
        for (final CustomItemProperties lllllllllllllIllllIlIllIIIlIIlII : getAllProperties()) {
            lllllllllllllIllllIlIllIIIlIIlII.loadModels(lllllllllllllIllllIlIllIIIlIIlIl);
        }
    }
    
    public static boolean isUseGlint() {
        return CustomItems.useGlint;
    }
    
    public static void update() {
        CustomItems.itemProperties = null;
        CustomItems.enchantmentProperties = null;
        CustomItems.useGlint = true;
        if (Config.isCustomItems()) {
            readCitProperties("mcpatcher/cit.properties");
            final IResourcePack[] lllllllllllllIllllIlIllIIlllIIIl = Config.getResourcePacks();
            for (int lllllllllllllIllllIlIllIIlllIIII = lllllllllllllIllllIlIllIIlllIIIl.length - 1; lllllllllllllIllllIlIllIIlllIIII >= 0; --lllllllllllllIllllIlIllIIlllIIII) {
                final IResourcePack lllllllllllllIllllIlIllIIllIllll = lllllllllllllIllllIlIllIIlllIIIl[lllllllllllllIllllIlIllIIlllIIII];
                update(lllllllllllllIllllIlIllIIllIllll);
            }
            update(Config.getDefaultResourcePack());
            if (CustomItems.itemProperties.length <= 0) {
                CustomItems.itemProperties = null;
            }
            if (CustomItems.enchantmentProperties.length <= 0) {
                CustomItems.enchantmentProperties = null;
            }
        }
    }
    
    private static Comparator getPropertiesComparator() {
        final Comparator lllllllllllllIllllIlIllIIIllIIlI = new Comparator() {
            @Override
            public int compare(final Object lllllllllllllIIIIIllIIIIIIllllll, final Object lllllllllllllIIIIIllIIIIIlIIIIlI) {
                final CustomItemProperties lllllllllllllIIIIIllIIIIIlIIIIIl = (CustomItemProperties)lllllllllllllIIIIIllIIIIIIllllll;
                final CustomItemProperties lllllllllllllIIIIIllIIIIIlIIIIII = (CustomItemProperties)lllllllllllllIIIIIllIIIIIlIIIIlI;
                if (lllllllllllllIIIIIllIIIIIlIIIIIl.layer != lllllllllllllIIIIIllIIIIIlIIIIII.layer) {
                    return lllllllllllllIIIIIllIIIIIlIIIIIl.layer - lllllllllllllIIIIIllIIIIIlIIIIII.layer;
                }
                if (lllllllllllllIIIIIllIIIIIlIIIIIl.weight != lllllllllllllIIIIIllIIIIIlIIIIII.weight) {
                    return lllllllllllllIIIIIllIIIIIlIIIIII.weight - lllllllllllllIIIIIllIIIIIlIIIIIl.weight;
                }
                return lllllllllllllIIIIIllIIIIIlIIIIIl.basePath.equals(lllllllllllllIIIIIllIIIIIlIIIIII.basePath) ? lllllllllllllIIIIIllIIIIIlIIIIIl.name.compareTo(lllllllllllllIIIIIllIIIIIlIIIIII.name) : lllllllllllllIIIIIllIIIIIlIIIIIl.basePath.compareTo(lllllllllllllIIIIIllIIIIIlIIIIII.basePath);
            }
        };
        return lllllllllllllIllllIlIllIIIllIIlI;
    }
    
    private static Map makeAutoImageProperties(final IResourcePack lllllllllllllIllllIlIllIIIIIIIIl) {
        final Map lllllllllllllIllllIlIllIIIIIIIII = new HashMap();
        lllllllllllllIllllIlIllIIIIIIIII.putAll(makePotionImageProperties(lllllllllllllIllllIlIllIIIIIIIIl, "normal", Item.getIdFromItem(Items.POTIONITEM)));
        lllllllllllllIllllIlIllIIIIIIIII.putAll(makePotionImageProperties(lllllllllllllIllllIlIllIIIIIIIIl, "splash", Item.getIdFromItem(Items.SPLASH_POTION)));
        lllllllllllllIllllIlIllIIIIIIIII.putAll(makePotionImageProperties(lllllllllllllIllllIlIllIIIIIIIIl, "linger", Item.getIdFromItem(Items.LINGERING_POTION)));
        return lllllllllllllIllllIlIllIIIIIIIII;
    }
    
    private static boolean matchesProperties(final CustomItemProperties lllllllllllllIllllIlIlIIlllllIlI, final ItemStack lllllllllllllIllllIlIlIIlllIlIIl, final int[][] lllllllllllllIllllIlIlIIlllIlIII) {
        final Item lllllllllllllIllllIlIlIIllllIlll = lllllllllllllIllllIlIlIIlllIlIIl.getItem();
        if (lllllllllllllIllllIlIlIIlllllIlI.damage != null) {
            int lllllllllllllIllllIlIlIIllllIllI = getItemStackDamage(lllllllllllllIllllIlIlIIlllIlIIl);
            if (lllllllllllllIllllIlIlIIllllIllI < 0) {
                return false;
            }
            if (lllllllllllllIllllIlIlIIlllllIlI.damageMask != 0) {
                lllllllllllllIllllIlIlIIllllIllI &= lllllllllllllIllllIlIlIIlllllIlI.damageMask;
            }
            if (lllllllllllllIllllIlIlIIlllllIlI.damagePercent) {
                final int lllllllllllllIllllIlIlIIllllIlIl = lllllllllllllIllllIlIlIIllllIlll.getMaxDamage();
                lllllllllllllIllllIlIlIIllllIllI = (int)(lllllllllllllIllllIlIlIIllllIllI * 100 / (double)lllllllllllllIllllIlIlIIllllIlIl);
            }
            if (!lllllllllllllIllllIlIlIIlllllIlI.damage.isInRange(lllllllllllllIllllIlIlIIllllIllI)) {
                return false;
            }
        }
        if (lllllllllllllIllllIlIlIIlllllIlI.stackSize != null && !lllllllllllllIllllIlIlIIlllllIlI.stackSize.isInRange(lllllllllllllIllllIlIlIIlllIlIIl.func_190916_E())) {
            return false;
        }
        int[][] lllllllllllllIllllIlIlIIllllIlII = lllllllllllllIllllIlIlIIlllIlIII;
        if (lllllllllllllIllllIlIlIIlllllIlI.enchantmentIds != null) {
            if (lllllllllllllIllllIlIlIIlllIlIII == null) {
                lllllllllllllIllllIlIlIIllllIlII = getEnchantmentIdLevels(lllllllllllllIllllIlIlIIlllIlIIl);
            }
            boolean lllllllllllllIllllIlIlIIllllIIll = false;
            for (int lllllllllllllIllllIlIlIIllllIIlI = 0; lllllllllllllIllllIlIlIIllllIIlI < lllllllllllllIllllIlIlIIllllIlII.length; ++lllllllllllllIllllIlIlIIllllIIlI) {
                final int lllllllllllllIllllIlIlIIllllIIIl = lllllllllllllIllllIlIlIIllllIlII[lllllllllllllIllllIlIlIIllllIIlI][0];
                if (lllllllllllllIllllIlIlIIlllllIlI.enchantmentIds.isInRange(lllllllllllllIllllIlIlIIllllIIIl)) {
                    lllllllllllllIllllIlIlIIllllIIll = true;
                    break;
                }
            }
            if (!lllllllllllllIllllIlIlIIllllIIll) {
                return false;
            }
        }
        if (lllllllllllllIllllIlIlIIlllllIlI.enchantmentLevels != null) {
            if (lllllllllllllIllllIlIlIIllllIlII == null) {
                lllllllllllllIllllIlIlIIllllIlII = getEnchantmentIdLevels(lllllllllllllIllllIlIlIIlllIlIIl);
            }
            boolean lllllllllllllIllllIlIlIIllllIIII = false;
            for (int lllllllllllllIllllIlIlIIlllIllll = 0; lllllllllllllIllllIlIlIIlllIllll < lllllllllllllIllllIlIlIIllllIlII.length; ++lllllllllllllIllllIlIlIIlllIllll) {
                final int lllllllllllllIllllIlIlIIlllIlllI = lllllllllllllIllllIlIlIIllllIlII[lllllllllllllIllllIlIlIIlllIllll][1];
                if (lllllllllllllIllllIlIlIIlllllIlI.enchantmentLevels.isInRange(lllllllllllllIllllIlIlIIlllIlllI)) {
                    lllllllllllllIllllIlIlIIllllIIII = true;
                    break;
                }
            }
            if (!lllllllllllllIllllIlIlIIllllIIII) {
                return false;
            }
        }
        if (lllllllllllllIllllIlIlIIlllllIlI.nbtTagValues != null) {
            final NBTTagCompound lllllllllllllIllllIlIlIIlllIllIl = lllllllllllllIllllIlIlIIlllIlIIl.getTagCompound();
            for (int lllllllllllllIllllIlIlIIlllIllII = 0; lllllllllllllIllllIlIlIIlllIllII < lllllllllllllIllllIlIlIIlllllIlI.nbtTagValues.length; ++lllllllllllllIllllIlIlIIlllIllII) {
                final NbtTagValue lllllllllllllIllllIlIlIIlllIlIll = lllllllllllllIllllIlIlIIlllllIlI.nbtTagValues[lllllllllllllIllllIlIlIIlllIllII];
                if (!lllllllllllllIllllIlIlIIlllIlIll.matches(lllllllllllllIllllIlIlIIlllIllIl)) {
                    return false;
                }
            }
        }
        if (lllllllllllllIllllIlIlIIlllllIlI.hand != 0) {
            if (lllllllllllllIllllIlIlIIlllllIlI.hand == 1 && CustomItems.renderOffHand) {
                return false;
            }
            if (lllllllllllllIllllIlIlIIlllllIlI.hand == 2 && !CustomItems.renderOffHand) {
                return false;
            }
        }
        return true;
    }
    
    private static void addPotion(final String lllllllllllllIllllIlIlIIlIlllllI, int lllllllllllllIllllIlIlIIlIllllIl, final boolean lllllllllllllIllllIlIlIIlIllllII, final Map<String, Integer> lllllllllllllIllllIlIlIIllIIIIIl) {
        if (lllllllllllllIllllIlIlIIlIllllII) {
            lllllllllllllIllllIlIlIIlIllllIl |= 0x2000;
        }
        lllllllllllllIllllIlIlIIllIIIIIl.put(String.valueOf(new StringBuilder("minecraft:").append(lllllllllllllIllllIlIlIIlIlllllI)), (int)lllllllllllllIllllIlIlIIlIllllIl);
        if (lllllllllllllIllllIlIlIIlIllllII) {
            final int lllllllllllllIllllIlIlIIllIIIIII = (int)(lllllllllllllIllllIlIlIIlIllllIl | 0x20);
            lllllllllllllIllllIlIlIIllIIIIIl.put(String.valueOf(new StringBuilder("minecraft:strong_").append(lllllllllllllIllllIlIlIIlIlllllI)), lllllllllllllIllllIlIlIIllIIIIII);
            final int lllllllllllllIllllIlIlIIlIllllll = (int)(lllllllllllllIllllIlIlIIlIllllIl | 0x40);
            lllllllllllllIllllIlIlIIllIIIIIl.put(String.valueOf(new StringBuilder("minecraft:long_").append(lllllllllllllIllllIlIlIIlIlllllI)), lllllllllllllIllllIlIlIIlIllllll);
        }
    }
    
    public static ResourceLocation getCustomElytraTexture(final ItemStack lllllllllllllIllllIlIlIlIIIllIlI, final ResourceLocation lllllllllllllIllllIlIlIlIIIlllII) {
        if (CustomItems.itemProperties == null) {
            return lllllllllllllIllllIlIlIlIIIlllII;
        }
        final CustomItemProperties lllllllllllllIllllIlIlIlIIIllIll = getCustomItemProperties(lllllllllllllIllllIlIlIlIIIllIlI, 4);
        if (lllllllllllllIllllIlIlIlIIIllIll == null) {
            return lllllllllllllIllllIlIlIlIIIlllII;
        }
        return (lllllllllllllIllllIlIlIlIIIllIll.textureLocation == null) ? lllllllllllllIllllIlIlIlIIIlllII : lllllllllllllIllllIlIlIlIIIllIll.textureLocation;
    }
    
    private static int[] getPotionIds(final int lllllllllllllIllllIlIlIllIllIllI) {
        return new int[] { lllllllllllllIllllIlIlIllIllIllI, lllllllllllllIllllIlIlIllIllIllI + 16, lllllllllllllIllllIlIlIllIllIllI + 32, lllllllllllllIllllIlIlIllIllIllI + 48 };
    }
    
    private static Map getMapPotionIds() {
        if (CustomItems.mapPotionIds == null) {
            (CustomItems.mapPotionIds = new LinkedHashMap()).put("water", getPotionId(0, 0));
            CustomItems.mapPotionIds.put("awkward", getPotionId(0, 1));
            CustomItems.mapPotionIds.put("thick", getPotionId(0, 2));
            CustomItems.mapPotionIds.put("potent", getPotionId(0, 3));
            CustomItems.mapPotionIds.put("regeneration", getPotionIds(1));
            CustomItems.mapPotionIds.put("movespeed", getPotionIds(2));
            CustomItems.mapPotionIds.put("fireresistance", getPotionIds(3));
            CustomItems.mapPotionIds.put("poison", getPotionIds(4));
            CustomItems.mapPotionIds.put("heal", getPotionIds(5));
            CustomItems.mapPotionIds.put("nightvision", getPotionIds(6));
            CustomItems.mapPotionIds.put("clear", getPotionId(7, 0));
            CustomItems.mapPotionIds.put("bungling", getPotionId(7, 1));
            CustomItems.mapPotionIds.put("charming", getPotionId(7, 2));
            CustomItems.mapPotionIds.put("rank", getPotionId(7, 3));
            CustomItems.mapPotionIds.put("weakness", getPotionIds(8));
            CustomItems.mapPotionIds.put("damageboost", getPotionIds(9));
            CustomItems.mapPotionIds.put("moveslowdown", getPotionIds(10));
            CustomItems.mapPotionIds.put("leaping", getPotionIds(11));
            CustomItems.mapPotionIds.put("harm", getPotionIds(12));
            CustomItems.mapPotionIds.put("waterbreathing", getPotionIds(13));
            CustomItems.mapPotionIds.put("invisibility", getPotionIds(14));
            CustomItems.mapPotionIds.put("thin", getPotionId(15, 0));
            CustomItems.mapPotionIds.put("debonair", getPotionId(15, 1));
            CustomItems.mapPotionIds.put("sparkling", getPotionId(15, 2));
            CustomItems.mapPotionIds.put("stinky", getPotionId(15, 3));
            CustomItems.mapPotionIds.put("mundane", getPotionId(0, 4));
            CustomItems.mapPotionIds.put("speed", CustomItems.mapPotionIds.get("movespeed"));
            CustomItems.mapPotionIds.put("fire_resistance", CustomItems.mapPotionIds.get("fireresistance"));
            CustomItems.mapPotionIds.put("instant_health", CustomItems.mapPotionIds.get("heal"));
            CustomItems.mapPotionIds.put("night_vision", CustomItems.mapPotionIds.get("nightvision"));
            CustomItems.mapPotionIds.put("strength", CustomItems.mapPotionIds.get("damageboost"));
            CustomItems.mapPotionIds.put("slowness", CustomItems.mapPotionIds.get("moveslowdown"));
            CustomItems.mapPotionIds.put("instant_damage", CustomItems.mapPotionIds.get("harm"));
            CustomItems.mapPotionIds.put("water_breathing", CustomItems.mapPotionIds.get("waterbreathing"));
        }
        return CustomItems.mapPotionIds;
    }
    
    static {
        DEFAULT_TEXTURE_SPLASH = "items/potion_bottle_splash";
        MASK_POTION_NAME = 63;
        DEFAULT_TEXTURE_OVERLAY = "items/potion_overlay";
        TYPE_POTION_NORMAL = "normal";
        KEY_TEXTURE_SPLASH = "texture.potion_bottle_splash";
        TYPE_POTION_SPLASH = "splash";
        MASK_POTION_EXTENDED = 64;
        KEY_TEXTURE_DRINKABLE = "texture.potion_bottle_drinkable";
        DEFAULT_TEXTURE_DRINKABLE = "items/potion_bottle_drinkable";
        TYPE_POTION_LINGER = "linger";
        KEY_TEXTURE_OVERLAY = "texture.potion_overlay";
        MASK_POTION_SPLASH = 16384;
        CustomItems.itemProperties = null;
        CustomItems.enchantmentProperties = null;
        CustomItems.mapPotionIds = null;
        CustomItems.itemModelGenerator = new ItemModelGenerator();
        CustomItems.useGlint = true;
        CustomItems.renderOffHand = false;
        EMPTY_INT2_ARRAY = new int[0][];
        mapPotionDamages = makeMapPotionDamages();
    }
    
    private static ResourceLocation getCustomArmorLocation(final ItemStack lllllllllllllIllllIlIlIlIIlIlIll, final EntityEquipmentSlot lllllllllllllIllllIlIlIlIIllIlIl, final String lllllllllllllIllllIlIlIlIIllIlII) {
        final CustomItemProperties lllllllllllllIllllIlIlIlIIllIIll = getCustomItemProperties(lllllllllllllIllllIlIlIlIIlIlIll, 3);
        if (lllllllllllllIllllIlIlIlIIllIIll == null) {
            return null;
        }
        if (lllllllllllllIllllIlIlIlIIllIIll.mapTextureLocations == null) {
            return lllllllllllllIllllIlIlIlIIllIIll.textureLocation;
        }
        final Item lllllllllllllIllllIlIlIlIIllIIlI = lllllllllllllIllllIlIlIlIIlIlIll.getItem();
        if (!(lllllllllllllIllllIlIlIlIIllIIlI instanceof ItemArmor)) {
            return null;
        }
        final ItemArmor lllllllllllllIllllIlIlIlIIllIIIl = (ItemArmor)lllllllllllllIllllIlIlIlIIllIIlI;
        final String lllllllllllllIllllIlIlIlIIllIIII = lllllllllllllIllllIlIlIlIIllIIIl.getArmorMaterial().getName();
        final int lllllllllllllIllllIlIlIlIIlIllll = (lllllllllllllIllllIlIlIlIIllIlIl == EntityEquipmentSlot.LEGS) ? 2 : 1;
        final StringBuffer lllllllllllllIllllIlIlIlIIlIlllI = new StringBuffer();
        lllllllllllllIllllIlIlIlIIlIlllI.append("texture.");
        lllllllllllllIllllIlIlIlIIlIlllI.append(lllllllllllllIllllIlIlIlIIllIIII);
        lllllllllllllIllllIlIlIlIIlIlllI.append("_layer_");
        lllllllllllllIllllIlIlIlIIlIlllI.append(lllllllllllllIllllIlIlIlIIlIllll);
        if (lllllllllllllIllllIlIlIlIIllIlII != null) {
            lllllllllllllIllllIlIlIlIIlIlllI.append("_");
            lllllllllllllIllllIlIlIlIIlIlllI.append(lllllllllllllIllllIlIlIlIIllIlII);
        }
        final String lllllllllllllIllllIlIlIlIIlIllIl = lllllllllllllIllllIlIlIlIIlIlllI.toString();
        final ResourceLocation lllllllllllllIllllIlIlIlIIlIllII = lllllllllllllIllllIlIlIlIIllIIll.mapTextureLocations.get(lllllllllllllIllllIlIlIlIIlIllIl);
        return (lllllllllllllIllllIlIlIlIIlIllII == null) ? lllllllllllllIllllIlIlIlIIllIIll.textureLocation : lllllllllllllIllllIlIlIlIIlIllII;
    }
    
    private static List makePropertyList(final CustomItemProperties[][] lllllllllllllIllllIlIlIllIIlIlII) {
        final List lllllllllllllIllllIlIlIllIIllIII = new ArrayList();
        if (lllllllllllllIllllIlIlIllIIlIlII != null) {
            for (int lllllllllllllIllllIlIlIllIIlIlll = 0; lllllllllllllIllllIlIlIllIIlIlll < lllllllllllllIllllIlIlIllIIlIlII.length; ++lllllllllllllIllllIlIlIllIIlIlll) {
                final CustomItemProperties[] lllllllllllllIllllIlIlIllIIlIllI = lllllllllllllIllllIlIlIllIIlIlII[lllllllllllllIllllIlIlIllIIlIlll];
                List lllllllllllllIllllIlIlIllIIlIlIl = null;
                if (lllllllllllllIllllIlIlIllIIlIllI != null) {
                    lllllllllllllIllllIlIlIllIIlIlIl = new ArrayList(Arrays.asList(lllllllllllllIllllIlIlIllIIlIllI));
                }
                lllllllllllllIllllIlIlIllIIllIII.add(lllllllllllllIllllIlIlIllIIlIlIl);
            }
        }
        return lllllllllllllIllllIlIlIllIIllIII;
    }
    
    private static int getPotionNameDamage(final String lllllllllllllIllllIlIlIllIlIlIIl) {
        final String lllllllllllllIllllIlIlIllIlIlIII = String.valueOf(new StringBuilder("effect.").append(lllllllllllllIllllIlIlIllIlIlIIl));
        for (final ResourceLocation lllllllllllllIllllIlIlIllIlIIlll : Potion.REGISTRY.getKeys()) {
            final Potion lllllllllllllIllllIlIlIllIlIIllI = Potion.REGISTRY.getObject(lllllllllllllIllllIlIlIllIlIIlll);
            final String lllllllllllllIllllIlIlIllIlIIlIl = lllllllllllllIllllIlIlIllIlIIllI.getName();
            if (lllllllllllllIllllIlIlIllIlIlIII.equals(lllllllllllllIllllIlIlIllIlIIlIl)) {
                return Potion.getIdFromPotion(lllllllllllllIllllIlIlIllIlIIllI);
            }
        }
        return -1;
    }
    
    private static void addAll(final CustomItemProperties[][] lllllllllllllIllllIlIllIIIIIllll, final List<CustomItemProperties> lllllllllllllIllllIlIllIIIIIlllI) {
        if (lllllllllllllIllllIlIllIIIIIllll != null) {
            for (int lllllllllllllIllllIlIllIIIIIllIl = 0; lllllllllllllIllllIlIllIIIIIllIl < lllllllllllllIllllIlIllIIIIIllll.length; ++lllllllllllllIllllIlIllIIIIIllIl) {
                final CustomItemProperties[] lllllllllllllIllllIlIllIIIIIllII = lllllllllllllIllllIlIllIIIIIllll[lllllllllllllIllllIlIllIIIIIllIl];
                if (lllllllllllllIllllIlIllIIIIIllII != null) {
                    for (int lllllllllllllIllllIlIllIIIIIlIll = 0; lllllllllllllIllllIlIllIIIIIlIll < lllllllllllllIllllIlIllIIIIIllII.length; ++lllllllllllllIllllIlIllIIIIIlIll) {
                        final CustomItemProperties lllllllllllllIllllIlIllIIIIIlIlI = lllllllllllllIllllIlIllIIIIIllII[lllllllllllllIllllIlIllIIIIIlIll];
                        if (lllllllllllllIllllIlIllIIIIIlIlI != null) {
                            lllllllllllllIllllIlIllIIIIIlllI.add(lllllllllllllIllllIlIllIIIIIlIlI);
                        }
                    }
                }
            }
        }
    }
    
    private static void addToList(final CustomItemProperties lllllllllllllIllllIlIlIlIllIIIll, final List lllllllllllllIllllIlIlIlIllIIllI, final int lllllllllllllIllllIlIlIlIllIIIIl) {
        while (lllllllllllllIllllIlIlIlIllIIIIl >= lllllllllllllIllllIlIlIlIllIIllI.size()) {
            lllllllllllllIllllIlIlIlIllIIllI.add(null);
        }
        List lllllllllllllIllllIlIlIlIllIIlII = lllllllllllllIllllIlIlIlIllIIllI.get(lllllllllllllIllllIlIlIlIllIIIIl);
        if (lllllllllllllIllllIlIlIlIllIIlII == null) {
            lllllllllllllIllllIlIlIlIllIIlII = new ArrayList();
            lllllllllllllIllllIlIlIlIllIIllI.set(lllllllllllllIllllIlIlIlIllIIIIl, lllllllllllllIllllIlIlIlIllIIlII);
        }
        lllllllllllllIllllIlIlIlIllIIlII.add(lllllllllllllIllllIlIlIlIllIIIll);
    }
    
    private static CustomItemProperties[][] propertyListToArray(final List lllllllllllllIllllIlIlIllIIIlIlI) {
        final CustomItemProperties[][] lllllllllllllIllllIlIlIllIIIlIIl = new CustomItemProperties[lllllllllllllIllllIlIlIllIIIlIlI.size()][];
        for (int lllllllllllllIllllIlIlIllIIIlIII = 0; lllllllllllllIllllIlIlIllIIIlIII < lllllllllllllIllllIlIlIllIIIlIlI.size(); ++lllllllllllllIllllIlIlIllIIIlIII) {
            final List lllllllllllllIllllIlIlIllIIIIlll = lllllllllllllIllllIlIlIllIIIlIlI.get(lllllllllllllIllllIlIlIllIIIlIII);
            if (lllllllllllllIllllIlIlIllIIIIlll != null) {
                final CustomItemProperties[] lllllllllllllIllllIlIlIllIIIIllI = lllllllllllllIllllIlIlIllIIIIlll.toArray(new CustomItemProperties[lllllllllllllIllllIlIlIllIIIIlll.size()]);
                Arrays.sort(lllllllllllllIllllIlIlIllIIIIllI, new CustomItemsComparator());
                lllllllllllllIllllIlIlIllIIIlIIl[lllllllllllllIllllIlIlIllIIIlIII] = lllllllllllllIllllIlIlIllIIIIllI;
            }
        }
        return lllllllllllllIllllIlIlIllIIIlIIl;
    }
    
    public static IBakedModel getCustomItemModel(final ItemStack lllllllllllllIllllIlIlIlIlIllIIl, final IBakedModel lllllllllllllIllllIlIlIlIlIlIIlI, final ResourceLocation lllllllllllllIllllIlIlIlIlIlIIIl, final boolean lllllllllllllIllllIlIlIlIlIlIIII) {
        if (!lllllllllllllIllllIlIlIlIlIlIIII && lllllllllllllIllllIlIlIlIlIlIIlI.isGui3d()) {
            return lllllllllllllIllllIlIlIlIlIlIIlI;
        }
        if (CustomItems.itemProperties == null) {
            return lllllllllllllIllllIlIlIlIlIlIIlI;
        }
        final CustomItemProperties lllllllllllllIllllIlIlIlIlIlIlIl = getCustomItemProperties(lllllllllllllIllllIlIlIlIlIllIIl, 1);
        if (lllllllllllllIllllIlIlIlIlIlIlIl == null) {
            return lllllllllllllIllllIlIlIlIlIlIIlI;
        }
        final IBakedModel lllllllllllllIllllIlIlIlIlIlIlII = lllllllllllllIllllIlIlIlIlIlIlIl.getBakedModel(lllllllllllllIllllIlIlIlIlIlIIIl, lllllllllllllIllllIlIlIlIlIlIIII);
        return (lllllllllllllIllllIlIlIlIlIlIlII != null) ? lllllllllllllIllllIlIlIlIlIlIlII : lllllllllllllIllllIlIlIlIlIlIIlI;
    }
    
    private static Map makePotionImageProperties(final IResourcePack lllllllllllllIllllIlIlIllllIllll, final String lllllllllllllIllllIlIlIllllIlllI, final int lllllllllllllIllllIlIlIllllIllIl) {
        final Map lllllllllllllIllllIlIlIllllIllII = new HashMap();
        final String lllllllllllllIllllIlIlIllllIlIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllllIlIlIllllIlllI)).append("/"));
        final String[] lllllllllllllIllllIlIlIllllIlIlI = { String.valueOf(new StringBuilder("mcpatcher/cit/potion/").append(lllllllllllllIllllIlIlIllllIlIll)), String.valueOf(new StringBuilder("mcpatcher/cit/Potion/").append(lllllllllllllIllllIlIlIllllIlIll)) };
        final String[] lllllllllllllIllllIlIlIllllIlIIl = { ".png" };
        final String[] lllllllllllllIllllIlIlIllllIlIII = ResUtils.collectFiles(lllllllllllllIllllIlIlIllllIllll, lllllllllllllIllllIlIlIllllIlIlI, lllllllllllllIllllIlIlIllllIlIIl);
        for (int lllllllllllllIllllIlIlIllllIIlll = 0; lllllllllllllIllllIlIlIllllIIlll < lllllllllllllIllllIlIlIllllIlIII.length; ++lllllllllllllIllllIlIlIllllIIlll) {
            final String lllllllllllllIllllIlIlIllllIIllI = lllllllllllllIllllIlIlIllllIlIII[lllllllllllllIllllIlIlIllllIIlll];
            final String lllllllllllllIllllIlIlIllllIIlIl = StrUtils.removePrefixSuffix(lllllllllllllIllllIlIlIllllIIllI, lllllllllllllIllllIlIlIllllIlIlI, lllllllllllllIllllIlIlIllllIlIIl);
            final Properties lllllllllllllIllllIlIlIllllIIlII = makePotionProperties(lllllllllllllIllllIlIlIllllIIlIl, lllllllllllllIllllIlIlIllllIlllI, lllllllllllllIllllIlIlIllllIllIl, lllllllllllllIllllIlIlIllllIIllI);
            if (lllllllllllllIllllIlIlIllllIIlII != null) {
                final String lllllllllllllIllllIlIlIllllIIIll = String.valueOf(new StringBuilder(String.valueOf(StrUtils.removeSuffix(lllllllllllllIllllIlIlIllllIIllI, lllllllllllllIllllIlIlIllllIlIIl))).append(".properties"));
                final CustomItemProperties lllllllllllllIllllIlIlIllllIIIlI = new CustomItemProperties(lllllllllllllIllllIlIlIllllIIlII, lllllllllllllIllllIlIlIllllIIIll);
                lllllllllllllIllllIlIlIllllIllII.put(lllllllllllllIllllIlIlIllllIIIll, lllllllllllllIllllIlIlIllllIIIlI);
            }
        }
        return lllllllllllllIllllIlIlIllllIllII;
    }
    
    private static int[][] getEnchantmentIdLevels(final ItemStack lllllllllllllIllllIlIlIIlIlIIlII) {
        final Item lllllllllllllIllllIlIlIIlIlIlllI = lllllllllllllIllllIlIlIIlIlIIlII.getItem();
        NBTTagList lllllllllllllIllllIlIlIIlIlIllII = null;
        if (lllllllllllllIllllIlIlIIlIlIlllI == Items.ENCHANTED_BOOK) {
            final ItemEnchantedBook lllllllllllllIllllIlIlIIlIlIlIll = (ItemEnchantedBook)Items.ENCHANTED_BOOK;
            final NBTTagList lllllllllllllIllllIlIlIIlIlIllIl = ItemEnchantedBook.getEnchantments(lllllllllllllIllllIlIlIIlIlIIlII);
        }
        else {
            lllllllllllllIllllIlIlIIlIlIllII = lllllllllllllIllllIlIlIIlIlIIlII.getEnchantmentTagList();
        }
        final NBTTagList lllllllllllllIllllIlIlIIlIlIlIlI = lllllllllllllIllllIlIlIIlIlIllII;
        if (lllllllllllllIllllIlIlIIlIlIlIlI != null && lllllllllllllIllllIlIlIIlIlIlIlI.tagCount() > 0) {
            final int[][] lllllllllllllIllllIlIlIIlIlIlIIl = new int[lllllllllllllIllllIlIlIIlIlIlIlI.tagCount()][2];
            for (int lllllllllllllIllllIlIlIIlIlIlIII = 0; lllllllllllllIllllIlIlIIlIlIlIII < lllllllllllllIllllIlIlIIlIlIlIlI.tagCount(); ++lllllllllllllIllllIlIlIIlIlIlIII) {
                final NBTTagCompound lllllllllllllIllllIlIlIIlIlIIlll = lllllllllllllIllllIlIlIIlIlIlIlI.getCompoundTagAt(lllllllllllllIllllIlIlIIlIlIlIII);
                final int lllllllllllllIllllIlIlIIlIlIIllI = lllllllllllllIllllIlIlIIlIlIIlll.getShort("id");
                final int lllllllllllllIllllIlIlIIlIlIIlIl = lllllllllllllIllllIlIlIIlIlIIlll.getShort("lvl");
                lllllllllllllIllllIlIlIIlIlIlIIl[lllllllllllllIllllIlIlIIlIlIlIII][0] = lllllllllllllIllllIlIlIIlIlIIllI;
                lllllllllllllIllllIlIlIIlIlIlIIl[lllllllllllllIllllIlIlIIlIlIlIII][1] = lllllllllllllIllllIlIlIIlIlIIlIl;
            }
            return lllllllllllllIllllIlIlIIlIlIlIIl;
        }
        return CustomItems.EMPTY_INT2_ARRAY;
    }
    
    public static void setRenderOffHand(final boolean lllllllllllllIllllIlIlIIIIllIIII) {
        CustomItems.renderOffHand = lllllllllllllIllllIlIlIIIIllIIII;
    }
    
    private static CustomItemProperties getCustomItemProperties(final ItemStack lllllllllllllIllllIlIlIlIIIlIIII, final int lllllllllllllIllllIlIlIlIIIIllll) {
        if (CustomItems.itemProperties == null) {
            return null;
        }
        if (lllllllllllllIllllIlIlIlIIIlIIII == null) {
            return null;
        }
        final Item lllllllllllllIllllIlIlIlIIIIlllI = lllllllllllllIllllIlIlIlIIIlIIII.getItem();
        final int lllllllllllllIllllIlIlIlIIIIllIl = Item.getIdFromItem(lllllllllllllIllllIlIlIlIIIIlllI);
        if (lllllllllllllIllllIlIlIlIIIIllIl >= 0 && lllllllllllllIllllIlIlIlIIIIllIl < CustomItems.itemProperties.length) {
            final CustomItemProperties[] lllllllllllllIllllIlIlIlIIIIllII = CustomItems.itemProperties[lllllllllllllIllllIlIlIlIIIIllIl];
            if (lllllllllllllIllllIlIlIlIIIIllII != null) {
                for (int lllllllllllllIllllIlIlIlIIIIlIll = 0; lllllllllllllIllllIlIlIlIIIIlIll < lllllllllllllIllllIlIlIlIIIIllII.length; ++lllllllllllllIllllIlIlIlIIIIlIll) {
                    final CustomItemProperties lllllllllllllIllllIlIlIlIIIIlIlI = lllllllllllllIllllIlIlIlIIIIllII[lllllllllllllIllllIlIlIlIIIIlIll];
                    if (lllllllllllllIllllIlIlIlIIIIlIlI.type == lllllllllllllIllllIlIlIlIIIIllll && matchesProperties(lllllllllllllIllllIlIlIlIIIIlIlI, lllllllllllllIllllIlIlIlIIIlIIII, null)) {
                        return lllllllllllllIllllIlIlIlIIIIlIlI;
                    }
                }
            }
        }
        return null;
    }
    
    private static List<CustomItemProperties> getAllProperties() {
        final List<CustomItemProperties> lllllllllllllIllllIlIllIIIIlIlll = new ArrayList<CustomItemProperties>();
        addAll(CustomItems.itemProperties, lllllllllllllIllllIlIllIIIIlIlll);
        addAll(CustomItems.enchantmentProperties, lllllllllllllIllllIlIllIIIIlIlll);
        return lllllllllllllIllllIlIllIIIIlIlll;
    }
}
