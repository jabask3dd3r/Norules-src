package net.minecraft.client.renderer;

import optifine.*;
import shadersmod.client.*;
import net.minecraft.client.renderer.vertex.*;
import java.nio.*;
import java.util.*;

public class WorldVertexBufferUploader
{
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage() {
        final int[] $switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage = WorldVertexBufferUploader.$SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;
        if ($switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage != null) {
            return $switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;
        }
        final char llllllllllllllIllIIllIlllIlIIllI = (Object)new int[VertexFormatElement.EnumUsage.values().length];
        try {
            llllllllllllllIllIIllIlllIlIIllI[VertexFormatElement.EnumUsage.BLEND_WEIGHT.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIllIIllIlllIlIIllI[VertexFormatElement.EnumUsage.COLOR.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIllIIllIlllIlIIllI[VertexFormatElement.EnumUsage.MATRIX.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIllIIllIlllIlIIllI[VertexFormatElement.EnumUsage.NORMAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIllIIllIlllIlIIllI[VertexFormatElement.EnumUsage.PADDING.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIllIIllIlllIlIIllI[VertexFormatElement.EnumUsage.POSITION.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllllIllIIllIlllIlIIllI[VertexFormatElement.EnumUsage.UV.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        return WorldVertexBufferUploader.$SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage = (int[])(Object)llllllllllllllIllIIllIlllIlIIllI;
    }
    
    public void draw(final BufferBuilder llllllllllllllIllIIllIlllIllIIll) {
        if (llllllllllllllIllIIllIlllIllIIll.getVertexCount() > 0) {
            final VertexFormat llllllllllllllIllIIllIllllIIIIll = llllllllllllllIllIIllIlllIllIIll.getVertexFormat();
            final int llllllllllllllIllIIllIllllIIIIlI = llllllllllllllIllIIllIllllIIIIll.getNextOffset();
            final ByteBuffer llllllllllllllIllIIllIllllIIIIIl = llllllllllllllIllIIllIlllIllIIll.getByteBuffer();
            final List<VertexFormatElement> llllllllllllllIllIIllIllllIIIIII = llllllllllllllIllIIllIllllIIIIll.getElements();
            final boolean llllllllllllllIllIIllIlllIllllll = Reflector.ForgeVertexFormatElementEnumUseage_preDraw.exists();
            final boolean llllllllllllllIllIIllIlllIlllllI = Reflector.ForgeVertexFormatElementEnumUseage_postDraw.exists();
            for (int llllllllllllllIllIIllIlllIllllIl = 0; llllllllllllllIllIIllIlllIllllIl < llllllllllllllIllIIllIllllIIIIII.size(); ++llllllllllllllIllIIllIlllIllllIl) {
                final VertexFormatElement llllllllllllllIllIIllIlllIllllII = llllllllllllllIllIIllIllllIIIIII.get(llllllllllllllIllIIllIlllIllllIl);
                final VertexFormatElement.EnumUsage llllllllllllllIllIIllIlllIlllIll = llllllllllllllIllIIllIlllIllllII.getUsage();
                if (llllllllllllllIllIIllIlllIllllll) {
                    Reflector.callVoid(llllllllllllllIllIIllIlllIlllIll, Reflector.ForgeVertexFormatElementEnumUseage_preDraw, llllllllllllllIllIIllIllllIIIIll, llllllllllllllIllIIllIlllIllllIl, llllllllllllllIllIIllIllllIIIIlI, llllllllllllllIllIIllIllllIIIIIl);
                }
                else {
                    final int llllllllllllllIllIIllIlllIlllIlI = llllllllllllllIllIIllIlllIllllII.getType().getGlConstant();
                    final int llllllllllllllIllIIllIlllIlllIIl = llllllllllllllIllIIllIlllIllllII.getIndex();
                    llllllllllllllIllIIllIllllIIIIIl.position(llllllllllllllIllIIllIllllIIIIll.getOffset(llllllllllllllIllIIllIlllIllllIl));
                    switch ($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage()[llllllllllllllIllIIllIlllIlllIll.ordinal()]) {
                        case 1: {
                            GlStateManager.glVertexPointer(llllllllllllllIllIIllIlllIllllII.getElementCount(), llllllllllllllIllIIllIlllIlllIlI, llllllllllllllIllIIllIllllIIIIlI, llllllllllllllIllIIllIllllIIIIIl);
                            GlStateManager.glEnableClientState(32884);
                            break;
                        }
                        case 4: {
                            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit + llllllllllllllIllIIllIlllIlllIIl);
                            GlStateManager.glTexCoordPointer(llllllllllllllIllIIllIlllIllllII.getElementCount(), llllllllllllllIllIIllIlllIlllIlI, llllllllllllllIllIIllIllllIIIIlI, llllllllllllllIllIIllIllllIIIIIl);
                            GlStateManager.glEnableClientState(32888);
                            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
                            break;
                        }
                        case 3: {
                            GlStateManager.glColorPointer(llllllllllllllIllIIllIlllIllllII.getElementCount(), llllllllllllllIllIIllIlllIlllIlI, llllllllllllllIllIIllIllllIIIIlI, llllllllllllllIllIIllIllllIIIIIl);
                            GlStateManager.glEnableClientState(32886);
                            break;
                        }
                        case 2: {
                            GlStateManager.glNormalPointer(llllllllllllllIllIIllIlllIlllIlI, llllllllllllllIllIIllIllllIIIIlI, llllllllllllllIllIIllIllllIIIIIl);
                            GlStateManager.glEnableClientState(32885);
                            break;
                        }
                    }
                }
            }
            if (llllllllllllllIllIIllIlllIllIIll.isMultiTexture()) {
                llllllllllllllIllIIllIlllIllIIll.drawMultiTexture();
            }
            else if (Config.isShaders()) {
                SVertexBuilder.drawArrays(llllllllllllllIllIIllIlllIllIIll.getDrawMode(), 0, llllllllllllllIllIIllIlllIllIIll.getVertexCount(), llllllllllllllIllIIllIlllIllIIll);
            }
            else {
                GlStateManager.glDrawArrays(llllllllllllllIllIIllIlllIllIIll.getDrawMode(), 0, llllllllllllllIllIIllIlllIllIIll.getVertexCount());
            }
            for (int llllllllllllllIllIIllIlllIlllIII = 0, llllllllllllllIllIIllIlllIllIlll = llllllllllllllIllIIllIllllIIIIII.size(); llllllllllllllIllIIllIlllIlllIII < llllllllllllllIllIIllIlllIllIlll; ++llllllllllllllIllIIllIlllIlllIII) {
                final VertexFormatElement llllllllllllllIllIIllIlllIllIllI = llllllllllllllIllIIllIllllIIIIII.get(llllllllllllllIllIIllIlllIlllIII);
                final VertexFormatElement.EnumUsage llllllllllllllIllIIllIlllIllIlIl = llllllllllllllIllIIllIlllIllIllI.getUsage();
                if (llllllllllllllIllIIllIlllIlllllI) {
                    Reflector.callVoid(llllllllllllllIllIIllIlllIllIlIl, Reflector.ForgeVertexFormatElementEnumUseage_postDraw, llllllllllllllIllIIllIllllIIIIll, llllllllllllllIllIIllIlllIlllIII, llllllllllllllIllIIllIllllIIIIlI, llllllllllllllIllIIllIllllIIIIIl);
                }
                else {
                    final int llllllllllllllIllIIllIlllIllIlII = llllllllllllllIllIIllIlllIllIllI.getIndex();
                    switch ($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage()[llllllllllllllIllIIllIlllIllIlIl.ordinal()]) {
                        case 1: {
                            GlStateManager.glDisableClientState(32884);
                            break;
                        }
                        case 4: {
                            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit + llllllllllllllIllIIllIlllIllIlII);
                            GlStateManager.glDisableClientState(32888);
                            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
                            break;
                        }
                        case 3: {
                            GlStateManager.glDisableClientState(32886);
                            GlStateManager.resetColor();
                            break;
                        }
                        case 2: {
                            GlStateManager.glDisableClientState(32885);
                            break;
                        }
                    }
                }
            }
        }
        llllllllllllllIllIIllIlllIllIIll.reset();
    }
}
