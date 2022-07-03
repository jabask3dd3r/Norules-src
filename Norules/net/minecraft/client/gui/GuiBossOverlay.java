package net.minecraft.client.gui;

import net.minecraft.util.*;
import net.minecraft.client.*;
import java.util.*;
import net.minecraft.world.*;
import com.google.common.collect.*;
import net.minecraft.client.renderer.*;
import net.minecraft.network.play.server.*;

public class GuiBossOverlay extends Gui
{
    private static final /* synthetic */ ResourceLocation GUI_BARS_TEXTURES;
    private final /* synthetic */ Minecraft client;
    private final /* synthetic */ Map<UUID, BossInfoClient> mapBossInfos;
    
    public boolean shouldPlayEndBossMusic() {
        if (!this.mapBossInfos.isEmpty()) {
            for (final BossInfo lllllllllllllIllIllIllIIIIllllll : this.mapBossInfos.values()) {
                if (lllllllllllllIllIllIllIIIIllllll.shouldPlayEndBossMusic()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean shouldDarkenSky() {
        if (!this.mapBossInfos.isEmpty()) {
            for (final BossInfo lllllllllllllIllIllIllIIIIllIlll : this.mapBossInfos.values()) {
                if (lllllllllllllIllIllIllIIIIllIlll.shouldDarkenSky()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public GuiBossOverlay(final Minecraft lllllllllllllIllIllIllIIIlllIIll) {
        this.mapBossInfos = (Map<UUID, BossInfoClient>)Maps.newLinkedHashMap();
        this.client = lllllllllllllIllIllIllIIIlllIIll;
    }
    
    private void render(final int lllllllllllllIllIllIllIIIlIlIIII, final int lllllllllllllIllIllIllIIIlIIllll, final BossInfo lllllllllllllIllIllIllIIIlIIlllI) {
        this.drawTexturedModalRect(lllllllllllllIllIllIllIIIlIlIIII, lllllllllllllIllIllIllIIIlIIllll, 0, lllllllllllllIllIllIllIIIlIIlllI.getColor().ordinal() * 5 * 2, 182, 5);
        if (lllllllllllllIllIllIllIIIlIIlllI.getOverlay() != BossInfo.Overlay.PROGRESS) {
            this.drawTexturedModalRect(lllllllllllllIllIllIllIIIlIlIIII, lllllllllllllIllIllIllIIIlIIllll, 0, 80 + (lllllllllllllIllIllIllIIIlIIlllI.getOverlay().ordinal() - 1) * 5 * 2, 182, 5);
        }
        final int lllllllllllllIllIllIllIIIlIlIIlI = (int)(lllllllllllllIllIllIllIIIlIIlllI.getPercent() * 183.0f);
        if (lllllllllllllIllIllIllIIIlIlIIlI > 0) {
            this.drawTexturedModalRect(lllllllllllllIllIllIllIIIlIlIIII, lllllllllllllIllIllIllIIIlIIllll, 0, lllllllllllllIllIllIllIIIlIIlllI.getColor().ordinal() * 5 * 2 + 5, lllllllllllllIllIllIllIIIlIlIIlI, 5);
            if (lllllllllllllIllIllIllIIIlIIlllI.getOverlay() != BossInfo.Overlay.PROGRESS) {
                this.drawTexturedModalRect(lllllllllllllIllIllIllIIIlIlIIII, lllllllllllllIllIllIllIIIlIIllll, 0, 80 + (lllllllllllllIllIllIllIIIlIIlllI.getOverlay().ordinal() - 1) * 5 * 2 + 5, lllllllllllllIllIllIllIIIlIlIIlI, 5);
            }
        }
    }
    
    public boolean shouldCreateFog() {
        if (!this.mapBossInfos.isEmpty()) {
            for (final BossInfo lllllllllllllIllIllIllIIIIlIllll : this.mapBossInfos.values()) {
                if (lllllllllllllIllIllIllIIIIlIllll.shouldCreateFog()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void renderBossHealth() {
        if (!this.mapBossInfos.isEmpty()) {
            final ScaledResolution lllllllllllllIllIllIllIIIllIlIIl = new ScaledResolution(this.client);
            final int lllllllllllllIllIllIllIIIllIlIII = lllllllllllllIllIllIllIIIllIlIIl.getScaledWidth();
            int lllllllllllllIllIllIllIIIllIIlll = 12;
            for (final BossInfoClient lllllllllllllIllIllIllIIIllIIllI : this.mapBossInfos.values()) {
                final int lllllllllllllIllIllIllIIIllIIlIl = lllllllllllllIllIllIllIIIllIlIII / 2 - 91;
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                this.client.getTextureManager().bindTexture(GuiBossOverlay.GUI_BARS_TEXTURES);
                this.render(lllllllllllllIllIllIllIIIllIIlIl, lllllllllllllIllIllIllIIIllIIlll, lllllllllllllIllIllIllIIIllIIllI);
                final String lllllllllllllIllIllIllIIIllIIlII = lllllllllllllIllIllIllIIIllIIllI.getName().getFormattedText();
                this.client.fontRendererObj.drawStringWithShadow(lllllllllllllIllIllIllIIIllIIlII, (float)(lllllllllllllIllIllIllIIIllIlIII / 2 - this.client.fontRendererObj.getStringWidth(lllllllllllllIllIllIllIIIllIIlII) / 2), (float)(lllllllllllllIllIllIllIIIllIIlll - 9), 16777215);
                lllllllllllllIllIllIllIIIllIIlll += 10 + this.client.fontRendererObj.FONT_HEIGHT;
                if (lllllllllllllIllIllIllIIIllIIlll >= lllllllllllllIllIllIllIIIllIlIIl.getScaledHeight() / 3) {
                    break;
                }
            }
        }
    }
    
    static {
        GUI_BARS_TEXTURES = new ResourceLocation("textures/gui/bars.png");
    }
    
    public void clearBossInfos() {
        this.mapBossInfos.clear();
    }
    
    public void read(final SPacketUpdateBossInfo lllllllllllllIllIllIllIIIlIIIlll) {
        if (lllllllllllllIllIllIllIIIlIIIlll.getOperation() == SPacketUpdateBossInfo.Operation.ADD) {
            this.mapBossInfos.put(lllllllllllllIllIllIllIIIlIIIlll.getUniqueId(), new BossInfoClient(lllllllllllllIllIllIllIIIlIIIlll));
        }
        else if (lllllllllllllIllIllIllIIIlIIIlll.getOperation() == SPacketUpdateBossInfo.Operation.REMOVE) {
            this.mapBossInfos.remove(lllllllllllllIllIllIllIIIlIIIlll.getUniqueId());
        }
        else {
            this.mapBossInfos.get(lllllllllllllIllIllIllIIIlIIIlll.getUniqueId()).updateFromPacket(lllllllllllllIllIllIllIIIlIIIlll);
        }
    }
}
