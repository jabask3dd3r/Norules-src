package net.minecraft.client.gui;

import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.text.event.*;
import java.io.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.*;
import net.minecraft.item.*;
import com.google.gson.*;
import net.minecraft.util.text.*;
import com.google.common.collect.*;
import io.netty.buffer.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.nbt.*;
import org.apache.logging.log4j.*;
import org.lwjgl.input.*;
import javax.annotation.*;
import net.minecraft.client.*;

public class GuiScreenBook extends GuiScreen
{
    private /* synthetic */ NextPageButton buttonNextPage;
    private /* synthetic */ NBTTagList bookPages;
    private /* synthetic */ String bookTitle;
    private /* synthetic */ GuiButton buttonDone;
    private static final /* synthetic */ ResourceLocation BOOK_GUI_TEXTURES;
    private /* synthetic */ int currPage;
    private /* synthetic */ GuiButton buttonCancel;
    private /* synthetic */ List<ITextComponent> cachedComponents;
    private final /* synthetic */ boolean bookIsUnsigned;
    private /* synthetic */ GuiButton buttonFinalize;
    private /* synthetic */ int bookTotalPages;
    private final /* synthetic */ ItemStack bookObj;
    private /* synthetic */ boolean bookIsModified;
    private /* synthetic */ int cachedPage;
    private /* synthetic */ boolean bookGettingSigned;
    private /* synthetic */ NextPageButton buttonPreviousPage;
    private /* synthetic */ int updateCount;
    private /* synthetic */ GuiButton buttonSign;
    private final /* synthetic */ EntityPlayer editingPlayer;
    
    @Override
    public boolean handleComponentClick(final ITextComponent lllllllllllllIlllIlllllIlllllIII) {
        final ClickEvent lllllllllllllIlllIlllllIllllIlll = lllllllllllllIlllIlllllIlllllIII.getStyle().getClickEvent();
        if (lllllllllllllIlllIlllllIllllIlll == null) {
            return false;
        }
        if (lllllllllllllIlllIlllllIllllIlll.getAction() == ClickEvent.Action.CHANGE_PAGE) {
            final String lllllllllllllIlllIlllllIllllIllI = lllllllllllllIlllIlllllIllllIlll.getValue();
            try {
                final int lllllllllllllIlllIlllllIllllIlIl = Integer.parseInt(lllllllllllllIlllIlllllIllllIllI) - 1;
                if (lllllllllllllIlllIlllllIllllIlIl >= 0 && lllllllllllllIlllIlllllIllllIlIl < this.bookTotalPages && lllllllllllllIlllIlllllIllllIlIl != this.currPage) {
                    this.currPage = lllllllllllllIlllIlllllIllllIlIl;
                    this.updateButtons();
                    return true;
                }
            }
            catch (Throwable t) {}
            return false;
        }
        final boolean lllllllllllllIlllIlllllIllllIlII = super.handleComponentClick(lllllllllllllIlllIlllllIlllllIII);
        if (lllllllllllllIlllIlllllIllllIlII && lllllllllllllIlllIlllllIllllIlll.getAction() == ClickEvent.Action.RUN_COMMAND) {
            this.mc.displayGuiScreen(null);
        }
        return lllllllllllllIlllIlllllIllllIlII;
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIlllIllllllIllllIII) throws IOException {
        if (lllllllllllllIlllIllllllIllllIII.enabled) {
            if (lllllllllllllIlllIllllllIllllIII.id == 0) {
                this.mc.displayGuiScreen(null);
                this.sendBookToServer(false);
            }
            else if (lllllllllllllIlllIllllllIllllIII.id == 3 && this.bookIsUnsigned) {
                this.bookGettingSigned = true;
            }
            else if (lllllllllllllIlllIllllllIllllIII.id == 1) {
                if (this.currPage < this.bookTotalPages - 1) {
                    ++this.currPage;
                }
                else if (this.bookIsUnsigned) {
                    this.addNewPage();
                    if (this.currPage < this.bookTotalPages - 1) {
                        ++this.currPage;
                    }
                }
            }
            else if (lllllllllllllIlllIllllllIllllIII.id == 2) {
                if (this.currPage > 0) {
                    --this.currPage;
                }
            }
            else if (lllllllllllllIlllIllllllIllllIII.id == 5 && this.bookGettingSigned) {
                this.sendBookToServer(true);
                this.mc.displayGuiScreen(null);
            }
            else if (lllllllllllllIlllIllllllIllllIII.id == 4 && this.bookGettingSigned) {
                this.bookGettingSigned = false;
            }
            this.updateButtons();
        }
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllIlllIllllllIIIIIIlI, final int lllllllllllllIlllIllllllIIIIIIIl, final int lllllllllllllIlllIllllllIIIIIIII) throws IOException {
        if (lllllllllllllIlllIllllllIIIIIIII == 0) {
            final ITextComponent lllllllllllllIlllIllllllIIIIIlII = this.getClickedComponentAt(lllllllllllllIlllIllllllIIIIIIlI, lllllllllllllIlllIllllllIIIIIIIl);
            if (lllllllllllllIlllIllllllIIIIIlII != null && this.handleComponentClick(lllllllllllllIlllIllllllIIIIIlII)) {
                return;
            }
        }
        super.mouseClicked(lllllllllllllIlllIllllllIIIIIIlI, lllllllllllllIlllIllllllIIIIIIIl, lllllllllllllIlllIllllllIIIIIIII);
    }
    
    private void keyTypedInBook(final char lllllllllllllIlllIllllllIllIIllI, final int lllllllllllllIlllIllllllIllIIIIl) {
        if (GuiScreen.isKeyComboCtrlV(lllllllllllllIlllIllllllIllIIIIl)) {
            this.pageInsertIntoCurrent(GuiScreen.getClipboardString());
        }
        else {
            switch (lllllllllllllIlllIllllllIllIIIIl) {
                case 14: {
                    final String lllllllllllllIlllIllllllIllIIlII = this.pageGetCurrent();
                    if (!lllllllllllllIlllIllllllIllIIlII.isEmpty()) {
                        this.pageSetCurrent(lllllllllllllIlllIllllllIllIIlII.substring(0, lllllllllllllIlllIllllllIllIIlII.length() - 1));
                    }
                }
                case 28:
                case 156: {
                    this.pageInsertIntoCurrent("\n");
                }
                default: {
                    if (ChatAllowedCharacters.isAllowedCharacter(lllllllllllllIlllIllllllIllIIllI)) {
                        this.pageInsertIntoCurrent(Character.toString(lllllllllllllIlllIllllllIllIIllI));
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    private void pageSetCurrent(final String lllllllllllllIlllIllllllIlIIlllI) {
        if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.tagCount()) {
            this.bookPages.set(this.currPage, new NBTTagString(lllllllllllllIlllIllllllIlIIlllI));
            this.bookIsModified = true;
        }
    }
    
    private void updateButtons() {
        this.buttonNextPage.visible = (!this.bookGettingSigned && (this.currPage < this.bookTotalPages - 1 || this.bookIsUnsigned));
        this.buttonPreviousPage.visible = (!this.bookGettingSigned && this.currPage > 0);
        this.buttonDone.visible = (!this.bookIsUnsigned || !this.bookGettingSigned);
        if (this.bookIsUnsigned) {
            this.buttonSign.visible = !this.bookGettingSigned;
            this.buttonCancel.visible = this.bookGettingSigned;
            this.buttonFinalize.visible = this.bookGettingSigned;
            this.buttonFinalize.enabled = !this.bookTitle.trim().isEmpty();
        }
    }
    
    private void pageInsertIntoCurrent(final String lllllllllllllIlllIllllllIlIIIIlI) {
        final String lllllllllllllIlllIllllllIlIIIllI = this.pageGetCurrent();
        final String lllllllllllllIlllIllllllIlIIIlIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIllllllIlIIIllI)).append(lllllllllllllIlllIllllllIlIIIIlI));
        final int lllllllllllllIlllIllllllIlIIIlII = this.fontRendererObj.splitStringWidth(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIllllllIlIIIlIl)).append(TextFormatting.BLACK).append("_")), 118);
        if (lllllllllllllIlllIllllllIlIIIlII <= 128 && lllllllllllllIlllIllllllIlIIIlIl.length() < 256) {
            this.pageSetCurrent(lllllllllllllIlllIllllllIlIIIlIl);
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIlllIllllllIIIllIIl, final int lllllllllllllIlllIllllllIIlIllll, final float lllllllllllllIlllIllllllIIIlIlll) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiScreenBook.BOOK_GUI_TEXTURES);
        final int lllllllllllllIlllIllllllIIlIllIl = (this.width - 192) / 2;
        final int lllllllllllllIlllIllllllIIlIllII = 2;
        this.drawTexturedModalRect(lllllllllllllIlllIllllllIIlIllIl, 2, 0, 0, 192, 192);
        if (this.bookGettingSigned) {
            String lllllllllllllIlllIllllllIIlIlIll = this.bookTitle;
            if (this.bookIsUnsigned) {
                if (this.updateCount / 6 % 2 == 0) {
                    lllllllllllllIlllIllllllIIlIlIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIllllllIIlIlIll)).append(TextFormatting.BLACK).append("_"));
                }
                else {
                    lllllllllllllIlllIllllllIIlIlIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIllllllIIlIlIll)).append(TextFormatting.GRAY).append("_"));
                }
            }
            final String lllllllllllllIlllIllllllIIlIlIlI = I18n.format("book.editTitle", new Object[0]);
            final int lllllllllllllIlllIllllllIIlIlIIl = this.fontRendererObj.getStringWidth(lllllllllllllIlllIllllllIIlIlIlI);
            this.fontRendererObj.drawString(lllllllllllllIlllIllllllIIlIlIlI, lllllllllllllIlllIllllllIIlIllIl + 36 + (116 - lllllllllllllIlllIllllllIIlIlIIl) / 2, 34.0, 0);
            final int lllllllllllllIlllIllllllIIlIlIII = this.fontRendererObj.getStringWidth(lllllllllllllIlllIllllllIIlIlIll);
            this.fontRendererObj.drawString(lllllllllllllIlllIllllllIIlIlIll, lllllllllllllIlllIllllllIIlIllIl + 36 + (116 - lllllllllllllIlllIllllllIIlIlIII) / 2, 50.0, 0);
            final String lllllllllllllIlllIllllllIIlIIlll = I18n.format("book.byAuthor", this.editingPlayer.getName());
            final int lllllllllllllIlllIllllllIIlIIllI = this.fontRendererObj.getStringWidth(lllllllllllllIlllIllllllIIlIIlll);
            this.fontRendererObj.drawString(String.valueOf(new StringBuilder().append(TextFormatting.DARK_GRAY).append(lllllllllllllIlllIllllllIIlIIlll)), lllllllllllllIlllIllllllIIlIllIl + 36 + (116 - lllllllllllllIlllIllllllIIlIIllI) / 2, 60.0, 0);
            final String lllllllllllllIlllIllllllIIlIIlIl = I18n.format("book.finalizeWarning", new Object[0]);
            this.fontRendererObj.drawSplitString(lllllllllllllIlllIllllllIIlIIlIl, lllllllllllllIlllIllllllIIlIllIl + 36, 82, 116, 0);
        }
        else {
            final String lllllllllllllIlllIllllllIIlIIlII = I18n.format("book.pageIndicator", this.currPage + 1, this.bookTotalPages);
            String lllllllllllllIlllIllllllIIlIIIll = "";
            if (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.tagCount()) {
                lllllllllllllIlllIllllllIIlIIIll = this.bookPages.getStringTagAt(this.currPage);
            }
            if (this.bookIsUnsigned) {
                if (this.fontRendererObj.getBidiFlag()) {
                    lllllllllllllIlllIllllllIIlIIIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIllllllIIlIIIll)).append("_"));
                }
                else if (this.updateCount / 6 % 2 == 0) {
                    lllllllllllllIlllIllllllIIlIIIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIllllllIIlIIIll)).append(TextFormatting.BLACK).append("_"));
                }
                else {
                    lllllllllllllIlllIllllllIIlIIIll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIllllllIIlIIIll)).append(TextFormatting.GRAY).append("_"));
                }
            }
            else if (this.cachedPage != this.currPage) {
                if (ItemWrittenBook.validBookTagContents(this.bookObj.getTagCompound())) {
                    try {
                        final ITextComponent lllllllllllllIlllIllllllIIlIIIlI = ITextComponent.Serializer.jsonToComponent(lllllllllllllIlllIllllllIIlIIIll);
                        this.cachedComponents = ((lllllllllllllIlllIllllllIIlIIIlI != null) ? GuiUtilRenderComponents.splitText(lllllllllllllIlllIllllllIIlIIIlI, 116, this.fontRendererObj, true, true) : null);
                    }
                    catch (JsonParseException lllllllllllllIlllIllllllIIlIIIIl) {
                        this.cachedComponents = null;
                    }
                }
                else {
                    final TextComponentString lllllllllllllIlllIllllllIIlIIIII = new TextComponentString(String.valueOf(new StringBuilder().append(TextFormatting.DARK_RED).append("* Invalid book tag *")));
                    this.cachedComponents = (List<ITextComponent>)Lists.newArrayList((Iterable)lllllllllllllIlllIllllllIIlIIIII);
                }
                this.cachedPage = this.currPage;
            }
            final int lllllllllllllIlllIllllllIIIlllll = this.fontRendererObj.getStringWidth(lllllllllllllIlllIllllllIIlIIlII);
            this.fontRendererObj.drawString(lllllllllllllIlllIllllllIIlIIlII, lllllllllllllIlllIllllllIIlIllIl - lllllllllllllIlllIllllllIIIlllll + 192 - 44, 18.0, 0);
            if (this.cachedComponents == null) {
                this.fontRendererObj.drawSplitString(lllllllllllllIlllIllllllIIlIIIll, lllllllllllllIlllIllllllIIlIllIl + 36, 34, 116, 0);
            }
            else {
                for (int lllllllllllllIlllIllllllIIIllllI = Math.min(128 / this.fontRendererObj.FONT_HEIGHT, this.cachedComponents.size()), lllllllllllllIlllIllllllIIIlllIl = 0; lllllllllllllIlllIllllllIIIlllIl < lllllllllllllIlllIllllllIIIllllI; ++lllllllllllllIlllIllllllIIIlllIl) {
                    final ITextComponent lllllllllllllIlllIllllllIIIlllII = this.cachedComponents.get(lllllllllllllIlllIllllllIIIlllIl);
                    this.fontRendererObj.drawString(lllllllllllllIlllIllllllIIIlllII.getUnformattedText(), lllllllllllllIlllIllllllIIlIllIl + 36, 34 + lllllllllllllIlllIllllllIIIlllIl * this.fontRendererObj.FONT_HEIGHT, 0);
                }
                final ITextComponent lllllllllllllIlllIllllllIIIllIll = this.getClickedComponentAt(lllllllllllllIlllIllllllIIIllIIl, lllllllllllllIlllIllllllIIlIllll);
                if (lllllllllllllIlllIllllllIIIllIll != null) {
                    this.handleComponentHover(lllllllllllllIlllIllllllIIIllIll, lllllllllllllIlllIllllllIIIllIIl, lllllllllllllIlllIllllllIIlIllll);
                }
            }
        }
        super.drawScreen(lllllllllllllIlllIllllllIIIllIIl, lllllllllllllIlllIllllllIIlIllll, lllllllllllllIlllIllllllIIIlIlll);
    }
    
    private void sendBookToServer(final boolean lllllllllllllIlllIlllllllIIlIIll) throws IOException {
        if (this.bookIsUnsigned && this.bookIsModified && this.bookPages != null) {
            while (this.bookPages.tagCount() > 1) {
                final String lllllllllllllIlllIlllllllIIlIIlI = this.bookPages.getStringTagAt(this.bookPages.tagCount() - 1);
                if (!lllllllllllllIlllIlllllllIIlIIlI.isEmpty()) {
                    break;
                }
                this.bookPages.removeTag(this.bookPages.tagCount() - 1);
            }
            if (this.bookObj.hasTagCompound()) {
                final NBTTagCompound lllllllllllllIlllIlllllllIIlIIIl = this.bookObj.getTagCompound();
                lllllllllllllIlllIlllllllIIlIIIl.setTag("pages", this.bookPages);
            }
            else {
                this.bookObj.setTagInfo("pages", this.bookPages);
            }
            String lllllllllllllIlllIlllllllIIlIIII = "MC|BEdit";
            if (lllllllllllllIlllIlllllllIIlIIll) {
                lllllllllllllIlllIlllllllIIlIIII = "MC|BSign";
                this.bookObj.setTagInfo("author", new NBTTagString(this.editingPlayer.getName()));
                this.bookObj.setTagInfo("title", new NBTTagString(this.bookTitle.trim()));
            }
            final PacketBuffer lllllllllllllIlllIlllllllIIIllll = new PacketBuffer(Unpooled.buffer());
            lllllllllllllIlllIlllllllIIIllll.writeItemStackToBuffer(this.bookObj);
            this.mc.getConnection().sendPacket(new CPacketCustomPayload(lllllllllllllIlllIlllllllIIlIIII, lllllllllllllIlllIlllllllIIIllll));
        }
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        ++this.updateCount;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        BOOK_GUI_TEXTURES = new ResourceLocation("textures/gui/book.png");
    }
    
    private String pageGetCurrent() {
        return (this.bookPages != null && this.currPage >= 0 && this.currPage < this.bookPages.tagCount()) ? this.bookPages.getStringTagAt(this.currPage) : "";
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        if (this.bookIsUnsigned) {
            this.buttonSign = this.addButton(new GuiButton(3, this.width / 2 - 100, 196, 98, 20, I18n.format("book.signButton", new Object[0])));
            this.buttonDone = this.addButton(new GuiButton(0, this.width / 2 + 2, 196, 98, 20, I18n.format("gui.done", new Object[0])));
            this.buttonFinalize = this.addButton(new GuiButton(5, this.width / 2 - 100, 196, 98, 20, I18n.format("book.finalizeButton", new Object[0])));
            this.buttonCancel = this.addButton(new GuiButton(4, this.width / 2 + 2, 196, 98, 20, I18n.format("gui.cancel", new Object[0])));
        }
        else {
            this.buttonDone = this.addButton(new GuiButton(0, this.width / 2 - 100, 196, 200, 20, I18n.format("gui.done", new Object[0])));
        }
        final int lllllllllllllIlllIlllllllIllllII = (this.width - 192) / 2;
        final int lllllllllllllIlllIlllllllIlllIll = 2;
        this.buttonNextPage = this.addButton(new NextPageButton(1, lllllllllllllIlllIlllllllIllllII + 120, 156, true));
        this.buttonPreviousPage = this.addButton(new NextPageButton(2, lllllllllllllIlllIlllllllIllllII + 38, 156, false));
        this.updateButtons();
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    private void addNewPage() {
        if (this.bookPages != null && this.bookPages.tagCount() < 50) {
            this.bookPages.appendTag(new NBTTagString(""));
            ++this.bookTotalPages;
            this.bookIsModified = true;
        }
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllIlllIllllllIlllIIII, final int lllllllllllllIlllIllllllIllIllII) throws IOException {
        super.keyTyped(lllllllllllllIlllIllllllIlllIIII, lllllllllllllIlllIllllllIllIllII);
        if (this.bookIsUnsigned) {
            if (this.bookGettingSigned) {
                this.keyTypedInTitle(lllllllllllllIlllIllllllIlllIIII, lllllllllllllIlllIllllllIllIllII);
            }
            else {
                this.keyTypedInBook(lllllllllllllIlllIllllllIlllIIII, lllllllllllllIlllIllllllIllIllII);
            }
        }
    }
    
    private void keyTypedInTitle(final char lllllllllllllIlllIllllllIlIllIll, final int lllllllllllllIlllIllllllIlIlIlll) throws IOException {
        switch (lllllllllllllIlllIllllllIlIlIlll) {
            case 14: {
                if (!this.bookTitle.isEmpty()) {
                    this.bookTitle = this.bookTitle.substring(0, this.bookTitle.length() - 1);
                    this.updateButtons();
                }
            }
            case 28:
            case 156: {
                if (!this.bookTitle.isEmpty()) {
                    this.sendBookToServer(true);
                    this.mc.displayGuiScreen(null);
                }
            }
            default: {
                if (this.bookTitle.length() < 16 && ChatAllowedCharacters.isAllowedCharacter(lllllllllllllIlllIllllllIlIllIll)) {
                    this.bookTitle = String.valueOf(new StringBuilder(String.valueOf(this.bookTitle)).append(Character.toString(lllllllllllllIlllIllllllIlIllIll)));
                    this.updateButtons();
                    this.bookIsModified = true;
                }
            }
        }
    }
    
    @Nullable
    public ITextComponent getClickedComponentAt(final int lllllllllllllIlllIlllllIlllIIIlI, final int lllllllllllllIlllIlllllIllIlIlll) {
        if (this.cachedComponents == null) {
            return null;
        }
        final int lllllllllllllIlllIlllllIlllIIIII = lllllllllllllIlllIlllllIlllIIIlI - (this.width - 192) / 2 - 36;
        final int lllllllllllllIlllIlllllIllIlllll = lllllllllllllIlllIlllllIllIlIlll - 2 - 16 - 16;
        if (lllllllllllllIlllIlllllIlllIIIII < 0 || lllllllllllllIlllIlllllIllIlllll < 0) {
            return null;
        }
        final int lllllllllllllIlllIlllllIllIllllI = Math.min(128 / this.fontRendererObj.FONT_HEIGHT, this.cachedComponents.size());
        if (lllllllllllllIlllIlllllIlllIIIII <= 116 && lllllllllllllIlllIlllllIllIlllll < this.mc.fontRendererObj.FONT_HEIGHT * lllllllllllllIlllIlllllIllIllllI + lllllllllllllIlllIlllllIllIllllI) {
            final int lllllllllllllIlllIlllllIllIlllIl = lllllllllllllIlllIlllllIllIlllll / this.mc.fontRendererObj.FONT_HEIGHT;
            if (lllllllllllllIlllIlllllIllIlllIl >= 0 && lllllllllllllIlllIlllllIllIlllIl < this.cachedComponents.size()) {
                final ITextComponent lllllllllllllIlllIlllllIllIlllII = this.cachedComponents.get(lllllllllllllIlllIlllllIllIlllIl);
                int lllllllllllllIlllIlllllIllIllIll = 0;
                for (final ITextComponent lllllllllllllIlllIlllllIllIllIlI : lllllllllllllIlllIlllllIllIlllII) {
                    if (lllllllllllllIlllIlllllIllIllIlI instanceof TextComponentString) {
                        lllllllllllllIlllIlllllIllIllIll += this.mc.fontRendererObj.getStringWidth(((TextComponentString)lllllllllllllIlllIlllllIllIllIlI).getText());
                        if (lllllllllllllIlllIlllllIllIllIll > lllllllllllllIlllIlllllIlllIIIII) {
                            return lllllllllllllIlllIlllllIllIllIlI;
                        }
                        continue;
                    }
                }
            }
            return null;
        }
        return null;
    }
    
    public GuiScreenBook(final EntityPlayer lllllllllllllIlllIllllllllIIIlll, final ItemStack lllllllllllllIlllIllllllllIIlIll, final boolean lllllllllllllIlllIllllllllIIIlIl) {
        this.bookTotalPages = 1;
        this.bookTitle = "";
        this.cachedPage = -1;
        this.editingPlayer = lllllllllllllIlllIllllllllIIIlll;
        this.bookObj = lllllllllllllIlllIllllllllIIlIll;
        this.bookIsUnsigned = lllllllllllllIlllIllllllllIIIlIl;
        if (lllllllllllllIlllIllllllllIIlIll.hasTagCompound()) {
            final NBTTagCompound lllllllllllllIlllIllllllllIIlIIl = lllllllllllllIlllIllllllllIIlIll.getTagCompound();
            this.bookPages = lllllllllllllIlllIllllllllIIlIIl.getTagList("pages", 8).copy();
            this.bookTotalPages = this.bookPages.tagCount();
            if (this.bookTotalPages < 1) {
                this.bookTotalPages = 1;
            }
        }
        if (this.bookPages == null && lllllllllllllIlllIllllllllIIIlIl) {
            this.bookPages = new NBTTagList();
            this.bookPages.appendTag(new NBTTagString(""));
            this.bookTotalPages = 1;
        }
    }
    
    static class NextPageButton extends GuiButton
    {
        private final /* synthetic */ boolean isForward;
        
        public NextPageButton(final int llllllllllllllIllIIlIlIllllIlIlI, final int llllllllllllllIllIIlIlIllllIlIIl, final int llllllllllllllIllIIlIlIllllIIIll, final boolean llllllllllllllIllIIlIlIllllIIlll) {
            super(llllllllllllllIllIIlIlIllllIlIlI, llllllllllllllIllIIlIlIllllIlIIl, llllllllllllllIllIIlIlIllllIIIll, 23, 13, "");
            this.isForward = llllllllllllllIllIIlIlIllllIIlll;
        }
        
        public void func_191745_a(final Minecraft llllllllllllllIllIIlIlIlllIllIIl, final int llllllllllllllIllIIlIlIlllIllIII, final int llllllllllllllIllIIlIlIlllIlIlll, final float llllllllllllllIllIIlIlIlllIlIllI) {
            if (this.visible) {
                final boolean llllllllllllllIllIIlIlIlllIlIlIl = llllllllllllllIllIIlIlIlllIllIII >= this.xPosition && llllllllllllllIllIIlIlIlllIlIlll >= this.yPosition && llllllllllllllIllIIlIlIlllIllIII < this.xPosition + this.width && llllllllllllllIllIIlIlIlllIlIlll < this.yPosition + this.height;
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                llllllllllllllIllIIlIlIlllIllIIl.getTextureManager().bindTexture(GuiScreenBook.BOOK_GUI_TEXTURES);
                int llllllllllllllIllIIlIlIlllIlIlII = 0;
                int llllllllllllllIllIIlIlIlllIlIIll = 192;
                if (llllllllllllllIllIIlIlIlllIlIlIl) {
                    llllllllllllllIllIIlIlIlllIlIlII += 23;
                }
                if (!this.isForward) {
                    llllllllllllllIllIIlIlIlllIlIIll += 13;
                }
                this.drawTexturedModalRect(this.xPosition, this.yPosition, llllllllllllllIllIIlIlIlllIlIlII, llllllllllllllIllIIlIlIlllIlIIll, 23, 13);
            }
        }
    }
}
