package us.myles.ViaVersion.api;

import us.myles.ViaVersion.api.boss.*;
import io.netty.buffer.*;
import java.util.*;

@Deprecated
public class Via<T> implements ViaAPI<T>
{
    private static final /* synthetic */ ViaAPI INSTANCE;
    
    @Override
    public BossBar createBossBar(final String llllllllllllllIllIIllIIlIIIlllII, final float llllllllllllllIllIIllIIlIIIlIlll, final BossColor llllllllllllllIllIIllIIlIIIlIllI, final BossStyle llllllllllllllIllIIllIIlIIIlIlIl) {
        return new BossBar(com.viaversion.viaversion.api.Via.getAPI().legacyAPI().createLegacyBossBar(llllllllllllllIllIIllIIlIIIlllII, llllllllllllllIllIIllIIlIIIlIlll, com.viaversion.viaversion.api.legacy.bossbar.BossColor.values()[llllllllllllllIllIIllIIlIIIlIllI.ordinal()], com.viaversion.viaversion.api.legacy.bossbar.BossStyle.values()[llllllllllllllIllIIllIIlIIIlIlIl.ordinal()]));
    }
    
    @Override
    public void sendRawPacket(final UUID llllllllllllllIllIIllIIlIIlIllIl, final ByteBuf llllllllllllllIllIIllIIlIIlIlllI) {
        com.viaversion.viaversion.api.Via.getAPI().sendRawPacket(llllllllllllllIllIIllIIlIIlIllIl, llllllllllllllIllIIllIIlIIlIlllI);
    }
    
    @Deprecated
    public static ViaAPI getAPI() {
        return Via.INSTANCE;
    }
    
    static {
        INSTANCE = new Via();
    }
    
    @Override
    public String getVersion() {
        return com.viaversion.viaversion.api.Via.getAPI().getVersion();
    }
    
    @Override
    public int getPlayerVersion(final UUID llllllllllllllIllIIllIIlIIllllll) {
        return com.viaversion.viaversion.api.Via.getAPI().getPlayerVersion(llllllllllllllIllIIllIIlIIllllll);
    }
    
    @Override
    public int getPlayerVersion(final T llllllllllllllIllIIllIIlIlIIIlII) {
        return com.viaversion.viaversion.api.Via.getAPI().getPlayerVersion(llllllllllllllIllIIllIIlIlIIIlII);
    }
    
    private Via() {
    }
    
    @Override
    public SortedSet<Integer> getFullSupportedVersions() {
        return (SortedSet<Integer>)com.viaversion.viaversion.api.Via.getAPI().getFullSupportedVersions();
    }
    
    @Override
    public SortedSet<Integer> getSupportedVersions() {
        return (SortedSet<Integer>)com.viaversion.viaversion.api.Via.getAPI().getSupportedVersions();
    }
    
    @Override
    public BossBar createBossBar(final String llllllllllllllIllIIllIIlIIlIIlll, final BossColor llllllllllllllIllIIllIIlIIlIIIll, final BossStyle llllllllllllllIllIIllIIlIIlIIlIl) {
        return new BossBar(com.viaversion.viaversion.api.Via.getAPI().legacyAPI().createLegacyBossBar(llllllllllllllIllIIllIIlIIlIIlll, com.viaversion.viaversion.api.legacy.bossbar.BossColor.values()[llllllllllllllIllIIllIIlIIlIIIll.ordinal()], com.viaversion.viaversion.api.legacy.bossbar.BossStyle.values()[llllllllllllllIllIIllIIlIIlIIlIl.ordinal()]));
    }
    
    @Override
    public void sendRawPacket(final T llllllllllllllIllIIllIIlIIllIlII, final ByteBuf llllllllllllllIllIIllIIlIIllIIll) {
        com.viaversion.viaversion.api.Via.getAPI().sendRawPacket(llllllllllllllIllIIllIIlIIllIlII, llllllllllllllIllIIllIIlIIllIIll);
    }
    
    @Override
    public boolean isInjected(final UUID llllllllllllllIllIIllIIlIIlllIll) {
        return com.viaversion.viaversion.api.Via.getAPI().isInjected(llllllllllllllIllIIllIIlIIlllIll);
    }
}
