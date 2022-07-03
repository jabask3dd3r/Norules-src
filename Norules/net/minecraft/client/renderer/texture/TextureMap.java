package net.minecraft.client.renderer.texture;

import javax.annotation.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.resources.*;
import java.awt.*;
import java.awt.image.*;
import org.apache.commons.io.*;
import java.io.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;
import shadersmod.client.*;
import java.util.*;
import optifine.*;
import net.minecraft.client.renderer.*;

public class TextureMap extends AbstractTexture implements ITickableTextureObject
{
    private /* synthetic */ double iconGridSizeU;
    private final /* synthetic */ List<TextureAtlasSprite> listAnimatedSprites;
    private /* synthetic */ double iconGridSizeV;
    private /* synthetic */ int iconGridSize;
    private final /* synthetic */ Map<String, TextureAtlasSprite> mapRegisteredSprites;
    private /* synthetic */ int counterIndexInMap;
    private final /* synthetic */ String basePath;
    private /* synthetic */ TextureAtlasSprite[] iconGrid;
    private /* synthetic */ int iconGridCountY;
    private static final /* synthetic */ Logger LOGGER;
    public static final /* synthetic */ ResourceLocation LOCATION_BLOCKS_TEXTURE;
    public /* synthetic */ int atlasWidth;
    private /* synthetic */ int mipmapLevels;
    private final /* synthetic */ TextureAtlasSprite missingImage;
    private final /* synthetic */ ITextureMapPopulator iconCreator;
    private final /* synthetic */ Map<String, TextureAtlasSprite> mapUploadedSprites;
    public /* synthetic */ int atlasHeight;
    private /* synthetic */ int iconGridCountX;
    
    public TextureMap(final String lllllllllllllIIIllllIlIlllIllIlI, @Nullable final ITextureMapPopulator lllllllllllllIIIllllIlIlllIlIllI) {
        this(lllllllllllllIIIllllIlIlllIllIlI, lllllllllllllIIIllllIlIlllIlIllI, false);
    }
    
    @Override
    public void tick() {
        this.updateAnimations();
    }
    
    public boolean setTextureEntry(final TextureAtlasSprite lllllllllllllIIIllllIlIIllllIlIl) {
        final String lllllllllllllIIIllllIlIIllllIlII = lllllllllllllIIIllllIlIIllllIlIl.getIconName();
        if (!this.mapRegisteredSprites.containsKey(lllllllllllllIIIllllIlIIllllIlII)) {
            this.mapRegisteredSprites.put(lllllllllllllIIIllllIlIIllllIlII, lllllllllllllIIIllllIlIIllllIlIl);
            if (lllllllllllllIIIllllIlIIllllIlIl.getIndexInMap() < 0) {
                lllllllllllllIIIllllIlIIllllIlIl.setIndexInMap(this.counterIndexInMap++);
            }
            return true;
        }
        return false;
    }
    
    private void initMissingImage() {
        final int lllllllllllllIIIllllIlIlllIIIllI = this.getMinSpriteSize();
        final int[] lllllllllllllIIIllllIlIlllIIIlIl = this.getMissingImageData(lllllllllllllIIIllllIlIlllIIIllI);
        this.missingImage.setIconWidth(lllllllllllllIIIllllIlIlllIIIllI);
        this.missingImage.setIconHeight(lllllllllllllIIIllllIlIlllIIIllI);
        final int[][] lllllllllllllIIIllllIlIlllIIIlII = new int[this.mipmapLevels + 1][];
        lllllllllllllIIIllllIlIlllIIIlII[0] = lllllllllllllIIIllllIlIlllIIIlIl;
        this.missingImage.setFramesTextureData(Lists.newArrayList((Object[])new int[][][] { lllllllllllllIIIllllIlIlllIIIlII }));
        this.missingImage.setIndexInMap(this.counterIndexInMap++);
    }
    
    private int getMinSpriteSize() {
        int lllllllllllllIIIllllIlIIIlllIlll = 1 << this.mipmapLevels;
        if (lllllllllllllIIIllllIlIIIlllIlll < 8) {
            lllllllllllllIIIllllIlIIIlllIlll = 8;
        }
        return lllllllllllllIIIllllIlIIIlllIlll;
    }
    
    private int detectMaxMipmapLevel(final Map lllllllllllllIIIllllIlIIlIlllIIl, final IResourceManager lllllllllllllIIIllllIlIIlIllllIl) {
        int lllllllllllllIIIllllIlIIlIllllII = this.detectMinimumSpriteSize(lllllllllllllIIIllllIlIIlIlllIIl, lllllllllllllIIIllllIlIIlIllllIl, 20);
        if (lllllllllllllIIIllllIlIIlIllllII < 16) {
            lllllllllllllIIIllllIlIIlIllllII = 16;
        }
        lllllllllllllIIIllllIlIIlIllllII = MathHelper.smallestEncompassingPowerOfTwo(lllllllllllllIIIllllIlIIlIllllII);
        if (lllllllllllllIIIllllIlIIlIllllII > 16) {
            Config.log(String.valueOf(new StringBuilder("Sprite size: ").append(lllllllllllllIIIllllIlIIlIllllII)));
        }
        int lllllllllllllIIIllllIlIIlIlllIll = MathHelper.log2(lllllllllllllIIIllllIlIIlIllllII);
        if (lllllllllllllIIIllllIlIIlIlllIll < 4) {
            lllllllllllllIIIllllIlIIlIlllIll = 4;
        }
        return lllllllllllllIIIllllIlIIlIlllIll;
    }
    
    public boolean isTextureBound() {
        final int lllllllllllllIIIllllIlIIIllIIIll = GlStateManager.getBoundTexture();
        final int lllllllllllllIIIllllIlIIIllIIIlI = this.getGlTextureId();
        return lllllllllllllIIIllllIlIIIllIIIll == lllllllllllllIIIllllIlIIIllIIIlI;
    }
    
    public TextureMap(final String lllllllllllllIIIllllIlIlllIIllIl, final ITextureMapPopulator lllllllllllllIIIllllIlIlllIIllII, final boolean lllllllllllllIIIllllIlIlllIIllll) {
        this.iconGrid = null;
        this.iconGridSize = -1;
        this.iconGridCountX = -1;
        this.iconGridCountY = -1;
        this.iconGridSizeU = -1.0;
        this.iconGridSizeV = -1.0;
        this.counterIndexInMap = 0;
        this.atlasWidth = 0;
        this.atlasHeight = 0;
        this.listAnimatedSprites = (List<TextureAtlasSprite>)Lists.newArrayList();
        this.mapRegisteredSprites = (Map<String, TextureAtlasSprite>)Maps.newHashMap();
        this.mapUploadedSprites = (Map<String, TextureAtlasSprite>)Maps.newHashMap();
        this.missingImage = new TextureAtlasSprite("missingno");
        this.basePath = lllllllllllllIIIllllIlIlllIIllIl;
        this.iconCreator = lllllllllllllIIIllllIlIlllIIllII;
    }
    
    private boolean isAbsoluteLocationPath(final String lllllllllllllIIIllllIlIIllIllllI) {
        final String lllllllllllllIIIllllIlIIllIlllIl = lllllllllllllIIIllllIlIIllIllllI.toLowerCase();
        return lllllllllllllIIIllllIlIIllIlllIl.startsWith("mcpatcher/") || lllllllllllllIIIllllIlIIllIlllIl.startsWith("optifine/");
    }
    
    public void setMipmapLevels(final int lllllllllllllIIIllllIlIlIIIIIIll) {
        this.mipmapLevels = lllllllllllllIIIllllIlIlIIIIIIll;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        LOCATION_MISSING_TEXTURE = new ResourceLocation("missingno");
        LOCATION_BLOCKS_TEXTURE = new ResourceLocation("textures/atlas/blocks.png");
    }
    
    public TextureAtlasSprite getAtlasSprite(final String lllllllllllllIIIllllIlIlIIlIlIlI) {
        TextureAtlasSprite lllllllllllllIIIllllIlIlIIlIllII = this.mapUploadedSprites.get(lllllllllllllIIIllllIlIlIIlIlIlI);
        if (lllllllllllllIIIllllIlIlIIlIllII == null) {
            lllllllllllllIIIllllIlIlIIlIllII = this.missingImage;
        }
        return lllllllllllllIIIllllIlIlIIlIllII;
    }
    
    public ResourceLocation getResourceLocation(final TextureAtlasSprite lllllllllllllIIIllllIlIlIIllllII) {
        final ResourceLocation lllllllllllllIIIllllIlIlIIlllIll = new ResourceLocation(lllllllllllllIIIllllIlIlIIllllII.getIconName());
        return this.completeResourceLocation(lllllllllllllIIIllllIlIlIIlllIll);
    }
    
    private int detectMinimumSpriteSize(final Map lllllllllllllIIIllllIlIIlIIIlIIl, final IResourceManager lllllllllllllIIIllllIlIIlIlIIIll, final int lllllllllllllIIIllllIlIIlIIIIlll) {
        final Map lllllllllllllIIIllllIlIIlIlIIIIl = new HashMap();
        for (final Object lllllllllllllIIIllllIlIIlIlIIIII : lllllllllllllIIIllllIlIIlIIIlIIl.entrySet()) {
            final TextureAtlasSprite lllllllllllllIIIllllIlIIlIIlllll = ((Map.Entry)lllllllllllllIIIllllIlIIlIlIIIII).getValue();
            final ResourceLocation lllllllllllllIIIllllIlIIlIIllllI = new ResourceLocation(lllllllllllllIIIllllIlIIlIIlllll.getIconName());
            final ResourceLocation lllllllllllllIIIllllIlIIlIIlllIl = this.completeResourceLocation(lllllllllllllIIIllllIlIIlIIllllI);
            if (!lllllllllllllIIIllllIlIIlIIlllll.hasCustomLoader(lllllllllllllIIIllllIlIIlIlIIIll, lllllllllllllIIIllllIlIIlIIllllI)) {
                try {
                    final IResource lllllllllllllIIIllllIlIIlIIlllII = lllllllllllllIIIllllIlIIlIlIIIll.getResource(lllllllllllllIIIllllIlIIlIIlllIl);
                    if (lllllllllllllIIIllllIlIIlIIlllII == null) {
                        continue;
                    }
                    final InputStream lllllllllllllIIIllllIlIIlIIllIll = lllllllllllllIIIllllIlIIlIIlllII.getInputStream();
                    if (lllllllllllllIIIllllIlIIlIIllIll == null) {
                        continue;
                    }
                    final Dimension lllllllllllllIIIllllIlIIlIIllIlI = TextureUtils.getImageSize(lllllllllllllIIIllllIlIIlIIllIll, "png");
                    if (lllllllllllllIIIllllIlIIlIIllIlI == null) {
                        continue;
                    }
                    final int lllllllllllllIIIllllIlIIlIIllIIl = lllllllllllllIIIllllIlIIlIIllIlI.width;
                    final int lllllllllllllIIIllllIlIIlIIllIII = MathHelper.smallestEncompassingPowerOfTwo(lllllllllllllIIIllllIlIIlIIllIIl);
                    if (!lllllllllllllIIIllllIlIIlIlIIIIl.containsKey(lllllllllllllIIIllllIlIIlIIllIII)) {
                        lllllllllllllIIIllllIlIIlIlIIIIl.put(lllllllllllllIIIllllIlIIlIIllIII, 1);
                    }
                    else {
                        final int lllllllllllllIIIllllIlIIlIIlIlll = lllllllllllllIIIllllIlIIlIlIIIIl.get(lllllllllllllIIIllllIlIIlIIllIII);
                        lllllllllllllIIIllllIlIIlIlIIIIl.put(lllllllllllllIIIllllIlIIlIIllIII, lllllllllllllIIIllllIlIIlIIlIlll + 1);
                    }
                }
                catch (Exception ex) {}
            }
        }
        int lllllllllllllIIIllllIlIIlIIlIllI = 0;
        final Set lllllllllllllIIIllllIlIIlIIlIlIl = lllllllllllllIIIllllIlIIlIlIIIIl.keySet();
        final Set lllllllllllllIIIllllIlIIlIIlIlII = new TreeSet(lllllllllllllIIIllllIlIIlIIlIlIl);
        for (final int lllllllllllllIIIllllIlIIlIIlIIII : lllllllllllllIIIllllIlIIlIIlIlII) {
            final int lllllllllllllIIIllllIlIIlIIlIIll = lllllllllllllIIIllllIlIIlIlIIIIl.get(lllllllllllllIIIllllIlIIlIIlIIII);
            lllllllllllllIIIllllIlIIlIIlIllI += lllllllllllllIIIllllIlIIlIIlIIll;
        }
        int lllllllllllllIIIllllIlIIlIIIllll = 16;
        int lllllllllllllIIIllllIlIIlIIIlllI = 0;
        final int lllllllllllllIIIllllIlIIlIIlIIlI = lllllllllllllIIIllllIlIIlIIlIllI * lllllllllllllIIIllllIlIIlIIIIlll / 100;
        for (final int lllllllllllllIIIllllIlIIlIIIllII : lllllllllllllIIIllllIlIIlIIlIlII) {
            final int lllllllllllllIIIllllIlIIlIIIlIll = lllllllllllllIIIllllIlIIlIlIIIIl.get(lllllllllllllIIIllllIlIIlIIIllII);
            lllllllllllllIIIllllIlIIlIIIlllI += lllllllllllllIIIllllIlIIlIIIlIll;
            if (lllllllllllllIIIllllIlIIlIIIllII > lllllllllllllIIIllllIlIIlIIIllll) {
                lllllllllllllIIIllllIlIIlIIIllll = lllllllllllllIIIllllIlIIlIIIllII;
            }
            if (lllllllllllllIIIllllIlIIlIIIlllI > lllllllllllllIIIllllIlIIlIIlIIlI) {
                return lllllllllllllIIIllllIlIIlIIIllll;
            }
        }
        return lllllllllllllIIIllllIlIIlIIIllll;
    }
    
    public TextureAtlasSprite registerSprite(final ResourceLocation lllllllllllllIIIllllIlIlIIIIllIl) {
        if (lllllllllllllIIIllllIlIlIIIIllIl == null) {
            throw new IllegalArgumentException("Location cannot be null!");
        }
        TextureAtlasSprite lllllllllllllIIIllllIlIlIIIIllll = this.mapRegisteredSprites.get(lllllllllllllIIIllllIlIlIIIIllIl.toString());
        if (lllllllllllllIIIllllIlIlIIIIllll == null) {
            lllllllllllllIIIllllIlIlIIIIllll = TextureAtlasSprite.makeAtlasSprite(lllllllllllllIIIllllIlIlIIIIllIl);
            this.mapRegisteredSprites.put(lllllllllllllIIIllllIlIlIIIIllIl.toString(), lllllllllllllIIIllllIlIlIIIIllll);
            if (lllllllllllllIIIllllIlIlIIIIllll.getIndexInMap() < 0) {
                lllllllllllllIIIllllIlIlIIIIllll.setIndexInMap(this.counterIndexInMap++);
            }
        }
        return lllllllllllllIIIllllIlIlIIIIllll;
    }
    
    @Nullable
    public TextureAtlasSprite getTextureExtry(final String lllllllllllllIIIllllIlIIllllllII) {
        return this.mapRegisteredSprites.get(lllllllllllllIIIllllIlIIllllllII);
    }
    
    private boolean isAbsoluteLocation(final ResourceLocation lllllllllllllIIIllllIlIIlllIIllI) {
        final String lllllllllllllIIIllllIlIIlllIIlIl = lllllllllllllIIIllllIlIIlllIIllI.getResourcePath();
        return this.isAbsoluteLocationPath(lllllllllllllIIIllllIlIIlllIIlIl);
    }
    
    public void loadSprites(final IResourceManager lllllllllllllIIIllllIlIllIllIlIl, final ITextureMapPopulator lllllllllllllIIIllllIlIllIllIlII) {
        this.mapRegisteredSprites.clear();
        this.counterIndexInMap = 0;
        Reflector.callVoid(Reflector.ForgeHooksClient_onTextureStitchedPre, this);
        lllllllllllllIIIllllIlIllIllIlII.registerSprites(this);
        if (this.mipmapLevels >= 4) {
            this.mipmapLevels = this.detectMaxMipmapLevel(this.mapRegisteredSprites, lllllllllllllIIIllllIlIllIllIlIl);
            Config.log(String.valueOf(new StringBuilder("Mipmap levels: ").append(this.mipmapLevels)));
        }
        this.initMissingImage();
        this.deleteGlTexture();
        this.loadTextureAtlas(lllllllllllllIIIllllIlIllIllIlIl);
    }
    
    private int[] getMissingImageData(final int lllllllllllllIIIllllIlIIIllIlIll) {
        final BufferedImage lllllllllllllIIIllllIlIIIllIlllI = new BufferedImage(16, 16, 2);
        lllllllllllllIIIllllIlIIIllIlllI.setRGB(0, 0, 16, 16, TextureUtil.MISSING_TEXTURE_DATA, 0, 16);
        final BufferedImage lllllllllllllIIIllllIlIIIllIllIl = TextureUtils.scaleToPowerOfTwo(lllllllllllllIIIllllIlIIIllIlllI, lllllllllllllIIIllllIlIIIllIlIll);
        final int[] lllllllllllllIIIllllIlIIIllIllII = new int[lllllllllllllIIIllllIlIIIllIlIll * lllllllllllllIIIllllIlIIIllIlIll];
        lllllllllllllIIIllllIlIIIllIllIl.getRGB(0, 0, lllllllllllllIIIllllIlIIIllIlIll, lllllllllllllIIIllllIlIIIllIlIll, lllllllllllllIIIllllIlIIIllIllII, 0, lllllllllllllIIIllllIlIIIllIlIll);
        return lllllllllllllIIIllllIlIIIllIllII;
    }
    
    private void updateIconGrid(final int lllllllllllllIIIllllIlIIIIlllIlI, final int lllllllllllllIIIllllIlIIIlIIlIlI) {
        this.iconGridCountX = -1;
        this.iconGridCountY = -1;
        this.iconGrid = null;
        if (this.iconGridSize > 0) {
            this.iconGridCountX = lllllllllllllIIIllllIlIIIIlllIlI / this.iconGridSize;
            this.iconGridCountY = lllllllllllllIIIllllIlIIIlIIlIlI / this.iconGridSize;
            this.iconGrid = new TextureAtlasSprite[this.iconGridCountX * this.iconGridCountY];
            this.iconGridSizeU = 1.0 / this.iconGridCountX;
            this.iconGridSizeV = 1.0 / this.iconGridCountY;
            for (final TextureAtlasSprite lllllllllllllIIIllllIlIIIlIIlIIl : this.mapUploadedSprites.values()) {
                final double lllllllllllllIIIllllIlIIIlIIlIII = 0.5 / lllllllllllllIIIllllIlIIIIlllIlI;
                final double lllllllllllllIIIllllIlIIIlIIIlll = 0.5 / lllllllllllllIIIllllIlIIIlIIlIlI;
                final double lllllllllllllIIIllllIlIIIlIIIllI = Math.min(lllllllllllllIIIllllIlIIIlIIlIIl.getMinU(), lllllllllllllIIIllllIlIIIlIIlIIl.getMaxU()) + lllllllllllllIIIllllIlIIIlIIlIII;
                final double lllllllllllllIIIllllIlIIIlIIIlIl = Math.min(lllllllllllllIIIllllIlIIIlIIlIIl.getMinV(), lllllllllllllIIIllllIlIIIlIIlIIl.getMaxV()) + lllllllllllllIIIllllIlIIIlIIIlll;
                final double lllllllllllllIIIllllIlIIIlIIIlII = Math.max(lllllllllllllIIIllllIlIIIlIIlIIl.getMinU(), lllllllllllllIIIllllIlIIIlIIlIIl.getMaxU()) - lllllllllllllIIIllllIlIIIlIIlIII;
                final double lllllllllllllIIIllllIlIIIlIIIIll = Math.max(lllllllllllllIIIllllIlIIIlIIlIIl.getMinV(), lllllllllllllIIIllllIlIIIlIIlIIl.getMaxV()) - lllllllllllllIIIllllIlIIIlIIIlll;
                final int lllllllllllllIIIllllIlIIIlIIIIlI = (int)(lllllllllllllIIIllllIlIIIlIIIllI / this.iconGridSizeU);
                final int lllllllllllllIIIllllIlIIIlIIIIIl = (int)(lllllllllllllIIIllllIlIIIlIIIlIl / this.iconGridSizeV);
                final int lllllllllllllIIIllllIlIIIlIIIIII = (int)(lllllllllllllIIIllllIlIIIlIIIlII / this.iconGridSizeU);
                final int lllllllllllllIIIllllIlIIIIllllll = (int)(lllllllllllllIIIllllIlIIIlIIIIll / this.iconGridSizeV);
                for (int lllllllllllllIIIllllIlIIIIlllllI = lllllllllllllIIIllllIlIIIlIIIIlI; lllllllllllllIIIllllIlIIIIlllllI <= lllllllllllllIIIllllIlIIIlIIIIII; ++lllllllllllllIIIllllIlIIIIlllllI) {
                    if (lllllllllllllIIIllllIlIIIIlllllI >= 0 && lllllllllllllIIIllllIlIIIIlllllI < this.iconGridCountX) {
                        for (int lllllllllllllIIIllllIlIIIIllllIl = lllllllllllllIIIllllIlIIIlIIIIIl; lllllllllllllIIIllllIlIIIIllllIl <= lllllllllllllIIIllllIlIIIIllllll; ++lllllllllllllIIIllllIlIIIIllllIl) {
                            if (lllllllllllllIIIllllIlIIIIllllIl >= 0 && lllllllllllllIIIllllIlIIIIllllIl < this.iconGridCountX) {
                                final int lllllllllllllIIIllllIlIIIIllllII = lllllllllllllIIIllllIlIIIIllllIl * this.iconGridCountX + lllllllllllllIIIllllIlIIIIlllllI;
                                this.iconGrid[lllllllllllllIIIllllIlIIIIllllII] = lllllllllllllIIIllllIlIIIlIIlIIl;
                            }
                            else {
                                Config.warn(String.valueOf(new StringBuilder("Invalid grid V: ").append(lllllllllllllIIIllllIlIIIIllllIl).append(", icon: ").append(lllllllllllllIIIllllIlIIIlIIlIIl.getIconName())));
                            }
                        }
                    }
                    else {
                        Config.warn(String.valueOf(new StringBuilder("Invalid grid U: ").append(lllllllllllllIIIllllIlIIIIlllllI).append(", icon: ").append(lllllllllllllIIIllllIlIIIlIIlIIl.getIconName())));
                    }
                }
            }
        }
    }
    
    public ResourceLocation completeResourceLocation(final ResourceLocation lllllllllllllIIIllllIlIlIIllIIlI) {
        return this.isAbsoluteLocation(lllllllllllllIIIllllIlIlIIllIIlI) ? new ResourceLocation(lllllllllllllIIIllllIlIlIIllIIlI.getResourceDomain(), String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIllllIlIlIIllIIlI.getResourcePath())).append(".png"))) : new ResourceLocation(lllllllllllllIIIllllIlIlIIllIIlI.getResourceDomain(), String.format("%s/%s%s", this.basePath, lllllllllllllIIIllllIlIlIIllIIlI.getResourcePath(), ".png"));
    }
    
    public int getMipmapLevels() {
        return this.mipmapLevels;
    }
    
    public TextureMap(final String lllllllllllllIIIllllIlIllllIIIII, final boolean lllllllllllllIIIllllIlIllllIIIlI) {
        this(lllllllllllllIIIllllIlIllllIIIII, null, lllllllllllllIIIllllIlIllllIIIlI);
    }
    
    public TextureAtlasSprite getRegisteredSprite(final ResourceLocation lllllllllllllIIIllllIlIIllIIllII) {
        return this.mapRegisteredSprites.get(lllllllllllllIIIllllIlIIllIIllII.toString());
    }
    
    public boolean generateMipmaps(final IResourceManager lllllllllllllIIIllllIlIlIlIlIlll, final TextureAtlasSprite lllllllllllllIIIllllIlIlIlIlIllI) {
        final ResourceLocation lllllllllllllIIIllllIlIlIlIlIlIl = this.getResourceLocation(lllllllllllllIIIllllIlIlIlIlIllI);
        IResource lllllllllllllIIIllllIlIlIlIlIlII = null;
        if (!lllllllllllllIIIllllIlIlIlIlIllI.hasCustomLoader(lllllllllllllIIIllllIlIlIlIlIlll, lllllllllllllIIIllllIlIlIlIlIlIl)) {
            try {
                lllllllllllllIIIllllIlIlIlIlIlII = lllllllllllllIIIllllIlIlIlIlIlll.getResource(lllllllllllllIIIllllIlIlIlIlIlIl);
                lllllllllllllIIIllllIlIlIlIlIllI.loadSpriteFrames(lllllllllllllIIIllllIlIlIlIlIlII, this.mipmapLevels + 1);
            }
            catch (RuntimeException lllllllllllllIIIllllIlIlIlIlIIII) {
                TextureMap.LOGGER.error("Unable to parse metadata from {}", (Object)lllllllllllllIIIllllIlIlIlIlIlIl, (Object)lllllllllllllIIIllllIlIlIlIlIIII);
                final boolean lllllllllllllIIIllllIlIlIlIlIIll = false;
            }
            catch (IOException lllllllllllllIIIllllIlIlIlIIllll) {
                TextureMap.LOGGER.error("Using missing texture, unable to load {}", (Object)lllllllllllllIIIllllIlIlIlIlIlIl, (Object)lllllllllllllIIIllllIlIlIlIIllll);
                final boolean lllllllllllllIIIllllIlIlIlIlIIlI = false;
                final boolean lllllllllllllIIIllllIlIlIlIIIIIl;
                final boolean lllllllllllllIIIllllIlIlIlIIlllI = lllllllllllllIIIllllIlIlIlIIIIIl = lllllllllllllIIIllllIlIlIlIlIIlI;
                return lllllllllllllIIIllllIlIlIlIIIIIl;
            }
            finally {
                IOUtils.closeQuietly((Closeable)lllllllllllllIIIllllIlIlIlIlIlII);
            }
            final boolean lllllllllllllIIIllllIlIlIlIlIIIl;
            return lllllllllllllIIIllllIlIlIlIlIIIl;
        }
        TextureUtils.generateCustomMipmaps(lllllllllllllIIIllllIlIlIlIlIllI, this.mipmapLevels);
        try {
            lllllllllllllIIIllllIlIlIlIlIllI.generateMipmaps(this.mipmapLevels);
            return true;
        }
        catch (Throwable lllllllllllllIIIllllIlIlIlIIllIl) {
            final CrashReport lllllllllllllIIIllllIlIlIlIIllII = CrashReport.makeCrashReport(lllllllllllllIIIllllIlIlIlIIllIl, "Applying mipmap");
            final CrashReportCategory lllllllllllllIIIllllIlIlIlIIlIll = lllllllllllllIIIllllIlIlIlIIllII.makeCategory("Sprite being mipmapped");
            lllllllllllllIIIllllIlIlIlIIlIll.setDetail("Sprite name", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    return lllllllllllllIIIllllIlIlIlIlIllI.getIconName();
                }
            });
            lllllllllllllIIIllllIlIlIlIIlIll.setDetail("Sprite size", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIllllIlIlIlIlIllI.getIconWidth())).append(" x ").append(lllllllllllllIIIllllIlIlIlIlIllI.getIconHeight()));
                }
            });
            lllllllllllllIIIllllIlIlIlIIlIll.setDetail("Sprite frames", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIllllIlIlIlIlIllI.getFrameCount())).append(" frames"));
                }
            });
            lllllllllllllIIIllllIlIlIlIIlIll.addCrashSection("Mipmap levels", this.mipmapLevels);
            throw new ReportedException(lllllllllllllIIIllllIlIlIlIIllII);
        }
    }
    
    public void updateAnimations() {
        if (Config.isShaders()) {
            ShadersTex.updatingTex = this.getMultiTexID();
        }
        boolean lllllllllllllIIIllllIlIlIIlIIIIl = false;
        boolean lllllllllllllIIIllllIlIlIIlIIIII = false;
        TextureUtil.bindTexture(this.getGlTextureId());
        for (final TextureAtlasSprite lllllllllllllIIIllllIlIlIIIlllll : this.listAnimatedSprites) {
            if (this.isTerrainAnimationActive(lllllllllllllIIIllllIlIlIIIlllll)) {
                lllllllllllllIIIllllIlIlIIIlllll.updateAnimation();
                if (lllllllllllllIIIllllIlIlIIIlllll.spriteNormal != null) {
                    lllllllllllllIIIllllIlIlIIlIIIIl = true;
                }
                if (lllllllllllllIIIllllIlIlIIIlllll.spriteSpecular == null) {
                    continue;
                }
                lllllllllllllIIIllllIlIlIIlIIIII = true;
            }
        }
        if (Config.isMultiTexture()) {
            for (final TextureAtlasSprite lllllllllllllIIIllllIlIlIIIllllI : this.listAnimatedSprites) {
                if (this.isTerrainAnimationActive(lllllllllllllIIIllllIlIlIIIllllI)) {
                    final TextureAtlasSprite lllllllllllllIIIllllIlIlIIIlllIl = lllllllllllllIIIllllIlIlIIIllllI.spriteSingle;
                    if (lllllllllllllIIIllllIlIlIIIlllIl == null) {
                        continue;
                    }
                    if (lllllllllllllIIIllllIlIlIIIllllI == TextureUtils.iconClock || lllllllllllllIIIllllIlIlIIIllllI == TextureUtils.iconCompass) {
                        lllllllllllllIIIllllIlIlIIIlllIl.frameCounter = lllllllllllllIIIllllIlIlIIIllllI.frameCounter;
                    }
                    lllllllllllllIIIllllIlIlIIIllllI.bindSpriteTexture();
                    lllllllllllllIIIllllIlIlIIIlllIl.updateAnimation();
                }
            }
            TextureUtil.bindTexture(this.getGlTextureId());
        }
        if (Config.isShaders()) {
            if (lllllllllllllIIIllllIlIlIIlIIIIl) {
                TextureUtil.bindTexture(this.getMultiTexID().norm);
                for (final TextureAtlasSprite lllllllllllllIIIllllIlIlIIIlllII : this.listAnimatedSprites) {
                    if (lllllllllllllIIIllllIlIlIIIlllII.spriteNormal != null && this.isTerrainAnimationActive(lllllllllllllIIIllllIlIlIIIlllII)) {
                        if (lllllllllllllIIIllllIlIlIIIlllII == TextureUtils.iconClock || lllllllllllllIIIllllIlIlIIIlllII == TextureUtils.iconCompass) {
                            lllllllllllllIIIllllIlIlIIIlllII.spriteNormal.frameCounter = lllllllllllllIIIllllIlIlIIIlllII.frameCounter;
                        }
                        lllllllllllllIIIllllIlIlIIIlllII.spriteNormal.updateAnimation();
                    }
                }
            }
            if (lllllllllllllIIIllllIlIlIIlIIIII) {
                TextureUtil.bindTexture(this.getMultiTexID().spec);
                for (final TextureAtlasSprite lllllllllllllIIIllllIlIlIIIllIll : this.listAnimatedSprites) {
                    if (lllllllllllllIIIllllIlIlIIIllIll.spriteSpecular != null && this.isTerrainAnimationActive(lllllllllllllIIIllllIlIlIIIllIll)) {
                        if (lllllllllllllIIIllllIlIlIIIllIll == TextureUtils.iconClock || lllllllllllllIIIllllIlIlIIIllIll == TextureUtils.iconCompass) {
                            lllllllllllllIIIllllIlIlIIIllIll.spriteNormal.frameCounter = lllllllllllllIIIllllIlIlIIIllIll.frameCounter;
                        }
                        lllllllllllllIIIllllIlIlIIIllIll.spriteSpecular.updateAnimation();
                    }
                }
            }
            if (lllllllllllllIIIllllIlIlIIlIIIIl || lllllllllllllIIIllllIlIlIIlIIIII) {
                TextureUtil.bindTexture(this.getGlTextureId());
            }
        }
        if (Config.isShaders()) {
            ShadersTex.updatingTex = null;
        }
    }
    
    public TextureAtlasSprite getSpriteSafe(final String lllllllllllllIIIllllIlIIllIlIIll) {
        final ResourceLocation lllllllllllllIIIllllIlIIllIlIlIl = new ResourceLocation(lllllllllllllIIIllllIlIIllIlIIll);
        return this.mapRegisteredSprites.get(lllllllllllllIIIllllIlIIllIlIlIl.toString());
    }
    
    public int getCountRegisteredSprites() {
        return this.counterIndexInMap;
    }
    
    public TextureAtlasSprite getMissingSprite() {
        return this.missingImage;
    }
    
    private boolean isTerrainAnimationActive(final TextureAtlasSprite lllllllllllllIIIllllIlIIllIIlIIl) {
        if (lllllllllllllIIIllllIlIIllIIlIIl == TextureUtils.iconWaterStill || lllllllllllllIIIllllIlIIllIIlIIl == TextureUtils.iconWaterFlow) {
            return Config.isAnimatedWater();
        }
        if (lllllllllllllIIIllllIlIIllIIlIIl == TextureUtils.iconLavaStill || lllllllllllllIIIllllIlIIllIIlIIl == TextureUtils.iconLavaFlow) {
            return Config.isAnimatedLava();
        }
        if (lllllllllllllIIIllllIlIIllIIlIIl == TextureUtils.iconFireLayer0 || lllllllllllllIIIllllIlIIllIIlIIl == TextureUtils.iconFireLayer1) {
            return Config.isAnimatedFire();
        }
        if (lllllllllllllIIIllllIlIIllIIlIIl == TextureUtils.iconPortal) {
            return Config.isAnimatedPortal();
        }
        return lllllllllllllIIIllllIlIIllIIlIIl == TextureUtils.iconClock || lllllllllllllIIIllllIlIIllIIlIIl == TextureUtils.iconCompass || Config.isAnimatedTerrain();
    }
    
    public String getBasePath() {
        return this.basePath;
    }
    
    public void loadTextureAtlas(final IResourceManager lllllllllllllIIIllllIlIlIlllIlII) {
        ShadersTex.resManager = lllllllllllllIIIllllIlIlIlllIlII;
        Config.dbg(String.valueOf(new StringBuilder("Multitexture: ").append(Config.isMultiTexture())));
        if (Config.isMultiTexture()) {
            for (final TextureAtlasSprite lllllllllllllIIIllllIlIllIIllIll : this.mapUploadedSprites.values()) {
                lllllllllllllIIIllllIlIllIIllIll.deleteSpriteTexture();
            }
        }
        ConnectedTextures.updateIcons(this);
        CustomItems.updateIcons(this);
        BetterGrass.updateIcons(this);
        final int lllllllllllllIIIllllIlIllIIllIlI = TextureUtils.getGLMaximumTextureSize();
        final Stitcher lllllllllllllIIIllllIlIllIIllIIl = new Stitcher(lllllllllllllIIIllllIlIllIIllIlI, lllllllllllllIIIllllIlIllIIllIlI, 0, this.mipmapLevels);
        this.mapUploadedSprites.clear();
        this.listAnimatedSprites.clear();
        int lllllllllllllIIIllllIlIllIIllIII = Integer.MAX_VALUE;
        final int lllllllllllllIIIllllIlIllIIlIlll = this.getMinSpriteSize();
        this.iconGridSize = lllllllllllllIIIllllIlIllIIlIlll;
        int lllllllllllllIIIllllIlIllIIlIllI = 1 << this.mipmapLevels;
        final List<TextureAtlasSprite> lllllllllllllIIIllllIlIllIIlIlIl = new ArrayList<TextureAtlasSprite>(this.mapRegisteredSprites.values());
        for (int lllllllllllllIIIllllIlIllIIlIlII = 0; lllllllllllllIIIllllIlIllIIlIlII < lllllllllllllIIIllllIlIllIIlIlIl.size(); ++lllllllllllllIIIllllIlIllIIlIlII) {
            final TextureAtlasSprite lllllllllllllIIIllllIlIllIIlIIll = SpriteDependencies.resolveDependencies(lllllllllllllIIIllllIlIllIIlIlIl, lllllllllllllIIIllllIlIllIIlIlII, this);
            final ResourceLocation lllllllllllllIIIllllIlIllIIlIIlI = this.getResourceLocation(lllllllllllllIIIllllIlIllIIlIIll);
            IResource lllllllllllllIIIllllIlIllIIlIIIl = null;
            if (lllllllllllllIIIllllIlIllIIlIIll.getIndexInMap() < 0) {
                lllllllllllllIIIllllIlIllIIlIIll.setIndexInMap(this.counterIndexInMap++);
            }
            if (lllllllllllllIIIllllIlIllIIlIIll.hasCustomLoader(lllllllllllllIIIllllIlIlIlllIlII, lllllllllllllIIIllllIlIllIIlIIlI)) {
                if (lllllllllllllIIIllllIlIllIIlIIll.load(lllllllllllllIIIllllIlIlIlllIlII, lllllllllllllIIIllllIlIllIIlIIlI, lllllllllllllIIIllllIlIIIIIlIlII -> this.mapRegisteredSprites.get(lllllllllllllIIIllllIlIIIIIlIlII.toString()))) {
                    Config.dbg(String.valueOf(new StringBuilder("Custom loader (skipped): ").append(lllllllllllllIIIllllIlIllIIlIIll)));
                    continue;
                }
                Config.dbg(String.valueOf(new StringBuilder("Custom loader: ").append(lllllllllllllIIIllllIlIllIIlIIll)));
            }
            else {
                try {
                    final PngSizeInfo lllllllllllllIIIllllIlIllIIlIIII = PngSizeInfo.makeFromResource(lllllllllllllIIIllllIlIlIlllIlII.getResource(lllllllllllllIIIllllIlIllIIlIIlI));
                    if (Config.isShaders()) {
                        lllllllllllllIIIllllIlIllIIlIIIl = ShadersTex.loadResource(lllllllllllllIIIllllIlIlIlllIlII, lllllllllllllIIIllllIlIllIIlIIlI);
                    }
                    else {
                        lllllllllllllIIIllllIlIllIIlIIIl = lllllllllllllIIIllllIlIlIlllIlII.getResource(lllllllllllllIIIllllIlIllIIlIIlI);
                    }
                    final boolean lllllllllllllIIIllllIlIllIIIllll = lllllllllllllIIIllllIlIllIIlIIIl.getMetadata("animation") != null;
                    lllllllllllllIIIllllIlIllIIlIIll.loadSprite(lllllllllllllIIIllllIlIllIIlIIII, lllllllllllllIIIllllIlIllIIIllll);
                }
                catch (RuntimeException lllllllllllllIIIllllIlIllIIIlllI) {
                    TextureMap.LOGGER.error("Unable to parse metadata from {}", (Object)lllllllllllllIIIllllIlIllIIlIIlI, (Object)lllllllllllllIIIllllIlIllIIIlllI);
                    ReflectorForge.FMLClientHandler_trackBrokenTexture(lllllllllllllIIIllllIlIllIIlIIlI, lllllllllllllIIIllllIlIllIIIlllI.getMessage());
                }
                catch (IOException lllllllllllllIIIllllIlIllIIIllIl) {
                    TextureMap.LOGGER.error(String.valueOf(new StringBuilder("Using missing texture, unable to load ").append(lllllllllllllIIIllllIlIllIIlIIlI).append(", ").append(lllllllllllllIIIllllIlIllIIIllIl.getClass().getName())));
                    ReflectorForge.FMLClientHandler_trackMissingTexture(lllllllllllllIIIllllIlIllIIlIIlI);
                }
                finally {
                    IOUtils.closeQuietly((Closeable)lllllllllllllIIIllllIlIllIIlIIIl);
                }
                IOUtils.closeQuietly((Closeable)lllllllllllllIIIllllIlIllIIlIIIl);
            }
            final int lllllllllllllIIIllllIlIllIIIllII = lllllllllllllIIIllllIlIllIIlIIll.getIconWidth();
            final int lllllllllllllIIIllllIlIllIIIlIll = lllllllllllllIIIllllIlIllIIlIIll.getIconHeight();
            if (lllllllllllllIIIllllIlIllIIIllII >= 1 && lllllllllllllIIIllllIlIllIIIlIll >= 1) {
                if (lllllllllllllIIIllllIlIllIIIllII < lllllllllllllIIIllllIlIllIIlIlll || this.mipmapLevels > 0) {
                    final int lllllllllllllIIIllllIlIllIIIlIlI = (this.mipmapLevels > 0) ? TextureUtils.scaleToPowerOfTwo(lllllllllllllIIIllllIlIllIIIllII, lllllllllllllIIIllllIlIllIIlIlll) : TextureUtils.scaleMinTo(lllllllllllllIIIllllIlIllIIIllII, lllllllllllllIIIllllIlIllIIlIlll);
                    if (lllllllllllllIIIllllIlIllIIIlIlI != lllllllllllllIIIllllIlIllIIIllII) {
                        if (!TextureUtils.isPowerOfTwo(lllllllllllllIIIllllIlIllIIIllII)) {
                            Config.log(String.valueOf(new StringBuilder("Scaled non power of 2: ").append(lllllllllllllIIIllllIlIllIIlIIll.getIconName()).append(", ").append(lllllllllllllIIIllllIlIllIIIllII).append(" -> ").append(lllllllllllllIIIllllIlIllIIIlIlI)));
                        }
                        else {
                            Config.log(String.valueOf(new StringBuilder("Scaled too small texture: ").append(lllllllllllllIIIllllIlIllIIlIIll.getIconName()).append(", ").append(lllllllllllllIIIllllIlIllIIIllII).append(" -> ").append(lllllllllllllIIIllllIlIllIIIlIlI)));
                        }
                        final int lllllllllllllIIIllllIlIllIIIlIIl = lllllllllllllIIIllllIlIllIIIlIll * lllllllllllllIIIllllIlIllIIIlIlI / lllllllllllllIIIllllIlIllIIIllII;
                        lllllllllllllIIIllllIlIllIIlIIll.setIconWidth(lllllllllllllIIIllllIlIllIIIlIlI);
                        lllllllllllllIIIllllIlIllIIlIIll.setIconHeight(lllllllllllllIIIllllIlIllIIIlIIl);
                    }
                }
                lllllllllllllIIIllllIlIllIIllIII = Math.min(lllllllllllllIIIllllIlIllIIllIII, Math.min(lllllllllllllIIIllllIlIllIIlIIll.getIconWidth(), lllllllllllllIIIllllIlIllIIlIIll.getIconHeight()));
                final int lllllllllllllIIIllllIlIllIIIlIII = Math.min(Integer.lowestOneBit(lllllllllllllIIIllllIlIllIIlIIll.getIconWidth()), Integer.lowestOneBit(lllllllllllllIIIllllIlIllIIlIIll.getIconHeight()));
                if (lllllllllllllIIIllllIlIllIIIlIII < lllllllllllllIIIllllIlIllIIlIllI) {
                    TextureMap.LOGGER.warn("Texture {} with size {}x{} limits mip level from {} to {}", (Object)lllllllllllllIIIllllIlIllIIlIIlI, (Object)lllllllllllllIIIllllIlIllIIlIIll.getIconWidth(), (Object)lllllllllllllIIIllllIlIllIIlIIll.getIconHeight(), (Object)MathHelper.log2(lllllllllllllIIIllllIlIllIIlIllI), (Object)MathHelper.log2(lllllllllllllIIIllllIlIllIIIlIII));
                    lllllllllllllIIIllllIlIllIIlIllI = lllllllllllllIIIllllIlIllIIIlIII;
                }
                if (this.generateMipmaps(lllllllllllllIIIllllIlIlIlllIlII, lllllllllllllIIIllllIlIllIIlIIll)) {
                    lllllllllllllIIIllllIlIllIIllIIl.addSprite(lllllllllllllIIIllllIlIllIIlIIll);
                }
            }
            else {
                Config.warn(String.valueOf(new StringBuilder("Invalid sprite size: ").append(lllllllllllllIIIllllIlIllIIlIIll)));
            }
        }
        final int lllllllllllllIIIllllIlIllIIIIlll = Math.min(lllllllllllllIIIllllIlIllIIllIII, lllllllllllllIIIllllIlIllIIlIllI);
        int lllllllllllllIIIllllIlIllIIIIllI = MathHelper.log2(lllllllllllllIIIllllIlIllIIIIlll);
        if (lllllllllllllIIIllllIlIllIIIIllI < 0) {
            lllllllllllllIIIllllIlIllIIIIllI = 0;
        }
        if (lllllllllllllIIIllllIlIllIIIIllI < this.mipmapLevels) {
            TextureMap.LOGGER.warn("{}: dropping miplevel from {} to {}, because of minimum power of two: {}", (Object)this.basePath, (Object)this.mipmapLevels, (Object)lllllllllllllIIIllllIlIllIIIIllI, (Object)lllllllllllllIIIllllIlIllIIIIlll);
            this.mipmapLevels = lllllllllllllIIIllllIlIllIIIIllI;
        }
        this.missingImage.generateMipmaps(this.mipmapLevels);
        lllllllllllllIIIllllIlIllIIllIIl.addSprite(this.missingImage);
        try {
            lllllllllllllIIIllllIlIllIIllIIl.doStitch();
        }
        catch (StitcherException lllllllllllllIIIllllIlIllIIIIlIl) {
            throw lllllllllllllIIIllllIlIllIIIIlIl;
        }
        TextureMap.LOGGER.info("Created: {}x{} {}-atlas", (Object)lllllllllllllIIIllllIlIllIIllIIl.getCurrentWidth(), (Object)lllllllllllllIIIllllIlIllIIllIIl.getCurrentHeight(), (Object)this.basePath);
        if (Config.isShaders()) {
            ShadersTex.allocateTextureMap(this.getGlTextureId(), this.mipmapLevels, lllllllllllllIIIllllIlIllIIllIIl.getCurrentWidth(), lllllllllllllIIIllllIlIllIIllIIl.getCurrentHeight(), lllllllllllllIIIllllIlIllIIllIIl, this);
        }
        else {
            TextureUtil.allocateTextureImpl(this.getGlTextureId(), this.mipmapLevels, lllllllllllllIIIllllIlIllIIllIIl.getCurrentWidth(), lllllllllllllIIIllllIlIllIIllIIl.getCurrentHeight());
        }
        final Map<String, TextureAtlasSprite> lllllllllllllIIIllllIlIllIIIIlII = (Map<String, TextureAtlasSprite>)Maps.newHashMap((Map)this.mapRegisteredSprites);
        for (final TextureAtlasSprite lllllllllllllIIIllllIlIllIIIIIll : lllllllllllllIIIllllIlIllIIllIIl.getStichSlots()) {
            if (Config.isShaders()) {
                ShadersTex.setIconName(ShadersTex.setSprite(lllllllllllllIIIllllIlIllIIIIIll).getIconName());
            }
            final String lllllllllllllIIIllllIlIllIIIIIlI = lllllllllllllIIIllllIlIllIIIIIll.getIconName();
            lllllllllllllIIIllllIlIllIIIIlII.remove(lllllllllllllIIIllllIlIllIIIIIlI);
            this.mapUploadedSprites.put(lllllllllllllIIIllllIlIllIIIIIlI, lllllllllllllIIIllllIlIllIIIIIll);
            try {
                if (Config.isShaders()) {
                    ShadersTex.uploadTexSubForLoadAtlas(lllllllllllllIIIllllIlIllIIIIIll.getFrameTextureData(0), lllllllllllllIIIllllIlIllIIIIIll.getIconWidth(), lllllllllllllIIIllllIlIllIIIIIll.getIconHeight(), lllllllllllllIIIllllIlIllIIIIIll.getOriginX(), lllllllllllllIIIllllIlIllIIIIIll.getOriginY(), false, false);
                }
                else {
                    TextureUtil.uploadTextureMipmap(lllllllllllllIIIllllIlIllIIIIIll.getFrameTextureData(0), lllllllllllllIIIllllIlIllIIIIIll.getIconWidth(), lllllllllllllIIIllllIlIllIIIIIll.getIconHeight(), lllllllllllllIIIllllIlIllIIIIIll.getOriginX(), lllllllllllllIIIllllIlIllIIIIIll.getOriginY(), false, false);
                }
            }
            catch (Throwable lllllllllllllIIIllllIlIllIIIIIIl) {
                final CrashReport lllllllllllllIIIllllIlIllIIIIIII = CrashReport.makeCrashReport(lllllllllllllIIIllllIlIllIIIIIIl, "Stitching texture atlas");
                final CrashReportCategory lllllllllllllIIIllllIlIlIlllllll = lllllllllllllIIIllllIlIllIIIIIII.makeCategory("Texture being stitched together");
                lllllllllllllIIIllllIlIlIlllllll.addCrashSection("Atlas path", this.basePath);
                lllllllllllllIIIllllIlIlIlllllll.addCrashSection("Sprite", lllllllllllllIIIllllIlIllIIIIIll);
                throw new ReportedException(lllllllllllllIIIllllIlIllIIIIIII);
            }
            if (lllllllllllllIIIllllIlIllIIIIIll.hasAnimationMetadata()) {
                this.listAnimatedSprites.add(lllllllllllllIIIllllIlIllIIIIIll);
            }
        }
        for (final TextureAtlasSprite lllllllllllllIIIllllIlIlIllllllI : lllllllllllllIIIllllIlIllIIIIlII.values()) {
            lllllllllllllIIIllllIlIlIllllllI.copyFrom(this.missingImage);
        }
        if (Config.isMultiTexture()) {
            final int lllllllllllllIIIllllIlIlIlllllIl = lllllllllllllIIIllllIlIllIIllIIl.getCurrentWidth();
            final int lllllllllllllIIIllllIlIlIlllllII = lllllllllllllIIIllllIlIllIIllIIl.getCurrentHeight();
            for (final TextureAtlasSprite lllllllllllllIIIllllIlIlIllllIll : lllllllllllllIIIllllIlIllIIllIIl.getStichSlots()) {
                lllllllllllllIIIllllIlIlIllllIll.sheetWidth = lllllllllllllIIIllllIlIlIlllllIl;
                lllllllllllllIIIllllIlIlIllllIll.sheetHeight = lllllllllllllIIIllllIlIlIlllllII;
                lllllllllllllIIIllllIlIlIllllIll.mipmapLevels = this.mipmapLevels;
                final TextureAtlasSprite lllllllllllllIIIllllIlIlIllllIlI = lllllllllllllIIIllllIlIlIllllIll.spriteSingle;
                if (lllllllllllllIIIllllIlIlIllllIlI != null) {
                    if (lllllllllllllIIIllllIlIlIllllIlI.getIconWidth() <= 0) {
                        lllllllllllllIIIllllIlIlIllllIlI.setIconWidth(lllllllllllllIIIllllIlIlIllllIll.getIconWidth());
                        lllllllllllllIIIllllIlIlIllllIlI.setIconHeight(lllllllllllllIIIllllIlIlIllllIll.getIconHeight());
                        lllllllllllllIIIllllIlIlIllllIlI.initSprite(lllllllllllllIIIllllIlIlIllllIll.getIconWidth(), lllllllllllllIIIllllIlIlIllllIll.getIconHeight(), 0, 0, false);
                        lllllllllllllIIIllllIlIlIllllIlI.clearFramesTextureData();
                        final List<int[][]> lllllllllllllIIIllllIlIlIllllIIl = lllllllllllllIIIllllIlIlIllllIll.getFramesTextureData();
                        lllllllllllllIIIllllIlIlIllllIlI.setFramesTextureData(lllllllllllllIIIllllIlIlIllllIIl);
                        lllllllllllllIIIllllIlIlIllllIlI.setAnimationMetadata(lllllllllllllIIIllllIlIlIllllIll.getAnimationMetadata());
                    }
                    lllllllllllllIIIllllIlIlIllllIlI.sheetWidth = lllllllllllllIIIllllIlIlIlllllIl;
                    lllllllllllllIIIllllIlIlIllllIlI.sheetHeight = lllllllllllllIIIllllIlIlIlllllII;
                    lllllllllllllIIIllllIlIlIllllIlI.mipmapLevels = this.mipmapLevels;
                    lllllllllllllIIIllllIlIlIllllIll.bindSpriteTexture();
                    final boolean lllllllllllllIIIllllIlIlIllllIII = false;
                    final boolean lllllllllllllIIIllllIlIlIlllIlll = true;
                    try {
                        TextureUtil.uploadTextureMipmap(lllllllllllllIIIllllIlIlIllllIlI.getFrameTextureData(0), lllllllllllllIIIllllIlIlIllllIlI.getIconWidth(), lllllllllllllIIIllllIlIlIllllIlI.getIconHeight(), lllllllllllllIIIllllIlIlIllllIlI.getOriginX(), lllllllllllllIIIllllIlIlIllllIlI.getOriginY(), lllllllllllllIIIllllIlIlIllllIII, lllllllllllllIIIllllIlIlIlllIlll);
                    }
                    catch (Exception lllllllllllllIIIllllIlIlIlllIllI) {
                        Config.dbg(String.valueOf(new StringBuilder("Error uploading sprite single: ").append(lllllllllllllIIIllllIlIlIllllIlI).append(", parent: ").append(lllllllllllllIIIllllIlIlIllllIll)));
                        lllllllllllllIIIllllIlIlIlllIllI.printStackTrace();
                    }
                }
            }
            Config.getMinecraft().getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        }
        Reflector.callVoid(Reflector.ForgeHooksClient_onTextureStitchedPost, this);
        this.updateIconGrid(lllllllllllllIIIllllIlIllIIllIIl.getCurrentWidth(), lllllllllllllIIIllllIlIllIIllIIl.getCurrentHeight());
        if (Config.equals(System.getProperty("saveTextureMap"), "true")) {
            Config.dbg(String.valueOf(new StringBuilder("Exporting texture map: ").append(this.basePath)));
            TextureUtils.saveGlTexture(String.valueOf(new StringBuilder("debug/").append(this.basePath.replaceAll("/", "_"))), this.getGlTextureId(), this.mipmapLevels, lllllllllllllIIIllllIlIllIIllIIl.getCurrentWidth(), lllllllllllllIIIllllIlIllIIllIIl.getCurrentHeight());
        }
    }
    
    @Override
    public void loadTexture(final IResourceManager lllllllllllllIIIllllIlIllIlllIlI) throws IOException {
        ShadersTex.resManager = lllllllllllllIIIllllIlIllIlllIlI;
        if (this.iconCreator != null) {
            this.loadSprites(lllllllllllllIIIllllIlIllIlllIlI, this.iconCreator);
        }
    }
    
    public TextureMap(final String lllllllllllllIIIllllIlIllllIlIII) {
        this(lllllllllllllIIIllllIlIllllIlIII, null);
    }
    
    public TextureAtlasSprite getIconByUV(final double lllllllllllllIIIllllIlIIIIIlllII, final double lllllllllllllIIIllllIlIIIIlIIIIl) {
        if (this.iconGrid == null) {
            return null;
        }
        final int lllllllllllllIIIllllIlIIIIlIIIII = (int)(lllllllllllllIIIllllIlIIIIIlllII / this.iconGridSizeU);
        final int lllllllllllllIIIllllIlIIIIIlllll = (int)(lllllllllllllIIIllllIlIIIIlIIIIl / this.iconGridSizeV);
        final int lllllllllllllIIIllllIlIIIIIllllI = lllllllllllllIIIllllIlIIIIIlllll * this.iconGridCountX + lllllllllllllIIIllllIlIIIIlIIIII;
        return (lllllllllllllIIIllllIlIIIIIllllI >= 0 && lllllllllllllIIIllllIlIIIIIllllI <= this.iconGrid.length) ? this.iconGrid[lllllllllllllIIIllllIlIIIIIllllI] : null;
    }
}
