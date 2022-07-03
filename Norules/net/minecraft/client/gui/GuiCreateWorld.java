package net.minecraft.client.gui;

import net.minecraft.client.resources.*;
import java.io.*;
import net.minecraft.util.*;
import org.apache.commons.lang3.*;
import net.minecraft.world.storage.*;
import org.lwjgl.input.*;
import java.util.*;
import net.minecraft.world.*;

public class GuiCreateWorld extends GuiScreen
{
    private /* synthetic */ String savedGameMode;
    private /* synthetic */ GuiButton btnGameMode;
    private /* synthetic */ GuiButton btnMapFeatures;
    private /* synthetic */ int selectedIndex;
    private /* synthetic */ String saveDirName;
    private static final /* synthetic */ String[] DISALLOWED_FILENAMES;
    private /* synthetic */ String gameModeDesc2;
    private /* synthetic */ GuiTextField worldNameField;
    private /* synthetic */ String worldName;
    private /* synthetic */ boolean allowCheats;
    private /* synthetic */ GuiButton btnMoreOptions;
    private /* synthetic */ boolean allowCheatsWasSetByUser;
    private /* synthetic */ GuiButton btnMapType;
    private /* synthetic */ boolean inMoreWorldOptionsDisplay;
    private /* synthetic */ boolean generateStructuresEnabled;
    private /* synthetic */ GuiButton btnCustomizeType;
    private final /* synthetic */ GuiScreen parentScreen;
    private /* synthetic */ String gameMode;
    private /* synthetic */ String worldSeed;
    public /* synthetic */ String chunkProviderSettingsJson;
    private /* synthetic */ GuiButton btnAllowCommands;
    private /* synthetic */ boolean alreadyGenerated;
    private /* synthetic */ GuiButton btnBonusItems;
    private /* synthetic */ boolean hardCoreMode;
    private /* synthetic */ GuiTextField worldSeedField;
    private /* synthetic */ boolean bonusChestEnabled;
    private /* synthetic */ String gameModeDesc1;
    
    static {
        DISALLOWED_FILENAMES = new String[] { "CON", "COM", "PRN", "AUX", "CLOCK$", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9" };
    }
    
    private void showMoreWorldOptions(final boolean llllllllllllllIlIlIlllIIIIlIIIlI) {
        this.inMoreWorldOptionsDisplay = llllllllllllllIlIlIlllIIIIlIIIlI;
        if (WorldType.WORLD_TYPES[this.selectedIndex] == WorldType.DEBUG_WORLD) {
            this.btnGameMode.visible = !this.inMoreWorldOptionsDisplay;
            this.btnGameMode.enabled = false;
            if (this.savedGameMode == null) {
                this.savedGameMode = this.gameMode;
            }
            this.gameMode = "spectator";
            this.btnMapFeatures.visible = false;
            this.btnBonusItems.visible = false;
            this.btnMapType.visible = this.inMoreWorldOptionsDisplay;
            this.btnAllowCommands.visible = false;
            this.btnCustomizeType.visible = false;
        }
        else {
            this.btnGameMode.visible = !this.inMoreWorldOptionsDisplay;
            this.btnGameMode.enabled = true;
            if (this.savedGameMode != null) {
                this.gameMode = this.savedGameMode;
                this.savedGameMode = null;
            }
            this.btnMapFeatures.visible = (this.inMoreWorldOptionsDisplay && WorldType.WORLD_TYPES[this.selectedIndex] != WorldType.CUSTOMIZED);
            this.btnBonusItems.visible = this.inMoreWorldOptionsDisplay;
            this.btnMapType.visible = this.inMoreWorldOptionsDisplay;
            this.btnAllowCommands.visible = this.inMoreWorldOptionsDisplay;
            this.btnCustomizeType.visible = (this.inMoreWorldOptionsDisplay && (WorldType.WORLD_TYPES[this.selectedIndex] == WorldType.FLAT || WorldType.WORLD_TYPES[this.selectedIndex] == WorldType.CUSTOMIZED));
        }
        this.updateDisplayState();
        if (this.inMoreWorldOptionsDisplay) {
            this.btnMoreOptions.displayString = I18n.format("gui.done", new Object[0]);
        }
        else {
            this.btnMoreOptions.displayString = I18n.format("selectWorld.moreWorldOptions", new Object[0]);
        }
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllllIlIlIlllIIIIIlIIIl, final int llllllllllllllIlIlIlllIIIIIlIIII, final int llllllllllllllIlIlIlllIIIIIIlIll) throws IOException {
        super.mouseClicked(llllllllllllllIlIlIlllIIIIIlIIIl, llllllllllllllIlIlIlllIIIIIlIIII, llllllllllllllIlIlIlllIIIIIIlIll);
        if (this.inMoreWorldOptionsDisplay) {
            this.worldSeedField.mouseClicked(llllllllllllllIlIlIlllIIIIIlIIIl, llllllllllllllIlIlIlllIIIIIlIIII, llllllllllllllIlIlIlllIIIIIIlIll);
        }
        else {
            this.worldNameField.mouseClicked(llllllllllllllIlIlIlllIIIIIlIIIl, llllllllllllllIlIlIlllIIIIIlIIII, llllllllllllllIlIlIlllIIIIIIlIll);
        }
    }
    
    private void calcSaveDirName() {
        this.saveDirName = this.worldNameField.getText().trim();
        final char llllllllllllllIlIlIlllIIIlIlIIll;
        final long llllllllllllllIlIlIlllIIIlIlIlII = ((char[])(Object)(llllllllllllllIlIlIlllIIIlIlIIll = (char)(Object)ChatAllowedCharacters.ILLEGAL_FILE_CHARACTERS)).length;
        for (boolean llllllllllllllIlIlIlllIIIlIlIlIl = false; (llllllllllllllIlIlIlllIIIlIlIlIl ? 1 : 0) < llllllllllllllIlIlIlllIIIlIlIlII; ++llllllllllllllIlIlIlllIIIlIlIlIl) {
            final char llllllllllllllIlIlIlllIIIlIllIII = llllllllllllllIlIlIlllIIIlIlIIll[llllllllllllllIlIlIlllIIIlIlIlIl];
            this.saveDirName = this.saveDirName.replace(llllllllllllllIlIlIlllIIIlIllIII, '_');
        }
        if (StringUtils.isEmpty((CharSequence)this.saveDirName)) {
            this.saveDirName = "World";
        }
        this.saveDirName = getUncollidingSaveDirName(this.mc.getSaveLoader(), this.saveDirName);
    }
    
    private void toggleMoreWorldOptions() {
        this.showMoreWorldOptions(!this.inMoreWorldOptionsDisplay);
    }
    
    private void updateDisplayState() {
        this.btnGameMode.displayString = String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.gameMode", new Object[0]))).append(": ").append(I18n.format(String.valueOf(new StringBuilder("selectWorld.gameMode.").append(this.gameMode)), new Object[0])));
        this.gameModeDesc1 = I18n.format(String.valueOf(new StringBuilder("selectWorld.gameMode.").append(this.gameMode).append(".line1")), new Object[0]);
        this.gameModeDesc2 = I18n.format(String.valueOf(new StringBuilder("selectWorld.gameMode.").append(this.gameMode).append(".line2")), new Object[0]);
        this.btnMapFeatures.displayString = String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.mapFeatures", new Object[0]))).append(" "));
        if (this.generateStructuresEnabled) {
            this.btnMapFeatures.displayString = String.valueOf(new StringBuilder(String.valueOf(this.btnMapFeatures.displayString)).append(I18n.format("options.on", new Object[0])));
        }
        else {
            this.btnMapFeatures.displayString = String.valueOf(new StringBuilder(String.valueOf(this.btnMapFeatures.displayString)).append(I18n.format("options.off", new Object[0])));
        }
        this.btnBonusItems.displayString = String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.bonusItems", new Object[0]))).append(" "));
        if (this.bonusChestEnabled && !this.hardCoreMode) {
            this.btnBonusItems.displayString = String.valueOf(new StringBuilder(String.valueOf(this.btnBonusItems.displayString)).append(I18n.format("options.on", new Object[0])));
        }
        else {
            this.btnBonusItems.displayString = String.valueOf(new StringBuilder(String.valueOf(this.btnBonusItems.displayString)).append(I18n.format("options.off", new Object[0])));
        }
        this.btnMapType.displayString = String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.mapType", new Object[0]))).append(" ").append(I18n.format(WorldType.WORLD_TYPES[this.selectedIndex].getTranslateName(), new Object[0])));
        this.btnAllowCommands.displayString = String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.allowCommands", new Object[0]))).append(" "));
        if (this.allowCheats && !this.hardCoreMode) {
            this.btnAllowCommands.displayString = String.valueOf(new StringBuilder(String.valueOf(this.btnAllowCommands.displayString)).append(I18n.format("options.on", new Object[0])));
        }
        else {
            this.btnAllowCommands.displayString = String.valueOf(new StringBuilder(String.valueOf(this.btnAllowCommands.displayString)).append(I18n.format("options.off", new Object[0])));
        }
    }
    
    public void recreateFromExistingWorld(final WorldInfo llllllllllllllIlIlIllIlllllllIll) {
        this.worldName = I18n.format("selectWorld.newWorld.copyOf", llllllllllllllIlIlIllIlllllllIll.getWorldName());
        this.worldSeed = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIlIllIlllllllIll.getSeed())));
        this.selectedIndex = llllllllllllllIlIlIllIlllllllIll.getTerrainType().getWorldTypeID();
        this.chunkProviderSettingsJson = llllllllllllllIlIlIllIlllllllIll.getGeneratorOptions();
        this.generateStructuresEnabled = llllllllllllllIlIlIllIlllllllIll.isMapFeaturesEnabled();
        this.allowCheats = llllllllllllllIlIlIllIlllllllIll.areCommandsAllowed();
        if (llllllllllllllIlIlIllIlllllllIll.isHardcoreModeEnabled()) {
            this.gameMode = "hardcore";
        }
        else if (llllllllllllllIlIlIllIlllllllIll.getGameType().isSurvivalOrAdventure()) {
            this.gameMode = "survival";
        }
        else if (llllllllllllllIlIlIllIlllllllIll.getGameType().isCreative()) {
            this.gameMode = "creative";
        }
    }
    
    private boolean canSelectCurWorldType() {
        final WorldType llllllllllllllIlIlIlllIIIIlIlIll = WorldType.WORLD_TYPES[this.selectedIndex];
        return llllllllllllllIlIlIlllIIIIlIlIll != null && llllllllllllllIlIlIlllIIIIlIlIll.getCanBeCreated() && (llllllllllllllIlIlIlllIIIIlIlIll != WorldType.DEBUG_WORLD || GuiScreen.isShiftKeyDown());
    }
    
    public static String getUncollidingSaveDirName(final ISaveFormat llllllllllllllIlIlIlllIIIlIIlIIl, String llllllllllllllIlIlIlllIIIlIIIlIl) {
        llllllllllllllIlIlIlllIIIlIIIlIl = llllllllllllllIlIlIlllIIIlIIIlIl.replaceAll("[\\./\"]", "_");
        final int llllllllllllllIlIlIlllIIIlIIIIIl;
        final int llllllllllllllIlIlIlllIIIlIIIIlI = ((String[])(Object)(llllllllllllllIlIlIlllIIIlIIIIIl = (int)(Object)GuiCreateWorld.DISALLOWED_FILENAMES)).length;
        for (short llllllllllllllIlIlIlllIIIlIIIIll = 0; llllllllllllllIlIlIlllIIIlIIIIll < llllllllllllllIlIlIlllIIIlIIIIlI; ++llllllllllllllIlIlIlllIIIlIIIIll) {
            final String llllllllllllllIlIlIlllIIIlIIIlll = llllllllllllllIlIlIlllIIIlIIIIIl[llllllllllllllIlIlIlllIIIlIIIIll];
            if (llllllllllllllIlIlIlllIIIlIIIlIl.equalsIgnoreCase(llllllllllllllIlIlIlllIIIlIIIlll)) {
                llllllllllllllIlIlIlllIIIlIIIlIl = String.valueOf(new StringBuilder("_").append(llllllllllllllIlIlIlllIIIlIIIlIl).append("_"));
            }
        }
        while (llllllllllllllIlIlIlllIIIlIIlIIl.getWorldInfo(llllllllllllllIlIlIlllIIIlIIIlIl) != null) {
            llllllllllllllIlIlIlllIIIlIIIlIl = String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIlIlllIIIlIIIlIl)).append("-"));
        }
        return llllllllllllllIlIlIlllIIIlIIIlIl;
    }
    
    @Override
    public void updateScreen() {
        this.worldNameField.updateCursorCounter();
        this.worldSeedField.updateCursorCounter();
    }
    
    public GuiCreateWorld(final GuiScreen llllllllllllllIlIlIlllIIIllIIlIl) {
        this.gameMode = "survival";
        this.generateStructuresEnabled = true;
        this.chunkProviderSettingsJson = "";
        this.parentScreen = llllllllllllllIlIlIlllIIIllIIlIl;
        this.worldSeed = "";
        this.worldName = I18n.format("selectWorld.newWorld", new Object[0]);
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIlIlIlllIIIIIIIIIl, final int llllllllllllllIlIlIlllIIIIIIIIII, final float llllllllllllllIlIlIllIllllllllll) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("selectWorld.create", new Object[0]), this.width / 2, 20, -1);
        if (this.inMoreWorldOptionsDisplay) {
            this.drawString(this.fontRendererObj, I18n.format("selectWorld.enterSeed", new Object[0]), this.width / 2 - 100, 47, -6250336);
            this.drawString(this.fontRendererObj, I18n.format("selectWorld.seedInfo", new Object[0]), this.width / 2 - 100, 85, -6250336);
            if (this.btnMapFeatures.visible) {
                this.drawString(this.fontRendererObj, I18n.format("selectWorld.mapFeatures.info", new Object[0]), this.width / 2 - 150, 122, -6250336);
            }
            if (this.btnAllowCommands.visible) {
                this.drawString(this.fontRendererObj, I18n.format("selectWorld.allowCommands.info", new Object[0]), this.width / 2 - 150, 172, -6250336);
            }
            this.worldSeedField.drawTextBox();
            if (WorldType.WORLD_TYPES[this.selectedIndex].showWorldInfoNotice()) {
                this.fontRendererObj.drawSplitString(I18n.format(WorldType.WORLD_TYPES[this.selectedIndex].getTranslatedInfo(), new Object[0]), this.btnMapType.xPosition + 2, this.btnMapType.yPosition + 22, this.btnMapType.getButtonWidth(), 10526880);
            }
        }
        else {
            this.drawString(this.fontRendererObj, I18n.format("selectWorld.enterName", new Object[0]), this.width / 2 - 100, 47, -6250336);
            this.drawString(this.fontRendererObj, String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.resultFolder", new Object[0]))).append(" ").append(this.saveDirName)), this.width / 2 - 100, 85, -6250336);
            this.worldNameField.drawTextBox();
            this.drawString(this.fontRendererObj, this.gameModeDesc1, this.width / 2 - 100, 137, -6250336);
            this.drawString(this.fontRendererObj, this.gameModeDesc2, this.width / 2 - 100, 149, -6250336);
        }
        super.drawScreen(llllllllllllllIlIlIlllIIIIIIIIIl, llllllllllllllIlIlIlllIIIIIIIIII, llllllllllllllIlIlIllIllllllllll);
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 155, this.height - 28, 150, 20, I18n.format("selectWorld.create", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 + 5, this.height - 28, 150, 20, I18n.format("gui.cancel", new Object[0])));
        this.btnGameMode = this.addButton(new GuiButton(2, this.width / 2 - 75, 115, 150, 20, I18n.format("selectWorld.gameMode", new Object[0])));
        this.btnMoreOptions = this.addButton(new GuiButton(3, this.width / 2 - 75, 187, 150, 20, I18n.format("selectWorld.moreWorldOptions", new Object[0])));
        this.btnMapFeatures = this.addButton(new GuiButton(4, this.width / 2 - 155, 100, 150, 20, I18n.format("selectWorld.mapFeatures", new Object[0])));
        this.btnMapFeatures.visible = false;
        this.btnBonusItems = this.addButton(new GuiButton(7, this.width / 2 + 5, 151, 150, 20, I18n.format("selectWorld.bonusItems", new Object[0])));
        this.btnBonusItems.visible = false;
        this.btnMapType = this.addButton(new GuiButton(5, this.width / 2 + 5, 100, 150, 20, I18n.format("selectWorld.mapType", new Object[0])));
        this.btnMapType.visible = false;
        this.btnAllowCommands = this.addButton(new GuiButton(6, this.width / 2 - 155, 151, 150, 20, I18n.format("selectWorld.allowCommands", new Object[0])));
        this.btnAllowCommands.visible = false;
        this.btnCustomizeType = this.addButton(new GuiButton(8, this.width / 2 + 5, 120, 150, 20, I18n.format("selectWorld.customizeType", new Object[0])));
        this.btnCustomizeType.visible = false;
        this.worldNameField = new GuiTextField(9, this.fontRendererObj, this.width / 2 - 100, 60, 200, 20);
        this.worldNameField.setFocused(true);
        this.worldNameField.setText(this.worldName);
        this.worldSeedField = new GuiTextField(10, this.fontRendererObj, this.width / 2 - 100, 60, 200, 20);
        this.worldSeedField.setText(this.worldSeed);
        this.showMoreWorldOptions(this.inMoreWorldOptionsDisplay);
        this.calcSaveDirName();
        this.updateDisplayState();
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllIlIlIlllIIIIIllIII, final int llllllllllllllIlIlIlllIIIIIlIlll) throws IOException {
        if (this.worldNameField.isFocused() && !this.inMoreWorldOptionsDisplay) {
            this.worldNameField.textboxKeyTyped(llllllllllllllIlIlIlllIIIIIllIII, llllllllllllllIlIlIlllIIIIIlIlll);
            this.worldName = this.worldNameField.getText();
        }
        else if (this.worldSeedField.isFocused() && this.inMoreWorldOptionsDisplay) {
            this.worldSeedField.textboxKeyTyped(llllllllllllllIlIlIlllIIIIIllIII, llllllllllllllIlIlIlllIIIIIlIlll);
            this.worldSeed = this.worldSeedField.getText();
        }
        if (llllllllllllllIlIlIlllIIIIIlIlll == 28 || llllllllllllllIlIlIlllIIIIIlIlll == 156) {
            this.actionPerformed(this.buttonList.get(0));
        }
        this.buttonList.get(0).enabled = !this.worldNameField.getText().isEmpty();
        this.calcSaveDirName();
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIlIlIlllIIIIlllIIl) throws IOException {
        if (llllllllllllllIlIlIlllIIIIlllIIl.enabled) {
            if (llllllllllllllIlIlIlllIIIIlllIIl.id == 1) {
                this.mc.displayGuiScreen(this.parentScreen);
            }
            else if (llllllllllllllIlIlIlllIIIIlllIIl.id == 0) {
                this.mc.displayGuiScreen(null);
                if (this.alreadyGenerated) {
                    return;
                }
                this.alreadyGenerated = true;
                long llllllllllllllIlIlIlllIIIIlllIII = new Random().nextLong();
                final String llllllllllllllIlIlIlllIIIIllIlll = this.worldSeedField.getText();
                if (!StringUtils.isEmpty((CharSequence)llllllllllllllIlIlIlllIIIIllIlll)) {
                    try {
                        final long llllllllllllllIlIlIlllIIIIllIllI = Long.parseLong(llllllllllllllIlIlIlllIIIIllIlll);
                        if (llllllllllllllIlIlIlllIIIIllIllI != 0L) {
                            llllllllllllllIlIlIlllIIIIlllIII = llllllllllllllIlIlIlllIIIIllIllI;
                        }
                    }
                    catch (NumberFormatException llllllllllllllIlIlIlllIIIIllIlIl) {
                        llllllllllllllIlIlIlllIIIIlllIII = llllllllllllllIlIlIlllIIIIllIlll.hashCode();
                    }
                }
                final WorldSettings llllllllllllllIlIlIlllIIIIllIlII = new WorldSettings(llllllllllllllIlIlIlllIIIIlllIII, GameType.getByName(this.gameMode), this.generateStructuresEnabled, this.hardCoreMode, WorldType.WORLD_TYPES[this.selectedIndex]);
                llllllllllllllIlIlIlllIIIIllIlII.setGeneratorOptions(this.chunkProviderSettingsJson);
                if (this.bonusChestEnabled && !this.hardCoreMode) {
                    llllllllllllllIlIlIlllIIIIllIlII.enableBonusChest();
                }
                if (this.allowCheats && !this.hardCoreMode) {
                    llllllllllllllIlIlIlllIIIIllIlII.enableCommands();
                }
                this.mc.launchIntegratedServer(this.saveDirName, this.worldNameField.getText().trim(), llllllllllllllIlIlIlllIIIIllIlII);
            }
            else if (llllllllllllllIlIlIlllIIIIlllIIl.id == 3) {
                this.toggleMoreWorldOptions();
            }
            else if (llllllllllllllIlIlIlllIIIIlllIIl.id == 2) {
                if ("survival".equals(this.gameMode)) {
                    if (!this.allowCheatsWasSetByUser) {
                        this.allowCheats = false;
                    }
                    this.hardCoreMode = false;
                    this.gameMode = "hardcore";
                    this.hardCoreMode = true;
                    this.btnAllowCommands.enabled = false;
                    this.btnBonusItems.enabled = false;
                    this.updateDisplayState();
                }
                else if ("hardcore".equals(this.gameMode)) {
                    if (!this.allowCheatsWasSetByUser) {
                        this.allowCheats = true;
                    }
                    this.hardCoreMode = false;
                    this.gameMode = "creative";
                    this.updateDisplayState();
                    this.hardCoreMode = false;
                    this.btnAllowCommands.enabled = true;
                    this.btnBonusItems.enabled = true;
                }
                else {
                    if (!this.allowCheatsWasSetByUser) {
                        this.allowCheats = false;
                    }
                    this.gameMode = "survival";
                    this.updateDisplayState();
                    this.btnAllowCommands.enabled = true;
                    this.btnBonusItems.enabled = true;
                    this.hardCoreMode = false;
                }
                this.updateDisplayState();
            }
            else if (llllllllllllllIlIlIlllIIIIlllIIl.id == 4) {
                this.generateStructuresEnabled = !this.generateStructuresEnabled;
                this.updateDisplayState();
            }
            else if (llllllllllllllIlIlIlllIIIIlllIIl.id == 7) {
                this.bonusChestEnabled = !this.bonusChestEnabled;
                this.updateDisplayState();
            }
            else if (llllllllllllllIlIlIlllIIIIlllIIl.id == 5) {
                ++this.selectedIndex;
                if (this.selectedIndex >= WorldType.WORLD_TYPES.length) {
                    this.selectedIndex = 0;
                }
                while (!this.canSelectCurWorldType()) {
                    ++this.selectedIndex;
                    if (this.selectedIndex >= WorldType.WORLD_TYPES.length) {
                        this.selectedIndex = 0;
                    }
                }
                this.chunkProviderSettingsJson = "";
                this.updateDisplayState();
                this.showMoreWorldOptions(this.inMoreWorldOptionsDisplay);
            }
            else if (llllllllllllllIlIlIlllIIIIlllIIl.id == 6) {
                this.allowCheatsWasSetByUser = true;
                this.allowCheats = !this.allowCheats;
                this.updateDisplayState();
            }
            else if (llllllllllllllIlIlIlllIIIIlllIIl.id == 8) {
                if (WorldType.WORLD_TYPES[this.selectedIndex] == WorldType.FLAT) {
                    this.mc.displayGuiScreen(new GuiCreateFlatWorld(this, this.chunkProviderSettingsJson));
                }
                else {
                    this.mc.displayGuiScreen(new GuiCustomizeWorldScreen(this, this.chunkProviderSettingsJson));
                }
            }
        }
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
}
