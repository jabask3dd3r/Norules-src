package net.minecraft.client.gui;

import net.minecraft.client.*;
import org.apache.commons.lang3.*;
import java.util.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.settings.*;
import net.minecraft.util.text.*;

public class GuiKeyBindingList extends GuiListExtended
{
    private final /* synthetic */ IGuiListEntry[] listEntries;
    private final /* synthetic */ Minecraft mc;
    private final /* synthetic */ GuiControls controlsScreen;
    private /* synthetic */ int maxListLabelWidth;
    
    @Override
    public int getListWidth() {
        return super.getListWidth() + 32;
    }
    
    @Override
    public IGuiListEntry getListEntry(final int llllllllllllllIlIIllIlIIIlIIlIlI) {
        return this.listEntries[llllllllllllllIlIIllIlIIIlIIlIlI];
    }
    
    public GuiKeyBindingList(final GuiControls llllllllllllllIlIIllIlIIIlIlllIl, final Minecraft llllllllllllllIlIIllIlIIIllIIlIl) {
        super(llllllllllllllIlIIllIlIIIllIIlIl, llllllllllllllIlIIllIlIIIlIlllIl.width + 45, llllllllllllllIlIIllIlIIIlIlllIl.height, 63, llllllllllllllIlIIllIlIIIlIlllIl.height - 32, 20);
        this.controlsScreen = llllllllllllllIlIIllIlIIIlIlllIl;
        this.mc = llllllllllllllIlIIllIlIIIllIIlIl;
        final KeyBinding[] llllllllllllllIlIIllIlIIIllIIlII = (KeyBinding[])ArrayUtils.clone((Object[])llllllllllllllIlIIllIlIIIllIIlIl.gameSettings.keyBindings);
        this.listEntries = new IGuiListEntry[llllllllllllllIlIIllIlIIIllIIlII.length + KeyBinding.getKeybinds().size()];
        Arrays.sort(llllllllllllllIlIIllIlIIIllIIlII);
        int llllllllllllllIlIIllIlIIIllIIIll = 0;
        String llllllllllllllIlIIllIlIIIllIIIlI = null;
        final char llllllllllllllIlIIllIlIIIlIlIlIl;
        final char llllllllllllllIlIIllIlIIIlIlIllI = (char)((KeyBinding[])(Object)(llllllllllllllIlIIllIlIIIlIlIlIl = (char)(Object)llllllllllllllIlIIllIlIIIllIIlII)).length;
        for (Exception llllllllllllllIlIIllIlIIIlIlIlll = (Exception)0; llllllllllllllIlIIllIlIIIlIlIlll < llllllllllllllIlIIllIlIIIlIlIllI; ++llllllllllllllIlIIllIlIIIlIlIlll) {
            final KeyBinding llllllllllllllIlIIllIlIIIllIIIIl = llllllllllllllIlIIllIlIIIlIlIlIl[llllllllllllllIlIIllIlIIIlIlIlll];
            final String llllllllllllllIlIIllIlIIIllIIIII = llllllllllllllIlIIllIlIIIllIIIIl.getKeyCategory();
            if (!llllllllllllllIlIIllIlIIIllIIIII.equals(llllllllllllllIlIIllIlIIIllIIIlI)) {
                llllllllllllllIlIIllIlIIIllIIIlI = llllllllllllllIlIIllIlIIIllIIIII;
                this.listEntries[llllllllllllllIlIIllIlIIIllIIIll++] = new CategoryEntry(llllllllllllllIlIIllIlIIIllIIIII);
            }
            final int llllllllllllllIlIIllIlIIIlIlllll = llllllllllllllIlIIllIlIIIllIIlIl.fontRendererObj.getStringWidth(I18n.format(llllllllllllllIlIIllIlIIIllIIIIl.getKeyDescription(), new Object[0]));
            if (llllllllllllllIlIIllIlIIIlIlllll > this.maxListLabelWidth) {
                this.maxListLabelWidth = llllllllllllllIlIIllIlIIIlIlllll;
            }
            this.listEntries[llllllllllllllIlIIllIlIIIllIIIll++] = new KeyEntry(llllllllllllllIlIIllIlIIIllIIIIl, (KeyEntry)null);
        }
    }
    
    @Override
    protected int getScrollBarX() {
        return super.getScrollBarX() + 15;
    }
    
    @Override
    protected int getSize() {
        return this.listEntries.length;
    }
    
    public class KeyEntry implements IGuiListEntry
    {
        private final /* synthetic */ GuiButton btnReset;
        private final /* synthetic */ KeyBinding keybinding;
        private final /* synthetic */ GuiButton btnChangeKeyBinding;
        private final /* synthetic */ String keyDesc;
        
        @Override
        public void func_192633_a(final int lllllllllllllIIIlIllIIIlIllIlIIl, final int lllllllllllllIIIlIllIIIlIllIlIII, final int lllllllllllllIIIlIllIIIlIllIIlll, final float lllllllllllllIIIlIllIIIlIllIIllI) {
        }
        
        @Override
        public void mouseReleased(final int lllllllllllllIIIlIllIIIlIlllIIll, final int lllllllllllllIIIlIllIIIlIllIllII, final int lllllllllllllIIIlIllIIIlIllIlIll, final int lllllllllllllIIIlIllIIIlIlllIIII, final int lllllllllllllIIIlIllIIIlIllIllll, final int lllllllllllllIIIlIllIIIlIllIlllI) {
            this.btnChangeKeyBinding.mouseReleased(lllllllllllllIIIlIllIIIlIllIllII, lllllllllllllIIIlIllIIIlIllIlIll);
            this.btnReset.mouseReleased(lllllllllllllIIIlIllIIIlIllIllII, lllllllllllllIIIlIllIIIlIllIlIll);
        }
        
        private KeyEntry(final KeyBinding lllllllllllllIIIlIllIIIllIlIlIIl) {
            this.keybinding = lllllllllllllIIIlIllIIIllIlIlIIl;
            this.keyDesc = I18n.format(lllllllllllllIIIlIllIIIllIlIlIIl.getKeyDescription(), new Object[0]);
            this.btnChangeKeyBinding = new GuiButton(0, 0, 0, 75, 20, I18n.format(lllllllllllllIIIlIllIIIllIlIlIIl.getKeyDescription(), new Object[0]));
            this.btnReset = new GuiButton(0, 0, 0, 50, 20, I18n.format("controls.reset", new Object[0]));
        }
        
        @Override
        public void func_192634_a(final int lllllllllllllIIIlIllIIIllIIllIlI, final int lllllllllllllIIIlIllIIIllIIllIIl, final int lllllllllllllIIIlIllIIIllIIIllII, final int lllllllllllllIIIlIllIIIllIIlIlll, final int lllllllllllllIIIlIllIIIllIIlIllI, final int lllllllllllllIIIlIllIIIllIIlIlIl, final int lllllllllllllIIIlIllIIIllIIlIlII, final boolean lllllllllllllIIIlIllIIIllIIlIIll, final float lllllllllllllIIIlIllIIIllIIlIIlI) {
            final boolean lllllllllllllIIIlIllIIIllIIlIIIl = GuiKeyBindingList.this.controlsScreen.buttonId == this.keybinding;
            GuiKeyBindingList.this.mc.fontRendererObj.drawString(this.keyDesc, lllllllllllllIIIlIllIIIllIIllIIl + 90 - GuiKeyBindingList.this.maxListLabelWidth, lllllllllllllIIIlIllIIIllIIIllII + lllllllllllllIIIlIllIIIllIIlIllI / 2 - GuiKeyBindingList.this.mc.fontRendererObj.FONT_HEIGHT / 2, 16777215);
            this.btnReset.xPosition = lllllllllllllIIIlIllIIIllIIllIIl + 190;
            this.btnReset.yPosition = lllllllllllllIIIlIllIIIllIIIllII;
            this.btnReset.enabled = (this.keybinding.getKeyCode() != this.keybinding.getKeyCodeDefault());
            this.btnReset.func_191745_a(GuiKeyBindingList.this.mc, GuiKeyBindingList.this.mouseX, GuiKeyBindingList.this.mouseY);
            this.btnChangeKeyBinding.xPosition = lllllllllllllIIIlIllIIIllIIllIIl + 105;
            this.btnChangeKeyBinding.yPosition = lllllllllllllIIIlIllIIIllIIIllII;
            this.btnChangeKeyBinding.displayString = GameSettings.getKeyDisplayString(this.keybinding.getKeyCode());
            boolean lllllllllllllIIIlIllIIIllIIlIIII = false;
            if (this.keybinding.getKeyCode() != 0) {
                final String lllllllllllllIIIlIllIIIllIIIIlIl;
                final char lllllllllllllIIIlIllIIIllIIIIllI = (char)((KeyBinding[])(Object)(lllllllllllllIIIlIllIIIllIIIIlIl = (String)(Object)GuiKeyBindingList.this.mc.gameSettings.keyBindings)).length;
                for (short lllllllllllllIIIlIllIIIllIIIIlll = 0; lllllllllllllIIIlIllIIIllIIIIlll < lllllllllllllIIIlIllIIIllIIIIllI; ++lllllllllllllIIIlIllIIIllIIIIlll) {
                    final KeyBinding lllllllllllllIIIlIllIIIllIIIllll = lllllllllllllIIIlIllIIIllIIIIlIl[lllllllllllllIIIlIllIIIllIIIIlll];
                    if (lllllllllllllIIIlIllIIIllIIIllll != this.keybinding && lllllllllllllIIIlIllIIIllIIIllll.getKeyCode() == this.keybinding.getKeyCode()) {
                        lllllllllllllIIIlIllIIIllIIlIIII = true;
                        break;
                    }
                }
            }
            if (lllllllllllllIIIlIllIIIllIIlIIIl) {
                this.btnChangeKeyBinding.displayString = String.valueOf(new StringBuilder().append(TextFormatting.WHITE).append("> ").append(TextFormatting.YELLOW).append(this.btnChangeKeyBinding.displayString).append(TextFormatting.WHITE).append(" <"));
            }
            else if (lllllllllllllIIIlIllIIIllIIlIIII) {
                this.btnChangeKeyBinding.displayString = String.valueOf(new StringBuilder().append(TextFormatting.RED).append(this.btnChangeKeyBinding.displayString));
            }
            this.btnChangeKeyBinding.func_191745_a(GuiKeyBindingList.this.mc, GuiKeyBindingList.this.mouseX, GuiKeyBindingList.this.mouseY);
        }
        
        @Override
        public boolean mousePressed(final int lllllllllllllIIIlIllIIIllIIIIIII, final int lllllllllllllIIIlIllIIIlIllllIIl, final int lllllllllllllIIIlIllIIIlIllllllI, final int lllllllllllllIIIlIllIIIlIlllllIl, final int lllllllllllllIIIlIllIIIlIlllllII, final int lllllllllllllIIIlIllIIIlIllllIll) {
            if (this.btnChangeKeyBinding.mousePressed(GuiKeyBindingList.this.mc, lllllllllllllIIIlIllIIIlIllllIIl, lllllllllllllIIIlIllIIIlIllllllI)) {
                GuiKeyBindingList.this.controlsScreen.buttonId = this.keybinding;
                return true;
            }
            if (this.btnReset.mousePressed(GuiKeyBindingList.this.mc, lllllllllllllIIIlIllIIIlIllllIIl, lllllllllllllIIIlIllIIIlIllllllI)) {
                GuiKeyBindingList.this.mc.gameSettings.setOptionKeyBinding(this.keybinding, this.keybinding.getKeyCodeDefault());
                KeyBinding.resetKeyBindingArrayAndHash();
                return true;
            }
            return false;
        }
    }
    
    public class CategoryEntry implements IGuiListEntry
    {
        private final /* synthetic */ String labelText;
        private final /* synthetic */ int labelWidth;
        
        @Override
        public void func_192634_a(final int llllllllllllllIlIlIlIlIlIlIIIlll, final int llllllllllllllIlIlIlIlIlIlIIIllI, final int llllllllllllllIlIlIlIlIlIlIIIlIl, final int llllllllllllllIlIlIlIlIlIlIIIlII, final int llllllllllllllIlIlIlIlIlIIllllII, final int llllllllllllllIlIlIlIlIlIlIIIIlI, final int llllllllllllllIlIlIlIlIlIlIIIIIl, final boolean llllllllllllllIlIlIlIlIlIlIIIIII, final float llllllllllllllIlIlIlIlIlIIllllll) {
            GuiKeyBindingList.this.mc.fontRendererObj.drawString(this.labelText, GuiKeyBindingList.this.mc.currentScreen.width / 2 - this.labelWidth / 2, llllllllllllllIlIlIlIlIlIlIIIlIl + llllllllllllllIlIlIlIlIlIIllllII - GuiKeyBindingList.this.mc.fontRendererObj.FONT_HEIGHT - 1, 16777215);
        }
        
        @Override
        public void mouseReleased(final int llllllllllllllIlIlIlIlIlIIllIIll, final int llllllllllllllIlIlIlIlIlIIllIIlI, final int llllllllllllllIlIlIlIlIlIIllIIIl, final int llllllllllllllIlIlIlIlIlIIllIIII, final int llllllllllllllIlIlIlIlIlIIlIllll, final int llllllllllllllIlIlIlIlIlIIlIlllI) {
        }
        
        @Override
        public boolean mousePressed(final int llllllllllllllIlIlIlIlIlIIlllIlI, final int llllllllllllllIlIlIlIlIlIIlllIIl, final int llllllllllllllIlIlIlIlIlIIlllIII, final int llllllllllllllIlIlIlIlIlIIllIlll, final int llllllllllllllIlIlIlIlIlIIllIllI, final int llllllllllllllIlIlIlIlIlIIllIlIl) {
            return false;
        }
        
        @Override
        public void func_192633_a(final int llllllllllllllIlIlIlIlIlIIlIllII, final int llllllllllllllIlIlIlIlIlIIlIlIll, final int llllllllllllllIlIlIlIlIlIIlIlIlI, final float llllllllllllllIlIlIlIlIlIIlIlIIl) {
        }
        
        public CategoryEntry(final String llllllllllllllIlIlIlIlIlIlIIllll) {
            this.labelText = I18n.format(llllllllllllllIlIlIlIlIlIlIIllll, new Object[0]);
            this.labelWidth = GuiKeyBindingList.this.mc.fontRendererObj.getStringWidth(this.labelText);
        }
    }
}
