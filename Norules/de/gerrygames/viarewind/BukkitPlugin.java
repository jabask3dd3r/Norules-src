package de.gerrygames.viarewind;

import org.bukkit.plugin.java.*;
import java.io.*;
import de.gerrygames.viarewind.api.*;

public class BukkitPlugin extends JavaPlugin implements ViaRewindPlatform
{
    public void onEnable() {
        final ViaRewindConfigImpl llllllllllllllIlIIIIIlIllIIlllll = new ViaRewindConfigImpl(new File(this.getDataFolder(), "config.yml"));
        llllllllllllllIlIIIIIlIllIIlllll.reloadConfig();
        this.init(llllllllllllllIlIIIIIlIllIIlllll);
    }
}
