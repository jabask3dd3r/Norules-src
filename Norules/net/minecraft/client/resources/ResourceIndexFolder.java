package net.minecraft.client.resources;

import java.io.*;
import net.minecraft.util.*;

public class ResourceIndexFolder extends ResourceIndex
{
    private final /* synthetic */ File baseDir;
    
    public ResourceIndexFolder(final File lllllllllllllllIlIlIlIlIIllIIlIl) {
        this.baseDir = lllllllllllllllIlIlIlIlIIllIIlIl;
    }
    
    @Override
    public File getPackMcmeta() {
        return new File(this.baseDir, "pack.mcmeta");
    }
    
    @Override
    public File getFile(final ResourceLocation lllllllllllllllIlIlIlIlIIllIIIIl) {
        return new File(this.baseDir, lllllllllllllllIlIlIlIlIIllIIIIl.toString().replace(':', '/'));
    }
}
