package me.nrules.module.render;

import me.nrules.module.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.math.*;
import org.lwjgl.opengl.*;
import me.nrules.event.events.*;
import java.awt.*;
import me.nrules.utils.render.*;
import java.util.*;
import me.nrules.event.*;

public class ChestESP extends Module
{
    public ChestESP() {
        super("ChestESP", 0, Category.RENDER);
    }
    
    public void drawESPOnStorage(final TileEntityLockable lllllllllllllIIlIIlIlIllIlIlllII, final double lllllllllllllIIlIIlIlIllIllIlIII, final double lllllllllllllIIlIIlIlIllIlIllIlI, final double lllllllllllllIIlIIlIlIllIlIllIIl, final int lllllllllllllIIlIIlIlIllIlIllIII, final int lllllllllllllIIlIIlIlIllIllIIlII) {
        if (!lllllllllllllIIlIIlIlIllIlIlllII.isLocked()) {
            final TileEntityChest lllllllllllllIIlIIlIlIllIllIIIll = (TileEntityChest)lllllllllllllIIlIIlIlIllIlIlllII;
            Vec3d lllllllllllllIIlIIlIlIllIllIIIII = null;
            Vec3d lllllllllllllIIlIIlIlIllIlIlllIl = null;
            if (lllllllllllllIIlIIlIlIllIllIIIll.adjacentChestZNeg != null) {
                final Vec3d lllllllllllllIIlIIlIlIllIllIIIlI = new Vec3d(lllllllllllllIIlIIlIlIllIllIlIII + 0.0625, lllllllllllllIIlIIlIlIllIlIllIlI, lllllllllllllIIlIIlIlIllIlIllIIl - 0.9375);
                final Vec3d lllllllllllllIIlIIlIlIllIlIlllll = new Vec3d(lllllllllllllIIlIIlIlIllIllIlIII + 0.9375, lllllllllllllIIlIIlIlIllIlIllIlI + 0.875, lllllllllllllIIlIIlIlIllIlIllIIl + 0.9375);
            }
            else if (lllllllllllllIIlIIlIlIllIllIIIll.adjacentChestXNeg != null) {
                final Vec3d lllllllllllllIIlIIlIlIllIllIIIIl = new Vec3d(lllllllllllllIIlIIlIlIllIllIlIII + 0.9375, lllllllllllllIIlIIlIlIllIlIllIlI, lllllllllllllIIlIIlIlIllIlIllIIl + 0.0625);
                final Vec3d lllllllllllllIIlIIlIlIllIlIllllI = new Vec3d(lllllllllllllIIlIIlIlIllIllIlIII - 0.9375, lllllllllllllIIlIIlIlIllIlIllIlI + 0.875, lllllllllllllIIlIIlIlIllIlIllIIl + 0.9375);
            }
            else {
                if (lllllllllllllIIlIIlIlIllIllIIIll.adjacentChestXPos != null || lllllllllllllIIlIIlIlIllIllIIIll.adjacentChestZPos != null) {
                    return;
                }
                lllllllllllllIIlIIlIlIllIllIIIII = new Vec3d(lllllllllllllIIlIIlIlIllIllIlIII + 0.0625, lllllllllllllIIlIIlIlIllIlIllIlI, lllllllllllllIIlIIlIlIllIlIllIIl + 0.0625);
                lllllllllllllIIlIIlIlIllIlIlllIl = new Vec3d(lllllllllllllIIlIIlIlIllIllIlIII + 0.9375, lllllllllllllIIlIIlIlIllIlIllIlI + 0.875, lllllllllllllIIlIIlIlIllIlIllIIl + 0.9375);
            }
            RenderUtils.pre3D();
            ChestESP.mc.entityRenderer.setupCameraTransform(ChestESP.mc.timer.renderPartialTicks, 2);
            if (((TileEntityChest)lllllllllllllIIlIIlIlIllIlIlllII).getChestType() == BlockChest.Type.BASIC) {
                RenderUtils.glColor(lllllllllllllIIlIIlIlIllIlIllIII);
            }
            else if (((TileEntityChest)lllllllllllllIIlIIlIlIllIlIlllII).getChestType() == BlockChest.Type.TRAP) {
                RenderUtils.glColor(lllllllllllllIIlIIlIlIllIllIIlII);
            }
            RenderUtils.drawFilledBox(new AxisAlignedBB(lllllllllllllIIlIIlIlIllIllIIIII.xCoord - RenderManager.renderPosX, lllllllllllllIIlIIlIlIllIllIIIII.yCoord - RenderManager.renderPosY, lllllllllllllIIlIIlIlIllIllIIIII.zCoord - RenderManager.renderPosZ, lllllllllllllIIlIIlIlIllIlIlllIl.xCoord - RenderManager.renderPosX, lllllllllllllIIlIIlIlIllIlIlllIl.yCoord - RenderManager.renderPosY, lllllllllllllIIlIIlIlIllIlIlllIl.zCoord - RenderManager.renderPosZ));
            GL11.glColor4f(0.0f, 0.0f, 0.0f, 1.0f);
            RenderUtils.post3D();
        }
    }
    
    @EventTarget
    public void onRender3D(final EventRender3D lllllllllllllIIlIIlIlIllIlllllll) {
        for (final Object lllllllllllllIIlIIlIlIllIlllllIl : ChestESP.mc.world.loadedTileEntityList) {
            if (lllllllllllllIIlIIlIlIllIlllllIl instanceof TileEntityChest) {
                final TileEntityLockable lllllllllllllIIlIIlIlIllIlllllII = (TileEntityLockable)lllllllllllllIIlIIlIlIllIlllllIl;
                final int lllllllllllllIIlIIlIlIllIllllIll = ColorUtils.getColor(new Color(252, 12, 12, 50));
                final int lllllllllllllIIlIIlIlIllIllllIlI = ColorUtils.getColor(new Color(239, 62, 15, 50));
                this.drawESPOnStorage(lllllllllllllIIlIIlIlIllIlllllII, lllllllllllllIIlIIlIlIllIlllllII.getPos().getX(), lllllllllllllIIlIIlIlIllIlllllII.getPos().getY(), lllllllllllllIIlIIlIlIllIlllllII.getPos().getZ(), lllllllllllllIIlIIlIlIllIllllIll, lllllllllllllIIlIIlIlIllIllllIlI);
            }
        }
    }
}
