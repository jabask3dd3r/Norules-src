package net.minecraft.client.resources;

import java.util.*;
import java.awt.image.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.resources.data.*;
import javax.annotation.*;
import optifine.*;
import java.io.*;
import java.net.*;
import com.google.common.collect.*;
import net.minecraft.util.*;

public class DefaultResourcePack implements IResourcePack
{
    public static final /* synthetic */ Set<String> DEFAULT_RESOURCE_DOMAINS;
    private final /* synthetic */ ResourceIndex resourceIndex;
    private static final /* synthetic */ boolean ON_WINDOWS;
    
    public DefaultResourcePack(final ResourceIndex lllllllllllllIIIIIllIlIIIIlIIIIl) {
        this.resourceIndex = lllllllllllllIIIIIllIlIIIIlIIIIl;
    }
    
    @Override
    public BufferedImage getPackImage() throws IOException {
        return TextureUtil.readBufferedImage(DefaultResourcePack.class.getResourceAsStream(String.valueOf(new StringBuilder("/").append(new ResourceLocation("pack.png").getResourcePath()))));
    }
    
    @Nullable
    @Override
    public <T extends IMetadataSection> T getPackMetadata(final MetadataSerializer lllllllllllllIIIIIllIIlllllIllIl, final String lllllllllllllIIIIIllIIlllllIIllI) throws IOException {
        try {
            final InputStream lllllllllllllIIIIIllIIlllllIlIll = new FileInputStream(this.resourceIndex.getPackMcmeta());
            return AbstractResourcePack.readMetadata(lllllllllllllIIIIIllIIlllllIllIl, lllllllllllllIIIIIllIIlllllIlIll, lllllllllllllIIIIIllIIlllllIIllI);
        }
        catch (RuntimeException lllllllllllllIIIIIllIIlllllIlIlI) {
            return null;
        }
        catch (FileNotFoundException lllllllllllllIIIIIllIIlllllIlIIl) {
            return null;
        }
    }
    
    @Override
    public String getPackName() {
        return "Default";
    }
    
    @Nullable
    private InputStream getResourceStream(final ResourceLocation lllllllllllllIIIIIllIlIIIIIIIIll) {
        final String lllllllllllllIIIIIllIlIIIIIIIIlI = String.valueOf(new StringBuilder("/assets/").append(lllllllllllllIIIIIllIlIIIIIIIIll.getResourceDomain()).append("/").append(lllllllllllllIIIIIllIlIIIIIIIIll.getResourcePath()));
        final InputStream lllllllllllllIIIIIllIlIIIIIIIIIl = ReflectorForge.getOptiFineResourceStream(lllllllllllllIIIIIllIlIIIIIIIIlI);
        if (lllllllllllllIIIIIllIlIIIIIIIIIl != null) {
            return lllllllllllllIIIIIllIlIIIIIIIIIl;
        }
        try {
            final URL lllllllllllllIIIIIllIlIIIIIIIIII = DefaultResourcePack.class.getResource(lllllllllllllIIIIIllIlIIIIIIIIlI);
            return (lllllllllllllIIIIIllIlIIIIIIIIII != null && this.validatePath(new File(lllllllllllllIIIIIllIlIIIIIIIIII.getFile()), lllllllllllllIIIIIllIlIIIIIIIIlI)) ? DefaultResourcePack.class.getResourceAsStream(lllllllllllllIIIIIllIlIIIIIIIIlI) : null;
        }
        catch (IOException lllllllllllllIIIIIllIIllllllllll) {
            return DefaultResourcePack.class.getResourceAsStream(lllllllllllllIIIIIllIlIIIIIIIIlI);
        }
    }
    
    static {
        DEFAULT_RESOURCE_DOMAINS = (Set)ImmutableSet.of((Object)"minecraft", (Object)"realms");
        ON_WINDOWS = (Util.getOSType() == Util.EnumOS.WINDOWS);
    }
    
    @Override
    public InputStream getInputStream(final ResourceLocation lllllllllllllIIIIIllIlIIIIIllIIl) throws IOException {
        final InputStream lllllllllllllIIIIIllIlIIIIIllIII = this.getInputStreamAssets(lllllllllllllIIIIIllIlIIIIIllIIl);
        if (lllllllllllllIIIIIllIlIIIIIllIII != null) {
            return lllllllllllllIIIIIllIlIIIIIllIII;
        }
        final InputStream lllllllllllllIIIIIllIlIIIIIlIlll = this.getResourceStream(lllllllllllllIIIIIllIlIIIIIllIIl);
        if (lllllllllllllIIIIIllIlIIIIIlIlll != null) {
            return lllllllllllllIIIIIllIlIIIIIlIlll;
        }
        throw new FileNotFoundException(lllllllllllllIIIIIllIlIIIIIllIIl.getResourcePath());
    }
    
    private boolean validatePath(final File lllllllllllllIIIIIllIIllllIllIll, final String lllllllllllllIIIIIllIIllllIllIlI) throws IOException {
        String lllllllllllllIIIIIllIIllllIlllII = lllllllllllllIIIIIllIIllllIllIll.getPath();
        if (lllllllllllllIIIIIllIIllllIlllII.startsWith("file:")) {
            if (DefaultResourcePack.ON_WINDOWS) {
                lllllllllllllIIIIIllIIllllIlllII = lllllllllllllIIIIIllIIllllIlllII.replace("\\", "/");
            }
            return lllllllllllllIIIIIllIIllllIlllII.endsWith(lllllllllllllIIIIIllIIllllIllIlI);
        }
        return FolderResourcePack.func_191384_a(lllllllllllllIIIIIllIIllllIllIll, lllllllllllllIIIIIllIIllllIllIlI);
    }
    
    @Nullable
    public InputStream getInputStreamAssets(final ResourceLocation lllllllllllllIIIIIllIlIIIIIIlllI) throws FileNotFoundException, IOException {
        final File lllllllllllllIIIIIllIlIIIIIIllIl = this.resourceIndex.getFile(lllllllllllllIIIIIllIlIIIIIIlllI);
        return (lllllllllllllIIIIIllIlIIIIIIllIl != null && lllllllllllllIIIIIllIlIIIIIIllIl.isFile()) ? new FileInputStream(lllllllllllllIIIIIllIlIIIIIIllIl) : null;
    }
    
    @Override
    public boolean resourceExists(final ResourceLocation lllllllllllllIIIIIllIIllllllIllI) {
        return this.getResourceStream(lllllllllllllIIIIIllIIllllllIllI) != null || this.resourceIndex.isFileExisting(lllllllllllllIIIIIllIIllllllIllI);
    }
    
    @Override
    public Set<String> getResourceDomains() {
        return DefaultResourcePack.DEFAULT_RESOURCE_DOMAINS;
    }
}
