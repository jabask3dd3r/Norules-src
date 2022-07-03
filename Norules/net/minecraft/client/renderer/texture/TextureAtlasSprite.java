package net.minecraft.client.renderer.texture;

import shadersmod.client.*;
import optifine.*;
import net.minecraft.client.resources.data.*;
import java.awt.image.*;
import java.io.*;
import net.minecraft.client.resources.*;
import java.util.function.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;
import com.google.common.collect.*;
import java.util.*;

public class TextureAtlasSprite
{
    protected /* synthetic */ boolean rotated;
    public /* synthetic */ boolean isSpriteSingle;
    protected /* synthetic */ int originY;
    public /* synthetic */ float baseU;
    public /* synthetic */ TextureAtlasSprite spriteSingle;
    public /* synthetic */ float baseV;
    public /* synthetic */ int sheetWidth;
    protected /* synthetic */ int originX;
    public /* synthetic */ TextureAtlasSprite spriteSpecular;
    private /* synthetic */ float maxU;
    public /* synthetic */ int mipmapLevels;
    public /* synthetic */ int sheetHeight;
    public /* synthetic */ boolean isShadersSprite;
    protected /* synthetic */ int tickCounter;
    private /* synthetic */ int indexInMap;
    public /* synthetic */ TextureAtlasSprite spriteNormal;
    private /* synthetic */ AnimationMetadataSection animationMetadata;
    protected /* synthetic */ List<int[][]> framesTextureData;
    protected /* synthetic */ int[][] interpolatedFrameData;
    public /* synthetic */ boolean isDependencyParent;
    protected /* synthetic */ int height;
    private /* synthetic */ float maxV;
    private final /* synthetic */ String iconName;
    private /* synthetic */ float minV;
    public /* synthetic */ int glSpriteTextureId;
    private /* synthetic */ float minU;
    protected /* synthetic */ int width;
    protected /* synthetic */ int frameCounter;
    
    public double getSpriteU16(final float llllllllllllllIlIllIIIIllIlllIIl) {
        final float llllllllllllllIlIllIIIIllIllllII = this.maxU - this.minU;
        return (llllllllllllllIlIllIIIIllIlllIIl - this.minU) / llllllllllllllIlIllIIIIllIllllII * 16.0f;
    }
    
    public void setIndexInMap(final int llllllllllllllIlIllIIIIlllllllIl) {
        this.indexInMap = llllllllllllllIlIllIIIIlllllllIl;
    }
    
    public void initSprite(final int llllllllllllllIlIllIIIllIIllIllI, final int llllllllllllllIlIllIIIllIIllIlIl, final int llllllllllllllIlIllIIIllIIllIlII, final int llllllllllllllIlIllIIIllIIlllIll, final boolean llllllllllllllIlIllIIIllIIllIIlI) {
        this.originX = llllllllllllllIlIllIIIllIIllIlII;
        this.originY = llllllllllllllIlIllIIIllIIlllIll;
        this.rotated = llllllllllllllIlIllIIIllIIllIIlI;
        final float llllllllllllllIlIllIIIllIIlllIIl = (float)(0.009999999776482582 / llllllllllllllIlIllIIIllIIllIllI);
        final float llllllllllllllIlIllIIIllIIlllIII = (float)(0.009999999776482582 / llllllllllllllIlIllIIIllIIllIlIl);
        this.minU = llllllllllllllIlIllIIIllIIllIlII / (float)llllllllllllllIlIllIIIllIIllIllI + llllllllllllllIlIllIIIllIIlllIIl;
        this.maxU = (llllllllllllllIlIllIIIllIIllIlII + this.width) / (float)llllllllllllllIlIllIIIllIIllIllI - llllllllllllllIlIllIIIllIIlllIIl;
        this.minV = llllllllllllllIlIllIIIllIIlllIll / (float)llllllllllllllIlIllIIIllIIllIlIl + llllllllllllllIlIllIIIllIIlllIII;
        this.maxV = (llllllllllllllIlIllIIIllIIlllIll + this.height) / (float)llllllllllllllIlIllIIIllIIllIlIl - llllllllllllllIlIllIIIllIIlllIII;
        this.baseU = Math.min(this.minU, this.maxU);
        this.baseV = Math.min(this.minV, this.maxV);
        if (this.spriteSingle != null) {
            this.spriteSingle.initSprite(this.width, this.height, 0, 0, false);
        }
    }
    
    public void setAnimationMetadata(final AnimationMetadataSection llllllllllllllIlIllIIIIlIlIIllll) {
        this.animationMetadata = llllllllllllllIlIllIIIIlIlIIllll;
    }
    
    private void allocateFrameTextureData(final int llllllllllllllIlIllIIIlIIIllIlll) {
        if (this.framesTextureData.size() <= llllllllllllllIlIllIIIlIIIllIlll) {
            for (int llllllllllllllIlIllIIIlIIIllIllI = this.framesTextureData.size(); llllllllllllllIlIllIIIlIIIllIllI <= llllllllllllllIlIllIIIlIIIllIlll; ++llllllllllllllIlIllIIIlIIIllIllI) {
                this.framesTextureData.add(null);
            }
        }
        if (this.spriteSingle != null) {
            this.spriteSingle.allocateFrameTextureData(llllllllllllllIlIllIIIlIIIllIlll);
        }
    }
    
    public double getSpriteV16(final float llllllllllllllIlIllIIIIllIlIlIll) {
        final float llllllllllllllIlIllIIIIllIlIlIlI = this.maxV - this.minV;
        return (llllllllllllllIlIllIIIIllIlIlIll - this.minV) / llllllllllllllIlIllIIIIllIlIlIlI * 16.0f;
    }
    
    public float getMinU() {
        return this.minU;
    }
    
    public float getMinV() {
        return this.minV;
    }
    
    private void loadShadersSprites() {
        if (Shaders.configNormalMap) {
            final String llllllllllllllIlIllIIIIlIIlllIIl = String.valueOf(new StringBuilder(String.valueOf(this.iconName)).append("_n"));
            ResourceLocation llllllllllllllIlIllIIIIlIIllIlll = new ResourceLocation(llllllllllllllIlIllIIIIlIIlllIIl);
            llllllllllllllIlIllIIIIlIIllIlll = Config.getTextureMap().completeResourceLocation(llllllllllllllIlIllIIIIlIIllIlll);
            if (Config.hasResource(llllllllllllllIlIllIIIIlIIllIlll)) {
                this.spriteNormal = new TextureAtlasSprite(llllllllllllllIlIllIIIIlIIlllIIl);
                this.spriteNormal.isShadersSprite = true;
                this.spriteNormal.copyFrom(this);
                Config.getTextureMap().generateMipmaps(Config.getResourceManager(), this.spriteNormal);
            }
        }
        if (Shaders.configSpecularMap) {
            final String llllllllllllllIlIllIIIIlIIllIllI = String.valueOf(new StringBuilder(String.valueOf(this.iconName)).append("_s"));
            ResourceLocation llllllllllllllIlIllIIIIlIIllIlIl = new ResourceLocation(llllllllllllllIlIllIIIIlIIllIllI);
            llllllllllllllIlIllIIIIlIIllIlIl = Config.getTextureMap().completeResourceLocation(llllllllllllllIlIllIIIIlIIllIlIl);
            if (Config.hasResource(llllllllllllllIlIllIIIIlIIllIlIl)) {
                this.spriteSpecular = new TextureAtlasSprite(llllllllllllllIlIllIIIIlIIllIllI);
                this.spriteSpecular.isShadersSprite = true;
                this.spriteSpecular.copyFrom(this);
                Config.getTextureMap().generateMipmaps(Config.getResourceManager(), this.spriteSpecular);
            }
        }
    }
    
    public float toSingleV(float llllllllllllllIlIllIIIIlIlllIIlI) {
        llllllllllllllIlIllIIIIlIlllIIlI -= this.baseV;
        final float llllllllllllllIlIllIIIIlIlllIlIl = this.sheetHeight / (float)this.height;
        llllllllllllllIlIllIIIIlIlllIIlI *= llllllllllllllIlIllIIIIlIlllIlIl;
        return llllllllllllllIlIllIIIIlIlllIIlI;
    }
    
    public void deleteSpriteTexture() {
        if (this.glSpriteTextureId >= 0) {
            TextureUtil.deleteTexture(this.glSpriteTextureId);
            this.glSpriteTextureId = -1;
        }
    }
    
    public float getMaxV() {
        return this.maxV;
    }
    
    public void loadSpriteFrames(final IResource llllllllllllllIlIllIIIlIIllIlIll, final int llllllllllllllIlIllIIIlIIllllIlI) throws IOException {
        BufferedImage llllllllllllllIlIllIIIlIIllllIIl = TextureUtil.readBufferedImage(llllllllllllllIlIllIIIlIIllIlIll.getInputStream());
        if (this.width != llllllllllllllIlIllIIIlIIllllIIl.getWidth()) {
            llllllllllllllIlIllIIIlIIllllIIl = TextureUtils.scaleImage(llllllllllllllIlIllIIIlIIllllIIl, this.width);
        }
        final AnimationMetadataSection llllllllllllllIlIllIIIlIIllllIII = llllllllllllllIlIllIIIlIIllIlIll.getMetadata("animation");
        final int[][] llllllllllllllIlIllIIIlIIlllIlll = new int[llllllllllllllIlIllIIIlIIllllIlI][];
        llllllllllllllIlIllIIIlIIlllIlll[0] = new int[llllllllllllllIlIllIIIlIIllllIIl.getWidth() * llllllllllllllIlIllIIIlIIllllIIl.getHeight()];
        llllllllllllllIlIllIIIlIIllllIIl.getRGB(0, 0, llllllllllllllIlIllIIIlIIllllIIl.getWidth(), llllllllllllllIlIllIIIlIIllllIIl.getHeight(), llllllllllllllIlIllIIIlIIlllIlll[0], 0, llllllllllllllIlIllIIIlIIllllIIl.getWidth());
        if (llllllllllllllIlIllIIIlIIllllIII == null) {
            this.framesTextureData.add(llllllllllllllIlIllIIIlIIlllIlll);
        }
        else {
            final int llllllllllllllIlIllIIIlIIlllIllI = llllllllllllllIlIllIIIlIIllllIIl.getHeight() / this.width;
            if (llllllllllllllIlIllIIIlIIllllIII.getFrameCount() > 0) {
                for (final int llllllllllllllIlIllIIIlIIlllIlII : llllllllllllllIlIllIIIlIIllllIII.getFrameIndexSet()) {
                    if (llllllllllllllIlIllIIIlIIlllIlII >= llllllllllllllIlIllIIIlIIlllIllI) {
                        throw new RuntimeException(String.valueOf(new StringBuilder("invalid frameindex ").append(llllllllllllllIlIllIIIlIIlllIlII)));
                    }
                    this.allocateFrameTextureData(llllllllllllllIlIllIIIlIIlllIlII);
                    this.framesTextureData.set(llllllllllllllIlIllIIIlIIlllIlII, getFrameTextureData(llllllllllllllIlIllIIIlIIlllIlll, this.width, this.width, llllllllllllllIlIllIIIlIIlllIlII));
                }
                this.animationMetadata = llllllllllllllIlIllIIIlIIllllIII;
            }
            else {
                final List<AnimationFrame> llllllllllllllIlIllIIIlIIlllIIll = (List<AnimationFrame>)Lists.newArrayList();
                for (int llllllllllllllIlIllIIIlIIlllIIlI = 0; llllllllllllllIlIllIIIlIIlllIIlI < llllllllllllllIlIllIIIlIIlllIllI; ++llllllllllllllIlIllIIIlIIlllIIlI) {
                    this.framesTextureData.add(getFrameTextureData(llllllllllllllIlIllIIIlIIlllIlll, this.width, this.width, llllllllllllllIlIllIIIlIIlllIIlI));
                    llllllllllllllIlIllIIIlIIlllIIll.add(new AnimationFrame(llllllllllllllIlIllIIIlIIlllIIlI, -1));
                }
                this.animationMetadata = new AnimationMetadataSection(llllllllllllllIlIllIIIlIIlllIIll, this.width, this.height, llllllllllllllIlIllIIIlIIllllIII.getFrameTime(), llllllllllllllIlIllIIIlIIllllIII.isInterpolate());
            }
        }
        if (!this.isShadersSprite) {
            if (Config.isShaders()) {
                this.loadShadersSprites();
            }
            for (int llllllllllllllIlIllIIIlIIlllIIIl = 0; llllllllllllllIlIllIIIlIIlllIIIl < this.framesTextureData.size(); ++llllllllllllllIlIllIIIlIIlllIIIl) {
                final int[][] llllllllllllllIlIllIIIlIIlllIIII = this.framesTextureData.get(llllllllllllllIlIllIIIlIIlllIIIl);
                if (llllllllllllllIlIllIIIlIIlllIIII != null && !this.iconName.startsWith("minecraft:blocks/leaves_")) {
                    for (int llllllllllllllIlIllIIIlIIllIllll = 0; llllllllllllllIlIllIIIlIIllIllll < llllllllllllllIlIllIIIlIIlllIIII.length; ++llllllllllllllIlIllIIIlIIllIllll) {
                        final int[] llllllllllllllIlIllIIIlIIllIlllI = llllllllllllllIlIllIIIlIIlllIIII[llllllllllllllIlIllIIIlIIllIllll];
                        this.fixTransparentColor(llllllllllllllIlIllIIIlIIllIlllI);
                    }
                }
            }
            if (this.spriteSingle != null) {
                final IResource llllllllllllllIlIllIIIlIIllIllIl = Config.getResourceManager().getResource(llllllllllllllIlIllIIIlIIllIlIll.getResourceLocation());
                this.spriteSingle.loadSpriteFrames(llllllllllllllIlIllIIIlIIllIllIl, llllllllllllllIlIllIIIlIIllllIlI);
            }
        }
    }
    
    protected TextureAtlasSprite(final String llllllllllllllIlIllIIIllIlIIlIll) {
        this.framesTextureData = (List<int[][]>)Lists.newArrayList();
        this.indexInMap = -1;
        this.glSpriteTextureId = -1;
        this.spriteSingle = null;
        this.isSpriteSingle = false;
        this.mipmapLevels = 0;
        this.spriteNormal = null;
        this.spriteSpecular = null;
        this.isShadersSprite = false;
        this.isDependencyParent = false;
        this.iconName = llllllllllllllIlIllIIIllIlIIlIll;
        if (Config.isMultiTexture()) {
            this.spriteSingle = new TextureAtlasSprite(this);
        }
    }
    
    private static int[][] getFrameTextureData(final int[][] llllllllllllllIlIllIIIlIIIlIlIll, final int llllllllllllllIlIllIIIlIIIlIlIlI, final int llllllllllllllIlIllIIIlIIIlIlIIl, final int llllllllllllllIlIllIIIlIIIlIlIII) {
        final int[][] llllllllllllllIlIllIIIlIIIlIIlll = new int[llllllllllllllIlIllIIIlIIIlIlIll.length][];
        for (int llllllllllllllIlIllIIIlIIIlIIllI = 0; llllllllllllllIlIllIIIlIIIlIIllI < llllllllllllllIlIllIIIlIIIlIlIll.length; ++llllllllllllllIlIllIIIlIIIlIIllI) {
            final int[] llllllllllllllIlIllIIIlIIIlIIlIl = llllllllllllllIlIllIIIlIIIlIlIll[llllllllllllllIlIllIIIlIIIlIIllI];
            if (llllllllllllllIlIllIIIlIIIlIIlIl != null) {
                llllllllllllllIlIllIIIlIIIlIIlll[llllllllllllllIlIllIIIlIIIlIIllI] = new int[(llllllllllllllIlIllIIIlIIIlIlIlI >> llllllllllllllIlIllIIIlIIIlIIllI) * (llllllllllllllIlIllIIIlIIIlIlIIl >> llllllllllllllIlIllIIIlIIIlIIllI)];
                System.arraycopy(llllllllllllllIlIllIIIlIIIlIIlIl, llllllllllllllIlIllIIIlIIIlIlIII * llllllllllllllIlIllIIIlIIIlIIlll[llllllllllllllIlIllIIIlIIIlIIllI].length, llllllllllllllIlIllIIIlIIIlIIlll[llllllllllllllIlIllIIIlIIIlIIllI], 0, llllllllllllllIlIllIIIlIIIlIIlll[llllllllllllllIlIllIIIlIIIlIIllI].length);
            }
        }
        return llllllllllllllIlIllIIIlIIIlIIlll;
    }
    
    private void updateAnimationInterpolated() {
        final double llllllllllllllIlIllIIIlIllIIlIIl = 1.0 - this.tickCounter / (double)this.animationMetadata.getFrameTimeSingle(this.frameCounter);
        final int llllllllllllllIlIllIIIlIllIIlIII = this.animationMetadata.getFrameIndex(this.frameCounter);
        final int llllllllllllllIlIllIIIlIllIIIlll = (this.animationMetadata.getFrameCount() == 0) ? this.framesTextureData.size() : this.animationMetadata.getFrameCount();
        final int llllllllllllllIlIllIIIlIllIIIllI = this.animationMetadata.getFrameIndex((this.frameCounter + 1) % llllllllllllllIlIllIIIlIllIIIlll);
        if (llllllllllllllIlIllIIIlIllIIlIII != llllllllllllllIlIllIIIlIllIIIllI && llllllllllllllIlIllIIIlIllIIIllI >= 0 && llllllllllllllIlIllIIIlIllIIIllI < this.framesTextureData.size()) {
            final int[][] llllllllllllllIlIllIIIlIllIIIlIl = this.framesTextureData.get(llllllllllllllIlIllIIIlIllIIlIII);
            final int[][] llllllllllllllIlIllIIIlIllIIIlII = this.framesTextureData.get(llllllllllllllIlIllIIIlIllIIIllI);
            if (this.interpolatedFrameData == null || this.interpolatedFrameData.length != llllllllllllllIlIllIIIlIllIIIlIl.length) {
                this.interpolatedFrameData = new int[llllllllllllllIlIllIIIlIllIIIlIl.length][];
            }
            for (int llllllllllllllIlIllIIIlIllIIIIll = 0; llllllllllllllIlIllIIIlIllIIIIll < llllllllllllllIlIllIIIlIllIIIlIl.length; ++llllllllllllllIlIllIIIlIllIIIIll) {
                if (this.interpolatedFrameData[llllllllllllllIlIllIIIlIllIIIIll] == null) {
                    this.interpolatedFrameData[llllllllllllllIlIllIIIlIllIIIIll] = new int[llllllllllllllIlIllIIIlIllIIIlIl[llllllllllllllIlIllIIIlIllIIIIll].length];
                }
                if (llllllllllllllIlIllIIIlIllIIIIll < llllllllllllllIlIllIIIlIllIIIlII.length && llllllllllllllIlIllIIIlIllIIIlII[llllllllllllllIlIllIIIlIllIIIIll].length == llllllllllllllIlIllIIIlIllIIIlIl[llllllllllllllIlIllIIIlIllIIIIll].length) {
                    for (int llllllllllllllIlIllIIIlIllIIIIlI = 0; llllllllllllllIlIllIIIlIllIIIIlI < llllllllllllllIlIllIIIlIllIIIlIl[llllllllllllllIlIllIIIlIllIIIIll].length; ++llllllllllllllIlIllIIIlIllIIIIlI) {
                        final int llllllllllllllIlIllIIIlIllIIIIIl = llllllllllllllIlIllIIIlIllIIIlIl[llllllllllllllIlIllIIIlIllIIIIll][llllllllllllllIlIllIIIlIllIIIIlI];
                        final int llllllllllllllIlIllIIIlIllIIIIII = llllllllllllllIlIllIIIlIllIIIlII[llllllllllllllIlIllIIIlIllIIIIll][llllllllllllllIlIllIIIlIllIIIIlI];
                        final int llllllllllllllIlIllIIIlIlIllllll = this.interpolateColor(llllllllllllllIlIllIIIlIllIIlIIl, llllllllllllllIlIllIIIlIllIIIIIl >> 16 & 0xFF, llllllllllllllIlIllIIIlIllIIIIII >> 16 & 0xFF);
                        final int llllllllllllllIlIllIIIlIlIlllllI = this.interpolateColor(llllllllllllllIlIllIIIlIllIIlIIl, llllllllllllllIlIllIIIlIllIIIIIl >> 8 & 0xFF, llllllllllllllIlIllIIIlIllIIIIII >> 8 & 0xFF);
                        final int llllllllllllllIlIllIIIlIlIllllIl = this.interpolateColor(llllllllllllllIlIllIIIlIllIIlIIl, llllllllllllllIlIllIIIlIllIIIIIl & 0xFF, llllllllllllllIlIllIIIlIllIIIIII & 0xFF);
                        this.interpolatedFrameData[llllllllllllllIlIllIIIlIllIIIIll][llllllllllllllIlIllIIIlIllIIIIlI] = ((llllllllllllllIlIllIIIlIllIIIIIl & 0xFF000000) | llllllllllllllIlIllIIIlIlIllllll << 16 | llllllllllllllIlIllIIIlIlIlllllI << 8 | llllllllllllllIlIllIIIlIlIllllIl);
                    }
                }
            }
            TextureUtil.uploadTextureMipmap(this.interpolatedFrameData, this.width, this.height, this.originX, this.originY, false, false);
        }
    }
    
    public int getOriginX() {
        return this.originX;
    }
    
    public int getIconHeight() {
        return this.height;
    }
    
    public String getIconName() {
        return this.iconName;
    }
    
    public float getUnInterpolatedV(final float llllllllllllllIlIllIIIlIllllIIlI) {
        final float llllllllllllllIlIllIIIlIllllIIIl = this.maxV - this.minV;
        return (llllllllllllllIlIllIIIlIllllIIlI - this.minV) / llllllllllllllIlIllIIIlIllllIIIl * 16.0f;
    }
    
    public int getIconWidth() {
        return this.width;
    }
    
    private void resetSprite() {
        this.animationMetadata = null;
        this.setFramesTextureData(Lists.newArrayList());
        this.frameCounter = 0;
        this.tickCounter = 0;
        if (this.spriteSingle != null) {
            this.spriteSingle.resetSprite();
        }
    }
    
    public void clearFramesTextureData() {
        this.framesTextureData.clear();
        if (this.spriteSingle != null) {
            this.spriteSingle.clearFramesTextureData();
        }
    }
    
    public float getInterpolatedU(final double llllllllllllllIlIllIIIllIIIlIIII) {
        final float llllllllllllllIlIllIIIllIIIlIIlI = this.maxU - this.minU;
        return this.minU + llllllllllllllIlIllIIIllIIIlIIlI * (float)llllllllllllllIlIllIIIllIIIlIIII / 16.0f;
    }
    
    private TextureAtlasSprite(final TextureAtlasSprite llllllllllllllIlIllIIIllIlIlIIIl) {
        this.framesTextureData = (List<int[][]>)Lists.newArrayList();
        this.indexInMap = -1;
        this.glSpriteTextureId = -1;
        this.spriteSingle = null;
        this.isSpriteSingle = false;
        this.mipmapLevels = 0;
        this.spriteNormal = null;
        this.spriteSpecular = null;
        this.isShadersSprite = false;
        this.isDependencyParent = false;
        this.iconName = llllllllllllllIlIllIIIllIlIlIIIl.iconName;
        this.isSpriteSingle = true;
    }
    
    public void loadSprite(final PngSizeInfo llllllllllllllIlIllIIIlIlIIIlIll, final boolean llllllllllllllIlIllIIIlIlIIIlIlI) throws IOException {
        this.resetSprite();
        this.width = llllllllllllllIlIllIIIlIlIIIlIll.pngWidth;
        this.height = llllllllllllllIlIllIIIlIlIIIlIll.pngHeight;
        if (llllllllllllllIlIllIIIlIlIIIlIlI) {
            this.height = this.width;
        }
        else if (llllllllllllllIlIllIIIlIlIIIlIll.pngHeight != llllllllllllllIlIllIIIlIlIIIlIll.pngWidth) {
            throw new RuntimeException("broken aspect ratio and not an animation");
        }
        if (this.spriteSingle != null) {
            this.spriteSingle.width = this.width;
            this.spriteSingle.height = this.height;
        }
    }
    
    public int getOriginY() {
        return this.originY;
    }
    
    public float getMaxU() {
        return this.maxU;
    }
    
    public boolean load(final IResourceManager llllllllllllllIlIllIIIlIIIIIIlll, final ResourceLocation llllllllllllllIlIllIIIlIIIIIIllI, final Function<ResourceLocation, TextureAtlasSprite> llllllllllllllIlIllIIIlIIIIIIlIl) {
        return true;
    }
    
    public void updateAnimation() {
        if (this.animationMetadata != null) {
            ++this.tickCounter;
            if (this.tickCounter >= this.animationMetadata.getFrameTimeSingle(this.frameCounter)) {
                final int llllllllllllllIlIllIIIlIlllIIIll = this.animationMetadata.getFrameIndex(this.frameCounter);
                final int llllllllllllllIlIllIIIlIlllIIIlI = (this.animationMetadata.getFrameCount() == 0) ? this.framesTextureData.size() : this.animationMetadata.getFrameCount();
                this.frameCounter = (this.frameCounter + 1) % llllllllllllllIlIllIIIlIlllIIIlI;
                this.tickCounter = 0;
                final int llllllllllllllIlIllIIIlIlllIIIIl = this.animationMetadata.getFrameIndex(this.frameCounter);
                final boolean llllllllllllllIlIllIIIlIlllIIIII = false;
                final boolean llllllllllllllIlIllIIIlIllIlllll = this.isSpriteSingle;
                if (llllllllllllllIlIllIIIlIlllIIIll != llllllllllllllIlIllIIIlIlllIIIIl && llllllllllllllIlIllIIIlIlllIIIIl >= 0 && llllllllllllllIlIllIIIlIlllIIIIl < this.framesTextureData.size()) {
                    TextureUtil.uploadTextureMipmap(this.framesTextureData.get(llllllllllllllIlIllIIIlIlllIIIIl), this.width, this.height, this.originX, this.originY, llllllllllllllIlIllIIIlIlllIIIII, llllllllllllllIlIllIIIlIllIlllll);
                }
            }
            else if (this.animationMetadata.isInterpolate()) {
                this.updateAnimationInterpolated();
            }
        }
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("TextureAtlasSprite{name='").append(this.iconName).append('\'').append(", frameCount=").append(this.framesTextureData.size()).append(", rotated=").append(this.rotated).append(", x=").append(this.originX).append(", y=").append(this.originY).append(", height=").append(this.height).append(", width=").append(this.width).append(", u0=").append(this.minU).append(", u1=").append(this.maxU).append(", v0=").append(this.minV).append(", v1=").append(this.maxV).append('}'));
    }
    
    public void copyFrom(final TextureAtlasSprite llllllllllllllIlIllIIIllIIlIlIlI) {
        this.originX = llllllllllllllIlIllIIIllIIlIlIlI.originX;
        this.originY = llllllllllllllIlIllIIIllIIlIlIlI.originY;
        this.width = llllllllllllllIlIllIIIllIIlIlIlI.width;
        this.height = llllllllllllllIlIllIIIllIIlIlIlI.height;
        this.rotated = llllllllllllllIlIllIIIllIIlIlIlI.rotated;
        this.minU = llllllllllllllIlIllIIIllIIlIlIlI.minU;
        this.maxU = llllllllllllllIlIllIIIllIIlIlIlI.maxU;
        this.minV = llllllllllllllIlIllIIIllIIlIlIlI.minV;
        this.maxV = llllllllllllllIlIllIIIllIIlIlIlI.maxV;
        if (this.spriteSingle != null) {
            this.spriteSingle.initSprite(this.width, this.height, 0, 0, false);
        }
    }
    
    public int getFrameCount() {
        return this.framesTextureData.size();
    }
    
    public int[][] getFrameTextureData(final int llllllllllllllIlIllIIIlIlIlIIIIl) {
        return this.framesTextureData.get(llllllllllllllIlIllIIIlIlIlIIIIl);
    }
    
    public void setIconWidth(final int llllllllllllllIlIllIIIlIlIIllIII) {
        this.width = llllllllllllllIlIllIIIlIlIIllIII;
        if (this.spriteSingle != null) {
            this.spriteSingle.setIconWidth(this.width);
        }
    }
    
    public void setIconHeight(final int llllllllllllllIlIllIIIlIlIIlIIII) {
        this.height = llllllllllllllIlIllIIIlIlIIlIIII;
        if (this.spriteSingle != null) {
            this.spriteSingle.setIconHeight(this.height);
        }
    }
    
    public int getIndexInMap() {
        return this.indexInMap;
    }
    
    public void generateMipmaps(final int llllllllllllllIlIllIIIlIIlIllIIl) {
        final List<int[][]> llllllllllllllIlIllIIIlIIlIllIII = (List<int[][]>)Lists.newArrayList();
        for (int llllllllllllllIlIllIIIlIIlIlIlll = 0; llllllllllllllIlIllIIIlIIlIlIlll < this.framesTextureData.size(); ++llllllllllllllIlIllIIIlIIlIlIlll) {
            final int[][] llllllllllllllIlIllIIIlIIlIlIlIl = this.framesTextureData.get(llllllllllllllIlIllIIIlIIlIlIlll);
            if (llllllllllllllIlIllIIIlIIlIlIlIl != null) {
                try {
                    llllllllllllllIlIllIIIlIIlIllIII.add(TextureUtil.generateMipmapData(llllllllllllllIlIllIIIlIIlIllIIl, this.width, llllllllllllllIlIllIIIlIIlIlIlIl));
                }
                catch (Throwable llllllllllllllIlIllIIIlIIlIlIlII) {
                    final CrashReport llllllllllllllIlIllIIIlIIlIlIIlI = CrashReport.makeCrashReport(llllllllllllllIlIllIIIlIIlIlIlII, "Generating mipmaps for frame");
                    final CrashReportCategory llllllllllllllIlIllIIIlIIlIlIIIl = llllllllllllllIlIllIIIlIIlIlIIlI.makeCategory("Frame being iterated");
                    llllllllllllllIlIllIIIlIIlIlIIIl.addCrashSection("Frame index", llllllllllllllIlIllIIIlIIlIlIlll);
                    llllllllllllllIlIllIIIlIIlIlIIIl.setDetail("Frame sizes", new ICrashReportDetail<String>() {
                        @Override
                        public String call() throws Exception {
                            final StringBuilder llllllllllllllIllIIlIllIIlIIIIIl = new StringBuilder();
                            final String llllllllllllllIllIIlIllIIIllIllI;
                            final String llllllllllllllIllIIlIllIIIlllIII = (String)((int[][])(Object)(llllllllllllllIllIIlIllIIIllIllI = (String)(Object)llllllllllllllIlIllIIIlIIlIlIlIl)).length;
                            for (short llllllllllllllIllIIlIllIIIlllIlI = 0; llllllllllllllIllIIlIllIIIlllIlI < llllllllllllllIllIIlIllIIIlllIII; ++llllllllllllllIllIIlIllIIIlllIlI) {
                                final int[] llllllllllllllIllIIlIllIIlIIIIII = llllllllllllllIllIIlIllIIIllIllI[llllllllllllllIllIIlIllIIIlllIlI];
                                if (llllllllllllllIllIIlIllIIlIIIIIl.length() > 0) {
                                    llllllllllllllIllIIlIllIIlIIIIIl.append(", ");
                                }
                                llllllllllllllIllIIlIllIIlIIIIIl.append((llllllllllllllIllIIlIllIIlIIIIII == null) ? "null" : Integer.valueOf(llllllllllllllIllIIlIllIIlIIIIII.length));
                            }
                            return String.valueOf(llllllllllllllIllIIlIllIIlIIIIIl);
                        }
                    });
                    throw new ReportedException(llllllllllllllIlIllIIIlIIlIlIIlI);
                }
            }
        }
        this.setFramesTextureData(llllllllllllllIlIllIIIlIIlIllIII);
        if (this.spriteSingle != null) {
            this.spriteSingle.generateMipmaps(llllllllllllllIlIllIIIlIIlIllIIl);
        }
    }
    
    public Collection<ResourceLocation> getDependencies() {
        return (Collection<ResourceLocation>)ImmutableList.of();
    }
    
    public float getInterpolatedV(final double llllllllllllllIlIllIIIlIlllllIll) {
        final float llllllllllllllIlIllIIIlIlllllIlI = this.maxV - this.minV;
        return this.minV + llllllllllllllIlIllIIIlIlllllIlI * (float)llllllllllllllIlIllIIIlIlllllIll / 16.0f;
    }
    
    public void bindSpriteTexture() {
        if (this.glSpriteTextureId < 0) {
            this.glSpriteTextureId = TextureUtil.glGenTextures();
            TextureUtil.allocateTextureImpl(this.glSpriteTextureId, this.mipmapLevels, this.width, this.height);
            TextureUtils.applyAnisotropicLevel();
        }
        TextureUtils.bindTexture(this.glSpriteTextureId);
    }
    
    public AnimationMetadataSection getAnimationMetadata() {
        return this.animationMetadata;
    }
    
    public List<int[][]> getFramesTextureData() {
        final List<int[][]> llllllllllllllIlIllIIIIlIllIIIlI = new ArrayList<int[][]>();
        llllllllllllllIlIllIIIIlIllIIIlI.addAll(this.framesTextureData);
        return llllllllllllllIlIllIIIIlIllIIIlI;
    }
    
    public boolean hasAnimationMetadata() {
        return this.animationMetadata != null;
    }
    
    public float getUnInterpolatedU(final float llllllllllllllIlIllIIIllIIIIIlll) {
        final float llllllllllllllIlIllIIIllIIIIlIIl = this.maxU - this.minU;
        return (llllllllllllllIlIllIIIllIIIIIlll - this.minU) / llllllllllllllIlIllIIIllIIIIlIIl * 16.0f;
    }
    
    public void setFramesTextureData(final List<int[][]> llllllllllllllIlIllIIIlIIIIlIlII) {
        this.framesTextureData = llllllllllllllIlIllIIIlIIIIlIlII;
        if (this.spriteSingle != null) {
            this.spriteSingle.setFramesTextureData(llllllllllllllIlIllIIIlIIIIlIlII);
        }
    }
    
    public float toSingleU(float llllllllllllllIlIllIIIIllIIIIllI) {
        llllllllllllllIlIllIIIIllIIIIllI -= (int)this.baseU;
        final float llllllllllllllIlIllIIIIllIIIlIII = this.sheetWidth / (float)this.width;
        llllllllllllllIlIllIIIIllIIIIllI *= (int)llllllllllllllIlIllIIIIllIIIlIII;
        return llllllllllllllIlIllIIIIllIIIIllI;
    }
    
    protected static TextureAtlasSprite makeAtlasSprite(final ResourceLocation llllllllllllllIlIllIIIllIlIIlIII) {
        return new TextureAtlasSprite(llllllllllllllIlIllIIIllIlIIlIII.toString());
    }
    
    private int interpolateColor(final double llllllllllllllIlIllIIIlIlIlIIlll, final int llllllllllllllIlIllIIIlIlIlIlIIl, final int llllllllllllllIlIllIIIlIlIlIlIII) {
        return (int)(llllllllllllllIlIllIIIlIlIlIIlll * llllllllllllllIlIllIIIlIlIlIlIIl + (1.0 - llllllllllllllIlIllIIIlIlIlIIlll) * llllllllllllllIlIllIIIlIlIlIlIII);
    }
    
    private void fixTransparentColor(final int[] llllllllllllllIlIllIIIIllllIllIl) {
        if (llllllllllllllIlIllIIIIllllIllIl != null) {
            long llllllllllllllIlIllIIIIllllIllII = 0L;
            long llllllllllllllIlIllIIIIllllIlIll = 0L;
            long llllllllllllllIlIllIIIIllllIlIlI = 0L;
            long llllllllllllllIlIllIIIIllllIlIIl = 0L;
            for (int llllllllllllllIlIllIIIIllllIlIII = 0; llllllllllllllIlIllIIIIllllIlIII < llllllllllllllIlIllIIIIllllIllIl.length; ++llllllllllllllIlIllIIIIllllIlIII) {
                final int llllllllllllllIlIllIIIIllllIIlll = llllllllllllllIlIllIIIIllllIllIl[llllllllllllllIlIllIIIIllllIlIII];
                final int llllllllllllllIlIllIIIIllllIIllI = llllllllllllllIlIllIIIIllllIIlll >> 24 & 0xFF;
                if (llllllllllllllIlIllIIIIllllIIllI >= 16) {
                    final int llllllllllllllIlIllIIIIllllIIlIl = llllllllllllllIlIllIIIIllllIIlll >> 16 & 0xFF;
                    final int llllllllllllllIlIllIIIIllllIIIll = llllllllllllllIlIllIIIIllllIIlll >> 8 & 0xFF;
                    final int llllllllllllllIlIllIIIIllllIIIlI = llllllllllllllIlIllIIIIllllIIlll & 0xFF;
                    llllllllllllllIlIllIIIIllllIllII += llllllllllllllIlIllIIIIllllIIlIl;
                    llllllllllllllIlIllIIIIllllIlIll += llllllllllllllIlIllIIIIllllIIIll;
                    llllllllllllllIlIllIIIIllllIlIlI += llllllllllllllIlIllIIIIllllIIIlI;
                    ++llllllllllllllIlIllIIIIllllIlIIl;
                }
            }
            if (llllllllllllllIlIllIIIIllllIlIIl > 0L) {
                final int llllllllllllllIlIllIIIIllllIIIII = (int)(llllllllllllllIlIllIIIIllllIllII / llllllllllllllIlIllIIIIllllIlIIl);
                final int llllllllllllllIlIllIIIIlllIllllI = (int)(llllllllllllllIlIllIIIIllllIlIll / llllllllllllllIlIllIIIIllllIlIIl);
                final int llllllllllllllIlIllIIIIlllIlllIl = (int)(llllllllllllllIlIllIIIIllllIlIlI / llllllllllllllIlIllIIIIllllIlIIl);
                final int llllllllllllllIlIllIIIIlllIlllII = llllllllllllllIlIllIIIIllllIIIII << 16 | llllllllllllllIlIllIIIIlllIllllI << 8 | llllllllllllllIlIllIIIIlllIlllIl;
                for (int llllllllllllllIlIllIIIIlllIllIll = 0; llllllllllllllIlIllIIIIlllIllIll < llllllllllllllIlIllIIIIllllIllIl.length; ++llllllllllllllIlIllIIIIlllIllIll) {
                    final int llllllllllllllIlIllIIIIlllIllIlI = llllllllllllllIlIllIIIIllllIllIl[llllllllllllllIlIllIIIIlllIllIll];
                    final int llllllllllllllIlIllIIIIlllIllIIl = llllllllllllllIlIllIIIIlllIllIlI >> 24 & 0xFF;
                    if (llllllllllllllIlIllIIIIlllIllIIl <= 16) {
                        llllllllllllllIlIllIIIIllllIllIl[llllllllllllllIlIllIIIIlllIllIll] = llllllllllllllIlIllIIIIlllIlllII;
                    }
                }
            }
        }
    }
    
    public boolean hasCustomLoader(final IResourceManager llllllllllllllIlIllIIIlIIIIIlIlI, final ResourceLocation llllllllllllllIlIllIIIlIIIIIlIIl) {
        return false;
    }
}
