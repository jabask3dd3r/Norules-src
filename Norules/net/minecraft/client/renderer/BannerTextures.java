package net.minecraft.client.renderer;

import net.minecraft.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.item.*;
import com.google.common.collect.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;
import javax.annotation.*;
import java.util.*;

public class BannerTextures
{
    public static final /* synthetic */ ResourceLocation BANNER_BASE_TEXTURE;
    
    static {
        BANNER_DESIGNS = new Cache("B", new ResourceLocation("textures/entity/banner_base.png"), "textures/entity/banner/");
        SHIELD_DESIGNS = new Cache("S", new ResourceLocation("textures/entity/shield_base.png"), "textures/entity/shield/");
        SHIELD_BASE_TEXTURE = new ResourceLocation("textures/entity/shield_base_nopattern.png");
        BANNER_BASE_TEXTURE = new ResourceLocation("textures/entity/banner/base.png");
    }
    
    public static class Cache
    {
        private final /* synthetic */ String cacheResourceBase;
        private final /* synthetic */ Map<String, CacheEntry> cacheMap;
        private final /* synthetic */ ResourceLocation cacheResourceLocation;
        private final /* synthetic */ String cacheId;
        
        public Cache(final String lllllllllllllIllIIIlIlllllIllIlI, final ResourceLocation lllllllllllllIllIIIlIlllllIlIlIl, final String lllllllllllllIllIIIlIlllllIlIlII) {
            this.cacheMap = (Map<String, CacheEntry>)Maps.newLinkedHashMap();
            this.cacheId = lllllllllllllIllIIIlIlllllIllIlI;
            this.cacheResourceLocation = lllllllllllllIllIIIlIlllllIlIlIl;
            this.cacheResourceBase = lllllllllllllIllIIIlIlllllIlIlII;
        }
        
        @Nullable
        public ResourceLocation getResourceLocation(String lllllllllllllIllIIIlIlllllIIIIll, final List<BannerPattern> lllllllllllllIllIIIlIlllllIIlIIl, final List<EnumDyeColor> lllllllllllllIllIIIlIlllllIIlIII) {
            if (lllllllllllllIllIIIlIlllllIIIIll.isEmpty()) {
                return null;
            }
            lllllllllllllIllIIIlIlllllIIIIll = String.valueOf(new StringBuilder(String.valueOf(this.cacheId)).append(lllllllllllllIllIIIlIlllllIIIIll));
            CacheEntry lllllllllllllIllIIIlIlllllIIIlll = this.cacheMap.get(lllllllllllllIllIIIlIlllllIIIIll);
            if (lllllllllllllIllIIIlIlllllIIIlll == null) {
                if (this.cacheMap.size() >= 256 && !this.freeCacheSlot()) {
                    return BannerTextures.BANNER_BASE_TEXTURE;
                }
                final List<String> lllllllllllllIllIIIlIlllllIIIllI = (List<String>)Lists.newArrayList();
                for (final BannerPattern lllllllllllllIllIIIlIlllllIIIlIl : lllllllllllllIllIIIlIlllllIIlIIl) {
                    lllllllllllllIllIIIlIlllllIIIllI.add(String.valueOf(new StringBuilder(String.valueOf(this.cacheResourceBase)).append(lllllllllllllIllIIIlIlllllIIIlIl.func_190997_a()).append(".png")));
                }
                lllllllllllllIllIIIlIlllllIIIlll = new CacheEntry(null);
                lllllllllllllIllIIIlIlllllIIIlll.textureLocation = new ResourceLocation(lllllllllllllIllIIIlIlllllIIIIll);
                Minecraft.getMinecraft().getTextureManager().loadTexture(lllllllllllllIllIIIlIlllllIIIlll.textureLocation, new LayeredColorMaskTexture(this.cacheResourceLocation, lllllllllllllIllIIIlIlllllIIIllI, lllllllllllllIllIIIlIlllllIIlIII));
                this.cacheMap.put(lllllllllllllIllIIIlIlllllIIIIll, lllllllllllllIllIIIlIlllllIIIlll);
            }
            lllllllllllllIllIIIlIlllllIIIlll.lastUseMillis = System.currentTimeMillis();
            return lllllllllllllIllIIIlIlllllIIIlll.textureLocation;
        }
        
        private boolean freeCacheSlot() {
            final long lllllllllllllIllIIIlIllllIllIllI = System.currentTimeMillis();
            final Iterator<String> lllllllllllllIllIIIlIllllIllIlIl = this.cacheMap.keySet().iterator();
            while (lllllllllllllIllIIIlIllllIllIlIl.hasNext()) {
                final String lllllllllllllIllIIIlIllllIllIlII = lllllllllllllIllIIIlIllllIllIlIl.next();
                final CacheEntry lllllllllllllIllIIIlIllllIllIIll = this.cacheMap.get(lllllllllllllIllIIIlIllllIllIlII);
                if (lllllllllllllIllIIIlIllllIllIllI - lllllllllllllIllIIIlIllllIllIIll.lastUseMillis > 5000L) {
                    Minecraft.getMinecraft().getTextureManager().deleteTexture(lllllllllllllIllIIIlIllllIllIIll.textureLocation);
                    lllllllllllllIllIIIlIllllIllIlIl.remove();
                    return true;
                }
            }
            return this.cacheMap.size() < 256;
        }
    }
    
    static class CacheEntry
    {
        public /* synthetic */ ResourceLocation textureLocation;
        public /* synthetic */ long lastUseMillis;
        
        private CacheEntry() {
        }
    }
}
