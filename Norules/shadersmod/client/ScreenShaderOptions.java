package shadersmod.client;

public class ScreenShaderOptions
{
    private /* synthetic */ ShaderOption[] shaderOptions;
    private /* synthetic */ String name;
    private /* synthetic */ int columns;
    
    public ScreenShaderOptions(final String lllIIIlllIlllll, final ShaderOption[] lllIIIllllIIIlI, final int lllIIIlllIlllIl) {
        this.name = lllIIIlllIlllll;
        this.shaderOptions = lllIIIllllIIIlI;
        this.columns = lllIIIlllIlllIl;
    }
    
    public ShaderOption[] getShaderOptions() {
        return this.shaderOptions;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getColumns() {
        return this.columns;
    }
}
