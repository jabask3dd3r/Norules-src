package de.gerrygames.viarewind;

import java.util.logging.*;
import net.fabricmc.loader.api.*;
import de.gerrygames.viarewind.api.*;
import org.apache.logging.log4j.*;
import de.gerrygames.viarewind.fabric.util.*;

public class ViaFabricAddon implements Runnable, ViaRewindPlatform
{
    private final /* synthetic */ Logger logger;
    
    @Override
    public void run() {
        final ViaRewindConfigImpl llllllllllllllIllIllllllIIlIIIII = new ViaRewindConfigImpl(FabricLoader.getInstance().getConfigDirectory().toPath().resolve("ViaRewind").resolve("config.yml").toFile());
        llllllllllllllIllIllllllIIlIIIII.reloadConfig();
        this.init(llllllllllllllIllIllllllIIlIIIII);
    }
    
    public ViaFabricAddon() {
        this.logger = new LoggerWrapper(LogManager.getLogger("ViaRewind"));
    }
    
    @Override
    public Logger getLogger() {
        return this.logger;
    }
}
