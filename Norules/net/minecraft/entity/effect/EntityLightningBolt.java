package net.minecraft.entity.effect;

import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.world.*;

public class EntityLightningBolt extends EntityWeatherEffect
{
    public /* synthetic */ long boltVertex;
    private /* synthetic */ int boltLivingTime;
    private final /* synthetic */ boolean effectOnly;
    private /* synthetic */ int lightningState;
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound llllllllllllllllIIllllllIIIlIIII) {
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.lightningState == 2) {
            this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_LIGHTNING_THUNDER, SoundCategory.WEATHER, 10000.0f, 0.8f + this.rand.nextFloat() * 0.2f);
            this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_LIGHTNING_IMPACT, SoundCategory.WEATHER, 2.0f, 0.5f + this.rand.nextFloat() * 0.2f);
        }
        --this.lightningState;
        if (this.lightningState < 0) {
            if (this.boltLivingTime == 0) {
                this.setDead();
            }
            else if (this.lightningState < -this.rand.nextInt(10)) {
                --this.boltLivingTime;
                this.lightningState = 1;
                if (!this.effectOnly && !this.world.isRemote) {
                    this.boltVertex = this.rand.nextLong();
                    final BlockPos llllllllllllllllIIllllllIIlIlIIl = new BlockPos(this);
                    if (this.world.getGameRules().getBoolean("doFireTick") && this.world.isAreaLoaded(llllllllllllllllIIllllllIIlIlIIl, 10) && this.world.getBlockState(llllllllllllllllIIllllllIIlIlIIl).getMaterial() == Material.AIR && Blocks.FIRE.canPlaceBlockAt(this.world, llllllllllllllllIIllllllIIlIlIIl)) {
                        this.world.setBlockState(llllllllllllllllIIllllllIIlIlIIl, Blocks.FIRE.getDefaultState());
                    }
                }
            }
        }
        if (this.lightningState >= 0) {
            if (this.world.isRemote) {
                this.world.setLastLightningBolt(2);
            }
            else if (!this.effectOnly) {
                final double llllllllllllllllIIllllllIIlIIlll = 3.0;
                final List<Entity> llllllllllllllllIIllllllIIlIIlIl = this.world.getEntitiesWithinAABBExcludingEntity(this, new AxisAlignedBB(this.posX - 3.0, this.posY - 3.0, this.posZ - 3.0, this.posX + 3.0, this.posY + 6.0 + 3.0, this.posZ + 3.0));
                for (int llllllllllllllllIIllllllIIlIIIll = 0; llllllllllllllllIIllllllIIlIIIll < llllllllllllllllIIllllllIIlIIlIl.size(); ++llllllllllllllllIIllllllIIlIIIll) {
                    final Entity llllllllllllllllIIllllllIIlIIIIl = llllllllllllllllIIllllllIIlIIlIl.get(llllllllllllllllIIllllllIIlIIIll);
                    llllllllllllllllIIllllllIIlIIIIl.onStruckByLightning(this);
                }
            }
        }
    }
    
    @Override
    public SoundCategory getSoundCategory() {
        return SoundCategory.WEATHER;
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound llllllllllllllllIIllllllIIIlIlII) {
    }
    
    public EntityLightningBolt(final World llllllllllllllllIIllllllIlIlIIlI, final double llllllllllllllllIIllllllIlIlIIII, final double llllllllllllllllIIllllllIllIIIII, final double llllllllllllllllIIllllllIlIllllI, final boolean llllllllllllllllIIllllllIlIlllII) {
        super(llllllllllllllllIIllllllIlIlIIlI);
        this.setLocationAndAngles(llllllllllllllllIIllllllIlIlIIII, llllllllllllllllIIllllllIllIIIII, llllllllllllllllIIllllllIlIllllI, 0.0f, 0.0f);
        this.lightningState = 2;
        this.boltVertex = this.rand.nextLong();
        this.boltLivingTime = this.rand.nextInt(3) + 1;
        this.effectOnly = llllllllllllllllIIllllllIlIlllII;
        final BlockPos llllllllllllllllIIllllllIlIllIlI = new BlockPos(this);
        if (!llllllllllllllllIIllllllIlIlllII && !llllllllllllllllIIllllllIlIlIIlI.isRemote && llllllllllllllllIIllllllIlIlIIlI.getGameRules().getBoolean("doFireTick") && (llllllllllllllllIIllllllIlIlIIlI.getDifficulty() == EnumDifficulty.NORMAL || llllllllllllllllIIllllllIlIlIIlI.getDifficulty() == EnumDifficulty.HARD) && llllllllllllllllIIllllllIlIlIIlI.isAreaLoaded(llllllllllllllllIIllllllIlIllIlI, 10)) {
            if (llllllllllllllllIIllllllIlIlIIlI.getBlockState(llllllllllllllllIIllllllIlIllIlI).getMaterial() == Material.AIR && Blocks.FIRE.canPlaceBlockAt(llllllllllllllllIIllllllIlIlIIlI, llllllllllllllllIIllllllIlIllIlI)) {
                llllllllllllllllIIllllllIlIlIIlI.setBlockState(llllllllllllllllIIllllllIlIllIlI, Blocks.FIRE.getDefaultState());
            }
            for (int llllllllllllllllIIllllllIlIllIII = 0; llllllllllllllllIIllllllIlIllIII < 4; ++llllllllllllllllIIllllllIlIllIII) {
                final BlockPos llllllllllllllllIIllllllIlIlIllI = llllllllllllllllIIllllllIlIllIlI.add(this.rand.nextInt(3) - 1, this.rand.nextInt(3) - 1, this.rand.nextInt(3) - 1);
                if (llllllllllllllllIIllllllIlIlIIlI.getBlockState(llllllllllllllllIIllllllIlIlIllI).getMaterial() == Material.AIR && Blocks.FIRE.canPlaceBlockAt(llllllllllllllllIIllllllIlIlIIlI, llllllllllllllllIIllllllIlIlIllI)) {
                    llllllllllllllllIIllllllIlIlIIlI.setBlockState(llllllllllllllllIIllllllIlIlIllI, Blocks.FIRE.getDefaultState());
                }
            }
        }
    }
    
    @Override
    protected void entityInit() {
    }
}
