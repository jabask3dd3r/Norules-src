package net.minecraft.nbt;

import java.util.regex.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;
import com.google.common.collect.*;
import java.io.*;
import org.apache.logging.log4j.*;
import javax.annotation.*;
import java.util.*;

public class NBTTagCompound extends NBTBase
{
    private static final /* synthetic */ Pattern field_193583_c;
    private final /* synthetic */ Map<String, NBTBase> tagMap;
    private static final /* synthetic */ Logger field_191551_b;
    
    public void setUniqueId(final String lllllllllllllllIIIllIIIlllIIlllI, final UUID lllllllllllllllIIIllIIIlllIlIIII) {
        this.setLong(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIllIIIlllIIlllI)).append("Most")), lllllllllllllllIIIllIIIlllIlIIII.getMostSignificantBits());
        this.setLong(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIllIIIlllIIlllI)).append("Least")), lllllllllllllllIIIllIIIlllIlIIII.getLeastSignificantBits());
    }
    
    static NBTBase readNBT(final byte lllllllllllllllIIIllIIIIlIlIlIll, final String lllllllllllllllIIIllIIIIlIlIIIIl, final DataInput lllllllllllllllIIIllIIIIlIlIlIIl, final int lllllllllllllllIIIllIIIIlIlIlIII, final NBTSizeTracker lllllllllllllllIIIllIIIIlIIllllI) throws IOException {
        final NBTBase lllllllllllllllIIIllIIIIlIlIIllI = NBTBase.createNewByType(lllllllllllllllIIIllIIIIlIlIlIll);
        try {
            lllllllllllllllIIIllIIIIlIlIIllI.read(lllllllllllllllIIIllIIIIlIlIlIIl, lllllllllllllllIIIllIIIIlIlIlIII, lllllllllllllllIIIllIIIIlIIllllI);
            return lllllllllllllllIIIllIIIIlIlIIllI;
        }
        catch (IOException lllllllllllllllIIIllIIIIlIlIIlIl) {
            final CrashReport lllllllllllllllIIIllIIIIlIlIIlII = CrashReport.makeCrashReport(lllllllllllllllIIIllIIIIlIlIIlIl, "Loading NBT data");
            final CrashReportCategory lllllllllllllllIIIllIIIIlIlIIIll = lllllllllllllllIIIllIIIIlIlIIlII.makeCategory("NBT Tag");
            lllllllllllllllIIIllIIIIlIlIIIll.addCrashSection("Tag name", lllllllllllllllIIIllIIIIlIlIIIIl);
            lllllllllllllllIIIllIIIIlIlIIIll.addCrashSection("Tag type", lllllllllllllllIIIllIIIIlIlIlIll);
            throw new ReportedException(lllllllllllllllIIIllIIIIlIlIIlII);
        }
    }
    
    public NBTTagList getTagList(final String lllllllllllllllIIIllIIIlIIIIllII, final int lllllllllllllllIIIllIIIlIIIIlIll) {
        try {
            if (this.getTagId(lllllllllllllllIIIllIIIlIIIIllII) == 9) {
                final NBTTagList lllllllllllllllIIIllIIIlIIIIllll = this.tagMap.get(lllllllllllllllIIIllIIIlIIIIllII);
                if (!lllllllllllllllIIIllIIIlIIIIllll.hasNoTags() && lllllllllllllllIIIllIIIlIIIIllll.getTagType() != lllllllllllllllIIIllIIIlIIIIlIll) {
                    return new NBTTagList();
                }
                return lllllllllllllllIIIllIIIlIIIIllll;
            }
        }
        catch (ClassCastException lllllllllllllllIIIllIIIlIIIIlllI) {
            throw new ReportedException(this.createCrashReport(lllllllllllllllIIIllIIIlIIIIllII, 9, lllllllllllllllIIIllIIIlIIIIlllI));
        }
        return new NBTTagList();
    }
    
    public void setByte(final String lllllllllllllllIIIllIIIlllllIIlI, final byte lllllllllllllllIIIllIIIlllllIIIl) {
        this.tagMap.put(lllllllllllllllIIIllIIIlllllIIlI, new NBTTagByte(lllllllllllllllIIIllIIIlllllIIIl));
    }
    
    protected static String func_193582_s(final String lllllllllllllllIIIllIIIIlIIIIlll) {
        return NBTTagCompound.field_193583_c.matcher(lllllllllllllllIIIllIIIIlIIIIlll).matches() ? lllllllllllllllIIIllIIIIlIIIIlll : NBTTagString.func_193588_a(lllllllllllllllIIIllIIIIlIIIIlll);
    }
    
    public byte[] getByteArray(final String lllllllllllllllIIIllIIIlIIlIlIlI) {
        try {
            if (this.hasKey(lllllllllllllllIIIllIIIlIIlIlIlI, 7)) {
                return this.tagMap.get(lllllllllllllllIIIllIIIlIIlIlIlI).getByteArray();
            }
        }
        catch (ClassCastException lllllllllllllllIIIllIIIlIIlIllII) {
            throw new ReportedException(this.createCrashReport(lllllllllllllllIIIllIIIlIIlIlIlI, 7, lllllllllllllllIIIllIIIlIIlIllII));
        }
        return new byte[0];
    }
    
    public int[] getIntArray(final String lllllllllllllllIIIllIIIlIIlIIlII) {
        try {
            if (this.hasKey(lllllllllllllllIIIllIIIlIIlIIlII, 11)) {
                return this.tagMap.get(lllllllllllllllIIIllIIIlIIlIIlII).getIntArray();
            }
        }
        catch (ClassCastException lllllllllllllllIIIllIIIlIIlIIIll) {
            throw new ReportedException(this.createCrashReport(lllllllllllllllIIIllIIIlIIlIIlII, 11, lllllllllllllllIIIllIIIlIIlIIIll));
        }
        return new int[0];
    }
    
    public void setLong(final String lllllllllllllllIIIllIIIlllIllIlI, final long lllllllllllllllIIIllIIIlllIlIllI) {
        this.tagMap.put(lllllllllllllllIIIllIIIlllIllIlI, new NBTTagLong(lllllllllllllllIIIllIIIlllIlIllI));
    }
    
    public void setBoolean(final String lllllllllllllllIIIllIIIllIIIllII, final boolean lllllllllllllllIIIllIIIllIIIlIll) {
        this.setByte(lllllllllllllllIIIllIIIllIIIllII, (byte)(lllllllllllllllIIIllIIIllIIIlIll ? 1 : 0));
    }
    
    @Override
    public NBTTagCompound copy() {
        final NBTTagCompound lllllllllllllllIIIllIIIIllIlIlII = new NBTTagCompound();
        for (final String lllllllllllllllIIIllIIIIllIlIIll : this.tagMap.keySet()) {
            lllllllllllllllIIIllIIIIllIlIlII.setTag(lllllllllllllllIIIllIIIIllIlIIll, this.tagMap.get(lllllllllllllllIIIllIIIIllIlIIll).copy());
        }
        return lllllllllllllllIIIllIIIIllIlIlII;
    }
    
    public NBTTagCompound() {
        this.tagMap = (Map<String, NBTBase>)Maps.newHashMap();
    }
    
    public short getShort(final String lllllllllllllllIIIllIIIlIlIlllIl) {
        try {
            if (this.hasKey(lllllllllllllllIIIllIIIlIlIlllIl, 99)) {
                return this.tagMap.get(lllllllllllllllIIIllIIIlIlIlllIl).getShort();
            }
        }
        catch (ClassCastException ex) {}
        return 0;
    }
    
    public boolean hasUniqueId(final String lllllllllllllllIIIllIIIlllIIIIIl) {
        return this.hasKey(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIllIIIlllIIIIIl)).append("Most")), 99) && this.hasKey(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIllIIIlllIIIIIl)).append("Least")), 99);
    }
    
    public void setTag(final String lllllllllllllllIIIllIIIllllllllI, final NBTBase lllllllllllllllIIIllIIIlllllllIl) {
        this.tagMap.put(lllllllllllllllIIIllIIIllllllllI, lllllllllllllllIIIllIIIlllllllIl);
    }
    
    public long getLong(final String lllllllllllllllIIIllIIIlIlIIlIll) {
        try {
            if (this.hasKey(lllllllllllllllIIIllIIIlIlIIlIll, 99)) {
                return this.tagMap.get(lllllllllllllllIIIllIIIlIlIIlIll).getLong();
            }
        }
        catch (ClassCastException ex) {}
        return 0L;
    }
    
    public byte getTagId(final String lllllllllllllllIIIllIIIlIlllllIl) {
        final NBTBase lllllllllllllllIIIllIIIlIlllllll = this.tagMap.get(lllllllllllllllIIIllIIIlIlllllIl);
        return (byte)((lllllllllllllllIIIllIIIlIlllllll == null) ? 0 : lllllllllllllllIIIllIIIlIlllllll.getId());
    }
    
    public double getDouble(final String lllllllllllllllIIIllIIIlIIlllIll) {
        try {
            if (this.hasKey(lllllllllllllllIIIllIIIlIIlllIll, 99)) {
                return this.tagMap.get(lllllllllllllllIIIllIIIlIIlllIll).getDouble();
            }
        }
        catch (ClassCastException ex) {}
        return 0.0;
    }
    
    public String getString(final String lllllllllllllllIIIllIIIlIIllIIll) {
        try {
            if (this.hasKey(lllllllllllllllIIIllIIIlIIllIIll, 8)) {
                return this.tagMap.get(lllllllllllllllIIIllIIIlIIllIIll).getString();
            }
        }
        catch (ClassCastException ex) {}
        return "";
    }
    
    private CrashReport createCrashReport(final String lllllllllllllllIIIllIIIIlllIIlII, final int lllllllllllllllIIIllIIIIlllIIIll, final ClassCastException lllllllllllllllIIIllIIIIllIlllII) {
        final CrashReport lllllllllllllllIIIllIIIIlllIIIIl = CrashReport.makeCrashReport(lllllllllllllllIIIllIIIIllIlllII, "Reading NBT data");
        final CrashReportCategory lllllllllllllllIIIllIIIIlllIIIII = lllllllllllllllIIIllIIIIlllIIIIl.makeCategoryDepth("Corrupt NBT tag", 1);
        lllllllllllllllIIIllIIIIlllIIIII.setDetail("Tag type found", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return NBTBase.NBT_TYPES[NBTTagCompound.this.tagMap.get(lllllllllllllllIIIllIIIIlllIIlII).getId()];
            }
        });
        lllllllllllllllIIIllIIIIlllIIIII.setDetail("Tag type expected", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return NBTBase.NBT_TYPES[lllllllllllllllIIIllIIIIlllIIIll];
            }
        });
        lllllllllllllllIIIllIIIIlllIIIII.addCrashSection("Tag name", lllllllllllllllIIIllIIIIlllIIlII);
        return lllllllllllllllIIIllIIIIlllIIIIl;
    }
    
    public boolean hasKey(final String lllllllllllllllIIIllIIIlIllllIII) {
        return this.tagMap.containsKey(lllllllllllllllIIIllIIIlIllllIII);
    }
    
    public boolean getBoolean(final String lllllllllllllllIIIllIIIlIIIIIllI) {
        return this.getByte(lllllllllllllllIIIllIIIlIIIIIllI) != 0;
    }
    
    public void setShort(final String lllllllllllllllIIIllIIIllllIlIIl, final short lllllllllllllllIIIllIIIllllIlIII) {
        this.tagMap.put(lllllllllllllllIIIllIIIllllIlIIl, new NBTTagShort(lllllllllllllllIIIllIIIllllIlIII));
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllllllIIIllIIIIllllIlll = new StringBuilder("{");
        Collection<String> lllllllllllllllIIIllIIIIllllIllI = this.tagMap.keySet();
        if (NBTTagCompound.field_191551_b.isDebugEnabled()) {
            final List<String> lllllllllllllllIIIllIIIIllllIlIl = (List<String>)Lists.newArrayList((Iterable)this.tagMap.keySet());
            Collections.sort(lllllllllllllllIIIllIIIIllllIlIl);
            lllllllllllllllIIIllIIIIllllIllI = lllllllllllllllIIIllIIIIllllIlIl;
        }
        for (final String lllllllllllllllIIIllIIIIllllIlII : lllllllllllllllIIIllIIIIllllIllI) {
            if (lllllllllllllllIIIllIIIIllllIlll.length() != 1) {
                lllllllllllllllIIIllIIIIllllIlll.append(',');
            }
            lllllllllllllllIIIllIIIIllllIlll.append(func_193582_s(lllllllllllllllIIIllIIIIllllIlII)).append(':').append(this.tagMap.get(lllllllllllllllIIIllIIIIllllIlII));
        }
        return String.valueOf(lllllllllllllllIIIllIIIIllllIlll.append('}'));
    }
    
    public void setFloat(final String lllllllllllllllIIIllIIIllIlllIIl, final float lllllllllllllllIIIllIIIllIlllIII) {
        this.tagMap.put(lllllllllllllllIIIllIIIllIlllIIl, new NBTTagFloat(lllllllllllllllIIIllIIIllIlllIII));
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIIIllIIIIllIIlIIl) {
        return super.equals(lllllllllllllllIIIllIIIIllIIlIIl) && Objects.equals(this.tagMap.entrySet(), ((NBTTagCompound)lllllllllllllllIIIllIIIIllIIlIIl).tagMap.entrySet());
    }
    
    public void setString(final String lllllllllllllllIIIllIIIllIlIlIlI, final String lllllllllllllllIIIllIIIllIlIlIIl) {
        this.tagMap.put(lllllllllllllllIIIllIIIllIlIlIlI, new NBTTagString(lllllllllllllllIIIllIIIllIlIlIIl));
    }
    
    public void setByteArray(final String lllllllllllllllIIIllIIIllIlIIIIl, final byte[] lllllllllllllllIIIllIIIllIIlllIl) {
        this.tagMap.put(lllllllllllllllIIIllIIIllIlIIIIl, new NBTTagByteArray(lllllllllllllllIIIllIIIllIIlllIl));
    }
    
    @Override
    void write(final DataOutput lllllllllllllllIIIllIIlIIIlIIlll) throws IOException {
        for (final String lllllllllllllllIIIllIIlIIIlIIllI : this.tagMap.keySet()) {
            final NBTBase lllllllllllllllIIIllIIlIIIlIIlIl = this.tagMap.get(lllllllllllllllIIIllIIlIIIlIIllI);
            writeEntry(lllllllllllllllIIIllIIlIIIlIIllI, lllllllllllllllIIIllIIlIIIlIIlIl, lllllllllllllllIIIllIIlIIIlIIlll);
        }
        lllllllllllllllIIIllIIlIIIlIIlll.writeByte(0);
    }
    
    @Override
    public byte getId() {
        return 10;
    }
    
    static {
        field_191551_b = LogManager.getLogger();
        field_193583_c = Pattern.compile("[A-Za-z0-9._+-]+");
    }
    
    @Override
    void read(final DataInput lllllllllllllllIIIllIIlIIIIIllll, final int lllllllllllllllIIIllIIlIIIIIlllI, final NBTSizeTracker lllllllllllllllIIIllIIlIIIIlIlIl) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: invokevirtual   net/minecraft/nbt/NBTSizeTracker.read:(J)V
        //     7: iload_2         /* lllllllllllllllIIIllIIlIIIIlIllI */
        //     8: sipush          512
        //    11: if_icmple       25
        //    14: new             Ljava/lang/RuntimeException;
        //    17: dup            
        //    18: ldc_w           "Tried to read NBT tag with too high complexity, depth > 512"
        //    21: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;)V
        //    24: athrow         
        //    25: aload_0         /* lllllllllllllllIIIllIIlIIIIllIII */
        //    26: getfield        net/minecraft/nbt/NBTTagCompound.tagMap:Ljava/util/Map;
        //    29: invokeinterface java/util/Map.clear:()V
        //    34: goto            98
        //    37: aload_1         /* lllllllllllllllIIIllIIlIIIIlIlll */
        //    38: aload_3         /* lllllllllllllllIIIllIIlIIIIIllIl */
        //    39: invokestatic    net/minecraft/nbt/NBTTagCompound.readKey:(Ljava/io/DataInput;Lnet/minecraft/nbt/NBTSizeTracker;)Ljava/lang/String;
        //    42: astore          lllllllllllllllIIIllIIlIIIIlIIlI
        //    44: aload_3         /* lllllllllllllllIIIllIIlIIIIIllIl */
        //    45: sipush          224
        //    48: bipush          16
        //    50: aload           lllllllllllllllIIIllIIlIIIIlIIlI
        //    52: invokevirtual   java/lang/String.length:()I
        //    55: imul           
        //    56: iadd           
        //    57: i2l            
        //    58: invokevirtual   net/minecraft/nbt/NBTSizeTracker.read:(J)V
        //    61: iload           lllllllllllllllIIIllIIlIIIIlIlII
        //    63: aload           lllllllllllllllIIIllIIlIIIIlIIlI
        //    65: aload_1         /* lllllllllllllllIIIllIIlIIIIlIlll */
        //    66: iload_2         /* lllllllllllllllIIIllIIlIIIIlIllI */
        //    67: iconst_1       
        //    68: iadd           
        //    69: aload_3         /* lllllllllllllllIIIllIIlIIIIIllIl */
        //    70: invokestatic    net/minecraft/nbt/NBTTagCompound.readNBT:(BLjava/lang/String;Ljava/io/DataInput;ILnet/minecraft/nbt/NBTSizeTracker;)Lnet/minecraft/nbt/NBTBase;
        //    73: astore          lllllllllllllllIIIllIIlIIIIlIIIl
        //    75: aload_0         /* lllllllllllllllIIIllIIlIIIIllIII */
        //    76: getfield        net/minecraft/nbt/NBTTagCompound.tagMap:Ljava/util/Map;
        //    79: aload           lllllllllllllllIIIllIIlIIIIlIIlI
        //    81: aload           lllllllllllllllIIIllIIlIIIIlIIIl
        //    83: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    88: ifnull          98
        //    91: aload_3         /* lllllllllllllllIIIllIIlIIIIIllIl */
        //    92: ldc2_w          288
        //    95: invokevirtual   net/minecraft/nbt/NBTSizeTracker.read:(J)V
        //    98: aload_1         /* lllllllllllllllIIIllIIlIIIIlIlll */
        //    99: aload_3         /* lllllllllllllllIIIllIIlIIIIIllIl */
        //   100: invokestatic    net/minecraft/nbt/NBTTagCompound.readType:(Ljava/io/DataInput;Lnet/minecraft/nbt/NBTSizeTracker;)B
        //   103: dup            
        //   104: istore          lllllllllllllllIIIllIIlIIIIlIIll
        //   106: ifne            37
        //   109: return         
        //    Exceptions:
        //  throws java.io.IOException
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static String readKey(final DataInput lllllllllllllllIIIllIIIIlIllIlIl, final NBTSizeTracker lllllllllllllllIIIllIIIIlIllIllI) throws IOException {
        return lllllllllllllllIIIllIIIIlIllIlIl.readUTF();
    }
    
    @Override
    public boolean hasNoTags() {
        return this.tagMap.isEmpty();
    }
    
    public void setInteger(final String lllllllllllllllIIIllIIIllllIIIll, final int lllllllllllllllIIIllIIIllllIIIlI) {
        this.tagMap.put(lllllllllllllllIIIllIIIllllIIIll, new NBTTagInt(lllllllllllllllIIIllIIIllllIIIlI));
    }
    
    public int getInteger(final String lllllllllllllllIIIllIIIlIlIlIIll) {
        try {
            if (this.hasKey(lllllllllllllllIIIllIIIlIlIlIIll, 99)) {
                return this.tagMap.get(lllllllllllllllIIIllIIIlIlIlIIll).getInt();
            }
        }
        catch (ClassCastException ex) {}
        return 0;
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.tagMap.hashCode();
    }
    
    public boolean hasKey(final String lllllllllllllllIIIllIIIlIllIllII, final int lllllllllllllllIIIllIIIlIllIllll) {
        final int lllllllllllllllIIIllIIIlIllIlllI = this.getTagId(lllllllllllllllIIIllIIIlIllIllII);
        return lllllllllllllllIIIllIIIlIllIlllI == lllllllllllllllIIIllIIIlIllIllll || (lllllllllllllllIIIllIIIlIllIllll == 99 && (lllllllllllllllIIIllIIIlIllIlllI == 1 || lllllllllllllllIIIllIIIlIllIlllI == 2 || lllllllllllllllIIIllIIIlIllIlllI == 3 || lllllllllllllllIIIllIIIlIllIlllI == 4 || lllllllllllllllIIIllIIIlIllIlllI == 5 || lllllllllllllllIIIllIIIlIllIlllI == 6));
    }
    
    public NBTBase getTag(final String lllllllllllllllIIIllIIIllIIIIlIl) {
        return this.tagMap.get(lllllllllllllllIIIllIIIllIIIIlIl);
    }
    
    public void removeTag(final String lllllllllllllllIIIllIIIlIIIIIIII) {
        this.tagMap.remove(lllllllllllllllIIIllIIIlIIIIIIII);
    }
    
    public NBTTagCompound getCompoundTag(final String lllllllllllllllIIIllIIIlIIIllIll) {
        try {
            if (this.hasKey(lllllllllllllllIIIllIIIlIIIllIll, 10)) {
                return this.tagMap.get(lllllllllllllllIIIllIIIlIIIllIll);
            }
        }
        catch (ClassCastException lllllllllllllllIIIllIIIlIIIllIlI) {
            throw new ReportedException(this.createCrashReport(lllllllllllllllIIIllIIIlIIIllIll, 10, lllllllllllllllIIIllIIIlIIIllIlI));
        }
        return new NBTTagCompound();
    }
    
    private static byte readType(final DataInput lllllllllllllllIIIllIIIIlIlllIll, final NBTSizeTracker lllllllllllllllIIIllIIIIlIlllIlI) throws IOException {
        return lllllllllllllllIIIllIIIIlIlllIll.readByte();
    }
    
    @Nullable
    public UUID getUniqueId(final String lllllllllllllllIIIllIIIlllIIlIIl) {
        return new UUID(this.getLong(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIllIIIlllIIlIIl)).append("Most"))), this.getLong(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIllIIIlllIIlIIl)).append("Least"))));
    }
    
    public void setIntArray(final String lllllllllllllllIIIllIIIllIIlIlIl, final int[] lllllllllllllllIIIllIIIllIIlIlII) {
        this.tagMap.put(lllllllllllllllIIIllIIIllIIlIlIl, new NBTTagIntArray(lllllllllllllllIIIllIIIllIIlIlII));
    }
    
    public void merge(final NBTTagCompound lllllllllllllllIIIllIIIIlIIIllIl) {
        for (final String lllllllllllllllIIIllIIIIlIIlIIIl : lllllllllllllllIIIllIIIIlIIIllIl.tagMap.keySet()) {
            final NBTBase lllllllllllllllIIIllIIIIlIIlIIII = lllllllllllllllIIIllIIIIlIIIllIl.tagMap.get(lllllllllllllllIIIllIIIIlIIlIIIl);
            if (lllllllllllllllIIIllIIIIlIIlIIII.getId() == 10) {
                if (this.hasKey(lllllllllllllllIIIllIIIIlIIlIIIl, 10)) {
                    final NBTTagCompound lllllllllllllllIIIllIIIIlIIIllll = this.getCompoundTag(lllllllllllllllIIIllIIIIlIIlIIIl);
                    lllllllllllllllIIIllIIIIlIIIllll.merge((NBTTagCompound)lllllllllllllllIIIllIIIIlIIlIIII);
                }
                else {
                    this.setTag(lllllllllllllllIIIllIIIIlIIlIIIl, lllllllllllllllIIIllIIIIlIIlIIII.copy());
                }
            }
            else {
                this.setTag(lllllllllllllllIIIllIIIIlIIlIIIl, lllllllllllllllIIIllIIIIlIIlIIII.copy());
            }
        }
    }
    
    public Set<String> getKeySet() {
        return this.tagMap.keySet();
    }
    
    public int getSize() {
        return this.tagMap.size();
    }
    
    public byte getByte(final String lllllllllllllllIIIllIIIlIllIIlIl) {
        try {
            if (this.hasKey(lllllllllllllllIIIllIIIlIllIIlIl, 99)) {
                return this.tagMap.get(lllllllllllllllIIIllIIIlIllIIlIl).getByte();
            }
        }
        catch (ClassCastException ex) {}
        return 0;
    }
    
    private static void writeEntry(final String lllllllllllllllIIIllIIIIllIIIIlI, final NBTBase lllllllllllllllIIIllIIIIlIlllllI, final DataOutput lllllllllllllllIIIllIIIIllIIIIII) throws IOException {
        lllllllllllllllIIIllIIIIllIIIIII.writeByte(lllllllllllllllIIIllIIIIlIlllllI.getId());
        if (lllllllllllllllIIIllIIIIlIlllllI.getId() != 0) {
            lllllllllllllllIIIllIIIIllIIIIII.writeUTF(lllllllllllllllIIIllIIIIllIIIIlI);
            lllllllllllllllIIIllIIIIlIlllllI.write(lllllllllllllllIIIllIIIIllIIIIII);
        }
    }
    
    public float getFloat(final String lllllllllllllllIIIllIIIlIlIIIlIl) {
        try {
            if (this.hasKey(lllllllllllllllIIIllIIIlIlIIIlIl, 99)) {
                return this.tagMap.get(lllllllllllllllIIIllIIIlIlIIIlIl).getFloat();
            }
        }
        catch (ClassCastException ex) {}
        return 0.0f;
    }
    
    public void setDouble(final String lllllllllllllllIIIllIIIllIllIIII, final double lllllllllllllllIIIllIIIllIlIllll) {
        this.tagMap.put(lllllllllllllllIIIllIIIllIllIIII, new NBTTagDouble(lllllllllllllllIIIllIIIllIlIllll));
    }
}
