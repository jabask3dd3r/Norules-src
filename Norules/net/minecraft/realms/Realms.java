package net.minecraft.realms;

import java.net.*;
import net.minecraft.client.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.client.settings.*;
import com.mojang.util.*;
import com.mojang.authlib.*;
import com.google.common.util.concurrent.*;
import net.minecraft.client.gui.*;
import java.io.*;
import net.minecraft.nbt.*;

public class Realms
{
    public static Proxy getProxy() {
        return Minecraft.getMinecraft().getProxy();
    }
    
    public static int spectatorId() {
        return GameType.SPECTATOR.getID();
    }
    
    public static int creativeId() {
        return GameType.CREATIVE.getID();
    }
    
    public static String sessionId() {
        final Session lIIlIlllIlllll = Minecraft.getMinecraft().getSession();
        return (lIIlIlllIlllll == null) ? null : lIIlIlllIlllll.getSessionID();
    }
    
    public static String getSessionId() {
        return Minecraft.getMinecraft().getSession().getSessionID();
    }
    
    public static String getUUID() {
        return Minecraft.getMinecraft().getSession().getPlayerID();
    }
    
    public static String userName() {
        final Session lIIlIlllIlllII = Minecraft.getMinecraft().getSession();
        return (lIIlIlllIlllII == null) ? null : lIIlIlllIlllII.getUsername();
    }
    
    public static int survivalId() {
        return GameType.SURVIVAL.getID();
    }
    
    public static boolean getRealmsNotificationsEnabled() {
        return Minecraft.getMinecraft().gameSettings.getOptionOrdinalValue(GameSettings.Options.REALMS_NOTIFICATIONS);
    }
    
    public static int adventureId() {
        return GameType.ADVENTURE.getID();
    }
    
    public static boolean inTitleScreen() {
        return Minecraft.getMinecraft().currentScreen != null && Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu;
    }
    
    public static String uuidToName(final String lIIlIlllIllIII) {
        return Minecraft.getMinecraft().getSessionService().fillProfileProperties(new GameProfile(UUIDTypeAdapter.fromString(lIIlIlllIllIII), (String)null), false).getName();
    }
    
    public static long currentTimeMillis() {
        return Minecraft.getSystemTime();
    }
    
    public static ListenableFuture<Object> downloadResourcePack(final String lIIlIlllIIllll, final String lIIlIlllIIllII) {
        return Minecraft.getMinecraft().getResourcePackRepository().downloadResourcePack(lIIlIlllIIllll, lIIlIlllIIllII);
    }
    
    public static void setScreen(final RealmsScreen lIIlIlllIlIllI) {
        Minecraft.getMinecraft().displayGuiScreen(lIIlIlllIlIllI.getProxy());
    }
    
    public static void setConnectedToRealms(final boolean lIIlIlllIlIIll) {
        Minecraft.getMinecraft().setConnectedToRealms(lIIlIlllIlIIll);
    }
    
    public static String getName() {
        return Minecraft.getMinecraft().getSession().getUsername();
    }
    
    public static void clearResourcePack() {
        Minecraft.getMinecraft().getResourcePackRepository().clearResourcePack();
    }
    
    public static String getGameDirectoryPath() {
        return Minecraft.getMinecraft().mcDataDir.getAbsolutePath();
    }
    
    public static void deletePlayerTag(final File lIIlIlllIIlIII) {
        if (lIIlIlllIIlIII.exists()) {
            try {
                final NBTTagCompound lIIlIlllIIIlll = CompressedStreamTools.readCompressed(new FileInputStream(lIIlIlllIIlIII));
                final NBTTagCompound lIIlIlllIIIllI = lIIlIlllIIIlll.getCompoundTag("Data");
                lIIlIlllIIIllI.removeTag("Player");
                CompressedStreamTools.writeCompressed(lIIlIlllIIIlll, new FileOutputStream(lIIlIlllIIlIII));
            }
            catch (Exception lIIlIlllIIIlIl) {
                lIIlIlllIIIlIl.printStackTrace();
            }
        }
    }
    
    public static boolean isTouchScreen() {
        return Minecraft.getMinecraft().gameSettings.touchscreen;
    }
}
