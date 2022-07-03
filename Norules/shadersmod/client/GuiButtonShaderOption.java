package shadersmod.client;

import net.minecraft.client.gui.*;

public class GuiButtonShaderOption extends GuiButton
{
    private /* synthetic */ ShaderOption shaderOption;
    
    public void valueChanged() {
    }
    
    public ShaderOption getShaderOption() {
        return this.shaderOption;
    }
    
    public GuiButtonShaderOption(final int lllllllllllllIlIIIIlllIIIIlllIlI, final int lllllllllllllIlIIIIlllIIIIllIIIl, final int lllllllllllllIlIIIIlllIIIIllIIII, final int lllllllllllllIlIIIIlllIIIIlIllll, final int lllllllllllllIlIIIIlllIIIIlIlllI, final ShaderOption lllllllllllllIlIIIIlllIIIIlIllIl, final String lllllllllllllIlIIIIlllIIIIllIlII) {
        super(lllllllllllllIlIIIIlllIIIIlllIlI, lllllllllllllIlIIIIlllIIIIllIIIl, lllllllllllllIlIIIIlllIIIIllIIII, lllllllllllllIlIIIIlllIIIIlIllll, lllllllllllllIlIIIIlllIIIIlIlllI, lllllllllllllIlIIIIlllIIIIllIlII);
        this.shaderOption = null;
        this.shaderOption = lllllllllllllIlIIIIlllIIIIlIllIl;
    }
}
