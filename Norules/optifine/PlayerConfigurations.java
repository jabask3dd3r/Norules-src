package optifine;

import net.minecraft.client.model.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.*;
import java.util.*;

public class PlayerConfigurations
{
    private static /* synthetic */ boolean reloadPlayerItems;
    private static /* synthetic */ long timeReloadPlayerItemsMs;
    private static /* synthetic */ Map mapConfigurations;
    
    public static void renderPlayerItems(final ModelBiped lllllllllllllIIllIIlllIlIIIlIIIl, final AbstractClientPlayer lllllllllllllIIllIIlllIlIIIlIlIl, final float lllllllllllllIIllIIlllIlIIIIllll, final float lllllllllllllIIllIIlllIlIIIIlllI) {
        final PlayerConfiguration lllllllllllllIIllIIlllIlIIIlIIlI = getPlayerConfiguration(lllllllllllllIIllIIlllIlIIIlIlIl);
        if (lllllllllllllIIllIIlllIlIIIlIIlI != null) {
            lllllllllllllIIllIIlllIlIIIlIIlI.renderPlayerItems(lllllllllllllIIllIIlllIlIIIlIIIl, lllllllllllllIIllIIlllIlIIIlIlIl, lllllllllllllIIllIIlllIlIIIIllll, lllllllllllllIIllIIlllIlIIIIlllI);
        }
    }
    
    static {
        PlayerConfigurations.mapConfigurations = null;
        PlayerConfigurations.reloadPlayerItems = Boolean.getBoolean("player.models.reload");
        PlayerConfigurations.timeReloadPlayerItemsMs = System.currentTimeMillis();
    }
    
    public static synchronized void setPlayerConfiguration(final String lllllllllllllIIllIIlllIIllllIlIl, final PlayerConfiguration lllllllllllllIIllIIlllIIllllIllI) {
        getMapConfigurations().put(lllllllllllllIIllIIlllIIllllIlIl, lllllllllllllIIllIIlllIIllllIllI);
    }
    
    public static synchronized PlayerConfiguration getPlayerConfiguration(final AbstractClientPlayer lllllllllllllIIllIIlllIlIIIIIllI) {
        if (PlayerConfigurations.reloadPlayerItems && System.currentTimeMillis() > PlayerConfigurations.timeReloadPlayerItemsMs + 5000L) {
            final AbstractClientPlayer lllllllllllllIIllIIlllIlIIIIIlIl = Minecraft.getMinecraft().player;
            if (lllllllllllllIIllIIlllIlIIIIIlIl != null) {
                setPlayerConfiguration(lllllllllllllIIllIIlllIlIIIIIlIl.getNameClear(), null);
                PlayerConfigurations.timeReloadPlayerItemsMs = System.currentTimeMillis();
            }
        }
        final String lllllllllllllIIllIIlllIlIIIIIlII = lllllllllllllIIllIIlllIlIIIIIllI.getNameClear();
        if (lllllllllllllIIllIIlllIlIIIIIlII == null) {
            return null;
        }
        PlayerConfiguration lllllllllllllIIllIIlllIlIIIIIIll = getMapConfigurations().get(lllllllllllllIIllIIlllIlIIIIIlII);
        if (lllllllllllllIIllIIlllIlIIIIIIll == null) {
            lllllllllllllIIllIIlllIlIIIIIIll = new PlayerConfiguration();
            getMapConfigurations().put(lllllllllllllIIllIIlllIlIIIIIlII, lllllllllllllIIllIIlllIlIIIIIIll);
            final PlayerConfigurationReceiver lllllllllllllIIllIIlllIlIIIIIIlI = new PlayerConfigurationReceiver(lllllllllllllIIllIIlllIlIIIIIlII);
            final String lllllllllllllIIllIIlllIlIIIIIIIl = String.valueOf(new StringBuilder(String.valueOf(HttpUtils.getPlayerItemsUrl())).append("/users/").append(lllllllllllllIIllIIlllIlIIIIIlII).append(".cfg"));
            final FileDownloadThread lllllllllllllIIllIIlllIlIIIIIIII = new FileDownloadThread(lllllllllllllIIllIIlllIlIIIIIIIl, lllllllllllllIIllIIlllIlIIIIIIlI);
            lllllllllllllIIllIIlllIlIIIIIIII.start();
        }
        return lllllllllllllIIllIIlllIlIIIIIIll;
    }
    
    private static Map getMapConfigurations() {
        if (PlayerConfigurations.mapConfigurations == null) {
            PlayerConfigurations.mapConfigurations = new HashMap();
        }
        return PlayerConfigurations.mapConfigurations;
    }
}
