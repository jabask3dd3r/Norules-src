package com.viaversion.viaversion;

import java.nio.file.*;
import com.google.inject.*;
import com.velocitypowered.api.plugin.annotation.*;
import java.util.logging.*;
import com.velocitypowered.api.proxy.*;
import net.kyori.adventure.text.serializer.legacy.*;
import java.util.concurrent.*;
import com.viaversion.viaversion.api.command.*;
import java.util.function.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.dump.*;
import com.velocitypowered.api.plugin.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.velocity.service.*;
import net.kyori.adventure.text.*;
import com.velocitypowered.api.event.proxy.*;
import com.viaversion.viaversion.velocity.command.*;
import com.velocitypowered.api.command.*;
import com.viaversion.viaversion.velocity.util.*;
import com.viaversion.viaversion.commands.*;
import com.viaversion.viaversion.velocity.platform.*;
import com.viaversion.viaversion.api.platform.*;
import com.viaversion.viaversion.api.data.*;
import java.util.*;
import java.io.*;
import com.viaversion.viaversion.api.configuration.*;
import com.velocitypowered.api.event.*;
import com.viaversion.viaversion.api.*;

@Plugin(id = "viaversion", name = "ViaVersion", version = "4.0.2-SNAPSHOT", authors = { "_MylesC", "creeper123123321", "Gerrygames", "kennytv", "Matsv" }, description = "Allow newer Minecraft versions to connect to an older server version.", url = "https://viaversion.com")
public class VelocityPlugin implements ViaPlatform<Player>
{
    @Inject
    @DataDirectory
    private /* synthetic */ Path configDir;
    private /* synthetic */ Logger logger;
    @Inject
    private /* synthetic */ org.slf4j.Logger loggerslf4j;
    @Inject
    private /* synthetic */ ProxyServer proxy;
    public static /* synthetic */ ProxyServer PROXY;
    public static final /* synthetic */ LegacyComponentSerializer COMPONENT_SERIALIZER;
    private /* synthetic */ VelocityViaAPI api;
    private /* synthetic */ VelocityViaConfig conf;
    
    @Override
    public PlatformTask runSync(final Runnable lllllllllllllIlIIlllIllIIlllIIII, final long lllllllllllllIlIIlllIllIIllIllII) {
        return new VelocityViaTask(VelocityPlugin.PROXY.getScheduler().buildTask((Object)this, lllllllllllllIlIIlllIllIIlllIIII).delay(lllllllllllllIlIIlllIllIIllIllII * 50L, TimeUnit.MILLISECONDS).schedule());
    }
    
    @Override
    public ViaCommandSender[] getOnlinePlayers() {
        return (ViaCommandSender[])VelocityPlugin.PROXY.getAllPlayers().stream().map(VelocityCommandSender::new).toArray(ViaCommandSender[]::new);
    }
    
    @Override
    public Logger getLogger() {
        return this.logger;
    }
    
    @Override
    public JsonObject getDump() {
        final JsonObject lllllllllllllIlIIlllIllIIIllllll = new JsonObject();
        final List<PluginInfo> lllllllllllllIlIIlllIllIIIlllllI = new ArrayList<PluginInfo>();
        for (final PluginContainer lllllllllllllIlIIlllIllIIlIIIIIl : VelocityPlugin.PROXY.getPluginManager().getPlugins()) {
            lllllllllllllIlIIlllIllIIIlllllI.add(new PluginInfo(true, lllllllllllllIlIIlllIllIIlIIIIIl.getDescription().getName().orElse(lllllllllllllIlIIlllIllIIlIIIIIl.getDescription().getId()), lllllllllllllIlIIlllIllIIlIIIIIl.getDescription().getVersion().orElse("Unknown Version"), lllllllllllllIlIIlllIllIIlIIIIIl.getInstance().isPresent() ? lllllllllllllIlIIlllIllIIlIIIIIl.getInstance().get().getClass().getCanonicalName() : "Unknown", lllllllllllllIlIIlllIllIIlIIIIIl.getDescription().getAuthors()));
        }
        lllllllllllllIlIIlllIllIIIllllll.add("plugins", GsonUtil.getGson().toJsonTree(lllllllllllllIlIIlllIllIIIlllllI));
        lllllllllllllIlIIlllIllIIIllllll.add("servers", GsonUtil.getGson().toJsonTree(ProtocolDetectorService.getDetectedIds()));
        return lllllllllllllIlIIlllIllIIIllllll;
    }
    
    @Override
    public PlatformTask runRepeatingSync(final Runnable lllllllllllllIlIIlllIllIIllIIlll, final long lllllllllllllIlIIlllIllIIllIIllI) {
        return new VelocityViaTask(VelocityPlugin.PROXY.getScheduler().buildTask((Object)this, lllllllllllllIlIIlllIllIIllIIlll).repeat(lllllllllllllIlIIlllIllIIllIIllI * 50L, TimeUnit.MILLISECONDS).schedule());
    }
    
    @Override
    public String getPlatformName() {
        final String lllllllllllllIlIIlllIllIlIIIlIII = ProxyServer.class.getPackage().getImplementationTitle();
        return (lllllllllllllIlIIlllIllIlIIIlIII != null) ? lllllllllllllIlIIlllIllIlIIIlIII : "Velocity";
    }
    
    @Subscribe
    public void onProxyInit(final ProxyInitializeEvent lllllllllllllIlIIlllIllIlIIlIIII) {
        if (!this.hasConnectionEvent()) {
            final org.slf4j.Logger lllllllllllllIlIIlllIllIlIIlIIlI = this.loggerslf4j;
            lllllllllllllIlIIlllIllIlIIlIIlI.error("      / \\");
            lllllllllllllIlIIlllIllIlIIlIIlI.error("     /   \\");
            lllllllllllllIlIIlllIllIlIIlIIlI.error("    /  |  \\");
            lllllllllllllIlIIlllIllIlIIlIIlI.error("   /   |   \\        VELOCITY 3.0.0 IS REQUIRED");
            lllllllllllllIlIIlllIllIlIIlIIlI.error("  /         \\   VIAVERSION WILL NOT WORK AS INTENDED");
            lllllllllllllIlIIlllIllIlIIlIIlI.error(" /     o     \\");
            lllllllllllllIlIIlllIllIlIIlIIlI.error("/_____________\\");
        }
        VelocityPlugin.PROXY = this.proxy;
        final VelocityCommandHandler lllllllllllllIlIIlllIllIlIIIllll = new VelocityCommandHandler();
        VelocityPlugin.PROXY.getCommandManager().register("viaver", (Command)lllllllllllllIlIIlllIllIlIIIllll, new String[] { "vvvelocity", "viaversion" });
        this.api = new VelocityViaAPI();
        this.conf = new VelocityViaConfig(this.configDir.toFile());
        this.logger = new LoggerWrapper(this.loggerslf4j);
        Via.init(ViaManagerImpl.builder().platform(this).commandHandler(lllllllllllllIlIIlllIllIlIIIllll).loader(new VelocityViaLoader()).injector(new VelocityViaInjector()).build());
        if (this.proxy.getPluginManager().getPlugin("viabackwards").isPresent()) {
            MappingDataLoader.enableMappingsCache();
        }
    }
    
    @Override
    public void sendMessage(final UUID lllllllllllllIlIIlllIllIIlIlllII, final String lllllllllllllIlIIlllIllIIlIlllIl) {
        VelocityPlugin.PROXY.getPlayer(lllllllllllllIlIIlllIllIIlIlllII).ifPresent(lllllllllllllIlIIlllIllIIIlIIIII -> lllllllllllllIlIIlllIllIIIlIIIII.sendMessage((Component)VelocityPlugin.COMPONENT_SERIALIZER.deserialize(lllllllllllllIlIIlllIllIIlIlllIl)));
    }
    
    @Override
    public boolean isOldClientsAllowed() {
        return true;
    }
    
    @Override
    public PlatformTask runSync(final Runnable lllllllllllllIlIIlllIllIIlllIlll) {
        return this.runSync(lllllllllllllIlIIlllIllIIlllIlll, 0L);
    }
    
    @Override
    public String getPlatformVersion() {
        final String lllllllllllllIlIIlllIllIlIIIIlII = ProxyServer.class.getPackage().getImplementationVersion();
        return (lllllllllllllIlIIlllIllIlIIIIlII != null) ? lllllllllllllIlIIlllIllIlIIIIlII : "Unknown";
    }
    
    @Override
    public VelocityViaConfig getConf() {
        return this.conf;
    }
    
    @Override
    public VelocityViaAPI getApi() {
        return this.api;
    }
    
    @Override
    public void onReload() {
    }
    
    @Override
    public File getDataFolder() {
        return this.configDir.toFile();
    }
    
    @Override
    public boolean isProxy() {
        return true;
    }
    
    @Override
    public boolean isPluginEnabled() {
        return true;
    }
    
    @Override
    public ConfigurationProvider getConfigurationProvider() {
        return this.conf;
    }
    
    private boolean hasConnectionEvent() {
        try {
            Class.forName("com.velocitypowered.proxy.protocol.VelocityConnectionEvent");
            return true;
        }
        catch (ClassNotFoundException lllllllllllllIlIIlllIllIIIllIlII) {
            return false;
        }
    }
    
    static {
        COMPONENT_SERIALIZER = LegacyComponentSerializer.builder().character('§').extractUrls().build();
    }
    
    @Override
    public boolean kickPlayer(final UUID lllllllllllllIlIIlllIllIIlIlIlIl, final String lllllllllllllIlIIlllIllIIlIlIllI) {
        return VelocityPlugin.PROXY.getPlayer(lllllllllllllIlIIlllIllIIlIlIlIl).map(lllllllllllllIlIIlllIllIIIlIlIII -> {
            lllllllllllllIlIIlllIllIIIlIlIII.disconnect((Component)LegacyComponentSerializer.legacySection().deserialize(lllllllllllllIlIIlllIllIIlIlIllI));
            return true;
        }).orElse(false);
    }
    
    @Override
    public String getPluginVersion() {
        return "4.0.2-SNAPSHOT";
    }
    
    @Subscribe(order = PostOrder.LAST)
    public void onProxyLateInit(final ProxyInitializeEvent lllllllllllllIlIIlllIllIlIIIlIll) {
        ((ViaManagerImpl)Via.getManager()).init();
    }
    
    @Override
    public PlatformTask runAsync(final Runnable lllllllllllllIlIIlllIllIIlllllIl) {
        return this.runSync(lllllllllllllIlIIlllIllIIlllllIl);
    }
}
