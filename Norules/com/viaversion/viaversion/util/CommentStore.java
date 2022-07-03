package com.viaversion.viaversion.util;

import com.google.common.base.*;
import java.util.regex.*;
import java.nio.charset.*;
import com.google.common.io.*;
import java.util.*;
import java.io.*;
import com.google.common.collect.*;

public class CommentStore
{
    private final /* synthetic */ char pathSeperator;
    private final /* synthetic */ Map<String, List<String>> headers;
    private final /* synthetic */ int indents;
    private /* synthetic */ List<String> mainHeader;
    
    private String join(final String[] lllllllllllllIllIllllIIIllllllIl, final char lllllllllllllIllIllllIIlIIIIIIIl, final int lllllllllllllIllIllllIIIlllllIll, final int lllllllllllllIllIllllIIIlllllIlI) {
        final String[] lllllllllllllIllIllllIIIlllllllI = new String[lllllllllllllIllIllllIIIlllllIlI - lllllllllllllIllIllllIIIlllllIll];
        System.arraycopy(lllllllllllllIllIllllIIIllllllIl, lllllllllllllIllIllllIIIlllllIll, lllllllllllllIllIllllIIIlllllllI, 0, lllllllllllllIllIllllIIIlllllIlI - lllllllllllllIllIllllIIIlllllIll);
        return Joiner.on(lllllllllllllIllIllllIIlIIIIIIIl).join((Object[])lllllllllllllIllIllllIIIlllllllI);
    }
    
    private int getSuccessiveCharCount(final String lllllllllllllIllIllllIIIlllIllll, final char lllllllllllllIllIllllIIIlllIlllI) {
        int lllllllllllllIllIllllIIIllllIIII = 0;
        for (int lllllllllllllIllIllllIIIllllIlII = 0; lllllllllllllIllIllllIIIllllIlII < lllllllllllllIllIllllIIIlllIllll.length() && lllllllllllllIllIllllIIIlllIllll.charAt(lllllllllllllIllIllllIIIllllIlII) == lllllllllllllIllIllllIIIlllIlllI; ++lllllllllllllIllIllllIIIllllIlII) {
            ++lllllllllllllIllIllllIIIllllIIII;
        }
        return lllllllllllllIllIllllIIIllllIIII;
    }
    
    public void writeComments(final String lllllllllllllIllIllllIIlIIllIIIl, final File lllllllllllllIllIllllIIlIIllIIII) throws IOException {
        final int lllllllllllllIllIllllIIlIIlIllll = this.indents;
        final String lllllllllllllIllIllllIIlIIlIlllI = Character.toString(this.pathSeperator);
        final StringBuilder lllllllllllllIllIllllIIlIIlIllIl = new StringBuilder();
        int lllllllllllllIllIllllIIlIIlIllII = 0;
        String lllllllllllllIllIllllIIlIIlIlIll = "";
        for (final String lllllllllllllIllIllllIIlIIllllIl : this.mainHeader) {
            lllllllllllllIllIllllIIlIIlIllIl.append("#> ").append(lllllllllllllIllIllllIIlIIllllIl).append('\n');
        }
        final short lllllllllllllIllIllllIIlIIlIIIlI = (Object)lllllllllllllIllIllllIIlIIllIIIl.split("\n");
        final int length = lllllllllllllIllIllllIIlIIlIIIlI.length;
        for (byte lllllllllllllIllIllllIIlIIlIIIII = 0; lllllllllllllIllIllllIIlIIlIIIII < length; ++lllllllllllllIllIllllIIlIIlIIIII) {
            final String lllllllllllllIllIllllIIlIIllIIll = lllllllllllllIllIllllIIlIIlIIIlI[lllllllllllllIllIllllIIlIIlIIIII];
            if (!lllllllllllllIllIllllIIlIIllIIll.isEmpty()) {
                final int lllllllllllllIllIllllIIlIIlllIlI = this.getSuccessiveCharCount(lllllllllllllIllIllllIIlIIllIIll, ' ');
                final int lllllllllllllIllIllllIIlIIlllIIl = lllllllllllllIllIllllIIlIIlllIlI / lllllllllllllIllIllllIIlIIlIllll;
                final String lllllllllllllIllIllllIIlIIlllIII = (lllllllllllllIllIllllIIlIIlllIlI > 0) ? lllllllllllllIllIllllIIlIIllIIll.substring(0, lllllllllllllIllIllllIIlIIlllIlI) : "";
                if (lllllllllllllIllIllllIIlIIlllIIl <= lllllllllllllIllIllllIIlIIlIllII) {
                    final String[] lllllllllllllIllIllllIIlIIllllII = lllllllllllllIllIllllIIlIIlIlIll.split(Pattern.quote(lllllllllllllIllIllllIIlIIlIlllI));
                    final int lllllllllllllIllIllllIIlIIlllIll = lllllllllllllIllIllllIIlIIlIllII - lllllllllllllIllIllllIIlIIlllIIl + 1;
                    lllllllllllllIllIllllIIlIIlIlIll = this.join(lllllllllllllIllIllllIIlIIllllII, this.pathSeperator, 0, lllllllllllllIllIllllIIlIIllllII.length - lllllllllllllIllIllllIIlIIlllIll);
                }
                final String lllllllllllllIllIllllIIlIIllIlll = (lllllllllllllIllIllllIIlIIlIlIll.length() > 0) ? lllllllllllllIllIllllIIlIIlIlllI : "";
                final String lllllllllllllIllIllllIIlIIllIllI = lllllllllllllIllIllllIIlIIllIIll.contains(":") ? lllllllllllllIllIllllIIlIIllIIll.split(Pattern.quote(":"))[0] : lllllllllllllIllIllllIIlIIllIIll;
                lllllllllllllIllIllllIIlIIlIlIll = String.valueOf(new StringBuilder().append(lllllllllllllIllIllllIIlIIlIlIll).append(lllllllllllllIllIllllIIlIIllIlll).append(lllllllllllllIllIllllIIlIIllIllI.substring(lllllllllllllIllIllllIIlIIlllIlI)));
                lllllllllllllIllIllllIIlIIlIllII = lllllllllllllIllIllllIIlIIlllIIl;
                final List<String> lllllllllllllIllIllllIIlIIllIlIl = this.headers.get(lllllllllllllIllIllllIIlIIlIlIll);
                final String lllllllllllllIllIllllIIlIIllIlII = (lllllllllllllIllIllllIIlIIllIlIl != null) ? this.addHeaderTags(lllllllllllllIllIllllIIlIIllIlIl, lllllllllllllIllIllllIIlIIlllIII) : "";
                lllllllllllllIllIllllIIlIIlIllIl.append(lllllllllllllIllIllllIIlIIllIlII).append(lllllllllllllIllIllllIIlIIllIIll).append('\n');
            }
        }
        Files.write((CharSequence)String.valueOf(lllllllllllllIllIllllIIlIIlIllIl), lllllllllllllIllIllllIIlIIllIIII, StandardCharsets.UTF_8);
    }
    
    public void mainHeader(final String... lllllllllllllIllIllllIIllIlIIlIl) {
        this.mainHeader = Arrays.asList(lllllllllllllIllIllllIIllIlIIlIl);
    }
    
    public List<String> header(final String lllllllllllllIllIllllIIllIIIlIll) {
        return this.headers.get(lllllllllllllIllIllllIIllIIIlIll);
    }
    
    public List<String> mainHeader() {
        return this.mainHeader;
    }
    
    public void header(final String lllllllllllllIllIllllIIllIIlIIll, final String... lllllllllllllIllIllllIIllIIlIIlI) {
        this.headers.put(lllllllllllllIllIllllIIllIIlIIll, Arrays.asList(lllllllllllllIllIllllIIllIIlIIlI));
    }
    
    public void storeComments(final InputStream lllllllllllllIllIllllIIlIllIIIIl) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_1         /* lllllllllllllIllIllllIIlIllIlIlI */
        //     5: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //     8: astore_2        /* lllllllllllllIllIllllIIlIllIlIIl */
        //     9: aload_2         /* lllllllllllllIllIllllIIlIllIlIIl */
        //    10: invokestatic    com/google/common/io/CharStreams.toString:(Ljava/lang/Readable;)Ljava/lang/String;
        //    13: astore_3        /* lllllllllllllIllIllllIIlIlllIllI */
        //    14: aload_2         /* lllllllllllllIllIllllIIlIllIlIIl */
        //    15: invokevirtual   java/io/InputStreamReader.close:()V
        //    18: goto            30
        //    21: astore          lllllllllllllIllIllllIIlIlIllllI
        //    23: aload_2         /* lllllllllllllIllIllllIIlIllIlIIl */
        //    24: invokevirtual   java/io/InputStreamReader.close:()V
        //    27: aload           lllllllllllllIllIllllIIlIlIllllI
        //    29: athrow         
        //    30: new             Ljava/lang/StringBuilder;
        //    33: dup            
        //    34: invokespecial   java/lang/StringBuilder.<init>:()V
        //    37: astore          lllllllllllllIllIllllIIlIllIIlll
        //    39: aload_0         /* lllllllllllllIllIllllIIlIllIlIll */
        //    40: getfield        com/viaversion/viaversion/util/CommentStore.pathSeperator:C
        //    43: invokestatic    java/lang/Character.toString:(C)Ljava/lang/String;
        //    46: astore          lllllllllllllIllIllllIIlIllIIllI
        //    48: iconst_0       
        //    49: istore          lllllllllllllIllIllllIIlIllIIlIl
        //    51: ldc             ""
        //    53: astore          lllllllllllllIllIllllIIlIllIIlII
        //    55: invokestatic    com/google/common/collect/Lists.newArrayList:()Ljava/util/ArrayList;
        //    58: astore          lllllllllllllIllIllllIIlIllIIIll
        //    60: aload_3         /* lllllllllllllIllIllllIIlIllIlIII */
        //    61: ldc             "\n"
        //    63: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //    66: astore          lllllllllllllIllIllllIIlIlIllIIl
        //    68: aload           lllllllllllllIllIllllIIlIlIllIIl
        //    70: arraylength    
        //    71: istore          lllllllllllllIllIllllIIlIlIllIII
        //    73: iconst_0       
        //    74: istore          lllllllllllllIllIllllIIlIlIlIlll
        //    76: iload           lllllllllllllIllIllllIIlIlIlIlll
        //    78: iload           lllllllllllllIllIllllIIlIlIllIII
        //    80: if_icmpge       421
        //    83: aload           lllllllllllllIllIllllIIlIlIllIIl
        //    85: iload           lllllllllllllIllIllllIIlIlIlIlll
        //    87: aaload         
        //    88: astore          lllllllllllllIllIllllIIlIllIllII
        //    90: aload           lllllllllllllIllIllllIIlIllIllII
        //    92: invokevirtual   java/lang/String.isEmpty:()Z
        //    95: ifeq            101
        //    98: goto            415
        //   101: aload_0         /* lllllllllllllIllIllllIIlIllIlIll */
        //   102: aload           lllllllllllllIllIllllIIlIllIllII
        //   104: bipush          32
        //   106: invokespecial   com/viaversion/viaversion/util/CommentStore.getSuccessiveCharCount:(Ljava/lang/String;C)I
        //   109: istore          lllllllllllllIllIllllIIlIlllIIIl
        //   111: iload           lllllllllllllIllIllllIIlIlllIIIl
        //   113: ifle            126
        //   116: aload           lllllllllllllIllIllllIIlIllIllII
        //   118: iload           lllllllllllllIllIllllIIlIlllIIIl
        //   120: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   123: goto            128
        //   126: aload           lllllllllllllIllIllllIIlIllIllII
        //   128: astore          lllllllllllllIllIllllIIlIlllIIII
        //   130: aload           lllllllllllllIllIllllIIlIlllIIII
        //   132: ldc_w           "#"
        //   135: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   138: ifeq            235
        //   141: aload           lllllllllllllIllIllllIIlIlllIIII
        //   143: ldc_w           "#>"
        //   146: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   149: ifeq            194
        //   152: aload           lllllllllllllIllIllllIIlIlllIIII
        //   154: ldc             "#> "
        //   156: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   159: ifeq            171
        //   162: aload           lllllllllllllIllIllllIIlIlllIIII
        //   164: iconst_3       
        //   165: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   168: goto            177
        //   171: aload           lllllllllllllIllIllllIIlIlllIIII
        //   173: iconst_2       
        //   174: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   177: astore          lllllllllllllIllIllllIIlIlllIlIl
        //   179: aload_0         /* lllllllllllllIllIllllIIlIllIlIll */
        //   180: getfield        com/viaversion/viaversion/util/CommentStore.mainHeader:Ljava/util/List;
        //   183: aload           lllllllllllllIllIllllIIlIlllIlIl
        //   185: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   190: pop            
        //   191: goto            415
        //   194: aload           lllllllllllllIllIllllIIlIlllIIII
        //   196: ldc_w           "# "
        //   199: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   202: ifeq            214
        //   205: aload           lllllllllllllIllIllllIIlIlllIIII
        //   207: iconst_2       
        //   208: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   211: goto            220
        //   214: aload           lllllllllllllIllIllllIIlIlllIIII
        //   216: iconst_1       
        //   217: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   220: astore          lllllllllllllIllIllllIIlIlllIlII
        //   222: aload           lllllllllllllIllIllllIIlIllIIIll
        //   224: aload           lllllllllllllIllIllllIIlIlllIlII
        //   226: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   231: pop            
        //   232: goto            415
        //   235: iload           lllllllllllllIllIllllIIlIlllIIIl
        //   237: aload_0         /* lllllllllllllIllIllllIIlIllIlIll */
        //   238: getfield        com/viaversion/viaversion/util/CommentStore.indents:I
        //   241: idiv           
        //   242: istore          lllllllllllllIllIllllIIlIllIllll
        //   244: iload           lllllllllllllIllIllllIIlIllIllll
        //   246: iload           lllllllllllllIllIllllIIlIllIIlIl
        //   248: if_icmpgt       291
        //   251: aload           lllllllllllllIllIllllIIlIllIIlII
        //   253: aload           lllllllllllllIllIllllIIlIllIIllI
        //   255: invokestatic    java/util/regex/Pattern.quote:(Ljava/lang/String;)Ljava/lang/String;
        //   258: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //   261: astore          lllllllllllllIllIllllIIlIlllIIll
        //   263: iload           lllllllllllllIllIllllIIlIllIIlIl
        //   265: iload           lllllllllllllIllIllllIIlIllIllll
        //   267: isub           
        //   268: iconst_1       
        //   269: iadd           
        //   270: istore          lllllllllllllIllIllllIIlIlllIIlI
        //   272: aload_0         /* lllllllllllllIllIllllIIlIllIlIll */
        //   273: aload           lllllllllllllIllIllllIIlIlllIIll
        //   275: aload_0         /* lllllllllllllIllIllllIIlIllIlIll */
        //   276: getfield        com/viaversion/viaversion/util/CommentStore.pathSeperator:C
        //   279: iconst_0       
        //   280: aload           lllllllllllllIllIllllIIlIlllIIll
        //   282: arraylength    
        //   283: iload           lllllllllllllIllIllllIIlIlllIIlI
        //   285: isub           
        //   286: invokespecial   com/viaversion/viaversion/util/CommentStore.join:([Ljava/lang/String;CII)Ljava/lang/String;
        //   289: astore          lllllllllllllIllIllllIIlIllIIlII
        //   291: aload           lllllllllllllIllIllllIIlIllIIlII
        //   293: invokevirtual   java/lang/String.length:()I
        //   296: ifle            304
        //   299: aload           lllllllllllllIllIllllIIlIllIIllI
        //   301: goto            306
        //   304: ldc             ""
        //   306: astore          lllllllllllllIllIllllIIlIllIlllI
        //   308: aload           lllllllllllllIllIllllIIlIllIllII
        //   310: ldc             ":"
        //   312: invokevirtual   java/lang/String.contains:(Ljava/lang/CharSequence;)Z
        //   315: ifeq            333
        //   318: aload           lllllllllllllIllIllllIIlIllIllII
        //   320: ldc             ":"
        //   322: invokestatic    java/util/regex/Pattern.quote:(Ljava/lang/String;)Ljava/lang/String;
        //   325: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //   328: iconst_0       
        //   329: aaload         
        //   330: goto            335
        //   333: aload           lllllllllllllIllIllllIIlIllIllII
        //   335: astore          lllllllllllllIllIllllIIlIllIllIl
        //   337: new             Ljava/lang/StringBuilder;
        //   340: dup            
        //   341: invokespecial   java/lang/StringBuilder.<init>:()V
        //   344: aload           lllllllllllllIllIllllIIlIllIIlII
        //   346: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   349: aload           lllllllllllllIllIllllIIlIllIlllI
        //   351: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   354: aload           lllllllllllllIllIllllIIlIllIllIl
        //   356: iload           lllllllllllllIllIllllIIlIlllIIIl
        //   358: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //   361: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   364: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   367: astore          lllllllllllllIllIllllIIlIllIIlII
        //   369: iload           lllllllllllllIllIllllIIlIllIllll
        //   371: istore          lllllllllllllIllIllllIIlIllIIlIl
        //   373: aload           lllllllllllllIllIllllIIlIllIIlll
        //   375: aload           lllllllllllllIllIllllIIlIllIllII
        //   377: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   380: bipush          10
        //   382: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   385: pop            
        //   386: aload           lllllllllllllIllIllllIIlIllIIIll
        //   388: invokeinterface java/util/List.isEmpty:()Z
        //   393: ifne            415
        //   396: aload_0         /* lllllllllllllIllIllllIIlIllIlIll */
        //   397: getfield        com/viaversion/viaversion/util/CommentStore.headers:Ljava/util/Map;
        //   400: aload           lllllllllllllIllIllllIIlIllIIlII
        //   402: aload           lllllllllllllIllIllllIIlIllIIIll
        //   404: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   409: pop            
        //   410: invokestatic    com/google/common/collect/Lists.newArrayList:()Ljava/util/ArrayList;
        //   413: astore          lllllllllllllIllIllllIIlIllIIIll
        //   415: iinc            lllllllllllllIllIllllIIlIlIlIlll, 1
        //   418: goto            76
        //   421: return         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 13 FF 00 15 00 03 07 00 02 07 01 50 07 01 07 00 01 07 01 52 FC 00 08 07 00 12 FF 00 2D 00 0C 07 00 02 07 01 50 07 01 07 07 00 12 07 00 57 07 00 12 01 07 00 12 07 01 54 07 00 E1 01 01 00 00 FC 00 18 07 00 12 FC 00 18 01 41 07 00 12 FC 00 2A 07 00 12 45 07 00 12 10 13 45 07 00 12 0E FC 00 37 01 0C 41 07 00 12 FC 00 1A 07 00 12 41 07 00 12 FF 00 4F 00 0D 07 00 02 07 01 50 07 01 07 07 00 12 07 00 57 07 00 12 01 07 00 12 07 01 54 07 00 E1 01 01 07 00 12 00 00 FA 00 05
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  9      14     21     30     Any
        //  21     23     21     30     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private String addHeaderTags(final List<String> lllllllllllllIllIllllIIlIIIlIIII, final String lllllllllllllIllIllllIIlIIIIllll) {
        final StringBuilder lllllllllllllIllIllllIIlIIIIlllI = new StringBuilder();
        for (final String lllllllllllllIllIllllIIlIIIlIIlI : lllllllllllllIllIllllIIlIIIlIIII) {
            lllllllllllllIllIllllIIlIIIIlllI.append(lllllllllllllIllIllllIIlIIIIllll).append("# ").append(lllllllllllllIllIllllIIlIIIlIIlI).append('\n');
        }
        return String.valueOf(lllllllllllllIllIllllIIlIIIIlllI);
    }
    
    public CommentStore(final char lllllllllllllIllIllllIIllIllIlIl, final int lllllllllllllIllIllllIIllIlIllIl) {
        this.headers = (Map<String, List<String>>)Maps.newConcurrentMap();
        this.mainHeader = (List<String>)Lists.newArrayList();
        this.pathSeperator = lllllllllllllIllIllllIIllIllIlIl;
        this.indents = lllllllllllllIllIllllIIllIlIllIl;
    }
}
