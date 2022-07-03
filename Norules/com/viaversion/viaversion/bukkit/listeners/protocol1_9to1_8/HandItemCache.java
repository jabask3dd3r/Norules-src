package com.viaversion.viaversion.bukkit.listeners.protocol1_9to1_8;

import org.bukkit.scheduler.*;
import java.util.concurrent.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.inventory.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

public class HandItemCache extends BukkitRunnable
{
    private final /* synthetic */ Map<UUID, Item> handCache;
    
    public HandItemCache() {
        this.handCache = new ConcurrentHashMap<UUID, Item>();
    }
    
    public void run() {
        final List<UUID> lllllllllllllIIllIIlllIIIIIllIlI = new ArrayList<UUID>(this.handCache.keySet());
        for (final Player lllllllllllllIIllIIlllIIIIIlllIl : Bukkit.getOnlinePlayers()) {
            this.handCache.put(lllllllllllllIIllIIlllIIIIIlllIl.getUniqueId(), convert(lllllllllllllIIllIIlllIIIIIlllIl.getItemInHand()));
            lllllllllllllIIllIIlllIIIIIllIlI.remove(lllllllllllllIIllIIlllIIIIIlllIl.getUniqueId());
        }
        for (final UUID lllllllllllllIIllIIlllIIIIIlllII : lllllllllllllIIllIIlllIIIIIllIlI) {
            this.handCache.remove(lllllllllllllIIllIIlllIIIIIlllII);
        }
    }
    
    public static Item convert(final ItemStack lllllllllllllIIllIIlllIIIIIIllIl) {
        if (lllllllllllllIIllIIlllIIIIIIllIl == null) {
            return new DataItem(0, (byte)0, (short)0, null);
        }
        return new DataItem(lllllllllllllIIllIIlllIIIIIIllIl.getTypeId(), (byte)lllllllllllllIIllIIlllIIIIIIllIl.getAmount(), lllllllllllllIIllIIlllIIIIIIllIl.getDurability(), null);
    }
    
    public Item getHandItem(final UUID lllllllllllllIIllIIlllIIIIIlIIlI) {
        return this.handCache.get(lllllllllllllIIllIIlllIIIIIlIIlI);
    }
}
