package net.minecraft.nbt;

import com.google.common.collect.*;
import org.apache.logging.log4j.*;
import java.util.*;
import java.io.*;

public class NBTTagList extends NBTBase
{
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ byte tagType;
    private /* synthetic */ List<NBTBase> tagList;
    
    public int getIntAt(final int lllllllllllllIllIIlIllIIlllIlIll) {
        if (lllllllllllllIllIIlIllIIlllIlIll >= 0 && lllllllllllllIllIIlIllIIlllIlIll < this.tagList.size()) {
            final NBTBase lllllllllllllIllIIlIllIIlllIlIlI = this.tagList.get(lllllllllllllIllIIlIllIIlllIlIll);
            if (lllllllllllllIllIIlIllIIlllIlIlI.getId() == 3) {
                return ((NBTTagInt)lllllllllllllIllIIlIllIIlllIlIlI).getInt();
            }
        }
        return 0;
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllllIllIIlIllIlIIIlIlIl = new StringBuilder("[");
        for (int lllllllllllllIllIIlIllIlIIIlIlII = 0; lllllllllllllIllIIlIllIlIIIlIlII < this.tagList.size(); ++lllllllllllllIllIIlIllIlIIIlIlII) {
            if (lllllllllllllIllIIlIllIlIIIlIlII != 0) {
                lllllllllllllIllIIlIllIlIIIlIlIl.append(',');
            }
            lllllllllllllIllIIlIllIlIIIlIlIl.append(this.tagList.get(lllllllllllllIllIIlIllIlIIIlIlII));
        }
        return String.valueOf(lllllllllllllIllIIlIllIlIIIlIlIl.append(']'));
    }
    
    public NBTTagList() {
        this.tagList = (List<NBTBase>)Lists.newArrayList();
        this.tagType = 0;
    }
    
    public int getTagType() {
        return this.tagType;
    }
    
    @Override
    void write(final DataOutput lllllllllllllIllIIlIllIlIIllIIIl) throws IOException {
        if (this.tagList.isEmpty()) {
            this.tagType = 0;
        }
        else {
            this.tagType = this.tagList.get(0).getId();
        }
        lllllllllllllIllIIlIllIlIIllIIIl.writeByte(this.tagType);
        lllllllllllllIllIIlIllIlIIllIIIl.writeInt(this.tagList.size());
        for (int lllllllllllllIllIIlIllIlIIllIIll = 0; lllllllllllllIllIIlIllIlIIllIIll < this.tagList.size(); ++lllllllllllllIllIIlIllIlIIllIIll) {
            this.tagList.get(lllllllllllllIllIIlIllIlIIllIIll).write(lllllllllllllIllIIlIllIlIIllIIIl);
        }
    }
    
    public void appendTag(final NBTBase lllllllllllllIllIIlIllIlIIIIllIl) {
        if (lllllllllllllIllIIlIllIlIIIIllIl.getId() == 0) {
            NBTTagList.LOGGER.warn("Invalid TagEnd added to ListTag");
        }
        else {
            if (this.tagType == 0) {
                this.tagType = lllllllllllllIllIIlIllIlIIIIllIl.getId();
            }
            else if (this.tagType != lllllllllllllIllIIlIllIlIIIIllIl.getId()) {
                NBTTagList.LOGGER.warn("Adding mismatching tag types to tag list");
                return;
            }
            this.tagList.add(lllllllllllllIllIIlIllIlIIIIllIl);
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public void set(final int lllllllllllllIllIIlIllIlIIIIIIll, final NBTBase lllllllllllllIllIIlIllIlIIIIIlIl) {
        if (lllllllllllllIllIIlIllIlIIIIIlIl.getId() == 0) {
            NBTTagList.LOGGER.warn("Invalid TagEnd added to ListTag");
        }
        else if (lllllllllllllIllIIlIllIlIIIIIIll >= 0 && lllllllllllllIllIIlIllIlIIIIIIll < this.tagList.size()) {
            if (this.tagType == 0) {
                this.tagType = lllllllllllllIllIIlIllIlIIIIIlIl.getId();
            }
            else if (this.tagType != lllllllllllllIllIIlIllIlIIIIIlIl.getId()) {
                NBTTagList.LOGGER.warn("Adding mismatching tag types to tag list");
                return;
            }
            this.tagList.set(lllllllllllllIllIIlIllIlIIIIIIll, lllllllllllllIllIIlIllIlIIIIIlIl);
        }
        else {
            NBTTagList.LOGGER.warn("index out of bounds to set tag in tag list");
        }
    }
    
    public int tagCount() {
        return this.tagList.size();
    }
    
    public double getDoubleAt(final int lllllllllllllIllIIlIllIIllIllIIl) {
        if (lllllllllllllIllIIlIllIIllIllIIl >= 0 && lllllllllllllIllIIlIllIIllIllIIl < this.tagList.size()) {
            final NBTBase lllllllllllllIllIIlIllIIllIllIII = this.tagList.get(lllllllllllllIllIIlIllIIllIllIIl);
            if (lllllllllllllIllIIlIllIIllIllIII.getId() == 6) {
                return ((NBTTagDouble)lllllllllllllIllIIlIllIIllIllIII).getDouble();
            }
        }
        return 0.0;
    }
    
    @Override
    public NBTTagList copy() {
        final NBTTagList lllllllllllllIllIIlIllIIlIllIIll = new NBTTagList();
        lllllllllllllIllIIlIllIIlIllIIll.tagType = this.tagType;
        for (final NBTBase lllllllllllllIllIIlIllIIlIllIIlI : this.tagList) {
            final NBTBase lllllllllllllIllIIlIllIIlIllIIIl = lllllllllllllIllIIlIllIIlIllIIlI.copy();
            lllllllllllllIllIIlIllIIlIllIIll.tagList.add(lllllllllllllIllIIlIllIIlIllIIIl);
        }
        return lllllllllllllIllIIlIllIIlIllIIll;
    }
    
    public NBTTagCompound getCompoundTagAt(final int lllllllllllllIllIIlIllIIllllIIIl) {
        if (lllllllllllllIllIIlIllIIllllIIIl >= 0 && lllllllllllllIllIIlIllIIllllIIIl < this.tagList.size()) {
            final NBTBase lllllllllllllIllIIlIllIIllllIIll = this.tagList.get(lllllllllllllIllIIlIllIIllllIIIl);
            if (lllllllllllllIllIIlIllIIllllIIll.getId() == 10) {
                return (NBTTagCompound)lllllllllllllIllIIlIllIIllllIIll;
            }
        }
        return new NBTTagCompound();
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIllIIlIllIIlIlIIlll) {
        if (!super.equals(lllllllllllllIllIIlIllIIlIlIIlll)) {
            return false;
        }
        final NBTTagList lllllllllllllIllIIlIllIIlIlIIllI = (NBTTagList)lllllllllllllIllIIlIllIIlIlIIlll;
        return this.tagType == lllllllllllllIllIIlIllIIlIlIIllI.tagType && Objects.equals(this.tagList, lllllllllllllIllIIlIllIIlIlIIllI.tagList);
    }
    
    public NBTBase removeTag(final int lllllllllllllIllIIlIllIIllllllII) {
        return this.tagList.remove(lllllllllllllIllIIlIllIIllllllII);
    }
    
    @Override
    void read(final DataInput lllllllllllllIllIIlIllIlIIlIIIII, final int lllllllllllllIllIIlIllIlIIIlllll, final NBTSizeTracker lllllllllllllIllIIlIllIlIIlIIlIl) throws IOException {
        lllllllllllllIllIIlIllIlIIlIIlIl.read(296L);
        if (lllllllllllllIllIIlIllIlIIIlllll > 512) {
            throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
        }
        this.tagType = lllllllllllllIllIIlIllIlIIlIIIII.readByte();
        final int lllllllllllllIllIIlIllIlIIlIIlII = lllllllllllllIllIIlIllIlIIlIIIII.readInt();
        if (this.tagType == 0 && lllllllllllllIllIIlIllIlIIlIIlII > 0) {
            throw new RuntimeException("Missing type on ListTag");
        }
        lllllllllllllIllIIlIllIlIIlIIlIl.read(32L * lllllllllllllIllIIlIllIlIIlIIlII);
        this.tagList = (List<NBTBase>)Lists.newArrayListWithCapacity(lllllllllllllIllIIlIllIlIIlIIlII);
        for (int lllllllllllllIllIIlIllIlIIlIIIll = 0; lllllllllllllIllIIlIllIlIIlIIIll < lllllllllllllIllIIlIllIlIIlIIlII; ++lllllllllllllIllIIlIllIlIIlIIIll) {
            final NBTBase lllllllllllllIllIIlIllIlIIlIIIlI = NBTBase.createNewByType(this.tagType);
            lllllllllllllIllIIlIllIlIIlIIIlI.read(lllllllllllllIllIIlIllIlIIlIIIII, lllllllllllllIllIIlIllIlIIIlllll + 1, lllllllllllllIllIIlIllIlIIlIIlIl);
            this.tagList.add(lllllllllllllIllIIlIllIlIIlIIIlI);
        }
    }
    
    public int[] getIntArrayAt(final int lllllllllllllIllIIlIllIIlllIIIlI) {
        if (lllllllllllllIllIIlIllIIlllIIIlI >= 0 && lllllllllllllIllIIlIllIIlllIIIlI < this.tagList.size()) {
            final NBTBase lllllllllllllIllIIlIllIIlllIIIIl = this.tagList.get(lllllllllllllIllIIlIllIIlllIIIlI);
            if (lllllllllllllIllIIlIllIIlllIIIIl.getId() == 11) {
                return ((NBTTagIntArray)lllllllllllllIllIIlIllIIlllIIIIl).getIntArray();
            }
        }
        return new int[0];
    }
    
    @Override
    public boolean hasNoTags() {
        return this.tagList.isEmpty();
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.tagList.hashCode();
    }
    
    public NBTBase get(final int lllllllllllllIllIIlIllIIlIllllll) {
        return (lllllllllllllIllIIlIllIIlIllllll >= 0 && lllllllllllllIllIIlIllIIlIllllll < this.tagList.size()) ? this.tagList.get(lllllllllllllIllIIlIllIIlIllllll) : new NBTTagEnd();
    }
    
    @Override
    public byte getId() {
        return 9;
    }
    
    public String getStringTagAt(final int lllllllllllllIllIIlIllIIllIIIlll) {
        if (lllllllllllllIllIIlIllIIllIIIlll >= 0 && lllllllllllllIllIIlIllIIllIIIlll < this.tagList.size()) {
            final NBTBase lllllllllllllIllIIlIllIIllIIIllI = this.tagList.get(lllllllllllllIllIIlIllIIllIIIlll);
            return (lllllllllllllIllIIlIllIIllIIIllI.getId() == 8) ? lllllllllllllIllIIlIllIIllIIIllI.getString() : lllllllllllllIllIIlIllIIllIIIllI.toString();
        }
        return "";
    }
    
    public float getFloatAt(final int lllllllllllllIllIIlIllIIllIIllIl) {
        if (lllllllllllllIllIIlIllIIllIIllIl >= 0 && lllllllllllllIllIIlIllIIllIIllIl < this.tagList.size()) {
            final NBTBase lllllllllllllIllIIlIllIIllIIllll = this.tagList.get(lllllllllllllIllIIlIllIIllIIllIl);
            if (lllllllllllllIllIIlIllIIllIIllll.getId() == 5) {
                return ((NBTTagFloat)lllllllllllllIllIIlIllIIllIIllll).getFloat();
            }
        }
        return 0.0f;
    }
}
