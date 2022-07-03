package shadersmod.client;

import net.minecraft.util.*;
import java.nio.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import java.awt.image.*;
import optifine.*;
import javax.imageio.*;
import java.io.*;
import net.minecraft.client.*;
import net.minecraft.client.resources.*;
import org.lwjgl.*;
import java.util.*;
import shadersmod.common.*;
import net.minecraft.client.renderer.texture.*;

public class ShadersTex
{
    public static /* synthetic */ MultiTexID boundTex;
    public static /* synthetic */ int[] intArray;
    public static /* synthetic */ ByteBuffer byteBuffer;
    public static /* synthetic */ String iconName;
    static /* synthetic */ int imageSize;
    public static /* synthetic */ TextureMap updatingTextureMap;
    public static /* synthetic */ MultiTexID updatingTex;
    public static /* synthetic */ int updatingPage;
    public static /* synthetic */ IResourceManager resManager;
    public static /* synthetic */ Map<Integer, MultiTexID> multiTexMap;
    static /* synthetic */ ResourceLocation resLocation;
    public static /* synthetic */ TextureAtlasSprite updatingSprite;
    public static /* synthetic */ IntBuffer intBuffer;
    
    public static void setupTexture(final MultiTexID lllllllllllllllIIIIlIIIllIIlIIll, final int[] lllllllllllllllIIIIlIIIllIIlIIlI, final int lllllllllllllllIIIIlIIIllIIllIll, final int lllllllllllllllIIIIlIIIllIIlIIII, final boolean lllllllllllllllIIIIlIIIllIIllIIl, final boolean lllllllllllllllIIIIlIIIllIIllIII) {
        final int lllllllllllllllIIIIlIIIllIIlIlll = lllllllllllllllIIIIlIIIllIIllIIl ? 9729 : 9728;
        final int lllllllllllllllIIIIlIIIllIIlIllI = lllllllllllllllIIIIlIIIllIIllIII ? 10496 : 10497;
        final int lllllllllllllllIIIIlIIIllIIlIlIl = lllllllllllllllIIIIlIIIllIIllIll * lllllllllllllllIIIIlIIIllIIlIIII;
        final IntBuffer lllllllllllllllIIIIlIIIllIIlIlII = getIntBuffer(lllllllllllllllIIIIlIIIllIIlIlIl);
        lllllllllllllllIIIIlIIIllIIlIlII.clear();
        lllllllllllllllIIIIlIIIllIIlIlII.put(lllllllllllllllIIIIlIIIllIIlIIlI, 0, lllllllllllllllIIIIlIIIllIIlIlIl).position(0).limit(lllllllllllllllIIIIlIIIllIIlIlIl);
        GlStateManager.bindTexture(lllllllllllllllIIIIlIIIllIIlIIll.base);
        GL11.glTexImage2D(3553, 0, 6408, lllllllllllllllIIIIlIIIllIIllIll, lllllllllllllllIIIIlIIIllIIlIIII, 0, 32993, 33639, lllllllllllllllIIIIlIIIllIIlIlII);
        GL11.glTexParameteri(3553, 10241, lllllllllllllllIIIIlIIIllIIlIlll);
        GL11.glTexParameteri(3553, 10240, lllllllllllllllIIIIlIIIllIIlIlll);
        GL11.glTexParameteri(3553, 10242, lllllllllllllllIIIIlIIIllIIlIllI);
        GL11.glTexParameteri(3553, 10243, lllllllllllllllIIIIlIIIllIIlIllI);
        lllllllllllllllIIIIlIIIllIIlIlII.put(lllllllllllllllIIIIlIIIllIIlIIlI, lllllllllllllllIIIIlIIIllIIlIlIl, lllllllllllllllIIIIlIIIllIIlIlIl).position(0).limit(lllllllllllllllIIIIlIIIllIIlIlIl);
        GlStateManager.bindTexture(lllllllllllllllIIIIlIIIllIIlIIll.norm);
        GL11.glTexImage2D(3553, 0, 6408, lllllllllllllllIIIIlIIIllIIllIll, lllllllllllllllIIIIlIIIllIIlIIII, 0, 32993, 33639, lllllllllllllllIIIIlIIIllIIlIlII);
        GL11.glTexParameteri(3553, 10241, lllllllllllllllIIIIlIIIllIIlIlll);
        GL11.glTexParameteri(3553, 10240, lllllllllllllllIIIIlIIIllIIlIlll);
        GL11.glTexParameteri(3553, 10242, lllllllllllllllIIIIlIIIllIIlIllI);
        GL11.glTexParameteri(3553, 10243, lllllllllllllllIIIIlIIIllIIlIllI);
        lllllllllllllllIIIIlIIIllIIlIlII.put(lllllllllllllllIIIIlIIIllIIlIIlI, lllllllllllllllIIIIlIIIllIIlIlIl * 2, lllllllllllllllIIIIlIIIllIIlIlIl).position(0).limit(lllllllllllllllIIIIlIIIllIIlIlIl);
        GlStateManager.bindTexture(lllllllllllllllIIIIlIIIllIIlIIll.spec);
        GL11.glTexImage2D(3553, 0, 6408, lllllllllllllllIIIIlIIIllIIllIll, lllllllllllllllIIIIlIIIllIIlIIII, 0, 32993, 33639, lllllllllllllllIIIIlIIIllIIlIlII);
        GL11.glTexParameteri(3553, 10241, lllllllllllllllIIIIlIIIllIIlIlll);
        GL11.glTexParameteri(3553, 10240, lllllllllllllllIIIIlIIIllIIlIlll);
        GL11.glTexParameteri(3553, 10242, lllllllllllllllIIIIlIIIllIIlIllI);
        GL11.glTexParameteri(3553, 10243, lllllllllllllllIIIIlIIIllIIlIllI);
        GlStateManager.bindTexture(lllllllllllllllIIIIlIIIllIIlIIll.base);
    }
    
    public static void uploadTexSub(final int[][] lllllllllllllllIIIIlIIlIlIlIIIll, final int lllllllllllllllIIIIlIIlIlIlIIIlI, final int lllllllllllllllIIIIlIIlIlIlIlIII, final int lllllllllllllllIIIIlIIlIlIlIIIII, final int lllllllllllllllIIIIlIIlIlIlIIllI, final boolean lllllllllllllllIIIIlIIlIlIIllllI, final boolean lllllllllllllllIIIIlIIlIlIIlllIl) {
        TextureUtil.uploadTextureMipmap(lllllllllllllllIIIIlIIlIlIlIIIll, lllllllllllllllIIIIlIIlIlIlIIIlI, lllllllllllllllIIIIlIIlIlIlIlIII, lllllllllllllllIIIIlIIlIlIlIIIII, lllllllllllllllIIIIlIIlIlIlIIllI, lllllllllllllllIIIIlIIlIlIIllllI, lllllllllllllllIIIIlIIlIlIIlllIl);
        if (Shaders.configNormalMap || Shaders.configSpecularMap) {
            if (Shaders.configNormalMap) {
                GlStateManager.bindTexture(ShadersTex.updatingTex.norm);
                uploadTexSub1(lllllllllllllllIIIIlIIlIlIlIIIll, lllllllllllllllIIIIlIIlIlIlIIIlI, lllllllllllllllIIIIlIIlIlIlIlIII, lllllllllllllllIIIIlIIlIlIlIIIII, lllllllllllllllIIIIlIIlIlIlIIllI, 1);
            }
            if (Shaders.configSpecularMap) {
                GlStateManager.bindTexture(ShadersTex.updatingTex.spec);
                uploadTexSub1(lllllllllllllllIIIIlIIlIlIlIIIll, lllllllllllllllIIIIlIIlIlIlIIIlI, lllllllllllllllIIIIlIIlIlIlIlIII, lllllllllllllllIIIIlIIlIlIlIIIII, lllllllllllllllIIIIlIIlIlIlIIllI, 2);
            }
            GlStateManager.bindTexture(ShadersTex.updatingTex.base);
        }
    }
    
    public static void initDynamicTexture(final int lllllllllllllllIIIIlIIllIlllIIII, final int lllllllllllllllIIIIlIIllIllIllll, final int lllllllllllllllIIIIlIIllIllIlllI, final DynamicTexture lllllllllllllllIIIIlIIllIllIllIl) {
        final MultiTexID lllllllllllllllIIIIlIIllIllIllII = lllllllllllllllIIIIlIIllIllIllIl.getMultiTexID();
        final int[] lllllllllllllllIIIIlIIllIllIlIll = lllllllllllllllIIIIlIIllIllIllIl.getTextureData();
        final int lllllllllllllllIIIIlIIllIllIlIlI = lllllllllllllllIIIIlIIllIllIllll * lllllllllllllllIIIIlIIllIllIlllI;
        Arrays.fill(lllllllllllllllIIIIlIIllIllIlIll, lllllllllllllllIIIIlIIllIllIlIlI, lllllllllllllllIIIIlIIllIllIlIlI * 2, -8421377);
        Arrays.fill(lllllllllllllllIIIIlIIllIllIlIll, lllllllllllllllIIIIlIIllIllIlIlI * 2, lllllllllllllllIIIIlIIllIllIlIlI * 3, 0);
        TextureUtil.allocateTexture(lllllllllllllllIIIIlIIllIllIllII.base, lllllllllllllllIIIIlIIllIllIllll, lllllllllllllllIIIIlIIllIllIlllI);
        TextureUtil.setTextureBlurMipmap(false, false);
        TextureUtil.setTextureClamped(false);
        TextureUtil.allocateTexture(lllllllllllllllIIIIlIIllIllIllII.norm, lllllllllllllllIIIIlIIllIllIllll, lllllllllllllllIIIIlIIllIllIlllI);
        TextureUtil.setTextureBlurMipmap(false, false);
        TextureUtil.setTextureClamped(false);
        TextureUtil.allocateTexture(lllllllllllllllIIIIlIIllIllIllII.spec, lllllllllllllllIIIIlIIllIllIllll, lllllllllllllllIIIIlIIllIllIlllI);
        TextureUtil.setTextureBlurMipmap(false, false);
        TextureUtil.setTextureClamped(false);
        GlStateManager.bindTexture(lllllllllllllllIIIIlIIllIllIllII.base);
    }
    
    public static int[] getIntArray(final int lllllllllllllllIIIIlIIllllIllIll) {
        if (ShadersTex.intArray == null) {
            ShadersTex.intArray = new int[1048576];
        }
        if (ShadersTex.intArray.length < lllllllllllllllIIIIlIIllllIllIll) {
            ShadersTex.intArray = new int[roundUpPOT(lllllllllllllllIIIIlIIllllIllIll)];
        }
        return ShadersTex.intArray;
    }
    
    public static int[][] genMipmapsSimple(final int lllllllllllllllIIIIlIIlIlIllllII, final int lllllllllllllllIIIIlIIlIllIIIllI, final int[][] lllllllllllllllIIIIlIIlIlIlllIlI) {
        for (int lllllllllllllllIIIIlIIlIllIIIlII = 1; lllllllllllllllIIIIlIIlIllIIIlII <= lllllllllllllllIIIIlIIlIlIllllII; ++lllllllllllllllIIIIlIIlIllIIIlII) {
            if (lllllllllllllllIIIIlIIlIlIlllIlI[lllllllllllllllIIIIlIIlIllIIIlII] == null) {
                final int lllllllllllllllIIIIlIIlIllIIIIll = lllllllllllllllIIIIlIIlIllIIIllI >> lllllllllllllllIIIIlIIlIllIIIlII;
                final int lllllllllllllllIIIIlIIlIllIIIIlI = lllllllllllllllIIIIlIIlIllIIIIll * 2;
                final int[] lllllllllllllllIIIIlIIlIllIIIIIl = lllllllllllllllIIIIlIIlIlIlllIlI[lllllllllllllllIIIIlIIlIllIIIlII - 1];
                final int n = lllllllllllllllIIIIlIIlIllIIIlII;
                final int[] array = new int[lllllllllllllllIIIIlIIlIllIIIIll * lllllllllllllllIIIIlIIlIllIIIIll];
                lllllllllllllllIIIIlIIlIlIlllIlI[n] = array;
                final int[] lllllllllllllllIIIIlIIlIllIIIIII = array;
                for (int lllllllllllllllIIIIlIIlIlIllllll = 0; lllllllllllllllIIIIlIIlIlIllllll < lllllllllllllllIIIIlIIlIllIIIIll; ++lllllllllllllllIIIIlIIlIlIllllll) {
                    for (int lllllllllllllllIIIIlIIlIlIlllllI = 0; lllllllllllllllIIIIlIIlIlIlllllI < lllllllllllllllIIIIlIIlIllIIIIll; ++lllllllllllllllIIIIlIIlIlIlllllI) {
                        final int lllllllllllllllIIIIlIIlIlIllllIl = lllllllllllllllIIIIlIIlIlIllllll * 2 * lllllllllllllllIIIIlIIlIllIIIIlI + lllllllllllllllIIIIlIIlIlIlllllI * 2;
                        lllllllllllllllIIIIlIIlIllIIIIII[lllllllllllllllIIIIlIIlIlIllllll * lllllllllllllllIIIIlIIlIllIIIIll + lllllllllllllllIIIIlIIlIlIlllllI] = blend4Simple(lllllllllllllllIIIIlIIlIllIIIIIl[lllllllllllllllIIIIlIIlIlIllllIl], lllllllllllllllIIIIlIIlIllIIIIIl[lllllllllllllllIIIIlIIlIlIllllIl + 1], lllllllllllllllIIIIlIIlIllIIIIIl[lllllllllllllllIIIIlIIlIlIllllIl + lllllllllllllllIIIIlIIlIllIIIIlI], lllllllllllllllIIIIlIIlIllIIIIIl[lllllllllllllllIIIIlIIlIlIllllIl + lllllllllllllllIIIIlIIlIllIIIIlI + 1]);
                    }
                }
            }
        }
        return lllllllllllllllIIIIlIIlIlIlllIlI;
    }
    
    public static void updateSubImage(final MultiTexID lllllllllllllllIIIIlIIIllIIIIIIl, final int[] lllllllllllllllIIIIlIIIllIIIIIII, final int lllllllllllllllIIIIlIIIlIlllIlIl, final int lllllllllllllllIIIIlIIIlIllllllI, final int lllllllllllllllIIIIlIIIlIlllIIll, final int lllllllllllllllIIIIlIIIlIlllllII, final boolean lllllllllllllllIIIIlIIIlIllllIll, final boolean lllllllllllllllIIIIlIIIlIllllIlI) {
        final int lllllllllllllllIIIIlIIIlIllllIIl = lllllllllllllllIIIIlIIIlIlllIlIl * lllllllllllllllIIIIlIIIlIllllllI;
        final IntBuffer lllllllllllllllIIIIlIIIlIllllIII = getIntBuffer(lllllllllllllllIIIIlIIIlIllllIIl);
        lllllllllllllllIIIIlIIIlIllllIII.clear();
        lllllllllllllllIIIIlIIIlIllllIII.put(lllllllllllllllIIIIlIIIllIIIIIII, 0, lllllllllllllllIIIIlIIIlIllllIIl);
        lllllllllllllllIIIIlIIIlIllllIII.position(0).limit(lllllllllllllllIIIIlIIIlIllllIIl);
        GlStateManager.bindTexture(lllllllllllllllIIIIlIIIllIIIIIIl.base);
        GL11.glTexParameteri(3553, 10241, 9728);
        GL11.glTexParameteri(3553, 10240, 9728);
        GL11.glTexParameteri(3553, 10242, 10497);
        GL11.glTexParameteri(3553, 10243, 10497);
        GL11.glTexSubImage2D(3553, 0, lllllllllllllllIIIIlIIIlIlllIIll, lllllllllllllllIIIIlIIIlIlllllII, lllllllllllllllIIIIlIIIlIlllIlIl, lllllllllllllllIIIIlIIIlIllllllI, 32993, 33639, lllllllllllllllIIIIlIIIlIllllIII);
        if (lllllllllllllllIIIIlIIIllIIIIIII.length == lllllllllllllllIIIIlIIIlIllllIIl * 3) {
            lllllllllllllllIIIIlIIIlIllllIII.clear();
            lllllllllllllllIIIIlIIIlIllllIII.put(lllllllllllllllIIIIlIIIllIIIIIII, lllllllllllllllIIIIlIIIlIllllIIl, lllllllllllllllIIIIlIIIlIllllIIl).position(0);
            lllllllllllllllIIIIlIIIlIllllIII.position(0).limit(lllllllllllllllIIIIlIIIlIllllIIl);
        }
        GlStateManager.bindTexture(lllllllllllllllIIIIlIIIllIIIIIIl.norm);
        GL11.glTexParameteri(3553, 10241, 9728);
        GL11.glTexParameteri(3553, 10240, 9728);
        GL11.glTexParameteri(3553, 10242, 10497);
        GL11.glTexParameteri(3553, 10243, 10497);
        GL11.glTexSubImage2D(3553, 0, lllllllllllllllIIIIlIIIlIlllIIll, lllllllllllllllIIIIlIIIlIlllllII, lllllllllllllllIIIIlIIIlIlllIlIl, lllllllllllllllIIIIlIIIlIllllllI, 32993, 33639, lllllllllllllllIIIIlIIIlIllllIII);
        if (lllllllllllllllIIIIlIIIllIIIIIII.length == lllllllllllllllIIIIlIIIlIllllIIl * 3) {
            lllllllllllllllIIIIlIIIlIllllIII.clear();
            lllllllllllllllIIIIlIIIlIllllIII.put(lllllllllllllllIIIIlIIIllIIIIIII, lllllllllllllllIIIIlIIIlIllllIIl * 2, lllllllllllllllIIIIlIIIlIllllIIl);
            lllllllllllllllIIIIlIIIlIllllIII.position(0).limit(lllllllllllllllIIIIlIIIlIllllIIl);
        }
        GlStateManager.bindTexture(lllllllllllllllIIIIlIIIllIIIIIIl.spec);
        GL11.glTexParameteri(3553, 10241, 9728);
        GL11.glTexParameteri(3553, 10240, 9728);
        GL11.glTexParameteri(3553, 10242, 10497);
        GL11.glTexParameteri(3553, 10243, 10497);
        GL11.glTexSubImage2D(3553, 0, lllllllllllllllIIIIlIIIlIlllIIll, lllllllllllllllIIIIlIIIlIlllllII, lllllllllllllllIIIIlIIIlIlllIlIl, lllllllllllllllIIIIlIIIlIllllllI, 32993, 33639, lllllllllllllllIIIIlIIIlIllllIII);
        GlStateManager.setActiveTexture(33984);
    }
    
    public static BufferedImage readImage(final ResourceLocation lllllllllllllllIIIIlIIlIllIllIIl) {
        try {
            if (!Config.hasResource(lllllllllllllllIIIIlIIlIllIllIIl)) {
                return null;
            }
            final InputStream lllllllllllllllIIIIlIIlIllIllIII = Config.getResourceStream(lllllllllllllllIIIIlIIlIllIllIIl);
            if (lllllllllllllllIIIIlIIlIllIllIII == null) {
                return null;
            }
            final BufferedImage lllllllllllllllIIIIlIIlIllIlIlll = ImageIO.read(lllllllllllllllIIIIlIIlIllIllIII);
            lllllllllllllllIIIIlIIlIllIllIII.close();
            return lllllllllllllllIIIIlIIlIllIlIlll;
        }
        catch (IOException lllllllllllllllIIIIlIIlIllIlIllI) {
            return null;
        }
    }
    
    public static void mergeImage(final int[] lllllllllllllllIIIIlIIIIllIllIII, final int lllllllllllllllIIIIlIIIIllIlIllI, final int lllllllllllllllIIIIlIIIIllIlIlII, final int lllllllllllllllIIIIlIIIIllIlIIll) {
    }
    
    public static int roundUpPOT(final int lllllllllllllllIIIIlIIllllIlIlIl) {
        int lllllllllllllllIIIIlIIllllIlIllI = lllllllllllllllIIIIlIIllllIlIlIl - 1;
        lllllllllllllllIIIIlIIllllIlIllI |= lllllllllllllllIIIIlIIllllIlIllI >> 1;
        lllllllllllllllIIIIlIIllllIlIllI |= lllllllllllllllIIIIlIIllllIlIllI >> 2;
        lllllllllllllllIIIIlIIllllIlIllI |= lllllllllllllllIIIIlIIllllIlIllI >> 4;
        lllllllllllllllIIIIlIIllllIlIllI |= lllllllllllllllIIIIlIIllllIlIllI >> 8;
        lllllllllllllllIIIIlIIllllIlIllI |= lllllllllllllllIIIIlIIllllIlIllI >> 16;
        return lllllllllllllllIIIIlIIllllIlIllI + 1;
    }
    
    public static void genMipmapSimple(final int[] lllllllllllllllIIIIlIIIlllllIllI, final int lllllllllllllllIIIIlIIIllllIIIll, final int lllllllllllllllIIIIlIIIlllllIlII, final int lllllllllllllllIIIIlIIIlllllIIll) {
        Math.min(lllllllllllllllIIIIlIIIlllllIlII, lllllllllllllllIIIIlIIIlllllIIll);
        int lllllllllllllllIIIIlIIIlllllIIlI = lllllllllllllllIIIIlIIIllllIIIll;
        int lllllllllllllllIIIIlIIIlllllIIIl = lllllllllllllllIIIIlIIIlllllIlII;
        int lllllllllllllllIIIIlIIIlllllIIII = lllllllllllllllIIIIlIIIlllllIIll;
        int lllllllllllllllIIIIlIIIllllIllll = 0;
        int lllllllllllllllIIIIlIIIllllIlllI = 0;
        int lllllllllllllllIIIIlIIIllllIllIl = 0;
        int lllllllllllllllIIIIlIIIllllIllII = 0;
        while (lllllllllllllllIIIIlIIIlllllIIIl > 1) {
            if (lllllllllllllllIIIIlIIIlllllIIII <= 1) {
                break;
            }
            lllllllllllllllIIIIlIIIllllIllll = lllllllllllllllIIIIlIIIlllllIIlI + lllllllllllllllIIIIlIIIlllllIIIl * lllllllllllllllIIIIlIIIlllllIIII;
            lllllllllllllllIIIIlIIIllllIlllI = lllllllllllllllIIIIlIIIlllllIIIl / 2;
            lllllllllllllllIIIIlIIIllllIllIl = lllllllllllllllIIIIlIIIlllllIIII / 2;
            for (int lllllllllllllllIIIIlIIIllllIlIll = 0; lllllllllllllllIIIIlIIIllllIlIll < lllllllllllllllIIIIlIIIllllIllIl; ++lllllllllllllllIIIIlIIIllllIlIll) {
                final int lllllllllllllllIIIIlIIIllllIlIlI = lllllllllllllllIIIIlIIIllllIllll + lllllllllllllllIIIIlIIIllllIlIll * lllllllllllllllIIIIlIIIllllIlllI;
                final int lllllllllllllllIIIIlIIIllllIlIIl = lllllllllllllllIIIIlIIIlllllIIlI + lllllllllllllllIIIIlIIIllllIlIll * 2 * lllllllllllllllIIIIlIIIlllllIIIl;
                for (int lllllllllllllllIIIIlIIIllllIlIII = 0; lllllllllllllllIIIIlIIIllllIlIII < lllllllllllllllIIIIlIIIllllIlllI; ++lllllllllllllllIIIIlIIIllllIlIII) {
                    lllllllllllllllIIIIlIIIlllllIllI[lllllllllllllllIIIIlIIIllllIlIlI + lllllllllllllllIIIIlIIIllllIlIII] = blend4Simple(lllllllllllllllIIIIlIIIlllllIllI[lllllllllllllllIIIIlIIIllllIlIIl + lllllllllllllllIIIIlIIIllllIlIII * 2], lllllllllllllllIIIIlIIIlllllIllI[lllllllllllllllIIIIlIIIllllIlIIl + lllllllllllllllIIIIlIIIllllIlIII * 2 + 1], lllllllllllllllIIIIlIIIlllllIllI[lllllllllllllllIIIIlIIIllllIlIIl + lllllllllllllllIIIIlIIIlllllIIIl + lllllllllllllllIIIIlIIIllllIlIII * 2], lllllllllllllllIIIIlIIIlllllIllI[lllllllllllllllIIIIlIIIllllIlIIl + lllllllllllllllIIIIlIIIlllllIIIl + lllllllllllllllIIIIlIIIllllIlIII * 2 + 1]);
                }
            }
            ++lllllllllllllllIIIIlIIIllllIllII;
            lllllllllllllllIIIIlIIIlllllIIIl = lllllllllllllllIIIIlIIIllllIlllI;
            lllllllllllllllIIIIlIIIlllllIIII = lllllllllllllllIIIIlIIIllllIllIl;
            lllllllllllllllIIIIlIIIlllllIIlI = lllllllllllllllIIIIlIIIllllIllll;
        }
        while (lllllllllllllllIIIIlIIIllllIllII > 0) {
            --lllllllllllllllIIIIlIIIllllIllII;
            lllllllllllllllIIIIlIIIlllllIIIl = lllllllllllllllIIIIlIIIlllllIlII >> lllllllllllllllIIIIlIIIllllIllII;
            lllllllllllllllIIIIlIIIlllllIIII = lllllllllllllllIIIIlIIIlllllIIll >> lllllllllllllllIIIIlIIIllllIllII;
            int lllllllllllllllIIIIlIIIllllIIlll;
            lllllllllllllllIIIIlIIIlllllIIlI = (lllllllllllllllIIIIlIIIllllIIlll = lllllllllllllllIIIIlIIIllllIllll - lllllllllllllllIIIIlIIIlllllIIIl * lllllllllllllllIIIIlIIIlllllIIII);
            for (int lllllllllllllllIIIIlIIIllllIIllI = 0; lllllllllllllllIIIIlIIIllllIIllI < lllllllllllllllIIIIlIIIlllllIIII; ++lllllllllllllllIIIIlIIIllllIIllI) {
                for (int lllllllllllllllIIIIlIIIllllIIlIl = 0; lllllllllllllllIIIIlIIIllllIIlIl < lllllllllllllllIIIIlIIIlllllIIIl; ++lllllllllllllllIIIIlIIIllllIIlIl) {
                    if (lllllllllllllllIIIIlIIIlllllIllI[lllllllllllllllIIIIlIIIllllIIlll] == 0) {
                        lllllllllllllllIIIIlIIIlllllIllI[lllllllllllllllIIIIlIIIllllIIlll] = (lllllllllllllllIIIIlIIIlllllIllI[lllllllllllllllIIIIlIIIllllIllll + lllllllllllllllIIIIlIIIllllIIllI / 2 * lllllllllllllllIIIIlIIIllllIlllI + lllllllllllllllIIIIlIIIllllIIlIl / 2] & 0xFFFFFF);
                    }
                    ++lllllllllllllllIIIIlIIIllllIIlll;
                }
            }
            lllllllllllllllIIIIlIIIllllIllll = lllllllllllllllIIIIlIIIlllllIIlI;
            lllllllllllllllIIIIlIIIllllIlllI = lllllllllllllllIIIIlIIIlllllIIIl;
        }
    }
    
    public static void fixTransparentColor(final TextureAtlasSprite lllllllllllllllIIIIlIIIIIIllIlII, final int[] lllllllllllllllIIIIlIIIIIIllIIll) {
    }
    
    public static void updateSubTex1(final int[] lllllllllllllllIIIIlIIIllIlllIlI, final int lllllllllllllllIIIIlIIIllIlllIIl, final int lllllllllllllllIIIIlIIIllIlllIII, final int lllllllllllllllIIIIlIIIllIllIlll, final int lllllllllllllllIIIIlIIIllIlIllIl) {
        int lllllllllllllllIIIIlIIIllIllIlIl = 0;
        for (int lllllllllllllllIIIIlIIIllIllIlII = lllllllllllllllIIIIlIIIllIlllIIl, lllllllllllllllIIIIlIIIllIllIIll = lllllllllllllllIIIIlIIIllIlllIII, lllllllllllllllIIIIlIIIllIllIIlI = lllllllllllllllIIIIlIIIllIllIlll, lllllllllllllllIIIIlIIIllIllIIIl = lllllllllllllllIIIIlIIIllIlIllIl; lllllllllllllllIIIIlIIIllIllIlII > 0 && lllllllllllllllIIIIlIIIllIllIIll > 0; lllllllllllllllIIIIlIIIllIllIlII /= 2, lllllllllllllllIIIIlIIIllIllIIll /= 2, lllllllllllllllIIIIlIIIllIllIIlI /= 2, lllllllllllllllIIIIlIIIllIllIIIl /= 2) {
            GL11.glCopyTexSubImage2D(3553, lllllllllllllllIIIIlIIIllIllIlIl, lllllllllllllllIIIIlIIIllIllIIlI, lllllllllllllllIIIIlIIIllIllIIIl, 0, 0, lllllllllllllllIIIIlIIIllIllIlII, lllllllllllllllIIIIlIIIllIllIIll);
            ++lllllllllllllllIIIIlIIIllIllIlIl;
        }
    }
    
    public static boolean isSemiTransparent(final int[] lllllllllllllllIIIIlIIIlllIIllll, final int lllllllllllllllIIIIlIIIlllIIlllI, final int lllllllllllllllIIIIlIIIlllIIIlll) {
        final int lllllllllllllllIIIIlIIIlllIIllII = lllllllllllllllIIIIlIIIlllIIlllI * lllllllllllllllIIIIlIIIlllIIIlll;
        if (lllllllllllllllIIIIlIIIlllIIllll[0] >>> 24 == 255 && lllllllllllllllIIIIlIIIlllIIllll[lllllllllllllllIIIIlIIIlllIIllII - 1] == 0) {
            return true;
        }
        for (int lllllllllllllllIIIIlIIIlllIIlIll = 0; lllllllllllllllIIIIlIIIlllIIlIll < lllllllllllllllIIIIlIIIlllIIllII; ++lllllllllllllllIIIIlIIIlllIIlIll) {
            final int lllllllllllllllIIIIlIIIlllIIlIlI = lllllllllllllllIIIIlIIIlllIIllll[lllllllllllllllIIIIlIIIlllIIlIll] >>> 24;
            if (lllllllllllllllIIIIlIIIlllIIlIlI != 0 && lllllllllllllllIIIIlIIIlllIIlIlI != 255) {
                return true;
            }
        }
        return false;
    }
    
    public static int blend4Alpha(final int lllllllllllllllIIIIlIIlIIlIlIIIl, final int lllllllllllllllIIIIlIIlIIlIllllI, final int lllllllllllllllIIIIlIIlIIlIIllll, final int lllllllllllllllIIIIlIIlIIlIlllII) {
        int lllllllllllllllIIIIlIIlIIlIllIll = lllllllllllllllIIIIlIIlIIlIlIIIl >>> 24 & 0xFF;
        int lllllllllllllllIIIIlIIlIIlIllIlI = lllllllllllllllIIIIlIIlIIlIllllI >>> 24 & 0xFF;
        int lllllllllllllllIIIIlIIlIIlIllIIl = lllllllllllllllIIIIlIIlIIlIIllll >>> 24 & 0xFF;
        int lllllllllllllllIIIIlIIlIIlIllIII = lllllllllllllllIIIIlIIlIIlIlllII >>> 24 & 0xFF;
        final int lllllllllllllllIIIIlIIlIIlIlIlll = lllllllllllllllIIIIlIIlIIlIllIll + lllllllllllllllIIIIlIIlIIlIllIlI + lllllllllllllllIIIIlIIlIIlIllIIl + lllllllllllllllIIIIlIIlIIlIllIII;
        final int lllllllllllllllIIIIlIIlIIlIlIllI = (lllllllllllllllIIIIlIIlIIlIlIlll + 2) / 4;
        int lllllllllllllllIIIIlIIlIIlIlIlII = 0;
        if (lllllllllllllllIIIIlIIlIIlIlIlll != 0) {
            final int lllllllllllllllIIIIlIIlIIlIlIlIl = lllllllllllllllIIIIlIIlIIlIlIlll;
        }
        else {
            lllllllllllllllIIIIlIIlIIlIlIlII = 4;
            lllllllllllllllIIIIlIIlIIlIllIll = 1;
            lllllllllllllllIIIIlIIlIIlIllIlI = 1;
            lllllllllllllllIIIIlIIlIIlIllIIl = 1;
            lllllllllllllllIIIIlIIlIIlIllIII = 1;
        }
        final int lllllllllllllllIIIIlIIlIIlIlIIll = (lllllllllllllllIIIIlIIlIIlIlIlII + 1) / 2;
        final int lllllllllllllllIIIIlIIlIIlIlIIlI = lllllllllllllllIIIIlIIlIIlIlIllI << 24 | ((lllllllllllllllIIIIlIIlIIlIlIIIl >>> 16 & 0xFF) * lllllllllllllllIIIIlIIlIIlIllIll + (lllllllllllllllIIIIlIIlIIlIllllI >>> 16 & 0xFF) * lllllllllllllllIIIIlIIlIIlIllIlI + (lllllllllllllllIIIIlIIlIIlIIllll >>> 16 & 0xFF) * lllllllllllllllIIIIlIIlIIlIllIIl + (lllllllllllllllIIIIlIIlIIlIlllII >>> 16 & 0xFF) * lllllllllllllllIIIIlIIlIIlIllIII + lllllllllllllllIIIIlIIlIIlIlIIll) / lllllllllllllllIIIIlIIlIIlIlIlII << 16 | ((lllllllllllllllIIIIlIIlIIlIlIIIl >>> 8 & 0xFF) * lllllllllllllllIIIIlIIlIIlIllIll + (lllllllllllllllIIIIlIIlIIlIllllI >>> 8 & 0xFF) * lllllllllllllllIIIIlIIlIIlIllIlI + (lllllllllllllllIIIIlIIlIIlIIllll >>> 8 & 0xFF) * lllllllllllllllIIIIlIIlIIlIllIIl + (lllllllllllllllIIIIlIIlIIlIlllII >>> 8 & 0xFF) * lllllllllllllllIIIIlIIlIIlIllIII + lllllllllllllllIIIIlIIlIIlIlIIll) / lllllllllllllllIIIIlIIlIIlIlIlII << 8 | ((lllllllllllllllIIIIlIIlIIlIlIIIl >>> 0 & 0xFF) * lllllllllllllllIIIIlIIlIIlIllIll + (lllllllllllllllIIIIlIIlIIlIllllI >>> 0 & 0xFF) * lllllllllllllllIIIIlIIlIIlIllIlI + (lllllllllllllllIIIIlIIlIIlIIllll >>> 0 & 0xFF) * lllllllllllllllIIIIlIIlIIlIllIIl + (lllllllllllllllIIIIlIIlIIlIlllII >>> 0 & 0xFF) * lllllllllllllllIIIIlIIlIIlIllIII + lllllllllllllllIIIIlIIlIIlIlIIll) / lllllllllllllllIIIIlIIlIIlIlIlII << 0;
        return lllllllllllllllIIIIlIIlIIlIlIIlI;
    }
    
    public static IntBuffer fillIntBuffer(final int lllllllllllllllIIIIlIIllllIIIlIl, final int lllllllllllllllIIIIlIIllllIIlIII) {
        final int[] lllllllllllllllIIIIlIIllllIIIlll = getIntArray(lllllllllllllllIIIIlIIllllIIIlIl);
        final IntBuffer lllllllllllllllIIIIlIIllllIIIllI = getIntBuffer(lllllllllllllllIIIIlIIllllIIIlIl);
        Arrays.fill(ShadersTex.intArray, 0, lllllllllllllllIIIIlIIllllIIIlIl, lllllllllllllllIIIIlIIllllIIlIII);
        ShadersTex.intBuffer.put(ShadersTex.intArray, 0, lllllllllllllllIIIIlIIllllIIIlIl);
        return ShadersTex.intBuffer;
    }
    
    public static void bindTexture(final ITextureObject lllllllllllllllIIIIlIIlllIIIlIIl) {
        final int lllllllllllllllIIIIlIIlllIIIlIII = lllllllllllllllIIIIlIIlllIIIlIIl.getGlTextureId();
        if (lllllllllllllllIIIIlIIlllIIIlIIl instanceof TextureMap) {
            Shaders.atlasSizeX = ((TextureMap)lllllllllllllllIIIIlIIlllIIIlIIl).atlasWidth;
            Shaders.atlasSizeY = ((TextureMap)lllllllllllllllIIIIlIIlllIIIlIIl).atlasHeight;
            bindTextures(lllllllllllllllIIIIlIIlllIIIlIIl.getMultiTexID());
        }
        else {
            Shaders.atlasSizeX = 0;
            Shaders.atlasSizeY = 0;
            bindTextures(lllllllllllllllIIIIlIIlllIIIlIIl.getMultiTexID());
        }
    }
    
    public static void uploadTexSubForLoadAtlas(final int[][] lllllllllllllllIIIIlIIllIIIIlIIl, final int lllllllllllllllIIIIlIIllIIIIlIII, final int lllllllllllllllIIIIlIIllIIIlIIIl, final int lllllllllllllllIIIIlIIllIIIIIllI, final int lllllllllllllllIIIIlIIllIIIIIlIl, final boolean lllllllllllllllIIIIlIIllIIIIIlII, final boolean lllllllllllllllIIIIlIIllIIIIllIl) {
        TextureUtil.uploadTextureMipmap(lllllllllllllllIIIIlIIllIIIIlIIl, lllllllllllllllIIIIlIIllIIIIlIII, lllllllllllllllIIIIlIIllIIIlIIIl, lllllllllllllllIIIIlIIllIIIIIllI, lllllllllllllllIIIIlIIllIIIIIlIl, lllllllllllllllIIIIlIIllIIIIIlII, lllllllllllllllIIIIlIIllIIIIllIl);
        final boolean lllllllllllllllIIIIlIIllIIIIllII = false;
        if (Shaders.configNormalMap) {
            final int[][] lllllllllllllllIIIIlIIllIIIIlIll = readImageAndMipmaps(String.valueOf(new StringBuilder(String.valueOf(ShadersTex.iconName)).append("_n")), lllllllllllllllIIIIlIIllIIIIlIII, lllllllllllllllIIIIlIIllIIIlIIIl, lllllllllllllllIIIIlIIllIIIIlIIl.length, lllllllllllllllIIIIlIIllIIIIllII, -8421377);
            GlStateManager.bindTexture(ShadersTex.updatingTex.norm);
            TextureUtil.uploadTextureMipmap(lllllllllllllllIIIIlIIllIIIIlIll, lllllllllllllllIIIIlIIllIIIIlIII, lllllllllllllllIIIIlIIllIIIlIIIl, lllllllllllllllIIIIlIIllIIIIIllI, lllllllllllllllIIIIlIIllIIIIIlIl, lllllllllllllllIIIIlIIllIIIIIlII, lllllllllllllllIIIIlIIllIIIIllIl);
        }
        if (Shaders.configSpecularMap) {
            final int[][] lllllllllllllllIIIIlIIllIIIIlIlI = readImageAndMipmaps(String.valueOf(new StringBuilder(String.valueOf(ShadersTex.iconName)).append("_s")), lllllllllllllllIIIIlIIllIIIIlIII, lllllllllllllllIIIIlIIllIIIlIIIl, lllllllllllllllIIIIlIIllIIIIlIIl.length, lllllllllllllllIIIIlIIllIIIIllII, 0);
            GlStateManager.bindTexture(ShadersTex.updatingTex.spec);
            TextureUtil.uploadTextureMipmap(lllllllllllllllIIIIlIIllIIIIlIlI, lllllllllllllllIIIIlIIllIIIIlIII, lllllllllllllllIIIIlIIllIIIlIIIl, lllllllllllllllIIIIlIIllIIIIIllI, lllllllllllllllIIIIlIIllIIIIIlIl, lllllllllllllllIIIIlIIllIIIIIlII, lllllllllllllllIIIIlIIllIIIIllIl);
        }
        GlStateManager.bindTexture(ShadersTex.updatingTex.base);
    }
    
    public static int loadSimpleTexture(final int lllllllllllllllIIIIlIIIIlllIlIII, final BufferedImage lllllllllllllllIIIIlIIIIlllIIllI, final boolean lllllllllllllllIIIIlIIIIllllIlII, final boolean lllllllllllllllIIIIlIIIIllllIIll, final IResourceManager lllllllllllllllIIIIlIIIIlllIIIIl, final ResourceLocation lllllllllllllllIIIIlIIIIllllIIIl, final MultiTexID lllllllllllllllIIIIlIIIIllIlllll) {
        final int lllllllllllllllIIIIlIIIIlllIllll = lllllllllllllllIIIIlIIIIlllIIllI.getWidth();
        final int lllllllllllllllIIIIlIIIIlllIlllI = lllllllllllllllIIIIlIIIIlllIIllI.getHeight();
        final int lllllllllllllllIIIIlIIIIlllIllII = lllllllllllllllIIIIlIIIIlllIllll * lllllllllllllllIIIIlIIIIlllIlllI;
        final int[] lllllllllllllllIIIIlIIIIlllIlIlI = getIntArray(lllllllllllllllIIIIlIIIIlllIllII * 3);
        lllllllllllllllIIIIlIIIIlllIIllI.getRGB(0, 0, lllllllllllllllIIIIlIIIIlllIllll, lllllllllllllllIIIIlIIIIlllIlllI, lllllllllllllllIIIIlIIIIlllIlIlI, 0, lllllllllllllllIIIIlIIIIlllIllll);
        loadNSMap(lllllllllllllllIIIIlIIIIlllIIIIl, lllllllllllllllIIIIlIIIIllllIIIl, lllllllllllllllIIIIlIIIIlllIllll, lllllllllllllllIIIIlIIIIlllIlllI, lllllllllllllllIIIIlIIIIlllIlIlI);
        setupTexture(lllllllllllllllIIIIlIIIIllIlllll, lllllllllllllllIIIIlIIIIlllIlIlI, lllllllllllllllIIIIlIIIIlllIllll, lllllllllllllllIIIIlIIIIlllIlllI, lllllllllllllllIIIIlIIIIllllIlII, lllllllllllllllIIIIlIIIIllllIIll);
        return lllllllllllllllIIIIlIIIIlllIlIII;
    }
    
    public static ITextureObject createDefaultTexture() {
        final DynamicTexture lllllllllllllllIIIIlIIllIIllIlll = new DynamicTexture(1, 1);
        lllllllllllllllIIIIlIIllIIllIlll.getTextureData()[0] = -1;
        lllllllllllllllIIIIlIIllIIllIlll.updateDynamicTexture();
        return lllllllllllllllIIIIlIIllIIllIlll;
    }
    
    public static void bindNSTextures(final int lllllllllllllllIIIIlIIlllIIlllII, final int lllllllllllllllIIIIlIIlllIIllIll) {
        if (Shaders.isRenderingWorld && GlStateManager.getActiveTextureUnit() == 33984) {
            GlStateManager.setActiveTexture(33986);
            GlStateManager.bindTexture(lllllllllllllllIIIIlIIlllIIlllII);
            GlStateManager.setActiveTexture(33987);
            GlStateManager.bindTexture(lllllllllllllllIIIIlIIlllIIllIll);
            GlStateManager.setActiveTexture(33984);
        }
    }
    
    static void updateTextureMinMagFilter() {
        final TextureManager lllllllllllllllIIIIlIIIIlIIIlIII = Minecraft.getMinecraft().getTextureManager();
        final ITextureObject lllllllllllllllIIIIlIIIIlIIIIlll = lllllllllllllllIIIIlIIIIlIIIlIII.getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        if (lllllllllllllllIIIIlIIIIlIIIIlll != null) {
            final MultiTexID lllllllllllllllIIIIlIIIIlIIIIllI = lllllllllllllllIIIIlIIIIlIIIIlll.getMultiTexID();
            GlStateManager.bindTexture(lllllllllllllllIIIIlIIIIlIIIIllI.base);
            GL11.glTexParameteri(3553, 10241, Shaders.texMinFilValue[Shaders.configTexMinFilB]);
            GL11.glTexParameteri(3553, 10240, Shaders.texMagFilValue[Shaders.configTexMagFilB]);
            GlStateManager.bindTexture(lllllllllllllllIIIIlIIIIlIIIIllI.norm);
            GL11.glTexParameteri(3553, 10241, Shaders.texMinFilValue[Shaders.configTexMinFilN]);
            GL11.glTexParameteri(3553, 10240, Shaders.texMagFilValue[Shaders.configTexMagFilN]);
            GlStateManager.bindTexture(lllllllllllllllIIIIlIIIIlIIIIllI.spec);
            GL11.glTexParameteri(3553, 10241, Shaders.texMinFilValue[Shaders.configTexMinFilS]);
            GL11.glTexParameteri(3553, 10240, Shaders.texMagFilValue[Shaders.configTexMagFilS]);
            GlStateManager.bindTexture(0);
        }
    }
    
    public static void loadNSMap1(final IResourceManager lllllllllllllllIIIIlIIIlIIlllIll, final ResourceLocation lllllllllllllllIIIIlIIIlIIlllIIl, final int lllllllllllllllIIIIlIIIlIIlIIIll, final int lllllllllllllllIIIIlIIIlIIlIIIIl, final int[] lllllllllllllllIIIIlIIIlIIIlllll, final int lllllllllllllllIIIIlIIIlIIIlllIl, final int lllllllllllllllIIIIlIIIlIIIllIll) {
        boolean lllllllllllllllIIIIlIIIlIIlIllIl = false;
        try {
            final IResource lllllllllllllllIIIIlIIIlIIlIlIll = lllllllllllllllIIIIlIIIlIIlllIll.getResource(lllllllllllllllIIIIlIIIlIIlllIIl);
            final BufferedImage lllllllllllllllIIIIlIIIlIIlIlIIl = ImageIO.read(lllllllllllllllIIIIlIIIlIIlIlIll.getInputStream());
            if (lllllllllllllllIIIIlIIIlIIlIlIIl != null && lllllllllllllllIIIIlIIIlIIlIlIIl.getWidth() == lllllllllllllllIIIIlIIIlIIlIIIll && lllllllllllllllIIIIlIIIlIIlIlIIl.getHeight() == lllllllllllllllIIIIlIIIlIIlIIIIl) {
                lllllllllllllllIIIIlIIIlIIlIlIIl.getRGB(0, 0, lllllllllllllllIIIIlIIIlIIlIIIll, lllllllllllllllIIIIlIIIlIIlIIIIl, lllllllllllllllIIIIlIIIlIIIlllll, lllllllllllllllIIIIlIIIlIIIlllIl, lllllllllllllllIIIIlIIIlIIlIIIll);
                lllllllllllllllIIIIlIIIlIIlIllIl = true;
            }
        }
        catch (IOException ex) {}
        if (!lllllllllllllllIIIIlIIIlIIlIllIl) {
            Arrays.fill(lllllllllllllllIIIIlIIIlIIIlllll, lllllllllllllllIIIIlIIIlIIIlllIl, lllllllllllllllIIIIlIIIlIIIlllIl + lllllllllllllllIIIIlIIIlIIlIIIll * lllllllllllllllIIIIlIIIlIIlIIIIl, lllllllllllllllIIIIlIIIlIIIllIll);
        }
    }
    
    public static int[][] getFrameTexData(final int[][] lllllllllllllllIIIIlIIIIIlIIlIlI, final int lllllllllllllllIIIIlIIIIIlIIlIIl, final int lllllllllllllllIIIIlIIIIIlIlIlIl, final int lllllllllllllllIIIIlIIIIIlIIIlll) {
        final int lllllllllllllllIIIIlIIIIIlIlIIll = lllllllllllllllIIIIlIIIIIlIIlIlI.length;
        final int[][] lllllllllllllllIIIIlIIIIIlIlIIlI = new int[lllllllllllllllIIIIlIIIIIlIlIIll][];
        for (int lllllllllllllllIIIIlIIIIIlIlIIIl = 0; lllllllllllllllIIIIlIIIIIlIlIIIl < lllllllllllllllIIIIlIIIIIlIlIIll; ++lllllllllllllllIIIIlIIIIIlIlIIIl) {
            final int[] lllllllllllllllIIIIlIIIIIlIlIIII = lllllllllllllllIIIIlIIIIIlIIlIlI[lllllllllllllllIIIIlIIIIIlIlIIIl];
            if (lllllllllllllllIIIIlIIIIIlIlIIII != null) {
                final int lllllllllllllllIIIIlIIIIIlIIllll = (lllllllllllllllIIIIlIIIIIlIIlIIl >> lllllllllllllllIIIIlIIIIIlIlIIIl) * (lllllllllllllllIIIIlIIIIIlIlIlIl >> lllllllllllllllIIIIlIIIIIlIlIIIl);
                final int[] lllllllllllllllIIIIlIIIIIlIIlllI = new int[lllllllllllllllIIIIlIIIIIlIIllll * 3];
                lllllllllllllllIIIIlIIIIIlIlIIlI[lllllllllllllllIIIIlIIIIIlIlIIIl] = lllllllllllllllIIIIlIIIIIlIIlllI;
                final int lllllllllllllllIIIIlIIIIIlIIllIl = lllllllllllllllIIIIlIIIIIlIlIIII.length / 3;
                int lllllllllllllllIIIIlIIIIIlIIllII = lllllllllllllllIIIIlIIIIIlIIllll * lllllllllllllllIIIIlIIIIIlIIIlll;
                int lllllllllllllllIIIIlIIIIIlIIlIll = 0;
                System.arraycopy(lllllllllllllllIIIIlIIIIIlIlIIII, lllllllllllllllIIIIlIIIIIlIIllII, lllllllllllllllIIIIlIIIIIlIIlllI, lllllllllllllllIIIIlIIIIIlIIlIll, lllllllllllllllIIIIlIIIIIlIIllll);
                lllllllllllllllIIIIlIIIIIlIIllII += lllllllllllllllIIIIlIIIIIlIIllIl;
                lllllllllllllllIIIIlIIIIIlIIlIll += lllllllllllllllIIIIlIIIIIlIIllll;
                System.arraycopy(lllllllllllllllIIIIlIIIIIlIlIIII, lllllllllllllllIIIIlIIIIIlIIllII, lllllllllllllllIIIIlIIIIIlIIlllI, lllllllllllllllIIIIlIIIIIlIIlIll, lllllllllllllllIIIIlIIIIIlIIllll);
                lllllllllllllllIIIIlIIIIIlIIllII += lllllllllllllllIIIIlIIIIIlIIllIl;
                lllllllllllllllIIIIlIIIIIlIIlIll += lllllllllllllllIIIIlIIIIIlIIllll;
                System.arraycopy(lllllllllllllllIIIIlIIIIIlIlIIII, lllllllllllllllIIIIlIIIIIlIIllII, lllllllllllllllIIIIlIIIIIlIIlllI, lllllllllllllllIIIIlIIIIIlIIlIll, lllllllllllllllIIIIlIIIIIlIIllll);
            }
        }
        return lllllllllllllllIIIIlIIIIIlIlIIlI;
    }
    
    static {
        defNormTexColor = -8421377;
        defSpecTexColor = 0;
        defBaseTexColor = 0;
        initialBufferSize = 1048576;
        ShadersTex.byteBuffer = BufferUtils.createByteBuffer(4194304);
        ShadersTex.intBuffer = ShadersTex.byteBuffer.asIntBuffer();
        ShadersTex.intArray = new int[1048576];
        ShadersTex.multiTexMap = new HashMap<Integer, MultiTexID>();
        ShadersTex.updatingTextureMap = null;
        ShadersTex.updatingSprite = null;
        ShadersTex.updatingTex = null;
        ShadersTex.boundTex = null;
        ShadersTex.updatingPage = 0;
        ShadersTex.iconName = null;
        ShadersTex.resManager = null;
        ShadersTex.resLocation = null;
        ShadersTex.imageSize = 0;
    }
    
    public static int[] createAIntImage(final int lllllllllllllllIIIIlIIlllIllIlIl, final int lllllllllllllllIIIIlIIlllIllIlll) {
        final int[] lllllllllllllllIIIIlIIlllIllIllI = new int[lllllllllllllllIIIIlIIlllIllIlIl * 3];
        Arrays.fill(lllllllllllllllIIIIlIIlllIllIllI, 0, lllllllllllllllIIIIlIIlllIllIlIl, lllllllllllllllIIIIlIIlllIllIlll);
        Arrays.fill(lllllllllllllllIIIIlIIlllIllIllI, lllllllllllllllIIIIlIIlllIllIlIl, lllllllllllllllIIIIlIIlllIllIlIl * 2, -8421377);
        Arrays.fill(lllllllllllllllIIIIlIIlllIllIllI, lllllllllllllllIIIIlIIlllIllIlIl * 2, lllllllllllllllIIIIlIIlllIllIlIl * 3, 0);
        return lllllllllllllllIIIIlIIlllIllIllI;
    }
    
    public static void updateDynTexSubImage1(final int[] lllllllllllllllIIIIlIIllIlIIIIIl, final int lllllllllllllllIIIIlIIllIlIIlIIl, final int lllllllllllllllIIIIlIIllIIllllll, final int lllllllllllllllIIIIlIIllIIlllllI, final int lllllllllllllllIIIIlIIllIIllllIl, final int lllllllllllllllIIIIlIIllIlIIIlIl) {
        final int lllllllllllllllIIIIlIIllIlIIIlII = lllllllllllllllIIIIlIIllIlIIlIIl * lllllllllllllllIIIIlIIllIIllllll;
        final IntBuffer lllllllllllllllIIIIlIIllIlIIIIll = getIntBuffer(lllllllllllllllIIIIlIIllIlIIIlII);
        lllllllllllllllIIIIlIIllIlIIIIll.clear();
        final int lllllllllllllllIIIIlIIllIlIIIIlI = lllllllllllllllIIIIlIIllIlIIIlIl * lllllllllllllllIIIIlIIllIlIIIlII;
        if (lllllllllllllllIIIIlIIllIlIIIIIl.length >= lllllllllllllllIIIIlIIllIlIIIIlI + lllllllllllllllIIIIlIIllIlIIIlII) {
            lllllllllllllllIIIIlIIllIlIIIIll.put(lllllllllllllllIIIIlIIllIlIIIIIl, lllllllllllllllIIIIlIIllIlIIIIlI, lllllllllllllllIIIIlIIllIlIIIlII).position(0).limit(lllllllllllllllIIIIlIIllIlIIIlII);
            GL11.glTexSubImage2D(3553, 0, lllllllllllllllIIIIlIIllIIlllllI, lllllllllllllllIIIIlIIllIIllllIl, lllllllllllllllIIIIlIIllIlIIlIIl, lllllllllllllllIIIIlIIllIIllllll, 32993, 33639, lllllllllllllllIIIIlIIllIlIIIIll);
            lllllllllllllllIIIIlIIllIlIIIIll.clear();
        }
    }
    
    public static String setIconName(final String lllllllllllllllIIIIlIIllIIIlllIl) {
        return ShadersTex.iconName = lllllllllllllllIIIIlIIllIIIlllIl;
    }
    
    public static TextureAtlasSprite setSprite(final TextureAtlasSprite lllllllllllllllIIIIlIIllIIlIIIII) {
        return ShadersTex.updatingSprite = lllllllllllllllIIIIlIIllIIlIIIII;
    }
    
    public static int log2(int lllllllllllllllIIIIlIIllllIIllll) {
        int lllllllllllllllIIIIlIIllllIlIIII = 0;
        if ((lllllllllllllllIIIIlIIllllIIllll & 0xFFFF0000) != 0x0) {
            lllllllllllllllIIIIlIIllllIlIIII += 16;
            lllllllllllllllIIIIlIIllllIIllll >>= 16;
        }
        if ((lllllllllllllllIIIIlIIllllIIllll & 0xFF00) != 0x0) {
            lllllllllllllllIIIIlIIllllIlIIII += 8;
            lllllllllllllllIIIIlIIllllIIllll >>= 8;
        }
        if ((lllllllllllllllIIIIlIIllllIIllll & 0xF0) != 0x0) {
            lllllllllllllllIIIIlIIllllIlIIII += 4;
            lllllllllllllllIIIIlIIllllIIllll >>= 4;
        }
        if ((lllllllllllllllIIIIlIIllllIIllll & 0x6) != 0x0) {
            lllllllllllllllIIIIlIIllllIlIIII += 2;
            lllllllllllllllIIIIlIIllllIIllll >>= 2;
        }
        if ((lllllllllllllllIIIIlIIllllIIllll & 0x2) != 0x0) {
            ++lllllllllllllllIIIIlIIllllIlIIII;
        }
        return lllllllllllllllIIIIlIIllllIlIIII;
    }
    
    public static void bindTextures(final int lllllllllllllllIIIIlIIlllIIlIIIl, final int lllllllllllllllIIIIlIIlllIIlIIll, final int lllllllllllllllIIIIlIIlllIIlIIlI) {
        if (Shaders.isRenderingWorld && GlStateManager.getActiveTextureUnit() == 33984) {
            GlStateManager.setActiveTexture(33986);
            GlStateManager.bindTexture(lllllllllllllllIIIIlIIlllIIlIIll);
            GlStateManager.setActiveTexture(33987);
            GlStateManager.bindTexture(lllllllllllllllIIIIlIIlllIIlIIlI);
            GlStateManager.setActiveTexture(33984);
        }
        GlStateManager.bindTexture(lllllllllllllllIIIIlIIlllIIlIIIl);
    }
    
    public static IntBuffer getIntBuffer(final int lllllllllllllllIIIIlIIllllIllllI) {
        if (ShadersTex.intBuffer.capacity() < lllllllllllllllIIIIlIIllllIllllI) {
            final int lllllllllllllllIIIIlIIllllIlllll = roundUpPOT(lllllllllllllllIIIIlIIllllIllllI);
            ShadersTex.byteBuffer = BufferUtils.createByteBuffer(lllllllllllllllIIIIlIIllllIlllll * 4);
            ShadersTex.intBuffer = ShadersTex.byteBuffer.asIntBuffer();
        }
        return ShadersTex.intBuffer;
    }
    
    public static void loadLayeredTexture(final LayeredTexture lllllllllllllllIIIIlIIIIlIlIlIIl, final IResourceManager lllllllllllllllIIIIlIIIIlIlIlIII, final List lllllllllllllllIIIIlIIIIlIIllIII) {
        int lllllllllllllllIIIIlIIIIlIlIIllI = 0;
        int lllllllllllllllIIIIlIIIIlIlIIlIl = 0;
        int lllllllllllllllIIIIlIIIIlIlIIlII = 0;
        int[] lllllllllllllllIIIIlIIIIlIlIIIll = null;
        for (final Object lllllllllllllllIIIIlIIIIlIlIIIlI : lllllllllllllllIIIIlIIIIlIIllIII) {
            if (lllllllllllllllIIIIlIIIIlIlIIIlI != null) {
                try {
                    final ResourceLocation lllllllllllllllIIIIlIIIIlIlIIIIl = new ResourceLocation((String)lllllllllllllllIIIIlIIIIlIlIIIlI);
                    final InputStream lllllllllllllllIIIIlIIIIlIlIIIII = lllllllllllllllIIIIlIIIIlIlIlIII.getResource(lllllllllllllllIIIIlIIIIlIlIIIIl).getInputStream();
                    final BufferedImage lllllllllllllllIIIIlIIIIlIIlllll = ImageIO.read(lllllllllllllllIIIIlIIIIlIlIIIII);
                    if (lllllllllllllllIIIIlIIIIlIlIIlII == 0) {
                        lllllllllllllllIIIIlIIIIlIlIIllI = lllllllllllllllIIIIlIIIIlIIlllll.getWidth();
                        lllllllllllllllIIIIlIIIIlIlIIlIl = lllllllllllllllIIIIlIIIIlIIlllll.getHeight();
                        lllllllllllllllIIIIlIIIIlIlIIlII = lllllllllllllllIIIIlIIIIlIlIIllI * lllllllllllllllIIIIlIIIIlIlIIlIl;
                        lllllllllllllllIIIIlIIIIlIlIIIll = createAIntImage(lllllllllllllllIIIIlIIIIlIlIIlII, 0);
                    }
                    final int[] lllllllllllllllIIIIlIIIIlIIllllI = getIntArray(lllllllllllllllIIIIlIIIIlIlIIlII * 3);
                    lllllllllllllllIIIIlIIIIlIIlllll.getRGB(0, 0, lllllllllllllllIIIIlIIIIlIlIIllI, lllllllllllllllIIIIlIIIIlIlIIlIl, lllllllllllllllIIIIlIIIIlIIllllI, 0, lllllllllllllllIIIIlIIIIlIlIIllI);
                    loadNSMap(lllllllllllllllIIIIlIIIIlIlIlIII, lllllllllllllllIIIIlIIIIlIlIIIIl, lllllllllllllllIIIIlIIIIlIlIIllI, lllllllllllllllIIIIlIIIIlIlIIlIl, lllllllllllllllIIIIlIIIIlIIllllI);
                    for (int lllllllllllllllIIIIlIIIIlIIlllIl = 0; lllllllllllllllIIIIlIIIIlIIlllIl < lllllllllllllllIIIIlIIIIlIlIIlII; ++lllllllllllllllIIIIlIIIIlIIlllIl) {
                        final int lllllllllllllllIIIIlIIIIlIIlllII = lllllllllllllllIIIIlIIIIlIIllllI[lllllllllllllllIIIIlIIIIlIIlllIl] >>> 24 & 0xFF;
                        lllllllllllllllIIIIlIIIIlIlIIIll[lllllllllllllllIIIIlIIIIlIlIIlII * 0 + lllllllllllllllIIIIlIIIIlIIlllIl] = blendColor(lllllllllllllllIIIIlIIIIlIIllllI[lllllllllllllllIIIIlIIIIlIlIIlII * 0 + lllllllllllllllIIIIlIIIIlIIlllIl], lllllllllllllllIIIIlIIIIlIlIIIll[lllllllllllllllIIIIlIIIIlIlIIlII * 0 + lllllllllllllllIIIIlIIIIlIIlllIl], lllllllllllllllIIIIlIIIIlIIlllII);
                        lllllllllllllllIIIIlIIIIlIlIIIll[lllllllllllllllIIIIlIIIIlIlIIlII * 1 + lllllllllllllllIIIIlIIIIlIIlllIl] = blendColor(lllllllllllllllIIIIlIIIIlIIllllI[lllllllllllllllIIIIlIIIIlIlIIlII * 1 + lllllllllllllllIIIIlIIIIlIIlllIl], lllllllllllllllIIIIlIIIIlIlIIIll[lllllllllllllllIIIIlIIIIlIlIIlII * 1 + lllllllllllllllIIIIlIIIIlIIlllIl], lllllllllllllllIIIIlIIIIlIIlllII);
                        lllllllllllllllIIIIlIIIIlIlIIIll[lllllllllllllllIIIIlIIIIlIlIIlII * 2 + lllllllllllllllIIIIlIIIIlIIlllIl] = blendColor(lllllllllllllllIIIIlIIIIlIIllllI[lllllllllllllllIIIIlIIIIlIlIIlII * 2 + lllllllllllllllIIIIlIIIIlIIlllIl], lllllllllllllllIIIIlIIIIlIlIIIll[lllllllllllllllIIIIlIIIIlIlIIlII * 2 + lllllllllllllllIIIIlIIIIlIIlllIl], lllllllllllllllIIIIlIIIIlIIlllII);
                    }
                }
                catch (IOException lllllllllllllllIIIIlIIIIlIIllIll) {
                    lllllllllllllllIIIIlIIIIlIIllIll.printStackTrace();
                }
            }
        }
        setupTexture(lllllllllllllllIIIIlIIIIlIlIlIIl.getMultiTexID(), lllllllllllllllIIIIlIIIIlIlIIIll, lllllllllllllllIIIIlIIIIlIlIIllI, lllllllllllllllIIIIlIIIIlIlIIlIl, false, false);
    }
    
    public static void bindNSTextures(final MultiTexID lllllllllllllllIIIIlIIlllIIllIII) {
        bindNSTextures(lllllllllllllllIIIIlIIlllIIllIII.norm, lllllllllllllllIIIIlIIlllIIllIII.spec);
    }
    
    public static void updateDynamicTexture(final int lllllllllllllllIIIIlIIllIlIllllI, final int[] lllllllllllllllIIIIlIIllIlIllIII, final int lllllllllllllllIIIIlIIllIlIlIlll, final int lllllllllllllllIIIIlIIllIlIllIll, final DynamicTexture lllllllllllllllIIIIlIIllIlIllIlI) {
        final MultiTexID lllllllllllllllIIIIlIIllIlIllIIl = lllllllllllllllIIIIlIIllIlIllIlI.getMultiTexID();
        GlStateManager.bindTexture(lllllllllllllllIIIIlIIllIlIllIIl.base);
        updateDynTexSubImage1(lllllllllllllllIIIIlIIllIlIllIII, lllllllllllllllIIIIlIIllIlIlIlll, lllllllllllllllIIIIlIIllIlIllIll, 0, 0, 0);
        GlStateManager.bindTexture(lllllllllllllllIIIIlIIllIlIllIIl.norm);
        updateDynTexSubImage1(lllllllllllllllIIIIlIIllIlIllIII, lllllllllllllllIIIIlIIllIlIlIlll, lllllllllllllllIIIIlIIllIlIllIll, 0, 0, 1);
        GlStateManager.bindTexture(lllllllllllllllIIIIlIIllIlIllIIl.spec);
        updateDynTexSubImage1(lllllllllllllllIIIIlIIllIlIllIII, lllllllllllllllIIIIlIIllIlIlIlll, lllllllllllllllIIIIlIIllIlIllIll, 0, 0, 2);
        GlStateManager.bindTexture(lllllllllllllllIIIIlIIllIlIllIIl.base);
    }
    
    public static void allocateTextureMap(final int lllllllllllllllIIIIlIIllIIlIllll, final int lllllllllllllllIIIIlIIllIIlIIlll, final int lllllllllllllllIIIIlIIllIIlIllIl, final int lllllllllllllllIIIIlIIllIIlIllII, final Stitcher lllllllllllllllIIIIlIIllIIlIlIll, final TextureMap lllllllllllllllIIIIlIIllIIlIlIlI) {
        SMCLog.info(String.valueOf(new StringBuilder("allocateTextureMap ").append(lllllllllllllllIIIIlIIllIIlIIlll).append(" ").append(lllllllllllllllIIIIlIIllIIlIllIl).append(" ").append(lllllllllllllllIIIIlIIllIIlIllII).append(" ")));
        ShadersTex.updatingTextureMap = lllllllllllllllIIIIlIIllIIlIlIlI;
        lllllllllllllllIIIIlIIllIIlIlIlI.atlasWidth = lllllllllllllllIIIIlIIllIIlIllIl;
        lllllllllllllllIIIIlIIllIIlIlIlI.atlasHeight = lllllllllllllllIIIIlIIllIIlIllII;
        final MultiTexID lllllllllllllllIIIIlIIllIIlIlIIl = ShadersTex.updatingTex = getMultiTexID(lllllllllllllllIIIIlIIllIIlIlIlI);
        TextureUtil.allocateTextureImpl(lllllllllllllllIIIIlIIllIIlIlIIl.base, lllllllllllllllIIIIlIIllIIlIIlll, lllllllllllllllIIIIlIIllIIlIllIl, lllllllllllllllIIIIlIIllIIlIllII);
        if (Shaders.configNormalMap) {
            TextureUtil.allocateTextureImpl(lllllllllllllllIIIIlIIllIIlIlIIl.norm, lllllllllllllllIIIIlIIllIIlIIlll, lllllllllllllllIIIIlIIllIIlIllIl, lllllllllllllllIIIIlIIllIIlIllII);
        }
        if (Shaders.configSpecularMap) {
            TextureUtil.allocateTextureImpl(lllllllllllllllIIIIlIIllIIlIlIIl.spec, lllllllllllllllIIIIlIIllIIlIIlll, lllllllllllllllIIIIlIIllIIlIllIl, lllllllllllllllIIIIlIIllIIlIllII);
        }
        GlStateManager.bindTexture(lllllllllllllllIIIIlIIllIIlIllll);
    }
    
    public static MultiTexID getMultiTexID(final AbstractTexture lllllllllllllllIIIIlIIlllIlIllll) {
        MultiTexID lllllllllllllllIIIIlIIlllIlIlllI = lllllllllllllllIIIIlIIlllIlIllll.multiTex;
        if (lllllllllllllllIIIIlIIlllIlIlllI == null) {
            final int lllllllllllllllIIIIlIIlllIlIllIl = lllllllllllllllIIIIlIIlllIlIllll.getGlTextureId();
            lllllllllllllllIIIIlIIlllIlIlllI = ShadersTex.multiTexMap.get(lllllllllllllllIIIIlIIlllIlIllIl);
            if (lllllllllllllllIIIIlIIlllIlIlllI == null) {
                lllllllllllllllIIIIlIIlllIlIlllI = new MultiTexID(lllllllllllllllIIIIlIIlllIlIllIl, GL11.glGenTextures(), GL11.glGenTextures());
                ShadersTex.multiTexMap.put(lllllllllllllllIIIIlIIlllIlIllIl, lllllllllllllllIIIIlIIlllIlIlllI);
            }
            lllllllllllllllIIIIlIIlllIlIllll.multiTex = lllllllllllllllIIIIlIIlllIlIlllI;
        }
        return lllllllllllllllIIIIlIIlllIlIlllI;
    }
    
    public static int blend4Simple(final int lllllllllllllllIIIIlIIlIIIlllIlI, final int lllllllllllllllIIIIlIIlIIIlllllI, final int lllllllllllllllIIIIlIIlIIIllllIl, final int lllllllllllllllIIIIlIIlIIIllllII) {
        final int lllllllllllllllIIIIlIIlIIIlllIll = ((lllllllllllllllIIIIlIIlIIIlllIlI >>> 24 & 0xFF) + (lllllllllllllllIIIIlIIlIIIlllllI >>> 24 & 0xFF) + (lllllllllllllllIIIIlIIlIIIllllIl >>> 24 & 0xFF) + (lllllllllllllllIIIIlIIlIIIllllII >>> 24 & 0xFF) + 2) / 4 << 24 | ((lllllllllllllllIIIIlIIlIIIlllIlI >>> 16 & 0xFF) + (lllllllllllllllIIIIlIIlIIIlllllI >>> 16 & 0xFF) + (lllllllllllllllIIIIlIIlIIIllllIl >>> 16 & 0xFF) + (lllllllllllllllIIIIlIIlIIIllllII >>> 16 & 0xFF) + 2) / 4 << 16 | ((lllllllllllllllIIIIlIIlIIIlllIlI >>> 8 & 0xFF) + (lllllllllllllllIIIIlIIlIIIlllllI >>> 8 & 0xFF) + (lllllllllllllllIIIIlIIlIIIllllIl >>> 8 & 0xFF) + (lllllllllllllllIIIIlIIlIIIllllII >>> 8 & 0xFF) + 2) / 4 << 8 | ((lllllllllllllllIIIIlIIlIIIlllIlI >>> 0 & 0xFF) + (lllllllllllllllIIIIlIIlIIIlllllI >>> 0 & 0xFF) + (lllllllllllllllIIIIlIIlIIIllllIl >>> 0 & 0xFF) + (lllllllllllllllIIIIlIIlIIIllllII >>> 0 & 0xFF) + 2) / 4 << 0;
        return lllllllllllllllIIIIlIIlIIIlllIll;
    }
    
    public static void genMipmapAlpha(final int[] lllllllllllllllIIIIlIIlIIIlIIllI, final int lllllllllllllllIIIIlIIlIIIlIIlIl, final int lllllllllllllllIIIIlIIlIIIIlIIlI, final int lllllllllllllllIIIIlIIlIIIIlIIIl) {
        Math.min(lllllllllllllllIIIIlIIlIIIIlIIlI, lllllllllllllllIIIIlIIlIIIIlIIIl);
        int lllllllllllllllIIIIlIIlIIIlIIIlI = lllllllllllllllIIIIlIIlIIIlIIlIl;
        int lllllllllllllllIIIIlIIlIIIlIIIIl = lllllllllllllllIIIIlIIlIIIIlIIlI;
        int lllllllllllllllIIIIlIIlIIIlIIIII = lllllllllllllllIIIIlIIlIIIIlIIIl;
        int lllllllllllllllIIIIlIIlIIIIlllll = 0;
        int lllllllllllllllIIIIlIIlIIIIllllI = 0;
        int lllllllllllllllIIIIlIIlIIIIlllIl = 0;
        int lllllllllllllllIIIIlIIlIIIIlllII = 0;
        while (lllllllllllllllIIIIlIIlIIIlIIIIl > 1) {
            if (lllllllllllllllIIIIlIIlIIIlIIIII <= 1) {
                break;
            }
            lllllllllllllllIIIIlIIlIIIIlllll = lllllllllllllllIIIIlIIlIIIlIIIlI + lllllllllllllllIIIIlIIlIIIlIIIIl * lllllllllllllllIIIIlIIlIIIlIIIII;
            lllllllllllllllIIIIlIIlIIIIllllI = lllllllllllllllIIIIlIIlIIIlIIIIl / 2;
            lllllllllllllllIIIIlIIlIIIIlllIl = lllllllllllllllIIIIlIIlIIIlIIIII / 2;
            for (int lllllllllllllllIIIIlIIlIIIIllIll = 0; lllllllllllllllIIIIlIIlIIIIllIll < lllllllllllllllIIIIlIIlIIIIlllIl; ++lllllllllllllllIIIIlIIlIIIIllIll) {
                final int lllllllllllllllIIIIlIIlIIIIllIlI = lllllllllllllllIIIIlIIlIIIIlllll + lllllllllllllllIIIIlIIlIIIIllIll * lllllllllllllllIIIIlIIlIIIIllllI;
                final int lllllllllllllllIIIIlIIlIIIIllIIl = lllllllllllllllIIIIlIIlIIIlIIIlI + lllllllllllllllIIIIlIIlIIIIllIll * 2 * lllllllllllllllIIIIlIIlIIIlIIIIl;
                for (int lllllllllllllllIIIIlIIlIIIIllIII = 0; lllllllllllllllIIIIlIIlIIIIllIII < lllllllllllllllIIIIlIIlIIIIllllI; ++lllllllllllllllIIIIlIIlIIIIllIII) {
                    lllllllllllllllIIIIlIIlIIIlIIllI[lllllllllllllllIIIIlIIlIIIIllIlI + lllllllllllllllIIIIlIIlIIIIllIII] = blend4Alpha(lllllllllllllllIIIIlIIlIIIlIIllI[lllllllllllllllIIIIlIIlIIIIllIIl + lllllllllllllllIIIIlIIlIIIIllIII * 2], lllllllllllllllIIIIlIIlIIIlIIllI[lllllllllllllllIIIIlIIlIIIIllIIl + lllllllllllllllIIIIlIIlIIIIllIII * 2 + 1], lllllllllllllllIIIIlIIlIIIlIIllI[lllllllllllllllIIIIlIIlIIIIllIIl + lllllllllllllllIIIIlIIlIIIlIIIIl + lllllllllllllllIIIIlIIlIIIIllIII * 2], lllllllllllllllIIIIlIIlIIIlIIllI[lllllllllllllllIIIIlIIlIIIIllIIl + lllllllllllllllIIIIlIIlIIIlIIIIl + lllllllllllllllIIIIlIIlIIIIllIII * 2 + 1]);
                }
            }
            ++lllllllllllllllIIIIlIIlIIIIlllII;
            lllllllllllllllIIIIlIIlIIIlIIIIl = lllllllllllllllIIIIlIIlIIIIllllI;
            lllllllllllllllIIIIlIIlIIIlIIIII = lllllllllllllllIIIIlIIlIIIIlllIl;
            lllllllllllllllIIIIlIIlIIIlIIIlI = lllllllllllllllIIIIlIIlIIIIlllll;
        }
        while (lllllllllllllllIIIIlIIlIIIIlllII > 0) {
            --lllllllllllllllIIIIlIIlIIIIlllII;
            lllllllllllllllIIIIlIIlIIIlIIIIl = lllllllllllllllIIIIlIIlIIIIlIIlI >> lllllllllllllllIIIIlIIlIIIIlllII;
            lllllllllllllllIIIIlIIlIIIlIIIII = lllllllllllllllIIIIlIIlIIIIlIIIl >> lllllllllllllllIIIIlIIlIIIIlllII;
            int lllllllllllllllIIIIlIIlIIIIlIlll;
            lllllllllllllllIIIIlIIlIIIlIIIlI = (lllllllllllllllIIIIlIIlIIIIlIlll = lllllllllllllllIIIIlIIlIIIIlllll - lllllllllllllllIIIIlIIlIIIlIIIIl * lllllllllllllllIIIIlIIlIIIlIIIII);
            for (int lllllllllllllllIIIIlIIlIIIIlIllI = 0; lllllllllllllllIIIIlIIlIIIIlIllI < lllllllllllllllIIIIlIIlIIIlIIIII; ++lllllllllllllllIIIIlIIlIIIIlIllI) {
                for (int lllllllllllllllIIIIlIIlIIIIlIlIl = 0; lllllllllllllllIIIIlIIlIIIIlIlIl < lllllllllllllllIIIIlIIlIIIlIIIIl; ++lllllllllllllllIIIIlIIlIIIIlIlIl) {
                    if (lllllllllllllllIIIIlIIlIIIlIIllI[lllllllllllllllIIIIlIIlIIIIlIlll] == 0) {
                        lllllllllllllllIIIIlIIlIIIlIIllI[lllllllllllllllIIIIlIIlIIIIlIlll] = (lllllllllllllllIIIIlIIlIIIlIIllI[lllllllllllllllIIIIlIIlIIIIlllll + lllllllllllllllIIIIlIIlIIIIlIllI / 2 * lllllllllllllllIIIIlIIlIIIIllllI + lllllllllllllllIIIIlIIlIIIIlIlIl / 2] & 0xFFFFFF);
                    }
                    ++lllllllllllllllIIIIlIIlIIIIlIlll;
                }
            }
            lllllllllllllllIIIIlIIlIIIIlllll = lllllllllllllllIIIIlIIlIIIlIIIlI;
            lllllllllllllllIIIIlIIlIIIIllllI = lllllllllllllllIIIIlIIlIIIlIIIIl;
        }
    }
    
    public static int blendColor(final int lllllllllllllllIIIIlIIIIllIIIIll, final int lllllllllllllllIIIIlIIIIlIlllIll, final int lllllllllllllllIIIIlIIIIlIlllIlI) {
        final int lllllllllllllllIIIIlIIIIlIllllll = 255 - lllllllllllllllIIIIlIIIIlIlllIlI;
        return ((lllllllllllllllIIIIlIIIIllIIIIll >>> 24 & 0xFF) * lllllllllllllllIIIIlIIIIlIlllIlI + (lllllllllllllllIIIIlIIIIlIlllIll >>> 24 & 0xFF) * lllllllllllllllIIIIlIIIIlIllllll) / 255 << 24 | ((lllllllllllllllIIIIlIIIIllIIIIll >>> 16 & 0xFF) * lllllllllllllllIIIIlIIIIlIlllIlI + (lllllllllllllllIIIIlIIIIlIlllIll >>> 16 & 0xFF) * lllllllllllllllIIIIlIIIIlIllllll) / 255 << 16 | ((lllllllllllllllIIIIlIIIIllIIIIll >>> 8 & 0xFF) * lllllllllllllllIIIIlIIIIlIlllIlI + (lllllllllllllllIIIIlIIIIlIlllIll >>> 8 & 0xFF) * lllllllllllllllIIIIlIIIIlIllllll) / 255 << 8 | ((lllllllllllllllIIIIlIIIIllIIIIll >>> 0 & 0xFF) * lllllllllllllllIIIIlIIIIlIlllIlI + (lllllllllllllllIIIIlIIIIlIlllIll >>> 0 & 0xFF) * lllllllllllllllIIIIlIIIIlIllllll) / 255 << 0;
    }
    
    public static int[][] readImageAndMipmaps(final String lllllllllllllllIIIIlIIlIllllIlII, final int lllllllllllllllIIIIlIIlIlllIIlll, final int lllllllllllllllIIIIlIIlIllllIIlI, final int lllllllllllllllIIIIlIIlIlllIIlIl, final boolean lllllllllllllllIIIIlIIlIllllIIII, final int lllllllllllllllIIIIlIIlIlllIllll) {
        int[][] lllllllllllllllIIIIlIIlIlllIlllI = new int[lllllllllllllllIIIIlIIlIlllIIlIl][];
        final int[] lllllllllllllllIIIIlIIlIlllIllIl = lllllllllllllllIIIIlIIlIlllIlllI[0] = new int[lllllllllllllllIIIIlIIlIlllIIlll * lllllllllllllllIIIIlIIlIllllIIlI];
        boolean lllllllllllllllIIIIlIIlIlllIllII = false;
        final BufferedImage lllllllllllllllIIIIlIIlIlllIlIll = readImage(ShadersTex.updatingTextureMap.completeResourceLocation(new ResourceLocation(lllllllllllllllIIIIlIIlIllllIlII)));
        if (lllllllllllllllIIIIlIIlIlllIlIll != null) {
            final int lllllllllllllllIIIIlIIlIlllIlIlI = lllllllllllllllIIIIlIIlIlllIlIll.getWidth();
            final int lllllllllllllllIIIIlIIlIlllIlIIl = lllllllllllllllIIIIlIIlIlllIlIll.getHeight();
            if (lllllllllllllllIIIIlIIlIlllIlIlI + (lllllllllllllllIIIIlIIlIllllIIII ? 16 : 0) == lllllllllllllllIIIIlIIlIlllIIlll) {
                lllllllllllllllIIIIlIIlIlllIllII = true;
                lllllllllllllllIIIIlIIlIlllIlIll.getRGB(0, 0, lllllllllllllllIIIIlIIlIlllIlIlI, lllllllllllllllIIIIlIIlIlllIlIlI, lllllllllllllllIIIIlIIlIlllIllIl, 0, lllllllllllllllIIIIlIIlIlllIlIlI);
            }
        }
        if (!lllllllllllllllIIIIlIIlIlllIllII) {
            Arrays.fill(lllllllllllllllIIIIlIIlIlllIllIl, lllllllllllllllIIIIlIIlIlllIllll);
        }
        GlStateManager.bindTexture(ShadersTex.updatingTex.spec);
        lllllllllllllllIIIIlIIlIlllIlllI = genMipmapsSimple(lllllllllllllllIIIIlIIlIlllIlllI.length - 1, lllllllllllllllIIIIlIIlIlllIIlll, lllllllllllllllIIIIlIIlIlllIlllI);
        return lllllllllllllllIIIIlIIlIlllIlllI;
    }
    
    public static void uploadTexSub1(final int[][] lllllllllllllllIIIIlIIlIlIIIllII, final int lllllllllllllllIIIIlIIlIIllllIll, final int lllllllllllllllIIIIlIIlIIllllIlI, final int lllllllllllllllIIIIlIIlIlIIIlIIl, final int lllllllllllllllIIIIlIIlIlIIIlIII, final int lllllllllllllllIIIIlIIlIIlllIlll) {
        final int lllllllllllllllIIIIlIIlIlIIIIllI = lllllllllllllllIIIIlIIlIIllllIll * lllllllllllllllIIIIlIIlIIllllIlI;
        final IntBuffer lllllllllllllllIIIIlIIlIlIIIIlIl = getIntBuffer(lllllllllllllllIIIIlIIlIlIIIIllI);
        for (int lllllllllllllllIIIIlIIlIlIIIIlII = lllllllllllllllIIIIlIIlIlIIIllII.length, lllllllllllllllIIIIlIIlIlIIIIIll = 0, lllllllllllllllIIIIlIIlIlIIIIIlI = lllllllllllllllIIIIlIIlIIllllIll, lllllllllllllllIIIIlIIlIlIIIIIIl = lllllllllllllllIIIIlIIlIIllllIlI, lllllllllllllllIIIIlIIlIlIIIIIII = lllllllllllllllIIIIlIIlIlIIIlIIl, lllllllllllllllIIIIlIIlIIlllllll = lllllllllllllllIIIIlIIlIlIIIlIII; lllllllllllllllIIIIlIIlIlIIIIIlI > 0 && lllllllllllllllIIIIlIIlIlIIIIIIl > 0 && lllllllllllllllIIIIlIIlIlIIIIIll < lllllllllllllllIIIIlIIlIlIIIIlII; lllllllllllllllIIIIlIIlIlIIIIIlI >>= 1, lllllllllllllllIIIIlIIlIlIIIIIIl >>= 1, lllllllllllllllIIIIlIIlIlIIIIIII >>= 1, lllllllllllllllIIIIlIIlIIlllllll >>= 1, ++lllllllllllllllIIIIlIIlIlIIIIIll) {
            final int lllllllllllllllIIIIlIIlIIllllllI = lllllllllllllllIIIIlIIlIlIIIIIlI * lllllllllllllllIIIIlIIlIlIIIIIIl;
            final int[] lllllllllllllllIIIIlIIlIIlllllIl = lllllllllllllllIIIIlIIlIlIIIllII[lllllllllllllllIIIIlIIlIlIIIIIll];
            lllllllllllllllIIIIlIIlIlIIIIlIl.clear();
            if (lllllllllllllllIIIIlIIlIIlllllIl.length >= lllllllllllllllIIIIlIIlIIllllllI * (lllllllllllllllIIIIlIIlIIlllIlll + 1)) {
                lllllllllllllllIIIIlIIlIlIIIIlIl.put(lllllllllllllllIIIIlIIlIIlllllIl, lllllllllllllllIIIIlIIlIIllllllI * lllllllllllllllIIIIlIIlIIlllIlll, lllllllllllllllIIIIlIIlIIllllllI).position(0).limit(lllllllllllllllIIIIlIIlIIllllllI);
                GL11.glTexSubImage2D(3553, lllllllllllllllIIIIlIIlIlIIIIIll, lllllllllllllllIIIIlIIlIlIIIIIII, lllllllllllllllIIIIlIIlIIlllllll, lllllllllllllllIIIIlIIlIlIIIIIlI, lllllllllllllllIIIIlIIlIlIIIIIIl, 32993, 33639, lllllllllllllllIIIIlIIlIlIIIIlIl);
            }
        }
        lllllllllllllllIIIIlIIlIlIIIIlIl.clear();
    }
    
    public static IResource loadResource(final IResourceManager lllllllllllllllIIIIlIIIIIllllllI, final ResourceLocation lllllllllllllllIIIIlIIIIIlllllll) throws IOException {
        ShadersTex.resManager = lllllllllllllllIIIIlIIIIIllllllI;
        ShadersTex.resLocation = lllllllllllllllIIIIlIIIIIlllllll;
        return lllllllllllllllIIIIlIIIIIllllllI.getResource(lllllllllllllllIIIIlIIIIIlllllll);
    }
    
    public static int[] createAIntImage(final int lllllllllllllllIIIIlIIlllIllllll) {
        final int[] lllllllllllllllIIIIlIIlllIlllllI = new int[lllllllllllllllIIIIlIIlllIllllll * 3];
        Arrays.fill(lllllllllllllllIIIIlIIlllIlllllI, 0, lllllllllllllllIIIIlIIlllIllllll, 0);
        Arrays.fill(lllllllllllllllIIIIlIIlllIlllllI, lllllllllllllllIIIIlIIlllIllllll, lllllllllllllllIIIIlIIlllIllllll * 2, -8421377);
        Arrays.fill(lllllllllllllllIIIIlIIlllIlllllI, lllllllllllllllIIIIlIIlllIllllll * 2, lllllllllllllllIIIIlIIlllIllllll * 3, 0);
        return lllllllllllllllIIIIlIIlllIlllllI;
    }
    
    public static void deleteTextures(final AbstractTexture lllllllllllllllIIIIlIIlllIlIIllI, final int lllllllllllllllIIIIlIIlllIlIIIlI) {
        final MultiTexID lllllllllllllllIIIIlIIlllIlIIlII = lllllllllllllllIIIIlIIlllIlIIllI.multiTex;
        if (lllllllllllllllIIIIlIIlllIlIIlII != null) {
            lllllllllllllllIIIIlIIlllIlIIllI.multiTex = null;
            ShadersTex.multiTexMap.remove(lllllllllllllllIIIIlIIlllIlIIlII.base);
            GlStateManager.deleteTexture(lllllllllllllllIIIIlIIlllIlIIlII.norm);
            GlStateManager.deleteTexture(lllllllllllllllIIIIlIIlllIlIIlII.spec);
            if (lllllllllllllllIIIIlIIlllIlIIlII.base != lllllllllllllllIIIIlIIlllIlIIIlI) {
                SMCLog.warning(String.valueOf(new StringBuilder("Error : MultiTexID.base mismatch: ").append(lllllllllllllllIIIIlIIlllIlIIlII.base).append(", texid: ").append(lllllllllllllllIIIIlIIlllIlIIIlI)));
                GlStateManager.deleteTexture(lllllllllllllllIIIIlIIlllIlIIlII.base);
            }
        }
    }
    
    public static int[] loadAtlasSprite(final BufferedImage lllllllllllllllIIIIlIIIIIllIllII, final int lllllllllllllllIIIIlIIIIIlllIIll, final int lllllllllllllllIIIIlIIIIIlllIIlI, final int lllllllllllllllIIIIlIIIIIllIlIIl, final int lllllllllllllllIIIIlIIIIIllIlIII, final int[] lllllllllllllllIIIIlIIIIIllIllll, final int lllllllllllllllIIIIlIIIIIllIlllI, final int lllllllllllllllIIIIlIIIIIllIIlIl) {
        ShadersTex.imageSize = lllllllllllllllIIIIlIIIIIllIlIIl * lllllllllllllllIIIIlIIIIIllIlIII;
        lllllllllllllllIIIIlIIIIIllIllII.getRGB(lllllllllllllllIIIIlIIIIIlllIIll, lllllllllllllllIIIIlIIIIIlllIIlI, lllllllllllllllIIIIlIIIIIllIlIIl, lllllllllllllllIIIIlIIIIIllIlIII, lllllllllllllllIIIIlIIIIIllIllll, lllllllllllllllIIIIlIIIIIllIlllI, lllllllllllllllIIIIlIIIIIllIIlIl);
        loadNSMap(ShadersTex.resManager, ShadersTex.resLocation, lllllllllllllllIIIIlIIIIIllIlIIl, lllllllllllllllIIIIlIIIIIllIlIII, lllllllllllllllIIIIlIIIIIllIllll);
        return lllllllllllllllIIIIlIIIIIllIllll;
    }
    
    public static ResourceLocation getNSMapLocation(final ResourceLocation lllllllllllllllIIIIlIIIlIllIlIlI, final String lllllllllllllllIIIIlIIIlIllIlIIl) {
        final String lllllllllllllllIIIIlIIIlIllIlIII = lllllllllllllllIIIIlIIIlIllIlIlI.getResourcePath();
        final String[] lllllllllllllllIIIIlIIIlIllIIlll = lllllllllllllllIIIIlIIIlIllIlIII.split(".png");
        final String lllllllllllllllIIIIlIIIlIllIIllI = lllllllllllllllIIIIlIIIlIllIIlll[0];
        return new ResourceLocation(lllllllllllllllIIIIlIIIlIllIlIlI.getResourceDomain(), String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIIlIIIlIllIIllI)).append("_").append(lllllllllllllllIIIIlIIIlIllIlIIl).append(".png")));
    }
    
    public static void bindTextureMapForUpdateAndRender(final TextureManager lllllllllllllllIIIIlIIllIlllllll, final ResourceLocation lllllllllllllllIIIIlIIlllIIIIIIl) {
        final TextureMap lllllllllllllllIIIIlIIlllIIIIIII = (TextureMap)lllllllllllllllIIIIlIIllIlllllll.getTexture(lllllllllllllllIIIIlIIlllIIIIIIl);
        Shaders.atlasSizeX = lllllllllllllllIIIIlIIlllIIIIIII.atlasWidth;
        Shaders.atlasSizeY = lllllllllllllllIIIIlIIlllIIIIIII.atlasHeight;
        bindTextures(ShadersTex.updatingTex = lllllllllllllllIIIIlIIlllIIIIIII.getMultiTexID());
    }
    
    public static int[][] prepareAF(final TextureAtlasSprite lllllllllllllllIIIIlIIIIIIlllIll, final int[][] lllllllllllllllIIIIlIIIIIIllIllI, final int lllllllllllllllIIIIlIIIIIIlllIIl, final int lllllllllllllllIIIIlIIIIIIlllIII) {
        final boolean lllllllllllllllIIIIlIIIIIIllIlll = true;
        return lllllllllllllllIIIIlIIIIIIllIllI;
    }
    
    public static void bindTextures(final int lllllllllllllllIIIIlIIllIllllIII) {
        final MultiTexID lllllllllllllllIIIIlIIllIllllIIl = ShadersTex.multiTexMap.get(lllllllllllllllIIIIlIIllIllllIII);
        bindTextures(lllllllllllllllIIIIlIIllIllllIIl);
    }
    
    public static void bindTextures(final MultiTexID lllllllllllllllIIIIlIIlllIIIllIl) {
        ShadersTex.boundTex = lllllllllllllllIIIIlIIlllIIIllIl;
        if (Shaders.isRenderingWorld && GlStateManager.getActiveTextureUnit() == 33984) {
            if (Shaders.configNormalMap) {
                GlStateManager.setActiveTexture(33986);
                GlStateManager.bindTexture(lllllllllllllllIIIIlIIlllIIIllIl.norm);
            }
            if (Shaders.configSpecularMap) {
                GlStateManager.setActiveTexture(33987);
                GlStateManager.bindTexture(lllllllllllllllIIIIlIIlllIIIllIl.spec);
            }
            GlStateManager.setActiveTexture(33984);
        }
        GlStateManager.bindTexture(lllllllllllllllIIIIlIIlllIIIllIl.base);
    }
    
    public static void loadNSMap(final IResourceManager lllllllllllllllIIIIlIIIlIlIlIIll, final ResourceLocation lllllllllllllllIIIIlIIIlIlIlIlll, final int lllllllllllllllIIIIlIIIlIlIlIllI, final int lllllllllllllllIIIIlIIIlIlIlIlIl, final int[] lllllllllllllllIIIIlIIIlIlIIllll) {
        if (Shaders.configNormalMap) {
            loadNSMap1(lllllllllllllllIIIIlIIIlIlIlIIll, getNSMapLocation(lllllllllllllllIIIIlIIIlIlIlIlll, "n"), lllllllllllllllIIIIlIIIlIlIlIllI, lllllllllllllllIIIIlIIIlIlIlIlIl, lllllllllllllllIIIIlIIIlIlIIllll, lllllllllllllllIIIIlIIIlIlIlIllI * lllllllllllllllIIIIlIIIlIlIlIlIl, -8421377);
        }
        if (Shaders.configSpecularMap) {
            loadNSMap1(lllllllllllllllIIIIlIIIlIlIlIIll, getNSMapLocation(lllllllllllllllIIIIlIIIlIlIlIlll, "s"), lllllllllllllllIIIIlIIIlIlIlIllI, lllllllllllllllIIIIlIIIlIlIlIlIl, lllllllllllllllIIIIlIIIlIlIIllll, lllllllllllllllIIIIlIIIlIlIlIllI * lllllllllllllllIIIIlIIIlIlIlIlIl * 2, 0);
        }
    }
}
