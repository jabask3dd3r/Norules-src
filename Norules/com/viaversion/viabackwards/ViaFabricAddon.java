package com.viaversion.viabackwards;

import com.viaversion.viabackwards.api.*;
import java.io.*;
import java.util.logging.*;
import net.fabricmc.loader.api.*;
import java.nio.file.*;
import org.apache.logging.log4j.*;
import com.viaversion.viabackwards.fabric.util.*;

public class ViaFabricAddon implements ViaBackwardsPlatform, Runnable
{
    private /* synthetic */ File configDir;
    private final /* synthetic */ Logger logger;
    
    @Override
    public void run() {
        final Path lllllllllllllIllllIllIllIIIIIIII = FabricLoader.getInstance().getConfigDir().resolve("ViaBackwards");
        this.configDir = lllllllllllllIllllIllIllIIIIIIII.toFile();
        this.init(this.getDataFolder());
    }
    
    @Override
    public void disable() {
    }
    
    @Override
    public File getDataFolder() {
        return this.configDir;
    }
    
    @Override
    public Logger getLogger() {
        return this.logger;
    }
    
    public ViaFabricAddon() {
        this.logger = new LoggerWrapper(LogManager.getLogger("ViaBackwards"));
    }
}
