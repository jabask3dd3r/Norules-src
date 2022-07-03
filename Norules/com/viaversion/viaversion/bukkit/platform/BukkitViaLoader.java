package com.viaversion.viaversion.bukkit.platform;

import com.viaversion.viaversion.api.platform.*;
import com.viaversion.viaversion.*;
import org.bukkit.scheduler.*;
import org.bukkit.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;
import com.viaversion.viaversion.bukkit.listeners.*;
import com.viaversion.viaversion.bukkit.classgenerator.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.protocol.version.*;
import com.viaversion.viaversion.bukkit.listeners.multiversion.*;
import com.viaversion.viaversion.bukkit.listeners.protocol1_15to1_14_4.*;
import com.viaversion.viaversion.bukkit.listeners.protocol1_9to1_8.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.providers.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import java.util.*;
import org.bukkit.entity.*;
import java.util.concurrent.*;
import com.viaversion.viaversion.protocols.protocol1_12to1_11_1.providers.*;
import com.viaversion.viaversion.bukkit.providers.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.providers.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.*;

public class BukkitViaLoader implements ViaPlatformLoader
{
    private final /* synthetic */ ViaVersionPlugin plugin;
    private final /* synthetic */ Set<BukkitTask> tasks;
    private /* synthetic */ HandItemCache handItemCache;
    private final /* synthetic */ Set<Listener> listeners;
    
    public void registerListener(final Listener lllllllllllllIlIIIllllllIlIIlllI) {
        Bukkit.getPluginManager().registerEvents(this.storeListener(lllllllllllllIlIIIllllllIlIIlllI), (Plugin)this.plugin);
    }
    
    public <T extends Listener> T storeListener(final T lllllllllllllIlIIIllllllIlIIlIlI) {
        this.listeners.add(lllllllllllllIlIIIllllllIlIIlIlI);
        return lllllllllllllIlIIIllllllIlIIlIlI;
    }
    
    public BukkitViaLoader(final ViaVersionPlugin lllllllllllllIlIIIllllllIlIlIlII) {
        this.listeners = new HashSet<Listener>();
        this.tasks = new HashSet<BukkitTask>();
        this.plugin = lllllllllllllIlIIIllllllIlIlIlII;
    }
    
    @Override
    public void unload() {
        for (final Listener lllllllllllllIlIIIllllllIIlIllll : this.listeners) {
            HandlerList.unregisterAll(lllllllllllllIlIIIllllllIIlIllll);
        }
        this.listeners.clear();
        for (final BukkitTask lllllllllllllIlIIIllllllIIlIlllI : this.tasks) {
            lllllllllllllIlIIIllllllIIlIlllI.cancel();
        }
        this.tasks.clear();
    }
    
    @Override
    public void load() {
        this.registerListener((Listener)new UpdateListener());
        final ViaVersionPlugin lllllllllllllIlIIIllllllIIlllIlI = (ViaVersionPlugin)Bukkit.getPluginManager().getPlugin("ViaVersion");
        ClassGenerator.registerPSConnectListener(lllllllllllllIlIIIllllllIIlllIlI);
        final int lllllllllllllIlIIIllllllIIlllIIl = Via.getAPI().getServerVersion().lowestSupportedVersion();
        if (lllllllllllllIlIIIllllllIIlllIIl < ProtocolVersion.v1_9.getVersion()) {
            this.storeListener(new ArmorListener((Plugin)lllllllllllllIlIIIllllllIIlllIlI)).register();
            this.storeListener(new DeathListener((Plugin)lllllllllllllIlIIIllllllIIlllIlI)).register();
            this.storeListener(new BlockListener((Plugin)lllllllllllllIlIIIllllllIIlllIlI)).register();
            if (lllllllllllllIlIIIllllllIIlllIlI.getConf().isItemCache()) {
                this.handItemCache = new HandItemCache();
                this.tasks.add(this.handItemCache.runTaskTimerAsynchronously((Plugin)lllllllllllllIlIIIllllllIIlllIlI, 2L, 2L));
            }
        }
        Label_0251: {
            if (lllllllllllllIlIIIllllllIIlllIIl < ProtocolVersion.v1_14.getVersion()) {
                final boolean lllllllllllllIlIIIllllllIlIIIIII = lllllllllllllIlIIIllllllIIlllIlI.getConf().is1_9HitboxFix() && lllllllllllllIlIIIllllllIIlllIIl < ProtocolVersion.v1_9.getVersion();
                if (!lllllllllllllIlIIIllllllIlIIIIII) {
                    if (!lllllllllllllIlIIIllllllIIlllIlI.getConf().is1_14HitboxFix()) {
                        break Label_0251;
                    }
                }
                try {
                    this.storeListener(new PlayerSneakListener(lllllllllllllIlIIIllllllIIlllIlI, lllllllllllllIlIIIllllllIlIIIIII, lllllllllllllIlIIIllllllIIlllIlI.getConf().is1_14HitboxFix())).register();
                }
                catch (ReflectiveOperationException lllllllllllllIlIIIllllllIlIIIIIl) {
                    Via.getPlatform().getLogger().warning("Could not load hitbox fix - please report this on our GitHub");
                    lllllllllllllIlIIIllllllIlIIIIIl.printStackTrace();
                }
            }
        }
        if (lllllllllllllIlIIIllllllIIlllIIl < ProtocolVersion.v1_15.getVersion()) {
            try {
                Class.forName("org.bukkit.event.entity.EntityToggleGlideEvent");
                this.storeListener(new EntityToggleGlideListener(lllllllllllllIlIIIllllllIIlllIlI)).register();
            }
            catch (ClassNotFoundException ex) {}
        }
        if (lllllllllllllIlIIIllllllIIlllIIl < ProtocolVersion.v1_12.getVersion() && !Boolean.getBoolean("com.viaversion.ignorePaperBlockPlacePatch")) {
            boolean lllllllllllllIlIIIllllllIIllllIl = true;
            try {
                Class.forName("org.github.paperspigot.PaperSpigotConfig");
            }
            catch (ClassNotFoundException lllllllllllllIlIIIllllllIIlllllI) {
                try {
                    Class.forName("com.destroystokyo.paper.PaperConfig");
                }
                catch (ClassNotFoundException lllllllllllllIlIIIllllllIIllllll) {
                    lllllllllllllIlIIIllllllIIllllIl = false;
                }
            }
            if (lllllllllllllIlIIIllllllIIllllIl) {
                this.storeListener(new PaperPatch((Plugin)lllllllllllllIlIIIllllllIIlllIlI)).register();
            }
        }
        if (lllllllllllllIlIIIllllllIIlllIIl < ProtocolVersion.v1_9.getVersion()) {
            Via.getManager().getProviders().use((Class<BukkitViaMovementTransmitter>)MovementTransmitterProvider.class, new BukkitViaMovementTransmitter());
            Via.getManager().getProviders().use((Class<BukkitViaLoader$1>)HandItemProvider.class, new HandItemProvider() {
                @Override
                public Item getHandItem(final UserConnection lllllllllllllIIIllIIlIlIllllIIIl) {
                    if (BukkitViaLoader.this.handItemCache != null) {
                        return BukkitViaLoader.this.handItemCache.getHandItem(lllllllllllllIIIllIIlIlIllllIIIl.getProtocolInfo().getUuid());
                    }
                    try {
                        final UUID lllllllllllllIIIllIIlIlIlllIlIll;
                        final Player lllllllllllllIIIllIIlIlIlllIlIlI;
                        return Bukkit.getScheduler().callSyncMethod(Bukkit.getPluginManager().getPlugin("ViaVersion"), () -> {
                            lllllllllllllIIIllIIlIlIlllIlIll = lllllllllllllIIIllIIlIlIllllIIIl.getProtocolInfo().getUuid();
                            lllllllllllllIIIllIIlIlIlllIlIlI = Bukkit.getPlayer(lllllllllllllIIIllIIlIlIlllIlIll);
                            if (lllllllllllllIIIllIIlIlIlllIlIlI != null) {
                                return HandItemCache.convert(lllllllllllllIIIllIIlIlIlllIlIlI.getItemInHand());
                            }
                            else {
                                return null;
                            }
                        }).get(10L, TimeUnit.SECONDS);
                    }
                    catch (Exception lllllllllllllIIIllIIlIlIllllIlIl) {
                        Via.getPlatform().getLogger().severe(String.valueOf(new StringBuilder().append("Error fetching hand item: ").append(lllllllllllllIIIllIIlIlIllllIlIl.getClass().getName())));
                        if (Via.getManager().isDebug()) {
                            lllllllllllllIIIllIIlIlIllllIlIl.printStackTrace();
                        }
                        return null;
                    }
                }
            });
        }
        if (lllllllllllllIlIIIllllllIIlllIIl < ProtocolVersion.v1_12.getVersion() && lllllllllllllIlIIIllllllIIlllIlI.getConf().is1_12QuickMoveActionFix()) {
            Via.getManager().getProviders().use((Class<BukkitInventoryQuickMoveProvider>)InventoryQuickMoveProvider.class, new BukkitInventoryQuickMoveProvider());
        }
        if (lllllllllllllIlIIIllllllIIlllIIl < ProtocolVersion.v1_13.getVersion() && Via.getConfig().getBlockConnectionMethod().equalsIgnoreCase("world")) {
            final BukkitBlockConnectionProvider lllllllllllllIlIIIllllllIIllllII = new BukkitBlockConnectionProvider();
            Via.getManager().getProviders().use(BlockConnectionProvider.class, lllllllllllllIlIIIllllllIIllllII);
            ConnectionData.blockConnectionProvider = lllllllllllllIlIIIllllllIIllllII;
        }
    }
}
