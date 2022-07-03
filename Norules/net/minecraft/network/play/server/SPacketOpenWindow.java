package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.util.text.*;
import net.minecraft.network.*;
import java.io.*;

public class SPacketOpenWindow implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int entityId;
    private /* synthetic */ String inventoryType;
    private /* synthetic */ int windowId;
    private /* synthetic */ int slotCount;
    private /* synthetic */ ITextComponent windowTitle;
    
    public SPacketOpenWindow() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIllIlIIIIIIllIIl) throws IOException {
        lllllllllllllllIIllIlIIIIIIllIIl.writeByte(this.windowId);
        lllllllllllllllIIllIlIIIIIIllIIl.writeString(this.inventoryType);
        lllllllllllllllIIllIlIIIIIIllIIl.writeTextComponent(this.windowTitle);
        lllllllllllllllIIllIlIIIIIIllIIl.writeByte(this.slotCount);
        if (this.inventoryType.equals("EntityHorse")) {
            lllllllllllllllIIllIlIIIIIIllIIl.writeInt(this.entityId);
        }
    }
    
    public ITextComponent getWindowTitle() {
        return this.windowTitle;
    }
    
    public boolean hasSlots() {
        return this.slotCount > 0;
    }
    
    public int getWindowId() {
        return this.windowId;
    }
    
    public SPacketOpenWindow(final int lllllllllllllllIIllIlIIIIlIIlIII, final String lllllllllllllllIIllIlIIIIlIIIIII, final ITextComponent lllllllllllllllIIllIlIIIIlIIIlIl, final int lllllllllllllllIIllIlIIIIlIIIlII) {
        this.windowId = lllllllllllllllIIllIlIIIIlIIlIII;
        this.inventoryType = lllllllllllllllIIllIlIIIIlIIIIII;
        this.windowTitle = lllllllllllllllIIllIlIIIIlIIIlIl;
        this.slotCount = lllllllllllllllIIllIlIIIIlIIIlII;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIIllIlIIIIIlIIlIl) {
        lllllllllllllllIIllIlIIIIIlIIlIl.handleOpenWindow(this);
    }
    
    public int getSlotCount() {
        return this.slotCount;
    }
    
    public SPacketOpenWindow(final int lllllllllllllllIIllIlIIIIIllIIll, final String lllllllllllllllIIllIlIIIIIlIllII, final ITextComponent lllllllllllllllIIllIlIIIIIllIIIl, final int lllllllllllllllIIllIlIIIIIllIIII, final int lllllllllllllllIIllIlIIIIIlIllll) {
        this(lllllllllllllllIIllIlIIIIIllIIll, lllllllllllllllIIllIlIIIIIlIllII, lllllllllllllllIIllIlIIIIIllIIIl, lllllllllllllllIIllIlIIIIIllIIII);
        this.entityId = lllllllllllllllIIllIlIIIIIlIllll;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIllIlIIIIIIlllIl) throws IOException {
        this.windowId = lllllllllllllllIIllIlIIIIIIlllIl.readUnsignedByte();
        this.inventoryType = lllllllllllllllIIllIlIIIIIIlllIl.readStringFromBuffer(32);
        this.windowTitle = lllllllllllllllIIllIlIIIIIIlllIl.readTextComponent();
        this.slotCount = lllllllllllllllIIllIlIIIIIIlllIl.readUnsignedByte();
        if (this.inventoryType.equals("EntityHorse")) {
            this.entityId = lllllllllllllllIIllIlIIIIIIlllIl.readInt();
        }
    }
    
    public int getEntityId() {
        return this.entityId;
    }
    
    public String getGuiId() {
        return this.inventoryType;
    }
    
    public SPacketOpenWindow(final int lllllllllllllllIIllIlIIIIlIllIlI, final String lllllllllllllllIIllIlIIIIlIllllI, final ITextComponent lllllllllllllllIIllIlIIIIlIlIllI) {
        this(lllllllllllllllIIllIlIIIIlIllIlI, lllllllllllllllIIllIlIIIIlIllllI, lllllllllllllllIIllIlIIIIlIlIllI, 0);
    }
}
