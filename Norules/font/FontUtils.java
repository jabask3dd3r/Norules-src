package font;

import net.minecraft.client.renderer.vertex.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;

public class FontUtils
{
    private static final /* synthetic */ Tessellator tessellator;
    
    public static void drawTextureRect(final float llllllllllllIllllllIIlllIlIlIllI, final float llllllllllllIllllllIIlllIlIllllI, final float llllllllllllIllllllIIlllIlIlIlII, final float llllllllllllIllllllIIlllIlIlIIll, final float llllllllllllIllllllIIlllIlIlIIlI, final float llllllllllllIllllllIIlllIlIllIlI, final float llllllllllllIllllllIIlllIlIllIIl, final float llllllllllllIllllllIIlllIlIllIII) {
        final BufferBuilder llllllllllllIllllllIIlllIlIlIlll = FontUtils.tessellator.getBuffer();
        llllllllllllIllllllIIlllIlIlIlll.begin(4, DefaultVertexFormats.POSITION_TEX);
        llllllllllllIllllllIIlllIlIlIlll.pos(llllllllllllIllllllIIlllIlIlIllI + llllllllllllIllllllIIlllIlIlIlII, llllllllllllIllllllIIlllIlIllllI, 0.0).tex(llllllllllllIllllllIIlllIlIllIIl, llllllllllllIllllllIIlllIlIllIlI).endVertex();
        llllllllllllIllllllIIlllIlIlIlll.pos(llllllllllllIllllllIIlllIlIlIllI, llllllllllllIllllllIIlllIlIllllI, 0.0).tex(llllllllllllIllllllIIlllIlIlIIlI, llllllllllllIllllllIIlllIlIllIlI).endVertex();
        llllllllllllIllllllIIlllIlIlIlll.pos(llllllllllllIllllllIIlllIlIlIllI, llllllllllllIllllllIIlllIlIllllI + llllllllllllIllllllIIlllIlIlIIll, 0.0).tex(llllllllllllIllllllIIlllIlIlIIlI, llllllllllllIllllllIIlllIlIllIII).endVertex();
        llllllllllllIllllllIIlllIlIlIlll.pos(llllllllllllIllllllIIlllIlIlIllI, llllllllllllIllllllIIlllIlIllllI + llllllllllllIllllllIIlllIlIlIIll, 0.0).tex(llllllllllllIllllllIIlllIlIlIIlI, llllllllllllIllllllIIlllIlIllIII).endVertex();
        llllllllllllIllllllIIlllIlIlIlll.pos(llllllllllllIllllllIIlllIlIlIllI + llllllllllllIllllllIIlllIlIlIlII, llllllllllllIllllllIIlllIlIllllI + llllllllllllIllllllIIlllIlIlIIll, 0.0).tex(llllllllllllIllllllIIlllIlIllIIl, llllllllllllIllllllIIlllIlIllIII).endVertex();
        llllllllllllIllllllIIlllIlIlIlll.pos(llllllllllllIllllllIIlllIlIlIllI + llllllllllllIllllllIIlllIlIlIlII, llllllllllllIllllllIIlllIlIllllI, 0.0).tex(llllllllllllIllllllIIlllIlIllIIl, llllllllllllIllllllIIlllIlIllIlI).endVertex();
        FontUtils.tessellator.draw();
    }
    
    public static void drawTextureRect(final float llllllllllllIllllllIIlllIIlllIIl, final float llllllllllllIllllllIIlllIlIIIIlI, final float llllllllllllIllllllIIlllIlIIIIIl, final float llllllllllllIllllllIIlllIIllIllI, final float llllllllllllIllllllIIlllIIllllll, final float llllllllllllIllllllIIlllIIllIlII, final float llllllllllllIllllllIIlllIIllllIl, final float llllllllllllIllllllIIlllIIllllII, final float llllllllllllIllllllIIlllIIllIIIl) {
        final BufferBuilder llllllllllllIllllllIIlllIIlllIlI = FontUtils.tessellator.getBuffer();
        llllllllllllIllllllIIlllIIlllIlI.begin(4, DefaultVertexFormats.POSITION_TEX);
        llllllllllllIllllllIIlllIIlllIlI.pos(llllllllllllIllllllIIlllIIlllIIl + llllllllllllIllllllIIlllIlIIIIIl, llllllllllllIllllllIIlllIlIIIIlI, llllllllllllIllllllIIlllIIllIIIl).tex(llllllllllllIllllllIIlllIIllllIl, llllllllllllIllllllIIlllIIllIlII).endVertex();
        llllllllllllIllllllIIlllIIlllIlI.pos(llllllllllllIllllllIIlllIIlllIIl, llllllllllllIllllllIIlllIlIIIIlI, llllllllllllIllllllIIlllIIllIIIl).tex(llllllllllllIllllllIIlllIIllllll, llllllllllllIllllllIIlllIIllIlII).endVertex();
        llllllllllllIllllllIIlllIIlllIlI.pos(llllllllllllIllllllIIlllIIlllIIl, llllllllllllIllllllIIlllIlIIIIlI + llllllllllllIllllllIIlllIIllIllI, llllllllllllIllllllIIlllIIllIIIl).tex(llllllllllllIllllllIIlllIIllllll, llllllllllllIllllllIIlllIIllllII).endVertex();
        llllllllllllIllllllIIlllIIlllIlI.pos(llllllllllllIllllllIIlllIIlllIIl, llllllllllllIllllllIIlllIlIIIIlI + llllllllllllIllllllIIlllIIllIllI, llllllllllllIllllllIIlllIIllIIIl).tex(llllllllllllIllllllIIlllIIllllll, llllllllllllIllllllIIlllIIllllII).endVertex();
        llllllllllllIllllllIIlllIIlllIlI.pos(llllllllllllIllllllIIlllIIlllIIl + llllllllllllIllllllIIlllIlIIIIIl, llllllllllllIllllllIIlllIlIIIIlI + llllllllllllIllllllIIlllIIllIllI, llllllllllllIllllllIIlllIIllIIIl).tex(llllllllllllIllllllIIlllIIllllIl, llllllllllllIllllllIIlllIIllllII).endVertex();
        llllllllllllIllllllIIlllIIlllIlI.pos(llllllllllllIllllllIIlllIIlllIIl + llllllllllllIllllllIIlllIlIIIIIl, llllllllllllIllllllIIlllIlIIIIlI, llllllllllllIllllllIIlllIIllIIIl).tex(llllllllllllIllllllIIlllIIllllIl, llllllllllllIllllllIIlllIIllIlII).endVertex();
        FontUtils.tessellator.draw();
    }
    
    static {
        tessellator = Tessellator.getInstance();
    }
    
    public static void drawLine(final float llllllllllllIllllllIIlllIIlIlIIl, final float llllllllllllIllllllIIlllIIlIIIlI, final float llllllllllllIllllllIIlllIIlIIIIl, final float llllllllllllIllllllIIlllIIlIIIII, final float llllllllllllIllllllIIlllIIlIIlIl) {
        GL11.glLineWidth(llllllllllllIllllllIIlllIIlIlIIl);
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        final BufferBuilder llllllllllllIllllllIIlllIIlIIlII = FontUtils.tessellator.getBuffer();
        llllllllllllIllllllIIlllIIlIIlII.begin(1, DefaultVertexFormats.POSITION);
        llllllllllllIllllllIIlllIIlIIlII.pos(llllllllllllIllllllIIlllIIlIIIlI, llllllllllllIllllllIIlllIIlIIIIl, 0.0).endVertex();
        llllllllllllIllllllIIlllIIlIIlII.pos(llllllllllllIllllllIIlllIIlIIIII, llllllllllllIllllllIIlllIIlIIlIl, 0.0).endVertex();
        FontUtils.tessellator.draw();
        GlStateManager.enableTexture2D();
    }
}
