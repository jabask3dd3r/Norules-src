package net.minecraft.client.gui;

import net.minecraft.client.resources.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.*;
import com.google.common.collect.*;
import java.util.*;
import org.lwjgl.input.*;
import java.io.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public class GuiFlatPresets extends GuiScreen
{
    private /* synthetic */ GuiTextField export;
    private /* synthetic */ ListSlot list;
    private /* synthetic */ String presetsTitle;
    private /* synthetic */ String listText;
    private /* synthetic */ String presetsShare;
    private final /* synthetic */ GuiCreateFlatWorld parentScreen;
    private static final /* synthetic */ List<LayerItem> FLAT_WORLD_PRESETS;
    private /* synthetic */ GuiButton btnSelect;
    
    public void updateButtonValidity() {
        this.btnSelect.enabled = this.hasValidSelection();
    }
    
    static {
        FLAT_WORLD_PRESETS = Lists.newArrayList();
        registerPreset(I18n.format("createWorld.customize.preset.classic_flat", new Object[0]), Item.getItemFromBlock(Blocks.GRASS), Biomes.PLAINS, Arrays.asList("village"), new FlatLayerInfo(1, Blocks.GRASS), new FlatLayerInfo(2, Blocks.DIRT), new FlatLayerInfo(1, Blocks.BEDROCK));
        registerPreset(I18n.format("createWorld.customize.preset.tunnelers_dream", new Object[0]), Item.getItemFromBlock(Blocks.STONE), Biomes.EXTREME_HILLS, Arrays.asList("biome_1", "dungeon", "decoration", "stronghold", "mineshaft"), new FlatLayerInfo(1, Blocks.GRASS), new FlatLayerInfo(5, Blocks.DIRT), new FlatLayerInfo(230, Blocks.STONE), new FlatLayerInfo(1, Blocks.BEDROCK));
        registerPreset(I18n.format("createWorld.customize.preset.water_world", new Object[0]), Items.WATER_BUCKET, Biomes.DEEP_OCEAN, Arrays.asList("biome_1", "oceanmonument"), new FlatLayerInfo(90, Blocks.WATER), new FlatLayerInfo(5, Blocks.SAND), new FlatLayerInfo(5, Blocks.DIRT), new FlatLayerInfo(5, Blocks.STONE), new FlatLayerInfo(1, Blocks.BEDROCK));
        registerPreset(I18n.format("createWorld.customize.preset.overworld", new Object[0]), Item.getItemFromBlock(Blocks.TALLGRASS), BlockTallGrass.EnumType.GRASS.getMeta(), Biomes.PLAINS, Arrays.asList("village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon", "lake", "lava_lake"), new FlatLayerInfo(1, Blocks.GRASS), new FlatLayerInfo(3, Blocks.DIRT), new FlatLayerInfo(59, Blocks.STONE), new FlatLayerInfo(1, Blocks.BEDROCK));
        registerPreset(I18n.format("createWorld.customize.preset.snowy_kingdom", new Object[0]), Item.getItemFromBlock(Blocks.SNOW_LAYER), Biomes.ICE_PLAINS, Arrays.asList("village", "biome_1"), new FlatLayerInfo(1, Blocks.SNOW_LAYER), new FlatLayerInfo(1, Blocks.GRASS), new FlatLayerInfo(3, Blocks.DIRT), new FlatLayerInfo(59, Blocks.STONE), new FlatLayerInfo(1, Blocks.BEDROCK));
        registerPreset(I18n.format("createWorld.customize.preset.bottomless_pit", new Object[0]), Items.FEATHER, Biomes.PLAINS, Arrays.asList("village", "biome_1"), new FlatLayerInfo(1, Blocks.GRASS), new FlatLayerInfo(3, Blocks.DIRT), new FlatLayerInfo(2, Blocks.COBBLESTONE));
        registerPreset(I18n.format("createWorld.customize.preset.desert", new Object[0]), Item.getItemFromBlock(Blocks.SAND), Biomes.DESERT, Arrays.asList("village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon"), new FlatLayerInfo(8, Blocks.SAND), new FlatLayerInfo(52, Blocks.SANDSTONE), new FlatLayerInfo(3, Blocks.STONE), new FlatLayerInfo(1, Blocks.BEDROCK));
        registerPreset(I18n.format("createWorld.customize.preset.redstone_ready", new Object[0]), Items.REDSTONE, Biomes.DESERT, Collections.emptyList(), new FlatLayerInfo(52, Blocks.SANDSTONE), new FlatLayerInfo(3, Blocks.STONE), new FlatLayerInfo(1, Blocks.BEDROCK));
        registerPreset(I18n.format("createWorld.customize.preset.the_void", new Object[0]), Item.getItemFromBlock(Blocks.BARRIER), Biomes.VOID, Arrays.asList("decoration"), new FlatLayerInfo(1, Blocks.AIR));
    }
    
    private static void registerPreset(final String lllIIIIlIIlIIll, final Item lllIIIIlIIllIll, final int lllIIIIlIIlIIIl, final Biome lllIIIIlIIlIIII, final List<String> lllIIIIlIIllIII, final FlatLayerInfo... lllIIIIlIIlIlll) {
        final FlatGeneratorInfo lllIIIIlIIlIllI = new FlatGeneratorInfo();
        for (int lllIIIIlIIlIlIl = lllIIIIlIIlIlll.length - 1; lllIIIIlIIlIlIl >= 0; --lllIIIIlIIlIlIl) {
            lllIIIIlIIlIllI.getFlatLayers().add(lllIIIIlIIlIlll[lllIIIIlIIlIlIl]);
        }
        lllIIIIlIIlIllI.setBiome(Biome.getIdForBiome(lllIIIIlIIlIIII));
        lllIIIIlIIlIllI.updateLayers();
        for (final String lllIIIIlIIlIlII : lllIIIIlIIllIII) {
            lllIIIIlIIlIllI.getWorldFeatures().put(lllIIIIlIIlIlII, Maps.newHashMap());
        }
        GuiFlatPresets.FLAT_WORLD_PRESETS.add(new LayerItem(lllIIIIlIIllIll, lllIIIIlIIlIIIl, lllIIIIlIIlIIll, lllIIIIlIIlIllI.toString()));
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    @Override
    public void drawScreen(final int lllIIIIllIIIlII, final int lllIIIIlIllllll, final float lllIIIIllIIIIlI) {
        this.drawDefaultBackground();
        this.list.drawScreen(lllIIIIllIIIlII, lllIIIIlIllllll, lllIIIIllIIIIlI);
        this.drawCenteredString(this.fontRendererObj, this.presetsTitle, this.width / 2, 8, 16777215);
        this.drawString(this.fontRendererObj, this.presetsShare, 50, 30, 10526880);
        this.drawString(this.fontRendererObj, this.listText, 50, 70, 10526880);
        this.export.drawTextBox();
        super.drawScreen(lllIIIIllIIIlII, lllIIIIlIllllll, lllIIIIllIIIIlI);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllIIIIllIlIIlI) throws IOException {
        if (lllIIIIllIlIIlI.id == 0 && this.hasValidSelection()) {
            this.parentScreen.setPreset(this.export.getText());
            this.mc.displayGuiScreen(this.parentScreen);
        }
        else if (lllIIIIllIlIIlI.id == 1) {
            this.mc.displayGuiScreen(this.parentScreen);
        }
    }
    
    @Override
    protected void mouseClicked(final int lllIIIIllllIIII, final int lllIIIIlllIlllI, final int lllIIIIllllIlIl) throws IOException {
        this.export.mouseClicked(lllIIIIllllIIII, lllIIIIlllIlllI, lllIIIIllllIlIl);
        super.mouseClicked(lllIIIIllllIIII, lllIIIIlllIlllI, lllIIIIllllIlIl);
    }
    
    @Override
    public void updateScreen() {
        this.export.updateCursorCounter();
        super.updateScreen();
    }
    
    @Override
    protected void keyTyped(final char lllIIIIlllIIIll, final int lllIIIIlllIIllI) throws IOException {
        if (!this.export.textboxKeyTyped(lllIIIIlllIIIll, lllIIIIlllIIllI)) {
            super.keyTyped(lllIIIIlllIIIll, lllIIIIlllIIllI);
        }
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.list.handleMouseInput();
    }
    
    private static void registerPreset(final String lllIIIIlIlIllll, final Item lllIIIIlIlIlllI, final Biome lllIIIIlIlIlIII, final List<String> lllIIIIlIlIllII, final FlatLayerInfo... lllIIIIlIlIIllI) {
        registerPreset(lllIIIIlIlIllll, lllIIIIlIlIlllI, 0, lllIIIIlIlIlIII, lllIIIIlIlIllII, lllIIIIlIlIIllI);
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        this.presetsTitle = I18n.format("createWorld.customize.presets.title", new Object[0]);
        this.presetsShare = I18n.format("createWorld.customize.presets.share", new Object[0]);
        this.listText = I18n.format("createWorld.customize.presets.list", new Object[0]);
        this.export = new GuiTextField(2, this.fontRendererObj, 50, 40, this.width - 100, 20);
        this.list = new ListSlot();
        this.export.setMaxStringLength(1230);
        this.export.setText(this.parentScreen.getPreset());
        this.btnSelect = this.addButton(new GuiButton(0, this.width / 2 - 155, this.height - 28, 150, 20, I18n.format("createWorld.customize.presets.select", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 + 5, this.height - 28, 150, 20, I18n.format("gui.cancel", new Object[0])));
        this.updateButtonValidity();
    }
    
    public GuiFlatPresets(final GuiCreateFlatWorld lllIIIlIIIllIlI) {
        this.parentScreen = lllIIIlIIIllIlI;
    }
    
    private boolean hasValidSelection() {
        return (this.list.selected > -1 && this.list.selected < GuiFlatPresets.FLAT_WORLD_PRESETS.size()) || this.export.getText().length() > 1;
    }
    
    static class LayerItem
    {
        public /* synthetic */ Item icon;
        public /* synthetic */ String generatorInfo;
        public /* synthetic */ String name;
        public /* synthetic */ int iconMetadata;
        
        public LayerItem(final Item lllllllllllllIllIIllllIIIlIIIllI, final int lllllllllllllIllIIllllIIIlIIIlIl, final String lllllllllllllIllIIllllIIIlIIlIIl, final String lllllllllllllIllIIllllIIIlIIIIll) {
            this.icon = lllllllllllllIllIIllllIIIlIIIllI;
            this.iconMetadata = lllllllllllllIllIIllllIIIlIIIlIl;
            this.name = lllllllllllllIllIIllllIIIlIIlIIl;
            this.generatorInfo = lllllllllllllIllIIllllIIIlIIIIll;
        }
    }
    
    class ListSlot extends GuiSlot
    {
        public /* synthetic */ int selected;
        
        public ListSlot() {
            super(GuiFlatPresets.this.mc, GuiFlatPresets.this.width, GuiFlatPresets.this.height, 80, GuiFlatPresets.this.height - 37, 24);
            this.selected = -1;
        }
        
        @Override
        protected void func_192637_a(final int lllllllllllllIIllIIIIlIlllIlIlll, final int lllllllllllllIIllIIIIlIlllIlIllI, final int lllllllllllllIIllIIIIlIlllIIllII, final int lllllllllllllIIllIIIIlIlllIlIlII, final int lllllllllllllIIllIIIIlIlllIlIIll, final int lllllllllllllIIllIIIIlIlllIlIIlI, final float lllllllllllllIIllIIIIlIlllIlIIIl) {
            final LayerItem lllllllllllllIIllIIIIlIlllIlIIII = GuiFlatPresets.FLAT_WORLD_PRESETS.get(lllllllllllllIIllIIIIlIlllIlIlll);
            this.renderIcon(lllllllllllllIIllIIIIlIlllIlIllI, lllllllllllllIIllIIIIlIlllIIllII, lllllllllllllIIllIIIIlIlllIlIIII.icon, lllllllllllllIIllIIIIlIlllIlIIII.iconMetadata);
            GuiFlatPresets.this.fontRendererObj.drawString(lllllllllllllIIllIIIIlIlllIlIIII.name, lllllllllllllIIllIIIIlIlllIlIllI + 18 + 5, lllllllllllllIIllIIIIlIlllIIllII + 6, 16777215);
        }
        
        @Override
        protected boolean isSelected(final int lllllllllllllIIllIIIIlIllllIIIIl) {
            return lllllllllllllIIllIIIIlIllllIIIIl == this.selected;
        }
        
        @Override
        protected void elementClicked(final int lllllllllllllIIllIIIIlIllllIIlIl, final boolean lllllllllllllIIllIIIIlIllllIlIIl, final int lllllllllllllIIllIIIIlIllllIlIII, final int lllllllllllllIIllIIIIlIllllIIlll) {
            this.selected = lllllllllllllIIllIIIIlIllllIIlIl;
            GuiFlatPresets.this.updateButtonValidity();
            GuiFlatPresets.this.export.setText(GuiFlatPresets.FLAT_WORLD_PRESETS.get(GuiFlatPresets.this.list.selected).generatorInfo);
        }
        
        @Override
        protected int getSize() {
            return GuiFlatPresets.FLAT_WORLD_PRESETS.size();
        }
        
        @Override
        protected void drawBackground() {
        }
        
        private void renderIcon(final int lllllllllllllIIllIIIIllIIIlIIIIl, final int lllllllllllllIIllIIIIllIIIlIIIII, final Item lllllllllllllIIllIIIIllIIIIllIlI, final int lllllllllllllIIllIIIIllIIIIllIIl) {
            this.blitSlotBg(lllllllllllllIIllIIIIllIIIlIIIIl + 1, lllllllllllllIIllIIIIllIIIlIIIII + 1);
            GlStateManager.enableRescaleNormal();
            RenderHelper.enableGUIStandardItemLighting();
            GuiFlatPresets.this.itemRender.renderItemIntoGUI(new ItemStack(lllllllllllllIIllIIIIllIIIIllIlI, 1, lllllllllllllIIllIIIIllIIIIllIlI.getHasSubtypes() ? lllllllllllllIIllIIIIllIIIIllIIl : 0), lllllllllllllIIllIIIIllIIIlIIIIl + 2, lllllllllllllIIllIIIIllIIIlIIIII + 2);
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableRescaleNormal();
        }
        
        private void blitSlotIcon(final int lllllllllllllIIllIIIIlIllllllIII, final int lllllllllllllIIllIIIIllIIIIIIIlI, final int lllllllllllllIIllIIIIllIIIIIIIIl, final int lllllllllllllIIllIIIIllIIIIIIIII) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getTextureManager().bindTexture(Gui.STAT_ICONS);
            final float lllllllllllllIIllIIIIlIlllllllll = 0.0078125f;
            final float lllllllllllllIIllIIIIlIllllllllI = 0.0078125f;
            final int lllllllllllllIIllIIIIlIlllllllIl = 18;
            final int lllllllllllllIIllIIIIlIlllllllII = 18;
            final Tessellator lllllllllllllIIllIIIIlIllllllIll = Tessellator.getInstance();
            final BufferBuilder lllllllllllllIIllIIIIlIllllllIlI = lllllllllllllIIllIIIIlIllllllIll.getBuffer();
            lllllllllllllIIllIIIIlIllllllIlI.begin(7, DefaultVertexFormats.POSITION_TEX);
            lllllllllllllIIllIIIIlIllllllIlI.pos(lllllllllllllIIllIIIIlIllllllIII + 0, lllllllllllllIIllIIIIllIIIIIIIlI + 18, GuiFlatPresets.this.zLevel).tex((lllllllllllllIIllIIIIllIIIIIIIIl + 0) * 0.0078125f, (lllllllllllllIIllIIIIllIIIIIIIII + 18) * 0.0078125f).endVertex();
            lllllllllllllIIllIIIIlIllllllIlI.pos(lllllllllllllIIllIIIIlIllllllIII + 18, lllllllllllllIIllIIIIllIIIIIIIlI + 18, GuiFlatPresets.this.zLevel).tex((lllllllllllllIIllIIIIllIIIIIIIIl + 18) * 0.0078125f, (lllllllllllllIIllIIIIllIIIIIIIII + 18) * 0.0078125f).endVertex();
            lllllllllllllIIllIIIIlIllllllIlI.pos(lllllllllllllIIllIIIIlIllllllIII + 18, lllllllllllllIIllIIIIllIIIIIIIlI + 0, GuiFlatPresets.this.zLevel).tex((lllllllllllllIIllIIIIllIIIIIIIIl + 18) * 0.0078125f, (lllllllllllllIIllIIIIllIIIIIIIII + 0) * 0.0078125f).endVertex();
            lllllllllllllIIllIIIIlIllllllIlI.pos(lllllllllllllIIllIIIIlIllllllIII + 0, lllllllllllllIIllIIIIllIIIIIIIlI + 0, GuiFlatPresets.this.zLevel).tex((lllllllllllllIIllIIIIllIIIIIIIIl + 0) * 0.0078125f, (lllllllllllllIIllIIIIllIIIIIIIII + 0) * 0.0078125f).endVertex();
            lllllllllllllIIllIIIIlIllllllIll.draw();
        }
        
        private void blitSlotBg(final int lllllllllllllIIllIIIIllIIIIlIlII, final int lllllllllllllIIllIIIIllIIIIlIIII) {
            this.blitSlotIcon(lllllllllllllIIllIIIIllIIIIlIlII, lllllllllllllIIllIIIIllIIIIlIIII, 0, 0);
        }
    }
}
