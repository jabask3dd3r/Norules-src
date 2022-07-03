package net.minecraft.realms;

import net.minecraft.client.*;
import java.lang.reflect.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.gui.*;

public class RealmsBridge extends RealmsScreen
{
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ GuiScreen previousScreen;
    
    public void switchToRealms(final GuiScreen llllllllllllllIIIlIlllIIllllllII) {
        this.previousScreen = llllllllllllllIIIlIlllIIllllllII;
        try {
            final Class<?> llllllllllllllIIIlIlllIIlllllIll = Class.forName("com.mojang.realmsclient.RealmsMainScreen");
            final Constructor<?> llllllllllllllIIIlIlllIIlllllIlI = llllllllllllllIIIlIlllIIlllllIll.getDeclaredConstructor(RealmsScreen.class);
            llllllllllllllIIIlIlllIIlllllIlI.setAccessible(true);
            final Object llllllllllllllIIIlIlllIIlllllIIl = llllllllllllllIIIlIlllIIlllllIlI.newInstance(this);
            Minecraft.getMinecraft().displayGuiScreen(((RealmsScreen)llllllllllllllIIIlIlllIIlllllIIl).getProxy());
        }
        catch (ClassNotFoundException llllllllllllllIIIlIlllIIlllllIII) {
            RealmsBridge.LOGGER.error("Realms module missing");
        }
        catch (Exception llllllllllllllIIIlIlllIIllllIlll) {
            RealmsBridge.LOGGER.error("Failed to load Realms module", (Throwable)llllllllllllllIIIlIlllIIllllIlll);
        }
    }
    
    @Override
    public void init() {
        Minecraft.getMinecraft().displayGuiScreen(this.previousScreen);
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public GuiScreenRealmsProxy getNotificationScreen(final GuiScreen llllllllllllllIIIlIlllIIlllIlIll) {
        try {
            this.previousScreen = llllllllllllllIIIlIlllIIlllIlIll;
            final Class<?> llllllllllllllIIIlIlllIIlllIlIlI = Class.forName("com.mojang.realmsclient.gui.screens.RealmsNotificationsScreen");
            final Constructor<?> llllllllllllllIIIlIlllIIlllIlIIl = llllllllllllllIIIlIlllIIlllIlIlI.getDeclaredConstructor(RealmsScreen.class);
            llllllllllllllIIIlIlllIIlllIlIIl.setAccessible(true);
            final Object llllllllllllllIIIlIlllIIlllIlIII = llllllllllllllIIIlIlllIIlllIlIIl.newInstance(this);
            return ((RealmsScreen)llllllllllllllIIIlIlllIIlllIlIII).getProxy();
        }
        catch (ClassNotFoundException llllllllllllllIIIlIlllIIlllIIlll) {
            RealmsBridge.LOGGER.error("Realms module missing");
        }
        catch (Exception llllllllllllllIIIlIlllIIlllIIllI) {
            RealmsBridge.LOGGER.error("Failed to load Realms module", (Throwable)llllllllllllllIIIlIlllIIlllIIllI);
        }
        return null;
    }
}
