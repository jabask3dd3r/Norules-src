package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.item.*;
import java.io.*;
import net.minecraft.network.*;

public class SPacketSpawnPainting implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ UUID uniqueId;
    private /* synthetic */ EnumFacing facing;
    private /* synthetic */ BlockPos position;
    private /* synthetic */ int entityID;
    private /* synthetic */ String title;
    
    public SPacketSpawnPainting(final EntityPainting lllllllllllllIIllllIlIlIIlIlIIIl) {
        this.entityID = lllllllllllllIIllllIlIlIIlIlIIIl.getEntityId();
        this.uniqueId = lllllllllllllIIllllIlIlIIlIlIIIl.getUniqueID();
        this.position = lllllllllllllIIllllIlIlIIlIlIIIl.getHangingPosition();
        this.facing = lllllllllllllIIllllIlIlIIlIlIIIl.facingDirection;
        this.title = lllllllllllllIIllllIlIlIIlIlIIIl.art.title;
    }
    
    public SPacketSpawnPainting() {
    }
    
    public EnumFacing getFacing() {
        return this.facing;
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIllllIlIlIIlIIIlIl) throws IOException {
        lllllllllllllIIllllIlIlIIlIIIlIl.writeVarIntToBuffer(this.entityID);
        lllllllllllllIIllllIlIlIIlIIIlIl.writeUuid(this.uniqueId);
        lllllllllllllIIllllIlIlIIlIIIlIl.writeString(this.title);
        lllllllllllllIIllllIlIlIIlIIIlIl.writeBlockPos(this.position);
        lllllllllllllIIllllIlIlIIlIIIlIl.writeByte(this.facing.getHorizontalIndex());
    }
    
    public UUID getUniqueId() {
        return this.uniqueId;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIllllIlIlIIIllllll) {
        lllllllllllllIIllllIlIlIIIllllll.handleSpawnPainting(this);
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public BlockPos getPosition() {
        return this.position;
    }
    
    public int getEntityID() {
        return this.entityID;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIllllIlIlIIlIIlIIl) throws IOException {
        this.entityID = lllllllllllllIIllllIlIlIIlIIlIIl.readVarIntFromBuffer();
        this.uniqueId = lllllllllllllIIllllIlIlIIlIIlIIl.readUuid();
        this.title = lllllllllllllIIllllIlIlIIlIIlIIl.readStringFromBuffer(EntityPainting.EnumArt.MAX_NAME_LENGTH);
        this.position = lllllllllllllIIllllIlIlIIlIIlIIl.readBlockPos();
        this.facing = EnumFacing.getHorizontal(lllllllllllllIIllllIlIlIIlIIlIIl.readUnsignedByte());
    }
}
