package com.viaversion.viaversion;

import org.spongepowered.api.entity.living.player.*;
import org.spongepowered.api.plugin.*;
import com.google.inject.*;
import java.io.*;
import org.spongepowered.api.config.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.serializer.legacy.*;
import org.spongepowered.api.*;
import java.util.logging.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.dump.*;
import com.viaversion.viaversion.util.*;
import org.spongepowered.api.scheduler.*;
import org.spongepowered.api.text.serializer.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import com.viaversion.viaversion.sponge.util.*;
import com.viaversion.viaversion.commands.*;
import com.viaversion.viaversion.sponge.platform.*;
import com.viaversion.viaversion.api.platform.*;
import com.viaversion.viaversion.api.*;
import org.spongepowered.api.event.*;
import com.viaversion.viaversion.api.configuration.*;
import org.spongepowered.api.event.game.state.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viaversion.api.command.*;
import com.viaversion.viaversion.sponge.commands.*;
import org.spongepowered.api.command.*;

@Plugin(id = "viaversion", name = "ViaVersion", version = "4.0.2-SNAPSHOT", authors = { "_MylesC", "creeper123123321", "Gerrygames", "kennytv", "Matsv" }, description = "Allow newer Minecraft versions to connect to an older server version.")
public class SpongePlugin implements ViaPlatform<Player>
{
    @Inject
    private /* synthetic */ PluginContainer container;
    private /* synthetic */ SpongeViaConfig conf;
    @Inject
    @DefaultConfig(sharedRoot = false)
    private /* synthetic */ File spongeConfig;
    public static final /* synthetic */ LegacyComponentSerializer COMPONENT_SERIALIZER;
    @Inject
    private /* synthetic */ Game game;
    private /* synthetic */ Logger logger;
    private final /* synthetic */ SpongeViaAPI api;
    
    @Override
    public boolean isOldClientsAllowed() {
        return true;
    }
    
    @Override
    public JsonObject getDump() {
        final JsonObject lllllllllllllIIIlIIIlllIlIllIlIl = new JsonObject();
        final List<PluginInfo> lllllllllllllIIIlIIIlllIlIllIlII = new ArrayList<PluginInfo>();
        for (final PluginContainer lllllllllllllIIIlIIIlllIlIllIlll : this.game.getPluginManager().getPlugins()) {
            lllllllllllllIIIlIIIlllIlIllIlII.add(new PluginInfo(true, lllllllllllllIIIlIIIlllIlIllIlll.getName(), lllllllllllllIIIlIIIlllIlIllIlll.getVersion().orElse("Unknown Version"), lllllllllllllIIIlIIIlllIlIllIlll.getInstance().isPresent() ? lllllllllllllIIIlIIIlllIlIllIlll.getInstance().get().getClass().getCanonicalName() : "Unknown", lllllllllllllIIIlIIIlllIlIllIlll.getAuthors()));
        }
        lllllllllllllIIIlIIIlllIlIllIlIl.add("plugins", GsonUtil.getGson().toJsonTree(lllllllllllllIIIlIIIlllIlIllIlII));
        return lllllllllllllIIIlIIIlllIlIllIlIl;
    }
    
    public SpongePlugin() {
        this.api = new SpongeViaAPI();
    }
    
    @Override
    public PlatformTask runRepeatingSync(final Runnable lllllllllllllIIIlIIIlllIlllIlllI, final long lllllllllllllIIIlIIIlllIlllIlIlI) {
        return new SpongeViaTask(Task.builder().execute(lllllllllllllIIIlIIIlllIlllIlllI).intervalTicks(lllllllllllllIIIlIIIlllIlllIlIlI).submit((Object)this));
    }
    
    @Override
    public ConfigurationProvider getConfigurationProvider() {
        return this.conf;
    }
    
    @Override
    public String getPlatformName() {
        return this.game.getPlatform().getImplementation().getName();
    }
    
    @Override
    public PlatformTask runAsync(final Runnable lllllllllllllIIIlIIIllllIIIIIIlI) {
        return new SpongeViaTask(Task.builder().execute(lllllllllllllIIIlIIIllllIIIIIIlI).async().submit((Object)this));
    }
    
    @Override
    public void sendMessage(final UUID lllllllllllllIIIlIIIlllIllIlIIlI, final String lllllllllllllIIIlIIIlllIllIlIlIl) {
        final String lllllllllllllIIIlIIIlllIllIlIlII = SpongePlugin.COMPONENT_SERIALIZER.serialize((Component)SpongePlugin.COMPONENT_SERIALIZER.deserialize(lllllllllllllIIIlIIIlllIllIlIlIl));
        this.game.getServer().getPlayer(lllllllllllllIIIlIIIlllIllIlIIlI).ifPresent(lllllllllllllIIIlIIIlllIlIIlIIll -> lllllllllllllIIIlIIIlllIlIIlIIll.sendMessage(TextSerializers.JSON.deserialize(lllllllllllllIIIlIIIlllIllIlIlII)));
    }
    
    @Override
    public boolean kickPlayer(final UUID lllllllllllllIIIlIIIlllIllIIlIII, final String lllllllllllllIIIlIIIlllIllIIIlll) {
        return this.game.getServer().getPlayer(lllllllllllllIIIlIIIlllIllIIlIII).map(lllllllllllllIIIlIIIlllIlIIllIIl -> {
            lllllllllllllIIIlIIIlllIlIIllIIl.kick(TextSerializers.formattingCode('§').deserialize(lllllllllllllIIIlIIIlllIllIIIlll));
            return true;
        }).orElse(false);
    }
    
    @Override
    public String getPlatformVersion() {
        return this.game.getPlatform().getImplementation().getVersion().orElse("Unknown Version");
    }
    
    @Listener
    public void onGameStart(final GameInitializationEvent lllllllllllllIIIlIIIllllIIIllIlI) {
        this.logger = new LoggerWrapper(this.container.getLogger());
        this.conf = new SpongeViaConfig(this.container, this.spongeConfig.getParentFile());
        final SpongeCommandHandler lllllllllllllIIIlIIIllllIIIllIIl = new SpongeCommandHandler();
        this.game.getCommandManager().register((Object)this, (CommandCallable)lllllllllllllIIIlIIIllllIIIllIIl, new String[] { "viaversion", "viaver", "vvsponge" });
        this.logger.info(String.valueOf(new StringBuilder().append("ViaVersion ").append(this.getPluginVersion()).append(" is now loaded!")));
        Via.init(ViaManagerImpl.builder().platform(this).commandHandler(lllllllllllllIIIlIIIllllIIIllIIl).injector(new SpongeViaInjector()).loader(new SpongeViaLoader(this)).build());
    }
    
    @Override
    public SpongeViaAPI getApi() {
        return this.api;
    }
    
    @Listener
    public void onServerStop(final GameStoppingServerEvent lllllllllllllIIIlIIIllllIIIlIIIl) {
        ((ViaManagerImpl)Via.getManager()).destroy();
    }
    
    @Override
    public boolean isPluginEnabled() {
        return true;
    }
    
    @Override
    public SpongeViaConfig getConf() {
        return this.conf;
    }
    
    @Listener
    public void onServerStart(final GameAboutToStartServerEvent lllllllllllllIIIlIIIllllIIIlIlII) {
        if (this.game.getPluginManager().getPlugin("viabackwards").isPresent()) {
            MappingDataLoader.enableMappingsCache();
        }
        this.logger.info("ViaVersion is injecting!");
        ((ViaManagerImpl)Via.getManager()).init();
    }
    
    @Override
    public void onReload() {
        this.getLogger().severe("ViaVersion is already loaded, this should work fine. If you get any console errors, try rebooting.");
    }
    
    @Override
    public PlatformTask runSync(final Runnable lllllllllllllIIIlIIIlllIlllllllI) {
        return new SpongeViaTask(Task.builder().execute(lllllllllllllIIIlIIIlllIlllllllI).submit((Object)this));
    }
    
    static {
        COMPONENT_SERIALIZER = LegacyComponentSerializer.builder().character('§').extractUrls().build();
    }
    
    @Override
    public File getDataFolder() {
        return this.spongeConfig.getParentFile();
    }
    
    @Override
    public PlatformTask runSync(final Runnable lllllllllllllIIIlIIIlllIllllIlll, final long lllllllllllllIIIlIIIlllIllllIllI) {
        return new SpongeViaTask(Task.builder().execute(lllllllllllllIIIlIIIlllIllllIlll).delayTicks(lllllllllllllIIIlIIIlllIllllIllI).submit((Object)this));
    }
    
    @Override
    public Logger getLogger() {
        return this.logger;
    }
    
    @Override
    public String getPluginVersion() {
        return this.container.getVersion().orElse("Unknown Version");
    }
    
    @Override
    public ViaCommandSender[] getOnlinePlayers() {
        final ViaCommandSender[] lllllllllllllIIIlIIIlllIlllIIIlI = new ViaCommandSender[this.game.getServer().getOnlinePlayers().size()];
        int lllllllllllllIIIlIIIlllIlllIIIIl = 0;
        for (final Player lllllllllllllIIIlIIIlllIlllIIlII : this.game.getServer().getOnlinePlayers()) {
            lllllllllllllIIIlIIIlllIlllIIIlI[lllllllllllllIIIlIIIlllIlllIIIIl++] = new SpongeCommandSender((CommandSource)lllllllllllllIIIlIIIlllIlllIIlII);
        }
        return lllllllllllllIIIlIIIlllIlllIIIlI;
    }
}
