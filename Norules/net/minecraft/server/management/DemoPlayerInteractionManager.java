package net.minecraft.server.management;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;

public class DemoPlayerInteractionManager extends PlayerInteractionManager
{
    private /* synthetic */ boolean displayedIntro;
    private /* synthetic */ int gameModeTicks;
    private /* synthetic */ boolean demoTimeExpired;
    private /* synthetic */ int demoEndedReminder;
    
    @Override
    public EnumActionResult processRightClickBlock(final EntityPlayer llllllllllllllIlIllllIIllIIIlIlI, final World llllllllllllllIlIllllIIlIlllllll, final ItemStack llllllllllllllIlIllllIIllIIIlIII, final EnumHand llllllllllllllIlIllllIIlIlllllIl, final BlockPos llllllllllllllIlIllllIIllIIIIllI, final EnumFacing llllllllllllllIlIllllIIllIIIIlIl, final float llllllllllllllIlIllllIIlIllllIlI, final float llllllllllllllIlIllllIIllIIIIIll, final float llllllllllllllIlIllllIIllIIIIIlI) {
        if (this.demoTimeExpired) {
            this.sendDemoReminder();
            return EnumActionResult.PASS;
        }
        return super.processRightClickBlock(llllllllllllllIlIllllIIllIIIlIlI, llllllllllllllIlIllllIIlIlllllll, llllllllllllllIlIllllIIllIIIlIII, llllllllllllllIlIllllIIlIlllllIl, llllllllllllllIlIllllIIllIIIIllI, llllllllllllllIlIllllIIllIIIIlIl, llllllllllllllIlIllllIIlIllllIlI, llllllllllllllIlIllllIIllIIIIIll, llllllllllllllIlIllllIIllIIIIIlI);
    }
    
    public DemoPlayerInteractionManager(final World llllllllllllllIlIllllIIlllIIlIII) {
        super(llllllllllllllIlIllllIIlllIIlIII);
    }
    
    @Override
    public EnumActionResult processRightClick(final EntityPlayer llllllllllllllIlIllllIIllIIllllI, final World llllllllllllllIlIllllIIllIIllIII, final ItemStack llllllllllllllIlIllllIIllIIlIlll, final EnumHand llllllllllllllIlIllllIIllIIlIllI) {
        if (this.demoTimeExpired) {
            this.sendDemoReminder();
            return EnumActionResult.PASS;
        }
        return super.processRightClick(llllllllllllllIlIllllIIllIIllllI, llllllllllllllIlIllllIIllIIllIII, llllllllllllllIlIllllIIllIIlIlll, llllllllllllllIlIllllIIllIIlIllI);
    }
    
    private void sendDemoReminder() {
        if (this.demoEndedReminder > 100) {
            this.thisPlayerMP.addChatMessage(new TextComponentTranslation("demo.reminder", new Object[0]));
            this.demoEndedReminder = 0;
        }
    }
    
    @Override
    public void blockRemoving(final BlockPos llllllllllllllIlIllllIIllIlIllIl) {
        if (!this.demoTimeExpired) {
            super.blockRemoving(llllllllllllllIlIllllIIllIlIllIl);
        }
    }
    
    @Override
    public void updateBlockRemoving() {
        super.updateBlockRemoving();
        ++this.gameModeTicks;
        final long llllllllllllllIlIllllIIlllIIIIIl = this.theWorld.getTotalWorldTime();
        final long llllllllllllllIlIllllIIlllIIIIII = llllllllllllllIlIllllIIlllIIIIIl / 24000L + 1L;
        if (!this.displayedIntro && this.gameModeTicks > 20) {
            this.displayedIntro = true;
            this.thisPlayerMP.connection.sendPacket(new SPacketChangeGameState(5, 0.0f));
        }
        this.demoTimeExpired = (llllllllllllllIlIllllIIlllIIIIIl > 120500L);
        if (this.demoTimeExpired) {
            ++this.demoEndedReminder;
        }
        if (llllllllllllllIlIllllIIlllIIIIIl % 24000L == 500L) {
            if (llllllllllllllIlIllllIIlllIIIIII <= 6L) {
                this.thisPlayerMP.addChatMessage(new TextComponentTranslation(String.valueOf(new StringBuilder("demo.day.").append(llllllllllllllIlIllllIIlllIIIIII)), new Object[0]));
            }
        }
        else if (llllllllllllllIlIllllIIlllIIIIII == 1L) {
            if (llllllllllllllIlIllllIIlllIIIIIl == 100L) {
                this.thisPlayerMP.connection.sendPacket(new SPacketChangeGameState(5, 101.0f));
            }
            else if (llllllllllllllIlIllllIIlllIIIIIl == 175L) {
                this.thisPlayerMP.connection.sendPacket(new SPacketChangeGameState(5, 102.0f));
            }
            else if (llllllllllllllIlIllllIIlllIIIIIl == 250L) {
                this.thisPlayerMP.connection.sendPacket(new SPacketChangeGameState(5, 103.0f));
            }
        }
        else if (llllllllllllllIlIllllIIlllIIIIII == 5L && llllllllllllllIlIllllIIlllIIIIIl % 24000L == 22000L) {
            this.thisPlayerMP.addChatMessage(new TextComponentTranslation("demo.day.warning", new Object[0]));
        }
    }
    
    @Override
    public void onBlockClicked(final BlockPos llllllllllllllIlIllllIIllIllIIlI, final EnumFacing llllllllllllllIlIllllIIllIllIIIl) {
        if (this.demoTimeExpired) {
            this.sendDemoReminder();
        }
        else {
            super.onBlockClicked(llllllllllllllIlIllllIIllIllIIlI, llllllllllllllIlIllllIIllIllIIIl);
        }
    }
    
    @Override
    public boolean tryHarvestBlock(final BlockPos llllllllllllllIlIllllIIllIlIIlIl) {
        return !this.demoTimeExpired && super.tryHarvestBlock(llllllllllllllIlIllllIIllIlIIlIl);
    }
}
