package me.nrules.module.player;

import java.util.*;
import clickui.settings.*;
import net.minecraft.network.play.server.*;
import me.nrules.event.*;
import me.nrules.module.*;
import net.minecraft.world.*;
import com.kisman.nr.cc.util.*;
import net.minecraft.init.*;
import me.nrules.*;
import net.minecraft.network.play.client.*;
import me.nrules.utils.player.*;
import net.minecraft.entity.*;
import me.nrules.event.events.*;
import net.minecraft.client.entity.*;

public class Freecam extends Module
{
    /* synthetic */ double z;
    /* synthetic */ double x;
    static /* synthetic */ int count;
    public static /* synthetic */ ArrayList<double[]> positionsList;
    private /* synthetic */ Setting clickPos;
    /* synthetic */ double y;
    
    @EventTarget
    public void onMove(final EventReceivePacket lllllllllllllIllIlllIIlllIlIlIll) {
        if (lllllllllllllIllIlllIIlllIlIlIll.getPacket() instanceof SPacketPlayerPosLook) {
            lllllllllllllIllIlllIIlllIlIlIll.setCancelled(true);
        }
    }
    
    public Freecam() {
        super("Freecam", 0, Category.PLAYER);
        this.clickPos = new Setting("ClickPos", this, false);
        Freecam.sm.Property(this.clickPos);
    }
    
    @Override
    public void onDisable() {
        Freecam.mc.player.setPosition(this.x, this.y, this.z);
        Freecam.mc.player.capabilities.isFlying = false;
        Freecam.mc.player.noClip = false;
        Freecam.mc.world.removeEntityFromWorld(-1);
        super.onDisable();
    }
    
    public static double posit(final double lllllllllllllIllIlllIIlllIIlIlII) {
        return (lllllllllllllIllIlllIIlllIIlIlII == 0.0) ? lllllllllllllIllIlllIIlllIIlIlII : ((lllllllllllllIllIlllIIlllIIlIlII < 0.0) ? (lllllllllllllIllIlllIIlllIIlIlII * -1.0) : lllllllllllllIllIlllIIlllIIlIlII);
    }
    
    @EventTarget
    public void onUpdate(final Event2D lllllllllllllIllIlllIIlllIIIllIl) {
        if (this.clickPos.getValBoolean()) {
            try {
                if (Freecam.mc.gameSettings.keyBindAttack.isKeyDown()) {
                    if (Freecam.mc.objectMouseOver.entityHit != null) {
                        return;
                    }
                    if (Freecam.mc.world.getBlockState(Freecam.mc.objectMouseOver.getBlockPos()).getBlockHardness(Freecam.mc.world, Freecam.mc.objectMouseOver.getBlockPos()) == -1.0f) {
                        return;
                    }
                    if (BlockUtil.getBlock(Freecam.mc.objectMouseOver.getBlockPos()) != Blocks.AIR && BlockUtil.getBlock(Freecam.mc.objectMouseOver.getBlockPos()) != null) {
                        final double lllllllllllllIllIlllIIlllIIIllII = Freecam.mc.objectMouseOver.getBlockPos().getX();
                        final double lllllllllllllIllIlllIIlllIIIlIll = Freecam.mc.objectMouseOver.getBlockPos().getY();
                        final double lllllllllllllIllIlllIIlllIIIlIlI = Freecam.mc.objectMouseOver.getBlockPos().getZ();
                        Main.msg(String.valueOf(new StringBuilder("Clicked Block: ").append(lllllllllllllIllIlllIIlllIIIllII).append(" | ").append(lllllllllllllIllIlllIIlllIIIlIll).append(" | ").append(lllllllllllllIllIlllIIlllIIIlIlI).append("!")));
                    }
                }
            }
            catch (Exception lllllllllllllIllIlllIIlllIIIlIIl) {
                Main.msg(String.valueOf(new StringBuilder("Block ").append(Freecam.mc.objectMouseOver.getBlockPos().getX()).append(Freecam.mc.objectMouseOver.getBlockPos().getY()).append(Freecam.mc.objectMouseOver.getBlockPos().getZ()).append(" is not valid!")));
            }
        }
    }
    
    static {
        Freecam.positionsList = new ArrayList<double[]>();
        Freecam.count = 0;
    }
    
    @EventTarget
    public void onMove(final EventSendPacket lllllllllllllIllIlllIIlllIlIlIII) {
        if (lllllllllllllIllIlllIIlllIlIlIII.getPacket() instanceof CPacketPlayer) {
            lllllllllllllIllIlllIIlllIlIlIII.setCancelled(true);
        }
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        final float lllllllllllllIllIlllIIlllIIllIlI = (float)MoveUtil.getDirection();
        this.x = Freecam.mc.player.posX;
        this.y = Freecam.mc.player.posY;
        this.z = Freecam.mc.player.posZ;
        final EntityOtherPlayerMP lllllllllllllIllIlllIIlllIIllIIl = new EntityOtherPlayerMP(Freecam.mc.world, Freecam.mc.player.getGameProfile());
        lllllllllllllIllIlllIIlllIIllIIl.inventory = Freecam.mc.player.inventory;
        lllllllllllllIllIlllIIlllIIllIIl.inventoryContainer = Freecam.mc.player.inventoryContainer;
        lllllllllllllIllIlllIIlllIIllIIl.setHealth(Freecam.mc.player.getHealth());
        lllllllllllllIllIlllIIlllIIllIIl.setPositionAndRotation(this.x, Freecam.mc.player.boundingBox.minY, this.z, Freecam.mc.player.rotationYaw, Freecam.mc.player.rotationPitch);
        lllllllllllllIllIlllIIlllIIllIIl.motionY = 0.0;
        lllllllllllllIllIlllIIlllIIllIIl.rotationYawHead = Freecam.mc.player.rotationYawHead;
        Freecam.mc.world.addEntityToWorld(-1, lllllllllllllIllIlllIIlllIIllIIl);
    }
    
    @EventTarget
    public void onPreMotion(final EventUpdate lllllllllllllIllIlllIIlllIlIIlII) {
        final double lllllllllllllIllIlllIIlllIlIIIll = MoveUtil.getDirection();
        Freecam.mc.player.motionY = 0.0;
        if (Freecam.mc.gameSettings.keyBindSneak.isKeyDown()) {
            final EntityPlayerSP player = Freecam.mc.player;
            player.motionY -= 0.800000011920929;
        }
        if (Freecam.mc.gameSettings.keyBindJump.isKeyDown()) {
            final EntityPlayerSP player2 = Freecam.mc.player;
            player2.motionY += 0.800000011920929;
        }
        if (Freecam.mc.player.movementInput.rightKeyDown) {
            final EntityPlayerSP player3 = Freecam.mc.player;
            player3.motionX -= Math.sin(lllllllllllllIllIlllIIlllIlIIIll) * 0.20000000298023224;
            final EntityPlayerSP player4 = Freecam.mc.player;
            player4.motionZ += Math.cos(lllllllllllllIllIlllIIlllIlIIIll) * 0.20000000298023224;
        }
        if (Freecam.mc.player.movementInput.leftKeyDown) {
            final EntityPlayerSP player5 = Freecam.mc.player;
            player5.motionX -= Math.sin(lllllllllllllIllIlllIIlllIlIIIll) * 0.20000000298023224;
            final EntityPlayerSP player6 = Freecam.mc.player;
            player6.motionZ += Math.cos(lllllllllllllIllIlllIIlllIlIIIll) * 0.20000000298023224;
        }
        if (Freecam.mc.player.movementInput.backKeyDown) {
            final EntityPlayerSP player7 = Freecam.mc.player;
            player7.motionX += Math.sin(lllllllllllllIllIlllIIlllIlIIIll) * 0.20000000298023224;
            final EntityPlayerSP player8 = Freecam.mc.player;
            player8.motionZ -= Math.cos(lllllllllllllIllIlllIIlllIlIIIll) * 0.20000000298023224;
        }
        if (Freecam.mc.player.movementInput.forwardKeyDown) {
            final EntityPlayerSP player9 = Freecam.mc.player;
            player9.motionX -= Math.sin(lllllllllllllIllIlllIIlllIlIIIll) * 0.20000000298023224;
            final EntityPlayerSP player10 = Freecam.mc.player;
            player10.motionZ += Math.cos(lllllllllllllIllIlllIIlllIlIIIll) * 0.20000000298023224;
        }
        Freecam.mc.player.noClip = true;
    }
}
