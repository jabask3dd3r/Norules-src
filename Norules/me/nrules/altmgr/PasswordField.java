package me.nrules.altmgr;

import font.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import java.awt.*;
import me.nrules.utils.render.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;

public class PasswordField extends Gui
{
    private final /* synthetic */ int xPos;
    private /* synthetic */ int i;
    /* synthetic */ MinecraftFontRenderer font;
    private /* synthetic */ int selectionEnd;
    private final /* synthetic */ int yPos;
    public /* synthetic */ boolean isFocused;
    private final /* synthetic */ int width;
    private /* synthetic */ boolean canLoseFocus;
    private final /* synthetic */ FontRenderer fontRenderer;
    private /* synthetic */ int enabledColor;
    private /* synthetic */ int cursorPosition;
    private /* synthetic */ String text;
    private /* synthetic */ boolean enableBackgroundDrawing;
    private final /* synthetic */ int height;
    private /* synthetic */ int maxStringLength;
    private /* synthetic */ int cursorCounter;
    private /* synthetic */ boolean b;
    
    public void cursorPos(final int llllllllllllllIlllIIlIllIlIlIlII) {
        this.setCursorPosition(this.selectionEnd + llllllllllllllIlllIIlIllIlIlIlII);
    }
    
    public void setEnableBackgroundDrawing(final boolean llllllllllllllIlllIIlIlIllIlIIIl) {
        this.enableBackgroundDrawing = llllllllllllllIlllIIlIlIllIlIIIl;
    }
    
    public PasswordField(final FontRenderer llllllllllllllIlllIIlIllllIllIII, final int llllllllllllllIlllIIlIllllIlIlll, final int llllllllllllllIlllIIlIllllIlIllI, final int llllllllllllllIlllIIlIllllIlIlIl, final int llllllllllllllIlllIIlIllllIIlllI) {
        this.font = FontLoader.INSTANCE.comfortaa_bold_20;
        this.text = "";
        this.maxStringLength = 50;
        this.enableBackgroundDrawing = true;
        this.canLoseFocus = true;
        this.isFocused = false;
        this.i = 0;
        this.cursorPosition = 0;
        this.selectionEnd = 0;
        this.enabledColor = 14737632;
        this.b = true;
        this.fontRenderer = llllllllllllllIlllIIlIllllIllIII;
        this.xPos = llllllllllllllIlllIIlIllllIlIlll;
        this.yPos = llllllllllllllIlllIIlIllllIlIllI;
        this.width = llllllllllllllIlllIIlIllllIlIlIl;
        this.height = llllllllllllllIlllIIlIllllIIlllI;
    }
    
    private void drawCursorVertical(int llllllllllllllIlllIIlIlIlllIllII, int llllllllllllllIlllIIlIlIlllIlIll, int llllllllllllllIlllIIlIlIlllIlIlI, int llllllllllllllIlllIIlIlIlllIlIIl) {
        if (llllllllllllllIlllIIlIlIlllIllII < llllllllllllllIlllIIlIlIlllIlIlI) {
            final int llllllllllllllIlllIIlIlIllllIIII = llllllllllllllIlllIIlIlIlllIllII;
            llllllllllllllIlllIIlIlIlllIllII = llllllllllllllIlllIIlIlIlllIlIlI;
            llllllllllllllIlllIIlIlIlllIlIlI = llllllllllllllIlllIIlIlIllllIIII;
        }
        if (llllllllllllllIlllIIlIlIlllIlIll < llllllllllllllIlllIIlIlIlllIlIIl) {
            final int llllllllllllllIlllIIlIlIlllIllll = llllllllllllllIlllIIlIlIlllIlIll;
            llllllllllllllIlllIIlIlIlllIlIll = (int)llllllllllllllIlllIIlIlIlllIlIIl;
            llllllllllllllIlllIIlIlIlllIlIIl = llllllllllllllIlllIIlIlIlllIllll;
        }
        final Tessellator llllllllllllllIlllIIlIlIlllIlllI = Tessellator.getInstance();
        final BufferBuilder llllllllllllllIlllIIlIlIlllIllIl = llllllllllllllIlllIIlIlIlllIlllI.getBuffer();
        GL11.glColor4f(0.0f, 0.0f, 255.0f, 255.0f);
        GL11.glDisable(3553);
        GL11.glEnable(3058);
        GL11.glLogicOp(5387);
        llllllllllllllIlllIIlIlIlllIllIl.begin(7, llllllllllllllIlllIIlIlIlllIllIl.getVertexFormat());
        llllllllllllllIlllIIlIlIlllIllIl.pos(llllllllllllllIlllIIlIlIlllIllII, llllllllllllllIlllIIlIlIlllIlIIl, 0.0);
        llllllllllllllIlllIIlIlIlllIllIl.pos(llllllllllllllIlllIIlIlIlllIlIlI, llllllllllllllIlllIIlIlIlllIlIIl, 0.0);
        llllllllllllllIlllIIlIlIlllIllIl.pos(llllllllllllllIlllIIlIlIlllIlIlI, llllllllllllllIlllIIlIlIlllIlIll, 0.0);
        llllllllllllllIlllIIlIlIlllIllIl.pos(llllllllllllllIlllIIlIlIlllIllII, llllllllllllllIlllIIlIlIlllIlIll, 0.0);
        llllllllllllllIlllIIlIlIlllIllIl.finishDrawing();
        GL11.glDisable(3058);
        GL11.glEnable(3553);
    }
    
    public void updateCursorCounter() {
        ++this.cursorCounter;
    }
    
    public void setText(final String llllllllllllllIlllIIlIllllIIIlll) {
        this.text = ((llllllllllllllIlllIIlIllllIIIlll.length() > this.maxStringLength) ? llllllllllllllIlllIIlIllllIIIlll.substring(0, this.maxStringLength) : llllllllllllllIlllIIlIllllIIIlll);
        this.setCursorPositionEnd();
    }
    
    public void writeText(final String llllllllllllllIlllIIlIlllIlIIIIl) {
        String llllllllllllllIlllIIlIlllIlIlIII = "";
        final String llllllllllllllIlllIIlIlllIlIIlll = ChatAllowedCharacters.filterAllowedCharacters(llllllllllllllIlllIIlIlllIlIIIIl);
        final int llllllllllllllIlllIIlIlllIlIIllI = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int llllllllllllllIlllIIlIlllIlIIlIl = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        final int llllllllllllllIlllIIlIlllIlIIlII = this.maxStringLength - this.text.length() - llllllllllllllIlllIIlIlllIlIIllI - this.selectionEnd;
        final boolean llllllllllllllIlllIIlIlllIlIIIll = false;
        if (this.text.length() > 0) {
            llllllllllllllIlllIIlIlllIlIlIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIIlIlllIlIlIII)).append(this.text.substring(0, llllllllllllllIlllIIlIlllIlIIllI)));
        }
        int llllllllllllllIlllIIlIlllIlIlIIl = 0;
        if (llllllllllllllIlllIIlIlllIlIIlII < llllllllllllllIlllIIlIlllIlIIlll.length()) {
            llllllllllllllIlllIIlIlllIlIlIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIIlIlllIlIlIII)).append(llllllllllllllIlllIIlIlllIlIIlll.substring(0, llllllllllllllIlllIIlIlllIlIIlII)));
            final int llllllllllllllIlllIIlIlllIlIlIlI = llllllllllllllIlllIIlIlllIlIIlII;
        }
        else {
            llllllllllllllIlllIIlIlllIlIlIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIIlIlllIlIlIII)).append(llllllllllllllIlllIIlIlllIlIIlll));
            llllllllllllllIlllIIlIlllIlIlIIl = llllllllllllllIlllIIlIlllIlIIlll.length();
        }
        if (this.text.length() > 0 && llllllllllllllIlllIIlIlllIlIIlIl < this.text.length()) {
            llllllllllllllIlllIIlIlllIlIlIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIIlIlllIlIlIII)).append(this.text.substring(llllllllllllllIlllIIlIlllIlIIlIl)));
        }
        this.text = llllllllllllllIlllIIlIlllIlIlIII.replaceAll(" ", "");
        this.cursorPos(llllllllllllllIlllIIlIlllIlIIllI - this.selectionEnd + llllllllllllllIlllIIlIlllIlIlIIl);
    }
    
    public void drawTextBox() {
        if (this.func_73778_q()) {
            if (this.getEnableBackgroundDrawing()) {
                RenderUtils.drawBorderedRect(this.xPos - 1, this.yPos - 1, this.xPos + this.width + 1, this.yPos + this.height + 1, 0.3, new Color(22, 22, 22, 255).getRGB(), new Color(60, 60, 60, 255).getRGB(), true);
                RenderUtils.drawBorderedRect(this.xPos, this.yPos, this.xPos + this.width, this.yPos + this.height, 0.3, new Color(22, 22, 22, 255).getRGB(), new Color(60, 60, 60, 255).getRGB(), true);
            }
            final int llllllllllllllIlllIIlIllIIIlIlIl = this.enabledColor;
            final int llllllllllllllIlllIIlIllIIIlIlII = this.cursorPosition - this.i;
            int llllllllllllllIlllIIlIllIIIlIIll = this.selectionEnd - this.i;
            final String llllllllllllllIlllIIlIllIIIlIIlI = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), this.getWidth());
            final boolean llllllllllllllIlllIIlIllIIIlIIIl = llllllllllllllIlllIIlIllIIIlIlII >= 0 && llllllllllllllIlllIIlIllIIIlIlII <= llllllllllllllIlllIIlIllIIIlIIlI.length();
            final boolean llllllllllllllIlllIIlIllIIIlIIII = this.isFocused && this.cursorCounter / 6 % 2 == 0 && llllllllllllllIlllIIlIllIIIlIIIl;
            final int llllllllllllllIlllIIlIllIIIIllll = this.enableBackgroundDrawing ? (this.xPos + 4) : this.xPos;
            final int llllllllllllllIlllIIlIllIIIIlllI = this.enableBackgroundDrawing ? (this.yPos + (this.height - 8) / 2) : this.yPos;
            int llllllllllllllIlllIIlIllIIIIllIl = llllllllllllllIlllIIlIllIIIIllll;
            if (llllllllllllllIlllIIlIllIIIlIIll > llllllllllllllIlllIIlIllIIIlIIlI.length()) {
                llllllllllllllIlllIIlIllIIIlIIll = llllllllllllllIlllIIlIllIIIlIIlI.length();
            }
            if (llllllllllllllIlllIIlIllIIIlIIlI.length() > 0) {
                if (llllllllllllllIlllIIlIllIIIlIIIl) {
                    llllllllllllllIlllIIlIllIIIlIIlI.substring(0, llllllllllllllIlllIIlIllIIIlIlII);
                }
                llllllllllllllIlllIIlIllIIIIllIl = Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(this.text.replaceAll("(?s).", "*"), (float)llllllllllllllIlllIIlIllIIIIllll, (float)llllllllllllllIlllIIlIllIIIIlllI, llllllllllllllIlllIIlIllIIIlIlIl);
            }
            final boolean llllllllllllllIlllIIlIllIIIIllII = this.cursorPosition < this.text.length() || this.text.length() >= this.getMaxStringLength();
            int llllllllllllllIlllIIlIllIIIIlIll = llllllllllllllIlllIIlIllIIIIllIl;
            if (!llllllllllllllIlllIIlIllIIIlIIIl) {
                llllllllllllllIlllIIlIllIIIIlIll = ((llllllllllllllIlllIIlIllIIIlIlII > 0) ? (llllllllllllllIlllIIlIllIIIIllll + this.width) : llllllllllllllIlllIIlIllIIIIllll);
            }
            else if (llllllllllllllIlllIIlIllIIIIllII) {
                llllllllllllllIlllIIlIllIIIIlIll = llllllllllllllIlllIIlIllIIIIllIl - 1;
                --llllllllllllllIlllIIlIllIIIIllIl;
            }
            if (llllllllllllllIlllIIlIllIIIlIIlI.length() > 0 && llllllllllllllIlllIIlIllIIIlIIIl && llllllllllllllIlllIIlIllIIIlIlII < llllllllllllllIlllIIlIllIIIlIIlI.length()) {
                Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(llllllllllllllIlllIIlIllIIIlIIlI.substring(llllllllllllllIlllIIlIllIIIlIlII), (float)llllllllllllllIlllIIlIllIIIIllIl, (float)llllllllllllllIlllIIlIllIIIIlllI, llllllllllllllIlllIIlIllIIIlIlIl);
            }
            if (llllllllllllllIlllIIlIllIIIlIIII) {
                if (llllllllllllllIlllIIlIllIIIIllII) {
                    Gui.drawRect(llllllllllllllIlllIIlIllIIIIlIll, llllllllllllllIlllIIlIllIIIIlllI - 1, llllllllllllllIlllIIlIllIIIIlIll + 1, llllllllllllllIlllIIlIllIIIIlllI + 1 + this.font.getHeight(), -3092272);
                }
                else {
                    Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("_", (float)llllllllllllllIlllIIlIllIIIIlIll, (float)llllllllllllllIlllIIlIllIIIIlllI, llllllllllllllIlllIIlIllIIIlIlIl);
                }
            }
            if (llllllllllllllIlllIIlIllIIIlIIll != llllllllllllllIlllIIlIllIIIlIlII) {
                final int llllllllllllllIlllIIlIllIIIIlIlI = llllllllllllllIlllIIlIllIIIIllll + this.fontRenderer.getStringWidth(llllllllllllllIlllIIlIllIIIlIIlI.substring(0, llllllllllllllIlllIIlIllIIIlIIll));
                this.drawCursorVertical(llllllllllllllIlllIIlIllIIIIlIll, llllllllllllllIlllIIlIllIIIIlllI - 1, llllllllllllllIlllIIlIllIIIIlIlI - 1, llllllllllllllIlllIIlIllIIIIlllI + 1 + this.font.getHeight());
            }
        }
    }
    
    public boolean func_73778_q() {
        return this.b;
    }
    
    public void deleteFromCursor(final int llllllllllllllIlllIIlIlllIIIIllI) {
        if (this.text.length() != 0) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                final boolean llllllllllllllIlllIIlIlllIIIlIll = llllllllllllllIlllIIlIlllIIIIllI < 0;
                final int llllllllllllllIlllIIlIlllIIIlIlI = llllllllllllllIlllIIlIlllIIIlIll ? (this.cursorPosition + llllllllllllllIlllIIlIlllIIIIllI) : this.cursorPosition;
                final int llllllllllllllIlllIIlIlllIIIlIIl = llllllllllllllIlllIIlIlllIIIlIll ? this.cursorPosition : (this.cursorPosition + llllllllllllllIlllIIlIlllIIIIllI);
                String llllllllllllllIlllIIlIlllIIIlIII = "";
                if (llllllllllllllIlllIIlIlllIIIlIlI >= 0) {
                    llllllllllllllIlllIIlIlllIIIlIII = this.text.substring(0, llllllllllllllIlllIIlIlllIIIlIlI);
                }
                if (llllllllllllllIlllIIlIlllIIIlIIl < this.text.length()) {
                    llllllllllllllIlllIIlIlllIIIlIII = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlllIIlIlllIIIlIII)).append(this.text.substring(llllllllllllllIlllIIlIlllIIIlIIl)));
                }
                this.text = llllllllllllllIlllIIlIlllIIIlIII;
                if (llllllllllllllIlllIIlIlllIIIlIll) {
                    this.cursorPos(llllllllllllllIlllIIlIlllIIIIllI);
                }
            }
        }
    }
    
    public int getWidth() {
        return this.getEnableBackgroundDrawing() ? (this.width - 8) : this.width;
    }
    
    public void setCursorPositionZero() {
        this.setCursorPosition(0);
    }
    
    public void setCursorPosition(final int llllllllllllllIlllIIlIllIlIIllII) {
        this.cursorPosition = llllllllllllllIlllIIlIllIlIIllII;
        final int llllllllllllllIlllIIlIllIlIIlllI = this.text.length();
        if (this.cursorPosition < 0) {
            this.cursorPosition = 0;
        }
        if (this.cursorPosition > llllllllllllllIlllIIlIllIlIIlllI) {
            this.cursorPosition = llllllllllllllIlllIIlIllIlIIlllI;
        }
        this.func_73800_i(this.cursorPosition);
    }
    
    public int getSelectionEnd() {
        return this.selectionEnd;
    }
    
    public void func_73800_i(int llllllllllllllIlllIIlIlIlIlIlllI) {
        final int llllllllllllllIlllIIlIlIlIllIIll = this.text.length();
        if (llllllllllllllIlllIIlIlIlIlIlllI > llllllllllllllIlllIIlIlIlIllIIll) {
            llllllllllllllIlllIIlIlIlIlIlllI = llllllllllllllIlllIIlIlIlIllIIll;
        }
        if (llllllllllllllIlllIIlIlIlIlIlllI < 0) {
            llllllllllllllIlllIIlIlIlIlIlllI = 0;
        }
        this.selectionEnd = llllllllllllllIlllIIlIlIlIlIlllI;
        if (this.fontRenderer != null) {
            if (this.i > llllllllllllllIlllIIlIlIlIllIIll) {
                this.i = llllllllllllllIlllIIlIlIlIllIIll;
            }
            final int llllllllllllllIlllIIlIlIlIllIIlI = this.getWidth();
            final String llllllllllllllIlllIIlIlIlIllIIIl = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), llllllllllllllIlllIIlIlIlIllIIlI);
            final int llllllllllllllIlllIIlIlIlIllIIII = llllllllllllllIlllIIlIlIlIllIIIl.length() + this.i;
            if (llllllllllllllIlllIIlIlIlIlIlllI == this.i) {
                this.i -= this.fontRenderer.trimStringToWidth(this.text, llllllllllllllIlllIIlIlIlIllIIlI, true).length();
            }
            if (llllllllllllllIlllIIlIlIlIlIlllI > llllllllllllllIlllIIlIlIlIllIIII) {
                this.i += llllllllllllllIlllIIlIlIlIlIlllI - llllllllllllllIlllIIlIlIlIllIIII;
            }
            else if (llllllllllllllIlllIIlIlIlIlIlllI <= this.i) {
                this.i -= this.i - llllllllllllllIlllIIlIlIlIlIlllI;
            }
            if (this.i < 0) {
                this.i = 0;
            }
            if (this.i > llllllllllllllIlllIIlIlIlIllIIll) {
                this.i = llllllllllllllIlllIIlIlIlIllIIll;
            }
        }
    }
    
    public int type(final int llllllllllllllIlllIIlIllIllIIIIl, final int llllllllllllllIlllIIlIllIllIIIII, final boolean llllllllllllllIlllIIlIllIlIlllll) {
        int llllllllllllllIlllIIlIllIllIIlll = llllllllllllllIlllIIlIllIllIIIII;
        final boolean llllllllllllllIlllIIlIllIllIIllI = llllllllllllllIlllIIlIllIllIIIIl < 0;
        for (int llllllllllllllIlllIIlIllIllIIlIl = Math.abs(llllllllllllllIlllIIlIllIllIIIIl), llllllllllllllIlllIIlIllIllIIlII = 0; llllllllllllllIlllIIlIllIllIIlII < llllllllllllllIlllIIlIllIllIIlIl; ++llllllllllllllIlllIIlIllIllIIlII) {
            if (!llllllllllllllIlllIIlIllIllIIllI) {
                final int llllllllllllllIlllIIlIllIllIIIll = this.text.length();
                if ((llllllllllllllIlllIIlIllIllIIlll = this.text.indexOf(32, llllllllllllllIlllIIlIllIllIIlll)) == -1) {
                    llllllllllllllIlllIIlIllIllIIlll = llllllllllllllIlllIIlIllIllIIIll;
                }
                else {
                    while (llllllllllllllIlllIIlIllIlIlllll && llllllllllllllIlllIIlIllIllIIlll < llllllllllllllIlllIIlIllIllIIIll) {
                        if (this.text.charAt(llllllllllllllIlllIIlIllIllIIlll) != ' ') {
                            break;
                        }
                        ++llllllllllllllIlllIIlIllIllIIlll;
                    }
                }
            }
            else {
                while (llllllllllllllIlllIIlIllIlIlllll && llllllllllllllIlllIIlIllIllIIlll > 0) {
                    if (this.text.charAt(llllllllllllllIlllIIlIllIllIIlll - 1) != ' ') {
                        break;
                    }
                    --llllllllllllllIlllIIlIllIllIIlll;
                }
                while (llllllllllllllIlllIIlIllIllIIlll > 0 && this.text.charAt(llllllllllllllIlllIIlIllIllIIlll - 1) != ' ') {
                    --llllllllllllllIlllIIlIllIllIIlll;
                }
            }
        }
        return llllllllllllllIlllIIlIllIllIIlll;
    }
    
    public int getNthWordFromPos(final int llllllllllllllIlllIIlIllIlllIlIl, final int llllllllllllllIlllIIlIllIlllIlll) {
        return this.type(llllllllllllllIlllIIlIllIlllIlIl, this.getCursorPosition(), true);
    }
    
    public void func_73779_a(final int llllllllllllllIlllIIlIlllIIlIlII) {
        if (this.text.length() != 0) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                this.deleteFromCursor(this.getNthWordFromCursor(llllllllllllllIlllIIlIlllIIlIlII) - this.cursorPosition);
            }
        }
    }
    
    public void func_73794_g(final int llllllllllllllIlllIIlIlIllIIlIll) {
        this.enabledColor = llllllllllllllIlllIIlIlIllIIlIll;
    }
    
    public String getSelectedtext() {
        final int llllllllllllllIlllIIlIlllIlllIlI = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int llllllllllllllIlllIIlIlllIlllIIl = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        return this.text.substring(llllllllllllllIlllIIlIlllIlllIlI, llllllllllllllIlllIIlIlllIlllIIl);
    }
    
    public boolean textboxKeyTyped(final char llllllllllllllIlllIIlIllIlIIIIII, final int llllllllllllllIlllIIlIllIIllllll) {
        if (!this.isFocused) {
            return false;
        }
        switch (llllllllllllllIlllIIlIllIlIIIIII) {
            case '\u0001': {
                this.setCursorPositionEnd();
                this.func_73800_i(0);
                return true;
            }
            case '\u0003': {
                GuiScreen.setClipboardString(this.getSelectedtext());
                return true;
            }
            case '\u0016': {
                this.writeText(GuiScreen.getClipboardString());
                return true;
            }
            case '\u0018': {
                GuiScreen.setClipboardString(this.getSelectedtext());
                this.writeText("");
                return true;
            }
            default: {
                switch (llllllllllllllIlllIIlIllIIllllll) {
                    case 14: {
                        if (GuiScreen.isCtrlKeyDown()) {
                            this.func_73779_a(-1);
                        }
                        else {
                            this.deleteFromCursor(-1);
                        }
                        return true;
                    }
                    case 199: {
                        if (GuiScreen.isShiftKeyDown()) {
                            this.func_73800_i(0);
                        }
                        else {
                            this.setCursorPositionZero();
                        }
                        return true;
                    }
                    case 203: {
                        if (GuiScreen.isShiftKeyDown()) {
                            if (GuiScreen.isCtrlKeyDown()) {
                                this.func_73800_i(this.getNthWordFromPos(-1, this.getSelectionEnd()));
                            }
                            else {
                                this.func_73800_i(this.getSelectionEnd() - 1);
                            }
                        }
                        else if (GuiScreen.isCtrlKeyDown()) {
                            this.setCursorPosition(this.getNthWordFromCursor(-1));
                        }
                        else {
                            this.cursorPos(-1);
                        }
                        return true;
                    }
                    case 205: {
                        if (GuiScreen.isShiftKeyDown()) {
                            if (GuiScreen.isCtrlKeyDown()) {
                                this.func_73800_i(this.getNthWordFromPos(1, this.getSelectionEnd()));
                            }
                            else {
                                this.func_73800_i(this.getSelectionEnd() + 1);
                            }
                        }
                        else if (GuiScreen.isCtrlKeyDown()) {
                            this.setCursorPosition(this.getNthWordFromCursor(1));
                        }
                        else {
                            this.cursorPos(1);
                        }
                        return true;
                    }
                    case 207: {
                        if (GuiScreen.isShiftKeyDown()) {
                            this.func_73800_i(this.text.length());
                        }
                        else {
                            this.setCursorPositionEnd();
                        }
                        return true;
                    }
                    case 211: {
                        if (GuiScreen.isCtrlKeyDown()) {
                            this.func_73779_a(1);
                        }
                        else {
                            this.deleteFromCursor(1);
                        }
                        return true;
                    }
                    default: {
                        if (ChatAllowedCharacters.isAllowedCharacter(llllllllllllllIlllIIlIllIlIIIIII)) {
                            this.writeText(Character.toString(llllllllllllllIlllIIlIllIlIIIIII));
                            return true;
                        }
                        return false;
                    }
                }
                break;
            }
        }
    }
    
    public void func_73790_e(final boolean llllllllllllllIlllIIlIlIlIIllIll) {
        this.b = llllllllllllllIlllIIlIlIlIIllIll;
    }
    
    public void mouseClicked(final int llllllllllllllIlllIIlIllIIlIlIlI, final int llllllllllllllIlllIIlIllIIlIlIIl, final int llllllllllllllIlllIIlIllIIlIlIII) {
        final boolean llllllllllllllIlllIIlIllIIlIlllI;
        final boolean llllllllllllllIlllIIlIllIIlIllll = llllllllllllllIlllIIlIllIIlIlllI = (llllllllllllllIlllIIlIllIIlIlIlI >= this.xPos && llllllllllllllIlllIIlIllIIlIlIlI < this.xPos + this.width && llllllllllllllIlllIIlIllIIlIlIIl >= this.yPos && llllllllllllllIlllIIlIllIIlIlIIl < this.yPos + this.height);
        if (this.canLoseFocus) {
            this.setFocused(llllllllllllllIlllIIlIllIIlIllll);
        }
        if (this.isFocused && llllllllllllllIlllIIlIllIIlIlIII == 0) {
            int llllllllllllllIlllIIlIllIIlIllIl = llllllllllllllIlllIIlIllIIlIlIlI - this.xPos;
            if (this.enableBackgroundDrawing) {
                llllllllllllllIlllIIlIllIIlIllIl -= 4;
            }
            final String llllllllllllllIlllIIlIllIIlIllII = this.fontRenderer.trimStringToWidth(this.text.substring(this.i), this.getWidth());
            this.setCursorPosition(this.fontRenderer.trimStringToWidth(llllllllllllllIlllIIlIllIIlIllII, llllllllllllllIlllIIlIllIIlIllIl).length() + this.i);
        }
    }
    
    public int getMaxStringLength() {
        return this.maxStringLength;
    }
    
    public void setMaxStringLength(final int llllllllllllllIlllIIlIlIlllIIIlI) {
        this.maxStringLength = llllllllllllllIlllIIlIlIlllIIIlI;
        if (this.text.length() > llllllllllllllIlllIIlIlIlllIIIlI) {
            this.text = this.text.substring(0, llllllllllllllIlllIIlIlIlllIIIlI);
        }
    }
    
    public int getCursorPosition() {
        return this.cursorPosition;
    }
    
    public int getNthWordFromCursor(final int llllllllllllllIlllIIlIllIlllllII) {
        return this.getNthWordFromPos(llllllllllllllIlllIIlIllIlllllII, this.getCursorPosition());
    }
    
    public boolean getEnableBackgroundDrawing() {
        return this.enableBackgroundDrawing;
    }
    
    public void setCanLoseFocus(final boolean llllllllllllllIlllIIlIlIlIlIIllI) {
        this.canLoseFocus = llllllllllllllIlllIIlIlIlIlIIllI;
    }
    
    public void setFocused(final boolean llllllllllllllIlllIIlIlIllIIIlIl) {
        if (llllllllllllllIlllIIlIlIllIIIlIl && !this.isFocused) {
            this.cursorCounter = 0;
        }
        this.isFocused = llllllllllllllIlllIIlIlIllIIIlIl;
    }
    
    public void setCursorPositionEnd() {
        this.setCursorPosition(this.text.length());
    }
    
    public String getText() {
        final String llllllllllllllIlllIIlIllllIIIIIl = this.text.replaceAll(" ", "");
        return llllllllllllllIlllIIlIllllIIIIIl;
    }
    
    public boolean isFocused() {
        return this.isFocused;
    }
}
