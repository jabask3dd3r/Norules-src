package net.minecraft.entity.player;

import net.minecraft.nbt.*;

public class PlayerCapabilities
{
    public /* synthetic */ boolean isFlying;
    public /* synthetic */ boolean allowEdit;
    public /* synthetic */ boolean disableDamage;
    public /* synthetic */ boolean isCreativeMode;
    public /* synthetic */ boolean allowFlying;
    public /* synthetic */ float flySpeed;
    private /* synthetic */ float walkSpeed;
    
    public PlayerCapabilities() {
        this.allowEdit = true;
        this.flySpeed = 0.05f;
        this.walkSpeed = 0.1f;
    }
    
    public float getFlySpeed() {
        return this.flySpeed;
    }
    
    public void readCapabilitiesFromNBT(final NBTTagCompound llllllllllllllIllIIIIIlIIlllIlII) {
        if (llllllllllllllIllIIIIIlIIlllIlII.hasKey("abilities", 10)) {
            final NBTTagCompound llllllllllllllIllIIIIIlIIlllIllI = llllllllllllllIllIIIIIlIIlllIlII.getCompoundTag("abilities");
            this.disableDamage = llllllllllllllIllIIIIIlIIlllIllI.getBoolean("invulnerable");
            this.isFlying = llllllllllllllIllIIIIIlIIlllIllI.getBoolean("flying");
            this.allowFlying = llllllllllllllIllIIIIIlIIlllIllI.getBoolean("mayfly");
            this.isCreativeMode = llllllllllllllIllIIIIIlIIlllIllI.getBoolean("instabuild");
            if (llllllllllllllIllIIIIIlIIlllIllI.hasKey("flySpeed", 99)) {
                this.flySpeed = llllllllllllllIllIIIIIlIIlllIllI.getFloat("flySpeed");
                this.walkSpeed = llllllllllllllIllIIIIIlIIlllIllI.getFloat("walkSpeed");
            }
            if (llllllllllllllIllIIIIIlIIlllIllI.hasKey("mayBuild", 1)) {
                this.allowEdit = llllllllllllllIllIIIIIlIIlllIllI.getBoolean("mayBuild");
            }
        }
    }
    
    public void setPlayerWalkSpeed(final float llllllllllllllIllIIIIIlIIllIIIIl) {
        this.walkSpeed = llllllllllllllIllIIIIIlIIllIIIIl;
    }
    
    public void writeCapabilitiesToNBT(final NBTTagCompound llllllllllllllIllIIIIIlIIlllllIl) {
        final NBTTagCompound llllllllllllllIllIIIIIlIIlllllll = new NBTTagCompound();
        llllllllllllllIllIIIIIlIIlllllll.setBoolean("invulnerable", this.disableDamage);
        llllllllllllllIllIIIIIlIIlllllll.setBoolean("flying", this.isFlying);
        llllllllllllllIllIIIIIlIIlllllll.setBoolean("mayfly", this.allowFlying);
        llllllllllllllIllIIIIIlIIlllllll.setBoolean("instabuild", this.isCreativeMode);
        llllllllllllllIllIIIIIlIIlllllll.setBoolean("mayBuild", this.allowEdit);
        llllllllllllllIllIIIIIlIIlllllll.setFloat("flySpeed", this.flySpeed);
        llllllllllllllIllIIIIIlIIlllllll.setFloat("walkSpeed", this.walkSpeed);
        llllllllllllllIllIIIIIlIIlllllIl.setTag("abilities", llllllllllllllIllIIIIIlIIlllllll);
    }
    
    public void setFlySpeed(final float llllllllllllllIllIIIIIlIIllIlIlI) {
        this.flySpeed = llllllllllllllIllIIIIIlIIllIlIlI;
    }
    
    public float getWalkSpeed() {
        return this.walkSpeed;
    }
}
