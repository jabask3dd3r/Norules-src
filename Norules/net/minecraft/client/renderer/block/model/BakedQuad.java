package net.minecraft.client.renderer.block.model;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraftforge.client.model.pipeline.*;
import optifine.*;
import net.minecraft.client.*;

public class BakedQuad implements IVertexProducer
{
    protected /* synthetic */ int[] vertexData;
    protected final /* synthetic */ int tintIndex;
    protected /* synthetic */ VertexFormat format;
    protected /* synthetic */ boolean applyDiffuseLighting;
    protected /* synthetic */ TextureAtlasSprite sprite;
    protected /* synthetic */ EnumFacing face;
    private /* synthetic */ int[] vertexDataSingle;
    private /* synthetic */ QuadBounds quadBounds;
    
    private static int[] makeVertexDataSingle(final int[] lllllllllllllIlllllIIIllIIIIllIl, final TextureAtlasSprite lllllllllllllIlllllIIIllIIIIllII) {
        final int[] lllllllllllllIlllllIIIllIIIlIlll = lllllllllllllIlllllIIIllIIIIllIl.clone();
        final int lllllllllllllIlllllIIIllIIIlIllI = lllllllllllllIlllllIIIllIIIIllII.sheetWidth / lllllllllllllIlllllIIIllIIIIllII.getIconWidth();
        final int lllllllllllllIlllllIIIllIIIlIlIl = lllllllllllllIlllllIIIllIIIIllII.sheetHeight / lllllllllllllIlllllIIIllIIIIllII.getIconHeight();
        final int lllllllllllllIlllllIIIllIIIlIlII = lllllllllllllIlllllIIIllIIIlIlll.length / 4;
        for (int lllllllllllllIlllllIIIllIIIlIIll = 0; lllllllllllllIlllllIIIllIIIlIIll < 4; ++lllllllllllllIlllllIIIllIIIlIIll) {
            final int lllllllllllllIlllllIIIllIIIlIIlI = lllllllllllllIlllllIIIllIIIlIIll * lllllllllllllIlllllIIIllIIIlIlII;
            final float lllllllllllllIlllllIIIllIIIlIIIl = Float.intBitsToFloat(lllllllllllllIlllllIIIllIIIlIlll[lllllllllllllIlllllIIIllIIIlIIlI + 4]);
            final float lllllllllllllIlllllIIIllIIIlIIII = Float.intBitsToFloat(lllllllllllllIlllllIIIllIIIlIlll[lllllllllllllIlllllIIIllIIIlIIlI + 4 + 1]);
            final float lllllllllllllIlllllIIIllIIIIllll = lllllllllllllIlllllIIIllIIIIllII.toSingleU(lllllllllllllIlllllIIIllIIIlIIIl);
            final float lllllllllllllIlllllIIIllIIIIlllI = lllllllllllllIlllllIIIllIIIIllII.toSingleV(lllllllllllllIlllllIIIllIIIlIIII);
            lllllllllllllIlllllIIIllIIIlIlll[lllllllllllllIlllllIIIllIIIlIIlI + 4] = Float.floatToRawIntBits(lllllllllllllIlllllIIIllIIIIllll);
            lllllllllllllIlllllIIIllIIIlIlll[lllllllllllllIlllllIIIllIIIlIIlI + 4 + 1] = Float.floatToRawIntBits(lllllllllllllIlllllIIIllIIIIlllI);
        }
        return lllllllllllllIlllllIIIllIIIlIlll;
    }
    
    public BakedQuad(final int[] lllllllllllllIlllllIIIllIlIIllII, final int lllllllllllllIlllllIIIllIlIIlIll, final EnumFacing lllllllllllllIlllllIIIllIlIlIIIl, final TextureAtlasSprite lllllllllllllIlllllIIIllIlIlIIII, final boolean lllllllllllllIlllllIIIllIlIIllll, final VertexFormat lllllllllllllIlllllIIIllIlIIIlll) {
        this.vertexDataSingle = null;
        this.applyDiffuseLighting = Reflector.ForgeHooksClient_fillNormal.exists();
        this.format = DefaultVertexFormats.ITEM;
        this.vertexData = lllllllllllllIlllllIIIllIlIIllII;
        this.tintIndex = lllllllllllllIlllllIIIllIlIIlIll;
        this.face = lllllllllllllIlllllIIIllIlIlIIIl;
        this.sprite = lllllllllllllIlllllIIIllIlIlIIII;
        this.applyDiffuseLighting = lllllllllllllIlllllIIIllIlIIllll;
        this.format = lllllllllllllIlllllIIIllIlIIIlll;
        this.fixVertexData();
    }
    
    public boolean isFullFaceQuad() {
        return this.isFullQuad() && this.isFaceQuad();
    }
    
    public BakedQuad(final int[] lllllllllllllIlllllIIIllIlIIIIII, final int lllllllllllllIlllllIIIllIIllllll, final EnumFacing lllllllllllllIlllllIIIllIIlllllI, final TextureAtlasSprite lllllllllllllIlllllIIIllIIllllIl) {
        this.vertexDataSingle = null;
        this.applyDiffuseLighting = Reflector.ForgeHooksClient_fillNormal.exists();
        this.format = DefaultVertexFormats.ITEM;
        this.vertexData = lllllllllllllIlllllIIIllIlIIIIII;
        this.tintIndex = lllllllllllllIlllllIIIllIIllllll;
        this.face = lllllllllllllIlllllIIIllIIlllllI;
        this.sprite = lllllllllllllIlllllIIIllIIllllIl;
        this.fixVertexData();
    }
    
    public float getMidX() {
        final QuadBounds lllllllllllllIlllllIIIlIlIlIllIl = this.getQuadBounds();
        return (lllllllllllllIlllllIIIlIlIlIllIl.getMaxX() + lllllllllllllIlllllIIIlIlIlIllIl.getMinX()) / 2.0f;
    }
    
    public boolean isFullQuad() {
        final QuadBounds lllllllllllllIlllllIIIlIlIIlIlIl = this.getQuadBounds();
        return lllllllllllllIlllllIIIlIlIIlIlIl.isFullQuad(this.face);
    }
    
    public boolean isFaceQuad() {
        final QuadBounds lllllllllllllIlllllIIIlIlIIllIll = this.getQuadBounds();
        return lllllllllllllIlllllIIIlIlIIllIll.isFaceQuad(this.face);
    }
    
    private static int[] expandVertexData(final int[] lllllllllllllIlllllIIIlIllIIIlll) {
        final int lllllllllllllIlllllIIIlIllIIlIll = lllllllllllllIlllllIIIlIllIIIlll.length / 4;
        final int lllllllllllllIlllllIIIlIllIIlIlI = lllllllllllllIlllllIIIlIllIIlIll * 2;
        final int[] lllllllllllllIlllllIIIlIllIIlIIl = new int[lllllllllllllIlllllIIIlIllIIlIlI * 4];
        for (int lllllllllllllIlllllIIIlIllIIlIII = 0; lllllllllllllIlllllIIIlIllIIlIII < 4; ++lllllllllllllIlllllIIIlIllIIlIII) {
            System.arraycopy(lllllllllllllIlllllIIIlIllIIIlll, lllllllllllllIlllllIIIlIllIIlIII * lllllllllllllIlllllIIIlIllIIlIll, lllllllllllllIlllllIIIlIllIIlIIl, lllllllllllllIlllllIIIlIllIIlIII * lllllllllllllIlllllIIIlIllIIlIlI, lllllllllllllIlllllIIIlIllIIlIll);
        }
        return lllllllllllllIlllllIIIlIllIIlIIl;
    }
    
    private static int[] compactVertexData(final int[] lllllllllllllIlllllIIIlIlIlllIII) {
        final int lllllllllllllIlllllIIIlIlIllllII = lllllllllllllIlllllIIIlIlIlllIII.length / 4;
        final int lllllllllllllIlllllIIIlIlIlllIll = lllllllllllllIlllllIIIlIlIllllII / 2;
        final int[] lllllllllllllIlllllIIIlIlIlllIlI = new int[lllllllllllllIlllllIIIlIlIlllIll * 4];
        for (int lllllllllllllIlllllIIIlIlIlllIIl = 0; lllllllllllllIlllllIIIlIlIlllIIl < 4; ++lllllllllllllIlllllIIIlIlIlllIIl) {
            System.arraycopy(lllllllllllllIlllllIIIlIlIlllIII, lllllllllllllIlllllIIIlIlIlllIIl * lllllllllllllIlllllIIIlIlIllllII, lllllllllllllIlllllIIIlIlIlllIlI, lllllllllllllIlllllIIIlIlIlllIIl * lllllllllllllIlllllIIIlIlIlllIll, lllllllllllllIlllllIIIlIlIlllIll);
        }
        return lllllllllllllIlllllIIIlIlIlllIlI;
    }
    
    public int getTintIndex() {
        return this.tintIndex;
    }
    
    public double getMidY() {
        final QuadBounds lllllllllllllIlllllIIIlIlIlIIlll = this.getQuadBounds();
        return (lllllllllllllIlllllIIIlIlIlIIlll.getMaxY() + lllllllllllllIlllllIIIlIlIlIIlll.getMinY()) / 2.0f;
    }
    
    public QuadBounds getQuadBounds() {
        if (this.quadBounds == null) {
            this.quadBounds = new QuadBounds(this.getVertexData());
        }
        return this.quadBounds;
    }
    
    public boolean shouldApplyDiffuseLighting() {
        return this.applyDiffuseLighting;
    }
    
    @Override
    public void pipe(final IVertexConsumer lllllllllllllIlllllIIIlIlllllllI) {
        Reflector.callVoid(Reflector.LightUtil_putBakedQuad, lllllllllllllIlllllIIIlIlllllllI, this);
    }
    
    public VertexFormat getFormat() {
        return this.format;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("vertex: ").append(this.vertexData.length / 7).append(", tint: ").append(this.tintIndex).append(", facing: ").append(this.face).append(", sprite: ").append(this.sprite));
    }
    
    public EnumFacing getFace() {
        if (this.face == null) {
            this.face = FaceBakery.getFacingFromVertexData(this.getVertexData());
        }
        return this.face;
    }
    
    protected void fixVertexData() {
        if (Config.isShaders()) {
            if (this.vertexData.length == 28) {
                this.vertexData = expandVertexData(this.vertexData);
            }
        }
        else if (this.vertexData.length == 56) {
            this.vertexData = compactVertexData(this.vertexData);
        }
    }
    
    private static TextureAtlasSprite getSpriteByUv(final int[] lllllllllllllIlllllIIIlIllIllllI) {
        float lllllllllllllIlllllIIIlIlllIlIlI = 1.0f;
        float lllllllllllllIlllllIIIlIlllIlIIl = 1.0f;
        float lllllllllllllIlllllIIIlIlllIlIII = 0.0f;
        float lllllllllllllIlllllIIIlIlllIIlll = 0.0f;
        final int lllllllllllllIlllllIIIlIlllIIllI = lllllllllllllIlllllIIIlIllIllllI.length / 4;
        for (int lllllllllllllIlllllIIIlIlllIIlIl = 0; lllllllllllllIlllllIIIlIlllIIlIl < 4; ++lllllllllllllIlllllIIIlIlllIIlIl) {
            final int lllllllllllllIlllllIIIlIlllIIlII = lllllllllllllIlllllIIIlIlllIIlIl * lllllllllllllIlllllIIIlIlllIIllI;
            final float lllllllllllllIlllllIIIlIlllIIIll = Float.intBitsToFloat(lllllllllllllIlllllIIIlIllIllllI[lllllllllllllIlllllIIIlIlllIIlII + 4]);
            final float lllllllllllllIlllllIIIlIlllIIIlI = Float.intBitsToFloat(lllllllllllllIlllllIIIlIllIllllI[lllllllllllllIlllllIIIlIlllIIlII + 4 + 1]);
            lllllllllllllIlllllIIIlIlllIlIlI = Math.min(lllllllllllllIlllllIIIlIlllIlIlI, lllllllllllllIlllllIIIlIlllIIIll);
            lllllllllllllIlllllIIIlIlllIlIIl = Math.min(lllllllllllllIlllllIIIlIlllIlIIl, lllllllllllllIlllllIIIlIlllIIIlI);
            lllllllllllllIlllllIIIlIlllIlIII = Math.max(lllllllllllllIlllllIIIlIlllIlIII, lllllllllllllIlllllIIIlIlllIIIll);
            lllllllllllllIlllllIIIlIlllIIlll = Math.max(lllllllllllllIlllllIIIlIlllIIlll, lllllllllllllIlllllIIIlIlllIIIlI);
        }
        final float lllllllllllllIlllllIIIlIlllIIIIl = (lllllllllllllIlllllIIIlIlllIlIlI + lllllllllllllIlllllIIIlIlllIlIII) / 2.0f;
        final float lllllllllllllIlllllIIIlIlllIIIII = (lllllllllllllIlllllIIIlIlllIlIIl + lllllllllllllIlllllIIIlIlllIIlll) / 2.0f;
        final TextureAtlasSprite lllllllllllllIlllllIIIlIllIlllll = Minecraft.getMinecraft().getTextureMapBlocks().getIconByUV(lllllllllllllIlllllIIIlIlllIIIIl, lllllllllllllIlllllIIIlIlllIIIII);
        return lllllllllllllIlllllIIIlIllIlllll;
    }
    
    public double getMidZ() {
        final QuadBounds lllllllllllllIlllllIIIlIlIlIIIIl = this.getQuadBounds();
        return (lllllllllllllIlllllIIIlIlIlIIIIl.getMaxZ() + lllllllllllllIlllllIIIlIlIlIIIIl.getMinZ()) / 2.0f;
    }
    
    public int[] getVertexData() {
        this.fixVertexData();
        return this.vertexData;
    }
    
    public int[] getVertexDataSingle() {
        if (this.vertexDataSingle == null) {
            this.vertexDataSingle = makeVertexDataSingle(this.getVertexData(), this.getSprite());
        }
        return this.vertexDataSingle;
    }
    
    public TextureAtlasSprite getSprite() {
        if (this.sprite == null) {
            this.sprite = getSpriteByUv(this.getVertexData());
        }
        return this.sprite;
    }
    
    public boolean hasTintIndex() {
        return this.tintIndex != -1;
    }
}
