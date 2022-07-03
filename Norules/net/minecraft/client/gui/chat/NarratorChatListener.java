package net.minecraft.client.gui.chat;

import com.mojang.text2speech.*;
import net.minecraft.client.settings.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.toasts.*;
import net.minecraft.util.text.*;

public class NarratorChatListener implements IChatListener
{
    private final /* synthetic */ Narrator field_192580_a;
    
    public void func_193642_b() {
        this.field_192580_a.clear();
    }
    
    public void func_193641_a(final int lllllllllllllIIlIllIIlIIlllIIlIl) {
        this.field_192580_a.clear();
        this.field_192580_a.say(String.valueOf(new StringBuilder(String.valueOf(new TextComponentTranslation("options.narrator", new Object[0]).getUnformattedText())).append(" : ").append(new TextComponentTranslation(GameSettings.field_193632_b[lllllllllllllIIlIllIIlIIlllIIlIl], new Object[0]).getUnformattedText())));
        final GuiToast lllllllllllllIIlIllIIlIIlllIIlll = Minecraft.getMinecraft().func_193033_an();
        if (this.field_192580_a.active()) {
            if (lllllllllllllIIlIllIIlIIlllIIlIl == 0) {
                SystemToast.func_193657_a(lllllllllllllIIlIllIIlIIlllIIlll, SystemToast.Type.NARRATOR_TOGGLE, new TextComponentTranslation("narrator.toast.disabled", new Object[0]), null);
            }
            else {
                SystemToast.func_193657_a(lllllllllllllIIlIllIIlIIlllIIlll, SystemToast.Type.NARRATOR_TOGGLE, new TextComponentTranslation("narrator.toast.enabled", new Object[0]), new TextComponentTranslation(GameSettings.field_193632_b[lllllllllllllIIlIllIIlIIlllIIlIl], new Object[0]));
            }
        }
        else {
            SystemToast.func_193657_a(lllllllllllllIIlIllIIlIIlllIIlll, SystemToast.Type.NARRATOR_TOGGLE, new TextComponentTranslation("narrator.toast.disabled", new Object[0]), new TextComponentTranslation("options.narrator.notavailable", new Object[0]));
        }
    }
    
    public NarratorChatListener() {
        this.field_192580_a = Narrator.getNarrator();
    }
    
    public boolean func_193640_a() {
        return this.field_192580_a.active();
    }
    
    static {
        field_193643_a = new NarratorChatListener();
    }
    
    @Override
    public void func_192576_a(final ChatType lllllllllllllIIlIllIIlIIllllIIll, final ITextComponent lllllllllllllIIlIllIIlIIllllIIlI) {
        final int lllllllllllllIIlIllIIlIIllllIIIl = Minecraft.getMinecraft().gameSettings.field_192571_R;
        if (lllllllllllllIIlIllIIlIIllllIIIl != 0 && this.field_192580_a.active() && (lllllllllllllIIlIllIIlIIllllIIIl == 1 || (lllllllllllllIIlIllIIlIIllllIIIl == 2 && lllllllllllllIIlIllIIlIIllllIIll == ChatType.CHAT) || (lllllllllllllIIlIllIIlIIllllIIIl == 3 && lllllllllllllIIlIllIIlIIllllIIll == ChatType.SYSTEM))) {
            if (lllllllllllllIIlIllIIlIIllllIIlI instanceof TextComponentTranslation && "chat.type.text".equals(((TextComponentTranslation)lllllllllllllIIlIllIIlIIllllIIlI).getKey())) {
                this.field_192580_a.say(new TextComponentTranslation("chat.type.text.narrate", ((TextComponentTranslation)lllllllllllllIIlIllIIlIIllllIIlI).getFormatArgs()).getUnformattedText());
            }
            else {
                this.field_192580_a.say(lllllllllllllIIlIllIIlIIllllIIlI.getUnformattedText());
            }
        }
    }
}
