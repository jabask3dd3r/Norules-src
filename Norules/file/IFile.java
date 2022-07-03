package file;

import java.io.*;
import com.google.gson.*;

public interface IFile
{
    default void writeFile(final String llllllllllllllIlIlllIlIIlllIlIlI, final File llllllllllllllIlIlllIlIIlllIllIl) {
        try {
            Exception llllllllllllllIlIlllIlIIlllIlIII = null;
            final double llllllllllllllIlIlllIlIIlllIIlll = (double)null;
            try {
                final FileWriter llllllllllllllIlIlllIlIIlllIllII = new FileWriter(llllllllllllllIlIlllIlIIlllIllIl);
                try {
                    llllllllllllllIlIlllIlIIlllIllII.write(llllllllllllllIlIlllIlIIlllIlIlI);
                }
                finally {
                    if (llllllllllllllIlIlllIlIIlllIllII != null) {
                        llllllllllllllIlIlllIlIIlllIllII.close();
                    }
                }
            }
            finally {
                if (llllllllllllllIlIlllIlIIlllIlIII == null) {
                    llllllllllllllIlIlllIlIIlllIlIII = (Exception)llllllllllllllIlIlllIlIIlllIIlll;
                }
                else if (llllllllllllllIlIlllIlIIlllIlIII != llllllllllllllIlIlllIlIIlllIIlll) {
                    llllllllllllllIlIlllIlIIlllIlIII.addSuppressed((Throwable)llllllllllllllIlIlllIlIIlllIIlll);
                }
            }
        }
        catch (IOException llllllllllllllIlIlllIlIIlllIlIll) {
            llllllllllllllIlIlllIlIIlllIlIll.printStackTrace();
        }
    }
    
    void setFile(final File p0);
    
    void save(final Gson p0);
    
    default String readFile(final File llllllllllllllIlIlllIlIIllIllIII) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: invokespecial   java/lang/StringBuilder.<init>:()V
        //     7: astore_2        /* llllllllllllllIlIlllIlIIllIlllIl */
        //     8: aconst_null    
        //     9: astore_3        /* llllllllllllllIlIlllIlIIllIlIllI */
        //    10: aconst_null    
        //    11: astore          llllllllllllllIlIlllIlIIllIlIlIl
        //    13: new             Ljava/io/BufferedReader;
        //    16: dup            
        //    17: new             Ljava/io/FileReader;
        //    20: dup            
        //    21: aload_1         /* llllllllllllllIlIlllIlIIllIllllI */
        //    22: invokespecial   java/io/FileReader.<init>:(Ljava/io/File;)V
        //    25: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    28: astore          llllllllllllllIlIlllIlIIllIlllII
        //    30: goto            40
        //    33: aload_2         /* llllllllllllllIlIlllIlIIllIlllIl */
        //    34: aload           llllllllllllllIlIlllIlIIllIllIll
        //    36: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    39: pop            
        //    40: aload           llllllllllllllIlIlllIlIIllIlllII
        //    42: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //    45: dup            
        //    46: astore          llllllllllllllIlIlllIlIIllIllIlI
        //    48: ifnonnull       33
        //    51: aload           llllllllllllllIlIlllIlIIllIlllII
        //    53: ifnull          108
        //    56: aload           llllllllllllllIlIlllIlIIllIlllII
        //    58: invokevirtual   java/io/BufferedReader.close:()V
        //    61: goto            108
        //    64: astore_3        /* llllllllllllllIlIlllIlIIllIlIllI */
        //    65: aload           llllllllllllllIlIlllIlIIllIlllII
        //    67: ifnull          75
        //    70: aload           llllllllllllllIlIlllIlIIllIlllII
        //    72: invokevirtual   java/io/BufferedReader.close:()V
        //    75: aload_3         /* llllllllllllllIlIlllIlIIllIlIllI */
        //    76: athrow         
        //    77: astore          llllllllllllllIlIlllIlIIllIlIlIl
        //    79: aload_3         /* llllllllllllllIlIlllIlIIllIlIllI */
        //    80: ifnonnull       89
        //    83: aload           llllllllllllllIlIlllIlIIllIlIlIl
        //    85: astore_3        /* llllllllllllllIlIlllIlIIllIlIllI */
        //    86: goto            101
        //    89: aload_3         /* llllllllllllllIlIlllIlIIllIlIllI */
        //    90: aload           llllllllllllllIlIlllIlIIllIlIlIl
        //    92: if_acmpeq       101
        //    95: aload_3         /* llllllllllllllIlIlllIlIIllIlIllI */
        //    96: aload           llllllllllllllIlIlllIlIIllIlIlIl
        //    98: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
        //   101: aload_3         /* llllllllllllllIlIlllIlIIllIlIllI */
        //   102: athrow         
        //   103: astore_3        /* llllllllllllllIlIlllIlIIllIlIllI */
        //   104: aload_3         /* llllllllllllllIlIlllIlIIllIllIIl */
        //   105: invokevirtual   java/io/IOException.printStackTrace:()V
        //   108: aload_2         /* llllllllllllllIlIlllIlIIllIlllIl */
        //   109: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   112: areturn        
        //    StackMapTable: 00 09 FF 00 21 00 07 07 00 02 07 00 36 07 00 3D 05 05 07 00 41 07 00 34 00 00 FA 00 06 57 07 00 18 FF 00 0A 00 06 07 00 02 07 00 36 07 00 3D 07 00 18 05 07 00 41 00 00 FF 00 01 00 05 07 00 02 07 00 36 07 00 3D 07 00 18 05 00 01 07 00 18 FF 00 0B 00 05 07 00 02 07 00 36 07 00 3D 07 00 18 07 00 18 00 00 0B FF 00 01 00 03 07 00 02 07 00 36 07 00 3D 00 01 07 00 08 FC 00 04 07 00 08
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  30     51     64     77     Any
        //  13     77     77     103    Any
        //  8      103    103    108    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    void load(final Gson p0);
}
