package com.viaversion.viaversion;

import net.md_5.bungee.api.connection.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.dump.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.bungee.service.*;
import java.util.concurrent.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viaversion.api.configuration.*;
import net.md_5.bungee.protocol.*;
import net.md_5.bungee.api.plugin.*;
import com.viaversion.viaversion.bungee.platform.*;
import com.viaversion.viaversion.api.platform.*;
import com.viaversion.viaversion.commands.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.command.*;
import com.viaversion.viaversion.bungee.commands.*;
import net.md_5.bungee.api.*;
import java.util.*;

public class BungeePlugin extends Plugin implements ViaPlatform<ProxiedPlayer>, Listener
{
    private /* synthetic */ BungeeViaConfig config;
    private /* synthetic */ BungeeViaAPI api;
    
    public void sendMessage(final UUID llllllllllllllIIIIllIIIlIllIllIl, final String llllllllllllllIIIIllIIIlIllIlIll) {
        this.getProxy().getPlayer(llllllllllllllIIIIllIIIlIllIllIl).sendMessage(llllllllllllllIIIIllIIIlIllIlIll);
    }
    
    public void onReload() {
    }
    
    public JsonObject getDump() {
        final JsonObject llllllllllllllIIIIllIIIlIIlIIlll = new JsonObject();
        final List<PluginInfo> llllllllllllllIIIIllIIIlIIlIIlIl = new ArrayList<PluginInfo>();
        for (final Plugin llllllllllllllIIIIllIIIlIIlIlIll : ProxyServer.getInstance().getPluginManager().getPlugins()) {
            llllllllllllllIIIIllIIIlIIlIIlIl.add(new PluginInfo(true, llllllllllllllIIIIllIIIlIIlIlIll.getDescription().getName(), llllllllllllllIIIIllIIIlIIlIlIll.getDescription().getVersion(), llllllllllllllIIIIllIIIlIIlIlIll.getDescription().getMain(), Collections.singletonList(llllllllllllllIIIIllIIIlIIlIlIll.getDescription().getAuthor())));
        }
        llllllllllllllIIIIllIIIlIIlIIlll.add("plugins", GsonUtil.getGson().toJsonTree(llllllllllllllIIIIllIIIlIIlIIlIl));
        llllllllllllllIIIIllIIIlIIlIIlll.add("servers", GsonUtil.getGson().toJsonTree(ProtocolDetectorService.getDetectedIds()));
        return llllllllllllllIIIIllIIIlIIlIIlll;
    }
    
    public PlatformTask runAsync(final Runnable llllllllllllllIIIIllIIIlllIIllll) {
        return new BungeeViaTask(this.getProxy().getScheduler().runAsync((Plugin)this, llllllllllllllIIIIllIIIlllIIllll));
    }
    
    public BungeeViaConfig getConf() {
        return this.config;
    }
    
    public boolean kickPlayer(final UUID llllllllllllllIIIIllIIIlIlIlIllI, final String llllllllllllllIIIIllIIIlIlIllIIl) {
        final ProxiedPlayer llllllllllllllIIIIllIIIlIlIllIII = this.getProxy().getPlayer(llllllllllllllIIIIllIIIlIlIlIllI);
        if (llllllllllllllIIIIllIIIlIlIllIII != null) {
            llllllllllllllIIIIllIIIlIlIllIII.disconnect(llllllllllllllIIIIllIIIlIlIllIIl);
            return true;
        }
        return false;
    }
    
    public PlatformTask runRepeatingSync(final Runnable llllllllllllllIIIIllIIIllIIlllII, final long llllllllllllllIIIIllIIIllIIllllI) {
        return new BungeeViaTask(this.getProxy().getScheduler().schedule((Plugin)this, llllllllllllllIIIIllIIIllIIlllII, 0L, llllllllllllllIIIIllIIIllIIllllI * 50L, TimeUnit.MILLISECONDS));
    }
    
    public void onEnable() {
        if (ProxyServer.getInstance().getPluginManager().getPlugin("ViaBackwards") != null) {
            MappingDataLoader.enableMappingsCache();
        }
        ((ViaManagerImpl)Via.getManager()).init();
    }
    
    public boolean isProxy() {
        return true;
    }
    
    public boolean isOldClientsAllowed() {
        return true;
    }
    
    public ViaAPI<ProxiedPlayer> getApi() {
        return this.api;
    }
    
    public PlatformTask runSync(final Runnable llllllllllllllIIIIllIIIllIlIllIl, final long llllllllllllllIIIIllIIIllIlIllII) {
        return new BungeeViaTask(this.getProxy().getScheduler().schedule((Plugin)this, llllllllllllllIIIIllIIIllIlIllIl, llllllllllllllIIIIllIIIllIlIllII * 50L, TimeUnit.MILLISECONDS));
    }
    
    public String getPluginVersion() {
        return this.getDescription().getVersion();
    }
    
    public String getPlatformName() {
        return this.getProxy().getName();
    }
    
    public ConfigurationProvider getConfigurationProvider() {
        return this.config;
    }
    
    public void onLoad() {
        try {
            ProtocolConstants.class.getField("MINECRAFT_1_17");
        }
        catch (NoSuchFieldException llllllllllllllIIIIllIIIlllllIIII) {
            this.getLogger().warning("      / \\");
            this.getLogger().warning("     /   \\");
            this.getLogger().warning("    /  |  \\");
            this.getLogger().warning("   /   |   \\         BUNGEECORD IS OUTDATED");
            this.getLogger().warning("  /         \\   VIAVERSION MAY NOT WORK AS INTENDED");
            this.getLogger().warning(" /     o     \\");
            this.getLogger().warning("/_____________\\");
        }
        this.api = new BungeeViaAPI();
        this.config = new BungeeViaConfig(this.getDataFolder());
        final BungeeCommandHandler llllllllllllllIIIIllIIIllllIlllI = new BungeeCommandHandler();
        ProxyServer.getInstance().getPluginManager().registerCommand((Plugin)this, (Command)new BungeeCommand(llllllllllllllIIIIllIIIllllIlllI));
        Via.init(ViaManagerImpl.builder().platform(this).injector(new BungeeViaInjector()).loader(new BungeeViaLoader(this)).commandHandler(llllllllllllllIIIIllIIIllllIlllI).build());
    }
    
    public ViaCommandSender[] getOnlinePlayers() {
        final Collection<ProxiedPlayer> llllllllllllllIIIIllIIIllIIIIlII = (Collection<ProxiedPlayer>)this.getProxy().getPlayers();
        final ViaCommandSender[] llllllllllllllIIIIllIIIllIIIIIlI = new ViaCommandSender[llllllllllllllIIIIllIIIllIIIIlII.size()];
        int llllllllllllllIIIIllIIIllIIIIIII = 0;
        for (final ProxiedPlayer llllllllllllllIIIIllIIIllIIIlIII : llllllllllllllIIIIllIIIllIIIIlII) {
            llllllllllllllIIIIllIIIllIIIIIlI[llllllllllllllIIIIllIIIllIIIIIII++] = new BungeeCommandSender((CommandSender)llllllllllllllIIIIllIIIllIIIlIII);
        }
        return llllllllllllllIIIIllIIIllIIIIIlI;
    }
    
    public PlatformTask runSync(final Runnable llllllllllllllIIIIllIIIlllIIIIII) {
        return this.runAsync(llllllllllllllIIIIllIIIlllIIIIII);
    }
    
    public String getPlatformVersion() {
        return this.getProxy().getVersion();
    }
    
    public boolean isPluginEnabled() {
        return true;
    }
}
