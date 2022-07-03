package net.minecraft.client.multiplayer;

import net.minecraft.nbt.*;
import net.minecraft.util.text.*;

public class ServerData
{
    private /* synthetic */ boolean lanServer;
    public /* synthetic */ String serverIP;
    public /* synthetic */ String serverName;
    public /* synthetic */ int version;
    private /* synthetic */ ServerResourceMode resourceMode;
    private /* synthetic */ String serverIcon;
    public /* synthetic */ String gameVersion;
    
    public String getBase64EncodedIconData() {
        return this.serverIcon;
    }
    
    public boolean isOnLAN() {
        return this.lanServer;
    }
    
    public NBTTagCompound getNBTCompound() {
        final NBTTagCompound lllllllllllllIlIlllIIllllIlIIlll = new NBTTagCompound();
        lllllllllllllIlIlllIIllllIlIIlll.setString("name", this.serverName);
        lllllllllllllIlIlllIIllllIlIIlll.setString("ip", this.serverIP);
        if (this.serverIcon != null) {
            lllllllllllllIlIlllIIllllIlIIlll.setString("icon", this.serverIcon);
        }
        if (this.resourceMode == ServerResourceMode.ENABLED) {
            lllllllllllllIlIlllIIllllIlIIlll.setBoolean("acceptTextures", true);
        }
        else if (this.resourceMode == ServerResourceMode.DISABLED) {
            lllllllllllllIlIlllIIllllIlIIlll.setBoolean("acceptTextures", false);
        }
        return lllllllllllllIlIlllIIllllIlIIlll;
    }
    
    public ServerData(final String lllllllllllllIlIlllIIllllIlIllIl, final String lllllllllllllIlIlllIIllllIlIllII, final boolean lllllllllllllIlIlllIIllllIlIllll) {
        this.version = 340;
        this.gameVersion = "1.12.2";
        this.resourceMode = ServerResourceMode.PROMPT;
        this.serverName = lllllllllllllIlIlllIIllllIlIllIl;
        this.serverIP = lllllllllllllIlIlllIIllllIlIllII;
        this.lanServer = lllllllllllllIlIlllIIllllIlIllll;
    }
    
    public void setBase64EncodedIconData(final String lllllllllllllIlIlllIIllllIIIllll) {
        this.serverIcon = lllllllllllllIlIlllIIllllIIIllll;
    }
    
    public static ServerData getServerDataFromNBTCompound(final NBTTagCompound lllllllllllllIlIlllIIllllIIlIlll) {
        final ServerData lllllllllllllIlIlllIIllllIIllIII = new ServerData(lllllllllllllIlIlllIIllllIIlIlll.getString("name"), lllllllllllllIlIlllIIllllIIlIlll.getString("ip"), false);
        if (lllllllllllllIlIlllIIllllIIlIlll.hasKey("icon", 8)) {
            lllllllllllllIlIlllIIllllIIllIII.setBase64EncodedIconData(lllllllllllllIlIlllIIllllIIlIlll.getString("icon"));
        }
        if (lllllllllllllIlIlllIIllllIIlIlll.hasKey("acceptTextures", 1)) {
            if (lllllllllllllIlIlllIIllllIIlIlll.getBoolean("acceptTextures")) {
                lllllllllllllIlIlllIIllllIIllIII.setResourceMode(ServerResourceMode.ENABLED);
            }
            else {
                lllllllllllllIlIlllIIllllIIllIII.setResourceMode(ServerResourceMode.DISABLED);
            }
        }
        else {
            lllllllllllllIlIlllIIllllIIllIII.setResourceMode(ServerResourceMode.PROMPT);
        }
        return lllllllllllllIlIlllIIllllIIllIII;
    }
    
    public void setResourceMode(final ServerResourceMode lllllllllllllIlIlllIIllllIIllllI) {
        this.resourceMode = lllllllllllllIlIlllIIllllIIllllI;
    }
    
    public void copyFrom(final ServerData lllllllllllllIlIlllIIllllIIIIllI) {
        this.serverIP = lllllllllllllIlIlllIIllllIIIIllI.serverIP;
        this.serverName = lllllllllllllIlIlllIIllllIIIIllI.serverName;
        this.setResourceMode(lllllllllllllIlIlllIIllllIIIIllI.getResourceMode());
        this.serverIcon = lllllllllllllIlIlllIIllllIIIIllI.serverIcon;
        this.lanServer = lllllllllllllIlIlllIIllllIIIIllI.lanServer;
    }
    
    public ServerResourceMode getResourceMode() {
        return this.resourceMode;
    }
    
    public enum ServerResourceMode
    {
        PROMPT("PROMPT", 2, "prompt"), 
        DISABLED("DISABLED", 1, "disabled");
        
        private final /* synthetic */ ITextComponent motd;
        
        ENABLED("ENABLED", 0, "enabled");
        
        private ServerResourceMode(final String llllllllllllllIllIlllIIlIlIIIIll, final int llllllllllllllIllIlllIIlIlIIIIlI, final String llllllllllllllIllIlllIIlIlIIIIIl) {
            this.motd = new TextComponentTranslation(String.valueOf(new StringBuilder("addServer.resourcePack.").append(llllllllllllllIllIlllIIlIlIIIIIl)), new Object[0]);
        }
        
        public ITextComponent getMotd() {
            return this.motd;
        }
    }
}
