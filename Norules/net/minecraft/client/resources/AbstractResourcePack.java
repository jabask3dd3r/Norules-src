package net.minecraft.client.resources;

import java.awt.image.*;
import net.minecraft.client.renderer.texture.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.resources.data.*;
import net.minecraft.util.*;
import java.nio.charset.*;
import java.io.*;
import org.apache.commons.io.*;
import com.google.gson.*;

public abstract class AbstractResourcePack implements IResourcePack
{
    public final /* synthetic */ File resourcePackFile;
    private static final /* synthetic */ Logger LOGGER;
    
    public AbstractResourcePack(final File lllllllllllllIlIlIIIIlllIIIIIIII) {
        this.resourcePackFile = lllllllllllllIlIlIIIIlllIIIIIIII;
    }
    
    @Override
    public BufferedImage getPackImage() throws IOException {
        return TextureUtil.readBufferedImage(this.getInputStreamByName("pack.png"));
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public <T extends IMetadataSection> T getPackMetadata(final MetadataSerializer lllllllllllllIlIlIIIIllIllIllIll, final String lllllllllllllIlIlIIIIllIllIlllIl) throws IOException {
        return readMetadata(lllllllllllllIlIlIIIIllIllIllIll, this.getInputStreamByName("pack.mcmeta"), lllllllllllllIlIlIIIIllIllIlllIl);
    }
    
    private static String locationToName(final ResourceLocation lllllllllllllIlIlIIIIllIlllllIll) {
        return String.format("%s/%s/%s", "assets", lllllllllllllIlIlIIIIllIlllllIll.getResourceDomain(), lllllllllllllIlIlIIIIllIlllllIll.getResourcePath());
    }
    
    @Override
    public boolean resourceExists(final ResourceLocation lllllllllllllIlIlIIIIllIlllIlIll) {
        return this.hasResourceName(locationToName(lllllllllllllIlIlIIIIllIlllIlIll));
    }
    
    protected void logNameNotLowercase(final String lllllllllllllIlIlIIIIllIlllIIlIl) {
        AbstractResourcePack.LOGGER.warn("ResourcePack: ignored non-lowercase namespace: {} in {}", (Object)lllllllllllllIlIlIIIIllIlllIIlIl, (Object)this.resourcePackFile);
    }
    
    protected static String getRelativeName(final File lllllllllllllIlIlIIIIllIlllllIII, final File lllllllllllllIlIlIIIIllIllllIlll) {
        return lllllllllllllIlIlIIIIllIlllllIII.toURI().relativize(lllllllllllllIlIlIIIIllIllllIlll.toURI()).getPath();
    }
    
    @Override
    public String getPackName() {
        return this.resourcePackFile.getName();
    }
    
    protected abstract boolean hasResourceName(final String p0);
    
    protected abstract InputStream getInputStreamByName(final String p0) throws IOException;
    
    static <T extends IMetadataSection> T readMetadata(final MetadataSerializer lllllllllllllIlIlIIIIllIllIIllII, final InputStream lllllllllllllIlIlIIIIllIllIIlIll, final String lllllllllllllIlIlIIIIllIllIIlIlI) {
        JsonObject lllllllllllllIlIlIIIIllIllIIllll = null;
        BufferedReader lllllllllllllIlIlIIIIllIllIIlllI = null;
        try {
            lllllllllllllIlIlIIIIllIllIIlllI = new BufferedReader(new InputStreamReader(lllllllllllllIlIlIIIIllIllIIlIll, StandardCharsets.UTF_8));
            lllllllllllllIlIlIIIIllIllIIllll = new JsonParser().parse((Reader)lllllllllllllIlIlIIIIllIllIIlllI).getAsJsonObject();
        }
        catch (RuntimeException lllllllllllllIlIlIIIIllIllIIllIl) {
            throw new JsonParseException((Throwable)lllllllllllllIlIlIIIIllIllIIllIl);
        }
        finally {
            IOUtils.closeQuietly((Reader)lllllllllllllIlIlIIIIllIllIIlllI);
        }
        IOUtils.closeQuietly((Reader)lllllllllllllIlIlIIIIllIllIIlllI);
        return lllllllllllllIlIlIIIIllIllIIllII.parseMetadataSection(lllllllllllllIlIlIIIIllIllIIlIlI, lllllllllllllIlIlIIIIllIllIIllll);
    }
    
    @Override
    public InputStream getInputStream(final ResourceLocation lllllllllllllIlIlIIIIllIllllIIIl) throws IOException {
        return this.getInputStreamByName(locationToName(lllllllllllllIlIlIIIIllIllllIIIl));
    }
}
