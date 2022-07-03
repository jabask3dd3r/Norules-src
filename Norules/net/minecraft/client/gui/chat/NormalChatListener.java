package net.minecraft.client.gui.chat;

import net.minecraft.client.*;
import net.minecraft.util.text.*;

public class NormalChatListener implements IChatListener
{
    private final /* synthetic */ Minecraft field_192581_a;
    
    @Override
    public void func_192576_a(final ChatType lllllllllllllllllllIlIIlIIlIlIIl, final ITextComponent lllllllllllllllllllIlIIlIIlIIllI) {
        this.field_192581_a.ingameGUI.getChatGUI().printChatMessage(lllllllllllllllllllIlIIlIIlIIllI);
    }
    
    public NormalChatListener(final Minecraft lllllllllllllllllllIlIIlIIlIllll) {
        this.field_192581_a = lllllllllllllllllllIlIIlIIlIllll;
    }
}
