package net.minecraft.entity.monster;

import net.minecraft.network.datasync.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public abstract class AbstractIllager extends EntityMob
{
    protected static final /* synthetic */ DataParameter<Byte> field_193080_a;
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.ILLAGER;
    }
    
    public IllagerArmPose func_193077_p() {
        return IllagerArmPose.CROSSED;
    }
    
    static {
        field_193080_a = EntityDataManager.createKey(AbstractIllager.class, DataSerializers.BYTE);
    }
    
    protected boolean func_193078_a(final int llllllllllllllIIlIIllllIIlIIlllI) {
        final int llllllllllllllIIlIIllllIIlIIllIl = this.dataManager.get(AbstractIllager.field_193080_a);
        return (llllllllllllllIIlIIllllIIlIIllIl & llllllllllllllIIlIIllllIIlIIlllI) != 0x0;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(AbstractIllager.field_193080_a, (Byte)0);
    }
    
    public AbstractIllager(final World llllllllllllllIIlIIllllIIlIllIII) {
        super(llllllllllllllIIlIIllllIIlIllIII);
    }
    
    protected void func_193079_a(final int llllllllllllllIIlIIllllIIlIIIIII, final boolean llllllllllllllIIlIIllllIIlIIIIll) {
        int llllllllllllllIIlIIllllIIlIIIIlI = this.dataManager.get(AbstractIllager.field_193080_a);
        if (llllllllllllllIIlIIllllIIlIIIIll) {
            llllllllllllllIIlIIllllIIlIIIIlI |= llllllllllllllIIlIIllllIIlIIIIII;
        }
        else {
            llllllllllllllIIlIIllllIIlIIIIlI &= ~llllllllllllllIIlIIllllIIlIIIIII;
        }
        this.dataManager.set(AbstractIllager.field_193080_a, (byte)(llllllllllllllIIlIIllllIIlIIIIlI & 0xFF));
    }
    
    public enum IllagerArmPose
    {
        BOW_AND_ARROW("BOW_AND_ARROW", 3), 
        ATTACKING("ATTACKING", 1), 
        CROSSED("CROSSED", 0), 
        SPELLCASTING("SPELLCASTING", 2);
        
        private IllagerArmPose(final String llllllllllllllllllIlIlIlIllIlIlI, final int llllllllllllllllllIlIlIlIllIlIIl) {
        }
    }
}
