package net.minecraft.client.renderer.vertex;

import org.apache.logging.log4j.*;

public class VertexFormatElement
{
    private final /* synthetic */ EnumType type;
    private final /* synthetic */ EnumUsage usage;
    private final /* synthetic */ int index;
    private final /* synthetic */ int elementCount;
    private static final /* synthetic */ Logger LOGGER;
    
    @Override
    public boolean equals(final Object llllllllllllllIlIIIIIIIllllllIll) {
        if (this == llllllllllllllIlIIIIIIIllllllIll) {
            return true;
        }
        if (llllllllllllllIlIIIIIIIllllllIll != null && this.getClass() == llllllllllllllIlIIIIIIIllllllIll.getClass()) {
            final VertexFormatElement llllllllllllllIlIIIIIIIlllllllIl = (VertexFormatElement)llllllllllllllIlIIIIIIIllllllIll;
            return this.elementCount == llllllllllllllIlIIIIIIIlllllllIl.elementCount && this.index == llllllllllllllIlIIIIIIIlllllllIl.index && this.type == llllllllllllllIlIIIIIIIlllllllIl.type && this.usage == llllllllllllllIlIIIIIIIlllllllIl.usage;
        }
        return false;
    }
    
    private final boolean isFirstOrUV(final int llllllllllllllIlIIIIIIlIIIIllIIl, final EnumUsage llllllllllllllIlIIIIIIlIIIIllIII) {
        return llllllllllllllIlIIIIIIlIIIIllIIl == 0 || llllllllllllllIlIIIIIIlIIIIllIII == EnumUsage.UV;
    }
    
    public final int getElementCount() {
        return this.elementCount;
    }
    
    public VertexFormatElement(final int llllllllllllllIlIIIIIIlIIIlIIlll, final EnumType llllllllllllllIlIIIIIIlIIIlIIllI, final EnumUsage llllllllllllllIlIIIIIIlIIIlIIIII, final int llllllllllllllIlIIIIIIlIIIIlllll) {
        if (this.isFirstOrUV(llllllllllllllIlIIIIIIlIIIlIIlll, llllllllllllllIlIIIIIIlIIIlIIIII)) {
            this.usage = llllllllllllllIlIIIIIIlIIIlIIIII;
        }
        else {
            VertexFormatElement.LOGGER.warn("Multiple vertex elements of the same type other than UVs are not supported. Forcing type to UV.");
            this.usage = EnumUsage.UV;
        }
        this.type = llllllllllllllIlIIIIIIlIIIlIIllI;
        this.index = llllllllllllllIlIIIIIIlIIIlIIlll;
        this.elementCount = llllllllllllllIlIIIIIIlIIIIlllll;
    }
    
    public final int getSize() {
        return this.type.getSize() * this.elementCount;
    }
    
    public final int getIndex() {
        return this.index;
    }
    
    public final boolean isPositionElement() {
        return this.usage == EnumUsage.POSITION;
    }
    
    public final EnumType getType() {
        return this.type;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public final EnumUsage getUsage() {
        return this.usage;
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIlIIIIIIIlllllIllI = this.type.hashCode();
        llllllllllllllIlIIIIIIIlllllIllI = 31 * llllllllllllllIlIIIIIIIlllllIllI + this.usage.hashCode();
        llllllllllllllIlIIIIIIIlllllIllI = 31 * llllllllllllllIlIIIIIIIlllllIllI + this.index;
        llllllllllllllIlIIIIIIIlllllIllI = 31 * llllllllllllllIlIIIIIIIlllllIllI + this.elementCount;
        return llllllllllllllIlIIIIIIIlllllIllI;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.elementCount)).append(",").append(this.usage.getDisplayName()).append(",").append(this.type.getDisplayName()));
    }
    
    public enum EnumType
    {
        USHORT("USHORT", 3, 2, "Unsigned Short", 5123);
        
        private final /* synthetic */ String displayName;
        
        BYTE("BYTE", 2, 1, "Byte", 5120), 
        UBYTE("UBYTE", 1, 1, "Unsigned Byte", 5121), 
        INT("INT", 6, 4, "Int", 5124), 
        FLOAT("FLOAT", 0, 4, "Float", 5126), 
        UINT("UINT", 5, 4, "Unsigned Int", 5125);
        
        private final /* synthetic */ int size;
        private final /* synthetic */ int glConstant;
        
        SHORT("SHORT", 4, 2, "Short", 5122);
        
        private EnumType(final String llllllllllllllllIIlIllIlIllIlIlI, final int llllllllllllllllIIlIllIlIllIlIIl, final int llllllllllllllllIIlIllIlIllIlllI, final String llllllllllllllllIIlIllIlIllIllIl, final int llllllllllllllllIIlIllIlIllIIllI) {
            this.size = llllllllllllllllIIlIllIlIllIlllI;
            this.displayName = llllllllllllllllIIlIllIlIllIllIl;
            this.glConstant = llllllllllllllllIIlIllIlIllIIllI;
        }
        
        public String getDisplayName() {
            return this.displayName;
        }
        
        public int getGlConstant() {
            return this.glConstant;
        }
        
        public int getSize() {
            return this.size;
        }
    }
    
    public enum EnumUsage
    {
        PADDING("PADDING", 6, "Padding");
        
        private final /* synthetic */ String displayName;
        
        UV("UV", 3, "UV"), 
        COLOR("COLOR", 2, "Vertex Color"), 
        NORMAL("NORMAL", 1, "Normal"), 
        BLEND_WEIGHT("BLEND_WEIGHT", 5, "Blend Weight"), 
        POSITION("POSITION", 0, "Position"), 
        MATRIX("MATRIX", 4, "Bone Matrix");
        
        public String getDisplayName() {
            return this.displayName;
        }
        
        private EnumUsage(final String lllllllllllllIIIIlIlIIIlllIllIll, final int lllllllllllllIIIIlIlIIIlllIllIlI, final String lllllllllllllIIIIlIlIIIlllIlllIl) {
            this.displayName = lllllllllllllIIIIlIlIIIlllIlllIl;
        }
    }
}
