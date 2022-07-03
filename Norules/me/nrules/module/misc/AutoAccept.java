package me.nrules.module.misc;

import net.minecraft.entity.*;
import me.nrules.event.events.*;
import net.minecraft.network.play.server.*;
import me.nrules.utils.friend.*;
import me.nrules.event.*;
import me.nrules.module.*;

public class AutoAccept extends Module
{
    @EventTarget
    public void onChat(final EventReceivePacket llllllllllllllIIlIlIlIIIlllllIlI) {
        if (llllllllllllllIIlIlIlIIIlllllIlI.getPacket() instanceof SPacketChat) {
            for (final FriendManager.Friend llllllllllllllIIlIlIlIIIlllllIll : FriendManager.friends) {
                if (((SPacketChat)llllllllllllllIIlIlIlIIIlllllIlI.getPacket()).getChatComponent().getUnformattedText().contains(llllllllllllllIIlIlIlIIIlllllIll.getName())) {
                    AutoAccept.mc.player.sendChatMessage("/tpaccept");
                }
            }
        }
    }
    
    public AutoAccept() {
        super("AutoAccept", 0, Category.MISC);
    }
}
