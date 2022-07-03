package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.world.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketJoinGame implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ WorldType worldType;
    private /* synthetic */ GameType gameType;
    private /* synthetic */ boolean hardcoreMode;
    private /* synthetic */ boolean reducedDebugInfo;
    private /* synthetic */ int dimension;
    private /* synthetic */ int playerId;
    private /* synthetic */ EnumDifficulty difficulty;
    private /* synthetic */ int maxPlayers;
    
    public int getPlayerId() {
        return this.playerId;
    }
    
    public SPacketJoinGame() {
    }
    
    public boolean isHardcoreMode() {
        return this.hardcoreMode;
    }
    
    @Override
    public void readPacketData(final PacketBuffer llllllllllllllIlllIIIIllllIlIllI) throws IOException {
        this.playerId = llllllllllllllIlllIIIIllllIlIllI.readInt();
        int llllllllllllllIlllIIIIllllIllIII = llllllllllllllIlllIIIIllllIlIllI.readUnsignedByte();
        this.hardcoreMode = ((llllllllllllllIlllIIIIllllIllIII & 0x8) == 0x8);
        llllllllllllllIlllIIIIllllIllIII &= 0xFFFFFFF7;
        this.gameType = GameType.getByID(llllllllllllllIlllIIIIllllIllIII);
        this.dimension = llllllllllllllIlllIIIIllllIlIllI.readInt();
        this.difficulty = EnumDifficulty.getDifficultyEnum(llllllllllllllIlllIIIIllllIlIllI.readUnsignedByte());
        this.maxPlayers = llllllllllllllIlllIIIIllllIlIllI.readUnsignedByte();
        this.worldType = WorldType.parseWorldType(llllllllllllllIlllIIIIllllIlIllI.readStringFromBuffer(16));
        if (this.worldType == null) {
            this.worldType = WorldType.DEFAULT;
        }
        this.reducedDebugInfo = llllllllllllllIlllIIIIllllIlIllI.readBoolean();
    }
    
    public WorldType getWorldType() {
        return this.worldType;
    }
    
    public boolean isReducedDebugInfo() {
        return this.reducedDebugInfo;
    }
    
    @Override
    public void writePacketData(final PacketBuffer llllllllllllllIlllIIIIllllIIllIl) throws IOException {
        llllllllllllllIlllIIIIllllIIllIl.writeInt(this.playerId);
        int llllllllllllllIlllIIIIllllIIllll = this.gameType.getID();
        if (this.hardcoreMode) {
            llllllllllllllIlllIIIIllllIIllll |= 0x8;
        }
        llllllllllllllIlllIIIIllllIIllIl.writeByte(llllllllllllllIlllIIIIllllIIllll);
        llllllllllllllIlllIIIIllllIIllIl.writeInt(this.dimension);
        llllllllllllllIlllIIIIllllIIllIl.writeByte(this.difficulty.getDifficultyId());
        llllllllllllllIlllIIIIllllIIllIl.writeByte(this.maxPlayers);
        llllllllllllllIlllIIIIllllIIllIl.writeString(this.worldType.getWorldTypeName());
        llllllllllllllIlllIIIIllllIIllIl.writeBoolean(this.reducedDebugInfo);
    }
    
    public int getMaxPlayers() {
        return this.maxPlayers;
    }
    
    public EnumDifficulty getDifficulty() {
        return this.difficulty;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient llllllllllllllIlllIIIIllllIIIllI) {
        llllllllllllllIlllIIIIllllIIIllI.handleJoinGame(this);
    }
    
    public SPacketJoinGame(final int llllllllllllllIlllIIIIlllllIIlIl, final GameType llllllllllllllIlllIIIIlllllIIlII, final boolean llllllllllllllIlllIIIIlllllIIIll, final int llllllllllllllIlllIIIIlllllIIIlI, final EnumDifficulty llllllllllllllIlllIIIIlllllIIIIl, final int llllllllllllllIlllIIIIlllllIIIII, final WorldType llllllllllllllIlllIIIIllllIlllll, final boolean llllllllllllllIlllIIIIllllIllllI) {
        this.playerId = llllllllllllllIlllIIIIlllllIIlIl;
        this.dimension = llllllllllllllIlllIIIIlllllIIIlI;
        this.difficulty = llllllllllllllIlllIIIIlllllIIIIl;
        this.gameType = llllllllllllllIlllIIIIlllllIIlII;
        this.maxPlayers = llllllllllllllIlllIIIIlllllIIIII;
        this.hardcoreMode = llllllllllllllIlllIIIIlllllIIIll;
        this.worldType = llllllllllllllIlllIIIIllllIlllll;
        this.reducedDebugInfo = llllllllllllllIlllIIIIllllIllllI;
    }
    
    public GameType getGameType() {
        return this.gameType;
    }
    
    public int getDimension() {
        return this.dimension;
    }
}
