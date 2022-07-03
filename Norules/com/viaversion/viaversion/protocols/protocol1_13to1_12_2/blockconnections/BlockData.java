package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import com.viaversion.viaversion.api.minecraft.*;
import java.util.*;

public class BlockData
{
    private final /* synthetic */ Map<String, boolean[]> connectData;
    
    public void put(final String llllllllllllllIllIIIllllIIllIIll, final boolean[] llllllllllllllIllIIIllllIIlIlIIl) {
        this.connectData.put(llllllllllllllIllIIIllllIIllIIll, llllllllllllllIllIIIllllIIlIlIIl);
    }
    
    public boolean connectsTo(final String llllllllllllllIllIIIllllIIIlIIIl, final BlockFace llllllllllllllIllIIIllllIIIlIIII, final boolean llllllllllllllIllIIIllllIIIIllll) {
        boolean[] llllllllllllllIllIIIllllIIIlIIll = null;
        if (llllllllllllllIllIIIllllIIIIllll) {
            llllllllllllllIllIIIllllIIIlIIll = this.connectData.get("allFalseIfStairPre1_12");
        }
        if (llllllllllllllIllIIIllllIIIlIIll == null) {
            llllllllllllllIllIIIllllIIIlIIll = this.connectData.get(llllllllllllllIllIIIllllIIIlIIIl);
        }
        return llllllllllllllIllIIIllllIIIlIIll != null && llllllllllllllIllIIIllllIIIlIIll[llllllllllllllIllIIIllllIIIlIIII.ordinal()];
    }
    
    public BlockData() {
        this.connectData = new HashMap<String, boolean[]>();
    }
}
