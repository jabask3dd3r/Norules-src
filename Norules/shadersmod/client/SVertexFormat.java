package shadersmod.client;

import net.minecraft.client.renderer.vertex.*;

public class SVertexFormat
{
    public static VertexFormat makeDefVertexFormatItem() {
        final VertexFormat lllllllllllllllIIllIIlIlIIlIIllI = new VertexFormat();
        lllllllllllllllIIllIIlIlIIlIIllI.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.POSITION, 3));
        lllllllllllllllIIllIIlIlIIlIIllI.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.UBYTE, VertexFormatElement.EnumUsage.COLOR, 4));
        lllllllllllllllIIllIIlIlIIlIIllI.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.UV, 2));
        lllllllllllllllIIllIIlIlIIlIIllI.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUsage.PADDING, 2));
        lllllllllllllllIIllIIlIlIIlIIllI.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUsage.NORMAL, 3));
        lllllllllllllllIIllIIlIlIIlIIllI.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUsage.PADDING, 1));
        lllllllllllllllIIllIIlIlIIlIIllI.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.PADDING, 2));
        lllllllllllllllIIllIIlIlIIlIIllI.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUsage.PADDING, 4));
        lllllllllllllllIIllIIlIlIIlIIllI.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUsage.PADDING, 4));
        return lllllllllllllllIIllIIlIlIIlIIllI;
    }
    
    public static VertexFormat makeDefVertexFormatBlock() {
        final VertexFormat lllllllllllllllIIllIIlIlIIlIlIIl = new VertexFormat();
        lllllllllllllllIIllIIlIlIIlIlIIl.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.POSITION, 3));
        lllllllllllllllIIllIIlIlIIlIlIIl.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.UBYTE, VertexFormatElement.EnumUsage.COLOR, 4));
        lllllllllllllllIIllIIlIlIIlIlIIl.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.UV, 2));
        lllllllllllllllIIllIIlIlIIlIlIIl.addElement(new VertexFormatElement(1, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUsage.UV, 2));
        lllllllllllllllIIllIIlIlIIlIlIIl.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUsage.NORMAL, 3));
        lllllllllllllllIIllIIlIlIIlIlIIl.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUsage.PADDING, 1));
        lllllllllllllllIIllIIlIlIIlIlIIl.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.PADDING, 2));
        lllllllllllllllIIllIIlIlIIlIlIIl.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUsage.PADDING, 4));
        lllllllllllllllIIllIIlIlIIlIlIIl.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUsage.PADDING, 4));
        return lllllllllllllllIIllIIlIlIIlIlIIl;
    }
    
    static {
        offsetEntity = 12;
        offsetTangent = 10;
        vertexSizeBlock = 14;
        offsetMidTexCoord = 8;
        defVertexFormatTextured = makeDefVertexFormatTextured();
    }
    
    public static void setDefBakedFormat(final VertexFormat lllllllllllllllIIllIIlIlIIIlllll) {
        lllllllllllllllIIllIIlIlIIIlllll.clear();
        lllllllllllllllIIllIIlIlIIIlllll.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.POSITION, 3));
        lllllllllllllllIIllIIlIlIIIlllll.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.UBYTE, VertexFormatElement.EnumUsage.COLOR, 4));
        lllllllllllllllIIllIIlIlIIIlllll.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.UV, 2));
        lllllllllllllllIIllIIlIlIIIlllll.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUsage.PADDING, 2));
        lllllllllllllllIIllIIlIlIIIlllll.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUsage.NORMAL, 3));
        lllllllllllllllIIllIIlIlIIIlllll.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUsage.PADDING, 1));
        lllllllllllllllIIllIIlIlIIIlllll.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.PADDING, 2));
        lllllllllllllllIIllIIlIlIIIlllll.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUsage.PADDING, 4));
        lllllllllllllllIIllIIlIlIIIlllll.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUsage.PADDING, 4));
    }
    
    public static VertexFormat makeDefVertexFormatTextured() {
        final VertexFormat lllllllllllllllIIllIIlIlIIlIIIll = new VertexFormat();
        lllllllllllllllIIllIIlIlIIlIIIll.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.POSITION, 3));
        lllllllllllllllIIllIIlIlIIlIIIll.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.UBYTE, VertexFormatElement.EnumUsage.PADDING, 4));
        lllllllllllllllIIllIIlIlIIlIIIll.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.UV, 2));
        lllllllllllllllIIllIIlIlIIlIIIll.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUsage.PADDING, 2));
        lllllllllllllllIIllIIlIlIIlIIIll.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUsage.NORMAL, 3));
        lllllllllllllllIIllIIlIlIIlIIIll.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUsage.PADDING, 1));
        lllllllllllllllIIllIIlIlIIlIIIll.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.PADDING, 2));
        lllllllllllllllIIllIIlIlIIlIIIll.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUsage.PADDING, 4));
        lllllllllllllllIIllIIlIlIIlIIIll.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUsage.PADDING, 4));
        return lllllllllllllllIIllIIlIlIIlIIIll;
    }
}
