package net.minecraft.entity;

import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import javax.annotation.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.network.datasync.*;

public abstract class EntityAgeable extends EntityCreature
{
    protected /* synthetic */ int forcedAge;
    protected /* synthetic */ int forcedAgeTimer;
    protected /* synthetic */ int growingAge;
    private /* synthetic */ float ageHeight;
    private static final /* synthetic */ DataParameter<Boolean> BABY;
    private /* synthetic */ float ageWidth;
    
    public void addGrowth(final int lllllllllllllIllIIlIIlIIIIIIlIll) {
        this.ageUp(lllllllllllllIllIIlIIlIIIIIIlIll, false);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIllIIlIIIlllllllIIl) {
        super.readEntityFromNBT(lllllllllllllIllIIlIIIlllllllIIl);
        this.setGrowingAge(lllllllllllllIllIIlIIIlllllllIIl.getInteger("Age"));
        this.forcedAge = lllllllllllllIllIIlIIIlllllllIIl.getInteger("ForcedAge");
    }
    
    @Override
    public void notifyDataManagerChange(final DataParameter<?> lllllllllllllIllIIlIIIllllllIlIl) {
        if (EntityAgeable.BABY.equals(lllllllllllllIllIIlIIIllllllIlIl)) {
            this.setScaleForAge(this.isChild());
        }
        super.notifyDataManagerChange(lllllllllllllIllIIlIIIllllllIlIl);
    }
    
    public void setGrowingAge(final int lllllllllllllIllIIlIIlIIIIIIIlIl) {
        this.dataManager.set(EntityAgeable.BABY, lllllllllllllIllIIlIIlIIIIIIIlIl < 0);
        this.growingAge = lllllllllllllIllIIlIIlIIIIIIIlIl;
        this.setScaleForAge(this.isChild());
    }
    
    public void setScaleForAge(final boolean lllllllllllllIllIIlIIIlllllIIlIl) {
        this.setScale(lllllllllllllIllIIlIIIlllllIIlIl ? 0.5f : 1.0f);
    }
    
    public boolean processInteract(final EntityPlayer lllllllllllllIllIIlIIlIIIIllIlll, final EnumHand lllllllllllllIllIIlIIlIIIIllllII) {
        final ItemStack lllllllllllllIllIIlIIlIIIIlllIll = lllllllllllllIllIIlIIlIIIIllIlll.getHeldItem(lllllllllllllIllIIlIIlIIIIllllII);
        if (lllllllllllllIllIIlIIlIIIIlllIll.getItem() == Items.SPAWN_EGG) {
            if (!this.world.isRemote) {
                final Class<? extends Entity> lllllllllllllIllIIlIIlIIIIlllIlI = EntityList.field_191308_b.getObject(ItemMonsterPlacer.func_190908_h(lllllllllllllIllIIlIIlIIIIlllIll));
                if (lllllllllllllIllIIlIIlIIIIlllIlI != null && this.getClass() == lllllllllllllIllIIlIIlIIIIlllIlI) {
                    final EntityAgeable lllllllllllllIllIIlIIlIIIIlllIIl = this.createChild(this);
                    if (lllllllllllllIllIIlIIlIIIIlllIIl != null) {
                        lllllllllllllIllIIlIIlIIIIlllIIl.setGrowingAge(-24000);
                        lllllllllllllIllIIlIIlIIIIlllIIl.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
                        this.world.spawnEntityInWorld(lllllllllllllIllIIlIIlIIIIlllIIl);
                        if (lllllllllllllIllIIlIIlIIIIlllIll.hasDisplayName()) {
                            lllllllllllllIllIIlIIlIIIIlllIIl.setCustomNameTag(lllllllllllllIllIIlIIlIIIIlllIll.getDisplayName());
                        }
                        if (!lllllllllllllIllIIlIIlIIIIllIlll.capabilities.isCreativeMode) {
                            lllllllllllllIllIIlIIlIIIIlllIll.func_190918_g(1);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIllIIlIIIllllllllll) {
        super.writeEntityToNBT(lllllllllllllIllIIlIIIllllllllll);
        lllllllllllllIllIIlIIIllllllllll.setInteger("Age", this.getGrowingAge());
        lllllllllllllIllIIlIIIllllllllll.setInteger("ForcedAge", this.forcedAge);
    }
    
    public int getGrowingAge() {
        if (this.world.isRemote) {
            return this.dataManager.get(EntityAgeable.BABY) ? -1 : 1;
        }
        return this.growingAge;
    }
    
    @Override
    public boolean isChild() {
        return this.getGrowingAge() < 0;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityAgeable.BABY, false);
    }
    
    @Nullable
    public abstract EntityAgeable createChild(final EntityAgeable p0);
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.world.isRemote) {
            if (this.forcedAgeTimer > 0) {
                if (this.forcedAgeTimer % 4 == 0) {
                    this.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + 0.5 + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, 0.0, 0.0, 0.0, new int[0]);
                }
                --this.forcedAgeTimer;
            }
        }
        else {
            int lllllllllllllIllIIlIIIlllllIllll = this.getGrowingAge();
            if (lllllllllllllIllIIlIIIlllllIllll < 0) {
                ++lllllllllllllIllIIlIIIlllllIllll;
                this.setGrowingAge(lllllllllllllIllIIlIIIlllllIllll);
                if (lllllllllllllIllIIlIIIlllllIllll == 0) {
                    this.onGrowingAdult();
                }
            }
            else if (lllllllllllllIllIIlIIIlllllIllll > 0) {
                --lllllllllllllIllIIlIIIlllllIllll;
                this.setGrowingAge(lllllllllllllIllIIlIIIlllllIllll);
            }
        }
    }
    
    public void ageUp(final int lllllllllllllIllIIlIIlIIIIIlIlIl, final boolean lllllllllllllIllIIlIIlIIIIIllIlI) {
        final int lllllllllllllIllIIlIIlIIIIIllIII;
        int lllllllllllllIllIIlIIlIIIIIllIIl = lllllllllllllIllIIlIIlIIIIIllIII = this.getGrowingAge();
        lllllllllllllIllIIlIIlIIIIIllIIl += lllllllllllllIllIIlIIlIIIIIlIlIl * 20;
        if (lllllllllllllIllIIlIIlIIIIIllIIl > 0) {
            lllllllllllllIllIIlIIlIIIIIllIIl = 0;
            if (lllllllllllllIllIIlIIlIIIIIllIII < 0) {
                this.onGrowingAdult();
            }
        }
        final int lllllllllllllIllIIlIIlIIIIIlIlll = lllllllllllllIllIIlIIlIIIIIllIIl - lllllllllllllIllIIlIIlIIIIIllIII;
        this.setGrowingAge(lllllllllllllIllIIlIIlIIIIIllIIl);
        if (lllllllllllllIllIIlIIlIIIIIllIlI) {
            this.forcedAge += lllllllllllllIllIIlIIlIIIIIlIlll;
            if (this.forcedAgeTimer == 0) {
                this.forcedAgeTimer = 40;
            }
        }
        if (this.getGrowingAge() == 0) {
            this.setGrowingAge(this.forcedAge);
        }
    }
    
    protected boolean func_190669_a(final ItemStack lllllllllllllIllIIlIIlIIIIlIlIll, final Class<? extends Entity> lllllllllllllIllIIlIIlIIIIlIlIlI) {
        if (lllllllllllllIllIIlIIlIIIIlIlIll.getItem() != Items.SPAWN_EGG) {
            return false;
        }
        final Class<? extends Entity> lllllllllllllIllIIlIIlIIIIlIllII = EntityList.field_191308_b.getObject(ItemMonsterPlacer.func_190908_h(lllllllllllllIllIIlIIlIIIIlIlIll));
        return lllllllllllllIllIIlIIlIIIIlIllII != null && lllllllllllllIllIIlIIlIIIIlIlIlI == lllllllllllllIllIIlIIlIIIIlIllII;
    }
    
    public EntityAgeable(final World lllllllllllllIllIIlIIlIIIlIIIlll) {
        super(lllllllllllllIllIIlIIlIIIlIIIlll);
        this.ageWidth = -1.0f;
    }
    
    @Override
    protected final void setSize(final float lllllllllllllIllIIlIIIllllIlllIl, final float lllllllllllllIllIIlIIIllllIllIII) {
        final boolean lllllllllllllIllIIlIIIllllIllIll = this.ageWidth > 0.0f;
        this.ageWidth = lllllllllllllIllIIlIIIllllIlllIl;
        this.ageHeight = lllllllllllllIllIIlIIIllllIllIII;
        if (!lllllllllllllIllIIlIIIllllIllIll) {
            this.setScale(1.0f);
        }
    }
    
    protected final void setScale(final float lllllllllllllIllIIlIIIllllIlIIIl) {
        super.setSize(this.ageWidth * lllllllllllllIllIIlIIIllllIlIIIl, this.ageHeight * lllllllllllllIllIIlIIIllllIlIIIl);
    }
    
    static {
        BABY = EntityDataManager.createKey(EntityAgeable.class, DataSerializers.BOOLEAN);
    }
    
    protected void onGrowingAdult() {
    }
}
