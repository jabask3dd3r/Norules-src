package net.minecraft.client.resources;

import java.io.*;
import com.mojang.authlib.*;
import java.util.*;
import javax.annotation.*;
import net.minecraft.util.*;
import java.awt.image.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;
import com.google.common.cache.*;
import net.minecraft.client.*;
import java.util.concurrent.*;
import com.mojang.authlib.minecraft.*;
import com.google.common.collect.*;

public class SkinManager
{
    private final /* synthetic */ File skinCacheDir;
    private final /* synthetic */ MinecraftSessionService sessionService;
    private final /* synthetic */ TextureManager textureManager;
    private final /* synthetic */ LoadingCache<GameProfile, Map<MinecraftProfileTexture.Type, MinecraftProfileTexture>> skinCacheLoader;
    private static final /* synthetic */ ExecutorService THREAD_POOL;
    
    public ResourceLocation loadSkin(final MinecraftProfileTexture lllllllllllllIIIlIIIlllIIIlllIlI, final MinecraftProfileTexture.Type lllllllllllllIIIlIIIlllIIIlllIIl, @Nullable final SkinAvailableCallback lllllllllllllIIIlIIIlllIIIlIlllI) {
        final ResourceLocation lllllllllllllIIIlIIIlllIIIllIlll = new ResourceLocation(String.valueOf(new StringBuilder("skins/").append(lllllllllllllIIIlIIIlllIIIlllIlI.getHash())));
        final ITextureObject lllllllllllllIIIlIIIlllIIIllIllI = this.textureManager.getTexture(lllllllllllllIIIlIIIlllIIIllIlll);
        if (lllllllllllllIIIlIIIlllIIIllIllI != null) {
            if (lllllllllllllIIIlIIIlllIIIlIlllI != null) {
                lllllllllllllIIIlIIIlllIIIlIlllI.skinAvailable(lllllllllllllIIIlIIIlllIIIlllIIl, lllllllllllllIIIlIIIlllIIIllIlll, lllllllllllllIIIlIIIlllIIIlllIlI);
            }
        }
        else {
            final File lllllllllllllIIIlIIIlllIIIllIlIl = new File(this.skinCacheDir, (lllllllllllllIIIlIIIlllIIIlllIlI.getHash().length() > 2) ? lllllllllllllIIIlIIIlllIIIlllIlI.getHash().substring(0, 2) : "xx");
            final File lllllllllllllIIIlIIIlllIIIllIlII = new File(lllllllllllllIIIlIIIlllIIIllIlIl, lllllllllllllIIIlIIIlllIIIlllIlI.getHash());
            final IImageBuffer lllllllllllllIIIlIIIlllIIIllIIll = (lllllllllllllIIIlIIIlllIIIlllIIl == MinecraftProfileTexture.Type.SKIN) ? new ImageBufferDownload() : null;
            final ThreadDownloadImageData lllllllllllllIIIlIIIlllIIIllIIlI = new ThreadDownloadImageData(lllllllllllllIIIlIIIlllIIIllIlII, lllllllllllllIIIlIIIlllIIIlllIlI.getUrl(), DefaultPlayerSkin.getDefaultSkinLegacy(), new IImageBuffer() {
                @Override
                public void skinAvailable() {
                    if (lllllllllllllIIIlIIIlllIIIllIIll != null) {
                        lllllllllllllIIIlIIIlllIIIllIIll.skinAvailable();
                    }
                    if (lllllllllllllIIIlIIIlllIIIlIlllI != null) {
                        lllllllllllllIIIlIIIlllIIIlIlllI.skinAvailable(lllllllllllllIIIlIIIlllIIIlllIIl, lllllllllllllIIIlIIIlllIIIllIlll, lllllllllllllIIIlIIIlllIIIlllIlI);
                    }
                }
                
                @Override
                public BufferedImage parseUserSkin(BufferedImage lllllllllllllIIlIllIIlIlIIIIIIIl) {
                    if (lllllllllllllIIIlIIIlllIIIllIIll != null) {
                        lllllllllllllIIlIllIIlIlIIIIIIIl = lllllllllllllIIIlIIIlllIIIllIIll.parseUserSkin((BufferedImage)lllllllllllllIIlIllIIlIlIIIIIIIl);
                    }
                    return (BufferedImage)lllllllllllllIIlIllIIlIlIIIIIIIl;
                }
            });
            this.textureManager.loadTexture(lllllllllllllIIIlIIIlllIIIllIlll, lllllllllllllIIIlIIIlllIIIllIIlI);
        }
        return lllllllllllllIIIlIIIlllIIIllIlll;
    }
    
    public ResourceLocation loadSkin(final MinecraftProfileTexture lllllllllllllIIIlIIIlllIIlIIIlll, final MinecraftProfileTexture.Type lllllllllllllIIIlIIIlllIIlIIIllI) {
        return this.loadSkin(lllllllllllllIIIlIIIlllIIlIIIlll, lllllllllllllIIIlIIIlllIIlIIIllI, null);
    }
    
    public SkinManager(final TextureManager lllllllllllllIIIlIIIlllIIlIlIIIl, final File lllllllllllllIIIlIIIlllIIlIlIIII, final MinecraftSessionService lllllllllllllIIIlIIIlllIIlIIllll) {
        this.textureManager = lllllllllllllIIIlIIIlllIIlIlIIIl;
        this.skinCacheDir = lllllllllllllIIIlIIIlllIIlIlIIII;
        this.sessionService = lllllllllllllIIIlIIIlllIIlIIllll;
        this.skinCacheLoader = (LoadingCache<GameProfile, Map<MinecraftProfileTexture.Type, MinecraftProfileTexture>>)CacheBuilder.newBuilder().expireAfterAccess(15L, TimeUnit.SECONDS).build((CacheLoader)new CacheLoader<GameProfile, Map<MinecraftProfileTexture.Type, MinecraftProfileTexture>>() {
            public Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> load(final GameProfile lllllllllllllIIlIIllIlIlIlIIIlII) throws Exception {
                try {
                    return (Map<MinecraftProfileTexture.Type, MinecraftProfileTexture>)Minecraft.getMinecraft().getSessionService().getTextures(lllllllllllllIIlIIllIlIlIlIIIlII, false);
                }
                catch (Throwable lllllllllllllIIlIIllIlIlIlIIIlIl) {
                    return (Map<MinecraftProfileTexture.Type, MinecraftProfileTexture>)Maps.newHashMap();
                }
            }
        });
    }
    
    static {
        THREAD_POOL = new ThreadPoolExecutor(0, 2, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
    }
    
    public void loadProfileTextures(final GameProfile lllllllllllllIIIlIIIlllIIIlIIIlI, final SkinAvailableCallback lllllllllllllIIIlIIIlllIIIIlllIl, final boolean lllllllllllllIIIlIIIlllIIIlIIIII) {
        SkinManager.THREAD_POOL.submit(new Runnable() {
            @Override
            public void run() {
                final Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> lllllllllllllIlIIlIlIlIllIIIIIll = (Map<MinecraftProfileTexture.Type, MinecraftProfileTexture>)Maps.newHashMap();
                try {
                    lllllllllllllIlIIlIlIlIllIIIIIll.putAll(SkinManager.this.sessionService.getTextures(lllllllllllllIIIlIIIlllIIIlIIIlI, lllllllllllllIIIlIIIlllIIIlIIIII));
                }
                catch (InsecureTextureException ex) {}
                if (lllllllllllllIlIIlIlIlIllIIIIIll.isEmpty() && lllllllllllllIIIlIIIlllIIIlIIIlI.getId().equals(Minecraft.getMinecraft().getSession().getProfile().getId())) {
                    lllllllllllllIIIlIIIlllIIIlIIIlI.getProperties().clear();
                    lllllllllllllIIIlIIIlllIIIlIIIlI.getProperties().putAll((Multimap)Minecraft.getMinecraft().getProfileProperties());
                    lllllllllllllIlIIlIlIlIllIIIIIll.putAll(SkinManager.this.sessionService.getTextures(lllllllllllllIIIlIIIlllIIIlIIIlI, false));
                }
                Minecraft.getMinecraft().addScheduledTask(new Runnable() {
                    @Override
                    public void run() {
                        if (lllllllllllllIlIIlIlIlIllIIIIIll.containsKey(MinecraftProfileTexture.Type.SKIN)) {
                            SkinManager.this.loadSkin(lllllllllllllIlIIlIlIlIllIIIIIll.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN, lllllllllllllIIIlIIIlllIIIIlllIl);
                        }
                        if (lllllllllllllIlIIlIlIlIllIIIIIll.containsKey(MinecraftProfileTexture.Type.CAPE)) {
                            SkinManager.this.loadSkin(lllllllllllllIlIIlIlIlIllIIIIIll.get(MinecraftProfileTexture.Type.CAPE), MinecraftProfileTexture.Type.CAPE, lllllllllllllIIIlIIIlllIIIIlllIl);
                        }
                    }
                });
            }
        });
    }
    
    public Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> loadSkinFromCache(final GameProfile lllllllllllllIIIlIIIlllIIIIllIII) {
        return (Map<MinecraftProfileTexture.Type, MinecraftProfileTexture>)this.skinCacheLoader.getUnchecked((Object)lllllllllllllIIIlIIIlllIIIIllIII);
    }
    
    public interface SkinAvailableCallback
    {
        void skinAvailable(final MinecraftProfileTexture.Type p0, final ResourceLocation p1, final MinecraftProfileTexture p2);
    }
}
