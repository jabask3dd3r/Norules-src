package net.minecraft.client.resources;

import net.minecraft.client.resources.data.*;
import javax.annotation.*;
import java.io.*;
import net.minecraft.util.*;

public interface IResource extends Closeable
{
    @Nullable
     <T extends IMetadataSection> T getMetadata(final String p0);
    
    boolean hasMetadata();
    
    InputStream getInputStream();
    
    ResourceLocation getResourceLocation();
    
    String getResourcePackName();
}
