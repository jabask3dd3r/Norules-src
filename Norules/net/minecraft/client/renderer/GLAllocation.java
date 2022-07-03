package net.minecraft.client.renderer;

import java.nio.*;
import org.lwjgl.util.glu.*;

public class GLAllocation
{
    public static IntBuffer createDirectIntBuffer(final int lllllllllllllIlIIIlIIlIllIlIllll) {
        return createDirectByteBuffer(lllllllllllllIlIIIlIIlIllIlIllll << 2).asIntBuffer();
    }
    
    public static FloatBuffer createDirectFloatBuffer(final int lllllllllllllIlIIIlIIlIllIlIllII) {
        return createDirectByteBuffer(lllllllllllllIlIIIlIIlIllIlIllII << 2).asFloatBuffer();
    }
    
    public static synchronized void deleteDisplayLists(final int lllllllllllllIlIIIlIIlIllIlllIII, final int lllllllllllllIlIIIlIIlIllIllIlll) {
        GlStateManager.glDeleteLists(lllllllllllllIlIIIlIIlIllIlllIII, lllllllllllllIlIIIlIIlIllIllIlll);
    }
    
    public static synchronized void deleteDisplayLists(final int lllllllllllllIlIIIlIIlIllIllIlIl) {
        deleteDisplayLists(lllllllllllllIlIIIlIIlIllIllIlIl, 1);
    }
    
    public static synchronized ByteBuffer createDirectByteBuffer(final int lllllllllllllIlIIIlIIlIllIllIIIl) {
        return ByteBuffer.allocateDirect(lllllllllllllIlIIIlIIlIllIllIIIl).order(ByteOrder.nativeOrder());
    }
    
    public static synchronized int generateDisplayLists(final int lllllllllllllIlIIIlIIlIlllIIIIII) {
        final int lllllllllllllIlIIIlIIlIlllIIIIll = GlStateManager.glGenLists(lllllllllllllIlIIIlIIlIlllIIIIII);
        if (lllllllllllllIlIIIlIIlIlllIIIIll == 0) {
            final int lllllllllllllIlIIIlIIlIlllIIIIlI = GlStateManager.glGetError();
            String lllllllllllllIlIIIlIIlIlllIIIIIl = "No error code reported";
            if (lllllllllllllIlIIIlIIlIlllIIIIlI != 0) {
                lllllllllllllIlIIIlIIlIlllIIIIIl = GLU.gluErrorString(lllllllllllllIlIIIlIIlIlllIIIIlI);
            }
            throw new IllegalStateException(String.valueOf(new StringBuilder("glGenLists returned an ID of 0 for a count of ").append(lllllllllllllIlIIIlIIlIlllIIIIII).append(", GL error (").append(lllllllllllllIlIIIlIIlIlllIIIIlI).append("): ").append(lllllllllllllIlIIIlIIlIlllIIIIIl)));
        }
        return lllllllllllllIlIIIlIIlIlllIIIIll;
    }
}
