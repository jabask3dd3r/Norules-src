package optifine;

import java.nio.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.texture.*;
import java.util.*;

public class TextureAnimation
{
    private /* synthetic */ int activeFrame;
    private /* synthetic */ int dstY;
    private /* synthetic */ ByteBuffer imageData;
    private /* synthetic */ int frameHeight;
    private /* synthetic */ TextureAnimationFrame[] frames;
    private /* synthetic */ String srcTex;
    private /* synthetic */ int dstTextId;
    /* synthetic */ byte[] srcData;
    private /* synthetic */ int dstX;
    private /* synthetic */ int frameWidth;
    private /* synthetic */ String dstTex;
    /* synthetic */ ResourceLocation dstTexLoc;
    
    public ResourceLocation getDstTexLoc() {
        return this.dstTexLoc;
    }
    
    public boolean nextFrame() {
        if (this.frames.length <= 0) {
            return false;
        }
        if (this.activeFrame >= this.frames.length) {
            this.activeFrame = 0;
        }
        final TextureAnimationFrame textureAnimationFrame;
        final TextureAnimationFrame lIIIIlllIIIIIll = textureAnimationFrame = this.frames[this.activeFrame];
        ++textureAnimationFrame.counter;
        if (lIIIIlllIIIIIll.counter < lIIIIlllIIIIIll.duration) {
            return false;
        }
        lIIIIlllIIIIIll.counter = 0;
        ++this.activeFrame;
        if (this.activeFrame >= this.frames.length) {
            this.activeFrame = 0;
        }
        return true;
    }
    
    public int getActiveFrameIndex() {
        if (this.frames.length <= 0) {
            return 0;
        }
        if (this.activeFrame >= this.frames.length) {
            this.activeFrame = 0;
        }
        final TextureAnimationFrame lIIIIllIlllllIl = this.frames[this.activeFrame];
        return lIIIIllIlllllIl.index;
    }
    
    public String getDstTex() {
        return this.dstTex;
    }
    
    public boolean updateTexture() {
        if (this.dstTextId < 0) {
            final ITextureObject lIIIIllIlllIIlI = TextureUtils.getTexture(this.dstTexLoc);
            if (lIIIIllIlllIIlI == null) {
                return false;
            }
            this.dstTextId = lIIIIllIlllIIlI.getGlTextureId();
        }
        if (this.imageData == null) {
            this.imageData = GLAllocation.createDirectByteBuffer(this.srcData.length);
            this.imageData.put(this.srcData);
            this.srcData = null;
        }
        if (!this.nextFrame()) {
            return false;
        }
        final int lIIIIllIlllIIIl = this.frameWidth * this.frameHeight * 4;
        final int lIIIIllIlllIIII = this.getActiveFrameIndex();
        final int lIIIIllIllIllll = lIIIIllIlllIIIl * lIIIIllIlllIIII;
        if (lIIIIllIllIllll + lIIIIllIlllIIIl > this.imageData.capacity()) {
            return false;
        }
        this.imageData.position(lIIIIllIllIllll);
        GlStateManager.bindTexture(this.dstTextId);
        GL11.glTexSubImage2D(3553, 0, this.dstX, this.dstY, this.frameWidth, this.frameHeight, 6408, 5121, this.imageData);
        return true;
    }
    
    public TextureAnimation(final String lIIIIlllIIllIlI, final byte[] lIIIIlllIlIllll, final String lIIIIlllIlIlllI, final ResourceLocation lIIIIlllIIlIlll, final int lIIIIlllIlIllII, final int lIIIIlllIIlIlIl, final int lIIIIlllIlIlIlI, final int lIIIIlllIlIlIIl, final Properties lIIIIlllIIlIIlI, final int lIIIIlllIlIIlll) {
        this.srcTex = null;
        this.dstTex = null;
        this.dstTexLoc = null;
        this.dstTextId = -1;
        this.dstX = 0;
        this.dstY = 0;
        this.frameWidth = 0;
        this.frameHeight = 0;
        this.frames = null;
        this.activeFrame = 0;
        this.srcData = null;
        this.imageData = null;
        this.srcTex = lIIIIlllIIllIlI;
        this.dstTex = lIIIIlllIlIlllI;
        this.dstTexLoc = lIIIIlllIIlIlll;
        this.dstX = lIIIIlllIlIllII;
        this.dstY = lIIIIlllIIlIlIl;
        this.frameWidth = lIIIIlllIlIlIlI;
        this.frameHeight = lIIIIlllIlIlIIl;
        final int lIIIIlllIlIIllI = lIIIIlllIlIlIlI * lIIIIlllIlIlIIl * 4;
        if (lIIIIlllIlIllll.length % lIIIIlllIlIIllI != 0) {
            Config.warn(String.valueOf(new StringBuilder("Invalid animated texture length: ").append(lIIIIlllIlIllll.length).append(", frameWidth: ").append(lIIIIlllIlIlIlI).append(", frameHeight: ").append(lIIIIlllIlIlIIl)));
        }
        this.srcData = lIIIIlllIlIllll;
        int lIIIIlllIlIIlIl = lIIIIlllIlIllll.length / lIIIIlllIlIIllI;
        if (lIIIIlllIIlIIlI.get("tile.0") != null) {
            for (int lIIIIlllIlIIlII = 0; lIIIIlllIIlIIlI.get(String.valueOf(new StringBuilder("tile.").append(lIIIIlllIlIIlII))) != null; ++lIIIIlllIlIIlII) {
                lIIIIlllIlIIlIl = lIIIIlllIlIIlII + 1;
            }
        }
        final String lIIIIlllIlIIIll = ((Hashtable<K, String>)lIIIIlllIIlIIlI).get("duration");
        final int lIIIIlllIlIIIlI = Config.parseInt(lIIIIlllIlIIIll, lIIIIlllIlIIlll);
        this.frames = new TextureAnimationFrame[lIIIIlllIlIIlIl];
        for (int lIIIIlllIlIIIIl = 0; lIIIIlllIlIIIIl < this.frames.length; ++lIIIIlllIlIIIIl) {
            final String lIIIIlllIlIIIII = ((Hashtable<K, String>)lIIIIlllIIlIIlI).get(String.valueOf(new StringBuilder("tile.").append(lIIIIlllIlIIIIl)));
            final int lIIIIlllIIlllll = Config.parseInt(lIIIIlllIlIIIII, lIIIIlllIlIIIIl);
            final String lIIIIlllIIllllI = ((Hashtable<K, String>)lIIIIlllIIlIIlI).get(String.valueOf(new StringBuilder("duration.").append(lIIIIlllIlIIIIl)));
            final int lIIIIlllIIlllIl = Config.parseInt(lIIIIlllIIllllI, lIIIIlllIlIIIlI);
            final TextureAnimationFrame lIIIIlllIIlllII = new TextureAnimationFrame(lIIIIlllIIlllll, lIIIIlllIIlllIl);
            this.frames[lIIIIlllIlIIIIl] = lIIIIlllIIlllII;
        }
    }
    
    public int getFrameCount() {
        return this.frames.length;
    }
    
    public String getSrcTex() {
        return this.srcTex;
    }
}
