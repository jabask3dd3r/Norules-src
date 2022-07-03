package net.minecraft.client.gui;

import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;
import me.nrules.event.events.*;
import com.google.common.collect.*;
import net.minecraft.util.text.*;
import javax.annotation.*;
import org.apache.logging.log4j.*;
import java.util.*;

public class GuiNewChat extends Gui
{
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ boolean isScrolled;
    private /* synthetic */ int scrollPos;
    private /* synthetic */ double offset;
    private final /* synthetic */ List<ChatLine> chatLines;
    private /* synthetic */ double deltaY;
    private final /* synthetic */ List<String> sentMessages;
    private final /* synthetic */ List<ChatLine> drawnChatLines;
    public static /* synthetic */ float globalOffset;
    private final /* synthetic */ Minecraft mc;
    
    public void clearChatMessages(final boolean llllllllllllllIIIlIlllllllIIlIll) {
        this.drawnChatLines.clear();
        this.chatLines.clear();
        if (llllllllllllllIIIlIlllllllIIlIll) {
            this.sentMessages.clear();
        }
    }
    
    public int getChatHeight() {
        return calculateChatboxHeight(this.getChatOpen() ? this.mc.gameSettings.chatHeightFocused : this.mc.gameSettings.chatHeightUnfocused);
    }
    
    public void drawChat(final int llllllllllllllIIIlIllllllllllIIl) {
        this.offset += this.deltaY;
        this.deltaY /= Math.pow(0.99, -Minecraft.frameTime);
        if ((int)this.offset != 0 && (int)this.offset % 8 == 0) {
            this.offset = 8.0;
        }
        if (this.mc.gameSettings.chatVisibility != EntityPlayer.EnumChatVisibility.HIDDEN) {
            final int llllllllllllllIIIlIllllllllllIII = this.getLineCount();
            final int llllllllllllllIIIlIlllllllllIlll = this.drawnChatLines.size();
            final float llllllllllllllIIIlIlllllllllIllI = this.mc.gameSettings.chatOpacity * 0.9f + 0.1f;
            if (llllllllllllllIIIlIlllllllllIlll > 0) {
                boolean llllllllllllllIIIlIlllllllllIlIl = false;
                if (this.getChatOpen()) {
                    llllllllllllllIIIlIlllllllllIlIl = true;
                }
                final float llllllllllllllIIIlIlllllllllIlII = this.getChatScale();
                final int llllllllllllllIIIlIlllllllllIIll = MathHelper.ceil(this.getChatWidth() / llllllllllllllIIIlIlllllllllIlII);
                GlStateManager.pushMatrix();
                GlStateManager.translate(2.0f, 8.0f, 0.0f);
                GlStateManager.scale(llllllllllllllIIIlIlllllllllIlII, llllllllllllllIIIlIlllllllllIlII, 1.0f);
                int llllllllllllllIIIlIlllllllllIIlI = 0;
                for (int llllllllllllllIIIlIlllllllllIIIl = 0; llllllllllllllIIIlIlllllllllIIIl + this.scrollPos < this.drawnChatLines.size() && llllllllllllllIIIlIlllllllllIIIl < llllllllllllllIIIlIllllllllllIII; ++llllllllllllllIIIlIlllllllllIIIl) {
                    final ChatLine llllllllllllllIIIlIlllllllllIIII = this.drawnChatLines.get(llllllllllllllIIIlIlllllllllIIIl + this.scrollPos);
                    if (llllllllllllllIIIlIlllllllllIIII != null) {
                        final int llllllllllllllIIIlIllllllllIllll = llllllllllllllIIIlIllllllllllIIl - llllllllllllllIIIlIlllllllllIIII.getUpdatedCounter();
                        if (llllllllllllllIIIlIllllllllIllll < 200 || llllllllllllllIIIlIlllllllllIlIl) {
                            double llllllllllllllIIIlIllllllllIlllI = llllllllllllllIIIlIllllllllIllll / 200.0;
                            llllllllllllllIIIlIllllllllIlllI = 1.0 - llllllllllllllIIIlIllllllllIlllI;
                            llllllllllllllIIIlIllllllllIlllI *= 10.0;
                            llllllllllllllIIIlIllllllllIlllI = MathHelper.clamp(llllllllllllllIIIlIllllllllIlllI, 0.0, 1.0);
                            llllllllllllllIIIlIllllllllIlllI *= llllllllllllllIIIlIllllllllIlllI;
                            int llllllllllllllIIIlIllllllllIllIl = (int)(255.0 * llllllllllllllIIIlIllllllllIlllI);
                            if (llllllllllllllIIIlIlllllllllIlIl) {
                                llllllllllllllIIIlIllllllllIllIl = 255;
                            }
                            llllllllllllllIIIlIllllllllIllIl *= (int)llllllllllllllIIIlIlllllllllIllI;
                            ++llllllllllllllIIIlIlllllllllIIlI;
                            if (llllllllllllllIIIlIllllllllIllIl > 3) {
                                final int llllllllllllllIIIlIllllllllIllII = 0;
                                final int llllllllllllllIIIlIllllllllIlIll = -llllllllllllllIIIlIlllllllllIIIl * 9;
                                Gui.drawRect(-2.0, llllllllllllllIIIlIllllllllIlIll - 1 - this.offset - GuiNewChat.globalOffset / 5.0f, 0 + llllllllllllllIIIlIlllllllllIIll + 4, llllllllllllllIIIlIllllllllIlIll + 8 - this.offset - GuiNewChat.globalOffset / 5.0f, llllllllllllllIIIlIllllllllIllIl / 2 << 24);
                                final String llllllllllllllIIIlIllllllllIlIlI = llllllllllllllIIIlIlllllllllIIII.getChatComponent().getFormattedText();
                                GlStateManager.enableBlend();
                                this.mc.fontRendererObj.drawStringWithShadow(llllllllllllllIIIlIllllllllIlIlI, 0.0f, (float)(llllllllllllllIIIlIllllllllIlIll - this.offset - GuiNewChat.globalOffset / 5.0f), 16777215 + (llllllllllllllIIIlIllllllllIllIl << 24));
                                GlStateManager.disableAlpha();
                                GlStateManager.disableBlend();
                            }
                        }
                    }
                }
                if (llllllllllllllIIIlIlllllllllIlIl) {
                    final int llllllllllllllIIIlIllllllllIlIIl = this.mc.fontRendererObj.FONT_HEIGHT;
                    GlStateManager.translate(-3.0f, 0.0f, 0.0f);
                    final int llllllllllllllIIIlIllllllllIlIII = llllllllllllllIIIlIlllllllllIlll * llllllllllllllIIIlIllllllllIlIIl + llllllllllllllIIIlIlllllllllIlll;
                    final int llllllllllllllIIIlIllllllllIIlll = llllllllllllllIIIlIlllllllllIIlI * llllllllllllllIIIlIllllllllIlIIl + llllllllllllllIIIlIlllllllllIIlI;
                    final int llllllllllllllIIIlIllllllllIIllI = this.scrollPos * llllllllllllllIIIlIllllllllIIlll / llllllllllllllIIIlIlllllllllIlll;
                    final int llllllllllllllIIIlIllllllllIIlIl = llllllllllllllIIIlIllllllllIIlll * llllllllllllllIIIlIllllllllIIlll / llllllllllllllIIIlIllllllllIlIII;
                    if (llllllllllllllIIIlIllllllllIlIII != llllllllllllllIIIlIllllllllIIlll) {
                        final int llllllllllllllIIIlIllllllllIIlII = (llllllllllllllIIIlIllllllllIIllI > 0) ? 170 : 96;
                        final int llllllllllllllIIIlIllllllllIIIll = this.isScrolled ? 13382451 : 3355562;
                        Gui.drawRect(0.0, -llllllllllllllIIIlIllllllllIIllI, 2.0, -llllllllllllllIIIlIllllllllIIllI - llllllllllllllIIIlIllllllllIIlIl, llllllllllllllIIIlIllllllllIIIll + (llllllllllllllIIIlIllllllllIIlII << 24));
                        Gui.drawRect(2.0, -llllllllllllllIIIlIllllllllIIllI, 1.0, -llllllllllllllIIIlIllllllllIIllI - llllllllllllllIIIlIllllllllIIlIl, 13421772 + (llllllllllllllIIIlIllllllllIIlII << 24));
                    }
                }
                GlStateManager.popMatrix();
            }
        }
    }
    
    public int getChatWidth() {
        return calculateChatboxWidth(this.mc.gameSettings.chatWidth);
    }
    
    public int getLineCount() {
        return this.getChatHeight() / 9;
    }
    
    public void scroll(final int llllllllllllllIIIlIlllllIlllllll) {
        this.scrollPos += llllllllllllllIIIlIlllllIlllllll;
        final int llllllllllllllIIIlIllllllIIIIIIl = this.drawnChatLines.size();
        if (this.scrollPos > llllllllllllllIIIlIllllllIIIIIIl - this.getLineCount()) {
            this.scrollPos = llllllllllllllIIIlIllllllIIIIIIl - this.getLineCount();
        }
        if (this.scrollPos <= 0) {
            this.scrollPos = 0;
            this.isScrolled = false;
        }
    }
    
    public void printChatMessage(final ITextComponent llllllllllllllIIIlIlllllllIIIIll) {
        final EventChatMessage llllllllllllllIIIlIlllllllIIIlIl = new EventChatMessage(llllllllllllllIIIlIlllllllIIIIll.getUnformattedComponentText());
        llllllllllllllIIIlIlllllllIIIlIl.call();
        this.printChatMessageWithOptionalDeletion(llllllllllllllIIIlIlllllllIIIIll, 0);
    }
    
    public void printChatMessageWithOptionalDeletion(final ITextComponent llllllllllllllIIIlIllllllIllllIl, final int llllllllllllllIIIlIllllllIlllIIl) {
        this.setChatLine(llllllllllllllIIIlIllllllIllllIl, llllllllllllllIIIlIllllllIlllIIl, this.mc.ingameGUI.getUpdateCounter(), false);
        GuiNewChat.LOGGER.info("[CHAT] {}", (Object)llllllllllllllIIIlIllllllIllllIl.getUnformattedText().replaceAll("\r", "\\\\r").replaceAll("\n", "\\\\n"));
    }
    
    public void refreshChat() {
        this.drawnChatLines.clear();
        this.resetScroll();
        for (int llllllllllllllIIIlIllllllIIlIlll = this.chatLines.size() - 1; llllllllllllllIIIlIllllllIIlIlll >= 0; --llllllllllllllIIIlIllllllIIlIlll) {
            final ChatLine llllllllllllllIIIlIllllllIIlIllI = this.chatLines.get(llllllllllllllIIIlIllllllIIlIlll);
            this.setChatLine(llllllllllllllIIIlIllllllIIlIllI.getChatComponent(), llllllllllllllIIIlIllllllIIlIllI.getChatLineID(), llllllllllllllIIIlIllllllIIlIllI.getUpdatedCounter(), true);
        }
    }
    
    public boolean getChatOpen() {
        return this.mc.currentScreen instanceof GuiChat;
    }
    
    public GuiNewChat(final Minecraft llllllllllllllIIIllIIIIIIIIIllIl) {
        this.sentMessages = (List<String>)Lists.newArrayList();
        this.chatLines = (List<ChatLine>)Lists.newArrayList();
        this.drawnChatLines = (List<ChatLine>)Lists.newArrayList();
        this.mc = llllllllllllllIIIllIIIIIIIIIllIl;
    }
    
    @Nullable
    public ITextComponent getChatComponent(final int llllllllllllllIIIlIlllllIllIlllI, final int llllllllllllllIIIlIlllllIllIIIII) {
        if (!this.getChatOpen()) {
            return null;
        }
        final ScaledResolution llllllllllllllIIIlIlllllIllIllII = new ScaledResolution(this.mc);
        final int llllllllllllllIIIlIlllllIllIlIll = llllllllllllllIIIlIlllllIllIllII.getScaleFactor();
        final float llllllllllllllIIIlIlllllIllIlIlI = this.getChatScale();
        int llllllllllllllIIIlIlllllIllIlIIl = llllllllllllllIIIlIlllllIllIlllI / llllllllllllllIIIlIlllllIllIlIll - 2;
        int llllllllllllllIIIlIlllllIllIlIII = llllllllllllllIIIlIlllllIllIIIII / llllllllllllllIIIlIlllllIllIlIll - 40;
        llllllllllllllIIIlIlllllIllIlIIl = MathHelper.floor(llllllllllllllIIIlIlllllIllIlIIl / llllllllllllllIIIlIlllllIllIlIlI);
        llllllllllllllIIIlIlllllIllIlIII = MathHelper.floor(llllllllllllllIIIlIlllllIllIlIII / llllllllllllllIIIlIlllllIllIlIlI);
        if (llllllllllllllIIIlIlllllIllIlIIl < 0 || llllllllllllllIIIlIlllllIllIlIII < 0) {
            return null;
        }
        final int llllllllllllllIIIlIlllllIllIIlll = Math.min(this.getLineCount(), this.drawnChatLines.size());
        if (llllllllllllllIIIlIlllllIllIlIIl <= MathHelper.floor(this.getChatWidth() / this.getChatScale()) && llllllllllllllIIIlIlllllIllIlIII < this.mc.fontRendererObj.FONT_HEIGHT * llllllllllllllIIIlIlllllIllIIlll + llllllllllllllIIIlIlllllIllIIlll) {
            final int llllllllllllllIIIlIlllllIllIIllI = llllllllllllllIIIlIlllllIllIlIII / this.mc.fontRendererObj.FONT_HEIGHT + this.scrollPos;
            if (llllllllllllllIIIlIlllllIllIIllI >= 0 && llllllllllllllIIIlIlllllIllIIllI < this.drawnChatLines.size()) {
                final ChatLine llllllllllllllIIIlIlllllIllIIlIl = this.drawnChatLines.get(llllllllllllllIIIlIlllllIllIIllI);
                int llllllllllllllIIIlIlllllIllIIlII = 0;
                for (final ITextComponent llllllllllllllIIIlIlllllIllIIIll : llllllllllllllIIIlIlllllIllIIlIl.getChatComponent()) {
                    if (llllllllllllllIIIlIlllllIllIIIll instanceof TextComponentString) {
                        llllllllllllllIIIlIlllllIllIIlII += this.mc.fontRendererObj.getStringWidth(GuiUtilRenderComponents.removeTextColorsIfConfigured(((TextComponentString)llllllllllllllIIIlIlllllIllIIIll).getText(), false));
                        if (llllllllllllllIIIlIlllllIllIIlII > llllllllllllllIIIlIlllllIllIlIIl) {
                            return llllllllllllllIIIlIlllllIllIIIll;
                        }
                        continue;
                    }
                }
            }
            return null;
        }
        return null;
    }
    
    public static int calculateChatboxWidth(final float llllllllllllllIIIlIlllllIIlllIII) {
        final int llllllllllllllIIIlIlllllIIllIlll = 320;
        final int llllllllllllllIIIlIlllllIIllIllI = 40;
        return MathHelper.floor(llllllllllllllIIIlIlllllIIlllIII * 280.0f + 40.0f);
    }
    
    public List<String> getSentMessages() {
        return this.sentMessages;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public void resetScroll() {
        this.scrollPos = 0;
        this.isScrolled = false;
    }
    
    public void addToSentMessages(final String llllllllllllllIIIlIllllllIIIllII) {
        if (this.sentMessages.isEmpty() || !this.sentMessages.get(this.sentMessages.size() - 1).equals(llllllllllllllIIIlIllllllIIIllII)) {
            this.sentMessages.add(llllllllllllllIIIlIllllllIIIllII);
        }
    }
    
    public static int calculateChatboxHeight(final float llllllllllllllIIIlIlllllIIlIllII) {
        final int llllllllllllllIIIlIlllllIIlIlllI = 180;
        final int llllllllllllllIIIlIlllllIIlIllIl = 20;
        return MathHelper.floor(llllllllllllllIIIlIlllllIIlIllII * 160.0f + 20.0f);
    }
    
    public void deleteChatLine(final int llllllllllllllIIIlIlllllIlIIIlll) {
        Iterator<ChatLine> llllllllllllllIIIlIlllllIlIIlIll = this.drawnChatLines.iterator();
        while (llllllllllllllIIIlIlllllIlIIlIll.hasNext()) {
            final ChatLine llllllllllllllIIIlIlllllIlIIlIlI = llllllllllllllIIIlIlllllIlIIlIll.next();
            if (llllllllllllllIIIlIlllllIlIIlIlI.getChatLineID() == llllllllllllllIIIlIlllllIlIIIlll) {
                llllllllllllllIIIlIlllllIlIIlIll.remove();
            }
        }
        llllllllllllllIIIlIlllllIlIIlIll = this.chatLines.iterator();
        while (llllllllllllllIIIlIlllllIlIIlIll.hasNext()) {
            final ChatLine llllllllllllllIIIlIlllllIlIIlIIl = llllllllllllllIIIlIlllllIlIIlIll.next();
            if (llllllllllllllIIIlIlllllIlIIlIIl.getChatLineID() == llllllllllllllIIIlIlllllIlIIIlll) {
                llllllllllllllIIIlIlllllIlIIlIll.remove();
                break;
            }
        }
    }
    
    private void setChatLine(final ITextComponent llllllllllllllIIIlIllllllIlIIlII, final int llllllllllllllIIIlIllllllIlIIIll, final int llllllllllllllIIIlIllllllIlIIIlI, final boolean llllllllllllllIIIlIllllllIlIlIlI) {
        if (llllllllllllllIIIlIllllllIlIIIll != 0) {
            this.deleteChatLine(llllllllllllllIIIlIllllllIlIIIll);
        }
        final int llllllllllllllIIIlIllllllIlIlIIl = MathHelper.floor(this.getChatWidth() / this.getChatScale());
        final List<ITextComponent> llllllllllllllIIIlIllllllIlIlIII = GuiUtilRenderComponents.splitText(llllllllllllllIIIlIllllllIlIIlII, llllllllllllllIIIlIllllllIlIlIIl, this.mc.fontRendererObj, false, false);
        final boolean llllllllllllllIIIlIllllllIlIIlll = this.getChatOpen();
        for (final ITextComponent llllllllllllllIIIlIllllllIlIIllI : llllllllllllllIIIlIllllllIlIlIII) {
            if (llllllllllllllIIIlIllllllIlIIlll && this.scrollPos > 0) {
                this.isScrolled = true;
                this.scroll(1);
            }
            this.drawnChatLines.add(0, new ChatLine(llllllllllllllIIIlIllllllIlIIIlI, llllllllllllllIIIlIllllllIlIIllI, llllllllllllllIIIlIllllllIlIIIll));
        }
        while (this.drawnChatLines.size() > 100) {
            this.drawnChatLines.remove(this.drawnChatLines.size() - 1);
        }
        if (!llllllllllllllIIIlIllllllIlIlIlI) {
            this.chatLines.add(0, new ChatLine(llllllllllllllIIIlIllllllIlIIIlI, llllllllllllllIIIlIllllllIlIIlII, llllllllllllllIIIlIllllllIlIIIll));
            while (this.chatLines.size() > 100) {
                this.chatLines.remove(this.chatLines.size() - 1);
            }
        }
    }
    
    public float getChatScale() {
        return this.mc.gameSettings.chatScale;
    }
}
