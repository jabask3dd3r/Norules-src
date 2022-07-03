package net.minecraft.client.gui;

import java.util.*;
import java.io.*;
import com.google.common.collect.*;
import net.minecraft.world.gen.*;
import net.minecraft.util.*;
import net.minecraft.client.resources.*;
import org.lwjgl.input.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public class GuiScreenCustomizePresets extends GuiScreen
{
    protected /* synthetic */ String title;
    private /* synthetic */ GuiTextField export;
    private final /* synthetic */ GuiCustomizeWorldScreen parent;
    private /* synthetic */ String shareText;
    private /* synthetic */ String listText;
    private static final /* synthetic */ List<Info> PRESETS;
    private /* synthetic */ GuiButton select;
    private /* synthetic */ ListPreset list;
    
    private boolean hasValidSelection() {
        return (this.list.selected > -1 && this.list.selected < GuiScreenCustomizePresets.PRESETS.size()) || this.export.getText().length() > 1;
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.list.handleMouseInput();
    }
    
    static {
        PRESETS = Lists.newArrayList();
        ChunkGeneratorSettings.Factory lllllllllllllIllIlIIIlIlIlIIIllI = ChunkGeneratorSettings.Factory.jsonToFactory("{ \"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":5000.0, \"mainNoiseScaleY\":1000.0, \"mainNoiseScaleZ\":5000.0, \"baseSize\":8.5, \"stretchY\":8.0, \"biomeDepthWeight\":2.0, \"biomeDepthOffset\":0.5, \"biomeScaleWeight\":2.0, \"biomeScaleOffset\":0.375, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":255 }");
        ResourceLocation lllllllllllllIllIlIIIlIlIlIIIlIl = new ResourceLocation("textures/gui/presets/water.png");
        GuiScreenCustomizePresets.PRESETS.add(new Info(I18n.format("createWorld.customize.custom.preset.waterWorld", new Object[0]), lllllllllllllIllIlIIIlIlIlIIIlIl, lllllllllllllIllIlIIIlIlIlIIIllI));
        lllllllllllllIllIlIIIlIlIlIIIllI = ChunkGeneratorSettings.Factory.jsonToFactory("{\"coordinateScale\":3000.0, \"heightScale\":6000.0, \"upperLimitScale\":250.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":80.0, \"mainNoiseScaleY\":160.0, \"mainNoiseScaleZ\":80.0, \"baseSize\":8.5, \"stretchY\":10.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":63 }");
        lllllllllllllIllIlIIIlIlIlIIIlIl = new ResourceLocation("textures/gui/presets/isles.png");
        GuiScreenCustomizePresets.PRESETS.add(new Info(I18n.format("createWorld.customize.custom.preset.isleLand", new Object[0]), lllllllllllllIllIlIIIlIlIlIIIlIl, lllllllllllllIllIlIIIlIlIlIIIllI));
        lllllllllllllIllIlIIIlIlIlIIIllI = ChunkGeneratorSettings.Factory.jsonToFactory("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":5000.0, \"mainNoiseScaleY\":1000.0, \"mainNoiseScaleZ\":5000.0, \"baseSize\":8.5, \"stretchY\":5.0, \"biomeDepthWeight\":2.0, \"biomeDepthOffset\":1.0, \"biomeScaleWeight\":4.0, \"biomeScaleOffset\":1.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":63 }");
        lllllllllllllIllIlIIIlIlIlIIIlIl = new ResourceLocation("textures/gui/presets/delight.png");
        GuiScreenCustomizePresets.PRESETS.add(new Info(I18n.format("createWorld.customize.custom.preset.caveDelight", new Object[0]), lllllllllllllIllIlIIIlIlIlIIIlIl, lllllllllllllIllIlIIIlIlIlIIIllI));
        lllllllllllllIllIlIIIlIlIlIIIllI = ChunkGeneratorSettings.Factory.jsonToFactory("{\"coordinateScale\":738.41864, \"heightScale\":157.69133, \"upperLimitScale\":801.4267, \"lowerLimitScale\":1254.1643, \"depthNoiseScaleX\":374.93652, \"depthNoiseScaleZ\":288.65228, \"depthNoiseScaleExponent\":1.2092624, \"mainNoiseScaleX\":1355.9908, \"mainNoiseScaleY\":745.5343, \"mainNoiseScaleZ\":1183.464, \"baseSize\":1.8758626, \"stretchY\":1.7137525, \"biomeDepthWeight\":1.7553768, \"biomeDepthOffset\":3.4701107, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":2.535211, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":63 }");
        lllllllllllllIllIlIIIlIlIlIIIlIl = new ResourceLocation("textures/gui/presets/madness.png");
        GuiScreenCustomizePresets.PRESETS.add(new Info(I18n.format("createWorld.customize.custom.preset.mountains", new Object[0]), lllllllllllllIllIlIIIlIlIlIIIlIl, lllllllllllllIllIlIIIlIlIlIIIllI));
        lllllllllllllIllIlIIIlIlIlIIIllI = ChunkGeneratorSettings.Factory.jsonToFactory("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":1000.0, \"mainNoiseScaleY\":3000.0, \"mainNoiseScaleZ\":1000.0, \"baseSize\":8.5, \"stretchY\":10.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":20 }");
        lllllllllllllIllIlIIIlIlIlIIIlIl = new ResourceLocation("textures/gui/presets/drought.png");
        GuiScreenCustomizePresets.PRESETS.add(new Info(I18n.format("createWorld.customize.custom.preset.drought", new Object[0]), lllllllllllllIllIlIIIlIlIlIIIlIl, lllllllllllllIllIlIIIlIlIlIIIllI));
        lllllllllllllIllIlIIIlIlIlIIIllI = ChunkGeneratorSettings.Factory.jsonToFactory("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":2.0, \"lowerLimitScale\":64.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":80.0, \"mainNoiseScaleY\":160.0, \"mainNoiseScaleZ\":80.0, \"baseSize\":8.5, \"stretchY\":12.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":6 }");
        lllllllllllllIllIlIIIlIlIlIIIlIl = new ResourceLocation("textures/gui/presets/chaos.png");
        GuiScreenCustomizePresets.PRESETS.add(new Info(I18n.format("createWorld.customize.custom.preset.caveChaos", new Object[0]), lllllllllllllIllIlIIIlIlIlIIIlIl, lllllllllllllIllIlIIIlIlIlIIIllI));
        lllllllllllllIllIlIIIlIlIlIIIllI = ChunkGeneratorSettings.Factory.jsonToFactory("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":80.0, \"mainNoiseScaleY\":160.0, \"mainNoiseScaleZ\":80.0, \"baseSize\":8.5, \"stretchY\":12.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":true, \"seaLevel\":40 }");
        lllllllllllllIllIlIIIlIlIlIIIlIl = new ResourceLocation("textures/gui/presets/luck.png");
        GuiScreenCustomizePresets.PRESETS.add(new Info(I18n.format("createWorld.customize.custom.preset.goodLuck", new Object[0]), lllllllllllllIllIlIIIlIlIlIIIlIl, lllllllllllllIllIlIIIlIlIlIIIllI));
    }
    
    public GuiScreenCustomizePresets(final GuiCustomizeWorldScreen lllllllllllllIllIlIIIlIlIIllllll) {
        this.title = "Customize World Presets";
        this.parent = lllllllllllllIllIlIIIlIlIIllllll;
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIllIlIIIlIlIIIlllIl) throws IOException {
        switch (lllllllllllllIllIlIIIlIlIIIlllIl.id) {
            case 0: {
                this.parent.loadValues(this.export.getText());
                this.mc.displayGuiScreen(this.parent);
                break;
            }
            case 1: {
                this.mc.displayGuiScreen(this.parent);
                break;
            }
        }
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllIllIlIIIlIlIIlIIIlI, final int lllllllllllllIllIlIIIlIlIIlIIIIl) throws IOException {
        if (!this.export.textboxKeyTyped(lllllllllllllIllIlIIIlIlIIlIIIlI, lllllllllllllIllIlIIIlIlIIlIIIIl)) {
            super.keyTyped(lllllllllllllIllIlIIIlIlIIlIIIlI, lllllllllllllIllIlIIIlIlIIlIIIIl);
        }
    }
    
    @Override
    public void updateScreen() {
        this.export.updateCursorCounter();
        super.updateScreen();
    }
    
    public void updateButtonValidity() {
        this.select.enabled = this.hasValidSelection();
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        this.title = I18n.format("createWorld.customize.custom.presets.title", new Object[0]);
        this.shareText = I18n.format("createWorld.customize.presets.share", new Object[0]);
        this.listText = I18n.format("createWorld.customize.presets.list", new Object[0]);
        this.export = new GuiTextField(2, this.fontRendererObj, 50, 40, this.width - 100, 20);
        this.list = new ListPreset();
        this.export.setMaxStringLength(2000);
        this.export.setText(this.parent.saveValues());
        this.select = this.addButton(new GuiButton(0, this.width / 2 - 102, this.height - 27, 100, 20, I18n.format("createWorld.customize.presets.select", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 + 3, this.height - 27, 100, 20, I18n.format("gui.cancel", new Object[0])));
        this.updateButtonValidity();
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIllIlIIIlIlIIIlIIIl, final int lllllllllllllIllIlIIIlIlIIIlIlII, final float lllllllllllllIllIlIIIlIlIIIIllll) {
        this.drawDefaultBackground();
        this.list.drawScreen(lllllllllllllIllIlIIIlIlIIIlIIIl, lllllllllllllIllIlIIIlIlIIIlIlII, lllllllllllllIllIlIIIlIlIIIIllll);
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 8, 16777215);
        this.drawString(this.fontRendererObj, this.shareText, 50, 30, 10526880);
        this.drawString(this.fontRendererObj, this.listText, 50, 70, 10526880);
        this.export.drawTextBox();
        super.drawScreen(lllllllllllllIllIlIIIlIlIIIlIIIl, lllllllllllllIllIlIIIlIlIIIlIlII, lllllllllllllIllIlIIIlIlIIIIllll);
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllIllIlIIIlIlIIllIIII, final int lllllllllllllIllIlIIIlIlIIlIllll, final int lllllllllllllIllIlIIIlIlIIlIlIlI) throws IOException {
        this.export.mouseClicked(lllllllllllllIllIlIIIlIlIIllIIII, lllllllllllllIllIlIIIlIlIIlIllll, lllllllllllllIllIlIIIlIlIIlIlIlI);
        super.mouseClicked(lllllllllllllIllIlIIIlIlIIllIIII, lllllllllllllIllIlIIIlIlIIlIllll, lllllllllllllIllIlIIIlIlIIlIlIlI);
    }
    
    class ListPreset extends GuiSlot
    {
        public /* synthetic */ int selected;
        
        @Override
        protected boolean isSelected(final int llllllllllllllllIlIlIlIlIllllIIl) {
            return llllllllllllllllIlIlIlIlIllllIIl == this.selected;
        }
        
        @Override
        protected void elementClicked(final int llllllllllllllllIlIlIlIlIlllllIl, final boolean llllllllllllllllIlIlIlIllIIIIIIl, final int llllllllllllllllIlIlIlIllIIIIIII, final int llllllllllllllllIlIlIlIlIlllllll) {
            this.selected = llllllllllllllllIlIlIlIlIlllllIl;
            GuiScreenCustomizePresets.this.updateButtonValidity();
            GuiScreenCustomizePresets.this.export.setText(GuiScreenCustomizePresets.PRESETS.get(GuiScreenCustomizePresets.this.list.selected).settings.toString());
        }
        
        @Override
        protected void drawBackground() {
        }
        
        @Override
        protected int getSize() {
            return GuiScreenCustomizePresets.PRESETS.size();
        }
        
        @Override
        protected void func_192637_a(final int llllllllllllllllIlIlIlIlIlIlIlII, final int llllllllllllllllIlIlIlIlIlIlIIll, final int llllllllllllllllIlIlIlIlIlIIlIIl, final int llllllllllllllllIlIlIlIlIlIlIIIl, final int llllllllllllllllIlIlIlIlIlIlIIII, final int llllllllllllllllIlIlIlIlIlIIllll, final float llllllllllllllllIlIlIlIlIlIIlllI) {
            final Info llllllllllllllllIlIlIlIlIlIIllIl = GuiScreenCustomizePresets.PRESETS.get(llllllllllllllllIlIlIlIlIlIlIlII);
            this.blitIcon(llllllllllllllllIlIlIlIlIlIlIIll, llllllllllllllllIlIlIlIlIlIIlIIl, llllllllllllllllIlIlIlIlIlIIllIl.texture);
            GuiScreenCustomizePresets.this.fontRendererObj.drawString(llllllllllllllllIlIlIlIlIlIIllIl.name, llllllllllllllllIlIlIlIlIlIlIIll + 32 + 10, llllllllllllllllIlIlIlIlIlIIlIIl + 14, 16777215);
        }
        
        private void blitIcon(final int llllllllllllllllIlIlIlIlIllIIIlI, final int llllllllllllllllIlIlIlIlIllIIIIl, final ResourceLocation llllllllllllllllIlIlIlIlIllIlIIl) {
            final int llllllllllllllllIlIlIlIlIllIlIII = llllllllllllllllIlIlIlIlIllIIIlI + 5;
            GuiScreenCustomizePresets.this.drawHorizontalLine(llllllllllllllllIlIlIlIlIllIlIII - 1, llllllllllllllllIlIlIlIlIllIlIII + 32, llllllllllllllllIlIlIlIlIllIIIIl - 1, -2039584);
            GuiScreenCustomizePresets.this.drawHorizontalLine(llllllllllllllllIlIlIlIlIllIlIII - 1, llllllllllllllllIlIlIlIlIllIlIII + 32, llllllllllllllllIlIlIlIlIllIIIIl + 32, -6250336);
            GuiScreenCustomizePresets.this.drawVerticalLine(llllllllllllllllIlIlIlIlIllIlIII - 1, llllllllllllllllIlIlIlIlIllIIIIl - 1, llllllllllllllllIlIlIlIlIllIIIIl + 32, -2039584);
            GuiScreenCustomizePresets.this.drawVerticalLine(llllllllllllllllIlIlIlIlIllIlIII + 32, llllllllllllllllIlIlIlIlIllIIIIl - 1, llllllllllllllllIlIlIlIlIllIIIIl + 32, -6250336);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getTextureManager().bindTexture(llllllllllllllllIlIlIlIlIllIlIIl);
            final int llllllllllllllllIlIlIlIlIllIIlll = 32;
            final int llllllllllllllllIlIlIlIlIllIIllI = 32;
            final Tessellator llllllllllllllllIlIlIlIlIllIIlIl = Tessellator.getInstance();
            final BufferBuilder llllllllllllllllIlIlIlIlIllIIlII = llllllllllllllllIlIlIlIlIllIIlIl.getBuffer();
            llllllllllllllllIlIlIlIlIllIIlII.begin(7, DefaultVertexFormats.POSITION_TEX);
            llllllllllllllllIlIlIlIlIllIIlII.pos(llllllllllllllllIlIlIlIlIllIlIII + 0, llllllllllllllllIlIlIlIlIllIIIIl + 32, 0.0).tex(0.0, 1.0).endVertex();
            llllllllllllllllIlIlIlIlIllIIlII.pos(llllllllllllllllIlIlIlIlIllIlIII + 32, llllllllllllllllIlIlIlIlIllIIIIl + 32, 0.0).tex(1.0, 1.0).endVertex();
            llllllllllllllllIlIlIlIlIllIIlII.pos(llllllllllllllllIlIlIlIlIllIlIII + 32, llllllllllllllllIlIlIlIlIllIIIIl + 0, 0.0).tex(1.0, 0.0).endVertex();
            llllllllllllllllIlIlIlIlIllIIlII.pos(llllllllllllllllIlIlIlIlIllIlIII + 0, llllllllllllllllIlIlIlIlIllIIIIl + 0, 0.0).tex(0.0, 0.0).endVertex();
            llllllllllllllllIlIlIlIlIllIIlIl.draw();
        }
        
        public ListPreset() {
            super(GuiScreenCustomizePresets.this.mc, GuiScreenCustomizePresets.this.width, GuiScreenCustomizePresets.this.height, 80, GuiScreenCustomizePresets.this.height - 32, 38);
            this.selected = -1;
        }
    }
    
    static class Info
    {
        public /* synthetic */ ResourceLocation texture;
        public /* synthetic */ ChunkGeneratorSettings.Factory settings;
        public /* synthetic */ String name;
        
        public Info(final String lllllllllllllIIIllIIlllIIIIlIIll, final ResourceLocation lllllllllllllIIIllIIlllIIIIlIIIl, final ChunkGeneratorSettings.Factory lllllllllllllIIIllIIlllIIIIIllll) {
            this.name = lllllllllllllIIIllIIlllIIIIlIIll;
            this.texture = lllllllllllllIIIllIIlllIIIIlIIIl;
            this.settings = lllllllllllllIIIllIIlllIIIIIllll;
        }
    }
}
