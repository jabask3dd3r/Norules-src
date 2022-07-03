package net.minecraft.util;

import net.minecraft.client.settings.*;

public class MovementInputFromOptions extends MovementInput
{
    private final /* synthetic */ GameSettings gameSettings;
    
    @Override
    public void updatePlayerMoveState() {
        MovementInputFromOptions.moveStrafe = 0.0f;
        this.field_192832_b = 0.0f;
        if (this.gameSettings.keyBindForward.isKeyDown()) {
            ++this.field_192832_b;
            this.forwardKeyDown = true;
        }
        else {
            this.forwardKeyDown = false;
        }
        if (this.gameSettings.keyBindBack.isKeyDown()) {
            --this.field_192832_b;
            this.backKeyDown = true;
        }
        else {
            this.backKeyDown = false;
        }
        if (this.gameSettings.keyBindLeft.isKeyDown()) {
            ++MovementInputFromOptions.moveStrafe;
            this.leftKeyDown = true;
        }
        else {
            this.leftKeyDown = false;
        }
        if (this.gameSettings.keyBindRight.isKeyDown()) {
            --MovementInputFromOptions.moveStrafe;
            this.rightKeyDown = true;
        }
        else {
            this.rightKeyDown = false;
        }
        this.jump = this.gameSettings.keyBindJump.isKeyDown();
        this.sneak = this.gameSettings.keyBindSneak.isKeyDown();
        if (this.sneak) {
            MovementInputFromOptions.moveStrafe *= (float)0.3;
            this.field_192832_b *= (float)0.3;
        }
    }
    
    public MovementInputFromOptions(final GameSettings lllllllllllllIIlIIIlIIlIIlllllIl) {
        this.gameSettings = lllllllllllllIIlIIIlIIlIIlllllIl;
    }
}
