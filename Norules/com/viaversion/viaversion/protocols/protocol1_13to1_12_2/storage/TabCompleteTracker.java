package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.storage;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_12_1to1_12.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.protocol.*;

public class TabCompleteTracker implements StorableObject
{
    private /* synthetic */ String input;
    private /* synthetic */ String lastTabComplete;
    private /* synthetic */ long timeToSend;
    private /* synthetic */ int transactionId;
    
    public void setInput(final String lllllllllllllIllllIIlIIIlIllIIIl) {
        this.input = lllllllllllllIllllIIlIIIlIllIIIl;
    }
    
    public void sendPacketToServer(final UserConnection lllllllllllllIllllIIlIIIllIIIIll) {
        if (this.lastTabComplete == null || this.timeToSend > System.currentTimeMillis()) {
            return;
        }
        final PacketWrapper lllllllllllllIllllIIlIIIllIIIlIl = PacketWrapper.create(ServerboundPackets1_12_1.TAB_COMPLETE, null, lllllllllllllIllllIIlIIIllIIIIll);
        lllllllllllllIllllIIlIIIllIIIlIl.write(Type.STRING, this.lastTabComplete);
        lllllllllllllIllllIIlIIIllIIIlIl.write(Type.BOOLEAN, false);
        lllllllllllllIllllIIlIIIllIIIlIl.write(Type.OPTIONAL_POSITION, null);
        try {
            lllllllllllllIllllIIlIIIllIIIlIl.scheduleSendToServer(Protocol1_13To1_12_2.class);
        }
        catch (Exception lllllllllllllIllllIIlIIIllIIlIII) {
            lllllllllllllIllllIIlIIIllIIlIII.printStackTrace();
        }
        this.lastTabComplete = null;
    }
    
    public void setLastTabComplete(final String lllllllllllllIllllIIlIIIlIlIIllI) {
        this.lastTabComplete = lllllllllllllIllllIIlIIIlIlIIllI;
    }
    
    public int getTransactionId() {
        return this.transactionId;
    }
    
    public void setTransactionId(final int lllllllllllllIllllIIlIIIlIlllIlI) {
        this.transactionId = lllllllllllllIllllIIlIIIlIlllIlI;
    }
    
    public String getLastTabComplete() {
        return this.lastTabComplete;
    }
    
    public long getTimeToSend() {
        return this.timeToSend;
    }
    
    public void setTimeToSend(final long lllllllllllllIllllIIlIIIlIIlllll) {
        this.timeToSend = lllllllllllllIllllIIlIIIlIIlllll;
    }
    
    public String getInput() {
        return this.input;
    }
}
