package net.minecraft.client.resources;

import java.util.*;

public interface IReloadableResourceManager extends IResourceManager
{
    void registerReloadListener(final IResourceManagerReloadListener p0);
    
    void reloadResources(final List<IResourcePack> p0);
}
