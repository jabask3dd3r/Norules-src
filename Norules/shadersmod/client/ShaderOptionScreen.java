package shadersmod.client;

public class ShaderOptionScreen extends ShaderOption
{
    @Override
    public String getNameText() {
        return Shaders.translate(String.valueOf(new StringBuilder("screen.").append(this.getName())), this.getName());
    }
    
    public ShaderOptionScreen(final String lllllllllllllIllIIIlIlIIllIlIlIl) {
        super(lllllllllllllIllIIIlIlIIllIlIlIl, null, null, new String[0], null, null);
    }
    
    @Override
    public String getDescriptionText() {
        return Shaders.translate(String.valueOf(new StringBuilder("screen.").append(this.getName()).append(".comment")), null);
    }
}
