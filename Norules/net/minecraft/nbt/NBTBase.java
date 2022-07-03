package net.minecraft.nbt;

import java.io.*;

public abstract class NBTBase
{
    protected String getString() {
        return this.toString();
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIllIllllIIlIllIIlI) {
        return lllllllllllllIIllIllllIIlIllIIlI instanceof NBTBase && this.getId() == ((NBTBase)lllllllllllllIIllIllllIIlIllIIlI).getId();
    }
    
    static {
        NBT_TYPES = new String[] { "END", "BYTE", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE", "BYTE[]", "STRING", "LIST", "COMPOUND", "INT[]", "LONG[]" };
    }
    
    public abstract byte getId();
    
    @Override
    public abstract String toString();
    
    abstract void write(final DataOutput p0) throws IOException;
    
    abstract void read(final DataInput p0, final int p1, final NBTSizeTracker p2) throws IOException;
    
    public boolean hasNoTags() {
        return false;
    }
    
    public static String func_193581_j(final int lllllllllllllIIllIllllIIlIlllIlI) {
        switch (lllllllllllllIIllIllllIIlIlllIlI) {
            case 0: {
                return "TAG_End";
            }
            case 1: {
                return "TAG_Byte";
            }
            case 2: {
                return "TAG_Short";
            }
            case 3: {
                return "TAG_Int";
            }
            case 4: {
                return "TAG_Long";
            }
            case 5: {
                return "TAG_Float";
            }
            case 6: {
                return "TAG_Double";
            }
            case 7: {
                return "TAG_Byte_Array";
            }
            case 8: {
                return "TAG_String";
            }
            case 9: {
                return "TAG_List";
            }
            case 10: {
                return "TAG_Compound";
            }
            case 11: {
                return "TAG_Int_Array";
            }
            case 12: {
                return "TAG_Long_Array";
            }
            case 99: {
                return "Any Numeric Tag";
            }
            default: {
                return "UNKNOWN";
            }
        }
    }
    
    public abstract NBTBase copy();
    
    protected static NBTBase createNewByType(final byte lllllllllllllIIllIllllIIlIllllIl) {
        switch (lllllllllllllIIllIllllIIlIllllIl) {
            case 0: {
                return new NBTTagEnd();
            }
            case 1: {
                return new NBTTagByte();
            }
            case 2: {
                return new NBTTagShort();
            }
            case 3: {
                return new NBTTagInt();
            }
            case 4: {
                return new NBTTagLong();
            }
            case 5: {
                return new NBTTagFloat();
            }
            case 6: {
                return new NBTTagDouble();
            }
            case 7: {
                return new NBTTagByteArray();
            }
            case 8: {
                return new NBTTagString();
            }
            case 9: {
                return new NBTTagList();
            }
            case 10: {
                return new NBTTagCompound();
            }
            case 11: {
                return new NBTTagIntArray();
            }
            case 12: {
                return new NBTTagLongArray();
            }
            default: {
                return null;
            }
        }
    }
    
    @Override
    public int hashCode() {
        return this.getId();
    }
}
