package com.viaversion.viaversion.bukkit.providers;

import com.viaversion.viaversion.protocols.protocol1_12to1_11_1.providers.*;
import java.util.*;
import com.viaversion.viaversion.bukkit.tasks.protocol1_12to1_11_1.*;
import org.bukkit.entity.*;
import com.viaversion.viaversion.protocols.protocol1_12to1_11_1.storage.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.protocol.version.*;
import org.bukkit.event.inventory.*;
import com.viaversion.viaversion.util.*;
import java.util.logging.*;
import org.bukkit.inventory.*;
import com.viaversion.viaversion.bukkit.util.*;
import com.viaversion.viaversion.api.connection.*;
import java.lang.reflect.*;
import java.util.concurrent.*;

public class BukkitInventoryQuickMoveProvider extends InventoryQuickMoveProvider
{
    private /* synthetic */ Method craftPlayerHandle;
    private /* synthetic */ Method packetMethod;
    private /* synthetic */ Class<?> windowClickPacketClass;
    private /* synthetic */ Object clickTypeEnum;
    private final /* synthetic */ boolean supported;
    private /* synthetic */ Field connection;
    private final /* synthetic */ Map<UUID, BukkitInventoryUpdateTask> updateTasks;
    private /* synthetic */ Method nmsItemMethod;
    
    public Object buildWindowClickPacket(final Player lllllllllllllIllIIlIIlIllIllIllI, final ItemTransaction lllllllllllllIllIIlIIlIllIllIlIl) {
        if (!this.supported) {
            return null;
        }
        final InventoryView lllllllllllllIllIIlIIlIllIllllIl = lllllllllllllIllIIlIIlIllIllIllI.getOpenInventory();
        short lllllllllllllIllIIlIIlIllIllllII = lllllllllllllIllIIlIIlIllIllIlIl.getSlotId();
        final Inventory lllllllllllllIllIIlIIlIllIlllIll = lllllllllllllIllIIlIIlIllIllllIl.getTopInventory();
        final InventoryType lllllllllllllIllIIlIIlIllIlllIlI = (lllllllllllllIllIIlIIlIllIlllIll == null) ? null : lllllllllllllIllIIlIIlIllIlllIll.getType();
        if (lllllllllllllIllIIlIIlIllIlllIlI != null) {
            final int lllllllllllllIllIIlIIlIlllIIIlIl = Via.getAPI().getServerVersion().lowestSupportedVersion();
            if (lllllllllllllIllIIlIIlIlllIIIlIl == ProtocolVersion.v1_8.getVersion() && lllllllllllllIllIIlIIlIllIlllIlI == InventoryType.BREWING && lllllllllllllIllIIlIIlIllIllllII >= 5 && lllllllllllllIllIIlIIlIllIllllII <= 40) {
                --lllllllllllllIllIIlIIlIllIllllII;
            }
        }
        ItemStack lllllllllllllIllIIlIIlIllIlllIIl = null;
        if (lllllllllllllIllIIlIIlIllIllllII <= lllllllllllllIllIIlIIlIllIllllIl.countSlots()) {
            lllllllllllllIllIIlIIlIllIlllIIl = lllllllllllllIllIIlIIlIllIllllIl.getItem((int)lllllllllllllIllIIlIIlIllIllllII);
        }
        else {
            final String lllllllllllllIllIIlIIlIlllIIIlII = String.valueOf(new StringBuilder().append("Too many inventory slots: slotId: ").append(lllllllllllllIllIIlIIlIllIllllII).append(" invSlotCount: ").append(lllllllllllllIllIIlIIlIllIllllIl.countSlots()).append(" invType: ").append(lllllllllllllIllIIlIIlIllIllllIl.getType()).append(" topInvType: ").append(lllllllllllllIllIIlIIlIllIlllIlI));
            Via.getPlatform().getLogger().severe(String.valueOf(new StringBuilder().append("Failed to get an item to create a window click packet. Please report this issue to the ViaVersion Github: ").append(lllllllllllllIllIIlIIlIlllIIIlII)));
        }
        Object lllllllllllllIllIIlIIlIllIlllIII = null;
        try {
            lllllllllllllIllIIlIIlIllIlllIII = this.windowClickPacketClass.getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
            final Object lllllllllllllIllIIlIIlIlllIIIIll = (lllllllllllllIllIIlIIlIllIlllIIl == null) ? null : this.nmsItemMethod.invoke(null, lllllllllllllIllIIlIIlIllIlllIIl);
            ReflectionUtil.set(lllllllllllllIllIIlIIlIllIlllIII, "a", (int)lllllllllllllIllIIlIIlIllIllIlIl.getWindowId());
            ReflectionUtil.set(lllllllllllllIllIIlIIlIllIlllIII, "slot", (int)lllllllllllllIllIIlIIlIllIllllII);
            ReflectionUtil.set(lllllllllllllIllIIlIIlIllIlllIII, "button", 0);
            ReflectionUtil.set(lllllllllllllIllIIlIIlIllIlllIII, "d", lllllllllllllIllIIlIIlIllIllIlIl.getActionId());
            ReflectionUtil.set(lllllllllllllIllIIlIIlIllIlllIII, "item", lllllllllllllIllIIlIIlIlllIIIIll);
            final int lllllllllllllIllIIlIIlIlllIIIIlI = Via.getAPI().getServerVersion().lowestSupportedVersion();
            if (lllllllllllllIllIIlIIlIlllIIIIlI == ProtocolVersion.v1_8.getVersion()) {
                ReflectionUtil.set(lllllllllllllIllIIlIIlIllIlllIII, "shift", 1);
            }
            else if (lllllllllllllIllIIlIIlIlllIIIIlI >= ProtocolVersion.v1_9.getVersion()) {
                ReflectionUtil.set(lllllllllllllIllIIlIIlIllIlllIII, "shift", this.clickTypeEnum);
            }
        }
        catch (Exception lllllllllllllIllIIlIIlIlllIIIIIl) {
            Via.getPlatform().getLogger().log(Level.SEVERE, String.valueOf(new StringBuilder().append("Failed to create a window click packet. Please report this issue to the ViaVersion Github: ").append(lllllllllllllIllIIlIIlIlllIIIIIl.getMessage())), lllllllllllllIllIIlIIlIlllIIIIIl);
        }
        return lllllllllllllIllIIlIIlIllIlllIII;
    }
    
    public void onTaskExecuted(final UUID lllllllllllllIllIIlIIlIllIIlIlll) {
        this.updateTasks.remove(lllllllllllllIllIIlIIlIllIIlIlll);
    }
    
    private void setupReflection() {
        if (!this.supported) {
            return;
        }
        try {
            this.windowClickPacketClass = NMSUtil.nms("PacketPlayInWindowClick");
            final int lllllllllllllIllIIlIIlIllIIlIIII = Via.getAPI().getServerVersion().lowestSupportedVersion();
            if (lllllllllllllIllIIlIIlIllIIlIIII >= ProtocolVersion.v1_9.getVersion()) {
                final Class<?> lllllllllllllIllIIlIIlIllIIlIIlI = NMSUtil.nms("InventoryClickType");
                final Object[] lllllllllllllIllIIlIIlIllIIlIIIl = (Object[])lllllllllllllIllIIlIIlIllIIlIIlI.getEnumConstants();
                this.clickTypeEnum = lllllllllllllIllIIlIIlIllIIlIIIl[1];
            }
            final Class<?> lllllllllllllIllIIlIIlIllIIIllll = NMSUtil.obc("inventory.CraftItemStack");
            this.nmsItemMethod = lllllllllllllIllIIlIIlIllIIIllll.getDeclaredMethod("asNMSCopy", ItemStack.class);
        }
        catch (Exception lllllllllllllIllIIlIIlIllIIIlllI) {
            throw new RuntimeException("Couldn't find required inventory classes", lllllllllllllIllIIlIIlIllIIIlllI);
        }
        try {
            this.craftPlayerHandle = NMSUtil.obc("entity.CraftPlayer").getDeclaredMethod("getHandle", (Class<?>[])new Class[0]);
        }
        catch (NoSuchMethodException | ClassNotFoundException ex4) {
            final ReflectiveOperationException ex;
            final ReflectiveOperationException lllllllllllllIllIIlIIlIllIIIllIl = ex;
            throw new RuntimeException("Couldn't find CraftPlayer", lllllllllllllIllIIlIIlIllIIIllIl);
        }
        try {
            this.connection = NMSUtil.nms("EntityPlayer").getDeclaredField("playerConnection");
        }
        catch (NoSuchFieldException | ClassNotFoundException ex5) {
            final ReflectiveOperationException ex2;
            final ReflectiveOperationException lllllllllllllIllIIlIIlIllIIIllII = ex2;
            throw new RuntimeException("Couldn't find Player Connection", lllllllllllllIllIIlIIlIllIIIllII);
        }
        try {
            this.packetMethod = NMSUtil.nms("PlayerConnection").getDeclaredMethod("a", this.windowClickPacketClass);
        }
        catch (NoSuchMethodException | ClassNotFoundException ex6) {
            final ReflectiveOperationException ex3;
            final ReflectiveOperationException lllllllllllllIllIIlIIlIllIIIlIll = ex3;
            throw new RuntimeException("Couldn't find CraftPlayer", lllllllllllllIllIIlIIlIllIIIlIll);
        }
    }
    
    @Override
    public boolean registerQuickMoveAction(final short lllllllllllllIllIIlIIlIllllIIIIl, final short lllllllllllllIllIIlIIlIlllIlIlll, final short lllllllllllllIllIIlIIlIlllIlIllI, final UserConnection lllllllllllllIllIIlIIlIlllIlIlIl) {
        if (!this.supported) {
            return false;
        }
        if (lllllllllllllIllIIlIIlIlllIlIlll < 0) {
            return false;
        }
        if (lllllllllllllIllIIlIIlIllllIIIIl == 0 && lllllllllllllIllIIlIIlIlllIlIlll >= 36 && lllllllllllllIllIIlIIlIlllIlIlll <= 45) {
            final int lllllllllllllIllIIlIIlIllllIIIll = Via.getAPI().getServerVersion().lowestSupportedVersion();
            if (lllllllllllllIllIIlIIlIllllIIIll == ProtocolVersion.v1_8.getVersion()) {
                return false;
            }
        }
        final ProtocolInfo lllllllllllllIllIIlIIlIlllIlllIl = lllllllllllllIllIIlIIlIlllIlIlIl.getProtocolInfo();
        final UUID lllllllllllllIllIIlIIlIlllIlllII = lllllllllllllIllIIlIIlIlllIlllIl.getUuid();
        BukkitInventoryUpdateTask lllllllllllllIllIIlIIlIlllIllIll = this.updateTasks.get(lllllllllllllIllIIlIIlIlllIlllII);
        final boolean lllllllllllllIllIIlIIlIlllIllIlI = lllllllllllllIllIIlIIlIlllIllIll != null;
        if (!lllllllllllllIllIIlIIlIlllIllIlI) {
            lllllllllllllIllIIlIIlIlllIllIll = new BukkitInventoryUpdateTask(this, lllllllllllllIllIIlIIlIlllIlllII);
            this.updateTasks.put(lllllllllllllIllIIlIIlIlllIlllII, lllllllllllllIllIIlIIlIlllIllIll);
        }
        lllllllllllllIllIIlIIlIlllIllIll.addItem(lllllllllllllIllIIlIIlIllllIIIIl, lllllllllllllIllIIlIIlIlllIlIlll, lllllllllllllIllIIlIIlIlllIlIllI);
        if (!lllllllllllllIllIIlIIlIlllIllIlI && Via.getPlatform().isPluginEnabled()) {
            Via.getPlatform().runSync(lllllllllllllIllIIlIIlIlllIllIll);
        }
        return true;
    }
    
    public boolean sendPacketToServer(final Player lllllllllllllIllIIlIIlIllIlIIIII, final Object lllllllllllllIllIIlIIlIllIlIIIlI) {
        if (lllllllllllllIllIIlIIlIllIlIIIlI == null) {
            return true;
        }
        try {
            final Object lllllllllllllIllIIlIIlIllIlIIlll = this.craftPlayerHandle.invoke(lllllllllllllIllIIlIIlIllIlIIIII, new Object[0]);
            final Object lllllllllllllIllIIlIIlIllIlIIllI = this.connection.get(lllllllllllllIllIIlIIlIllIlIIlll);
            this.packetMethod.invoke(lllllllllllllIllIIlIIlIllIlIIllI, lllllllllllllIllIIlIIlIllIlIIIlI);
        }
        catch (IllegalAccessException | InvocationTargetException ex2) {
            final ReflectiveOperationException ex;
            final ReflectiveOperationException lllllllllllllIllIIlIIlIllIlIIlIl = ex;
            lllllllllllllIllIIlIIlIllIlIIlIl.printStackTrace();
            return false;
        }
        return true;
    }
    
    public BukkitInventoryQuickMoveProvider() {
        this.updateTasks = new ConcurrentHashMap<UUID, BukkitInventoryUpdateTask>();
        this.supported = this.isSupported();
        this.setupReflection();
    }
    
    private boolean isSupported() {
        final int lllllllllllllIllIIlIIlIllIIIIIll = Via.getAPI().getServerVersion().lowestSupportedVersion();
        return lllllllllllllIllIIlIIlIllIIIIIll >= ProtocolVersion.v1_8.getVersion() && lllllllllllllIllIIlIIlIllIIIIIll <= ProtocolVersion.v1_11_1.getVersion();
    }
}
