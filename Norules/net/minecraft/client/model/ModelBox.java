package net.minecraft.client.model;

import net.minecraft.client.renderer.*;

public class ModelBox
{
    public final /* synthetic */ float posY2;
    private final /* synthetic */ PositionTextureVertex[] vertexPositions;
    public final /* synthetic */ float posZ2;
    private final /* synthetic */ TexturedQuad[] quadList;
    public /* synthetic */ String boxName;
    public final /* synthetic */ float posZ1;
    public final /* synthetic */ float posX2;
    public final /* synthetic */ float posY1;
    public final /* synthetic */ float posX1;
    
    public ModelBox(final ModelRenderer llllllllllllllIllllIIIlIIlIlIllI, final int llllllllllllllIllllIIIlIIIllllII, final int llllllllllllllIllllIIIlIIlIlIlII, float llllllllllllllIllllIIIlIIIlllIlI, float llllllllllllllIllllIIIlIIIlllIIl, float llllllllllllllIllllIIIlIIlIlIIIl, final int llllllllllllllIllllIIIlIIlIlIIII, final int llllllllllllllIllllIIIlIIlIIllll, final int llllllllllllllIllllIIIlIIIllIlIl, final float llllllllllllllIllllIIIlIIIllIlII, final boolean llllllllllllllIllllIIIlIIIllIIll) {
        this.posX1 = llllllllllllllIllllIIIlIIIlllIlI;
        this.posY1 = llllllllllllllIllllIIIlIIIlllIIl;
        this.posZ1 = llllllllllllllIllllIIIlIIlIlIIIl;
        this.posX2 = llllllllllllllIllllIIIlIIIlllIlI + llllllllllllllIllllIIIlIIlIlIIII;
        this.posY2 = llllllllllllllIllllIIIlIIIlllIIl + llllllllllllllIllllIIIlIIlIIllll;
        this.posZ2 = llllllllllllllIllllIIIlIIlIlIIIl + llllllllllllllIllllIIIlIIIllIlIl;
        this.vertexPositions = new PositionTextureVertex[8];
        this.quadList = new TexturedQuad[6];
        float llllllllllllllIllllIIIlIIlIIlIll = llllllllllllllIllllIIIlIIIlllIlI + llllllllllllllIllllIIIlIIlIlIIII;
        float llllllllllllllIllllIIIlIIlIIlIlI = llllllllllllllIllllIIIlIIIlllIIl + llllllllllllllIllllIIIlIIlIIllll;
        float llllllllllllllIllllIIIlIIlIIlIIl = llllllllllllllIllllIIIlIIlIlIIIl + llllllllllllllIllllIIIlIIIllIlIl;
        llllllllllllllIllllIIIlIIIlllIlI -= llllllllllllllIllllIIIlIIIllIlII;
        llllllllllllllIllllIIIlIIIlllIIl -= llllllllllllllIllllIIIlIIIllIlII;
        llllllllllllllIllllIIIlIIlIlIIIl -= llllllllllllllIllllIIIlIIIllIlII;
        llllllllllllllIllllIIIlIIlIIlIll += llllllllllllllIllllIIIlIIIllIlII;
        llllllllllllllIllllIIIlIIlIIlIlI += llllllllllllllIllllIIIlIIIllIlII;
        llllllllllllllIllllIIIlIIlIIlIIl += llllllllllllllIllllIIIlIIIllIlII;
        if (llllllllllllllIllllIIIlIIIllIIll) {
            final float llllllllllllllIllllIIIlIIlIIlIII = llllllllllllllIllllIIIlIIlIIlIll;
            llllllllllllllIllllIIIlIIlIIlIll = llllllllllllllIllllIIIlIIIlllIlI;
            llllllllllllllIllllIIIlIIIlllIlI = llllllllllllllIllllIIIlIIlIIlIII;
        }
        final PositionTextureVertex llllllllllllllIllllIIIlIIlIIIlll = new PositionTextureVertex(llllllllllllllIllllIIIlIIIlllIlI, llllllllllllllIllllIIIlIIIlllIIl, llllllllllllllIllllIIIlIIlIlIIIl, 0.0f, 0.0f);
        final PositionTextureVertex llllllllllllllIllllIIIlIIlIIIllI = new PositionTextureVertex(llllllllllllllIllllIIIlIIlIIlIll, llllllllllllllIllllIIIlIIIlllIIl, llllllllllllllIllllIIIlIIlIlIIIl, 0.0f, 8.0f);
        final PositionTextureVertex llllllllllllllIllllIIIlIIlIIIlIl = new PositionTextureVertex(llllllllllllllIllllIIIlIIlIIlIll, llllllllllllllIllllIIIlIIlIIlIlI, llllllllllllllIllllIIIlIIlIlIIIl, 8.0f, 8.0f);
        final PositionTextureVertex llllllllllllllIllllIIIlIIlIIIlII = new PositionTextureVertex(llllllllllllllIllllIIIlIIIlllIlI, llllllllllllllIllllIIIlIIlIIlIlI, llllllllllllllIllllIIIlIIlIlIIIl, 8.0f, 0.0f);
        final PositionTextureVertex llllllllllllllIllllIIIlIIlIIIIll = new PositionTextureVertex(llllllllllllllIllllIIIlIIIlllIlI, llllllllllllllIllllIIIlIIIlllIIl, llllllllllllllIllllIIIlIIlIIlIIl, 0.0f, 0.0f);
        final PositionTextureVertex llllllllllllllIllllIIIlIIlIIIIlI = new PositionTextureVertex(llllllllllllllIllllIIIlIIlIIlIll, llllllllllllllIllllIIIlIIIlllIIl, llllllllllllllIllllIIIlIIlIIlIIl, 0.0f, 8.0f);
        final PositionTextureVertex llllllllllllllIllllIIIlIIlIIIIIl = new PositionTextureVertex(llllllllllllllIllllIIIlIIlIIlIll, llllllllllllllIllllIIIlIIlIIlIlI, llllllllllllllIllllIIIlIIlIIlIIl, 8.0f, 8.0f);
        final PositionTextureVertex llllllllllllllIllllIIIlIIlIIIIII = new PositionTextureVertex(llllllllllllllIllllIIIlIIIlllIlI, llllllllllllllIllllIIIlIIlIIlIlI, llllllllllllllIllllIIIlIIlIIlIIl, 8.0f, 0.0f);
        this.vertexPositions[0] = llllllllllllllIllllIIIlIIlIIIlll;
        this.vertexPositions[1] = llllllllllllllIllllIIIlIIlIIIllI;
        this.vertexPositions[2] = llllllllllllllIllllIIIlIIlIIIlIl;
        this.vertexPositions[3] = llllllllllllllIllllIIIlIIlIIIlII;
        this.vertexPositions[4] = llllllllllllllIllllIIIlIIlIIIIll;
        this.vertexPositions[5] = llllllllllllllIllllIIIlIIlIIIIlI;
        this.vertexPositions[6] = llllllllllllllIllllIIIlIIlIIIIIl;
        this.vertexPositions[7] = llllllllllllllIllllIIIlIIlIIIIII;
        this.quadList[0] = new TexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIIIlIIlIIIIlI, llllllllllllllIllllIIIlIIlIIIllI, llllllllllllllIllllIIIlIIlIIIlIl, llllllllllllllIllllIIIlIIlIIIIIl }, llllllllllllllIllllIIIlIIIllllII + llllllllllllllIllllIIIlIIIllIlIl + llllllllllllllIllllIIIlIIlIlIIII, llllllllllllllIllllIIIlIIlIlIlII + llllllllllllllIllllIIIlIIIllIlIl, llllllllllllllIllllIIIlIIIllllII + llllllllllllllIllllIIIlIIIllIlIl + llllllllllllllIllllIIIlIIlIlIIII + llllllllllllllIllllIIIlIIIllIlIl, llllllllllllllIllllIIIlIIlIlIlII + llllllllllllllIllllIIIlIIIllIlIl + llllllllllllllIllllIIIlIIlIIllll, llllllllllllllIllllIIIlIIlIlIllI.textureWidth, llllllllllllllIllllIIIlIIlIlIllI.textureHeight);
        this.quadList[1] = new TexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIIIlIIlIIIlll, llllllllllllllIllllIIIlIIlIIIIll, llllllllllllllIllllIIIlIIlIIIIII, llllllllllllllIllllIIIlIIlIIIlII }, llllllllllllllIllllIIIlIIIllllII, llllllllllllllIllllIIIlIIlIlIlII + llllllllllllllIllllIIIlIIIllIlIl, llllllllllllllIllllIIIlIIIllllII + llllllllllllllIllllIIIlIIIllIlIl, llllllllllllllIllllIIIlIIlIlIlII + llllllllllllllIllllIIIlIIIllIlIl + llllllllllllllIllllIIIlIIlIIllll, llllllllllllllIllllIIIlIIlIlIllI.textureWidth, llllllllllllllIllllIIIlIIlIlIllI.textureHeight);
        this.quadList[2] = new TexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIIIlIIlIIIIlI, llllllllllllllIllllIIIlIIlIIIIll, llllllllllllllIllllIIIlIIlIIIlll, llllllllllllllIllllIIIlIIlIIIllI }, llllllllllllllIllllIIIlIIIllllII + llllllllllllllIllllIIIlIIIllIlIl, llllllllllllllIllllIIIlIIlIlIlII, llllllllllllllIllllIIIlIIIllllII + llllllllllllllIllllIIIlIIIllIlIl + llllllllllllllIllllIIIlIIlIlIIII, llllllllllllllIllllIIIlIIlIlIlII + llllllllllllllIllllIIIlIIIllIlIl, llllllllllllllIllllIIIlIIlIlIllI.textureWidth, llllllllllllllIllllIIIlIIlIlIllI.textureHeight);
        this.quadList[3] = new TexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIIIlIIlIIIlIl, llllllllllllllIllllIIIlIIlIIIlII, llllllllllllllIllllIIIlIIlIIIIII, llllllllllllllIllllIIIlIIlIIIIIl }, llllllllllllllIllllIIIlIIIllllII + llllllllllllllIllllIIIlIIIllIlIl + llllllllllllllIllllIIIlIIlIlIIII, llllllllllllllIllllIIIlIIlIlIlII + llllllllllllllIllllIIIlIIIllIlIl, llllllllllllllIllllIIIlIIIllllII + llllllllllllllIllllIIIlIIIllIlIl + llllllllllllllIllllIIIlIIlIlIIII + llllllllllllllIllllIIIlIIlIlIIII, llllllllllllllIllllIIIlIIlIlIlII, llllllllllllllIllllIIIlIIlIlIllI.textureWidth, llllllllllllllIllllIIIlIIlIlIllI.textureHeight);
        this.quadList[4] = new TexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIIIlIIlIIIllI, llllllllllllllIllllIIIlIIlIIIlll, llllllllllllllIllllIIIlIIlIIIlII, llllllllllllllIllllIIIlIIlIIIlIl }, llllllllllllllIllllIIIlIIIllllII + llllllllllllllIllllIIIlIIIllIlIl, llllllllllllllIllllIIIlIIlIlIlII + llllllllllllllIllllIIIlIIIllIlIl, llllllllllllllIllllIIIlIIIllllII + llllllllllllllIllllIIIlIIIllIlIl + llllllllllllllIllllIIIlIIlIlIIII, llllllllllllllIllllIIIlIIlIlIlII + llllllllllllllIllllIIIlIIIllIlIl + llllllllllllllIllllIIIlIIlIIllll, llllllllllllllIllllIIIlIIlIlIllI.textureWidth, llllllllllllllIllllIIIlIIlIlIllI.textureHeight);
        this.quadList[5] = new TexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIIIlIIlIIIIll, llllllllllllllIllllIIIlIIlIIIIlI, llllllllllllllIllllIIIlIIlIIIIIl, llllllllllllllIllllIIIlIIlIIIIII }, llllllllllllllIllllIIIlIIIllllII + llllllllllllllIllllIIIlIIIllIlIl + llllllllllllllIllllIIIlIIlIlIIII + llllllllllllllIllllIIIlIIIllIlIl, llllllllllllllIllllIIIlIIlIlIlII + llllllllllllllIllllIIIlIIIllIlIl, llllllllllllllIllllIIIlIIIllllII + llllllllllllllIllllIIIlIIIllIlIl + llllllllllllllIllllIIIlIIlIlIIII + llllllllllllllIllllIIIlIIIllIlIl + llllllllllllllIllllIIIlIIlIlIIII, llllllllllllllIllllIIIlIIlIlIlII + llllllllllllllIllllIIIlIIIllIlIl + llllllllllllllIllllIIIlIIlIIllll, llllllllllllllIllllIIIlIIlIlIllI.textureWidth, llllllllllllllIllllIIIlIIlIlIllI.textureHeight);
        if (llllllllllllllIllllIIIlIIIllIIll) {
            final Exception llllllllllllllIllllIIIlIIIlIIlII;
            final String llllllllllllllIllllIIIlIIIlIIlIl = (String)((TexturedQuad[])(Object)(llllllllllllllIllllIIIlIIIlIIlII = (Exception)(Object)this.quadList)).length;
            for (long llllllllllllllIllllIIIlIIIlIIllI = 0; llllllllllllllIllllIIIlIIIlIIllI < llllllllllllllIllllIIIlIIIlIIlIl; ++llllllllllllllIllllIIIlIIIlIIllI) {
                final TexturedQuad llllllllllllllIllllIIIlIIIllllll = llllllllllllllIllllIIIlIIIlIIlII[llllllllllllllIllllIIIlIIIlIIllI];
                llllllllllllllIllllIIIlIIIllllll.flipFace();
            }
        }
    }
    
    public ModelBox(final ModelRenderer llllllllllllllIllllIIIlIlllIIIll, final int llllllllllllllIllllIIIlIlllIIIlI, final int llllllllllllllIllllIIIlIlllIIIIl, final float llllllllllllllIllllIIIlIllIlIlIl, final float llllllllllllllIllllIIIlIllIlllll, final float llllllllllllllIllllIIIlIllIlIIll, final int llllllllllllllIllllIIIlIllIlIIlI, final int llllllllllllllIllllIIIlIllIlIIIl, final int llllllllllllllIllllIIIlIllIllIll, final float llllllllllllllIllllIIIlIllIllIlI) {
        this(llllllllllllllIllllIIIlIlllIIIll, llllllllllllllIllllIIIlIlllIIIlI, llllllllllllllIllllIIIlIlllIIIIl, llllllllllllllIllllIIIlIllIlIlIl, llllllllllllllIllllIIIlIllIlllll, llllllllllllllIllllIIIlIllIlIIll, llllllllllllllIllllIIIlIllIlIIlI, llllllllllllllIllllIIIlIllIlIIIl, llllllllllllllIllllIIIlIllIllIll, llllllllllllllIllllIIIlIllIllIlI, llllllllllllllIllllIIIlIlllIIIll.mirror);
    }
    
    public void render(final BufferBuilder llllllllllllllIllllIIIlIIIIlIlll, final float llllllllllllllIllllIIIlIIIIllIlI) {
        Exception llllllllllllllIllllIIIlIIIIlIIlI;
        for (double llllllllllllllIllllIIIlIIIIlIIll = ((TexturedQuad[])(Object)(llllllllllllllIllllIIIlIIIIlIIlI = (Exception)(Object)this.quadList)).length, llllllllllllllIllllIIIlIIIIlIlII = 0; llllllllllllllIllllIIIlIIIIlIlII < llllllllllllllIllllIIIlIIIIlIIll; ++llllllllllllllIllllIIIlIIIIlIlII) {
            final TexturedQuad llllllllllllllIllllIIIlIIIIllIIl = llllllllllllllIllllIIIlIIIIlIIlI[llllllllllllllIllllIIIlIIIIlIlII];
            if (llllllllllllllIllllIIIlIIIIllIIl != null) {
                llllllllllllllIllllIIIlIIIIllIIl.draw(llllllllllllllIllllIIIlIIIIlIlll, llllllllllllllIllllIIIlIIIIllIlI);
            }
        }
    }
    
    public ModelBox setBoxName(final String llllllllllllllIllllIIIlIIIIIlllI) {
        this.boxName = llllllllllllllIllllIIIlIIIIIlllI;
        return this;
    }
    
    private TexturedQuad makeTexturedQuad(final PositionTextureVertex[] llllllllllllllIllllIIIlIIlllllII, final int[] llllllllllllllIllllIIIlIIllllIll, final boolean llllllllllllllIllllIIIlIIlllIlIl, final float llllllllllllllIllllIIIlIIllllIIl, final float llllllllllllllIllllIIIlIIlllIIll) {
        if (llllllllllllllIllllIIIlIIllllIll == null) {
            return null;
        }
        return llllllllllllllIllllIIIlIIlllIlIl ? new TexturedQuad(llllllllllllllIllllIIIlIIlllllII, llllllllllllllIllllIIIlIIllllIll[2], llllllllllllllIllllIIIlIIllllIll[3], llllllllllllllIllllIIIlIIllllIll[0], llllllllllllllIllllIIIlIIllllIll[1], llllllllllllllIllllIIIlIIllllIIl, llllllllllllllIllllIIIlIIlllIIll) : new TexturedQuad(llllllllllllllIllllIIIlIIlllllII, llllllllllllllIllllIIIlIIllllIll[0], llllllllllllllIllllIIIlIIllllIll[1], llllllllllllllIllllIIIlIIllllIll[2], llllllllllllllIllllIIIlIIllllIll[3], llllllllllllllIllllIIIlIIllllIIl, llllllllllllllIllllIIIlIIlllIIll);
    }
    
    public ModelBox(final ModelRenderer llllllllllllllIllllIIIlIlIIllIll, final int[][] llllllllllllllIllllIIIlIlIIllIlI, float llllllllllllllIllllIIIlIlIllIIIl, float llllllllllllllIllllIIIlIlIIllIII, float llllllllllllllIllllIIIlIlIIlIlll, final float llllllllllllllIllllIIIlIlIIlIllI, final float llllllllllllllIllllIIIlIlIlIllIl, final float llllllllllllllIllllIIIlIlIIlIlII, final float llllllllllllllIllllIIIlIlIIlIIll, final boolean llllllllllllllIllllIIIlIlIIlIIlI) {
        this.posX1 = llllllllllllllIllllIIIlIlIllIIIl;
        this.posY1 = llllllllllllllIllllIIIlIlIIllIII;
        this.posZ1 = llllllllllllllIllllIIIlIlIIlIlll;
        this.posX2 = llllllllllllllIllllIIIlIlIllIIIl + llllllllllllllIllllIIIlIlIIlIllI;
        this.posY2 = llllllllllllllIllllIIIlIlIIllIII + llllllllllllllIllllIIIlIlIlIllIl;
        this.posZ2 = llllllllllllllIllllIIIlIlIIlIlll + llllllllllllllIllllIIIlIlIIlIlII;
        this.vertexPositions = new PositionTextureVertex[8];
        this.quadList = new TexturedQuad[6];
        float llllllllllllllIllllIIIlIlIlIlIIl = llllllllllllllIllllIIIlIlIllIIIl + llllllllllllllIllllIIIlIlIIlIllI;
        float llllllllllllllIllllIIIlIlIlIlIII = llllllllllllllIllllIIIlIlIIllIII + llllllllllllllIllllIIIlIlIlIllIl;
        float llllllllllllllIllllIIIlIlIlIIlll = llllllllllllllIllllIIIlIlIIlIlll + llllllllllllllIllllIIIlIlIIlIlII;
        llllllllllllllIllllIIIlIlIllIIIl -= llllllllllllllIllllIIIlIlIIlIIll;
        llllllllllllllIllllIIIlIlIIllIII -= llllllllllllllIllllIIIlIlIIlIIll;
        llllllllllllllIllllIIIlIlIIlIlll -= llllllllllllllIllllIIIlIlIIlIIll;
        llllllllllllllIllllIIIlIlIlIlIIl += llllllllllllllIllllIIIlIlIIlIIll;
        llllllllllllllIllllIIIlIlIlIlIII += llllllllllllllIllllIIIlIlIIlIIll;
        llllllllllllllIllllIIIlIlIlIIlll += llllllllllllllIllllIIIlIlIIlIIll;
        if (llllllllllllllIllllIIIlIlIIlIIlI) {
            final float llllllllllllllIllllIIIlIlIlIIllI = llllllllllllllIllllIIIlIlIlIlIIl;
            llllllllllllllIllllIIIlIlIlIlIIl = llllllllllllllIllllIIIlIlIllIIIl;
            llllllllllllllIllllIIIlIlIllIIIl = llllllllllllllIllllIIIlIlIlIIllI;
        }
        final PositionTextureVertex llllllllllllllIllllIIIlIlIlIIlIl = new PositionTextureVertex(llllllllllllllIllllIIIlIlIllIIIl, llllllllllllllIllllIIIlIlIIllIII, llllllllllllllIllllIIIlIlIIlIlll, 0.0f, 0.0f);
        final PositionTextureVertex llllllllllllllIllllIIIlIlIlIIlII = new PositionTextureVertex(llllllllllllllIllllIIIlIlIlIlIIl, llllllllllllllIllllIIIlIlIIllIII, llllllllllllllIllllIIIlIlIIlIlll, 0.0f, 8.0f);
        final PositionTextureVertex llllllllllllllIllllIIIlIlIlIIIll = new PositionTextureVertex(llllllllllllllIllllIIIlIlIlIlIIl, llllllllllllllIllllIIIlIlIlIlIII, llllllllllllllIllllIIIlIlIIlIlll, 8.0f, 8.0f);
        final PositionTextureVertex llllllllllllllIllllIIIlIlIlIIIlI = new PositionTextureVertex(llllllllllllllIllllIIIlIlIllIIIl, llllllllllllllIllllIIIlIlIlIlIII, llllllllllllllIllllIIIlIlIIlIlll, 8.0f, 0.0f);
        final PositionTextureVertex llllllllllllllIllllIIIlIlIlIIIIl = new PositionTextureVertex(llllllllllllllIllllIIIlIlIllIIIl, llllllllllllllIllllIIIlIlIIllIII, llllllllllllllIllllIIIlIlIlIIlll, 0.0f, 0.0f);
        final PositionTextureVertex llllllllllllllIllllIIIlIlIlIIIII = new PositionTextureVertex(llllllllllllllIllllIIIlIlIlIlIIl, llllllllllllllIllllIIIlIlIIllIII, llllllllllllllIllllIIIlIlIlIIlll, 0.0f, 8.0f);
        final PositionTextureVertex llllllllllllllIllllIIIlIlIIlllll = new PositionTextureVertex(llllllllllllllIllllIIIlIlIlIlIIl, llllllllllllllIllllIIIlIlIlIlIII, llllllllllllllIllllIIIlIlIlIIlll, 8.0f, 8.0f);
        final PositionTextureVertex llllllllllllllIllllIIIlIlIIllllI = new PositionTextureVertex(llllllllllllllIllllIIIlIlIllIIIl, llllllllllllllIllllIIIlIlIlIlIII, llllllllllllllIllllIIIlIlIlIIlll, 8.0f, 0.0f);
        this.vertexPositions[0] = llllllllllllllIllllIIIlIlIlIIlIl;
        this.vertexPositions[1] = llllllllllllllIllllIIIlIlIlIIlII;
        this.vertexPositions[2] = llllllllllllllIllllIIIlIlIlIIIll;
        this.vertexPositions[3] = llllllllllllllIllllIIIlIlIlIIIlI;
        this.vertexPositions[4] = llllllllllllllIllllIIIlIlIlIIIIl;
        this.vertexPositions[5] = llllllllllllllIllllIIIlIlIlIIIII;
        this.vertexPositions[6] = llllllllllllllIllllIIIlIlIIlllll;
        this.vertexPositions[7] = llllllllllllllIllllIIIlIlIIllllI;
        this.quadList[0] = this.makeTexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIIIlIlIlIIIII, llllllllllllllIllllIIIlIlIlIIlII, llllllllllllllIllllIIIlIlIlIIIll, llllllllllllllIllllIIIlIlIIlllll }, llllllllllllllIllllIIIlIlIIllIlI[4], false, llllllllllllllIllllIIIlIlIIllIll.textureWidth, llllllllllllllIllllIIIlIlIIllIll.textureHeight);
        this.quadList[1] = this.makeTexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIIIlIlIlIIlIl, llllllllllllllIllllIIIlIlIlIIIIl, llllllllllllllIllllIIIlIlIIllllI, llllllllllllllIllllIIIlIlIlIIIlI }, llllllllllllllIllllIIIlIlIIllIlI[5], false, llllllllllllllIllllIIIlIlIIllIll.textureWidth, llllllllllllllIllllIIIlIlIIllIll.textureHeight);
        this.quadList[2] = this.makeTexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIIIlIlIlIIIII, llllllllllllllIllllIIIlIlIlIIIIl, llllllllllllllIllllIIIlIlIlIIlIl, llllllllllllllIllllIIIlIlIlIIlII }, llllllllllllllIllllIIIlIlIIllIlI[1], true, llllllllllllllIllllIIIlIlIIllIll.textureWidth, llllllllllllllIllllIIIlIlIIllIll.textureHeight);
        this.quadList[3] = this.makeTexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIIIlIlIlIIIll, llllllllllllllIllllIIIlIlIlIIIlI, llllllllllllllIllllIIIlIlIIllllI, llllllllllllllIllllIIIlIlIIlllll }, llllllllllllllIllllIIIlIlIIllIlI[0], true, llllllllllllllIllllIIIlIlIIllIll.textureWidth, llllllllllllllIllllIIIlIlIIllIll.textureHeight);
        this.quadList[4] = this.makeTexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIIIlIlIlIIlII, llllllllllllllIllllIIIlIlIlIIlIl, llllllllllllllIllllIIIlIlIlIIIlI, llllllllllllllIllllIIIlIlIlIIIll }, llllllllllllllIllllIIIlIlIIllIlI[2], false, llllllllllllllIllllIIIlIlIIllIll.textureWidth, llllllllllllllIllllIIIlIlIIllIll.textureHeight);
        this.quadList[5] = this.makeTexturedQuad(new PositionTextureVertex[] { llllllllllllllIllllIIIlIlIlIIIIl, llllllllllllllIllllIIIlIlIlIIIII, llllllllllllllIllllIIIlIlIIlllll, llllllllllllllIllllIIIlIlIIllllI }, llllllllllllllIllllIIIlIlIIllIlI[3], false, llllllllllllllIllllIIIlIlIIllIll.textureWidth, llllllllllllllIllllIIIlIlIIllIll.textureHeight);
        if (llllllllllllllIllllIIIlIlIIlIIlI) {
            final String llllllllllllllIllllIIIlIlIIIIIll;
            final long llllllllllllllIllllIIIlIlIIIIlII = ((TexturedQuad[])(Object)(llllllllllllllIllllIIIlIlIIIIIll = (String)(Object)this.quadList)).length;
            for (short llllllllllllllIllllIIIlIlIIIIlIl = 0; llllllllllllllIllllIIIlIlIIIIlIl < llllllllllllllIllllIIIlIlIIIIlII; ++llllllllllllllIllllIIIlIlIIIIlIl) {
                final TexturedQuad llllllllllllllIllllIIIlIlIIlllIl = llllllllllllllIllllIIIlIlIIIIIll[llllllllllllllIllllIIIlIlIIIIlIl];
                llllllllllllllIllllIIIlIlIIlllIl.flipFace();
            }
        }
    }
}
