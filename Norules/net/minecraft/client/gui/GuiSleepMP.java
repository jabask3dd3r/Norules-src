package net.minecraft.client.gui;

import net.minecraft.network.play.client.*;
import net.minecraft.entity.*;
import net.minecraft.network.*;
import net.minecraft.client.network.*;
import net.minecraft.client.resources.*;
import java.io.*;

public class GuiSleepMP extends GuiChat
{
    private void wakeFromSleep() {
        final NetHandlerPlayClient lllllllllllllIllIIllIllIIlIlIlll = this.mc.player.connection;
        lllllllllllllIllIIllIllIIlIlIlll.sendPacket(new CPacketEntityAction(this.mc.player, CPacketEntityAction.Action.STOP_SLEEPING));
    }
    
    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height - 40, I18n.format("multiplayer.stopSleeping", new Object[0])));
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIllIIllIllIIlIlllIl) throws IOException {
        if (lllllllllllllIllIIllIllIIlIlllIl.id == 1) {
            this.wakeFromSleep();
        }
        else {
            super.actionPerformed(lllllllllllllIllIIllIllIIlIlllIl);
        }
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllIllIIllIllIIllIIlll, final int lllllllllllllIllIIllIllIIllIIllI) throws IOException {
        if (lllllllllllllIllIIllIllIIllIIllI == 1) {
            this.wakeFromSleep();
        }
        else if (lllllllllllllIllIIllIllIIllIIllI != 28 && lllllllllllllIllIIllIllIIllIIllI != 156) {
            super.keyTyped(lllllllllllllIllIIllIllIIllIIlll, lllllllllllllIllIIllIllIIllIIllI);
        }
        else {
            final String lllllllllllllIllIIllIllIIllIIlIl = this.inputField.getText().trim();
            if (!lllllllllllllIllIIllIllIIllIIlIl.isEmpty()) {
                this.mc.player.sendChatMessage(lllllllllllllIllIIllIllIIllIIlIl);
            }
            this.inputField.setText("");
            this.mc.ingameGUI.getChatGUI().resetScroll();
        }
    }
}
