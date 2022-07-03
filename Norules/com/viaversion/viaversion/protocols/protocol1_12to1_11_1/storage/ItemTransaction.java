package com.viaversion.viaversion.protocols.protocol1_12to1_11_1.storage;

public class ItemTransaction
{
    private final /* synthetic */ short actionId;
    private final /* synthetic */ short slotId;
    private final /* synthetic */ short windowId;
    
    public short getActionId() {
        return this.actionId;
    }
    
    public short getSlotId() {
        return this.slotId;
    }
    
    public ItemTransaction(final short lllllllllllllllllllIllIllIlIlIlI, final short lllllllllllllllllllIllIllIlIIlIl, final short lllllllllllllllllllIllIllIlIlIII) {
        this.windowId = lllllllllllllllllllIllIllIlIlIlI;
        this.slotId = lllllllllllllllllllIllIllIlIIlIl;
        this.actionId = lllllllllllllllllllIllIllIlIlIII;
    }
    
    public short getWindowId() {
        return this.windowId;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("ItemTransaction{windowId=").append(this.windowId).append(", slotId=").append(this.slotId).append(", actionId=").append(this.actionId).append('}'));
    }
}
