package me.nrules.module.misc;

import me.nrules.event.events.*;
import net.minecraft.network.play.server.*;
import me.nrules.*;
import me.nrules.event.*;
import me.nrules.notifications.*;
import me.nrules.module.*;

public class AutoLogin extends Module
{
    @EventTarget
    public void onChat(final EventReceivePacket lllllllllllllllIIIIIlIllIIIIlIII) {
        if (lllllllllllllllIIIIIlIllIIIIlIII.getPacket() instanceof SPacketChat) {
            if (((SPacketChat)lllllllllllllllIIIIIlIllIIIIlIII.getPacket()).getChatComponent().getUnformattedText().contains("/reg") || ((SPacketChat)lllllllllllllllIIIIIlIllIIIIlIII.getPacket()).getChatComponent().getUnformattedText().contains("/register")) {
                if (AutoLogin.timerHelper.hasReached(100.0)) {
                    AutoLogin.timerHelper.reset();
                    AutoLogin.mc.player.sendChatMessage("/reg A12345555 A12345555");
                    Main.msg("Your account password: A12345555");
                }
            }
            else if (((SPacketChat)lllllllllllllllIIIIIlIllIIIIlIII.getPacket()).getChatComponent().getUnformattedText().contains("/l")) {
                AutoLogin.mc.player.sendChatMessage("/login A12345555");
            }
        }
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    public AutoLogin() {
        super("AutoLogin", 0, Category.MISC);
    }
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
}
