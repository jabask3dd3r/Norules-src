package net.minecraft.realms;

import net.minecraft.client.renderer.vertex.*;

public class RealmsVertexFormatElement
{
    private final /* synthetic */ VertexFormatElement v;
    
    @Override
    public boolean equals(final Object lllllllllllllllIIIllIIlIIlIllIll) {
        return this.v.equals(lllllllllllllllIIIllIIlIIlIllIll);
    }
    
    @Override
    public int hashCode() {
        return this.v.hashCode();
    }
    
    public boolean isPosition() {
        return this.v.isPositionElement();
    }
    
    public int getByteSize() {
        return this.v.getSize();
    }
    
    public int getCount() {
        return this.v.getElementCount();
    }
    
    public int getIndex() {
        return this.v.getIndex();
    }
    
    public VertexFormatElement getVertexFormatElement() {
        return this.v;
    }
    
    public RealmsVertexFormatElement(final VertexFormatElement lllllllllllllllIIIllIIlIIlllIIIl) {
        this.v = lllllllllllllllIIIllIIlIIlllIIIl;
    }
    
    @Override
    public String toString() {
        return this.v.toString();
    }
}
