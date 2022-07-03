package net.minecraft.client.gui;

import java.util.*;
import net.minecraft.util.*;
import javax.annotation.*;
import net.minecraft.client.*;
import com.google.common.collect.*;
import com.google.common.base.*;

public class GuiPageButtonList extends GuiListExtended
{
    private /* synthetic */ Gui focusedControl;
    private /* synthetic */ int page;
    private final /* synthetic */ List<GuiTextField> editBoxes;
    private final /* synthetic */ List<GuiEntry> entries;
    private final /* synthetic */ GuiListEntry[][] pages;
    private final /* synthetic */ IntHashMap<Gui> componentMap;
    private final /* synthetic */ GuiResponder responder;
    
    public void setPage(final int lllllllllllllllIlIlIllllIIIIlIlI) {
        if (lllllllllllllllIlIlIllllIIIIlIlI != this.page) {
            final int lllllllllllllllIlIlIllllIIIIlIIl = this.page;
            this.page = lllllllllllllllIlIlIllllIIIIlIlI;
            this.populateEntries();
            this.markVisibility(lllllllllllllllIlIlIllllIIIIlIIl, lllllllllllllllIlIlIllllIIIIlIlI);
            this.amountScrolled = 0.0f;
        }
    }
    
    private void markVisibility(final int lllllllllllllllIlIlIlllIlllIIIll, final int lllllllllllllllIlIlIlllIlllIIIlI) {
        long lllllllllllllllIlIlIlllIllIllllI;
        double lllllllllllllllIlIlIlllIllIlllll = ((GuiListEntry[])(Object)(lllllllllllllllIlIlIlllIllIllllI = (long)(Object)this.pages[lllllllllllllllIlIlIlllIlllIIIll])).length;
        for (boolean lllllllllllllllIlIlIlllIlllIIIII = false; (lllllllllllllllIlIlIlllIlllIIIII ? 1 : 0) < lllllllllllllllIlIlIlllIllIlllll; ++lllllllllllllllIlIlIlllIlllIIIII) {
            final GuiListEntry lllllllllllllllIlIlIlllIlllIIllI = lllllllllllllllIlIlIlllIllIllllI[lllllllllllllllIlIlIlllIlllIIIII];
            if (lllllllllllllllIlIlIlllIlllIIllI != null) {
                this.setComponentVisibility(this.componentMap.lookup(lllllllllllllllIlIlIlllIlllIIllI.getId()), false);
            }
        }
        lllllllllllllllIlIlIlllIllIlllll = ((GuiListEntry[])(Object)(lllllllllllllllIlIlIlllIllIllllI = (long)(Object)this.pages[lllllllllllllllIlIlIlllIlllIIIlI])).length;
        for (boolean lllllllllllllllIlIlIlllIlllIIIII = 0 != 0; (lllllllllllllllIlIlIlllIlllIIIII ? 1 : 0) < lllllllllllllllIlIlIlllIllIlllll; ++lllllllllllllllIlIlIlllIlllIIIII) {
            final GuiListEntry lllllllllllllllIlIlIlllIlllIIlIl = lllllllllllllllIlIlIlllIllIllllI[lllllllllllllllIlIlIlllIlllIIIII];
            if (lllllllllllllllIlIlIlllIlllIIlIl != null) {
                this.setComponentVisibility(this.componentMap.lookup(lllllllllllllllIlIlIlllIlllIIlIl.getId()), true);
            }
        }
    }
    
    public int getSize() {
        return this.entries.size();
    }
    
    public void setActive(final boolean lllllllllllllllIlIlIlllIllIIIIlI) {
        for (final GuiEntry lllllllllllllllIlIlIlllIllIIIlII : this.entries) {
            if (lllllllllllllllIlIlIlllIllIIIlII.component1 instanceof GuiButton) {
                ((GuiButton)lllllllllllllllIlIlIlllIllIIIlII.component1).enabled = lllllllllllllllIlIlIlllIllIIIIlI;
            }
            if (lllllllllllllllIlIlIlllIllIIIlII.component2 instanceof GuiButton) {
                ((GuiButton)lllllllllllllllIlIlIlllIllIIIlII.component2).enabled = lllllllllllllllIlIlIlllIllIIIIlI;
            }
        }
    }
    
    public void onKeyPressed(final char lllllllllllllllIlIlIlllIIlIlllII, final int lllllllllllllllIlIlIlllIIlIllIll) {
        if (this.focusedControl instanceof GuiTextField) {
            GuiTextField lllllllllllllllIlIlIlllIIlIllIlI = (GuiTextField)this.focusedControl;
            if (!GuiScreen.isKeyComboCtrlV(lllllllllllllllIlIlIlllIIlIllIll)) {
                if (lllllllllllllllIlIlIlllIIlIllIll == 15) {
                    lllllllllllllllIlIlIlllIIlIllIlI.setFocused(false);
                    int lllllllllllllllIlIlIlllIIlIllIIl = this.editBoxes.indexOf(this.focusedControl);
                    if (GuiScreen.isShiftKeyDown()) {
                        if (lllllllllllllllIlIlIlllIIlIllIIl == 0) {
                            lllllllllllllllIlIlIlllIIlIllIIl = this.editBoxes.size() - 1;
                        }
                        else {
                            --lllllllllllllllIlIlIlllIIlIllIIl;
                        }
                    }
                    else if (lllllllllllllllIlIlIlllIIlIllIIl == this.editBoxes.size() - 1) {
                        lllllllllllllllIlIlIlllIIlIllIIl = 0;
                    }
                    else {
                        ++lllllllllllllllIlIlIlllIIlIllIIl;
                    }
                    this.focusedControl = this.editBoxes.get(lllllllllllllllIlIlIlllIIlIllIIl);
                    lllllllllllllllIlIlIlllIIlIllIlI = (GuiTextField)this.focusedControl;
                    lllllllllllllllIlIlIlllIIlIllIlI.setFocused(true);
                    final int lllllllllllllllIlIlIlllIIlIllIII = lllllllllllllllIlIlIlllIIlIllIlI.yPosition + this.slotHeight;
                    final int lllllllllllllllIlIlIlllIIlIlIlll = lllllllllllllllIlIlIlllIIlIllIlI.yPosition;
                    if (lllllllllllllllIlIlIlllIIlIllIII > this.bottom) {
                        this.amountScrolled += lllllllllllllllIlIlIlllIIlIllIII - this.bottom;
                    }
                    else if (lllllllllllllllIlIlIlllIIlIlIlll < this.top) {
                        this.amountScrolled = (float)lllllllllllllllIlIlIlllIIlIlIlll;
                    }
                }
                else {
                    lllllllllllllllIlIlIlllIIlIllIlI.textboxKeyTyped(lllllllllllllllIlIlIlllIIlIlllII, lllllllllllllllIlIlIlllIIlIllIll);
                }
            }
            else {
                final String lllllllllllllllIlIlIlllIIlIlIllI = GuiScreen.getClipboardString();
                final String[] lllllllllllllllIlIlIlllIIlIlIlIl = lllllllllllllllIlIlIlllIIlIlIllI.split(";");
                int lllllllllllllllIlIlIlllIIlIlIIll;
                final int lllllllllllllllIlIlIlllIIlIlIlII = lllllllllllllllIlIlIlllIIlIlIIll = this.editBoxes.indexOf(this.focusedControl);
                final Exception lllllllllllllllIlIlIlllIIlIIIlIl;
                final long lllllllllllllllIlIlIlllIIlIIIllI = ((String[])(Object)(lllllllllllllllIlIlIlllIIlIIIlIl = (Exception)(Object)lllllllllllllllIlIlIlllIIlIlIlIl)).length;
                for (byte lllllllllllllllIlIlIlllIIlIIIlll = 0; lllllllllllllllIlIlIlllIIlIIIlll < lllllllllllllllIlIlIlllIIlIIIllI; ++lllllllllllllllIlIlIlllIIlIIIlll) {
                    final String lllllllllllllllIlIlIlllIIlIlIIlI = lllllllllllllllIlIlIlllIIlIIIlIl[lllllllllllllllIlIlIlllIIlIIIlll];
                    final GuiTextField lllllllllllllllIlIlIlllIIlIlIIIl = this.editBoxes.get(lllllllllllllllIlIlIlllIIlIlIIll);
                    lllllllllllllllIlIlIlllIIlIlIIIl.setText(lllllllllllllllIlIlIlllIIlIlIIlI);
                    lllllllllllllllIlIlIlllIIlIlIIIl.func_190516_a(lllllllllllllllIlIlIlllIIlIlIIIl.getId(), lllllllllllllllIlIlIlllIIlIlIIlI);
                    if (lllllllllllllllIlIlIlllIIlIlIIll == this.editBoxes.size() - 1) {
                        lllllllllllllllIlIlIlllIIlIlIIll = 0;
                    }
                    else {
                        ++lllllllllllllllIlIlIlllIIlIlIIll;
                    }
                    if (lllllllllllllllIlIlIlllIIlIlIIll == lllllllllllllllIlIlIlllIIlIlIlII) {
                        break;
                    }
                }
            }
        }
    }
    
    @Override
    public GuiEntry getListEntry(final int lllllllllllllllIlIlIlllIIlIIIIII) {
        return this.entries.get(lllllllllllllllIlIlIlllIIlIIIIII);
    }
    
    public int getPage() {
        return this.page;
    }
    
    private void setComponentVisibility(final Gui lllllllllllllllIlIlIlllIllIllIII, final boolean lllllllllllllllIlIlIlllIllIllIIl) {
        if (lllllllllllllllIlIlIlllIllIllIII instanceof GuiButton) {
            ((GuiButton)lllllllllllllllIlIlIlllIllIllIII).visible = lllllllllllllllIlIlIlllIllIllIIl;
        }
        else if (lllllllllllllllIlIlIlllIllIllIII instanceof GuiTextField) {
            ((GuiTextField)lllllllllllllllIlIlIlllIllIllIII).setVisible(lllllllllllllllIlIlIlllIllIllIIl);
        }
        else if (lllllllllllllllIlIlIlllIllIllIII instanceof GuiLabel) {
            ((GuiLabel)lllllllllllllllIlIlIlllIllIllIII).visible = lllllllllllllllIlIlIlllIllIllIIl;
        }
    }
    
    public Gui getComponent(final int lllllllllllllllIlIlIlllIllllIIll) {
        return this.componentMap.lookup(lllllllllllllllIlIlIlllIllllIIll);
    }
    
    private GuiListButton createButton(final int lllllllllllllllIlIlIlllIlIIlIlIl, final int lllllllllllllllIlIlIlllIlIIlIlII, final GuiButtonEntry lllllllllllllllIlIlIlllIlIIIlllI) {
        final GuiListButton lllllllllllllllIlIlIlllIlIIlIIlI = new GuiListButton(this.responder, lllllllllllllllIlIlIlllIlIIIlllI.getId(), lllllllllllllllIlIlIlllIlIIlIlIl, lllllllllllllllIlIlIlllIlIIlIlII, lllllllllllllllIlIlIlllIlIIIlllI.getCaption(), lllllllllllllllIlIlIlllIlIIIlllI.getInitialValue());
        lllllllllllllllIlIlIlllIlIIlIIlI.visible = lllllllllllllllIlIlIlllIlIIIlllI.shouldStartVisible();
        return lllllllllllllllIlIlIlllIlIIlIIlI;
    }
    
    private void populateEntries() {
        this.entries.clear();
        for (int lllllllllllllllIlIlIllllIIIllIll = 0; lllllllllllllllIlIlIllllIIIllIll < this.pages[this.page].length; lllllllllllllllIlIlIllllIIIllIll += 2) {
            final GuiListEntry lllllllllllllllIlIlIllllIIIllIlI = this.pages[this.page][lllllllllllllllIlIlIllllIIIllIll];
            final GuiListEntry lllllllllllllllIlIlIllllIIIllIIl = (lllllllllllllllIlIlIllllIIIllIll < this.pages[this.page].length - 1) ? this.pages[this.page][lllllllllllllllIlIlIllllIIIllIll + 1] : null;
            final Gui lllllllllllllllIlIlIllllIIIllIII = this.componentMap.lookup(lllllllllllllllIlIlIllllIIIllIlI.getId());
            final Gui lllllllllllllllIlIlIllllIIIlIlll = (lllllllllllllllIlIlIllllIIIllIIl != null) ? this.componentMap.lookup(lllllllllllllllIlIlIllllIIIllIIl.getId()) : null;
            final GuiEntry lllllllllllllllIlIlIllllIIIlIllI = new GuiEntry(lllllllllllllllIlIlIllllIIIllIII, lllllllllllllllIlIlIllllIIIlIlll);
            this.entries.add(lllllllllllllllIlIlIllllIIIlIllI);
        }
    }
    
    private GuiTextField createTextField(final int lllllllllllllllIlIlIlllIlIIIIllI, final int lllllllllllllllIlIlIlllIlIIIIlIl, final EditBoxEntry lllllllllllllllIlIlIlllIIlllllll) {
        final GuiTextField lllllllllllllllIlIlIlllIlIIIIIll = new GuiTextField(lllllllllllllllIlIlIlllIIlllllll.getId(), this.mc.fontRendererObj, lllllllllllllllIlIlIlllIlIIIIllI, lllllllllllllllIlIlIlllIlIIIIlIl, 150, 20);
        lllllllllllllllIlIlIlllIlIIIIIll.setText(lllllllllllllllIlIlIlllIIlllllll.getCaption());
        lllllllllllllllIlIlIlllIlIIIIIll.setGuiResponder(this.responder);
        lllllllllllllllIlIlIlllIlIIIIIll.setVisible(lllllllllllllllIlIlIlllIIlllllll.shouldStartVisible());
        lllllllllllllllIlIlIlllIlIIIIIll.setValidator(lllllllllllllllIlIlIlllIIlllllll.getFilter());
        return lllllllllllllllIlIlIlllIlIIIIIll;
    }
    
    public void previousPage() {
        if (this.page > 0) {
            this.setPage(this.page - 1);
        }
    }
    
    public Gui getFocusedControl() {
        return this.focusedControl;
    }
    
    private void populateComponents() {
        final boolean lllllllllllllllIlIlIllllIIlIlIlI;
        final double lllllllllllllllIlIlIllllIIlIlIll = ((GuiListEntry[][])(Object)(lllllllllllllllIlIlIllllIIlIlIlI = (boolean)(Object)this.pages)).length;
        for (Exception lllllllllllllllIlIlIllllIIlIllII = (Exception)0; lllllllllllllllIlIlIllllIIlIllII < lllllllllllllllIlIlIllllIIlIlIll; ++lllllllllllllllIlIlIllllIIlIllII) {
            final GuiListEntry[] lllllllllllllllIlIlIllllIIllIlIl = lllllllllllllllIlIlIllllIIlIlIlI[lllllllllllllllIlIlIllllIIlIllII];
            for (int lllllllllllllllIlIlIllllIIllIlII = 0; lllllllllllllllIlIlIllllIIllIlII < lllllllllllllllIlIlIllllIIllIlIl.length; lllllllllllllllIlIlIllllIIllIlII += 2) {
                final GuiListEntry lllllllllllllllIlIlIllllIIllIIll = lllllllllllllllIlIlIllllIIllIlIl[lllllllllllllllIlIlIllllIIllIlII];
                final GuiListEntry lllllllllllllllIlIlIllllIIllIIlI = (lllllllllllllllIlIlIllllIIllIlII < lllllllllllllllIlIlIllllIIllIlIl.length - 1) ? lllllllllllllllIlIlIllllIIllIlIl[lllllllllllllllIlIlIllllIIllIlII + 1] : null;
                final Gui lllllllllllllllIlIlIllllIIllIIIl = this.createEntry(lllllllllllllllIlIlIllllIIllIIll, 0, lllllllllllllllIlIlIllllIIllIIlI == null);
                final Gui lllllllllllllllIlIlIllllIIllIIII = this.createEntry(lllllllllllllllIlIlIllllIIllIIlI, 160, lllllllllllllllIlIlIllllIIllIIll == null);
                final GuiEntry lllllllllllllllIlIlIllllIIlIllll = new GuiEntry(lllllllllllllllIlIlIllllIIllIIIl, lllllllllllllllIlIlIllllIIllIIII);
                this.entries.add(lllllllllllllllIlIlIllllIIlIllll);
                if (lllllllllllllllIlIlIllllIIllIIll != null && lllllllllllllllIlIlIllllIIllIIIl != null) {
                    this.componentMap.addKey(lllllllllllllllIlIlIllllIIllIIll.getId(), lllllllllllllllIlIlIllllIIllIIIl);
                    if (lllllllllllllllIlIlIllllIIllIIIl instanceof GuiTextField) {
                        this.editBoxes.add((GuiTextField)lllllllllllllllIlIlIllllIIllIIIl);
                    }
                }
                if (lllllllllllllllIlIlIllllIIllIIlI != null && lllllllllllllllIlIlIllllIIllIIII != null) {
                    this.componentMap.addKey(lllllllllllllllIlIlIllllIIllIIlI.getId(), lllllllllllllllIlIlIllllIIllIIII);
                    if (lllllllllllllllIlIlIllllIIllIIII instanceof GuiTextField) {
                        this.editBoxes.add((GuiTextField)lllllllllllllllIlIlIllllIIllIIII);
                    }
                }
            }
        }
    }
    
    @Nullable
    private Gui createEntry(@Nullable final GuiListEntry lllllllllllllllIlIlIlllIllIlIIIl, final int lllllllllllllllIlIlIlllIllIIllII, final boolean lllllllllllllllIlIlIlllIllIIllll) {
        if (lllllllllllllllIlIlIlllIllIlIIIl instanceof GuiSlideEntry) {
            return this.createSlider(this.width / 2 - 155 + lllllllllllllllIlIlIlllIllIIllII, 0, (GuiSlideEntry)lllllllllllllllIlIlIlllIllIlIIIl);
        }
        if (lllllllllllllllIlIlIlllIllIlIIIl instanceof GuiButtonEntry) {
            return this.createButton(this.width / 2 - 155 + lllllllllllllllIlIlIlllIllIIllII, 0, (GuiButtonEntry)lllllllllllllllIlIlIlllIllIlIIIl);
        }
        if (lllllllllllllllIlIlIlllIllIlIIIl instanceof EditBoxEntry) {
            return this.createTextField(this.width / 2 - 155 + lllllllllllllllIlIlIlllIllIIllII, 0, (EditBoxEntry)lllllllllllllllIlIlIlllIllIlIIIl);
        }
        return (lllllllllllllllIlIlIlllIllIlIIIl instanceof GuiLabelEntry) ? this.createLabel(this.width / 2 - 155 + lllllllllllllllIlIlIlllIllIIllII, 0, (GuiLabelEntry)lllllllllllllllIlIlIlllIllIlIIIl, lllllllllllllllIlIlIlllIllIIllll) : null;
    }
    
    @Override
    protected int getScrollBarX() {
        return super.getScrollBarX() + 32;
    }
    
    private GuiSlider createSlider(final int lllllllllllllllIlIlIlllIlIlIIlII, final int lllllllllllllllIlIlIlllIlIIllllI, final GuiSlideEntry lllllllllllllllIlIlIlllIlIlIIIlI) {
        final GuiSlider lllllllllllllllIlIlIlllIlIlIIIIl = new GuiSlider(this.responder, lllllllllllllllIlIlIlllIlIlIIIlI.getId(), lllllllllllllllIlIlIlllIlIlIIlII, lllllllllllllllIlIlIlllIlIIllllI, lllllllllllllllIlIlIlllIlIlIIIlI.getCaption(), lllllllllllllllIlIlIlllIlIlIIIlI.getMinValue(), lllllllllllllllIlIlIlllIlIlIIIlI.getMaxValue(), lllllllllllllllIlIlIlllIlIlIIIlI.getInitalValue(), lllllllllllllllIlIlIlllIlIlIIIlI.getFormatter());
        lllllllllllllllIlIlIlllIlIlIIIIl.visible = lllllllllllllllIlIlIlllIlIlIIIlI.shouldStartVisible();
        return lllllllllllllllIlIlIlllIlIlIIIIl;
    }
    
    @Override
    public int getListWidth() {
        return 400;
    }
    
    public void nextPage() {
        if (this.page < this.pages.length - 1) {
            this.setPage(this.page + 1);
        }
    }
    
    @Override
    public boolean mouseClicked(final int lllllllllllllllIlIlIlllIlIllIIII, final int lllllllllllllllIlIlIlllIlIllIllI, final int lllllllllllllllIlIlIlllIlIlIlllI) {
        final boolean lllllllllllllllIlIlIlllIlIllIlII = super.mouseClicked(lllllllllllllllIlIlIlllIlIllIIII, lllllllllllllllIlIlIlllIlIllIllI, lllllllllllllllIlIlIlllIlIlIlllI);
        final int lllllllllllllllIlIlIlllIlIllIIll = this.getSlotIndexFromScreenCoords(lllllllllllllllIlIlIlllIlIllIIII, lllllllllllllllIlIlIlllIlIllIllI);
        if (lllllllllllllllIlIlIlllIlIllIIll >= 0) {
            final GuiEntry lllllllllllllllIlIlIlllIlIllIIlI = this.getListEntry(lllllllllllllllIlIlIlllIlIllIIll);
            if (this.focusedControl != lllllllllllllllIlIlIlllIlIllIIlI.focusedControl && this.focusedControl != null && this.focusedControl instanceof GuiTextField) {
                ((GuiTextField)this.focusedControl).setFocused(false);
            }
            this.focusedControl = lllllllllllllllIlIlIlllIlIllIIlI.focusedControl;
        }
        return lllllllllllllllIlIlIlllIlIllIlII;
    }
    
    private GuiLabel createLabel(final int lllllllllllllllIlIlIlllIIlllIllI, final int lllllllllllllllIlIlIlllIIlllIlIl, final GuiLabelEntry lllllllllllllllIlIlIlllIIllIllIl, final boolean lllllllllllllllIlIlIlllIIlllIIll) {
        GuiLabel lllllllllllllllIlIlIlllIIlllIIIl = null;
        if (lllllllllllllllIlIlIlllIIlllIIll) {
            final GuiLabel lllllllllllllllIlIlIlllIIlllIIlI = new GuiLabel(this.mc.fontRendererObj, lllllllllllllllIlIlIlllIIllIllIl.getId(), lllllllllllllllIlIlIlllIIlllIllI, lllllllllllllllIlIlIlllIIlllIlIl, this.width - lllllllllllllllIlIlIlllIIlllIllI * 2, 20, -1);
        }
        else {
            lllllllllllllllIlIlIlllIIlllIIIl = new GuiLabel(this.mc.fontRendererObj, lllllllllllllllIlIlIlllIIllIllIl.getId(), lllllllllllllllIlIlIlllIIlllIllI, lllllllllllllllIlIlIlllIIlllIlIl, 150, 20, -1);
        }
        lllllllllllllllIlIlIlllIIlllIIIl.visible = lllllllllllllllIlIlIlllIIllIllIl.shouldStartVisible();
        lllllllllllllllIlIlIlllIIlllIIIl.addLine(lllllllllllllllIlIlIlllIIllIllIl.getCaption());
        lllllllllllllllIlIlIlllIIlllIIIl.setCentered();
        return lllllllllllllllIlIlIlllIIlllIIIl;
    }
    
    public int getPageCount() {
        return this.pages.length;
    }
    
    public GuiPageButtonList(final Minecraft lllllllllllllllIlIlIllllIlIIlIIl, final int lllllllllllllllIlIlIllllIlIlIIIl, final int lllllllllllllllIlIlIllllIlIlIIII, final int lllllllllllllllIlIlIllllIlIIllll, final int lllllllllllllllIlIlIllllIlIIIlIl, final int lllllllllllllllIlIlIllllIlIIllIl, final GuiResponder lllllllllllllllIlIlIllllIlIIIIll, final GuiListEntry[]... lllllllllllllllIlIlIllllIlIIlIll) {
        super(lllllllllllllllIlIlIllllIlIIlIIl, lllllllllllllllIlIlIllllIlIlIIIl, lllllllllllllllIlIlIllllIlIlIIII, lllllllllllllllIlIlIllllIlIIllll, lllllllllllllllIlIlIllllIlIIIlIl, lllllllllllllllIlIlIllllIlIIllIl);
        this.entries = (List<GuiEntry>)Lists.newArrayList();
        this.componentMap = new IntHashMap<Gui>();
        this.editBoxes = (List<GuiTextField>)Lists.newArrayList();
        this.responder = lllllllllllllllIlIlIllllIlIIIIll;
        this.pages = lllllllllllllllIlIlIllllIlIIlIll;
        this.centerListVertically = false;
        this.populateComponents();
        this.populateEntries();
    }
    
    public interface GuiResponder
    {
        void setEntryValue(final int p0, final float p1);
        
        void setEntryValue(final int p0, final String p1);
        
        void setEntryValue(final int p0, final boolean p1);
    }
    
    public static class EditBoxEntry extends GuiListEntry
    {
        private final /* synthetic */ Predicate<String> filter;
        
        public Predicate<String> getFilter() {
            return this.filter;
        }
        
        public EditBoxEntry(final int llllllllllllIllllllIIllIIIIllIlI, final String llllllllllllIllllllIIllIIIIllllI, final boolean llllllllllllIllllllIIllIIIIlllIl, final Predicate<String> llllllllllllIllllllIIllIIIIlllII) {
            super(llllllllllllIllllllIIllIIIIllIlI, llllllllllllIllllllIIllIIIIllllI, llllllllllllIllllllIIllIIIIlllIl);
            this.filter = (Predicate<String>)MoreObjects.firstNonNull((Object)llllllllllllIllllllIIllIIIIlllII, (Object)Predicates.alwaysTrue());
        }
    }
    
    public static class GuiListEntry
    {
        private final /* synthetic */ int id;
        private final /* synthetic */ boolean startVisible;
        private final /* synthetic */ String caption;
        
        public boolean shouldStartVisible() {
            return this.startVisible;
        }
        
        public GuiListEntry(final int lllllllllllllIIIIIlIllIIlllllIll, final String lllllllllllllIIIIIlIllIIllllIllI, final boolean lllllllllllllIIIIIlIllIIllllIlIl) {
            this.id = lllllllllllllIIIIIlIllIIlllllIll;
            this.caption = lllllllllllllIIIIIlIllIIllllIllI;
            this.startVisible = lllllllllllllIIIIIlIllIIllllIlIl;
        }
        
        public int getId() {
            return this.id;
        }
        
        public String getCaption() {
            return this.caption;
        }
    }
    
    public static class GuiSlideEntry extends GuiListEntry
    {
        private final /* synthetic */ float initialValue;
        private final /* synthetic */ GuiSlider.FormatHelper formatter;
        private final /* synthetic */ float minValue;
        private final /* synthetic */ float maxValue;
        
        public GuiSlider.FormatHelper getFormatter() {
            return this.formatter;
        }
        
        public float getInitalValue() {
            return this.initialValue;
        }
        
        public float getMaxValue() {
            return this.maxValue;
        }
        
        public GuiSlideEntry(final int lllllllllllllllIIllIlIlllIlllIll, final String lllllllllllllllIIllIlIlllIllIIlI, final boolean lllllllllllllllIIllIlIlllIlllIIl, final GuiSlider.FormatHelper lllllllllllllllIIllIlIlllIllIIII, final float lllllllllllllllIIllIlIlllIlIllll, final float lllllllllllllllIIllIlIlllIllIllI, final float lllllllllllllllIIllIlIlllIlIllIl) {
            super(lllllllllllllllIIllIlIlllIlllIll, lllllllllllllllIIllIlIlllIllIIlI, lllllllllllllllIIllIlIlllIlllIIl);
            this.formatter = lllllllllllllllIIllIlIlllIllIIII;
            this.minValue = lllllllllllllllIIllIlIlllIlIllll;
            this.maxValue = lllllllllllllllIIllIlIlllIllIllI;
            this.initialValue = lllllllllllllllIIllIlIlllIlIllIl;
        }
        
        public float getMinValue() {
            return this.minValue;
        }
    }
    
    public static class GuiButtonEntry extends GuiListEntry
    {
        private final /* synthetic */ boolean initialValue;
        
        public GuiButtonEntry(final int lllllllllllllIIIllIllIllIIIlIlII, final String lllllllllllllIIIllIllIllIIIlIIll, final boolean lllllllllllllIIIllIllIllIIIlIIlI, final boolean lllllllllllllIIIllIllIllIIIlIllI) {
            super(lllllllllllllIIIllIllIllIIIlIlII, lllllllllllllIIIllIllIllIIIlIIll, lllllllllllllIIIllIllIllIIIlIIlI);
            this.initialValue = lllllllllllllIIIllIllIllIIIlIllI;
        }
        
        public boolean getInitialValue() {
            return this.initialValue;
        }
    }
    
    public static class GuiLabelEntry extends GuiListEntry
    {
        public GuiLabelEntry(final int llllllllllllllllIllllIIlllIllIlI, final String llllllllllllllllIllllIIlllIlIlIl, final boolean llllllllllllllllIllllIIlllIllIII) {
            super(llllllllllllllllIllllIIlllIllIlI, llllllllllllllllIllllIIlllIlIlIl, llllllllllllllllIllllIIlllIllIII);
        }
    }
    
    public static class GuiEntry implements IGuiListEntry
    {
        private final /* synthetic */ Minecraft client;
        private final /* synthetic */ Gui component1;
        private /* synthetic */ Gui focusedControl;
        private final /* synthetic */ Gui component2;
        
        private boolean clickButton(final GuiButton lllllllllllllIIlIIlIlIllllIlIIll, final int lllllllllllllIIlIIlIlIllllIllIII, final int lllllllllllllIIlIIlIlIllllIlIIIl, final int lllllllllllllIIlIIlIlIllllIlIllI) {
            final boolean lllllllllllllIIlIIlIlIllllIlIlIl = lllllllllllllIIlIIlIlIllllIlIIll.mousePressed(this.client, lllllllllllllIIlIIlIlIllllIllIII, lllllllllllllIIlIIlIlIllllIlIIIl);
            if (lllllllllllllIIlIIlIlIllllIlIlIl) {
                this.focusedControl = lllllllllllllIIlIIlIlIllllIlIIll;
            }
            return lllllllllllllIIlIIlIlIllllIlIlIl;
        }
        
        public Gui getComponent1() {
            return this.component1;
        }
        
        private void renderLabel(final GuiLabel lllllllllllllIIlIIlIllIIIIIllIIl, final int lllllllllllllIIlIIlIllIIIIIlIIlI, final int lllllllllllllIIlIIlIllIIIIIlIIIl, final int lllllllllllllIIlIIlIllIIIIIlIIII, final boolean lllllllllllllIIlIIlIllIIIIIIllll) {
            lllllllllllllIIlIIlIllIIIIIllIIl.y = lllllllllllllIIlIIlIllIIIIIlIIlI;
            if (!lllllllllllllIIlIIlIllIIIIIIllll) {
                lllllllllllllIIlIIlIllIIIIIllIIl.drawLabel(this.client, lllllllllllllIIlIIlIllIIIIIlIIIl, lllllllllllllIIlIIlIllIIIIIlIIII);
            }
        }
        
        private void func_192636_a(final Gui lllllllllllllIIlIIlIllIIIlIIIIll, final int lllllllllllllIIlIIlIllIIIlIIIIlI, final int lllllllllllllIIlIIlIllIIIlIIIIIl, final int lllllllllllllIIlIIlIllIIIlIIIIII, final boolean lllllllllllllIIlIIlIllIIIlIIIllI, final float lllllllllllllIIlIIlIllIIIIlllllI) {
            if (lllllllllllllIIlIIlIllIIIlIIIIll != null) {
                if (lllllllllllllIIlIIlIllIIIlIIIIll instanceof GuiButton) {
                    this.func_192635_a((GuiButton)lllllllllllllIIlIIlIllIIIlIIIIll, lllllllllllllIIlIIlIllIIIlIIIIlI, lllllllllllllIIlIIlIllIIIlIIIIIl, lllllllllllllIIlIIlIllIIIlIIIIII, lllllllllllllIIlIIlIllIIIlIIIllI, lllllllllllllIIlIIlIllIIIIlllllI);
                }
                else if (lllllllllllllIIlIIlIllIIIlIIIIll instanceof GuiTextField) {
                    this.renderTextField((GuiTextField)lllllllllllllIIlIIlIllIIIlIIIIll, lllllllllllllIIlIIlIllIIIlIIIIlI, lllllllllllllIIlIIlIllIIIlIIIllI);
                }
                else if (lllllllllllllIIlIIlIllIIIlIIIIll instanceof GuiLabel) {
                    this.renderLabel((GuiLabel)lllllllllllllIIlIIlIllIIIlIIIIll, lllllllllllllIIlIIlIllIIIlIIIIlI, lllllllllllllIIlIIlIllIIIlIIIIIl, lllllllllllllIIlIIlIllIIIlIIIIII, lllllllllllllIIlIIlIllIIIlIIIllI);
                }
            }
        }
        
        @Override
        public boolean mousePressed(final int lllllllllllllIIlIIlIlIllllllllII, final int lllllllllllllIIlIIlIlIllllllIIll, final int lllllllllllllIIlIIlIlIlllllllIlI, final int lllllllllllllIIlIIlIlIlllllllIIl, final int lllllllllllllIIlIIlIlIlllllllIII, final int lllllllllllllIIlIIlIlIllllllIlll) {
            final boolean lllllllllllllIIlIIlIlIllllllIllI = this.clickComponent(this.component1, lllllllllllllIIlIIlIlIllllllIIll, lllllllllllllIIlIIlIlIlllllllIlI, lllllllllllllIIlIIlIlIlllllllIIl);
            final boolean lllllllllllllIIlIIlIlIllllllIlIl = this.clickComponent(this.component2, lllllllllllllIIlIIlIlIllllllIIll, lllllllllllllIIlIIlIlIlllllllIlI, lllllllllllllIIlIIlIlIlllllllIIl);
            return lllllllllllllIIlIIlIlIllllllIllI || lllllllllllllIIlIIlIlIllllllIlIl;
        }
        
        @Override
        public void mouseReleased(final int lllllllllllllIIlIIlIlIlllIlllIll, final int lllllllllllllIIlIIlIlIlllIllIlII, final int lllllllllllllIIlIIlIlIlllIlllIIl, final int lllllllllllllIIlIIlIlIlllIlllIII, final int lllllllllllllIIlIIlIlIlllIllIlll, final int lllllllllllllIIlIIlIlIlllIllIllI) {
            this.releaseComponent(this.component1, lllllllllllllIIlIIlIlIlllIllIlII, lllllllllllllIIlIIlIlIlllIlllIIl, lllllllllllllIIlIIlIlIlllIlllIII);
            this.releaseComponent(this.component2, lllllllllllllIIlIIlIlIlllIllIlII, lllllllllllllIIlIIlIlIlllIlllIIl, lllllllllllllIIlIIlIlIlllIlllIII);
        }
        
        @Override
        public void func_192633_a(final int lllllllllllllIIlIIlIllIIIIIIlIlI, final int lllllllllllllIIlIIlIllIIIIIIlIIl, final int lllllllllllllIIlIIlIllIIIIIIIlIl, final float lllllllllllllIIlIIlIllIIIIIIIlll) {
            this.func_192636_a(this.component1, lllllllllllllIIlIIlIllIIIIIIIlIl, 0, 0, true, lllllllllllllIIlIIlIllIIIIIIIlll);
            this.func_192636_a(this.component2, lllllllllllllIIlIIlIllIIIIIIIlIl, 0, 0, true, lllllllllllllIIlIIlIllIIIIIIIlll);
        }
        
        private boolean clickComponent(final Gui lllllllllllllIIlIIlIlIlllllIlIII, final int lllllllllllllIIlIIlIlIlllllIIIlI, final int lllllllllllllIIlIIlIlIlllllIIIIl, final int lllllllllllllIIlIIlIlIlllllIIIII) {
            if (lllllllllllllIIlIIlIlIlllllIlIII == null) {
                return false;
            }
            if (lllllllllllllIIlIIlIlIlllllIlIII instanceof GuiButton) {
                return this.clickButton((GuiButton)lllllllllllllIIlIIlIlIlllllIlIII, lllllllllllllIIlIIlIlIlllllIIIlI, lllllllllllllIIlIIlIlIlllllIIIIl, lllllllllllllIIlIIlIlIlllllIIIII);
            }
            if (lllllllllllllIIlIIlIlIlllllIlIII instanceof GuiTextField) {
                this.clickTextField((GuiTextField)lllllllllllllIIlIIlIlIlllllIlIII, lllllllllllllIIlIIlIlIlllllIIIlI, lllllllllllllIIlIIlIlIlllllIIIIl, lllllllllllllIIlIIlIlIlllllIIIII);
            }
            return false;
        }
        
        @Override
        public void func_192634_a(final int lllllllllllllIIlIIlIllIIIllIIIII, final int lllllllllllllIIlIIlIllIIIlIlllll, final int lllllllllllllIIlIIlIllIIIlIllllI, final int lllllllllllllIIlIIlIllIIIlIlllIl, final int lllllllllllllIIlIIlIllIIIlIlllII, final int lllllllllllllIIlIIlIllIIIlIllIll, final int lllllllllllllIIlIIlIllIIIlIllIlI, final boolean lllllllllllllIIlIIlIllIIIlIllIIl, final float lllllllllllllIIlIIlIllIIIlIllIII) {
            this.func_192636_a(this.component1, lllllllllllllIIlIIlIllIIIlIllllI, lllllllllllllIIlIIlIllIIIlIllIll, lllllllllllllIIlIIlIllIIIlIllIlI, false, lllllllllllllIIlIIlIllIIIlIllIII);
            this.func_192636_a(this.component2, lllllllllllllIIlIIlIllIIIlIllllI, lllllllllllllIIlIIlIllIIIlIllIll, lllllllllllllIIlIIlIllIIIlIllIlI, false, lllllllllllllIIlIIlIllIIIlIllIII);
        }
        
        private void func_192635_a(final GuiButton lllllllllllllIIlIIlIllIIIIllIllI, final int lllllllllllllIIlIIlIllIIIIlIlllI, final int lllllllllllllIIlIIlIllIIIIlIllIl, final int lllllllllllllIIlIIlIllIIIIlIllII, final boolean lllllllllllllIIlIIlIllIIIIllIIlI, final float lllllllllllllIIlIIlIllIIIIllIIIl) {
            lllllllllllllIIlIIlIllIIIIllIllI.yPosition = lllllllllllllIIlIIlIllIIIIlIlllI;
            if (!lllllllllllllIIlIIlIllIIIIllIIlI) {
                lllllllllllllIIlIIlIllIIIIllIllI.func_191745_a(this.client, lllllllllllllIIlIIlIllIIIIlIllIl, lllllllllllllIIlIIlIllIIIIlIllII);
            }
        }
        
        private void releaseComponent(final Gui lllllllllllllIIlIIlIlIlllIlIIllI, final int lllllllllllllIIlIIlIlIlllIlIlIlI, final int lllllllllllllIIlIIlIlIlllIlIIlII, final int lllllllllllllIIlIIlIlIlllIlIIIll) {
            if (lllllllllllllIIlIIlIlIlllIlIIllI != null && lllllllllllllIIlIIlIlIlllIlIIllI instanceof GuiButton) {
                this.releaseButton((GuiButton)lllllllllllllIIlIIlIlIlllIlIIllI, lllllllllllllIIlIIlIlIlllIlIlIlI, lllllllllllllIIlIIlIlIlllIlIIlII, lllllllllllllIIlIIlIlIlllIlIIIll);
            }
        }
        
        private void clickTextField(final GuiTextField lllllllllllllIIlIIlIlIllllIIlIIl, final int lllllllllllllIIlIIlIlIllllIIIIll, final int lllllllllllllIIlIIlIlIllllIIIlll, final int lllllllllllllIIlIIlIlIllllIIIllI) {
            lllllllllllllIIlIIlIlIllllIIlIIl.mouseClicked(lllllllllllllIIlIIlIlIllllIIIIll, lllllllllllllIIlIIlIlIllllIIIlll, lllllllllllllIIlIIlIlIllllIIIllI);
            if (lllllllllllllIIlIIlIlIllllIIlIIl.isFocused()) {
                this.focusedControl = lllllllllllllIIlIIlIlIllllIIlIIl;
            }
        }
        
        private void releaseButton(final GuiButton lllllllllllllIIlIIlIlIlllIIllIlI, final int lllllllllllllIIlIIlIlIlllIIlllIl, final int lllllllllllllIIlIIlIlIlllIIlllII, final int lllllllllllllIIlIIlIlIlllIIllIll) {
            lllllllllllllIIlIIlIlIlllIIllIlI.mouseReleased(lllllllllllllIIlIIlIlIlllIIlllIl, lllllllllllllIIlIIlIlIlllIIlllII);
        }
        
        private void renderTextField(final GuiTextField lllllllllllllIIlIIlIllIIIIlIIllI, final int lllllllllllllIIlIIlIllIIIIlIIIlI, final boolean lllllllllllllIIlIIlIllIIIIlIIIIl) {
            lllllllllllllIIlIIlIllIIIIlIIllI.yPosition = lllllllllllllIIlIIlIllIIIIlIIIlI;
            if (!lllllllllllllIIlIIlIllIIIIlIIIIl) {
                lllllllllllllIIlIIlIllIIIIlIIllI.drawTextBox();
            }
        }
        
        public GuiEntry(@Nullable final Gui lllllllllllllIIlIIlIllIIIllIlllI, @Nullable final Gui lllllllllllllIIlIIlIllIIIlllIIII) {
            this.client = Minecraft.getMinecraft();
            this.component1 = lllllllllllllIIlIIlIllIIIllIlllI;
            this.component2 = lllllllllllllIIlIIlIllIIIlllIIII;
        }
        
        public Gui getComponent2() {
            return this.component2;
        }
    }
}
