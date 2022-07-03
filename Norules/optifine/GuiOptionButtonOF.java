package optifine;

import net.minecraft.client.gui.*;
import net.minecraft.client.settings.*;

public class GuiOptionButtonOF extends GuiOptionButton implements IOptionControl
{
    private /* synthetic */ GameSettings.Options option;
    
    public GuiOptionButtonOF(final int lllllllllllllIIIllIllIlIIIllIlll, final int lllllllllllllIIIllIllIlIIIllIllI, final int lllllllllllllIIIllIllIlIIIllIlIl, final GameSettings.Options lllllllllllllIIIllIllIlIIIlllIlI, final String lllllllllllllIIIllIllIlIIIlllIIl) {
        super(lllllllllllllIIIllIllIlIIIllIlll, lllllllllllllIIIllIllIlIIIllIllI, lllllllllllllIIIllIllIlIIIllIlIl, lllllllllllllIIIllIllIlIIIlllIlI, lllllllllllllIIIllIllIlIIIlllIIl);
        this.option = null;
        this.option = lllllllllllllIIIllIllIlIIIlllIlI;
    }
    
    @Override
    public GameSettings.Options getOption() {
        return this.option;
    }
}
