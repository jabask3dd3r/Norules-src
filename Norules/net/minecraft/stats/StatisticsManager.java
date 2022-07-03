package net.minecraft.stats;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import com.google.common.collect.*;

public class StatisticsManager
{
    protected final /* synthetic */ Map<StatBase, TupleIntJsonSerializable> statsData;
    
    public int readStat(final StatBase llllllllllllllIIIIlIIIlllIllIlll) {
        final TupleIntJsonSerializable llllllllllllllIIIIlIIIlllIllIllI = this.statsData.get(llllllllllllllIIIIlIIIlllIllIlll);
        return (llllllllllllllIIIIlIIIlllIllIllI == null) ? 0 : llllllllllllllIIIIlIIIlllIllIllI.getIntegerValue();
    }
    
    public void unlockAchievement(final EntityPlayer llllllllllllllIIIIlIIIllllIIIIll, final StatBase llllllllllllllIIIIlIIIllllIIIIlI, final int llllllllllllllIIIIlIIIlllIllllIl) {
        TupleIntJsonSerializable llllllllllllllIIIIlIIIllllIIIIII = this.statsData.get(llllllllllllllIIIIlIIIllllIIIIlI);
        if (llllllllllllllIIIIlIIIllllIIIIII == null) {
            llllllllllllllIIIIlIIIllllIIIIII = new TupleIntJsonSerializable();
            this.statsData.put(llllllllllllllIIIIlIIIllllIIIIlI, llllllllllllllIIIIlIIIllllIIIIII);
        }
        llllllllllllllIIIIlIIIllllIIIIII.setIntegerValue(llllllllllllllIIIIlIIIlllIllllIl);
    }
    
    public StatisticsManager() {
        this.statsData = (Map<StatBase, TupleIntJsonSerializable>)Maps.newConcurrentMap();
    }
    
    public void increaseStat(final EntityPlayer llllllllllllllIIIIlIIIllllIIlIll, final StatBase llllllllllllllIIIIlIIIllllIIlIlI, final int llllllllllllllIIIIlIIIllllIIllIl) {
        this.unlockAchievement(llllllllllllllIIIIlIIIllllIIlIll, llllllllllllllIIIIlIIIllllIIlIlI, this.readStat(llllllllllllllIIIIlIIIllllIIlIlI) + llllllllllllllIIIIlIIIllllIIllIl);
    }
}
