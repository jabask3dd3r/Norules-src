package ViaMCP.minecraft.viamcp1_12.loader;

import java.io.*;
import de.gerrygames.viarewind.api.*;
import java.util.logging.*;
import com.viaversion.viaversion.api.*;

public class VRRewindLoader implements ViaRewindPlatform
{
    public VRRewindLoader(final File lllllllllllllllllIIIlIIllllIlIII) {
        final ViaRewindConfigImpl lllllllllllllllllIIIlIIllllIIlll = new ViaRewindConfigImpl(lllllllllllllllllIIIlIIllllIlIII.toPath().resolve("ViaRewind").resolve("config.yml").toFile());
        lllllllllllllllllIIIlIIllllIIlll.reloadConfig();
        this.init(lllllllllllllllllIIIlIIllllIIlll);
    }
    
    @Override
    public Logger getLogger() {
        return Via.getPlatform().getLogger();
    }
}
