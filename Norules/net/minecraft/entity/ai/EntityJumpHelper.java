package net.minecraft.entity.ai;

import net.minecraft.entity.*;

public class EntityJumpHelper
{
    private final /* synthetic */ EntityLiving entity;
    protected /* synthetic */ boolean isJumping;
    
    public EntityJumpHelper(final EntityLiving lllllllllllllIIllIllIIIIIlIIIllI) {
        this.entity = lllllllllllllIIllIllIIIIIlIIIllI;
    }
    
    public void doJump() {
        this.entity.setJumping(this.isJumping);
        this.isJumping = false;
    }
    
    public void setJumping() {
        this.isJumping = true;
    }
}
