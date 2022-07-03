package optifine;

import com.google.gson.*;

public class PlayerConfigurationReceiver implements IFileDownloadListener
{
    private /* synthetic */ String player;
    
    @Override
    public void fileDownloadFinished(final String lllllllllllllIIlIllIllllllIIIlll, final byte[] lllllllllllllIIlIllIllllllIIIllI, final Throwable lllllllllllllIIlIllIllllllIIIlIl) {
        if (lllllllllllllIIlIllIllllllIIIllI != null) {
            try {
                final String lllllllllllllIIlIllIllllllIIIlII = new String(lllllllllllllIIlIllIllllllIIIllI, "ASCII");
                final JsonParser lllllllllllllIIlIllIllllllIIIIll = new JsonParser();
                final JsonElement lllllllllllllIIlIllIllllllIIIIlI = lllllllllllllIIlIllIllllllIIIIll.parse(lllllllllllllIIlIllIllllllIIIlII);
                final PlayerConfigurationParser lllllllllllllIIlIllIllllllIIIIIl = new PlayerConfigurationParser(this.player);
                final PlayerConfiguration lllllllllllllIIlIllIllllllIIIIII = lllllllllllllIIlIllIllllllIIIIIl.parsePlayerConfiguration(lllllllllllllIIlIllIllllllIIIIlI);
                if (lllllllllllllIIlIllIllllllIIIIII != null) {
                    lllllllllllllIIlIllIllllllIIIIII.setInitialized(true);
                    PlayerConfigurations.setPlayerConfiguration(this.player, lllllllllllllIIlIllIllllllIIIIII);
                }
            }
            catch (Exception lllllllllllllIIlIllIlllllIllllll) {
                Config.dbg(String.valueOf(new StringBuilder("Error parsing configuration: ").append(lllllllllllllIIlIllIllllllIIIlll).append(", ").append(lllllllllllllIIlIllIlllllIllllll.getClass().getName()).append(": ").append(lllllllllllllIIlIllIlllllIllllll.getMessage())));
            }
        }
    }
    
    public PlayerConfigurationReceiver(final String lllllllllllllIIlIllIllllllIlIIIl) {
        this.player = null;
        this.player = lllllllllllllIIlIllIllllllIlIIIl;
    }
}
