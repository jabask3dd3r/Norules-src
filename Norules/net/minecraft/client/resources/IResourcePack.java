package net.minecraft.client.resources;

import net.minecraft.util.*;
import java.io.*;
import java.awt.image.*;
import java.util.*;
import net.minecraft.client.resources.data.*;
import javax.annotation.*;

public interface IResourcePack
{
    String getPackName();
    
    InputStream getInputStream(final ResourceLocation p0) throws IOException;
    
    BufferedImage getPackImage() throws IOException;
    
    Set<String> getResourceDomains();
    
    @Nullable
     <T extends IMetadataSection> T getPackMetadata(final MetadataSerializer p0, final String p1) throws IOException;
    
    boolean resourceExists(final ResourceLocation p0);
}
