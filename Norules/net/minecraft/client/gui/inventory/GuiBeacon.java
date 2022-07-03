package net.minecraft.client.gui.inventory;

import net.minecraft.util.*;
import net.minecraft.potion.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.gui.*;
import io.netty.buffer.*;
import net.minecraft.network.*;
import net.minecraft.network.play.client.*;
import java.io.*;
import net.minecraft.client.*;
import net.minecraft.init.*;

public class GuiBeacon extends GuiContainer
{
    private /* synthetic */ ConfirmButton beaconConfirmButton;
    private static final /* synthetic */ ResourceLocation BEACON_GUI_TEXTURES;
    private final /* synthetic */ IInventory tileBeacon;
    private /* synthetic */ boolean buttonsNotDrawn;
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        final int lllllllllllllIIIlIIIlIIIlllIllll = this.tileBeacon.getField(0);
        final Potion lllllllllllllIIIlIIIlIIIlllIlllI = Potion.getPotionById(this.tileBeacon.getField(1));
        final Potion lllllllllllllIIIlIIIlIIIlllIllIl = Potion.getPotionById(this.tileBeacon.getField(2));
        if (this.buttonsNotDrawn && lllllllllllllIIIlIIIlIIIlllIllll >= 0) {
            this.buttonsNotDrawn = false;
            int lllllllllllllIIIlIIIlIIIlllIllII = 100;
            for (int lllllllllllllIIIlIIIlIIIlllIlIll = 0; lllllllllllllIIIlIIIlIIIlllIlIll <= 2; ++lllllllllllllIIIlIIIlIIIlllIlIll) {
                final int lllllllllllllIIIlIIIlIIIlllIlIlI = TileEntityBeacon.EFFECTS_LIST[lllllllllllllIIIlIIIlIIIlllIlIll].length;
                final int lllllllllllllIIIlIIIlIIIlllIlIIl = lllllllllllllIIIlIIIlIIIlllIlIlI * 22 + (lllllllllllllIIIlIIIlIIIlllIlIlI - 1) * 2;
                for (int lllllllllllllIIIlIIIlIIIlllIlIII = 0; lllllllllllllIIIlIIIlIIIlllIlIII < lllllllllllllIIIlIIIlIIIlllIlIlI; ++lllllllllllllIIIlIIIlIIIlllIlIII) {
                    final Potion lllllllllllllIIIlIIIlIIIlllIIlll = TileEntityBeacon.EFFECTS_LIST[lllllllllllllIIIlIIIlIIIlllIlIll][lllllllllllllIIIlIIIlIIIlllIlIII];
                    final PowerButton lllllllllllllIIIlIIIlIIIlllIIllI = new PowerButton(lllllllllllllIIIlIIIlIIIlllIllII++, this.guiLeft + 76 + lllllllllllllIIIlIIIlIIIlllIlIII * 24 - lllllllllllllIIIlIIIlIIIlllIlIIl / 2, this.guiTop + 22 + lllllllllllllIIIlIIIlIIIlllIlIll * 25, lllllllllllllIIIlIIIlIIIlllIIlll, lllllllllllllIIIlIIIlIIIlllIlIll);
                    this.buttonList.add(lllllllllllllIIIlIIIlIIIlllIIllI);
                    if (lllllllllllllIIIlIIIlIIIlllIlIll >= lllllllllllllIIIlIIIlIIIlllIllll) {
                        lllllllllllllIIIlIIIlIIIlllIIllI.enabled = false;
                    }
                    else if (lllllllllllllIIIlIIIlIIIlllIIlll == lllllllllllllIIIlIIIlIIIlllIlllI) {
                        lllllllllllllIIIlIIIlIIIlllIIllI.setSelected(true);
                    }
                }
            }
            final int lllllllllllllIIIlIIIlIIIlllIIlIl = 3;
            final int lllllllllllllIIIlIIIlIIIlllIIlII = TileEntityBeacon.EFFECTS_LIST[3].length + 1;
            final int lllllllllllllIIIlIIIlIIIlllIIIll = lllllllllllllIIIlIIIlIIIlllIIlII * 22 + (lllllllllllllIIIlIIIlIIIlllIIlII - 1) * 2;
            for (int lllllllllllllIIIlIIIlIIIlllIIIlI = 0; lllllllllllllIIIlIIIlIIIlllIIIlI < lllllllllllllIIIlIIIlIIIlllIIlII - 1; ++lllllllllllllIIIlIIIlIIIlllIIIlI) {
                final Potion lllllllllllllIIIlIIIlIIIlllIIIIl = TileEntityBeacon.EFFECTS_LIST[3][lllllllllllllIIIlIIIlIIIlllIIIlI];
                final PowerButton lllllllllllllIIIlIIIlIIIlllIIIII = new PowerButton(lllllllllllllIIIlIIIlIIIlllIllII++, this.guiLeft + 167 + lllllllllllllIIIlIIIlIIIlllIIIlI * 24 - lllllllllllllIIIlIIIlIIIlllIIIll / 2, this.guiTop + 47, lllllllllllllIIIlIIIlIIIlllIIIIl, 3);
                this.buttonList.add(lllllllllllllIIIlIIIlIIIlllIIIII);
                if (3 >= lllllllllllllIIIlIIIlIIIlllIllll) {
                    lllllllllllllIIIlIIIlIIIlllIIIII.enabled = false;
                }
                else if (lllllllllllllIIIlIIIlIIIlllIIIIl == lllllllllllllIIIlIIIlIIIlllIllIl) {
                    lllllllllllllIIIlIIIlIIIlllIIIII.setSelected(true);
                }
            }
            if (lllllllllllllIIIlIIIlIIIlllIlllI != null) {
                final PowerButton lllllllllllllIIIlIIIlIIIllIlllll = new PowerButton(lllllllllllllIIIlIIIlIIIlllIllII++, this.guiLeft + 167 + (lllllllllllllIIIlIIIlIIIlllIIlII - 1) * 24 - lllllllllllllIIIlIIIlIIIlllIIIll / 2, this.guiTop + 47, lllllllllllllIIIlIIIlIIIlllIlllI, 3);
                this.buttonList.add(lllllllllllllIIIlIIIlIIIllIlllll);
                if (3 >= lllllllllllllIIIlIIIlIIIlllIllll) {
                    lllllllllllllIIIlIIIlIIIllIlllll.enabled = false;
                }
                else if (lllllllllllllIIIlIIIlIIIlllIlllI == lllllllllllllIIIlIIIlIIIlllIllIl) {
                    lllllllllllllIIIlIIIlIIIllIlllll.setSelected(true);
                }
            }
        }
        this.beaconConfirmButton.enabled = (!this.tileBeacon.getStackInSlot(0).func_190926_b() && lllllllllllllIIIlIIIlIIIlllIlllI != null);
    }
    
    public GuiBeacon(final InventoryPlayer lllllllllllllIIIlIIIlIIlIIIIIIll, final IInventory lllllllllllllIIIlIIIlIIIllllllll) {
        super(new ContainerBeacon(lllllllllllllIIIlIIIlIIlIIIIIIll, lllllllllllllIIIlIIIlIIIllllllll));
        this.tileBeacon = lllllllllllllIIIlIIIlIIIllllllll;
        this.xSize = 230;
        this.ySize = 219;
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllIIIlIIIlIIIlIlIIlll, final int lllllllllllllIIIlIIIlIIIlIlIIllI, final int lllllllllllllIIIlIIIlIIIlIlIIlIl) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiBeacon.BEACON_GUI_TEXTURES);
        final int lllllllllllllIIIlIIIlIIIlIlIIlII = (this.width - this.xSize) / 2;
        final int lllllllllllllIIIlIIIlIIIlIlIIIll = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllllIIIlIIIlIIIlIlIIlII, lllllllllllllIIIlIIIlIIIlIlIIIll, 0, 0, this.xSize, this.ySize);
        this.itemRender.zLevel = 100.0f;
        this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.EMERALD), lllllllllllllIIIlIIIlIIIlIlIIlII + 42, lllllllllllllIIIlIIIlIIIlIlIIIll + 109);
        this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.DIAMOND), lllllllllllllIIIlIIIlIIIlIlIIlII + 42 + 22, lllllllllllllIIIlIIIlIIIlIlIIIll + 109);
        this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.GOLD_INGOT), lllllllllllllIIIlIIIlIIIlIlIIlII + 42 + 44, lllllllllllllIIIlIIIlIIIlIlIIIll + 109);
        this.itemRender.renderItemAndEffectIntoGUI(new ItemStack(Items.IRON_INGOT), lllllllllllllIIIlIIIlIIIlIlIIlII + 42 + 66, lllllllllllllIIIlIIIlIIIlIlIIIll + 109);
        this.itemRender.zLevel = 0.0f;
    }
    
    @Override
    public void initGui() {
        super.initGui();
        this.beaconConfirmButton = new ConfirmButton(-1, this.guiLeft + 164, this.guiTop + 107);
        this.buttonList.add(this.beaconConfirmButton);
        this.buttonList.add(new CancelButton(-2, this.guiLeft + 190, this.guiTop + 107));
        this.buttonsNotDrawn = true;
        this.beaconConfirmButton.enabled = false;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        BEACON_GUI_TEXTURES = new ResourceLocation("textures/gui/container/beacon.png");
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllIIIlIIIlIIIlIlIllll, final int lllllllllllllIIIlIIIlIIIlIlIlllI) {
        RenderHelper.disableStandardItemLighting();
        this.drawCenteredString(this.fontRendererObj, I18n.format("tile.beacon.primary", new Object[0]), 62, 10, 14737632);
        this.drawCenteredString(this.fontRendererObj, I18n.format("tile.beacon.secondary", new Object[0]), 169, 10, 14737632);
        for (final GuiButton lllllllllllllIIIlIIIlIIIlIllIIIl : this.buttonList) {
            if (lllllllllllllIIIlIIIlIIIlIllIIIl.isMouseOver()) {
                lllllllllllllIIIlIIIlIIIlIllIIIl.drawButtonForegroundLayer(lllllllllllllIIIlIIIlIIIlIlIllll - this.guiLeft, lllllllllllllIIIlIIIlIIIlIlIlllI - this.guiTop);
                break;
            }
        }
        RenderHelper.enableGUIStandardItemLighting();
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIIlIIIlIIIlIllllII, final int lllllllllllllIIIlIIIlIIIlIlllIll, final float lllllllllllllIIIlIIIlIIIlIlllllI) {
        this.drawDefaultBackground();
        super.drawScreen(lllllllllllllIIIlIIIlIIIlIllllII, lllllllllllllIIIlIIIlIIIlIlllIll, lllllllllllllIIIlIIIlIIIlIlllllI);
        this.func_191948_b(lllllllllllllIIIlIIIlIIIlIllllII, lllllllllllllIIIlIIIlIIIlIlllIll);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIIIlIIIlIIIllIIlllI) throws IOException {
        if (lllllllllllllIIIlIIIlIIIllIIlllI.id == -2) {
            this.mc.player.connection.sendPacket(new CPacketCloseWindow(this.mc.player.openContainer.windowId));
            this.mc.displayGuiScreen(null);
        }
        else if (lllllllllllllIIIlIIIlIIIllIIlllI.id == -1) {
            final String lllllllllllllIIIlIIIlIIIllIIllIl = "MC|Beacon";
            final PacketBuffer lllllllllllllIIIlIIIlIIIllIIllII = new PacketBuffer(Unpooled.buffer());
            lllllllllllllIIIlIIIlIIIllIIllII.writeInt(this.tileBeacon.getField(1));
            lllllllllllllIIIlIIIlIIIllIIllII.writeInt(this.tileBeacon.getField(2));
            this.mc.getConnection().sendPacket(new CPacketCustomPayload("MC|Beacon", lllllllllllllIIIlIIIlIIIllIIllII));
            this.mc.player.connection.sendPacket(new CPacketCloseWindow(this.mc.player.openContainer.windowId));
            this.mc.displayGuiScreen(null);
        }
        else if (lllllllllllllIIIlIIIlIIIllIIlllI instanceof PowerButton) {
            final PowerButton lllllllllllllIIIlIIIlIIIllIIlIll = (PowerButton)lllllllllllllIIIlIIIlIIIllIIlllI;
            if (lllllllllllllIIIlIIIlIIIllIIlIll.isSelected()) {
                return;
            }
            final int lllllllllllllIIIlIIIlIIIllIIlIlI = Potion.getIdFromPotion(lllllllllllllIIIlIIIlIIIllIIlIll.effect);
            if (lllllllllllllIIIlIIIlIIIllIIlIll.tier < 3) {
                this.tileBeacon.setField(1, lllllllllllllIIIlIIIlIIIllIIlIlI);
            }
            else {
                this.tileBeacon.setField(2, lllllllllllllIIIlIIIlIIIllIIlIlI);
            }
            this.buttonList.clear();
            this.initGui();
            this.updateScreen();
        }
    }
    
    static class Button extends GuiButton
    {
        private final /* synthetic */ ResourceLocation iconTexture;
        private final /* synthetic */ int iconX;
        private /* synthetic */ boolean selected;
        private final /* synthetic */ int iconY;
        
        public boolean isSelected() {
            return this.selected;
        }
        
        public void setSelected(final boolean llllllllllllllllIllIllIIIllIllIl) {
            this.selected = llllllllllllllllIllIllIIIllIllIl;
        }
        
        protected Button(final int llllllllllllllllIllIllIIlIIlIlIl, final int llllllllllllllllIllIllIIlIIlIlII, final int llllllllllllllllIllIllIIlIIIllII, final ResourceLocation llllllllllllllllIllIllIIlIIlIIlI, final int llllllllllllllllIllIllIIlIIlIIIl, final int llllllllllllllllIllIllIIlIIlIIII) {
            super(llllllllllllllllIllIllIIlIIlIlIl, llllllllllllllllIllIllIIlIIlIlII, llllllllllllllllIllIllIIlIIIllII, 22, 22, "");
            this.iconTexture = llllllllllllllllIllIllIIlIIlIIlI;
            this.iconX = llllllllllllllllIllIllIIlIIlIIIl;
            this.iconY = llllllllllllllllIllIllIIlIIlIIII;
        }
        
        public void func_191745_a(final Minecraft llllllllllllllllIllIllIIlIIIIIIl, final int llllllllllllllllIllIllIIIllllIIl, final int llllllllllllllllIllIllIIIlllllll, final float llllllllllllllllIllIllIIIllllllI) {
            if (this.visible) {
                llllllllllllllllIllIllIIlIIIIIIl.getTextureManager().bindTexture(GuiBeacon.BEACON_GUI_TEXTURES);
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                this.hovered = (llllllllllllllllIllIllIIIllllIIl >= this.xPosition && llllllllllllllllIllIllIIIlllllll >= this.yPosition && llllllllllllllllIllIllIIIllllIIl < this.xPosition + this.width && llllllllllllllllIllIllIIIlllllll < this.yPosition + this.height);
                final int llllllllllllllllIllIllIIIlllllIl = 219;
                int llllllllllllllllIllIllIIIlllllII = 0;
                if (!this.enabled) {
                    llllllllllllllllIllIllIIIlllllII += this.width * 2;
                }
                else if (this.selected) {
                    llllllllllllllllIllIllIIIlllllII += this.width * 1;
                }
                else if (this.hovered) {
                    llllllllllllllllIllIllIIIlllllII += this.width * 3;
                }
                this.drawTexturedModalRect(this.xPosition, this.yPosition, llllllllllllllllIllIllIIIlllllII, 219, this.width, this.height);
                if (!GuiBeacon.BEACON_GUI_TEXTURES.equals(this.iconTexture)) {
                    llllllllllllllllIllIllIIlIIIIIIl.getTextureManager().bindTexture(this.iconTexture);
                }
                this.drawTexturedModalRect(this.xPosition + 2, this.yPosition + 2, this.iconX, this.iconY, 18, 18);
            }
        }
    }
    
    class ConfirmButton extends Button
    {
        public ConfirmButton(final int lllllllllllllllIIlIlllIllIIIlllI, final int lllllllllllllllIIlIlllIllIIIllIl, final int lllllllllllllllIIlIlllIllIIIllII) {
            super(lllllllllllllllIIlIlllIllIIIlllI, lllllllllllllllIIlIlllIllIIIllIl, lllllllllllllllIIlIlllIllIIIllII, GuiBeacon.BEACON_GUI_TEXTURES, 90, 220);
        }
        
        @Override
        public void drawButtonForegroundLayer(final int lllllllllllllllIIlIlllIllIIIIlll, final int lllllllllllllllIIlIlllIllIIIIllI) {
            GuiBeacon.this.drawCreativeTabHoveringText(I18n.format("gui.done", new Object[0]), lllllllllllllllIIlIlllIllIIIIlll, lllllllllllllllIIlIlllIllIIIIllI);
        }
    }
    
    class CancelButton extends Button
    {
        public CancelButton(final int llllllllllllllIllIIlllIllIIlIIll, final int llllllllllllllIllIIlllIllIIlIIlI, final int llllllllllllllIllIIlllIllIIIllII) {
            super(llllllllllllllIllIIlllIllIIlIIll, llllllllllllllIllIIlllIllIIlIIlI, llllllllllllllIllIIlllIllIIIllII, GuiBeacon.BEACON_GUI_TEXTURES, 112, 220);
        }
        
        @Override
        public void drawButtonForegroundLayer(final int llllllllllllllIllIIlllIllIIIIlII, final int llllllllllllllIllIIlllIllIIIIIll) {
            GuiBeacon.this.drawCreativeTabHoveringText(I18n.format("gui.cancel", new Object[0]), llllllllllllllIllIIlllIllIIIIlII, llllllllllllllIllIIlllIllIIIIIll);
        }
    }
    
    class PowerButton extends Button
    {
        private final /* synthetic */ Potion effect;
        private final /* synthetic */ int tier;
        
        @Override
        public void drawButtonForegroundLayer(final int lllllllllllllIllIllllIlllllIllll, final int lllllllllllllIllIllllIlllllIlllI) {
            String lllllllllllllIllIllllIllllllIIIl = I18n.format(this.effect.getName(), new Object[0]);
            if (this.tier >= 3 && this.effect != MobEffects.REGENERATION) {
                lllllllllllllIllIllllIllllllIIIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllIllllIllllllIIIl)).append(" II"));
            }
            GuiBeacon.this.drawCreativeTabHoveringText(lllllllllllllIllIllllIllllllIIIl, lllllllllllllIllIllllIlllllIllll, lllllllllllllIllIllllIlllllIlllI);
        }
        
        public PowerButton(final int lllllllllllllIllIllllIllllllllIl, final int lllllllllllllIllIlllllIIIIIIIIll, final int lllllllllllllIllIllllIlllllllIll, final Potion lllllllllllllIllIllllIlllllllIlI, final int lllllllllllllIllIlllllIIIIIIIIII) {
            super(lllllllllllllIllIllllIllllllllIl, lllllllllllllIllIlllllIIIIIIIIll, lllllllllllllIllIllllIlllllllIll, GuiContainer.INVENTORY_BACKGROUND, lllllllllllllIllIllllIlllllllIlI.getStatusIconIndex() % 8 * 18, 198 + lllllllllllllIllIllllIlllllllIlI.getStatusIconIndex() / 8 * 18);
            this.effect = lllllllllllllIllIllllIlllllllIlI;
            this.tier = lllllllllllllIllIlllllIIIIIIIIII;
        }
    }
}
