package net.minecraft.client.renderer.vertex;

import java.nio.*;
import net.minecraft.client.renderer.*;

public class VertexBuffer
{
    private /* synthetic */ int glBufferId;
    private final /* synthetic */ VertexFormat vertexFormat;
    private /* synthetic */ int count;
    
    public void deleteGlBuffers() {
        if (this.glBufferId >= 0) {
            OpenGlHelper.glDeleteBuffers(this.glBufferId);
            this.glBufferId = -1;
        }
    }
    
    public void bufferData(final ByteBuffer llllllllllllllIlIlIlIllllllllIll) {
        this.bindBuffer();
        OpenGlHelper.glBufferData(OpenGlHelper.GL_ARRAY_BUFFER, llllllllllllllIlIlIlIllllllllIll, 35044);
        this.unbindBuffer();
        this.count = llllllllllllllIlIlIlIllllllllIll.limit() / this.vertexFormat.getNextOffset();
    }
    
    public VertexBuffer(final VertexFormat llllllllllllllIlIlIllIIIIIIIIllI) {
        this.vertexFormat = llllllllllllllIlIlIllIIIIIIIIllI;
        this.glBufferId = OpenGlHelper.glGenBuffers();
    }
    
    public void drawArrays(final int llllllllllllllIlIlIlIlllllllIlIl) {
        GlStateManager.glDrawArrays(llllllllllllllIlIlIlIlllllllIlIl, 0, this.count);
    }
    
    public void unbindBuffer() {
        OpenGlHelper.glBindBuffer(OpenGlHelper.GL_ARRAY_BUFFER, 0);
    }
    
    public void bindBuffer() {
        OpenGlHelper.glBindBuffer(OpenGlHelper.GL_ARRAY_BUFFER, this.glBufferId);
    }
}
