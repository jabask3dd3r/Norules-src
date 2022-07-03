package net.minecraft.client.gui.achievement;

import net.minecraft.client.resources.*;
import net.minecraft.client.gui.*;
import java.io.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import com.google.common.collect.*;
import net.minecraft.stats.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.client.audio.*;
import org.lwjgl.input.*;
import java.util.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;

public class GuiStats extends GuiScreen implements IProgressMeter
{
    private /* synthetic */ StatsItem itemStats;
    private /* synthetic */ StatsMobsList mobStats;
    private /* synthetic */ GuiSlot displaySlot;
    private /* synthetic */ StatsBlock blockStats;
    protected /* synthetic */ GuiScreen parentScreen;
    protected /* synthetic */ String screenTitle;
    private /* synthetic */ StatsGeneral generalStats;
    private final /* synthetic */ StatisticsManager stats;
    private /* synthetic */ boolean doesGuiPauseGame;
    
    public void func_193029_f() {
        this.buttonList.add(new GuiButton(0, this.width / 2 + 4, this.height - 28, 150, 20, I18n.format("gui.done", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 160, this.height - 52, 80, 20, I18n.format("stat.generalButton", new Object[0])));
        final GuiButton lllllllllllllIIIIlIIIlllIlIIllll = this.addButton(new GuiButton(2, this.width / 2 - 80, this.height - 52, 80, 20, I18n.format("stat.blocksButton", new Object[0])));
        final GuiButton lllllllllllllIIIIlIIIlllIlIIlllI = this.addButton(new GuiButton(3, this.width / 2, this.height - 52, 80, 20, I18n.format("stat.itemsButton", new Object[0])));
        final GuiButton lllllllllllllIIIIlIIIlllIlIIllIl = this.addButton(new GuiButton(4, this.width / 2 + 80, this.height - 52, 80, 20, I18n.format("stat.mobsButton", new Object[0])));
        if (this.blockStats.getSize() == 0) {
            lllllllllllllIIIIlIIIlllIlIIllll.enabled = false;
        }
        if (this.itemStats.getSize() == 0) {
            lllllllllllllIIIIlIIIlllIlIIlllI.enabled = false;
        }
        if (this.mobStats.getSize() == 0) {
            lllllllllllllIIIIlIIIlllIlIIllIl.enabled = false;
        }
    }
    
    public GuiStats(final GuiScreen lllllllllllllIIIIlIIIlllIlIlllll, final StatisticsManager lllllllllllllIIIIlIIIlllIlIllllI) {
        this.screenTitle = "Select world";
        this.doesGuiPauseGame = true;
        this.parentScreen = lllllllllllllIIIIlIIIlllIlIlllll;
        this.stats = lllllllllllllIIIIlIIIlllIlIllllI;
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        if (this.displaySlot != null) {
            this.displaySlot.handleMouseInput();
        }
    }
    
    @Override
    public void func_193026_g() {
        if (this.doesGuiPauseGame) {
            this.func_193028_a();
            this.func_193029_f();
            this.displaySlot = this.generalStats;
            this.doesGuiPauseGame = false;
        }
    }
    
    @Override
    public void initGui() {
        this.screenTitle = I18n.format("gui.stats", new Object[0]);
        this.doesGuiPauseGame = true;
        this.mc.getConnection().sendPacket(new CPacketClientStatus(CPacketClientStatus.State.REQUEST_STATS));
    }
    
    private void drawStatsScreen(final int lllllllllllllIIIIlIIIlllIIlIlIll, final int lllllllllllllIIIIlIIIlllIIlIIllI, final Item lllllllllllllIIIIlIIIlllIIlIIlIl) {
        this.drawButtonBackground(lllllllllllllIIIIlIIIlllIIlIlIll + 1, lllllllllllllIIIIlIIIlllIIlIIllI + 1);
        GlStateManager.enableRescaleNormal();
        RenderHelper.enableGUIStandardItemLighting();
        this.itemRender.renderItemIntoGUI(lllllllllllllIIIIlIIIlllIIlIIlIl.func_190903_i(), lllllllllllllIIIIlIIIlllIIlIlIll + 2, lllllllllllllIIIIlIIIlllIIlIIllI + 2);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return !this.doesGuiPauseGame;
    }
    
    private void drawSprite(final int lllllllllllllIIIIlIIIlllIIIIIlII, final int lllllllllllllIIIIlIIIlllIIIIlllI, final int lllllllllllllIIIIlIIIlllIIIIllIl, final int lllllllllllllIIIIlIIIlllIIIIllII) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiStats.STAT_ICONS);
        final float lllllllllllllIIIIlIIIlllIIIIlIll = 0.0078125f;
        final float lllllllllllllIIIIlIIIlllIIIIlIlI = 0.0078125f;
        final int lllllllllllllIIIIlIIIlllIIIIlIIl = 18;
        final int lllllllllllllIIIIlIIIlllIIIIlIII = 18;
        final Tessellator lllllllllllllIIIIlIIIlllIIIIIlll = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIIIlIIIlllIIIIIllI = lllllllllllllIIIIlIIIlllIIIIIlll.getBuffer();
        lllllllllllllIIIIlIIIlllIIIIIllI.begin(7, DefaultVertexFormats.POSITION_TEX);
        lllllllllllllIIIIlIIIlllIIIIIllI.pos(lllllllllllllIIIIlIIIlllIIIIIlII + 0, lllllllllllllIIIIlIIIlllIIIIlllI + 18, this.zLevel).tex((lllllllllllllIIIIlIIIlllIIIIllIl + 0) * 0.0078125f, (lllllllllllllIIIIlIIIlllIIIIllII + 18) * 0.0078125f).endVertex();
        lllllllllllllIIIIlIIIlllIIIIIllI.pos(lllllllllllllIIIIlIIIlllIIIIIlII + 18, lllllllllllllIIIIlIIIlllIIIIlllI + 18, this.zLevel).tex((lllllllllllllIIIIlIIIlllIIIIllIl + 18) * 0.0078125f, (lllllllllllllIIIIlIIIlllIIIIllII + 18) * 0.0078125f).endVertex();
        lllllllllllllIIIIlIIIlllIIIIIllI.pos(lllllllllllllIIIIlIIIlllIIIIIlII + 18, lllllllllllllIIIIlIIIlllIIIIlllI + 0, this.zLevel).tex((lllllllllllllIIIIlIIIlllIIIIllIl + 18) * 0.0078125f, (lllllllllllllIIIIlIIIlllIIIIllII + 0) * 0.0078125f).endVertex();
        lllllllllllllIIIIlIIIlllIIIIIllI.pos(lllllllllllllIIIIlIIIlllIIIIIlII + 0, lllllllllllllIIIIlIIIlllIIIIlllI + 0, this.zLevel).tex((lllllllllllllIIIIlIIIlllIIIIllIl + 0) * 0.0078125f, (lllllllllllllIIIIlIIIlllIIIIllII + 0) * 0.0078125f).endVertex();
        lllllllllllllIIIIlIIIlllIIIIIlll.draw();
    }
    
    public void func_193028_a() {
        this.generalStats = new StatsGeneral(this.mc);
        this.generalStats.registerScrollButtons(1, 1);
        this.itemStats = new StatsItem(this.mc);
        this.itemStats.registerScrollButtons(1, 1);
        this.blockStats = new StatsBlock(this.mc);
        this.blockStats.registerScrollButtons(1, 1);
        this.mobStats = new StatsMobsList(this.mc);
        this.mobStats.registerScrollButtons(1, 1);
    }
    
    private void drawButtonBackground(final int lllllllllllllIIIIlIIIlllIIIlllIl, final int lllllllllllllIIIIlIIIlllIIIlllll) {
        this.drawSprite(lllllllllllllIIIIlIIIlllIIIlllIl, lllllllllllllIIIIlIIIlllIIIlllll, 0, 0);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIIIIlIIIlllIlIIIIll) throws IOException {
        if (lllllllllllllIIIIlIIIlllIlIIIIll.enabled) {
            if (lllllllllllllIIIIlIIIlllIlIIIIll.id == 0) {
                this.mc.displayGuiScreen(this.parentScreen);
            }
            else if (lllllllllllllIIIIlIIIlllIlIIIIll.id == 1) {
                this.displaySlot = this.generalStats;
            }
            else if (lllllllllllllIIIIlIIIlllIlIIIIll.id == 3) {
                this.displaySlot = this.itemStats;
            }
            else if (lllllllllllllIIIIlIIIlllIlIIIIll.id == 2) {
                this.displaySlot = this.blockStats;
            }
            else if (lllllllllllllIIIIlIIIlllIlIIIIll.id == 4) {
                this.displaySlot = this.mobStats;
            }
            else {
                this.displaySlot.actionPerformed(lllllllllllllIIIIlIIIlllIlIIIIll);
            }
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIIIlIIIlllIIllllIl, final int lllllllllllllIIIIlIIIlllIIllllII, final float lllllllllllllIIIIlIIIlllIIllIlll) {
        if (this.doesGuiPauseGame) {
            this.drawDefaultBackground();
            this.drawCenteredString(this.fontRendererObj, I18n.format("multiplayer.downloadingStats", new Object[0]), this.width / 2, this.height / 2, 16777215);
            this.drawCenteredString(this.fontRendererObj, GuiStats.LOADING_STRINGS[(int)(Minecraft.getSystemTime() / 150L % GuiStats.LOADING_STRINGS.length)], this.width / 2, this.height / 2 + this.fontRendererObj.FONT_HEIGHT * 2, 16777215);
        }
        else {
            this.displaySlot.drawScreen(lllllllllllllIIIIlIIIlllIIllllIl, lllllllllllllIIIIlIIIlllIIllllII, lllllllllllllIIIIlIIIlllIIllIlll);
            this.drawCenteredString(this.fontRendererObj, this.screenTitle, this.width / 2, 20, 16777215);
            super.drawScreen(lllllllllllllIIIIlIIIlllIIllllIl, lllllllllllllIIIIlIIIlllIIllllII, lllllllllllllIIIIlIIIlllIIllIlll);
        }
    }
    
    class StatsItem extends Stats
    {
        @Override
        protected void drawListHeader(final int llllllllllllllIIIIIIllllllllIIll, final int llllllllllllllIIIIIIllllllllIllI, final Tessellator llllllllllllllIIIIIIllllllllIIIl) {
            super.drawListHeader(llllllllllllllIIIIIIllllllllIIll, llllllllllllllIIIIIIllllllllIllI, llllllllllllllIIIIIIllllllllIIIl);
            if (this.headerPressed == 0) {
                GuiStats.this.drawSprite(llllllllllllllIIIIIIllllllllIIll + 115 - 18 + 1, llllllllllllllIIIIIIllllllllIllI + 1 + 1, 72, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIIIIIIllllllllIIll + 115 - 18, llllllllllllllIIIIIIllllllllIllI + 1, 72, 18);
            }
            if (this.headerPressed == 1) {
                GuiStats.this.drawSprite(llllllllllllllIIIIIIllllllllIIll + 165 - 18 + 1, llllllllllllllIIIIIIllllllllIllI + 1 + 1, 18, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIIIIIIllllllllIIll + 165 - 18, llllllllllllllIIIIIIllllllllIllI + 1, 18, 18);
            }
            if (this.headerPressed == 2) {
                GuiStats.this.drawSprite(llllllllllllllIIIIIIllllllllIIll + 215 - 18 + 1, llllllllllllllIIIIIIllllllllIllI + 1 + 1, 36, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIIIIIIllllllllIIll + 215 - 18, llllllllllllllIIIIIIllllllllIllI + 1, 36, 18);
            }
            if (this.headerPressed == 3) {
                GuiStats.this.drawSprite(llllllllllllllIIIIIIllllllllIIll + 265 - 18 + 1, llllllllllllllIIIIIIllllllllIllI + 1 + 1, 90, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIIIIIIllllllllIIll + 265 - 18, llllllllllllllIIIIIIllllllllIllI + 1, 90, 18);
            }
            if (this.headerPressed == 4) {
                GuiStats.this.drawSprite(llllllllllllllIIIIIIllllllllIIll + 315 - 18 + 1, llllllllllllllIIIIIIllllllllIllI + 1 + 1, 108, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIIIIIIllllllllIIll + 315 - 18, llllllllllllllIIIIIIllllllllIllI + 1, 108, 18);
            }
        }
        
        @Override
        protected String getHeaderDescriptionId(final int llllllllllllllIIIIIIllllllIllIII) {
            if (llllllllllllllIIIIIIllllllIllIII == 1) {
                return "stat.crafted";
            }
            if (llllllllllllllIIIIIIllllllIllIII == 2) {
                return "stat.used";
            }
            if (llllllllllllllIIIIIIllllllIllIII == 3) {
                return "stat.pickup";
            }
            return (llllllllllllllIIIIIIllllllIllIII == 4) ? "stat.dropped" : "stat.depleted";
        }
        
        public StatsItem(final Minecraft llllllllllllllIIIIIlIIIIIIIIIIIl) {
            super(llllllllllllllIIIIIlIIIIIIIIIIIl);
            this.statsHolder = (List<StatCrafting>)Lists.newArrayList();
            for (final StatCrafting llllllllllllllIIIIIlIIIIIIIIIllI : StatList.USE_ITEM_STATS) {
                boolean llllllllllllllIIIIIlIIIIIIIIIlIl = false;
                final Item llllllllllllllIIIIIlIIIIIIIIIlII = llllllllllllllIIIIIlIIIIIIIIIllI.getItem();
                if (GuiStats.this.stats.readStat(llllllllllllllIIIIIlIIIIIIIIIllI) > 0) {
                    llllllllllllllIIIIIlIIIIIIIIIlIl = true;
                }
                else if (StatList.getObjectBreakStats(llllllllllllllIIIIIlIIIIIIIIIlII) != null && GuiStats.this.stats.readStat(StatList.getObjectBreakStats(llllllllllllllIIIIIlIIIIIIIIIlII)) > 0) {
                    llllllllllllllIIIIIlIIIIIIIIIlIl = true;
                }
                else if (StatList.getCraftStats(llllllllllllllIIIIIlIIIIIIIIIlII) != null && GuiStats.this.stats.readStat(StatList.getCraftStats(llllllllllllllIIIIIlIIIIIIIIIlII)) > 0) {
                    llllllllllllllIIIIIlIIIIIIIIIlIl = true;
                }
                else if (StatList.getObjectsPickedUpStats(llllllllllllllIIIIIlIIIIIIIIIlII) != null && GuiStats.this.stats.readStat(StatList.getObjectsPickedUpStats(llllllllllllllIIIIIlIIIIIIIIIlII)) > 0) {
                    llllllllllllllIIIIIlIIIIIIIIIlIl = true;
                }
                else if (StatList.getDroppedObjectStats(llllllllllllllIIIIIlIIIIIIIIIlII) != null && GuiStats.this.stats.readStat(StatList.getDroppedObjectStats(llllllllllllllIIIIIlIIIIIIIIIlII)) > 0) {
                    llllllllllllllIIIIIlIIIIIIIIIlIl = true;
                }
                if (llllllllllllllIIIIIlIIIIIIIIIlIl) {
                    this.statsHolder.add(llllllllllllllIIIIIlIIIIIIIIIllI);
                }
            }
            this.statSorter = new Comparator<StatCrafting>() {
                @Override
                public int compare(final StatCrafting lllllllllllllIIlIIIIIIIlIIIIIIlI, final StatCrafting lllllllllllllIIlIIIIIIIIllllIllI) {
                    final Item lllllllllllllIIlIIIIIIIlIIIIIIII = lllllllllllllIIlIIIIIIIlIIIIIIlI.getItem();
                    final Item lllllllllllllIIlIIIIIIIIllllllll = lllllllllllllIIlIIIIIIIIllllIllI.getItem();
                    final int lllllllllllllIIlIIIIIIIIlllllllI = Item.getIdFromItem(lllllllllllllIIlIIIIIIIlIIIIIIII);
                    final int lllllllllllllIIlIIIIIIIIllllllIl = Item.getIdFromItem(lllllllllllllIIlIIIIIIIIllllllll);
                    StatBase lllllllllllllIIlIIIIIIIIllllllII = null;
                    StatBase lllllllllllllIIlIIIIIIIIlllllIll = null;
                    if (StatsItem.this.sortColumn == 0) {
                        lllllllllllllIIlIIIIIIIIllllllII = StatList.getObjectBreakStats(lllllllllllllIIlIIIIIIIlIIIIIIII);
                        lllllllllllllIIlIIIIIIIIlllllIll = StatList.getObjectBreakStats(lllllllllllllIIlIIIIIIIIllllllll);
                    }
                    else if (StatsItem.this.sortColumn == 1) {
                        lllllllllllllIIlIIIIIIIIllllllII = StatList.getCraftStats(lllllllllllllIIlIIIIIIIlIIIIIIII);
                        lllllllllllllIIlIIIIIIIIlllllIll = StatList.getCraftStats(lllllllllllllIIlIIIIIIIIllllllll);
                    }
                    else if (StatsItem.this.sortColumn == 2) {
                        lllllllllllllIIlIIIIIIIIllllllII = StatList.getObjectUseStats(lllllllllllllIIlIIIIIIIlIIIIIIII);
                        lllllllllllllIIlIIIIIIIIlllllIll = StatList.getObjectUseStats(lllllllllllllIIlIIIIIIIIllllllll);
                    }
                    else if (StatsItem.this.sortColumn == 3) {
                        lllllllllllllIIlIIIIIIIIllllllII = StatList.getObjectsPickedUpStats(lllllllllllllIIlIIIIIIIlIIIIIIII);
                        lllllllllllllIIlIIIIIIIIlllllIll = StatList.getObjectsPickedUpStats(lllllllllllllIIlIIIIIIIIllllllll);
                    }
                    else if (StatsItem.this.sortColumn == 4) {
                        lllllllllllllIIlIIIIIIIIllllllII = StatList.getDroppedObjectStats(lllllllllllllIIlIIIIIIIlIIIIIIII);
                        lllllllllllllIIlIIIIIIIIlllllIll = StatList.getDroppedObjectStats(lllllllllllllIIlIIIIIIIIllllllll);
                    }
                    if (lllllllllllllIIlIIIIIIIIllllllII != null || lllllllllllllIIlIIIIIIIIlllllIll != null) {
                        if (lllllllllllllIIlIIIIIIIIllllllII == null) {
                            return 1;
                        }
                        if (lllllllllllllIIlIIIIIIIIlllllIll == null) {
                            return -1;
                        }
                        final int lllllllllllllIIlIIIIIIIIlllllIlI = GuiStats.this.stats.readStat(lllllllllllllIIlIIIIIIIIllllllII);
                        final int lllllllllllllIIlIIIIIIIIlllllIIl = GuiStats.this.stats.readStat(lllllllllllllIIlIIIIIIIIlllllIll);
                        if (lllllllllllllIIlIIIIIIIIlllllIlI != lllllllllllllIIlIIIIIIIIlllllIIl) {
                            return (lllllllllllllIIlIIIIIIIIlllllIlI - lllllllllllllIIlIIIIIIIIlllllIIl) * StatsItem.this.sortOrder;
                        }
                    }
                    return lllllllllllllIIlIIIIIIIIlllllllI - lllllllllllllIIlIIIIIIIIllllllIl;
                }
            };
        }
        
        @Override
        protected void func_192637_a(final int llllllllllllllIIIIIIlllllllIlIIl, final int llllllllllllllIIIIIIlllllllIlIII, final int llllllllllllllIIIIIIllllllIlllIl, final int llllllllllllllIIIIIIlllllllIIllI, final int llllllllllllllIIIIIIlllllllIIlIl, final int llllllllllllllIIIIIIlllllllIIlII, final float llllllllllllllIIIIIIlllllllIIIll) {
            final StatCrafting llllllllllllllIIIIIIlllllllIIIlI = this.getSlotStat(llllllllllllllIIIIIIlllllllIlIIl);
            final Item llllllllllllllIIIIIIlllllllIIIIl = llllllllllllllIIIIIIlllllllIIIlI.getItem();
            GuiStats.this.drawStatsScreen(llllllllllllllIIIIIIlllllllIlIII + 40, llllllllllllllIIIIIIllllllIlllIl, llllllllllllllIIIIIIlllllllIIIIl);
            this.renderStat(StatList.getObjectBreakStats(llllllllllllllIIIIIIlllllllIIIIl), llllllllllllllIIIIIIlllllllIlIII + 115, llllllllllllllIIIIIIllllllIlllIl, llllllllllllllIIIIIIlllllllIlIIl % 2 == 0);
            this.renderStat(StatList.getCraftStats(llllllllllllllIIIIIIlllllllIIIIl), llllllllllllllIIIIIIlllllllIlIII + 165, llllllllllllllIIIIIIllllllIlllIl, llllllllllllllIIIIIIlllllllIlIIl % 2 == 0);
            this.renderStat(llllllllllllllIIIIIIlllllllIIIlI, llllllllllllllIIIIIIlllllllIlIII + 215, llllllllllllllIIIIIIllllllIlllIl, llllllllllllllIIIIIIlllllllIlIIl % 2 == 0);
            this.renderStat(StatList.getObjectsPickedUpStats(llllllllllllllIIIIIIlllllllIIIIl), llllllllllllllIIIIIIlllllllIlIII + 265, llllllllllllllIIIIIIllllllIlllIl, llllllllllllllIIIIIIlllllllIlIIl % 2 == 0);
            this.renderStat(StatList.getDroppedObjectStats(llllllllllllllIIIIIIlllllllIIIIl), llllllllllllllIIIIIIlllllllIlIII + 315, llllllllllllllIIIIIIllllllIlllIl, llllllllllllllIIIIIIlllllllIlIIl % 2 == 0);
        }
    }
    
    abstract class Stats extends GuiSlot
    {
        protected /* synthetic */ int sortOrder;
        protected /* synthetic */ Comparator<StatCrafting> statSorter;
        protected /* synthetic */ int sortColumn;
        protected /* synthetic */ int headerPressed;
        protected /* synthetic */ List<StatCrafting> statsHolder;
        
        protected void renderMouseHoverToolTip(final StatCrafting lllllllllllllIlllIIlIlIlIIllIlIl, final int lllllllllllllIlllIIlIlIlIIlIlIIl, final int lllllllllllllIlllIIlIlIlIIllIIll) {
            if (lllllllllllllIlllIIlIlIlIIllIlIl != null) {
                final Item lllllllllllllIlllIIlIlIlIIllIIlI = lllllllllllllIlllIIlIlIlIIllIlIl.getItem();
                final ItemStack lllllllllllllIlllIIlIlIlIIllIIIl = new ItemStack(lllllllllllllIlllIIlIlIlIIllIIlI);
                final String lllllllllllllIlllIIlIlIlIIllIIII = lllllllllllllIlllIIlIlIlIIllIIIl.getUnlocalizedName();
                final String lllllllllllllIlllIIlIlIlIIlIllll = String.valueOf(new StringBuilder().append(I18n.format(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIIlIlIlIIllIIII)).append(".name")), new Object[0]))).trim();
                if (!lllllllllllllIlllIIlIlIlIIlIllll.isEmpty()) {
                    final int lllllllllllllIlllIIlIlIlIIlIlllI = lllllllllllllIlllIIlIlIlIIlIlIIl + 12;
                    final int lllllllllllllIlllIIlIlIlIIlIllIl = lllllllllllllIlllIIlIlIlIIllIIll - 12;
                    final int lllllllllllllIlllIIlIlIlIIlIllII = GuiStats.this.fontRendererObj.getStringWidth(lllllllllllllIlllIIlIlIlIIlIllll);
                    GuiStats.this.drawGradientRect(lllllllllllllIlllIIlIlIlIIlIlllI - 3, lllllllllllllIlllIIlIlIlIIlIllIl - 3, lllllllllllllIlllIIlIlIlIIlIlllI + lllllllllllllIlllIIlIlIlIIlIllII + 3, lllllllllllllIlllIIlIlIlIIlIllIl + 8 + 3, -1073741824, -1073741824);
                    GuiStats.this.fontRendererObj.drawStringWithShadow(lllllllllllllIlllIIlIlIlIIlIllll, (float)lllllllllllllIlllIIlIlIlIIlIlllI, (float)lllllllllllllIlllIIlIlIlIIlIllIl, -1);
                }
            }
        }
        
        @Override
        protected boolean isSelected(final int lllllllllllllIlllIIlIlIllIIlllII) {
            return false;
        }
        
        @Override
        public int getListWidth() {
            return 375;
        }
        
        protected void renderStat(final StatBase lllllllllllllIlllIIlIlIlIllIIllI, final int lllllllllllllIlllIIlIlIlIllIllII, final int lllllllllllllIlllIIlIlIlIllIIlII, final boolean lllllllllllllIlllIIlIlIlIllIlIlI) {
            if (lllllllllllllIlllIIlIlIlIllIIllI != null) {
                final String lllllllllllllIlllIIlIlIlIllIlIIl = lllllllllllllIlllIIlIlIlIllIIllI.format(GuiStats.this.stats.readStat(lllllllllllllIlllIIlIlIlIllIIllI));
                GuiStats.this.drawString(GuiStats.this.fontRendererObj, lllllllllllllIlllIIlIlIlIllIlIIl, lllllllllllllIlllIIlIlIlIllIllII - GuiStats.this.fontRendererObj.getStringWidth(lllllllllllllIlllIIlIlIlIllIlIIl), lllllllllllllIlllIIlIlIlIllIIlII + 5, lllllllllllllIlllIIlIlIlIllIlIlI ? 16777215 : 9474192);
            }
            else {
                final String lllllllllllllIlllIIlIlIlIllIlIII = "-";
                GuiStats.this.drawString(GuiStats.this.fontRendererObj, "-", lllllllllllllIlllIIlIlIlIllIllII - GuiStats.this.fontRendererObj.getStringWidth("-"), lllllllllllllIlllIIlIlIlIllIIlII + 5, lllllllllllllIlllIIlIlIlIllIlIlI ? 16777215 : 9474192);
            }
        }
        
        @Override
        protected final int getSize() {
            return this.statsHolder.size();
        }
        
        @Override
        protected void drawBackground() {
            GuiStats.this.drawDefaultBackground();
        }
        
        protected abstract String getHeaderDescriptionId(final int p0);
        
        @Override
        protected int getScrollBarX() {
            return this.width / 2 + 140;
        }
        
        @Override
        protected void renderDecorations(final int lllllllllllllIlllIIlIlIlIlIIlIIl, final int lllllllllllllIlllIIlIlIlIlIlIllI) {
            if (lllllllllllllIlllIIlIlIlIlIlIllI >= this.top && lllllllllllllIlllIIlIlIlIlIlIllI <= this.bottom) {
                final int lllllllllllllIlllIIlIlIlIlIlIlIl = this.getSlotIndexFromScreenCoords(lllllllllllllIlllIIlIlIlIlIIlIIl, lllllllllllllIlllIIlIlIlIlIlIllI);
                final int lllllllllllllIlllIIlIlIlIlIlIlII = (this.width - this.getListWidth()) / 2;
                if (lllllllllllllIlllIIlIlIlIlIlIlIl >= 0) {
                    if (lllllllllllllIlllIIlIlIlIlIIlIIl < lllllllllllllIlllIIlIlIlIlIlIlII + 40 || lllllllllllllIlllIIlIlIlIlIIlIIl > lllllllllllllIlllIIlIlIlIlIlIlII + 40 + 20) {
                        return;
                    }
                    final StatCrafting lllllllllllllIlllIIlIlIlIlIlIIll = this.getSlotStat(lllllllllllllIlllIIlIlIlIlIlIlIl);
                    this.renderMouseHoverToolTip(lllllllllllllIlllIIlIlIlIlIlIIll, lllllllllllllIlllIIlIlIlIlIIlIIl, lllllllllllllIlllIIlIlIlIlIlIllI);
                }
                else {
                    String lllllllllllllIlllIIlIlIlIlIIlllI = null;
                    if (lllllllllllllIlllIIlIlIlIlIIlIIl >= lllllllllllllIlllIIlIlIlIlIlIlII + 115 - 18 && lllllllllllllIlllIIlIlIlIlIIlIIl <= lllllllllllllIlllIIlIlIlIlIlIlII + 115) {
                        final String lllllllllllllIlllIIlIlIlIlIlIIlI = this.getHeaderDescriptionId(0);
                    }
                    else if (lllllllllllllIlllIIlIlIlIlIIlIIl >= lllllllllllllIlllIIlIlIlIlIlIlII + 165 - 18 && lllllllllllllIlllIIlIlIlIlIIlIIl <= lllllllllllllIlllIIlIlIlIlIlIlII + 165) {
                        final String lllllllllllllIlllIIlIlIlIlIlIIIl = this.getHeaderDescriptionId(1);
                    }
                    else if (lllllllllllllIlllIIlIlIlIlIIlIIl >= lllllllllllllIlllIIlIlIlIlIlIlII + 215 - 18 && lllllllllllllIlllIIlIlIlIlIIlIIl <= lllllllllllllIlllIIlIlIlIlIlIlII + 215) {
                        final String lllllllllllllIlllIIlIlIlIlIlIIII = this.getHeaderDescriptionId(2);
                    }
                    else if (lllllllllllllIlllIIlIlIlIlIIlIIl >= lllllllllllllIlllIIlIlIlIlIlIlII + 265 - 18 && lllllllllllllIlllIIlIlIlIlIIlIIl <= lllllllllllllIlllIIlIlIlIlIlIlII + 265) {
                        final String lllllllllllllIlllIIlIlIlIlIIllll = this.getHeaderDescriptionId(3);
                    }
                    else {
                        if (lllllllllllllIlllIIlIlIlIlIIlIIl < lllllllllllllIlllIIlIlIlIlIlIlII + 315 - 18 || lllllllllllllIlllIIlIlIlIlIIlIIl > lllllllllllllIlllIIlIlIlIlIlIlII + 315) {
                            return;
                        }
                        lllllllllllllIlllIIlIlIlIlIIlllI = this.getHeaderDescriptionId(4);
                    }
                    lllllllllllllIlllIIlIlIlIlIIlllI = String.valueOf(new StringBuilder().append(I18n.format(lllllllllllllIlllIIlIlIlIlIIlllI, new Object[0]))).trim();
                    if (!lllllllllllllIlllIIlIlIlIlIIlllI.isEmpty()) {
                        final int lllllllllllllIlllIIlIlIlIlIIllIl = lllllllllllllIlllIIlIlIlIlIIlIIl + 12;
                        final int lllllllllllllIlllIIlIlIlIlIIllII = lllllllllllllIlllIIlIlIlIlIlIllI - 12;
                        final int lllllllllllllIlllIIlIlIlIlIIlIll = GuiStats.this.fontRendererObj.getStringWidth(lllllllllllllIlllIIlIlIlIlIIlllI);
                        GuiStats.this.drawGradientRect(lllllllllllllIlllIIlIlIlIlIIllIl - 3, lllllllllllllIlllIIlIlIlIlIIllII - 3, lllllllllllllIlllIIlIlIlIlIIllIl + lllllllllllllIlllIIlIlIlIlIIlIll + 3, lllllllllllllIlllIIlIlIlIlIIllII + 8 + 3, -1073741824, -1073741824);
                        GuiStats.this.fontRendererObj.drawStringWithShadow(lllllllllllllIlllIIlIlIlIlIIlllI, (float)lllllllllllllIlllIIlIlIlIlIIllIl, (float)lllllllllllllIlllIIlIlIlIlIIllII, -1);
                    }
                }
            }
        }
        
        @Override
        protected void elementClicked(final int lllllllllllllIlllIIlIlIllIlIIIIl, final boolean lllllllllllllIlllIIlIlIllIlIIIII, final int lllllllllllllIlllIIlIlIllIIlllll, final int lllllllllllllIlllIIlIlIllIIllllI) {
        }
        
        @Override
        protected void clickedHeader(final int lllllllllllllIlllIIlIlIllIIIIIIl, final int lllllllllllllIlllIIlIlIllIIIIIII) {
            this.headerPressed = -1;
            if (lllllllllllllIlllIIlIlIllIIIIIIl >= 79 && lllllllllllllIlllIIlIlIllIIIIIIl < 115) {
                this.headerPressed = 0;
            }
            else if (lllllllllllllIlllIIlIlIllIIIIIIl >= 129 && lllllllllllllIlllIIlIlIllIIIIIIl < 165) {
                this.headerPressed = 1;
            }
            else if (lllllllllllllIlllIIlIlIllIIIIIIl >= 179 && lllllllllllllIlllIIlIlIllIIIIIIl < 215) {
                this.headerPressed = 2;
            }
            else if (lllllllllllllIlllIIlIlIllIIIIIIl >= 229 && lllllllllllllIlllIIlIlIllIIIIIIl < 265) {
                this.headerPressed = 3;
            }
            else if (lllllllllllllIlllIIlIlIllIIIIIIl >= 279 && lllllllllllllIlllIIlIlIllIIIIIIl < 315) {
                this.headerPressed = 4;
            }
            if (this.headerPressed >= 0) {
                this.sortByColumn(this.headerPressed);
                this.mc.getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(SoundEvents.UI_BUTTON_CLICK, 1.0f));
            }
        }
        
        @Override
        protected void drawListHeader(final int lllllllllllllIlllIIlIlIllIIIlllI, final int lllllllllllllIlllIIlIlIllIIIllIl, final Tessellator lllllllllllllIlllIIlIlIllIIIllII) {
            if (!Mouse.isButtonDown(0)) {
                this.headerPressed = -1;
            }
            if (this.headerPressed == 0) {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlIlIllIIIlllI + 115 - 18, lllllllllllllIlllIIlIlIllIIIllIl + 1, 0, 0);
            }
            else {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlIlIllIIIlllI + 115 - 18, lllllllllllllIlllIIlIlIllIIIllIl + 1, 0, 18);
            }
            if (this.headerPressed == 1) {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlIlIllIIIlllI + 165 - 18, lllllllllllllIlllIIlIlIllIIIllIl + 1, 0, 0);
            }
            else {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlIlIllIIIlllI + 165 - 18, lllllllllllllIlllIIlIlIllIIIllIl + 1, 0, 18);
            }
            if (this.headerPressed == 2) {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlIlIllIIIlllI + 215 - 18, lllllllllllllIlllIIlIlIllIIIllIl + 1, 0, 0);
            }
            else {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlIlIllIIIlllI + 215 - 18, lllllllllllllIlllIIlIlIllIIIllIl + 1, 0, 18);
            }
            if (this.headerPressed == 3) {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlIlIllIIIlllI + 265 - 18, lllllllllllllIlllIIlIlIllIIIllIl + 1, 0, 0);
            }
            else {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlIlIllIIIlllI + 265 - 18, lllllllllllllIlllIIlIlIllIIIllIl + 1, 0, 18);
            }
            if (this.headerPressed == 4) {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlIlIllIIIlllI + 315 - 18, lllllllllllllIlllIIlIlIllIIIllIl + 1, 0, 0);
            }
            else {
                GuiStats.this.drawSprite(lllllllllllllIlllIIlIlIllIIIlllI + 315 - 18, lllllllllllllIlllIIlIlIllIIIllIl + 1, 0, 18);
            }
            if (this.sortColumn != -1) {
                int lllllllllllllIlllIIlIlIllIIIlIll = 79;
                int lllllllllllllIlllIIlIlIllIIIlIlI = 18;
                if (this.sortColumn == 1) {
                    lllllllllllllIlllIIlIlIllIIIlIll = 129;
                }
                else if (this.sortColumn == 2) {
                    lllllllllllllIlllIIlIlIllIIIlIll = 179;
                }
                else if (this.sortColumn == 3) {
                    lllllllllllllIlllIIlIlIllIIIlIll = 229;
                }
                else if (this.sortColumn == 4) {
                    lllllllllllllIlllIIlIlIllIIIlIll = 279;
                }
                if (this.sortOrder == 1) {
                    lllllllllllllIlllIIlIlIllIIIlIlI = 36;
                }
                GuiStats.this.drawSprite(lllllllllllllIlllIIlIlIllIIIlllI + lllllllllllllIlllIIlIlIllIIIlIll, lllllllllllllIlllIIlIlIllIIIllIl + 1, lllllllllllllIlllIIlIlIllIIIlIlI, 0);
            }
        }
        
        protected final StatCrafting getSlotStat(final int lllllllllllllIlllIIlIlIlIlllIlll) {
            return this.statsHolder.get(lllllllllllllIlllIIlIlIlIlllIlll);
        }
        
        protected Stats(final Minecraft lllllllllllllIlllIIlIlIllIlIIIll) {
            super(lllllllllllllIlllIIlIlIllIlIIIll, GuiStats.this.width, GuiStats.this.height, 32, GuiStats.this.height - 64, 20);
            this.headerPressed = -1;
            this.sortColumn = -1;
            this.func_193651_b(false);
            this.setHasListHeader(true, 20);
        }
        
        protected void sortByColumn(final int lllllllllllllIlllIIlIlIlIIIlllIl) {
            if (lllllllllllllIlllIIlIlIlIIIlllIl != this.sortColumn) {
                this.sortColumn = lllllllllllllIlllIIlIlIlIIIlllIl;
                this.sortOrder = -1;
            }
            else if (this.sortOrder == -1) {
                this.sortOrder = 1;
            }
            else {
                this.sortColumn = -1;
                this.sortOrder = 0;
            }
            Collections.sort(this.statsHolder, this.statSorter);
        }
    }
    
    class StatsGeneral extends GuiSlot
    {
        @Override
        protected void elementClicked(final int lllllllllllllIlllIllIIllllIlIIII, final boolean lllllllllllllIlllIllIIllllIIllll, final int lllllllllllllIlllIllIIllllIIlllI, final int lllllllllllllIlllIllIIllllIIllIl) {
        }
        
        @Override
        protected int getSize() {
            return StatList.BASIC_STATS.size();
        }
        
        @Override
        protected void func_192637_a(final int lllllllllllllIlllIllIIlllIllllIl, final int lllllllllllllIlllIllIIlllIllIIlI, final int lllllllllllllIlllIllIIlllIlllIll, final int lllllllllllllIlllIllIIlllIlllIlI, final int lllllllllllllIlllIllIIlllIlllIIl, final int lllllllllllllIlllIllIIlllIlllIII, final float lllllllllllllIlllIllIIlllIllIlll) {
            final StatBase lllllllllllllIlllIllIIlllIllIllI = StatList.BASIC_STATS.get(lllllllllllllIlllIllIIlllIllllIl);
            GuiStats.this.drawString(GuiStats.this.fontRendererObj, lllllllllllllIlllIllIIlllIllIllI.getStatName().getUnformattedText(), lllllllllllllIlllIllIIlllIllIIlI + 2, lllllllllllllIlllIllIIlllIlllIll + 1, (lllllllllllllIlllIllIIlllIllllIl % 2 == 0) ? 16777215 : 9474192);
            final String lllllllllllllIlllIllIIlllIllIlIl = lllllllllllllIlllIllIIlllIllIllI.format(GuiStats.this.stats.readStat(lllllllllllllIlllIllIIlllIllIllI));
            GuiStats.this.drawString(GuiStats.this.fontRendererObj, lllllllllllllIlllIllIIlllIllIlIl, lllllllllllllIlllIllIIlllIllIIlI + 2 + 213 - GuiStats.this.fontRendererObj.getStringWidth(lllllllllllllIlllIllIIlllIllIlIl), lllllllllllllIlllIllIIlllIlllIll + 1, (lllllllllllllIlllIllIIlllIllllIl % 2 == 0) ? 16777215 : 9474192);
        }
        
        @Override
        protected boolean isSelected(final int lllllllllllllIlllIllIIllllIIlIll) {
            return false;
        }
        
        @Override
        protected int getContentHeight() {
            return this.getSize() * 10;
        }
        
        @Override
        protected void drawBackground() {
            GuiStats.this.drawDefaultBackground();
        }
        
        public StatsGeneral(final Minecraft lllllllllllllIlllIllIIllllIlIIll) {
            super(lllllllllllllIlllIllIIllllIlIIll, GuiStats.this.width, GuiStats.this.height, 32, GuiStats.this.height - 64, 10);
            this.func_193651_b(false);
        }
    }
    
    class StatsBlock extends Stats
    {
        @Override
        protected void func_192637_a(final int llllllllllllllIIIllllIllIlIlllIl, final int llllllllllllllIIIllllIllIlIlllII, final int llllllllllllllIIIllllIllIlIllIll, final int llllllllllllllIIIllllIllIlIllIlI, final int llllllllllllllIIIllllIllIlIllIIl, final int llllllllllllllIIIllllIllIlIllIII, final float llllllllllllllIIIllllIllIlIlIlll) {
            final StatCrafting llllllllllllllIIIllllIllIlIlIllI = this.getSlotStat(llllllllllllllIIIllllIllIlIlllIl);
            final Item llllllllllllllIIIllllIllIlIlIlIl = llllllllllllllIIIllllIllIlIlIllI.getItem();
            GuiStats.this.drawStatsScreen(llllllllllllllIIIllllIllIlIlllII + 40, llllllllllllllIIIllllIllIlIllIll, llllllllllllllIIIllllIllIlIlIlIl);
            this.renderStat(StatList.getCraftStats(llllllllllllllIIIllllIllIlIlIlIl), llllllllllllllIIIllllIllIlIlllII + 115, llllllllllllllIIIllllIllIlIllIll, llllllllllllllIIIllllIllIlIlllIl % 2 == 0);
            this.renderStat(StatList.getObjectUseStats(llllllllllllllIIIllllIllIlIlIlIl), llllllllllllllIIIllllIllIlIlllII + 165, llllllllllllllIIIllllIllIlIllIll, llllllllllllllIIIllllIllIlIlllIl % 2 == 0);
            this.renderStat(llllllllllllllIIIllllIllIlIlIllI, llllllllllllllIIIllllIllIlIlllII + 215, llllllllllllllIIIllllIllIlIllIll, llllllllllllllIIIllllIllIlIlllIl % 2 == 0);
            this.renderStat(StatList.getObjectsPickedUpStats(llllllllllllllIIIllllIllIlIlIlIl), llllllllllllllIIIllllIllIlIlllII + 265, llllllllllllllIIIllllIllIlIllIll, llllllllllllllIIIllllIllIlIlllIl % 2 == 0);
            this.renderStat(StatList.getDroppedObjectStats(llllllllllllllIIIllllIllIlIlIlIl), llllllllllllllIIIllllIllIlIlllII + 315, llllllllllllllIIIllllIllIlIllIll, llllllllllllllIIIllllIllIlIlllIl % 2 == 0);
        }
        
        public StatsBlock(final Minecraft llllllllllllllIIIllllIllIlllIlIl) {
            super(llllllllllllllIIIllllIllIlllIlIl);
            this.statsHolder = (List<StatCrafting>)Lists.newArrayList();
            for (final StatCrafting llllllllllllllIIIllllIllIllllIlI : StatList.MINE_BLOCK_STATS) {
                boolean llllllllllllllIIIllllIllIllllIIl = false;
                final Item llllllllllllllIIIllllIllIllllIII = llllllllllllllIIIllllIllIllllIlI.getItem();
                if (GuiStats.this.stats.readStat(llllllllllllllIIIllllIllIllllIlI) > 0) {
                    llllllllllllllIIIllllIllIllllIIl = true;
                }
                else if (StatList.getObjectUseStats(llllllllllllllIIIllllIllIllllIII) != null && GuiStats.this.stats.readStat(StatList.getObjectUseStats(llllllllllllllIIIllllIllIllllIII)) > 0) {
                    llllllllllllllIIIllllIllIllllIIl = true;
                }
                else if (StatList.getCraftStats(llllllllllllllIIIllllIllIllllIII) != null && GuiStats.this.stats.readStat(StatList.getCraftStats(llllllllllllllIIIllllIllIllllIII)) > 0) {
                    llllllllllllllIIIllllIllIllllIIl = true;
                }
                else if (StatList.getObjectsPickedUpStats(llllllllllllllIIIllllIllIllllIII) != null && GuiStats.this.stats.readStat(StatList.getObjectsPickedUpStats(llllllllllllllIIIllllIllIllllIII)) > 0) {
                    llllllllllllllIIIllllIllIllllIIl = true;
                }
                else if (StatList.getDroppedObjectStats(llllllllllllllIIIllllIllIllllIII) != null && GuiStats.this.stats.readStat(StatList.getDroppedObjectStats(llllllllllllllIIIllllIllIllllIII)) > 0) {
                    llllllllllllllIIIllllIllIllllIIl = true;
                }
                if (llllllllllllllIIIllllIllIllllIIl) {
                    this.statsHolder.add(llllllllllllllIIIllllIllIllllIlI);
                }
            }
            this.statSorter = new Comparator<StatCrafting>() {
                @Override
                public int compare(final StatCrafting lllllllllllllIllllllIIIIIllllIIl, final StatCrafting lllllllllllllIllllllIIIIIllllIII) {
                    final Item lllllllllllllIllllllIIIIIlllIlll = lllllllllllllIllllllIIIIIllllIIl.getItem();
                    final Item lllllllllllllIllllllIIIIIlllIllI = lllllllllllllIllllllIIIIIllllIII.getItem();
                    StatBase lllllllllllllIllllllIIIIIlllIlIl = null;
                    StatBase lllllllllllllIllllllIIIIIlllIlII = null;
                    if (StatsBlock.this.sortColumn == 2) {
                        lllllllllllllIllllllIIIIIlllIlIl = StatList.getBlockStats(Block.getBlockFromItem(lllllllllllllIllllllIIIIIlllIlll));
                        lllllllllllllIllllllIIIIIlllIlII = StatList.getBlockStats(Block.getBlockFromItem(lllllllllllllIllllllIIIIIlllIllI));
                    }
                    else if (StatsBlock.this.sortColumn == 0) {
                        lllllllllllllIllllllIIIIIlllIlIl = StatList.getCraftStats(lllllllllllllIllllllIIIIIlllIlll);
                        lllllllllllllIllllllIIIIIlllIlII = StatList.getCraftStats(lllllllllllllIllllllIIIIIlllIllI);
                    }
                    else if (StatsBlock.this.sortColumn == 1) {
                        lllllllllllllIllllllIIIIIlllIlIl = StatList.getObjectUseStats(lllllllllllllIllllllIIIIIlllIlll);
                        lllllllllllllIllllllIIIIIlllIlII = StatList.getObjectUseStats(lllllllllllllIllllllIIIIIlllIllI);
                    }
                    else if (StatsBlock.this.sortColumn == 3) {
                        lllllllllllllIllllllIIIIIlllIlIl = StatList.getObjectsPickedUpStats(lllllllllllllIllllllIIIIIlllIlll);
                        lllllllllllllIllllllIIIIIlllIlII = StatList.getObjectsPickedUpStats(lllllllllllllIllllllIIIIIlllIllI);
                    }
                    else if (StatsBlock.this.sortColumn == 4) {
                        lllllllllllllIllllllIIIIIlllIlIl = StatList.getDroppedObjectStats(lllllllllllllIllllllIIIIIlllIlll);
                        lllllllllllllIllllllIIIIIlllIlII = StatList.getDroppedObjectStats(lllllllllllllIllllllIIIIIlllIllI);
                    }
                    if (lllllllllllllIllllllIIIIIlllIlIl != null || lllllllllllllIllllllIIIIIlllIlII != null) {
                        if (lllllllllllllIllllllIIIIIlllIlIl == null) {
                            return 1;
                        }
                        if (lllllllllllllIllllllIIIIIlllIlII == null) {
                            return -1;
                        }
                        final int lllllllllllllIllllllIIIIIlllIIll = GuiStats.this.stats.readStat(lllllllllllllIllllllIIIIIlllIlIl);
                        final int lllllllllllllIllllllIIIIIlllIIlI = GuiStats.this.stats.readStat(lllllllllllllIllllllIIIIIlllIlII);
                        if (lllllllllllllIllllllIIIIIlllIIll != lllllllllllllIllllllIIIIIlllIIlI) {
                            return (lllllllllllllIllllllIIIIIlllIIll - lllllllllllllIllllllIIIIIlllIIlI) * StatsBlock.this.sortOrder;
                        }
                    }
                    return Item.getIdFromItem(lllllllllllllIllllllIIIIIlllIlll) - Item.getIdFromItem(lllllllllllllIllllllIIIIIlllIllI);
                }
            };
        }
        
        @Override
        protected void drawListHeader(final int llllllllllllllIIIllllIllIllIlIll, final int llllllllllllllIIIllllIllIllIIllI, final Tessellator llllllllllllllIIIllllIllIllIlIIl) {
            super.drawListHeader(llllllllllllllIIIllllIllIllIlIll, llllllllllllllIIIllllIllIllIIllI, llllllllllllllIIIllllIllIllIlIIl);
            if (this.headerPressed == 0) {
                GuiStats.this.drawSprite(llllllllllllllIIIllllIllIllIlIll + 115 - 18 + 1, llllllllllllllIIIllllIllIllIIllI + 1 + 1, 18, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIIIllllIllIllIlIll + 115 - 18, llllllllllllllIIIllllIllIllIIllI + 1, 18, 18);
            }
            if (this.headerPressed == 1) {
                GuiStats.this.drawSprite(llllllllllllllIIIllllIllIllIlIll + 165 - 18 + 1, llllllllllllllIIIllllIllIllIIllI + 1 + 1, 36, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIIIllllIllIllIlIll + 165 - 18, llllllllllllllIIIllllIllIllIIllI + 1, 36, 18);
            }
            if (this.headerPressed == 2) {
                GuiStats.this.drawSprite(llllllllllllllIIIllllIllIllIlIll + 215 - 18 + 1, llllllllllllllIIIllllIllIllIIllI + 1 + 1, 54, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIIIllllIllIllIlIll + 215 - 18, llllllllllllllIIIllllIllIllIIllI + 1, 54, 18);
            }
            if (this.headerPressed == 3) {
                GuiStats.this.drawSprite(llllllllllllllIIIllllIllIllIlIll + 265 - 18 + 1, llllllllllllllIIIllllIllIllIIllI + 1 + 1, 90, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIIIllllIllIllIlIll + 265 - 18, llllllllllllllIIIllllIllIllIIllI + 1, 90, 18);
            }
            if (this.headerPressed == 4) {
                GuiStats.this.drawSprite(llllllllllllllIIIllllIllIllIlIll + 315 - 18 + 1, llllllllllllllIIIllllIllIllIIllI + 1 + 1, 108, 18);
            }
            else {
                GuiStats.this.drawSprite(llllllllllllllIIIllllIllIllIlIll + 315 - 18, llllllllllllllIIIllllIllIllIIllI + 1, 108, 18);
            }
        }
        
        @Override
        protected String getHeaderDescriptionId(final int llllllllllllllIIIllllIllIlIIIIll) {
            if (llllllllllllllIIIllllIllIlIIIIll == 0) {
                return "stat.crafted";
            }
            if (llllllllllllllIIIllllIllIlIIIIll == 1) {
                return "stat.used";
            }
            if (llllllllllllllIIIllllIllIlIIIIll == 3) {
                return "stat.pickup";
            }
            return (llllllllllllllIIIllllIllIlIIIIll == 4) ? "stat.dropped" : "stat.mined";
        }
    }
    
    class StatsMobsList extends GuiSlot
    {
        private final /* synthetic */ List<EntityList.EntityEggInfo> mobs;
        
        @Override
        protected void func_192637_a(final int llllllllllllllIIIlIIIIlIIIlIlIlI, final int llllllllllllllIIIlIIIIlIIIlIlIIl, final int llllllllllllllIIIlIIIIlIIIIllIlI, final int llllllllllllllIIIlIIIIlIIIlIIlll, final int llllllllllllllIIIlIIIIlIIIlIIllI, final int llllllllllllllIIIlIIIIlIIIlIIlIl, final float llllllllllllllIIIlIIIIlIIIlIIlII) {
            final EntityList.EntityEggInfo llllllllllllllIIIlIIIIlIIIlIIIll = this.mobs.get(llllllllllllllIIIlIIIIlIIIlIlIlI);
            final String llllllllllllllIIIlIIIIlIIIlIIIlI = I18n.format(String.valueOf(new StringBuilder("entity.").append(EntityList.func_191302_a(llllllllllllllIIIlIIIIlIIIlIIIll.spawnedID)).append(".name")), new Object[0]);
            final int llllllllllllllIIIlIIIIlIIIlIIIIl = GuiStats.this.stats.readStat(llllllllllllllIIIlIIIIlIIIlIIIll.killEntityStat);
            final int llllllllllllllIIIlIIIIlIIIlIIIII = GuiStats.this.stats.readStat(llllllllllllllIIIlIIIIlIIIlIIIll.entityKilledByStat);
            String llllllllllllllIIIlIIIIlIIIIlllll = I18n.format("stat.entityKills", llllllllllllllIIIlIIIIlIIIlIIIIl, llllllllllllllIIIlIIIIlIIIlIIIlI);
            String llllllllllllllIIIlIIIIlIIIIllllI = I18n.format("stat.entityKilledBy", llllllllllllllIIIlIIIIlIIIlIIIlI, llllllllllllllIIIlIIIIlIIIlIIIII);
            if (llllllllllllllIIIlIIIIlIIIlIIIIl == 0) {
                llllllllllllllIIIlIIIIlIIIIlllll = I18n.format("stat.entityKills.none", llllllllllllllIIIlIIIIlIIIlIIIlI);
            }
            if (llllllllllllllIIIlIIIIlIIIlIIIII == 0) {
                llllllllllllllIIIlIIIIlIIIIllllI = I18n.format("stat.entityKilledBy.none", llllllllllllllIIIlIIIIlIIIlIIIlI);
            }
            GuiStats.this.drawString(GuiStats.this.fontRendererObj, llllllllllllllIIIlIIIIlIIIlIIIlI, llllllllllllllIIIlIIIIlIIIlIlIIl + 2 - 10, llllllllllllllIIIlIIIIlIIIIllIlI + 1, 16777215);
            GuiStats.this.drawString(GuiStats.this.fontRendererObj, llllllllllllllIIIlIIIIlIIIIlllll, llllllllllllllIIIlIIIIlIIIlIlIIl + 2, llllllllllllllIIIlIIIIlIIIIllIlI + 1 + GuiStats.this.fontRendererObj.FONT_HEIGHT, (llllllllllllllIIIlIIIIlIIIlIIIIl == 0) ? 6316128 : 9474192);
            GuiStats.this.drawString(GuiStats.this.fontRendererObj, llllllllllllllIIIlIIIIlIIIIllllI, llllllllllllllIIIlIIIIlIIIlIlIIl + 2, llllllllllllllIIIlIIIIlIIIIllIlI + 1 + GuiStats.this.fontRendererObj.FONT_HEIGHT * 2, (llllllllllllllIIIlIIIIlIIIlIIIII == 0) ? 6316128 : 9474192);
        }
        
        @Override
        protected int getSize() {
            return this.mobs.size();
        }
        
        public StatsMobsList(final Minecraft llllllllllllllIIIlIIIIlIIlIIlIII) {
            super(llllllllllllllIIIlIIIIlIIlIIlIII, GuiStats.this.width, GuiStats.this.height, 32, GuiStats.this.height - 64, GuiStats.this.fontRendererObj.FONT_HEIGHT * 4);
            this.mobs = (List<EntityList.EntityEggInfo>)Lists.newArrayList();
            this.func_193651_b(false);
            for (final EntityList.EntityEggInfo llllllllllllllIIIlIIIIlIIlIIlIll : EntityList.ENTITY_EGGS.values()) {
                if (GuiStats.this.stats.readStat(llllllllllllllIIIlIIIIlIIlIIlIll.killEntityStat) > 0 || GuiStats.this.stats.readStat(llllllllllllllIIIlIIIIlIIlIIlIll.entityKilledByStat) > 0) {
                    this.mobs.add(llllllllllllllIIIlIIIIlIIlIIlIll);
                }
            }
        }
        
        @Override
        protected boolean isSelected(final int llllllllllllllIIIlIIIIlIIIllllII) {
            return false;
        }
        
        @Override
        protected int getContentHeight() {
            return this.getSize() * GuiStats.this.fontRendererObj.FONT_HEIGHT * 4;
        }
        
        @Override
        protected void drawBackground() {
            GuiStats.this.drawDefaultBackground();
        }
        
        @Override
        protected void elementClicked(final int llllllllllllllIIIlIIIIlIIlIIIIIl, final boolean llllllllllllllIIIlIIIIlIIlIIIIII, final int llllllllllllllIIIlIIIIlIIIllllll, final int llllllllllllllIIIlIIIIlIIIlllllI) {
        }
    }
}
