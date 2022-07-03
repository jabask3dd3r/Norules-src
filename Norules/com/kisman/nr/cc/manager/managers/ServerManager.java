package com.kisman.nr.cc.manager.managers;

import com.kisman.nr.cc.util.*;
import java.text.*;
import net.minecraft.client.*;
import me.nrules.event.*;
import me.nrules.event.events.*;
import net.minecraft.client.network.*;
import java.util.*;

public class ServerManager
{
    private /* synthetic */ TimerUtils timer;
    private /* synthetic */ float[] tpsCount;
    private /* synthetic */ DecimalFormat format;
    private /* synthetic */ String serverBrand;
    private /* synthetic */ float tps;
    private /* synthetic */ long lastUpdate;
    private /* synthetic */ Minecraft mc;
    
    public void setServerBrand(final String lllllllIllI) {
        this.serverBrand = lllllllIllI;
    }
    
    public String getServerBrand() {
        return this.serverBrand;
    }
    
    public void reset() {
        Arrays.fill(this.tpsCount, 20.0f);
        this.tps = 20.0f;
    }
    
    @EventTarget
    public void onPacket(final EventReceivePacket lIIIIIIIIlll) {
        this.timer.reset();
    }
    
    public ServerManager() {
        this.mc = Minecraft.getMinecraft();
        this.tpsCount = new float[10];
        this.format = new DecimalFormat("##.00##");
        this.timer = new TimerUtils();
        this.tps = 20.0f;
        this.lastUpdate = -1L;
        this.serverBrand = "";
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lIIIIIIllIlI) {
        final long lIIIIIIllIIl = System.currentTimeMillis();
        if (this.lastUpdate == -1L) {
            this.lastUpdate = lIIIIIIllIIl;
            return;
        }
        final long lIIIIIIllIII = lIIIIIIllIIl - this.lastUpdate;
        float lIIIIIIlIlll = (float)(lIIIIIIllIII / 20L);
        if (lIIIIIIlIlll == 0.0f) {
            lIIIIIIlIlll = 50.0f;
        }
        float lIIIIIIlIllI = 1000.0f / lIIIIIIlIlll;
        if (lIIIIIIlIllI > 20.0f) {
            lIIIIIIlIllI = 20.0f;
        }
        System.arraycopy(this.tpsCount, 0, this.tpsCount, 1, this.tpsCount.length - 1);
        this.tpsCount[0] = lIIIIIIlIllI;
        double lIIIIIIlIlIl = 0.0;
        final int lIIIIIIIlIlI;
        final int lIIIIIIIlIll = ((float[])(Object)(lIIIIIIIlIlI = (int)(Object)this.tpsCount)).length;
        for (Exception lIIIIIIIllII = (Exception)0; lIIIIIIIllII < lIIIIIIIlIll; ++lIIIIIIIllII) {
            final float lIIIIIIlIlII = lIIIIIIIlIlI[lIIIIIIIllII];
            lIIIIIIlIlIl += lIIIIIIlIlII;
        }
        if ((lIIIIIIlIlIl /= this.tpsCount.length) > 20.0) {
            lIIIIIIlIlIl = 20.0;
        }
        lIIIIIIlIllI = Float.parseFloat(this.format.format(lIIIIIIlIlIl));
        this.lastUpdate = lIIIIIIllIIl;
    }
    
    public int getPing() {
        if (this.mc.player == null && this.mc.world == null) {
            return 0;
        }
        try {
            return Objects.requireNonNull(this.mc.getConnection()).getPlayerInfo(this.mc.getConnection().getGameProfile().getId()).getResponseTime();
        }
        catch (Exception lllllllIIII) {
            return 0;
        }
    }
    
    public float getTps() {
        return this.tps;
    }
    
    public float getTpsFactor() {
        return 20.0f / this.tps;
    }
}
