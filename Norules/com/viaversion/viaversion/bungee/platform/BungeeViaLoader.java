package com.viaversion.viaversion.bungee.platform;

import com.viaversion.viaversion.api.platform.*;
import net.md_5.bungee.api.scheduler.*;
import com.viaversion.viaversion.*;
import net.md_5.bungee.api.*;
import java.util.*;
import com.viaversion.viaversion.bungee.handlers.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.bungee.listeners.*;
import com.viaversion.viaversion.api.protocol.version.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.providers.*;
import com.viaversion.viaversion.bungee.providers.*;
import com.viaversion.viaversion.bungee.service.*;
import java.util.concurrent.*;
import net.md_5.bungee.api.plugin.*;

public class BungeeViaLoader implements ViaPlatformLoader
{
    private final /* synthetic */ Set<ScheduledTask> tasks;
    private final /* synthetic */ BungeePlugin plugin;
    private final /* synthetic */ Set<Listener> listeners;
    
    @Override
    public void unload() {
        for (final Listener lllllllllllllIlllIIlllIIlIllIIll : this.listeners) {
            ProxyServer.getInstance().getPluginManager().unregisterListener(lllllllllllllIlllIIlllIIlIllIIll);
        }
        this.listeners.clear();
        for (final ScheduledTask lllllllllllllIlllIIlllIIlIllIIlI : this.tasks) {
            lllllllllllllIlllIIlllIIlIllIIlI.cancel();
        }
        this.tasks.clear();
    }
    
    public BungeeViaLoader(final BungeePlugin lllllllllllllIlllIIlllIIllIIIIII) {
        this.listeners = new HashSet<Listener>();
        this.tasks = new HashSet<ScheduledTask>();
        this.plugin = lllllllllllllIlllIIlllIIllIIIIII;
    }
    
    @Override
    public void load() {
        this.registerListener((Listener)this.plugin);
        this.registerListener((Listener)new UpdateListener());
        this.registerListener((Listener)new BungeeServerHandler());
        if (Via.getAPI().getServerVersion().lowestSupportedVersion() < ProtocolVersion.v1_9.getVersion()) {
            this.registerListener((Listener)new ElytraPatch());
        }
        Via.getManager().getProviders().use((Class<BungeeVersionProvider>)VersionProvider.class, new BungeeVersionProvider());
        Via.getManager().getProviders().use((Class<BungeeEntityIdProvider>)EntityIdProvider.class, new BungeeEntityIdProvider());
        if (Via.getAPI().getServerVersion().lowestSupportedVersion() < ProtocolVersion.v1_9.getVersion()) {
            Via.getManager().getProviders().use((Class<BungeeMovementTransmitter>)MovementTransmitterProvider.class, new BungeeMovementTransmitter());
            Via.getManager().getProviders().use((Class<BungeeBossBarProvider>)BossBarProvider.class, new BungeeBossBarProvider());
            Via.getManager().getProviders().use((Class<BungeeMainHandProvider>)MainHandProvider.class, new BungeeMainHandProvider());
        }
        if (this.plugin.getConf().getBungeePingInterval() > 0) {
            this.tasks.add(this.plugin.getProxy().getScheduler().schedule((Plugin)this.plugin, (Runnable)new ProtocolDetectorService(this.plugin), 0L, (long)this.plugin.getConf().getBungeePingInterval(), TimeUnit.SECONDS));
        }
    }
    
    private void registerListener(final Listener lllllllllllllIlllIIlllIIlIlllIlI) {
        this.listeners.add(lllllllllllllIlllIIlllIIlIlllIlI);
        ProxyServer.getInstance().getPluginManager().registerListener((Plugin)this.plugin, lllllllllllllIlllIIlllIIlIlllIlI);
    }
}
