package net.minecraft.client.renderer;

public class Tessellator
{
    private final /* synthetic */ WorldVertexBufferUploader vboUploader;
    private final /* synthetic */ BufferBuilder worldRenderer;
    private static final /* synthetic */ Tessellator INSTANCE;
    
    public static Tessellator getInstance() {
        return Tessellator.INSTANCE;
    }
    
    public BufferBuilder getBuffer() {
        return this.worldRenderer;
    }
    
    public Tessellator(final int lllllllllllllIllIlllIIIIlIllllll) {
        this.vboUploader = new WorldVertexBufferUploader();
        this.worldRenderer = new BufferBuilder(lllllllllllllIllIlllIIIIlIllllll);
    }
    
    public void draw() {
        this.worldRenderer.finishDrawing();
        this.vboUploader.draw(this.worldRenderer);
    }
    
    static {
        INSTANCE = new Tessellator(2097152);
    }
}
