package net.minecraft.client.gui;

import net.minecraft.client.settings.*;
import java.io.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.gui.chat.*;

public class ScreenChatOptions extends GuiScreen
{
    private static final /* synthetic */ GameSettings.Options[] CHAT_OPTIONS;
    private /* synthetic */ GuiOptionButton field_193025_i;
    private final /* synthetic */ GuiScreen parentScreen;
    private final /* synthetic */ GameSettings game_settings;
    private /* synthetic */ String chatTitle;
    
    public ScreenChatOptions(final GuiScreen lllllllllllllllIIIIIIllllIIIlIlI, final GameSettings lllllllllllllllIIIIIIllllIIIllII) {
        this.parentScreen = lllllllllllllllIIIIIIllllIIIlIlI;
        this.game_settings = lllllllllllllllIIIIIIllllIIIllII;
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllllIIIIIIlllIllIllll, final int lllllllllllllllIIIIIIlllIlllIIIl) throws IOException {
        if (lllllllllllllllIIIIIIlllIlllIIIl == 1) {
            this.mc.gameSettings.saveOptions();
        }
        super.keyTyped(lllllllllllllllIIIIIIlllIllIllll, lllllllllllllllIIIIIIlllIlllIIIl);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllIIIIIIlllIllIlIlI) throws IOException {
        if (lllllllllllllllIIIIIIlllIllIlIlI.enabled) {
            if (lllllllllllllllIIIIIIlllIllIlIlI.id < 100 && lllllllllllllllIIIIIIlllIllIlIlI instanceof GuiOptionButton) {
                this.game_settings.setOptionValue(((GuiOptionButton)lllllllllllllllIIIIIIlllIllIlIlI).returnEnumOptions(), 1);
                lllllllllllllllIIIIIIlllIllIlIlI.displayString = this.game_settings.getKeyBinding(GameSettings.Options.getEnumOptions(lllllllllllllllIIIIIIlllIllIlIlI.id));
            }
            if (lllllllllllllllIIIIIIlllIllIlIlI.id == 200) {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parentScreen);
            }
        }
    }
    
    static {
        CHAT_OPTIONS = new GameSettings.Options[] { GameSettings.Options.CHAT_VISIBILITY, GameSettings.Options.CHAT_COLOR, GameSettings.Options.CHAT_LINKS, GameSettings.Options.CHAT_OPACITY, GameSettings.Options.CHAT_LINKS_PROMPT, GameSettings.Options.CHAT_SCALE, GameSettings.Options.CHAT_HEIGHT_FOCUSED, GameSettings.Options.CHAT_HEIGHT_UNFOCUSED, GameSettings.Options.CHAT_WIDTH, GameSettings.Options.REDUCED_DEBUG_INFO, GameSettings.Options.NARRATOR };
    }
    
    @Override
    public void initGui() {
        this.chatTitle = I18n.format("options.chat.title", new Object[0]);
        int lllllllllllllllIIIIIIllllIIIIIII = 0;
        final char lllllllllllllllIIIIIIlllIllllIII;
        final long lllllllllllllllIIIIIIlllIllllIIl = ((GameSettings.Options[])(Object)(lllllllllllllllIIIIIIlllIllllIII = (char)(Object)ScreenChatOptions.CHAT_OPTIONS)).length;
        for (short lllllllllllllllIIIIIIlllIllllIlI = 0; lllllllllllllllIIIIIIlllIllllIlI < lllllllllllllllIIIIIIlllIllllIIl; ++lllllllllllllllIIIIIIlllIllllIlI) {
            final GameSettings.Options lllllllllllllllIIIIIIlllIlllllll = lllllllllllllllIIIIIIlllIllllIII[lllllllllllllllIIIIIIlllIllllIlI];
            if (lllllllllllllllIIIIIIlllIlllllll.getEnumFloat()) {
                this.buttonList.add(new GuiOptionSlider(lllllllllllllllIIIIIIlllIlllllll.returnEnumOrdinal(), this.width / 2 - 155 + lllllllllllllllIIIIIIllllIIIIIII % 2 * 160, this.height / 6 + 24 * (lllllllllllllllIIIIIIllllIIIIIII >> 1), lllllllllllllllIIIIIIlllIlllllll));
            }
            else {
                final GuiOptionButton lllllllllllllllIIIIIIlllIllllllI = new GuiOptionButton(lllllllllllllllIIIIIIlllIlllllll.returnEnumOrdinal(), this.width / 2 - 155 + lllllllllllllllIIIIIIllllIIIIIII % 2 * 160, this.height / 6 + 24 * (lllllllllllllllIIIIIIllllIIIIIII >> 1), lllllllllllllllIIIIIIlllIlllllll, this.game_settings.getKeyBinding(lllllllllllllllIIIIIIlllIlllllll));
                this.buttonList.add(lllllllllllllllIIIIIIlllIllllllI);
                if (lllllllllllllllIIIIIIlllIlllllll == GameSettings.Options.NARRATOR) {
                    this.field_193025_i = lllllllllllllllIIIIIIlllIllllllI;
                    lllllllllllllllIIIIIIlllIllllllI.enabled = NarratorChatListener.field_193643_a.func_193640_a();
                }
            }
            ++lllllllllllllllIIIIIIllllIIIIIII;
        }
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 144, I18n.format("gui.done", new Object[0])));
    }
    
    public void func_193024_a() {
        this.field_193025_i.displayString = this.game_settings.getKeyBinding(GameSettings.Options.getEnumOptions(this.field_193025_i.id));
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllIIIIIIlllIllIIIlI, final int lllllllllllllllIIIIIIlllIllIIIIl, final float lllllllllllllllIIIIIIlllIlIlllII) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.chatTitle, this.width / 2, 20, 16777215);
        super.drawScreen(lllllllllllllllIIIIIIlllIllIIIlI, lllllllllllllllIIIIIIlllIllIIIIl, lllllllllllllllIIIIIIlllIlIlllII);
    }
}
