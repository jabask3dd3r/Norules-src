package net.minecraft.world.chunk.storage;

import java.util.*;
import javax.annotation.*;
import java.util.zip.*;
import net.minecraft.server.*;
import com.google.common.collect.*;
import java.io.*;

public class RegionFile
{
    private final /* synthetic */ int[] offsets;
    private static final /* synthetic */ byte[] EMPTY_SECTOR;
    private /* synthetic */ RandomAccessFile dataFile;
    private /* synthetic */ int sizeDelta;
    private /* synthetic */ long lastModified;
    private final /* synthetic */ File fileName;
    private final /* synthetic */ int[] chunkTimestamps;
    private /* synthetic */ List<Boolean> sectorFree;
    
    @Nullable
    public synchronized DataInputStream getChunkDataInputStream(final int lllllllllllllIIllIlIllIlllIllIII, final int lllllllllllllIIllIlIllIlllIlIlll) {
        if (this.outOfBounds(lllllllllllllIIllIlIllIlllIllIII, lllllllllllllIIllIlIllIlllIlIlll)) {
            return null;
        }
        try {
            final int lllllllllllllIIllIlIllIllllIIIIl = this.getOffset(lllllllllllllIIllIlIllIlllIllIII, lllllllllllllIIllIlIllIlllIlIlll);
            if (lllllllllllllIIllIlIllIllllIIIIl == 0) {
                return null;
            }
            final int lllllllllllllIIllIlIllIllllIIIII = lllllllllllllIIllIlIllIllllIIIIl >> 8;
            final int lllllllllllllIIllIlIllIlllIlllll = lllllllllllllIIllIlIllIllllIIIIl & 0xFF;
            if (lllllllllllllIIllIlIllIllllIIIII + lllllllllllllIIllIlIllIlllIlllll > this.sectorFree.size()) {
                return null;
            }
            this.dataFile.seek(lllllllllllllIIllIlIllIllllIIIII * 4096);
            final int lllllllllllllIIllIlIllIlllIllllI = this.dataFile.readInt();
            if (lllllllllllllIIllIlIllIlllIllllI > 4096 * lllllllllllllIIllIlIllIlllIlllll) {
                return null;
            }
            if (lllllllllllllIIllIlIllIlllIllllI <= 0) {
                return null;
            }
            final byte lllllllllllllIIllIlIllIlllIlllIl = this.dataFile.readByte();
            if (lllllllllllllIIllIlIllIlllIlllIl == 1) {
                final byte[] lllllllllllllIIllIlIllIlllIlllII = new byte[lllllllllllllIIllIlIllIlllIllllI - 1];
                this.dataFile.read(lllllllllllllIIllIlIllIlllIlllII);
                return new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(lllllllllllllIIllIlIllIlllIlllII))));
            }
            if (lllllllllllllIIllIlIllIlllIlllIl == 2) {
                final byte[] lllllllllllllIIllIlIllIlllIllIll = new byte[lllllllllllllIIllIlIllIlllIllllI - 1];
                this.dataFile.read(lllllllllllllIIllIlIllIlllIllIll);
                return new DataInputStream(new BufferedInputStream(new InflaterInputStream(new ByteArrayInputStream(lllllllllllllIIllIlIllIlllIllIll))));
            }
            return null;
        }
        catch (IOException lllllllllllllIIllIlIllIlllIllIlI) {
            return null;
        }
    }
    
    public boolean isChunkSaved(final int lllllllllllllIIllIlIllIlIlllllll, final int lllllllllllllIIllIlIllIlIllllllI) {
        return this.getOffset(lllllllllllllIIllIlIllIlIlllllll, lllllllllllllIIllIlIllIlIllllllI) != 0;
    }
    
    private int getOffset(final int lllllllllllllIIllIlIllIllIIIlIII, final int lllllllllllllIIllIlIllIllIIIIlll) {
        return this.offsets[lllllllllllllIIllIlIllIllIIIlIII + lllllllllllllIIllIlIllIllIIIIlll * 32];
    }
    
    @Nullable
    public DataOutputStream getChunkDataOutputStream(final int lllllllllllllIIllIlIllIlllIIlIIl, final int lllllllllllllIIllIlIllIlllIIlIII) {
        DataOutputStream dataOutputStream;
        if (this.outOfBounds(lllllllllllllIIllIlIllIlllIIlIIl, lllllllllllllIIllIlIllIlllIIlIII)) {
            dataOutputStream = null;
        }
        else {
            final BufferedOutputStream bufferedOutputStream;
            dataOutputStream = new DataOutputStream(bufferedOutputStream);
            bufferedOutputStream = new BufferedOutputStream(new DeflaterOutputStream(new ChunkBuffer(lllllllllllllIIllIlIllIlllIIlIIl, lllllllllllllIIllIlIllIlllIIlIII)));
        }
        return dataOutputStream;
    }
    
    private void setChunkTimestamp(final int lllllllllllllIIllIlIllIlIllIIlIl, final int lllllllllllllIIllIlIllIlIllIlIII, final int lllllllllllllIIllIlIllIlIllIIIll) throws IOException {
        this.chunkTimestamps[lllllllllllllIIllIlIllIlIllIIlIl + lllllllllllllIIllIlIllIlIllIlIII * 32] = lllllllllllllIIllIlIllIlIllIIIll;
        this.dataFile.seek(4096 + (lllllllllllllIIllIlIllIlIllIIlIl + lllllllllllllIIllIlIllIlIllIlIII * 32) * 4);
        this.dataFile.writeInt(lllllllllllllIIllIlIllIlIllIIIll);
    }
    
    private boolean outOfBounds(final int lllllllllllllIIllIlIllIllIIlIIII, final int lllllllllllllIIllIlIllIllIIIllIl) {
        return lllllllllllllIIllIlIllIllIIlIIII < 0 || lllllllllllllIIllIlIllIllIIlIIII >= 32 || lllllllllllllIIllIlIllIllIIIllIl < 0 || lllllllllllllIIllIlIllIllIIIllIl >= 32;
    }
    
    protected synchronized void write(final int lllllllllllllIIllIlIllIllIlllIlI, final int lllllllllllllIIllIlIllIllIlIlIIl, final byte[] lllllllllllllIIllIlIllIllIlllIII, final int lllllllllllllIIllIlIllIllIlIIlll) {
        try {
            final int lllllllllllllIIllIlIllIllIllIllI = this.getOffset(lllllllllllllIIllIlIllIllIlllIlI, lllllllllllllIIllIlIllIllIlIlIIl);
            int lllllllllllllIIllIlIllIllIllIlIl = lllllllllllllIIllIlIllIllIllIllI >> 8;
            final int lllllllllllllIIllIlIllIllIllIlII = lllllllllllllIIllIlIllIllIllIllI & 0xFF;
            final int lllllllllllllIIllIlIllIllIllIIll = (lllllllllllllIIllIlIllIllIlIIlll + 5) / 4096 + 1;
            if (lllllllllllllIIllIlIllIllIllIIll >= 256) {
                return;
            }
            if (lllllllllllllIIllIlIllIllIllIlIl != 0 && lllllllllllllIIllIlIllIllIllIlII == lllllllllllllIIllIlIllIllIllIIll) {
                this.write(lllllllllllllIIllIlIllIllIllIlIl, lllllllllllllIIllIlIllIllIlllIII, lllllllllllllIIllIlIllIllIlIIlll);
            }
            else {
                for (int lllllllllllllIIllIlIllIllIllIIlI = 0; lllllllllllllIIllIlIllIllIllIIlI < lllllllllllllIIllIlIllIllIllIlII; ++lllllllllllllIIllIlIllIllIllIIlI) {
                    this.sectorFree.set(lllllllllllllIIllIlIllIllIllIlIl + lllllllllllllIIllIlIllIllIllIIlI, true);
                }
                int lllllllllllllIIllIlIllIllIllIIIl = this.sectorFree.indexOf(true);
                int lllllllllllllIIllIlIllIllIllIIII = 0;
                if (lllllllllllllIIllIlIllIllIllIIIl != -1) {
                    for (int lllllllllllllIIllIlIllIllIlIllll = lllllllllllllIIllIlIllIllIllIIIl; lllllllllllllIIllIlIllIllIlIllll < this.sectorFree.size(); ++lllllllllllllIIllIlIllIllIlIllll) {
                        if (lllllllllllllIIllIlIllIllIllIIII != 0) {
                            if (this.sectorFree.get(lllllllllllllIIllIlIllIllIlIllll)) {
                                ++lllllllllllllIIllIlIllIllIllIIII;
                            }
                            else {
                                lllllllllllllIIllIlIllIllIllIIII = 0;
                            }
                        }
                        else if (this.sectorFree.get(lllllllllllllIIllIlIllIllIlIllll)) {
                            lllllllllllllIIllIlIllIllIllIIIl = lllllllllllllIIllIlIllIllIlIllll;
                            lllllllllllllIIllIlIllIllIllIIII = 1;
                        }
                        if (lllllllllllllIIllIlIllIllIllIIII >= lllllllllllllIIllIlIllIllIllIIll) {
                            break;
                        }
                    }
                }
                if (lllllllllllllIIllIlIllIllIllIIII >= lllllllllllllIIllIlIllIllIllIIll) {
                    lllllllllllllIIllIlIllIllIllIlIl = lllllllllllllIIllIlIllIllIllIIIl;
                    this.setOffset(lllllllllllllIIllIlIllIllIlllIlI, lllllllllllllIIllIlIllIllIlIlIIl, lllllllllllllIIllIlIllIllIllIIIl << 8 | lllllllllllllIIllIlIllIllIllIIll);
                    for (int lllllllllllllIIllIlIllIllIlIlllI = 0; lllllllllllllIIllIlIllIllIlIlllI < lllllllllllllIIllIlIllIllIllIIll; ++lllllllllllllIIllIlIllIllIlIlllI) {
                        this.sectorFree.set(lllllllllllllIIllIlIllIllIllIlIl + lllllllllllllIIllIlIllIllIlIlllI, false);
                    }
                    this.write(lllllllllllllIIllIlIllIllIllIlIl, lllllllllllllIIllIlIllIllIlllIII, lllllllllllllIIllIlIllIllIlIIlll);
                }
                else {
                    this.dataFile.seek(this.dataFile.length());
                    lllllllllllllIIllIlIllIllIllIlIl = this.sectorFree.size();
                    for (int lllllllllllllIIllIlIllIllIlIllIl = 0; lllllllllllllIIllIlIllIllIlIllIl < lllllllllllllIIllIlIllIllIllIIll; ++lllllllllllllIIllIlIllIllIlIllIl) {
                        this.dataFile.write(RegionFile.EMPTY_SECTOR);
                        this.sectorFree.add(false);
                    }
                    this.sizeDelta += 4096 * lllllllllllllIIllIlIllIllIllIIll;
                    this.write(lllllllllllllIIllIlIllIllIllIlIl, lllllllllllllIIllIlIllIllIlllIII, lllllllllllllIIllIlIllIllIlIIlll);
                    this.setOffset(lllllllllllllIIllIlIllIllIlllIlI, lllllllllllllIIllIlIllIllIlIlIIl, lllllllllllllIIllIlIllIllIllIlIl << 8 | lllllllllllllIIllIlIllIllIllIIll);
                }
            }
            this.setChunkTimestamp(lllllllllllllIIllIlIllIllIlllIlI, lllllllllllllIIllIlIllIllIlIlIIl, (int)(MinecraftServer.getCurrentTimeMillis() / 1000L));
        }
        catch (IOException lllllllllllllIIllIlIllIllIlIllII) {
            lllllllllllllIIllIlIllIllIlIllII.printStackTrace();
        }
    }
    
    public RegionFile(final File lllllllllllllIIllIlIllIlllllIIlI) {
        this.offsets = new int[1024];
        this.chunkTimestamps = new int[1024];
        this.fileName = lllllllllllllIIllIlIllIlllllIIlI;
        this.sizeDelta = 0;
        try {
            if (lllllllllllllIIllIlIllIlllllIIlI.exists()) {
                this.lastModified = lllllllllllllIIllIlIllIlllllIIlI.lastModified();
            }
            this.dataFile = new RandomAccessFile(lllllllllllllIIllIlIllIlllllIIlI, "rw");
            if (this.dataFile.length() < 4096L) {
                this.dataFile.write(RegionFile.EMPTY_SECTOR);
                this.dataFile.write(RegionFile.EMPTY_SECTOR);
                this.sizeDelta += 8192;
            }
            if ((this.dataFile.length() & 0xFFFL) != 0x0L) {
                for (int lllllllllllllIIllIlIllIlllllllII = 0; lllllllllllllIIllIlIllIlllllllII < (this.dataFile.length() & 0xFFFL); ++lllllllllllllIIllIlIllIlllllllII) {
                    this.dataFile.write(0);
                }
            }
            final int lllllllllllllIIllIlIllIllllllIll = (int)this.dataFile.length() / 4096;
            this.sectorFree = (List<Boolean>)Lists.newArrayListWithCapacity(lllllllllllllIIllIlIllIllllllIll);
            for (int lllllllllllllIIllIlIllIllllllIlI = 0; lllllllllllllIIllIlIllIllllllIlI < lllllllllllllIIllIlIllIllllllIll; ++lllllllllllllIIllIlIllIllllllIlI) {
                this.sectorFree.add(true);
            }
            this.sectorFree.set(0, false);
            this.sectorFree.set(1, false);
            this.dataFile.seek(0L);
            for (int lllllllllllllIIllIlIllIllllllIIl = 0; lllllllllllllIIllIlIllIllllllIIl < 1024; ++lllllllllllllIIllIlIllIllllllIIl) {
                final int lllllllllllllIIllIlIllIllllllIII = this.dataFile.readInt();
                this.offsets[lllllllllllllIIllIlIllIllllllIIl] = lllllllllllllIIllIlIllIllllllIII;
                if (lllllllllllllIIllIlIllIllllllIII != 0 && (lllllllllllllIIllIlIllIllllllIII >> 8) + (lllllllllllllIIllIlIllIllllllIII & 0xFF) <= this.sectorFree.size()) {
                    for (int lllllllllllllIIllIlIllIlllllIlll = 0; lllllllllllllIIllIlIllIlllllIlll < (lllllllllllllIIllIlIllIllllllIII & 0xFF); ++lllllllllllllIIllIlIllIlllllIlll) {
                        this.sectorFree.set((lllllllllllllIIllIlIllIllllllIII >> 8) + lllllllllllllIIllIlIllIlllllIlll, false);
                    }
                }
            }
            for (int lllllllllllllIIllIlIllIlllllIllI = 0; lllllllllllllIIllIlIllIlllllIllI < 1024; ++lllllllllllllIIllIlIllIlllllIllI) {
                final int lllllllllllllIIllIlIllIlllllIlIl = this.dataFile.readInt();
                this.chunkTimestamps[lllllllllllllIIllIlIllIlllllIllI] = lllllllllllllIIllIlIllIlllllIlIl;
            }
        }
        catch (IOException lllllllllllllIIllIlIllIlllllIlII) {
            lllllllllllllIIllIlIllIlllllIlII.printStackTrace();
        }
    }
    
    private void setOffset(final int lllllllllllllIIllIlIllIlIlllIIIl, final int lllllllllllllIIllIlIllIlIlllIIII, final int lllllllllllllIIllIlIllIlIlllIIll) throws IOException {
        this.offsets[lllllllllllllIIllIlIllIlIlllIIIl + lllllllllllllIIllIlIllIlIlllIIII * 32] = lllllllllllllIIllIlIllIlIlllIIll;
        this.dataFile.seek((lllllllllllllIIllIlIllIlIlllIIIl + lllllllllllllIIllIlIllIlIlllIIII * 32) * 4);
        this.dataFile.writeInt(lllllllllllllIIllIlIllIlIlllIIll);
    }
    
    static {
        EMPTY_SECTOR = new byte[4096];
    }
    
    public void close() throws IOException {
        if (this.dataFile != null) {
            this.dataFile.close();
        }
    }
    
    private void write(final int lllllllllllllIIllIlIllIllIIllIlI, final byte[] lllllllllllllIIllIlIllIllIIlIlIl, final int lllllllllllllIIllIlIllIllIIlIlII) throws IOException {
        this.dataFile.seek(lllllllllllllIIllIlIllIllIIllIlI * 4096);
        this.dataFile.writeInt(lllllllllllllIIllIlIllIllIIlIlII + 1);
        this.dataFile.writeByte(2);
        this.dataFile.write(lllllllllllllIIllIlIllIllIIlIlIl, 0, lllllllllllllIIllIlIllIllIIlIlII);
    }
    
    class ChunkBuffer extends ByteArrayOutputStream
    {
        private final /* synthetic */ int chunkZ;
        private final /* synthetic */ int chunkX;
        
        @Override
        public void close() throws IOException {
            RegionFile.this.write(this.chunkX, this.chunkZ, this.buf, this.count);
        }
        
        public ChunkBuffer(final int llllllllllllllllllIlllIllIIIlIlI, final int llllllllllllllllllIlllIllIIIllIl) {
            super(8096);
            this.chunkX = llllllllllllllllllIlllIllIIIlIlI;
            this.chunkZ = llllllllllllllllllIlllIllIIIllIl;
        }
    }
}
