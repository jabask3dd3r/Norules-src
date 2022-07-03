package net.minecraft.client.gui.inventory;

import net.minecraft.client.gui.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import java.io.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.renderer.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.*;
import org.lwjgl.input.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.client.network.*;

public class GuiEditSign extends GuiScreen
{
    private /* synthetic */ int editLine;
    private final /* synthetic */ TileEntitySign tileSign;
    private /* synthetic */ int updateCounter;
    private /* synthetic */ GuiButton doneBtn;
    
    @Override
    protected void keyTyped(final char llllllllllllllIIIllllIIllllIIIll, final int llllllllllllllIIIllllIIllllIIlll) throws IOException {
        if (llllllllllllllIIIllllIIllllIIlll == 200) {
            this.editLine = (this.editLine - 1 & 0x3);
        }
        if (llllllllllllllIIIllllIIllllIIlll == 208 || llllllllllllllIIIllllIIllllIIlll == 28 || llllllllllllllIIIllllIIllllIIlll == 156) {
            this.editLine = (this.editLine + 1 & 0x3);
        }
        String llllllllllllllIIIllllIIllllIIlIl = this.tileSign.signText[this.editLine].getUnformattedText();
        if (llllllllllllllIIIllllIIllllIIlll == 14 && !llllllllllllllIIIllllIIllllIIlIl.isEmpty()) {
            llllllllllllllIIIllllIIllllIIlIl = llllllllllllllIIIllllIIllllIIlIl.substring(0, llllllllllllllIIIllllIIllllIIlIl.length() - 1);
        }
        if (ChatAllowedCharacters.isAllowedCharacter(llllllllllllllIIIllllIIllllIIIll) && this.fontRendererObj.getStringWidth(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIllllIIllllIIlIl)).append(llllllllllllllIIIllllIIllllIIIll))) <= 90) {
            llllllllllllllIIIllllIIllllIIlIl = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIllllIIllllIIlIl)).append(llllllllllllllIIIllllIIllllIIIll));
        }
        this.tileSign.signText[this.editLine] = new TextComponentString(llllllllllllllIIIllllIIllllIIlIl);
        if (llllllllllllllIIIllllIIllllIIlll == 1) {
            this.actionPerformed(this.doneBtn);
        }
    }
    
    public GuiEditSign(final TileEntitySign llllllllllllllIIIllllIlIIIIllIIl) {
        this.tileSign = llllllllllllllIIIllllIlIIIIllIIl;
    }
    
    @Override
    public void updateScreen() {
        ++this.updateCounter;
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIIllllIIlllIIIlIl, final int llllllllllllllIIIllllIIllIlllIll, final float llllllllllllllIIIllllIIllIlllIlI) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("sign.edit", new Object[0]), this.width / 2, 40, 16777215);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)(this.width / 2), 0.0f, 50.0f);
        final float llllllllllllllIIIllllIIlllIIIIlI = 93.75f;
        GlStateManager.scale(-93.75f, -93.75f, -93.75f);
        GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
        final Block llllllllllllllIIIllllIIlllIIIIIl = this.tileSign.getBlockType();
        if (llllllllllllllIIIllllIIlllIIIIIl == Blocks.STANDING_SIGN) {
            final float llllllllllllllIIIllllIIlllIIIIII = this.tileSign.getBlockMetadata() * 360 / 16.0f;
            GlStateManager.rotate(llllllllllllllIIIllllIIlllIIIIII, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.0f, -1.0625f, 0.0f);
        }
        else {
            final int llllllllllllllIIIllllIIllIllllll = this.tileSign.getBlockMetadata();
            float llllllllllllllIIIllllIIllIlllllI = 0.0f;
            if (llllllllllllllIIIllllIIllIllllll == 2) {
                llllllllllllllIIIllllIIllIlllllI = 180.0f;
            }
            if (llllllllllllllIIIllllIIllIllllll == 4) {
                llllllllllllllIIIllllIIllIlllllI = 90.0f;
            }
            if (llllllllllllllIIIllllIIllIllllll == 5) {
                llllllllllllllIIIllllIIllIlllllI = -90.0f;
            }
            GlStateManager.rotate(llllllllllllllIIIllllIIllIlllllI, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.0f, -1.0625f, 0.0f);
        }
        if (this.updateCounter / 6 % 2 == 0) {
            this.tileSign.lineBeingEdited = this.editLine;
        }
        TileEntityRendererDispatcher.instance.renderTileEntityAt(this.tileSign, -0.5, -0.75, -0.5, 0.0f);
        this.tileSign.lineBeingEdited = -1;
        GlStateManager.popMatrix();
        super.drawScreen(llllllllllllllIIIllllIIlllIIIlIl, llllllllllllllIIIllllIIllIlllIll, llllllllllllllIIIllllIIllIlllIlI);
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        this.doneBtn = this.addButton(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120, I18n.format("gui.done", new Object[0])));
        this.tileSign.setEditable(false);
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIIIllllIIllllllllI) throws IOException {
        if (llllllllllllllIIIllllIIllllllllI.enabled && llllllllllllllIIIllllIIllllllllI.id == 0) {
            this.tileSign.markDirty();
            this.mc.displayGuiScreen(null);
        }
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        final NetHandlerPlayClient llllllllllllllIIIllllIlIIIIIllll = this.mc.getConnection();
        if (llllllllllllllIIIllllIlIIIIIllll != null) {
            llllllllllllllIIIllllIlIIIIIllll.sendPacket(new CPacketUpdateSign(this.tileSign.getPos(), this.tileSign.signText));
        }
        this.tileSign.setEditable(true);
    }
}
