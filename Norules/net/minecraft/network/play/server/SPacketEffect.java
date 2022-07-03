package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.util.math.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketEffect implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ int soundType;
    private /* synthetic */ boolean serverWide;
    private /* synthetic */ int soundData;
    private /* synthetic */ BlockPos soundPos;
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlllIllIlIlIlIIlII) throws IOException {
        llllllllllllllIlllIllIlIlIlIIlII.writeInt(this.soundType);
        llllllllllllllIlllIllIlIlIlIIlII.writeBlockPos(this.soundPos);
        llllllllllllllIlllIllIlIlIlIIlII.writeInt(this.soundData);
        llllllllllllllIlllIllIlIlIlIIlII.writeBoolean(this.serverWide);
    }
    
    public SPacketEffect() {
    }
    
    public int getSoundData() {
        return this.soundData;
    }
    
    public SPacketEffect(final int llllllllllllllIlllIllIlIlIllIIIl, final BlockPos llllllllllllllIlllIllIlIlIllIlIl, final int llllllllllllllIlllIllIlIlIllIlII, final boolean llllllllllllllIlllIllIlIlIlIlllI) {
        this.soundType = llllllllllllllIlllIllIlIlIllIIIl;
        this.soundPos = llllllllllllllIlllIllIlIlIllIlIl;
        this.soundData = llllllllllllllIlllIllIlIlIllIlII;
        this.serverWide = llllllllllllllIlllIllIlIlIlIlllI;
    }
    
    public BlockPos getSoundPos() {
        return this.soundPos;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIlllIllIlIlIIlllII) {
        llllllllllllllIlllIllIlIlIIlllII.handleEffect(this);
    }
    
    public boolean isSoundServerwide() {
        return this.serverWide;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlllIllIlIlIlIlIlI) throws IOException {
        this.soundType = llllllllllllllIlllIllIlIlIlIlIlI.readInt();
        this.soundPos = llllllllllllllIlllIllIlIlIlIlIlI.readBlockPos();
        this.soundData = llllllllllllllIlllIllIlIlIlIlIlI.readInt();
        this.serverWide = llllllllllllllIlllIllIlIlIlIlIlI.readBoolean();
    }
    
    public int getSoundType() {
        return this.soundType;
    }
}
