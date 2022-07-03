package net.minecraft.entity.passive;

import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public abstract class EntityShoulderRiding extends EntityTameable
{
    private /* synthetic */ int field_191996_bB;
    
    public boolean func_191994_f(final EntityPlayer llllllllllllllllIIllIlllIIllIIlI) {
        final NBTTagCompound llllllllllllllllIIllIlllIIllIlII = new NBTTagCompound();
        llllllllllllllllIIllIlllIIllIlII.setString("id", this.getEntityString());
        this.writeToNBT(llllllllllllllllIIllIlllIIllIlII);
        if (llllllllllllllllIIllIlllIIllIIlI.func_192027_g(llllllllllllllllIIllIlllIIllIlII)) {
            this.world.removeEntity(this);
            return true;
        }
        return false;
    }
    
    public EntityShoulderRiding(final World llllllllllllllllIIllIlllIIllllII) {
        super(llllllllllllllllIIllIlllIIllllII);
    }
    
    public boolean func_191995_du() {
        return this.field_191996_bB > 100;
    }
    
    @Override
    public void onUpdate() {
        ++this.field_191996_bB;
        super.onUpdate();
    }
}
