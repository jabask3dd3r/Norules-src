package net.minecraft.network.play.client;

import net.minecraft.network.play.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import java.io.*;
import net.minecraft.network.*;
import org.apache.commons.lang3.*;

public class CPacketTabComplete implements Packet<INetHandlerPlayServer>
{
    private /* synthetic */ String message;
    @Nullable
    private /* synthetic */ BlockPos targetBlock;
    private /* synthetic */ boolean hasTargetBlock;
    
    public CPacketTabComplete(final String lllllllllllllIllIIIlIIIIlIIlIllI, @Nullable final BlockPos lllllllllllllIllIIIlIIIIlIIllIIl, final boolean lllllllllllllIllIIIlIIIIlIIlIlII) {
        this.message = lllllllllllllIllIIIlIIIIlIIlIllI;
        this.targetBlock = lllllllllllllIllIIIlIIIIlIIllIIl;
        this.hasTargetBlock = lllllllllllllIllIIIlIIIIlIIlIlII;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIllIIIlIIIIlIIIllll) throws IOException {
        this.message = lllllllllllllIllIIIlIIIIlIIIllll.readStringFromBuffer(32767);
        this.hasTargetBlock = lllllllllllllIllIIIlIIIIlIIIllll.readBoolean();
        final boolean lllllllllllllIllIIIlIIIIlIIIlllI = lllllllllllllIllIIIlIIIIlIIIllll.readBoolean();
        if (lllllllllllllIllIIIlIIIIlIIIlllI) {
            this.targetBlock = lllllllllllllIllIIIlIIIIlIIIllll.readBlockPos();
        }
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public CPacketTabComplete() {
    }
    
    @Nullable
    public BlockPos getTargetBlock() {
        return this.targetBlock;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayServer lllllllllllllIllIIIlIIIIIlllllII) {
        lllllllllllllIllIIIlIIIIIlllllII.processTabComplete(this);
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIllIIIlIIIIlIIIIllI) throws IOException {
        lllllllllllllIllIIIlIIIIlIIIIllI.writeString(StringUtils.substring(this.message, 0, 32767));
        lllllllllllllIllIIIlIIIIlIIIIllI.writeBoolean(this.hasTargetBlock);
        final boolean lllllllllllllIllIIIlIIIIlIIIIlIl = this.targetBlock != null;
        lllllllllllllIllIIIlIIIIlIIIIllI.writeBoolean(lllllllllllllIllIIIlIIIIlIIIIlIl);
        if (lllllllllllllIllIIIlIIIIlIIIIlIl) {
            lllllllllllllIllIIIlIIIIlIIIIllI.writeBlockPos(this.targetBlock);
        }
    }
    
    public boolean hasTargetBlock() {
        return this.hasTargetBlock;
    }
}
