package me.nrules.utils.render;

import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import java.io.*;

public class GuiCustomMainMenu extends GuiScreen
{
    @Override
    public void drawScreen(final int lllllllllllllllllIlIlllllIlIllII, final int lllllllllllllllllIlIlllllIllIIIl, final float lllllllllllllllllIlIlllllIllIIII) {
        final ResourceLocation lllllllllllllllllIlIlllllIlIllll = new ResourceLocation("nrules/cosmetic/sexymenu.png");
        this.mc.getTextureManager().bindTexture(lllllllllllllllllIlIlllllIlIllll);
        final Gui lllllllllllllllllIlIlllllIlIlllI = new Gui();
        super.drawScreen(lllllllllllllllllIlIlllllIlIllII, lllllllllllllllllIlIlllllIllIIIl, lllllllllllllllllIlIlllllIllIIII);
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllllllIlIlllllIIllIll, final int lllllllllllllllllIlIlllllIIllIlI, final int lllllllllllllllllIlIlllllIIllllI) throws IOException {
        super.mouseClicked(lllllllllllllllllIlIlllllIIllIll, lllllllllllllllllIlIlllllIIllIlI, lllllllllllllllllIlIlllllIIllllI);
    }
}
