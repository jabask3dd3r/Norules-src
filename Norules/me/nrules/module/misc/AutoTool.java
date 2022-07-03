package me.nrules.module.misc;

import me.nrules.event.events.*;
import me.nrules.event.*;
import me.nrules.notifications.*;
import net.minecraft.util.math.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import me.nrules.module.*;

public class AutoTool extends Module
{
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllllllllIIIIlIlllIlIlI) {
        if (!AutoTool.mc.gameSettings.keyBindAttack.pressed || AutoTool.mc.objectMouseOver == null) {
            return;
        }
        this.updateTool(AutoTool.mc.objectMouseOver.getBlockPos());
    }
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    @EventTarget
    public void updateTool(final BlockPos llllllllllllllllllIIIIlIlllIIIII) {
        final Block llllllllllllllllllIIIIlIllIlllll = AutoTool.mc.world.getBlockState(llllllllllllllllllIIIIlIlllIIIII).getBlock();
        float llllllllllllllllllIIIIlIllIllllI = 1.0f;
        byte llllllllllllllllllIIIIlIllIlllIl = -1;
        for (byte llllllllllllllllllIIIIlIllIlllII = 0; llllllllllllllllllIIIIlIllIlllII < 9; ++llllllllllllllllllIIIIlIllIlllII) {
            final ItemStack llllllllllllllllllIIIIlIllIllIll = AutoTool.mc.player.inventory.mainInventory.get(llllllllllllllllllIIIIlIllIlllII);
            final ItemStack llllllllllllllllllIIIIlIllIllIlI = AutoTool.mc.player.inventory.getCurrentItem();
            if (llllllllllllllllllIIIIlIllIllIll != null && llllllllllllllllllIIIIlIllIllIll.getStrVsBlock(llllllllllllllllllIIIIlIllIlllll.getDefaultState()) > llllllllllllllllllIIIIlIllIllllI && llllllllllllllllllIIIIlIllIllIlI.getStrVsBlock(llllllllllllllllllIIIIlIllIlllll.getDefaultState()) <= llllllllllllllllllIIIIlIllIllllI) {
                llllllllllllllllllIIIIlIllIllllI = llllllllllllllllllIIIIlIllIllIll.getStrVsBlock(llllllllllllllllllIIIIlIllIlllll.getDefaultState());
                llllllllllllllllllIIIIlIllIlllIl = llllllllllllllllllIIIIlIllIlllII;
            }
        }
        if (llllllllllllllllllIIIIlIllIlllIl != -1) {
            AutoTool.mc.player.inventory.currentItem = llllllllllllllllllIIIIlIllIlllIl;
        }
    }
    
    public AutoTool() {
        super("AutoTool", 0, Category.MISC);
    }
}
