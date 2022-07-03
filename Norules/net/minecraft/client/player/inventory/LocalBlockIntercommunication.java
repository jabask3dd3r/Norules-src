package net.minecraft.client.player.inventory;

import net.minecraft.world.*;
import net.minecraft.util.text.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;

public class LocalBlockIntercommunication implements IInteractionObject
{
    private final /* synthetic */ ITextComponent displayName;
    private final /* synthetic */ String guiID;
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllllllIIIllIllllIlIIllIl, final EntityPlayer llllllllllllllIIIllIllllIlIIllII) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String getGuiID() {
        return this.guiID;
    }
    
    @Override
    public String getName() {
        return this.displayName.getUnformattedText();
    }
    
    public LocalBlockIntercommunication(final String llllllllllllllIIIllIllllIlIlIIII, final ITextComponent llllllllllllllIIIllIllllIlIIllll) {
        this.guiID = llllllllllllllIIIllIllllIlIlIIII;
        this.displayName = llllllllllllllIIIllIllllIlIIllll;
    }
    
    @Override
    public boolean hasCustomName() {
        return true;
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.displayName;
    }
}
