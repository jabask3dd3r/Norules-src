package net.minecraft.realms;

import net.minecraft.client.multiplayer.*;

public class RealmsServerAddress
{
    private final /* synthetic */ int port;
    private final /* synthetic */ String host;
    
    public String getHost() {
        return this.host;
    }
    
    protected RealmsServerAddress(final String llllllllllllIlllllIllllIIIllIIlI, final int llllllllllllIlllllIllllIIIlIlllI) {
        this.host = llllllllllllIlllllIllllIIIllIIlI;
        this.port = llllllllllllIlllllIllllIIIlIlllI;
    }
    
    public static RealmsServerAddress parseString(final String llllllllllllIlllllIllllIIIlIIIll) {
        final ServerAddress llllllllllllIlllllIllllIIIlIIlII = ServerAddress.fromString(llllllllllllIlllllIllllIIIlIIIll);
        return new RealmsServerAddress(llllllllllllIlllllIllllIIIlIIlII.getIP(), llllllllllllIlllllIllllIIIlIIlII.getPort());
    }
    
    public int getPort() {
        return this.port;
    }
}
