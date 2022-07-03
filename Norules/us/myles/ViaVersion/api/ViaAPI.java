package us.myles.ViaVersion.api;

import us.myles.ViaVersion.api.boss.*;
import java.util.*;
import io.netty.buffer.*;

@Deprecated
public interface ViaAPI<T>
{
    String getVersion();
    
    BossBar createBossBar(final String p0, final BossColor p1, final BossStyle p2);
    
    int getPlayerVersion(final T p0);
    
    SortedSet<Integer> getFullSupportedVersions();
    
    BossBar createBossBar(final String p0, final float p1, final BossColor p2, final BossStyle p3);
    
    boolean isInjected(final UUID p0);
    
    void sendRawPacket(final UUID p0, final ByteBuf p1);
    
    void sendRawPacket(final T p0, final ByteBuf p1);
    
    default boolean isPorted(final UUID lllllllllllllIIlIlIIllIIlIlIIlIl) {
        return this.isInjected(lllllllllllllIIlIlIIllIIlIlIIlIl);
    }
    
    SortedSet<Integer> getSupportedVersions();
    
    int getPlayerVersion(final UUID p0);
}
