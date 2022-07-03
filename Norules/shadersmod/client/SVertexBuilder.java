package shadersmod.client;

import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.vertex.*;
import java.nio.*;

public class SVertexBuilder
{
    /* synthetic */ boolean hasNormal;
    /* synthetic */ boolean hasTangent;
    /* synthetic */ boolean hasUV;
    /* synthetic */ int offsetUVCenter;
    /* synthetic */ long[] entityData;
    /* synthetic */ int offsetNormal;
    /* synthetic */ int entityDataIndex;
    /* synthetic */ int vertexSize;
    /* synthetic */ int offsetUV;
    
    public static void beginAddVertexData(final BufferBuilder lllllllllllllIIIIlIlIIllIllIIIlI, final int[] lllllllllllllIIIIlIlIIllIllIIIIl) {
        if (lllllllllllllIIIIlIlIIllIllIIIlI.vertexCount == 0) {
            endSetVertexFormat(lllllllllllllIIIIlIlIIllIllIIIlI);
        }
        final SVertexBuilder lllllllllllllIIIIlIlIIllIllIIlIl = lllllllllllllIIIIlIlIIllIllIIIlI.sVertexBuilder;
        if (lllllllllllllIIIIlIlIIllIllIIlIl.vertexSize == 14) {
            final long lllllllllllllIIIIlIlIIllIllIIlII = lllllllllllllIIIIlIlIIllIllIIlIl.entityData[lllllllllllllIIIIlIlIIllIllIIlIl.entityDataIndex];
            for (int lllllllllllllIIIIlIlIIllIllIIIll = 12; lllllllllllllIIIIlIlIIllIllIIIll + 1 < lllllllllllllIIIIlIlIIllIllIIIIl.length; lllllllllllllIIIIlIlIIllIllIIIll += 14) {
                lllllllllllllIIIIlIlIIllIllIIIIl[lllllllllllllIIIIlIlIIllIllIIIll] = (int)lllllllllllllIIIIlIlIIllIllIIlII;
                lllllllllllllIIIIlIlIIllIllIIIIl[lllllllllllllIIIIlIlIIllIllIIIll + 1] = (int)(lllllllllllllIIIIlIlIIllIllIIlII >> 32);
            }
        }
    }
    
    public static void pushEntity(final IBlockState lllllllllllllIIIIlIlIIlllIlIIIlI, final BlockPos lllllllllllllIIIIlIlIIlllIlIIIIl, final IBlockAccess lllllllllllllIIIIlIlIIlllIlIIIII, final BufferBuilder lllllllllllllIIIIlIlIIlllIIlllll) {
        final Block lllllllllllllIIIIlIlIIlllIIllllI = lllllllllllllIIIIlIlIIlllIlIIIlI.getBlock();
        int lllllllllllllIIIIlIlIIlllIIlllII = 0;
        int lllllllllllllIIIIlIlIIlllIIllIlI = 0;
        if (lllllllllllllIIIIlIlIIlllIlIIIlI instanceof BlockStateBase) {
            final BlockStateBase lllllllllllllIIIIlIlIIlllIIllIIl = (BlockStateBase)lllllllllllllIIIIlIlIIlllIlIIIlI;
            final int lllllllllllllIIIIlIlIIlllIIlllIl = lllllllllllllIIIIlIlIIlllIIllIIl.getBlockId();
            final int lllllllllllllIIIIlIlIIlllIIllIll = lllllllllllllIIIIlIlIIlllIIllIIl.getMetadata();
        }
        else {
            lllllllllllllIIIIlIlIIlllIIlllII = Block.getIdFromBlock(lllllllllllllIIIIlIlIIlllIIllllI);
            lllllllllllllIIIIlIlIIlllIIllIlI = lllllllllllllIIIIlIlIIlllIIllllI.getMetaFromState(lllllllllllllIIIIlIlIIlllIlIIIlI);
        }
        lllllllllllllIIIIlIlIIlllIIlllII = BlockAliases.getMappedBlockId(lllllllllllllIIIIlIlIIlllIIlllII, lllllllllllllIIIIlIlIIlllIIllIlI);
        final int lllllllllllllIIIIlIlIIlllIIllIII = lllllllllllllIIIIlIlIIlllIIllllI.getRenderType(lllllllllllllIIIIlIlIIlllIlIIIlI).ordinal();
        final int lllllllllllllIIIIlIlIIlllIIlIlll = ((lllllllllllllIIIIlIlIIlllIIllIII & 0xFFFF) << 16) + (lllllllllllllIIIIlIlIIlllIIlllII & 0xFFFF);
        final int lllllllllllllIIIIlIlIIlllIIlIllI = lllllllllllllIIIIlIlIIlllIIllIlI & 0xFFFF;
        lllllllllllllIIIIlIlIIlllIIlllll.sVertexBuilder.pushEntity(((long)lllllllllllllIIIIlIlIIlllIIlIllI << 32) + lllllllllllllIIIIlIlIIlllIIlIlll);
    }
    
    public static void endAddVertexData(final BufferBuilder lllllllllllllIIIIlIlIIllIlIllIll) {
        final SVertexBuilder lllllllllllllIIIIlIlIIllIlIllIlI = lllllllllllllIIIIlIlIIllIlIllIll.sVertexBuilder;
        if (lllllllllllllIIIIlIlIIllIlIllIlI.vertexSize == 14 && lllllllllllllIIIIlIlIIllIlIllIll.drawMode == 7 && lllllllllllllIIIIlIlIIllIlIllIll.vertexCount % 4 == 0) {
            lllllllllllllIIIIlIlIIllIlIllIlI.calcNormal(lllllllllllllIIIIlIlIIllIlIllIll, lllllllllllllIIIIlIlIIllIlIllIll.getBufferSize() - 4 * lllllllllllllIIIIlIlIIllIlIllIlI.vertexSize);
        }
    }
    
    public void pushEntity(final long lllllllllllllIIIIlIlIIlllIlIlllI) {
        ++this.entityDataIndex;
        this.entityData[this.entityDataIndex] = lllllllllllllIIIIlIlIIlllIlIlllI;
    }
    
    public void popEntity() {
        this.entityData[this.entityDataIndex] = 0L;
        --this.entityDataIndex;
    }
    
    public static void drawArrays(final int lllllllllllllIIIIlIlIIlIlIIIIllI, final int lllllllllllllIIIIlIlIIlIlIIIIlIl, final int lllllllllllllIIIIlIlIIlIlIIIIlII, final BufferBuilder lllllllllllllIIIIlIlIIlIlIIIIIll) {
        if (lllllllllllllIIIIlIlIIlIlIIIIlII != 0) {
            final VertexFormat lllllllllllllIIIIlIlIIlIlIIIlIIl = lllllllllllllIIIIlIlIIlIlIIIIIll.getVertexFormat();
            final int lllllllllllllIIIIlIlIIlIlIIIlIII = lllllllllllllIIIIlIlIIlIlIIIlIIl.getNextOffset();
            if (lllllllllllllIIIIlIlIIlIlIIIlIII == 56) {
                final ByteBuffer lllllllllllllIIIIlIlIIlIlIIIIlll = lllllllllllllIIIIlIlIIlIlIIIIIll.getByteBuffer();
                lllllllllllllIIIIlIlIIlIlIIIIlll.position(32);
                GL20.glVertexAttribPointer(Shaders.midTexCoordAttrib, 2, 5126, false, lllllllllllllIIIIlIlIIlIlIIIlIII, lllllllllllllIIIIlIlIIlIlIIIIlll);
                lllllllllllllIIIIlIlIIlIlIIIIlll.position(40);
                GL20.glVertexAttribPointer(Shaders.tangentAttrib, 4, 5122, false, lllllllllllllIIIIlIlIIlIlIIIlIII, lllllllllllllIIIIlIlIIlIlIIIIlll);
                lllllllllllllIIIIlIlIIlIlIIIIlll.position(48);
                GL20.glVertexAttribPointer(Shaders.entityAttrib, 3, 5122, false, lllllllllllllIIIIlIlIIlIlIIIlIII, lllllllllllllIIIIlIlIIlIlIIIIlll);
                lllllllllllllIIIIlIlIIlIlIIIIlll.position(0);
                GL20.glEnableVertexAttribArray(Shaders.midTexCoordAttrib);
                GL20.glEnableVertexAttribArray(Shaders.tangentAttrib);
                GL20.glEnableVertexAttribArray(Shaders.entityAttrib);
                GL11.glDrawArrays(lllllllllllllIIIIlIlIIlIlIIIIllI, lllllllllllllIIIIlIlIIlIlIIIIlIl, lllllllllllllIIIIlIlIIlIlIIIIlII);
                GL20.glDisableVertexAttribArray(Shaders.midTexCoordAttrib);
                GL20.glDisableVertexAttribArray(Shaders.tangentAttrib);
                GL20.glDisableVertexAttribArray(Shaders.entityAttrib);
            }
            else {
                GL11.glDrawArrays(lllllllllllllIIIIlIlIIlIlIIIIllI, lllllllllllllIIIIlIlIIlIlIIIIlIl, lllllllllllllIIIIlIlIIlIlIIIIlII);
            }
        }
    }
    
    public SVertexBuilder() {
        this.entityData = new long[10];
        this.entityDataIndex = 0;
        this.entityData[this.entityDataIndex] = 0L;
    }
    
    public static void beginAddVertex(final BufferBuilder lllllllllllllIIIIlIlIIllIllllIlI) {
        if (lllllllllllllIIIIlIlIIllIllllIlI.vertexCount == 0) {
            endSetVertexFormat(lllllllllllllIIIIlIlIIllIllllIlI);
        }
    }
    
    public static void endSetVertexFormat(final BufferBuilder lllllllllllllIIIIlIlIIlllIIIIIIl) {
        final SVertexBuilder lllllllllllllIIIIlIlIIlllIIIIIII = lllllllllllllIIIIlIlIIlllIIIIIIl.sVertexBuilder;
        final VertexFormat lllllllllllllIIIIlIlIIllIlllllll = lllllllllllllIIIIlIlIIlllIIIIIIl.getVertexFormat();
        lllllllllllllIIIIlIlIIlllIIIIIII.vertexSize = lllllllllllllIIIIlIlIIllIlllllll.getNextOffset() / 4;
        lllllllllllllIIIIlIlIIlllIIIIIII.hasNormal = lllllllllllllIIIIlIlIIllIlllllll.hasNormal();
        lllllllllllllIIIIlIlIIlllIIIIIII.hasTangent = lllllllllllllIIIIlIlIIlllIIIIIII.hasNormal;
        lllllllllllllIIIIlIlIIlllIIIIIII.hasUV = lllllllllllllIIIIlIlIIllIlllllll.hasUvOffset(0);
        lllllllllllllIIIIlIlIIlllIIIIIII.offsetNormal = (lllllllllllllIIIIlIlIIlllIIIIIII.hasNormal ? (lllllllllllllIIIIlIlIIllIlllllll.getNormalOffset() / 4) : 0);
        lllllllllllllIIIIlIlIIlllIIIIIII.offsetUV = (lllllllllllllIIIIlIlIIlllIIIIIII.hasUV ? (lllllllllllllIIIIlIlIIllIlllllll.getUvOffsetById(0) / 4) : 0);
        lllllllllllllIIIIlIlIIlllIIIIIII.offsetUVCenter = 8;
    }
    
    public static void endAddVertex(final BufferBuilder lllllllllllllIIIIlIlIIllIlllIIII) {
        final SVertexBuilder lllllllllllllIIIIlIlIIllIlllIIll = lllllllllllllIIIIlIlIIllIlllIIII.sVertexBuilder;
        if (lllllllllllllIIIIlIlIIllIlllIIll.vertexSize == 14) {
            if (lllllllllllllIIIIlIlIIllIlllIIII.drawMode == 7 && lllllllllllllIIIIlIlIIllIlllIIII.vertexCount % 4 == 0) {
                lllllllllllllIIIIlIlIIllIlllIIll.calcNormal(lllllllllllllIIIIlIlIIllIlllIIII, lllllllllllllIIIIlIlIIllIlllIIII.getBufferSize() - 4 * lllllllllllllIIIIlIlIIllIlllIIll.vertexSize);
            }
            final long lllllllllllllIIIIlIlIIllIlllIIlI = lllllllllllllIIIIlIlIIllIlllIIll.entityData[lllllllllllllIIIIlIlIIllIlllIIll.entityDataIndex];
            final int lllllllllllllIIIIlIlIIllIlllIIIl = lllllllllllllIIIIlIlIIllIlllIIII.getBufferSize() - 14 + 12;
            lllllllllllllIIIIlIlIIllIlllIIII.rawIntBuffer.put(lllllllllllllIIIIlIlIIllIlllIIIl, (int)lllllllllllllIIIIlIlIIllIlllIIlI);
            lllllllllllllIIIIlIlIIllIlllIIII.rawIntBuffer.put(lllllllllllllIIIIlIlIIllIlllIIIl + 1, (int)(lllllllllllllIIIIlIlIIllIlllIIlI >> 32));
        }
    }
    
    public static void calcNormalChunkLayer(final BufferBuilder lllllllllllllIIIIlIlIIlIlIIlllII) {
        if (lllllllllllllIIIIlIlIIlIlIIlllII.getVertexFormat().hasNormal() && lllllllllllllIIIIlIlIIlIlIIlllII.drawMode == 7 && lllllllllllllIIIIlIlIIlIlIIlllII.vertexCount % 4 == 0) {
            final SVertexBuilder lllllllllllllIIIIlIlIIlIlIIllIll = lllllllllllllIIIIlIlIIlIlIIlllII.sVertexBuilder;
            endSetVertexFormat(lllllllllllllIIIIlIlIIlIlIIlllII);
            for (int lllllllllllllIIIIlIlIIlIlIIllIlI = lllllllllllllIIIIlIlIIlIlIIlllII.vertexCount * lllllllllllllIIIIlIlIIlIlIIllIll.vertexSize, lllllllllllllIIIIlIlIIlIlIIllIIl = 0; lllllllllllllIIIIlIlIIlIlIIllIIl < lllllllllllllIIIIlIlIIlIlIIllIlI; lllllllllllllIIIIlIlIIlIlIIllIIl += lllllllllllllIIIIlIlIIlIlIIllIll.vertexSize * 4) {
                lllllllllllllIIIIlIlIIlIlIIllIll.calcNormal(lllllllllllllIIIIlIlIIlIlIIlllII, lllllllllllllIIIIlIlIIlIlIIllIIl);
            }
        }
    }
    
    public void calcNormal(final BufferBuilder lllllllllllllIIIIlIlIIllIIIllIIl, final int lllllllllllllIIIIlIlIIlIllIllIll) {
        final FloatBuffer lllllllllllllIIIIlIlIIllIIIlIlll = lllllllllllllIIIIlIlIIllIIIllIIl.rawFloatBuffer;
        final IntBuffer lllllllllllllIIIIlIlIIllIIIlIllI = lllllllllllllIIIIlIlIIllIIIllIIl.rawIntBuffer;
        final int lllllllllllllIIIIlIlIIllIIIlIlIl = lllllllllllllIIIIlIlIIllIIIllIIl.getBufferSize();
        final float lllllllllllllIIIIlIlIIllIIIlIlII = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 0 * this.vertexSize);
        final float lllllllllllllIIIIlIlIIllIIIlIIll = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 0 * this.vertexSize + 1);
        final float lllllllllllllIIIIlIlIIllIIIlIIlI = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 0 * this.vertexSize + 2);
        final float lllllllllllllIIIIlIlIIllIIIlIIIl = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 0 * this.vertexSize + this.offsetUV);
        final float lllllllllllllIIIIlIlIIllIIIlIIII = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 0 * this.vertexSize + this.offsetUV + 1);
        final float lllllllllllllIIIIlIlIIllIIIIllll = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 1 * this.vertexSize);
        final float lllllllllllllIIIIlIlIIllIIIIlllI = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 1 * this.vertexSize + 1);
        final float lllllllllllllIIIIlIlIIllIIIIllIl = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 1 * this.vertexSize + 2);
        final float lllllllllllllIIIIlIlIIllIIIIllII = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 1 * this.vertexSize + this.offsetUV);
        final float lllllllllllllIIIIlIlIIllIIIIlIll = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 1 * this.vertexSize + this.offsetUV + 1);
        final float lllllllllllllIIIIlIlIIllIIIIlIlI = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 2 * this.vertexSize);
        final float lllllllllllllIIIIlIlIIllIIIIlIIl = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 2 * this.vertexSize + 1);
        final float lllllllllllllIIIIlIlIIllIIIIlIII = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 2 * this.vertexSize + 2);
        final float lllllllllllllIIIIlIlIIllIIIIIlll = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 2 * this.vertexSize + this.offsetUV);
        final float lllllllllllllIIIIlIlIIllIIIIIllI = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 2 * this.vertexSize + this.offsetUV + 1);
        final float lllllllllllllIIIIlIlIIllIIIIIlIl = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 3 * this.vertexSize);
        final float lllllllllllllIIIIlIlIIllIIIIIlII = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 3 * this.vertexSize + 1);
        final float lllllllllllllIIIIlIlIIllIIIIIIll = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 3 * this.vertexSize + 2);
        final float lllllllllllllIIIIlIlIIllIIIIIIlI = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 3 * this.vertexSize + this.offsetUV);
        final float lllllllllllllIIIIlIlIIllIIIIIIIl = lllllllllllllIIIIlIlIIllIIIlIlll.get(lllllllllllllIIIIlIlIIlIllIllIll + 3 * this.vertexSize + this.offsetUV + 1);
        float lllllllllllllIIIIlIlIIllIIIIIIII = lllllllllllllIIIIlIlIIllIIIIlIlI - lllllllllllllIIIIlIlIIllIIIlIlII;
        float lllllllllllllIIIIlIlIIlIllllllll = lllllllllllllIIIIlIlIIllIIIIlIIl - lllllllllllllIIIIlIlIIllIIIlIIll;
        float lllllllllllllIIIIlIlIIlIlllllllI = lllllllllllllIIIIlIlIIllIIIIlIII - lllllllllllllIIIIlIlIIllIIIlIIlI;
        float lllllllllllllIIIIlIlIIlIllllllIl = lllllllllllllIIIIlIlIIllIIIIIlIl - lllllllllllllIIIIlIlIIllIIIIllll;
        float lllllllllllllIIIIlIlIIlIllllllII = lllllllllllllIIIIlIlIIllIIIIIlII - lllllllllllllIIIIlIlIIllIIIIlllI;
        float lllllllllllllIIIIlIlIIlIlllllIll = lllllllllllllIIIIlIlIIllIIIIIIll - lllllllllllllIIIIlIlIIllIIIIllIl;
        float lllllllllllllIIIIlIlIIlIlllllIlI = lllllllllllllIIIIlIlIIlIllllllll * lllllllllllllIIIIlIlIIlIlllllIll - lllllllllllllIIIIlIlIIlIllllllII * lllllllllllllIIIIlIlIIlIlllllllI;
        float lllllllllllllIIIIlIlIIlIlllllIIl = lllllllllllllIIIIlIlIIlIlllllllI * lllllllllllllIIIIlIlIIlIllllllIl - lllllllllllllIIIIlIlIIlIlllllIll * lllllllllllllIIIIlIlIIllIIIIIIII;
        float lllllllllllllIIIIlIlIIlIlllllIII = lllllllllllllIIIIlIlIIllIIIIIIII * lllllllllllllIIIIlIlIIlIllllllII - lllllllllllllIIIIlIlIIlIllllllIl * lllllllllllllIIIIlIlIIlIllllllll;
        float lllllllllllllIIIIlIlIIlIllllIlll = lllllllllllllIIIIlIlIIlIlllllIlI * lllllllllllllIIIIlIlIIlIlllllIlI + lllllllllllllIIIIlIlIIlIlllllIIl * lllllllllllllIIIIlIlIIlIlllllIIl + lllllllllllllIIIIlIlIIlIlllllIII * lllllllllllllIIIIlIlIIlIlllllIII;
        float lllllllllllllIIIIlIlIIlIllllIllI = (lllllllllllllIIIIlIlIIlIllllIlll != 0.0) ? ((float)(1.0 / Math.sqrt(lllllllllllllIIIIlIlIIlIllllIlll))) : 1.0f;
        lllllllllllllIIIIlIlIIlIlllllIlI *= lllllllllllllIIIIlIlIIlIllllIllI;
        lllllllllllllIIIIlIlIIlIlllllIIl *= lllllllllllllIIIIlIlIIlIllllIllI;
        lllllllllllllIIIIlIlIIlIlllllIII *= lllllllllllllIIIIlIlIIlIllllIllI;
        lllllllllllllIIIIlIlIIllIIIIIIII = lllllllllllllIIIIlIlIIllIIIIllll - lllllllllllllIIIIlIlIIllIIIlIlII;
        lllllllllllllIIIIlIlIIlIllllllll = lllllllllllllIIIIlIlIIllIIIIlllI - lllllllllllllIIIIlIlIIllIIIlIIll;
        lllllllllllllIIIIlIlIIlIlllllllI = lllllllllllllIIIIlIlIIllIIIIllIl - lllllllllllllIIIIlIlIIllIIIlIIlI;
        final float lllllllllllllIIIIlIlIIlIllllIlIl = lllllllllllllIIIIlIlIIllIIIIllII - lllllllllllllIIIIlIlIIllIIIlIIIl;
        final float lllllllllllllIIIIlIlIIlIllllIlII = lllllllllllllIIIIlIlIIllIIIIlIll - lllllllllllllIIIIlIlIIllIIIlIIII;
        lllllllllllllIIIIlIlIIlIllllllIl = lllllllllllllIIIIlIlIIllIIIIlIlI - lllllllllllllIIIIlIlIIllIIIlIlII;
        lllllllllllllIIIIlIlIIlIllllllII = lllllllllllllIIIIlIlIIllIIIIlIIl - lllllllllllllIIIIlIlIIllIIIlIIll;
        lllllllllllllIIIIlIlIIlIlllllIll = lllllllllllllIIIIlIlIIllIIIIlIII - lllllllllllllIIIIlIlIIllIIIlIIlI;
        final float lllllllllllllIIIIlIlIIlIllllIIll = lllllllllllllIIIIlIlIIllIIIIIlll - lllllllllllllIIIIlIlIIllIIIlIIIl;
        final float lllllllllllllIIIIlIlIIlIllllIIlI = lllllllllllllIIIIlIlIIllIIIIIllI - lllllllllllllIIIIlIlIIllIIIlIIII;
        final float lllllllllllllIIIIlIlIIlIllllIIIl = lllllllllllllIIIIlIlIIlIllllIlIl * lllllllllllllIIIIlIlIIlIllllIIlI - lllllllllllllIIIIlIlIIlIllllIIll * lllllllllllllIIIIlIlIIlIllllIlII;
        final float lllllllllllllIIIIlIlIIlIllllIIII = (lllllllllllllIIIIlIlIIlIllllIIIl != 0.0f) ? (1.0f / lllllllllllllIIIIlIlIIlIllllIIIl) : 1.0f;
        float lllllllllllllIIIIlIlIIlIlllIllll = (lllllllllllllIIIIlIlIIlIllllIIlI * lllllllllllllIIIIlIlIIllIIIIIIII - lllllllllllllIIIIlIlIIlIllllIlII * lllllllllllllIIIIlIlIIlIllllllIl) * lllllllllllllIIIIlIlIIlIllllIIII;
        float lllllllllllllIIIIlIlIIlIlllIlllI = (lllllllllllllIIIIlIlIIlIllllIIlI * lllllllllllllIIIIlIlIIlIllllllll - lllllllllllllIIIIlIlIIlIllllIlII * lllllllllllllIIIIlIlIIlIllllllII) * lllllllllllllIIIIlIlIIlIllllIIII;
        float lllllllllllllIIIIlIlIIlIlllIllIl = (lllllllllllllIIIIlIlIIlIllllIIlI * lllllllllllllIIIIlIlIIlIlllllllI - lllllllllllllIIIIlIlIIlIllllIlII * lllllllllllllIIIIlIlIIlIlllllIll) * lllllllllllllIIIIlIlIIlIllllIIII;
        float lllllllllllllIIIIlIlIIlIlllIllII = (lllllllllllllIIIIlIlIIlIllllIlIl * lllllllllllllIIIIlIlIIlIllllllIl - lllllllllllllIIIIlIlIIlIllllIIll * lllllllllllllIIIIlIlIIllIIIIIIII) * lllllllllllllIIIIlIlIIlIllllIIII;
        float lllllllllllllIIIIlIlIIlIlllIlIll = (lllllllllllllIIIIlIlIIlIllllIlIl * lllllllllllllIIIIlIlIIlIllllllII - lllllllllllllIIIIlIlIIlIllllIIll * lllllllllllllIIIIlIlIIlIllllllll) * lllllllllllllIIIIlIlIIlIllllIIII;
        float lllllllllllllIIIIlIlIIlIlllIlIlI = (lllllllllllllIIIIlIlIIlIllllIlIl * lllllllllllllIIIIlIlIIlIlllllIll - lllllllllllllIIIIlIlIIlIllllIIll * lllllllllllllIIIIlIlIIlIlllllllI) * lllllllllllllIIIIlIlIIlIllllIIII;
        lllllllllllllIIIIlIlIIlIllllIlll = lllllllllllllIIIIlIlIIlIlllIllll * lllllllllllllIIIIlIlIIlIlllIllll + lllllllllllllIIIIlIlIIlIlllIlllI * lllllllllllllIIIIlIlIIlIlllIlllI + lllllllllllllIIIIlIlIIlIlllIllIl * lllllllllllllIIIIlIlIIlIlllIllIl;
        lllllllllllllIIIIlIlIIlIllllIllI = ((lllllllllllllIIIIlIlIIlIllllIlll != 0.0) ? ((float)(1.0 / Math.sqrt(lllllllllllllIIIIlIlIIlIllllIlll))) : 1.0f);
        lllllllllllllIIIIlIlIIlIlllIllll *= lllllllllllllIIIIlIlIIlIllllIllI;
        lllllllllllllIIIIlIlIIlIlllIlllI *= lllllllllllllIIIIlIlIIlIllllIllI;
        lllllllllllllIIIIlIlIIlIlllIllIl *= lllllllllllllIIIIlIlIIlIllllIllI;
        lllllllllllllIIIIlIlIIlIllllIlll = lllllllllllllIIIIlIlIIlIlllIllII * lllllllllllllIIIIlIlIIlIlllIllII + lllllllllllllIIIIlIlIIlIlllIlIll * lllllllllllllIIIIlIlIIlIlllIlIll + lllllllllllllIIIIlIlIIlIlllIlIlI * lllllllllllllIIIIlIlIIlIlllIlIlI;
        lllllllllllllIIIIlIlIIlIllllIllI = ((lllllllllllllIIIIlIlIIlIllllIlll != 0.0) ? ((float)(1.0 / Math.sqrt(lllllllllllllIIIIlIlIIlIllllIlll))) : 1.0f);
        lllllllllllllIIIIlIlIIlIlllIllII *= lllllllllllllIIIIlIlIIlIllllIllI;
        lllllllllllllIIIIlIlIIlIlllIlIll *= lllllllllllllIIIIlIlIIlIllllIllI;
        lllllllllllllIIIIlIlIIlIlllIlIlI *= lllllllllllllIIIIlIlIIlIllllIllI;
        final float lllllllllllllIIIIlIlIIlIlllIlIIl = lllllllllllllIIIIlIlIIlIlllllIII * lllllllllllllIIIIlIlIIlIlllIlllI - lllllllllllllIIIIlIlIIlIlllllIIl * lllllllllllllIIIIlIlIIlIlllIllIl;
        final float lllllllllllllIIIIlIlIIlIlllIlIII = lllllllllllllIIIIlIlIIlIlllllIlI * lllllllllllllIIIIlIlIIlIlllIllIl - lllllllllllllIIIIlIlIIlIlllllIII * lllllllllllllIIIIlIlIIlIlllIllll;
        final float lllllllllllllIIIIlIlIIlIlllIIlll = lllllllllllllIIIIlIlIIlIlllllIIl * lllllllllllllIIIIlIlIIlIlllIllll - lllllllllllllIIIIlIlIIlIlllllIlI * lllllllllllllIIIIlIlIIlIlllIlllI;
        final float lllllllllllllIIIIlIlIIlIlllIIllI = (lllllllllllllIIIIlIlIIlIlllIllII * lllllllllllllIIIIlIlIIlIlllIlIIl + lllllllllllllIIIIlIlIIlIlllIlIll * lllllllllllllIIIIlIlIIlIlllIlIII + lllllllllllllIIIIlIlIIlIlllIlIlI * lllllllllllllIIIIlIlIIlIlllIIlll < 0.0f) ? -1.0f : 1.0f;
        final int lllllllllllllIIIIlIlIIlIlllIIlIl = (int)(lllllllllllllIIIIlIlIIlIlllllIlI * 127.0f) & 0xFF;
        final int lllllllllllllIIIIlIlIIlIlllIIlII = (int)(lllllllllllllIIIIlIlIIlIlllllIIl * 127.0f) & 0xFF;
        final int lllllllllllllIIIIlIlIIlIlllIIIll = (int)(lllllllllllllIIIIlIlIIlIlllllIII * 127.0f) & 0xFF;
        final int lllllllllllllIIIIlIlIIlIlllIIIlI = (lllllllllllllIIIIlIlIIlIlllIIIll << 16) + (lllllllllllllIIIIlIlIIlIlllIIlII << 8) + lllllllllllllIIIIlIlIIlIlllIIlIl;
        lllllllllllllIIIIlIlIIllIIIlIllI.put(lllllllllllllIIIIlIlIIlIllIllIll + 0 * this.vertexSize + this.offsetNormal, lllllllllllllIIIIlIlIIlIlllIIIlI);
        lllllllllllllIIIIlIlIIllIIIlIllI.put(lllllllllllllIIIIlIlIIlIllIllIll + 1 * this.vertexSize + this.offsetNormal, lllllllllllllIIIIlIlIIlIlllIIIlI);
        lllllllllllllIIIIlIlIIllIIIlIllI.put(lllllllllllllIIIIlIlIIlIllIllIll + 2 * this.vertexSize + this.offsetNormal, lllllllllllllIIIIlIlIIlIlllIIIlI);
        lllllllllllllIIIIlIlIIllIIIlIllI.put(lllllllllllllIIIIlIlIIlIllIllIll + 3 * this.vertexSize + this.offsetNormal, lllllllllllllIIIIlIlIIlIlllIIIlI);
        final int lllllllllllllIIIIlIlIIlIlllIIIIl = ((int)(lllllllllllllIIIIlIlIIlIlllIllll * 32767.0f) & 0xFFFF) + (((int)(lllllllllllllIIIIlIlIIlIlllIlllI * 32767.0f) & 0xFFFF) << 16);
        final int lllllllllllllIIIIlIlIIlIlllIIIII = ((int)(lllllllllllllIIIIlIlIIlIlllIllIl * 32767.0f) & 0xFFFF) + (((int)(lllllllllllllIIIIlIlIIlIlllIIllI * 32767.0f) & 0xFFFF) << 16);
        lllllllllllllIIIIlIlIIllIIIlIllI.put(lllllllllllllIIIIlIlIIlIllIllIll + 0 * this.vertexSize + 10, lllllllllllllIIIIlIlIIlIlllIIIIl);
        lllllllllllllIIIIlIlIIllIIIlIllI.put(lllllllllllllIIIIlIlIIlIllIllIll + 0 * this.vertexSize + 10 + 1, lllllllllllllIIIIlIlIIlIlllIIIII);
        lllllllllllllIIIIlIlIIllIIIlIllI.put(lllllllllllllIIIIlIlIIlIllIllIll + 1 * this.vertexSize + 10, lllllllllllllIIIIlIlIIlIlllIIIIl);
        lllllllllllllIIIIlIlIIllIIIlIllI.put(lllllllllllllIIIIlIlIIlIllIllIll + 1 * this.vertexSize + 10 + 1, lllllllllllllIIIIlIlIIlIlllIIIII);
        lllllllllllllIIIIlIlIIllIIIlIllI.put(lllllllllllllIIIIlIlIIlIllIllIll + 2 * this.vertexSize + 10, lllllllllllllIIIIlIlIIlIlllIIIIl);
        lllllllllllllIIIIlIlIIllIIIlIllI.put(lllllllllllllIIIIlIlIIlIllIllIll + 2 * this.vertexSize + 10 + 1, lllllllllllllIIIIlIlIIlIlllIIIII);
        lllllllllllllIIIIlIlIIllIIIlIllI.put(lllllllllllllIIIIlIlIIlIllIllIll + 3 * this.vertexSize + 10, lllllllllllllIIIIlIlIIlIlllIIIIl);
        lllllllllllllIIIIlIlIIllIIIlIllI.put(lllllllllllllIIIIlIlIIlIllIllIll + 3 * this.vertexSize + 10 + 1, lllllllllllllIIIIlIlIIlIlllIIIII);
        final float lllllllllllllIIIIlIlIIlIllIlllll = (lllllllllllllIIIIlIlIIllIIIlIIIl + lllllllllllllIIIIlIlIIllIIIIllII + lllllllllllllIIIIlIlIIllIIIIIlll + lllllllllllllIIIIlIlIIllIIIIIIlI) / 4.0f;
        final float lllllllllllllIIIIlIlIIlIllIllllI = (lllllllllllllIIIIlIlIIllIIIlIIII + lllllllllllllIIIIlIlIIllIIIIlIll + lllllllllllllIIIIlIlIIllIIIIIllI + lllllllllllllIIIIlIlIIllIIIIIIIl) / 4.0f;
        lllllllllllllIIIIlIlIIllIIIlIlll.put(lllllllllllllIIIIlIlIIlIllIllIll + 0 * this.vertexSize + 8, lllllllllllllIIIIlIlIIlIllIlllll);
        lllllllllllllIIIIlIlIIllIIIlIlll.put(lllllllllllllIIIIlIlIIlIllIllIll + 0 * this.vertexSize + 8 + 1, lllllllllllllIIIIlIlIIlIllIllllI);
        lllllllllllllIIIIlIlIIllIIIlIlll.put(lllllllllllllIIIIlIlIIlIllIllIll + 1 * this.vertexSize + 8, lllllllllllllIIIIlIlIIlIllIlllll);
        lllllllllllllIIIIlIlIIllIIIlIlll.put(lllllllllllllIIIIlIlIIlIllIllIll + 1 * this.vertexSize + 8 + 1, lllllllllllllIIIIlIlIIlIllIllllI);
        lllllllllllllIIIIlIlIIllIIIlIlll.put(lllllllllllllIIIIlIlIIlIllIllIll + 2 * this.vertexSize + 8, lllllllllllllIIIIlIlIIlIllIlllll);
        lllllllllllllIIIIlIlIIllIIIlIlll.put(lllllllllllllIIIIlIlIIlIllIllIll + 2 * this.vertexSize + 8 + 1, lllllllllllllIIIIlIlIIlIllIllllI);
        lllllllllllllIIIIlIlIIllIIIlIlll.put(lllllllllllllIIIIlIlIIlIllIllIll + 3 * this.vertexSize + 8, lllllllllllllIIIIlIlIIlIllIlllll);
        lllllllllllllIIIIlIlIIllIIIlIlll.put(lllllllllllllIIIIlIlIIlIllIllIll + 3 * this.vertexSize + 8 + 1, lllllllllllllIIIIlIlIIlIllIllllI);
    }
    
    public static boolean popEntity(final boolean lllllllllllllIIIIlIlIIlllIIIlIII, final BufferBuilder lllllllllllllIIIIlIlIIlllIIIIlll) {
        lllllllllllllIIIIlIlIIlllIIIIlll.sVertexBuilder.popEntity();
        return lllllllllllllIIIIlIlIIlllIIIlIII;
    }
    
    public static void popEntity(final BufferBuilder lllllllllllllIIIIlIlIIlllIIIllII) {
        lllllllllllllIIIIlIlIIlllIIIllII.sVertexBuilder.popEntity();
    }
    
    public static void initVertexBuilder(final BufferBuilder lllllllllllllIIIIlIlIIlllIllIlIl) {
        lllllllllllllIIIIlIlIIlllIllIlIl.sVertexBuilder = new SVertexBuilder();
    }
}
