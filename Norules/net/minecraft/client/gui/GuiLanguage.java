package net.minecraft.client.gui;

import net.minecraft.client.settings.*;
import java.io.*;
import java.util.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.*;
import com.google.common.collect.*;

public class GuiLanguage extends GuiScreen
{
    private /* synthetic */ List list;
    private /* synthetic */ GuiOptionButton forceUnicodeFontBtn;
    private final /* synthetic */ LanguageManager languageManager;
    protected /* synthetic */ GuiScreen parentScreen;
    private final /* synthetic */ GameSettings game_settings_3;
    private /* synthetic */ GuiOptionButton confirmSettingsBtn;
    
    @Override
    public void initGui() {
        this.forceUnicodeFontBtn = this.addButton(new GuiOptionButton(100, this.width / 2 - 155, this.height - 38, GameSettings.Options.FORCE_UNICODE_FONT, this.game_settings_3.getKeyBinding(GameSettings.Options.FORCE_UNICODE_FONT)));
        this.confirmSettingsBtn = this.addButton(new GuiOptionButton(6, this.width / 2 - 155 + 160, this.height - 38, I18n.format("gui.done", new Object[0])));
        this.list = new List(this.mc);
        this.list.registerScrollButtons(7, 8);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIlIIIIIllIIIIlIllIl) throws IOException {
        if (lllllllllllllIlIIIIIllIIIIlIllIl.enabled) {
            switch (lllllllllllllIlIIIIIllIIIIlIllIl.id) {
                case 5: {
                    break;
                }
                case 6: {
                    this.mc.displayGuiScreen(this.parentScreen);
                    break;
                }
                case 100: {
                    if (lllllllllllllIlIIIIIllIIIIlIllIl instanceof GuiOptionButton) {
                        this.game_settings_3.setOptionValue(((GuiOptionButton)lllllllllllllIlIIIIIllIIIIlIllIl).returnEnumOptions(), 1);
                        lllllllllllllIlIIIIIllIIIIlIllIl.displayString = this.game_settings_3.getKeyBinding(GameSettings.Options.FORCE_UNICODE_FONT);
                        final ScaledResolution lllllllllllllIlIIIIIllIIIIllIIIl = new ScaledResolution(this.mc);
                        final int lllllllllllllIlIIIIIllIIIIllIIII = lllllllllllllIlIIIIIllIIIIllIIIl.getScaledWidth();
                        final int lllllllllllllIlIIIIIllIIIIlIllll = lllllllllllllIlIIIIIllIIIIllIIIl.getScaledHeight();
                        this.setWorldAndResolution(this.mc, lllllllllllllIlIIIIIllIIIIllIIII, lllllllllllllIlIIIIIllIIIIlIllll);
                        break;
                    }
                    break;
                }
                default: {
                    this.list.actionPerformed(lllllllllllllIlIIIIIllIIIIlIllIl);
                    break;
                }
            }
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIlIIIIIllIIIIlIIlII, final int lllllllllllllIlIIIIIllIIIIlIIIll, final float lllllllllllllIlIIIIIllIIIIIllllI) {
        this.list.drawScreen(lllllllllllllIlIIIIIllIIIIlIIlII, lllllllllllllIlIIIIIllIIIIlIIIll, lllllllllllllIlIIIIIllIIIIIllllI);
        this.drawCenteredString(this.fontRendererObj, I18n.format("options.language", new Object[0]), this.width / 2, 16, 16777215);
        this.drawCenteredString(this.fontRendererObj, String.valueOf(new StringBuilder("(").append(I18n.format("options.languageWarning", new Object[0])).append(")")), this.width / 2, this.height - 56, 8421504);
        super.drawScreen(lllllllllllllIlIIIIIllIIIIlIIlII, lllllllllllllIlIIIIIllIIIIlIIIll, lllllllllllllIlIIIIIllIIIIIllllI);
    }
    
    public GuiLanguage(final GuiScreen lllllllllllllIlIIIIIllIIIlIIIlIl, final GameSettings lllllllllllllIlIIIIIllIIIlIIIlII, final LanguageManager lllllllllllllIlIIIIIllIIIIllllll) {
        this.parentScreen = lllllllllllllIlIIIIIllIIIlIIIlIl;
        this.game_settings_3 = lllllllllllllIlIIIIIllIIIlIIIlII;
        this.languageManager = lllllllllllllIlIIIIIllIIIIllllll;
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.list.handleMouseInput();
    }
    
    class List extends GuiSlot
    {
        private final /* synthetic */ java.util.List<String> langCodeList;
        private final /* synthetic */ Map<String, Language> languageMap;
        
        @Override
        protected boolean isSelected(final int llllllllllllIlllllllIlIlIllllllI) {
            return this.langCodeList.get(llllllllllllIlllllllIlIlIllllllI).equals(GuiLanguage.this.languageManager.getCurrentLanguage().getLanguageCode());
        }
        
        @Override
        protected int getSize() {
            return this.langCodeList.size();
        }
        
        @Override
        protected void elementClicked(final int llllllllllllIlllllllIlIllIIIlIll, final boolean llllllllllllIlllllllIlIllIIIlIlI, final int llllllllllllIlllllllIlIllIIIlIIl, final int llllllllllllIlllllllIlIllIIIlIII) {
            final Language llllllllllllIlllllllIlIllIIIIlll = this.languageMap.get(this.langCodeList.get(llllllllllllIlllllllIlIllIIIlIll));
            GuiLanguage.this.languageManager.setCurrentLanguage(llllllllllllIlllllllIlIllIIIIlll);
            GuiLanguage.this.game_settings_3.language = llllllllllllIlllllllIlIllIIIIlll.getLanguageCode();
            this.mc.refreshResources();
            GuiLanguage.this.fontRendererObj.setUnicodeFlag(GuiLanguage.this.languageManager.isCurrentLocaleUnicode() || GuiLanguage.this.game_settings_3.forceUnicodeFont);
            GuiLanguage.this.fontRendererObj.setBidiFlag(GuiLanguage.this.languageManager.isCurrentLanguageBidirectional());
            GuiLanguage.this.confirmSettingsBtn.displayString = I18n.format("gui.done", new Object[0]);
            GuiLanguage.this.forceUnicodeFontBtn.displayString = GuiLanguage.this.game_settings_3.getKeyBinding(GameSettings.Options.FORCE_UNICODE_FONT);
            GuiLanguage.this.game_settings_3.saveOptions();
        }
        
        @Override
        protected void func_192637_a(final int llllllllllllIlllllllIlIlIlllIIll, final int llllllllllllIlllllllIlIlIlllIIlI, final int llllllllllllIlllllllIlIlIlllIIIl, final int llllllllllllIlllllllIlIlIlllIIII, final int llllllllllllIlllllllIlIlIllIllll, final int llllllllllllIlllllllIlIlIllIlllI, final float llllllllllllIlllllllIlIlIllIllIl) {
            GuiLanguage.this.fontRendererObj.setBidiFlag(true);
            GuiLanguage.this.drawCenteredString(GuiLanguage.this.fontRendererObj, this.languageMap.get(this.langCodeList.get(llllllllllllIlllllllIlIlIlllIIll)).toString(), this.width / 2, llllllllllllIlllllllIlIlIlllIIIl + 1, 16777215);
            GuiLanguage.this.fontRendererObj.setBidiFlag(GuiLanguage.this.languageManager.getCurrentLanguage().isBidirectional());
        }
        
        @Override
        protected int getContentHeight() {
            return this.getSize() * 18;
        }
        
        @Override
        protected void drawBackground() {
            GuiLanguage.this.drawDefaultBackground();
        }
        
        public List(final Minecraft llllllllllllIlllllllIlIllIIlIlIl) {
            super(llllllllllllIlllllllIlIllIIlIlIl, GuiLanguage.this.width, GuiLanguage.this.height, 32, GuiLanguage.this.height - 65 + 4, 18);
            this.langCodeList = (java.util.List<String>)Lists.newArrayList();
            this.languageMap = (Map<String, Language>)Maps.newHashMap();
            for (final Language llllllllllllIlllllllIlIllIIllIII : GuiLanguage.this.languageManager.getLanguages()) {
                this.languageMap.put(llllllllllllIlllllllIlIllIIllIII.getLanguageCode(), llllllllllllIlllllllIlIllIIllIII);
                this.langCodeList.add(llllllllllllIlllllllIlIllIIllIII.getLanguageCode());
            }
        }
    }
}
