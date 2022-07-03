package net.minecraft.client.gui;

import net.minecraft.client.settings.*;
import net.minecraft.client.resources.*;
import com.google.common.collect.*;
import java.util.*;
import java.io.*;

public class GuiSnooper extends GuiScreen
{
    private /* synthetic */ GuiButton toggleButton;
    private /* synthetic */ List list;
    private /* synthetic */ String title;
    private final /* synthetic */ java.util.List<String> values;
    private final /* synthetic */ java.util.List<String> keys;
    private /* synthetic */ String[] desc;
    private final /* synthetic */ GameSettings game_settings_2;
    private final /* synthetic */ GuiScreen lastScreen;
    
    @Override
    public void initGui() {
        this.title = I18n.format("options.snooper.title", new Object[0]);
        final String lllllllllllllIIlIllllllllIlllIlI = I18n.format("options.snooper.desc", new Object[0]);
        final java.util.List<String> lllllllllllllIIlIllllllllIlllIIl = (java.util.List<String>)Lists.newArrayList();
        for (final String lllllllllllllIIlIllllllllIlllIII : this.fontRendererObj.listFormattedStringToWidth(lllllllllllllIIlIllllllllIlllIlI, this.width - 30)) {
            lllllllllllllIIlIllllllllIlllIIl.add(lllllllllllllIIlIllllllllIlllIII);
        }
        this.desc = lllllllllllllIIlIllllllllIlllIIl.toArray(new String[lllllllllllllIIlIllllllllIlllIIl.size()]);
        this.keys.clear();
        this.values.clear();
        this.toggleButton = this.addButton(new GuiButton(1, this.width / 2 - 152, this.height - 30, 150, 20, this.game_settings_2.getKeyBinding(GameSettings.Options.SNOOPER_ENABLED)));
        this.buttonList.add(new GuiButton(2, this.width / 2 + 2, this.height - 30, 150, 20, I18n.format("gui.done", new Object[0])));
        final boolean lllllllllllllIIlIllllllllIllIlll = this.mc.getIntegratedServer() != null && this.mc.getIntegratedServer().getPlayerUsageSnooper() != null;
        for (final Map.Entry<String, String> lllllllllllllIIlIllllllllIllIllI : new TreeMap(this.mc.getPlayerUsageSnooper().getCurrentStats()).entrySet()) {
            this.keys.add(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIlIllllllllIllIlll ? "C " : "")).append(lllllllllllllIIlIllllllllIllIllI.getKey())));
            this.values.add(this.fontRendererObj.trimStringToWidth(lllllllllllllIIlIllllllllIllIllI.getValue(), this.width - 220));
        }
        if (lllllllllllllIIlIllllllllIllIlll) {
            for (final Map.Entry<String, String> lllllllllllllIIlIllllllllIllIlIl : new TreeMap(this.mc.getIntegratedServer().getPlayerUsageSnooper().getCurrentStats()).entrySet()) {
                this.keys.add(String.valueOf(new StringBuilder("S ").append(lllllllllllllIIlIllllllllIllIlIl.getKey())));
                this.values.add(this.fontRendererObj.trimStringToWidth(lllllllllllllIIlIllllllllIllIlIl.getValue(), this.width - 220));
            }
        }
        this.list = new List();
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIlIllllllllIIlIlIl, final int lllllllllllllIIlIllllllllIIllIlI, final float lllllllllllllIIlIllllllllIIlIIll) {
        this.drawDefaultBackground();
        this.list.drawScreen(lllllllllllllIIlIllllllllIIlIlIl, lllllllllllllIIlIllllllllIIllIlI, lllllllllllllIIlIllllllllIIlIIll);
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 8, 16777215);
        int lllllllllllllIIlIllllllllIIllIII = 22;
        final double lllllllllllllIIlIllllllllIIIlllI;
        final Exception lllllllllllllIIlIllllllllIIIllll = (Exception)((String[])(Object)(lllllllllllllIIlIllllllllIIIlllI = (double)(Object)this.desc)).length;
        for (final String lllllllllllllIIlIllllllllIIlIlll : lllllllllllllIIlIllllllllIIIlllI) {
            this.drawCenteredString(this.fontRendererObj, lllllllllllllIIlIllllllllIIlIlll, this.width / 2, lllllllllllllIIlIllllllllIIllIII, 8421504);
            lllllllllllllIIlIllllllllIIllIII += this.fontRendererObj.FONT_HEIGHT;
        }
        super.drawScreen(lllllllllllllIIlIllllllllIIlIlIl, lllllllllllllIIlIllllllllIIllIlI, lllllllllllllIIlIllllllllIIlIIll);
    }
    
    public GuiSnooper(final GuiScreen lllllllllllllIIlIlllllllllIIIllI, final GameSettings lllllllllllllIIlIlllllllllIIIlIl) {
        this.keys = (java.util.List<String>)Lists.newArrayList();
        this.values = (java.util.List<String>)Lists.newArrayList();
        this.lastScreen = lllllllllllllIIlIlllllllllIIIllI;
        this.game_settings_2 = lllllllllllllIIlIlllllllllIIIlIl;
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIIlIllllllllIlIlIII) throws IOException {
        if (lllllllllllllIIlIllllllllIlIlIII.enabled) {
            if (lllllllllllllIIlIllllllllIlIlIII.id == 2) {
                this.game_settings_2.saveOptions();
                this.game_settings_2.saveOptions();
                this.mc.displayGuiScreen(this.lastScreen);
            }
            if (lllllllllllllIIlIllllllllIlIlIII.id == 1) {
                this.game_settings_2.setOptionValue(GameSettings.Options.SNOOPER_ENABLED, 1);
                this.toggleButton.displayString = this.game_settings_2.getKeyBinding(GameSettings.Options.SNOOPER_ENABLED);
            }
        }
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.list.handleMouseInput();
    }
    
    class List extends GuiSlot
    {
        public List() {
            super(GuiSnooper.this.mc, GuiSnooper.this.width, GuiSnooper.this.height, 80, GuiSnooper.this.height - 40, GuiSnooper.this.fontRendererObj.FONT_HEIGHT + 1);
        }
        
        @Override
        protected int getSize() {
            return GuiSnooper.this.keys.size();
        }
        
        @Override
        protected void elementClicked(final int llllllllllllllllIlIlllllIlllIlIl, final boolean llllllllllllllllIlIlllllIlllIlII, final int llllllllllllllllIlIlllllIlllIIll, final int llllllllllllllllIlIlllllIlllIIlI) {
        }
        
        @Override
        protected void func_192637_a(final int llllllllllllllllIlIlllllIllIlIlI, final int llllllllllllllllIlIlllllIllIlIIl, final int llllllllllllllllIlIlllllIllIIIIl, final int llllllllllllllllIlIlllllIllIIlll, final int llllllllllllllllIlIlllllIllIIllI, final int llllllllllllllllIlIlllllIllIIlIl, final float llllllllllllllllIlIlllllIllIIlII) {
            GuiSnooper.this.fontRendererObj.drawString(GuiSnooper.this.keys.get(llllllllllllllllIlIlllllIllIlIlI), 10.0, llllllllllllllllIlIlllllIllIIIIl, 16777215);
            GuiSnooper.this.fontRendererObj.drawString(GuiSnooper.this.values.get(llllllllllllllllIlIlllllIllIlIlI), 230.0, llllllllllllllllIlIlllllIllIIIIl, 16777215);
        }
        
        @Override
        protected int getScrollBarX() {
            return this.width - 10;
        }
        
        @Override
        protected boolean isSelected(final int llllllllllllllllIlIlllllIlllIIII) {
            return false;
        }
        
        @Override
        protected void drawBackground() {
        }
    }
}
