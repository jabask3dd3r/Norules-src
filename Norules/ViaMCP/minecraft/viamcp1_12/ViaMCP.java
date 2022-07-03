package ViaMCP.minecraft.viamcp1_12;

import io.netty.channel.*;
import java.util.logging.*;
import java.io.*;
import org.apache.logging.log4j.*;
import ViaMCP.minecraft.viamcp1_12.utils.*;
import com.google.common.util.concurrent.*;
import io.netty.channel.local.*;
import com.viaversion.viaversion.*;
import ViaMCP.minecraft.viamcp1_12.platform.*;
import com.viaversion.viaversion.api.platform.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.data.*;
import ViaMCP.minecraft.viamcp1_12.loader.*;
import java.util.concurrent.*;

public class ViaMCP
{
    private /* synthetic */ String lastServer;
    private final /* synthetic */ CompletableFuture<Void> INIT_FUTURE;
    private /* synthetic */ EventLoop EVENT_LOOP;
    private final /* synthetic */ Logger jLogger;
    private /* synthetic */ File file;
    private static final /* synthetic */ ViaMCP instance;
    private /* synthetic */ int version;
    private /* synthetic */ ExecutorService ASYNC_EXEC;
    
    public void setVersion(final int llllllllllllllIIllIIIIIIlIlIlIll) {
        this.version = llllllllllllllIIllIIIIIIlIlIlIll;
    }
    
    public int getVersion() {
        return this.version;
    }
    
    public File getFile() {
        return this.file;
    }
    
    public static ViaMCP getInstance() {
        return ViaMCP.instance;
    }
    
    public EventLoop getEventLoop() {
        return this.EVENT_LOOP;
    }
    
    public ViaMCP() {
        this.jLogger = new JLoggerToLog4j(LogManager.getLogger("ViaMCP"));
        this.INIT_FUTURE = new CompletableFuture<Void>();
    }
    
    static {
        PROTOCOL_VERSION = 340;
        instance = new ViaMCP();
    }
    
    public String getLastServer() {
        return this.lastServer;
    }
    
    public void setFile(final File llllllllllllllIIllIIIIIIlIlIIlIl) {
        this.file = llllllllllllllIIllIIIIIIlIlIIlIl;
    }
    
    public ExecutorService getAsyncExecutor() {
        return this.ASYNC_EXEC;
    }
    
    public CompletableFuture<Void> getInitFuture() {
        return this.INIT_FUTURE;
    }
    
    public Logger getjLogger() {
        return this.jLogger;
    }
    
    public void start() {
        final ThreadFactory llllllllllllllIIllIIIIIIllIIlIII = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("ViaMCP-%d").build();
        this.ASYNC_EXEC = Executors.newFixedThreadPool(8, llllllllllllllIIllIIIIIIllIIlIII);
        this.EVENT_LOOP = new LocalEventLoopGroup(1, llllllllllllllIIllIIIIIIllIIlIII).next();
        this.EVENT_LOOP.submit((Callable)this.INIT_FUTURE::join);
        this.setVersion(340);
        this.file = new File("ViaMCP");
        if (this.file.mkdir()) {
            this.getjLogger().info("Creating ViaMCP Folder");
        }
        Via.init(ViaManagerImpl.builder().injector(new VRInjector()).loader(new VRProviderLoader()).platform(new VRPlatform(this.file)).build());
        MappingDataLoader.enableMappingsCache();
        ((ViaManagerImpl)Via.getManager()).init();
        new VRBackwardsLoader(this.file);
        new VRRewindLoader(this.file);
        this.INIT_FUTURE.complete(null);
    }
    
    public void setLastServer(final String llllllllllllllIIllIIIIIIlIlIIIIl) {
        this.lastServer = llllllllllllllIIllIIIIIIlIlIIIIl;
    }
}
