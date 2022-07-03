package net.minecraft.nbt;

import net.minecraft.util.*;
import net.minecraft.crash.*;
import java.util.zip.*;
import javax.annotation.*;
import java.io.*;

public class CompressedStreamTools
{
    public static void safeWrite(final NBTTagCompound lllllllllllllllIlIIlllIIlIIIIIlI, final File lllllllllllllllIlIIlllIIlIIIIIIl) throws IOException {
        final File lllllllllllllllIlIIlllIIlIIIIIII = new File(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIlIIlllIIlIIIIIIl.getAbsolutePath())).append("_tmp")));
        if (lllllllllllllllIlIIlllIIlIIIIIII.exists()) {
            lllllllllllllllIlIIlllIIlIIIIIII.delete();
        }
        write(lllllllllllllllIlIIlllIIlIIIIIlI, lllllllllllllllIlIIlllIIlIIIIIII);
        if (lllllllllllllllIlIIlllIIlIIIIIIl.exists()) {
            lllllllllllllllIlIIlllIIlIIIIIIl.delete();
        }
        if (lllllllllllllllIlIIlllIIlIIIIIIl.exists()) {
            throw new IOException(String.valueOf(new StringBuilder("Failed to delete ").append(lllllllllllllllIlIIlllIIlIIIIIIl)));
        }
        lllllllllllllllIlIIlllIIlIIIIIII.renameTo(lllllllllllllllIlIIlllIIlIIIIIIl);
    }
    
    public static NBTTagCompound read(final DataInput lllllllllllllllIlIIlllIIIlIlllII, final NBTSizeTracker lllllllllllllllIlIIlllIIIlIllIll) throws IOException {
        final NBTBase lllllllllllllllIlIIlllIIIlIlllIl = read(lllllllllllllllIlIIlllIIIlIlllII, 0, lllllllllllllllIlIIlllIIIlIllIll);
        if (lllllllllllllllIlIIlllIIIlIlllIl instanceof NBTTagCompound) {
            return (NBTTagCompound)lllllllllllllllIlIIlllIIIlIlllIl;
        }
        throw new IOException("Root tag must be a named compound tag");
    }
    
    private static NBTBase read(final DataInput lllllllllllllllIlIIlllIIIlIIIlIl, final int lllllllllllllllIlIIlllIIIIllllII, final NBTSizeTracker lllllllllllllllIlIIlllIIIIlllIll) throws IOException {
        final byte lllllllllllllllIlIIlllIIIlIIIIlI = lllllllllllllllIlIIlllIIIlIIIlIl.readByte();
        if (lllllllllllllllIlIIlllIIIlIIIIlI == 0) {
            return new NBTTagEnd();
        }
        lllllllllllllllIlIIlllIIIlIIIlIl.readUTF();
        final NBTBase lllllllllllllllIlIIlllIIIlIIIIIl = NBTBase.createNewByType(lllllllllllllllIlIIlllIIIlIIIIlI);
        try {
            lllllllllllllllIlIIlllIIIlIIIIIl.read(lllllllllllllllIlIIlllIIIlIIIlIl, lllllllllllllllIlIIlllIIIIllllII, lllllllllllllllIlIIlllIIIIlllIll);
            return lllllllllllllllIlIIlllIIIlIIIIIl;
        }
        catch (IOException lllllllllllllllIlIIlllIIIlIIIIII) {
            final CrashReport lllllllllllllllIlIIlllIIIIllllll = CrashReport.makeCrashReport(lllllllllllllllIlIIlllIIIlIIIIII, "Loading NBT data");
            final CrashReportCategory lllllllllllllllIlIIlllIIIIlllllI = lllllllllllllllIlIIlllIIIIllllll.makeCategory("NBT Tag");
            lllllllllllllllIlIIlllIIIIlllllI.addCrashSection("Tag type", lllllllllllllllIlIIlllIIIlIIIIlI);
            throw new ReportedException(lllllllllllllllIlIIlllIIIIllllll);
        }
    }
    
    public static void write(final NBTTagCompound lllllllllllllllIlIIlllIIIllllIII, final File lllllllllllllllIlIIlllIIIlllIlll) throws IOException {
        final DataOutputStream lllllllllllllllIlIIlllIIIlllIllI = new DataOutputStream(new FileOutputStream(lllllllllllllllIlIIlllIIIlllIlll));
        try {
            write(lllllllllllllllIlIIlllIIIllllIII, lllllllllllllllIlIIlllIIIlllIllI);
        }
        finally {
            lllllllllllllllIlIIlllIIIlllIllI.close();
        }
        lllllllllllllllIlIIlllIIIlllIllI.close();
    }
    
    public static void writeCompressed(final NBTTagCompound lllllllllllllllIlIIlllIIlIIIllII, final OutputStream lllllllllllllllIlIIlllIIlIIIlIll) throws IOException {
        final DataOutputStream lllllllllllllllIlIIlllIIlIIIlIlI = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(lllllllllllllllIlIIlllIIlIIIlIll)));
        try {
            write(lllllllllllllllIlIIlllIIlIIIllII, lllllllllllllllIlIIlllIIlIIIlIlI);
        }
        finally {
            lllllllllllllllIlIIlllIIlIIIlIlI.close();
        }
        lllllllllllllllIlIIlllIIlIIIlIlI.close();
    }
    
    public static NBTTagCompound readCompressed(final InputStream lllllllllllllllIlIIlllIIlIIllIII) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: new             Ljava/io/BufferedInputStream;
        //     7: dup            
        //     8: new             Ljava/util/zip/GZIPInputStream;
        //    11: dup            
        //    12: aload_0         /* lllllllllllllllIlIIlllIIlIIlIlII */
        //    13: invokespecial   java/util/zip/GZIPInputStream.<init>:(Ljava/io/InputStream;)V
        //    16: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //    19: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    22: astore_1        /* lllllllllllllllIlIIlllIIlIIlIIll */
        //    23: aload_1         /* lllllllllllllllIlIIlllIIlIIlIlll */
        //    24: getstatic       net/minecraft/nbt/NBTSizeTracker.INFINITE:Lnet/minecraft/nbt/NBTSizeTracker;
        //    27: invokestatic    net/minecraft/nbt/CompressedStreamTools.read:(Ljava/io/DataInput;Lnet/minecraft/nbt/NBTSizeTracker;)Lnet/minecraft/nbt/NBTTagCompound;
        //    30: astore_2        /* lllllllllllllllIlIIlllIIlIIlIllI */
        //    31: goto            41
        //    34: astore_3        /* lllllllllllllllIlIIlllIIlIIlIIIl */
        //    35: aload_1         /* lllllllllllllllIlIIlllIIlIIlIlll */
        //    36: invokevirtual   java/io/DataInputStream.close:()V
        //    39: aload_3         /* lllllllllllllllIlIIlllIIlIIlIIIl */
        //    40: athrow         
        //    41: aload_1         /* lllllllllllllllIlIIlllIIlIIlIlll */
        //    42: invokevirtual   java/io/DataInputStream.close:()V
        //    45: aload_2         /* lllllllllllllllIlIIlllIIlIIlIlIl */
        //    46: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 02 FF 00 22 00 02 07 00 EF 07 00 D4 00 01 07 00 BE FC 00 06 07 00 47
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  23     34     34     41     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static void writeTag(final NBTBase lllllllllllllllIlIIlllIIIlIlIIIl, final DataOutput lllllllllllllllIlIIlllIIIlIlIIII) throws IOException {
        lllllllllllllllIlIIlllIIIlIlIIII.writeByte(lllllllllllllllIlIIlllIIIlIlIIIl.getId());
        if (lllllllllllllllIlIIlllIIIlIlIIIl.getId() != 0) {
            lllllllllllllllIlIIlllIIIlIlIIII.writeUTF("");
            lllllllllllllllIlIIlllIIIlIlIIIl.write(lllllllllllllllIlIIlllIIIlIlIIII);
        }
    }
    
    @Nullable
    public static NBTTagCompound read(final File lllllllllllllllIlIIlllIIIllIllIl) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   java/io/File.exists:()Z
        //     4: ifne            9
        //     7: aconst_null    
        //     8: areturn        
        //     9: new             Ljava/io/DataInputStream;
        //    12: dup            
        //    13: new             Ljava/io/FileInputStream;
        //    16: dup            
        //    17: aload_0         /* lllllllllllllllIlIIlllIIIllIlIIl */
        //    18: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    21: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    24: astore_1        /* lllllllllllllllIlIIlllIIIllIlIII */
        //    25: aload_1         /* lllllllllllllllIlIIlllIIIllIllII */
        //    26: getstatic       net/minecraft/nbt/NBTSizeTracker.INFINITE:Lnet/minecraft/nbt/NBTSizeTracker;
        //    29: invokestatic    net/minecraft/nbt/CompressedStreamTools.read:(Ljava/io/DataInput;Lnet/minecraft/nbt/NBTSizeTracker;)Lnet/minecraft/nbt/NBTTagCompound;
        //    32: astore_2        /* lllllllllllllllIlIIlllIIIllIlIll */
        //    33: goto            43
        //    36: astore_3        /* lllllllllllllllIlIIlllIIIllIIllI */
        //    37: aload_1         /* lllllllllllllllIlIIlllIIIllIllII */
        //    38: invokevirtual   java/io/DataInputStream.close:()V
        //    41: aload_3         /* lllllllllllllllIlIIlllIIIllIIllI */
        //    42: athrow         
        //    43: aload_1         /* lllllllllllllllIlIIlllIIIllIllII */
        //    44: invokevirtual   java/io/DataInputStream.close:()V
        //    47: aload_2         /* lllllllllllllllIlIIlllIIIllIlIlI */
        //    48: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    RuntimeVisibleTypeAnnotations: 00 01 14 00 01 0A 00 00
        //    StackMapTable: 00 03 09 FF 00 1A 00 02 07 00 0A 07 00 D4 00 01 07 00 BE FC 00 06 07 00 47
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  25     36     36     43     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static void write(final NBTTagCompound lllllllllllllllIlIIlllIIIlIlIlll, final DataOutput lllllllllllllllIlIIlllIIIlIlIlII) throws IOException {
        writeTag(lllllllllllllllIlIIlllIIIlIlIlll, lllllllllllllllIlIIlllIIIlIlIlII);
    }
    
    public static NBTTagCompound read(final DataInputStream lllllllllllllllIlIIlllIIIllIIIll) throws IOException {
        return read(lllllllllllllllIlIIlllIIIllIIIll, NBTSizeTracker.INFINITE);
    }
}
