package net.minecraft.entity.item;

import net.minecraft.entity.*;
import com.google.common.base.*;
import net.minecraft.util.math.*;
import net.minecraft.nbt.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.entity.boss.*;
import net.minecraft.world.end.*;

public class EntityEnderCrystal extends Entity
{
    private static final /* synthetic */ DataParameter<Boolean> SHOW_BOTTOM;
    public /* synthetic */ int innerRotation;
    private static final /* synthetic */ DataParameter<Optional<BlockPos>> BEAM_TARGET;
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound llllllllllllllIllllIllIlllllIlll) {
        if (this.getBeamTarget() != null) {
            llllllllllllllIllllIllIlllllIlll.setTag("BeamTarget", NBTUtil.createPosTag(this.getBeamTarget()));
        }
        llllllllllllllIllllIllIlllllIlll.setBoolean("ShowBottom", this.shouldShowBottom());
    }
    
    @Nullable
    public BlockPos getBeamTarget() {
        return (BlockPos)this.getDataManager().get(EntityEnderCrystal.BEAM_TARGET).orNull();
    }
    
    public EntityEnderCrystal(final World llllllllllllllIllllIlllIIIIlIllI) {
        super(llllllllllllllIllllIlllIIIIlIllI);
        this.preventEntitySpawning = true;
        this.setSize(2.0f, 2.0f);
        this.innerRotation = this.rand.nextInt(100000);
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        ++this.innerRotation;
        if (!this.world.isRemote) {
            final BlockPos llllllllllllllIllllIllIlllllllll = new BlockPos(this);
            if (this.world.provider instanceof WorldProviderEnd && this.world.getBlockState(llllllllllllllIllllIllIlllllllll).getBlock() != Blocks.FIRE) {
                this.world.setBlockState(llllllllllllllIllllIllIlllllllll, Blocks.FIRE.getDefaultState());
            }
        }
    }
    
    public boolean shouldShowBottom() {
        return this.getDataManager().get(EntityEnderCrystal.SHOW_BOTTOM);
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double llllllllllllllIllllIllIlllIIIIlI) {
        return super.isInRangeToRenderDist(llllllllllllllIllllIllIlllIIIIlI) || this.getBeamTarget() != null;
    }
    
    public EntityEnderCrystal(final World llllllllllllllIllllIlllIIIIIlIlI, final double llllllllllllllIllllIlllIIIIIlIIl, final double llllllllllllllIllllIlllIIIIIllIl, final double llllllllllllllIllllIlllIIIIIIlll) {
        this(llllllllllllllIllllIlllIIIIIlIlI);
        this.setPosition(llllllllllllllIllllIlllIIIIIlIIl, llllllllllllllIllllIlllIIIIIllIl, llllllllllllllIllllIlllIIIIIIlll);
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
    
    public void setShowBottom(final boolean llllllllllllllIllllIllIlllIIllIl) {
        this.getDataManager().set(EntityEnderCrystal.SHOW_BOTTOM, llllllllllllllIllllIllIlllIIllIl);
    }
    
    static {
        BEAM_TARGET = EntityDataManager.createKey(EntityEnderCrystal.class, DataSerializers.OPTIONAL_BLOCK_POS);
        SHOW_BOTTOM = EntityDataManager.createKey(EntityEnderCrystal.class, DataSerializers.BOOLEAN);
    }
    
    @Override
    protected void entityInit() {
        this.getDataManager().register(EntityEnderCrystal.BEAM_TARGET, (Optional<BlockPos>)Optional.absent());
        this.getDataManager().register(EntityEnderCrystal.SHOW_BOTTOM, true);
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound llllllllllllllIllllIllIlllllIIIl) {
        if (llllllllllllllIllllIllIlllllIIIl.hasKey("BeamTarget", 10)) {
            this.setBeamTarget(NBTUtil.getPosFromTag(llllllllllllllIllllIllIlllllIIIl.getCompoundTag("BeamTarget")));
        }
        if (llllllllllllllIllllIllIlllllIIIl.hasKey("ShowBottom", 1)) {
            this.setShowBottom(llllllllllllllIllllIllIlllllIIIl.getBoolean("ShowBottom"));
        }
    }
    
    @Override
    public void onKillCommand() {
        this.onCrystalDestroyed(DamageSource.generic);
        super.onKillCommand();
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllIllllIllIllllIlIIl, final float llllllllllllllIllllIllIllllIlIll) {
        if (this.isEntityInvulnerable(llllllllllllllIllllIllIllllIlIIl)) {
            return false;
        }
        if (llllllllllllllIllllIllIllllIlIIl.getEntity() instanceof EntityDragon) {
            return false;
        }
        if (!this.isDead && !this.world.isRemote) {
            this.setDead();
            if (!this.world.isRemote) {
                if (!llllllllllllllIllllIllIllllIlIIl.isExplosion()) {
                    this.world.createExplosion(null, this.posX, this.posY, this.posZ, 6.0f, true);
                }
                this.onCrystalDestroyed(llllllllllllllIllllIllIllllIlIIl);
            }
        }
        return true;
    }
    
    private void onCrystalDestroyed(final DamageSource llllllllllllllIllllIllIlllIlllII) {
        if (this.world.provider instanceof WorldProviderEnd) {
            final WorldProviderEnd llllllllllllllIllllIllIlllIlllll = (WorldProviderEnd)this.world.provider;
            final DragonFightManager llllllllllllllIllllIllIlllIllllI = llllllllllllllIllllIllIlllIlllll.getDragonFightManager();
            if (llllllllllllllIllllIllIlllIllllI != null) {
                llllllllllllllIllllIllIlllIllllI.onCrystalDestroyed(this, llllllllllllllIllllIllIlllIlllII);
            }
        }
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    public void setBeamTarget(@Nullable final BlockPos llllllllllllllIllllIllIlllIlIllI) {
        this.getDataManager().set(EntityEnderCrystal.BEAM_TARGET, (Optional<BlockPos>)Optional.fromNullable((Object)llllllllllllllIllllIllIlllIlIllI));
    }
}
