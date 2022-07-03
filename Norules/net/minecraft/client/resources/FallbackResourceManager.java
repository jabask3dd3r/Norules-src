package net.minecraft.client.resources;

import net.minecraft.client.resources.data.*;
import com.google.common.collect.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.*;
import java.util.*;
import java.io.*;

public class FallbackResourceManager implements IResourceManager
{
    private final /* synthetic */ MetadataSerializer frmMetadataSerializer;
    private static final /* synthetic */ Logger LOGGER;
    protected final /* synthetic */ List<IResourcePack> resourcePacks;
    
    public FallbackResourceManager(final MetadataSerializer llllllllllllllIllllIlIlIlllIlIlI) {
        this.resourcePacks = (List<IResourcePack>)Lists.newArrayList();
        this.frmMetadataSerializer = llllllllllllllIllllIlIlIlllIlIlI;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public IResource getResource(final ResourceLocation llllllllllllllIllllIlIlIllIlIIll) throws IOException {
        this.checkResourcePath(llllllllllllllIllllIlIlIllIlIIll);
        IResourcePack llllllllllllllIllllIlIlIllIllIIl = null;
        final ResourceLocation llllllllllllllIllllIlIlIllIllIII = getLocationMcmeta(llllllllllllllIllllIlIlIllIlIIll);
        for (int llllllllllllllIllllIlIlIllIlIlll = this.resourcePacks.size() - 1; llllllllllllllIllllIlIlIllIlIlll >= 0; --llllllllllllllIllllIlIlIllIlIlll) {
            final IResourcePack llllllllllllllIllllIlIlIllIlIllI = this.resourcePacks.get(llllllllllllllIllllIlIlIllIlIlll);
            if (llllllllllllllIllllIlIlIllIllIIl == null && llllllllllllllIllllIlIlIllIlIllI.resourceExists(llllllllllllllIllllIlIlIllIllIII)) {
                llllllllllllllIllllIlIlIllIllIIl = llllllllllllllIllllIlIlIllIlIllI;
            }
            if (llllllllllllllIllllIlIlIllIlIllI.resourceExists(llllllllllllllIllllIlIlIllIlIIll)) {
                InputStream llllllllllllllIllllIlIlIllIlIlIl = null;
                if (llllllllllllllIllllIlIlIllIllIIl != null) {
                    llllllllllllllIllllIlIlIllIlIlIl = this.getInputStream(llllllllllllllIllllIlIlIllIllIII, llllllllllllllIllllIlIlIllIllIIl);
                }
                return new SimpleResource(llllllllllllllIllllIlIlIllIlIllI.getPackName(), llllllllllllllIllllIlIlIllIlIIll, this.getInputStream(llllllllllllllIllllIlIlIllIlIIll, llllllllllllllIllllIlIlIllIlIllI), llllllllllllllIllllIlIlIllIlIlIl, this.frmMetadataSerializer);
            }
        }
        throw new FileNotFoundException(llllllllllllllIllllIlIlIllIlIIll.toString());
    }
    
    private void checkResourcePath(final ResourceLocation llllllllllllllIllllIlIlIllIIIIII) throws IOException {
        if (llllllllllllllIllllIlIlIllIIIIII.getResourcePath().contains("..")) {
            throw new IOException(String.valueOf(new StringBuilder("Invalid relative path to resource: ").append(llllllllllllllIllllIlIlIllIIIIII)));
        }
    }
    
    @Override
    public Set<String> getResourceDomains() {
        return Collections.emptySet();
    }
    
    protected InputStream getInputStream(final ResourceLocation llllllllllllllIllllIlIlIllIIIllI, final IResourcePack llllllllllllllIllllIlIlIllIIIlIl) throws IOException {
        final InputStream llllllllllllllIllllIlIlIllIIIlll = llllllllllllllIllllIlIlIllIIIlIl.getInputStream(llllllllllllllIllllIlIlIllIIIllI);
        return FallbackResourceManager.LOGGER.isDebugEnabled() ? new InputStreamLeakedResourceLogger(llllllllllllllIllllIlIlIllIIIlll, llllllllllllllIllllIlIlIllIIIllI, llllllllllllllIllllIlIlIllIIIlIl.getPackName()) : llllllllllllllIllllIlIlIllIIIlll;
    }
    
    public void addResourcePack(final IResourcePack llllllllllllllIllllIlIlIlllIIlII) {
        this.resourcePacks.add(llllllllllllllIllllIlIlIlllIIlII);
    }
    
    static ResourceLocation getLocationMcmeta(final ResourceLocation llllllllllllllIllllIlIlIlIlIlIIl) {
        return new ResourceLocation(llllllllllllllIllllIlIlIlIlIlIIl.getResourceDomain(), String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIllllIlIlIlIlIlIIl.getResourcePath())).append(".mcmeta")));
    }
    
    @Override
    public List<IResource> getAllResources(final ResourceLocation llllllllllllllIllllIlIlIlIllIlll) throws IOException {
        this.checkResourcePath(llllllllllllllIllllIlIlIlIllIlll);
        final List<IResource> llllllllllllllIllllIlIlIlIllIllI = (List<IResource>)Lists.newArrayList();
        final ResourceLocation llllllllllllllIllllIlIlIlIllIlIl = getLocationMcmeta(llllllllllllllIllllIlIlIlIllIlll);
        for (final IResourcePack llllllllllllllIllllIlIlIlIllIlII : this.resourcePacks) {
            if (llllllllllllllIllllIlIlIlIllIlII.resourceExists(llllllllllllllIllllIlIlIlIllIlll)) {
                final InputStream llllllllllllllIllllIlIlIlIllIIll = llllllllllllllIllllIlIlIlIllIlII.resourceExists(llllllllllllllIllllIlIlIlIllIlIl) ? this.getInputStream(llllllllllllllIllllIlIlIlIllIlIl, llllllllllllllIllllIlIlIlIllIlII) : null;
                llllllllllllllIllllIlIlIlIllIllI.add(new SimpleResource(llllllllllllllIllllIlIlIlIllIlII.getPackName(), llllllllllllllIllllIlIlIlIllIlll, this.getInputStream(llllllllllllllIllllIlIlIlIllIlll, llllllllllllllIllllIlIlIlIllIlII), llllllllllllllIllllIlIlIlIllIIll, this.frmMetadataSerializer));
            }
        }
        if (llllllllllllllIllllIlIlIlIllIllI.isEmpty()) {
            throw new FileNotFoundException(llllllllllllllIllllIlIlIlIllIlll.toString());
        }
        return llllllllllllllIllllIlIlIlIllIllI;
    }
    
    static class InputStreamLeakedResourceLogger extends InputStream
    {
        private final /* synthetic */ String message;
        private final /* synthetic */ InputStream inputStream;
        private /* synthetic */ boolean isClosed;
        
        public InputStreamLeakedResourceLogger(final InputStream llllllllllllllllIIlllIlIlIIlIIIl, final ResourceLocation llllllllllllllllIIlllIlIlIIlIlIl, final String llllllllllllllllIIlllIlIlIIIllll) {
            this.inputStream = llllllllllllllllIIlllIlIlIIlIIIl;
            final ByteArrayOutputStream llllllllllllllllIIlllIlIlIIlIIll = new ByteArrayOutputStream();
            new Exception().printStackTrace(new PrintStream(llllllllllllllllIIlllIlIlIIlIIll));
            this.message = String.valueOf(new StringBuilder("Leaked resource: '").append(llllllllllllllllIIlllIlIlIIlIlIl).append("' loaded from pack: '").append(llllllllllllllllIIlllIlIlIIIllll).append("'\n").append(llllllllllllllllIIlllIlIlIIlIIll));
        }
        
        @Override
        public int read() throws IOException {
            return this.inputStream.read();
        }
        
        @Override
        public void close() throws IOException {
            this.inputStream.close();
            this.isClosed = true;
        }
        
        @Override
        protected void finalize() throws Throwable {
            if (!this.isClosed) {
                FallbackResourceManager.LOGGER.warn(this.message);
            }
            super.finalize();
        }
    }
}
