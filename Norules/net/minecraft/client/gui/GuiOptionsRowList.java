package net.minecraft.client.gui;

import java.util.*;
import net.minecraft.client.*;
import net.minecraft.client.settings.*;
import com.google.common.collect.*;

public class GuiOptionsRowList extends GuiListExtended
{
    private final /* synthetic */ List<Row> options;
    
    @Override
    public int getListWidth() {
        return 400;
    }
    
    @Override
    public Row getListEntry(final int llllllllllllllIIIllIlIIIlIlIlIlI) {
        return this.options.get(llllllllllllllIIIllIlIIIlIlIlIlI);
    }
    
    @Override
    protected int getSize() {
        return this.options.size();
    }
    
    public GuiOptionsRowList(final Minecraft llllllllllllllIIIllIlIIIllIIlIIl, final int llllllllllllllIIIllIlIIIllIIlIII, final int llllllllllllllIIIllIlIIIllIIIlll, final int llllllllllllllIIIllIlIIIllIlIIll, final int llllllllllllllIIIllIlIIIllIlIIlI, final int llllllllllllllIIIllIlIIIllIIIlII, final GameSettings.Options... llllllllllllllIIIllIlIIIllIlIIII) {
        super(llllllllllllllIIIllIlIIIllIIlIIl, llllllllllllllIIIllIlIIIllIIlIII, llllllllllllllIIIllIlIIIllIIIlll, llllllllllllllIIIllIlIIIllIlIIll, llllllllllllllIIIllIlIIIllIlIIlI, llllllllllllllIIIllIlIIIllIIIlII);
        this.options = (List<Row>)Lists.newArrayList();
        this.centerListVertically = false;
        for (int llllllllllllllIIIllIlIIIllIIllll = 0; llllllllllllllIIIllIlIIIllIIllll < llllllllllllllIIIllIlIIIllIlIIII.length; llllllllllllllIIIllIlIIIllIIllll += 2) {
            final GameSettings.Options llllllllllllllIIIllIlIIIllIIlllI = llllllllllllllIIIllIlIIIllIlIIII[llllllllllllllIIIllIlIIIllIIllll];
            final GameSettings.Options llllllllllllllIIIllIlIIIllIIllIl = (llllllllllllllIIIllIlIIIllIIllll < llllllllllllllIIIllIlIIIllIlIIII.length - 1) ? llllllllllllllIIIllIlIIIllIlIIII[llllllllllllllIIIllIlIIIllIIllll + 1] : null;
            final GuiButton llllllllllllllIIIllIlIIIllIIllII = this.createButton(llllllllllllllIIIllIlIIIllIIlIIl, llllllllllllllIIIllIlIIIllIIlIII / 2 - 155, 0, llllllllllllllIIIllIlIIIllIIlllI);
            final GuiButton llllllllllllllIIIllIlIIIllIIlIll = this.createButton(llllllllllllllIIIllIlIIIllIIlIIl, llllllllllllllIIIllIlIIIllIIlIII / 2 - 155 + 160, 0, llllllllllllllIIIllIlIIIllIIllIl);
            this.options.add(new Row(llllllllllllllIIIllIlIIIllIIllII, llllllllllllllIIIllIlIIIllIIlIll));
        }
    }
    
    private GuiButton createButton(final Minecraft llllllllllllllIIIllIlIIIlIllIlll, final int llllllllllllllIIIllIlIIIlIllIIIl, final int llllllllllllllIIIllIlIIIlIllIIII, final GameSettings.Options llllllllllllllIIIllIlIIIlIllIlII) {
        if (llllllllllllllIIIllIlIIIlIllIlII == null) {
            return null;
        }
        final int llllllllllllllIIIllIlIIIlIllIIll = llllllllllllllIIIllIlIIIlIllIlII.returnEnumOrdinal();
        return llllllllllllllIIIllIlIIIlIllIlII.getEnumFloat() ? new GuiOptionSlider(llllllllllllllIIIllIlIIIlIllIIll, llllllllllllllIIIllIlIIIlIllIIIl, llllllllllllllIIIllIlIIIlIllIIII, llllllllllllllIIIllIlIIIlIllIlII) : new GuiOptionButton(llllllllllllllIIIllIlIIIlIllIIll, llllllllllllllIIIllIlIIIlIllIIIl, llllllllllllllIIIllIlIIIlIllIIII, llllllllllllllIIIllIlIIIlIllIlII, llllllllllllllIIIllIlIIIlIllIlll.gameSettings.getKeyBinding(llllllllllllllIIIllIlIIIlIllIlII));
    }
    
    @Override
    protected int getScrollBarX() {
        return super.getScrollBarX() + 32;
    }
    
    public static class Row implements IGuiListEntry
    {
        private final /* synthetic */ Minecraft client;
        private final /* synthetic */ GuiButton buttonA;
        private final /* synthetic */ GuiButton buttonB;
        
        public Row(final GuiButton llllllllllllllllIllIIllIlllIIIII, final GuiButton llllllllllllllllIllIIllIllIlllll) {
            this.client = Minecraft.getMinecraft();
            this.buttonA = llllllllllllllllIllIIllIlllIIIII;
            this.buttonB = llllllllllllllllIllIIllIllIlllll;
        }
        
        @Override
        public boolean mousePressed(final int llllllllllllllllIllIIllIllIIlIII, final int llllllllllllllllIllIIllIllIIIlll, final int llllllllllllllllIllIIllIllIIIllI, final int llllllllllllllllIllIIllIllIIIlIl, final int llllllllllllllllIllIIllIllIIIlII, final int llllllllllllllllIllIIllIllIIIIll) {
            if (this.buttonA.mousePressed(this.client, llllllllllllllllIllIIllIllIIIlll, llllllllllllllllIllIIllIllIIIllI)) {
                if (this.buttonA instanceof GuiOptionButton) {
                    this.client.gameSettings.setOptionValue(((GuiOptionButton)this.buttonA).returnEnumOptions(), 1);
                    this.buttonA.displayString = this.client.gameSettings.getKeyBinding(GameSettings.Options.getEnumOptions(this.buttonA.id));
                }
                return true;
            }
            if (this.buttonB != null && this.buttonB.mousePressed(this.client, llllllllllllllllIllIIllIllIIIlll, llllllllllllllllIllIIllIllIIIllI)) {
                if (this.buttonB instanceof GuiOptionButton) {
                    this.client.gameSettings.setOptionValue(((GuiOptionButton)this.buttonB).returnEnumOptions(), 1);
                    this.buttonB.displayString = this.client.gameSettings.getKeyBinding(GameSettings.Options.getEnumOptions(this.buttonB.id));
                }
                return true;
            }
            return false;
        }
        
        @Override
        public void func_192633_a(final int llllllllllllllllIllIIllIlIllIIIl, final int llllllllllllllllIllIIllIlIllIIII, final int llllllllllllllllIllIIllIlIlIllll, final float llllllllllllllllIllIIllIlIlIlllI) {
        }
        
        @Override
        public void mouseReleased(final int llllllllllllllllIllIIllIlIlllIll, final int llllllllllllllllIllIIllIlIllIlII, final int llllllllllllllllIllIIllIlIllIIll, final int llllllllllllllllIllIIllIlIlllIII, final int llllllllllllllllIllIIllIlIllIlll, final int llllllllllllllllIllIIllIlIllIllI) {
            if (this.buttonA != null) {
                this.buttonA.mouseReleased(llllllllllllllllIllIIllIlIllIlII, llllllllllllllllIllIIllIlIllIIll);
            }
            if (this.buttonB != null) {
                this.buttonB.mouseReleased(llllllllllllllllIllIIllIlIllIlII, llllllllllllllllIllIIllIlIllIIll);
            }
        }
        
        @Override
        public void func_192634_a(final int llllllllllllllllIllIIllIllIllIIl, final int llllllllllllllllIllIIllIllIllIII, final int llllllllllllllllIllIIllIllIIllll, final int llllllllllllllllIllIIllIllIlIllI, final int llllllllllllllllIllIIllIllIlIlIl, final int llllllllllllllllIllIIllIllIIlllI, final int llllllllllllllllIllIIllIllIIllIl, final boolean llllllllllllllllIllIIllIllIlIIlI, final float llllllllllllllllIllIIllIllIlIIIl) {
            if (this.buttonA != null) {
                this.buttonA.yPosition = llllllllllllllllIllIIllIllIIllll;
                this.buttonA.func_191745_a(this.client, llllllllllllllllIllIIllIllIIlllI, llllllllllllllllIllIIllIllIIllIl);
            }
            if (this.buttonB != null) {
                this.buttonB.yPosition = llllllllllllllllIllIIllIllIIllll;
                this.buttonB.func_191745_a(this.client, llllllllllllllllIllIIllIllIIlllI, llllllllllllllllIllIIllIllIIllIl);
            }
        }
    }
}
