package net.minecraft.client.resources;

import net.minecraft.client.resources.data.*;
import java.util.*;
import net.minecraft.util.*;
import java.io.*;
import org.apache.logging.log4j.*;
import com.google.common.base.*;
import javax.annotation.*;
import com.google.common.collect.*;

public class SimpleReloadableResourceManager implements IReloadableResourceManager
{
    private final /* synthetic */ Map<String, FallbackResourceManager> domainResourceManagers;
    private final /* synthetic */ MetadataSerializer rmMetadataSerializer;
    private final /* synthetic */ Set<String> setResourceDomains;
    private static final /* synthetic */ Logger LOGGER;
    private static final /* synthetic */ Joiner JOINER_RESOURCE_PACKS;
    private final /* synthetic */ List<IResourceManagerReloadListener> reloadListeners;
    
    @Override
    public IResource getResource(final ResourceLocation lllllllllllllIIIllIIlIlIlIlIlIlI) throws IOException {
        final IResourceManager lllllllllllllIIIllIIlIlIlIlIllII = this.domainResourceManagers.get(lllllllllllllIIIllIIlIlIlIlIlIlI.getResourceDomain());
        if (lllllllllllllIIIllIIlIlIlIlIllII != null) {
            return lllllllllllllIIIllIIlIlIlIlIllII.getResource(lllllllllllllIIIllIIlIlIlIlIlIlI);
        }
        throw new FileNotFoundException(lllllllllllllIIIllIIlIlIlIlIlIlI.toString());
    }
    
    private void clearResources() {
        this.domainResourceManagers.clear();
        this.setResourceDomains.clear();
    }
    
    private void notifyReloadListeners() {
        for (final IResourceManagerReloadListener lllllllllllllIIIllIIlIlIlIIIIlll : this.reloadListeners) {
            lllllllllllllIIIllIIlIlIlIIIIlll.onResourceManagerReload(this);
        }
    }
    
    public void reloadResourcePack(final IResourcePack lllllllllllllIIIllIIlIlIlIlllIII) {
        for (final String lllllllllllllIIIllIIlIlIlIlllIll : lllllllllllllIIIllIIlIlIlIlllIII.getResourceDomains()) {
            this.setResourceDomains.add(lllllllllllllIIIllIIlIlIlIlllIll);
            FallbackResourceManager lllllllllllllIIIllIIlIlIlIlllIlI = this.domainResourceManagers.get(lllllllllllllIIIllIIlIlIlIlllIll);
            if (lllllllllllllIIIllIIlIlIlIlllIlI == null) {
                lllllllllllllIIIllIIlIlIlIlllIlI = new FallbackResourceManager(this.rmMetadataSerializer);
                this.domainResourceManagers.put(lllllllllllllIIIllIIlIlIlIlllIll, lllllllllllllIIIllIIlIlIlIlllIlI);
            }
            lllllllllllllIIIllIIlIlIlIlllIlI.addResourcePack(lllllllllllllIIIllIIlIlIlIlllIII);
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        JOINER_RESOURCE_PACKS = Joiner.on(", ");
    }
    
    @Override
    public void registerReloadListener(final IResourceManagerReloadListener lllllllllllllIIIllIIlIlIlIIIlllI) {
        this.reloadListeners.add(lllllllllllllIIIllIIlIlIlIIIlllI);
        lllllllllllllIIIllIIlIlIlIIIlllI.onResourceManagerReload(this);
    }
    
    @Override
    public void reloadResources(final List<IResourcePack> lllllllllllllIIIllIIlIlIlIIlIlll) {
        this.clearResources();
        SimpleReloadableResourceManager.LOGGER.info("Reloading ResourceManager: {}", (Object)SimpleReloadableResourceManager.JOINER_RESOURCE_PACKS.join(Iterables.transform((Iterable)lllllllllllllIIIllIIlIlIlIIlIlll, (Function)new Function<IResourcePack, String>() {
            public String apply(@Nullable final IResourcePack lllllllllllllllIIlIIlIlllIllIIII) {
                return (lllllllllllllllIIlIIlIlllIllIIII == null) ? "<NULL>" : lllllllllllllllIIlIIlIlllIllIIII.getPackName();
            }
        })));
        for (final IResourcePack lllllllllllllIIIllIIlIlIlIIlIllI : lllllllllllllIIIllIIlIlIlIIlIlll) {
            this.reloadResourcePack(lllllllllllllIIIllIIlIlIlIIlIllI);
        }
        this.notifyReloadListeners();
    }
    
    @Override
    public Set<String> getResourceDomains() {
        return this.setResourceDomains;
    }
    
    public SimpleReloadableResourceManager(final MetadataSerializer lllllllllllllIIIllIIlIlIllIIIlIl) {
        this.domainResourceManagers = (Map<String, FallbackResourceManager>)Maps.newHashMap();
        this.reloadListeners = (List<IResourceManagerReloadListener>)Lists.newArrayList();
        this.setResourceDomains = (Set<String>)Sets.newLinkedHashSet();
        this.rmMetadataSerializer = lllllllllllllIIIllIIlIlIllIIIlIl;
    }
    
    @Override
    public List<IResource> getAllResources(final ResourceLocation lllllllllllllIIIllIIlIlIlIlIIlII) throws IOException {
        final IResourceManager lllllllllllllIIIllIIlIlIlIlIIIll = this.domainResourceManagers.get(lllllllllllllIIIllIIlIlIlIlIIlII.getResourceDomain());
        if (lllllllllllllIIIllIIlIlIlIlIIIll != null) {
            return lllllllllllllIIIllIIlIlIlIlIIIll.getAllResources(lllllllllllllIIIllIIlIlIlIlIIlII);
        }
        throw new FileNotFoundException(lllllllllllllIIIllIIlIlIlIlIIlII.toString());
    }
}
