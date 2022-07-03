package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.util.*;
import net.minecraft.network.*;
import com.google.common.collect.*;
import net.minecraft.stats.*;
import java.io.*;

public class SPacketStatistics implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ Map<StatBase, Integer> statisticMap;
    
    public Map<StatBase, Integer> getStatisticMap() {
        return this.statisticMap;
    }
    
    public SPacketStatistics(final Map<StatBase, Integer> llllllllllllllIIIlIIlllIIIlllllI) {
        this.statisticMap = llllllllllllllIIIlIIlllIIIlllllI;
    }
    
    public SPacketStatistics() {
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIIIlIIlllIIIlIlIII) throws IOException {
        final int llllllllllllllIIIlIIlllIIIlIllIl = llllllllllllllIIIlIIlllIIIlIlIII.readVarIntFromBuffer();
        this.statisticMap = (Map<StatBase, Integer>)Maps.newHashMap();
        for (int llllllllllllllIIIlIIlllIIIlIllII = 0; llllllllllllllIIIlIIlllIIIlIllII < llllllllllllllIIIlIIlllIIIlIllIl; ++llllllllllllllIIIlIIlllIIIlIllII) {
            final StatBase llllllllllllllIIIlIIlllIIIlIlIll = StatList.getOneShotStat(llllllllllllllIIIlIIlllIIIlIlIII.readStringFromBuffer(32767));
            final int llllllllllllllIIIlIIlllIIIlIlIlI = llllllllllllllIIIlIIlllIIIlIlIII.readVarIntFromBuffer();
            if (llllllllllllllIIIlIIlllIIIlIlIll != null) {
                this.statisticMap.put(llllllllllllllIIIlIIlllIIIlIlIll, llllllllllllllIIIlIIlllIIIlIlIlI);
            }
        }
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIIIlIIlllIIIllIllI) {
        llllllllllllllIIIlIIlllIIIllIllI.handleStatistics(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIIIlIIlllIIIIllIll) throws IOException {
        llllllllllllllIIIlIIlllIIIIllIll.writeVarIntToBuffer(this.statisticMap.size());
        for (final Map.Entry<StatBase, Integer> llllllllllllllIIIlIIlllIIIIlllIl : this.statisticMap.entrySet()) {
            llllllllllllllIIIlIIlllIIIIllIll.writeString(llllllllllllllIIIlIIlllIIIIlllIl.getKey().statId);
            llllllllllllllIIIlIIlllIIIIllIll.writeVarIntToBuffer(llllllllllllllIIIlIIlllIIIIlllIl.getValue());
        }
    }
}
