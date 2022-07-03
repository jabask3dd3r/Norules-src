package net.minecraft.client.gui.inventory;

import net.minecraft.client.gui.recipebook.*;
import java.io.*;
import net.minecraft.client.resources.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;

public class GuiInventory extends InventoryEffectRenderer implements IRecipeShownListener
{
    private /* synthetic */ float oldMouseY;
    private /* synthetic */ boolean field_194031_B;
    private /* synthetic */ float oldMouseX;
    private final /* synthetic */ GuiRecipeBook field_192045_A;
    private /* synthetic */ GuiButtonImage field_192048_z;
    private /* synthetic */ boolean field_192046_B;
    
    @Override
    protected void mouseReleased(final int llllllllllllllIIlIIllIIlIIIIlIlI, final int llllllllllllllIIlIIllIIlIIIIIlIl, final int llllllllllllllIIlIIllIIlIIIIlIII) {
        if (this.field_194031_B) {
            this.field_194031_B = false;
        }
        else {
            super.mouseReleased(llllllllllllllIIlIIllIIlIIIIlIlI, llllllllllllllIIlIIllIIlIIIIIlIl, llllllllllllllIIlIIllIIlIIIIlIII);
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIIlIIllIIIlllIlllI) throws IOException {
        if (llllllllllllllIIlIIllIIIlllIlllI.id == 10) {
            this.field_192045_A.func_193014_a(this.field_192046_B, ((ContainerPlayer)this.inventorySlots).craftMatrix);
            this.field_192045_A.func_191866_a();
            this.guiLeft = this.field_192045_A.func_193011_a(this.field_192046_B, this.width, this.xSize);
            this.field_192048_z.func_191746_c(this.guiLeft + 104, this.height / 2 - 22);
            this.field_194031_B = true;
        }
    }
    
    @Override
    protected boolean func_193983_c(final int llllllllllllllIIlIIllIIIllllllII, final int llllllllllllllIIlIIllIIIllllIlIl, final int llllllllllllllIIlIIllIIIlllllIlI, final int llllllllllllllIIlIIllIIIllllIIll) {
        final boolean llllllllllllllIIlIIllIIIlllllIII = llllllllllllllIIlIIllIIIllllllII < llllllllllllllIIlIIllIIIlllllIlI || llllllllllllllIIlIIllIIIllllIlIl < llllllllllllllIIlIIllIIIllllIIll || llllllllllllllIIlIIllIIIllllllII >= llllllllllllllIIlIIllIIIlllllIlI + this.xSize || llllllllllllllIIlIIllIIIllllIlIl >= llllllllllllllIIlIIllIIIllllIIll + this.ySize;
        return this.field_192045_A.func_193955_c(llllllllllllllIIlIIllIIIllllllII, llllllllllllllIIlIIllIIIllllIlIl, this.guiLeft, this.guiTop, this.xSize, this.ySize) && llllllllllllllIIlIIllIIIlllllIII;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int llllllllllllllIIlIIllIIlIllIllll, final int llllllllllllllIIlIIllIIlIllIlllI) {
        this.fontRendererObj.drawString(I18n.format("container.crafting", new Object[0]), 97.0, 8.0, 4210752);
    }
    
    @Override
    protected void handleMouseClick(final Slot llllllllllllllIIlIIllIIIllIlllII, final int llllllllllllllIIlIIllIIIllIlIllI, final int llllllllllllllIIlIIllIIIllIllIlI, final ClickType llllllllllllllIIlIIllIIIllIllIIl) {
        super.handleMouseClick(llllllllllllllIIlIIllIIIllIlllII, llllllllllllllIIlIIllIIIllIlIllI, llllllllllllllIIlIIllIIIllIllIlI, llllllllllllllIIlIIllIIIllIllIIl);
        this.field_192045_A.func_191874_a(llllllllllllllIIlIIllIIIllIlllII);
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllllIIlIIllIIlIIIlIIlI, final int llllllllllllllIIlIIllIIlIIIlIIIl, final int llllllllllllllIIlIIllIIlIIIlIIII) throws IOException {
        if (!this.field_192045_A.func_191862_a(llllllllllllllIIlIIllIIlIIIlIIlI, llllllllllllllIIlIIllIIlIIIlIIIl, llllllllllllllIIlIIllIIlIIIlIIII) && (!this.field_192046_B || !this.field_192045_A.func_191878_b())) {
            super.mouseClicked(llllllllllllllIIlIIllIIlIIIlIIlI, llllllllllllllIIlIIllIIlIIIlIIIl, llllllllllllllIIlIIllIIlIIIlIIII);
        }
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float llllllllllllllIIlIIllIIlIlIlllII, final int llllllllllllllIIlIIllIIlIlIllIll, final int llllllllllllllIIlIIllIIlIlIllIlI) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiInventory.INVENTORY_BACKGROUND);
        final int llllllllllllllIIlIIllIIlIlIllIIl = this.guiLeft;
        final int llllllllllllllIIlIIllIIlIlIllIII = this.guiTop;
        this.drawTexturedModalRect(llllllllllllllIIlIIllIIlIlIllIIl, llllllllllllllIIlIIllIIlIlIllIII, 0, 0, this.xSize, this.ySize);
        drawEntityOnScreen((float)(llllllllllllllIIlIIllIIlIlIllIIl + 51), llllllllllllllIIlIIllIIlIlIllIII + 75, 30, llllllllllllllIIlIIllIIlIlIllIIl + 51 - this.oldMouseX, llllllllllllllIIlIIllIIlIlIllIII + 75 - 50 - this.oldMouseY, this.mc.player);
    }
    
    @Override
    protected boolean isPointInRegion(final int llllllllllllllIIlIIllIIlIIlIlIII, final int llllllllllllllIIlIIllIIlIIlIIlll, final int llllllllllllllIIlIIllIIlIIIlllll, final int llllllllllllllIIlIIllIIlIIIllllI, final int llllllllllllllIIlIIllIIlIIIlllIl, final int llllllllllllllIIlIIllIIlIIlIIIll) {
        return (!this.field_192046_B || !this.field_192045_A.func_191878_b()) && super.isPointInRegion(llllllllllllllIIlIIllIIlIIlIlIII, llllllllllllllIIlIIllIIlIIlIIlll, llllllllllllllIIlIIllIIlIIIlllll, llllllllllllllIIlIIllIIlIIIllllI, llllllllllllllIIlIIllIIlIIIlllIl, llllllllllllllIIlIIllIIlIIlIIIll);
    }
    
    @Override
    public void func_192043_J_() {
        this.field_192045_A.func_193948_e();
    }
    
    @Override
    public void updateScreen() {
        if (this.mc.playerController.isInCreativeMode()) {
            this.mc.displayGuiScreen(new GuiContainerCreative(this.mc.player));
        }
        this.field_192045_A.func_193957_d();
    }
    
    @Override
    public GuiRecipeBook func_194310_f() {
        return this.field_192045_A;
    }
    
    @Override
    public void onGuiClosed() {
        this.field_192045_A.func_191871_c();
        super.onGuiClosed();
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        if (this.mc.playerController.isInCreativeMode()) {
            this.mc.displayGuiScreen(new GuiContainerCreative(this.mc.player));
        }
        else {
            super.initGui();
        }
        this.field_192046_B = (this.width < 379);
        this.field_192045_A.func_194303_a(this.width, this.height, this.mc, this.field_192046_B, ((ContainerPlayer)this.inventorySlots).craftMatrix);
        this.guiLeft = this.field_192045_A.func_193011_a(this.field_192046_B, this.width, this.xSize);
        this.field_192048_z = new GuiButtonImage(10, this.guiLeft + 104, this.height / 2 - 22, 20, 18, 178, 0, 19, GuiInventory.INVENTORY_BACKGROUND);
        this.buttonList.add(this.field_192048_z);
    }
    
    public GuiInventory(final EntityPlayer llllllllllllllIIlIIllIIlIllllIII) {
        super(llllllllllllllIIlIIllIIlIllllIII.inventoryContainer);
        this.field_192045_A = new GuiRecipeBook();
        this.allowUserInput = true;
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllIIlIIllIIIlllIIlll, final int llllllllllllllIIlIIllIIIlllIIIll) throws IOException {
        if (!this.field_192045_A.func_191859_a(llllllllllllllIIlIIllIIIlllIIlll, llllllllllllllIIlIIllIIIlllIIIll)) {
            super.keyTyped(llllllllllllllIIlIIllIIIlllIIlll, llllllllllllllIIlIIllIIIlllIIIll);
        }
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIlIIllIIlIllIIlll, final int llllllllllllllIIlIIllIIlIllIIllI, final float llllllllllllllIIlIIllIIlIllIIIIl) {
        this.drawDefaultBackground();
        this.hasActivePotionEffects = !this.field_192045_A.func_191878_b();
        if (this.field_192045_A.func_191878_b() && this.field_192046_B) {
            this.drawGuiContainerBackgroundLayer(llllllllllllllIIlIIllIIlIllIIIIl, llllllllllllllIIlIIllIIlIllIIlll, llllllllllllllIIlIIllIIlIllIIllI);
            this.field_192045_A.func_191861_a(llllllllllllllIIlIIllIIlIllIIlll, llllllllllllllIIlIIllIIlIllIIllI, llllllllllllllIIlIIllIIlIllIIIIl);
        }
        else {
            this.field_192045_A.func_191861_a(llllllllllllllIIlIIllIIlIllIIlll, llllllllllllllIIlIIllIIlIllIIllI, llllllllllllllIIlIIllIIlIllIIIIl);
            super.drawScreen(llllllllllllllIIlIIllIIlIllIIlll, llllllllllllllIIlIIllIIlIllIIllI, llllllllllllllIIlIIllIIlIllIIIIl);
            this.field_192045_A.func_191864_a(this.guiLeft, this.guiTop, false, llllllllllllllIIlIIllIIlIllIIIIl);
        }
        this.func_191948_b(llllllllllllllIIlIIllIIlIllIIlll, llllllllllllllIIlIIllIIlIllIIllI);
        this.field_192045_A.func_191876_c(this.guiLeft, this.guiTop, llllllllllllllIIlIIllIIlIllIIlll, llllllllllllllIIlIIllIIlIllIIllI);
        this.oldMouseX = (float)llllllllllllllIIlIIllIIlIllIIlll;
        this.oldMouseY = (float)llllllllllllllIIlIIllIIlIllIIllI;
    }
    
    public static void drawEntityOnScreen(final float llllllllllllllIIlIIllIIlIIllllII, final double llllllllllllllIIlIIllIIlIIlllIll, final int llllllllllllllIIlIIllIIlIIlllIlI, final float llllllllllllllIIlIIllIIlIIlllIIl, final float llllllllllllllIIlIIllIIlIIlllIII, final EntityLivingBase llllllllllllllIIlIIllIIlIlIIIIll) {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate(llllllllllllllIIlIIllIIlIIllllII, (float)llllllllllllllIIlIIllIIlIIlllIll, 50.0f);
        GlStateManager.scale((float)(-llllllllllllllIIlIIllIIlIIlllIlI), (float)llllllllllllllIIlIIllIIlIIlllIlI, (float)llllllllllllllIIlIIllIIlIIlllIlI);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        final float llllllllllllllIIlIIllIIlIlIIIIlI = llllllllllllllIIlIIllIIlIlIIIIll.renderYawOffset;
        final float llllllllllllllIIlIIllIIlIlIIIIIl = llllllllllllllIIlIIllIIlIlIIIIll.rotationYaw;
        final float llllllllllllllIIlIIllIIlIlIIIIII = llllllllllllllIIlIIllIIlIlIIIIll.rotationPitch;
        final float llllllllllllllIIlIIllIIlIIllllll = llllllllllllllIIlIIllIIlIlIIIIll.prevRotationYawHead;
        final float llllllllllllllIIlIIllIIlIIlllllI = llllllllllllllIIlIIllIIlIlIIIIll.rotationYawHead;
        GlStateManager.rotate(135.0f, 0.0f, 1.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-(float)Math.atan(llllllllllllllIIlIIllIIlIIlllIII / 40.0f) * 20.0f, 1.0f, 0.0f, 0.0f);
        llllllllllllllIIlIIllIIlIlIIIIll.renderYawOffset = (float)Math.atan(llllllllllllllIIlIIllIIlIIlllIIl / 40.0f) * 20.0f;
        llllllllllllllIIlIIllIIlIlIIIIll.rotationYaw = (float)Math.atan(llllllllllllllIIlIIllIIlIIlllIIl / 40.0f) * 40.0f;
        llllllllllllllIIlIIllIIlIlIIIIll.rotationPitch = -(float)Math.atan(llllllllllllllIIlIIllIIlIIlllIII / 40.0f) * 20.0f;
        llllllllllllllIIlIIllIIlIlIIIIll.rotationYawHead = llllllllllllllIIlIIllIIlIlIIIIll.rotationYaw;
        llllllllllllllIIlIIllIIlIlIIIIll.prevRotationYawHead = llllllllllllllIIlIIllIIlIlIIIIll.rotationYaw;
        GlStateManager.translate(0.0f, 0.0f, 0.0f);
        final RenderManager llllllllllllllIIlIIllIIlIIllllIl = Minecraft.getMinecraft().getRenderManager();
        llllllllllllllIIlIIllIIlIIllllIl.setPlayerViewY(180.0f);
        llllllllllllllIIlIIllIIlIIllllIl.setRenderShadow(false);
        llllllllllllllIIlIIllIIlIIllllIl.doRenderEntity(llllllllllllllIIlIIllIIlIlIIIIll, 0.0, 0.0, 0.0, 0.0f, 1.0f, false);
        llllllllllllllIIlIIllIIlIIllllIl.setRenderShadow(true);
        llllllllllllllIIlIIllIIlIlIIIIll.renderYawOffset = llllllllllllllIIlIIllIIlIlIIIIlI;
        llllllllllllllIIlIIllIIlIlIIIIll.rotationYaw = llllllllllllllIIlIIllIIlIlIIIIIl;
        llllllllllllllIIlIIllIIlIlIIIIll.rotationPitch = llllllllllllllIIlIIllIIlIlIIIIII;
        llllllllllllllIIlIIllIIlIlIIIIll.prevRotationYawHead = llllllllllllllIIlIIllIIlIIllllll;
        llllllllllllllIIlIIllIIlIlIIIIll.rotationYawHead = llllllllllllllIIlIIllIIlIIlllllI;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
}
