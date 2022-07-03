package me.nrules.module.misc;

import java.security.*;
import me.nrules.event.events.*;
import me.nrules.event.*;
import me.nrules.notifications.*;
import me.nrules.module.*;
import me.nrules.*;
import clickui.settings.*;

public class Spammer extends Module
{
    private /* synthetic */ Setting customMessage;
    private static final /* synthetic */ SecureRandom secureRandom;
    private /* synthetic */ Setting customString;
    /* synthetic */ String lastMessage;
    private /* synthetic */ Setting delay;
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllllIlIIlIIIlIlllIIIl) {
        if (this.customMessage.getValBoolean()) {
            if (Spammer.timerHelper.hasReached(this.delay.getValDouble())) {
                Spammer.mc.player.sendChatMessage(String.valueOf(new StringBuilder("![").append(Spammer.secureRandom.nextInt() / 10000000).append("] ").append(this.customString.getValString())));
                this.lastMessage = this.customString.getValString();
                Spammer.timerHelper.reset();
            }
        }
        else {
            final String[] lllllllllllllllIlIIlIIIlIlllIIII = { "i am your death.)", "you're going to die soon.", "i am the devil", "uf norules sex.", "u owned.", "retard blasted.", "too fucking easy.", "get best, get norules.", "lol, nice rainbowpaste.", "norules?.", "consider suicide.", "effortless.", "ez." };
            final String lllllllllllllllIlIIlIIIlIllIllll = lllllllllllllllIlIIlIIIlIlllIIII[Spammer.secureRandom.nextInt(lllllllllllllllIlIIlIIIlIlllIIII.length)];
            if (!this.lastMessage.equals(lllllllllllllllIlIIlIIIlIllIllll) && Spammer.timerHelper.hasReached(this.delay.getValDouble())) {
                Spammer.mc.player.sendChatMessage(String.valueOf(new StringBuilder("![").append(Spammer.secureRandom.nextInt() / 10000000).append("] ").append(lllllllllllllllIlIIlIIIlIllIllll)));
                this.lastMessage = lllllllllllllllIlIIlIIIlIllIllll;
                Spammer.timerHelper.reset();
            }
        }
    }
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    public Spammer() {
        super("Spammer", 0, Category.MISC);
        this.lastMessage = "";
        this.customMessage = new Setting("Custom Message", this, false);
        this.customString = new Setting("Custom", this, "NoRules on top!", "NoRules on top!");
        final SM settingsManager = Main.settingsManager;
        final Setting setting = new Setting("Delay", this, 3000.0, 500.0, 20000.0, true);
        this.delay = setting;
        settingsManager.Property(setting);
        Spammer.sm.Property(this.customMessage);
        Spammer.sm.Property(this.customString);
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    static {
        secureRandom = new SecureRandom();
    }
}
