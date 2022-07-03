package net.minecraft.client.shader;

import java.nio.*;
import org.lwjgl.util.vector.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.*;
import org.apache.logging.log4j.*;

public class ShaderUniform
{
    private final /* synthetic */ String shaderName;
    private final /* synthetic */ FloatBuffer uniformFloatBuffer;
    private final /* synthetic */ IntBuffer uniformIntBuffer;
    private /* synthetic */ int uniformLocation;
    private final /* synthetic */ int uniformCount;
    private /* synthetic */ boolean dirty;
    private final /* synthetic */ ShaderManager shaderManager;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ int uniformType;
    
    public void setUniformLocation(final int lllllllllllllllIIlIlIIlIIIIllIlI) {
        this.uniformLocation = lllllllllllllllIIlIlIIlIIIIllIlI;
    }
    
    public String getShaderName() {
        return this.shaderName;
    }
    
    public void set(final Matrix4f lllllllllllllllIIlIlIIIllIIIlllI) {
        this.set(lllllllllllllllIIlIlIIIllIIIlllI.m00, lllllllllllllllIIlIlIIIllIIIlllI.m01, lllllllllllllllIIlIlIIIllIIIlllI.m02, lllllllllllllllIIlIlIIIllIIIlllI.m03, lllllllllllllllIIlIlIIIllIIIlllI.m10, lllllllllllllllIIlIlIIIllIIIlllI.m11, lllllllllllllllIIlIlIIIllIIIlllI.m12, lllllllllllllllIIlIlIIIllIIIlllI.m13, lllllllllllllllIIlIlIIIllIIIlllI.m20, lllllllllllllllIIlIlIIIllIIIlllI.m21, lllllllllllllllIIlIlIIIllIIIlllI.m22, lllllllllllllllIIlIlIIIllIIIlllI.m23, lllllllllllllllIIlIlIIIllIIIlllI.m30, lllllllllllllllIIlIlIIIllIIIlllI.m31, lllllllllllllllIIlIlIIIllIIIlllI.m32, lllllllllllllllIIlIlIIIllIIIlllI.m33);
    }
    
    public void set(final float lllllllllllllllIIlIlIIlIIIIIlIlI, final float lllllllllllllllIIlIlIIlIIIIIlIIl) {
        this.uniformFloatBuffer.position(0);
        this.uniformFloatBuffer.put(0, lllllllllllllllIIlIlIIlIIIIIlIlI);
        this.uniformFloatBuffer.put(1, lllllllllllllllIIlIlIIlIIIIIlIIl);
        this.markDirty();
    }
    
    public void set(final float lllllllllllllllIIlIlIIIllIlIIIll, final float lllllllllllllllIIlIlIIIllIlIIIlI, final float lllllllllllllllIIlIlIIIllIlIIIIl, final float lllllllllllllllIIlIlIIIllIlIIIII, final float lllllllllllllllIIlIlIIIllIllIIII, final float lllllllllllllllIIlIlIIIllIIllllI, final float lllllllllllllllIIlIlIIIllIIlllIl, final float lllllllllllllllIIlIlIIIllIIlllII, final float lllllllllllllllIIlIlIIIllIlIllII, final float lllllllllllllllIIlIlIIIllIlIlIll, final float lllllllllllllllIIlIlIIIllIIllIIl, final float lllllllllllllllIIlIlIIIllIIllIII, final float lllllllllllllllIIlIlIIIllIlIlIII, final float lllllllllllllllIIlIlIIIllIlIIlll, final float lllllllllllllllIIlIlIIIllIIlIlIl, final float lllllllllllllllIIlIlIIIllIlIIlIl) {
        this.uniformFloatBuffer.position(0);
        this.uniformFloatBuffer.put(0, lllllllllllllllIIlIlIIIllIlIIIll);
        this.uniformFloatBuffer.put(1, lllllllllllllllIIlIlIIIllIlIIIlI);
        this.uniformFloatBuffer.put(2, lllllllllllllllIIlIlIIIllIlIIIIl);
        this.uniformFloatBuffer.put(3, lllllllllllllllIIlIlIIIllIlIIIII);
        this.uniformFloatBuffer.put(4, lllllllllllllllIIlIlIIIllIllIIII);
        this.uniformFloatBuffer.put(5, lllllllllllllllIIlIlIIIllIIllllI);
        this.uniformFloatBuffer.put(6, lllllllllllllllIIlIlIIIllIIlllIl);
        this.uniformFloatBuffer.put(7, lllllllllllllllIIlIlIIIllIIlllII);
        this.uniformFloatBuffer.put(8, lllllllllllllllIIlIlIIIllIlIllII);
        this.uniformFloatBuffer.put(9, lllllllllllllllIIlIlIIIllIlIlIll);
        this.uniformFloatBuffer.put(10, lllllllllllllllIIlIlIIIllIIllIIl);
        this.uniformFloatBuffer.put(11, lllllllllllllllIIlIlIIIllIIllIII);
        this.uniformFloatBuffer.put(12, lllllllllllllllIIlIlIIIllIlIlIII);
        this.uniformFloatBuffer.put(13, lllllllllllllllIIlIlIIIllIlIIlll);
        this.uniformFloatBuffer.put(14, lllllllllllllllIIlIlIIIllIIlIlIl);
        this.uniformFloatBuffer.put(15, lllllllllllllllIIlIlIIIllIlIIlIl);
        this.markDirty();
    }
    
    private void markDirty() {
        this.dirty = true;
        if (this.shaderManager != null) {
            this.shaderManager.markDirty();
        }
    }
    
    private void uploadFloatMatrix() {
        switch (this.uniformType) {
            case 8: {
                OpenGlHelper.glUniformMatrix2(this.uniformLocation, true, this.uniformFloatBuffer);
                break;
            }
            case 9: {
                OpenGlHelper.glUniformMatrix3(this.uniformLocation, true, this.uniformFloatBuffer);
                break;
            }
            case 10: {
                OpenGlHelper.glUniformMatrix4(this.uniformLocation, true, this.uniformFloatBuffer);
                break;
            }
        }
    }
    
    public void set(final float lllllllllllllllIIlIlIIlIIIIlIIIl) {
        this.uniformFloatBuffer.position(0);
        this.uniformFloatBuffer.put(0, lllllllllllllllIIlIlIIlIIIIlIIIl);
        this.markDirty();
    }
    
    public ShaderUniform(final String lllllllllllllllIIlIlIIlIIIlIllll, final int lllllllllllllllIIlIlIIlIIIlIlllI, final int lllllllllllllllIIlIlIIlIIIlIllIl, final ShaderManager lllllllllllllllIIlIlIIlIIIlIIlll) {
        this.shaderName = lllllllllllllllIIlIlIIlIIIlIllll;
        this.uniformCount = lllllllllllllllIIlIlIIlIIIlIllIl;
        this.uniformType = lllllllllllllllIIlIlIIlIIIlIlllI;
        this.shaderManager = lllllllllllllllIIlIlIIlIIIlIIlll;
        if (lllllllllllllllIIlIlIIlIIIlIlllI <= 3) {
            this.uniformIntBuffer = BufferUtils.createIntBuffer(lllllllllllllllIIlIlIIlIIIlIllIl);
            this.uniformFloatBuffer = null;
        }
        else {
            this.uniformIntBuffer = null;
            this.uniformFloatBuffer = BufferUtils.createFloatBuffer(lllllllllllllllIIlIlIIlIIIlIllIl);
        }
        this.uniformLocation = -1;
        this.markDirty();
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public void set(final float[] lllllllllllllllIIlIlIIIlllIIlIIl) {
        if (lllllllllllllllIIlIlIIIlllIIlIIl.length < this.uniformCount) {
            ShaderUniform.LOGGER.warn("Uniform.set called with a too-small value array (expected {}, got {}). Ignoring.", (Object)this.uniformCount, (Object)lllllllllllllllIIlIlIIIlllIIlIIl.length);
        }
        else {
            this.uniformFloatBuffer.position(0);
            this.uniformFloatBuffer.put(lllllllllllllllIIlIlIIIlllIIlIIl);
            this.uniformFloatBuffer.position(0);
            this.markDirty();
        }
    }
    
    public void set(final float lllllllllllllllIIlIlIIIlllllIIll, final float lllllllllllllllIIlIlIIIlllllIIlI, final float lllllllllllllllIIlIlIIIllllIllII, final float lllllllllllllllIIlIlIIIllllIlIll) {
        this.uniformFloatBuffer.position(0);
        this.uniformFloatBuffer.put(lllllllllllllllIIlIlIIIlllllIIll);
        this.uniformFloatBuffer.put(lllllllllllllllIIlIlIIIlllllIIlI);
        this.uniformFloatBuffer.put(lllllllllllllllIIlIlIIIllllIllII);
        this.uniformFloatBuffer.put(lllllllllllllllIIlIlIIIllllIlIll);
        this.uniformFloatBuffer.flip();
        this.markDirty();
    }
    
    public void set(final float lllllllllllllllIIlIlIIlIIIIIIIII, final float lllllllllllllllIIlIlIIIlllllllll, final float lllllllllllllllIIlIlIIIllllllllI) {
        this.uniformFloatBuffer.position(0);
        this.uniformFloatBuffer.put(0, lllllllllllllllIIlIlIIlIIIIIIIII);
        this.uniformFloatBuffer.put(1, lllllllllllllllIIlIlIIIlllllllll);
        this.uniformFloatBuffer.put(2, lllllllllllllllIIlIlIIIllllllllI);
        this.markDirty();
    }
    
    private void uploadInt() {
        switch (this.uniformType) {
            case 0: {
                OpenGlHelper.glUniform1(this.uniformLocation, this.uniformIntBuffer);
                break;
            }
            case 1: {
                OpenGlHelper.glUniform2(this.uniformLocation, this.uniformIntBuffer);
                break;
            }
            case 2: {
                OpenGlHelper.glUniform3(this.uniformLocation, this.uniformIntBuffer);
                break;
            }
            case 3: {
                OpenGlHelper.glUniform4(this.uniformLocation, this.uniformIntBuffer);
                break;
            }
            default: {
                ShaderUniform.LOGGER.warn("Uniform.upload called, but count value ({}) is  not in the range of 1 to 4. Ignoring.", (Object)this.uniformCount);
                break;
            }
        }
    }
    
    public static int parseType(final String lllllllllllllllIIlIlIIlIIIlIIIIl) {
        int lllllllllllllllIIlIlIIlIIIlIIIII = -1;
        if ("int".equals(lllllllllllllllIIlIlIIlIIIlIIIIl)) {
            lllllllllllllllIIlIlIIlIIIlIIIII = 0;
        }
        else if ("float".equals(lllllllllllllllIIlIlIIlIIIlIIIIl)) {
            lllllllllllllllIIlIlIIlIIIlIIIII = 4;
        }
        else if (lllllllllllllllIIlIlIIlIIIlIIIIl.startsWith("matrix")) {
            if (lllllllllllllllIIlIlIIlIIIlIIIIl.endsWith("2x2")) {
                lllllllllllllllIIlIlIIlIIIlIIIII = 8;
            }
            else if (lllllllllllllllIIlIlIIlIIIlIIIIl.endsWith("3x3")) {
                lllllllllllllllIIlIlIIlIIIlIIIII = 9;
            }
            else if (lllllllllllllllIIlIlIIlIIIlIIIIl.endsWith("4x4")) {
                lllllllllllllllIIlIlIIlIIIlIIIII = 10;
            }
        }
        return lllllllllllllllIIlIlIIlIIIlIIIII;
    }
    
    private void uploadFloat() {
        switch (this.uniformType) {
            case 4: {
                OpenGlHelper.glUniform1(this.uniformLocation, this.uniformFloatBuffer);
                break;
            }
            case 5: {
                OpenGlHelper.glUniform2(this.uniformLocation, this.uniformFloatBuffer);
                break;
            }
            case 6: {
                OpenGlHelper.glUniform3(this.uniformLocation, this.uniformFloatBuffer);
                break;
            }
            case 7: {
                OpenGlHelper.glUniform4(this.uniformLocation, this.uniformFloatBuffer);
                break;
            }
            default: {
                ShaderUniform.LOGGER.warn("Uniform.upload called, but count value ({}) is not in the range of 1 to 4. Ignoring.", (Object)this.uniformCount);
                break;
            }
        }
    }
    
    public void upload() {
        if (!this.dirty) {}
        this.dirty = false;
        if (this.uniformType <= 3) {
            this.uploadInt();
        }
        else if (this.uniformType <= 7) {
            this.uploadFloat();
        }
        else {
            if (this.uniformType > 10) {
                ShaderUniform.LOGGER.warn("Uniform.upload called, but type value ({}) is not a valid type. Ignoring.", (Object)this.uniformType);
                return;
            }
            this.uploadFloatMatrix();
        }
    }
    
    public void set(final int lllllllllllllllIIlIlIIIlllIlIlIl, final int lllllllllllllllIIlIlIIIlllIlIlII, final int lllllllllllllllIIlIlIIIlllIIlllI, final int lllllllllllllllIIlIlIIIlllIlIIlI) {
        this.uniformIntBuffer.position(0);
        if (this.uniformType >= 0) {
            this.uniformIntBuffer.put(0, lllllllllllllllIIlIlIIIlllIlIlIl);
        }
        if (this.uniformType >= 1) {
            this.uniformIntBuffer.put(1, lllllllllllllllIIlIlIIIlllIlIlII);
        }
        if (this.uniformType >= 2) {
            this.uniformIntBuffer.put(2, lllllllllllllllIIlIlIIIlllIIlllI);
        }
        if (this.uniformType >= 3) {
            this.uniformIntBuffer.put(3, lllllllllllllllIIlIlIIIlllIlIIlI);
        }
        this.markDirty();
    }
    
    public void setSafe(final float lllllllllllllllIIlIlIIIlllIlllll, final float lllllllllllllllIIlIlIIIllllIIIll, final float lllllllllllllllIIlIlIIIllllIIIlI, final float lllllllllllllllIIlIlIIIlllIlllII) {
        this.uniformFloatBuffer.position(0);
        if (this.uniformType >= 4) {
            this.uniformFloatBuffer.put(0, lllllllllllllllIIlIlIIIlllIlllll);
        }
        if (this.uniformType >= 5) {
            this.uniformFloatBuffer.put(1, lllllllllllllllIIlIlIIIllllIIIll);
        }
        if (this.uniformType >= 6) {
            this.uniformFloatBuffer.put(2, lllllllllllllllIIlIlIIIllllIIIlI);
        }
        if (this.uniformType >= 7) {
            this.uniformFloatBuffer.put(3, lllllllllllllllIIlIlIIIlllIlllII);
        }
        this.markDirty();
    }
}
