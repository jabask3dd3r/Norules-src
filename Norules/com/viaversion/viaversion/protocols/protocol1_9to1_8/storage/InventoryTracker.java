package com.viaversion.viaversion.protocols.protocol1_9to1_8.storage;

import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.minecraft.item.*;

public class InventoryTracker implements StorableObject
{
    private /* synthetic */ String inventory;
    private final /* synthetic */ Map<Short, Map<Short, Integer>> windowItemCache;
    private /* synthetic */ int itemIdInCursor;
    private /* synthetic */ boolean dragging;
    
    public int getItemId(final short llllllllllllllIllIllllIllIlIIllI, final short llllllllllllllIllIllllIllIlIlIIl) {
        final Map<Short, Integer> llllllllllllllIllIllllIllIlIlIII = this.windowItemCache.get(llllllllllllllIllIllllIllIlIIllI);
        if (llllllllllllllIllIllllIllIlIlIII == null) {
            return 0;
        }
        return llllllllllllllIllIllllIllIlIlIII.getOrDefault(llllllllllllllIllIllllIllIlIlIIl, 0);
    }
    
    public void setInventory(final String llllllllllllllIllIllllIllIlllIII) {
        this.inventory = llllllllllllllIllIllllIllIlllIII;
    }
    
    public void setItemId(final short llllllllllllllIllIllllIllIIllllI, final short llllllllllllllIllIllllIllIIlllIl, final int llllllllllllllIllIllllIllIIllIII) {
        if (llllllllllllllIllIllllIllIIllllI == -1 && llllllllllllllIllIllllIllIIlllIl == -1) {
            this.itemIdInCursor = llllllllllllllIllIllllIllIIllIII;
        }
        else {
            this.windowItemCache.computeIfAbsent(Short.valueOf(llllllllllllllIllIllllIllIIllllI), llllllllllllllIllIllllIlIlllIIll -> new HashMap()).put(llllllllllllllIllIllllIllIIlllIl, llllllllllllllIllIllllIllIIllIII);
        }
    }
    
    public InventoryTracker() {
        this.windowItemCache = new HashMap<Short, Map<Short, Integer>>();
        this.itemIdInCursor = 0;
        this.dragging = false;
    }
    
    public String getInventory() {
        return this.inventory;
    }
    
    public void handleWindowClick(final UserConnection llllllllllllllIllIllllIllIIIIlIl, final short llllllllllllllIllIllllIlIlllllII, final byte llllllllllllllIllIllllIlIllllIll, final short llllllllllllllIllIllllIlIllllIlI, final byte llllllllllllllIllIllllIllIIIIIIl) {
        final EntityTracker1_9 llllllllllllllIllIllllIllIIIIIII = llllllllllllllIllIllllIllIIIIlIl.getEntityTracker(Protocol1_9To1_8.class);
        if (llllllllllllllIllIllllIlIllllIlI == -1) {
            return;
        }
        if (llllllllllllllIllIllllIlIllllIlI == 45) {
            llllllllllllllIllIllllIllIIIIIII.setSecondHand(null);
            return;
        }
        final boolean llllllllllllllIllIllllIlIlllllll = (llllllllllllllIllIllllIlIllllIlI >= 5 && llllllllllllllIllIllllIlIllllIlI <= 8) || llllllllllllllIllIllllIlIllllIlI == 0;
        switch (llllllllllllllIllIllllIlIllllIll) {
            case 0: {
                if (this.itemIdInCursor == 0) {
                    this.itemIdInCursor = this.getItemId(llllllllllllllIllIllllIlIlllllII, llllllllllllllIllIllllIlIllllIlI);
                    this.setItemId(llllllllllllllIllIllllIlIlllllII, llllllllllllllIllIllllIlIllllIlI, 0);
                    break;
                }
                if (llllllllllllllIllIllllIlIllllIlI == -999) {
                    this.itemIdInCursor = 0;
                    break;
                }
                if (!llllllllllllllIllIllllIlIlllllll) {
                    final int llllllllllllllIllIllllIllIIIllII = this.getItemId(llllllllllllllIllIllllIlIlllllII, llllllllllllllIllIllllIlIllllIlI);
                    this.setItemId(llllllllllllllIllIllllIlIlllllII, llllllllllllllIllIllllIlIllllIlI, this.itemIdInCursor);
                    this.itemIdInCursor = llllllllllllllIllIllllIllIIIllII;
                    break;
                }
                break;
            }
            case 2: {
                if (!llllllllllllllIllIllllIlIlllllll) {
                    final short llllllllllllllIllIllllIllIIIlIll = (short)(llllllllllllllIllIllllIllIIIIIIl + 36);
                    final int llllllllllllllIllIllllIllIIIlIlI = this.getItemId(llllllllllllllIllIllllIlIlllllII, llllllllllllllIllIllllIlIllllIlI);
                    final int llllllllllllllIllIllllIllIIIlIIl = this.getItemId(llllllllllllllIllIllllIlIlllllII, llllllllllllllIllIllllIllIIIlIll);
                    this.setItemId(llllllllllllllIllIllllIlIlllllII, llllllllllllllIllIllllIllIIIlIll, llllllllllllllIllIllllIllIIIlIlI);
                    this.setItemId(llllllllllllllIllIllllIlIlllllII, llllllllllllllIllIllllIlIllllIlI, llllllllllllllIllIllllIllIIIlIIl);
                    break;
                }
                break;
            }
            case 4: {
                final int llllllllllllllIllIllllIllIIIlIII = this.getItemId(llllllllllllllIllIllllIlIlllllII, llllllllllllllIllIllllIlIllllIlI);
                if (llllllllllllllIllIllllIllIIIlIII != 0) {
                    this.setItemId(llllllllllllllIllIllllIlIlllllII, llllllllllllllIllIllllIlIllllIlI, 0);
                    break;
                }
                break;
            }
            case 5: {
                switch (llllllllllllllIllIllllIllIIIIIIl) {
                    case 0:
                    case 4: {
                        this.dragging = true;
                        break;
                    }
                    case 1:
                    case 5: {
                        if (this.dragging && this.itemIdInCursor != 0 && !llllllllllllllIllIllllIlIlllllll) {
                            final int llllllllllllllIllIllllIllIIIIlll = this.getItemId(llllllllllllllIllIllllIlIlllllII, llllllllllllllIllIllllIlIllllIlI);
                            this.setItemId(llllllllllllllIllIllllIlIlllllII, llllllllllllllIllIllllIlIllllIlI, this.itemIdInCursor);
                            this.itemIdInCursor = llllllllllllllIllIllllIllIIIIlll;
                            break;
                        }
                        break;
                    }
                    case 2:
                    case 6: {
                        this.dragging = false;
                        break;
                    }
                }
                break;
            }
        }
        llllllllllllllIllIllllIllIIIIIII.syncShieldWithSword();
    }
    
    public void resetInventory(final short llllllllllllllIllIllllIllIllIIII) {
        if (this.inventory == null) {
            this.itemIdInCursor = 0;
            this.dragging = false;
            if (llllllllllllllIllIllllIllIllIIII != 0) {
                this.windowItemCache.remove(llllllllllllllIllIllllIllIllIIII);
            }
        }
    }
}
