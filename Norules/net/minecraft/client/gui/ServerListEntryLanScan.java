package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.client.resources.*;

public class ServerListEntryLanScan implements GuiListExtended.IGuiListEntry
{
    private final /* synthetic */ Minecraft mc;
    
    @Override
    public boolean mousePressed(final int lllllllllllllIIlIlIIllIlllIIlIII, final int lllllllllllllIIlIlIIllIlllIIIlll, final int lllllllllllllIIlIlIIllIlllIIIllI, final int lllllllllllllIIlIlIIllIlllIIIlIl, final int lllllllllllllIIlIlIIllIlllIIIlII, final int lllllllllllllIIlIlIIllIlllIIIIll) {
        return false;
    }
    
    @Override
    public void mouseReleased(final int lllllllllllllIIlIlIIllIlllIIIIIl, final int lllllllllllllIIlIlIIllIlllIIIIII, final int lllllllllllllIIlIlIIllIllIllllll, final int lllllllllllllIIlIlIIllIllIlllllI, final int lllllllllllllIIlIlIIllIllIllllIl, final int lllllllllllllIIlIlIIllIllIllllII) {
    }
    
    @Override
    public void func_192634_a(final int lllllllllllllIIlIlIIllIllllIIIII, final int lllllllllllllIIlIlIIllIlllIlllll, final int lllllllllllllIIlIlIIllIlllIlIIlI, final int lllllllllllllIIlIlIIllIlllIlllIl, final int lllllllllllllIIlIlIIllIlllIlIIIl, final int lllllllllllllIIlIlIIllIlllIllIll, final int lllllllllllllIIlIlIIllIlllIllIlI, final boolean lllllllllllllIIlIlIIllIlllIllIIl, final float lllllllllllllIIlIlIIllIlllIllIII) {
        final int lllllllllllllIIlIlIIllIlllIlIlll = lllllllllllllIIlIlIIllIlllIlIIlI + lllllllllllllIIlIlIIllIlllIlIIIl / 2 - this.mc.fontRendererObj.FONT_HEIGHT / 2;
        this.mc.fontRendererObj.drawString(I18n.format("lanServer.scanning", new Object[0]), this.mc.currentScreen.width / 2 - this.mc.fontRendererObj.getStringWidth(I18n.format("lanServer.scanning", new Object[0])) / 2, lllllllllllllIIlIlIIllIlllIlIlll, 16777215);
        final String lllllllllllllIIlIlIIllIlllIlIlII;
        switch ((int)(Minecraft.getSystemTime() / 300L % 4L)) {
            default: {
                final String lllllllllllllIIlIlIIllIlllIlIllI = "O o o";
                break;
            }
            case 1:
            case 3: {
                final String lllllllllllllIIlIlIIllIlllIlIlIl = "o O o";
                break;
            }
            case 2: {
                lllllllllllllIIlIlIIllIlllIlIlII = "o o O";
                break;
            }
        }
        this.mc.fontRendererObj.drawString(lllllllllllllIIlIlIIllIlllIlIlII, this.mc.currentScreen.width / 2 - this.mc.fontRendererObj.getStringWidth(lllllllllllllIIlIlIIllIlllIlIlII) / 2, lllllllllllllIIlIlIIllIlllIlIlll + this.mc.fontRendererObj.FONT_HEIGHT, 8421504);
    }
    
    public ServerListEntryLanScan() {
        this.mc = Minecraft.getMinecraft();
    }
    
    @Override
    public void func_192633_a(final int lllllllllllllIIlIlIIllIlllIIllIl, final int lllllllllllllIIlIlIIllIlllIIllII, final int lllllllllllllIIlIlIIllIlllIIlIll, final float lllllllllllllIIlIlIIllIlllIIlIlI) {
    }
}
