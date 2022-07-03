package net.minecraft.client.gui.spectator.categories;

import java.util.*;
import net.minecraft.client.gui.spectator.*;
import com.google.common.base.*;

public class SpectatorDetails
{
    private final /* synthetic */ int selectedSlot;
    private final /* synthetic */ List<ISpectatorMenuObject> items;
    private final /* synthetic */ ISpectatorMenuView category;
    
    public int getSelectedSlot() {
        return this.selectedSlot;
    }
    
    public SpectatorDetails(final ISpectatorMenuView lIIlllIllIllIll, final List<ISpectatorMenuObject> lIIlllIllIlIllI, final int lIIlllIllIllIIl) {
        this.category = lIIlllIllIllIll;
        this.items = lIIlllIllIlIllI;
        this.selectedSlot = lIIlllIllIllIIl;
    }
    
    public ISpectatorMenuObject getObject(final int lIIlllIllIlIIIl) {
        return (ISpectatorMenuObject)((lIIlllIllIlIIIl >= 0 && lIIlllIllIlIIIl < this.items.size()) ? MoreObjects.firstNonNull((Object)this.items.get(lIIlllIllIlIIIl), (Object)SpectatorMenu.EMPTY_SLOT) : SpectatorMenu.EMPTY_SLOT);
    }
}
