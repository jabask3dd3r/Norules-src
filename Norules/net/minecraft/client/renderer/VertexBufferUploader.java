package net.minecraft.client.renderer;

import net.minecraft.client.renderer.vertex.*;

public class VertexBufferUploader extends WorldVertexBufferUploader
{
    private /* synthetic */ VertexBuffer vertexBuffer;
    
    @Override
    public void draw(final BufferBuilder lllllllllllllIIlIIIIlIIllIIIIlll) {
        lllllllllllllIIlIIIIlIIllIIIIlll.reset();
        this.vertexBuffer.bufferData(lllllllllllllIIlIIIIlIIllIIIIlll.getByteBuffer());
    }
    
    public void setVertexBuffer(final VertexBuffer lllllllllllllIIlIIIIlIIlIlllllll) {
        this.vertexBuffer = lllllllllllllIIlIIIIlIIlIlllllll;
    }
}
