package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.world.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketServerDifficulty implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ EnumDifficulty difficulty;
    private /* synthetic */ boolean difficultyLocked;
    
    public SPacketServerDifficulty() {
    }
    
    public SPacketServerDifficulty(final EnumDifficulty lllllllllllllIIllIIlllIIIlIIIIlI, final boolean lllllllllllllIIllIIlllIIIlIIIlII) {
        this.difficulty = lllllllllllllIIllIIlllIIIlIIIIlI;
        this.difficultyLocked = lllllllllllllIIllIIlllIIIlIIIlII;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIllIIlllIIIIllIlll) throws IOException {
        this.difficulty = EnumDifficulty.getDifficultyEnum(lllllllllllllIIllIIlllIIIIllIlll.readUnsignedByte());
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIllIIlllIIIIlllIll) {
        lllllllllllllIIllIIlllIIIIlllIll.handleServerDifficulty(this);
    }
    
    public EnumDifficulty getDifficulty() {
        return this.difficulty;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIllIIlllIIIIllIIIl) throws IOException {
        lllllllllllllIIllIIlllIIIIllIIIl.writeByte(this.difficulty.getDifficultyId());
    }
    
    public boolean isDifficultyLocked() {
        return this.difficultyLocked;
    }
}
