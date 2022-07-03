package net.minecraft.client.resources;

import java.io.*;

public class ResourcePackFileNotFoundException extends FileNotFoundException
{
    public ResourcePackFileNotFoundException(final File llllllllllllllIlIlIlIlIlIllIlllI, final String llllllllllllllIlIlIlIlIlIllIlIlI) {
        super(String.format("'%s' in ResourcePack '%s'", llllllllllllllIlIlIlIlIlIllIlIlI, llllllllllllllIlIlIlIlIlIllIlllI));
    }
}
