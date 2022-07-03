package net.minecraft.client.gui;

import net.minecraft.util.text.*;

public class ChatLine
{
    private final /* synthetic */ int updateCounterCreated;
    private final /* synthetic */ ITextComponent lineString;
    private final /* synthetic */ int chatLineID;
    
    public int getChatLineID() {
        return this.chatLineID;
    }
    
    public ChatLine(final int llllllllllllllIlIIIllIlIlllIIIll, final ITextComponent llllllllllllllIlIIIllIlIllIllllI, final int llllllllllllllIlIIIllIlIllIlllIl) {
        this.lineString = llllllllllllllIlIIIllIlIllIllllI;
        this.updateCounterCreated = llllllllllllllIlIIIllIlIlllIIIll;
        this.chatLineID = llllllllllllllIlIIIllIlIllIlllIl;
    }
    
    public ITextComponent getChatComponent() {
        return this.lineString;
    }
    
    public int getUpdatedCounter() {
        return this.updateCounterCreated;
    }
}
