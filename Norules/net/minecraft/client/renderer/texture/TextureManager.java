package net.minecraft.client.renderer.texture;

import net.minecraft.client.resources.*;
import optifine.*;
import shadersmod.client.*;
import java.io.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;
import com.google.common.collect.*;
import java.util.*;
import org.apache.logging.log4j.*;

public class TextureManager implements IResourceManagerReloadListener, ITickable
{
    private final /* synthetic */ IResourceManager theResourceManager;
    private final /* synthetic */ Map<String, Integer> mapTextureCounters;
    private final /* synthetic */ List<ITickable> listTickables;
    public static final /* synthetic */ ResourceLocation field_194008_a;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ Map<ResourceLocation, ITextureObject> mapTextureObjects;
    
    public ResourceLocation getDynamicTextureLocation(final String lllllllllllllIlIllllIIIllIIlllII, DynamicTexture lllllllllllllIlIllllIIIllIIlIllI) {
        if (lllllllllllllIlIllllIIIllIIlllII.equals("logo")) {
            lllllllllllllIlIllllIIIllIIlIllI = Config.getMojangLogoTexture((DynamicTexture)lllllllllllllIlIllllIIIllIIlIllI);
        }
        Integer lllllllllllllIlIllllIIIllIIllIlI = this.mapTextureCounters.get(lllllllllllllIlIllllIIIllIIlllII);
        if (lllllllllllllIlIllllIIIllIIllIlI == null) {
            lllllllllllllIlIllllIIIllIIllIlI = 1;
        }
        else {
            ++lllllllllllllIlIllllIIIllIIllIlI;
        }
        this.mapTextureCounters.put(lllllllllllllIlIllllIIIllIIlllII, lllllllllllllIlIllllIIIllIIllIlI);
        final ResourceLocation lllllllllllllIlIllllIIIllIIllIIl = new ResourceLocation(String.format("dynamic/%s_%d", lllllllllllllIlIllllIIIllIIlllII, lllllllllllllIlIllllIIIllIIllIlI));
        this.loadTexture(lllllllllllllIlIllllIIIllIIllIIl, (ITextureObject)lllllllllllllIlIllllIIIllIIlIllI);
        return lllllllllllllIlIllllIIIllIIllIIl;
    }
    
    public void deleteTexture(final ResourceLocation lllllllllllllIlIllllIIIllIIIIlll) {
        final ITextureObject lllllllllllllIlIllllIIIllIIIIllI = this.getTexture(lllllllllllllIlIllllIIIllIIIIlll);
        if (lllllllllllllIlIllllIIIllIIIIllI != null) {
            this.mapTextureObjects.remove(lllllllllllllIlIllllIIIllIIIIlll);
            TextureUtil.deleteTexture(lllllllllllllIlIllllIIIllIIIIllI.getGlTextureId());
        }
    }
    
    public void bindTexture(ResourceLocation lllllllllllllIlIllllIIIlllIIllII) {
        if (Config.isRandomMobs()) {
            lllllllllllllIlIllllIIIlllIIllII = RandomMobs.getTextureLocation(lllllllllllllIlIllllIIIlllIIllII);
        }
        if (Config.isCustomGuis()) {
            lllllllllllllIlIllllIIIlllIIllII = CustomGuis.getTextureLocation(lllllllllllllIlIllllIIIlllIIllII);
        }
        ITextureObject lllllllllllllIlIllllIIIlllIIlllI = this.mapTextureObjects.get(lllllllllllllIlIllllIIIlllIIllII);
        if (lllllllllllllIlIllllIIIlllIIlllI == null) {
            lllllllllllllIlIllllIIIlllIIlllI = new SimpleTexture(lllllllllllllIlIllllIIIlllIIllII);
            this.loadTexture(lllllllllllllIlIllllIIIlllIIllII, lllllllllllllIlIllllIIIlllIIlllI);
        }
        if (Config.isShaders()) {
            ShadersTex.bindTexture(lllllllllllllIlIllllIIIlllIIlllI);
        }
        else {
            TextureUtil.bindTexture(lllllllllllllIlIllllIIIlllIIlllI.getGlTextureId());
        }
    }
    
    public boolean loadTexture(final ResourceLocation lllllllllllllIlIllllIIIllIlIllll, ITextureObject lllllllllllllIlIllllIIIllIlIlllI) {
        boolean lllllllllllllIlIllllIIIllIllIllI = true;
        try {
            lllllllllllllIlIllllIIIllIlIlllI.loadTexture(this.theResourceManager);
        }
        catch (IOException lllllllllllllIlIllllIIIllIllIlIl) {
            if (lllllllllllllIlIllllIIIllIlIllll != TextureManager.field_194008_a) {
                TextureManager.LOGGER.warn("Failed to load texture: {}", (Object)lllllllllllllIlIllllIIIllIlIllll, (Object)lllllllllllllIlIllllIIIllIllIlIl);
            }
            lllllllllllllIlIllllIIIllIlIlllI = TextureUtil.MISSING_TEXTURE;
            this.mapTextureObjects.put(lllllllllllllIlIllllIIIllIlIllll, lllllllllllllIlIllllIIIllIlIlllI);
            lllllllllllllIlIllllIIIllIllIllI = false;
        }
        catch (Throwable lllllllllllllIlIllllIIIllIllIlII) {
            final ITextureObject lllllllllllllIlIllllIIIllIllIIll = lllllllllllllIlIllllIIIllIlIlllI;
            final CrashReport lllllllllllllIlIllllIIIllIllIIlI = CrashReport.makeCrashReport(lllllllllllllIlIllllIIIllIllIlII, "Registering texture");
            final CrashReportCategory lllllllllllllIlIllllIIIllIllIIIl = lllllllllllllIlIllllIIIllIllIIlI.makeCategory("Resource location being registered");
            lllllllllllllIlIllllIIIllIllIIIl.addCrashSection("Resource location", lllllllllllllIlIllllIIIllIlIllll);
            lllllllllllllIlIllllIIIllIllIIIl.setDetail("Texture object class", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    return lllllllllllllIlIllllIIIllIllIIll.getClass().getName();
                }
            });
            throw new ReportedException(lllllllllllllIlIllllIIIllIllIIlI);
        }
        this.mapTextureObjects.put(lllllllllllllIlIllllIIIllIlIllll, lllllllllllllIlIllllIIIllIlIlllI);
        return lllllllllllllIlIllllIIIllIllIllI;
    }
    
    public TextureManager(final IResourceManager lllllllllllllIlIllllIIIlllIlIllI) {
        this.mapTextureObjects = (Map<ResourceLocation, ITextureObject>)Maps.newHashMap();
        this.listTickables = (List<ITickable>)Lists.newArrayList();
        this.mapTextureCounters = (Map<String, Integer>)Maps.newHashMap();
        this.theResourceManager = lllllllllllllIlIllllIIIlllIlIllI;
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager lllllllllllllIlIllllIIIlIllllIll) {
        Config.dbg("*** Reloading textures ***");
        Config.log(String.valueOf(new StringBuilder("Resource packs: ").append(Config.getResourcePackNames())));
        final Iterator lllllllllllllIlIllllIIIlIllllIlI = this.mapTextureObjects.keySet().iterator();
        while (lllllllllllllIlIllllIIIlIllllIlI.hasNext()) {
            final ResourceLocation lllllllllllllIlIllllIIIlIllllIIl = lllllllllllllIlIllllIIIlIllllIlI.next();
            final String lllllllllllllIlIllllIIIlIllllIII = lllllllllllllIlIllllIIIlIllllIIl.getResourcePath();
            if (lllllllllllllIlIllllIIIlIllllIII.startsWith("mcpatcher/") || lllllllllllllIlIllllIIIlIllllIII.startsWith("optifine/")) {
                final ITextureObject lllllllllllllIlIllllIIIlIlllIlll = this.mapTextureObjects.get(lllllllllllllIlIllllIIIlIllllIIl);
                if (lllllllllllllIlIllllIIIlIlllIlll instanceof AbstractTexture) {
                    final AbstractTexture lllllllllllllIlIllllIIIlIlllIllI = (AbstractTexture)lllllllllllllIlIllllIIIlIlllIlll;
                    lllllllllllllIlIllllIIIlIlllIllI.deleteGlTexture();
                }
                lllllllllllllIlIllllIIIlIllllIlI.remove();
            }
        }
        final Iterator<Map.Entry<ResourceLocation, ITextureObject>> lllllllllllllIlIllllIIIlIlllIlIl = this.mapTextureObjects.entrySet().iterator();
        while (lllllllllllllIlIllllIIIlIlllIlIl.hasNext()) {
            final Map.Entry<ResourceLocation, ITextureObject> lllllllllllllIlIllllIIIlIlllIlII = lllllllllllllIlIllllIIIlIlllIlIl.next();
            final ITextureObject lllllllllllllIlIllllIIIlIlllIIll = lllllllllllllIlIllllIIIlIlllIlII.getValue();
            if (lllllllllllllIlIllllIIIlIlllIIll == TextureUtil.MISSING_TEXTURE) {
                lllllllllllllIlIllllIIIlIlllIlIl.remove();
            }
            else {
                this.loadTexture(lllllllllllllIlIllllIIIlIlllIlII.getKey(), lllllllllllllIlIllllIIIlIlllIIll);
            }
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        field_194008_a = new ResourceLocation("");
    }
    
    @Override
    public void tick() {
        for (final ITickable lllllllllllllIlIllllIIIllIIIllll : this.listTickables) {
            lllllllllllllIlIllllIIIllIIIllll.tick();
        }
    }
    
    public void reloadBannerTextures() {
        for (final Map.Entry<ResourceLocation, ITextureObject> lllllllllllllIlIllllIIIlIllIIllI : this.mapTextureObjects.entrySet()) {
            final ResourceLocation lllllllllllllIlIllllIIIlIllIIlIl = lllllllllllllIlIllllIIIlIllIIllI.getKey();
            final ITextureObject lllllllllllllIlIllllIIIlIllIIlII = lllllllllllllIlIllllIIIlIllIIllI.getValue();
            if (lllllllllllllIlIllllIIIlIllIIlII instanceof LayeredColorMaskTexture) {
                this.loadTexture(lllllllllllllIlIllllIIIlIllIIlIl, lllllllllllllIlIllllIIIlIllIIlII);
            }
        }
    }
    
    public boolean loadTickableTexture(final ResourceLocation lllllllllllllIlIllllIIIlllIIIllI, final ITickableTextureObject lllllllllllllIlIllllIIIlllIIIlIl) {
        if (this.loadTexture(lllllllllllllIlIllllIIIlllIIIllI, lllllllllllllIlIllllIIIlllIIIlIl)) {
            this.listTickables.add(lllllllllllllIlIllllIIIlllIIIlIl);
            return true;
        }
        return false;
    }
    
    public ITextureObject getTexture(final ResourceLocation lllllllllllllIlIllllIIIllIlIIlIl) {
        return this.mapTextureObjects.get(lllllllllllllIlIllllIIIllIlIIlIl);
    }
}
