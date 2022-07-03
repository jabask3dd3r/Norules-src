package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.provider;

import com.viaversion.viaversion.api.platform.providers.*;
import java.util.concurrent.atomic.*;
import java.util.*;

public abstract class TitleRenderProvider implements Provider
{
    protected /* synthetic */ Map<UUID, Integer> fadeIn;
    protected /* synthetic */ Map<UUID, Integer> fadeOut;
    protected /* synthetic */ Map<UUID, Integer> stay;
    protected /* synthetic */ Map<UUID, String> titles;
    protected /* synthetic */ Map<UUID, String> subTitles;
    protected /* synthetic */ Map<UUID, AtomicInteger> times;
    
    public int getFadeIn(final UUID lllllllllllllIIllIIlllIlIlIIlIll) {
        return this.fadeIn.getOrDefault(lllllllllllllIIllIIlllIlIlIIlIll, 10);
    }
    
    public void reset(final UUID lllllllllllllIIllIIlllIlIllIllll) {
        this.titles.remove(lllllllllllllIIllIIlllIlIllIllll);
        this.subTitles.remove(lllllllllllllIIllIIlllIlIllIllll);
        this.getTime(lllllllllllllIIllIIlllIlIllIllll).set(0);
        this.fadeIn.remove(lllllllllllllIIllIIlllIlIllIllll);
        this.stay.remove(lllllllllllllIIllIIlllIlIllIllll);
        this.fadeOut.remove(lllllllllllllIIllIIlllIlIllIllll);
    }
    
    public void setFadeIn(final UUID lllllllllllllIIllIIlllIlIIllIlll, final int lllllllllllllIIllIIlllIlIIlllIIl) {
        if (lllllllllllllIIllIIlllIlIIlllIIl >= 0) {
            this.fadeIn.put(lllllllllllllIIllIIlllIlIIllIlll, lllllllllllllIIllIIlllIlIIlllIIl);
        }
        else {
            this.fadeIn.remove(lllllllllllllIIllIIlllIlIIllIlll);
        }
    }
    
    public void setSubTitle(final UUID lllllllllllllIIllIIlllIlIlIllllI, final String lllllllllllllIIllIIlllIlIllIIIII) {
        this.subTitles.put(lllllllllllllIIllIIlllIlIlIllllI, lllllllllllllIIllIIlllIlIllIIIII);
    }
    
    public TitleRenderProvider() {
        this.fadeIn = new HashMap<UUID, Integer>();
        this.stay = new HashMap<UUID, Integer>();
        this.fadeOut = new HashMap<UUID, Integer>();
        this.titles = new HashMap<UUID, String>();
        this.subTitles = new HashMap<UUID, String>();
        this.times = new HashMap<UUID, AtomicInteger>();
    }
    
    public void setTimings(final UUID lllllllllllllIIllIIlllIlIlllllll, final int lllllllllllllIIllIIlllIlIllllIII, final int lllllllllllllIIllIIlllIlIlllllIl, final int lllllllllllllIIllIIlllIlIlllIllI) {
        this.setFadeIn(lllllllllllllIIllIIlllIlIlllllll, lllllllllllllIIllIIlllIlIllllIII);
        this.setStay(lllllllllllllIIllIIlllIlIlllllll, lllllllllllllIIllIIlllIlIlllllIl);
        this.setFadeOut(lllllllllllllIIllIIlllIlIlllllll, lllllllllllllIIllIIlllIlIlllIllI);
        final AtomicInteger lllllllllllllIIllIIlllIlIllllIll = this.getTime(lllllllllllllIIllIIlllIlIlllllll);
        if (lllllllllllllIIllIIlllIlIllllIll.get() > 0) {
            lllllllllllllIIllIIlllIlIllllIll.set(this.getFadeIn(lllllllllllllIIllIIlllIlIlllllll) + this.getStay(lllllllllllllIIllIIlllIlIlllllll) + this.getFadeOut(lllllllllllllIIllIIlllIlIlllllll));
        }
    }
    
    public int getStay(final UUID lllllllllllllIIllIIlllIlIlIIIlll) {
        return this.stay.getOrDefault(lllllllllllllIIllIIlllIlIlIIIlll, 70);
    }
    
    public void setFadeOut(final UUID lllllllllllllIIllIIlllIlIIlIIlIl, final int lllllllllllllIIllIIlllIlIIlIIlII) {
        if (lllllllllllllIIllIIlllIlIIlIIlII >= 0) {
            this.fadeOut.put(lllllllllllllIIllIIlllIlIIlIIlIl, lllllllllllllIIllIIlllIlIIlIIlII);
        }
        else {
            this.fadeOut.remove(lllllllllllllIIllIIlllIlIIlIIlIl);
        }
    }
    
    public void setStay(final UUID lllllllllllllIIllIIlllIlIIlIlllI, final int lllllllllllllIIllIIlllIlIIllIIII) {
        if (lllllllllllllIIllIIlllIlIIllIIII >= 0) {
            this.stay.put(lllllllllllllIIllIIlllIlIIlIlllI, lllllllllllllIIllIIlllIlIIllIIII);
        }
        else {
            this.stay.remove(lllllllllllllIIllIIlllIlIIlIlllI);
        }
    }
    
    public int getFadeOut(final UUID lllllllllllllIIllIIlllIlIlIIIIIl) {
        return this.fadeOut.getOrDefault(lllllllllllllIIllIIlllIlIlIIIIIl, 20);
    }
    
    public void setTitle(final UUID lllllllllllllIIllIIlllIlIllIIlll, final String lllllllllllllIIllIIlllIlIllIIllI) {
        this.titles.put(lllllllllllllIIllIIlllIlIllIIlll, lllllllllllllIIllIIlllIlIllIIllI);
        this.getTime(lllllllllllllIIllIIlllIlIllIIlll).set(this.getFadeIn(lllllllllllllIIllIIlllIlIllIIlll) + this.getStay(lllllllllllllIIllIIlllIlIllIIlll) + this.getFadeOut(lllllllllllllIIllIIlllIlIllIIlll));
    }
    
    public void clear(final UUID lllllllllllllIIllIIlllIlIlIllIIl) {
        this.titles.remove(lllllllllllllIIllIIlllIlIlIllIIl);
        this.subTitles.remove(lllllllllllllIIllIIlllIlIlIllIIl);
        this.getTime(lllllllllllllIIllIIlllIlIlIllIIl).set(0);
    }
    
    public AtomicInteger getTime(final UUID lllllllllllllIIllIIlllIlIlIlIIIl) {
        return this.times.computeIfAbsent(lllllllllllllIIllIIlllIlIlIlIIIl, lllllllllllllIIllIIlllIlIIlIIIll -> new AtomicInteger(0));
    }
}
