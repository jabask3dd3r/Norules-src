package net.minecraft.world.gen.structure.template;

import net.minecraft.block.*;
import javax.annotation.*;
import net.minecraft.world.gen.structure.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;

public class PlacementSettings
{
    @Nullable
    private /* synthetic */ Block replacedBlock;
    @Nullable
    private /* synthetic */ ChunkPos chunk;
    @Nullable
    private /* synthetic */ Long setSeed;
    @Nullable
    private /* synthetic */ StructureBoundingBox boundingBox;
    @Nullable
    private /* synthetic */ Random random;
    private /* synthetic */ float integrity;
    private /* synthetic */ boolean ignoreStructureBlock;
    private /* synthetic */ Mirror mirror;
    private /* synthetic */ boolean ignoreEntities;
    private /* synthetic */ Rotation rotation;
    
    @Nullable
    private StructureBoundingBox getBoundingBoxFromChunk(@Nullable final ChunkPos llllllllllllllIIlllIllllIIllIIll) {
        if (llllllllllllllIIlllIllllIIllIIll == null) {
            return null;
        }
        final int llllllllllllllIIlllIllllIIllIIlI = llllllllllllllIIlllIllllIIllIIll.chunkXPos * 16;
        final int llllllllllllllIIlllIllllIIllIIIl = llllllllllllllIIlllIllllIIllIIll.chunkZPos * 16;
        return new StructureBoundingBox(llllllllllllllIIlllIllllIIllIIlI, 0, llllllllllllllIIlllIllllIIllIIIl, llllllllllllllIIlllIllllIIllIIlI + 16 - 1, 255, llllllllllllllIIlllIllllIIllIIIl + 16 - 1);
    }
    
    public PlacementSettings setChunk(final ChunkPos llllllllllllllIIlllIllllIlllllII) {
        this.chunk = llllllllllllllIIlllIllllIlllllII;
        return this;
    }
    
    public boolean getIgnoreEntities() {
        return this.ignoreEntities;
    }
    
    public PlacementSettings setMirror(final Mirror llllllllllllllIIlllIlllllIIlIIlI) {
        this.mirror = llllllllllllllIIlllIlllllIIlIIlI;
        return this;
    }
    
    public PlacementSettings setIgnoreStructureBlock(final boolean llllllllllllllIIlllIllllIlIllIIl) {
        this.ignoreStructureBlock = llllllllllllllIIlllIllllIlIllIIl;
        return this;
    }
    
    public PlacementSettings setRandom(@Nullable final Random llllllllllllllIIlllIllllIllIlIII) {
        this.random = llllllllllllllIIlllIllllIllIlIII;
        return this;
    }
    
    @Nullable
    public Block getReplacedBlock() {
        return this.replacedBlock;
    }
    
    @Nullable
    public StructureBoundingBox getBoundingBox() {
        if (this.boundingBox == null && this.chunk != null) {
            this.setBoundingBoxFromChunk();
        }
        return this.boundingBox;
    }
    
    public PlacementSettings setRotation(final Rotation llllllllllllllIIlllIlllllIIIllII) {
        this.rotation = llllllllllllllIIlllIlllllIIIllII;
        return this;
    }
    
    public Mirror getMirror() {
        return this.mirror;
    }
    
    public PlacementSettings setBoundingBox(final StructureBoundingBox llllllllllllllIIlllIllllIlllIllI) {
        this.boundingBox = llllllllllllllIIlllIllllIlllIllI;
        return this;
    }
    
    public Rotation getRotation() {
        return this.rotation;
    }
    
    public PlacementSettings copy() {
        final PlacementSettings llllllllllllllIIlllIlllllIIllIlI = new PlacementSettings();
        llllllllllllllIIlllIlllllIIllIlI.mirror = this.mirror;
        llllllllllllllIIlllIlllllIIllIlI.rotation = this.rotation;
        llllllllllllllIIlllIlllllIIllIlI.ignoreEntities = this.ignoreEntities;
        llllllllllllllIIlllIlllllIIllIlI.replacedBlock = this.replacedBlock;
        llllllllllllllIIlllIlllllIIllIlI.chunk = this.chunk;
        llllllllllllllIIlllIlllllIIllIlI.boundingBox = this.boundingBox;
        llllllllllllllIIlllIlllllIIllIlI.ignoreStructureBlock = this.ignoreStructureBlock;
        llllllllllllllIIlllIlllllIIllIlI.integrity = this.integrity;
        llllllllllllllIIlllIlllllIIllIlI.random = this.random;
        llllllllllllllIIlllIlllllIIllIlI.setSeed = this.setSeed;
        return llllllllllllllIIlllIlllllIIllIlI;
    }
    
    public float getIntegrity() {
        return this.integrity;
    }
    
    void setBoundingBoxFromChunk() {
        this.boundingBox = this.getBoundingBoxFromChunk(this.chunk);
    }
    
    public boolean getIgnoreStructureBlock() {
        return this.ignoreStructureBlock;
    }
    
    public Random getRandom(@Nullable final BlockPos llllllllllllllIIlllIllllIlIlIIII) {
        if (this.random != null) {
            return this.random;
        }
        if (this.setSeed != null) {
            return (this.setSeed == 0L) ? new Random(System.currentTimeMillis()) : new Random(this.setSeed);
        }
        if (llllllllllllllIIlllIllllIlIlIIII == null) {
            return new Random(System.currentTimeMillis());
        }
        final int llllllllllllllIIlllIllllIlIIllll = llllllllllllllIIlllIllllIlIlIIII.getX();
        final int llllllllllllllIIlllIllllIlIIlllI = llllllllllllllIIlllIllllIlIlIIII.getZ();
        return new Random(llllllllllllllIIlllIllllIlIIllll * llllllllllllllIIlllIllllIlIIllll * 4987142 + llllllllllllllIIlllIllllIlIIllll * 5947611 + llllllllllllllIIlllIllllIlIIlllI * llllllllllllllIIlllIllllIlIIlllI * 4392871L + llllllllllllllIIlllIllllIlIIlllI * 389711 ^ 0x3AD8025FL);
    }
    
    public PlacementSettings setIntegrity(final float llllllllllllllIIlllIllllIllIIIlI) {
        this.integrity = llllllllllllllIIlllIllllIllIIIlI;
        return this;
    }
    
    public PlacementSettings setSeed(@Nullable final Long llllllllllllllIIlllIllllIllIlllI) {
        this.setSeed = llllllllllllllIIlllIllllIllIlllI;
        return this;
    }
    
    public PlacementSettings setIgnoreEntities(final boolean llllllllllllllIIlllIlllllIIIIllI) {
        this.ignoreEntities = llllllllllllllIIlllIlllllIIIIllI;
        return this;
    }
    
    public PlacementSettings() {
        this.mirror = Mirror.NONE;
        this.rotation = Rotation.NONE;
        this.ignoreStructureBlock = true;
        this.integrity = 1.0f;
    }
    
    public PlacementSettings setReplacedBlock(final Block llllllllllllllIIlllIlllllIIIIIlI) {
        this.replacedBlock = llllllllllllllIIlllIlllllIIIIIlI;
        return this;
    }
}
