package net.minecraft.client.gui;

import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import com.google.common.base.*;
import net.minecraft.client.*;

public class GuiTextField extends Gui
{
    private /* synthetic */ boolean isFocused;
    private /* synthetic */ int enabledColor;
    private final /* synthetic */ FontRenderer fontRendererInstance;
    private /* synthetic */ GuiPageButtonList.GuiResponder guiResponder;
    public /* synthetic */ int yPosition;
    private final /* synthetic */ int height;
    private /* synthetic */ boolean canLoseFocus;
    private /* synthetic */ int cursorCounter;
    private /* synthetic */ String text;
    private /* synthetic */ boolean isEnabled;
    private /* synthetic */ int selectionEnd;
    private /* synthetic */ int cursorPosition;
    private final /* synthetic */ int width;
    private /* synthetic */ int lineScrollOffset;
    private /* synthetic */ int disabledColor;
    private /* synthetic */ boolean visible;
    private /* synthetic */ int maxStringLength;
    private /* synthetic */ boolean enableBackgroundDrawing;
    private /* synthetic */ Predicate<String> validator;
    private final /* synthetic */ int id;
    public /* synthetic */ int xPosition;
    
    public int getNthWordFromPos(final int lllllllllllllIlIIIIlIIllIIlIIIIl, final int lllllllllllllIlIIIIlIIllIIlIIIII) {
        return this.getNthWordFromPosWS(lllllllllllllIlIIIIlIIllIIlIIIIl, lllllllllllllIlIIIIlIIllIIlIIIII, true);
    }
    
    public void setMaxStringLength(final int lllllllllllllIlIIIIlIIIlllIIIlII) {
        this.maxStringLength = lllllllllllllIlIIIIlIIIlllIIIlII;
        if (this.text.length() > lllllllllllllIlIIIIlIIIlllIIIlII) {
            this.text = this.text.substring(0, lllllllllllllIlIIIIlIIIlllIIIlII);
        }
    }
    
    public boolean mouseClicked(final int lllllllllllllIlIIIIlIIlIIIIlIlIl, final int lllllllllllllIlIIIIlIIlIIIIlIlII, final int lllllllllllllIlIIIIlIIlIIIIlIIll) {
        final boolean lllllllllllllIlIIIIlIIlIIIIlIIlI = lllllllllllllIlIIIIlIIlIIIIlIlIl >= this.xPosition && lllllllllllllIlIIIIlIIlIIIIlIlIl < this.xPosition + this.width && lllllllllllllIlIIIIlIIlIIIIlIlII >= this.yPosition && lllllllllllllIlIIIIlIIlIIIIlIlII < this.yPosition + this.height;
        if (this.canLoseFocus) {
            this.setFocused(lllllllllllllIlIIIIlIIlIIIIlIIlI);
        }
        if (this.isFocused && lllllllllllllIlIIIIlIIlIIIIlIIlI && lllllllllllllIlIIIIlIIlIIIIlIIll == 0) {
            int lllllllllllllIlIIIIlIIlIIIIlIIIl = lllllllllllllIlIIIIlIIlIIIIlIlIl - this.xPosition;
            if (this.enableBackgroundDrawing) {
                lllllllllllllIlIIIIlIIlIIIIlIIIl -= 4;
            }
            final String lllllllllllllIlIIIIlIIlIIIIlIIII = this.fontRendererInstance.trimStringToWidth(this.text.substring(this.lineScrollOffset), this.getWidth());
            this.setCursorPosition(this.fontRendererInstance.trimStringToWidth(lllllllllllllIlIIIIlIIlIIIIlIIII, lllllllllllllIlIIIIlIIlIIIIlIIIl).length() + this.lineScrollOffset);
            return true;
        }
        return false;
    }
    
    public int getWidth() {
        return this.getEnableBackgroundDrawing() ? (this.width - 8) : this.width;
    }
    
    public int getNthWordFromPosWS(final int lllllllllllllIlIIIIlIIllIIIIlIIl, final int lllllllllllllIlIIIIlIIllIIIlIIIl, final boolean lllllllllllllIlIIIIlIIllIIIlIIII) {
        int lllllllllllllIlIIIIlIIllIIIIllll = lllllllllllllIlIIIIlIIllIIIlIIIl;
        final boolean lllllllllllllIlIIIIlIIllIIIIlllI = lllllllllllllIlIIIIlIIllIIIIlIIl < 0;
        for (int lllllllllllllIlIIIIlIIllIIIIllIl = Math.abs(lllllllllllllIlIIIIlIIllIIIIlIIl), lllllllllllllIlIIIIlIIllIIIIllII = 0; lllllllllllllIlIIIIlIIllIIIIllII < lllllllllllllIlIIIIlIIllIIIIllIl; ++lllllllllllllIlIIIIlIIllIIIIllII) {
            if (!lllllllllllllIlIIIIlIIllIIIIlllI) {
                final int lllllllllllllIlIIIIlIIllIIIIlIll = this.text.length();
                lllllllllllllIlIIIIlIIllIIIIllll = this.text.indexOf(32, lllllllllllllIlIIIIlIIllIIIIllll);
                if (lllllllllllllIlIIIIlIIllIIIIllll == -1) {
                    lllllllllllllIlIIIIlIIllIIIIllll = lllllllllllllIlIIIIlIIllIIIIlIll;
                }
                else {
                    while (lllllllllllllIlIIIIlIIllIIIlIIII && lllllllllllllIlIIIIlIIllIIIIllll < lllllllllllllIlIIIIlIIllIIIIlIll) {
                        if (this.text.charAt(lllllllllllllIlIIIIlIIllIIIIllll) != ' ') {
                            break;
                        }
                        ++lllllllllllllIlIIIIlIIllIIIIllll;
                    }
                }
            }
            else {
                while (lllllllllllllIlIIIIlIIllIIIlIIII && lllllllllllllIlIIIIlIIllIIIIllll > 0) {
                    if (this.text.charAt(lllllllllllllIlIIIIlIIllIIIIllll - 1) != ' ') {
                        break;
                    }
                    --lllllllllllllIlIIIIlIIllIIIIllll;
                }
                while (lllllllllllllIlIIIIlIIllIIIIllll > 0 && this.text.charAt(lllllllllllllIlIIIIlIIllIIIIllll - 1) != ' ') {
                    --lllllllllllllIlIIIIlIIllIIIIllll;
                }
            }
        }
        return lllllllllllllIlIIIIlIIllIIIIllll;
    }
    
    public boolean textboxKeyTyped(final char lllllllllllllIlIIIIlIIlIlllIlIII, final int lllllllllllllIlIIIIlIIlIlllIIlll) {
        if (!this.isFocused) {
            return false;
        }
        if (GuiScreen.isKeyComboCtrlA(lllllllllllllIlIIIIlIIlIlllIIlll)) {
            this.setCursorPositionEnd();
            this.setSelectionPos(0);
            return true;
        }
        if (GuiScreen.isKeyComboCtrlC(lllllllllllllIlIIIIlIIlIlllIIlll)) {
            GuiScreen.setClipboardString(this.getSelectedText());
            return true;
        }
        if (GuiScreen.isKeyComboCtrlV(lllllllllllllIlIIIIlIIlIlllIIlll)) {
            if (this.isEnabled) {
                this.writeText(GuiScreen.getClipboardString());
            }
            return true;
        }
        if (GuiScreen.isKeyComboCtrlX(lllllllllllllIlIIIIlIIlIlllIIlll)) {
            GuiScreen.setClipboardString(this.getSelectedText());
            if (this.isEnabled) {
                this.writeText("");
            }
            return true;
        }
        switch (lllllllllllllIlIIIIlIIlIlllIIlll) {
            case 14: {
                if (GuiScreen.isCtrlKeyDown()) {
                    if (this.isEnabled) {
                        this.deleteWords(-1);
                    }
                }
                else if (this.isEnabled) {
                    this.deleteFromCursor(-1);
                }
                return true;
            }
            case 199: {
                if (GuiScreen.isShiftKeyDown()) {
                    this.setSelectionPos(0);
                }
                else {
                    this.setCursorPositionZero();
                }
                return true;
            }
            case 203: {
                if (GuiScreen.isShiftKeyDown()) {
                    if (GuiScreen.isCtrlKeyDown()) {
                        this.setSelectionPos(this.getNthWordFromPos(-1, this.getSelectionEnd()));
                    }
                    else {
                        this.setSelectionPos(this.getSelectionEnd() - 1);
                    }
                }
                else if (GuiScreen.isCtrlKeyDown()) {
                    this.setCursorPosition(this.getNthWordFromCursor(-1));
                }
                else {
                    this.moveCursorBy(-1);
                }
                return true;
            }
            case 205: {
                if (GuiScreen.isShiftKeyDown()) {
                    if (GuiScreen.isCtrlKeyDown()) {
                        this.setSelectionPos(this.getNthWordFromPos(1, this.getSelectionEnd()));
                    }
                    else {
                        this.setSelectionPos(this.getSelectionEnd() + 1);
                    }
                }
                else if (GuiScreen.isCtrlKeyDown()) {
                    this.setCursorPosition(this.getNthWordFromCursor(1));
                }
                else {
                    this.moveCursorBy(1);
                }
                return true;
            }
            case 207: {
                if (GuiScreen.isShiftKeyDown()) {
                    this.setSelectionPos(this.text.length());
                }
                else {
                    this.setCursorPositionEnd();
                }
                return true;
            }
            case 211: {
                if (GuiScreen.isCtrlKeyDown()) {
                    if (this.isEnabled) {
                        this.deleteWords(1);
                    }
                }
                else if (this.isEnabled) {
                    this.deleteFromCursor(1);
                }
                return true;
            }
            default: {
                if (ChatAllowedCharacters.isAllowedCharacter(lllllllllllllIlIIIIlIIlIlllIlIII)) {
                    if (this.isEnabled) {
                        this.writeText(Character.toString(lllllllllllllIlIIIIlIIlIlllIlIII));
                    }
                    return true;
                }
                return false;
            }
        }
    }
    
    public void updateCursorCounter() {
        ++this.cursorCounter;
    }
    
    public void setCanLoseFocus(final boolean lllllllllllllIlIIIIlIIIlIllllllI) {
        this.canLoseFocus = lllllllllllllIlIIIIlIIIlIllllllI;
    }
    
    public void deleteWords(final int lllllllllllllIlIIIIlIIllIlIIIIll) {
        if (!this.text.isEmpty()) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                this.deleteFromCursor(this.getNthWordFromCursor(lllllllllllllIlIIIIlIIllIlIIIIll) - this.cursorPosition);
            }
        }
    }
    
    public void setSelectionPos(int lllllllllllllIlIIIIlIIIllIIIIllI) {
        final int lllllllllllllIlIIIIlIIIllIIIlIll = this.text.length();
        if (lllllllllllllIlIIIIlIIIllIIIIllI > lllllllllllllIlIIIIlIIIllIIIlIll) {
            lllllllllllllIlIIIIlIIIllIIIIllI = lllllllllllllIlIIIIlIIIllIIIlIll;
        }
        if (lllllllllllllIlIIIIlIIIllIIIIllI < 0) {
            lllllllllllllIlIIIIlIIIllIIIIllI = 0;
        }
        this.selectionEnd = lllllllllllllIlIIIIlIIIllIIIIllI;
        if (this.fontRendererInstance != null) {
            if (this.lineScrollOffset > lllllllllllllIlIIIIlIIIllIIIlIll) {
                this.lineScrollOffset = lllllllllllllIlIIIIlIIIllIIIlIll;
            }
            final int lllllllllllllIlIIIIlIIIllIIIlIlI = this.getWidth();
            final String lllllllllllllIlIIIIlIIIllIIIlIIl = this.fontRendererInstance.trimStringToWidth(this.text.substring(this.lineScrollOffset), lllllllllllllIlIIIIlIIIllIIIlIlI);
            final int lllllllllllllIlIIIIlIIIllIIIlIII = lllllllllllllIlIIIIlIIIllIIIlIIl.length() + this.lineScrollOffset;
            if (lllllllllllllIlIIIIlIIIllIIIIllI == this.lineScrollOffset) {
                this.lineScrollOffset -= this.fontRendererInstance.trimStringToWidth(this.text, lllllllllllllIlIIIIlIIIllIIIlIlI, true).length();
            }
            if (lllllllllllllIlIIIIlIIIllIIIIllI > lllllllllllllIlIIIIlIIIllIIIlIII) {
                this.lineScrollOffset += lllllllllllllIlIIIIlIIIllIIIIllI - lllllllllllllIlIIIIlIIIllIIIlIII;
            }
            else if (lllllllllllllIlIIIIlIIIllIIIIllI <= this.lineScrollOffset) {
                this.lineScrollOffset -= this.lineScrollOffset - lllllllllllllIlIIIIlIIIllIIIIllI;
            }
            this.lineScrollOffset = MathHelper.clamp(this.lineScrollOffset, 0, lllllllllllllIlIIIIlIIIllIIIlIll);
        }
    }
    
    public void setCursorPositionEnd() {
        this.setCursorPosition(this.text.length());
    }
    
    public void deleteFromCursor(final int lllllllllllllIlIIIIlIIllIIlllIIl) {
        if (!this.text.isEmpty()) {
            if (this.selectionEnd != this.cursorPosition) {
                this.writeText("");
            }
            else {
                final boolean lllllllllllllIlIIIIlIIllIIlllIII = lllllllllllllIlIIIIlIIllIIlllIIl < 0;
                final int lllllllllllllIlIIIIlIIllIIllIlll = lllllllllllllIlIIIIlIIllIIlllIII ? (this.cursorPosition + lllllllllllllIlIIIIlIIllIIlllIIl) : this.cursorPosition;
                final int lllllllllllllIlIIIIlIIllIIllIllI = lllllllllllllIlIIIIlIIllIIlllIII ? this.cursorPosition : (this.cursorPosition + lllllllllllllIlIIIIlIIllIIlllIIl);
                String lllllllllllllIlIIIIlIIllIIllIlIl = "";
                if (lllllllllllllIlIIIIlIIllIIllIlll >= 0) {
                    lllllllllllllIlIIIIlIIllIIllIlIl = this.text.substring(0, lllllllllllllIlIIIIlIIllIIllIlll);
                }
                if (lllllllllllllIlIIIIlIIllIIllIllI < this.text.length()) {
                    lllllllllllllIlIIIIlIIllIIllIlIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIIIIlIIllIIllIlIl)).append(this.text.substring(lllllllllllllIlIIIIlIIllIIllIllI)));
                }
                if (this.validator.apply((Object)lllllllllllllIlIIIIlIIllIIllIlIl)) {
                    this.text = lllllllllllllIlIIIIlIIllIIllIlIl;
                    if (lllllllllllllIlIIIIlIIllIIlllIII) {
                        this.moveCursorBy(lllllllllllllIlIIIIlIIllIIlllIIl);
                    }
                    this.func_190516_a(this.id, this.text);
                }
            }
        }
    }
    
    public void setGuiResponder(final GuiPageButtonList.GuiResponder lllllllllllllIlIIIIlIIlllIIIIllI) {
        this.guiResponder = lllllllllllllIlIIIIlIIlllIIIIllI;
    }
    
    public int getSelectionEnd() {
        return this.selectionEnd;
    }
    
    public void setValidator(final Predicate<String> lllllllllllllIlIIIIlIIllIllIlIll) {
        this.validator = lllllllllllllIlIIIIlIIllIllIlIll;
    }
    
    public int getNthWordFromCursor(final int lllllllllllllIlIIIIlIIllIIlIIllI) {
        return this.getNthWordFromPos(lllllllllllllIlIIIIlIIllIIlIIllI, this.getCursorPosition());
    }
    
    public void setCursorPosition(final int lllllllllllllIlIIIIlIIlIllllIlll) {
        this.cursorPosition = lllllllllllllIlIIIIlIIlIllllIlll;
        final int lllllllllllllIlIIIIlIIlIllllIllI = this.text.length();
        this.cursorPosition = MathHelper.clamp(this.cursorPosition, 0, lllllllllllllIlIIIIlIIlIllllIllI);
        this.setSelectionPos(this.cursorPosition);
    }
    
    public void setTextColor(final int lllllllllllllIlIIIIlIIIllIlIllll) {
        this.enabledColor = lllllllllllllIlIIIIlIIIllIlIllll;
    }
    
    public void setCursorPositionZero() {
        this.setCursorPosition(0);
    }
    
    private void drawCursorVertical(int lllllllllllllIlIIIIlIIIlllIIllll, int lllllllllllllIlIIIIlIIIlllIIlllI, int lllllllllllllIlIIIIlIIIlllIIllIl, int lllllllllllllIlIIIIlIIIlllIIllII) {
        if (lllllllllllllIlIIIIlIIIlllIIllll < lllllllllllllIlIIIIlIIIlllIIllIl) {
            final int lllllllllllllIlIIIIlIIIlllIlIlII = lllllllllllllIlIIIIlIIIlllIIllll;
            lllllllllllllIlIIIIlIIIlllIIllll = lllllllllllllIlIIIIlIIIlllIIllIl;
            lllllllllllllIlIIIIlIIIlllIIllIl = lllllllllllllIlIIIIlIIIlllIlIlII;
        }
        if (lllllllllllllIlIIIIlIIIlllIIlllI < lllllllllllllIlIIIIlIIIlllIIllII) {
            final int lllllllllllllIlIIIIlIIIlllIlIIll = lllllllllllllIlIIIIlIIIlllIIlllI;
            lllllllllllllIlIIIIlIIIlllIIlllI = lllllllllllllIlIIIIlIIIlllIIllII;
            lllllllllllllIlIIIIlIIIlllIIllII = lllllllllllllIlIIIIlIIIlllIlIIll;
        }
        if (lllllllllllllIlIIIIlIIIlllIIllIl > this.xPosition + this.width) {
            lllllllllllllIlIIIIlIIIlllIIllIl = this.xPosition + this.width;
        }
        if (lllllllllllllIlIIIIlIIIlllIIllll > this.xPosition + this.width) {
            lllllllllllllIlIIIIlIIIlllIIllll = this.xPosition + this.width;
        }
        final Tessellator lllllllllllllIlIIIIlIIIlllIlIIlI = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIlIIIIlIIIlllIlIIIl = lllllllllllllIlIIIIlIIIlllIlIIlI.getBuffer();
        GlStateManager.color(0.0f, 0.0f, 255.0f, 255.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.enableColorLogic();
        GlStateManager.colorLogicOp(GlStateManager.LogicOp.OR_REVERSE);
        lllllllllllllIlIIIIlIIIlllIlIIIl.begin(7, DefaultVertexFormats.POSITION);
        lllllllllllllIlIIIIlIIIlllIlIIIl.pos(lllllllllllllIlIIIIlIIIlllIIllll, lllllllllllllIlIIIIlIIIlllIIllII, 0.0).endVertex();
        lllllllllllllIlIIIIlIIIlllIlIIIl.pos(lllllllllllllIlIIIIlIIIlllIIllIl, lllllllllllllIlIIIIlIIIlllIIllII, 0.0).endVertex();
        lllllllllllllIlIIIIlIIIlllIlIIIl.pos(lllllllllllllIlIIIIlIIIlllIIllIl, lllllllllllllIlIIIIlIIIlllIIlllI, 0.0).endVertex();
        lllllllllllllIlIIIIlIIIlllIlIIIl.pos(lllllllllllllIlIIIIlIIIlllIIllll, lllllllllllllIlIIIIlIIIlllIIlllI, 0.0).endVertex();
        lllllllllllllIlIIIIlIIIlllIlIIlI.draw();
        GlStateManager.disableColorLogic();
        GlStateManager.enableTexture2D();
    }
    
    public void setDisabledTextColour(final int lllllllllllllIlIIIIlIIIllIlIlIll) {
        this.disabledColor = lllllllllllllIlIIIIlIIIllIlIlIll;
    }
    
    public void setEnabled(final boolean lllllllllllllIlIIIIlIIIllIIlllII) {
        this.isEnabled = lllllllllllllIlIIIIlIIIllIIlllII;
    }
    
    public void drawTextBox() {
        if (this.getVisible()) {
            if (this.getEnableBackgroundDrawing()) {
                Gui.drawRect(this.xPosition - 1, this.yPosition - 1, this.xPosition + this.width + 1, this.yPosition + this.height + 1, -6250336);
                Gui.drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, -16777216);
            }
            final int lllllllllllllIlIIIIlIIIllllllIlI = this.isEnabled ? this.enabledColor : this.disabledColor;
            final int lllllllllllllIlIIIIlIIIllllllIIl = this.cursorPosition - this.lineScrollOffset;
            int lllllllllllllIlIIIIlIIIllllllIII = this.selectionEnd - this.lineScrollOffset;
            final String lllllllllllllIlIIIIlIIIlllllIlll = this.fontRendererInstance.trimStringToWidth(this.text.substring(this.lineScrollOffset), this.getWidth());
            final boolean lllllllllllllIlIIIIlIIIlllllIllI = lllllllllllllIlIIIIlIIIllllllIIl >= 0 && lllllllllllllIlIIIIlIIIllllllIIl <= lllllllllllllIlIIIIlIIIlllllIlll.length();
            final boolean lllllllllllllIlIIIIlIIIlllllIlIl = this.isFocused && this.cursorCounter / 6 % 2 == 0 && lllllllllllllIlIIIIlIIIlllllIllI;
            final int lllllllllllllIlIIIIlIIIlllllIlII = this.enableBackgroundDrawing ? (this.xPosition + 4) : this.xPosition;
            final int lllllllllllllIlIIIIlIIIlllllIIll = this.enableBackgroundDrawing ? (this.yPosition + (this.height - 8) / 2) : this.yPosition;
            int lllllllllllllIlIIIIlIIIlllllIIlI = lllllllllllllIlIIIIlIIIlllllIlII;
            if (lllllllllllllIlIIIIlIIIllllllIII > lllllllllllllIlIIIIlIIIlllllIlll.length()) {
                lllllllllllllIlIIIIlIIIllllllIII = lllllllllllllIlIIIIlIIIlllllIlll.length();
            }
            if (!lllllllllllllIlIIIIlIIIlllllIlll.isEmpty()) {
                final String lllllllllllllIlIIIIlIIIlllllIIIl = lllllllllllllIlIIIIlIIIlllllIllI ? lllllllllllllIlIIIIlIIIlllllIlll.substring(0, lllllllllllllIlIIIIlIIIllllllIIl) : lllllllllllllIlIIIIlIIIlllllIlll;
                lllllllllllllIlIIIIlIIIlllllIIlI = this.fontRendererInstance.drawStringWithShadow(lllllllllllllIlIIIIlIIIlllllIIIl, (float)lllllllllllllIlIIIIlIIIlllllIlII, (float)lllllllllllllIlIIIIlIIIlllllIIll, lllllllllllllIlIIIIlIIIllllllIlI);
            }
            final boolean lllllllllllllIlIIIIlIIIlllllIIII = this.cursorPosition < this.text.length() || this.text.length() >= this.getMaxStringLength();
            int lllllllllllllIlIIIIlIIIllllIllll = lllllllllllllIlIIIIlIIIlllllIIlI;
            if (!lllllllllllllIlIIIIlIIIlllllIllI) {
                lllllllllllllIlIIIIlIIIllllIllll = ((lllllllllllllIlIIIIlIIIllllllIIl > 0) ? (lllllllllllllIlIIIIlIIIlllllIlII + this.width) : lllllllllllllIlIIIIlIIIlllllIlII);
            }
            else if (lllllllllllllIlIIIIlIIIlllllIIII) {
                lllllllllllllIlIIIIlIIIllllIllll = lllllllllllllIlIIIIlIIIlllllIIlI - 1;
                --lllllllllllllIlIIIIlIIIlllllIIlI;
            }
            if (!lllllllllllllIlIIIIlIIIlllllIlll.isEmpty() && lllllllllllllIlIIIIlIIIlllllIllI && lllllllllllllIlIIIIlIIIllllllIIl < lllllllllllllIlIIIIlIIIlllllIlll.length()) {
                lllllllllllllIlIIIIlIIIlllllIIlI = this.fontRendererInstance.drawStringWithShadow(lllllllllllllIlIIIIlIIIlllllIlll.substring(lllllllllllllIlIIIIlIIIllllllIIl), (float)lllllllllllllIlIIIIlIIIlllllIIlI, (float)lllllllllllllIlIIIIlIIIlllllIIll, lllllllllllllIlIIIIlIIIllllllIlI);
            }
            if (lllllllllllllIlIIIIlIIIlllllIlIl) {
                if (lllllllllllllIlIIIIlIIIlllllIIII) {
                    Gui.drawRect(lllllllllllllIlIIIIlIIIllllIllll, lllllllllllllIlIIIIlIIIlllllIIll - 1, lllllllllllllIlIIIIlIIIllllIllll + 1, lllllllllllllIlIIIIlIIIlllllIIll + 1 + this.fontRendererInstance.FONT_HEIGHT, -3092272);
                }
                else {
                    this.fontRendererInstance.drawStringWithShadow("_", (float)lllllllllllllIlIIIIlIIIllllIllll, (float)lllllllllllllIlIIIIlIIIlllllIIll, lllllllllllllIlIIIIlIIIllllllIlI);
                }
            }
            if (lllllllllllllIlIIIIlIIIllllllIII != lllllllllllllIlIIIIlIIIllllllIIl) {
                final int lllllllllllllIlIIIIlIIIllllIlllI = lllllllllllllIlIIIIlIIIlllllIlII + this.fontRendererInstance.getStringWidth(lllllllllllllIlIIIIlIIIlllllIlll.substring(0, lllllllllllllIlIIIIlIIIllllllIII));
                this.drawCursorVertical(lllllllllllllIlIIIIlIIIllllIllll, lllllllllllllIlIIIIlIIIlllllIIll - 1, lllllllllllllIlIIIIlIIIllllIlllI - 1, lllllllllllllIlIIIIlIIIlllllIIll + 1 + this.fontRendererInstance.FONT_HEIGHT);
            }
        }
    }
    
    public void setEnableBackgroundDrawing(final boolean lllllllllllllIlIIIIlIIIllIllIlll) {
        this.enableBackgroundDrawing = lllllllllllllIlIIIIlIIIllIllIlll;
    }
    
    public int getCursorPosition() {
        return this.cursorPosition;
    }
    
    public void moveCursorBy(final int lllllllllllllIlIIIIlIIlIllllllII) {
        this.setCursorPosition(this.selectionEnd + lllllllllllllIlIIIIlIIlIllllllII);
    }
    
    public boolean getVisible() {
        return this.visible;
    }
    
    public boolean getEnableBackgroundDrawing() {
        return this.enableBackgroundDrawing;
    }
    
    public boolean isFocused() {
        return this.isFocused;
    }
    
    public GuiTextField(final int lllllllllllllIlIIIIlIIlllIIIllll, final FontRenderer lllllllllllllIlIIIIlIIlllIIIlllI, final int lllllllllllllIlIIIIlIIlllIIlIlII, final int lllllllllllllIlIIIIlIIlllIIlIIll, final int lllllllllllllIlIIIIlIIlllIIIlIll, final int lllllllllllllIlIIIIlIIlllIIIlIlI) {
        this.text = "";
        this.maxStringLength = 32;
        this.enableBackgroundDrawing = true;
        this.canLoseFocus = true;
        this.isEnabled = true;
        this.enabledColor = 14737632;
        this.disabledColor = 7368816;
        this.visible = true;
        this.validator = (Predicate<String>)Predicates.alwaysTrue();
        this.id = lllllllllllllIlIIIIlIIlllIIIllll;
        this.fontRendererInstance = lllllllllllllIlIIIIlIIlllIIIlllI;
        this.xPosition = lllllllllllllIlIIIIlIIlllIIlIlII;
        this.yPosition = lllllllllllllIlIIIIlIIlllIIlIIll;
        this.width = lllllllllllllIlIIIIlIIlllIIIlIll;
        this.height = lllllllllllllIlIIIIlIIlllIIIlIlI;
    }
    
    public void writeText(final String lllllllllllllIlIIIIlIIllIlIlllll) {
        String lllllllllllllIlIIIIlIIllIlIllllI = "";
        final String lllllllllllllIlIIIIlIIllIlIlllIl = ChatAllowedCharacters.filterAllowedCharacters(lllllllllllllIlIIIIlIIllIlIlllll);
        final int lllllllllllllIlIIIIlIIllIlIlllII = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int lllllllllllllIlIIIIlIIllIlIllIll = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        final int lllllllllllllIlIIIIlIIllIlIllIlI = this.maxStringLength - this.text.length() - (lllllllllllllIlIIIIlIIllIlIlllII - lllllllllllllIlIIIIlIIllIlIllIll);
        if (!this.text.isEmpty()) {
            lllllllllllllIlIIIIlIIllIlIllllI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIIIIlIIllIlIllllI)).append(this.text.substring(0, lllllllllllllIlIIIIlIIllIlIlllII)));
        }
        int lllllllllllllIlIIIIlIIllIlIllIII = 0;
        if (lllllllllllllIlIIIIlIIllIlIllIlI < lllllllllllllIlIIIIlIIllIlIlllIl.length()) {
            lllllllllllllIlIIIIlIIllIlIllllI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIIIIlIIllIlIllllI)).append(lllllllllllllIlIIIIlIIllIlIlllIl.substring(0, lllllllllllllIlIIIIlIIllIlIllIlI)));
            final int lllllllllllllIlIIIIlIIllIlIllIIl = lllllllllllllIlIIIIlIIllIlIllIlI;
        }
        else {
            lllllllllllllIlIIIIlIIllIlIllllI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIIIIlIIllIlIllllI)).append(lllllllllllllIlIIIIlIIllIlIlllIl));
            lllllllllllllIlIIIIlIIllIlIllIII = lllllllllllllIlIIIIlIIllIlIlllIl.length();
        }
        if (!this.text.isEmpty() && lllllllllllllIlIIIIlIIllIlIllIll < this.text.length()) {
            lllllllllllllIlIIIIlIIllIlIllllI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIIIIlIIllIlIllllI)).append(this.text.substring(lllllllllllllIlIIIIlIIllIlIllIll)));
        }
        if (this.validator.apply((Object)lllllllllllllIlIIIIlIIllIlIllllI)) {
            this.text = lllllllllllllIlIIIIlIIllIlIllllI;
            this.moveCursorBy(lllllllllllllIlIIIIlIIllIlIlllII - this.selectionEnd + lllllllllllllIlIIIIlIIllIlIllIII);
            this.func_190516_a(this.id, this.text);
        }
    }
    
    public void setText(final String lllllllllllllIlIIIIlIIllIlllllIl) {
        if (this.validator.apply((Object)lllllllllllllIlIIIIlIIllIlllllIl)) {
            if (lllllllllllllIlIIIIlIIllIlllllIl.length() > this.maxStringLength) {
                this.text = lllllllllllllIlIIIIlIIllIlllllIl.substring(0, this.maxStringLength);
            }
            else {
                this.text = lllllllllllllIlIIIIlIIllIlllllIl;
            }
            this.setCursorPositionEnd();
        }
    }
    
    public void func_190516_a(final int lllllllllllllIlIIIIlIIllIlIIlIII, final String lllllllllllllIlIIIIlIIllIlIIIlll) {
        if (this.guiResponder != null) {
            this.guiResponder.setEntryValue(lllllllllllllIlIIIIlIIllIlIIlIII, lllllllllllllIlIIIIlIIllIlIIIlll);
        }
    }
    
    public int getMaxStringLength() {
        return this.maxStringLength;
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setVisible(final boolean lllllllllllllIlIIIIlIIIlIlllIlIl) {
        this.visible = lllllllllllllIlIIIIlIIIlIlllIlIl;
    }
    
    public void setFocused(final boolean lllllllllllllIlIIIIlIIIllIlIIlIl) {
        if (lllllllllllllIlIIIIlIIIllIlIIlIl && !this.isFocused) {
            this.cursorCounter = 0;
        }
        this.isFocused = lllllllllllllIlIIIIlIIIllIlIIlIl;
        if (Minecraft.getMinecraft().currentScreen != null) {
            Minecraft.getMinecraft().currentScreen.func_193975_a(lllllllllllllIlIIIIlIIIllIlIIlIl);
        }
    }
    
    public String getSelectedText() {
        final int lllllllllllllIlIIIIlIIllIlllIIll = (this.cursorPosition < this.selectionEnd) ? this.cursorPosition : this.selectionEnd;
        final int lllllllllllllIlIIIIlIIllIlllIIlI = (this.cursorPosition < this.selectionEnd) ? this.selectionEnd : this.cursorPosition;
        return this.text.substring(lllllllllllllIlIIIIlIIllIlllIIll, lllllllllllllIlIIIIlIIllIlllIIlI);
    }
    
    public int getId() {
        return this.id;
    }
}
