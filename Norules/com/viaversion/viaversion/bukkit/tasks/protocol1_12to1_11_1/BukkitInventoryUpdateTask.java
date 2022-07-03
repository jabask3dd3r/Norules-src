package com.viaversion.viaversion.bukkit.tasks.protocol1_12to1_11_1;

import com.viaversion.viaversion.bukkit.providers.*;
import com.viaversion.viaversion.protocols.protocol1_12to1_11_1.storage.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import java.util.*;

public class BukkitInventoryUpdateTask implements Runnable
{
    private final /* synthetic */ UUID uuid;
    private final /* synthetic */ BukkitInventoryQuickMoveProvider provider;
    private final /* synthetic */ List<ItemTransaction> items;
    
    @Override
    public void run() {
        final Player llllllllllllllIIIIlIlIlllIllllII = Bukkit.getServer().getPlayer(this.uuid);
        if (llllllllllllllIIIIlIlIlllIllllII == null) {
            this.provider.onTaskExecuted(this.uuid);
            return;
        }
        try {
            synchronized (this.items) {
                for (final ItemTransaction llllllllllllllIIIIlIlIlllIlllllI : this.items) {
                    final Object llllllllllllllIIIIlIlIllllIIIIII = this.provider.buildWindowClickPacket(llllllllllllllIIIIlIlIlllIllllII, llllllllllllllIIIIlIlIlllIlllllI);
                    final boolean llllllllllllllIIIIlIlIlllIllllll = this.provider.sendPacketToServer(llllllllllllllIIIIlIlIlllIllllII, llllllllllllllIIIIlIlIllllIIIIII);
                    if (!llllllllllllllIIIIlIlIlllIllllll) {
                        break;
                    }
                }
                this.items.clear();
            }
        }
        finally {
            this.provider.onTaskExecuted(this.uuid);
        }
    }
    
    public BukkitInventoryUpdateTask(final BukkitInventoryQuickMoveProvider llllllllllllllIIIIlIlIllllIllIlI, final UUID llllllllllllllIIIIlIlIllllIllIIl) {
        this.provider = llllllllllllllIIIIlIlIllllIllIlI;
        this.uuid = llllllllllllllIIIIlIlIllllIllIIl;
        this.items = Collections.synchronizedList(new ArrayList<ItemTransaction>());
    }
    
    public void addItem(final short llllllllllllllIIIIlIlIllllIlIIlI, final short llllllllllllllIIIIlIlIllllIIllII, final short llllllllllllllIIIIlIlIllllIlIIII) {
        final ItemTransaction llllllllllllllIIIIlIlIllllIIllll = new ItemTransaction(llllllllllllllIIIIlIlIllllIlIIlI, llllllllllllllIIIIlIlIllllIIllII, llllllllllllllIIIIlIlIllllIlIIII);
        this.items.add(llllllllllllllIIIIlIlIllllIIllll);
    }
}
