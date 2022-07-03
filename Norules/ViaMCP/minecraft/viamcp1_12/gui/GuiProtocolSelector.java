package ViaMCP.minecraft.viamcp1_12.gui;

import java.io.*;
import net.minecraft.client.gui.*;
import ViaMCP.minecraft.viamcp1_12.protocols.*;
import net.minecraft.client.*;
import ViaMCP.minecraft.viamcp1_12.*;
import net.minecraft.util.text.*;
import font.*;

public class GuiProtocolSelector extends GuiScreen
{
    public /* synthetic */ SlotList list;
    private /* synthetic */ GuiScreen parent;
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIIllIlllIIlIIIllll) throws IOException {
        this.list.actionPerformed(llllllllllllllIIllIlllIIlIIIllll);
        if (llllllllllllllIIllIlllIIlIIIllll.id == 1) {
            this.mc.displayGuiScreen(this.parent);
        }
    }
    
    public GuiProtocolSelector(final GuiScreen llllllllllllllIIllIlllIIlIIlIllI) {
        this.parent = llllllllllllllIIllIlllIIlIIlIllI;
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIllIlllIIlIIIIlII, final int llllllllllllllIIllIlllIIlIIIIIll, final float llllllllllllllIIllIlllIIIllllllI) {
        this.list.drawScreen(llllllllllllllIIllIlllIIlIIIIlII, llllllllllllllIIllIlllIIlIIIIIll, llllllllllllllIIllIlllIIIllllllI);
        super.drawScreen(llllllllllllllIIllIlllIIlIIIIlII, llllllllllllllIIllIlllIIlIIIIIll, llllllllllllllIIllIlllIIIllllllI);
    }
    
    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height - 27, 200, 20, "Back"));
        this.list = new SlotList(this.mc, this.width, this.height, 32, this.height - 32, 10);
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        this.list.handleMouseInput();
        super.handleMouseInput();
    }
    
    class SlotList extends GuiSlot
    {
        @Override
        protected int getSize() {
            return ProtocolCollection.values().length;
        }
        
        public SlotList(final Minecraft lllllllllllllllllIllllllIIlIIlIl, final int lllllllllllllllllIllllllIIIlllII, final int lllllllllllllllllIllllllIIIllIll, final int lllllllllllllllllIllllllIIIllIlI, final int lllllllllllllllllIllllllIIIllIIl, final int lllllllllllllllllIllllllIIlIIIII) {
            super(lllllllllllllllllIllllllIIlIIlIl, lllllllllllllllllIllllllIIIlllII, lllllllllllllllllIllllllIIIllIll, lllllllllllllllllIllllllIIIllIlI, lllllllllllllllllIllllllIIIllIIl, lllllllllllllllllIllllllIIlIIIII);
        }
        
        @Override
        protected void func_192637_a(final int lllllllllllllllllIlllllIllllllII, final int lllllllllllllllllIllllllIIIIIlII, final int lllllllllllllllllIlllllIlllllIll, final int lllllllllllllllllIllllllIIIIIIlI, final int lllllllllllllllllIllllllIIIIIIIl, final int lllllllllllllllllIllllllIIIIIIII, final float lllllllllllllllllIlllllIllllllll) {
            final MinecraftFontRenderer lllllllllllllllllIlllllIlllllllI = FontLoader.INSTANCE.comfortaa_bold_20;
            lllllllllllllllllIlllllIlllllllI.drawCenteredString(String.valueOf(new StringBuilder(String.valueOf((ViaMCP.getInstance().getVersion() == ProtocolCollection.values()[lllllllllllllllllIlllllIllllllII].getVersion().getVersion()) ? String.valueOf(new StringBuilder(String.valueOf(TextFormatting.LIGHT_PURPLE.toString())).append(TextFormatting.BOLD)) : TextFormatting.GRAY.toString())).append(ProtocolCollection.getProtocolById(ProtocolCollection.values()[lllllllllllllllllIlllllIllllllII].getVersion().getVersion()).getName())), this.width / 2, lllllllllllllllllIlllllIlllllIll + 3, -1);
        }
        
        @Override
        protected boolean isSelected(final int lllllllllllllllllIllllllIIIIlllI) {
            return false;
        }
        
        @Override
        protected void elementClicked(final int lllllllllllllllllIllllllIIIlIlII, final boolean lllllllllllllllllIllllllIIIlIIll, final int lllllllllllllllllIllllllIIIlIIlI, final int lllllllllllllllllIllllllIIIlIIIl) {
            ViaMCP.getInstance().setVersion(ProtocolCollection.values()[lllllllllllllllllIllllllIIIlIlII].getVersion().getVersion());
        }
        
        @Override
        protected void drawBackground() {
            GuiProtocolSelector.this.drawDefaultBackground();
        }
    }
}
