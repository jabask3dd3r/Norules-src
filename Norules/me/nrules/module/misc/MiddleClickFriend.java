package me.nrules.module.misc;

import me.nrules.module.*;
import me.nrules.event.events.*;
import net.minecraft.entity.player.*;
import me.nrules.utils.friend.*;
import com.mojang.realmsclient.gui.*;
import me.nrules.*;
import me.nrules.event.*;

public class MiddleClickFriend extends Module
{
    public MiddleClickFriend() {
        super("MiddleClickFriend", 0, Category.MISC);
    }
    
    @EventTarget
    public void onMouseEvent(final EventMouse lllllIIlIllIlI) {
        if (lllllIIlIllIlI.key == 2 && MiddleClickFriend.mc.objectMouseOver.entityHit != null && MiddleClickFriend.mc.objectMouseOver.entityHit instanceof EntityPlayer) {
            final EntityPlayer lllllIIlIllIIl = (EntityPlayer)MiddleClickFriend.mc.objectMouseOver.entityHit;
            if (FriendManager.isFriend(lllllIIlIllIIl.getName())) {
                FriendManager.addFriend(lllllIIlIllIIl.getName(), lllllIIlIllIIl.getName());
                Main.msg(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append(lllllIIlIllIIl.getName()).append(ChatFormatting.WHITE).append(" was removed from your friends list.")));
            }
            else {
                FriendManager.addFriend(lllllIIlIllIIl.getName(), lllllIIlIllIIl.getName());
                Main.msg(String.valueOf(new StringBuilder().append(ChatFormatting.GREEN).append(lllllIIlIllIIl.getName()).append(ChatFormatting.WHITE).append(" added to your friend list.")));
            }
        }
    }
}
