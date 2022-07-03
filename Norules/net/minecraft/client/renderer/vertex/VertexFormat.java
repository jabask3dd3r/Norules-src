package net.minecraft.client.renderer.vertex;

import java.util.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;

public class VertexFormat
{
    private final /* synthetic */ List<VertexFormatElement> elements;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ List<Integer> uvOffsetsById;
    private /* synthetic */ int normalElementOffset;
    private /* synthetic */ int colorElementOffset;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;
    private /* synthetic */ int nextOffset;
    private final /* synthetic */ List<Integer> offsets;
    
    @Override
    public String toString() {
        String lllllllllllllIIIlIlIIllIllllIIll = String.valueOf(new StringBuilder("format: ").append(this.elements.size()).append(" elements: "));
        for (int lllllllllllllIIIlIlIIllIllllIIlI = 0; lllllllllllllIIIlIlIIllIllllIIlI < this.elements.size(); ++lllllllllllllIIIlIlIIllIllllIIlI) {
            lllllllllllllIIIlIlIIllIllllIIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIlIlIIllIllllIIll)).append(this.elements.get(lllllllllllllIIIlIlIIllIllllIIlI).toString()));
            if (lllllllllllllIIIlIlIIllIllllIIlI != this.elements.size() - 1) {
                lllllllllllllIIIlIlIIllIllllIIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIlIlIIllIllllIIll)).append(" "));
            }
        }
        return lllllllllllllIIIlIlIIllIllllIIll;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIIlIlIIllIllIIIIll) {
        if (this == lllllllllllllIIIlIlIIllIllIIIIll) {
            return true;
        }
        if (lllllllllllllIIIlIlIIllIllIIIIll != null && this.getClass() == lllllllllllllIIIlIlIIllIllIIIIll.getClass()) {
            final VertexFormat lllllllllllllIIIlIlIIllIllIIIlIl = (VertexFormat)lllllllllllllIIIlIlIIllIllIIIIll;
            return this.nextOffset == lllllllllllllIIIlIlIIllIllIIIlIl.nextOffset && this.elements.equals(lllllllllllllIIIlIlIIllIllIIIlIl.elements) && this.offsets.equals(lllllllllllllIIIlIlIIllIllIIIlIl.offsets);
        }
        return false;
    }
    
    public boolean hasNormal() {
        return this.normalElementOffset >= 0;
    }
    
    public VertexFormatElement getElement(final int lllllllllllllIIIlIlIIllIllIlIIIl) {
        return this.elements.get(lllllllllllllIIIlIlIIllIllIlIIIl);
    }
    
    public VertexFormat addElement(final VertexFormatElement lllllllllllllIIIlIlIIlllIIIlIIlI) {
        if (lllllllllllllIIIlIlIIlllIIIlIIlI.isPositionElement() && this.hasPosition()) {
            VertexFormat.LOGGER.warn("VertexFormat error: Trying to add a position VertexFormatElement when one already exists, ignoring.");
            return this;
        }
        this.elements.add(lllllllllllllIIIlIlIIlllIIIlIIlI);
        this.offsets.add(this.nextOffset);
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage()[lllllllllllllIIIlIlIIlllIIIlIIlI.getUsage().ordinal()]) {
            case 2: {
                this.normalElementOffset = this.nextOffset;
                break;
            }
            case 3: {
                this.colorElementOffset = this.nextOffset;
                break;
            }
            case 4: {
                this.uvOffsetsById.add(lllllllllllllIIIlIlIIlllIIIlIIlI.getIndex(), this.nextOffset);
                break;
            }
        }
        this.nextOffset += lllllllllllllIIIlIlIIlllIIIlIIlI.getSize();
        return this;
    }
    
    public int getOffset(final int lllllllllllllIIIlIlIIllIllIIlIll) {
        return this.offsets.get(lllllllllllllIIIlIlIIllIllIIlIll);
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public int getElementCount() {
        return this.elements.size();
    }
    
    public VertexFormat(final VertexFormat lllllllllllllIIIlIlIIlllIIlIIIII) {
        this();
        for (int lllllllllllllIIIlIlIIlllIIIlllll = 0; lllllllllllllIIIlIlIIlllIIIlllll < lllllllllllllIIIlIlIIlllIIlIIIII.getElementCount(); ++lllllllllllllIIIlIlIIlllIIIlllll) {
            this.addElement(lllllllllllllIIIlIlIIlllIIlIIIII.getElement(lllllllllllllIIIlIlIIlllIIIlllll));
        }
        this.nextOffset = lllllllllllllIIIlIlIIlllIIlIIIII.getNextOffset();
    }
    
    public boolean hasUvOffset(final int lllllllllllllIIIlIlIIlllIIIIIIII) {
        return this.uvOffsetsById.size() - 1 >= lllllllllllllIIIlIlIIlllIIIIIIII;
    }
    
    public List<VertexFormatElement> getElements() {
        return this.elements;
    }
    
    public int getUvOffsetById(final int lllllllllllllIIIlIlIIllIlllllIII) {
        return this.uvOffsetsById.get(lllllllllllllIIIlIlIIllIlllllIII);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage() {
        final int[] $switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage = VertexFormat.$SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;
        if ($switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage != null) {
            return $switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;
        }
        final int lllllllllllllIIIlIlIIllIlIlllIlI = (Object)new int[VertexFormatElement.EnumUsage.values().length];
        try {
            lllllllllllllIIIlIlIIllIlIlllIlI[VertexFormatElement.EnumUsage.BLEND_WEIGHT.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIIlIlIIllIlIlllIlI[VertexFormatElement.EnumUsage.COLOR.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIIlIlIIllIlIlllIlI[VertexFormatElement.EnumUsage.MATRIX.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIIlIlIIllIlIlllIlI[VertexFormatElement.EnumUsage.NORMAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIIlIlIIllIlIlllIlI[VertexFormatElement.EnumUsage.PADDING.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIIIlIlIIllIlIlllIlI[VertexFormatElement.EnumUsage.POSITION.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllllIIIlIlIIllIlIlllIlI[VertexFormatElement.EnumUsage.UV.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        return VertexFormat.$SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage = (int[])(Object)lllllllllllllIIIlIlIIllIlIlllIlI;
    }
    
    public VertexFormat() {
        this.elements = (List<VertexFormatElement>)Lists.newArrayList();
        this.offsets = (List<Integer>)Lists.newArrayList();
        this.colorElementOffset = -1;
        this.uvOffsetsById = (List<Integer>)Lists.newArrayList();
        this.normalElementOffset = -1;
    }
    
    public int getNormalOffset() {
        return this.normalElementOffset;
    }
    
    public int getColorOffset() {
        return this.colorElementOffset;
    }
    
    public int getIntegerSize() {
        return this.getNextOffset() / 4;
    }
    
    public boolean hasColor() {
        return this.colorElementOffset >= 0;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIIIlIlIIllIlIlllllI = this.elements.hashCode();
        lllllllllllllIIIlIlIIllIlIlllllI = 31 * lllllllllllllIIIlIlIIllIlIlllllI + this.offsets.hashCode();
        lllllllllllllIIIlIlIIllIlIlllllI = 31 * lllllllllllllIIIlIlIIllIlIlllllI + this.nextOffset;
        return lllllllllllllIIIlIlIIllIlIlllllI;
    }
    
    public void clear() {
        this.elements.clear();
        this.offsets.clear();
        this.colorElementOffset = -1;
        this.uvOffsetsById.clear();
        this.normalElementOffset = -1;
        this.nextOffset = 0;
    }
    
    private boolean hasPosition() {
        for (int lllllllllllllIIIlIlIIllIlllIlIIl = 0, lllllllllllllIIIlIlIIllIlllIlIII = this.elements.size(); lllllllllllllIIIlIlIIllIlllIlIIl < lllllllllllllIIIlIlIIllIlllIlIII; ++lllllllllllllIIIlIlIIllIlllIlIIl) {
            final VertexFormatElement lllllllllllllIIIlIlIIllIlllIIlll = this.elements.get(lllllllllllllIIIlIlIIllIlllIlIIl);
            if (lllllllllllllIIIlIlIIllIlllIIlll.isPositionElement()) {
                return true;
            }
        }
        return false;
    }
    
    public int getNextOffset() {
        return this.nextOffset;
    }
}
