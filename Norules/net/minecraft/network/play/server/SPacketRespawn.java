package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import net.minecraft.world.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketRespawn implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ GameType gameType;
    private /* synthetic */ int dimensionID;
    private /* synthetic */ EnumDifficulty difficulty;
    private /* synthetic */ WorldType worldType;
    
    public SPacketRespawn(final int lllllllllllllllIIllIlIlIlllllIlI, final EnumDifficulty lllllllllllllllIIllIlIlIllllIlII, final WorldType lllllllllllllllIIllIlIlIlllllIII, final GameType lllllllllllllllIIllIlIlIllllIIlI) {
        this.dimensionID = lllllllllllllllIIllIlIlIlllllIlI;
        this.difficulty = lllllllllllllllIIllIlIlIllllIlII;
        this.gameType = lllllllllllllllIIllIlIlIllllIIlI;
        this.worldType = lllllllllllllllIIllIlIlIlllllIII;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllllIIllIlIlIlllIlllI) {
        lllllllllllllllIIllIlIlIlllIlllI.handleRespawn(this);
    }
    
    public GameType getGameType() {
        return this.gameType;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllllIIllIlIlIlllIIIII) throws IOException {
        lllllllllllllllIIllIlIlIlllIIIII.writeInt(this.dimensionID);
        lllllllllllllllIIllIlIlIlllIIIII.writeByte(this.difficulty.getDifficultyId());
        lllllllllllllllIIllIlIlIlllIIIII.writeByte(this.gameType.getID());
        lllllllllllllllIIllIlIlIlllIIIII.writeString(this.worldType.getWorldTypeName());
    }
    
    public SPacketRespawn() {
    }
    
    public EnumDifficulty getDifficulty() {
        return this.difficulty;
    }
    
    public int getDimensionID() {
        return this.dimensionID;
    }
    
    public WorldType getWorldType() {
        return this.worldType;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllllIIllIlIlIlllIIllI) throws IOException {
        this.dimensionID = lllllllllllllllIIllIlIlIlllIIllI.readInt();
        this.difficulty = EnumDifficulty.getDifficultyEnum(lllllllllllllllIIllIlIlIlllIIllI.readUnsignedByte());
        this.gameType = GameType.getByID(lllllllllllllllIIllIlIlIlllIIllI.readUnsignedByte());
        this.worldType = WorldType.parseWorldType(lllllllllllllllIIllIlIlIlllIIllI.readStringFromBuffer(16));
        if (this.worldType == null) {
            this.worldType = WorldType.DEFAULT;
        }
    }
}
