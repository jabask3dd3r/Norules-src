package shadersmod.client;

import org.lwjgl.opengl.*;

public class ShaderUniformFloat4 extends ShaderUniformBase
{
    private /* synthetic */ float[] values;
    
    public void setValue(final float llllllllllllllIlIllIlIIIlIIIIIIl, final float llllllllllllllIlIllIlIIIlIIIIlIl, final float llllllllllllllIlIllIlIIIIlllllll, final float llllllllllllllIlIllIlIIIIllllllI) {
        if (this.getLocation() >= 0 && (this.values[0] != llllllllllllllIlIllIlIIIlIIIIIIl || this.values[1] != llllllllllllllIlIllIlIIIlIIIIlIl || this.values[2] != llllllllllllllIlIllIlIIIIlllllll || this.values[3] != llllllllllllllIlIllIlIIIIllllllI)) {
            ARBShaderObjects.glUniform4fARB(this.getLocation(), llllllllllllllIlIllIlIIIlIIIIIIl, llllllllllllllIlIllIlIIIlIIIIlIl, llllllllllllllIlIllIlIIIIlllllll, llllllllllllllIlIllIlIIIIllllllI);
            Shaders.checkGLError(this.getName());
            this.values[0] = llllllllllllllIlIllIlIIIlIIIIIIl;
            this.values[1] = llllllllllllllIlIllIlIIIlIIIIlIl;
            this.values[2] = llllllllllllllIlIllIlIIIIlllllll;
            this.values[3] = llllllllllllllIlIllIlIIIIllllllI;
        }
    }
    
    public float[] getValues() {
        return this.values;
    }
    
    public ShaderUniformFloat4(final String llllllllllllllIlIllIlIIIlIIlIIII) {
        super(llllllllllllllIlIllIlIIIlIIlIIII);
        this.values = new float[4];
    }
    
    @Override
    protected void onProgramChanged() {
        this.values[0] = 0.0f;
        this.values[1] = 0.0f;
        this.values[2] = 0.0f;
        this.values[3] = 0.0f;
    }
}
