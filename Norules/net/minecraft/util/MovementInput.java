package net.minecraft.util;

import net.minecraft.util.math.*;

public class MovementInput
{
    public static /* synthetic */ float moveStrafe;
    public /* synthetic */ float field_192832_b;
    
    public void updatePlayerMoveState() {
    }
    
    public Vec2f getMoveVector() {
        return new Vec2f(MovementInput.moveStrafe, this.field_192832_b);
    }
}
