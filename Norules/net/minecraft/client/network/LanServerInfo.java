package net.minecraft.client.network;

import net.minecraft.client.*;

public class LanServerInfo
{
    private /* synthetic */ long timeLastSeen;
    private final /* synthetic */ String lanServerIpPort;
    private final /* synthetic */ String lanServerMotd;
    
    public String getServerMotd() {
        return this.lanServerMotd;
    }
    
    public void updateLastSeen() {
        this.timeLastSeen = Minecraft.getSystemTime();
    }
    
    public String getServerIpPort() {
        return this.lanServerIpPort;
    }
    
    public LanServerInfo(final String llllllllllllllllllllllIIllllIlII, final String llllllllllllllllllllllIIllllIIII) {
        this.lanServerMotd = llllllllllllllllllllllIIllllIlII;
        this.lanServerIpPort = llllllllllllllllllllllIIllllIIII;
        this.timeLastSeen = Minecraft.getSystemTime();
    }
}
