package net.minecraft.client.resources;

import com.google.common.base.*;
import java.util.*;
import java.util.zip.*;
import java.io.*;

public class FileResourcePack extends AbstractResourcePack implements Closeable
{
    private /* synthetic */ ZipFile resourcePackZipFile;
    
    public boolean hasResourceName(final String lllllllllllllllllIIIlllIIIlIIllI) {
        try {
            return this.getResourcePackZipFile().getEntry(lllllllllllllllllIIIlllIIIlIIllI) != null;
        }
        catch (IOException lllllllllllllllllIIIlllIIIlIlIII) {
            return false;
        }
    }
    
    @Override
    public Set<String> getResourceDomains() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   net/minecraft/client/resources/FileResourcePack.getResourcePackZipFile:()Ljava/util/zip/ZipFile;
        //     4: astore_1        /* lllllllllllllllllIIIlllIIIIlIIIl */
        //     5: goto            13
        //     8: astore_2        /* lllllllllllllllllIIIlllIIIIllIIl */
        //     9: invokestatic    java/util/Collections.emptySet:()Ljava/util/Set;
        //    12: areturn        
        //    13: aload_1         /* lllllllllllllllllIIIlllIIIIllIlI */
        //    14: invokevirtual   java/util/zip/ZipFile.entries:()Ljava/util/Enumeration;
        //    17: astore_2        /* lllllllllllllllllIIIlllIIIIllIII */
        //    18: invokestatic    com/google/common/collect/Sets.newHashSet:()Ljava/util/HashSet;
        //    21: astore_3        /* lllllllllllllllllIIIlllIIIIIllll */
        //    22: goto            124
        //    25: aload_2         /* lllllllllllllllllIIIlllIIIIllIII */
        //    26: invokeinterface java/util/Enumeration.nextElement:()Ljava/lang/Object;
        //    31: checkcast       Ljava/util/zip/ZipEntry;
        //    34: astore          lllllllllllllllllIIIlllIIIIlIllI
        //    36: aload           lllllllllllllllllIIIlllIIIIlIllI
        //    38: invokevirtual   java/util/zip/ZipEntry.getName:()Ljava/lang/String;
        //    41: astore          lllllllllllllllllIIIlllIIIIlIlIl
        //    43: aload           lllllllllllllllllIIIlllIIIIlIlIl
        //    45: ldc             "assets/"
        //    47: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //    50: ifeq            124
        //    53: getstatic       net/minecraft/client/resources/FileResourcePack.ENTRY_NAME_SPLITTER:Lcom/google/common/base/Splitter;
        //    56: aload           lllllllllllllllllIIIlllIIIIlIlIl
        //    58: invokevirtual   com/google/common/base/Splitter.split:(Ljava/lang/CharSequence;)Ljava/lang/Iterable;
        //    61: invokestatic    com/google/common/collect/Lists.newArrayList:(Ljava/lang/Iterable;)Ljava/util/ArrayList;
        //    64: astore          lllllllllllllllllIIIlllIIIIlIlII
        //    66: aload           lllllllllllllllllIIIlllIIIIlIlII
        //    68: invokeinterface java/util/List.size:()I
        //    73: iconst_1       
        //    74: if_icmple       124
        //    77: aload           lllllllllllllllllIIIlllIIIIlIlII
        //    79: iconst_1       
        //    80: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //    85: checkcast       Ljava/lang/String;
        //    88: astore          lllllllllllllllllIIIlllIIIIlIIll
        //    90: aload           lllllllllllllllllIIIlllIIIIlIIll
        //    92: aload           lllllllllllllllllIIIlllIIIIlIIll
        //    94: getstatic       java/util/Locale.ROOT:Ljava/util/Locale;
        //    97: invokevirtual   java/lang/String.toLowerCase:(Ljava/util/Locale;)Ljava/lang/String;
        //   100: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   103: ifeq            118
        //   106: aload_3         /* lllllllllllllllllIIIlllIIIIlIlll */
        //   107: aload           lllllllllllllllllIIIlllIIIIlIIll
        //   109: invokeinterface java/util/Set.add:(Ljava/lang/Object;)Z
        //   114: pop            
        //   115: goto            124
        //   118: aload_0         /* lllllllllllllllllIIIlllIIIIlllII */
        //   119: aload           lllllllllllllllllIIIlllIIIIlIIll
        //   121: invokevirtual   net/minecraft/client/resources/FileResourcePack.logNameNotLowercase:(Ljava/lang/String;)V
        //   124: aload_2         /* lllllllllllllllllIIIlllIIIIllIII */
        //   125: invokeinterface java/util/Enumeration.hasMoreElements:()Z
        //   130: ifne            25
        //   133: aload_3         /* lllllllllllllllllIIIlllIIIIlIlll */
        //   134: areturn        
        //    Signature:
        //  ()Ljava/util/Set<Ljava/lang/String;>;
        //    StackMapTable: 00 05 48 07 00 0E FC 00 04 07 00 14 FD 00 0B 07 00 37 07 00 9A FF 00 5C 00 08 07 00 02 07 00 14 07 00 37 07 00 9A 07 00 3D 07 00 45 07 00 9C 07 00 45 00 00 FF 00 05 00 04 07 00 02 07 00 14 07 00 37 07 00 9A 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      5      8      13     Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    protected void finalize() throws Throwable {
        this.close();
        super.finalize();
    }
    
    @Override
    protected InputStream getInputStreamByName(final String lllllllllllllllllIIIlllIIIllIlII) throws IOException {
        final ZipFile lllllllllllllllllIIIlllIIIllIIll = this.getResourcePackZipFile();
        final ZipEntry lllllllllllllllllIIIlllIIIllIIlI = lllllllllllllllllIIIlllIIIllIIll.getEntry(lllllllllllllllllIIIlllIIIllIlII);
        if (lllllllllllllllllIIIlllIIIllIIlI == null) {
            throw new ResourcePackFileNotFoundException(this.resourcePackFile, lllllllllllllllllIIIlllIIIllIlII);
        }
        return lllllllllllllllllIIIlllIIIllIIll.getInputStream(lllllllllllllllllIIIlllIIIllIIlI);
    }
    
    static {
        ENTRY_NAME_SPLITTER = Splitter.on('/').omitEmptyStrings().limit(3);
    }
    
    @Override
    public void close() throws IOException {
        if (this.resourcePackZipFile != null) {
            this.resourcePackZipFile.close();
            this.resourcePackZipFile = null;
        }
    }
    
    public FileResourcePack(final File lllllllllllllllllIIIlllIIIllllll) {
        super(lllllllllllllllllIIIlllIIIllllll);
    }
    
    private ZipFile getResourcePackZipFile() throws IOException {
        if (this.resourcePackZipFile == null) {
            this.resourcePackZipFile = new ZipFile(this.resourcePackFile);
        }
        return this.resourcePackZipFile;
    }
}
