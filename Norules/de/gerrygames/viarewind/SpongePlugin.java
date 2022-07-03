package de.gerrygames.viarewind;

import org.spongepowered.api.plugin.*;
import java.nio.file.*;
import com.google.inject.*;
import org.spongepowered.api.config.*;
import java.util.logging.*;
import org.spongepowered.api.event.game.state.*;
import com.viaversion.viaversion.sponge.util.*;
import de.gerrygames.viarewind.api.*;
import org.spongepowered.api.event.*;

@Plugin(id = "viarewind", name = "ViaRewind", version = "2.0.2-SNAPSHOT", authors = { "Gerrygames" }, dependencies = { @Dependency(id = "viaversion"), @Dependency(id = "viabackwards", optional = true) }, url = "https://viaversion.com/rewind")
public class SpongePlugin implements ViaRewindPlatform
{
    @Inject
    @ConfigDir(sharedRoot = false)
    private /* synthetic */ Path configDir;
    private /* synthetic */ Logger logger;
    @Inject
    private /* synthetic */ org.slf4j.Logger loggerSlf4j;
    
    @Listener(order = Order.LATE)
    public void onGameStart(final GameInitializationEvent llllllllllllllIIIIIIlllIlllIIIlI) {
        this.logger = new LoggerWrapper(this.loggerSlf4j);
        final ViaRewindConfigImpl llllllllllllllIIIIIIlllIlllIIIII = new ViaRewindConfigImpl(this.configDir.resolve("config.yml").toFile());
        llllllllllllllIIIIIIlllIlllIIIII.reloadConfig();
        this.init(llllllllllllllIIIIIIlllIlllIIIII);
    }
    
    @Override
    public Logger getLogger() {
        return this.logger;
    }
}
