package com.viaversion.viabackwards.listener;

import com.viaversion.viaversion.bukkit.listeners.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viabackwards.protocol.protocol1_13_2to1_14.*;
import org.bukkit.plugin.*;
import com.viaversion.viaversion.api.protocol.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.block.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class LecternInteractListener extends ViaBukkitListener
{
    public LecternInteractListener(final BukkitPlugin llllllllllllllIIllIIllIllIllllII) {
        super((Plugin)llllllllllllllIIllIIllIllIllllII, Protocol1_13_2To1_14.class);
    }
    
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onLecternInteract(final PlayerInteractEvent llllllllllllllIIllIIllIllIlIIllI) {
        final Block llllllllllllllIIllIIllIllIlIlllI = llllllllllllllIIllIIllIllIlIIllI.getClickedBlock();
        if (llllllllllllllIIllIIllIllIlIlllI == null || llllllllllllllIIllIIllIllIlIlllI.getType() != Material.LECTERN) {
            return;
        }
        final Player llllllllllllllIIllIIllIllIlIllIl = llllllllllllllIIllIIllIllIlIIllI.getPlayer();
        if (!this.isOnPipe(llllllllllllllIIllIIllIllIlIllIl)) {
            return;
        }
        final Lectern llllllllllllllIIllIIllIllIlIllII = (Lectern)llllllllllllllIIllIIllIllIlIlllI.getState();
        final ItemStack llllllllllllllIIllIIllIllIlIlIll = llllllllllllllIIllIIllIllIlIllII.getInventory().getItem(0);
        if (llllllllllllllIIllIIllIllIlIlIll == null) {
            return;
        }
        final BookMeta llllllllllllllIIllIIllIllIlIlIlI = (BookMeta)llllllllllllllIIllIIllIllIlIlIll.getItemMeta();
        final ItemStack llllllllllllllIIllIIllIllIlIlIIl = new ItemStack(Material.WRITTEN_BOOK);
        final BookMeta llllllllllllllIIllIIllIllIlIlIII = (BookMeta)llllllllllllllIIllIIllIllIlIlIIl.getItemMeta();
        llllllllllllllIIllIIllIllIlIlIII.setPages(llllllllllllllIIllIIllIllIlIlIlI.getPages());
        llllllllllllllIIllIIllIllIlIlIII.setAuthor("an upsidedown person");
        llllllllllllllIIllIIllIllIlIlIII.setTitle("buk");
        llllllllllllllIIllIIllIllIlIlIIl.setItemMeta((ItemMeta)llllllllllllllIIllIIllIllIlIlIII);
        llllllllllllllIIllIIllIllIlIllIl.openBook(llllllllllllllIIllIIllIllIlIlIIl);
        llllllllllllllIIllIIllIllIlIIllI.setCancelled(true);
    }
}
