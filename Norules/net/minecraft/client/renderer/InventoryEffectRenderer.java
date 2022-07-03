package net.minecraft.client.renderer;

import net.minecraft.client.gui.inventory.*;
import net.minecraft.inventory.*;
import com.google.common.collect.*;
import net.minecraft.client.resources.*;
import net.minecraft.potion.*;
import java.util.*;

public abstract class InventoryEffectRenderer extends GuiContainer
{
    protected /* synthetic */ boolean hasActivePotionEffects;
    
    @Override
    public void initGui() {
        super.initGui();
        this.updateActivePotionEffects();
    }
    
    public InventoryEffectRenderer(final Container llllllllllllllIIlIIIIIIllIlllIIl) {
        super(llllllllllllllIIlIIIIIIllIlllIIl);
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIlIIIIIIllIlIIlll, final int llllllllllllllIIlIIIIIIllIlIlIlI, final float llllllllllllllIIlIIIIIIllIlIIlIl) {
        super.drawScreen(llllllllllllllIIlIIIIIIllIlIIlll, llllllllllllllIIlIIIIIIllIlIlIlI, llllllllllllllIIlIIIIIIllIlIIlIl);
        if (this.hasActivePotionEffects) {
            this.drawActivePotionEffects();
        }
    }
    
    private void drawActivePotionEffects() {
        final int llllllllllllllIIlIIIIIIllIIllIII = this.guiLeft - 124;
        int llllllllllllllIIlIIIIIIllIIlIlll = this.guiTop;
        final int llllllllllllllIIlIIIIIIllIIlIllI = 166;
        final Collection<PotionEffect> llllllllllllllIIlIIIIIIllIIlIlIl = this.mc.player.getActivePotionEffects();
        if (!llllllllllllllIIlIIIIIIllIIlIlIl.isEmpty()) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableLighting();
            int llllllllllllllIIlIIIIIIllIIlIlII = 33;
            if (llllllllllllllIIlIIIIIIllIIlIlIl.size() > 5) {
                llllllllllllllIIlIIIIIIllIIlIlII = 132 / (llllllllllllllIIlIIIIIIllIIlIlIl.size() - 1);
            }
            for (final PotionEffect llllllllllllllIIlIIIIIIllIIlIIll : Ordering.natural().sortedCopy((Iterable)llllllllllllllIIlIIIIIIllIIlIlIl)) {
                final Potion llllllllllllllIIlIIIIIIllIIlIIlI = llllllllllllllIIlIIIIIIllIIlIIll.getPotion();
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                this.mc.getTextureManager().bindTexture(InventoryEffectRenderer.INVENTORY_BACKGROUND);
                this.drawTexturedModalRect(llllllllllllllIIlIIIIIIllIIllIII, llllllllllllllIIlIIIIIIllIIlIlll, 0, 166, 140, 32);
                if (llllllllllllllIIlIIIIIIllIIlIIlI.hasStatusIcon()) {
                    final int llllllllllllllIIlIIIIIIllIIlIIIl = llllllllllllllIIlIIIIIIllIIlIIlI.getStatusIconIndex();
                    this.drawTexturedModalRect(llllllllllllllIIlIIIIIIllIIllIII + 6, llllllllllllllIIlIIIIIIllIIlIlll + 7, 0 + llllllllllllllIIlIIIIIIllIIlIIIl % 8 * 18, 198 + llllllllllllllIIlIIIIIIllIIlIIIl / 8 * 18, 18, 18);
                }
                String llllllllllllllIIlIIIIIIllIIlIIII = I18n.format(llllllllllllllIIlIIIIIIllIIlIIlI.getName(), new Object[0]);
                if (llllllllllllllIIlIIIIIIllIIlIIll.getAmplifier() == 1) {
                    llllllllllllllIIlIIIIIIllIIlIIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIIIIIIllIIlIIII)).append(" ").append(I18n.format("enchantment.level.2", new Object[0])));
                }
                else if (llllllllllllllIIlIIIIIIllIIlIIll.getAmplifier() == 2) {
                    llllllllllllllIIlIIIIIIllIIlIIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIIIIIIllIIlIIII)).append(" ").append(I18n.format("enchantment.level.3", new Object[0])));
                }
                else if (llllllllllllllIIlIIIIIIllIIlIIll.getAmplifier() == 3) {
                    llllllllllllllIIlIIIIIIllIIlIIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIlIIIIIIllIIlIIII)).append(" ").append(I18n.format("enchantment.level.4", new Object[0])));
                }
                this.fontRendererObj.drawStringWithShadow(llllllllllllllIIlIIIIIIllIIlIIII, (float)(llllllllllllllIIlIIIIIIllIIllIII + 10 + 18), (float)(llllllllllllllIIlIIIIIIllIIlIlll + 6), 16777215);
                final String llllllllllllllIIlIIIIIIllIIIllll = Potion.getPotionDurationString(llllllllllllllIIlIIIIIIllIIlIIll, 1.0f);
                this.fontRendererObj.drawStringWithShadow(llllllllllllllIIlIIIIIIllIIIllll, (float)(llllllllllllllIIlIIIIIIllIIllIII + 10 + 18), (float)(llllllllllllllIIlIIIIIIllIIlIlll + 6 + 10), 8355711);
                llllllllllllllIIlIIIIIIllIIlIlll += llllllllllllllIIlIIIIIIllIIlIlII;
            }
        }
    }
    
    protected void updateActivePotionEffects() {
        if (this.mc.player.getActivePotionEffects().isEmpty()) {
            this.guiLeft = (this.width - this.xSize) / 2;
            this.hasActivePotionEffects = false;
        }
        else {
            this.guiLeft = 160 + (this.width - this.xSize - 200) / 2;
            this.hasActivePotionEffects = true;
        }
    }
}
