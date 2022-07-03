package net.minecraft.client.renderer.tileentity;

import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.tileentity.*;

public class TileEntityEnchantmentTableRenderer extends TileEntitySpecialRenderer<TileEntityEnchantmentTable>
{
    private static final /* synthetic */ ResourceLocation TEXTURE_BOOK;
    private final /* synthetic */ ModelBook modelBook;
    
    @Override
    public void func_192841_a(final TileEntityEnchantmentTable lllllllllllllllIlIlIIlIllIIlIIlI, final double lllllllllllllllIlIlIIlIllIIlIIIl, final double lllllllllllllllIlIlIIlIllIIlIIII, final double lllllllllllllllIlIlIIlIllIIIIIII, final float lllllllllllllllIlIlIIlIlIlllllll, final int lllllllllllllllIlIlIIlIllIIIllIl, final float lllllllllllllllIlIlIIlIllIIIllII) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllllllIlIlIIlIllIIlIIIl + 0.5f, (float)lllllllllllllllIlIlIIlIllIIlIIII + 0.75f, (float)lllllllllllllllIlIlIIlIllIIIIIII + 0.5f);
        final float lllllllllllllllIlIlIIlIllIIIlIll = lllllllllllllllIlIlIIlIllIIlIIlI.tickCount + lllllllllllllllIlIlIIlIlIlllllll;
        GlStateManager.translate(0.0f, 0.1f + MathHelper.sin(lllllllllllllllIlIlIIlIllIIIlIll * 0.1f) * 0.01f, 0.0f);
        float lllllllllllllllIlIlIIlIllIIIlIlI;
        for (lllllllllllllllIlIlIIlIllIIIlIlI = lllllllllllllllIlIlIIlIllIIlIIlI.bookRotation - lllllllllllllllIlIlIIlIllIIlIIlI.bookRotationPrev; lllllllllllllllIlIlIIlIllIIIlIlI >= 3.1415927f; lllllllllllllllIlIlIIlIllIIIlIlI -= 6.2831855f) {}
        while (lllllllllllllllIlIlIIlIllIIIlIlI < -3.1415927f) {
            lllllllllllllllIlIlIIlIllIIIlIlI += 6.2831855f;
        }
        final float lllllllllllllllIlIlIIlIllIIIlIIl = lllllllllllllllIlIlIIlIllIIlIIlI.bookRotationPrev + lllllllllllllllIlIlIIlIllIIIlIlI * lllllllllllllllIlIlIIlIlIlllllll;
        GlStateManager.rotate(-lllllllllllllllIlIlIIlIllIIIlIIl * 57.295776f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(80.0f, 0.0f, 0.0f, 1.0f);
        this.bindTexture(TileEntityEnchantmentTableRenderer.TEXTURE_BOOK);
        float lllllllllllllllIlIlIIlIllIIIlIII = lllllllllllllllIlIlIIlIllIIlIIlI.pageFlipPrev + (lllllllllllllllIlIlIIlIllIIlIIlI.pageFlip - lllllllllllllllIlIlIIlIllIIlIIlI.pageFlipPrev) * lllllllllllllllIlIlIIlIlIlllllll + 0.25f;
        float lllllllllllllllIlIlIIlIllIIIIlll = lllllllllllllllIlIlIIlIllIIlIIlI.pageFlipPrev + (lllllllllllllllIlIlIIlIllIIlIIlI.pageFlip - lllllllllllllllIlIlIIlIllIIlIIlI.pageFlipPrev) * lllllllllllllllIlIlIIlIlIlllllll + 0.75f;
        lllllllllllllllIlIlIIlIllIIIlIII = (lllllllllllllllIlIlIIlIllIIIlIII - MathHelper.fastFloor(lllllllllllllllIlIlIIlIllIIIlIII)) * 1.6f - 0.3f;
        lllllllllllllllIlIlIIlIllIIIIlll = (lllllllllllllllIlIlIIlIllIIIIlll - MathHelper.fastFloor(lllllllllllllllIlIlIIlIllIIIIlll)) * 1.6f - 0.3f;
        if (lllllllllllllllIlIlIIlIllIIIlIII < 0.0f) {
            lllllllllllllllIlIlIIlIllIIIlIII = 0.0f;
        }
        if (lllllllllllllllIlIlIIlIllIIIIlll < 0.0f) {
            lllllllllllllllIlIlIIlIllIIIIlll = 0.0f;
        }
        if (lllllllllllllllIlIlIIlIllIIIlIII > 1.0f) {
            lllllllllllllllIlIlIIlIllIIIlIII = 1.0f;
        }
        if (lllllllllllllllIlIlIIlIllIIIIlll > 1.0f) {
            lllllllllllllllIlIlIIlIllIIIIlll = 1.0f;
        }
        final float lllllllllllllllIlIlIIlIllIIIIllI = lllllllllllllllIlIlIIlIllIIlIIlI.bookSpreadPrev + (lllllllllllllllIlIlIIlIllIIlIIlI.bookSpread - lllllllllllllllIlIlIIlIllIIlIIlI.bookSpreadPrev) * lllllllllllllllIlIlIIlIlIlllllll;
        GlStateManager.enableCull();
        this.modelBook.render(null, lllllllllllllllIlIlIIlIllIIIlIll, lllllllllllllllIlIlIIlIllIIIlIII, lllllllllllllllIlIlIIlIllIIIIlll, lllllllllllllllIlIlIIlIllIIIIllI, 0.0f, 0.0625f);
        GlStateManager.popMatrix();
    }
    
    public TileEntityEnchantmentTableRenderer() {
        this.modelBook = new ModelBook();
    }
    
    static {
        TEXTURE_BOOK = new ResourceLocation("textures/entity/enchanting_table_book.png");
    }
}
