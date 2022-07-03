package net.minecraft.client.resources;

import java.util.regex.*;
import java.util.concurrent.locks.*;
import net.minecraft.client.*;
import org.apache.commons.codec.digest.*;
import net.minecraft.client.gui.*;
import java.util.concurrent.*;
import net.minecraft.util.*;
import com.google.common.util.concurrent.*;
import javax.annotation.*;
import net.minecraft.client.resources.data.*;
import net.minecraft.client.settings.*;
import com.google.common.collect.*;
import org.apache.logging.log4j.*;
import org.apache.commons.io.filefilter.*;
import org.apache.commons.io.comparator.*;
import java.util.*;
import net.minecraft.util.text.*;
import net.minecraft.client.renderer.texture.*;
import java.awt.image.*;
import java.io.*;
import org.apache.commons.io.*;

public class ResourcePackRepository
{
    public final /* synthetic */ MetadataSerializer rprMetadataSerializer;
    private final /* synthetic */ File dirResourcepacks;
    private final /* synthetic */ File dirServerResourcepacks;
    private static final /* synthetic */ ResourceLocation field_191400_f;
    public final /* synthetic */ List<Entry> repositoryEntries;
    private /* synthetic */ List<Entry> repositoryEntriesAll;
    private static final /* synthetic */ Logger LOGGER;
    private static final /* synthetic */ Pattern SHA1;
    private /* synthetic */ ListenableFuture<Object> downloadingPacks;
    private /* synthetic */ IResourcePack resourcePackInstance;
    private static final /* synthetic */ FileFilter RESOURCE_PACK_FILTER;
    private final /* synthetic */ ReentrantLock lock;
    public final /* synthetic */ IResourcePack rprDefaultResourcePack;
    
    public void updateRepositoryEntriesAll() {
        final List<Entry> lllllllllllllllIIlIlIlIIlllllllI = (List<Entry>)Lists.newArrayList();
        for (final File lllllllllllllllIIlIlIlIIllllllII : this.getResourcePackFiles()) {
            final Entry lllllllllllllllIIlIlIlIIlllllIlI = new Entry(lllllllllllllllIIlIlIlIIllllllII, (Entry)null);
            if (this.repositoryEntriesAll.contains(lllllllllllllllIIlIlIlIIlllllIlI)) {
                final int lllllllllllllllIIlIlIlIIlllllIII = this.repositoryEntriesAll.indexOf(lllllllllllllllIIlIlIlIIlllllIlI);
                if (lllllllllllllllIIlIlIlIIlllllIII <= -1 || lllllllllllllllIIlIlIlIIlllllIII >= this.repositoryEntriesAll.size()) {
                    continue;
                }
                lllllllllllllllIIlIlIlIIlllllllI.add(this.repositoryEntriesAll.get(lllllllllllllllIIlIlIlIIlllllIII));
            }
            else {
                try {
                    lllllllllllllllIIlIlIlIIlllllIlI.updateResourcePack();
                    lllllllllllllllIIlIlIlIIlllllllI.add(lllllllllllllllIIlIlIlIIlllllIlI);
                }
                catch (Exception lllllllllllllllIIlIlIlIIllllIllI) {
                    lllllllllllllllIIlIlIlIIlllllllI.remove(lllllllllllllllIIlIlIlIIlllllIlI);
                }
            }
        }
        this.repositoryEntriesAll.removeAll(lllllllllllllllIIlIlIlIIlllllllI);
        for (final Entry lllllllllllllllIIlIlIlIIllllIlII : this.repositoryEntriesAll) {
            lllllllllllllllIIlIlIlIIllllIlII.closeResourcePack();
        }
        this.repositoryEntriesAll = lllllllllllllllIIlIlIlIIlllllllI;
    }
    
    public static Map<String, String> getDownloadHeaders() {
        final Map<String, String> lllllllllllllllIIlIlIlIlIIlIlIll = (Map<String, String>)Maps.newHashMap();
        lllllllllllllllIIlIlIlIlIIlIlIll.put("X-Minecraft-Username", Minecraft.getMinecraft().getSession().getUsername());
        lllllllllllllllIIlIlIlIlIIlIlIll.put("X-Minecraft-UUID", Minecraft.getMinecraft().getSession().getPlayerID());
        lllllllllllllllIIlIlIlIlIIlIlIll.put("X-Minecraft-Version", "1.12.2");
        return lllllllllllllllIIlIlIlIlIIlIlIll;
    }
    
    public ListenableFuture<Object> downloadResourcePack(final String lllllllllllllllIIlIlIlIIIlllllII, final String lllllllllllllllIIlIlIlIIlIIlIIlI) {
        final String lllllllllllllllIIlIlIlIIlIIlIIII = DigestUtils.sha1Hex(lllllllllllllllIIlIlIlIIIlllllII);
        final String lllllllllllllllIIlIlIlIIlIIIllll = ResourcePackRepository.SHA1.matcher(lllllllllllllllIIlIlIlIIlIIlIIlI).matches() ? lllllllllllllllIIlIlIlIIlIIlIIlI : "";
        final File lllllllllllllllIIlIlIlIIlIIIlllI = new File(this.dirServerResourcepacks, lllllllllllllllIIlIlIlIIlIIlIIII);
        this.lock.lock();
        try {
            this.clearResourcePack();
            if (lllllllllllllllIIlIlIlIIlIIIlllI.exists()) {
                if (this.checkHash(lllllllllllllllIIlIlIlIIlIIIllll, lllllllllllllllIIlIlIlIIlIIIlllI)) {
                    final ListenableFuture lllllllllllllllIIlIlIlIIlIIIllIl = this.setResourcePackInstance(lllllllllllllllIIlIlIlIIlIIIlllI);
                    final float lllllllllllllllIIlIlIlIIIllIlIIl;
                    final ListenableFuture lllllllllllllllIIlIlIlIIlIIIllII = (ListenableFuture)(lllllllllllllllIIlIlIlIIIllIlIIl = (float)lllllllllllllllIIlIlIlIIlIIIllIl);
                    return (ListenableFuture<Object>)lllllllllllllllIIlIlIlIIIllIlIIl;
                }
                ResourcePackRepository.LOGGER.warn("Deleting file {}", (Object)lllllllllllllllIIlIlIlIIlIIIlllI);
                FileUtils.deleteQuietly(lllllllllllllllIIlIlIlIIlIIIlllI);
            }
            this.deleteOldServerResourcesPacks();
            final GuiScreenWorking lllllllllllllllIIlIlIlIIlIIIlIll = new GuiScreenWorking();
            final Map<String, String> lllllllllllllllIIlIlIlIIlIIIlIII = getDownloadHeaders();
            final Minecraft lllllllllllllllIIlIlIlIIlIIIIllI = Minecraft.getMinecraft();
            Futures.getUnchecked((Future)lllllllllllllllIIlIlIlIIlIIIIllI.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    lllllllllllllllIIlIlIlIIlIIIIllI.displayGuiScreen(lllllllllllllllIIlIlIlIIlIIIlIll);
                }
            }));
            final SettableFuture<Object> lllllllllllllllIIlIlIlIIlIIIIlII = (SettableFuture<Object>)SettableFuture.create();
            this.downloadingPacks = HttpUtil.downloadResourcePack(lllllllllllllllIIlIlIlIIlIIIlllI, lllllllllllllllIIlIlIlIIIlllllII, lllllllllllllllIIlIlIlIIlIIIlIII, 52428800, lllllllllllllllIIlIlIlIIlIIIlIll, lllllllllllllllIIlIlIlIIlIIIIllI.getProxy());
            Futures.addCallback((ListenableFuture)this.downloadingPacks, (FutureCallback)new FutureCallback<Object>() {
                public void onSuccess(@Nullable final Object lllllllllllllIlllIIlIlllIlllllII) {
                    if (ResourcePackRepository.this.checkHash(lllllllllllllllIIlIlIlIIlIIIllll, lllllllllllllllIIlIlIlIIlIIIlllI)) {
                        ResourcePackRepository.this.setResourcePackInstance(lllllllllllllllIIlIlIlIIlIIIlllI);
                        lllllllllllllllIIlIlIlIIlIIIIlII.set((Object)null);
                    }
                    else {
                        ResourcePackRepository.LOGGER.warn("Deleting file {}", (Object)lllllllllllllllIIlIlIlIIlIIIlllI);
                        FileUtils.deleteQuietly(lllllllllllllllIIlIlIlIIlIIIlllI);
                    }
                }
                
                public void onFailure(final Throwable lllllllllllllIlllIIlIlllIlllIlIl) {
                    FileUtils.deleteQuietly(lllllllllllllllIIlIlIlIIlIIIlllI);
                    lllllllllllllllIIlIlIlIIlIIIIlII.setException(lllllllllllllIlllIIlIlllIlllIlIl);
                }
            });
            final ListenableFuture lllllllllllllllIIlIlIlIIlIIIIIlI = this.downloadingPacks;
            float lllllllllllllllIIlIlIlIIIllIlIIl;
            final ListenableFuture lllllllllllllllIIlIlIlIIlIIIIIII = (ListenableFuture)(lllllllllllllllIIlIlIlIIIllIlIIl = (float)lllllllllllllllIIlIlIlIIlIIIIIlI);
            return (ListenableFuture<Object>)lllllllllllllllIIlIlIlIIIllIlIIl;
        }
        finally {
            this.lock.unlock();
        }
    }
    
    public void clearResourcePack() {
        this.lock.lock();
        try {
            if (this.downloadingPacks != null) {
                this.downloadingPacks.cancel(true);
            }
            this.downloadingPacks = null;
            if (this.resourcePackInstance != null) {
                this.resourcePackInstance = null;
                Minecraft.getMinecraft().scheduleResourcesRefresh();
            }
        }
        finally {
            this.lock.unlock();
        }
        this.lock.unlock();
    }
    
    private IResourcePack func_191399_b(final File lllllllllllllllIIlIlIlIlIIIllIIl) {
        IResourcePack lllllllllllllllIIlIlIlIlIIIlllII = null;
        if (lllllllllllllllIIlIlIlIlIIIllIIl.isDirectory()) {
            final IResourcePack lllllllllllllllIIlIlIlIlIIIlllIl = new FolderResourcePack(lllllllllllllllIIlIlIlIlIIIllIIl);
        }
        else {
            lllllllllllllllIIlIlIlIlIIIlllII = new FileResourcePack(lllllllllllllllIIlIlIlIlIIIllIIl);
        }
        try {
            final PackMetadataSection lllllllllllllllIIlIlIlIlIIIllIll = lllllllllllllllIIlIlIlIlIIIlllII.getPackMetadata(this.rprMetadataSerializer, "pack");
            if (lllllllllllllllIIlIlIlIlIIIllIll != null && lllllllllllllllIIlIlIlIlIIIllIll.getPackFormat() == 2) {
                return new LegacyV2Adapter(lllllllllllllllIIlIlIlIlIIIlllII);
            }
        }
        catch (Exception ex) {}
        return lllllllllllllllIIlIlIlIlIIIlllII;
    }
    
    private List<File> getResourcePackFiles() {
        return this.dirResourcepacks.isDirectory() ? Arrays.asList(this.dirResourcepacks.listFiles(ResourcePackRepository.RESOURCE_PACK_FILTER)) : Collections.emptyList();
    }
    
    private boolean checkHash(final String lllllllllllllllIIlIlIlIIIlIlIlII, final File lllllllllllllllIIlIlIlIIIlIlIIll) {
        try {
            final String lllllllllllllllIIlIlIlIIIlIlIllI = DigestUtils.sha1Hex((InputStream)new FileInputStream(lllllllllllllllIIlIlIlIIIlIlIIll));
            if (lllllllllllllllIIlIlIlIIIlIlIlII.isEmpty()) {
                ResourcePackRepository.LOGGER.info("Found file {} without verification hash", (Object)lllllllllllllllIIlIlIlIIIlIlIIll);
                return true;
            }
            if (lllllllllllllllIIlIlIlIIIlIlIllI.toLowerCase(Locale.ROOT).equals(lllllllllllllllIIlIlIlIIIlIlIlII.toLowerCase(Locale.ROOT))) {
                ResourcePackRepository.LOGGER.info("Found file {} matching requested hash {}", (Object)lllllllllllllllIIlIlIlIIIlIlIIll, (Object)lllllllllllllllIIlIlIlIIIlIlIlII);
                return true;
            }
            ResourcePackRepository.LOGGER.warn("File {} had wrong hash (expected {}, found {}).", (Object)lllllllllllllllIIlIlIlIIIlIlIIll, (Object)lllllllllllllllIIlIlIlIIIlIlIlII, (Object)lllllllllllllllIIlIlIlIIIlIlIllI);
        }
        catch (IOException lllllllllllllllIIlIlIlIIIlIlIlIl) {
            ResourcePackRepository.LOGGER.warn("File {} couldn't be hashed.", (Object)lllllllllllllllIIlIlIlIIIlIlIIll, (Object)lllllllllllllllIIlIlIlIIIlIlIlIl);
        }
        return false;
    }
    
    public File getDirResourcepacks() {
        return this.dirResourcepacks;
    }
    
    public void setRepositories(final List<Entry> lllllllllllllllIIlIlIlIIllIIIlII) {
        this.repositoryEntries.clear();
        this.repositoryEntries.addAll(lllllllllllllllIIlIlIlIIllIIIlII);
    }
    
    public ResourcePackRepository(final File lllllllllllllllIIlIlIlIlIIllIlIl, final File lllllllllllllllIIlIlIlIlIIllIlII, final IResourcePack lllllllllllllllIIlIlIlIlIIllIIll, final MetadataSerializer lllllllllllllllIIlIlIlIlIIllIIlI, final GameSettings lllllllllllllllIIlIlIlIlIIllIIIl) {
        this.lock = new ReentrantLock();
        this.repositoryEntriesAll = (List<Entry>)Lists.newArrayList();
        this.repositoryEntries = (List<Entry>)Lists.newArrayList();
        this.dirResourcepacks = lllllllllllllllIIlIlIlIlIIllIlIl;
        this.dirServerResourcepacks = lllllllllllllllIIlIlIlIlIIllIlII;
        this.rprDefaultResourcePack = lllllllllllllllIIlIlIlIlIIllIIll;
        this.rprMetadataSerializer = lllllllllllllllIIlIlIlIlIIllIIlI;
        this.fixDirResourcepacks();
        this.updateRepositoryEntriesAll();
        final Iterator<String> lllllllllllllllIIlIlIlIlIIlllIIl = lllllllllllllllIIlIlIlIlIIllIIIl.resourcePacks.iterator();
        while (lllllllllllllllIIlIlIlIlIIlllIIl.hasNext()) {
            final String lllllllllllllllIIlIlIlIlIIlllIII = lllllllllllllllIIlIlIlIlIIlllIIl.next();
            for (final Entry lllllllllllllllIIlIlIlIlIIllIlll : this.repositoryEntriesAll) {
                if (lllllllllllllllIIlIlIlIlIIllIlll.getResourcePackName().equals(lllllllllllllllIIlIlIlIlIIlllIII)) {
                    if (lllllllllllllllIIlIlIlIlIIllIlll.getPackFormat() == 3 || lllllllllllllllIIlIlIlIlIIllIIIl.incompatibleResourcePacks.contains(lllllllllllllllIIlIlIlIlIIllIlll.getResourcePackName())) {
                        this.repositoryEntries.add(lllllllllllllllIIlIlIlIlIIllIlll);
                        break;
                    }
                    lllllllllllllllIIlIlIlIlIIlllIIl.remove();
                    ResourcePackRepository.LOGGER.warn("Removed selected resource pack {} because it's no longer compatible", (Object)lllllllllllllllIIlIlIlIlIIllIlll.getResourcePackName());
                }
            }
        }
    }
    
    @Nullable
    public IResourcePack getResourcePackInstance() {
        return this.resourcePackInstance;
    }
    
    public List<Entry> getRepositoryEntries() {
        return (List<Entry>)ImmutableList.copyOf((Collection)this.repositoryEntries);
    }
    
    static {
        LOGGER = LogManager.getLogger();
        RESOURCE_PACK_FILTER = new FileFilter() {
            @Override
            public boolean accept(final File lllllllllllllIIlIlllIIIllllIIlIl) {
                final boolean lllllllllllllIIlIlllIIIllllIIlll = lllllllllllllIIlIlllIIIllllIIlIl.isFile() && lllllllllllllIIlIlllIIIllllIIlIl.getName().endsWith(".zip");
                final boolean lllllllllllllIIlIlllIIIllllIIllI = lllllllllllllIIlIlllIIIllllIIlIl.isDirectory() && new File(lllllllllllllIIlIlllIIIllllIIlIl, "pack.mcmeta").isFile();
                return lllllllllllllIIlIlllIIIllllIIlll || lllllllllllllIIlIlllIIIllllIIllI;
            }
        };
        SHA1 = Pattern.compile("^[a-fA-F0-9]{40}$");
        field_191400_f = new ResourceLocation("textures/misc/unknown_pack.png");
    }
    
    private void deleteOldServerResourcesPacks() {
        try {
            final List<File> lllllllllllllllIIlIlIlIIIIlIlIlI = (List<File>)Lists.newArrayList((Iterable)FileUtils.listFiles(this.dirServerResourcepacks, TrueFileFilter.TRUE, (IOFileFilter)null));
            Collections.sort(lllllllllllllllIIlIlIlIIIIlIlIlI, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
            int lllllllllllllllIIlIlIlIIIIlIlIIl = 0;
            for (final File lllllllllllllllIIlIlIlIIIIlIlIII : lllllllllllllllIIlIlIlIIIIlIlIlI) {
                if (lllllllllllllllIIlIlIlIIIIlIlIIl++ >= 10) {
                    ResourcePackRepository.LOGGER.info("Deleting old server resource pack {}", (Object)lllllllllllllllIIlIlIlIIIIlIlIII.getName());
                    FileUtils.deleteQuietly(lllllllllllllllIIlIlIlIIIIlIlIII);
                }
            }
        }
        catch (IllegalArgumentException lllllllllllllllIIlIlIlIIIIlIIlll) {
            ResourcePackRepository.LOGGER.error("Error while deleting old server resource pack : {}", (Object)lllllllllllllllIIlIlIlIIIIlIIlll.getMessage());
        }
    }
    
    public ListenableFuture<Object> setResourcePackInstance(final File lllllllllllllllIIlIlIlIIIIIllIll) {
        if (!this.validatePack(lllllllllllllllIIlIlIlIIIIIllIll)) {
            return (ListenableFuture<Object>)Futures.immediateFailedFuture((Throwable)new RuntimeException("Invalid resourcepack"));
        }
        this.resourcePackInstance = new FileResourcePack(lllllllllllllllIIlIlIlIIIIIllIll);
        return Minecraft.getMinecraft().scheduleResourcesRefresh();
    }
    
    @Nullable
    public Entry getResourcePackEntry() {
        if (this.resourcePackInstance != null) {
            final Entry lllllllllllllllIIlIlIlIIllIllIlI = new Entry(this.resourcePackInstance, (Entry)null);
            try {
                lllllllllllllllIIlIlIlIIllIllIlI.updateResourcePack();
                return lllllllllllllllIIlIlIlIIllIllIlI;
            }
            catch (IOException ex) {}
        }
        return null;
    }
    
    public List<Entry> getRepositoryEntriesAll() {
        return (List<Entry>)ImmutableList.copyOf((Collection)this.repositoryEntriesAll);
    }
    
    private boolean validatePack(final File lllllllllllllllIIlIlIlIIIIlllllI) {
        final Entry lllllllllllllllIIlIlIlIIIlIIIIll = new Entry(lllllllllllllllIIlIlIlIIIIlllllI, (Entry)null);
        try {
            lllllllllllllllIIlIlIlIIIlIIIIll.updateResourcePack();
            return true;
        }
        catch (Exception lllllllllllllllIIlIlIlIIIlIIIIIl) {
            ResourcePackRepository.LOGGER.warn("Server resourcepack is invalid, ignoring it", (Throwable)lllllllllllllllIIlIlIlIIIlIIIIIl);
            return false;
        }
    }
    
    private void fixDirResourcepacks() {
        if (this.dirResourcepacks.exists()) {
            if (!this.dirResourcepacks.isDirectory() && (!this.dirResourcepacks.delete() || !this.dirResourcepacks.mkdirs())) {
                ResourcePackRepository.LOGGER.warn("Unable to recreate resourcepack folder, it exists but is not a directory: {}", (Object)this.dirResourcepacks);
            }
        }
        else if (!this.dirResourcepacks.mkdirs()) {
            ResourcePackRepository.LOGGER.warn("Unable to create resourcepack folder: {}", (Object)this.dirResourcepacks);
        }
    }
    
    public class Entry
    {
        private /* synthetic */ ResourceLocation locationTexturePackIcon;
        private /* synthetic */ PackMetadataSection rePackMetadataSection;
        private final /* synthetic */ IResourcePack reResourcePack;
        
        public IResourcePack getResourcePack() {
            return this.reResourcePack;
        }
        
        public String getResourcePackName() {
            return this.reResourcePack.getPackName();
        }
        
        private Entry(final IResourcePack lllllllllllllIIIlllIIIIllIlIllIl) {
            this.reResourcePack = lllllllllllllIIIlllIIIIllIlIllIl;
        }
        
        public void updateResourcePack() throws IOException {
            this.rePackMetadataSection = this.reResourcePack.getPackMetadata(ResourcePackRepository.this.rprMetadataSerializer, "pack");
            this.closeResourcePack();
        }
        
        private Entry(final ResourcePackRepository lllllllllllllIIIlllIIIIllIllIIll, final File lllllllllllllIIIlllIIIIllIllIlIl) {
            this(lllllllllllllIIIlllIIIIllIllIIll, lllllllllllllIIIlllIIIIllIllIIll.func_191399_b(lllllllllllllIIIlllIIIIllIllIlIl));
        }
        
        @Override
        public boolean equals(final Object lllllllllllllIIIlllIIIIllIIIIllI) {
            return this == lllllllllllllIIIlllIIIIllIIIIllI || (lllllllllllllIIIlllIIIIllIIIIllI instanceof Entry && this.toString().equals(lllllllllllllIIIlllIIIIllIIIIllI.toString()));
        }
        
        public String getTexturePackDescription() {
            return (this.rePackMetadataSection == null) ? String.valueOf(new StringBuilder().append(TextFormatting.RED).append("Invalid pack.mcmeta (or missing 'pack' section)")) : this.rePackMetadataSection.getPackDescription().getFormattedText();
        }
        
        @Override
        public int hashCode() {
            return this.toString().hashCode();
        }
        
        @Override
        public String toString() {
            return String.format("%s:%s", this.reResourcePack.getPackName(), (this.reResourcePack instanceof FolderResourcePack) ? "folder" : "zip");
        }
        
        public void bindTexturePackIcon(final TextureManager lllllllllllllIIIlllIIIIllIlIIIIl) {
            BufferedImage lllllllllllllIIIlllIIIIllIlIIIII = null;
            if (this.locationTexturePackIcon == null) {
                try {
                    lllllllllllllIIIlllIIIIllIlIIIII = this.reResourcePack.getPackImage();
                }
                catch (IOException ex) {}
                if (lllllllllllllIIIlllIIIIllIlIIIII == null) {
                    try {
                        lllllllllllllIIIlllIIIIllIlIIIII = TextureUtil.readBufferedImage(Minecraft.getMinecraft().getResourceManager().getResource(ResourcePackRepository.field_191400_f).getInputStream());
                    }
                    catch (IOException lllllllllllllIIIlllIIIIllIIlllll) {
                        throw new Error("Couldn't bind resource pack icon", lllllllllllllIIIlllIIIIllIIlllll);
                    }
                }
            }
            if (this.locationTexturePackIcon == null) {
                this.locationTexturePackIcon = lllllllllllllIIIlllIIIIllIlIIIIl.getDynamicTextureLocation("texturepackicon", new DynamicTexture(lllllllllllllIIIlllIIIIllIlIIIII));
            }
            lllllllllllllIIIlllIIIIllIlIIIIl.bindTexture(this.locationTexturePackIcon);
        }
        
        public void closeResourcePack() {
            if (this.reResourcePack instanceof Closeable) {
                IOUtils.closeQuietly((Closeable)this.reResourcePack);
            }
        }
        
        public int getPackFormat() {
            return (this.rePackMetadataSection == null) ? 0 : this.rePackMetadataSection.getPackFormat();
        }
    }
}
