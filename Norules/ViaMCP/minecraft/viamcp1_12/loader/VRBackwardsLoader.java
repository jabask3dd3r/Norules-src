package ViaMCP.minecraft.viamcp1_12.loader;

import com.viaversion.viabackwards.api.*;
import java.io.*;
import java.util.logging.*;
import ViaMCP.minecraft.viamcp1_12.*;

public class VRBackwardsLoader implements ViaBackwardsPlatform
{
    private final /* synthetic */ File file;
    
    public VRBackwardsLoader(final File llllllllllllllIlIIIllIllIlIllIII) {
        final File file = new File(llllllllllllllIlIIIllIllIlIllIII, "ViaBackwards");
        this.file = file;
        this.init(file);
    }
    
    @Override
    public boolean isOutdated() {
        return false;
    }
    
    @Override
    public void disable() {
    }
    
    @Override
    public File getDataFolder() {
        return new File(this.file, "config.yml");
    }
    
    @Override
    public Logger getLogger() {
        return ViaMCP.getInstance().getjLogger();
    }
}
