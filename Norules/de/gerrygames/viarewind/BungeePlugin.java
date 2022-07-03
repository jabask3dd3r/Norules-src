package de.gerrygames.viarewind;

import net.md_5.bungee.api.plugin.*;
import java.io.*;
import de.gerrygames.viarewind.api.*;

public class BungeePlugin extends Plugin implements ViaRewindPlatform
{
    public void onEnable() {
        final ViaRewindConfigImpl lllllllllllllIIIIlIlllllIlIlIIll = new ViaRewindConfigImpl(new File(this.getDataFolder(), "config.yml"));
        lllllllllllllIIIIlIlllllIlIlIIll.reloadConfig();
        this.init(lllllllllllllIIIIlIlllllIlIlIIll);
    }
}
