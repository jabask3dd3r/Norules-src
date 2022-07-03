package net.minecraft.network.play.server;

import net.minecraft.network.play.*;
import java.util.*;
import net.minecraft.world.storage.*;
import net.minecraft.network.*;
import java.io.*;

public class SPacketMaps implements Packet<INetHandlerPlayClient>
{
    private /* synthetic */ byte[] mapDataBytes;
    private /* synthetic */ int minZ;
    private /* synthetic */ int mapId;
    private /* synthetic */ int columns;
    private /* synthetic */ byte mapScale;
    private /* synthetic */ int minX;
    private /* synthetic */ MapDecoration[] icons;
    private /* synthetic */ int rows;
    private /* synthetic */ boolean trackingPosition;
    
    public SPacketMaps(final int lllllllllllllIIIlIlIIlIlllIIlIII, final byte lllllllllllllIIIlIlIIlIlllIlIIll, final boolean lllllllllllllIIIlIlIIlIlllIlIIlI, final Collection<MapDecoration> lllllllllllllIIIlIlIIlIlllIlIIIl, final byte[] lllllllllllllIIIlIlIIlIlllIlIIII, final int lllllllllllllIIIlIlIIlIlllIIIIll, final int lllllllllllllIIIlIlIIlIlllIIIIlI, final int lllllllllllllIIIlIlIIlIlllIIllIl, final int lllllllllllllIIIlIlIIlIlllIIIIII) {
        this.mapId = lllllllllllllIIIlIlIIlIlllIIlIII;
        this.mapScale = lllllllllllllIIIlIlIIlIlllIlIIll;
        this.trackingPosition = lllllllllllllIIIlIlIIlIlllIlIIlI;
        this.icons = lllllllllllllIIIlIlIIlIlllIlIIIl.toArray(new MapDecoration[lllllllllllllIIIlIlIIlIlllIlIIIl.size()]);
        this.minX = lllllllllllllIIIlIlIIlIlllIIIIll;
        this.minZ = lllllllllllllIIIlIlIIlIlllIIIIlI;
        this.columns = lllllllllllllIIIlIlIIlIlllIIllIl;
        this.rows = lllllllllllllIIIlIlIIlIlllIIIIII;
        this.mapDataBytes = new byte[lllllllllllllIIIlIlIIlIlllIIllIl * lllllllllllllIIIlIlIIlIlllIIIIII];
        for (int lllllllllllllIIIlIlIIlIlllIIlIll = 0; lllllllllllllIIIlIlIIlIlllIIlIll < lllllllllllllIIIlIlIIlIlllIIllIl; ++lllllllllllllIIIlIlIIlIlllIIlIll) {
            for (int lllllllllllllIIIlIlIIlIlllIIlIlI = 0; lllllllllllllIIIlIlIIlIlllIIlIlI < lllllllllllllIIIlIlIIlIlllIIIIII; ++lllllllllllllIIIlIlIIlIlllIIlIlI) {
                this.mapDataBytes[lllllllllllllIIIlIlIIlIlllIIlIll + lllllllllllllIIIlIlIIlIlllIIlIlI * lllllllllllllIIIlIlIIlIlllIIllIl] = lllllllllllllIIIlIlIIlIlllIlIIII[lllllllllllllIIIlIlIIlIlllIIIIll + lllllllllllllIIIlIlIIlIlllIIlIll + (lllllllllllllIIIlIlIIlIlllIIIIlI + lllllllllllllIIIlIlIIlIlllIIlIlI) * 128];
            }
        }
    }
    
    public SPacketMaps() {
    }
    
    public void setMapdataTo(final MapData lllllllllllllIIIlIlIIlIllIIIlllI) {
        lllllllllllllIIIlIlIIlIllIIIlllI.scale = this.mapScale;
        lllllllllllllIIIlIlIIlIllIIIlllI.trackingPosition = this.trackingPosition;
        lllllllllllllIIIlIlIIlIllIIIlllI.mapDecorations.clear();
        for (int lllllllllllllIIIlIlIIlIllIIlIIll = 0; lllllllllllllIIIlIlIIlIllIIlIIll < this.icons.length; ++lllllllllllllIIIlIlIIlIllIIlIIll) {
            final MapDecoration lllllllllllllIIIlIlIIlIllIIlIIlI = this.icons[lllllllllllllIIIlIlIIlIllIIlIIll];
            lllllllllllllIIIlIlIIlIllIIIlllI.mapDecorations.put(String.valueOf(new StringBuilder("icon-").append(lllllllllllllIIIlIlIIlIllIIlIIll)), lllllllllllllIIIlIlIIlIllIIlIIlI);
        }
        for (int lllllllllllllIIIlIlIIlIllIIlIIIl = 0; lllllllllllllIIIlIlIIlIllIIlIIIl < this.columns; ++lllllllllllllIIIlIlIIlIllIIlIIIl) {
            for (int lllllllllllllIIIlIlIIlIllIIlIIII = 0; lllllllllllllIIIlIlIIlIllIIlIIII < this.rows; ++lllllllllllllIIIlIlIIlIllIIlIIII) {
                lllllllllllllIIIlIlIIlIllIIIlllI.colors[this.minX + lllllllllllllIIIlIlIIlIllIIlIIIl + (this.minZ + lllllllllllllIIIlIlIIlIllIIlIIII) * 128] = this.mapDataBytes[lllllllllllllIIIlIlIIlIllIIlIIIl + lllllllllllllIIIlIlIIlIllIIlIIII * this.columns];
            }
        }
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIIIlIlIIlIllIlIIlll) throws IOException {
        lllllllllllllIIIlIlIIlIllIlIIlll.writeVarIntToBuffer(this.mapId);
        lllllllllllllIIIlIlIIlIllIlIIlll.writeByte(this.mapScale);
        lllllllllllllIIIlIlIIlIllIlIIlll.writeBoolean(this.trackingPosition);
        lllllllllllllIIIlIlIIlIllIlIIlll.writeVarIntToBuffer(this.icons.length);
        final String lllllllllllllIIIlIlIIlIllIlIIIll;
        final byte lllllllllllllIIIlIlIIlIllIlIIlII = (byte)((MapDecoration[])(Object)(lllllllllllllIIIlIlIIlIllIlIIIll = (String)(Object)this.icons)).length;
        for (float lllllllllllllIIIlIlIIlIllIlIIlIl = 0; lllllllllllllIIIlIlIIlIllIlIIlIl < lllllllllllllIIIlIlIIlIllIlIIlII; ++lllllllllllllIIIlIlIIlIllIlIIlIl) {
            final MapDecoration lllllllllllllIIIlIlIIlIllIlIlIIl = lllllllllllllIIIlIlIIlIllIlIIIll[lllllllllllllIIIlIlIIlIllIlIIlIl];
            lllllllllllllIIIlIlIIlIllIlIIlll.writeByte((lllllllllllllIIIlIlIIlIllIlIlIIl.getType() & 0xF) << 4 | (lllllllllllllIIIlIlIIlIllIlIlIIl.getRotation() & 0xF));
            lllllllllllllIIIlIlIIlIllIlIIlll.writeByte(lllllllllllllIIIlIlIIlIllIlIlIIl.getX());
            lllllllllllllIIIlIlIIlIllIlIIlll.writeByte(lllllllllllllIIIlIlIIlIllIlIlIIl.getY());
        }
        lllllllllllllIIIlIlIIlIllIlIIlll.writeByte(this.columns);
        if (this.columns > 0) {
            lllllllllllllIIIlIlIIlIllIlIIlll.writeByte(this.rows);
            lllllllllllllIIIlIlIIlIllIlIIlll.writeByte(this.minX);
            lllllllllllllIIIlIlIIlIllIlIIlll.writeByte(this.minZ);
            lllllllllllllIIIlIlIIlIllIlIIlll.writeByteArray(this.mapDataBytes);
        }
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIIIlIlIIlIllIllIlII) throws IOException {
        this.mapId = lllllllllllllIIIlIlIIlIllIllIlII.readVarIntFromBuffer();
        this.mapScale = lllllllllllllIIIlIlIIlIllIllIlII.readByte();
        this.trackingPosition = lllllllllllllIIIlIlIIlIllIllIlII.readBoolean();
        this.icons = new MapDecoration[lllllllllllllIIIlIlIIlIllIllIlII.readVarIntFromBuffer()];
        for (int lllllllllllllIIIlIlIIlIllIllIlll = 0; lllllllllllllIIIlIlIIlIllIllIlll < this.icons.length; ++lllllllllllllIIIlIlIIlIllIllIlll) {
            final short lllllllllllllIIIlIlIIlIllIllIllI = lllllllllllllIIIlIlIIlIllIllIlII.readByte();
            this.icons[lllllllllllllIIIlIlIIlIllIllIlll] = new MapDecoration(MapDecoration.Type.func_191159_a((byte)(lllllllllllllIIIlIlIIlIllIllIllI >> 4 & 0xF)), lllllllllllllIIIlIlIIlIllIllIlII.readByte(), lllllllllllllIIIlIlIIlIllIllIlII.readByte(), (byte)(lllllllllllllIIIlIlIIlIllIllIllI & 0xF));
        }
        this.columns = lllllllllllllIIIlIlIIlIllIllIlII.readUnsignedByte();
        if (this.columns > 0) {
            this.rows = lllllllllllllIIIlIlIIlIllIllIlII.readUnsignedByte();
            this.minX = lllllllllllllIIIlIlIIlIllIllIlII.readUnsignedByte();
            this.minZ = lllllllllllllIIIlIlIIlIllIllIlII.readUnsignedByte();
            this.mapDataBytes = lllllllllllllIIIlIlIIlIllIllIlII.readByteArray();
        }
    }
    
    public int getMapId() {
        return this.mapId;
    }
    
    @Override
    public void processPacket(final INetHandlerPlayClient lllllllllllllIIIlIlIIlIllIIlllIl) {
        lllllllllllllIIIlIlIIlIllIIlllIl.handleMaps(this);
    }
}
