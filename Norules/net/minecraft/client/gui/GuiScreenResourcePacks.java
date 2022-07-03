package net.minecraft.client.gui;

import com.google.common.collect.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.renderer.*;
import java.util.*;
import java.io.*;

public class GuiScreenResourcePacks extends GuiScreen
{
    private /* synthetic */ GuiResourcePackSelected selectedResourcePacksList;
    private /* synthetic */ List<ResourcePackListEntry> selectedResourcePacks;
    private final /* synthetic */ GuiScreen parentScreen;
    private /* synthetic */ List<ResourcePackListEntry> availableResourcePacks;
    private /* synthetic */ boolean changed;
    private /* synthetic */ GuiResourcePackAvailable availableResourcePacksList;
    
    public List<ResourcePackListEntry> getSelectedResourcePacks() {
        return this.selectedResourcePacks;
    }
    
    public GuiScreenResourcePacks(final GuiScreen lllllllllllllllllIIIIllllIlllIlI) {
        this.parentScreen = lllllllllllllllllIIIIllllIlllIlI;
    }
    
    @Override
    public void initGui() {
        this.buttonList.add(new GuiOptionButton(2, this.width / 2 - 154, this.height - 48, I18n.format("resourcePack.openFolder", new Object[0])));
        this.buttonList.add(new GuiOptionButton(1, this.width / 2 + 4, this.height - 48, I18n.format("gui.done", new Object[0])));
        if (!this.changed) {
            this.availableResourcePacks = (List<ResourcePackListEntry>)Lists.newArrayList();
            this.selectedResourcePacks = (List<ResourcePackListEntry>)Lists.newArrayList();
            final ResourcePackRepository lllllllllllllllllIIIIllllIllIIII = this.mc.getResourcePackRepository();
            lllllllllllllllllIIIIllllIllIIII.updateRepositoryEntriesAll();
            final List<ResourcePackRepository.Entry> lllllllllllllllllIIIIllllIlIllll = (List<ResourcePackRepository.Entry>)Lists.newArrayList((Iterable)lllllllllllllllllIIIIllllIllIIII.getRepositoryEntriesAll());
            lllllllllllllllllIIIIllllIlIllll.removeAll(lllllllllllllllllIIIIllllIllIIII.getRepositoryEntries());
            for (final ResourcePackRepository.Entry lllllllllllllllllIIIIllllIlIlllI : lllllllllllllllllIIIIllllIlIllll) {
                this.availableResourcePacks.add(new ResourcePackListEntryFound(this, lllllllllllllllllIIIIllllIlIlllI));
            }
            final ResourcePackRepository.Entry lllllllllllllllllIIIIllllIlIllIl = lllllllllllllllllIIIIllllIllIIII.getResourcePackEntry();
            if (lllllllllllllllllIIIIllllIlIllIl != null) {
                this.selectedResourcePacks.add(new ResourcePackListEntryServer(this, lllllllllllllllllIIIIllllIllIIII.getResourcePackInstance()));
            }
            for (final ResourcePackRepository.Entry lllllllllllllllllIIIIllllIlIllII : Lists.reverse((List)lllllllllllllllllIIIIllllIllIIII.getRepositoryEntries())) {
                this.selectedResourcePacks.add(new ResourcePackListEntryFound(this, lllllllllllllllllIIIIllllIlIllII));
            }
            this.selectedResourcePacks.add(new ResourcePackListEntryDefault(this));
        }
        this.availableResourcePacksList = new GuiResourcePackAvailable(this.mc, 200, this.height, this.availableResourcePacks);
        this.availableResourcePacksList.setSlotXBoundsFromLeft(this.width / 2 - 4 - 200);
        this.availableResourcePacksList.registerScrollButtons(7, 8);
        this.selectedResourcePacksList = new GuiResourcePackSelected(this.mc, 200, this.height, this.selectedResourcePacks);
        this.selectedResourcePacksList.setSlotXBoundsFromLeft(this.width / 2 + 4);
        this.selectedResourcePacksList.registerScrollButtons(7, 8);
    }
    
    public List<ResourcePackListEntry> getListContaining(final ResourcePackListEntry lllllllllllllllllIIIIllllIIllIIl) {
        return this.hasResourcePackEntry(lllllllllllllllllIIIIllllIIllIIl) ? this.selectedResourcePacks : this.availableResourcePacks;
    }
    
    @Override
    protected void mouseReleased(final int lllllllllllllllllIIIIlllIllIllll, final int lllllllllllllllllIIIIlllIllIlIlI, final int lllllllllllllllllIIIIlllIllIllIl) {
        super.mouseReleased(lllllllllllllllllIIIIlllIllIllll, lllllllllllllllllIIIIlllIllIlIlI, lllllllllllllllllIIIIlllIllIllIl);
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllllllIIIIlllIlllIlll, final int lllllllllllllllllIIIIlllIlllIllI, final int lllllllllllllllllIIIIlllIllllIIl) throws IOException {
        super.mouseClicked(lllllllllllllllllIIIIlllIlllIlll, lllllllllllllllllIIIIlllIlllIllI, lllllllllllllllllIIIIlllIllllIIl);
        this.availableResourcePacksList.mouseClicked(lllllllllllllllllIIIIlllIlllIlll, lllllllllllllllllIIIIlllIlllIllI, lllllllllllllllllIIIIlllIllllIIl);
        this.selectedResourcePacksList.mouseClicked(lllllllllllllllllIIIIlllIlllIlll, lllllllllllllllllIIIIlllIlllIllI, lllllllllllllllllIIIIlllIllllIIl);
    }
    
    public List<ResourcePackListEntry> getAvailableResourcePacks() {
        return this.availableResourcePacks;
    }
    
    public boolean hasResourcePackEntry(final ResourcePackListEntry lllllllllllllllllIIIIllllIIlllIl) {
        return this.selectedResourcePacks.contains(lllllllllllllllllIIIIllllIIlllIl);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllllIIIIllllIIIlIlI) throws IOException {
        if (lllllllllllllllllIIIIllllIIIlIlI.enabled) {
            if (lllllllllllllllllIIIIllllIIIlIlI.id == 2) {
                final File lllllllllllllllllIIIIllllIIIlIIl = this.mc.getResourcePackRepository().getDirResourcepacks();
                OpenGlHelper.openFile(lllllllllllllllllIIIIllllIIIlIIl);
            }
            else if (lllllllllllllllllIIIIllllIIIlIlI.id == 1) {
                if (this.changed) {
                    final List<ResourcePackRepository.Entry> lllllllllllllllllIIIIllllIIIlIII = (List<ResourcePackRepository.Entry>)Lists.newArrayList();
                    for (final ResourcePackListEntry lllllllllllllllllIIIIllllIIIIlll : this.selectedResourcePacks) {
                        if (lllllllllllllllllIIIIllllIIIIlll instanceof ResourcePackListEntryFound) {
                            lllllllllllllllllIIIIllllIIIlIII.add(((ResourcePackListEntryFound)lllllllllllllllllIIIIllllIIIIlll).getResourcePackEntry());
                        }
                    }
                    Collections.reverse(lllllllllllllllllIIIIllllIIIlIII);
                    this.mc.getResourcePackRepository().setRepositories(lllllllllllllllllIIIIllllIIIlIII);
                    this.mc.gameSettings.resourcePacks.clear();
                    this.mc.gameSettings.incompatibleResourcePacks.clear();
                    for (final ResourcePackRepository.Entry lllllllllllllllllIIIIllllIIIIllI : lllllllllllllllllIIIIllllIIIlIII) {
                        this.mc.gameSettings.resourcePacks.add(lllllllllllllllllIIIIllllIIIIllI.getResourcePackName());
                        if (lllllllllllllllllIIIIllllIIIIllI.getPackFormat() != 3) {
                            this.mc.gameSettings.incompatibleResourcePacks.add(lllllllllllllllllIIIIllllIIIIllI.getResourcePackName());
                        }
                    }
                    this.mc.gameSettings.saveOptions();
                    this.mc.refreshResources();
                }
                this.mc.displayGuiScreen(this.parentScreen);
            }
        }
    }
    
    public void markChanged() {
        this.changed = true;
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.selectedResourcePacksList.handleMouseInput();
        this.availableResourcePacksList.handleMouseInput();
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllllIIIIlllIlIlllll, final int lllllllllllllllllIIIIlllIlIllllI, final float lllllllllllllllllIIIIlllIllIIIIl) {
        this.drawBackground(0);
        this.availableResourcePacksList.drawScreen(lllllllllllllllllIIIIlllIlIlllll, lllllllllllllllllIIIIlllIlIllllI, lllllllllllllllllIIIIlllIllIIIIl);
        this.selectedResourcePacksList.drawScreen(lllllllllllllllllIIIIlllIlIlllll, lllllllllllllllllIIIIlllIlIllllI, lllllllllllllllllIIIIlllIllIIIIl);
        this.drawCenteredString(this.fontRendererObj, I18n.format("resourcePack.title", new Object[0]), this.width / 2, 16, 16777215);
        this.drawCenteredString(this.fontRendererObj, I18n.format("resourcePack.folderInfo", new Object[0]), this.width / 2 - 77, this.height - 26, 8421504);
        super.drawScreen(lllllllllllllllllIIIIlllIlIlllll, lllllllllllllllllIIIIlllIlIllllI, lllllllllllllllllIIIIlllIllIIIIl);
    }
}
