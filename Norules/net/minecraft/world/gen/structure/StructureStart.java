package net.minecraft.world.gen.structure;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.nbt.*;

public abstract class StructureStart
{
    private /* synthetic */ int chunkPosX;
    protected /* synthetic */ List<StructureComponent> components;
    private /* synthetic */ int chunkPosZ;
    protected /* synthetic */ StructureBoundingBox boundingBox;
    
    public StructureBoundingBox getBoundingBox() {
        return this.boundingBox;
    }
    
    protected void setRandomHeight(final World lllllllllllllIlIIIIIlIlIIlIllIIl, final Random lllllllllllllIlIIIIIlIlIIlIIllll, final int lllllllllllllIlIIIIIlIlIIlIlIlll, final int lllllllllllllIlIIIIIlIlIIlIlIllI) {
        final int lllllllllllllIlIIIIIlIlIIlIlIlIl = lllllllllllllIlIIIIIlIlIIlIlIllI - lllllllllllllIlIIIIIlIlIIlIlIlll + 1 - this.boundingBox.getYSize();
        int lllllllllllllIlIIIIIlIlIIlIlIIll = 0;
        if (lllllllllllllIlIIIIIlIlIIlIlIlIl > 1) {
            final int lllllllllllllIlIIIIIlIlIIlIlIlII = lllllllllllllIlIIIIIlIlIIlIlIlll + lllllllllllllIlIIIIIlIlIIlIIllll.nextInt(lllllllllllllIlIIIIIlIlIIlIlIlIl);
        }
        else {
            lllllllllllllIlIIIIIlIlIIlIlIIll = lllllllllllllIlIIIIIlIlIIlIlIlll;
        }
        final int lllllllllllllIlIIIIIlIlIIlIlIIlI = lllllllllllllIlIIIIIlIlIIlIlIIll - this.boundingBox.minY;
        this.boundingBox.offset(0, lllllllllllllIlIIIIIlIlIIlIlIIlI, 0);
        for (final StructureComponent lllllllllllllIlIIIIIlIlIIlIlIIIl : this.components) {
            lllllllllllllIlIIIIIlIlIIlIlIIIl.offset(0, lllllllllllllIlIIIIIlIlIIlIlIIlI, 0);
        }
    }
    
    public List<StructureComponent> getComponents() {
        return this.components;
    }
    
    public void notifyPostProcessAt(final ChunkPos lllllllllllllIlIIIIIlIlIIlIIIIll) {
    }
    
    public void writeToNBT(final NBTTagCompound lllllllllllllIlIIIIIlIlIlIIIllll) {
    }
    
    public boolean isValidForPostProcess(final ChunkPos lllllllllllllIlIIIIIlIlIIlIIIlIl) {
        return true;
    }
    
    protected void updateBoundingBox() {
        this.boundingBox = StructureBoundingBox.getNewBoundingBox();
        for (final StructureComponent lllllllllllllIlIIIIIlIlIlIlIlIII : this.components) {
            this.boundingBox.expandTo(lllllllllllllIlIIIIIlIlIlIlIlIII.getBoundingBox());
        }
    }
    
    public void readStructureComponentsFromNBT(final World lllllllllllllIlIIIIIlIlIlIIIIIll, final NBTTagCompound lllllllllllllIlIIIIIlIlIlIIIIlll) {
        this.chunkPosX = lllllllllllllIlIIIIIlIlIlIIIIlll.getInteger("ChunkX");
        this.chunkPosZ = lllllllllllllIlIIIIIlIlIlIIIIlll.getInteger("ChunkZ");
        if (lllllllllllllIlIIIIIlIlIlIIIIlll.hasKey("BB")) {
            this.boundingBox = new StructureBoundingBox(lllllllllllllIlIIIIIlIlIlIIIIlll.getIntArray("BB"));
        }
        final NBTTagList lllllllllllllIlIIIIIlIlIlIIIIllI = lllllllllllllIlIIIIIlIlIlIIIIlll.getTagList("Children", 10);
        for (int lllllllllllllIlIIIIIlIlIlIIIIlIl = 0; lllllllllllllIlIIIIIlIlIlIIIIlIl < lllllllllllllIlIIIIIlIlIlIIIIllI.tagCount(); ++lllllllllllllIlIIIIIlIlIlIIIIlIl) {
            this.components.add(MapGenStructureIO.getStructureComponent(lllllllllllllIlIIIIIlIlIlIIIIllI.getCompoundTagAt(lllllllllllllIlIIIIIlIlIlIIIIlIl), lllllllllllllIlIIIIIlIlIlIIIIIll));
        }
        this.readFromNBT(lllllllllllllIlIIIIIlIlIlIIIIlll);
    }
    
    public void generateStructure(final World lllllllllllllIlIIIIIlIlIlIllIlll, final Random lllllllllllllIlIIIIIlIlIlIllIIII, final StructureBoundingBox lllllllllllllIlIIIIIlIlIlIllIlIl) {
        final Iterator<StructureComponent> lllllllllllllIlIIIIIlIlIlIllIlII = this.components.iterator();
        while (lllllllllllllIlIIIIIlIlIlIllIlII.hasNext()) {
            final StructureComponent lllllllllllllIlIIIIIlIlIlIllIIll = lllllllllllllIlIIIIIlIlIlIllIlII.next();
            if (lllllllllllllIlIIIIIlIlIlIllIIll.getBoundingBox().intersectsWith(lllllllllllllIlIIIIIlIlIlIllIlIl) && !lllllllllllllIlIIIIIlIlIlIllIIll.addComponentParts(lllllllllllllIlIIIIIlIlIlIllIlll, lllllllllllllIlIIIIIlIlIlIllIIII, lllllllllllllIlIIIIIlIlIlIllIlIl)) {
                lllllllllllllIlIIIIIlIlIlIllIlII.remove();
            }
        }
    }
    
    protected void markAvailableHeight(final World lllllllllllllIlIIIIIlIlIIlllIIll, final Random lllllllllllllIlIIIIIlIlIIlllIIlI, final int lllllllllllllIlIIIIIlIlIIlllIIIl) {
        final int lllllllllllllIlIIIIIlIlIIlllIIII = lllllllllllllIlIIIIIlIlIIlllIIll.getSeaLevel() - lllllllllllllIlIIIIIlIlIIlllIIIl;
        int lllllllllllllIlIIIIIlIlIIllIllll = this.boundingBox.getYSize() + 1;
        if (lllllllllllllIlIIIIIlIlIIllIllll < lllllllllllllIlIIIIIlIlIIlllIIII) {
            lllllllllllllIlIIIIIlIlIIllIllll += lllllllllllllIlIIIIIlIlIIlllIIlI.nextInt(lllllllllllllIlIIIIIlIlIIlllIIII - lllllllllllllIlIIIIIlIlIIllIllll);
        }
        final int lllllllllllllIlIIIIIlIlIIllIlllI = lllllllllllllIlIIIIIlIlIIllIllll - this.boundingBox.maxY;
        this.boundingBox.offset(0, lllllllllllllIlIIIIIlIlIIllIlllI, 0);
        for (final StructureComponent lllllllllllllIlIIIIIlIlIIllIllIl : this.components) {
            lllllllllllllIlIIIIIlIlIIllIllIl.offset(0, lllllllllllllIlIIIIIlIlIIllIlllI, 0);
        }
    }
    
    public int getChunkPosZ() {
        return this.chunkPosZ;
    }
    
    public boolean isSizeableStructure() {
        return true;
    }
    
    public StructureStart() {
        this.components = (List<StructureComponent>)Lists.newLinkedList();
    }
    
    public int getChunkPosX() {
        return this.chunkPosX;
    }
    
    public StructureStart(final int lllllllllllllIlIIIIIlIlIllIIIllI, final int lllllllllllllIlIIIIIlIlIllIIIlIl) {
        this.components = (List<StructureComponent>)Lists.newLinkedList();
        this.chunkPosX = lllllllllllllIlIIIIIlIlIllIIIllI;
        this.chunkPosZ = lllllllllllllIlIIIIIlIlIllIIIlIl;
    }
    
    public NBTTagCompound writeStructureComponentsToNBT(final int lllllllllllllIlIIIIIlIlIlIIlIllI, final int lllllllllllllIlIIIIIlIlIlIIlIlIl) {
        final NBTTagCompound lllllllllllllIlIIIIIlIlIlIIllIlI = new NBTTagCompound();
        lllllllllllllIlIIIIIlIlIlIIllIlI.setString("id", MapGenStructureIO.getStructureStartName(this));
        lllllllllllllIlIIIIIlIlIlIIllIlI.setInteger("ChunkX", lllllllllllllIlIIIIIlIlIlIIlIllI);
        lllllllllllllIlIIIIIlIlIlIIllIlI.setInteger("ChunkZ", lllllllllllllIlIIIIIlIlIlIIlIlIl);
        lllllllllllllIlIIIIIlIlIlIIllIlI.setTag("BB", this.boundingBox.toNBTTagIntArray());
        final NBTTagList lllllllllllllIlIIIIIlIlIlIIllIIl = new NBTTagList();
        for (final StructureComponent lllllllllllllIlIIIIIlIlIlIIllIII : this.components) {
            lllllllllllllIlIIIIIlIlIlIIllIIl.appendTag(lllllllllllllIlIIIIIlIlIlIIllIII.createStructureBaseNBT());
        }
        lllllllllllllIlIIIIIlIlIlIIllIlI.setTag("Children", lllllllllllllIlIIIIIlIlIlIIllIIl);
        this.writeToNBT(lllllllllllllIlIIIIIlIlIlIIllIlI);
        return lllllllllllllIlIIIIIlIlIlIIllIlI;
    }
    
    public void readFromNBT(final NBTTagCompound lllllllllllllIlIIIIIlIlIIllllllI) {
    }
}
