package us.myles.ViaVersion.api.boss;

import java.util.*;

@Deprecated
public class BossBar<T>
{
    private final /* synthetic */ com.viaversion.viaversion.api.legacy.bossbar.BossBar bossBar;
    
    public BossBar setColor(final BossColor lllllllllllllIIIlIlIIIIIIllIllll) {
        this.bossBar.setColor(com.viaversion.viaversion.api.legacy.bossbar.BossColor.values()[lllllllllllllIIIlIlIIIIIIllIllll.ordinal()]);
        return this;
    }
    
    public BossBar setHealth(final float lllllllllllllIIIlIlIIIIIIllllIII) {
        this.bossBar.setHealth(lllllllllllllIIIlIlIIIIIIllllIII);
        return this;
    }
    
    public BossBar addFlag(final BossFlag lllllllllllllIIIlIlIIIIIIlIIlIII) {
        this.bossBar.addFlag(com.viaversion.viaversion.api.legacy.bossbar.BossFlag.values()[lllllllllllllIIIlIlIIIIIIlIIlIII.ordinal()]);
        return this;
    }
    
    public String getTitle() {
        return this.bossBar.getTitle();
    }
    
    public BossBar removePlayer(final UUID lllllllllllllIIIlIlIIIIIIlIIllII) {
        this.bossBar.removePlayer(lllllllllllllIIIlIlIIIIIIlIIllII);
        return this;
    }
    
    @Deprecated
    public BossBar addPlayers(final T... lllllllllllllIIIlIlIIIIIIlIlIlll) {
        return this;
    }
    
    public boolean isVisible() {
        return this.bossBar.isVisible();
    }
    
    public UUID getId() {
        return this.bossBar.getId();
    }
    
    public BossColor getColor() {
        return BossColor.values()[this.bossBar.getColor().ordinal()];
    }
    
    public BossStyle getStyle() {
        return BossStyle.values()[this.bossBar.getStyle().ordinal()];
    }
    
    @Deprecated
    public BossBar addPlayer(final T lllllllllllllIIIlIlIIIIIIllIIIIl) {
        return this;
    }
    
    public BossBar hide() {
        this.bossBar.hide();
        return this;
    }
    
    public BossBar setTitle(final String lllllllllllllIIIlIlIIIIIIlllllll) {
        this.bossBar.setTitle(lllllllllllllIIIlIlIIIIIIlllllll);
        return this;
    }
    
    public BossBar show() {
        this.bossBar.show();
        return this;
    }
    
    public Set<UUID> getPlayers() {
        return this.bossBar.getPlayers();
    }
    
    @Deprecated
    public BossBar removePlayer(final T lllllllllllllIIIlIlIIIIIIlIlIIll) {
        return this;
    }
    
    public float getHealth() {
        return this.bossBar.getHealth();
    }
    
    public BossBar addPlayer(final UUID lllllllllllllIIIlIlIIIIIIlIlllII) {
        this.bossBar.addPlayer(lllllllllllllIIIlIlIIIIIIlIlllII);
        return this;
    }
    
    public BossBar(final com.viaversion.viaversion.api.legacy.bossbar.BossBar lllllllllllllIIIlIlIIIIIlIIlIIlI) {
        this.bossBar = lllllllllllllIIIlIlIIIIIlIIlIIlI;
    }
    
    public BossBar setStyle(final BossStyle lllllllllllllIIIlIlIIIIIIllIIllI) {
        this.bossBar.setStyle(com.viaversion.viaversion.api.legacy.bossbar.BossStyle.values()[lllllllllllllIIIlIlIIIIIIllIIllI.ordinal()]);
        return this;
    }
    
    public BossBar removeFlag(final BossFlag lllllllllllllIIIlIlIIIIIIlIIIIlI) {
        this.bossBar.removeFlag(com.viaversion.viaversion.api.legacy.bossbar.BossFlag.values()[lllllllllllllIIIlIlIIIIIIlIIIIlI.ordinal()]);
        return this;
    }
    
    public boolean hasFlag(final BossFlag lllllllllllllIIIlIlIIIIIIIlllIlI) {
        return this.bossBar.hasFlag(com.viaversion.viaversion.api.legacy.bossbar.BossFlag.values()[lllllllllllllIIIlIlIIIIIIIlllIlI.ordinal()]);
    }
}
