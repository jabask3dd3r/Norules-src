package optifine;

import net.minecraft.client.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.client.gui.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import java.util.*;

public class CustomGuis
{
    private static /* synthetic */ PlayerControllerOF playerControllerOF;
    public static /* synthetic */ boolean isChristmas;
    private static /* synthetic */ CustomGuiProperties[][] guiProperties;
    private static /* synthetic */ Minecraft mc;
    
    private static void update(final IResourcePack lllllllllllllIIlIlIlIllIIlIlIlIl, final List<List<CustomGuiProperties>> lllllllllllllIIlIlIlIllIIlIIlIIl) {
        final String[] lllllllllllllIIlIlIlIllIIlIlIIll = ResUtils.collectFiles(lllllllllllllIIlIlIlIllIIlIlIlIl, "optifine/gui/container/", ".properties", null);
        Arrays.sort(lllllllllllllIIlIlIlIllIIlIlIIll);
        for (int lllllllllllllIIlIlIlIllIIlIlIIlI = 0; lllllllllllllIIlIlIlIllIIlIlIIlI < lllllllllllllIIlIlIlIllIIlIlIIll.length; ++lllllllllllllIIlIlIlIllIIlIlIIlI) {
            final String lllllllllllllIIlIlIlIllIIlIlIIIl = lllllllllllllIIlIlIlIllIIlIlIIll[lllllllllllllIIlIlIlIllIIlIlIIlI];
            Config.dbg(String.valueOf(new StringBuilder("CustomGuis: ").append(lllllllllllllIIlIlIlIllIIlIlIIIl)));
            try {
                final ResourceLocation lllllllllllllIIlIlIlIllIIlIlIIII = new ResourceLocation(lllllllllllllIIlIlIlIllIIlIlIIIl);
                final InputStream lllllllllllllIIlIlIlIllIIlIIllll = lllllllllllllIIlIlIlIllIIlIlIlIl.getInputStream(lllllllllllllIIlIlIlIllIIlIlIIII);
                if (lllllllllllllIIlIlIlIllIIlIIllll == null) {
                    Config.warn(String.valueOf(new StringBuilder("CustomGuis file not found: ").append(lllllllllllllIIlIlIlIllIIlIlIIIl)));
                }
                else {
                    final Properties lllllllllllllIIlIlIlIllIIlIIlllI = new Properties();
                    lllllllllllllIIlIlIlIllIIlIIlllI.load(lllllllllllllIIlIlIlIllIIlIIllll);
                    lllllllllllllIIlIlIlIllIIlIIllll.close();
                    final CustomGuiProperties lllllllllllllIIlIlIlIllIIlIIllIl = new CustomGuiProperties(lllllllllllllIIlIlIlIllIIlIIlllI, lllllllllllllIIlIlIlIllIIlIlIIIl);
                    if (lllllllllllllIIlIlIlIllIIlIIllIl.isValid(lllllllllllllIIlIlIlIllIIlIlIIIl)) {
                        addToList(lllllllllllllIIlIlIlIllIIlIIllIl, lllllllllllllIIlIlIlIllIIlIIlIIl);
                    }
                }
            }
            catch (FileNotFoundException lllllllllllllIIlIlIlIllIIlIIllII) {
                Config.warn(String.valueOf(new StringBuilder("CustomGuis file not found: ").append(lllllllllllllIIlIlIlIllIIlIlIIIl)));
            }
            catch (Exception lllllllllllllIIlIlIlIllIIlIIlIll) {
                lllllllllllllIIlIlIlIllIIlIIlIll.printStackTrace();
            }
        }
    }
    
    public static ResourceLocation getTextureLocation(final ResourceLocation lllllllllllllIIlIlIlIllIlIlIlIII) {
        if (CustomGuis.guiProperties == null) {
            return lllllllllllllIIlIlIlIllIlIlIlIII;
        }
        final GuiScreen lllllllllllllIIlIlIlIllIlIlIllII = CustomGuis.mc.currentScreen;
        if (!(lllllllllllllIIlIlIlIllIlIlIllII instanceof GuiContainer)) {
            return lllllllllllllIIlIlIlIllIlIlIlIII;
        }
        if (!lllllllllllllIIlIlIlIllIlIlIlIII.getResourceDomain().equals("minecraft") || !lllllllllllllIIlIlIlIllIlIlIlIII.getResourcePath().startsWith("textures/gui/")) {
            return lllllllllllllIIlIlIlIllIlIlIlIII;
        }
        if (CustomGuis.playerControllerOF == null) {
            return lllllllllllllIIlIlIlIllIlIlIlIII;
        }
        final IBlockAccess lllllllllllllIIlIlIlIllIlIlIlIll = CustomGuis.mc.world;
        if (lllllllllllllIIlIlIlIllIlIlIlIll == null) {
            return lllllllllllllIIlIlIlIllIlIlIlIII;
        }
        if (lllllllllllllIIlIlIlIllIlIlIllII instanceof GuiContainerCreative) {
            return getTexturePos(CustomGuiProperties.EnumContainer.CREATIVE, CustomGuis.mc.player.getPosition(), lllllllllllllIIlIlIlIllIlIlIlIll, lllllllllllllIIlIlIlIllIlIlIlIII);
        }
        if (lllllllllllllIIlIlIlIllIlIlIllII instanceof GuiInventory) {
            return getTexturePos(CustomGuiProperties.EnumContainer.INVENTORY, CustomGuis.mc.player.getPosition(), lllllllllllllIIlIlIlIllIlIlIlIll, lllllllllllllIIlIlIlIllIlIlIlIII);
        }
        final BlockPos lllllllllllllIIlIlIlIllIlIlIlIlI = CustomGuis.playerControllerOF.getLastClickBlockPos();
        if (lllllllllllllIIlIlIlIllIlIlIlIlI != null) {
            if (lllllllllllllIIlIlIlIllIlIlIllII instanceof GuiRepair) {
                return getTexturePos(CustomGuiProperties.EnumContainer.ANVIL, lllllllllllllIIlIlIlIllIlIlIlIlI, lllllllllllllIIlIlIlIllIlIlIlIll, lllllllllllllIIlIlIlIllIlIlIlIII);
            }
            if (lllllllllllllIIlIlIlIllIlIlIllII instanceof GuiBeacon) {
                return getTexturePos(CustomGuiProperties.EnumContainer.BEACON, lllllllllllllIIlIlIlIllIlIlIlIlI, lllllllllllllIIlIlIlIllIlIlIlIll, lllllllllllllIIlIlIlIllIlIlIlIII);
            }
            if (lllllllllllllIIlIlIlIllIlIlIllII instanceof GuiBrewingStand) {
                return getTexturePos(CustomGuiProperties.EnumContainer.BREWING_STAND, lllllllllllllIIlIlIlIllIlIlIlIlI, lllllllllllllIIlIlIlIllIlIlIlIll, lllllllllllllIIlIlIlIllIlIlIlIII);
            }
            if (lllllllllllllIIlIlIlIllIlIlIllII instanceof GuiChest) {
                return getTexturePos(CustomGuiProperties.EnumContainer.CHEST, lllllllllllllIIlIlIlIllIlIlIlIlI, lllllllllllllIIlIlIlIllIlIlIlIll, lllllllllllllIIlIlIlIllIlIlIlIII);
            }
            if (lllllllllllllIIlIlIlIllIlIlIllII instanceof GuiCrafting) {
                return getTexturePos(CustomGuiProperties.EnumContainer.CRAFTING, lllllllllllllIIlIlIlIllIlIlIlIlI, lllllllllllllIIlIlIlIllIlIlIlIll, lllllllllllllIIlIlIlIllIlIlIlIII);
            }
            if (lllllllllllllIIlIlIlIllIlIlIllII instanceof GuiDispenser) {
                return getTexturePos(CustomGuiProperties.EnumContainer.DISPENSER, lllllllllllllIIlIlIlIllIlIlIlIlI, lllllllllllllIIlIlIlIllIlIlIlIll, lllllllllllllIIlIlIlIllIlIlIlIII);
            }
            if (lllllllllllllIIlIlIlIllIlIlIllII instanceof GuiEnchantment) {
                return getTexturePos(CustomGuiProperties.EnumContainer.ENCHANTMENT, lllllllllllllIIlIlIlIllIlIlIlIlI, lllllllllllllIIlIlIlIllIlIlIlIll, lllllllllllllIIlIlIlIllIlIlIlIII);
            }
            if (lllllllllllllIIlIlIlIllIlIlIllII instanceof GuiFurnace) {
                return getTexturePos(CustomGuiProperties.EnumContainer.FURNACE, lllllllllllllIIlIlIlIllIlIlIlIlI, lllllllllllllIIlIlIlIllIlIlIlIll, lllllllllllllIIlIlIlIllIlIlIlIII);
            }
            if (lllllllllllllIIlIlIlIllIlIlIllII instanceof GuiHopper) {
                return getTexturePos(CustomGuiProperties.EnumContainer.HOPPER, lllllllllllllIIlIlIlIllIlIlIlIlI, lllllllllllllIIlIlIlIllIlIlIlIll, lllllllllllllIIlIlIlIllIlIlIlIII);
            }
            if (lllllllllllllIIlIlIlIllIlIlIllII instanceof GuiShulkerBox) {
                return getTexturePos(CustomGuiProperties.EnumContainer.SHULKER_BOX, lllllllllllllIIlIlIlIllIlIlIlIlI, lllllllllllllIIlIlIlIllIlIlIlIll, lllllllllllllIIlIlIlIllIlIlIlIII);
            }
        }
        final Entity lllllllllllllIIlIlIlIllIlIlIlIIl = CustomGuis.playerControllerOF.getLastClickEntity();
        if (lllllllllllllIIlIlIlIllIlIlIlIIl != null) {
            if (lllllllllllllIIlIlIlIllIlIlIllII instanceof GuiScreenHorseInventory) {
                return getTextureEntity(CustomGuiProperties.EnumContainer.HORSE, lllllllllllllIIlIlIlIllIlIlIlIIl, lllllllllllllIIlIlIlIllIlIlIlIll, lllllllllllllIIlIlIlIllIlIlIlIII);
            }
            if (lllllllllllllIIlIlIlIllIlIlIllII instanceof GuiMerchant) {
                return getTextureEntity(CustomGuiProperties.EnumContainer.VILLAGER, lllllllllllllIIlIlIlIllIlIlIlIIl, lllllllllllllIIlIlIlIllIlIlIlIll, lllllllllllllIIlIlIlIllIlIlIlIII);
            }
        }
        return lllllllllllllIIlIlIlIllIlIlIlIII;
    }
    
    public static PlayerControllerOF getPlayerControllerOF() {
        return CustomGuis.playerControllerOF;
    }
    
    static {
        CustomGuis.mc = Config.getMinecraft();
        CustomGuis.playerControllerOF = null;
        CustomGuis.guiProperties = null;
        CustomGuis.isChristmas = isChristmas();
    }
    
    private static void warn(final String lllllllllllllIIlIlIlIllIIIlIlllI) {
        Config.warn(String.valueOf(new StringBuilder("[CustomGuis] ").append(lllllllllllllIIlIlIlIllIIIlIlllI)));
    }
    
    private static boolean isChristmas() {
        final Calendar lllllllllllllIIlIlIlIllIIIllIIIl = Calendar.getInstance();
        return lllllllllllllIIlIlIlIllIIIllIIIl.get(2) + 1 == 12 && lllllllllllllIIlIlIlIllIIIllIIIl.get(5) >= 24 && lllllllllllllIIlIlIlIllIIIllIIIl.get(5) <= 26;
    }
    
    public static void update() {
        CustomGuis.guiProperties = null;
        if (Config.isCustomGuis()) {
            final List<List<CustomGuiProperties>> lllllllllllllIIlIlIlIllIIlllIlIl = new ArrayList<List<CustomGuiProperties>>();
            final IResourcePack[] lllllllllllllIIlIlIlIllIIlllIlII = Config.getResourcePacks();
            for (int lllllllllllllIIlIlIlIllIIlllIIll = lllllllllllllIIlIlIlIllIIlllIlII.length - 1; lllllllllllllIIlIlIlIllIIlllIIll >= 0; --lllllllllllllIIlIlIlIllIIlllIIll) {
                final IResourcePack lllllllllllllIIlIlIlIllIIlllIIlI = lllllllllllllIIlIlIlIllIIlllIlII[lllllllllllllIIlIlIlIllIIlllIIll];
                update(lllllllllllllIIlIlIlIllIIlllIIlI, lllllllllllllIIlIlIlIllIIlllIlIl);
            }
            CustomGuis.guiProperties = propertyListToArray(lllllllllllllIIlIlIlIllIIlllIlIl);
        }
    }
    
    private static void addToList(final CustomGuiProperties lllllllllllllIIlIlIlIllIIIlllIIl, final List<List<CustomGuiProperties>> lllllllllllllIIlIlIlIllIIIlllIII) {
        if (lllllllllllllIIlIlIlIllIIIlllIIl.getContainer() == null) {
            warn(String.valueOf(new StringBuilder("Invalid container: ").append(lllllllllllllIIlIlIlIllIIIlllIIl.getContainer())));
        }
        else {
            final int lllllllllllllIIlIlIlIllIIIlllIll = lllllllllllllIIlIlIlIllIIIlllIIl.getContainer().ordinal();
            while (lllllllllllllIIlIlIlIllIIIlllIII.size() <= lllllllllllllIIlIlIlIllIIIlllIll) {
                lllllllllllllIIlIlIlIllIIIlllIII.add(null);
            }
            List<CustomGuiProperties> lllllllllllllIIlIlIlIllIIIlllIlI = lllllllllllllIIlIlIlIllIIIlllIII.get(lllllllllllllIIlIlIlIllIIIlllIll);
            if (lllllllllllllIIlIlIlIllIIIlllIlI == null) {
                lllllllllllllIIlIlIlIllIIIlllIlI = new ArrayList<CustomGuiProperties>();
                lllllllllllllIIlIlIlIllIIIlllIII.set(lllllllllllllIIlIlIlIllIIIlllIll, lllllllllllllIIlIlIlIllIIIlllIlI);
            }
            lllllllllllllIIlIlIlIllIIIlllIlI.add(lllllllllllllIIlIlIlIllIIIlllIIl);
        }
    }
    
    private static CustomGuiProperties[][] propertyListToArray(final List<List<CustomGuiProperties>> lllllllllllllIIlIlIlIllIIllIlIII) {
        if (lllllllllllllIIlIlIlIllIIllIlIII.isEmpty()) {
            return null;
        }
        final CustomGuiProperties[][] lllllllllllllIIlIlIlIllIIllIIlll = new CustomGuiProperties[CustomGuiProperties.EnumContainer.values().length][];
        for (int lllllllllllllIIlIlIlIllIIllIIllI = 0; lllllllllllllIIlIlIlIllIIllIIllI < lllllllllllllIIlIlIlIllIIllIIlll.length; ++lllllllllllllIIlIlIlIllIIllIIllI) {
            if (lllllllllllllIIlIlIlIllIIllIlIII.size() > lllllllllllllIIlIlIlIllIIllIIllI) {
                final List<CustomGuiProperties> lllllllllllllIIlIlIlIllIIllIIlIl = lllllllllllllIIlIlIlIllIIllIlIII.get(lllllllllllllIIlIlIlIllIIllIIllI);
                if (lllllllllllllIIlIlIlIllIIllIIlIl != null) {
                    final CustomGuiProperties[] lllllllllllllIIlIlIlIllIIllIIlII = lllllllllllllIIlIlIlIllIIllIIlIl.toArray(new CustomGuiProperties[lllllllllllllIIlIlIlIllIIllIIlIl.size()]);
                    lllllllllllllIIlIlIlIllIIllIIlll[lllllllllllllIIlIlIlIllIIllIIllI] = lllllllllllllIIlIlIlIllIIllIIlII;
                }
            }
        }
        return lllllllllllllIIlIlIlIllIIllIIlll;
    }
    
    public static void setPlayerControllerOF(final PlayerControllerOF lllllllllllllIIlIlIlIllIIIllIlII) {
        CustomGuis.playerControllerOF = lllllllllllllIIlIlIlIllIIIllIlII;
    }
    
    private static ResourceLocation getTexturePos(final CustomGuiProperties.EnumContainer lllllllllllllIIlIlIlIllIlIIlllII, final BlockPos lllllllllllllIIlIlIlIllIlIIlIlII, final IBlockAccess lllllllllllllIIlIlIlIllIlIIllIlI, final ResourceLocation lllllllllllllIIlIlIlIllIlIIlIIlI) {
        final CustomGuiProperties[] lllllllllllllIIlIlIlIllIlIIllIII = CustomGuis.guiProperties[lllllllllllllIIlIlIlIllIlIIlllII.ordinal()];
        if (lllllllllllllIIlIlIlIllIlIIllIII == null) {
            return lllllllllllllIIlIlIlIllIlIIlIIlI;
        }
        for (int lllllllllllllIIlIlIlIllIlIIlIlll = 0; lllllllllllllIIlIlIlIllIlIIlIlll < lllllllllllllIIlIlIlIllIlIIllIII.length; ++lllllllllllllIIlIlIlIllIlIIlIlll) {
            final CustomGuiProperties lllllllllllllIIlIlIlIllIlIIlIllI = lllllllllllllIIlIlIlIllIlIIllIII[lllllllllllllIIlIlIlIllIlIIlIlll];
            if (lllllllllllllIIlIlIlIllIlIIlIllI.matchesPos(lllllllllllllIIlIlIlIllIlIIlllII, lllllllllllllIIlIlIlIllIlIIlIlII, lllllllllllllIIlIlIlIllIlIIllIlI)) {
                return lllllllllllllIIlIlIlIllIlIIlIllI.getTextureLocation(lllllllllllllIIlIlIlIllIlIIlIIlI);
            }
        }
        return lllllllllllllIIlIlIlIllIlIIlIIlI;
    }
    
    private static ResourceLocation getTextureEntity(final CustomGuiProperties.EnumContainer lllllllllllllIIlIlIlIllIlIIIIlll, final Entity lllllllllllllIIlIlIlIllIIlllllll, final IBlockAccess lllllllllllllIIlIlIlIllIIllllllI, final ResourceLocation lllllllllllllIIlIlIlIllIIlllllIl) {
        final CustomGuiProperties[] lllllllllllllIIlIlIlIllIlIIIIIll = CustomGuis.guiProperties[lllllllllllllIIlIlIlIllIlIIIIlll.ordinal()];
        if (lllllllllllllIIlIlIlIllIlIIIIIll == null) {
            return lllllllllllllIIlIlIlIllIIlllllIl;
        }
        for (int lllllllllllllIIlIlIlIllIlIIIIIlI = 0; lllllllllllllIIlIlIlIllIlIIIIIlI < lllllllllllllIIlIlIlIllIlIIIIIll.length; ++lllllllllllllIIlIlIlIllIlIIIIIlI) {
            final CustomGuiProperties lllllllllllllIIlIlIlIllIlIIIIIIl = lllllllllllllIIlIlIlIllIlIIIIIll[lllllllllllllIIlIlIlIllIlIIIIIlI];
            if (lllllllllllllIIlIlIlIllIlIIIIIIl.matchesEntity(lllllllllllllIIlIlIlIllIlIIIIlll, lllllllllllllIIlIlIlIllIIlllllll, lllllllllllllIIlIlIlIllIIllllllI)) {
                return lllllllllllllIIlIlIlIllIlIIIIIIl.getTextureLocation(lllllllllllllIIlIlIlIllIIlllllIl);
            }
        }
        return lllllllllllllIIlIlIlIllIIlllllIl;
    }
}
