package net.minecraft.entity.ai;

import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.pattern.*;
import net.minecraft.block.*;
import com.google.common.base.*;
import net.minecraft.block.properties.*;

public class EntityAIEatGrass extends EntityAIBase
{
    private final /* synthetic */ EntityLiving grassEaterEntity;
    /* synthetic */ int eatingGrassTimer;
    private static final /* synthetic */ Predicate<IBlockState> IS_TALL_GRASS;
    private final /* synthetic */ World entityWorld;
    
    @Override
    public boolean continueExecuting() {
        return this.eatingGrassTimer > 0;
    }
    
    @Override
    public void updateTask() {
        this.eatingGrassTimer = Math.max(0, this.eatingGrassTimer - 1);
        if (this.eatingGrassTimer == 4) {
            final BlockPos lllllllllllllIIIIIlIlIIIlllIlIIl = new BlockPos(this.grassEaterEntity.posX, this.grassEaterEntity.posY, this.grassEaterEntity.posZ);
            if (EntityAIEatGrass.IS_TALL_GRASS.apply((Object)this.entityWorld.getBlockState(lllllllllllllIIIIIlIlIIIlllIlIIl))) {
                if (this.entityWorld.getGameRules().getBoolean("mobGriefing")) {
                    this.entityWorld.destroyBlock(lllllllllllllIIIIIlIlIIIlllIlIIl, false);
                }
                this.grassEaterEntity.eatGrassBonus();
            }
            else {
                final BlockPos lllllllllllllIIIIIlIlIIIlllIlIII = lllllllllllllIIIIIlIlIIIlllIlIIl.down();
                if (this.entityWorld.getBlockState(lllllllllllllIIIIIlIlIIIlllIlIII).getBlock() == Blocks.GRASS) {
                    if (this.entityWorld.getGameRules().getBoolean("mobGriefing")) {
                        this.entityWorld.playEvent(2001, lllllllllllllIIIIIlIlIIIlllIlIII, Block.getIdFromBlock(Blocks.GRASS));
                        this.entityWorld.setBlockState(lllllllllllllIIIIIlIlIIIlllIlIII, Blocks.DIRT.getDefaultState(), 2);
                    }
                    this.grassEaterEntity.eatGrassBonus();
                }
            }
        }
    }
    
    public int getEatingGrassTimer() {
        return this.eatingGrassTimer;
    }
    
    @Override
    public void resetTask() {
        this.eatingGrassTimer = 0;
    }
    
    @Override
    public void startExecuting() {
        this.eatingGrassTimer = 40;
        this.entityWorld.setEntityState(this.grassEaterEntity, (byte)10);
        this.grassEaterEntity.getNavigator().clearPathEntity();
    }
    
    public EntityAIEatGrass(final EntityLiving lllllllllllllIIIIIlIlIIlIIIIIIlI) {
        this.grassEaterEntity = lllllllllllllIIIIIlIlIIlIIIIIIlI;
        this.entityWorld = lllllllllllllIIIIIlIlIIlIIIIIIlI.world;
        this.setMutexBits(7);
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.grassEaterEntity.getRNG().nextInt(this.grassEaterEntity.isChild() ? 50 : 1000) != 0) {
            return false;
        }
        final BlockPos lllllllllllllIIIIIlIlIIIllllllII = new BlockPos(this.grassEaterEntity.posX, this.grassEaterEntity.posY, this.grassEaterEntity.posZ);
        return EntityAIEatGrass.IS_TALL_GRASS.apply((Object)this.entityWorld.getBlockState(lllllllllllllIIIIIlIlIIIllllllII)) || this.entityWorld.getBlockState(lllllllllllllIIIIIlIlIIIllllllII.down()).getBlock() == Blocks.GRASS;
    }
    
    static {
        IS_TALL_GRASS = (Predicate)BlockStateMatcher.forBlock(Blocks.TALLGRASS).where(BlockTallGrass.TYPE, (com.google.common.base.Predicate<? extends BlockTallGrass.EnumType>)Predicates.equalTo((Object)BlockTallGrass.EnumType.GRASS));
    }
}
