package net.minecraft.client.renderer;

public class Matrix4f extends org.lwjgl.util.vector.Matrix4f
{
    public Matrix4f(final float[] llllllllllllllllIlIlIllIlIlIllII) {
        this.m00 = llllllllllllllllIlIlIllIlIlIllII[0];
        this.m01 = llllllllllllllllIlIlIllIlIlIllII[1];
        this.m02 = llllllllllllllllIlIlIllIlIlIllII[2];
        this.m03 = llllllllllllllllIlIlIllIlIlIllII[3];
        this.m10 = llllllllllllllllIlIlIllIlIlIllII[4];
        this.m11 = llllllllllllllllIlIlIllIlIlIllII[5];
        this.m12 = llllllllllllllllIlIlIllIlIlIllII[6];
        this.m13 = llllllllllllllllIlIlIllIlIlIllII[7];
        this.m20 = llllllllllllllllIlIlIllIlIlIllII[8];
        this.m21 = llllllllllllllllIlIlIllIlIlIllII[9];
        this.m22 = llllllllllllllllIlIlIllIlIlIllII[10];
        this.m23 = llllllllllllllllIlIlIllIlIlIllII[11];
        this.m30 = llllllllllllllllIlIlIllIlIlIllII[12];
        this.m31 = llllllllllllllllIlIlIllIlIlIllII[13];
        this.m32 = llllllllllllllllIlIlIllIlIlIllII[14];
        this.m33 = llllllllllllllllIlIlIllIlIlIllII[15];
    }
    
    public Matrix4f() {
        this.m00 = 0.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 0.0f;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 0.0f;
    }
}
