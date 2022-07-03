package me.nrules.module.player;

import me.nrules.notifications.*;
import me.nrules.module.*;
import java.util.*;
import me.nrules.*;
import clickui.settings.*;
import me.nrules.event.events.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.client.entity.*;
import me.nrules.event.*;

public class NoFall extends Module
{
    private /* synthetic */ Setting modeType;
    
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
    
    public NoFall() {
        super("NoFall", 0, Category.PLAYER);
        final ArrayList<String> lllllllllllllIIlllIIIIIllIIlIIII = new ArrayList<String>();
        lllllllllllllIIlllIIIIIllIIlIIII.add("Vanilla");
        lllllllllllllIIlllIIIIIllIIlIIII.add("Matrix");
        final SM settingsManager = Main.settingsManager;
        final Setting setting = new Setting("Mode", this, "Vanilla", lllllllllllllIIlllIIIIIllIIlIIII);
        this.modeType = setting;
        settingsManager.Property(setting);
    }
    
    @EventTarget
    public void EventSendPacket(final EventMove lllllllllllllIIlllIIIIIllIIIlIll) {
        if (this.modeType.getValString().equalsIgnoreCase("Matrix") && NoFall.mc.player.fallDistance > 3.0f) {
            NoFall.mc.player.connection.sendPacket(new CPacketPlayer.Position(NoFall.mc.player.posX, NoFall.mc.player.posY, NoFall.mc.player.posZ, true));
            final EntityPlayerSP player = NoFall.mc.player;
            player.motionY -= 0.6000000238418579;
        }
        if (this.modeType.getValString().equalsIgnoreCase("Vanilla") && NoFall.mc.player.fallDistance > 3.0f) {
            NoFall.mc.player.connection.sendPacket(new CPacketPlayer(true));
        }
    }
}
