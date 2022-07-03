package shadersmod.client;

import org.lwjgl.opengl.*;

public class ShaderUniformInt extends ShaderUniformBase
{
    private /* synthetic */ int value;
    
    @Override
    protected void onProgramChanged() {
        this.value = -1;
    }
    
    public ShaderUniformInt(final String lllllllllllllIIlllIlIIlIlIIIlIIl) {
        super(lllllllllllllIIlllIlIIlIlIIIlIIl);
        this.value = -1;
    }
    
    public void setValue(final int lllllllllllllIIlllIlIIlIlIIIIIII) {
        if (this.getLocation() >= 0 && this.value != lllllllllllllIIlllIlIIlIlIIIIIII) {
            ARBShaderObjects.glUniform1iARB(this.getLocation(), lllllllllllllIIlllIlIIlIlIIIIIII);
            Shaders.checkGLError(this.getName());
            this.value = lllllllllllllIIlllIlIIlIlIIIIIII;
        }
    }
    
    public int getValue() {
        return this.value;
    }
}
