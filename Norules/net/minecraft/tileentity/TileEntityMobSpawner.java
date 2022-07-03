package net.minecraft.tileentity;

import net.minecraft.network.play.server.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;

public class TileEntityMobSpawner extends TileEntity implements ITickable
{
    private final /* synthetic */ MobSpawnerBaseLogic spawnerLogic;
    
    @Override
    public NBTTagCompound getUpdateTag() {
        final NBTTagCompound llllllllllllllIIllIIIllIlIIIlIIl = this.writeToNBT(new NBTTagCompound());
        llllllllllllllIIllIIIllIlIIIlIIl.removeTag("SpawnPotentials");
        return llllllllllllllIIllIIIllIlIIIlIIl;
    }
    
    @Override
    public boolean receiveClientEvent(final int llllllllllllllIIllIIIllIIlllllll, final int llllllllllllllIIllIIIllIIllllllI) {
        return this.spawnerLogic.setDelayToMin(llllllllllllllIIllIIIllIIlllllll) || super.receiveClientEvent(llllllllllllllIIllIIIllIIlllllll, llllllllllllllIIllIIIllIIllllllI);
    }
    
    @Override
    public void update() {
        this.spawnerLogic.updateSpawner();
    }
    
    public MobSpawnerBaseLogic getSpawnerBaseLogic() {
        return this.spawnerLogic;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllllIIllIIIllIlIIlIlIl) {
        super.writeToNBT(llllllllllllllIIllIIIllIlIIlIlIl);
        this.spawnerLogic.writeToNBT(llllllllllllllIIllIIIllIlIIlIlIl);
        return llllllllllllllIIllIIIllIlIIlIlIl;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllIIllIIIllIlIIllIll) {
        super.readFromNBT(llllllllllllllIIllIIIllIlIIllIll);
        this.spawnerLogic.readFromNBT(llllllllllllllIIllIIIllIlIIllIll);
    }
    
    @Override
    public boolean onlyOpsCanSetNbt() {
        return true;
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 1, this.getUpdateTag());
    }
    
    public TileEntityMobSpawner() {
        this.spawnerLogic = new MobSpawnerBaseLogic() {
            @Override
            public World getSpawnerWorld() {
                return TileEntityMobSpawner.this.world;
            }
            
            @Override
            public BlockPos getSpawnerPosition() {
                return TileEntityMobSpawner.this.pos;
            }
            
            @Override
            public void setNextSpawnData(final WeightedSpawnerEntity lllllllllllllIlIlIIlIIlllIllIIIl) {
                super.setNextSpawnData(lllllllllllllIlIlIIlIIlllIllIIIl);
                if (this.getSpawnerWorld() != null) {
                    final IBlockState lllllllllllllIlIlIIlIIlllIllIIII = this.getSpawnerWorld().getBlockState(this.getSpawnerPosition());
                    this.getSpawnerWorld().notifyBlockUpdate(TileEntityMobSpawner.this.pos, lllllllllllllIlIlIIlIIlllIllIIII, lllllllllllllIlIlIIlIIlllIllIIII, 4);
                }
            }
            
            @Override
            public void broadcastEvent(final int lllllllllllllIlIlIIlIIllllIIlIlI) {
                TileEntityMobSpawner.this.world.addBlockEvent(TileEntityMobSpawner.this.pos, Blocks.MOB_SPAWNER, lllllllllllllIlIlIIlIIllllIIlIlI, 0);
            }
        };
    }
    
    public static void registerFixesMobSpawner(final DataFixer llllllllllllllIIllIIIllIlIIlllll) {
        llllllllllllllIIllIIIllIlIIlllll.registerWalker(FixTypes.BLOCK_ENTITY, new IDataWalker() {
            @Override
            public NBTTagCompound process(final IDataFixer llllllllllllllIlIlIlllIIlIlIIlIl, final NBTTagCompound llllllllllllllIlIlIlllIIlIIllllI, final int llllllllllllllIlIlIlllIIlIlIIIll) {
                if (TileEntity.func_190559_a(TileEntityMobSpawner.class).equals(new ResourceLocation(llllllllllllllIlIlIlllIIlIIllllI.getString("id")))) {
                    if (llllllllllllllIlIlIlllIIlIIllllI.hasKey("SpawnPotentials", 9)) {
                        final NBTTagList llllllllllllllIlIlIlllIIlIlIIIlI = llllllllllllllIlIlIlllIIlIIllllI.getTagList("SpawnPotentials", 10);
                        for (int llllllllllllllIlIlIlllIIlIlIIIIl = 0; llllllllllllllIlIlIlllIIlIlIIIIl < llllllllllllllIlIlIlllIIlIlIIIlI.tagCount(); ++llllllllllllllIlIlIlllIIlIlIIIIl) {
                            final NBTTagCompound llllllllllllllIlIlIlllIIlIlIIIII = llllllllllllllIlIlIlllIIlIlIIIlI.getCompoundTagAt(llllllllllllllIlIlIlllIIlIlIIIIl);
                            llllllllllllllIlIlIlllIIlIlIIIII.setTag("Entity", llllllllllllllIlIlIlllIIlIlIIlIl.process(FixTypes.ENTITY, llllllllllllllIlIlIlllIIlIlIIIII.getCompoundTag("Entity"), llllllllllllllIlIlIlllIIlIlIIIll));
                        }
                    }
                    llllllllllllllIlIlIlllIIlIIllllI.setTag("SpawnData", llllllllllllllIlIlIlllIIlIlIIlIl.process(FixTypes.ENTITY, llllllllllllllIlIlIlllIIlIIllllI.getCompoundTag("SpawnData"), llllllllllllllIlIlIlllIIlIlIIIll));
                }
                return llllllllllllllIlIlIlllIIlIIllllI;
            }
        });
    }
}
