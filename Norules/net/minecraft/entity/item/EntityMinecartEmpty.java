package net.minecraft.entity.item;

import net.minecraft.util.datafix.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityMinecartEmpty extends EntityMinecart
{
    @Override
    public Type getType() {
        return Type.RIDEABLE;
    }
    
    public static void registerFixesMinecartEmpty(final DataFixer lllllllllllllIlllllIlllllllIIllI) {
        EntityMinecart.registerFixesMinecart(lllllllllllllIlllllIlllllllIIllI, EntityMinecartEmpty.class);
    }
    
    @Override
    public void onActivatorRailPass(final int lllllllllllllIlllllIllllllIllIll, final int lllllllllllllIlllllIllllllIllIlI, final int lllllllllllllIlllllIllllllIllIIl, final boolean lllllllllllllIlllllIllllllIlIllI) {
        if (lllllllllllllIlllllIllllllIlIllI) {
            if (this.isBeingRidden()) {
                this.removePassengers();
            }
            if (this.getRollingAmplitude() == 0) {
                this.setRollingDirection(-this.getRollingDirection());
                this.setRollingAmplitude(10);
                this.setDamage(50.0f);
                this.setBeenAttacked();
            }
        }
    }
    
    public EntityMinecartEmpty(final World lllllllllllllIlllllIlllllllllIII) {
        super(lllllllllllllIlllllIlllllllllIII);
    }
    
    @Override
    public boolean processInitialInteract(final EntityPlayer lllllllllllllIlllllIllllllIlllll, final EnumHand lllllllllllllIlllllIlllllllIIIIl) {
        if (lllllllllllllIlllllIllllllIlllll.isSneaking()) {
            return false;
        }
        if (this.isBeingRidden()) {
            return true;
        }
        if (!this.world.isRemote) {
            lllllllllllllIlllllIllllllIlllll.startRiding(this);
        }
        return true;
    }
    
    public EntityMinecartEmpty(final World lllllllllllllIlllllIllllllllIIIl, final double lllllllllllllIlllllIlllllllIlIll, final double lllllllllllllIlllllIlllllllIlIlI, final double lllllllllllllIlllllIlllllllIlIIl) {
        super(lllllllllllllIlllllIllllllllIIIl, lllllllllllllIlllllIlllllllIlIll, lllllllllllllIlllllIlllllllIlIlI, lllllllllllllIlllllIlllllllIlIIl);
    }
}
