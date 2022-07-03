package optifine;

import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.world.biome.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import it.unimi.dsi.fastutil.ints.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;
import java.util.*;

public class CustomGuiProperties
{
    private static final /* synthetic */ ResourceLocation BREWING_STAND_GUI_TEXTURE;
    private /* synthetic */ Boolean large;
    private /* synthetic */ NbtTagValue nbtName;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$optifine$CustomGuiProperties$EnumContainer;
    private static final /* synthetic */ ResourceLocation CHEST_GUI_TEXTURE;
    private /* synthetic */ VillagerProfession[] professions;
    private static final /* synthetic */ ResourceLocation VILLAGER_GUI_TEXTURE;
    private /* synthetic */ Boolean trapped;
    private static final /* synthetic */ ResourceLocation BEACON_GUI_TEXTURE;
    private /* synthetic */ EnumContainer container;
    private static final /* synthetic */ EnumVariant[] VARIANTS_INVALID;
    private /* synthetic */ Boolean christmas;
    private static final /* synthetic */ ResourceLocation FURNACE_GUI_TEXTURE;
    private /* synthetic */ Boolean ender;
    private /* synthetic */ EnumVariant[] variants;
    private static final /* synthetic */ ResourceLocation INVENTORY_GUI_TEXTURE;
    private static final /* synthetic */ EnumVariant[] VARIANTS_HORSE;
    private /* synthetic */ Map<ResourceLocation, ResourceLocation> textureLocations;
    private static final /* synthetic */ ResourceLocation HORSE_GUI_TEXTURE;
    private /* synthetic */ String basePath;
    private static final /* synthetic */ VillagerProfession[] PROFESSIONS_INVALID;
    private static final /* synthetic */ ResourceLocation ANVIL_GUI_TEXTURE;
    private /* synthetic */ String fileName;
    private static final /* synthetic */ EnumDyeColor[] COLORS_INVALID;
    private static final /* synthetic */ ResourceLocation CRAFTING_TABLE_GUI_TEXTURE;
    private static final /* synthetic */ ResourceLocation DISPENSER_GUI_TEXTURE;
    private /* synthetic */ Biome[] biomes;
    private static final /* synthetic */ ResourceLocation ENCHANTMENT_TABLE_GUI_TEXTURE;
    private static final /* synthetic */ ResourceLocation HOPPER_GUI_TEXTURE;
    private /* synthetic */ RangeListInt heights;
    private /* synthetic */ RangeListInt levels;
    private /* synthetic */ EnumDyeColor[] colors;
    private static final /* synthetic */ ResourceLocation SHULKER_BOX_GUI_TEXTURE;
    private static final /* synthetic */ EnumVariant[] VARIANTS_DISPENSER;
    
    private static void warn(final String llllllllllllllllllllIlIllIlIlllI) {
        Config.warn(String.valueOf(new StringBuilder("[CustomGuis] ").append(llllllllllllllllllllIlIllIlIlllI)));
    }
    
    private boolean matchesVillager(final Entity llllllllllllllllllllIlIIlllIIIIl, final IBlockAccess llllllllllllllllllllIlIIlllIlIlI) {
        if (!(llllllllllllllllllllIlIIlllIIIIl instanceof EntityVillager)) {
            return false;
        }
        final EntityVillager llllllllllllllllllllIlIIlllIlIIl = (EntityVillager)llllllllllllllllllllIlIIlllIIIIl;
        final NBTTagCompound llllllllllllllllllllIlIIlllIlIII = new NBTTagCompound();
        llllllllllllllllllllIlIIlllIlIIl.writeToNBT(llllllllllllllllllllIlIIlllIlIII);
        final Integer llllllllllllllllllllIlIIlllIIlll = llllllllllllllllllllIlIIlllIlIII.getInteger("Profession");
        final Integer llllllllllllllllllllIlIIlllIIllI = llllllllllllllllllllIlIIlllIlIII.getInteger("Career");
        if (llllllllllllllllllllIlIIlllIIlll != null && llllllllllllllllllllIlIIlllIIllI != null) {
            if (this.professions != null) {
                boolean llllllllllllllllllllIlIIlllIIlIl = false;
                for (int llllllllllllllllllllIlIIlllIIlII = 0; llllllllllllllllllllIlIIlllIIlII < this.professions.length; ++llllllllllllllllllllIlIIlllIIlII) {
                    final VillagerProfession llllllllllllllllllllIlIIlllIIIll = this.professions[llllllllllllllllllllIlIIlllIIlII];
                    if (llllllllllllllllllllIlIIlllIIIll.matches(llllllllllllllllllllIlIIlllIIlll, llllllllllllllllllllIlIIlllIIllI)) {
                        llllllllllllllllllllIlIIlllIIlIl = true;
                        break;
                    }
                }
                if (!llllllllllllllllllllIlIIlllIIlIl) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    private static Map<ResourceLocation, ResourceLocation> parseTextureLocations(final Properties llllllllllllllllllllIlIlllIllIII, final String llllllllllllllllllllIlIlllIIIlll, final EnumContainer llllllllllllllllllllIlIlllIlIllI, final String llllllllllllllllllllIlIlllIlIlIl, final String llllllllllllllllllllIlIlllIIIlII) {
        final Map<ResourceLocation, ResourceLocation> llllllllllllllllllllIlIlllIlIIll = new HashMap<ResourceLocation, ResourceLocation>();
        final String llllllllllllllllllllIlIlllIlIIlI = llllllllllllllllllllIlIlllIllIII.getProperty(llllllllllllllllllllIlIlllIIIlll);
        if (llllllllllllllllllllIlIlllIlIIlI != null) {
            final ResourceLocation llllllllllllllllllllIlIlllIlIIIl = getGuiTextureLocation(llllllllllllllllllllIlIlllIlIllI);
            final ResourceLocation llllllllllllllllllllIlIlllIlIIII = parseTextureLocation(llllllllllllllllllllIlIlllIlIIlI, llllllllllllllllllllIlIlllIIIlII);
            if (llllllllllllllllllllIlIlllIlIIIl != null && llllllllllllllllllllIlIlllIlIIII != null) {
                llllllllllllllllllllIlIlllIlIIll.put(llllllllllllllllllllIlIlllIlIIIl, llllllllllllllllllllIlIlllIlIIII);
            }
        }
        final String llllllllllllllllllllIlIlllIIllll = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllllIlIlllIIIlll)).append("."));
        for (final Object llllllllllllllllllllIlIlllIIlllI : ((Hashtable<Object, V>)llllllllllllllllllllIlIlllIllIII).keySet()) {
            if (((String)llllllllllllllllllllIlIlllIIlllI).startsWith(llllllllllllllllllllIlIlllIIllll)) {
                String llllllllllllllllllllIlIlllIIllIl = ((String)llllllllllllllllllllIlIlllIIlllI).substring(llllllllllllllllllllIlIlllIIllll.length());
                llllllllllllllllllllIlIlllIIllIl = llllllllllllllllllllIlIlllIIllIl.replace('\\', '/');
                llllllllllllllllllllIlIlllIIllIl = StrUtils.removePrefixSuffix(llllllllllllllllllllIlIlllIIllIl, "/", ".png");
                final String llllllllllllllllllllIlIlllIIllII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllllIlIlllIlIlIl)).append(llllllllllllllllllllIlIlllIIllIl).append(".png"));
                final String llllllllllllllllllllIlIlllIIlIll = llllllllllllllllllllIlIlllIllIII.getProperty((String)llllllllllllllllllllIlIlllIIlllI);
                final ResourceLocation llllllllllllllllllllIlIlllIIlIlI = new ResourceLocation(llllllllllllllllllllIlIlllIIllII);
                final ResourceLocation llllllllllllllllllllIlIlllIIlIIl = parseTextureLocation(llllllllllllllllllllIlIlllIIlIll, llllllllllllllllllllIlIlllIIIlII);
                llllllllllllllllllllIlIlllIlIIll.put(llllllllllllllllllllIlIlllIIlIlI, llllllllllllllllllllIlIlllIIlIIl);
            }
        }
        return llllllllllllllllllllIlIlllIlIIll;
    }
    
    private boolean matchesDispenser(final BlockPos llllllllllllllllllllIlIlIIlIIlll, final IBlockAccess llllllllllllllllllllIlIlIIIlllll) {
        final TileEntity llllllllllllllllllllIlIlIIlIIlIl = llllllllllllllllllllIlIlIIIlllll.getTileEntity(llllllllllllllllllllIlIlIIlIIlll);
        if (!(llllllllllllllllllllIlIlIIlIIlIl instanceof TileEntityDispenser)) {
            return false;
        }
        final TileEntityDispenser llllllllllllllllllllIlIlIIlIIlII = (TileEntityDispenser)llllllllllllllllllllIlIlIIlIIlIl;
        if (this.nbtName != null) {
            final String llllllllllllllllllllIlIlIIlIIIll = llllllllllllllllllllIlIlIIlIIlII.getName();
            if (!this.nbtName.matchesValue(llllllllllllllllllllIlIlIIlIIIll)) {
                return false;
            }
        }
        if (this.variants != null) {
            final EnumVariant llllllllllllllllllllIlIlIIlIIIlI = this.getDispenserVariant(llllllllllllllllllllIlIlIIlIIlII);
            if (!Config.equalsOne(llllllllllllllllllllIlIlIIlIIIlI, this.variants)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean matchesChest(final boolean llllllllllllllllllllIlIlIIlllIIl, final boolean llllllllllllllllllllIlIlIIllIIlI, final boolean llllllllllllllllllllIlIlIIllIIIl, final boolean llllllllllllllllllllIlIlIIllIIII, final String llllllllllllllllllllIlIlIIllIlIl) {
        return (this.large == null || this.large == llllllllllllllllllllIlIlIIlllIIl) && (this.trapped == null || this.trapped == llllllllllllllllllllIlIlIIllIIlI) && (this.christmas == null || this.christmas == llllllllllllllllllllIlIlIIllIIIl) && (this.ender == null || this.ender == llllllllllllllllllllIlIlIIllIIII) && (this.nbtName == null || this.nbtName.matchesValue(llllllllllllllllllllIlIlIIllIlIl));
    }
    
    private static int parseProfessionId(final String llllllllllllllllllllIllIIIIlIIll) {
        final int llllllllllllllllllllIllIIIIlIIlI = Config.parseInt(llllllllllllllllllllIllIIIIlIIll, -1);
        if (llllllllllllllllllllIllIIIIlIIlI >= 0) {
            return llllllllllllllllllllIllIIIIlIIlI;
        }
        if (llllllllllllllllllllIllIIIIlIIll.equals("farmer")) {
            return 0;
        }
        if (llllllllllllllllllllIllIIIIlIIll.equals("librarian")) {
            return 1;
        }
        if (llllllllllllllllllllIllIIIIlIIll.equals("priest")) {
            return 2;
        }
        if (llllllllllllllllllllIllIIIIlIIll.equals("blacksmith")) {
            return 3;
        }
        if (llllllllllllllllllllIllIIIIlIIll.equals("butcher")) {
            return 4;
        }
        return llllllllllllllllllllIllIIIIlIIll.equals("nitwit") ? 5 : -1;
    }
    
    private EnumVariant getHorseVariant(final AbstractHorse llllllllllllllllllllIlIIllIIIllI) {
        if (llllllllllllllllllllIlIIllIIIllI instanceof EntityHorse) {
            return EnumVariant.HORSE;
        }
        if (llllllllllllllllllllIlIIllIIIllI instanceof EntityDonkey) {
            return EnumVariant.DONKEY;
        }
        if (llllllllllllllllllllIlIIllIIIllI instanceof EntityMule) {
            return EnumVariant.MULE;
        }
        return (llllllllllllllllllllIlIIllIIIllI instanceof EntityLlama) ? EnumVariant.LLAMA : null;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("name: ").append(this.fileName).append(", container: ").append(this.container).append(", textures: ").append(this.textureLocations));
    }
    
    private static ResourceLocation getGuiTextureLocation(final EnumContainer llllllllllllllllllllIlIllIllIlll) {
        switch ($SWITCH_TABLE$optifine$CustomGuiProperties$EnumContainer()[llllllllllllllllllllIlIllIllIlll.ordinal()]) {
            case 1: {
                return CustomGuiProperties.ANVIL_GUI_TEXTURE;
            }
            case 2: {
                return CustomGuiProperties.BEACON_GUI_TEXTURE;
            }
            case 3: {
                return CustomGuiProperties.BREWING_STAND_GUI_TEXTURE;
            }
            case 4: {
                return CustomGuiProperties.CHEST_GUI_TEXTURE;
            }
            case 5: {
                return CustomGuiProperties.CRAFTING_TABLE_GUI_TEXTURE;
            }
            case 13: {
                return null;
            }
            case 6: {
                return CustomGuiProperties.DISPENSER_GUI_TEXTURE;
            }
            case 7: {
                return CustomGuiProperties.ENCHANTMENT_TABLE_GUI_TEXTURE;
            }
            case 8: {
                return CustomGuiProperties.FURNACE_GUI_TEXTURE;
            }
            case 9: {
                return CustomGuiProperties.HOPPER_GUI_TEXTURE;
            }
            case 10: {
                return CustomGuiProperties.HORSE_GUI_TEXTURE;
            }
            case 14: {
                return CustomGuiProperties.INVENTORY_GUI_TEXTURE;
            }
            case 12: {
                return CustomGuiProperties.SHULKER_BOX_GUI_TEXTURE;
            }
            case 11: {
                return CustomGuiProperties.VILLAGER_GUI_TEXTURE;
            }
            default: {
                return null;
            }
        }
    }
    
    private static int parseCareerId(final int llllllllllllllllllllIlIlllllIllI, final String llllllllllllllllllllIlIlllllIlIl) {
        final int llllllllllllllllllllIlIlllllIlII = Config.parseInt(llllllllllllllllllllIlIlllllIlIl, -1);
        if (llllllllllllllllllllIlIlllllIlII >= 0) {
            return llllllllllllllllllllIlIlllllIlII;
        }
        if (llllllllllllllllllllIlIlllllIllI == 0) {
            if (llllllllllllllllllllIlIlllllIlIl.equals("farmer")) {
                return 1;
            }
            if (llllllllllllllllllllIlIlllllIlIl.equals("fisherman")) {
                return 2;
            }
            if (llllllllllllllllllllIlIlllllIlIl.equals("shepherd")) {
                return 3;
            }
            if (llllllllllllllllllllIlIlllllIlIl.equals("fletcher")) {
                return 4;
            }
        }
        if (llllllllllllllllllllIlIlllllIllI == 1) {
            if (llllllllllllllllllllIlIlllllIlIl.equals("librarian")) {
                return 1;
            }
            if (llllllllllllllllllllIlIlllllIlIl.equals("cartographer")) {
                return 2;
            }
        }
        if (llllllllllllllllllllIlIlllllIllI == 2 && llllllllllllllllllllIlIlllllIlIl.equals("cleric")) {
            return 1;
        }
        if (llllllllllllllllllllIlIlllllIllI == 3) {
            if (llllllllllllllllllllIlIlllllIlIl.equals("armor")) {
                return 1;
            }
            if (llllllllllllllllllllIlIlllllIlIl.equals("weapon")) {
                return 2;
            }
            if (llllllllllllllllllllIlIlllllIlIl.equals("tool")) {
                return 3;
            }
        }
        if (llllllllllllllllllllIlIlllllIllI == 4) {
            if (llllllllllllllllllllIlIlllllIlIl.equals("butcher")) {
                return 1;
            }
            if (llllllllllllllllllllIlIlllllIlIl.equals("leather")) {
                return 2;
            }
        }
        return (llllllllllllllllllllIlIlllllIllI == 5 && llllllllllllllllllllIlIlllllIlIl.equals("nitwit")) ? 1 : -1;
    }
    
    public CustomGuiProperties(final Properties llllllllllllllllllllIllIIllIlIlI, final String llllllllllllllllllllIllIIllIlIIl) {
        this.fileName = null;
        this.basePath = null;
        this.container = null;
        this.textureLocations = null;
        this.nbtName = null;
        this.biomes = null;
        this.heights = null;
        this.large = null;
        this.trapped = null;
        this.christmas = null;
        this.ender = null;
        this.levels = null;
        this.professions = null;
        this.variants = null;
        this.colors = null;
        final ConnectedParser llllllllllllllllllllIllIIllIlIII = new ConnectedParser("CustomGuis");
        this.fileName = llllllllllllllllllllIllIIllIlIII.parseName(llllllllllllllllllllIllIIllIlIIl);
        this.basePath = llllllllllllllllllllIllIIllIlIII.parseBasePath(llllllllllllllllllllIllIIllIlIIl);
        this.container = (EnumContainer)llllllllllllllllllllIllIIllIlIII.parseEnum(llllllllllllllllllllIllIIllIlIlI.getProperty("container"), EnumContainer.values(), "container");
        this.textureLocations = parseTextureLocations(llllllllllllllllllllIllIIllIlIlI, "texture", this.container, "textures/gui/", this.basePath);
        this.nbtName = parseNbtTagValue("name", llllllllllllllllllllIllIIllIlIlI.getProperty("name"));
        this.biomes = llllllllllllllllllllIllIIllIlIII.parseBiomes(llllllllllllllllllllIllIIllIlIlI.getProperty("biomes"));
        this.heights = llllllllllllllllllllIllIIllIlIII.parseRangeListInt(llllllllllllllllllllIllIIllIlIlI.getProperty("heights"));
        this.large = llllllllllllllllllllIllIIllIlIII.parseBooleanObject(llllllllllllllllllllIllIIllIlIlI.getProperty("large"));
        this.trapped = llllllllllllllllllllIllIIllIlIII.parseBooleanObject(llllllllllllllllllllIllIIllIlIlI.getProperty("trapped"));
        this.christmas = llllllllllllllllllllIllIIllIlIII.parseBooleanObject(llllllllllllllllllllIllIIllIlIlI.getProperty("christmas"));
        this.ender = llllllllllllllllllllIllIIllIlIII.parseBooleanObject(llllllllllllllllllllIllIIllIlIlI.getProperty("ender"));
        this.levels = llllllllllllllllllllIllIIllIlIII.parseRangeListInt(llllllllllllllllllllIllIIllIlIlI.getProperty("levels"));
        this.professions = parseProfessions(llllllllllllllllllllIllIIllIlIlI.getProperty("professions"));
        final EnumVariant[] llllllllllllllllllllIllIIllIIlll = getContainerVariants(this.container);
        this.variants = (EnumVariant[])llllllllllllllllllllIllIIllIlIII.parseEnums(llllllllllllllllllllIllIIllIlIlI.getProperty("variants"), llllllllllllllllllllIllIIllIIlll, "variants", CustomGuiProperties.VARIANTS_INVALID);
        this.colors = parseEnumDyeColors(llllllllllllllllllllIllIIllIlIlI.getProperty("colors"));
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$optifine$CustomGuiProperties$EnumContainer() {
        final int[] $switch_TABLE$optifine$CustomGuiProperties$EnumContainer = CustomGuiProperties.$SWITCH_TABLE$optifine$CustomGuiProperties$EnumContainer;
        if ($switch_TABLE$optifine$CustomGuiProperties$EnumContainer != null) {
            return $switch_TABLE$optifine$CustomGuiProperties$EnumContainer;
        }
        final int llllllllllllllllllllIlIIlIllIlII = (Object)new int[EnumContainer.values().length];
        try {
            llllllllllllllllllllIlIIlIllIlII[EnumContainer.ANVIL.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllllllIlIIlIllIlII[EnumContainer.BEACON.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllllllIlIIlIllIlII[EnumContainer.BREWING_STAND.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllllllllIlIIlIllIlII[EnumContainer.CHEST.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllllllllIlIIlIllIlII[EnumContainer.CRAFTING.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllllllllIlIIlIllIlII[EnumContainer.CREATIVE.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllllllllllIlIIlIllIlII[EnumContainer.DISPENSER.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            llllllllllllllllllllIlIIlIllIlII[EnumContainer.ENCHANTMENT.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            llllllllllllllllllllIlIIlIllIlII[EnumContainer.FURNACE.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            llllllllllllllllllllIlIIlIllIlII[EnumContainer.HOPPER.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        try {
            llllllllllllllllllllIlIIlIllIlII[EnumContainer.HORSE.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError11) {}
        try {
            llllllllllllllllllllIlIIlIllIlII[EnumContainer.INVENTORY.ordinal()] = 14;
        }
        catch (NoSuchFieldError noSuchFieldError12) {}
        try {
            llllllllllllllllllllIlIIlIllIlII[EnumContainer.SHULKER_BOX.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError13) {}
        try {
            llllllllllllllllllllIlIIlIllIlII[EnumContainer.VILLAGER.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError14) {}
        return CustomGuiProperties.$SWITCH_TABLE$optifine$CustomGuiProperties$EnumContainer = (int[])(Object)llllllllllllllllllllIlIIlIllIlII;
    }
    
    private static NbtTagValue parseNbtTagValue(final String llllllllllllllllllllIllIIIllllII, final String llllllllllllllllllllIllIIIlllIll) {
        return (llllllllllllllllllllIllIIIllllII != null && llllllllllllllllllllIllIIIlllIll != null) ? new NbtTagValue(llllllllllllllllllllIllIIIllllII, llllllllllllllllllllIllIIIlllIll) : null;
    }
    
    private boolean matchesGeneral(final EnumContainer llllllllllllllllllllIlIllIlIIIlI, final BlockPos llllllllllllllllllllIlIllIlIIllI, final IBlockAccess llllllllllllllllllllIlIllIlIIlIl) {
        if (this.container != llllllllllllllllllllIlIllIlIIIlI) {
            return false;
        }
        if (this.biomes != null) {
            final Biome llllllllllllllllllllIlIllIlIIlII = llllllllllllllllllllIlIllIlIIlIl.getBiome(llllllllllllllllllllIlIllIlIIllI);
            if (!Matches.biome(llllllllllllllllllllIlIllIlIIlII, this.biomes)) {
                return false;
            }
        }
        return this.heights == null || this.heights.isInRange(llllllllllllllllllllIlIllIlIIllI.getY());
    }
    
    private static EnumVariant[] getContainerVariants(final EnumContainer llllllllllllllllllllIllIIlIlllll) {
        if (llllllllllllllllllllIllIIlIlllll == EnumContainer.HORSE) {
            return CustomGuiProperties.VARIANTS_HORSE;
        }
        return (llllllllllllllllllllIllIIlIlllll == EnumContainer.DISPENSER) ? CustomGuiProperties.VARIANTS_DISPENSER : new EnumVariant[0];
    }
    
    private boolean matchesHorse(final Entity llllllllllllllllllllIlIIllIlIIll, final IBlockAccess llllllllllllllllllllIlIIllIlIIlI) {
        if (!(llllllllllllllllllllIlIIllIlIIll instanceof AbstractHorse)) {
            return false;
        }
        final AbstractHorse llllllllllllllllllllIlIIllIlIIIl = (AbstractHorse)llllllllllllllllllllIlIIllIlIIll;
        if (this.variants != null) {
            final EnumVariant llllllllllllllllllllIlIIllIlIIII = this.getHorseVariant(llllllllllllllllllllIlIIllIlIIIl);
            if (!Config.equalsOne(llllllllllllllllllllIlIIllIlIIII, this.variants)) {
                return false;
            }
        }
        if (this.colors != null && llllllllllllllllllllIlIIllIlIIIl instanceof EntityLlama) {
            final EntityLlama llllllllllllllllllllIlIIllIIllll = (EntityLlama)llllllllllllllllllllIlIIllIlIIIl;
            final EnumDyeColor llllllllllllllllllllIlIIllIIlllI = llllllllllllllllllllIlIIllIIllll.func_190704_dO();
            if (!Config.equalsOne(llllllllllllllllllllIlIIllIIlllI, this.colors)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isValid(final String llllllllllllllllllllIlIllIllIIll) {
        if (this.fileName == null || this.fileName.length() <= 0) {
            warn(String.valueOf(new StringBuilder("No name found: ").append(llllllllllllllllllllIlIllIllIIll)));
            return false;
        }
        if (this.basePath == null) {
            warn(String.valueOf(new StringBuilder("No base path found: ").append(llllllllllllllllllllIlIllIllIIll)));
            return false;
        }
        if (this.container == null) {
            warn(String.valueOf(new StringBuilder("No container found: ").append(llllllllllllllllllllIlIllIllIIll)));
            return false;
        }
        if (this.textureLocations.isEmpty()) {
            warn(String.valueOf(new StringBuilder("No texture found: ").append(llllllllllllllllllllIlIllIllIIll)));
            return false;
        }
        if (this.professions == CustomGuiProperties.PROFESSIONS_INVALID) {
            warn(String.valueOf(new StringBuilder("Invalid professions or careers: ").append(llllllllllllllllllllIlIllIllIIll)));
            return false;
        }
        if (this.variants == CustomGuiProperties.VARIANTS_INVALID) {
            warn(String.valueOf(new StringBuilder("Invalid variants: ").append(llllllllllllllllllllIlIllIllIIll)));
            return false;
        }
        if (this.colors == CustomGuiProperties.COLORS_INVALID) {
            warn(String.valueOf(new StringBuilder("Invalid colors: ").append(llllllllllllllllllllIlIllIllIIll)));
            return false;
        }
        return true;
    }
    
    private static EnumDyeColor[] parseEnumDyeColors(String llllllllllllllllllllIllIIlIlIIlI) {
        if (llllllllllllllllllllIllIIlIlIIlI == null) {
            return null;
        }
        llllllllllllllllllllIllIIlIlIIlI = llllllllllllllllllllIllIIlIlIIlI.toLowerCase();
        final String[] llllllllllllllllllllIllIIlIlIlll = Config.tokenize(llllllllllllllllllllIllIIlIlIIlI, " ");
        final EnumDyeColor[] llllllllllllllllllllIllIIlIlIllI = new EnumDyeColor[llllllllllllllllllllIllIIlIlIlll.length];
        for (int llllllllllllllllllllIllIIlIlIlIl = 0; llllllllllllllllllllIllIIlIlIlIl < llllllllllllllllllllIllIIlIlIlll.length; ++llllllllllllllllllllIllIIlIlIlIl) {
            final String llllllllllllllllllllIllIIlIlIlII = llllllllllllllllllllIllIIlIlIlll[llllllllllllllllllllIllIIlIlIlIl];
            final EnumDyeColor llllllllllllllllllllIllIIlIlIIll = parseEnumDyeColor(llllllllllllllllllllIllIIlIlIlII);
            if (llllllllllllllllllllIllIIlIlIIll == null) {
                warn(String.valueOf(new StringBuilder("Invalid color: ").append(llllllllllllllllllllIllIIlIlIlII)));
                return CustomGuiProperties.COLORS_INVALID;
            }
            llllllllllllllllllllIllIIlIlIllI[llllllllllllllllllllIllIIlIlIlIl] = llllllllllllllllllllIllIIlIlIIll;
        }
        return llllllllllllllllllllIllIIlIlIllI;
    }
    
    public boolean matchesPos(final EnumContainer llllllllllllllllllllIlIllIIlIlIl, final BlockPos llllllllllllllllllllIlIllIIlIlII, final IBlockAccess llllllllllllllllllllIlIllIIlIlll) {
        if (!this.matchesGeneral(llllllllllllllllllllIlIllIIlIlIl, llllllllllllllllllllIlIllIIlIlII, llllllllllllllllllllIlIllIIlIlll)) {
            return false;
        }
        switch ($SWITCH_TABLE$optifine$CustomGuiProperties$EnumContainer()[llllllllllllllllllllIlIllIIlIlIl.ordinal()]) {
            case 2: {
                return this.matchesBeacon(llllllllllllllllllllIlIllIIlIlII, llllllllllllllllllllIlIllIIlIlll);
            }
            case 3: {
                return this.matchesNameable(llllllllllllllllllllIlIllIIlIlII, llllllllllllllllllllIlIllIIlIlll);
            }
            case 4: {
                return this.matchesChest(llllllllllllllllllllIlIllIIlIlII, llllllllllllllllllllIlIllIIlIlll);
            }
            default: {
                return true;
            }
            case 6: {
                return this.matchesDispenser(llllllllllllllllllllIlIllIIlIlII, llllllllllllllllllllIlIllIIlIlll);
            }
            case 7: {
                return this.matchesNameable(llllllllllllllllllllIlIllIIlIlII, llllllllllllllllllllIlIllIIlIlll);
            }
            case 8: {
                return this.matchesNameable(llllllllllllllllllllIlIllIIlIlII, llllllllllllllllllllIlIllIIlIlll);
            }
            case 9: {
                return this.matchesNameable(llllllllllllllllllllIlIllIIlIlII, llllllllllllllllllllIlIllIIlIlll);
            }
            case 12: {
                return this.matchesShulker(llllllllllllllllllllIlIllIIlIlII, llllllllllllllllllllIlIllIIlIlll);
            }
        }
    }
    
    private boolean matchesEnderChest(final TileEntityEnderChest llllllllllllllllllllIlIlIlIIIlII, final BlockPos llllllllllllllllllllIlIlIlIIIIll, final IBlockAccess llllllllllllllllllllIlIlIlIIIIlI) {
        return this.matchesChest(false, false, false, true, null);
    }
    
    private static EnumDyeColor parseEnumDyeColor(final String llllllllllllllllllllIllIIlIIlIII) {
        if (llllllllllllllllllllIllIIlIIlIII == null) {
            return null;
        }
        final EnumDyeColor[] llllllllllllllllllllIllIIlIIIlll = EnumDyeColor.values();
        for (int llllllllllllllllllllIllIIlIIIllI = 0; llllllllllllllllllllIllIIlIIIllI < llllllllllllllllllllIllIIlIIIlll.length; ++llllllllllllllllllllIllIIlIIIllI) {
            final EnumDyeColor llllllllllllllllllllIllIIlIIIlIl = llllllllllllllllllllIllIIlIIIlll[llllllllllllllllllllIllIIlIIIllI];
            if (llllllllllllllllllllIllIIlIIIlIl.getName().equals(llllllllllllllllllllIllIIlIIlIII)) {
                return llllllllllllllllllllIllIIlIIIlIl;
            }
            if (llllllllllllllllllllIllIIlIIIlIl.getUnlocalizedName().equals(llllllllllllllllllllIllIIlIIlIII)) {
                return llllllllllllllllllllIllIIlIIIlIl;
            }
        }
        return null;
    }
    
    public boolean matchesEntity(final EnumContainer llllllllllllllllllllIlIIlllllllI, final Entity llllllllllllllllllllIlIIllllllIl, final IBlockAccess llllllllllllllllllllIlIIllllllII) {
        if (!this.matchesGeneral(llllllllllllllllllllIlIIlllllllI, llllllllllllllllllllIlIIllllllIl.getPosition(), llllllllllllllllllllIlIIllllllII)) {
            return false;
        }
        if (this.nbtName != null) {
            final String llllllllllllllllllllIlIIlllllIll = llllllllllllllllllllIlIIllllllIl.getName();
            if (!this.nbtName.matchesValue(llllllllllllllllllllIlIIlllllIll)) {
                return false;
            }
        }
        switch ($SWITCH_TABLE$optifine$CustomGuiProperties$EnumContainer()[llllllllllllllllllllIlIIlllllllI.ordinal()]) {
            case 10: {
                return this.matchesHorse(llllllllllllllllllllIlIIllllllIl, llllllllllllllllllllIlIIllllllII);
            }
            case 11: {
                return this.matchesVillager(llllllllllllllllllllIlIIllllllIl, llllllllllllllllllllIlIIllllllII);
            }
            default: {
                return true;
            }
        }
    }
    
    public EnumContainer getContainer() {
        return this.container;
    }
    
    private boolean matchesShulker(final BlockPos llllllllllllllllllllIlIlIIIIlIIl, final IBlockAccess llllllllllllllllllllIlIlIIIIllll) {
        final TileEntity llllllllllllllllllllIlIlIIIIlllI = llllllllllllllllllllIlIlIIIIllll.getTileEntity(llllllllllllllllllllIlIlIIIIlIIl);
        if (!(llllllllllllllllllllIlIlIIIIlllI instanceof TileEntityShulkerBox)) {
            return false;
        }
        final TileEntityShulkerBox llllllllllllllllllllIlIlIIIIllIl = (TileEntityShulkerBox)llllllllllllllllllllIlIlIIIIlllI;
        if (this.nbtName != null) {
            final String llllllllllllllllllllIlIlIIIIllII = llllllllllllllllllllIlIlIIIIllIl.getName();
            if (!this.nbtName.matchesValue(llllllllllllllllllllIlIlIIIIllII)) {
                return false;
            }
        }
        if (this.colors != null) {
            final EnumDyeColor llllllllllllllllllllIlIlIIIIlIll = llllllllllllllllllllIlIlIIIIllIl.func_190592_s();
            if (!Config.equalsOne(llllllllllllllllllllIlIlIIIIlIll, this.colors)) {
                return false;
            }
        }
        return true;
    }
    
    private EnumVariant getDispenserVariant(final TileEntityDispenser llllllllllllllllllllIlIlIIIllIIl) {
        return (llllllllllllllllllllIlIlIIIllIIl instanceof TileEntityDropper) ? EnumVariant.DROPPER : EnumVariant.DISPENSER;
    }
    
    private boolean matchesChest(final BlockPos llllllllllllllllllllIlIlIllIIIIl, final IBlockAccess llllllllllllllllllllIlIlIllIIIII) {
        final TileEntity llllllllllllllllllllIlIlIllIIlIl = llllllllllllllllllllIlIlIllIIIII.getTileEntity(llllllllllllllllllllIlIlIllIIIIl);
        if (llllllllllllllllllllIlIlIllIIlIl instanceof TileEntityChest) {
            final TileEntityChest llllllllllllllllllllIlIlIllIIlII = (TileEntityChest)llllllllllllllllllllIlIlIllIIlIl;
            return this.matchesChest(llllllllllllllllllllIlIlIllIIlII, llllllllllllllllllllIlIlIllIIIIl, llllllllllllllllllllIlIlIllIIIII);
        }
        if (llllllllllllllllllllIlIlIllIIlIl instanceof TileEntityEnderChest) {
            final TileEntityEnderChest llllllllllllllllllllIlIlIllIIIll = (TileEntityEnderChest)llllllllllllllllllllIlIlIllIIlIl;
            return this.matchesEnderChest(llllllllllllllllllllIlIlIllIIIll, llllllllllllllllllllIlIlIllIIIIl, llllllllllllllllllllIlIlIllIIIII);
        }
        return false;
    }
    
    private boolean matchesNameable(final BlockPos llllllllllllllllllllIlIllIIIIlIl, final IBlockAccess llllllllllllllllllllIlIllIIIlIlI) {
        final TileEntity llllllllllllllllllllIlIllIIIlIIl = llllllllllllllllllllIlIllIIIlIlI.getTileEntity(llllllllllllllllllllIlIllIIIIlIl);
        if (!(llllllllllllllllllllIlIllIIIlIIl instanceof IWorldNameable)) {
            return false;
        }
        final IWorldNameable llllllllllllllllllllIlIllIIIlIII = (IWorldNameable)llllllllllllllllllllIlIllIIIlIIl;
        if (this.nbtName != null) {
            final String llllllllllllllllllllIlIllIIIIlll = llllllllllllllllllllIlIllIIIlIII.getName();
            if (!this.nbtName.matchesValue(llllllllllllllllllllIlIllIIIIlll)) {
                return false;
            }
        }
        return true;
    }
    
    private static int[] parseCareerIds(final int llllllllllllllllllllIllIIIIIlIII, final String llllllllllllllllllllIlIlllllllll) {
        final IntSet llllllllllllllllllllIllIIIIIIllI = (IntSet)new IntArraySet();
        final String[] llllllllllllllllllllIllIIIIIIlIl = Config.tokenize(llllllllllllllllllllIlIlllllllll, ",");
        for (int llllllllllllllllllllIllIIIIIIlII = 0; llllllllllllllllllllIllIIIIIIlII < llllllllllllllllllllIllIIIIIIlIl.length; ++llllllllllllllllllllIllIIIIIIlII) {
            final String llllllllllllllllllllIllIIIIIIIll = llllllllllllllllllllIllIIIIIIlIl[llllllllllllllllllllIllIIIIIIlII];
            final int llllllllllllllllllllIllIIIIIIIlI = parseCareerId(llllllllllllllllllllIllIIIIIlIII, llllllllllllllllllllIllIIIIIIIll);
            if (llllllllllllllllllllIllIIIIIIIlI < 0) {
                return null;
            }
            llllllllllllllllllllIllIIIIIIllI.add(llllllllllllllllllllIllIIIIIIIlI);
        }
        final int[] llllllllllllllllllllIllIIIIIIIIl = llllllllllllllllllllIllIIIIIIllI.toIntArray();
        return llllllllllllllllllllIllIIIIIIIIl;
    }
    
    private static VillagerProfession parseProfession(String llllllllllllllllllllIllIIIIllIll) {
        llllllllllllllllllllIllIIIIllIll = llllllllllllllllllllIllIIIIllIll.toLowerCase();
        final String[] llllllllllllllllllllIllIIIlIIIII = Config.tokenize(llllllllllllllllllllIllIIIIllIll, ":");
        if (llllllllllllllllllllIllIIIlIIIII.length > 2) {
            return null;
        }
        final String llllllllllllllllllllIllIIIIlllll = llllllllllllllllllllIllIIIlIIIII[0];
        String llllllllllllllllllllIllIIIIllllI = null;
        if (llllllllllllllllllllIllIIIlIIIII.length > 1) {
            llllllllllllllllllllIllIIIIllllI = llllllllllllllllllllIllIIIlIIIII[1];
        }
        final int llllllllllllllllllllIllIIIIlllIl = parseProfessionId(llllllllllllllllllllIllIIIIlllll);
        if (llllllllllllllllllllIllIIIIlllIl < 0) {
            return null;
        }
        int[] llllllllllllllllllllIllIIIIlllII = null;
        if (llllllllllllllllllllIllIIIIllllI != null) {
            llllllllllllllllllllIllIIIIlllII = parseCareerIds(llllllllllllllllllllIllIIIIlllIl, llllllllllllllllllllIllIIIIllllI);
            if (llllllllllllllllllllIllIIIIlllII == null) {
                return null;
            }
        }
        return new VillagerProfession(llllllllllllllllllllIllIIIIlllIl, llllllllllllllllllllIllIIIIlllII);
    }
    
    private static ResourceLocation parseTextureLocation(String llllllllllllllllllllIlIllllIllIl, final String llllllllllllllllllllIlIllllIlIIl) {
        if (llllllllllllllllllllIlIllllIllIl == null) {
            return null;
        }
        llllllllllllllllllllIlIllllIllIl = llllllllllllllllllllIlIllllIllIl.trim();
        String llllllllllllllllllllIlIllllIlIll = TextureUtils.fixResourcePath(llllllllllllllllllllIlIllllIllIl, llllllllllllllllllllIlIllllIlIIl);
        if (!llllllllllllllllllllIlIllllIlIll.endsWith(".png")) {
            llllllllllllllllllllIlIllllIlIll = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllllIlIllllIlIll)).append(".png"));
        }
        return new ResourceLocation(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllllllllIlIllllIlIIl)).append("/").append(llllllllllllllllllllIlIllllIlIll)));
    }
    
    public ResourceLocation getTextureLocation(final ResourceLocation llllllllllllllllllllIlIIlIlllIlI) {
        final ResourceLocation llllllllllllllllllllIlIIlIllllII = this.textureLocations.get(llllllllllllllllllllIlIIlIlllIlI);
        return (llllllllllllllllllllIlIIlIllllII == null) ? llllllllllllllllllllIlIIlIlllIlI : llllllllllllllllllllIlIIlIllllII;
    }
    
    private boolean matchesChest(final TileEntityChest llllllllllllllllllllIlIlIlIlIlIl, final BlockPos llllllllllllllllllllIlIlIlIlIlII, final IBlockAccess llllllllllllllllllllIlIlIlIlIIll) {
        final boolean llllllllllllllllllllIlIlIlIlIIlI = llllllllllllllllllllIlIlIlIlIlIl.adjacentChestXNeg != null || llllllllllllllllllllIlIlIlIlIlIl.adjacentChestXPos != null || llllllllllllllllllllIlIlIlIlIlIl.adjacentChestZNeg != null || llllllllllllllllllllIlIlIlIlIlIl.adjacentChestZPos != null;
        final boolean llllllllllllllllllllIlIlIlIlIIIl = llllllllllllllllllllIlIlIlIlIlIl.getChestType() == BlockChest.Type.TRAP;
        final boolean llllllllllllllllllllIlIlIlIlIIII = CustomGuis.isChristmas;
        final boolean llllllllllllllllllllIlIlIlIIllll = false;
        final String llllllllllllllllllllIlIlIlIIlllI = llllllllllllllllllllIlIlIlIlIlIl.getName();
        return this.matchesChest(llllllllllllllllllllIlIlIlIlIIlI, llllllllllllllllllllIlIlIlIlIIIl, llllllllllllllllllllIlIlIlIlIIII, llllllllllllllllllllIlIlIlIIllll, llllllllllllllllllllIlIlIlIIlllI);
    }
    
    private static VillagerProfession[] parseProfessions(final String llllllllllllllllllllIllIIIllIlII) {
        if (llllllllllllllllllllIllIIIllIlII == null) {
            return null;
        }
        final List<VillagerProfession> llllllllllllllllllllIllIIIllIIll = new ArrayList<VillagerProfession>();
        final String[] llllllllllllllllllllIllIIIllIIlI = Config.tokenize(llllllllllllllllllllIllIIIllIlII, " ");
        for (int llllllllllllllllllllIllIIIllIIIl = 0; llllllllllllllllllllIllIIIllIIIl < llllllllllllllllllllIllIIIllIIlI.length; ++llllllllllllllllllllIllIIIllIIIl) {
            final String llllllllllllllllllllIllIIIllIIII = llllllllllllllllllllIllIIIllIIlI[llllllllllllllllllllIllIIIllIIIl];
            final VillagerProfession llllllllllllllllllllIllIIIlIllll = parseProfession(llllllllllllllllllllIllIIIllIIII);
            if (llllllllllllllllllllIllIIIlIllll == null) {
                warn(String.valueOf(new StringBuilder("Invalid profession: ").append(llllllllllllllllllllIllIIIllIIII)));
                return CustomGuiProperties.PROFESSIONS_INVALID;
            }
            llllllllllllllllllllIllIIIllIIll.add(llllllllllllllllllllIllIIIlIllll);
        }
        if (llllllllllllllllllllIllIIIllIIll.isEmpty()) {
            return null;
        }
        final VillagerProfession[] llllllllllllllllllllIllIIIlIlllI = llllllllllllllllllllIllIIIllIIll.toArray(new VillagerProfession[llllllllllllllllllllIllIIIllIIll.size()]);
        return llllllllllllllllllllIllIIIlIlllI;
    }
    
    private boolean matchesBeacon(final BlockPos llllllllllllllllllllIlIlIlllIIlI, final IBlockAccess llllllllllllllllllllIlIlIllllIII) {
        final TileEntity llllllllllllllllllllIlIlIlllIlll = llllllllllllllllllllIlIlIllllIII.getTileEntity(llllllllllllllllllllIlIlIlllIIlI);
        if (!(llllllllllllllllllllIlIlIlllIlll instanceof TileEntityBeacon)) {
            return false;
        }
        final TileEntityBeacon llllllllllllllllllllIlIlIlllIllI = (TileEntityBeacon)llllllllllllllllllllIlIlIlllIlll;
        if (this.levels != null) {
            final int llllllllllllllllllllIlIlIlllIlIl = llllllllllllllllllllIlIlIlllIllI.func_191979_s();
            if (!this.levels.isInRange(llllllllllllllllllllIlIlIlllIlIl)) {
                return false;
            }
        }
        if (this.nbtName != null) {
            final String llllllllllllllllllllIlIlIlllIlII = llllllllllllllllllllIlIlIlllIllI.getName();
            if (!this.nbtName.matchesValue(llllllllllllllllllllIlIlIlllIlII)) {
                return false;
            }
        }
        return true;
    }
    
    static {
        PROFESSIONS_INVALID = new VillagerProfession[0];
        VARIANTS_HORSE = new EnumVariant[] { EnumVariant.HORSE, EnumVariant.DONKEY, EnumVariant.MULE, EnumVariant.LLAMA };
        VARIANTS_DISPENSER = new EnumVariant[] { EnumVariant.DISPENSER, EnumVariant.DROPPER };
        VARIANTS_INVALID = new EnumVariant[0];
        COLORS_INVALID = new EnumDyeColor[0];
        ANVIL_GUI_TEXTURE = new ResourceLocation("textures/gui/container/anvil.png");
        BEACON_GUI_TEXTURE = new ResourceLocation("textures/gui/container/beacon.png");
        BREWING_STAND_GUI_TEXTURE = new ResourceLocation("textures/gui/container/brewing_stand.png");
        CHEST_GUI_TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");
        CRAFTING_TABLE_GUI_TEXTURE = new ResourceLocation("textures/gui/container/crafting_table.png");
        HORSE_GUI_TEXTURE = new ResourceLocation("textures/gui/container/horse.png");
        DISPENSER_GUI_TEXTURE = new ResourceLocation("textures/gui/container/dispenser.png");
        ENCHANTMENT_TABLE_GUI_TEXTURE = new ResourceLocation("textures/gui/container/enchanting_table.png");
        FURNACE_GUI_TEXTURE = new ResourceLocation("textures/gui/container/furnace.png");
        HOPPER_GUI_TEXTURE = new ResourceLocation("textures/gui/container/hopper.png");
        INVENTORY_GUI_TEXTURE = new ResourceLocation("textures/gui/container/inventory.png");
        SHULKER_BOX_GUI_TEXTURE = new ResourceLocation("textures/gui/container/shulker_box.png");
        VILLAGER_GUI_TEXTURE = new ResourceLocation("textures/gui/container/villager.png");
    }
    
    public enum EnumContainer
    {
        CHEST("CHEST", 3), 
        DISPENSER("DISPENSER", 5), 
        VILLAGER("VILLAGER", 10), 
        INVENTORY("INVENTORY", 13), 
        HORSE("HORSE", 9), 
        FURNACE("FURNACE", 7), 
        HOPPER("HOPPER", 8), 
        ENCHANTMENT("ENCHANTMENT", 6), 
        BEACON("BEACON", 1), 
        BREWING_STAND("BREWING_STAND", 2), 
        CREATIVE("CREATIVE", 12), 
        CRAFTING("CRAFTING", 4), 
        SHULKER_BOX("SHULKER_BOX", 11), 
        ANVIL("ANVIL", 0);
        
        private EnumContainer(final String lllllllllllllIIlIlIlIlIlIIlIIIlI, final int lllllllllllllIIlIlIlIlIlIIlIIIIl) {
        }
    }
    
    private enum EnumVariant
    {
        DISPENSER("DISPENSER", 4), 
        MULE("MULE", 2), 
        HORSE("HORSE", 0), 
        LLAMA("LLAMA", 3), 
        DROPPER("DROPPER", 5), 
        DONKEY("DONKEY", 1);
        
        private EnumVariant(final String lllllllllllllllIIlIlIIllIIlIllIl, final int lllllllllllllllIIlIlIIllIIlIllII) {
        }
    }
}
