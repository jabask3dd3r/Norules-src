package com.viaversion.viaversion;

import com.viaversion.viaversion.commands.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.platform.providers.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocol.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import com.viaversion.viaversion.api.protocol.version.*;
import com.viaversion.viaversion.update.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.connection.*;
import java.util.*;
import com.viaversion.viaversion.api.platform.*;
import com.viaversion.viaversion.api.command.*;

public class ViaManagerImpl implements ViaManager
{
    private final /* synthetic */ Set<String> subPlatforms;
    private /* synthetic */ boolean debug;
    private final /* synthetic */ ViaCommandHandler commandHandler;
    private final /* synthetic */ ConnectionManager connectionManager;
    private /* synthetic */ List<Runnable> enableListeners;
    private /* synthetic */ PlatformTask mappingLoadingTask;
    private final /* synthetic */ ViaProviders providers;
    private final /* synthetic */ ViaInjector injector;
    private final /* synthetic */ ViaPlatform<?> platform;
    private final /* synthetic */ ViaPlatformLoader loader;
    private final /* synthetic */ ProtocolManagerImpl protocolManager;
    
    @Override
    public ViaPlatform<?> getPlatform() {
        return this.platform;
    }
    
    @Override
    public void setDebug(final boolean lllllllllllllIIIIllIllIIllIllIIl) {
        this.debug = lllllllllllllIIIIllIllIIllIllIIl;
    }
    
    public void destroy() {
        this.platform.getLogger().info("ViaVersion is disabling, if this is a reload and you experience issues consider rebooting.");
        try {
            this.injector.uninject();
        }
        catch (Exception lllllllllllllIIIIllIllIlIIIIllll) {
            this.platform.getLogger().severe("ViaVersion failed to uninject:");
            lllllllllllllIIIIllIllIlIIIIllll.printStackTrace();
        }
        this.loader.unload();
    }
    
    @Override
    public ViaProviders getProviders() {
        return this.providers;
    }
    
    @Override
    public ProtocolManager getProtocolManager() {
        return this.protocolManager;
    }
    
    @Override
    public void addEnableListener(final Runnable lllllllllllllIIIIllIllIIllIIlIIl) {
        this.enableListeners.add(lllllllllllllIIIIllIllIIllIIlIIl);
    }
    
    private final void checkJavaVersion() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: invokestatic    java/lang/System.getProperty:(Ljava/lang/String;)Ljava/lang/String;
        //     5: astore_1        /* lllllllllllllIIIIllIllIlIIIIIIlI */
        //     6: ldc             "(?:1\\.)?(\\d+)"
        //     8: invokestatic    java/util/regex/Pattern.compile:(Ljava/lang/String;)Ljava/util/regex/Pattern;
        //    11: aload_1         /* lllllllllllllIIIIllIllIlIIIIIIlI */
        //    12: invokevirtual   java/util/regex/Pattern.matcher:(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
        //    15: astore_2        /* lllllllllllllIIIIllIllIIllllllII */
        //    16: aload_2         /* lllllllllllllIIIIllIllIlIIIIIIIl */
        //    17: invokevirtual   java/util/regex/Matcher.find:()Z
        //    20: ifne            55
        //    23: aload_0         /* lllllllllllllIIIIllIllIIlllllllI */
        //    24: getfield        com/viaversion/viaversion/ViaManagerImpl.platform:Lcom/viaversion/viaversion/api/platform/ViaPlatform;
        //    27: invokeinterface com/viaversion/viaversion/api/platform/ViaPlatform.getLogger:()Ljava/util/logging/Logger;
        //    32: new             Ljava/lang/StringBuilder;
        //    35: dup            
        //    36: invokespecial   java/lang/StringBuilder.<init>:()V
        //    39: ldc             "Failed to determine Java version; could not parse: "
        //    41: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    44: aload_1         /* lllllllllllllIIIIllIllIlIIIIIIlI */
        //    45: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    48: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    51: invokevirtual   java/util/logging/Logger.warning:(Ljava/lang/String;)V
        //    54: return         
        //    55: aload_2         /* lllllllllllllIIIIllIllIlIIIIIIIl */
        //    56: iconst_1       
        //    57: invokevirtual   java/util/regex/Matcher.group:(I)Ljava/lang/String;
        //    60: astore_3        /* lllllllllllllIIIIllIllIIlllllIll */
        //    61: aload_3         /* lllllllllllllIIIIllIllIlIIIIIIII */
        //    62: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //    65: istore          lllllllllllllIIIIllIllIlIIIIIlIl
        //    67: goto            109
        //    70: astore          lllllllllllllIIIIllIllIlIIIIIlII
        //    72: aload_0         /* lllllllllllllIIIIllIllIIlllllllI */
        //    73: getfield        com/viaversion/viaversion/ViaManagerImpl.platform:Lcom/viaversion/viaversion/api/platform/ViaPlatform;
        //    76: invokeinterface com/viaversion/viaversion/api/platform/ViaPlatform.getLogger:()Ljava/util/logging/Logger;
        //    81: new             Ljava/lang/StringBuilder;
        //    84: dup            
        //    85: invokespecial   java/lang/StringBuilder.<init>:()V
        //    88: ldc             "Failed to determine Java version; could not parse: "
        //    90: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    93: aload_3         /* lllllllllllllIIIIllIllIlIIIIIIII */
        //    94: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    97: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   100: invokevirtual   java/util/logging/Logger.warning:(Ljava/lang/String;)V
        //   103: aload           lllllllllllllIIIIllIllIlIIIIIlII
        //   105: invokevirtual   java/lang/NumberFormatException.printStackTrace:()V
        //   108: return         
        //   109: iload           lllllllllllllIIIIllIllIIllllllll
        //   111: bipush          16
        //   113: if_icmpge       152
        //   116: aload_0         /* lllllllllllllIIIIllIllIIlllllllI */
        //   117: getfield        com/viaversion/viaversion/ViaManagerImpl.platform:Lcom/viaversion/viaversion/api/platform/ViaPlatform;
        //   120: invokeinterface com/viaversion/viaversion/api/platform/ViaPlatform.getLogger:()Ljava/util/logging/Logger;
        //   125: new             Ljava/lang/StringBuilder;
        //   128: dup            
        //   129: invokespecial   java/lang/StringBuilder.<init>:()V
        //   132: ldc             "You are running an outdated Java version, please consider updating it to at least Java 16 (your version is "
        //   134: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   137: aload_1         /* lllllllllllllIIIIllIllIlIIIIIIlI */
        //   138: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   141: ldc             "). At some point in the future, ViaVersion will no longer be compatible with this version of Java."
        //   143: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   146: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   149: invokevirtual   java/util/logging/Logger.warning:(Ljava/lang/String;)V
        //   152: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  61     67     70     109    Ljava/lang/NumberFormatException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void loadServerProtocol() {
        try {
            final ProtocolVersion lllllllllllllIIIIllIllIlIIIllIIl = ProtocolVersion.getProtocol(this.injector.getServerProtocolVersion());
            ServerProtocolVersion lllllllllllllIIIIllIllIlIIIllIII = null;
            if (this.platform.isProxy()) {
                final IntSortedSet lllllllllllllIIIIllIllIlIIIllIll = this.injector.getServerProtocolVersions();
                final ServerProtocolVersion lllllllllllllIIIIllIllIlIIIllIlI = new ServerProtocolVersionRange(lllllllllllllIIIIllIllIlIIIllIll.firstInt(), lllllllllllllIIIIllIllIlIIIllIll.lastInt(), lllllllllllllIIIIllIllIlIIIllIll);
            }
            else {
                lllllllllllllIIIIllIllIlIIIllIII = new ServerProtocolVersionSingleton(lllllllllllllIIIIllIllIlIIIllIIl.getVersion());
            }
            this.protocolManager.setServerProtocol(lllllllllllllIIIIllIllIlIIIllIII);
        }
        catch (Exception lllllllllllllIIIIllIllIlIIIlIlll) {
            this.platform.getLogger().severe("ViaVersion failed to get the server protocol!");
            lllllllllllllIIIIllIllIlIIIlIlll.printStackTrace();
        }
    }
    
    @Override
    public boolean isDebug() {
        return this.debug;
    }
    
    @Override
    public ViaPlatformLoader getLoader() {
        return this.loader;
    }
    
    @Override
    public ViaInjector getInjector() {
        return this.injector;
    }
    
    @Override
    public Set<String> getSubPlatforms() {
        return this.subPlatforms;
    }
    
    public void init() {
        if (System.getProperty("ViaVersion") != null) {
            this.platform.onReload();
        }
        if (this.platform.getConf().isCheckForUpdates()) {
            UpdateUtil.sendUpdateMessage();
        }
        if (!this.injector.lateProtocolVersionSetting()) {
            this.loadServerProtocol();
        }
        this.protocolManager.registerProtocols();
        try {
            this.injector.inject();
        }
        catch (Exception lllllllllllllIIIIllIllIlIIlIlllI) {
            this.platform.getLogger().severe("ViaVersion failed to inject:");
            lllllllllllllIIIIllIllIlIIlIlllI.printStackTrace();
            return;
        }
        System.setProperty("ViaVersion", this.platform.getPluginVersion());
        for (final Runnable lllllllllllllIIIIllIllIlIIlIllIl : this.enableListeners) {
            lllllllllllllIIIIllIllIlIIlIllIl.run();
        }
        this.enableListeners = null;
        this.platform.runSync(this::onServerLoaded);
    }
    
    @Override
    public ViaCommandHandler getCommandHandler() {
        return this.commandHandler;
    }
    
    public void onServerLoaded() {
        if (!this.protocolManager.getServerProtocolVersion().isKnown()) {
            this.loadServerProtocol();
        }
        final ServerProtocolVersion lllllllllllllIIIIllIllIlIIlIIlII = this.protocolManager.getServerProtocolVersion();
        if (lllllllllllllIIIIllIllIlIIlIIlII.isKnown()) {
            if (this.platform.isProxy()) {
                this.platform.getLogger().info(String.valueOf(new StringBuilder().append("ViaVersion detected lowest supported version by the proxy: ").append(ProtocolVersion.getProtocol(lllllllllllllIIIIllIllIlIIlIIlII.lowestSupportedVersion()))));
                this.platform.getLogger().info(String.valueOf(new StringBuilder().append("Highest supported version by the proxy: ").append(ProtocolVersion.getProtocol(lllllllllllllIIIIllIllIlIIlIIlII.highestSupportedVersion()))));
                if (this.debug) {
                    this.platform.getLogger().info(String.valueOf(new StringBuilder().append("Supported version range: ").append(Arrays.toString(lllllllllllllIIIIllIllIlIIlIIlII.supportedVersions().toArray(new int[0])))));
                }
            }
            else {
                this.platform.getLogger().info(String.valueOf(new StringBuilder().append("ViaVersion detected server version: ").append(ProtocolVersion.getProtocol(lllllllllllllIIIIllIllIlIIlIIlII.highestSupportedVersion()))));
            }
            if (!this.protocolManager.isWorkingPipe()) {
                this.platform.getLogger().warning("ViaVersion does not have any compatible versions for this server version!");
                this.platform.getLogger().warning("Please remember that ViaVersion only adds support for versions newer than the server version.");
                this.platform.getLogger().warning("If you need support for older versions you may need to use one or more ViaVersion addons too.");
                this.platform.getLogger().warning("In that case please read the ViaVersion resource page carefully or use https://jo0001.github.io/ViaSetup");
                this.platform.getLogger().warning("and if you're still unsure, feel free to join our Discord-Server for further assistance.");
            }
            else if (lllllllllllllIIIIllIllIlIIlIIlII.highestSupportedVersion() <= ProtocolVersion.v1_12_2.getVersion()) {
                this.platform.getLogger().warning("This version of Minecraft is extremely outdated and support for it has reached its end of life. You will still be able to run Via on this Minecraft version, but we are unlikely to provide any further fixes or help with problems specific to legacy Minecraft versions. Please consider updating to give your players a better experience and to avoid issues that have long been fixed.");
            }
        }
        this.checkJavaVersion();
        this.unsupportedSoftwareWarning();
        this.protocolManager.onServerLoaded();
        this.loader.load();
        this.mappingLoadingTask = Via.getPlatform().runRepeatingSync(() -> {
            if (this.protocolManager.checkForMappingCompletion()) {
                this.mappingLoadingTask.cancel();
                this.mappingLoadingTask = null;
            }
            return;
        }, 10L);
        final int lllllllllllllIIIIllIllIlIIlIIIll = this.protocolManager.getServerProtocolVersion().lowestSupportedVersion();
        if (lllllllllllllIIIIllIllIlIIlIIIll < ProtocolVersion.v1_9.getVersion() && Via.getConfig().isSimulatePlayerTick()) {
            Via.getPlatform().runRepeatingSync(new ViaIdleThread(), 1L);
        }
        if (lllllllllllllIIIIllIllIlIIlIIIll < ProtocolVersion.v1_13.getVersion() && Via.getConfig().get1_13TabCompleteDelay() > 0) {
            Via.getPlatform().runRepeatingSync(new TabCompleteThread(), 1L);
        }
        this.protocolManager.refreshVersions();
    }
    
    public ViaManagerImpl(final ViaPlatform<?> lllllllllllllIIIIllIllIlIIlllIlI, final ViaInjector lllllllllllllIIIIllIllIlIIlllIIl, final ViaCommandHandler lllllllllllllIIIIllIllIlIIlllIII, final ViaPlatformLoader lllllllllllllIIIIllIllIlIIllIlll) {
        this.protocolManager = new ProtocolManagerImpl();
        this.connectionManager = new ConnectionManagerImpl();
        this.providers = new ViaProviders();
        this.subPlatforms = new HashSet<String>();
        this.enableListeners = new ArrayList<Runnable>();
        this.platform = lllllllllllllIIIIllIllIlIIlllIlI;
        this.injector = lllllllllllllIIIIllIllIlIIlllIIl;
        this.commandHandler = lllllllllllllIIIIllIllIlIIlllIII;
        this.loader = lllllllllllllIIIIllIllIlIIllIlll;
    }
    
    @Override
    public ConnectionManager getConnectionManager() {
        return this.connectionManager;
    }
    
    public static ViaManagerBuilder builder() {
        return new ViaManagerBuilder();
    }
    
    private final void unsupportedSoftwareWarning() {
        boolean lllllllllllllIIIIllIllIIllllIIlI = false;
        for (final UnsupportedSoftware lllllllllllllIIIIllIllIIllllIlII : this.platform.getUnsupportedSoftwareClasses()) {
            if (!lllllllllllllIIIIllIllIIllllIlII.findMatch()) {
                continue;
            }
            if (!lllllllllllllIIIIllIllIIllllIIlI) {
                this.platform.getLogger().severe("************************************************");
                this.platform.getLogger().severe("You are using unsupported software and may encounter unforeseeable issues.");
                this.platform.getLogger().severe("");
                lllllllllllllIIIIllIllIIllllIIlI = true;
            }
            this.platform.getLogger().severe(String.valueOf(new StringBuilder().append("We strongly advise against using ").append(lllllllllllllIIIIllIllIIllllIlII.getName()).append(":")));
            this.platform.getLogger().severe(lllllllllllllIIIIllIllIIllllIlII.getReason());
            this.platform.getLogger().severe("");
        }
        if (lllllllllllllIIIIllIllIIllllIIlI) {
            this.platform.getLogger().severe("We will not provide support in case you encounter issues possibly related to this software.");
            this.platform.getLogger().severe("************************************************");
        }
    }
    
    public static final class ViaManagerBuilder
    {
        private /* synthetic */ ViaPlatformLoader loader;
        private /* synthetic */ ViaPlatform<?> platform;
        private /* synthetic */ ViaInjector injector;
        private /* synthetic */ ViaCommandHandler commandHandler;
        
        public ViaManagerBuilder commandHandler(final ViaCommandHandler lllllllllllllIIllIIIlIllllIIlIlI) {
            this.commandHandler = lllllllllllllIIllIIIlIllllIIlIlI;
            return this;
        }
        
        public ViaManagerBuilder platform(final ViaPlatform<?> lllllllllllllIIllIIIlIllllIlllII) {
            this.platform = lllllllllllllIIllIIIlIllllIlllII;
            return this;
        }
        
        public ViaManagerBuilder injector(final ViaInjector lllllllllllllIIllIIIlIllllIlIlII) {
            this.injector = lllllllllllllIIllIIIlIllllIlIlII;
            return this;
        }
        
        public ViaManagerBuilder loader(final ViaPlatformLoader lllllllllllllIIllIIIlIllllIIlllI) {
            this.loader = lllllllllllllIIllIIIlIllllIIlllI;
            return this;
        }
        
        public ViaManagerImpl build() {
            return new ViaManagerImpl(this.platform, this.injector, this.commandHandler, this.loader);
        }
    }
}
