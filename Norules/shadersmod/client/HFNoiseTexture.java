package shadersmod.client;

import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import org.lwjgl.*;
import java.nio.*;

public class HFNoiseTexture implements ICustomTexture
{
    private /* synthetic */ int textureUnit;
    private /* synthetic */ int texID;
    
    public int getID() {
        return this.texID;
    }
    
    @Override
    public void deleteTexture() {
        GlStateManager.deleteTexture(this.texID);
        this.texID = 0;
    }
    
    @Override
    public int getTextureId() {
        return this.texID;
    }
    
    @Override
    public int getTextureUnit() {
        return this.textureUnit;
    }
    
    private byte random(final int lllllllllllllIllllIIlllllIIIIlII, final int lllllllllllllIllllIIlllllIIIIIll, final int lllllllllllllIllllIIlllllIIIIlll) {
        final int lllllllllllllIllllIIlllllIIIIllI = (this.random(lllllllllllllIllllIIlllllIIIIlII) + this.random(lllllllllllllIllllIIlllllIIIIIll * 19)) * this.random(lllllllllllllIllllIIlllllIIIIlll * 23) - lllllllllllllIllllIIlllllIIIIlll;
        return (byte)(this.random(lllllllllllllIllllIIlllllIIIIllI) % 128);
    }
    
    private int random(int lllllllllllllIllllIIlllllIIlIIII) {
        lllllllllllllIllllIIlllllIIlIIII ^= lllllllllllllIllllIIlllllIIlIIII << 13;
        lllllllllllllIllllIIlllllIIlIIII ^= lllllllllllllIllllIIlllllIIlIIII >> 17;
        lllllllllllllIllllIIlllllIIlIIII ^= lllllllllllllIllllIIlllllIIlIIII << 5;
        return lllllllllllllIllllIIlllllIIlIIII;
    }
    
    private byte[] genHFNoiseImage(final int lllllllllllllIllllIIllllIllIllll, final int lllllllllllllIllllIIllllIllIlllI) {
        final byte[] lllllllllllllIllllIIllllIlllIlIl = new byte[lllllllllllllIllllIIllllIllIllll * lllllllllllllIllllIIllllIllIlllI * 3];
        int lllllllllllllIllllIIllllIlllIlII = 0;
        for (int lllllllllllllIllllIIllllIlllIIll = 0; lllllllllllllIllllIIllllIlllIIll < lllllllllllllIllllIIllllIllIlllI; ++lllllllllllllIllllIIllllIlllIIll) {
            for (int lllllllllllllIllllIIllllIlllIIlI = 0; lllllllllllllIllllIIllllIlllIIlI < lllllllllllllIllllIIllllIllIllll; ++lllllllllllllIllllIIllllIlllIIlI) {
                for (int lllllllllllllIllllIIllllIlllIIIl = 1; lllllllllllllIllllIIllllIlllIIIl < 4; ++lllllllllllllIllllIIllllIlllIIIl) {
                    lllllllllllllIllllIIllllIlllIlIl[lllllllllllllIllllIIllllIlllIlII++] = this.random(lllllllllllllIllllIIllllIlllIIlI, lllllllllllllIllllIIllllIlllIIll, lllllllllllllIllllIIllllIlllIIIl);
                }
            }
        }
        return lllllllllllllIllllIIllllIlllIlIl;
    }
    
    public HFNoiseTexture(final int lllllllllllllIllllIIlllllIlIIIlI, final int lllllllllllllIllllIIlllllIlIIIIl) {
        this.texID = GL11.glGenTextures();
        this.textureUnit = 15;
        final byte[] lllllllllllllIllllIIlllllIlIIIII = this.genHFNoiseImage(lllllllllllllIllllIIlllllIlIIIlI, lllllllllllllIllllIIlllllIlIIIIl);
        final ByteBuffer lllllllllllllIllllIIlllllIIlllll = BufferUtils.createByteBuffer(lllllllllllllIllllIIlllllIlIIIII.length);
        lllllllllllllIllllIIlllllIIlllll.put(lllllllllllllIllllIIlllllIlIIIII);
        lllllllllllllIllllIIlllllIIlllll.flip();
        GlStateManager.bindTexture(this.texID);
        GL11.glTexImage2D(3553, 0, 6407, lllllllllllllIllllIIlllllIlIIIlI, lllllllllllllIllllIIlllllIlIIIIl, 0, 6407, 5121, lllllllllllllIllllIIlllllIIlllll);
        GL11.glTexParameteri(3553, 10242, 10497);
        GL11.glTexParameteri(3553, 10243, 10497);
        GL11.glTexParameteri(3553, 10240, 9729);
        GL11.glTexParameteri(3553, 10241, 9729);
        GlStateManager.bindTexture(0);
    }
}
