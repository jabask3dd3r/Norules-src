package com.viaversion.viabackwards;

import com.viaversion.viabackwards.api.*;
import org.spongepowered.api.plugin.*;
import java.nio.file.*;
import com.google.inject.*;
import org.spongepowered.api.config.*;
import org.slf4j.*;
import java.io.*;
import org.spongepowered.api.event.game.state.*;
import com.viaversion.viaversion.sponge.util.*;
import com.viaversion.viaversion.api.*;
import org.spongepowered.api.event.*;

@Plugin(id = "viabackwards", name = "ViaBackwards", version = "4.0.2-SNAPSHOT", authors = { "Matsv", "kennytv", "Gerrygames", "creeper123123321", "ForceUpdate1" }, description = "Allow older Minecraft versions to connect to a newer server version.", dependencies = { @Dependency(id = "viaversion") })
public class SpongePlugin implements ViaBackwardsPlatform
{
    @Inject
    @ConfigDir(sharedRoot = false)
    private /* synthetic */ Path configPath;
    @Inject
    private /* synthetic */ Logger loggerSlf4j;
    private /* synthetic */ java.util.logging.Logger logger;
    
    @Override
    public void disable() {
    }
    
    @Override
    public File getDataFolder() {
        return this.configPath.toFile();
    }
    
    @Override
    public java.util.logging.Logger getLogger() {
        return this.logger;
    }
    
    @Listener(order = Order.LATE)
    public void onGameStart(final GameInitializationEvent lllllllllllllIlIllIlIllIIlIIIIlI) {
        this.logger = new LoggerWrapper(this.loggerSlf4j);
        Via.getManager().addEnableListener(() -> this.init(this.configPath.resolve("config.yml").toFile()));
    }
}
