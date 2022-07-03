package net.minecraft.client.gui;

import net.minecraft.client.*;

public abstract class GuiListExtended extends GuiSlot
{
    public boolean mouseClicked(final int llllllllllllllIIIIIIlllIlllIlIIl, final int llllllllllllllIIIIIIlllIlllIlIII, final int llllllllllllllIIIIIIlllIllIllIII) {
        if (this.isMouseYWithinSlotBounds(llllllllllllllIIIIIIlllIlllIlIII)) {
            final int llllllllllllllIIIIIIlllIlllIIlIl = this.getSlotIndexFromScreenCoords(llllllllllllllIIIIIIlllIlllIlIIl, llllllllllllllIIIIIIlllIlllIlIII);
            if (llllllllllllllIIIIIIlllIlllIIlIl >= 0) {
                final int llllllllllllllIIIIIIlllIlllIIIll = this.left + this.width / 2 - this.getListWidth() / 2 + 2;
                final int llllllllllllllIIIIIIlllIlllIIIIl = this.top + 4 - this.getAmountScrolled() + llllllllllllllIIIIIIlllIlllIIlIl * this.slotHeight + this.headerPadding;
                final int llllllllllllllIIIIIIlllIllIlllll = llllllllllllllIIIIIIlllIlllIlIIl - llllllllllllllIIIIIIlllIlllIIIll;
                final int llllllllllllllIIIIIIlllIllIlllIl = llllllllllllllIIIIIIlllIlllIlIII - llllllllllllllIIIIIIlllIlllIIIIl;
                if (this.getListEntry(llllllllllllllIIIIIIlllIlllIIlIl).mousePressed(llllllllllllllIIIIIIlllIlllIIlIl, llllllllllllllIIIIIIlllIlllIlIIl, llllllllllllllIIIIIIlllIlllIlIII, llllllllllllllIIIIIIlllIllIllIII, llllllllllllllIIIIIIlllIllIlllll, llllllllllllllIIIIIIlllIllIlllIl)) {
                    this.setEnabled(false);
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    protected boolean isSelected(final int llllllllllllllIIIIIIllllIIIlllll) {
        return false;
    }
    
    @Override
    protected void func_192637_a(final int llllllllllllllIIIIIIllllIIIIllII, final int llllllllllllllIIIIIIllllIIIIlIll, final int llllllllllllllIIIIIIllllIIIlIIlI, final int llllllllllllllIIIIIIllllIIIlIIIl, final int llllllllllllllIIIIIIllllIIIlIIII, final int llllllllllllllIIIIIIllllIIIIllll, final float llllllllllllllIIIIIIllllIIIIIllI) {
        this.getListEntry(llllllllllllllIIIIIIllllIIIIllII).func_192634_a(llllllllllllllIIIIIIllllIIIIllII, llllllllllllllIIIIIIllllIIIIlIll, llllllllllllllIIIIIIllllIIIlIIlI, this.getListWidth(), llllllllllllllIIIIIIllllIIIlIIIl, llllllllllllllIIIIIIllllIIIlIIII, llllllllllllllIIIIIIllllIIIIllll, this.isMouseYWithinSlotBounds(llllllllllllllIIIIIIllllIIIIllll) && this.getSlotIndexFromScreenCoords(llllllllllllllIIIIIIllllIIIlIIII, llllllllllllllIIIIIIllllIIIIllll) == llllllllllllllIIIIIIllllIIIIllII, llllllllllllllIIIIIIllllIIIIIllI);
    }
    
    public abstract IGuiListEntry getListEntry(final int p0);
    
    @Override
    protected void elementClicked(final int llllllllllllllIIIIIIllllIIlIIlII, final boolean llllllllllllllIIIIIIllllIIlIIIll, final int llllllllllllllIIIIIIllllIIlIIIlI, final int llllllllllllllIIIIIIllllIIlIIIIl) {
    }
    
    public GuiListExtended(final Minecraft llllllllllllllIIIIIIllllIIlIlIll, final int llllllllllllllIIIIIIllllIIlIlIlI, final int llllllllllllllIIIIIIllllIIlIlIIl, final int llllllllllllllIIIIIIllllIIlIllll, final int llllllllllllllIIIIIIllllIIlIIlll, final int llllllllllllllIIIIIIllllIIlIllIl) {
        super(llllllllllllllIIIIIIllllIIlIlIll, llllllllllllllIIIIIIllllIIlIlIlI, llllllllllllllIIIIIIllllIIlIlIIl, llllllllllllllIIIIIIllllIIlIllll, llllllllllllllIIIIIIllllIIlIIlll, llllllllllllllIIIIIIllllIIlIllIl);
    }
    
    public boolean mouseReleased(final int llllllllllllllIIIIIIlllIlIllIllI, final int llllllllllllllIIIIIIlllIlIlIIllI, final int llllllllllllllIIIIIIlllIlIllIlII) {
        for (int llllllllllllllIIIIIIlllIlIllIIll = 0; llllllllllllllIIIIIIlllIlIllIIll < this.getSize(); ++llllllllllllllIIIIIIlllIlIllIIll) {
            final int llllllllllllllIIIIIIlllIlIllIIlI = this.left + this.width / 2 - this.getListWidth() / 2 + 2;
            final int llllllllllllllIIIIIIlllIlIllIIII = this.top + 4 - this.getAmountScrolled() + llllllllllllllIIIIIIlllIlIllIIll * this.slotHeight + this.headerPadding;
            final int llllllllllllllIIIIIIlllIlIlIlllI = llllllllllllllIIIIIIlllIlIllIllI - llllllllllllllIIIIIIlllIlIllIIlI;
            final int llllllllllllllIIIIIIlllIlIlIllII = llllllllllllllIIIIIIlllIlIlIIllI - llllllllllllllIIIIIIlllIlIllIIII;
            this.getListEntry(llllllllllllllIIIIIIlllIlIllIIll).mouseReleased(llllllllllllllIIIIIIlllIlIllIIll, llllllllllllllIIIIIIlllIlIllIllI, llllllllllllllIIIIIIlllIlIlIIllI, llllllllllllllIIIIIIlllIlIllIlII, llllllllllllllIIIIIIlllIlIlIlllI, llllllllllllllIIIIIIlllIlIlIllII);
        }
        this.setEnabled(true);
        return false;
    }
    
    @Override
    protected void drawBackground() {
    }
    
    @Override
    protected void func_192639_a(final int llllllllllllllIIIIIIlllIllllllll, final int llllllllllllllIIIIIIlllIlllllIIl, final int llllllllllllllIIIIIIlllIlllllIII, final float llllllllllllllIIIIIIlllIllllllII) {
        this.getListEntry(llllllllllllllIIIIIIlllIllllllll).func_192633_a(llllllllllllllIIIIIIlllIllllllll, llllllllllllllIIIIIIlllIlllllIIl, llllllllllllllIIIIIIlllIlllllIII, llllllllllllllIIIIIIlllIllllllII);
    }
    
    public interface IGuiListEntry
    {
        boolean mousePressed(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5);
        
        void func_192634_a(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5, final int p6, final boolean p7, final float p8);
        
        void mouseReleased(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5);
        
        void func_192633_a(final int p0, final int p1, final int p2, final float p3);
    }
}
