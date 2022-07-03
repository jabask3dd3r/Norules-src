package com.viaversion.viaversion;

import org.bukkit.plugin.java.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.dump.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.api.configuration.*;
import com.viaversion.viaversion.api.command.*;
import com.viaversion.viaversion.bukkit.commands.*;
import com.viaversion.viaversion.unsupported.*;
import java.util.*;
import org.bukkit.scheduler.*;
import org.bukkit.command.*;
import com.viaversion.viaversion.bukkit.listeners.*;
import org.bukkit.event.*;
import com.viaversion.viaversion.commands.*;
import com.viaversion.viaversion.bukkit.platform.*;
import com.viaversion.viaversion.api.platform.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.bukkit.util.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viaversion.bukkit.classgenerator.*;
import org.bukkit.*;

public class ViaVersionPlugin extends JavaPlugin implements ViaPlatform<Player>
{
    private /* synthetic */ boolean spigot;
    private /* synthetic */ boolean lateBind;
    private final /* synthetic */ List<Runnable> asyncQueuedTasks;
    private final /* synthetic */ List<Runnable> queuedTasks;
    private final /* synthetic */ BukkitCommandHandler commandHandler;
    private static /* synthetic */ ViaVersionPlugin instance;
    private final /* synthetic */ ViaAPI<Player> api;
    private /* synthetic */ boolean compatSpigotBuild;
    private final /* synthetic */ BukkitViaConfig conf;
    private final /* synthetic */ boolean protocolSupport;
    
    public PlatformTask runRepeatingSync(final Runnable llllllllllllllIIlIlIIIlIlllIllll, final long llllllllllllllIIlIlIIIlIllllIIIl) {
        return new BukkitViaTask(this.getServer().getScheduler().runTaskTimer((Plugin)this, llllllllllllllIIlIlIIIlIlllIllll, 0L, llllllllllllllIIlIlIIIlIllllIIIl));
    }
    
    public ViaAPI<Player> getApi() {
        return this.api;
    }
    
    public String getPlatformName() {
        return Bukkit.getServer().getName();
    }
    
    public boolean isProtocolSupport() {
        return this.protocolSupport;
    }
    
    public JsonObject getDump() {
        final JsonObject llllllllllllllIIlIlIIIlIlIlllIIl = new JsonObject();
        final List<PluginInfo> llllllllllllllIIlIlIIIlIlIlllIII = new ArrayList<PluginInfo>();
        final double llllllllllllllIIlIlIIIlIlIllIlIl = (Object)Bukkit.getPluginManager().getPlugins();
        final byte llllllllllllllIIlIlIIIlIlIllIlII = (byte)llllllllllllllIIlIlIIIlIlIllIlIl.length;
        for (short llllllllllllllIIlIlIIIlIlIllIIll = 0; llllllllllllllIIlIlIIIlIlIllIIll < llllllllllllllIIlIlIIIlIlIllIlII; ++llllllllllllllIIlIlIIIlIlIllIIll) {
            final Plugin llllllllllllllIIlIlIIIlIlIlllIll = llllllllllllllIIlIlIIIlIlIllIlIl[llllllllllllllIIlIlIIIlIlIllIIll];
            llllllllllllllIIlIlIIIlIlIlllIII.add(new PluginInfo(llllllllllllllIIlIlIIIlIlIlllIll.isEnabled(), llllllllllllllIIlIlIIIlIlIlllIll.getDescription().getName(), llllllllllllllIIlIlIIIlIlIlllIll.getDescription().getVersion(), llllllllllllllIIlIlIIIlIlIlllIll.getDescription().getMain(), llllllllllllllIIlIlIIIlIlIlllIll.getDescription().getAuthors()));
        }
        llllllllllllllIIlIlIIIlIlIlllIIl.add("plugins", GsonUtil.getGson().toJsonTree(llllllllllllllIIlIlIIIlIlIlllIII));
        return llllllllllllllIIlIlIIIlIlIlllIIl;
    }
    
    public ConfigurationProvider getConfigurationProvider() {
        return this.conf;
    }
    
    public boolean isPluginEnabled() {
        return Bukkit.getPluginManager().getPlugin("ViaVersion").isEnabled();
    }
    
    public boolean isLateBind() {
        return this.lateBind;
    }
    
    public static ViaVersionPlugin getInstance() {
        return ViaVersionPlugin.instance;
    }
    
    public String getPlatformVersion() {
        return Bukkit.getServer().getVersion();
    }
    
    public void sendMessage(final UUID llllllllllllllIIlIlIIIlIllIlllIl, final String llllllllllllllIIlIlIIIlIllIlllII) {
        final Player llllllllllllllIIlIlIIIlIllIllIll = Bukkit.getPlayer(llllllllllllllIIlIlIIIlIllIlllIl);
        if (llllllllllllllIIlIlIIIlIllIllIll != null) {
            llllllllllllllIIlIlIIIlIllIllIll.sendMessage(llllllllllllllIIlIlIIIlIllIlllII);
        }
    }
    
    public PlatformTask runSync(final Runnable llllllllllllllIIlIlIIIlIlllllIII, final long llllllllllllllIIlIlIIIlIllllIlll) {
        return new BukkitViaTask(this.getServer().getScheduler().runTaskLater((Plugin)this, llllllllllllllIIlIlIIIlIlllllIII, llllllllllllllIIlIlIIIlIllllIlll));
    }
    
    public void onDisable() {
        ((ViaManagerImpl)Via.getManager()).destroy();
    }
    
    public String getPluginVersion() {
        return this.getDescription().getVersion();
    }
    
    public ViaCommandSender[] getOnlinePlayers() {
        final ViaCommandSender[] llllllllllllllIIlIlIIIlIlllIIlll = new ViaCommandSender[Bukkit.getOnlinePlayers().size()];
        int llllllllllllllIIlIlIIIlIlllIIllI = 0;
        for (final Player llllllllllllllIIlIlIIIlIlllIlIIl : Bukkit.getOnlinePlayers()) {
            llllllllllllllIIlIlIIIlIlllIIlll[llllllllllllllIIlIlIIIlIlllIIllI++] = new BukkitCommandSender((CommandSender)llllllllllllllIIlIlIIIlIlllIlIIl);
        }
        return llllllllllllllIIlIlIIIlIlllIIlll;
    }
    
    public boolean isOldClientsAllowed() {
        return !this.protocolSupport;
    }
    
    public final Collection<UnsupportedSoftware> getUnsupportedSoftwareClasses() {
        final List<UnsupportedSoftware> llllllllllllllIIlIlIIIlIlIlIIlIl = new ArrayList<UnsupportedSoftware>(super.getUnsupportedSoftwareClasses());
        llllllllllllllIIlIlIIIlIlIlIIlIl.add(new UnsupportedSoftwareImpl.Builder().name("Yatopia").reason("You are using server software that - outside of possibly breaking ViaVersion - can also cause severe damage to your server's integrity as a whole.").addClassName("org.yatopiamc.yatopia.server.YatopiaConfig").addClassName("net.yatopia.api.event.PlayerAttackEntityEvent").addClassName("yatopiamc.org.yatopia.server.YatopiaConfig").addMethod("org.bukkit.Server", "getLastTickTime").build());
        return (Collection<UnsupportedSoftware>)Collections.unmodifiableList((List<?>)llllllllllllllIIlIlIIIlIlIlIIlIl);
    }
    
    public boolean isSpigot() {
        return this.spigot;
    }
    
    public boolean isCompatSpigotBuild() {
        return this.compatSpigotBuild;
    }
    
    public PlatformTask runAsync(final Runnable llllllllllllllIIlIlIIIllIIIIlIII) {
        if (this.isPluginEnabled()) {
            return new BukkitViaTask(this.getServer().getScheduler().runTaskAsynchronously((Plugin)this, llllllllllllllIIlIlIIIllIIIIlIII));
        }
        this.asyncQueuedTasks.add(llllllllllllllIIlIlIIIllIIIIlIII);
        return new BukkitViaTask(null);
    }
    
    public boolean kickPlayer(final UUID llllllllllllllIIlIlIIIlIllIlIIll, final String llllllllllllllIIlIlIIIlIllIIllll) {
        final Player llllllllllllllIIlIlIIIlIllIlIIIl = Bukkit.getPlayer(llllllllllllllIIlIlIIIlIllIlIIll);
        if (llllllllllllllIIlIlIIIlIllIlIIIl != null) {
            llllllllllllllIIlIlIIIlIllIlIIIl.kickPlayer(llllllllllllllIIlIlIIIlIllIIllll);
            return true;
        }
        return false;
    }
    
    public void onEnable() {
        if (this.lateBind) {
            ((ViaManagerImpl)Via.getManager()).init();
        }
        this.getCommand("viaversion").setExecutor((CommandExecutor)this.commandHandler);
        this.getCommand("viaversion").setTabCompleter((TabCompleter)this.commandHandler);
        this.getServer().getPluginManager().registerEvents((Listener)new ProtocolLibEnableListener(), (Plugin)this);
        if (this.conf.isAntiXRay() && !this.spigot) {
            this.getLogger().info("You have anti-xray on in your config, since you're not using spigot it won't fix xray!");
        }
        for (final Runnable llllllllllllllIIlIlIIIllIIIlIlll : this.queuedTasks) {
            Bukkit.getScheduler().runTask((Plugin)this, llllllllllllllIIlIlIIIllIIIlIlll);
        }
        this.queuedTasks.clear();
        for (final Runnable llllllllllllllIIlIlIIIllIIIlIllI : this.asyncQueuedTasks) {
            Bukkit.getScheduler().runTaskAsynchronously((Plugin)this, llllllllllllllIIlIlIIIllIIIlIllI);
        }
        this.asyncQueuedTasks.clear();
    }
    
    public ViaVersionPlugin() {
        this.api = new BukkitViaAPI(this);
        this.queuedTasks = new ArrayList<Runnable>();
        this.asyncQueuedTasks = new ArrayList<Runnable>();
        this.spigot = true;
        ViaVersionPlugin.instance = this;
        this.commandHandler = new BukkitCommandHandler();
        final BukkitViaInjector llllllllllllllIIlIlIIIllIIlIlIII = new BukkitViaInjector();
        Via.init(ViaManagerImpl.builder().platform(this).commandHandler(this.commandHandler).injector(llllllllllllllIIlIlIIIllIIlIlIII).loader(new BukkitViaLoader(this)).build());
        this.conf = new BukkitViaConfig();
        this.protocolSupport = (Bukkit.getPluginManager().getPlugin("ProtocolSupport") != null);
        if (this.protocolSupport) {
            this.getLogger().info("Hooking into ProtocolSupport, to prevent issues!");
            try {
                BukkitViaInjector.patchLists();
            }
            catch (Exception llllllllllllllIIlIlIIIllIIlIlIlI) {
                llllllllllllllIIlIlIIIllIIlIlIlI.printStackTrace();
            }
        }
    }
    
    public void onLoad() {
        final boolean llllllllllllllIIlIlIIIllIIIllllI = Bukkit.getPluginManager().getPlugin("ProtocolLib") != null;
        ((BukkitViaInjector)Via.getManager().getInjector()).setProtocolLib(llllllllllllllIIlIlIIIllIIIllllI);
        try {
            Class.forName("org.spigotmc.SpigotConfig");
        }
        catch (ClassNotFoundException llllllllllllllIIlIlIIIllIIlIIIIl) {
            this.spigot = false;
        }
        try {
            NMSUtil.nms("PacketEncoder", "net.minecraft.network.PacketEncoder").getDeclaredField("version");
            this.compatSpigotBuild = true;
        }
        catch (Exception llllllllllllllIIlIlIIIllIIlIIIII) {
            this.compatSpigotBuild = false;
        }
        if (this.getServer().getPluginManager().getPlugin("ViaBackwards") != null) {
            MappingDataLoader.enableMappingsCache();
        }
        ClassGenerator.generate();
        this.lateBind = !BukkitViaInjector.isBinded();
        this.getLogger().info(String.valueOf(new StringBuilder().append("ViaVersion ").append(this.getDescription().getVersion()).append(this.compatSpigotBuild ? "compat" : "").append(" is now loaded").append(this.lateBind ? ", waiting for boot. (late-bind)" : ", injecting!")));
        if (!this.lateBind) {
            ((ViaManagerImpl)Via.getManager()).init();
        }
    }
    
    public void onReload() {
        if (Bukkit.getPluginManager().getPlugin("ProtocolLib") != null) {
            this.getLogger().severe("ViaVersion is already loaded, we're going to kick all the players... because otherwise we'll crash because of ProtocolLib.");
            for (final Player llllllllllllllIIlIlIIIlIllIIIllI : Bukkit.getOnlinePlayers()) {
                llllllllllllllIIlIlIIIlIllIIIllI.kickPlayer(ChatColor.translateAlternateColorCodes('&', this.conf.getReloadDisconnectMsg()));
            }
        }
        else {
            this.getLogger().severe("ViaVersion is already loaded, this should work fine. If you get any console errors, try rebooting.");
        }
    }
    
    public BukkitViaConfig getConf() {
        return this.conf;
    }
    
    public PlatformTask runSync(final Runnable llllllllllllllIIlIlIIIllIIIIIIlI) {
        if (this.isPluginEnabled()) {
            return new BukkitViaTask(this.getServer().getScheduler().runTask((Plugin)this, llllllllllllllIIlIlIIIllIIIIIIlI));
        }
        this.queuedTasks.add(llllllllllllllIIlIlIIIllIIIIIIlI);
        return new BukkitViaTask(null);
    }
}
