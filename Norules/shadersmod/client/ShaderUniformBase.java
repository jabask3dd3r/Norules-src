package shadersmod.client;

import org.lwjgl.opengl.*;

public abstract class ShaderUniformBase
{
    private /* synthetic */ int program;
    private /* synthetic */ int location;
    private /* synthetic */ String name;
    
    public String getName() {
        return this.name;
    }
    
    public int getProgram() {
        return this.program;
    }
    
    public void setProgram(final int lllllllllllllllIIIlIllIlIIlIlllI) {
        if (this.program != lllllllllllllllIIIlIllIlIIlIlllI) {
            this.program = lllllllllllllllIIIlIllIlIIlIlllI;
            this.location = ARBShaderObjects.glGetUniformLocationARB(lllllllllllllllIIIlIllIlIIlIlllI, (CharSequence)this.name);
            this.onProgramChanged();
        }
    }
    
    public ShaderUniformBase(final String lllllllllllllllIIIlIllIlIIlllIlI) {
        this.program = -1;
        this.location = -1;
        this.name = lllllllllllllllIIIlIllIlIIlllIlI;
    }
    
    public boolean isDefined() {
        return this.location >= 0;
    }
    
    protected abstract void onProgramChanged();
    
    public int getLocation() {
        return this.location;
    }
}
