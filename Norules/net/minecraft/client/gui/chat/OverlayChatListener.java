package net.minecraft.client.gui.chat;

import net.minecraft.client.*;
import net.minecraft.util.text.*;

public class OverlayChatListener implements IChatListener
{
    private final /* synthetic */ Minecraft field_192577_a;
    
    @Override
    public void func_192576_a(final ChatType llllllllllllllIlllIIllIlllIIIIII, final ITextComponent llllllllllllllIlllIIllIllIllllll) {
        this.field_192577_a.ingameGUI.setRecordPlaying(llllllllllllllIlllIIllIllIllllll, false);
    }
    
    public OverlayChatListener(final Minecraft llllllllllllllIlllIIllIlllIIIllI) {
        this.field_192577_a = llllllllllllllIlllIIllIlllIIIllI;
    }
}
