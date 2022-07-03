package ViaMCP.minecraft.viamcp1_12.platform;

import java.util.*;
import java.util.logging.*;
import java.io.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.libs.gson.*;
import ViaMCP.minecraft.viamcp1_12.*;
import com.viaversion.viaversion.api.command.*;
import io.netty.util.concurrent.*;
import org.apache.logging.log4j.*;
import ViaMCP.minecraft.viamcp1_12.utils.*;
import java.nio.file.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.serializer.gson.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.serializer.legacy.*;
import com.viaversion.viaversion.api.platform.*;
import java.util.concurrent.*;
import com.viaversion.viaversion.api.configuration.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.serializer.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;

public class VRPlatform implements ViaPlatform<UUID>
{
    private final /* synthetic */ Logger logger;
    private final /* synthetic */ File dataFolder;
    private final /* synthetic */ ViaAPI<UUID> api;
    private final /* synthetic */ VRViaConfig config;
    
    @Override
    public JsonObject getDump() {
        final JsonObject lllllllllllllllIIlIlIIIIIIlIlIII = new JsonObject();
        return lllllllllllllllIIlIlIIIIIIlIlIII;
    }
    
    @Override
    public boolean isPluginEnabled() {
        return true;
    }
    
    @Override
    public File getDataFolder() {
        return this.dataFolder;
    }
    
    @Override
    public String getPlatformName() {
        return "ViaForge";
    }
    
    @Override
    public FutureTaskId runAsync(final Runnable lllllllllllllllIIlIlIIIIIlIllIll) {
        return new FutureTaskId(CompletableFuture.runAsync(lllllllllllllllIIlIlIIIIIlIllIll, ViaMCP.getInstance().getAsyncExecutor()).exceptionally(lllllllllllllllIIlIlIIIIIIIllIll -> {
            if (!(lllllllllllllllIIlIlIIIIIIIllIll instanceof CancellationException)) {
                lllllllllllllllIIlIlIIIIIIIllIll.printStackTrace();
            }
            return null;
        }));
    }
    
    @Override
    public String getPlatformVersion() {
        return String.valueOf(340);
    }
    
    @Override
    public void sendMessage(final UUID lllllllllllllllIIlIlIIIIIIllllIl, final String lllllllllllllllIIlIlIIIIIIllllII) {
    }
    
    private ViaCommandSender[] getServerPlayers() {
        return new ViaCommandSender[1337];
    }
    
    private <T extends Future<?>> GenericFutureListener<T> errorLogger() {
        return (GenericFutureListener<T>)(lllllllllllllllIIlIlIIIIIIIIllll -> {
            if (!lllllllllllllllIIlIlIIIIIIIIllll.isCancelled() && lllllllllllllllIIlIlIIIIIIIIllll.cause() != null) {
                lllllllllllllllIIlIlIIIIIIIIllll.cause().printStackTrace();
            }
        });
    }
    
    @Override
    public String getPluginVersion() {
        return "4.0.0";
    }
    
    @Override
    public ViaAPI<UUID> getApi() {
        return this.api;
    }
    
    public VRPlatform(final File lllllllllllllllIIlIlIIIIIllIlIll) {
        this.logger = new JLoggerToLog4j(LogManager.getLogger("ViaVersion"));
        final Path lllllllllllllllIIlIlIIIIIllIlIlI = lllllllllllllllIIlIlIIIIIllIlIll.toPath().resolve("ViaVersion");
        this.config = new VRViaConfig(lllllllllllllllIIlIlIIIIIllIlIlI.resolve("viaversion.yml").toFile());
        this.dataFolder = lllllllllllllllIIlIlIIIIIllIlIlI.toFile();
        this.api = new VRViaAPI();
    }
    
    @Override
    public ViaCommandSender[] getOnlinePlayers() {
        return new ViaCommandSender[1337];
    }
    
    @Override
    public boolean isOldClientsAllowed() {
        return true;
    }
    
    @Override
    public ConfigurationProvider getConfigurationProvider() {
        return this.config;
    }
    
    public static String legacyToJson(final String lllllllllllllllIIlIlIIIIIllIIlIl) {
        return ((ComponentSerializer<TextComponent, O, String>)GsonComponentSerializer.gson()).serialize(LegacyComponentSerializer.legacySection().deserialize(lllllllllllllllIIlIlIIIIIllIIlIl));
    }
    
    @Override
    public PlatformTask runSync(final Runnable lllllllllllllllIIlIlIIIIIlIIllII, final long lllllllllllllllIIlIlIIIIIlIIlIll) {
        return new FutureTaskId((java.util.concurrent.Future<?>)ViaMCP.getInstance().getEventLoop().schedule(() -> this.runSync(lllllllllllllllIIlIlIIIIIlIIllII), lllllllllllllllIIlIlIIIIIlIIlIll * 50L, TimeUnit.MILLISECONDS).addListener((GenericFutureListener)this.errorLogger()));
    }
    
    @Override
    public void onReload() {
    }
    
    @Override
    public FutureTaskId runSync(final Runnable lllllllllllllllIIlIlIIIIIlIlIllI) {
        return new FutureTaskId((java.util.concurrent.Future<?>)ViaMCP.getInstance().getEventLoop().submit(lllllllllllllllIIlIlIIIIIlIlIllI).addListener((GenericFutureListener)this.errorLogger()));
    }
    
    @Override
    public Logger getLogger() {
        return this.logger;
    }
    
    @Override
    public boolean kickPlayer(final UUID lllllllllllllllIIlIlIIIIIIlllIlI, final String lllllllllllllllIIlIlIIIIIIlllIIl) {
        return false;
    }
    
    @Override
    public ViaVersionConfig getConf() {
        return this.config;
    }
    
    @Override
    public PlatformTask runRepeatingSync(final Runnable lllllllllllllllIIlIlIIIIIlIIIllI, final long lllllllllllllllIIlIlIIIIIlIIIlIl) {
        return new FutureTaskId((java.util.concurrent.Future<?>)ViaMCP.getInstance().getEventLoop().scheduleAtFixedRate(() -> this.runSync(lllllllllllllllIIlIlIIIIIlIIIllI), 0L, lllllllllllllllIIlIlIIIIIlIIIlIl * 50L, TimeUnit.MILLISECONDS).addListener((GenericFutureListener)this.errorLogger()));
    }
}
