package net.minecraft.world;

import net.minecraft.util.text.*;
import java.util.*;

public abstract class BossInfo
{
    protected /* synthetic */ Color color;
    protected /* synthetic */ float percent;
    protected /* synthetic */ Overlay overlay;
    protected /* synthetic */ ITextComponent name;
    protected /* synthetic */ boolean playEndBossMusic;
    private final /* synthetic */ UUID uniqueId;
    protected /* synthetic */ boolean darkenSky;
    protected /* synthetic */ boolean createFog;
    
    public Overlay getOverlay() {
        return this.overlay;
    }
    
    public boolean shouldCreateFog() {
        return this.createFog;
    }
    
    public Color getColor() {
        return this.color;
    }
    
    public void setColor(final Color lllllllllllllIIIlIIIIllllIIlIlll) {
        this.color = lllllllllllllIIIlIIIIllllIIlIlll;
    }
    
    public void setName(final ITextComponent lllllllllllllIIIlIIIIllllIlIlIIl) {
        this.name = lllllllllllllIIIlIIIIllllIlIlIIl;
    }
    
    public BossInfo(final UUID lllllllllllllIIIlIIIIllllIlllIll, final ITextComponent lllllllllllllIIIlIIIIllllIlllIlI, final Color lllllllllllllIIIlIIIIllllIlllIIl, final Overlay lllllllllllllIIIlIIIIllllIllIIll) {
        this.uniqueId = lllllllllllllIIIlIIIIllllIlllIll;
        this.name = lllllllllllllIIIlIIIIllllIlllIlI;
        this.color = lllllllllllllIIIlIIIIllllIlllIIl;
        this.overlay = lllllllllllllIIIlIIIIllllIllIIll;
        this.percent = 1.0f;
    }
    
    public BossInfo setDarkenSky(final boolean lllllllllllllIIIlIIIIllllIIIIlIl) {
        this.darkenSky = lllllllllllllIIIlIIIIllllIIIIlIl;
        return this;
    }
    
    public BossInfo setCreateFog(final boolean lllllllllllllIIIlIIIIlllIlllIlII) {
        this.createFog = lllllllllllllIIIlIIIIlllIlllIlII;
        return this;
    }
    
    public BossInfo setPlayEndBossMusic(final boolean lllllllllllllIIIlIIIIlllIlllllII) {
        this.playEndBossMusic = lllllllllllllIIIlIIIIlllIlllllII;
        return this;
    }
    
    public void setPercent(final float lllllllllllllIIIlIIIIllllIIllllI) {
        this.percent = lllllllllllllIIIlIIIIllllIIllllI;
    }
    
    public boolean shouldDarkenSky() {
        return this.darkenSky;
    }
    
    public UUID getUniqueId() {
        return this.uniqueId;
    }
    
    public ITextComponent getName() {
        return this.name;
    }
    
    public float getPercent() {
        return this.percent;
    }
    
    public void setOverlay(final Overlay lllllllllllllIIIlIIIIllllIIIllII) {
        this.overlay = lllllllllllllIIIlIIIIllllIIIllII;
    }
    
    public boolean shouldPlayEndBossMusic() {
        return this.playEndBossMusic;
    }
    
    public enum Color
    {
        PINK("PINK", 0), 
        WHITE("WHITE", 6), 
        BLUE("BLUE", 1), 
        RED("RED", 2), 
        PURPLE("PURPLE", 5), 
        GREEN("GREEN", 3), 
        YELLOW("YELLOW", 4);
        
        private Color(final String llllllllllllllIllllIllllIllIIIII, final int llllllllllllllIllllIllllIlIlllll) {
        }
    }
    
    public enum Overlay
    {
        NOTCHED_20("NOTCHED_20", 4), 
        NOTCHED_6("NOTCHED_6", 1), 
        NOTCHED_10("NOTCHED_10", 2), 
        NOTCHED_12("NOTCHED_12", 3), 
        PROGRESS("PROGRESS", 0);
        
        private Overlay(final String llllIlIlllIIIII, final int llllIlIllIlllll) {
        }
    }
}
