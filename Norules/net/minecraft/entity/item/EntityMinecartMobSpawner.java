package net.minecraft.entity.item;

import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.datafix.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;

public class EntityMinecartMobSpawner extends EntityMinecart
{
    private final /* synthetic */ MobSpawnerBaseLogic mobSpawnerLogic;
    
    @Override
    public IBlockState getDefaultDisplayTile() {
        return Blocks.MOB_SPAWNER.getDefaultState();
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound llllllllllllllllIIIllllIllllllII) {
        super.readEntityFromNBT(llllllllllllllllIIIllllIllllllII);
        this.mobSpawnerLogic.readFromNBT(llllllllllllllllIIIllllIllllllII);
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        this.mobSpawnerLogic.updateSpawner();
    }
    
    public static void registerFixesMinecartMobSpawner(final DataFixer llllllllllllllllIIIlllllIIIIIIlI) {
        EntityMinecart.registerFixesMinecart(llllllllllllllllIIIlllllIIIIIIlI, EntityMinecartMobSpawner.class);
        llllllllllllllllIIIlllllIIIIIIlI.registerWalker(FixTypes.ENTITY, new IDataWalker() {
            @Override
            public NBTTagCompound process(final IDataFixer lllllllllllllIlIlIllllllIlIIlIll, final NBTTagCompound lllllllllllllIlIlIllllllIlIIIllI, final int lllllllllllllIlIlIllllllIlIIIlIl) {
                final String lllllllllllllIlIlIllllllIlIIlIII = lllllllllllllIlIlIllllllIlIIIllI.getString("id");
                if (EntityList.func_191306_a(EntityMinecartMobSpawner.class).equals(new ResourceLocation(lllllllllllllIlIlIllllllIlIIlIII))) {
                    lllllllllllllIlIlIllllllIlIIIllI.setString("id", TileEntity.func_190559_a(TileEntityMobSpawner.class).toString());
                    lllllllllllllIlIlIllllllIlIIlIll.process(FixTypes.BLOCK_ENTITY, lllllllllllllIlIlIllllllIlIIIllI, lllllllllllllIlIlIllllllIlIIIlIl);
                    lllllllllllllIlIlIllllllIlIIIllI.setString("id", lllllllllllllIlIlIllllllIlIIlIII);
                }
                return lllllllllllllIlIlIllllllIlIIIllI;
            }
        });
    }
    
    @Override
    public void handleStatusUpdate(final byte llllllllllllllllIIIllllIlllIlllI) {
        this.mobSpawnerLogic.setDelayToMin(llllllllllllllllIIIllllIlllIlllI);
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound llllllllllllllllIIIllllIllllIlII) {
        super.writeEntityToNBT(llllllllllllllllIIIllllIllllIlII);
        this.mobSpawnerLogic.writeToNBT(llllllllllllllllIIIllllIllllIlII);
    }
    
    public EntityMinecartMobSpawner(final World llllllllllllllllIIIlllllIIIIlIII, final double llllllllllllllllIIIlllllIIIIllII, final double llllllllllllllllIIIlllllIIIIlIll, final double llllllllllllllllIIIlllllIIIIIlIl) {
        super(llllllllllllllllIIIlllllIIIIlIII, llllllllllllllllIIIlllllIIIIllII, llllllllllllllllIIIlllllIIIIlIll, llllllllllllllllIIIlllllIIIIIlIl);
        this.mobSpawnerLogic = new MobSpawnerBaseLogic() {
            @Override
            public BlockPos getSpawnerPosition() {
                return new BlockPos(EntityMinecartMobSpawner.this);
            }
            
            @Override
            public World getSpawnerWorld() {
                return EntityMinecartMobSpawner.this.world;
            }
            
            @Override
            public void broadcastEvent(final int llllllllllllIlllllIIIlIIlllllIIl) {
                EntityMinecartMobSpawner.this.world.setEntityState(EntityMinecartMobSpawner.this, (byte)llllllllllllIlllllIIIlIIlllllIIl);
            }
        };
    }
    
    public EntityMinecartMobSpawner(final World llllllllllllllllIIIlllllIIIlIllI) {
        super(llllllllllllllllIIIlllllIIIlIllI);
        this.mobSpawnerLogic = new MobSpawnerBaseLogic() {
            @Override
            public BlockPos getSpawnerPosition() {
                return new BlockPos(EntityMinecartMobSpawner.this);
            }
            
            @Override
            public World getSpawnerWorld() {
                return EntityMinecartMobSpawner.this.world;
            }
            
            @Override
            public void broadcastEvent(final int llllllllllllIlllllIIIlIIlllllIIl) {
                EntityMinecartMobSpawner.this.world.setEntityState(EntityMinecartMobSpawner.this, (byte)llllllllllllIlllllIIIlIIlllllIIl);
            }
        };
    }
    
    @Override
    public Type getType() {
        return Type.SPAWNER;
    }
}
