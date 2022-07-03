package de.gerrygames.viarewind;

import com.velocitypowered.api.plugin.*;
import java.nio.file.*;
import com.google.inject.*;
import com.velocitypowered.api.plugin.annotation.*;
import org.slf4j.*;
import com.velocitypowered.api.event.proxy.*;
import com.viaversion.viaversion.sponge.util.*;
import de.gerrygames.viarewind.api.*;
import com.velocitypowered.api.event.*;

@Plugin(id = "viarewind", name = "ViaRewind", version = "2.0.2-SNAPSHOT", authors = { "Gerrygames" }, dependencies = { @Dependency(id = "viaversion"), @Dependency(id = "viabackwards", optional = true) }, url = "https://viaversion.com/rewind")
public class VelocityPlugin implements ViaRewindPlatform
{
    @Inject
    @DataDirectory
    private /* synthetic */ Path configDir;
    @Inject
    private /* synthetic */ Logger loggerSlf4j;
    private /* synthetic */ java.util.logging.Logger logger;
    
    @Override
    public java.util.logging.Logger getLogger() {
        return this.logger;
    }
    
    @Subscribe(order = PostOrder.LATE)
    public void onProxyStart(final ProxyInitializeEvent lllllllllllllIIlIIlIlllllIIIIIll) {
        this.logger = new LoggerWrapper(this.loggerSlf4j);
        final ViaRewindConfigImpl lllllllllllllIIlIIlIlllllIIIIIlI = new ViaRewindConfigImpl(this.configDir.resolve("config.yml").toFile());
        lllllllllllllIIlIIlIlllllIIIIIlI.reloadConfig();
        this.init(lllllllllllllIIlIIlIlllllIIIIIlI);
    }
}
