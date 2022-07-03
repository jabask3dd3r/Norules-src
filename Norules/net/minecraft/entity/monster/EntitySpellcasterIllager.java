package net.minecraft.entity.monster;

import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.network.datasync.*;
import net.minecraft.entity.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.ai.*;
import javax.annotation.*;

public abstract class EntitySpellcasterIllager extends AbstractIllager
{
    private static final /* synthetic */ DataParameter<Byte> field_193088_c;
    private /* synthetic */ SpellType field_193089_bx;
    protected /* synthetic */ int field_193087_b;
    
    protected abstract SoundEvent func_193086_dk();
    
    public void func_193081_a(final SpellType lllllllllllllIlIIllIIIIIllIIlIIl) {
        this.field_193089_bx = lllllllllllllIlIIllIIIIIllIIlIIl;
        this.dataManager.set(EntitySpellcasterIllager.field_193088_c, (byte)lllllllllllllIlIIllIIIIIllIIlIIl.field_193345_g);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIlIIllIIIIIllIlllIl) {
        super.readEntityFromNBT(lllllllllllllIlIIllIIIIIllIlllIl);
        this.field_193087_b = lllllllllllllIlIIllIIIIIllIlllIl.getInteger("SpellTicks");
    }
    
    @Override
    public IllagerArmPose func_193077_p() {
        return this.func_193082_dl() ? IllagerArmPose.SPELLCASTING : IllagerArmPose.CROSSED;
    }
    
    public boolean func_193082_dl() {
        if (this.world.isRemote) {
            return this.dataManager.get(EntitySpellcasterIllager.field_193088_c) > 0;
        }
        return this.field_193087_b > 0;
    }
    
    @Override
    protected void updateAITasks() {
        super.updateAITasks();
        if (this.field_193087_b > 0) {
            --this.field_193087_b;
        }
    }
    
    protected SpellType func_193083_dm() {
        return this.world.isRemote ? SpellType.func_193337_a(this.dataManager.get(EntitySpellcasterIllager.field_193088_c)) : this.field_193089_bx;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIlIIllIIIIIllIlIlIl) {
        super.writeEntityToNBT(lllllllllllllIlIIllIIIIIllIlIlIl);
        lllllllllllllIlIIllIIIIIllIlIlIl.setInteger("SpellTicks", this.field_193087_b);
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.world.isRemote && this.func_193082_dl()) {
            final SpellType lllllllllllllIlIIllIIIIIlIlllIIl = this.func_193083_dm();
            final double lllllllllllllIlIIllIIIIIlIlllIII = lllllllllllllIlIIllIIIIIlIlllIIl.field_193346_h[0];
            final double lllllllllllllIlIIllIIIIIlIllIlll = lllllllllllllIlIIllIIIIIlIlllIIl.field_193346_h[1];
            final double lllllllllllllIlIIllIIIIIlIllIllI = lllllllllllllIlIIllIIIIIlIlllIIl.field_193346_h[2];
            final float lllllllllllllIlIIllIIIIIlIllIlIl = this.renderYawOffset * 0.017453292f + MathHelper.cos(this.ticksExisted * 0.6662f) * 0.25f;
            final float lllllllllllllIlIIllIIIIIlIllIlII = MathHelper.cos(lllllllllllllIlIIllIIIIIlIllIlIl);
            final float lllllllllllllIlIIllIIIIIlIllIIll = MathHelper.sin(lllllllllllllIlIIllIIIIIlIllIlIl);
            this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, this.posX + lllllllllllllIlIIllIIIIIlIllIlII * 0.6, this.posY + 1.8, this.posZ + lllllllllllllIlIIllIIIIIlIllIIll * 0.6, lllllllllllllIlIIllIIIIIlIlllIII, lllllllllllllIlIIllIIIIIlIllIlll, lllllllllllllIlIIllIIIIIlIllIllI, new int[0]);
            this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, this.posX - lllllllllllllIlIIllIIIIIlIllIlII * 0.6, this.posY + 1.8, this.posZ - lllllllllllllIlIIllIIIIIlIllIIll * 0.6, lllllllllllllIlIIllIIIIIlIlllIII, lllllllllllllIlIIllIIIIIlIllIlll, lllllllllllllIlIIllIIIIIlIllIllI, new int[0]);
        }
    }
    
    public EntitySpellcasterIllager(final World lllllllllllllIlIIllIIIIIlllIIlII) {
        super(lllllllllllllIlIIllIIIIIlllIIlII);
        this.field_193089_bx = SpellType.NONE;
    }
    
    static {
        field_193088_c = EntityDataManager.createKey(EntitySpellcasterIllager.class, DataSerializers.BYTE);
    }
    
    protected int func_193085_dn() {
        return this.field_193087_b;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntitySpellcasterIllager.field_193088_c, (Byte)0);
    }
    
    public abstract class AIUseSpell extends EntityAIBase
    {
        protected /* synthetic */ int field_193322_d;
        protected /* synthetic */ int field_193321_c;
        
        @Override
        public boolean continueExecuting() {
            return EntitySpellcasterIllager.this.getAttackTarget() != null && this.field_193321_c > 0;
        }
        
        protected abstract SpellType func_193320_l();
        
        @Override
        public void updateTask() {
            --this.field_193321_c;
            if (this.field_193321_c == 0) {
                this.func_190868_j();
                EntitySpellcasterIllager.this.playSound(EntitySpellcasterIllager.this.func_193086_dk(), 1.0f, 1.0f);
            }
        }
        
        @Nullable
        protected abstract SoundEvent func_190871_k();
        
        @Override
        public boolean shouldExecute() {
            return EntitySpellcasterIllager.this.getAttackTarget() != null && !EntitySpellcasterIllager.this.func_193082_dl() && EntitySpellcasterIllager.this.ticksExisted >= this.field_193322_d;
        }
        
        protected int func_190867_m() {
            return 20;
        }
        
        @Override
        public void startExecuting() {
            this.field_193321_c = this.func_190867_m();
            EntitySpellcasterIllager.this.field_193087_b = this.func_190869_f();
            this.field_193322_d = EntitySpellcasterIllager.this.ticksExisted + this.func_190872_i();
            final SoundEvent lllllllllllllIIIIIIlIlIIllIIllII = this.func_190871_k();
            if (lllllllllllllIIIIIIlIlIIllIIllII != null) {
                EntitySpellcasterIllager.this.playSound(lllllllllllllIIIIIIlIlIIllIIllII, 1.0f, 1.0f);
            }
            EntitySpellcasterIllager.this.func_193081_a(this.func_193320_l());
        }
        
        protected abstract int func_190869_f();
        
        protected abstract int func_190872_i();
        
        protected abstract void func_190868_j();
    }
    
    public enum SpellType
    {
        DISAPPEAR("DISAPPEAR", 4, 4, 0.3, 0.3, 0.8), 
        SUMMON_VEX("SUMMON_VEX", 1, 1, 0.7, 0.7, 0.8);
        
        private final /* synthetic */ double[] field_193346_h;
        
        FANGS("FANGS", 2, 2, 0.4, 0.3, 0.35), 
        BLINDNESS("BLINDNESS", 5, 5, 0.1, 0.1, 0.2), 
        NONE("NONE", 0, 0, 0.0, 0.0, 0.0), 
        WOLOLO("WOLOLO", 3, 3, 0.7, 0.5, 0.2);
        
        private final /* synthetic */ int field_193345_g;
        
        private SpellType(final String lllllllllllllllIllIlllIIIllIllIl, final int lllllllllllllllIllIlllIIIllIlIll, final int lllllllllllllllIllIlllIIIllIlIIl, final double lllllllllllllllIllIlllIIIlllIlII, final double lllllllllllllllIllIlllIIIlllIIlI, final double lllllllllllllllIllIlllIIIllIIIll) {
            this.field_193345_g = lllllllllllllllIllIlllIIIllIlIIl;
            this.field_193346_h = new double[] { lllllllllllllllIllIlllIIIlllIlII, lllllllllllllllIllIlllIIIlllIIlI, lllllllllllllllIllIlllIIIllIIIll };
        }
        
        public static SpellType func_193337_a(final int lllllllllllllllIllIlllIIIlIlIIII) {
            final int lllllllllllllllIllIlllIIIlIIIlll;
            final int lllllllllllllllIllIlllIIIlIIlIII = ((SpellType[])(Object)(lllllllllllllllIllIlllIIIlIIIlll = (int)(Object)values())).length;
            for (Exception lllllllllllllllIllIlllIIIlIIlIIl = (Exception)0; lllllllllllllllIllIlllIIIlIIlIIl < lllllllllllllllIllIlllIIIlIIlIII; ++lllllllllllllllIllIlllIIIlIIlIIl) {
                final SpellType lllllllllllllllIllIlllIIIlIIlllI = lllllllllllllllIllIlllIIIlIIIlll[lllllllllllllllIllIlllIIIlIIlIIl];
                if (lllllllllllllllIllIlllIIIlIlIIII == lllllllllllllllIllIlllIIIlIIlllI.field_193345_g) {
                    return lllllllllllllllIllIlllIIIlIIlllI;
                }
            }
            return SpellType.NONE;
        }
    }
    
    public class AICastingApell extends EntityAIBase
    {
        public AICastingApell() {
            this.setMutexBits(3);
        }
        
        @Override
        public boolean shouldExecute() {
            return EntitySpellcasterIllager.this.func_193085_dn() > 0;
        }
        
        @Override
        public void updateTask() {
            if (EntitySpellcasterIllager.this.getAttackTarget() != null) {
                EntitySpellcasterIllager.this.getLookHelper().setLookPositionWithEntity(EntitySpellcasterIllager.this.getAttackTarget(), (float)EntitySpellcasterIllager.this.getHorizontalFaceSpeed(), (float)EntitySpellcasterIllager.this.getVerticalFaceSpeed());
            }
        }
        
        @Override
        public void resetTask() {
            super.resetTask();
            EntitySpellcasterIllager.this.func_193081_a(SpellType.NONE);
        }
        
        @Override
        public void startExecuting() {
            super.startExecuting();
            EntitySpellcasterIllager.this.navigator.clearPathEntity();
        }
    }
}
