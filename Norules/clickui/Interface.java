package clickui;

import net.minecraft.client.gui.*;
import me.nrules.utils.world.*;
import java.util.*;
import clickui.panel.*;
import me.nrules.module.*;
import clickui.panel.panels.*;
import java.io.*;
import me.nrules.utils.render.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;

public class Interface extends GuiScreen implements Manager
{
    /* synthetic */ float scaleA;
    private /* synthetic */ ArrayList<Panel> panels;
    
    @Override
    public void setup() {
        this.panels = new ArrayList<Panel>();
        int lllllllllllllIIIllIIlllIIlIlllll = 20;
        final Exception lllllllllllllIIIllIIlllIIlIllIII;
        final double lllllllllllllIIIllIIlllIIlIllIIl = ((Category[])(Object)(lllllllllllllIIIllIIlllIIlIllIII = (Exception)(Object)Category.values())).length;
        for (long lllllllllllllIIIllIIlllIIlIllIlI = 0; lllllllllllllIIIllIIlllIIlIllIlI < lllllllllllllIIIllIIlllIIlIllIIl; ++lllllllllllllIIIllIIlllIIlIllIlI) {
            final Category lllllllllllllIIIllIIlllIIlIllllI = lllllllllllllIIIllIIlllIIlIllIII[lllllllllllllIIIllIIlllIIlIllIlI];
            this.panels.add(new CheatTypePanel(lllllllllllllIIIllIIlllIIlIllllI, (float)lllllllllllllIIIllIIlllIIlIlllll, 30.0f));
            lllllllllllllIIIllIIlllIIlIlllll += 130;
        }
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        this.panels.forEach(Panel::handleMouseInput);
        super.handleMouseInput();
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllIIIllIIlllIIlIIIllI, final int lllllllllllllIIIllIIlllIIlIIIlIl, final int lllllllllllllIIIllIIlllIIlIIIIII) throws IOException {
        this.panels.forEach(lllllllllllllIIIllIIlllIIIIIllII -> lllllllllllllIIIllIIlllIIIIIllII.mouseClicked(lllllllllllllIIIllIIlllIIlIIIllI, lllllllllllllIIIllIIlllIIlIIIlIl, lllllllllllllIIIllIIlllIIlIIIIII));
        super.mouseClicked(lllllllllllllIIIllIIlllIIlIIIllI, lllllllllllllIIIllIIlllIIlIIIlIl, lllllllllllllIIIllIIlllIIlIIIIII);
    }
    
    @Override
    protected void mouseReleased(final int lllllllllllllIIIllIIlllIIIllIllI, final int lllllllllllllIIIllIIlllIIIllIlIl, final int lllllllllllllIIIllIIlllIIIlllIII) {
        this.panels.forEach(lllllllllllllIIIllIIlllIIIIIIlII -> lllllllllllllIIIllIIlllIIIIIIlII.mouseReleased(lllllllllllllIIIllIIlllIIIllIllI, lllllllllllllIIIllIIlllIIIllIlIl, lllllllllllllIIIllIIlllIIIlllIII));
        super.mouseReleased(lllllllllllllIIIllIIlllIIIllIllI, lllllllllllllIIIllIIlllIIIllIlIl, lllllllllllllIIIllIIlllIIIlllIII);
    }
    
    @Override
    public void initGui() {
        this.scaleA = 0.0f;
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllIIIllIIlllIIIlIlIIl, final int lllllllllllllIIIllIIlllIIIlIlIII) throws IOException {
        this.panels.forEach(lllllllllllllIIIllIIllIllllllIIl -> lllllllllllllIIIllIIllIllllllIIl.keyTyped(lllllllllllllIIIllIIlllIIIlIlIIl, lllllllllllllIIIllIIlllIIIlIlIII));
        super.keyTyped(lllllllllllllIIIllIIlllIIIlIlIIl, lllllllllllllIIIllIIlllIIIlIlIII);
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIIllIIlllIIlIIlllI, final int lllllllllllllIIIllIIlllIIlIlIIIl, final float lllllllllllllIIIllIIlllIIlIIllII) {
        this.drawGrayBackground();
        this.scaleA = (float)RenderUtils.animate(this.scaleA, 1.0);
        GL11.glPushMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)(this.width / 2), (float)(this.height / 2), 0.0f);
        GlStateManager.scale(this.scaleA, this.scaleA, 1.0f);
        GlStateManager.translate((float)(-(this.width / 2)), (float)(-(this.height / 2)), 0.0f);
        this.panels.forEach(lllllllllllllIIIllIIlllIIIlIIIII -> lllllllllllllIIIllIIlllIIIlIIIII.drawScreen(lllllllllllllIIIllIIlllIIlIIlllI, lllllllllllllIIIllIIlllIIlIlIIIl, lllllllllllllIIIllIIlllIIlIIllII));
        super.drawScreen(lllllllllllllIIIllIIlllIIlIIlllI, lllllllllllllIIIllIIlllIIlIlIIIl, lllllllllllllIIIllIIlllIIlIIllII);
        GlStateManager.popMatrix();
        GL11.glPopMatrix();
    }
}
