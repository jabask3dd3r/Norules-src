package me.nrules.module.movement;

import me.nrules.notifications.*;
import me.nrules.module.*;
import me.nrules.event.events.*;
import net.minecraft.client.gui.*;
import org.lwjgl.input.*;
import me.nrules.event.*;

public class GuiWalk extends Module
{
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        GuiWalk.mc.gameSettings.keyBindJump.pressed = false;
        GuiWalk.mc.gameSettings.keyBindForward.pressed = false;
        GuiWalk.mc.gameSettings.keyBindBack.pressed = false;
        GuiWalk.mc.gameSettings.keyBindLeft.pressed = false;
        GuiWalk.mc.gameSettings.keyBindRight.pressed = false;
        GuiWalk.mc.gameSettings.keyBindSneak.pressed = false;
        GuiWalk.mc.gameSettings.keyBindSprint.pressed = false;
        super.onDisable();
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    public GuiWalk() {
        super("GuiMove", 0, Category.MOVEMENT);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllIllIIIlllllIIIllIll) {
        if (!(GuiWalk.mc.currentScreen instanceof GuiChat)) {
            GuiWalk.mc.gameSettings.keyBindJump.pressed = Keyboard.isKeyDown(GuiWalk.mc.gameSettings.keyBindJump.getKeyCode());
            GuiWalk.mc.gameSettings.keyBindForward.pressed = Keyboard.isKeyDown(GuiWalk.mc.gameSettings.keyBindForward.getKeyCode());
            GuiWalk.mc.gameSettings.keyBindBack.pressed = Keyboard.isKeyDown(GuiWalk.mc.gameSettings.keyBindBack.getKeyCode());
            GuiWalk.mc.gameSettings.keyBindLeft.pressed = Keyboard.isKeyDown(GuiWalk.mc.gameSettings.keyBindLeft.getKeyCode());
            GuiWalk.mc.gameSettings.keyBindRight.pressed = Keyboard.isKeyDown(GuiWalk.mc.gameSettings.keyBindRight.getKeyCode());
            GuiWalk.mc.gameSettings.keyBindSneak.pressed = Keyboard.isKeyDown(GuiWalk.mc.gameSettings.keyBindSneak.getKeyCode());
            GuiWalk.mc.gameSettings.keyBindSprint.pressed = Keyboard.isKeyDown(GuiWalk.mc.gameSettings.keyBindSprint.getKeyCode());
        }
    }
}
