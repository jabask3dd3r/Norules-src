package optifine;

import net.minecraft.client.gui.*;
import net.minecraft.client.settings.*;

public class GuiOptionSliderOF extends GuiOptionSlider implements IOptionControl
{
    private /* synthetic */ GameSettings.Options option;
    
    public GuiOptionSliderOF(final int lllllllllllllIllllIIlIIIIllIIlII, final int lllllllllllllIllllIIlIIIIllIIIll, final int lllllllllllllIllllIIlIIIIlIlllIl, final GameSettings.Options lllllllllllllIllllIIlIIIIllIIIIl) {
        super(lllllllllllllIllllIIlIIIIllIIlII, lllllllllllllIllllIIlIIIIllIIIll, lllllllllllllIllllIIlIIIIlIlllIl, lllllllllllllIllllIIlIIIIllIIIIl);
        this.option = null;
        this.option = lllllllllllllIllllIIlIIIIllIIIIl;
    }
    
    @Override
    public GameSettings.Options getOption() {
        return this.option;
    }
}
