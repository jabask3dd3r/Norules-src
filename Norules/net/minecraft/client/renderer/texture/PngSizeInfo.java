package net.minecraft.client.renderer.texture;

import net.minecraft.client.resources.*;
import java.io.*;
import org.apache.commons.io.*;

public class PngSizeInfo
{
    public final /* synthetic */ int pngHeight;
    public final /* synthetic */ int pngWidth;
    
    public static PngSizeInfo makeFromResource(final IResource lllllllllllllIllIllllllIIIIlllIl) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: aload_0         /* lllllllllllllIllIllllllIIIIllIlI */
        //     5: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //    10: invokespecial   net/minecraft/client/renderer/texture/PngSizeInfo.<init>:(Ljava/io/InputStream;)V
        //    13: astore_1        /* lllllllllllllIllIllllllIIIIllIIl */
        //    14: goto            24
        //    17: astore_2        /* lllllllllllllIllIllllllIIIIllIII */
        //    18: aload_0         /* lllllllllllllIllIllllllIIIIllIlI */
        //    19: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //    22: aload_2         /* lllllllllllllIllIllllllIIIIllIII */
        //    23: athrow         
        //    24: aload_0         /* lllllllllllllIllIllllllIIIIllIlI */
        //    25: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //    28: aload_1         /* lllllllllllllIllIllllllIIIIllIll */
        //    29: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 02 51 07 00 27 FC 00 06 07 00 02
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  0      17     17     24     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public PngSizeInfo(final InputStream lllllllllllllIllIllllllIIIlIIlIl) throws IOException {
        final DataInputStream lllllllllllllIllIllllllIIIlIIlII = new DataInputStream(lllllllllllllIllIllllllIIIlIIlIl);
        if (lllllllllllllIllIllllllIIIlIIlII.readLong() != -8552249625308161526L) {
            throw new IOException("Bad PNG Signature");
        }
        if (lllllllllllllIllIllllllIIIlIIlII.readInt() != 13) {
            throw new IOException("Bad length for IHDR chunk!");
        }
        if (lllllllllllllIllIllllllIIIlIIlII.readInt() != 1229472850) {
            throw new IOException("Bad type for IHDR chunk!");
        }
        this.pngWidth = lllllllllllllIllIllllllIIIlIIlII.readInt();
        this.pngHeight = lllllllllllllIllIllllllIIIlIIlII.readInt();
        IOUtils.closeQuietly((InputStream)lllllllllllllIllIllllllIIIlIIlII);
    }
}
