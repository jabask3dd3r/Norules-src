package net.minecraft.client.renderer;

import net.minecraft.client.renderer.texture.*;
import shadersmod.client.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.util.*;
import org.apache.logging.log4j.*;
import java.nio.*;
import optifine.*;
import org.lwjgl.opengl.*;
import com.google.common.primitives.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;

public class BufferBuilder
{
    private /* synthetic */ TextureAtlasSprite quadSprite;
    private /* synthetic */ ByteBuffer byteBuffer;
    public /* synthetic */ IntBuffer rawIntBuffer;
    private /* synthetic */ TextureAtlasSprite[] quadSpritesPrev;
    private /* synthetic */ boolean noColor;
    public /* synthetic */ int drawMode;
    private /* synthetic */ int vertexFormatIndex;
    private /* synthetic */ TextureAtlasSprite[] quadSprites;
    private /* synthetic */ boolean isDrawing;
    private /* synthetic */ VertexFormatElement vertexFormatElement;
    private /* synthetic */ ShortBuffer rawShortBuffer;
    public /* synthetic */ int vertexCount;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType;
    private /* synthetic */ double xOffset;
    public /* synthetic */ FloatBuffer rawFloatBuffer;
    private /* synthetic */ boolean[] drawnIcons;
    private static final /* synthetic */ Logger LOGGER;
    public /* synthetic */ RenderEnv renderEnv;
    private /* synthetic */ VertexFormat vertexFormat;
    private /* synthetic */ double yOffset;
    private /* synthetic */ double zOffset;
    private /* synthetic */ BlockRenderLayer blockLayer;
    
    public State getVertexState() {
        this.rawIntBuffer.rewind();
        final int lllllllllllllIlllIlIIIllllIlIIII = this.getBufferSize();
        this.rawIntBuffer.limit(lllllllllllllIlllIlIIIllllIlIIII);
        final int[] lllllllllllllIlllIlIIIllllIIllll = new int[lllllllllllllIlllIlIIIllllIlIIII];
        this.rawIntBuffer.get(lllllllllllllIlllIlIIIllllIIllll);
        this.rawIntBuffer.limit(this.rawIntBuffer.capacity());
        this.rawIntBuffer.position(lllllllllllllIlllIlIIIllllIlIIII);
        TextureAtlasSprite[] lllllllllllllIlllIlIIIllllIIlllI = null;
        if (this.quadSprites != null) {
            final int lllllllllllllIlllIlIIIllllIIllIl = this.vertexCount / 4;
            lllllllllllllIlllIlIIIllllIIlllI = new TextureAtlasSprite[lllllllllllllIlllIlIIIllllIIllIl];
            System.arraycopy(this.quadSprites, 0, lllllllllllllIlllIlIIIllllIIlllI, 0, lllllllllllllIlllIlIIIllllIIllIl);
        }
        return new State(lllllllllllllIlllIlIIIllllIIllll, new VertexFormat(this.vertexFormat), lllllllllllllIlllIlIIIllllIIlllI);
    }
    
    public BufferBuilder normal(final float lllllllllllllIlllIlIIIlIIlIlIlll, final float lllllllllllllIlllIlIIIlIIlIlIllI, final float lllllllllllllIlllIlIIIlIIlIllIlI) {
        final int lllllllllllllIlllIlIIIlIIlIllIIl = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType()[this.vertexFormatElement.getType().ordinal()]) {
            case 1: {
                this.byteBuffer.putFloat(lllllllllllllIlllIlIIIlIIlIllIIl, lllllllllllllIlllIlIIIlIIlIlIlll);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIIIlIIlIllIIl + 4, lllllllllllllIlllIlIIIlIIlIlIllI);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIIIlIIlIllIIl + 8, lllllllllllllIlllIlIIIlIIlIllIlI);
                break;
            }
            case 6:
            case 7: {
                this.byteBuffer.putInt(lllllllllllllIlllIlIIIlIIlIllIIl, (int)lllllllllllllIlllIlIIIlIIlIlIlll);
                this.byteBuffer.putInt(lllllllllllllIlllIlIIIlIIlIllIIl + 4, (int)lllllllllllllIlllIlIIIlIIlIlIllI);
                this.byteBuffer.putInt(lllllllllllllIlllIlIIIlIIlIllIIl + 8, (int)lllllllllllllIlllIlIIIlIIlIllIlI);
                break;
            }
            case 4:
            case 5: {
                this.byteBuffer.putShort(lllllllllllllIlllIlIIIlIIlIllIIl, (short)((int)(lllllllllllllIlllIlIIIlIIlIlIlll * 32767.0f) & 0xFFFF));
                this.byteBuffer.putShort(lllllllllllllIlllIlIIIlIIlIllIIl + 2, (short)((int)(lllllllllllllIlllIlIIIlIIlIlIllI * 32767.0f) & 0xFFFF));
                this.byteBuffer.putShort(lllllllllllllIlllIlIIIlIIlIllIIl + 4, (short)((int)(lllllllllllllIlllIlIIIlIIlIllIlI * 32767.0f) & 0xFFFF));
                break;
            }
            case 2:
            case 3: {
                this.byteBuffer.put(lllllllllllllIlllIlIIIlIIlIllIIl, (byte)((int)(lllllllllllllIlllIlIIIlIIlIlIlll * 127.0f) & 0xFF));
                this.byteBuffer.put(lllllllllllllIlllIlIIIlIIlIllIIl + 1, (byte)((int)(lllllllllllllIlllIlIIIlIIlIlIllI * 127.0f) & 0xFF));
                this.byteBuffer.put(lllllllllllllIlllIlIIIlIIlIllIIl + 2, (byte)((int)(lllllllllllllIlllIlIIIlIIlIllIlI * 127.0f) & 0xFF));
                break;
            }
        }
        this.nextVertexFormatIndex();
        return this;
    }
    
    public double getYOffset() {
        return this.yOffset;
    }
    
    public double getZOffset() {
        return this.zOffset;
    }
    
    public boolean isColorDisabled() {
        return this.noColor;
    }
    
    public BufferBuilder tex(double lllllllllllllIlllIlIIIllIllIIlll, double lllllllllllllIlllIlIIIllIllIIllI) {
        if (this.quadSprite != null && this.quadSprites != null) {
            lllllllllllllIlllIlIIIllIllIIlll = this.quadSprite.toSingleU((float)lllllllllllllIlllIlIIIllIllIIlll);
            lllllllllllllIlllIlIIIllIllIIllI = this.quadSprite.toSingleV((float)lllllllllllllIlllIlIIIllIllIIllI);
            this.quadSprites[this.vertexCount / 4] = this.quadSprite;
        }
        final int lllllllllllllIlllIlIIIllIllIlIIl = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType()[this.vertexFormatElement.getType().ordinal()]) {
            case 1: {
                this.byteBuffer.putFloat(lllllllllllllIlllIlIIIllIllIlIIl, (float)lllllllllllllIlllIlIIIllIllIIlll);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIIIllIllIlIIl + 4, (float)lllllllllllllIlllIlIIIllIllIIllI);
                break;
            }
            case 6:
            case 7: {
                this.byteBuffer.putInt(lllllllllllllIlllIlIIIllIllIlIIl, (int)lllllllllllllIlllIlIIIllIllIIlll);
                this.byteBuffer.putInt(lllllllllllllIlllIlIIIllIllIlIIl + 4, (int)lllllllllllllIlllIlIIIllIllIIllI);
                break;
            }
            case 4:
            case 5: {
                this.byteBuffer.putShort(lllllllllllllIlllIlIIIllIllIlIIl, (short)lllllllllllllIlllIlIIIllIllIIllI);
                this.byteBuffer.putShort(lllllllllllllIlllIlIIIllIllIlIIl + 2, (short)lllllllllllllIlllIlIIIllIllIIlll);
                break;
            }
            case 2:
            case 3: {
                this.byteBuffer.put(lllllllllllllIlllIlIIIllIllIlIIl, (byte)lllllllllllllIlllIlIIIllIllIIllI);
                this.byteBuffer.put(lllllllllllllIlllIlIIIllIllIlIIl + 1, (byte)lllllllllllllIlllIlIIIllIllIIlll);
                break;
            }
        }
        this.nextVertexFormatIndex();
        return this;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public void putColorRGBA(final int lllllllllllllIlllIlIIIIllIlIIIIl, final int lllllllllllllIlllIlIIIIllIlIIIII, final int lllllllllllllIlllIlIIIIllIIlllll, final int lllllllllllllIlllIlIIIIllIIllIII, final int lllllllllllllIlllIlIIIIllIIlllIl) {
        if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            this.rawIntBuffer.put(lllllllllllllIlllIlIIIIllIlIIIIl, lllllllllllllIlllIlIIIIllIIlllIl << 24 | lllllllllllllIlllIlIIIIllIIllIII << 16 | lllllllllllllIlllIlIIIIllIIlllll << 8 | lllllllllllllIlllIlIIIIllIlIIIII);
        }
        else {
            this.rawIntBuffer.put(lllllllllllllIlllIlIIIIllIlIIIIl, lllllllllllllIlllIlIIIIllIlIIIII << 24 | lllllllllllllIlllIlIIIIllIIlllll << 16 | lllllllllllllIlllIlIIIIllIIllIII << 8 | lllllllllllllIlllIlIIIIllIIlllIl);
        }
    }
    
    public void noColor() {
        this.noColor = true;
    }
    
    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }
    
    public void setTranslation(final double lllllllllllllIlllIlIIIlIIlIIlllI, final double lllllllllllllIlllIlIIIlIIlIIllIl, final double lllllllllllllIlllIlIIIlIIlIIlIII) {
        this.xOffset = lllllllllllllIlllIlIIIlIIlIIlllI;
        this.yOffset = lllllllllllllIlllIlIIIlIIlIIllIl;
        this.zOffset = lllllllllllllIlllIlIIIlIIlIIlIII;
    }
    
    public VertexFormat getVertexFormat() {
        return this.vertexFormat;
    }
    
    public void setSprite(final TextureAtlasSprite lllllllllllllIlllIlIIIlIIIIlIIlI) {
        if (this.quadSprites != null) {
            this.quadSprite = lllllllllllllIlllIlIIIlIIIIlIIlI;
        }
    }
    
    public BufferBuilder color(final int lllllllllllllIlllIlIIIlIlIlIIIII, final int lllllllllllllIlllIlIIIlIlIIlllll, final int lllllllllllllIlllIlIIIlIlIlIIlII, final int lllllllllllllIlllIlIIIlIlIlIIIll) {
        if (this.noColor) {
            return this;
        }
        final int lllllllllllllIlllIlIIIlIlIlIIIlI = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType()[this.vertexFormatElement.getType().ordinal()]) {
            case 1: {
                this.byteBuffer.putFloat(lllllllllllllIlllIlIIIlIlIlIIIlI, lllllllllllllIlllIlIIIlIlIlIIIII / 255.0f);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIIIlIlIlIIIlI + 4, lllllllllllllIlllIlIIIlIlIIlllll / 255.0f);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIIIlIlIlIIIlI + 8, lllllllllllllIlllIlIIIlIlIlIIlII / 255.0f);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIIIlIlIlIIIlI + 12, lllllllllllllIlllIlIIIlIlIlIIIll / 255.0f);
                break;
            }
            case 6:
            case 7: {
                this.byteBuffer.putFloat(lllllllllllllIlllIlIIIlIlIlIIIlI, (float)lllllllllllllIlllIlIIIlIlIlIIIII);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIIIlIlIlIIIlI + 4, (float)lllllllllllllIlllIlIIIlIlIIlllll);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIIIlIlIlIIIlI + 8, (float)lllllllllllllIlllIlIIIlIlIlIIlII);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIIIlIlIlIIIlI + 12, (float)lllllllllllllIlllIlIIIlIlIlIIIll);
                break;
            }
            case 4:
            case 5: {
                this.byteBuffer.putShort(lllllllllllllIlllIlIIIlIlIlIIIlI, (short)lllllllllllllIlllIlIIIlIlIlIIIII);
                this.byteBuffer.putShort(lllllllllllllIlllIlIIIlIlIlIIIlI + 2, (short)lllllllllllllIlllIlIIIlIlIIlllll);
                this.byteBuffer.putShort(lllllllllllllIlllIlIIIlIlIlIIIlI + 4, (short)lllllllllllllIlllIlIIIlIlIlIIlII);
                this.byteBuffer.putShort(lllllllllllllIlllIlIIIlIlIlIIIlI + 6, (short)lllllllllllllIlllIlIIIlIlIlIIIll);
                break;
            }
            case 2:
            case 3: {
                if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
                    this.byteBuffer.put(lllllllllllllIlllIlIIIlIlIlIIIlI, (byte)lllllllllllllIlllIlIIIlIlIlIIIII);
                    this.byteBuffer.put(lllllllllllllIlllIlIIIlIlIlIIIlI + 1, (byte)lllllllllllllIlllIlIIIlIlIIlllll);
                    this.byteBuffer.put(lllllllllllllIlllIlIIIlIlIlIIIlI + 2, (byte)lllllllllllllIlllIlIIIlIlIlIIlII);
                    this.byteBuffer.put(lllllllllllllIlllIlIIIlIlIlIIIlI + 3, (byte)lllllllllllllIlllIlIIIlIlIlIIIll);
                    break;
                }
                this.byteBuffer.put(lllllllllllllIlllIlIIIlIlIlIIIlI, (byte)lllllllllllllIlllIlIIIlIlIlIIIll);
                this.byteBuffer.put(lllllllllllllIlllIlIIIlIlIlIIIlI + 1, (byte)lllllllllllllIlllIlIIIlIlIlIIlII);
                this.byteBuffer.put(lllllllllllllIlllIlIIIlIlIlIIIlI + 2, (byte)lllllllllllllIlllIlIIIlIlIIlllll);
                this.byteBuffer.put(lllllllllllllIlllIlIIIlIlIlIIIlI + 3, (byte)lllllllllllllIlllIlIIIlIlIlIIIII);
                break;
            }
        }
        this.nextVertexFormatIndex();
        return this;
    }
    
    public void putColor4(final int lllllllllllllIlllIlIIIlIIIllIlII) {
        for (int lllllllllllllIlllIlIIIlIIIllIIll = 0; lllllllllllllIlllIlIIIlIIIllIIll < 4; ++lllllllllllllIlllIlIIIlIIIllIIll) {
            this.func_192836_a(lllllllllllllIlllIlIIIlIIIllIlII, lllllllllllllIlllIlIIIlIIIllIIll + 1);
        }
    }
    
    private void nextVertexFormatIndex() {
        ++this.vertexFormatIndex;
        this.vertexFormatIndex %= this.vertexFormat.getElementCount();
        this.vertexFormatElement = this.vertexFormat.getElement(this.vertexFormatIndex);
        if (this.vertexFormatElement.getUsage() == VertexFormatElement.EnumUsage.PADDING) {
            this.nextVertexFormatIndex();
        }
    }
    
    private static float getDistanceSq(final FloatBuffer lllllllllllllIlllIlIIIlllIlIllll, final float lllllllllllllIlllIlIIIlllIIllIIl, final float lllllllllllllIlllIlIIIlllIIllIII, final float lllllllllllllIlllIlIIIlllIIlIlll, final int lllllllllllllIlllIlIIIlllIIlIllI, final int lllllllllllllIlllIlIIIlllIIlIlIl) {
        final float lllllllllllllIlllIlIIIlllIlIlIIl = lllllllllllllIlllIlIIIlllIlIllll.get(lllllllllllllIlllIlIIIlllIIlIlIl + lllllllllllllIlllIlIIIlllIIlIllI * 0 + 0);
        final float lllllllllllllIlllIlIIIlllIlIlIII = lllllllllllllIlllIlIIIlllIlIllll.get(lllllllllllllIlllIlIIIlllIIlIlIl + lllllllllllllIlllIlIIIlllIIlIllI * 0 + 1);
        final float lllllllllllllIlllIlIIIlllIlIIlll = lllllllllllllIlllIlIIIlllIlIllll.get(lllllllllllllIlllIlIIIlllIIlIlIl + lllllllllllllIlllIlIIIlllIIlIllI * 0 + 2);
        final float lllllllllllllIlllIlIIIlllIlIIllI = lllllllllllllIlllIlIIIlllIlIllll.get(lllllllllllllIlllIlIIIlllIIlIlIl + lllllllllllllIlllIlIIIlllIIlIllI * 1 + 0);
        final float lllllllllllllIlllIlIIIlllIlIIlIl = lllllllllllllIlllIlIIIlllIlIllll.get(lllllllllllllIlllIlIIIlllIIlIlIl + lllllllllllllIlllIlIIIlllIIlIllI * 1 + 1);
        final float lllllllllllllIlllIlIIIlllIlIIlII = lllllllllllllIlllIlIIIlllIlIllll.get(lllllllllllllIlllIlIIIlllIIlIlIl + lllllllllllllIlllIlIIIlllIIlIllI * 1 + 2);
        final float lllllllllllllIlllIlIIIlllIlIIIll = lllllllllllllIlllIlIIIlllIlIllll.get(lllllllllllllIlllIlIIIlllIIlIlIl + lllllllllllllIlllIlIIIlllIIlIllI * 2 + 0);
        final float lllllllllllllIlllIlIIIlllIlIIIlI = lllllllllllllIlllIlIIIlllIlIllll.get(lllllllllllllIlllIlIIIlllIIlIlIl + lllllllllllllIlllIlIIIlllIIlIllI * 2 + 1);
        final float lllllllllllllIlllIlIIIlllIlIIIIl = lllllllllllllIlllIlIIIlllIlIllll.get(lllllllllllllIlllIlIIIlllIIlIlIl + lllllllllllllIlllIlIIIlllIIlIllI * 2 + 2);
        final float lllllllllllllIlllIlIIIlllIlIIIII = lllllllllllllIlllIlIIIlllIlIllll.get(lllllllllllllIlllIlIIIlllIIlIlIl + lllllllllllllIlllIlIIIlllIIlIllI * 3 + 0);
        final float lllllllllllllIlllIlIIIlllIIlllll = lllllllllllllIlllIlIIIlllIlIllll.get(lllllllllllllIlllIlIIIlllIIlIlIl + lllllllllllllIlllIlIIIlllIIlIllI * 3 + 1);
        final float lllllllllllllIlllIlIIIlllIIllllI = lllllllllllllIlllIlIIIlllIlIllll.get(lllllllllllllIlllIlIIIlllIIlIlIl + lllllllllllllIlllIlIIIlllIIlIllI * 3 + 2);
        final float lllllllllllllIlllIlIIIlllIIlllIl = (lllllllllllllIlllIlIIIlllIlIlIIl + lllllllllllllIlllIlIIIlllIlIIllI + lllllllllllllIlllIlIIIlllIlIIIll + lllllllllllllIlllIlIIIlllIlIIIII) * 0.25f - lllllllllllllIlllIlIIIlllIIllIIl;
        final float lllllllllllllIlllIlIIIlllIIlllII = (lllllllllllllIlllIlIIIlllIlIlIII + lllllllllllllIlllIlIIIlllIlIIlIl + lllllllllllllIlllIlIIIlllIlIIIlI + lllllllllllllIlllIlIIIlllIIlllll) * 0.25f - lllllllllllllIlllIlIIIlllIIllIII;
        final float lllllllllllllIlllIlIIIlllIIllIll = (lllllllllllllIlllIlIIIlllIlIIlll + lllllllllllllIlllIlIIIlllIlIIlII + lllllllllllllIlllIlIIIlllIlIIIIl + lllllllllllllIlllIlIIIlllIIllllI) * 0.25f - lllllllllllllIlllIlIIIlllIIlIlll;
        return lllllllllllllIlllIlIIIlllIIlllIl * lllllllllllllIlllIlIIIlllIIlllIl + lllllllllllllIlllIlIIIlllIIlllII * lllllllllllllIlllIlIIIlllIIlllII + lllllllllllllIlllIlIIIlllIIllIll * lllllllllllllIlllIlIIIlllIIllIll;
    }
    
    public void drawMultiTexture() {
        if (this.quadSprites != null) {
            final int lllllllllllllIlllIlIIIlIIIIIIlIl = Config.getMinecraft().getTextureMapBlocks().getCountRegisteredSprites();
            if (this.drawnIcons.length <= lllllllllllllIlllIlIIIlIIIIIIlIl) {
                this.drawnIcons = new boolean[lllllllllllllIlllIlIIIlIIIIIIlIl + 1];
            }
            Arrays.fill(this.drawnIcons, false);
            int lllllllllllllIlllIlIIIlIIIIIIlII = 0;
            int lllllllllllllIlllIlIIIlIIIIIIIll = -1;
            for (int lllllllllllllIlllIlIIIlIIIIIIIlI = this.vertexCount / 4, lllllllllllllIlllIlIIIlIIIIIIIIl = 0; lllllllllllllIlllIlIIIlIIIIIIIIl < lllllllllllllIlllIlIIIlIIIIIIIlI; ++lllllllllllllIlllIlIIIlIIIIIIIIl) {
                final TextureAtlasSprite lllllllllllllIlllIlIIIlIIIIIIIII = this.quadSprites[lllllllllllllIlllIlIIIlIIIIIIIIl];
                if (lllllllllllllIlllIlIIIlIIIIIIIII != null) {
                    final int lllllllllllllIlllIlIIIIlllllllll = lllllllllllllIlllIlIIIlIIIIIIIII.getIndexInMap();
                    if (!this.drawnIcons[lllllllllllllIlllIlIIIIlllllllll]) {
                        if (lllllllllllllIlllIlIIIlIIIIIIIII == TextureUtils.iconGrassSideOverlay) {
                            if (lllllllllllllIlllIlIIIlIIIIIIIll < 0) {
                                lllllllllllllIlllIlIIIlIIIIIIIll = lllllllllllllIlllIlIIIlIIIIIIIIl;
                            }
                        }
                        else {
                            lllllllllllllIlllIlIIIlIIIIIIIIl = this.drawForIcon(lllllllllllllIlllIlIIIlIIIIIIIII, lllllllllllllIlllIlIIIlIIIIIIIIl) - 1;
                            ++lllllllllllllIlllIlIIIlIIIIIIlII;
                            if (this.blockLayer != BlockRenderLayer.TRANSLUCENT) {
                                this.drawnIcons[lllllllllllllIlllIlIIIIlllllllll] = true;
                            }
                        }
                    }
                }
            }
            if (lllllllllllllIlllIlIIIlIIIIIIIll >= 0) {
                this.drawForIcon(TextureUtils.iconGrassSideOverlay, lllllllllllllIlllIlIIIlIIIIIIIll);
                ++lllllllllllllIlllIlIIIlIIIIIIlII;
            }
            if (lllllllllllllIlllIlIIIlIIIIIIlII > 0) {}
        }
    }
    
    public void putColorRGBA(final int lllllllllllllIlllIlIIIlIllIIlIII, final int lllllllllllllIlllIlIIIlIllIIIIlI, final int lllllllllllllIlllIlIIIlIllIIIIIl, final int lllllllllllllIlllIlIIIlIllIIIIII) {
        if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            this.rawIntBuffer.put(lllllllllllllIlllIlIIIlIllIIlIII, 0xFF000000 | lllllllllllllIlllIlIIIlIllIIIIII << 16 | lllllllllllllIlllIlIIIlIllIIIIIl << 8 | lllllllllllllIlllIlIIIlIllIIIIlI);
        }
        else {
            this.rawIntBuffer.put(lllllllllllllIlllIlIIIlIllIIlIII, lllllllllllllIlllIlIIIlIllIIIIlI << 24 | lllllllllllllIlllIlIIIlIllIIIIIl << 16 | lllllllllllllIlllIlIIIlIllIIIIII << 8 | 0xFF);
        }
    }
    
    private void growBuffer(int lllllllllllllIlllIlIIlIIIIIlIIII) {
        if (Config.isShaders()) {
            lllllllllllllIlllIlIIlIIIIIlIIII *= 2;
        }
        if (MathHelper.roundUp(lllllllllllllIlllIlIIlIIIIIlIIII, 4) / 4 > this.rawIntBuffer.remaining() || this.vertexCount * this.vertexFormat.getNextOffset() + lllllllllllllIlllIlIIlIIIIIlIIII > this.byteBuffer.capacity()) {
            final int lllllllllllllIlllIlIIlIIIIIlIlll = this.byteBuffer.capacity();
            final int lllllllllllllIlllIlIIlIIIIIlIllI = lllllllllllllIlllIlIIlIIIIIlIlll + MathHelper.roundUp(lllllllllllllIlllIlIIlIIIIIlIIII, 2097152);
            BufferBuilder.LOGGER.debug("Needed to grow BufferBuilder buffer: Old size {} bytes, new size {} bytes.", (Object)lllllllllllllIlllIlIIlIIIIIlIlll, (Object)lllllllllllllIlllIlIIlIIIIIlIllI);
            final int lllllllllllllIlllIlIIlIIIIIlIlIl = this.rawIntBuffer.position();
            final ByteBuffer lllllllllllllIlllIlIIlIIIIIlIlII = GLAllocation.createDirectByteBuffer(lllllllllllllIlllIlIIlIIIIIlIllI);
            this.byteBuffer.position(0);
            lllllllllllllIlllIlIIlIIIIIlIlII.put(this.byteBuffer);
            lllllllllllllIlllIlIIlIIIIIlIlII.rewind();
            this.byteBuffer = lllllllllllllIlllIlIIlIIIIIlIlII;
            this.rawFloatBuffer = this.byteBuffer.asFloatBuffer();
            this.rawIntBuffer = this.byteBuffer.asIntBuffer();
            this.rawIntBuffer.position(lllllllllllllIlllIlIIlIIIIIlIlIl);
            this.rawShortBuffer = this.byteBuffer.asShortBuffer();
            this.rawShortBuffer.position(lllllllllllllIlllIlIIlIIIIIlIlIl << 1);
            if (this.quadSprites != null) {
                final TextureAtlasSprite[] lllllllllllllIlllIlIIlIIIIIlIIll = this.quadSprites;
                final int lllllllllllllIlllIlIIlIIIIIlIIlI = this.getBufferQuadSize();
                this.quadSprites = new TextureAtlasSprite[lllllllllllllIlllIlIIlIIIIIlIIlI];
                System.arraycopy(lllllllllllllIlllIlIIlIIIIIlIIll, 0, this.quadSprites, 0, Math.min(lllllllllllllIlllIlIIlIIIIIlIIll.length, this.quadSprites.length));
                this.quadSpritesPrev = null;
            }
        }
    }
    
    public int getBufferSize() {
        return this.vertexCount * this.vertexFormat.getIntegerSize();
    }
    
    public void reset() {
        this.vertexCount = 0;
        this.vertexFormatElement = null;
        this.vertexFormatIndex = 0;
        this.quadSprite = null;
    }
    
    public double getXOffset() {
        return this.xOffset;
    }
    
    public void putPosition(final double lllllllllllllIlllIlIIIllIIlIlllI, final double lllllllllllllIlllIlIIIllIIlIllIl, final double lllllllllllllIlllIlIIIllIIlIllII) {
        final int lllllllllllllIlllIlIIIllIIllIlIl = this.vertexFormat.getIntegerSize();
        final int lllllllllllllIlllIlIIIllIIllIlII = (this.vertexCount - 4) * lllllllllllllIlllIlIIIllIIllIlIl;
        for (int lllllllllllllIlllIlIIIllIIllIIll = 0; lllllllllllllIlllIlIIIllIIllIIll < 4; ++lllllllllllllIlllIlIIIllIIllIIll) {
            final int lllllllllllllIlllIlIIIllIIllIIlI = lllllllllllllIlllIlIIIllIIllIlII + lllllllllllllIlllIlIIIllIIllIIll * lllllllllllllIlllIlIIIllIIllIlIl;
            final int lllllllllllllIlllIlIIIllIIllIIIl = lllllllllllllIlllIlIIIllIIllIIlI + 1;
            final int lllllllllllllIlllIlIIIllIIllIIII = lllllllllllllIlllIlIIIllIIllIIIl + 1;
            this.rawIntBuffer.put(lllllllllllllIlllIlIIIllIIllIIlI, Float.floatToRawIntBits((float)(lllllllllllllIlllIlIIIllIIlIlllI + this.xOffset) + Float.intBitsToFloat(this.rawIntBuffer.get(lllllllllllllIlllIlIIIllIIllIIlI))));
            this.rawIntBuffer.put(lllllllllllllIlllIlIIIllIIllIIIl, Float.floatToRawIntBits((float)(lllllllllllllIlllIlIIIllIIlIllIl + this.yOffset) + Float.intBitsToFloat(this.rawIntBuffer.get(lllllllllllllIlllIlIIIllIIllIIIl))));
            this.rawIntBuffer.put(lllllllllllllIlllIlIIIllIIllIIII, Float.floatToRawIntBits((float)(lllllllllllllIlllIlIIIllIIlIllII + this.zOffset) + Float.intBitsToFloat(this.rawIntBuffer.get(lllllllllllllIlllIlIIIllIIllIIII))));
        }
    }
    
    private int drawForIcon(final TextureAtlasSprite lllllllllllllIlllIlIIIIllllIIlIl, final int lllllllllllllIlllIlIIIIllllIIlII) {
        GL11.glBindTexture(3553, lllllllllllllIlllIlIIIIllllIIlIl.glSpriteTextureId);
        int lllllllllllllIlllIlIIIIllllIlIll = -1;
        int lllllllllllllIlllIlIIIIllllIlIlI = -1;
        final int lllllllllllllIlllIlIIIIllllIlIIl = this.vertexCount / 4;
        for (int lllllllllllllIlllIlIIIIllllIlIII = lllllllllllllIlllIlIIIIllllIIlII; lllllllllllllIlllIlIIIIllllIlIII < lllllllllllllIlllIlIIIIllllIlIIl; ++lllllllllllllIlllIlIIIIllllIlIII) {
            final TextureAtlasSprite lllllllllllllIlllIlIIIIllllIIlll = this.quadSprites[lllllllllllllIlllIlIIIIllllIlIII];
            if (lllllllllllllIlllIlIIIIllllIIlll == lllllllllllllIlllIlIIIIllllIIlIl) {
                if (lllllllllllllIlllIlIIIIllllIlIlI < 0) {
                    lllllllllllllIlllIlIIIIllllIlIlI = lllllllllllllIlllIlIIIIllllIlIII;
                }
            }
            else if (lllllllllllllIlllIlIIIIllllIlIlI >= 0) {
                this.draw(lllllllllllllIlllIlIIIIllllIlIlI, lllllllllllllIlllIlIIIIllllIlIII);
                if (this.blockLayer == BlockRenderLayer.TRANSLUCENT) {
                    return lllllllllllllIlllIlIIIIllllIlIII;
                }
                lllllllllllllIlllIlIIIIllllIlIlI = -1;
                if (lllllllllllllIlllIlIIIIllllIlIll < 0) {
                    lllllllllllllIlllIlIIIIllllIlIll = lllllllllllllIlllIlIIIIllllIlIII;
                }
            }
        }
        if (lllllllllllllIlllIlIIIIllllIlIlI >= 0) {
            this.draw(lllllllllllllIlllIlIIIIllllIlIlI, lllllllllllllIlllIlIIIIllllIlIIl);
        }
        if (lllllllllllllIlllIlIIIIllllIlIll < 0) {
            lllllllllllllIlllIlIIIIllllIlIll = lllllllllllllIlllIlIIIIllllIlIIl;
        }
        return lllllllllllllIlllIlIIIIllllIlIll;
    }
    
    public int getColorIndex(final int lllllllllllllIlllIlIIIllIIlIIIII) {
        return ((this.vertexCount - lllllllllllllIlllIlIIIllIIlIIIII) * this.vertexFormat.getNextOffset() + this.vertexFormat.getColorOffset()) / 4;
    }
    
    public boolean isDrawing() {
        return this.isDrawing;
    }
    
    private void func_192836_a(final int lllllllllllllIlllIlIIIlIllllIllI, final int lllllllllllllIlllIlIIIlIlllIlllI) {
        final int lllllllllllllIlllIlIIIlIllllIlII = this.getColorIndex(lllllllllllllIlllIlIIIlIlllIlllI);
        final int lllllllllllllIlllIlIIIlIllllIIll = lllllllllllllIlllIlIIIlIllllIllI >> 16 & 0xFF;
        final int lllllllllllllIlllIlIIIlIllllIIlI = lllllllllllllIlllIlIIIlIllllIllI >> 8 & 0xFF;
        final int lllllllllllllIlllIlIIIlIllllIIIl = lllllllllllllIlllIlIIIlIllllIllI & 0xFF;
        this.putColorRGBA(lllllllllllllIlllIlIIIlIllllIlII, lllllllllllllIlllIlIIIlIllllIIll, lllllllllllllIlllIlIIIlIllllIIlI, lllllllllllllIlllIlIIIlIllllIIIl);
    }
    
    public void endVertex() {
        ++this.vertexCount;
        this.growBuffer(this.vertexFormat.getNextOffset());
        this.vertexFormatIndex = 0;
        this.vertexFormatElement = this.vertexFormat.getElement(this.vertexFormatIndex);
        if (Config.isShaders()) {
            SVertexBuilder.endAddVertex(this);
        }
    }
    
    public BufferBuilder pos(final double lllllllllllllIlllIlIIIlIlIIIIlll, final double lllllllllllllIlllIlIIIlIlIIIIllI, final double lllllllllllllIlllIlIIIlIlIIIIlIl) {
        if (Config.isShaders()) {
            SVertexBuilder.beginAddVertex(this);
        }
        final int lllllllllllllIlllIlIIIlIlIIIlIIl = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType()[this.vertexFormatElement.getType().ordinal()]) {
            case 1: {
                this.byteBuffer.putFloat(lllllllllllllIlllIlIIIlIlIIIlIIl, (float)(lllllllllllllIlllIlIIIlIlIIIIlll + this.xOffset));
                this.byteBuffer.putFloat(lllllllllllllIlllIlIIIlIlIIIlIIl + 4, (float)(lllllllllllllIlllIlIIIlIlIIIIllI + this.yOffset));
                this.byteBuffer.putFloat(lllllllllllllIlllIlIIIlIlIIIlIIl + 8, (float)(lllllllllllllIlllIlIIIlIlIIIIlIl + this.zOffset));
                break;
            }
            case 6:
            case 7: {
                this.byteBuffer.putInt(lllllllllllllIlllIlIIIlIlIIIlIIl, Float.floatToRawIntBits((float)(lllllllllllllIlllIlIIIlIlIIIIlll + this.xOffset)));
                this.byteBuffer.putInt(lllllllllllllIlllIlIIIlIlIIIlIIl + 4, Float.floatToRawIntBits((float)(lllllllllllllIlllIlIIIlIlIIIIllI + this.yOffset)));
                this.byteBuffer.putInt(lllllllllllllIlllIlIIIlIlIIIlIIl + 8, Float.floatToRawIntBits((float)(lllllllllllllIlllIlIIIlIlIIIIlIl + this.zOffset)));
                break;
            }
            case 4:
            case 5: {
                this.byteBuffer.putShort(lllllllllllllIlllIlIIIlIlIIIlIIl, (short)(lllllllllllllIlllIlIIIlIlIIIIlll + this.xOffset));
                this.byteBuffer.putShort(lllllllllllllIlllIlIIIlIlIIIlIIl + 2, (short)(lllllllllllllIlllIlIIIlIlIIIIllI + this.yOffset));
                this.byteBuffer.putShort(lllllllllllllIlllIlIIIlIlIIIlIIl + 4, (short)(lllllllllllllIlllIlIIIlIlIIIIlIl + this.zOffset));
                break;
            }
            case 2:
            case 3: {
                this.byteBuffer.put(lllllllllllllIlllIlIIIlIlIIIlIIl, (byte)(lllllllllllllIlllIlIIIlIlIIIIlll + this.xOffset));
                this.byteBuffer.put(lllllllllllllIlllIlIIIlIlIIIlIIl + 1, (byte)(lllllllllllllIlllIlIIIlIlIIIIllI + this.yOffset));
                this.byteBuffer.put(lllllllllllllIlllIlIIIlIlIIIlIIl + 2, (byte)(lllllllllllllIlllIlIIIlIlIIIIlIl + this.zOffset));
                break;
            }
        }
        this.nextVertexFormatIndex();
        return this;
    }
    
    public void sortVertexData(final float lllllllllllllIlllIlIIIlllllIIlII, final float lllllllllllllIlllIlIIIlllllllIII, final float lllllllllllllIlllIlIIIlllllIIIlI) {
        final int lllllllllllllIlllIlIIIllllllIllI = this.vertexCount / 4;
        final float[] lllllllllllllIlllIlIIIllllllIlIl = new float[lllllllllllllIlllIlIIIllllllIllI];
        for (int lllllllllllllIlllIlIIIllllllIlII = 0; lllllllllllllIlllIlIIIllllllIlII < lllllllllllllIlllIlIIIllllllIllI; ++lllllllllllllIlllIlIIIllllllIlII) {
            lllllllllllllIlllIlIIIllllllIlIl[lllllllllllllIlllIlIIIllllllIlII] = getDistanceSq(this.rawFloatBuffer, (float)(lllllllllllllIlllIlIIIlllllIIlII + this.xOffset), (float)(lllllllllllllIlllIlIIIlllllllIII + this.yOffset), (float)(lllllllllllllIlllIlIIIlllllIIIlI + this.zOffset), this.vertexFormat.getIntegerSize(), lllllllllllllIlllIlIIIllllllIlII * this.vertexFormat.getNextOffset());
        }
        final Integer[] lllllllllllllIlllIlIIIllllllIIll = new Integer[lllllllllllllIlllIlIIIllllllIllI];
        for (int lllllllllllllIlllIlIIIllllllIIlI = 0; lllllllllllllIlllIlIIIllllllIIlI < lllllllllllllIlllIlIIIllllllIIll.length; ++lllllllllllllIlllIlIIIllllllIIlI) {
            lllllllllllllIlllIlIIIllllllIIll[lllllllllllllIlllIlIIIllllllIIlI] = lllllllllllllIlllIlIIIllllllIIlI;
        }
        Arrays.sort(lllllllllllllIlllIlIIIllllllIIll, new Comparator<Integer>() {
            @Override
            public int compare(final Integer llllllllllllllIlIIIllIlIIIlIlIll, final Integer llllllllllllllIlIIIllIlIIIlIlIlI) {
                return Floats.compare(lllllllllllllIlllIlIIIllllllIlIl[llllllllllllllIlIIIllIlIIIlIlIlI], lllllllllllllIlllIlIIIllllllIlIl[llllllllllllllIlIIIllIlIIIlIlIll]);
            }
        });
        final BitSet lllllllllllllIlllIlIIIllllllIIIl = new BitSet();
        final int lllllllllllllIlllIlIIIllllllIIII = this.vertexFormat.getNextOffset();
        final int[] lllllllllllllIlllIlIIIlllllIllll = new int[lllllllllllllIlllIlIIIllllllIIII];
        for (int lllllllllllllIlllIlIIIlllllIlllI = lllllllllllllIlllIlIIIllllllIIIl.nextClearBit(0); lllllllllllllIlllIlIIIlllllIlllI < lllllllllllllIlllIlIIIllllllIIll.length; lllllllllllllIlllIlIIIlllllIlllI = lllllllllllllIlllIlIIIllllllIIIl.nextClearBit(lllllllllllllIlllIlIIIlllllIlllI + 1)) {
            final int lllllllllllllIlllIlIIIlllllIllIl = lllllllllllllIlllIlIIIllllllIIll[lllllllllllllIlllIlIIIlllllIlllI];
            if (lllllllllllllIlllIlIIIlllllIllIl != lllllllllllllIlllIlIIIlllllIlllI) {
                this.rawIntBuffer.limit(lllllllllllllIlllIlIIIlllllIllIl * lllllllllllllIlllIlIIIllllllIIII + lllllllllllllIlllIlIIIllllllIIII);
                this.rawIntBuffer.position(lllllllllllllIlllIlIIIlllllIllIl * lllllllllllllIlllIlIIIllllllIIII);
                this.rawIntBuffer.get(lllllllllllllIlllIlIIIlllllIllll);
                for (int lllllllllllllIlllIlIIIlllllIllII = lllllllllllllIlllIlIIIlllllIllIl, lllllllllllllIlllIlIIIlllllIlIll = lllllllllllllIlllIlIIIllllllIIll[lllllllllllllIlllIlIIIlllllIllIl]; lllllllllllllIlllIlIIIlllllIllII != lllllllllllllIlllIlIIIlllllIlllI; lllllllllllllIlllIlIIIlllllIllII = lllllllllllllIlllIlIIIlllllIlIll, lllllllllllllIlllIlIIIlllllIlIll = lllllllllllllIlllIlIIIllllllIIll[lllllllllllllIlllIlIIIlllllIlIll]) {
                    this.rawIntBuffer.limit(lllllllllllllIlllIlIIIlllllIlIll * lllllllllllllIlllIlIIIllllllIIII + lllllllllllllIlllIlIIIllllllIIII);
                    this.rawIntBuffer.position(lllllllllllllIlllIlIIIlllllIlIll * lllllllllllllIlllIlIIIllllllIIII);
                    final IntBuffer lllllllllllllIlllIlIIIlllllIlIlI = this.rawIntBuffer.slice();
                    this.rawIntBuffer.limit(lllllllllllllIlllIlIIIlllllIllII * lllllllllllllIlllIlIIIllllllIIII + lllllllllllllIlllIlIIIllllllIIII);
                    this.rawIntBuffer.position(lllllllllllllIlllIlIIIlllllIllII * lllllllllllllIlllIlIIIllllllIIII);
                    this.rawIntBuffer.put(lllllllllllllIlllIlIIIlllllIlIlI);
                    lllllllllllllIlllIlIIIllllllIIIl.set(lllllllllllllIlllIlIIIlllllIllII);
                }
                this.rawIntBuffer.limit(lllllllllllllIlllIlIIIlllllIlllI * lllllllllllllIlllIlIIIllllllIIII + lllllllllllllIlllIlIIIllllllIIII);
                this.rawIntBuffer.position(lllllllllllllIlllIlIIIlllllIlllI * lllllllllllllIlllIlIIIllllllIIII);
                this.rawIntBuffer.put(lllllllllllllIlllIlIIIlllllIllll);
            }
            lllllllllllllIlllIlIIIllllllIIIl.set(lllllllllllllIlllIlIIIlllllIlllI);
        }
        this.rawIntBuffer.limit(this.rawIntBuffer.capacity());
        this.rawIntBuffer.position(this.getBufferSize());
        if (this.quadSprites != null) {
            final TextureAtlasSprite[] lllllllllllllIlllIlIIIlllllIlIIl = new TextureAtlasSprite[this.vertexCount / 4];
            final int lllllllllllllIlllIlIIIlllllIlIII = this.vertexFormat.getNextOffset() / 4 * 4;
            for (int lllllllllllllIlllIlIIIlllllIIlll = 0; lllllllllllllIlllIlIIIlllllIIlll < lllllllllllllIlllIlIIIllllllIIll.length; ++lllllllllllllIlllIlIIIlllllIIlll) {
                final int lllllllllllllIlllIlIIIlllllIIllI = lllllllllllllIlllIlIIIllllllIIll[lllllllllllllIlllIlIIIlllllIIlll];
                lllllllllllllIlllIlIIIlllllIlIIl[lllllllllllllIlllIlIIIlllllIIlll] = this.quadSprites[lllllllllllllIlllIlIIIlllllIIllI];
            }
            System.arraycopy(lllllllllllllIlllIlIIIlllllIlIIl, 0, this.quadSprites, 0, lllllllllllllIlllIlIIIlllllIlIIl.length);
        }
    }
    
    public void addVertexData(final int[] lllllllllllllIlllIlIIIlIlIIlIllI) {
        if (Config.isShaders()) {
            SVertexBuilder.beginAddVertexData(this, lllllllllllllIlllIlIIIlIlIIlIllI);
        }
        this.growBuffer(lllllllllllllIlllIlIIIlIlIIlIllI.length * 4);
        this.rawIntBuffer.position(this.getBufferSize());
        this.rawIntBuffer.put(lllllllllllllIlllIlIIIlIlIIlIllI);
        this.vertexCount += lllllllllllllIlllIlIIIlIlIIlIllI.length / this.vertexFormat.getIntegerSize();
        if (Config.isShaders()) {
            SVertexBuilder.endAddVertexData(this);
        }
    }
    
    public BufferBuilder lightmap(final int lllllllllllllIlllIlIIIllIlIllIll, final int lllllllllllllIlllIlIIIllIlIllllI) {
        final int lllllllllllllIlllIlIIIllIlIlllIl = this.vertexCount * this.vertexFormat.getNextOffset() + this.vertexFormat.getOffset(this.vertexFormatIndex);
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType()[this.vertexFormatElement.getType().ordinal()]) {
            case 1: {
                this.byteBuffer.putFloat(lllllllllllllIlllIlIIIllIlIlllIl, (float)lllllllllllllIlllIlIIIllIlIllIll);
                this.byteBuffer.putFloat(lllllllllllllIlllIlIIIllIlIlllIl + 4, (float)lllllllllllllIlllIlIIIllIlIllllI);
                break;
            }
            case 6:
            case 7: {
                this.byteBuffer.putInt(lllllllllllllIlllIlIIIllIlIlllIl, lllllllllllllIlllIlIIIllIlIllIll);
                this.byteBuffer.putInt(lllllllllllllIlllIlIIIllIlIlllIl + 4, lllllllllllllIlllIlIIIllIlIllllI);
                break;
            }
            case 4:
            case 5: {
                this.byteBuffer.putShort(lllllllllllllIlllIlIIIllIlIlllIl, (short)lllllllllllllIlllIlIIIllIlIllllI);
                this.byteBuffer.putShort(lllllllllllllIlllIlIIIllIlIlllIl + 2, (short)lllllllllllllIlllIlIIIllIlIllIll);
                break;
            }
            case 2:
            case 3: {
                this.byteBuffer.put(lllllllllllllIlllIlIIIllIlIlllIl, (byte)lllllllllllllIlllIlIIIllIlIllllI);
                this.byteBuffer.put(lllllllllllllIlllIlIIIllIlIlllIl + 1, (byte)lllllllllllllIlllIlIIIllIlIllIll);
                break;
            }
        }
        this.nextVertexFormatIndex();
        return this;
    }
    
    public void setBlockLayer(final BlockRenderLayer lllllllllllllIlllIlIIIIlllIIlIIl) {
        this.blockLayer = lllllllllllllIlllIlIIIIlllIIlIIl;
        if (lllllllllllllIlllIlIIIIlllIIlIIl == null) {
            if (this.quadSprites != null) {
                this.quadSpritesPrev = this.quadSprites;
            }
            this.quadSprites = null;
            this.quadSprite = null;
        }
    }
    
    public void finishDrawing() {
        if (!this.isDrawing) {
            throw new IllegalStateException("Not building!");
        }
        this.isDrawing = false;
        this.byteBuffer.position(0);
        this.byteBuffer.limit(this.getBufferSize() * 4);
    }
    
    public BufferBuilder(int lllllllllllllIlllIlIIlIIIIlIIIlI) {
        this.blockLayer = null;
        this.drawnIcons = new boolean[256];
        this.quadSprites = null;
        this.quadSpritesPrev = null;
        this.quadSprite = null;
        this.renderEnv = null;
        if (Config.isShaders()) {
            lllllllllllllIlllIlIIlIIIIlIIIlI *= 2;
        }
        this.byteBuffer = GLAllocation.createDirectByteBuffer((int)(lllllllllllllIlllIlIIlIIIIlIIIlI * 4));
        this.rawIntBuffer = this.byteBuffer.asIntBuffer();
        this.rawShortBuffer = this.byteBuffer.asShortBuffer();
        this.rawFloatBuffer = this.byteBuffer.asFloatBuffer();
        SVertexBuilder.initVertexBuilder(this);
    }
    
    public void putColorMultiplier(final float lllllllllllllIlllIlIIIllIIIIIlll, final float lllllllllllllIlllIlIIIllIIIlIIll, final float lllllllllllllIlllIlIIIllIIIIIlIl, final int lllllllllllllIlllIlIIIllIIIIIlII) {
        final int lllllllllllllIlllIlIIIllIIIlIIII = this.getColorIndex(lllllllllllllIlllIlIIIllIIIIIlII);
        int lllllllllllllIlllIlIIIllIIIIllll = -1;
        if (!this.noColor) {
            lllllllllllllIlllIlIIIllIIIIllll = this.rawIntBuffer.get(lllllllllllllIlllIlIIIllIIIlIIII);
            if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
                final int lllllllllllllIlllIlIIIllIIIIlllI = (int)((lllllllllllllIlllIlIIIllIIIIllll & 0xFF) * lllllllllllllIlllIlIIIllIIIIIlll);
                final int lllllllllllllIlllIlIIIllIIIIllIl = (int)((lllllllllllllIlllIlIIIllIIIIllll >> 8 & 0xFF) * lllllllllllllIlllIlIIIllIIIlIIll);
                final int lllllllllllllIlllIlIIIllIIIIllII = (int)((lllllllllllllIlllIlIIIllIIIIllll >> 16 & 0xFF) * lllllllllllllIlllIlIIIllIIIIIlIl);
                lllllllllllllIlllIlIIIllIIIIllll &= 0xFF000000;
                lllllllllllllIlllIlIIIllIIIIllll = (lllllllllllllIlllIlIIIllIIIIllll | lllllllllllllIlllIlIIIllIIIIllII << 16 | lllllllllllllIlllIlIIIllIIIIllIl << 8 | lllllllllllllIlllIlIIIllIIIIlllI);
            }
            else {
                final int lllllllllllllIlllIlIIIllIIIIlIll = (int)((lllllllllllllIlllIlIIIllIIIIllll >> 24 & 0xFF) * lllllllllllllIlllIlIIIllIIIIIlll);
                final int lllllllllllllIlllIlIIIllIIIIlIlI = (int)((lllllllllllllIlllIlIIIllIIIIllll >> 16 & 0xFF) * lllllllllllllIlllIlIIIllIIIlIIll);
                final int lllllllllllllIlllIlIIIllIIIIlIIl = (int)((lllllllllllllIlllIlIIIllIIIIllll >> 8 & 0xFF) * lllllllllllllIlllIlIIIllIIIIIlIl);
                lllllllllllllIlllIlIIIllIIIIllll &= 0xFF;
                lllllllllllllIlllIlIIIllIIIIllll = (lllllllllllllIlllIlIIIllIIIIllll | lllllllllllllIlllIlIIIllIIIIlIll << 24 | lllllllllllllIlllIlIIIllIIIIlIlI << 16 | lllllllllllllIlllIlIIIllIIIIlIIl << 8);
            }
        }
        this.rawIntBuffer.put(lllllllllllllIlllIlIIIllIIIlIIII, lllllllllllllIlllIlIIIllIIIIllll);
    }
    
    public void putNormal(final float lllllllllllllIlllIlIIIlIIllIlllI, final float lllllllllllllIlllIlIIIlIIlllIlll, final float lllllllllllllIlllIlIIIlIIllIllII) {
        final int lllllllllllllIlllIlIIIlIIlllIlIl = (byte)(lllllllllllllIlllIlIIIlIIllIlllI * 127.0f) & 0xFF;
        final int lllllllllllllIlllIlIIIlIIlllIlII = (byte)(lllllllllllllIlllIlIIIlIIlllIlll * 127.0f) & 0xFF;
        final int lllllllllllllIlllIlIIIlIIlllIIll = (byte)(lllllllllllllIlllIlIIIlIIllIllII * 127.0f) & 0xFF;
        final int lllllllllllllIlllIlIIIlIIlllIIlI = lllllllllllllIlllIlIIIlIIlllIlIl | lllllllllllllIlllIlIIIlIIlllIlII << 8 | lllllllllllllIlllIlIIIlIIlllIIll << 16;
        final int lllllllllllllIlllIlIIIlIIlllIIIl = this.vertexFormat.getNextOffset() >> 2;
        final int lllllllllllllIlllIlIIIlIIlllIIII = (this.vertexCount - 4) * lllllllllllllIlllIlIIIlIIlllIIIl + this.vertexFormat.getNormalOffset() / 4;
        this.rawIntBuffer.put(lllllllllllllIlllIlIIIlIIlllIIII, lllllllllllllIlllIlIIIlIIlllIIlI);
        this.rawIntBuffer.put(lllllllllllllIlllIlIIIlIIlllIIII + lllllllllllllIlllIlIIIlIIlllIIIl, lllllllllllllIlllIlIIIlIIlllIIlI);
        this.rawIntBuffer.put(lllllllllllllIlllIlIIIlIIlllIIII + lllllllllllllIlllIlIIIlIIlllIIIl * 2, lllllllllllllIlllIlIIIlIIlllIIlI);
        this.rawIntBuffer.put(lllllllllllllIlllIlIIIlIIlllIIII + lllllllllllllIlllIlIIIlIIlllIIIl * 3, lllllllllllllIlllIlIIIlIIlllIIlI);
    }
    
    public boolean isMultiTexture() {
        return this.quadSprites != null;
    }
    
    public void putColorRGB_F4(final float lllllllllllllIlllIlIIIlIIIlIIlII, final float lllllllllllllIlllIlIIIlIIIlIlIII, final float lllllllllllllIlllIlIIIlIIIlIIIlI) {
        for (int lllllllllllllIlllIlIIIlIIIlIIllI = 0; lllllllllllllIlllIlIIIlIIIlIIllI < 4; ++lllllllllllllIlllIlIIIlIIIlIIllI) {
            this.putColorRGB_F(lllllllllllllIlllIlIIIlIIIlIIlII, lllllllllllllIlllIlIIIlIIIlIlIII, lllllllllllllIlllIlIIIlIIIlIIIlI, lllllllllllllIlllIlIIIlIIIlIIllI + 1);
        }
    }
    
    public void setVertexState(final State lllllllllllllIlllIlIIIllIllllllI) {
        this.rawIntBuffer.clear();
        this.growBuffer(lllllllllllllIlllIlIIIllIllllllI.getRawBuffer().length * 4);
        this.rawIntBuffer.put(lllllllllllllIlllIlIIIllIllllllI.getRawBuffer());
        this.vertexCount = lllllllllllllIlllIlIIIllIllllllI.getVertexCount();
        this.vertexFormat = new VertexFormat(lllllllllllllIlllIlIIIllIllllllI.getVertexFormat());
        if (lllllllllllllIlllIlIIIllIllllllI.stateQuadSprites != null) {
            if (this.quadSprites == null) {
                this.quadSprites = this.quadSpritesPrev;
            }
            if (this.quadSprites == null || this.quadSprites.length < this.getBufferQuadSize()) {
                this.quadSprites = new TextureAtlasSprite[this.getBufferQuadSize()];
            }
            final TextureAtlasSprite[] lllllllllllllIlllIlIIIlllIIIIIII = lllllllllllllIlllIlIIIllIllllllI.stateQuadSprites;
            System.arraycopy(lllllllllllllIlllIlIIIlllIIIIIII, 0, this.quadSprites, 0, lllllllllllllIlllIlIIIlllIIIIIII.length);
        }
        else {
            if (this.quadSprites != null) {
                this.quadSpritesPrev = this.quadSprites;
            }
            this.quadSprites = null;
        }
    }
    
    public RenderEnv getRenderEnv(final IBlockAccess lllllllllllllIlllIlIIIIllIllIlll, final IBlockState lllllllllllllIlllIlIIIIllIllIllI, final BlockPos lllllllllllllIlllIlIIIIllIlllIIl) {
        if (this.renderEnv == null) {
            this.renderEnv = new RenderEnv(lllllllllllllIlllIlIIIIllIllIlll, lllllllllllllIlllIlIIIIllIllIllI, lllllllllllllIlllIlIIIIllIlllIIl);
            return this.renderEnv;
        }
        this.renderEnv.reset(lllllllllllllIlllIlIIIIllIllIlll, lllllllllllllIlllIlIIIIllIllIllI, lllllllllllllIlllIlIIIIllIlllIIl);
        return this.renderEnv;
    }
    
    private void draw(final int lllllllllllllIlllIlIIIIlllIlIIIl, final int lllllllllllllIlllIlIIIIlllIlIIII) {
        final int lllllllllllllIlllIlIIIIlllIlIlIl = lllllllllllllIlllIlIIIIlllIlIIII - lllllllllllllIlllIlIIIIlllIlIIIl;
        if (lllllllllllllIlllIlIIIIlllIlIlIl > 0) {
            final int lllllllllllllIlllIlIIIIlllIlIlII = lllllllllllllIlllIlIIIIlllIlIIIl * 4;
            final int lllllllllllllIlllIlIIIIlllIlIIll = lllllllllllllIlllIlIIIIlllIlIlIl * 4;
            GL11.glDrawArrays(this.drawMode, lllllllllllllIlllIlIIIIlllIlIlII, lllllllllllllIlllIlIIIIlllIlIIll);
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType() {
        final int[] $switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType = BufferBuilder.$SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType;
        if ($switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType != null) {
            return $switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType;
        }
        final short lllllllllllllIlllIlIIIIllIIlIIlI = (Object)new int[VertexFormatElement.EnumType.values().length];
        try {
            lllllllllllllIlllIlIIIIllIIlIIlI[VertexFormatElement.EnumType.BYTE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlllIlIIIIllIIlIIlI[VertexFormatElement.EnumType.FLOAT.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlllIlIIIIllIIlIIlI[VertexFormatElement.EnumType.INT.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlllIlIIIIllIIlIIlI[VertexFormatElement.EnumType.SHORT.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIlllIlIIIIllIIlIIlI[VertexFormatElement.EnumType.UBYTE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIlllIlIIIIllIIlIIlI[VertexFormatElement.EnumType.UINT.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllllIlllIlIIIIllIIlIIlI[VertexFormatElement.EnumType.USHORT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        return BufferBuilder.$SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumType = (int[])(Object)lllllllllllllIlllIlIIIIllIIlIIlI;
    }
    
    private int getBufferQuadSize() {
        final int lllllllllllllIlllIlIIIIlllIIIIll = this.rawIntBuffer.capacity() * 4 / (this.vertexFormat.getIntegerSize() * 4);
        return lllllllllllllIlllIlIIIIlllIIIIll;
    }
    
    public void putColorRGB_F(final float lllllllllllllIlllIlIIIlIllIlIllI, final float lllllllllllllIlllIlIIIlIllIlIlIl, final float lllllllllllllIlllIlIIIlIllIlIlII, final int lllllllllllllIlllIlIIIlIllIlIIll) {
        final int lllllllllllllIlllIlIIIlIllIllIll = this.getColorIndex(lllllllllllllIlllIlIIIlIllIlIIll);
        final int lllllllllllllIlllIlIIIlIllIllIlI = MathHelper.clamp((int)(lllllllllllllIlllIlIIIlIllIlIllI * 255.0f), 0, 255);
        final int lllllllllllllIlllIlIIIlIllIllIIl = MathHelper.clamp((int)(lllllllllllllIlllIlIIIlIllIlIlIl * 255.0f), 0, 255);
        final int lllllllllllllIlllIlIIIlIllIllIII = MathHelper.clamp((int)(lllllllllllllIlllIlIIIlIllIlIlII * 255.0f), 0, 255);
        this.putColorRGBA(lllllllllllllIlllIlIIIlIllIllIll, lllllllllllllIlllIlIIIlIllIllIlI, lllllllllllllIlllIlIIIlIllIllIIl, lllllllllllllIlllIlIIIlIllIllIII);
    }
    
    public int getDrawMode() {
        return this.drawMode;
    }
    
    public void putBrightness4(final int lllllllllllllIlllIlIIIllIlIlIIII, final int lllllllllllllIlllIlIIIllIlIIlIII, final int lllllllllllllIlllIlIIIllIlIIIlll, final int lllllllllllllIlllIlIIIllIlIIIllI) {
        final int lllllllllllllIlllIlIIIllIlIIllII = (this.vertexCount - 4) * this.vertexFormat.getIntegerSize() + this.vertexFormat.getUvOffsetById(1) / 4;
        final int lllllllllllllIlllIlIIIllIlIIlIll = this.vertexFormat.getNextOffset() >> 2;
        this.rawIntBuffer.put(lllllllllllllIlllIlIIIllIlIIllII, lllllllllllllIlllIlIIIllIlIlIIII);
        this.rawIntBuffer.put(lllllllllllllIlllIlIIIllIlIIllII + lllllllllllllIlllIlIIIllIlIIlIll, lllllllllllllIlllIlIIIllIlIIlIII);
        this.rawIntBuffer.put(lllllllllllllIlllIlIIIllIlIIllII + lllllllllllllIlllIlIIIllIlIIlIll * 2, lllllllllllllIlllIlIIIllIlIIIlll);
        this.rawIntBuffer.put(lllllllllllllIlllIlIIIllIlIIllII + lllllllllllllIlllIlIIIllIlIIlIll * 3, lllllllllllllIlllIlIIIllIlIIIllI);
    }
    
    public BufferBuilder color(final float lllllllllllllIlllIlIIIlIlIllIllI, final float lllllllllllllIlllIlIIIlIlIllIIII, final float lllllllllllllIlllIlIIIlIlIllIlII, final float lllllllllllllIlllIlIIIlIlIllIIll) {
        return this.color((int)(lllllllllllllIlllIlIIIlIlIllIllI * 255.0f), (int)(lllllllllllllIlllIlIIIlIlIllIIII * 255.0f), (int)(lllllllllllllIlllIlIIIlIlIllIlII * 255.0f), (int)(lllllllllllllIlllIlIIIlIlIllIIll * 255.0f));
    }
    
    public int getVertexCount() {
        return this.vertexCount;
    }
    
    public void putSprite(final TextureAtlasSprite lllllllllllllIlllIlIIIlIIIIlllII) {
        if (this.quadSprites != null) {
            final int lllllllllllllIlllIlIIIlIIIIllIll = this.vertexCount / 4;
            this.quadSprites[lllllllllllllIlllIlIIIlIIIIllIll - 1] = lllllllllllllIlllIlIIIlIIIIlllII;
        }
    }
    
    public void begin(final int lllllllllllllIlllIlIIIllIlllIlIl, final VertexFormat lllllllllllllIlllIlIIIllIlllIlII) {
        if (this.isDrawing) {
            throw new IllegalStateException("Already building!");
        }
        this.isDrawing = true;
        this.reset();
        this.drawMode = lllllllllllllIlllIlIIIllIlllIlIl;
        this.vertexFormat = lllllllllllllIlllIlIIIllIlllIlII;
        this.vertexFormatElement = lllllllllllllIlllIlIIIllIlllIlII.getElement(this.vertexFormatIndex);
        this.noColor = false;
        this.byteBuffer.limit(this.byteBuffer.capacity());
        if (Config.isShaders()) {
            SVertexBuilder.endSetVertexFormat(this);
        }
        if (Config.isMultiTexture()) {
            if (this.blockLayer != null) {
                if (this.quadSprites == null) {
                    this.quadSprites = this.quadSpritesPrev;
                }
                if (this.quadSprites == null || this.quadSprites.length < this.getBufferQuadSize()) {
                    this.quadSprites = new TextureAtlasSprite[this.getBufferQuadSize()];
                }
            }
        }
        else {
            if (this.quadSprites != null) {
                this.quadSpritesPrev = this.quadSprites;
            }
            this.quadSprites = null;
        }
    }
    
    public class State
    {
        private final /* synthetic */ int[] stateRawBuffer;
        private final /* synthetic */ VertexFormat stateVertexFormat;
        private /* synthetic */ TextureAtlasSprite[] stateQuadSprites;
        
        public int[] getRawBuffer() {
            return this.stateRawBuffer;
        }
        
        public int getVertexCount() {
            return this.stateRawBuffer.length / this.stateVertexFormat.getIntegerSize();
        }
        
        public State(final int[] llllllllllllIllllllllIlIlIllllII, final VertexFormat llllllllllllIllllllllIlIlIlllIll, final TextureAtlasSprite[] llllllllllllIllllllllIlIlIlllIlI) {
            this.stateRawBuffer = llllllllllllIllllllllIlIlIllllII;
            this.stateVertexFormat = llllllllllllIllllllllIlIlIlllIll;
            this.stateQuadSprites = llllllllllllIllllllllIlIlIlllIlI;
        }
        
        public State(final int[] llllllllllllIllllllllIlIlIlIllll, final VertexFormat llllllllllllIllllllllIlIlIlIlllI) {
            this.stateRawBuffer = llllllllllllIllllllllIlIlIlIllll;
            this.stateVertexFormat = llllllllllllIllllllllIlIlIlIlllI;
        }
        
        public VertexFormat getVertexFormat() {
            return this.stateVertexFormat;
        }
    }
}
