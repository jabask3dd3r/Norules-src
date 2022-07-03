package net.minecraft.realms;

import net.minecraft.client.renderer.*;
import java.nio.*;
import net.minecraft.client.renderer.vertex.*;

public class RealmsBufferBuilder
{
    private /* synthetic */ BufferBuilder b;
    
    public RealmsVertexFormat getVertexFormat() {
        return new RealmsVertexFormat(this.b.getVertexFormat());
    }
    
    public RealmsBufferBuilder color(final float llllllllllllIlllllIlIIIIllIllIll, final float llllllllllllIlllllIlIIIIllIllIlI, final float llllllllllllIlllllIlIIIIllIllllI, final float llllllllllllIlllllIlIIIIllIllIII) {
        return this.from(this.b.color(llllllllllllIlllllIlIIIIllIllIll, llllllllllllIlllllIlIIIIllIllIlI, llllllllllllIlllllIlIIIIllIllllI, llllllllllllIlllllIlIIIIllIllIII));
    }
    
    public void fixupVertexColor(final float llllllllllllIlllllIlIIIIlllIlIlI, final float llllllllllllIlllllIlIIIIlllIlIIl, final float llllllllllllIlllllIlIIIIlllIllIl, final int llllllllllllIlllllIlIIIIlllIIlll) {
        this.b.putColorRGB_F(llllllllllllIlllllIlIIIIlllIlIlI, llllllllllllIlllllIlIIIIlllIlIIl, llllllllllllIlllllIlIIIIlllIllIl, llllllllllllIlllllIlIIIIlllIIlll);
    }
    
    public void sortQuads(final float llllllllllllIlllllIlIIIlIllIIlll, final float llllllllllllIlllllIlIIIlIllIlIlI, final float llllllllllllIlllllIlIIIlIllIIlIl) {
        this.b.sortVertexData(llllllllllllIlllllIlIIIlIllIIlll, llllllllllllIlllllIlIIIlIllIlIlI, llllllllllllIlllllIlIIIlIllIIlIl);
    }
    
    public void offset(final double llllllllllllIlllllIlIIIlIlIIIIll, final double llllllllllllIlllllIlIIIlIlIIIIlI, final double llllllllllllIlllllIlIIIlIlIIIIIl) {
        this.b.setTranslation(llllllllllllIlllllIlIIIlIlIIIIll, llllllllllllIlllllIlIIIlIlIIIIlI, llllllllllllIlllllIlIIIlIlIIIIIl);
    }
    
    public void endVertex() {
        this.b.endVertex();
    }
    
    public RealmsBufferBuilder(final BufferBuilder llllllllllllIlllllIlIIIlIllllIIl) {
        this.b = llllllllllllIlllllIlIIIlIllllIIl;
    }
    
    public void fixupQuadColor(final int llllllllllllIlllllIlIIIlIllIIIIl) {
        this.b.putColor4(llllllllllllIlllllIlIIIlIllIIIIl);
    }
    
    public void restoreState(final BufferBuilder.State llllllllllllIlllllIlIIIlIIlllIll) {
        this.b.setVertexState(llllllllllllIlllllIlIIIlIIlllIll);
    }
    
    public void postProcessFacePosition(final double llllllllllllIlllllIlIIIIlllllIII, final double llllllllllllIlllllIlIIIIlllllIll, final double llllllllllllIlllllIlIIIIlllllIlI) {
        this.b.putPosition(llllllllllllIlllllIlIIIIlllllIII, llllllllllllIlllllIlIIIIlllllIll, llllllllllllIlllllIlIIIIlllllIlI);
    }
    
    public void putBulkData(final int[] llllllllllllIlllllIlIIIIlIlllIIl) {
        this.b.addVertexData(llllllllllllIlllllIlIIIIlIlllIIl);
    }
    
    public RealmsBufferBuilder vertex(final double llllllllllllIlllllIlIIIIlIlIIIlI, final double llllllllllllIlllllIlIIIIlIlIIIIl, final double llllllllllllIlllllIlIIIIlIlIIIII) {
        return this.from(this.b.pos(llllllllllllIlllllIlIIIIlIlIIIlI, llllllllllllIlllllIlIIIIlIlIIIIl, llllllllllllIlllllIlIIIIlIlIIIII));
    }
    
    public RealmsBufferBuilder tex(final double llllllllllllIlllllIlIIIIlIlIllll, final double llllllllllllIlllllIlIIIIlIlIlllI) {
        return this.from(this.b.tex(llllllllllllIlllllIlIIIIlIlIllll, llllllllllllIlllllIlIIIIlIlIlllI));
    }
    
    public RealmsBufferBuilder normal(final float llllllllllllIlllllIlIIIlIIlIlllI, final float llllllllllllIlllllIlIIIlIIllIIIl, final float llllllllllllIlllllIlIIIlIIllIIII) {
        return this.from(this.b.normal(llllllllllllIlllllIlIIIlIIlIlllI, llllllllllllIlllllIlIIIlIIllIIIl, llllllllllllIlllllIlIIIlIIllIIII));
    }
    
    public RealmsBufferBuilder tex2(final int llllllllllllIlllllIlIIIIlIlllllI, final int llllllllllllIlllllIlIIIIllIIIIII) {
        return this.from(this.b.lightmap(llllllllllllIlllllIlIIIIlIlllllI, llllllllllllIlllllIlIIIIllIIIIII));
    }
    
    public void noColor() {
        this.b.noColor();
    }
    
    public void clear() {
        this.b.reset();
    }
    
    public void fixupQuadColor(final float llllllllllllIlllllIlIIIIlIIlIllI, final float llllllllllllIlllllIlIIIIlIIlIIIl, final float llllllllllllIlllllIlIIIIlIIlIIII) {
        this.b.putColorRGB_F4(llllllllllllIlllllIlIIIIlIIlIllI, llllllllllllIlllllIlIIIIlIIlIIIl, llllllllllllIlllllIlIIIIlIIlIIII);
    }
    
    public void postNormal(final float llllllllllllIlllllIlIIIlIlIlIIlI, final float llllllllllllIlllllIlIIIlIlIlIlIl, final float llllllllllllIlllllIlIIIlIlIlIIII) {
        this.b.putNormal(llllllllllllIlllllIlIIIlIlIlIIlI, llllllllllllIlllllIlIIIlIlIlIlIl, llllllllllllIlllllIlIIIlIlIlIIII);
    }
    
    public RealmsBufferBuilder color(final int llllllllllllIlllllIlIIIlIIIlIlII, final int llllllllllllIlllllIlIIIlIIIllIII, final int llllllllllllIlllllIlIIIlIIIlIlll, final int llllllllllllIlllllIlIIIlIIIlIIIl) {
        return this.from(this.b.color(llllllllllllIlllllIlIIIlIIIlIlII, llllllllllllIlllllIlIIIlIIIllIII, llllllllllllIlllllIlIIIlIIIlIlll, llllllllllllIlllllIlIIIlIIIlIIIl));
    }
    
    public RealmsBufferBuilder from(final BufferBuilder llllllllllllIlllllIlIIIlIlllIIll) {
        this.b = llllllllllllIlllllIlIIIlIlllIIll;
        return this;
    }
    
    public void faceTint(final float llllllllllllIlllllIlIIIIllIIlIIl, final float llllllllllllIlllllIlIIIIllIIlIII, final float llllllllllllIlllllIlIIIIllIIllII, final int llllllllllllIlllllIlIIIIllIIlIll) {
        this.b.putColorMultiplier(llllllllllllIlllllIlIIIIllIIlIIl, llllllllllllIlllllIlIIIIllIIlIII, llllllllllllIlllllIlIIIIllIIllII, llllllllllllIlllllIlIIIIllIIlIll);
    }
    
    public ByteBuffer getBuffer() {
        return this.b.getByteBuffer();
    }
    
    public void faceTex2(final int llllllllllllIlllllIlIIIlIIIIlIlI, final int llllllllllllIlllllIlIIIlIIIIlIIl, final int llllllllllllIlllllIlIIIlIIIIIIll, final int llllllllllllIlllllIlIIIlIIIIIlll) {
        this.b.putBrightness4(llllllllllllIlllllIlIIIlIIIIlIlI, llllllllllllIlllllIlIIIlIIIIlIIl, llllllllllllIlllllIlIIIlIIIIIIll, llllllllllllIlllllIlIIIlIIIIIlll);
    }
    
    public int getDrawMode() {
        return this.b.getDrawMode();
    }
    
    public int getVertexCount() {
        return this.b.getVertexCount();
    }
    
    public void begin(final int llllllllllllIlllllIlIIIlIIlIIlII, final VertexFormat llllllllllllIlllllIlIIIlIIlIIIll) {
        this.b.begin(llllllllllllIlllllIlIIIlIIlIIlII, llllllllllllIlllllIlIIIlIIlIIIll);
    }
    
    public void end() {
        this.b.finishDrawing();
    }
}
