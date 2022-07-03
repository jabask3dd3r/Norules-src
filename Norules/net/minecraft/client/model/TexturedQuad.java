package net.minecraft.client.model;

import optifine.*;
import shadersmod.client.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;

public class TexturedQuad
{
    public /* synthetic */ int nVertices;
    public /* synthetic */ PositionTextureVertex[] vertexPositions;
    private /* synthetic */ boolean invertNormal;
    
    public void flipFace() {
        final PositionTextureVertex[] lllllllllllllllIlIllIlIIlllIIllI = new PositionTextureVertex[this.vertexPositions.length];
        for (int lllllllllllllllIlIllIlIIlllIIlIl = 0; lllllllllllllllIlIllIlIIlllIIlIl < this.vertexPositions.length; ++lllllllllllllllIlIllIlIIlllIIlIl) {
            lllllllllllllllIlIllIlIIlllIIllI[lllllllllllllllIlIllIlIIlllIIlIl] = this.vertexPositions[this.vertexPositions.length - lllllllllllllllIlIllIlIIlllIIlIl - 1];
        }
        this.vertexPositions = lllllllllllllllIlIllIlIIlllIIllI;
    }
    
    public TexturedQuad(final PositionTextureVertex[] lllllllllllllllIlIllIlIlIIIIlIll) {
        this.vertexPositions = lllllllllllllllIlIllIlIlIIIIlIll;
        this.nVertices = lllllllllllllllIlIllIlIlIIIIlIll.length;
    }
    
    public void draw(final BufferBuilder lllllllllllllllIlIllIlIIllIlIlIl, final float lllllllllllllllIlIllIlIIllIlIlII) {
        final Vec3d lllllllllllllllIlIllIlIIllIlIIll = this.vertexPositions[1].vector3D.subtractReverse(this.vertexPositions[0].vector3D);
        final Vec3d lllllllllllllllIlIllIlIIllIlIIlI = this.vertexPositions[1].vector3D.subtractReverse(this.vertexPositions[2].vector3D);
        final Vec3d lllllllllllllllIlIllIlIIllIlIIIl = lllllllllllllllIlIllIlIIllIlIIlI.crossProduct(lllllllllllllllIlIllIlIIllIlIIll).normalize();
        float lllllllllllllllIlIllIlIIllIlIIII = (float)lllllllllllllllIlIllIlIIllIlIIIl.xCoord;
        float lllllllllllllllIlIllIlIIllIIllll = (float)lllllllllllllllIlIllIlIIllIlIIIl.yCoord;
        float lllllllllllllllIlIllIlIIllIIlllI = (float)lllllllllllllllIlIllIlIIllIlIIIl.zCoord;
        if (this.invertNormal) {
            lllllllllllllllIlIllIlIIllIlIIII = -lllllllllllllllIlIllIlIIllIlIIII;
            lllllllllllllllIlIllIlIIllIIllll = -lllllllllllllllIlIllIlIIllIIllll;
            lllllllllllllllIlIllIlIIllIIlllI = -lllllllllllllllIlIllIlIIllIIlllI;
        }
        if (Config.isShaders()) {
            lllllllllllllllIlIllIlIIllIlIlIl.begin(7, SVertexFormat.defVertexFormatTextured);
        }
        else {
            lllllllllllllllIlIllIlIIllIlIlIl.begin(7, DefaultVertexFormats.OLDMODEL_POSITION_TEX_NORMAL);
        }
        for (int lllllllllllllllIlIllIlIIllIIllIl = 0; lllllllllllllllIlIllIlIIllIIllIl < 4; ++lllllllllllllllIlIllIlIIllIIllIl) {
            final PositionTextureVertex lllllllllllllllIlIllIlIIllIIllII = this.vertexPositions[lllllllllllllllIlIllIlIIllIIllIl];
            lllllllllllllllIlIllIlIIllIlIlIl.pos(lllllllllllllllIlIllIlIIllIIllII.vector3D.xCoord * lllllllllllllllIlIllIlIIllIlIlII, lllllllllllllllIlIllIlIIllIIllII.vector3D.yCoord * lllllllllllllllIlIllIlIIllIlIlII, lllllllllllllllIlIllIlIIllIIllII.vector3D.zCoord * lllllllllllllllIlIllIlIIllIlIlII).tex(lllllllllllllllIlIllIlIIllIIllII.texturePositionX, lllllllllllllllIlIllIlIIllIIllII.texturePositionY).normal(lllllllllllllllIlIllIlIIllIlIIII, lllllllllllllllIlIllIlIIllIIllll, lllllllllllllllIlIllIlIIllIIlllI).endVertex();
        }
        Tessellator.getInstance().draw();
    }
    
    public TexturedQuad(final PositionTextureVertex[] lllllllllllllllIlIllIlIIllllllIl, final int lllllllllllllllIlIllIlIIllllIIlI, final int lllllllllllllllIlIllIlIIlllllIll, final int lllllllllllllllIlIllIlIIlllllIlI, final int lllllllllllllllIlIllIlIIlllllIIl, final float lllllllllllllllIlIllIlIIlllIlllI, final float lllllllllllllllIlIllIlIIlllIllIl) {
        this(lllllllllllllllIlIllIlIIllllllIl);
        final float lllllllllllllllIlIllIlIIllllIllI = 0.0f / lllllllllllllllIlIllIlIIlllIlllI;
        final float lllllllllllllllIlIllIlIIllllIlIl = 0.0f / lllllllllllllllIlIllIlIIlllIllIl;
        lllllllllllllllIlIllIlIIllllllIl[0] = lllllllllllllllIlIllIlIIllllllIl[0].setTexturePosition(lllllllllllllllIlIllIlIIlllllIlI / lllllllllllllllIlIllIlIIlllIlllI - lllllllllllllllIlIllIlIIllllIllI, lllllllllllllllIlIllIlIIlllllIll / lllllllllllllllIlIllIlIIlllIllIl + lllllllllllllllIlIllIlIIllllIlIl);
        lllllllllllllllIlIllIlIIllllllIl[1] = lllllllllllllllIlIllIlIIllllllIl[1].setTexturePosition(lllllllllllllllIlIllIlIIllllIIlI / lllllllllllllllIlIllIlIIlllIlllI + lllllllllllllllIlIllIlIIllllIllI, lllllllllllllllIlIllIlIIlllllIll / lllllllllllllllIlIllIlIIlllIllIl + lllllllllllllllIlIllIlIIllllIlIl);
        lllllllllllllllIlIllIlIIllllllIl[2] = lllllllllllllllIlIllIlIIllllllIl[2].setTexturePosition(lllllllllllllllIlIllIlIIllllIIlI / lllllllllllllllIlIllIlIIlllIlllI + lllllllllllllllIlIllIlIIllllIllI, lllllllllllllllIlIllIlIIlllllIIl / lllllllllllllllIlIllIlIIlllIllIl - lllllllllllllllIlIllIlIIllllIlIl);
        lllllllllllllllIlIllIlIIllllllIl[3] = lllllllllllllllIlIllIlIIllllllIl[3].setTexturePosition(lllllllllllllllIlIllIlIIlllllIlI / lllllllllllllllIlIllIlIIlllIlllI - lllllllllllllllIlIllIlIIllllIllI, lllllllllllllllIlIllIlIIlllllIIl / lllllllllllllllIlIllIlIIlllIllIl - lllllllllllllllIlIllIlIIllllIlIl);
    }
}
