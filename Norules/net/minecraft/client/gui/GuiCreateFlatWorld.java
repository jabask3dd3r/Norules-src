package net.minecraft.client.gui;

import java.io.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.world.gen.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;

public class GuiCreateFlatWorld extends GuiScreen
{
    private /* synthetic */ FlatGeneratorInfo theFlatGeneratorInfo;
    private /* synthetic */ String flatWorldTitle;
    private /* synthetic */ String heightText;
    private /* synthetic */ GuiButton addLayerButton;
    private final /* synthetic */ GuiCreateWorld createWorldGui;
    private /* synthetic */ GuiButton editLayerButton;
    private /* synthetic */ String materialText;
    private /* synthetic */ Details createFlatWorldListSlotGui;
    private /* synthetic */ GuiButton removeLayerButton;
    
    public GuiCreateFlatWorld(final GuiCreateWorld lllllllllllllIllIllIllIlIIllIlIl, final String lllllllllllllIllIllIllIlIIllIlII) {
        this.theFlatGeneratorInfo = FlatGeneratorInfo.getDefaultFlatGenerator();
        this.createWorldGui = lllllllllllllIllIllIllIlIIllIlIl;
        this.setPreset(lllllllllllllIllIllIllIlIIllIlII);
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIllIllIllIlIIIIllII, final int lllllllllllllIllIllIllIlIIIIIllI, final float lllllllllllllIllIllIllIlIIIIIlIl) {
        this.drawDefaultBackground();
        this.createFlatWorldListSlotGui.drawScreen(lllllllllllllIllIllIllIlIIIIllII, lllllllllllllIllIllIllIlIIIIIllI, lllllllllllllIllIllIllIlIIIIIlIl);
        this.drawCenteredString(this.fontRendererObj, this.flatWorldTitle, this.width / 2, 8, 16777215);
        final int lllllllllllllIllIllIllIlIIIIlIIl = this.width / 2 - 92 - 16;
        this.drawString(this.fontRendererObj, this.materialText, lllllllllllllIllIllIllIlIIIIlIIl, 32, 16777215);
        this.drawString(this.fontRendererObj, this.heightText, lllllllllllllIllIllIllIlIIIIlIIl + 2 + 213 - this.fontRendererObj.getStringWidth(this.heightText), 32, 16777215);
        super.drawScreen(lllllllllllllIllIllIllIlIIIIllII, lllllllllllllIllIllIllIlIIIIIllI, lllllllllllllIllIllIllIlIIIIIlIl);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIllIllIllIlIIlIIIII) throws IOException {
        final int lllllllllllllIllIllIllIlIIIlllll = this.theFlatGeneratorInfo.getFlatLayers().size() - this.createFlatWorldListSlotGui.selectedLayer - 1;
        if (lllllllllllllIllIllIllIlIIlIIIII.id == 1) {
            this.mc.displayGuiScreen(this.createWorldGui);
        }
        else if (lllllllllllllIllIllIllIlIIlIIIII.id == 0) {
            this.createWorldGui.chunkProviderSettingsJson = this.getPreset();
            this.mc.displayGuiScreen(this.createWorldGui);
        }
        else if (lllllllllllllIllIllIllIlIIlIIIII.id == 5) {
            this.mc.displayGuiScreen(new GuiFlatPresets(this));
        }
        else if (lllllllllllllIllIllIllIlIIlIIIII.id == 4 && this.hasSelectedLayer()) {
            this.theFlatGeneratorInfo.getFlatLayers().remove(lllllllllllllIllIllIllIlIIIlllll);
            this.createFlatWorldListSlotGui.selectedLayer = Math.min(this.createFlatWorldListSlotGui.selectedLayer, this.theFlatGeneratorInfo.getFlatLayers().size() - 1);
        }
        this.theFlatGeneratorInfo.updateLayers();
        this.onLayersChanged();
    }
    
    private boolean hasSelectedLayer() {
        return this.createFlatWorldListSlotGui.selectedLayer > -1 && this.createFlatWorldListSlotGui.selectedLayer < this.theFlatGeneratorInfo.getFlatLayers().size();
    }
    
    public void onLayersChanged() {
        final boolean lllllllllllllIllIllIllIlIIIllIII = this.hasSelectedLayer();
        this.removeLayerButton.enabled = lllllllllllllIllIllIllIlIIIllIII;
        this.editLayerButton.enabled = lllllllllllllIllIllIllIlIIIllIII;
        this.editLayerButton.enabled = false;
        this.addLayerButton.enabled = false;
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.createFlatWorldListSlotGui.handleMouseInput();
    }
    
    public void setPreset(final String lllllllllllllIllIllIllIlIIlIlIll) {
        this.theFlatGeneratorInfo = FlatGeneratorInfo.createFlatGeneratorFromString(lllllllllllllIllIllIllIlIIlIlIll);
    }
    
    public String getPreset() {
        return this.theFlatGeneratorInfo.toString();
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        this.flatWorldTitle = I18n.format("createWorld.customize.flat.title", new Object[0]);
        this.materialText = I18n.format("createWorld.customize.flat.tile", new Object[0]);
        this.heightText = I18n.format("createWorld.customize.flat.height", new Object[0]);
        this.createFlatWorldListSlotGui = new Details();
        this.addLayerButton = this.addButton(new GuiButton(2, this.width / 2 - 154, this.height - 52, 100, 20, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.flat.addLayer", new Object[0]))).append(" (NYI)"))));
        this.editLayerButton = this.addButton(new GuiButton(3, this.width / 2 - 50, this.height - 52, 100, 20, String.valueOf(new StringBuilder(String.valueOf(I18n.format("createWorld.customize.flat.editLayer", new Object[0]))).append(" (NYI)"))));
        this.removeLayerButton = this.addButton(new GuiButton(4, this.width / 2 - 155, this.height - 52, 150, 20, I18n.format("createWorld.customize.flat.removeLayer", new Object[0])));
        this.buttonList.add(new GuiButton(0, this.width / 2 - 155, this.height - 28, 150, 20, I18n.format("gui.done", new Object[0])));
        this.buttonList.add(new GuiButton(5, this.width / 2 + 5, this.height - 52, 150, 20, I18n.format("createWorld.customize.presets", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 + 5, this.height - 28, 150, 20, I18n.format("gui.cancel", new Object[0])));
        this.addLayerButton.visible = false;
        this.editLayerButton.visible = false;
        this.theFlatGeneratorInfo.updateLayers();
        this.onLayersChanged();
    }
    
    class Details extends GuiSlot
    {
        public /* synthetic */ int selectedLayer;
        
        @Override
        protected boolean isSelected(final int lllllllllllllllllllIlIlIlIIlIllI) {
            return lllllllllllllllllllIlIlIlIIlIllI == this.selectedLayer;
        }
        
        @Override
        protected void elementClicked(final int lllllllllllllllllllIlIlIlIIllIlI, final boolean lllllllllllllllllllIlIlIlIIllllI, final int lllllllllllllllllllIlIlIlIIlllIl, final int lllllllllllllllllllIlIlIlIIlllII) {
            this.selectedLayer = lllllllllllllllllllIlIlIlIIllIlI;
            GuiCreateFlatWorld.this.onLayersChanged();
        }
        
        @Override
        protected void drawBackground() {
        }
        
        @Override
        protected int getSize() {
            return GuiCreateFlatWorld.this.theFlatGeneratorInfo.getFlatLayers().size();
        }
        
        @Override
        protected int getScrollBarX() {
            return this.width - 70;
        }
        
        public Details() {
            super(GuiCreateFlatWorld.this.mc, GuiCreateFlatWorld.this.width, GuiCreateFlatWorld.this.height, 43, GuiCreateFlatWorld.this.height - 60, 24);
            this.selectedLayer = -1;
        }
        
        private void drawItemBackground(final int lllllllllllllllllllIlIlIllIIlIll, final int lllllllllllllllllllIlIlIllIIIlll) {
            this.drawItemBackground(lllllllllllllllllllIlIlIllIIlIll, lllllllllllllllllllIlIlIllIIIlll, 0, 0);
        }
        
        private void drawItem(final int lllllllllllllllllllIlIlIllIlIllI, final int lllllllllllllllllllIlIlIllIlIlIl, final ItemStack lllllllllllllllllllIlIlIllIlIIII) {
            this.drawItemBackground(lllllllllllllllllllIlIlIllIlIllI + 1, lllllllllllllllllllIlIlIllIlIlIl + 1);
            GlStateManager.enableRescaleNormal();
            if (!lllllllllllllllllllIlIlIllIlIIII.func_190926_b()) {
                RenderHelper.enableGUIStandardItemLighting();
                GuiCreateFlatWorld.this.itemRender.renderItemIntoGUI(lllllllllllllllllllIlIlIllIlIIII, lllllllllllllllllllIlIlIllIlIllI + 2, lllllllllllllllllllIlIlIllIlIlIl + 2);
                RenderHelper.disableStandardItemLighting();
            }
            GlStateManager.disableRescaleNormal();
        }
        
        private void drawItemBackground(final int lllllllllllllllllllIlIlIlIlIllll, final int lllllllllllllllllllIlIlIlIlIlllI, final int lllllllllllllllllllIlIlIlIlIllIl, final int lllllllllllllllllllIlIlIlIllIlll) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getTextureManager().bindTexture(Gui.STAT_ICONS);
            final float lllllllllllllllllllIlIlIlIllIllI = 0.0078125f;
            final float lllllllllllllllllllIlIlIlIllIlIl = 0.0078125f;
            final int lllllllllllllllllllIlIlIlIllIlII = 18;
            final int lllllllllllllllllllIlIlIlIllIIll = 18;
            final Tessellator lllllllllllllllllllIlIlIlIllIIlI = Tessellator.getInstance();
            final BufferBuilder lllllllllllllllllllIlIlIlIllIIIl = lllllllllllllllllllIlIlIlIllIIlI.getBuffer();
            lllllllllllllllllllIlIlIlIllIIIl.begin(7, DefaultVertexFormats.POSITION_TEX);
            lllllllllllllllllllIlIlIlIllIIIl.pos(lllllllllllllllllllIlIlIlIlIllll + 0, lllllllllllllllllllIlIlIlIlIlllI + 18, GuiCreateFlatWorld.this.zLevel).tex((lllllllllllllllllllIlIlIlIlIllIl + 0) * 0.0078125f, (lllllllllllllllllllIlIlIlIllIlll + 18) * 0.0078125f).endVertex();
            lllllllllllllllllllIlIlIlIllIIIl.pos(lllllllllllllllllllIlIlIlIlIllll + 18, lllllllllllllllllllIlIlIlIlIlllI + 18, GuiCreateFlatWorld.this.zLevel).tex((lllllllllllllllllllIlIlIlIlIllIl + 18) * 0.0078125f, (lllllllllllllllllllIlIlIlIllIlll + 18) * 0.0078125f).endVertex();
            lllllllllllllllllllIlIlIlIllIIIl.pos(lllllllllllllllllllIlIlIlIlIllll + 18, lllllllllllllllllllIlIlIlIlIlllI + 0, GuiCreateFlatWorld.this.zLevel).tex((lllllllllllllllllllIlIlIlIlIllIl + 18) * 0.0078125f, (lllllllllllllllllllIlIlIlIllIlll + 0) * 0.0078125f).endVertex();
            lllllllllllllllllllIlIlIlIllIIIl.pos(lllllllllllllllllllIlIlIlIlIllll + 0, lllllllllllllllllllIlIlIlIlIlllI + 0, GuiCreateFlatWorld.this.zLevel).tex((lllllllllllllllllllIlIlIlIlIllIl + 0) * 0.0078125f, (lllllllllllllllllllIlIlIlIllIlll + 0) * 0.0078125f).endVertex();
            lllllllllllllllllllIlIlIlIllIIlI.draw();
        }
        
        @Override
        protected void func_192637_a(final int lllllllllllllllllllIlIlIIlllIlIl, final int lllllllllllllllllllIlIlIlIIIIlIl, final int lllllllllllllllllllIlIlIIlllIIll, final int lllllllllllllllllllIlIlIlIIIIIll, final int lllllllllllllllllllIlIlIlIIIIIlI, final int lllllllllllllllllllIlIlIlIIIIIIl, final float lllllllllllllllllllIlIlIlIIIIIII) {
            final FlatLayerInfo lllllllllllllllllllIlIlIIlllllll = GuiCreateFlatWorld.this.theFlatGeneratorInfo.getFlatLayers().get(GuiCreateFlatWorld.this.theFlatGeneratorInfo.getFlatLayers().size() - lllllllllllllllllllIlIlIIlllIlIl - 1);
            final IBlockState lllllllllllllllllllIlIlIIllllllI = lllllllllllllllllllIlIlIIlllllll.getLayerMaterial();
            final Block lllllllllllllllllllIlIlIIlllllIl = lllllllllllllllllllIlIlIIllllllI.getBlock();
            Item lllllllllllllllllllIlIlIIlllllII = Item.getItemFromBlock(lllllllllllllllllllIlIlIIlllllIl);
            if (lllllllllllllllllllIlIlIIlllllII == Items.field_190931_a) {
                if (lllllllllllllllllllIlIlIIlllllIl != Blocks.WATER && lllllllllllllllllllIlIlIIlllllIl != Blocks.FLOWING_WATER) {
                    if (lllllllllllllllllllIlIlIIlllllIl == Blocks.LAVA || lllllllllllllllllllIlIlIIlllllIl == Blocks.FLOWING_LAVA) {
                        lllllllllllllllllllIlIlIIlllllII = Items.LAVA_BUCKET;
                    }
                }
                else {
                    lllllllllllllllllllIlIlIIlllllII = Items.WATER_BUCKET;
                }
            }
            final ItemStack lllllllllllllllllllIlIlIIllllIll = new ItemStack(lllllllllllllllllllIlIlIIlllllII, 1, lllllllllllllllllllIlIlIIlllllII.getHasSubtypes() ? lllllllllllllllllllIlIlIIlllllIl.getMetaFromState(lllllllllllllllllllIlIlIIllllllI) : 0);
            final String lllllllllllllllllllIlIlIIllllIlI = lllllllllllllllllllIlIlIIlllllII.getItemStackDisplayName(lllllllllllllllllllIlIlIIllllIll);
            this.drawItem(lllllllllllllllllllIlIlIlIIIIlIl, lllllllllllllllllllIlIlIIlllIIll, lllllllllllllllllllIlIlIIllllIll);
            GuiCreateFlatWorld.this.fontRendererObj.drawString(lllllllllllllllllllIlIlIIllllIlI, lllllllllllllllllllIlIlIlIIIIlIl + 18 + 5, lllllllllllllllllllIlIlIIlllIIll + 3, 16777215);
            String lllllllllllllllllllIlIlIIlllIlll = null;
            if (lllllllllllllllllllIlIlIIlllIlIl == 0) {
                final String lllllllllllllllllllIlIlIIllllIIl = I18n.format("createWorld.customize.flat.layer.top", lllllllllllllllllllIlIlIIlllllll.getLayerCount());
            }
            else if (lllllllllllllllllllIlIlIIlllIlIl == GuiCreateFlatWorld.this.theFlatGeneratorInfo.getFlatLayers().size() - 1) {
                final String lllllllllllllllllllIlIlIIllllIII = I18n.format("createWorld.customize.flat.layer.bottom", lllllllllllllllllllIlIlIIlllllll.getLayerCount());
            }
            else {
                lllllllllllllllllllIlIlIIlllIlll = I18n.format("createWorld.customize.flat.layer", lllllllllllllllllllIlIlIIlllllll.getLayerCount());
            }
            GuiCreateFlatWorld.this.fontRendererObj.drawString(lllllllllllllllllllIlIlIIlllIlll, lllllllllllllllllllIlIlIlIIIIlIl + 2 + 213 - GuiCreateFlatWorld.this.fontRendererObj.getStringWidth(lllllllllllllllllllIlIlIIlllIlll), lllllllllllllllllllIlIlIIlllIIll + 3, 16777215);
        }
    }
}
