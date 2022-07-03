package net.minecraft.client.gui;

import net.minecraft.client.*;
import java.util.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.text.*;

public abstract class GuiResourcePackList extends GuiListExtended
{
    protected final /* synthetic */ Minecraft mc;
    protected final /* synthetic */ List<ResourcePackListEntry> resourcePackEntries;
    
    @Override
    protected void drawListHeader(final int llllllllllllllIlIIIlIlllIIIIIlIl, final int llllllllllllllIlIIIlIllIllllllll, final Tessellator llllllllllllllIlIIIlIlllIIIIIIll) {
        final String llllllllllllllIlIIIlIlllIIIIIIlI = String.valueOf(new StringBuilder().append(TextFormatting.UNDERLINE).append(TextFormatting.BOLD).append(this.getListHeader()));
        this.mc.fontRendererObj.drawString(llllllllllllllIlIIIlIlllIIIIIIlI, llllllllllllllIlIIIlIlllIIIIIlIl + this.width / 2 - this.mc.fontRendererObj.getStringWidth(llllllllllllllIlIIIlIlllIIIIIIlI) / 2, Math.min(this.top + 3, llllllllllllllIlIIIlIllIllllllll), 16777215);
    }
    
    public GuiResourcePackList(final Minecraft llllllllllllllIlIIIlIlllIIIIlllI, final int llllllllllllllIlIIIlIlllIIIIllIl, final int llllllllllllllIlIIIlIlllIIIlIIIl, final List<ResourcePackListEntry> llllllllllllllIlIIIlIlllIIIIlIll) {
        super(llllllllllllllIlIIIlIlllIIIIlllI, llllllllllllllIlIIIlIlllIIIIllIl, llllllllllllllIlIIIlIlllIIIlIIIl, 32, llllllllllllllIlIIIlIlllIIIlIIIl - 55 + 4, 36);
        this.mc = llllllllllllllIlIIIlIlllIIIIlllI;
        this.resourcePackEntries = llllllllllllllIlIIIlIlllIIIIlIll;
        this.centerListVertically = false;
        this.setHasListHeader(true, (int)(llllllllllllllIlIIIlIlllIIIIlllI.fontRendererObj.FONT_HEIGHT * 1.5f));
    }
    
    public List<ResourcePackListEntry> getList() {
        return this.resourcePackEntries;
    }
    
    @Override
    public ResourcePackListEntry getListEntry(final int llllllllllllllIlIIIlIllIllllIIlI) {
        return this.getList().get(llllllllllllllIlIIIlIllIllllIIlI);
    }
    
    @Override
    protected int getSize() {
        return this.getList().size();
    }
    
    protected abstract String getListHeader();
    
    @Override
    protected int getScrollBarX() {
        return this.right - 6;
    }
    
    @Override
    public int getListWidth() {
        return this.width;
    }
}
