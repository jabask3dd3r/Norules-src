package net.minecraft.realms;

import java.util.*;
import com.google.common.collect.*;
import net.minecraft.client.renderer.vertex.*;

public class RealmsVertexFormat
{
    private /* synthetic */ VertexFormat v;
    
    public RealmsVertexFormatElement getElement(final int lllllllllllllIllIIllIlIlllIlllll) {
        return new RealmsVertexFormatElement(this.v.getElement(lllllllllllllIllIIllIlIlllIlllll));
    }
    
    public RealmsVertexFormat(final VertexFormat lllllllllllllIllIIllIllIIIIIIIIl) {
        this.v = lllllllllllllIllIIllIllIIIIIIIIl;
    }
    
    public int getColorOffset() {
        return this.v.getColorOffset();
    }
    
    public int getElementCount() {
        return this.v.getElementCount();
    }
    
    public RealmsVertexFormat from(final VertexFormat lllllllllllllIllIIllIlIllllllIll) {
        this.v = lllllllllllllIllIIllIlIllllllIll;
        return this;
    }
    
    public int getIntegerSize() {
        return this.v.getIntegerSize();
    }
    
    @Override
    public int hashCode() {
        return this.v.hashCode();
    }
    
    public boolean hasNormal() {
        return this.v.hasNormal();
    }
    
    public int getNormalOffset() {
        return this.v.getNormalOffset();
    }
    
    public int getOffset(final int lllllllllllllIllIIllIlIllIllllll) {
        return this.v.getOffset(lllllllllllllIllIIllIlIllIllllll);
    }
    
    public boolean hasUv(final int lllllllllllllIllIIllIlIllllIIIll) {
        return this.v.hasUvOffset(lllllllllllllIllIIllIlIllllIIIll);
    }
    
    public boolean hasColor() {
        return this.v.hasColor();
    }
    
    @Override
    public String toString() {
        return this.v.toString();
    }
    
    public int getVertexSize() {
        return this.v.getNextOffset();
    }
    
    public int getUvOffset(final int lllllllllllllIllIIllIlIlllllIIIl) {
        return this.v.getUvOffsetById(lllllllllllllIllIIllIlIlllllIIIl);
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIllIIllIlIllIllIIll) {
        return this.v.equals(lllllllllllllIllIIllIlIllIllIIll);
    }
    
    public RealmsVertexFormat addElement(final RealmsVertexFormatElement lllllllllllllIllIIllIlIlllIlIlll) {
        return this.from(this.v.addElement(lllllllllllllIllIIllIlIlllIlIlll.getVertexFormatElement()));
    }
    
    public List<RealmsVertexFormatElement> getElements() {
        final List<RealmsVertexFormatElement> lllllllllllllIllIIllIlIlllIIlllI = (List<RealmsVertexFormatElement>)Lists.newArrayList();
        for (final VertexFormatElement lllllllllllllIllIIllIlIlllIIllIl : this.v.getElements()) {
            lllllllllllllIllIIllIlIlllIIlllI.add(new RealmsVertexFormatElement(lllllllllllllIllIIllIlIlllIIllIl));
        }
        return lllllllllllllIllIIllIlIlllIIlllI;
    }
    
    public VertexFormat getVertexFormat() {
        return this.v;
    }
    
    public void clear() {
        this.v.clear();
    }
}
