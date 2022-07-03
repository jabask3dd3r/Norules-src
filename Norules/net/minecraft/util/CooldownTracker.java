package net.minecraft.util;

import net.minecraft.item.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;
import java.util.*;

public class CooldownTracker
{
    private /* synthetic */ int ticks;
    private final /* synthetic */ Map<Item, Cooldown> cooldowns;
    
    public float getCooldown(final Item lllllllllllllIlIlIIlIIIIIllIlllI, final float lllllllllllllIlIlIIlIIIIIllIllIl) {
        final Cooldown lllllllllllllIlIlIIlIIIIIlllIIlI = this.cooldowns.get(lllllllllllllIlIlIIlIIIIIllIlllI);
        if (lllllllllllllIlIlIIlIIIIIlllIIlI != null) {
            final float lllllllllllllIlIlIIlIIIIIlllIIIl = (float)(lllllllllllllIlIlIIlIIIIIlllIIlI.expireTicks - lllllllllllllIlIlIIlIIIIIlllIIlI.createTicks);
            final float lllllllllllllIlIlIIlIIIIIlllIIII = lllllllllllllIlIlIIlIIIIIlllIIlI.expireTicks - (this.ticks + lllllllllllllIlIlIIlIIIIIllIllIl);
            return MathHelper.clamp(lllllllllllllIlIlIIlIIIIIlllIIII / lllllllllllllIlIlIIlIIIIIlllIIIl, 0.0f, 1.0f);
        }
        return 0.0f;
    }
    
    public CooldownTracker() {
        this.cooldowns = (Map<Item, Cooldown>)Maps.newHashMap();
    }
    
    public void tick() {
        ++this.ticks;
        if (!this.cooldowns.isEmpty()) {
            final Iterator<Map.Entry<Item, Cooldown>> lllllllllllllIlIlIIlIIIIIllIIlIl = this.cooldowns.entrySet().iterator();
            while (lllllllllllllIlIlIIlIIIIIllIIlIl.hasNext()) {
                final Map.Entry<Item, Cooldown> lllllllllllllIlIlIIlIIIIIllIIlII = lllllllllllllIlIlIIlIIIIIllIIlIl.next();
                if (lllllllllllllIlIlIIlIIIIIllIIlII.getValue().expireTicks <= this.ticks) {
                    lllllllllllllIlIlIIlIIIIIllIIlIl.remove();
                    this.notifyOnRemove(lllllllllllllIlIlIIlIIIIIllIIlII.getKey());
                }
            }
        }
    }
    
    public boolean hasCooldown(final Item lllllllllllllIlIlIIlIIIIIlllllII) {
        return this.getCooldown(lllllllllllllIlIlIIlIIIIIlllllII, 0.0f) > 0.0f;
    }
    
    public void setCooldown(final Item lllllllllllllIlIlIIlIIIIIlIlllII, final int lllllllllllllIlIlIIlIIIIIlIllIll) {
        this.cooldowns.put(lllllllllllllIlIlIIlIIIIIlIlllII, new Cooldown(this.ticks, this.ticks + lllllllllllllIlIlIIlIIIIIlIllIll, (Cooldown)null));
        this.notifyOnSet(lllllllllllllIlIlIIlIIIIIlIlllII, lllllllllllllIlIlIIlIIIIIlIllIll);
    }
    
    protected void notifyOnSet(final Item lllllllllllllIlIlIIlIIIIIlIlIIII, final int lllllllllllllIlIlIIlIIIIIlIIllll) {
    }
    
    protected void notifyOnRemove(final Item lllllllllllllIlIlIIlIIIIIlIIllIl) {
    }
    
    public void removeCooldown(final Item lllllllllllllIlIlIIlIIIIIlIlIlII) {
        this.cooldowns.remove(lllllllllllllIlIlIIlIIIIIlIlIlII);
        this.notifyOnRemove(lllllllllllllIlIlIIlIIIIIlIlIlII);
    }
    
    class Cooldown
    {
        final /* synthetic */ int createTicks;
        final /* synthetic */ int expireTicks;
        
        private Cooldown(final int llllllllllllllIIIIIIllIlIllIlIlI, final int llllllllllllllIIIIIIllIlIllIlIIl) {
            this.createTicks = llllllllllllllIIIIIIllIlIllIlIlI;
            this.expireTicks = llllllllllllllIIIIIIllIlIllIlIIl;
        }
    }
}
