package net.minecraft.entity.item;

import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.network.datasync.*;
import net.minecraft.crash.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.util.datafix.*;
import javax.annotation.*;

public class EntityFallingBlock extends Entity
{
    protected static final /* synthetic */ DataParameter<BlockPos> ORIGIN;
    private /* synthetic */ boolean canSetAsBlock;
    private /* synthetic */ IBlockState fallTile;
    public /* synthetic */ int fallTime;
    private /* synthetic */ boolean hurtEntities;
    private /* synthetic */ float fallHurtAmount;
    private /* synthetic */ int fallHurtMax;
    public /* synthetic */ NBTTagCompound tileEntityData;
    public /* synthetic */ boolean shouldDropItem;
    
    public BlockPos getOrigin() {
        return this.dataManager.get(EntityFallingBlock.ORIGIN);
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound lllllllllllllIlIlllIlllIllllIIll) {
        final int lllllllllllllIlIlllIlllIllllIllI = lllllllllllllIlIlllIlllIllllIIll.getByte("Data") & 0xFF;
        if (lllllllllllllIlIlllIlllIllllIIll.hasKey("Block", 8)) {
            this.fallTile = Block.getBlockFromName(lllllllllllllIlIlllIlllIllllIIll.getString("Block")).getStateFromMeta(lllllllllllllIlIlllIlllIllllIllI);
        }
        else if (lllllllllllllIlIlllIlllIllllIIll.hasKey("TileID", 99)) {
            this.fallTile = Block.getBlockById(lllllllllllllIlIlllIlllIllllIIll.getInteger("TileID")).getStateFromMeta(lllllllllllllIlIlllIlllIllllIllI);
        }
        else {
            this.fallTile = Block.getBlockById(lllllllllllllIlIlllIlllIllllIIll.getByte("Tile") & 0xFF).getStateFromMeta(lllllllllllllIlIlllIlllIllllIllI);
        }
        this.fallTime = lllllllllllllIlIlllIlllIllllIIll.getInteger("Time");
        final Block lllllllllllllIlIlllIlllIllllIlIl = this.fallTile.getBlock();
        if (lllllllllllllIlIlllIlllIllllIIll.hasKey("HurtEntities", 99)) {
            this.hurtEntities = lllllllllllllIlIlllIlllIllllIIll.getBoolean("HurtEntities");
            this.fallHurtAmount = lllllllllllllIlIlllIlllIllllIIll.getFloat("FallHurtAmount");
            this.fallHurtMax = lllllllllllllIlIlllIlllIllllIIll.getInteger("FallHurtMax");
        }
        else if (lllllllllllllIlIlllIlllIllllIlIl == Blocks.ANVIL) {
            this.hurtEntities = true;
        }
        if (lllllllllllllIlIlllIlllIllllIIll.hasKey("DropItem", 99)) {
            this.shouldDropItem = lllllllllllllIlIlllIlllIllllIIll.getBoolean("DropItem");
        }
        if (lllllllllllllIlIlllIlllIllllIIll.hasKey("TileEntityData", 10)) {
            this.tileEntityData = lllllllllllllIlIlllIlllIllllIIll.getCompoundTag("TileEntityData");
        }
        if (lllllllllllllIlIlllIlllIllllIlIl == null || lllllllllllllIlIlllIlllIllllIlIl.getDefaultState().getMaterial() == Material.AIR) {
            this.fallTile = Blocks.SAND.getDefaultState();
        }
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound lllllllllllllIlIlllIllllIIIIIIll) {
        final Block lllllllllllllIlIlllIllllIIIIIIlI = (this.fallTile != null) ? this.fallTile.getBlock() : Blocks.AIR;
        final ResourceLocation lllllllllllllIlIlllIllllIIIIIIIl = Block.REGISTRY.getNameForObject(lllllllllllllIlIlllIllllIIIIIIlI);
        lllllllllllllIlIlllIllllIIIIIIll.setString("Block", (lllllllllllllIlIlllIllllIIIIIIIl == null) ? "" : lllllllllllllIlIlllIllllIIIIIIIl.toString());
        lllllllllllllIlIlllIllllIIIIIIll.setByte("Data", (byte)lllllllllllllIlIlllIllllIIIIIIlI.getMetaFromState(this.fallTile));
        lllllllllllllIlIlllIllllIIIIIIll.setInteger("Time", this.fallTime);
        lllllllllllllIlIlllIllllIIIIIIll.setBoolean("DropItem", this.shouldDropItem);
        lllllllllllllIlIlllIllllIIIIIIll.setBoolean("HurtEntities", this.hurtEntities);
        lllllllllllllIlIlllIllllIIIIIIll.setFloat("FallHurtAmount", this.fallHurtAmount);
        lllllllllllllIlIlllIllllIIIIIIll.setInteger("FallHurtMax", this.fallHurtMax);
        if (this.tileEntityData != null) {
            lllllllllllllIlIlllIllllIIIIIIll.setTag("TileEntityData", this.tileEntityData);
        }
    }
    
    public EntityFallingBlock(final World lllllllllllllIlIlllIllllIllIIIII, final double lllllllllllllIlIlllIllllIlIlllll, final double lllllllllllllIlIlllIllllIlIllllI, final double lllllllllllllIlIlllIllllIlIlllIl, final IBlockState lllllllllllllIlIlllIllllIllIIIlI) {
        super(lllllllllllllIlIlllIllllIllIIIII);
        this.shouldDropItem = true;
        this.fallHurtMax = 40;
        this.fallHurtAmount = 2.0f;
        this.fallTile = lllllllllllllIlIlllIllllIllIIIlI;
        this.preventEntitySpawning = true;
        this.setSize(0.98f, 0.98f);
        this.setPosition(lllllllllllllIlIlllIllllIlIlllll, lllllllllllllIlIlllIllllIlIllllI + (1.0f - this.height) / 2.0f, lllllllllllllIlIlllIllllIlIlllIl);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = lllllllllllllIlIlllIllllIlIlllll;
        this.prevPosY = lllllllllllllIlIlllIllllIlIllllI;
        this.prevPosZ = lllllllllllllIlIlllIllllIlIlllIl;
        this.setOrigin(new BlockPos(this));
    }
    
    public void setOrigin(final BlockPos lllllllllllllIlIlllIllllIlIlIlll) {
        this.dataManager.set(EntityFallingBlock.ORIGIN, lllllllllllllIlIlllIllllIlIlIlll);
    }
    
    @Override
    public boolean canRenderOnFire() {
        return false;
    }
    
    static {
        ORIGIN = EntityDataManager.createKey(EntityFallingBlock.class, DataSerializers.BLOCK_POS);
    }
    
    @Override
    protected void entityInit() {
        this.dataManager.register(EntityFallingBlock.ORIGIN, BlockPos.ORIGIN);
    }
    
    public World getWorldObj() {
        return this.world;
    }
    
    public EntityFallingBlock(final World lllllllllllllIlIlllIllllIlllIIII) {
        super(lllllllllllllIlIlllIllllIlllIIII);
        this.shouldDropItem = true;
        this.fallHurtMax = 40;
        this.fallHurtAmount = 2.0f;
    }
    
    @Override
    public void addEntityCrashInfo(final CrashReportCategory lllllllllllllIlIlllIlllIllIlllll) {
        super.addEntityCrashInfo(lllllllllllllIlIlllIlllIllIlllll);
        if (this.fallTile != null) {
            final Block lllllllllllllIlIlllIlllIlllIIIIl = this.fallTile.getBlock();
            lllllllllllllIlIlllIlllIllIlllll.addCrashSection("Immitating block ID", Block.getIdFromBlock(lllllllllllllIlIlllIlllIlllIIIIl));
            lllllllllllllIlIlllIlllIllIlllll.addCrashSection("Immitating block data", lllllllllllllIlIlllIlllIlllIIIIl.getMetaFromState(this.fallTile));
        }
    }
    
    @Override
    public void onUpdate() {
        final Block lllllllllllllIlIlllIllllIIllllIl = this.fallTile.getBlock();
        if (this.fallTile.getMaterial() == Material.AIR) {
            this.setDead();
        }
        else {
            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;
            if (this.fallTime++ == 0) {
                final BlockPos lllllllllllllIlIlllIllllIIllllII = new BlockPos(this);
                if (this.world.getBlockState(lllllllllllllIlIlllIllllIIllllII).getBlock() == lllllllllllllIlIlllIllllIIllllIl) {
                    this.world.setBlockToAir(lllllllllllllIlIlllIllllIIllllII);
                }
                else if (!this.world.isRemote) {
                    this.setDead();
                    return;
                }
            }
            if (!this.hasNoGravity()) {
                this.motionY -= 0.03999999910593033;
            }
            this.moveEntity(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            if (!this.world.isRemote) {
                BlockPos lllllllllllllIlIlllIllllIIlllIll = new BlockPos(this);
                final boolean lllllllllllllIlIlllIllllIIlllIlI = this.fallTile.getBlock() == Blocks.field_192444_dS;
                boolean lllllllllllllIlIlllIllllIIlllIIl = lllllllllllllIlIlllIllllIIlllIlI && this.world.getBlockState(lllllllllllllIlIlllIllllIIlllIll).getMaterial() == Material.WATER;
                final double lllllllllllllIlIlllIllllIIlllIII = this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ;
                if (lllllllllllllIlIlllIllllIIlllIlI && lllllllllllllIlIlllIllllIIlllIII > 1.0) {
                    final RayTraceResult lllllllllllllIlIlllIllllIIllIlll = this.world.rayTraceBlocks(new Vec3d(this.prevPosX, this.prevPosY, this.prevPosZ), new Vec3d(this.posX, this.posY, this.posZ), true);
                    if (lllllllllllllIlIlllIllllIIllIlll != null && this.world.getBlockState(lllllllllllllIlIlllIllllIIllIlll.getBlockPos()).getMaterial() == Material.WATER) {
                        lllllllllllllIlIlllIllllIIlllIll = lllllllllllllIlIlllIllllIIllIlll.getBlockPos();
                        lllllllllllllIlIlllIllllIIlllIIl = true;
                    }
                }
                if (!this.onGround && !lllllllllllllIlIlllIllllIIlllIIl) {
                    if ((this.fallTime > 100 && !this.world.isRemote && (lllllllllllllIlIlllIllllIIlllIll.getY() < 1 || lllllllllllllIlIlllIllllIIlllIll.getY() > 256)) || this.fallTime > 600) {
                        if (this.shouldDropItem && this.world.getGameRules().getBoolean("doEntityDrops")) {
                            this.entityDropItem(new ItemStack(lllllllllllllIlIlllIllllIIllllIl, 1, lllllllllllllIlIlllIllllIIllllIl.damageDropped(this.fallTile)), 0.0f);
                        }
                        this.setDead();
                    }
                }
                else {
                    final IBlockState lllllllllllllIlIlllIllllIIllIllI = this.world.getBlockState(lllllllllllllIlIlllIllllIIlllIll);
                    if (!lllllllllllllIlIlllIllllIIlllIIl && BlockFalling.canFallThrough(this.world.getBlockState(new BlockPos(this.posX, this.posY - 0.009999999776482582, this.posZ)))) {
                        this.onGround = false;
                        return;
                    }
                    this.motionX *= 0.699999988079071;
                    this.motionZ *= 0.699999988079071;
                    this.motionY *= -0.5;
                    if (lllllllllllllIlIlllIllllIIllIllI.getBlock() != Blocks.PISTON_EXTENSION) {
                        this.setDead();
                        if (!this.canSetAsBlock) {
                            if (this.world.func_190527_a(lllllllllllllIlIlllIllllIIllllIl, lllllllllllllIlIlllIllllIIlllIll, true, EnumFacing.UP, null) && (lllllllllllllIlIlllIllllIIlllIIl || !BlockFalling.canFallThrough(this.world.getBlockState(lllllllllllllIlIlllIllllIIlllIll.down()))) && this.world.setBlockState(lllllllllllllIlIlllIllllIIlllIll, this.fallTile, 3)) {
                                if (lllllllllllllIlIlllIllllIIllllIl instanceof BlockFalling) {
                                    ((BlockFalling)lllllllllllllIlIlllIllllIIllllIl).onEndFalling(this.world, lllllllllllllIlIlllIllllIIlllIll, this.fallTile, lllllllllllllIlIlllIllllIIllIllI);
                                }
                                if (this.tileEntityData != null && lllllllllllllIlIlllIllllIIllllIl instanceof ITileEntityProvider) {
                                    final TileEntity lllllllllllllIlIlllIllllIIllIlIl = this.world.getTileEntity(lllllllllllllIlIlllIllllIIlllIll);
                                    if (lllllllllllllIlIlllIllllIIllIlIl != null) {
                                        final NBTTagCompound lllllllllllllIlIlllIllllIIllIlII = lllllllllllllIlIlllIllllIIllIlIl.writeToNBT(new NBTTagCompound());
                                        for (final String lllllllllllllIlIlllIllllIIllIIll : this.tileEntityData.getKeySet()) {
                                            final NBTBase lllllllllllllIlIlllIllllIIllIIlI = this.tileEntityData.getTag(lllllllllllllIlIlllIllllIIllIIll);
                                            if (!"x".equals(lllllllllllllIlIlllIllllIIllIIll) && !"y".equals(lllllllllllllIlIlllIllllIIllIIll) && !"z".equals(lllllllllllllIlIlllIllllIIllIIll)) {
                                                lllllllllllllIlIlllIllllIIllIlII.setTag(lllllllllllllIlIlllIllllIIllIIll, lllllllllllllIlIlllIllllIIllIIlI.copy());
                                            }
                                        }
                                        lllllllllllllIlIlllIllllIIllIlIl.readFromNBT(lllllllllllllIlIlllIllllIIllIlII);
                                        lllllllllllllIlIlllIllllIIllIlIl.markDirty();
                                    }
                                }
                            }
                            else if (this.shouldDropItem && this.world.getGameRules().getBoolean("doEntityDrops")) {
                                this.entityDropItem(new ItemStack(lllllllllllllIlIlllIllllIIllllIl, 1, lllllllllllllIlIlllIllllIIllllIl.damageDropped(this.fallTile)), 0.0f);
                            }
                        }
                        else if (lllllllllllllIlIlllIllllIIllllIl instanceof BlockFalling) {
                            ((BlockFalling)lllllllllllllIlIlllIllllIIllllIl).func_190974_b(this.world, lllllllllllllIlIlllIllllIIlllIll);
                        }
                    }
                }
            }
            this.motionX *= 0.9800000190734863;
            this.motionY *= 0.9800000190734863;
            this.motionZ *= 0.9800000190734863;
        }
    }
    
    @Override
    public void fall(final float lllllllllllllIlIlllIllllIIIlIIIl, final float lllllllllllllIlIlllIllllIIIllIlI) {
        final Block lllllllllllllIlIlllIllllIIIllIIl = this.fallTile.getBlock();
        if (this.hurtEntities) {
            final int lllllllllllllIlIlllIllllIIIllIII = MathHelper.ceil(lllllllllllllIlIlllIllllIIIlIIIl - 1.0f);
            if (lllllllllllllIlIlllIllllIIIllIII > 0) {
                final List<Entity> lllllllllllllIlIlllIllllIIIlIlll = (List<Entity>)Lists.newArrayList((Iterable)this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox()));
                final boolean lllllllllllllIlIlllIllllIIIlIllI = lllllllllllllIlIlllIllllIIIllIIl == Blocks.ANVIL;
                final DamageSource lllllllllllllIlIlllIllllIIIlIlIl = lllllllllllllIlIlllIllllIIIlIllI ? DamageSource.anvil : DamageSource.fallingBlock;
                for (final Entity lllllllllllllIlIlllIllllIIIlIlII : lllllllllllllIlIlllIllllIIIlIlll) {
                    lllllllllllllIlIlllIllllIIIlIlII.attackEntityFrom(lllllllllllllIlIlllIllllIIIlIlIl, (float)Math.min(MathHelper.floor(lllllllllllllIlIlllIllllIIIllIII * this.fallHurtAmount), this.fallHurtMax));
                }
                if (lllllllllllllIlIlllIllllIIIlIllI && this.rand.nextFloat() < 0.05000000074505806 + lllllllllllllIlIlllIllllIIIllIII * 0.05) {
                    int lllllllllllllIlIlllIllllIIIlIIll = this.fallTile.getValue((IProperty<Integer>)BlockAnvil.DAMAGE);
                    if (++lllllllllllllIlIlllIllllIIIlIIll > 2) {
                        this.canSetAsBlock = true;
                    }
                    else {
                        this.fallTile = this.fallTile.withProperty((IProperty<Comparable>)BlockAnvil.DAMAGE, lllllllllllllIlIlllIllllIIIlIIll);
                    }
                }
            }
        }
    }
    
    public static void registerFixesFallingBlock(final DataFixer lllllllllllllIlIlllIllllIIIIlIIl) {
    }
    
    public void setHurtEntities(final boolean lllllllllllllIlIlllIlllIlllIlIII) {
        this.hurtEntities = lllllllllllllIlIlllIlllIlllIlIII;
    }
    
    @Override
    public boolean ignoreItemEntityData() {
        return true;
    }
    
    @Override
    public boolean canBeAttackedWithItem() {
        return false;
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Nullable
    public IBlockState getBlock() {
        return this.fallTile;
    }
}
