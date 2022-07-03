package net.minecraft.client.gui.inventory;

import net.minecraft.client.gui.*;
import net.minecraft.tileentity.*;
import com.google.common.collect.*;
import java.util.*;
import java.text.*;
import net.minecraft.client.resources.*;
import java.io.*;
import org.lwjgl.input.*;
import net.minecraft.util.*;
import org.apache.logging.log4j.*;
import io.netty.buffer.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.util.math.*;

public class GuiEditStructure extends GuiScreen
{
    private /* synthetic */ GuiButton rotate180DegreesButton;
    private /* synthetic */ GuiButton rotate270DegressButton;
    private /* synthetic */ GuiTextField dataEdit;
    private final /* synthetic */ TileEntityStructure tileStructure;
    private /* synthetic */ GuiTextField sizeZEdit;
    private /* synthetic */ boolean showAir;
    private /* synthetic */ GuiButton rotateNinetyDegreesButton;
    private /* synthetic */ GuiTextField nameEdit;
    private /* synthetic */ GuiButton rotateZeroDegreesButton;
    private final /* synthetic */ DecimalFormat decimalFormat;
    private /* synthetic */ GuiButton loadButton;
    private /* synthetic */ Rotation rotation;
    private /* synthetic */ Mirror mirror;
    private /* synthetic */ GuiButton showAirButton;
    private /* synthetic */ GuiButton saveButton;
    private /* synthetic */ GuiTextField posXEdit;
    private /* synthetic */ GuiTextField integrityEdit;
    private /* synthetic */ GuiTextField posYEdit;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    private /* synthetic */ GuiButton showBoundingBoxButton;
    private /* synthetic */ boolean ignoreEntities;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode;
    private /* synthetic */ GuiButton doneButton;
    private /* synthetic */ GuiButton mirrorButton;
    private /* synthetic */ GuiButton cancelButton;
    private /* synthetic */ GuiTextField seedEdit;
    private /* synthetic */ TileEntityStructure.Mode mode;
    private /* synthetic */ GuiButton detectSizeButton;
    private final /* synthetic */ List<GuiTextField> tabOrder;
    private /* synthetic */ boolean showBoundingBox;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    private /* synthetic */ GuiTextField sizeYEdit;
    private /* synthetic */ GuiButton showEntitiesButton;
    private /* synthetic */ GuiButton modeButton;
    private /* synthetic */ GuiTextField posZEdit;
    private static final /* synthetic */ Logger LOGGER;
    public static final /* synthetic */ int[] LEGAL_KEY_CODES;
    private /* synthetic */ GuiTextField sizeXEdit;
    
    private long parseSeed(final String lllllllllllllllllIlIlllIllIlIIIl) {
        try {
            return Long.valueOf(lllllllllllllllllIlIlllIllIlIIIl);
        }
        catch (NumberFormatException lllllllllllllllllIlIlllIllIlIIII) {
            return 0L;
        }
    }
    
    public GuiEditStructure(final TileEntityStructure lllllllllllllllllIlIllllIIIlIIlI) {
        this.mirror = Mirror.NONE;
        this.rotation = Rotation.NONE;
        this.mode = TileEntityStructure.Mode.DATA;
        this.tabOrder = (List<GuiTextField>)Lists.newArrayList();
        this.decimalFormat = new DecimalFormat("0.0###");
        this.tileStructure = lllllllllllllllllIlIllllIIIlIIlI;
        this.decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
    }
    
    private void updateMode() {
        this.nameEdit.setFocused(false);
        this.posXEdit.setFocused(false);
        this.posYEdit.setFocused(false);
        this.posZEdit.setFocused(false);
        this.sizeXEdit.setFocused(false);
        this.sizeYEdit.setFocused(false);
        this.sizeZEdit.setFocused(false);
        this.integrityEdit.setFocused(false);
        this.seedEdit.setFocused(false);
        this.dataEdit.setFocused(false);
        this.nameEdit.setVisible(false);
        this.nameEdit.setFocused(false);
        this.posXEdit.setVisible(false);
        this.posYEdit.setVisible(false);
        this.posZEdit.setVisible(false);
        this.sizeXEdit.setVisible(false);
        this.sizeYEdit.setVisible(false);
        this.sizeZEdit.setVisible(false);
        this.integrityEdit.setVisible(false);
        this.seedEdit.setVisible(false);
        this.dataEdit.setVisible(false);
        this.saveButton.visible = false;
        this.loadButton.visible = false;
        this.detectSizeButton.visible = false;
        this.showEntitiesButton.visible = false;
        this.mirrorButton.visible = false;
        this.rotateZeroDegreesButton.visible = false;
        this.rotateNinetyDegreesButton.visible = false;
        this.rotate180DegreesButton.visible = false;
        this.rotate270DegressButton.visible = false;
        this.showAirButton.visible = false;
        this.showBoundingBoxButton.visible = false;
        switch ($SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode()[this.tileStructure.getMode().ordinal()]) {
            case 1: {
                this.nameEdit.setVisible(true);
                this.nameEdit.setFocused(true);
                this.posXEdit.setVisible(true);
                this.posYEdit.setVisible(true);
                this.posZEdit.setVisible(true);
                this.sizeXEdit.setVisible(true);
                this.sizeYEdit.setVisible(true);
                this.sizeZEdit.setVisible(true);
                this.saveButton.visible = true;
                this.detectSizeButton.visible = true;
                this.showEntitiesButton.visible = true;
                this.showAirButton.visible = true;
                break;
            }
            case 2: {
                this.nameEdit.setVisible(true);
                this.nameEdit.setFocused(true);
                this.posXEdit.setVisible(true);
                this.posYEdit.setVisible(true);
                this.posZEdit.setVisible(true);
                this.integrityEdit.setVisible(true);
                this.seedEdit.setVisible(true);
                this.loadButton.visible = true;
                this.showEntitiesButton.visible = true;
                this.mirrorButton.visible = true;
                this.rotateZeroDegreesButton.visible = true;
                this.rotateNinetyDegreesButton.visible = true;
                this.rotate180DegreesButton.visible = true;
                this.rotate270DegressButton.visible = true;
                this.showBoundingBoxButton.visible = true;
                this.updateDirectionButtons();
                break;
            }
            case 3: {
                this.nameEdit.setVisible(true);
                this.nameEdit.setFocused(true);
                break;
            }
            case 4: {
                this.dataEdit.setVisible(true);
                this.dataEdit.setFocused(true);
                break;
            }
        }
        this.modeButton.displayString = I18n.format(String.valueOf(new StringBuilder("structure_block.mode.").append(this.tileStructure.getMode().getName())), new Object[0]);
    }
    
    private int parseCoordinate(final String lllllllllllllllllIlIlllIllIIIIll) {
        try {
            return Integer.parseInt(lllllllllllllllllIlIlllIllIIIIll);
        }
        catch (NumberFormatException lllllllllllllllllIlIlllIllIIIIlI) {
            return 0;
        }
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllllllIlIlllIlIIlIIlI, final int lllllllllllllllllIlIlllIlIIlIIIl, final int lllllllllllllllllIlIlllIlIIIllII) throws IOException {
        super.mouseClicked(lllllllllllllllllIlIlllIlIIlIIlI, lllllllllllllllllIlIlllIlIIlIIIl, lllllllllllllllllIlIlllIlIIIllII);
        if (this.nameEdit.getVisible()) {
            this.nameEdit.mouseClicked(lllllllllllllllllIlIlllIlIIlIIlI, lllllllllllllllllIlIlllIlIIlIIIl, lllllllllllllllllIlIlllIlIIIllII);
        }
        if (this.posXEdit.getVisible()) {
            this.posXEdit.mouseClicked(lllllllllllllllllIlIlllIlIIlIIlI, lllllllllllllllllIlIlllIlIIlIIIl, lllllllllllllllllIlIlllIlIIIllII);
        }
        if (this.posYEdit.getVisible()) {
            this.posYEdit.mouseClicked(lllllllllllllllllIlIlllIlIIlIIlI, lllllllllllllllllIlIlllIlIIlIIIl, lllllllllllllllllIlIlllIlIIIllII);
        }
        if (this.posZEdit.getVisible()) {
            this.posZEdit.mouseClicked(lllllllllllllllllIlIlllIlIIlIIlI, lllllllllllllllllIlIlllIlIIlIIIl, lllllllllllllllllIlIlllIlIIIllII);
        }
        if (this.sizeXEdit.getVisible()) {
            this.sizeXEdit.mouseClicked(lllllllllllllllllIlIlllIlIIlIIlI, lllllllllllllllllIlIlllIlIIlIIIl, lllllllllllllllllIlIlllIlIIIllII);
        }
        if (this.sizeYEdit.getVisible()) {
            this.sizeYEdit.mouseClicked(lllllllllllllllllIlIlllIlIIlIIlI, lllllllllllllllllIlIlllIlIIlIIIl, lllllllllllllllllIlIlllIlIIIllII);
        }
        if (this.sizeZEdit.getVisible()) {
            this.sizeZEdit.mouseClicked(lllllllllllllllllIlIlllIlIIlIIlI, lllllllllllllllllIlIlllIlIIlIIIl, lllllllllllllllllIlIlllIlIIIllII);
        }
        if (this.integrityEdit.getVisible()) {
            this.integrityEdit.mouseClicked(lllllllllllllllllIlIlllIlIIlIIlI, lllllllllllllllllIlIlllIlIIlIIIl, lllllllllllllllllIlIlllIlIIIllII);
        }
        if (this.seedEdit.getVisible()) {
            this.seedEdit.mouseClicked(lllllllllllllllllIlIlllIlIIlIIlI, lllllllllllllllllIlIlllIlIIlIIIl, lllllllllllllllllIlIlllIlIIIllII);
        }
        if (this.dataEdit.getVisible()) {
            this.dataEdit.mouseClicked(lllllllllllllllllIlIlllIlIIlIIlI, lllllllllllllllllIlIlllIlIIlIIIl, lllllllllllllllllIlIlllIlIIIllII);
        }
    }
    
    private void updateDirectionButtons() {
        this.rotateZeroDegreesButton.enabled = true;
        this.rotateNinetyDegreesButton.enabled = true;
        this.rotate180DegreesButton.enabled = true;
        this.rotate270DegressButton.enabled = true;
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[this.tileStructure.getRotation().ordinal()]) {
            case 1: {
                this.rotateZeroDegreesButton.enabled = false;
                break;
            }
            case 3: {
                this.rotate180DegreesButton.enabled = false;
                break;
            }
            case 4: {
                this.rotate270DegressButton.enabled = false;
                break;
            }
            case 2: {
                this.rotateNinetyDegreesButton.enabled = false;
                break;
            }
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllllIlIlllIllllllIl) throws IOException {
        if (lllllllllllllllllIlIlllIllllllIl.enabled) {
            if (lllllllllllllllllIlIlllIllllllIl.id == 1) {
                this.tileStructure.setMirror(this.mirror);
                this.tileStructure.setRotation(this.rotation);
                this.tileStructure.setMode(this.mode);
                this.tileStructure.setIgnoresEntities(this.ignoreEntities);
                this.tileStructure.setShowAir(this.showAir);
                this.tileStructure.setShowBoundingBox(this.showBoundingBox);
                this.mc.displayGuiScreen(null);
            }
            else if (lllllllllllllllllIlIlllIllllllIl.id == 0) {
                if (this.sendToServer(1)) {
                    this.mc.displayGuiScreen(null);
                }
            }
            else if (lllllllllllllllllIlIlllIllllllIl.id == 9) {
                if (this.tileStructure.getMode() == TileEntityStructure.Mode.SAVE) {
                    this.sendToServer(2);
                    this.mc.displayGuiScreen(null);
                }
            }
            else if (lllllllllllllllllIlIlllIllllllIl.id == 10) {
                if (this.tileStructure.getMode() == TileEntityStructure.Mode.LOAD) {
                    this.sendToServer(3);
                    this.mc.displayGuiScreen(null);
                }
            }
            else if (lllllllllllllllllIlIlllIllllllIl.id == 11) {
                this.tileStructure.setRotation(Rotation.NONE);
                this.updateDirectionButtons();
            }
            else if (lllllllllllllllllIlIlllIllllllIl.id == 12) {
                this.tileStructure.setRotation(Rotation.CLOCKWISE_90);
                this.updateDirectionButtons();
            }
            else if (lllllllllllllllllIlIlllIllllllIl.id == 13) {
                this.tileStructure.setRotation(Rotation.CLOCKWISE_180);
                this.updateDirectionButtons();
            }
            else if (lllllllllllllllllIlIlllIllllllIl.id == 14) {
                this.tileStructure.setRotation(Rotation.COUNTERCLOCKWISE_90);
                this.updateDirectionButtons();
            }
            else if (lllllllllllllllllIlIlllIllllllIl.id == 18) {
                this.tileStructure.nextMode();
                this.updateMode();
            }
            else if (lllllllllllllllllIlIlllIllllllIl.id == 19) {
                if (this.tileStructure.getMode() == TileEntityStructure.Mode.SAVE) {
                    this.sendToServer(4);
                    this.mc.displayGuiScreen(null);
                }
            }
            else if (lllllllllllllllllIlIlllIllllllIl.id == 20) {
                this.tileStructure.setIgnoresEntities(!this.tileStructure.ignoresEntities());
                this.updateEntitiesButton();
            }
            else if (lllllllllllllllllIlIlllIllllllIl.id == 22) {
                this.tileStructure.setShowAir(!this.tileStructure.showsAir());
                this.updateToggleAirButton();
            }
            else if (lllllllllllllllllIlIlllIllllllIl.id == 23) {
                this.tileStructure.setShowBoundingBox(!this.tileStructure.showsBoundingBox());
                this.updateToggleBoundingBox();
            }
            else if (lllllllllllllllllIlIlllIllllllIl.id == 21) {
                switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[this.tileStructure.getMirror().ordinal()]) {
                    case 1: {
                        this.tileStructure.setMirror(Mirror.LEFT_RIGHT);
                        break;
                    }
                    case 2: {
                        this.tileStructure.setMirror(Mirror.FRONT_BACK);
                        break;
                    }
                    case 3: {
                        this.tileStructure.setMirror(Mirror.NONE);
                        break;
                    }
                }
                this.updateMirrorButton();
            }
        }
    }
    
    private void updateToggleBoundingBox() {
        final boolean lllllllllllllllllIlIlllIlllIllIl = this.tileStructure.showsBoundingBox();
        if (lllllllllllllllllIlIlllIlllIllIl) {
            this.showBoundingBoxButton.displayString = I18n.format("options.on", new Object[0]);
        }
        else {
            this.showBoundingBoxButton.displayString = I18n.format("options.off", new Object[0]);
        }
    }
    
    private float parseIntegrity(final String lllllllllllllllllIlIlllIllIIlIlI) {
        try {
            return Float.valueOf(lllllllllllllllllIlIlllIllIIlIlI);
        }
        catch (NumberFormatException lllllllllllllllllIlIlllIllIIlIIl) {
            return 1.0f;
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllllIlIlllIIlllIIll, final int lllllllllllllllllIlIlllIIlllIIlI, final float lllllllllllllllllIlIlllIIlllllll) {
        this.drawDefaultBackground();
        final TileEntityStructure.Mode lllllllllllllllllIlIlllIIllllllI = this.tileStructure.getMode();
        this.drawCenteredString(this.fontRendererObj, I18n.format("tile.structureBlock.name", new Object[0]), this.width / 2, 10, 16777215);
        if (lllllllllllllllllIlIlllIIllllllI != TileEntityStructure.Mode.DATA) {
            this.drawString(this.fontRendererObj, I18n.format("structure_block.structure_name", new Object[0]), this.width / 2 - 153, 30, 10526880);
            this.nameEdit.drawTextBox();
        }
        if (lllllllllllllllllIlIlllIIllllllI == TileEntityStructure.Mode.LOAD || lllllllllllllllllIlIlllIIllllllI == TileEntityStructure.Mode.SAVE) {
            this.drawString(this.fontRendererObj, I18n.format("structure_block.position", new Object[0]), this.width / 2 - 153, 70, 10526880);
            this.posXEdit.drawTextBox();
            this.posYEdit.drawTextBox();
            this.posZEdit.drawTextBox();
            final String lllllllllllllllllIlIlllIIlllllIl = I18n.format("structure_block.include_entities", new Object[0]);
            final int lllllllllllllllllIlIlllIIlllllII = this.fontRendererObj.getStringWidth(lllllllllllllllllIlIlllIIlllllIl);
            this.drawString(this.fontRendererObj, lllllllllllllllllIlIlllIIlllllIl, this.width / 2 + 154 - lllllllllllllllllIlIlllIIlllllII, 150, 10526880);
        }
        if (lllllllllllllllllIlIlllIIllllllI == TileEntityStructure.Mode.SAVE) {
            this.drawString(this.fontRendererObj, I18n.format("structure_block.size", new Object[0]), this.width / 2 - 153, 110, 10526880);
            this.sizeXEdit.drawTextBox();
            this.sizeYEdit.drawTextBox();
            this.sizeZEdit.drawTextBox();
            final String lllllllllllllllllIlIlllIIllllIll = I18n.format("structure_block.detect_size", new Object[0]);
            final int lllllllllllllllllIlIlllIIllllIlI = this.fontRendererObj.getStringWidth(lllllllllllllllllIlIlllIIllllIll);
            this.drawString(this.fontRendererObj, lllllllllllllllllIlIlllIIllllIll, this.width / 2 + 154 - lllllllllllllllllIlIlllIIllllIlI, 110, 10526880);
            final String lllllllllllllllllIlIlllIIllllIIl = I18n.format("structure_block.show_air", new Object[0]);
            final int lllllllllllllllllIlIlllIIllllIII = this.fontRendererObj.getStringWidth(lllllllllllllllllIlIlllIIllllIIl);
            this.drawString(this.fontRendererObj, lllllllllllllllllIlIlllIIllllIIl, this.width / 2 + 154 - lllllllllllllllllIlIlllIIllllIII, 70, 10526880);
        }
        if (lllllllllllllllllIlIlllIIllllllI == TileEntityStructure.Mode.LOAD) {
            this.drawString(this.fontRendererObj, I18n.format("structure_block.integrity", new Object[0]), this.width / 2 - 153, 110, 10526880);
            this.integrityEdit.drawTextBox();
            this.seedEdit.drawTextBox();
            final String lllllllllllllllllIlIlllIIlllIlll = I18n.format("structure_block.show_boundingbox", new Object[0]);
            final int lllllllllllllllllIlIlllIIlllIllI = this.fontRendererObj.getStringWidth(lllllllllllllllllIlIlllIIlllIlll);
            this.drawString(this.fontRendererObj, lllllllllllllllllIlIlllIIlllIlll, this.width / 2 + 154 - lllllllllllllllllIlIlllIIlllIllI, 70, 10526880);
        }
        if (lllllllllllllllllIlIlllIIllllllI == TileEntityStructure.Mode.DATA) {
            this.drawString(this.fontRendererObj, I18n.format("structure_block.custom_data", new Object[0]), this.width / 2 - 153, 110, 10526880);
            this.dataEdit.drawTextBox();
        }
        final String lllllllllllllllllIlIlllIIlllIlIl = String.valueOf(new StringBuilder("structure_block.mode_info.").append(lllllllllllllllllIlIlllIIllllllI.getName()));
        this.drawString(this.fontRendererObj, I18n.format(lllllllllllllllllIlIlllIIlllIlIl, new Object[0]), this.width / 2 - 153, 174, 10526880);
        super.drawScreen(lllllllllllllllllIlIlllIIlllIIll, lllllllllllllllllIlIlllIIlllIIlI, lllllllllllllllllIlIlllIIlllllll);
    }
    
    private void updateEntitiesButton() {
        final boolean lllllllllllllllllIlIlllIlllllIIl = !this.tileStructure.ignoresEntities();
        if (lllllllllllllllllIlIlllIlllllIIl) {
            this.showEntitiesButton.displayString = I18n.format("options.on", new Object[0]);
        }
        else {
            this.showEntitiesButton.displayString = I18n.format("options.off", new Object[0]);
        }
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = GuiEditStructure.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final int lllllllllllllllllIlIlllIIllIIlll = (Object)new int[Rotation.values().length];
        try {
            lllllllllllllllllIlIlllIIllIIlll[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllllIlIlllIIllIIlll[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllllIlIlllIIllIIlll[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllllIlIlllIIllIIlll[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return GuiEditStructure.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllllllllIlIlllIIllIIlll;
    }
    
    private void updateMirrorButton() {
        final Mirror lllllllllllllllllIlIlllIlllIIlll = this.tileStructure.getMirror();
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[lllllllllllllllllIlIlllIlllIIlll.ordinal()]) {
            case 1: {
                this.mirrorButton.displayString = "|";
                break;
            }
            case 2: {
                this.mirrorButton.displayString = "< >";
                break;
            }
            case 3: {
                this.mirrorButton.displayString = "^ v";
                break;
            }
        }
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    private void updateToggleAirButton() {
        final boolean lllllllllllllllllIlIlllIllllIIll = this.tileStructure.showsAir();
        if (lllllllllllllllllIlIlllIllllIIll) {
            this.showAirButton.displayString = I18n.format("options.on", new Object[0]);
        }
        else {
            this.showAirButton.displayString = I18n.format("options.off", new Object[0]);
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = GuiEditStructure.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final short lllllllllllllllllIlIlllIIllIlIIl = (Object)new int[Mirror.values().length];
        try {
            lllllllllllllllllIlIlllIIllIlIIl[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllllIlIlllIIllIlIIl[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllllIlIlllIIllIlIIl[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return GuiEditStructure.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllllllllIlIlllIIllIlIIl;
    }
    
    private static boolean isValidCharacterForName(final char lllllllllllllllllIlIlllIlIIllllI, final int lllllllllllllllllIlIlllIlIIlllIl) {
        boolean lllllllllllllllllIlIlllIlIlIIIIl = true;
        char lllllllllllllllllIlIlllIlIIllIII;
        Exception lllllllllllllllllIlIlllIlIIllIIl = (Exception)((int[])(Object)(lllllllllllllllllIlIlllIlIIllIII = (char)(Object)GuiEditStructure.LEGAL_KEY_CODES)).length;
        for (final int lllllllllllllllllIlIlllIlIlIIIII : lllllllllllllllllIlIlllIlIIllIII) {
            if (lllllllllllllllllIlIlllIlIlIIIII == lllllllllllllllllIlIlllIlIIlllIl) {
                return true;
            }
        }
        lllllllllllllllllIlIlllIlIIllIIl = (Exception)((char[])(Object)(lllllllllllllllllIlIlllIlIIllIII = (char)(Object)ChatAllowedCharacters.ILLEGAL_STRUCTURE_CHARACTERS)).length;
        for (final char lllllllllllllllllIlIlllIlIIlllll : lllllllllllllllllIlIlllIlIIllIII) {
            if (lllllllllllllllllIlIlllIlIIlllll == lllllllllllllllllIlIlllIlIIllllI) {
                lllllllllllllllllIlIlllIlIlIIIIl = false;
                break;
            }
        }
        return lllllllllllllllllIlIlllIlIlIIIIl;
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllllllIlIlllIlIllIlll, final int lllllllllllllllllIlIlllIlIlIllll) throws IOException {
        if (this.nameEdit.getVisible() && isValidCharacterForName(lllllllllllllllllIlIlllIlIllIlll, lllllllllllllllllIlIlllIlIlIllll)) {
            this.nameEdit.textboxKeyTyped(lllllllllllllllllIlIlllIlIllIlll, lllllllllllllllllIlIlllIlIlIllll);
        }
        if (this.posXEdit.getVisible()) {
            this.posXEdit.textboxKeyTyped(lllllllllllllllllIlIlllIlIllIlll, lllllllllllllllllIlIlllIlIlIllll);
        }
        if (this.posYEdit.getVisible()) {
            this.posYEdit.textboxKeyTyped(lllllllllllllllllIlIlllIlIllIlll, lllllllllllllllllIlIlllIlIlIllll);
        }
        if (this.posZEdit.getVisible()) {
            this.posZEdit.textboxKeyTyped(lllllllllllllllllIlIlllIlIllIlll, lllllllllllllllllIlIlllIlIlIllll);
        }
        if (this.sizeXEdit.getVisible()) {
            this.sizeXEdit.textboxKeyTyped(lllllllllllllllllIlIlllIlIllIlll, lllllllllllllllllIlIlllIlIlIllll);
        }
        if (this.sizeYEdit.getVisible()) {
            this.sizeYEdit.textboxKeyTyped(lllllllllllllllllIlIlllIlIllIlll, lllllllllllllllllIlIlllIlIlIllll);
        }
        if (this.sizeZEdit.getVisible()) {
            this.sizeZEdit.textboxKeyTyped(lllllllllllllllllIlIlllIlIllIlll, lllllllllllllllllIlIlllIlIlIllll);
        }
        if (this.integrityEdit.getVisible()) {
            this.integrityEdit.textboxKeyTyped(lllllllllllllllllIlIlllIlIllIlll, lllllllllllllllllIlIlllIlIlIllll);
        }
        if (this.seedEdit.getVisible()) {
            this.seedEdit.textboxKeyTyped(lllllllllllllllllIlIlllIlIllIlll, lllllllllllllllllIlIlllIlIlIllll);
        }
        if (this.dataEdit.getVisible()) {
            this.dataEdit.textboxKeyTyped(lllllllllllllllllIlIlllIlIllIlll, lllllllllllllllllIlIlllIlIlIllll);
        }
        if (lllllllllllllllllIlIlllIlIlIllll == 15) {
            GuiTextField lllllllllllllllllIlIlllIlIllIlIl = null;
            GuiTextField lllllllllllllllllIlIlllIlIllIlII = null;
            for (final GuiTextField lllllllllllllllllIlIlllIlIllIIll : this.tabOrder) {
                if (lllllllllllllllllIlIlllIlIllIlIl != null && lllllllllllllllllIlIlllIlIllIIll.getVisible()) {
                    lllllllllllllllllIlIlllIlIllIlII = lllllllllllllllllIlIlllIlIllIIll;
                    break;
                }
                if (!lllllllllllllllllIlIlllIlIllIIll.isFocused() || !lllllllllllllllllIlIlllIlIllIIll.getVisible()) {
                    continue;
                }
                lllllllllllllllllIlIlllIlIllIlIl = lllllllllllllllllIlIlllIlIllIIll;
            }
            if (lllllllllllllllllIlIlllIlIllIlIl != null && lllllllllllllllllIlIlllIlIllIlII == null) {
                for (final GuiTextField lllllllllllllllllIlIlllIlIllIIlI : this.tabOrder) {
                    if (lllllllllllllllllIlIlllIlIllIIlI.getVisible() && lllllllllllllllllIlIlllIlIllIIlI != lllllllllllllllllIlIlllIlIllIlIl) {
                        lllllllllllllllllIlIlllIlIllIlII = lllllllllllllllllIlIlllIlIllIIlI;
                        break;
                    }
                }
            }
            if (lllllllllllllllllIlIlllIlIllIlII != null && lllllllllllllllllIlIlllIlIllIlII != lllllllllllllllllIlIlllIlIllIlIl) {
                lllllllllllllllllIlIlllIlIllIlIl.setFocused(false);
                lllllllllllllllllIlIlllIlIllIlII.setFocused(true);
            }
        }
        if (lllllllllllllllllIlIlllIlIlIllll != 28 && lllllllllllllllllIlIlllIlIlIllll != 156) {
            if (lllllllllllllllllIlIlllIlIlIllll == 1) {
                this.actionPerformed(this.cancelButton);
            }
        }
        else {
            this.actionPerformed(this.doneButton);
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        LEGAL_KEY_CODES = new int[] { 203, 205, 14, 211, 199, 207 };
    }
    
    private boolean sendToServer(final int lllllllllllllllllIlIlllIllIlIllI) {
        try {
            final PacketBuffer lllllllllllllllllIlIlllIllIllIIl = new PacketBuffer(Unpooled.buffer());
            this.tileStructure.writeCoordinates(lllllllllllllllllIlIlllIllIllIIl);
            lllllllllllllllllIlIlllIllIllIIl.writeByte(lllllllllllllllllIlIlllIllIlIllI);
            lllllllllllllllllIlIlllIllIllIIl.writeString(this.tileStructure.getMode().toString());
            lllllllllllllllllIlIlllIllIllIIl.writeString(this.nameEdit.getText());
            lllllllllllllllllIlIlllIllIllIIl.writeInt(this.parseCoordinate(this.posXEdit.getText()));
            lllllllllllllllllIlIlllIllIllIIl.writeInt(this.parseCoordinate(this.posYEdit.getText()));
            lllllllllllllllllIlIlllIllIllIIl.writeInt(this.parseCoordinate(this.posZEdit.getText()));
            lllllllllllllllllIlIlllIllIllIIl.writeInt(this.parseCoordinate(this.sizeXEdit.getText()));
            lllllllllllllllllIlIlllIllIllIIl.writeInt(this.parseCoordinate(this.sizeYEdit.getText()));
            lllllllllllllllllIlIlllIllIllIIl.writeInt(this.parseCoordinate(this.sizeZEdit.getText()));
            lllllllllllllllllIlIlllIllIllIIl.writeString(this.tileStructure.getMirror().toString());
            lllllllllllllllllIlIlllIllIllIIl.writeString(this.tileStructure.getRotation().toString());
            lllllllllllllllllIlIlllIllIllIIl.writeString(this.dataEdit.getText());
            lllllllllllllllllIlIlllIllIllIIl.writeBoolean(this.tileStructure.ignoresEntities());
            lllllllllllllllllIlIlllIllIllIIl.writeBoolean(this.tileStructure.showsAir());
            lllllllllllllllllIlIlllIllIllIIl.writeBoolean(this.tileStructure.showsBoundingBox());
            lllllllllllllllllIlIlllIllIllIIl.writeFloat(this.parseIntegrity(this.integrityEdit.getText()));
            lllllllllllllllllIlIlllIllIllIIl.writeVarLong(this.parseSeed(this.seedEdit.getText()));
            this.mc.getConnection().sendPacket(new CPacketCustomPayload("MC|Struct", lllllllllllllllllIlIlllIllIllIIl));
            return true;
        }
        catch (Exception lllllllllllllllllIlIlllIllIllIII) {
            GuiEditStructure.LOGGER.warn("Could not send structure block info", (Throwable)lllllllllllllllllIlIlllIllIllIII);
            return false;
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode() {
        final int[] $switch_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode = GuiEditStructure.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode;
        if ($switch_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode != null) {
            return $switch_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode;
        }
        final double lllllllllllllllllIlIlllIIllIIlIl = (Object)new int[TileEntityStructure.Mode.values().length];
        try {
            lllllllllllllllllIlIlllIIllIIlIl[TileEntityStructure.Mode.CORNER.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllllIlIlllIIllIIlIl[TileEntityStructure.Mode.DATA.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllllIlIlllIIllIIlIl[TileEntityStructure.Mode.LOAD.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllllIlIlllIIllIIlIl[TileEntityStructure.Mode.SAVE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return GuiEditStructure.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode = (int[])(Object)lllllllllllllllllIlIlllIIllIIlIl;
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.doneButton = this.addButton(new GuiButton(0, this.width / 2 - 4 - 150, 210, 150, 20, I18n.format("gui.done", new Object[0])));
        this.cancelButton = this.addButton(new GuiButton(1, this.width / 2 + 4, 210, 150, 20, I18n.format("gui.cancel", new Object[0])));
        this.saveButton = this.addButton(new GuiButton(9, this.width / 2 + 4 + 100, 185, 50, 20, I18n.format("structure_block.button.save", new Object[0])));
        this.loadButton = this.addButton(new GuiButton(10, this.width / 2 + 4 + 100, 185, 50, 20, I18n.format("structure_block.button.load", new Object[0])));
        this.modeButton = this.addButton(new GuiButton(18, this.width / 2 - 4 - 150, 185, 50, 20, "MODE"));
        this.detectSizeButton = this.addButton(new GuiButton(19, this.width / 2 + 4 + 100, 120, 50, 20, I18n.format("structure_block.button.detect_size", new Object[0])));
        this.showEntitiesButton = this.addButton(new GuiButton(20, this.width / 2 + 4 + 100, 160, 50, 20, "ENTITIES"));
        this.mirrorButton = this.addButton(new GuiButton(21, this.width / 2 - 20, 185, 40, 20, "MIRROR"));
        this.showAirButton = this.addButton(new GuiButton(22, this.width / 2 + 4 + 100, 80, 50, 20, "SHOWAIR"));
        this.showBoundingBoxButton = this.addButton(new GuiButton(23, this.width / 2 + 4 + 100, 80, 50, 20, "SHOWBB"));
        this.rotateZeroDegreesButton = this.addButton(new GuiButton(11, this.width / 2 - 1 - 40 - 1 - 40 - 20, 185, 40, 20, "0"));
        this.rotateNinetyDegreesButton = this.addButton(new GuiButton(12, this.width / 2 - 1 - 40 - 20, 185, 40, 20, "90"));
        this.rotate180DegreesButton = this.addButton(new GuiButton(13, this.width / 2 + 1 + 20, 185, 40, 20, "180"));
        this.rotate270DegressButton = this.addButton(new GuiButton(14, this.width / 2 + 1 + 40 + 1 + 20, 185, 40, 20, "270"));
        this.nameEdit = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 152, 40, 300, 20);
        this.nameEdit.setMaxStringLength(64);
        this.nameEdit.setText(this.tileStructure.getName());
        this.tabOrder.add(this.nameEdit);
        final BlockPos lllllllllllllllllIlIllllIIIIlIII = this.tileStructure.getPosition();
        this.posXEdit = new GuiTextField(3, this.fontRendererObj, this.width / 2 - 152, 80, 80, 20);
        this.posXEdit.setMaxStringLength(15);
        this.posXEdit.setText(Integer.toString(lllllllllllllllllIlIllllIIIIlIII.getX()));
        this.tabOrder.add(this.posXEdit);
        this.posYEdit = new GuiTextField(4, this.fontRendererObj, this.width / 2 - 72, 80, 80, 20);
        this.posYEdit.setMaxStringLength(15);
        this.posYEdit.setText(Integer.toString(lllllllllllllllllIlIllllIIIIlIII.getY()));
        this.tabOrder.add(this.posYEdit);
        this.posZEdit = new GuiTextField(5, this.fontRendererObj, this.width / 2 + 8, 80, 80, 20);
        this.posZEdit.setMaxStringLength(15);
        this.posZEdit.setText(Integer.toString(lllllllllllllllllIlIllllIIIIlIII.getZ()));
        this.tabOrder.add(this.posZEdit);
        final BlockPos lllllllllllllllllIlIllllIIIIIlll = this.tileStructure.getStructureSize();
        this.sizeXEdit = new GuiTextField(6, this.fontRendererObj, this.width / 2 - 152, 120, 80, 20);
        this.sizeXEdit.setMaxStringLength(15);
        this.sizeXEdit.setText(Integer.toString(lllllllllllllllllIlIllllIIIIIlll.getX()));
        this.tabOrder.add(this.sizeXEdit);
        this.sizeYEdit = new GuiTextField(7, this.fontRendererObj, this.width / 2 - 72, 120, 80, 20);
        this.sizeYEdit.setMaxStringLength(15);
        this.sizeYEdit.setText(Integer.toString(lllllllllllllllllIlIllllIIIIIlll.getY()));
        this.tabOrder.add(this.sizeYEdit);
        this.sizeZEdit = new GuiTextField(8, this.fontRendererObj, this.width / 2 + 8, 120, 80, 20);
        this.sizeZEdit.setMaxStringLength(15);
        this.sizeZEdit.setText(Integer.toString(lllllllllllllllllIlIllllIIIIIlll.getZ()));
        this.tabOrder.add(this.sizeZEdit);
        this.integrityEdit = new GuiTextField(15, this.fontRendererObj, this.width / 2 - 152, 120, 80, 20);
        this.integrityEdit.setMaxStringLength(15);
        this.integrityEdit.setText(this.decimalFormat.format(this.tileStructure.getIntegrity()));
        this.tabOrder.add(this.integrityEdit);
        this.seedEdit = new GuiTextField(16, this.fontRendererObj, this.width / 2 - 72, 120, 80, 20);
        this.seedEdit.setMaxStringLength(31);
        this.seedEdit.setText(Long.toString(this.tileStructure.getSeed()));
        this.tabOrder.add(this.seedEdit);
        this.dataEdit = new GuiTextField(17, this.fontRendererObj, this.width / 2 - 152, 120, 240, 20);
        this.dataEdit.setMaxStringLength(128);
        this.dataEdit.setText(this.tileStructure.getMetadata());
        this.tabOrder.add(this.dataEdit);
        this.mirror = this.tileStructure.getMirror();
        this.updateMirrorButton();
        this.rotation = this.tileStructure.getRotation();
        this.updateDirectionButtons();
        this.mode = this.tileStructure.getMode();
        this.updateMode();
        this.ignoreEntities = this.tileStructure.ignoresEntities();
        this.updateEntitiesButton();
        this.showAir = this.tileStructure.showsAir();
        this.updateToggleAirButton();
        this.showBoundingBox = this.tileStructure.showsBoundingBox();
        this.updateToggleBoundingBox();
    }
    
    @Override
    public void updateScreen() {
        this.nameEdit.updateCursorCounter();
        this.posXEdit.updateCursorCounter();
        this.posYEdit.updateCursorCounter();
        this.posZEdit.updateCursorCounter();
        this.sizeXEdit.updateCursorCounter();
        this.sizeYEdit.updateCursorCounter();
        this.sizeZEdit.updateCursorCounter();
        this.integrityEdit.updateCursorCounter();
        this.seedEdit.updateCursorCounter();
        this.dataEdit.updateCursorCounter();
    }
}
