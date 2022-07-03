package net.minecraft.client.gui;

import net.minecraft.util.*;
import java.util.*;
import javax.annotation.*;
import com.google.common.collect.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.world.storage.*;
import net.minecraft.client.renderer.*;

public class MapItemRenderer
{
    private static final /* synthetic */ ResourceLocation TEXTURE_MAP_ICONS;
    private final /* synthetic */ TextureManager textureManager;
    private final /* synthetic */ Map<String, Instance> loadedMaps;
    
    public void clearLoadedMaps() {
        for (final Instance lllllllllllllIIIlllIlIIlIllllIlI : this.loadedMaps.values()) {
            this.textureManager.deleteTexture(lllllllllllllIIIlllIlIIlIllllIlI.location);
        }
        this.loadedMaps.clear();
    }
    
    static {
        TEXTURE_MAP_ICONS = new ResourceLocation("textures/map/map_icons.png");
    }
    
    private Instance getMapRendererInstance(final MapData lllllllllllllIIIlllIlIIllIIIlIIl) {
        Instance lllllllllllllIIIlllIlIIllIIIlIII = this.loadedMaps.get(lllllllllllllIIIlllIlIIllIIIlIIl.mapName);
        if (lllllllllllllIIIlllIlIIllIIIlIII == null) {
            lllllllllllllIIIlllIlIIllIIIlIII = new Instance(lllllllllllllIIIlllIlIIllIIIlIIl, (Instance)null);
            this.loadedMaps.put(lllllllllllllIIIlllIlIIllIIIlIIl.mapName, lllllllllllllIIIlllIlIIllIIIlIII);
        }
        return lllllllllllllIIIlllIlIIllIIIlIII;
    }
    
    @Nullable
    public Instance func_191205_a(final String lllllllllllllIIIlllIlIIlIlllllll) {
        return this.loadedMaps.get(lllllllllllllIIIlllIlIIlIlllllll);
    }
    
    public MapItemRenderer(final TextureManager lllllllllllllIIIlllIlIIllIIlllll) {
        this.loadedMaps = (Map<String, Instance>)Maps.newHashMap();
        this.textureManager = lllllllllllllIIIlllIlIIllIIlllll;
    }
    
    @Nullable
    public MapData func_191207_a(@Nullable final Instance lllllllllllllIIIlllIlIIlIlllIIll) {
        return (lllllllllllllIIIlllIlIIlIlllIIll != null) ? lllllllllllllIIIlllIlIIlIlllIIll.mapData : null;
    }
    
    public void updateMapTexture(final MapData lllllllllllllIIIlllIlIIllIIllIIl) {
        this.getMapRendererInstance(lllllllllllllIIIlllIlIIllIIllIIl).updateMapTexture();
    }
    
    public void renderMap(final MapData lllllllllllllIIIlllIlIIllIIlIIlI, final boolean lllllllllllllIIIlllIlIIllIIlIIIl) {
        this.getMapRendererInstance(lllllllllllllIIIlllIlIIllIIlIIlI).render(lllllllllllllIIIlllIlIIllIIlIIIl);
    }
    
    class Instance
    {
        private final /* synthetic */ MapData mapData;
        private final /* synthetic */ ResourceLocation location;
        private final /* synthetic */ int[] mapTextureData;
        private final /* synthetic */ DynamicTexture mapTexture;
        
        private void updateMapTexture() {
            for (int llllllllllllIlllllIlIIllIlllIIII = 0; llllllllllllIlllllIlIIllIlllIIII < 16384; ++llllllllllllIlllllIlIIllIlllIIII) {
                final int llllllllllllIlllllIlIIllIllIllll = this.mapData.colors[llllllllllllIlllllIlIIllIlllIIII] & 0xFF;
                if (llllllllllllIlllllIlIIllIllIllll / 4 == 0) {
                    this.mapTextureData[llllllllllllIlllllIlIIllIlllIIII] = (llllllllllllIlllllIlIIllIlllIIII + llllllllllllIlllllIlIIllIlllIIII / 128 & 0x1) * 8 + 16 << 24;
                }
                else {
                    this.mapTextureData[llllllllllllIlllllIlIIllIlllIIII] = MapColor.COLORS[llllllllllllIlllllIlIIllIllIllll / 4].getMapColor(llllllllllllIlllllIlIIllIllIllll & 0x3);
                }
            }
            this.mapTexture.updateDynamicTexture();
        }
        
        private Instance(final MapData llllllllllllIlllllIlIIllIllllIlI) {
            this.mapData = llllllllllllIlllllIlIIllIllllIlI;
            this.mapTexture = new DynamicTexture(128, 128);
            this.mapTextureData = this.mapTexture.getTextureData();
            this.location = MapItemRenderer.this.textureManager.getDynamicTextureLocation(String.valueOf(new StringBuilder("map/").append(llllllllllllIlllllIlIIllIllllIlI.mapName)), this.mapTexture);
            for (int llllllllllllIlllllIlIIllIllllIIl = 0; llllllllllllIlllllIlIIllIllllIIl < this.mapTextureData.length; ++llllllllllllIlllllIlIIllIllllIIl) {
                this.mapTextureData[llllllllllllIlllllIlIIllIllllIIl] = 0;
            }
        }
        
        private void render(final boolean llllllllllllIlllllIlIIllIlIllIlI) {
            final int llllllllllllIlllllIlIIllIlIllIIl = 0;
            final int llllllllllllIlllllIlIIllIlIllIII = 0;
            final Tessellator llllllllllllIlllllIlIIllIlIlIlll = Tessellator.getInstance();
            final BufferBuilder llllllllllllIlllllIlIIllIlIlIllI = llllllllllllIlllllIlIIllIlIlIlll.getBuffer();
            final float llllllllllllIlllllIlIIllIlIlIlIl = 0.0f;
            MapItemRenderer.this.textureManager.bindTexture(this.location);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE);
            GlStateManager.disableAlpha();
            llllllllllllIlllllIlIIllIlIlIllI.begin(7, DefaultVertexFormats.POSITION_TEX);
            llllllllllllIlllllIlIIllIlIlIllI.pos(0.0, 128.0, -0.009999999776482582).tex(0.0, 1.0).endVertex();
            llllllllllllIlllllIlIIllIlIlIllI.pos(128.0, 128.0, -0.009999999776482582).tex(1.0, 1.0).endVertex();
            llllllllllllIlllllIlIIllIlIlIllI.pos(128.0, 0.0, -0.009999999776482582).tex(1.0, 0.0).endVertex();
            llllllllllllIlllllIlIIllIlIlIllI.pos(0.0, 0.0, -0.009999999776482582).tex(0.0, 0.0).endVertex();
            llllllllllllIlllllIlIIllIlIlIlll.draw();
            GlStateManager.enableAlpha();
            GlStateManager.disableBlend();
            MapItemRenderer.this.textureManager.bindTexture(MapItemRenderer.TEXTURE_MAP_ICONS);
            int llllllllllllIlllllIlIIllIlIlIlII = 0;
            for (final MapDecoration llllllllllllIlllllIlIIllIlIlIIll : this.mapData.mapDecorations.values()) {
                if (!llllllllllllIlllllIlIIllIlIllIlI || llllllllllllIlllllIlIIllIlIlIIll.func_191180_f()) {
                    GlStateManager.pushMatrix();
                    GlStateManager.translate(0.0f + llllllllllllIlllllIlIIllIlIlIIll.getX() / 2.0f + 64.0f, 0.0f + llllllllllllIlllllIlIIllIlIlIIll.getY() / 2.0f + 64.0f, -0.02f);
                    GlStateManager.rotate(llllllllllllIlllllIlIIllIlIlIIll.getRotation() * 360 / 16.0f, 0.0f, 0.0f, 1.0f);
                    GlStateManager.scale(4.0f, 4.0f, 3.0f);
                    GlStateManager.translate(-0.125f, 0.125f, 0.0f);
                    final byte llllllllllllIlllllIlIIllIlIlIIlI = llllllllllllIlllllIlIIllIlIlIIll.getType();
                    final float llllllllllllIlllllIlIIllIlIlIIIl = (llllllllllllIlllllIlIIllIlIlIIlI % 4 + 0) / 4.0f;
                    final float llllllllllllIlllllIlIIllIlIlIIII = (llllllllllllIlllllIlIIllIlIlIIlI / 4 + 0) / 4.0f;
                    final float llllllllllllIlllllIlIIllIlIIllll = (llllllllllllIlllllIlIIllIlIlIIlI % 4 + 1) / 4.0f;
                    final float llllllllllllIlllllIlIIllIlIIlllI = (llllllllllllIlllllIlIIllIlIlIIlI / 4 + 1) / 4.0f;
                    llllllllllllIlllllIlIIllIlIlIllI.begin(7, DefaultVertexFormats.POSITION_TEX);
                    final float llllllllllllIlllllIlIIllIlIIllIl = -0.001f;
                    llllllllllllIlllllIlIIllIlIlIllI.pos(-1.0, 1.0, llllllllllllIlllllIlIIllIlIlIlII * -0.001f).tex(llllllllllllIlllllIlIIllIlIlIIIl, llllllllllllIlllllIlIIllIlIlIIII).endVertex();
                    llllllllllllIlllllIlIIllIlIlIllI.pos(1.0, 1.0, llllllllllllIlllllIlIIllIlIlIlII * -0.001f).tex(llllllllllllIlllllIlIIllIlIIllll, llllllllllllIlllllIlIIllIlIlIIII).endVertex();
                    llllllllllllIlllllIlIIllIlIlIllI.pos(1.0, -1.0, llllllllllllIlllllIlIIllIlIlIlII * -0.001f).tex(llllllllllllIlllllIlIIllIlIIllll, llllllllllllIlllllIlIIllIlIIlllI).endVertex();
                    llllllllllllIlllllIlIIllIlIlIllI.pos(-1.0, -1.0, llllllllllllIlllllIlIIllIlIlIlII * -0.001f).tex(llllllllllllIlllllIlIIllIlIlIIIl, llllllllllllIlllllIlIIllIlIIlllI).endVertex();
                    llllllllllllIlllllIlIIllIlIlIlll.draw();
                    GlStateManager.popMatrix();
                    ++llllllllllllIlllllIlIIllIlIlIlII;
                }
            }
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 0.0f, -0.04f);
            GlStateManager.scale(1.0f, 1.0f, 1.0f);
            GlStateManager.popMatrix();
        }
    }
}
