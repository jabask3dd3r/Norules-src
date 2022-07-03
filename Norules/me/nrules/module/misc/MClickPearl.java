package me.nrules.module.misc;

import me.nrules.event.events.*;
import org.lwjgl.input.*;
import net.minecraft.init.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import net.minecraft.network.play.client.*;
import net.minecraft.item.*;
import me.nrules.event.*;
import me.nrules.module.*;

public class MClickPearl extends Module
{
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllllIlIlIIlllIlIllllII) {
        if (Mouse.isButtonDown(2) && MClickPearl.mc.currentScreen == null) {
            for (int llllllllllllllIlIlIIlllIlIlllIll = 0; llllllllllllllIlIlIIlllIlIlllIll < 9; ++llllllllllllllIlIlIIlllIlIlllIll) {
                final ItemStack llllllllllllllIlIlIIlllIlIlllIlI = MClickPearl.mc.player.inventory.getStackInSlot(llllllllllllllIlIlIIlllIlIlllIll);
                if (llllllllllllllIlIlIIlllIlIlllIlI.getItem() == Items.ENDER_PEARL) {
                    MClickPearl.mc.player.connection.sendPacket(new CPacketHeldItemChange(llllllllllllllIlIlIIlllIlIlllIll));
                    MClickPearl.mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                    MClickPearl.mc.player.connection.sendPacket(new CPacketHeldItemChange(MClickPearl.mc.player.inventory.currentItem));
                }
            }
        }
    }
    
    public MClickPearl() {
        super("MClickPearl", 0, Category.MISC);
    }
}
