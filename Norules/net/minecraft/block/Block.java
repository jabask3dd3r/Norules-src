package net.minecraft.block;

import net.minecraft.util.registry.*;
import javax.annotation.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import net.minecraft.stats.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.client.util.*;
import net.minecraft.item.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;

public class Block
{
    protected final /* synthetic */ BlockStateContainer blockState;
    public static final /* synthetic */ RegistryNamespacedDefaultedByKey<ResourceLocation, Block> REGISTRY;
    protected /* synthetic */ boolean enableStats;
    private /* synthetic */ IBlockState defaultBlockState;
    protected /* synthetic */ float blockResistance;
    protected final /* synthetic */ Material blockMaterial;
    public /* synthetic */ float slipperiness;
    protected /* synthetic */ int lightValue;
    public static final /* synthetic */ ObjectIntIdentityMap<IBlockState> BLOCK_STATE_IDS;
    protected /* synthetic */ boolean isBlockContainer;
    protected /* synthetic */ boolean needsRandomTick;
    protected /* synthetic */ boolean useNeighborBrightness;
    protected /* synthetic */ float blockHardness;
    public static final /* synthetic */ AxisAlignedBB FULL_BLOCK_AABB;
    protected final /* synthetic */ MapColor blockMapColor;
    private static final /* synthetic */ ResourceLocation AIR_ID;
    @Nullable
    public static final /* synthetic */ AxisAlignedBB NULL_AABB;
    protected /* synthetic */ boolean fullBlock;
    public /* synthetic */ float blockParticleGravity;
    protected /* synthetic */ boolean translucent;
    private /* synthetic */ String unlocalizedName;
    private /* synthetic */ CreativeTabs displayOnCreativeTab;
    protected /* synthetic */ int lightOpacity;
    protected /* synthetic */ SoundType blockSoundType;
    
    @Deprecated
    public boolean canEntitySpawn(final IBlockState llllllllllllllllllllIIlIIllllllI, final Entity llllllllllllllllllllIIlIIlllllIl) {
        return true;
    }
    
    private static void registerBlock(final int lllllllllllllllllllIllllIlIlllIl, final String lllllllllllllllllllIllllIlIllIIl, final Block lllllllllllllllllllIllllIlIllIll) {
        registerBlock(lllllllllllllllllllIllllIlIlllIl, new ResourceLocation(lllllllllllllllllllIllllIlIllIIl), lllllllllllllllllllIllllIlIllIll);
    }
    
    @Nullable
    public static Block getBlockFromName(final String llllllllllllllllllllIIlIlIIIlIlI) {
        final ResourceLocation llllllllllllllllllllIIlIlIIIllII = new ResourceLocation(llllllllllllllllllllIIlIlIIIlIlI);
        if (Block.REGISTRY.containsKey(llllllllllllllllllllIIlIlIIIllII)) {
            return Block.REGISTRY.getObject(llllllllllllllllllllIIlIlIIIllII);
        }
        try {
            return Block.REGISTRY.getObjectById(Integer.parseInt(llllllllllllllllllllIIlIlIIIlIlI));
        }
        catch (NumberFormatException llllllllllllllllllllIIlIlIIIlIll) {
            return null;
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = Block.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final char lllllllllllllllllllIllllIlIlIllI = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllllllllIllllIlIlIllI[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllllllIllllIlIlIllI[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllllllIllllIlIlIllI[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllllllIllllIlIlIllI[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllllllllIllllIlIlIllI[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllllllllIllllIlIlIllI[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return Block.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllllllllIllllIlIlIllI;
    }
    
    @Deprecated
    public int getLightOpacity(final IBlockState llllllllllllllllllllIIlIIllllIlI) {
        return this.lightOpacity;
    }
    
    public void onLanded(final World llllllllllllllllllllIIIIIIIlIlIl, final Entity llllllllllllllllllllIIIIIIIlIIll) {
        llllllllllllllllllllIIIIIIIlIIll.motionY = 0.0;
    }
    
    public void randomDisplayTick(final IBlockState llllllllllllllllllllIIIlIlllIIII, final World llllllllllllllllllllIIIlIllIllll, final BlockPos llllllllllllllllllllIIIlIllIlllI, final Random llllllllllllllllllllIIIlIllIllIl) {
    }
    
    public boolean isAssociatedBlock(final Block lllllllllllllllllllIlllllllIlIlI) {
        return this == lllllllllllllllllllIlllllllIlIlI;
    }
    
    @Deprecated
    public int getPackedLightmapCoords(IBlockState llllllllllllllllllllIIIlllIllIll, final IBlockAccess llllllllllllllllllllIIIlllIllllI, BlockPos llllllllllllllllllllIIIlllIllIIl) {
        final int llllllllllllllllllllIIIlllIlllII = llllllllllllllllllllIIIlllIllllI.getCombinedLight(llllllllllllllllllllIIIlllIllIIl, llllllllllllllllllllIIIlllIllIll.getLightValue());
        if (llllllllllllllllllllIIIlllIlllII == 0 && llllllllllllllllllllIIIlllIllIll.getBlock() instanceof BlockSlab) {
            llllllllllllllllllllIIIlllIllIIl = llllllllllllllllllllIIIlllIllIIl.down();
            llllllllllllllllllllIIIlllIllIll = llllllllllllllllllllIIIlllIllllI.getBlockState(llllllllllllllllllllIIIlllIllIIl);
            return llllllllllllllllllllIIIlllIllllI.getCombinedLight(llllllllllllllllllllIIIlllIllIIl, llllllllllllllllllllIIIlllIllIll.getLightValue());
        }
        return llllllllllllllllllllIIIlllIlllII;
    }
    
    public static boolean isEqualTo(final Block lllllllllllllllllllIlllllllIIlll, final Block lllllllllllllllllllIlllllllIIllI) {
        return lllllllllllllllllllIlllllllIIlll != null && lllllllllllllllllllIlllllllIIllI != null && (lllllllllllllllllllIlllllllIIlll == lllllllllllllllllllIlllllllIIllI || lllllllllllllllllllIlllllllIIlll.isAssociatedBlock(lllllllllllllllllllIlllllllIIllI));
    }
    
    public void fillWithRain(final World lllllllllllllllllllIllllllllIlII, final BlockPos lllllllllllllllllllIllllllllIIll) {
    }
    
    public void harvestBlock(final World llllllllllllllllllllIIIIIllIIlIl, final EntityPlayer llllllllllllllllllllIIIIIllIIlII, final BlockPos llllllllllllllllllllIIIIIllIllII, final IBlockState llllllllllllllllllllIIIIIllIIIlI, @Nullable final TileEntity llllllllllllllllllllIIIIIllIlIlI, final ItemStack llllllllllllllllllllIIIIIllIlIIl) {
        llllllllllllllllllllIIIIIllIIlII.addStat(StatList.getBlockStats(this));
        llllllllllllllllllllIIIIIllIIlII.addExhaustion(0.005f);
        if (this.canSilkHarvest() && EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, llllllllllllllllllllIIIIIllIlIIl) > 0) {
            final ItemStack llllllllllllllllllllIIIIIllIlIII = this.getSilkTouchDrop(llllllllllllllllllllIIIIIllIIIlI);
            spawnAsEntity(llllllllllllllllllllIIIIIllIIlIl, llllllllllllllllllllIIIIIllIllII, llllllllllllllllllllIIIIIllIlIII);
        }
        else {
            final int llllllllllllllllllllIIIIIllIIlll = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, llllllllllllllllllllIIIIIllIlIIl);
            this.dropBlockAsItem(llllllllllllllllllllIIIIIllIIlIl, llllllllllllllllllllIIIIIllIllII, llllllllllllllllllllIIIIIllIIIlI, llllllllllllllllllllIIIIIllIIlll);
        }
    }
    
    @Deprecated
    public float getAmbientOcclusionLightValue(final IBlockState llllllllllllllllllllIIIIIIlIIIIl) {
        return llllllllllllllllllllIIIIIIlIIIIl.isBlockNormalCube() ? 0.2f : 1.0f;
    }
    
    @Deprecated
    @Nullable
    public RayTraceResult collisionRayTrace(final IBlockState llllllllllllllllllllIIIIllIllllI, final World llllllllllllllllllllIIIIllIlllIl, final BlockPos llllllllllllllllllllIIIIllIlllII, final Vec3d llllllllllllllllllllIIIIllIllIll, final Vec3d llllllllllllllllllllIIIIllIllIlI) {
        return this.rayTrace(llllllllllllllllllllIIIIllIlllII, llllllllllllllllllllIIIIllIllIll, llllllllllllllllllllIIIIllIllIlI, llllllllllllllllllllIIIIllIllllI.getBoundingBox(llllllllllllllllllllIIIIllIlllIl, llllllllllllllllllllIIIIllIlllII));
    }
    
    public static int getIdFromBlock(final Block llllllllllllllllllllIIlIlIlIIllI) {
        return Block.REGISTRY.getIDForObject(llllllllllllllllllllIIlIlIlIIllI);
    }
    
    public static Block getBlockFromItem(@Nullable final Item llllllllllllllllllllIIlIlIIlIIlI) {
        return (llllllllllllllllllllIIlIlIIlIIlI instanceof ItemBlock) ? ((ItemBlock)llllllllllllllllllllIIlIlIIlIIlI).getBlock() : Blocks.AIR;
    }
    
    public void onBlockPlacedBy(final World llllllllllllllllllllIIIIIlIIlIII, final BlockPos llllllllllllllllllllIIIIIlIIIlll, final IBlockState llllllllllllllllllllIIIIIlIIIllI, final EntityLivingBase llllllllllllllllllllIIIIIlIIIlIl, final ItemStack llllllllllllllllllllIIIIIlIIIlII) {
    }
    
    @Deprecated
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllllllllllIIIllllIIlll, final IBlockAccess llllllllllllllllllllIIIllllIIllI, final BlockPos llllllllllllllllllllIIIllllIIlIl) {
        return Block.FULL_BLOCK_AABB;
    }
    
    public Vec3d modifyAcceleration(final World llllllllllllllllllllIIIIlIIIllII, final BlockPos llllllllllllllllllllIIIIlIIIlIll, final Entity llllllllllllllllllllIIIIlIIIlIlI, final Vec3d llllllllllllllllllllIIIIlIIIlIIl) {
        return llllllllllllllllllllIIIIlIIIlIIl;
    }
    
    public boolean getEnableStats() {
        return this.enableStats;
    }
    
    public boolean isCollidable() {
        return true;
    }
    
    public boolean canCollideCheck(final IBlockState llllllllllllllllllllIIIllIIIlIIl, final boolean llllllllllllllllllllIIIllIIIlIII) {
        return this.isCollidable();
    }
    
    public void updateTick(final World llllllllllllllllllllIIIlIlllIlIl, final BlockPos llllllllllllllllllllIIIlIlllIlII, final IBlockState llllllllllllllllllllIIIlIlllIIll, final Random llllllllllllllllllllIIIlIlllIIlI) {
    }
    
    public boolean canDropFromExplosion(final Explosion lllllllllllllllllllIllllllllIIII) {
        return true;
    }
    
    @Deprecated
    public int getStrongPower(final IBlockState llllllllllllllllllllIIIIIllllIlI, final IBlockAccess llllllllllllllllllllIIIIIllllIIl, final BlockPos llllllllllllllllllllIIIIIllllIII, final EnumFacing llllllllllllllllllllIIIIIlllIlll) {
        return 0;
    }
    
    public String getUnlocalizedName() {
        return String.valueOf(new StringBuilder("tile.").append(this.unlocalizedName));
    }
    
    static {
        AIR_ID = new ResourceLocation("air");
        REGISTRY = new RegistryNamespacedDefaultedByKey<ResourceLocation, Block>(Block.AIR_ID);
        BLOCK_STATE_IDS = new ObjectIntIdentityMap<IBlockState>();
        FULL_BLOCK_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
        NULL_AABB = null;
    }
    
    @Deprecated
    public boolean shouldSideBeRendered(final IBlockState llllllllllllllllllllIIIlllIlIIIl, final IBlockAccess llllllllllllllllllllIIIlllIlIIII, final BlockPos llllllllllllllllllllIIIlllIIllll, final EnumFacing llllllllllllllllllllIIIlllIIlIIl) {
        final AxisAlignedBB llllllllllllllllllllIIIlllIIllIl = llllllllllllllllllllIIIlllIlIIIl.getBoundingBox(llllllllllllllllllllIIIlllIlIIII, llllllllllllllllllllIIIlllIIllll);
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllllllllIIIlllIIlIIl.ordinal()]) {
            case 1: {
                if (llllllllllllllllllllIIIlllIIllIl.minY > 0.0) {
                    return true;
                }
                break;
            }
            case 2: {
                if (llllllllllllllllllllIIIlllIIllIl.maxY < 1.0) {
                    return true;
                }
                break;
            }
            case 3: {
                if (llllllllllllllllllllIIIlllIIllIl.minZ > 0.0) {
                    return true;
                }
                break;
            }
            case 4: {
                if (llllllllllllllllllllIIIlllIIllIl.maxZ < 1.0) {
                    return true;
                }
                break;
            }
            case 5: {
                if (llllllllllllllllllllIIIlllIIllIl.minX > 0.0) {
                    return true;
                }
                break;
            }
            case 6: {
                if (llllllllllllllllllllIIIlllIIllIl.maxX < 1.0) {
                    return true;
                }
                break;
            }
        }
        return !llllllllllllllllllllIIIlllIlIIII.getBlockState(llllllllllllllllllllIIIlllIIllll.offset(llllllllllllllllllllIIIlllIIlIIl)).isOpaqueCube();
    }
    
    @Deprecated
    public float getBlockHardness(final IBlockState llllllllllllllllllllIIIllllllIII, final World llllllllllllllllllllIIIlllllIlll, final BlockPos llllllllllllllllllllIIIlllllIllI) {
        return this.blockHardness;
    }
    
    public int damageDropped(final IBlockState llllllllllllllllllllIIIIllllIIII) {
        return 0;
    }
    
    @Deprecated
    public Material getMaterial(final IBlockState llllllllllllllllllllIIlIIllIlIlI) {
        return this.blockMaterial;
    }
    
    public void onBlockHarvested(final World lllllllllllllllllllIlllllllllIIl, final BlockPos lllllllllllllllllllIlllllllllIII, final IBlockState lllllllllllllllllllIllllllllIlll, final EntityPlayer lllllllllllllllllllIllllllllIllI) {
    }
    
    @Deprecated
    public boolean func_190946_v(final IBlockState llllllllllllllllllllIIlIIIIIlllI) {
        return false;
    }
    
    @Deprecated
    public boolean isBlockNormalCube(final IBlockState llllllllllllllllllllIIlIIIIllIlI) {
        return llllllllllllllllllllIIlIIIIllIlI.getMaterial().blocksMovement() && llllllllllllllllllllIIlIIIIllIlI.isFullCube();
    }
    
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[0]);
    }
    
    @Deprecated
    public boolean canProvidePower(final IBlockState llllllllllllllllllllIIIIlIIIIIIl) {
        return false;
    }
    
    public static int getStateId(final IBlockState llllllllllllllllllllIIlIlIlIIIll) {
        final Block llllllllllllllllllllIIlIlIlIIIlI = llllllllllllllllllllIIlIlIlIIIll.getBlock();
        return getIdFromBlock(llllllllllllllllllllIIlIlIlIIIlI) + (llllllllllllllllllllIIlIlIlIIIlI.getMetaFromState(llllllllllllllllllllIIlIlIlIIIll) << 12);
    }
    
    public static void spawnAsEntity(final World llllllllllllllllllllIIIlIIIIlllI, final BlockPos llllllllllllllllllllIIIlIIIIllIl, final ItemStack llllllllllllllllllllIIIlIIIIllII) {
        if (!llllllllllllllllllllIIIlIIIIlllI.isRemote && !llllllllllllllllllllIIIlIIIIllII.func_190926_b() && llllllllllllllllllllIIIlIIIIlllI.getGameRules().getBoolean("doTileDrops")) {
            final float llllllllllllllllllllIIIlIIIIlIll = 0.5f;
            final double llllllllllllllllllllIIIlIIIIlIlI = llllllllllllllllllllIIIlIIIIlllI.rand.nextFloat() * 0.5f + 0.25;
            final double llllllllllllllllllllIIIlIIIIlIIl = llllllllllllllllllllIIIlIIIIlllI.rand.nextFloat() * 0.5f + 0.25;
            final double llllllllllllllllllllIIIlIIIIlIII = llllllllllllllllllllIIIlIIIIlllI.rand.nextFloat() * 0.5f + 0.25;
            final EntityItem llllllllllllllllllllIIIlIIIIIlll = new EntityItem(llllllllllllllllllllIIIlIIIIlllI, llllllllllllllllllllIIIlIIIIllIl.getX() + llllllllllllllllllllIIIlIIIIlIlI, llllllllllllllllllllIIIlIIIIllIl.getY() + llllllllllllllllllllIIIlIIIIlIIl, llllllllllllllllllllIIIlIIIIllIl.getZ() + llllllllllllllllllllIIIlIIIIlIII, llllllllllllllllllllIIIlIIIIllII);
            llllllllllllllllllllIIIlIIIIIlll.setDefaultPickupDelay();
            llllllllllllllllllllIIIlIIIIlllI.spawnEntityInWorld(llllllllllllllllllllIIIlIIIIIlll);
        }
    }
    
    @Deprecated
    public IBlockState withRotation(final IBlockState llllllllllllllllllllIIlIIlIlIIII, final Rotation llllllllllllllllllllIIlIIlIlIIIl) {
        return llllllllllllllllllllIIlIIlIlIIII;
    }
    
    public Block setCreativeTab(final CreativeTabs lllllllllllllllllllIllllllllllIl) {
        this.displayOnCreativeTab = lllllllllllllllllllIllllllllllIl;
        return this;
    }
    
    protected Block disableStats() {
        this.enableStats = false;
        return this;
    }
    
    protected void dropXpOnBlockBreak(final World llllllllllllllllllllIIIIllllIlIl, final BlockPos llllllllllllllllllllIIIIllllIlII, int llllllllllllllllllllIIIIllllIIll) {
        if (!llllllllllllllllllllIIIIllllIlIl.isRemote && llllllllllllllllllllIIIIllllIlIl.getGameRules().getBoolean("doTileDrops")) {
            while (llllllllllllllllllllIIIIllllIIll > 0) {
                final int llllllllllllllllllllIIIIllllIllI = EntityXPOrb.getXPSplit(llllllllllllllllllllIIIIllllIIll);
                llllllllllllllllllllIIIIllllIIll -= llllllllllllllllllllIIIIllllIllI;
                llllllllllllllllllllIIIIllllIlIl.spawnEntityInWorld(new EntityXPOrb(llllllllllllllllllllIIIIllllIlIl, llllllllllllllllllllIIIIllllIlII.getX() + 0.5, llllllllllllllllllllIIIIllllIlII.getY() + 0.5, llllllllllllllllllllIIIIllllIlII.getZ() + 0.5, llllllllllllllllllllIIIIllllIllI));
            }
        }
    }
    
    public boolean isPassable(final IBlockAccess llllllllllllllllllllIIlIIIIIlIll, final BlockPos llllllllllllllllllllIIlIIIIIlIlI) {
        return !this.blockMaterial.blocksMovement();
    }
    
    public void onEntityWalk(final World llllllllllllllllllllIIIIlIlIIIlI, final BlockPos llllllllllllllllllllIIIIlIlIIIIl, final Entity llllllllllllllllllllIIIIlIlIIIII) {
    }
    
    protected Block setLightLevel(final float llllllllllllllllllllIIlIIIlIlIlI) {
        this.lightValue = (int)(15.0f * llllllllllllllllllllIIlIIIlIlIlI);
        return this;
    }
    
    @Deprecated
    public boolean isTranslucent(final IBlockState llllllllllllllllllllIIlIIlllIllI) {
        return this.translucent;
    }
    
    public void getSubBlocks(final CreativeTabs llllllllllllllllllllIIIIIIIIIlll, final NonNullList<ItemStack> llllllllllllllllllllIIIIIIIIIllI) {
        llllllllllllllllllllIIIIIIIIIllI.add(new ItemStack(this));
    }
    
    public int tickRate(final World llllllllllllllllllllIIIlIllIIIIl) {
        return 10;
    }
    
    public Block(final Material llllllllllllllllllllIIlIIlIIIllI, final MapColor llllllllllllllllllllIIlIIlIIIlIl) {
        this.enableStats = true;
        this.blockSoundType = SoundType.STONE;
        this.blockParticleGravity = 1.0f;
        this.slipperiness = 0.6f;
        this.blockMaterial = llllllllllllllllllllIIlIIlIIIllI;
        this.blockMapColor = llllllllllllllllllllIIlIIlIIIlIl;
        this.blockState = this.createBlockState();
        this.setDefaultState(this.blockState.getBaseState());
        this.fullBlock = this.getDefaultState().isOpaqueCube();
        this.lightOpacity = (this.fullBlock ? 255 : 0);
        this.translucent = !llllllllllllllllllllIIlIIlIIIllI.blocksLight();
    }
    
    public String getLocalizedName() {
        return I18n.translateToLocal(String.valueOf(new StringBuilder(String.valueOf(this.getUnlocalizedName())).append(".name")));
    }
    
    public boolean canPlaceBlockOnSide(final World llllllllllllllllllllIIIIlIlllIlI, final BlockPos llllllllllllllllllllIIIIlIlllIIl, final EnumFacing llllllllllllllllllllIIIIlIlllIII) {
        return this.canPlaceBlockAt(llllllllllllllllllllIIIIlIlllIlI, llllllllllllllllllllIIIIlIlllIIl);
    }
    
    public void onBlockAdded(final World llllllllllllllllllllIIIlIlIlllll, final BlockPos llllllllllllllllllllIIIlIlIllllI, final IBlockState llllllllllllllllllllIIIlIlIlllIl) {
    }
    
    @Deprecated
    public int getComparatorInputOverride(final IBlockState lllllllllllllllllllIlllllllIIIII, final World lllllllllllllllllllIllllllIlllll, final BlockPos lllllllllllllllllllIllllllIllllI) {
        return 0;
    }
    
    @Deprecated
    public AxisAlignedBB getSelectedBoundingBox(final IBlockState llllllllllllllllllllIIIllIlllIll, final World llllllllllllllllllllIIIllIllllIl, final BlockPos llllllllllllllllllllIIIllIllllII) {
        return llllllllllllllllllllIIIllIlllIll.getBoundingBox(llllllllllllllllllllIIIllIllllIl, llllllllllllllllllllIIIllIllllII).offset(llllllllllllllllllllIIIllIllllII);
    }
    
    @Deprecated
    public EnumBlockRenderType getRenderType(final IBlockState llllllllllllllllllllIIlIIIIIIlll) {
        return EnumBlockRenderType.MODEL;
    }
    
    public boolean canPlaceBlockAt(final World llllllllllllllllllllIIIIlIllIIIl, final BlockPos llllllllllllllllllllIIIIlIlIlllI) {
        return llllllllllllllllllllIIIIlIllIIIl.getBlockState(llllllllllllllllllllIIIIlIlIlllI).getBlock().blockMaterial.isReplaceable();
    }
    
    protected Block setResistance(final float llllllllllllllllllllIIlIIIlIIllI) {
        this.blockResistance = llllllllllllllllllllIIlIIIlIIllI * 3.0f;
        return this;
    }
    
    public boolean requiresUpdates() {
        return true;
    }
    
    public int quantityDropped(final Random llllllllllllllllllllIIIlIlIlIlll) {
        return 1;
    }
    
    @Deprecated
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllllllllIIIlllIIIllI, final IBlockState llllllllllllllllllllIIIlllIIIlIl, final BlockPos llllllllllllllllllllIIIlllIIIlII, final EnumFacing llllllllllllllllllllIIIlllIIIIll) {
        return BlockFaceShape.SOLID;
    }
    
    @Deprecated
    public void addCollisionBoxToList(final IBlockState llllllllllllllllllllIIIllIllIIlI, final World llllllllllllllllllllIIIllIllIIIl, final BlockPos llllllllllllllllllllIIIllIllIIII, final AxisAlignedBB llllllllllllllllllllIIIllIlIllll, final List<AxisAlignedBB> llllllllllllllllllllIIIllIlIIlll, @Nullable final Entity llllllllllllllllllllIIIllIlIllIl, final boolean llllllllllllllllllllIIIllIlIllII) {
        addCollisionBoxToList(llllllllllllllllllllIIIllIllIIII, llllllllllllllllllllIIIllIlIllll, llllllllllllllllllllIIIllIlIIlll, llllllllllllllllllllIIIllIllIIlI.getCollisionBoundingBox(llllllllllllllllllllIIIllIllIIIl, llllllllllllllllllllIIIllIllIIII));
    }
    
    @Deprecated
    public IBlockState getStateFromMeta(final int llllllllllllllllllllIIlIIllIIIII) {
        return this.getDefaultState();
    }
    
    @Deprecated
    public int getWeakPower(final IBlockState llllllllllllllllllllIIIIlIIIIllI, final IBlockAccess llllllllllllllllllllIIIIlIIIIlIl, final BlockPos llllllllllllllllllllIIIIlIIIIlII, final EnumFacing llllllllllllllllllllIIIIlIIIIIll) {
        return 0;
    }
    
    @Deprecated
    public IBlockState withMirror(final IBlockState llllllllllllllllllllIIlIIlIIlIll, final Mirror llllllllllllllllllllIIlIIlIIllII) {
        return llllllllllllllllllllIIlIIlIIlIll;
    }
    
    public BlockStateContainer getBlockState() {
        return this.blockState;
    }
    
    public void dropBlockAsItemWithChance(final World llllllllllllllllllllIIIlIIIllllI, final BlockPos llllllllllllllllllllIIIlIIlIIllI, final IBlockState llllllllllllllllllllIIIlIIlIIlIl, final float llllllllllllllllllllIIIlIIIllIll, final int llllllllllllllllllllIIIlIIIllIlI) {
        if (!llllllllllllllllllllIIIlIIIllllI.isRemote) {
            for (int llllllllllllllllllllIIIlIIlIIIlI = this.quantityDroppedWithBonus(llllllllllllllllllllIIIlIIIllIlI, llllllllllllllllllllIIIlIIIllllI.rand), llllllllllllllllllllIIIlIIlIIIIl = 0; llllllllllllllllllllIIIlIIlIIIIl < llllllllllllllllllllIIIlIIlIIIlI; ++llllllllllllllllllllIIIlIIlIIIIl) {
                if (llllllllllllllllllllIIIlIIIllllI.rand.nextFloat() <= llllllllllllllllllllIIIlIIIllIll) {
                    final Item llllllllllllllllllllIIIlIIlIIIII = this.getItemDropped(llllllllllllllllllllIIIlIIlIIlIl, llllllllllllllllllllIIIlIIIllllI.rand, llllllllllllllllllllIIIlIIIllIlI);
                    if (llllllllllllllllllllIIIlIIlIIIII != Items.field_190931_a) {
                        spawnAsEntity(llllllllllllllllllllIIIlIIIllllI, llllllllllllllllllllIIIlIIlIIllI, new ItemStack(llllllllllllllllllllIIIlIIlIIIII, 1, this.damageDropped(llllllllllllllllllllIIIlIIlIIlIl)));
                    }
                }
            }
        }
    }
    
    @Nullable
    protected RayTraceResult rayTrace(final BlockPos llllllllllllllllllllIIIIllIIlIlI, final Vec3d llllllllllllllllllllIIIIllIlIIII, final Vec3d llllllllllllllllllllIIIIllIIlIII, final AxisAlignedBB llllllllllllllllllllIIIIllIIlllI) {
        final Vec3d llllllllllllllllllllIIIIllIIllIl = llllllllllllllllllllIIIIllIlIIII.subtract(llllllllllllllllllllIIIIllIIlIlI.getX(), llllllllllllllllllllIIIIllIIlIlI.getY(), llllllllllllllllllllIIIIllIIlIlI.getZ());
        final Vec3d llllllllllllllllllllIIIIllIIllII = llllllllllllllllllllIIIIllIIlIII.subtract(llllllllllllllllllllIIIIllIIlIlI.getX(), llllllllllllllllllllIIIIllIIlIlI.getY(), llllllllllllllllllllIIIIllIIlIlI.getZ());
        final RayTraceResult llllllllllllllllllllIIIIllIIlIll = llllllllllllllllllllIIIIllIIlllI.calculateIntercept(llllllllllllllllllllIIIIllIIllIl, llllllllllllllllllllIIIIllIIllII);
        return (llllllllllllllllllllIIIIllIIlIll == null) ? null : new RayTraceResult(llllllllllllllllllllIIIIllIIlIll.hitVec.addVector(llllllllllllllllllllIIIIllIIlIlI.getX(), llllllllllllllllllllIIIIllIIlIlI.getY(), llllllllllllllllllllIIIIllIIlIlI.getZ()), llllllllllllllllllllIIIIllIIlIll.sideHit, llllllllllllllllllllIIIIllIIlIlI);
    }
    
    public boolean hasTileEntity() {
        return this.isBlockContainer;
    }
    
    protected ItemStack getSilkTouchDrop(final IBlockState llllllllllllllllllllIIIIIlIlIlll) {
        final Item llllllllllllllllllllIIIIIlIlIllI = Item.getItemFromBlock(this);
        int llllllllllllllllllllIIIIIlIlIlIl = 0;
        if (llllllllllllllllllllIIIIIlIlIllI.getHasSubtypes()) {
            llllllllllllllllllllIIIIIlIlIlIl = this.getMetaFromState(llllllllllllllllllllIIIIIlIlIlll);
        }
        return new ItemStack(llllllllllllllllllllIIIIIlIlIllI, 1, llllllllllllllllllllIIIIIlIlIlIl);
    }
    
    @Deprecated
    public boolean causesSuffocation(final IBlockState llllllllllllllllllllIIlIIIIlIIll) {
        return this.blockMaterial.blocksMovement() && this.getDefaultState().isFullCube();
    }
    
    protected Block(final Material llllllllllllllllllllIIlIIIlllllI) {
        this(llllllllllllllllllllIIlIIIlllllI, llllllllllllllllllllIIlIIIlllllI.getMaterialMapColor());
    }
    
    protected final void setDefaultState(final IBlockState lllllllllllllllllllIllllllIlIlII) {
        this.defaultBlockState = lllllllllllllllllllIllllllIlIlII;
    }
    
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
    }
    
    @Deprecated
    public EnumPushReaction getMobilityFlag(final IBlockState llllllllllllllllllllIIIIIIlIIllI) {
        return this.blockMaterial.getMobilityFlag();
    }
    
    public void onBlockDestroyedByExplosion(final World llllllllllllllllllllIIIIllIIIIlI, final BlockPos llllllllllllllllllllIIIIllIIIIIl, final Explosion llllllllllllllllllllIIIIllIIIIII) {
    }
    
    protected Block setLightOpacity(final int llllllllllllllllllllIIlIIIllIIlI) {
        this.lightOpacity = llllllllllllllllllllIIlIIIllIIlI;
        return this;
    }
    
    public void breakBlock(final World llllllllllllllllllllIIIlIlIllIll, final BlockPos llllllllllllllllllllIIIlIlIllIlI, final IBlockState llllllllllllllllllllIIIlIlIllIIl) {
    }
    
    public final IBlockState getDefaultState() {
        return this.defaultBlockState;
    }
    
    public boolean canSpawnInBlock() {
        return !this.blockMaterial.isSolid() && !this.blockMaterial.isLiquid();
    }
    
    public void onBlockDestroyedByPlayer(final World llllllllllllllllllllIIIlIllIlIll, final BlockPos llllllllllllllllllllIIIlIllIlIlI, final IBlockState llllllllllllllllllllIIIlIllIlIIl) {
    }
    
    @Deprecated
    public int getLightValue(final IBlockState llllllllllllllllllllIIlIIlllIIlI) {
        return this.lightValue;
    }
    
    @Deprecated
    public MapColor getMapColor(final IBlockState llllllllllllllllllllIIlIIllIIllI, final IBlockAccess llllllllllllllllllllIIlIIllIIlIl, final BlockPos llllllllllllllllllllIIlIIllIIlII) {
        return this.blockMapColor;
    }
    
    @Deprecated
    public boolean isFullCube(final IBlockState llllllllllllllllllllIIlIIIIlIIII) {
        return true;
    }
    
    public void onBlockClicked(final World llllllllllllllllllllIIIIlIIlIIIl, final BlockPos llllllllllllllllllllIIIIlIIlIIII, final EntityPlayer llllllllllllllllllllIIIIlIIIllll) {
    }
    
    public void func_190948_a(final ItemStack lllllllllllllllllllIlllllIlllIII, @Nullable final World lllllllllllllllllllIlllllIllIlll, final List<String> lllllllllllllllllllIlllllIllIllI, final ITooltipFlag lllllllllllllllllllIlllllIllIlIl) {
    }
    
    @Deprecated
    public boolean eventReceived(final IBlockState llllllllllllllllllllIIIIIIllIIll, final World llllllllllllllllllllIIIIIIllIIlI, final BlockPos llllllllllllllllllllIIIIIIllIIIl, final int llllllllllllllllllllIIIIIIllIIII, final int llllllllllllllllllllIIIIIIlIllll) {
        return false;
    }
    
    public void onFallenUpon(final World llllllllllllllllllllIIIIIIIlllIl, final BlockPos llllllllllllllllllllIIIIIIIlllII, final Entity llllllllllllllllllllIIIIIIIllIll, final float llllllllllllllllllllIIIIIIIllIlI) {
        llllllllllllllllllllIIIIIIIllIll.fall(llllllllllllllllllllIIIIIIIllIlI, 1.0f);
    }
    
    protected Block setTickRandomly(final boolean llllllllllllllllllllIIIlllllIIIl) {
        this.needsRandomTick = llllllllllllllllllllIIIlllllIIIl;
        return this;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("Block{").append(Block.REGISTRY.getNameForObject(this)).append("}"));
    }
    
    protected static boolean func_193382_c(final Block llllllllllllllllllllIIlIIIIlllll) {
        return func_193384_b(llllllllllllllllllllIIlIIIIlllll) || llllllllllllllllllllIIlIIIIlllll == Blocks.PISTON || llllllllllllllllllllIIlIIIIlllll == Blocks.STICKY_PISTON || llllllllllllllllllllIIlIIIIlllll == Blocks.PISTON_HEAD;
    }
    
    @Deprecated
    public IBlockState getActualState(final IBlockState llllllllllllllllllllIIlIIlIllIII, final IBlockAccess llllllllllllllllllllIIlIIlIlIlll, final BlockPos llllllllllllllllllllIIlIIlIlIllI) {
        return llllllllllllllllllllIIlIIlIllIII;
    }
    
    protected Block setSoundType(final SoundType llllllllllllllllllllIIlIIIllIllI) {
        this.blockSoundType = llllllllllllllllllllIIlIIIllIllI;
        return this;
    }
    
    public Item getItemDropped(final IBlockState llllllllllllllllllllIIIlIlIlIlII, final Random llllllllllllllllllllIIIlIlIlIIll, final int llllllllllllllllllllIIIlIlIlIIlI) {
        return Item.getItemFromBlock(this);
    }
    
    @Deprecated
    public boolean isNormalCube(final IBlockState llllllllllllllllllllIIlIIIIlIllI) {
        return llllllllllllllllllllIIlIIIIlIllI.getMaterial().isOpaque() && llllllllllllllllllllIIlIIIIlIllI.isFullCube() && !llllllllllllllllllllIIlIIIIlIllI.canProvidePower();
    }
    
    protected static void addCollisionBoxToList(final BlockPos llllllllllllllllllllIIIllIlIIIIl, final AxisAlignedBB llllllllllllllllllllIIIllIIllIll, final List<AxisAlignedBB> llllllllllllllllllllIIIllIIlllll, @Nullable final AxisAlignedBB llllllllllllllllllllIIIllIIllIIl) {
        if (llllllllllllllllllllIIIllIIllIIl != Block.NULL_AABB) {
            final AxisAlignedBB llllllllllllllllllllIIIllIIlllIl = llllllllllllllllllllIIIllIIllIIl.offset(llllllllllllllllllllIIIllIlIIIIl);
            if (llllllllllllllllllllIIIllIIllIll.intersectsWith(llllllllllllllllllllIIIllIIlllIl)) {
                llllllllllllllllllllIIIllIIlllll.add(llllllllllllllllllllIIIllIIlllIl);
            }
        }
    }
    
    @Deprecated
    public boolean hasComparatorInputOverride(final IBlockState lllllllllllllllllllIlllllllIIIlI) {
        return false;
    }
    
    protected Block setHardness(final float llllllllllllllllllllIIIllllllllI) {
        this.blockHardness = llllllllllllllllllllIIIllllllllI;
        if (this.blockResistance < llllllllllllllllllllIIIllllllllI * 5.0f) {
            this.blockResistance = llllllllllllllllllllIIIllllllllI * 5.0f;
        }
        return this;
    }
    
    public static Block getBlockById(final int llllllllllllllllllllIIlIlIIllllI) {
        return Block.REGISTRY.getObjectById(llllllllllllllllllllIIlIlIIllllI);
    }
    
    public static IBlockState getStateById(final int llllllllllllllllllllIIlIlIIllIIl) {
        final int llllllllllllllllllllIIlIlIIllIII = llllllllllllllllllllIIlIlIIllIIl & 0xFFF;
        final int llllllllllllllllllllIIlIlIIlIlll = llllllllllllllllllllIIlIlIIllIIl >> 12 & 0xF;
        return getBlockById(llllllllllllllllllllIIlIlIIllIII).getStateFromMeta(llllllllllllllllllllIIlIlIIlIlll);
    }
    
    public int getMetaFromState(final IBlockState llllllllllllllllllllIIlIIlIllIll) {
        if (llllllllllllllllllllIIlIIlIllIll.getPropertyNames().isEmpty()) {
            return 0;
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder("Don't know how to convert ").append(llllllllllllllllllllIIlIIlIllIll).append(" back into data...")));
    }
    
    protected boolean canSilkHarvest() {
        return this.getDefaultState().isFullCube() && !this.isBlockContainer;
    }
    
    @Deprecated
    public boolean isFullBlock(final IBlockState llllllllllllllllllllIIlIlIIIIIIl) {
        return this.fullBlock;
    }
    
    public static void registerBlocks() {
        registerBlock(0, Block.AIR_ID, new BlockAir().setUnlocalizedName("air"));
        registerBlock(1, "stone", new BlockStone().setHardness(1.5f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("stone"));
        registerBlock(2, "grass", new BlockGrass().setHardness(0.6f).setSoundType(SoundType.PLANT).setUnlocalizedName("grass"));
        registerBlock(3, "dirt", new BlockDirt().setHardness(0.5f).setSoundType(SoundType.GROUND).setUnlocalizedName("dirt"));
        final Block lllllllllllllllllllIlllllIIlllIl = new Block(Material.ROCK).setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("stonebrick").setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        registerBlock(4, "cobblestone", lllllllllllllllllllIlllllIIlllIl);
        final Block lllllllllllllllllllIlllllIIlllII = new BlockPlanks().setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("wood");
        registerBlock(5, "planks", lllllllllllllllllllIlllllIIlllII);
        registerBlock(6, "sapling", new BlockSapling().setHardness(0.0f).setSoundType(SoundType.PLANT).setUnlocalizedName("sapling"));
        registerBlock(7, "bedrock", new BlockEmptyDrops(Material.ROCK).setBlockUnbreakable().setResistance(6000000.0f).setSoundType(SoundType.STONE).setUnlocalizedName("bedrock").disableStats().setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(8, "flowing_water", new BlockDynamicLiquid(Material.WATER).setHardness(100.0f).setLightOpacity(3).setUnlocalizedName("water").disableStats());
        registerBlock(9, "water", new BlockStaticLiquid(Material.WATER).setHardness(100.0f).setLightOpacity(3).setUnlocalizedName("water").disableStats());
        registerBlock(10, "flowing_lava", new BlockDynamicLiquid(Material.LAVA).setHardness(100.0f).setLightLevel(1.0f).setUnlocalizedName("lava").disableStats());
        registerBlock(11, "lava", new BlockStaticLiquid(Material.LAVA).setHardness(100.0f).setLightLevel(1.0f).setUnlocalizedName("lava").disableStats());
        registerBlock(12, "sand", new BlockSand().setHardness(0.5f).setSoundType(SoundType.SAND).setUnlocalizedName("sand"));
        registerBlock(13, "gravel", new BlockGravel().setHardness(0.6f).setSoundType(SoundType.GROUND).setUnlocalizedName("gravel"));
        registerBlock(14, "gold_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("oreGold"));
        registerBlock(15, "iron_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("oreIron"));
        registerBlock(16, "coal_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("oreCoal"));
        registerBlock(17, "log", new BlockOldLog().setUnlocalizedName("log"));
        registerBlock(18, "leaves", new BlockOldLeaf().setUnlocalizedName("leaves"));
        registerBlock(19, "sponge", new BlockSponge().setHardness(0.6f).setSoundType(SoundType.PLANT).setUnlocalizedName("sponge"));
        registerBlock(20, "glass", new BlockGlass(Material.GLASS, false).setHardness(0.3f).setSoundType(SoundType.GLASS).setUnlocalizedName("glass"));
        registerBlock(21, "lapis_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("oreLapis"));
        registerBlock(22, "lapis_block", new Block(Material.IRON, MapColor.LAPIS).setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("blockLapis").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(23, "dispenser", new BlockDispenser().setHardness(3.5f).setSoundType(SoundType.STONE).setUnlocalizedName("dispenser"));
        final Block lllllllllllllllllllIlllllIIllIll = new BlockSandStone().setSoundType(SoundType.STONE).setHardness(0.8f).setUnlocalizedName("sandStone");
        registerBlock(24, "sandstone", lllllllllllllllllllIlllllIIllIll);
        registerBlock(25, "noteblock", new BlockNote().setSoundType(SoundType.WOOD).setHardness(0.8f).setUnlocalizedName("musicBlock"));
        registerBlock(26, "bed", new BlockBed().setSoundType(SoundType.WOOD).setHardness(0.2f).setUnlocalizedName("bed").disableStats());
        registerBlock(27, "golden_rail", new BlockRailPowered().setHardness(0.7f).setSoundType(SoundType.METAL).setUnlocalizedName("goldenRail"));
        registerBlock(28, "detector_rail", new BlockRailDetector().setHardness(0.7f).setSoundType(SoundType.METAL).setUnlocalizedName("detectorRail"));
        registerBlock(29, "sticky_piston", new BlockPistonBase(true).setUnlocalizedName("pistonStickyBase"));
        registerBlock(30, "web", new BlockWeb().setLightOpacity(1).setHardness(4.0f).setUnlocalizedName("web"));
        registerBlock(31, "tallgrass", new BlockTallGrass().setHardness(0.0f).setSoundType(SoundType.PLANT).setUnlocalizedName("tallgrass"));
        registerBlock(32, "deadbush", new BlockDeadBush().setHardness(0.0f).setSoundType(SoundType.PLANT).setUnlocalizedName("deadbush"));
        registerBlock(33, "piston", new BlockPistonBase(false).setUnlocalizedName("pistonBase"));
        registerBlock(34, "piston_head", new BlockPistonExtension().setUnlocalizedName("pistonBase"));
        registerBlock(35, "wool", new BlockColored(Material.CLOTH).setHardness(0.8f).setSoundType(SoundType.CLOTH).setUnlocalizedName("cloth"));
        registerBlock(36, "piston_extension", new BlockPistonMoving());
        registerBlock(37, "yellow_flower", new BlockYellowFlower().setHardness(0.0f).setSoundType(SoundType.PLANT).setUnlocalizedName("flower1"));
        registerBlock(38, "red_flower", new BlockRedFlower().setHardness(0.0f).setSoundType(SoundType.PLANT).setUnlocalizedName("flower2"));
        final Block lllllllllllllllllllIlllllIIllIlI = new BlockMushroom().setHardness(0.0f).setSoundType(SoundType.PLANT).setLightLevel(0.125f).setUnlocalizedName("mushroom");
        registerBlock(39, "brown_mushroom", lllllllllllllllllllIlllllIIllIlI);
        final Block lllllllllllllllllllIlllllIIllIIl = new BlockMushroom().setHardness(0.0f).setSoundType(SoundType.PLANT).setUnlocalizedName("mushroom");
        registerBlock(40, "red_mushroom", lllllllllllllllllllIlllllIIllIIl);
        registerBlock(41, "gold_block", new Block(Material.IRON, MapColor.GOLD).setHardness(3.0f).setResistance(10.0f).setSoundType(SoundType.METAL).setUnlocalizedName("blockGold").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(42, "iron_block", new Block(Material.IRON, MapColor.IRON).setHardness(5.0f).setResistance(10.0f).setSoundType(SoundType.METAL).setUnlocalizedName("blockIron").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(43, "double_stone_slab", new BlockDoubleStoneSlab().setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("stoneSlab"));
        registerBlock(44, "stone_slab", new BlockHalfStoneSlab().setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("stoneSlab"));
        final Block lllllllllllllllllllIlllllIIllIII = new Block(Material.ROCK, MapColor.RED).setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("brick").setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        registerBlock(45, "brick_block", lllllllllllllllllllIlllllIIllIII);
        registerBlock(46, "tnt", new BlockTNT().setHardness(0.0f).setSoundType(SoundType.PLANT).setUnlocalizedName("tnt"));
        registerBlock(47, "bookshelf", new BlockBookshelf().setHardness(1.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("bookshelf"));
        registerBlock(48, "mossy_cobblestone", new Block(Material.ROCK).setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("stoneMoss").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(49, "obsidian", new BlockObsidian().setHardness(50.0f).setResistance(2000.0f).setSoundType(SoundType.STONE).setUnlocalizedName("obsidian"));
        registerBlock(50, "torch", new BlockTorch().setHardness(0.0f).setLightLevel(0.9375f).setSoundType(SoundType.WOOD).setUnlocalizedName("torch"));
        registerBlock(51, "fire", new BlockFire().setHardness(0.0f).setLightLevel(1.0f).setSoundType(SoundType.CLOTH).setUnlocalizedName("fire").disableStats());
        registerBlock(52, "mob_spawner", new BlockMobSpawner().setHardness(5.0f).setSoundType(SoundType.METAL).setUnlocalizedName("mobSpawner").disableStats());
        registerBlock(53, "oak_stairs", new BlockStairs(lllllllllllllllllllIlllllIIlllII.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK)).setUnlocalizedName("stairsWood"));
        registerBlock(54, "chest", new BlockChest(BlockChest.Type.BASIC).setHardness(2.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("chest"));
        registerBlock(55, "redstone_wire", new BlockRedstoneWire().setHardness(0.0f).setSoundType(SoundType.STONE).setUnlocalizedName("redstoneDust").disableStats());
        registerBlock(56, "diamond_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("oreDiamond"));
        registerBlock(57, "diamond_block", new Block(Material.IRON, MapColor.DIAMOND).setHardness(5.0f).setResistance(10.0f).setSoundType(SoundType.METAL).setUnlocalizedName("blockDiamond").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(58, "crafting_table", new BlockWorkbench().setHardness(2.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("workbench"));
        registerBlock(59, "wheat", new BlockCrops().setUnlocalizedName("crops"));
        final Block lllllllllllllllllllIlllllIIlIlll = new BlockFarmland().setHardness(0.6f).setSoundType(SoundType.GROUND).setUnlocalizedName("farmland");
        registerBlock(60, "farmland", lllllllllllllllllllIlllllIIlIlll);
        registerBlock(61, "furnace", new BlockFurnace(false).setHardness(3.5f).setSoundType(SoundType.STONE).setUnlocalizedName("furnace").setCreativeTab(CreativeTabs.DECORATIONS));
        registerBlock(62, "lit_furnace", new BlockFurnace(true).setHardness(3.5f).setSoundType(SoundType.STONE).setLightLevel(0.875f).setUnlocalizedName("furnace"));
        registerBlock(63, "standing_sign", new BlockStandingSign().setHardness(1.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("sign").disableStats());
        registerBlock(64, "wooden_door", new BlockDoor(Material.WOOD).setHardness(3.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("doorOak").disableStats());
        registerBlock(65, "ladder", new BlockLadder().setHardness(0.4f).setSoundType(SoundType.LADDER).setUnlocalizedName("ladder"));
        registerBlock(66, "rail", new BlockRail().setHardness(0.7f).setSoundType(SoundType.METAL).setUnlocalizedName("rail"));
        registerBlock(67, "stone_stairs", new BlockStairs(lllllllllllllllllllIlllllIIlllIl.getDefaultState()).setUnlocalizedName("stairsStone"));
        registerBlock(68, "wall_sign", new BlockWallSign().setHardness(1.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("sign").disableStats());
        registerBlock(69, "lever", new BlockLever().setHardness(0.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("lever"));
        registerBlock(70, "stone_pressure_plate", new BlockPressurePlate(Material.ROCK, BlockPressurePlate.Sensitivity.MOBS).setHardness(0.5f).setSoundType(SoundType.STONE).setUnlocalizedName("pressurePlateStone"));
        registerBlock(71, "iron_door", new BlockDoor(Material.IRON).setHardness(5.0f).setSoundType(SoundType.METAL).setUnlocalizedName("doorIron").disableStats());
        registerBlock(72, "wooden_pressure_plate", new BlockPressurePlate(Material.WOOD, BlockPressurePlate.Sensitivity.EVERYTHING).setHardness(0.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("pressurePlateWood"));
        registerBlock(73, "redstone_ore", new BlockRedstoneOre(false).setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("oreRedstone").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(74, "lit_redstone_ore", new BlockRedstoneOre(true).setLightLevel(0.625f).setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("oreRedstone"));
        registerBlock(75, "unlit_redstone_torch", new BlockRedstoneTorch(false).setHardness(0.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("notGate"));
        registerBlock(76, "redstone_torch", new BlockRedstoneTorch(true).setHardness(0.0f).setLightLevel(0.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("notGate").setCreativeTab(CreativeTabs.REDSTONE));
        registerBlock(77, "stone_button", new BlockButtonStone().setHardness(0.5f).setSoundType(SoundType.STONE).setUnlocalizedName("button"));
        registerBlock(78, "snow_layer", new BlockSnow().setHardness(0.1f).setSoundType(SoundType.SNOW).setUnlocalizedName("snow").setLightOpacity(0));
        registerBlock(79, "ice", new BlockIce().setHardness(0.5f).setLightOpacity(3).setSoundType(SoundType.GLASS).setUnlocalizedName("ice"));
        registerBlock(80, "snow", new BlockSnowBlock().setHardness(0.2f).setSoundType(SoundType.SNOW).setUnlocalizedName("snow"));
        registerBlock(81, "cactus", new BlockCactus().setHardness(0.4f).setSoundType(SoundType.CLOTH).setUnlocalizedName("cactus"));
        registerBlock(82, "clay", new BlockClay().setHardness(0.6f).setSoundType(SoundType.GROUND).setUnlocalizedName("clay"));
        registerBlock(83, "reeds", new BlockReed().setHardness(0.0f).setSoundType(SoundType.PLANT).setUnlocalizedName("reeds").disableStats());
        registerBlock(84, "jukebox", new BlockJukebox().setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("jukebox"));
        registerBlock(85, "fence", new BlockFence(Material.WOOD, BlockPlanks.EnumType.OAK.getMapColor()).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("fence"));
        final Block lllllllllllllllllllIlllllIIlIllI = new BlockPumpkin().setHardness(1.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("pumpkin");
        registerBlock(86, "pumpkin", lllllllllllllllllllIlllllIIlIllI);
        registerBlock(87, "netherrack", new BlockNetherrack().setHardness(0.4f).setSoundType(SoundType.STONE).setUnlocalizedName("hellrock"));
        registerBlock(88, "soul_sand", new BlockSoulSand().setHardness(0.5f).setSoundType(SoundType.SAND).setUnlocalizedName("hellsand"));
        registerBlock(89, "glowstone", new BlockGlowstone(Material.GLASS).setHardness(0.3f).setSoundType(SoundType.GLASS).setLightLevel(1.0f).setUnlocalizedName("lightgem"));
        registerBlock(90, "portal", new BlockPortal().setHardness(-1.0f).setSoundType(SoundType.GLASS).setLightLevel(0.75f).setUnlocalizedName("portal"));
        registerBlock(91, "lit_pumpkin", new BlockPumpkin().setHardness(1.0f).setSoundType(SoundType.WOOD).setLightLevel(1.0f).setUnlocalizedName("litpumpkin"));
        registerBlock(92, "cake", new BlockCake().setHardness(0.5f).setSoundType(SoundType.CLOTH).setUnlocalizedName("cake").disableStats());
        registerBlock(93, "unpowered_repeater", new BlockRedstoneRepeater(false).setHardness(0.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("diode").disableStats());
        registerBlock(94, "powered_repeater", new BlockRedstoneRepeater(true).setHardness(0.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("diode").disableStats());
        registerBlock(95, "stained_glass", new BlockStainedGlass(Material.GLASS).setHardness(0.3f).setSoundType(SoundType.GLASS).setUnlocalizedName("stainedGlass"));
        registerBlock(96, "trapdoor", new BlockTrapDoor(Material.WOOD).setHardness(3.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("trapdoor").disableStats());
        registerBlock(97, "monster_egg", new BlockSilverfish().setHardness(0.75f).setUnlocalizedName("monsterStoneEgg"));
        final Block lllllllllllllllllllIlllllIIlIlIl = new BlockStoneBrick().setHardness(1.5f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("stonebricksmooth");
        registerBlock(98, "stonebrick", lllllllllllllllllllIlllllIIlIlIl);
        registerBlock(99, "brown_mushroom_block", new BlockHugeMushroom(Material.WOOD, MapColor.DIRT, lllllllllllllllllllIlllllIIllIlI).setHardness(0.2f).setSoundType(SoundType.WOOD).setUnlocalizedName("mushroom"));
        registerBlock(100, "red_mushroom_block", new BlockHugeMushroom(Material.WOOD, MapColor.RED, lllllllllllllllllllIlllllIIllIIl).setHardness(0.2f).setSoundType(SoundType.WOOD).setUnlocalizedName("mushroom"));
        registerBlock(101, "iron_bars", new BlockPane(Material.IRON, true).setHardness(5.0f).setResistance(10.0f).setSoundType(SoundType.METAL).setUnlocalizedName("fenceIron"));
        registerBlock(102, "glass_pane", new BlockPane(Material.GLASS, false).setHardness(0.3f).setSoundType(SoundType.GLASS).setUnlocalizedName("thinGlass"));
        final Block lllllllllllllllllllIlllllIIlIlII = new BlockMelon().setHardness(1.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("melon");
        registerBlock(103, "melon_block", lllllllllllllllllllIlllllIIlIlII);
        registerBlock(104, "pumpkin_stem", new BlockStem(lllllllllllllllllllIlllllIIlIllI).setHardness(0.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("pumpkinStem"));
        registerBlock(105, "melon_stem", new BlockStem(lllllllllllllllllllIlllllIIlIlII).setHardness(0.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("pumpkinStem"));
        registerBlock(106, "vine", new BlockVine().setHardness(0.2f).setSoundType(SoundType.PLANT).setUnlocalizedName("vine"));
        registerBlock(107, "fence_gate", new BlockFenceGate(BlockPlanks.EnumType.OAK).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("fenceGate"));
        registerBlock(108, "brick_stairs", new BlockStairs(lllllllllllllllllllIlllllIIllIII.getDefaultState()).setUnlocalizedName("stairsBrick"));
        registerBlock(109, "stone_brick_stairs", new BlockStairs(lllllllllllllllllllIlllllIIlIlIl.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.DEFAULT)).setUnlocalizedName("stairsStoneBrickSmooth"));
        registerBlock(110, "mycelium", new BlockMycelium().setHardness(0.6f).setSoundType(SoundType.PLANT).setUnlocalizedName("mycel"));
        registerBlock(111, "waterlily", new BlockLilyPad().setHardness(0.0f).setSoundType(SoundType.PLANT).setUnlocalizedName("waterlily"));
        final Block lllllllllllllllllllIlllllIIlIIll = new BlockNetherBrick().setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("netherBrick").setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        registerBlock(112, "nether_brick", lllllllllllllllllllIlllllIIlIIll);
        registerBlock(113, "nether_brick_fence", new BlockFence(Material.ROCK, MapColor.NETHERRACK).setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("netherFence"));
        registerBlock(114, "nether_brick_stairs", new BlockStairs(lllllllllllllllllllIlllllIIlIIll.getDefaultState()).setUnlocalizedName("stairsNetherBrick"));
        registerBlock(115, "nether_wart", new BlockNetherWart().setUnlocalizedName("netherStalk"));
        registerBlock(116, "enchanting_table", new BlockEnchantmentTable().setHardness(5.0f).setResistance(2000.0f).setUnlocalizedName("enchantmentTable"));
        registerBlock(117, "brewing_stand", new BlockBrewingStand().setHardness(0.5f).setLightLevel(0.125f).setUnlocalizedName("brewingStand"));
        registerBlock(118, "cauldron", new BlockCauldron().setHardness(2.0f).setUnlocalizedName("cauldron"));
        registerBlock(119, "end_portal", new BlockEndPortal(Material.PORTAL).setHardness(-1.0f).setResistance(6000000.0f));
        registerBlock(120, "end_portal_frame", new BlockEndPortalFrame().setSoundType(SoundType.GLASS).setLightLevel(0.125f).setHardness(-1.0f).setUnlocalizedName("endPortalFrame").setResistance(6000000.0f).setCreativeTab(CreativeTabs.DECORATIONS));
        registerBlock(121, "end_stone", new Block(Material.ROCK, MapColor.SAND).setHardness(3.0f).setResistance(15.0f).setSoundType(SoundType.STONE).setUnlocalizedName("whiteStone").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(122, "dragon_egg", new BlockDragonEgg().setHardness(3.0f).setResistance(15.0f).setSoundType(SoundType.STONE).setLightLevel(0.125f).setUnlocalizedName("dragonEgg"));
        registerBlock(123, "redstone_lamp", new BlockRedstoneLight(false).setHardness(0.3f).setSoundType(SoundType.GLASS).setUnlocalizedName("redstoneLight").setCreativeTab(CreativeTabs.REDSTONE));
        registerBlock(124, "lit_redstone_lamp", new BlockRedstoneLight(true).setHardness(0.3f).setSoundType(SoundType.GLASS).setUnlocalizedName("redstoneLight"));
        registerBlock(125, "double_wooden_slab", new BlockDoubleWoodSlab().setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("woodSlab"));
        registerBlock(126, "wooden_slab", new BlockHalfWoodSlab().setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("woodSlab"));
        registerBlock(127, "cocoa", new BlockCocoa().setHardness(0.2f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("cocoa"));
        registerBlock(128, "sandstone_stairs", new BlockStairs(lllllllllllllllllllIlllllIIllIll.getDefaultState().withProperty(BlockSandStone.TYPE, BlockSandStone.EnumType.SMOOTH)).setUnlocalizedName("stairsSandStone"));
        registerBlock(129, "emerald_ore", new BlockOre().setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("oreEmerald"));
        registerBlock(130, "ender_chest", new BlockEnderChest().setHardness(22.5f).setResistance(1000.0f).setSoundType(SoundType.STONE).setUnlocalizedName("enderChest").setLightLevel(0.5f));
        registerBlock(131, "tripwire_hook", new BlockTripWireHook().setUnlocalizedName("tripWireSource"));
        registerBlock(132, "tripwire", new BlockTripWire().setUnlocalizedName("tripWire"));
        registerBlock(133, "emerald_block", new Block(Material.IRON, MapColor.EMERALD).setHardness(5.0f).setResistance(10.0f).setSoundType(SoundType.METAL).setUnlocalizedName("blockEmerald").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(134, "spruce_stairs", new BlockStairs(lllllllllllllllllllIlllllIIlllII.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE)).setUnlocalizedName("stairsWoodSpruce"));
        registerBlock(135, "birch_stairs", new BlockStairs(lllllllllllllllllllIlllllIIlllII.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.BIRCH)).setUnlocalizedName("stairsWoodBirch"));
        registerBlock(136, "jungle_stairs", new BlockStairs(lllllllllllllllllllIlllllIIlllII.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.JUNGLE)).setUnlocalizedName("stairsWoodJungle"));
        registerBlock(137, "command_block", new BlockCommandBlock(MapColor.BROWN).setBlockUnbreakable().setResistance(6000000.0f).setUnlocalizedName("commandBlock"));
        registerBlock(138, "beacon", new BlockBeacon().setUnlocalizedName("beacon").setLightLevel(1.0f));
        registerBlock(139, "cobblestone_wall", new BlockWall(lllllllllllllllllllIlllllIIlllIl).setUnlocalizedName("cobbleWall"));
        registerBlock(140, "flower_pot", new BlockFlowerPot().setHardness(0.0f).setSoundType(SoundType.STONE).setUnlocalizedName("flowerPot"));
        registerBlock(141, "carrots", new BlockCarrot().setUnlocalizedName("carrots"));
        registerBlock(142, "potatoes", new BlockPotato().setUnlocalizedName("potatoes"));
        registerBlock(143, "wooden_button", new BlockButtonWood().setHardness(0.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("button"));
        registerBlock(144, "skull", new BlockSkull().setHardness(1.0f).setSoundType(SoundType.STONE).setUnlocalizedName("skull"));
        registerBlock(145, "anvil", new BlockAnvil().setHardness(5.0f).setSoundType(SoundType.ANVIL).setResistance(2000.0f).setUnlocalizedName("anvil"));
        registerBlock(146, "trapped_chest", new BlockChest(BlockChest.Type.TRAP).setHardness(2.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("chestTrap"));
        registerBlock(147, "light_weighted_pressure_plate", new BlockPressurePlateWeighted(Material.IRON, 15, MapColor.GOLD).setHardness(0.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("weightedPlate_light"));
        registerBlock(148, "heavy_weighted_pressure_plate", new BlockPressurePlateWeighted(Material.IRON, 150).setHardness(0.5f).setSoundType(SoundType.WOOD).setUnlocalizedName("weightedPlate_heavy"));
        registerBlock(149, "unpowered_comparator", new BlockRedstoneComparator(false).setHardness(0.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("comparator").disableStats());
        registerBlock(150, "powered_comparator", new BlockRedstoneComparator(true).setHardness(0.0f).setLightLevel(0.625f).setSoundType(SoundType.WOOD).setUnlocalizedName("comparator").disableStats());
        registerBlock(151, "daylight_detector", new BlockDaylightDetector(false));
        registerBlock(152, "redstone_block", new BlockCompressedPowered(Material.IRON, MapColor.TNT).setHardness(5.0f).setResistance(10.0f).setSoundType(SoundType.METAL).setUnlocalizedName("blockRedstone").setCreativeTab(CreativeTabs.REDSTONE));
        registerBlock(153, "quartz_ore", new BlockOre(MapColor.NETHERRACK).setHardness(3.0f).setResistance(5.0f).setSoundType(SoundType.STONE).setUnlocalizedName("netherquartz"));
        registerBlock(154, "hopper", new BlockHopper().setHardness(3.0f).setResistance(8.0f).setSoundType(SoundType.METAL).setUnlocalizedName("hopper"));
        final Block lllllllllllllllllllIlllllIIlIIlI = new BlockQuartz().setSoundType(SoundType.STONE).setHardness(0.8f).setUnlocalizedName("quartzBlock");
        registerBlock(155, "quartz_block", lllllllllllllllllllIlllllIIlIIlI);
        registerBlock(156, "quartz_stairs", new BlockStairs(lllllllllllllllllllIlllllIIlIIlI.getDefaultState().withProperty(BlockQuartz.VARIANT, BlockQuartz.EnumType.DEFAULT)).setUnlocalizedName("stairsQuartz"));
        registerBlock(157, "activator_rail", new BlockRailPowered().setHardness(0.7f).setSoundType(SoundType.METAL).setUnlocalizedName("activatorRail"));
        registerBlock(158, "dropper", new BlockDropper().setHardness(3.5f).setSoundType(SoundType.STONE).setUnlocalizedName("dropper"));
        registerBlock(159, "stained_hardened_clay", new BlockStainedHardenedClay().setHardness(1.25f).setResistance(7.0f).setSoundType(SoundType.STONE).setUnlocalizedName("clayHardenedStained"));
        registerBlock(160, "stained_glass_pane", new BlockStainedGlassPane().setHardness(0.3f).setSoundType(SoundType.GLASS).setUnlocalizedName("thinStainedGlass"));
        registerBlock(161, "leaves2", new BlockNewLeaf().setUnlocalizedName("leaves"));
        registerBlock(162, "log2", new BlockNewLog().setUnlocalizedName("log"));
        registerBlock(163, "acacia_stairs", new BlockStairs(lllllllllllllllllllIlllllIIlllII.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA)).setUnlocalizedName("stairsWoodAcacia"));
        registerBlock(164, "dark_oak_stairs", new BlockStairs(lllllllllllllllllllIlllllIIlllII.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK)).setUnlocalizedName("stairsWoodDarkOak"));
        registerBlock(165, "slime", new BlockSlime().setUnlocalizedName("slime").setSoundType(SoundType.SLIME));
        registerBlock(166, "barrier", new BlockBarrier().setUnlocalizedName("barrier"));
        registerBlock(167, "iron_trapdoor", new BlockTrapDoor(Material.IRON).setHardness(5.0f).setSoundType(SoundType.METAL).setUnlocalizedName("ironTrapdoor").disableStats());
        registerBlock(168, "prismarine", new BlockPrismarine().setHardness(1.5f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("prismarine"));
        registerBlock(169, "sea_lantern", new BlockSeaLantern(Material.GLASS).setHardness(0.3f).setSoundType(SoundType.GLASS).setLightLevel(1.0f).setUnlocalizedName("seaLantern"));
        registerBlock(170, "hay_block", new BlockHay().setHardness(0.5f).setSoundType(SoundType.PLANT).setUnlocalizedName("hayBlock").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(171, "carpet", new BlockCarpet().setHardness(0.1f).setSoundType(SoundType.CLOTH).setUnlocalizedName("woolCarpet").setLightOpacity(0));
        registerBlock(172, "hardened_clay", new BlockHardenedClay().setHardness(1.25f).setResistance(7.0f).setSoundType(SoundType.STONE).setUnlocalizedName("clayHardened"));
        registerBlock(173, "coal_block", new Block(Material.ROCK, MapColor.BLACK).setHardness(5.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("blockCoal").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(174, "packed_ice", new BlockPackedIce().setHardness(0.5f).setSoundType(SoundType.GLASS).setUnlocalizedName("icePacked"));
        registerBlock(175, "double_plant", new BlockDoublePlant());
        registerBlock(176, "standing_banner", new BlockBanner.BlockBannerStanding().setHardness(1.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("banner").disableStats());
        registerBlock(177, "wall_banner", new BlockBanner.BlockBannerHanging().setHardness(1.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("banner").disableStats());
        registerBlock(178, "daylight_detector_inverted", new BlockDaylightDetector(true));
        final Block lllllllllllllllllllIlllllIIlIIIl = new BlockRedSandstone().setSoundType(SoundType.STONE).setHardness(0.8f).setUnlocalizedName("redSandStone");
        registerBlock(179, "red_sandstone", lllllllllllllllllllIlllllIIlIIIl);
        registerBlock(180, "red_sandstone_stairs", new BlockStairs(lllllllllllllllllllIlllllIIlIIIl.getDefaultState().withProperty(BlockRedSandstone.TYPE, BlockRedSandstone.EnumType.SMOOTH)).setUnlocalizedName("stairsRedSandStone"));
        registerBlock(181, "double_stone_slab2", new BlockDoubleStoneSlabNew().setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("stoneSlab2"));
        registerBlock(182, "stone_slab2", new BlockHalfStoneSlabNew().setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("stoneSlab2"));
        registerBlock(183, "spruce_fence_gate", new BlockFenceGate(BlockPlanks.EnumType.SPRUCE).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("spruceFenceGate"));
        registerBlock(184, "birch_fence_gate", new BlockFenceGate(BlockPlanks.EnumType.BIRCH).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("birchFenceGate"));
        registerBlock(185, "jungle_fence_gate", new BlockFenceGate(BlockPlanks.EnumType.JUNGLE).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("jungleFenceGate"));
        registerBlock(186, "dark_oak_fence_gate", new BlockFenceGate(BlockPlanks.EnumType.DARK_OAK).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("darkOakFenceGate"));
        registerBlock(187, "acacia_fence_gate", new BlockFenceGate(BlockPlanks.EnumType.ACACIA).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("acaciaFenceGate"));
        registerBlock(188, "spruce_fence", new BlockFence(Material.WOOD, BlockPlanks.EnumType.SPRUCE.getMapColor()).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("spruceFence"));
        registerBlock(189, "birch_fence", new BlockFence(Material.WOOD, BlockPlanks.EnumType.BIRCH.getMapColor()).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("birchFence"));
        registerBlock(190, "jungle_fence", new BlockFence(Material.WOOD, BlockPlanks.EnumType.JUNGLE.getMapColor()).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("jungleFence"));
        registerBlock(191, "dark_oak_fence", new BlockFence(Material.WOOD, BlockPlanks.EnumType.DARK_OAK.getMapColor()).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("darkOakFence"));
        registerBlock(192, "acacia_fence", new BlockFence(Material.WOOD, BlockPlanks.EnumType.ACACIA.getMapColor()).setHardness(2.0f).setResistance(5.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("acaciaFence"));
        registerBlock(193, "spruce_door", new BlockDoor(Material.WOOD).setHardness(3.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("doorSpruce").disableStats());
        registerBlock(194, "birch_door", new BlockDoor(Material.WOOD).setHardness(3.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("doorBirch").disableStats());
        registerBlock(195, "jungle_door", new BlockDoor(Material.WOOD).setHardness(3.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("doorJungle").disableStats());
        registerBlock(196, "acacia_door", new BlockDoor(Material.WOOD).setHardness(3.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("doorAcacia").disableStats());
        registerBlock(197, "dark_oak_door", new BlockDoor(Material.WOOD).setHardness(3.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("doorDarkOak").disableStats());
        registerBlock(198, "end_rod", new BlockEndRod().setHardness(0.0f).setLightLevel(0.9375f).setSoundType(SoundType.WOOD).setUnlocalizedName("endRod"));
        registerBlock(199, "chorus_plant", new BlockChorusPlant().setHardness(0.4f).setSoundType(SoundType.WOOD).setUnlocalizedName("chorusPlant"));
        registerBlock(200, "chorus_flower", new BlockChorusFlower().setHardness(0.4f).setSoundType(SoundType.WOOD).setUnlocalizedName("chorusFlower"));
        final Block lllllllllllllllllllIlllllIIlIIII = new Block(Material.ROCK, MapColor.MAGENTA).setHardness(1.5f).setResistance(10.0f).setSoundType(SoundType.STONE).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setUnlocalizedName("purpurBlock");
        registerBlock(201, "purpur_block", lllllllllllllllllllIlllllIIlIIII);
        registerBlock(202, "purpur_pillar", new BlockRotatedPillar(Material.ROCK, MapColor.MAGENTA).setHardness(1.5f).setResistance(10.0f).setSoundType(SoundType.STONE).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setUnlocalizedName("purpurPillar"));
        registerBlock(203, "purpur_stairs", new BlockStairs(lllllllllllllllllllIlllllIIlIIII.getDefaultState()).setUnlocalizedName("stairsPurpur"));
        registerBlock(204, "purpur_double_slab", new BlockPurpurSlab.Double().setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("purpurSlab"));
        registerBlock(205, "purpur_slab", new BlockPurpurSlab.Half().setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("purpurSlab"));
        registerBlock(206, "end_bricks", new Block(Material.ROCK, MapColor.SAND).setSoundType(SoundType.STONE).setHardness(0.8f).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setUnlocalizedName("endBricks"));
        registerBlock(207, "beetroots", new BlockBeetroot().setUnlocalizedName("beetroots"));
        final Block lllllllllllllllllllIlllllIIIllll = new BlockGrassPath().setHardness(0.65f).setSoundType(SoundType.PLANT).setUnlocalizedName("grassPath").disableStats();
        registerBlock(208, "grass_path", lllllllllllllllllllIlllllIIIllll);
        registerBlock(209, "end_gateway", new BlockEndGateway(Material.PORTAL).setHardness(-1.0f).setResistance(6000000.0f));
        registerBlock(210, "repeating_command_block", new BlockCommandBlock(MapColor.PURPLE).setBlockUnbreakable().setResistance(6000000.0f).setUnlocalizedName("repeatingCommandBlock"));
        registerBlock(211, "chain_command_block", new BlockCommandBlock(MapColor.GREEN).setBlockUnbreakable().setResistance(6000000.0f).setUnlocalizedName("chainCommandBlock"));
        registerBlock(212, "frosted_ice", new BlockFrostedIce().setHardness(0.5f).setLightOpacity(3).setSoundType(SoundType.GLASS).setUnlocalizedName("frostedIce"));
        registerBlock(213, "magma", new BlockMagma().setHardness(0.5f).setSoundType(SoundType.STONE).setUnlocalizedName("magma"));
        registerBlock(214, "nether_wart_block", new Block(Material.GRASS, MapColor.RED).setCreativeTab(CreativeTabs.BUILDING_BLOCKS).setHardness(1.0f).setSoundType(SoundType.WOOD).setUnlocalizedName("netherWartBlock"));
        registerBlock(215, "red_nether_brick", new BlockNetherBrick().setHardness(2.0f).setResistance(10.0f).setSoundType(SoundType.STONE).setUnlocalizedName("redNetherBrick").setCreativeTab(CreativeTabs.BUILDING_BLOCKS));
        registerBlock(216, "bone_block", new BlockBone().setUnlocalizedName("boneBlock"));
        registerBlock(217, "structure_void", new BlockStructureVoid().setUnlocalizedName("structureVoid"));
        registerBlock(218, "observer", new BlockObserver().setHardness(3.0f).setUnlocalizedName("observer"));
        registerBlock(219, "white_shulker_box", new BlockShulkerBox(EnumDyeColor.WHITE).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxWhite"));
        registerBlock(220, "orange_shulker_box", new BlockShulkerBox(EnumDyeColor.ORANGE).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxOrange"));
        registerBlock(221, "magenta_shulker_box", new BlockShulkerBox(EnumDyeColor.MAGENTA).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxMagenta"));
        registerBlock(222, "light_blue_shulker_box", new BlockShulkerBox(EnumDyeColor.LIGHT_BLUE).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxLightBlue"));
        registerBlock(223, "yellow_shulker_box", new BlockShulkerBox(EnumDyeColor.YELLOW).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxYellow"));
        registerBlock(224, "lime_shulker_box", new BlockShulkerBox(EnumDyeColor.LIME).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxLime"));
        registerBlock(225, "pink_shulker_box", new BlockShulkerBox(EnumDyeColor.PINK).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxPink"));
        registerBlock(226, "gray_shulker_box", new BlockShulkerBox(EnumDyeColor.GRAY).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxGray"));
        registerBlock(227, "silver_shulker_box", new BlockShulkerBox(EnumDyeColor.SILVER).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxSilver"));
        registerBlock(228, "cyan_shulker_box", new BlockShulkerBox(EnumDyeColor.CYAN).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxCyan"));
        registerBlock(229, "purple_shulker_box", new BlockShulkerBox(EnumDyeColor.PURPLE).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxPurple"));
        registerBlock(230, "blue_shulker_box", new BlockShulkerBox(EnumDyeColor.BLUE).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxBlue"));
        registerBlock(231, "brown_shulker_box", new BlockShulkerBox(EnumDyeColor.BROWN).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxBrown"));
        registerBlock(232, "green_shulker_box", new BlockShulkerBox(EnumDyeColor.GREEN).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxGreen"));
        registerBlock(233, "red_shulker_box", new BlockShulkerBox(EnumDyeColor.RED).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxRed"));
        registerBlock(234, "black_shulker_box", new BlockShulkerBox(EnumDyeColor.BLACK).setHardness(2.0f).setSoundType(SoundType.STONE).setUnlocalizedName("shulkerBoxBlack"));
        registerBlock(235, "white_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.WHITE));
        registerBlock(236, "orange_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.ORANGE));
        registerBlock(237, "magenta_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.MAGENTA));
        registerBlock(238, "light_blue_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.LIGHT_BLUE));
        registerBlock(239, "yellow_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.YELLOW));
        registerBlock(240, "lime_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.LIME));
        registerBlock(241, "pink_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.PINK));
        registerBlock(242, "gray_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.GRAY));
        registerBlock(243, "silver_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.SILVER));
        registerBlock(244, "cyan_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.CYAN));
        registerBlock(245, "purple_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.PURPLE));
        registerBlock(246, "blue_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.BLUE));
        registerBlock(247, "brown_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.BROWN));
        registerBlock(248, "green_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.GREEN));
        registerBlock(249, "red_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.RED));
        registerBlock(250, "black_glazed_terracotta", new BlockGlazedTerracotta(EnumDyeColor.BLACK));
        registerBlock(251, "concrete", new BlockColored(Material.ROCK).setHardness(1.8f).setSoundType(SoundType.STONE).setUnlocalizedName("concrete"));
        registerBlock(252, "concrete_powder", new BlockConcretePowder().setHardness(0.5f).setSoundType(SoundType.SAND).setUnlocalizedName("concretePowder"));
        registerBlock(255, "structure_block", new BlockStructure().setBlockUnbreakable().setResistance(6000000.0f).setUnlocalizedName("structureBlock"));
        Block.REGISTRY.validateKey();
        for (final Block lllllllllllllllllllIlllllIIIlllI : Block.REGISTRY) {
            if (lllllllllllllllllllIlllllIIIlllI.blockMaterial == Material.AIR) {
                lllllllllllllllllllIlllllIIIlllI.useNeighborBrightness = false;
            }
            else {
                boolean lllllllllllllllllllIlllllIIIllIl = false;
                final boolean lllllllllllllllllllIlllllIIIllII = lllllllllllllllllllIlllllIIIlllI instanceof BlockStairs;
                final boolean lllllllllllllllllllIlllllIIIlIll = lllllllllllllllllllIlllllIIIlllI instanceof BlockSlab;
                final boolean lllllllllllllllllllIlllllIIIlIlI = lllllllllllllllllllIlllllIIIlllI == lllllllllllllllllllIlllllIIlIlll || lllllllllllllllllllIlllllIIIlllI == lllllllllllllllllllIlllllIIIllll;
                final boolean lllllllllllllllllllIlllllIIIlIIl = lllllllllllllllllllIlllllIIIlllI.translucent;
                final boolean lllllllllllllllllllIlllllIIIlIII = lllllllllllllllllllIlllllIIIlllI.lightOpacity == 0;
                if (lllllllllllllllllllIlllllIIIllII || lllllllllllllllllllIlllllIIIlIll || lllllllllllllllllllIlllllIIIlIlI || lllllllllllllllllllIlllllIIIlIIl || lllllllllllllllllllIlllllIIIlIII) {
                    lllllllllllllllllllIlllllIIIllIl = true;
                }
                lllllllllllllllllllIlllllIIIlllI.useNeighborBrightness = lllllllllllllllllllIlllllIIIllIl;
            }
        }
        final Set<Block> lllllllllllllllllllIlllllIIIIlll = (Set<Block>)Sets.newHashSet((Object[])new Block[] { Block.REGISTRY.getObject(new ResourceLocation("tripwire")) });
        for (final Block lllllllllllllllllllIlllllIIIIllI : Block.REGISTRY) {
            if (lllllllllllllllllllIlllllIIIIlll.contains(lllllllllllllllllllIlllllIIIIllI)) {
                for (int lllllllllllllllllllIlllllIIIIlIl = 0; lllllllllllllllllllIlllllIIIIlIl < 15; ++lllllllllllllllllllIlllllIIIIlIl) {
                    final int lllllllllllllllllllIlllllIIIIlII = Block.REGISTRY.getIDForObject(lllllllllllllllllllIlllllIIIIllI) << 4 | lllllllllllllllllllIlllllIIIIlIl;
                    Block.BLOCK_STATE_IDS.put(lllllllllllllllllllIlllllIIIIllI.getStateFromMeta(lllllllllllllllllllIlllllIIIIlIl), lllllllllllllllllllIlllllIIIIlII);
                }
            }
            else {
                for (final IBlockState lllllllllllllllllllIlllllIIIIIlI : lllllllllllllllllllIlllllIIIIllI.getBlockState().getValidStates()) {
                    final int lllllllllllllllllllIlllllIIIIIIl = Block.REGISTRY.getIDForObject(lllllllllllllllllllIlllllIIIIllI) << 4 | lllllllllllllllllllIlllllIIIIllI.getMetaFromState(lllllllllllllllllllIlllllIIIIIlI);
                    Block.BLOCK_STATE_IDS.put(lllllllllllllllllllIlllllIIIIIlI, lllllllllllllllllllIlllllIIIIIIl);
                }
            }
        }
    }
    
    public int quantityDroppedWithBonus(final int llllllllllllllllllllIIIIIlIIllIl, final Random llllllllllllllllllllIIIIIlIIlIlI) {
        return this.quantityDropped(llllllllllllllllllllIIIIIlIIlIlI);
    }
    
    public boolean getTickRandomly() {
        return this.needsRandomTick;
    }
    
    @Deprecated
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llllllllllllllllllllIIIllIIlIIll, final IBlockAccess llllllllllllllllllllIIIllIIlIIlI, final BlockPos llllllllllllllllllllIIIllIIIlllI) {
        return llllllllllllllllllllIIIllIIlIIll.getBoundingBox(llllllllllllllllllllIIIllIIlIIlI, llllllllllllllllllllIIIllIIIlllI);
    }
    
    @Deprecated
    public boolean isFullyOpaque(final IBlockState llllllllllllllllllllIIlIlIIIIlIl) {
        return llllllllllllllllllllIIlIlIIIIlIl.getMaterial().isOpaque() && llllllllllllllllllllIIlIlIIIIlIl.isFullCube();
    }
    
    public Block setUnlocalizedName(final String llllllllllllllllllllIIIIIIlllIll) {
        this.unlocalizedName = llllllllllllllllllllIIIIIIlllIll;
        return this;
    }
    
    public IBlockState onBlockPlaced(final World llllllllllllllllllllIIIIlIIlllII, final BlockPos llllllllllllllllllllIIIIlIIllIll, final EnumFacing llllllllllllllllllllIIIIlIIllIlI, final float llllllllllllllllllllIIIIlIIllIIl, final float llllllllllllllllllllIIIIlIIllIII, final float llllllllllllllllllllIIIIlIIlIlll, final int llllllllllllllllllllIIIIlIIlIIll, final EntityLivingBase llllllllllllllllllllIIIIlIIlIlIl) {
        return this.getStateFromMeta(llllllllllllllllllllIIIIlIIlIIll);
    }
    
    @Deprecated
    public boolean getUseNeighborBrightness(final IBlockState llllllllllllllllllllIIlIIllIlllI) {
        return this.useNeighborBrightness;
    }
    
    @Deprecated
    public void neighborChanged(final IBlockState llllllllllllllllllllIIIlIllIIlll, final World llllllllllllllllllllIIIlIllIIllI, final BlockPos llllllllllllllllllllIIIlIllIIlIl, final Block llllllllllllllllllllIIIlIllIIlII, final BlockPos llllllllllllllllllllIIIlIllIIIll) {
    }
    
    public EnumOffsetType getOffsetType() {
        return EnumOffsetType.NONE;
    }
    
    public boolean onBlockActivated(final World llllllllllllllllllllIIIIlIlIllII, final BlockPos llllllllllllllllllllIIIIlIlIlIll, final IBlockState llllllllllllllllllllIIIIlIlIlIlI, final EntityPlayer llllllllllllllllllllIIIIlIlIlIIl, final EnumHand llllllllllllllllllllIIIIlIlIlIII, final EnumFacing llllllllllllllllllllIIIIlIlIIlll, final float llllllllllllllllllllIIIIlIlIIllI, final float llllllllllllllllllllIIIIlIlIIlIl, final float llllllllllllllllllllIIIIlIlIIlII) {
        return false;
    }
    
    @Deprecated
    public float getPlayerRelativeBlockHardness(final IBlockState llllllllllllllllllllIIIlIlIIIlIl, final EntityPlayer llllllllllllllllllllIIIlIlIIlIIl, final World llllllllllllllllllllIIIlIlIIIIll, final BlockPos llllllllllllllllllllIIIlIlIIIIlI) {
        final float llllllllllllllllllllIIIlIlIIIllI = llllllllllllllllllllIIIlIlIIIlIl.getBlockHardness(llllllllllllllllllllIIIlIlIIIIll, llllllllllllllllllllIIIlIlIIIIlI);
        if (llllllllllllllllllllIIIlIlIIIllI < 0.0f) {
            return 0.0f;
        }
        return llllllllllllllllllllIIIlIlIIlIIl.canHarvestBlock(llllllllllllllllllllIIIlIlIIIlIl) ? (llllllllllllllllllllIIIlIlIIlIIl.getDigSpeed(llllllllllllllllllllIIIlIlIIIlIl) / llllllllllllllllllllIIIlIlIIIllI / 30.0f) : (llllllllllllllllllllIIIlIlIIlIIl.getDigSpeed(llllllllllllllllllllIIIlIlIIIlIl) / llllllllllllllllllllIIIlIlIIIllI / 100.0f);
    }
    
    public ItemStack getItem(final World llllllllllllllllllllIIIIIIIIllll, final BlockPos llllllllllllllllllllIIIIIIIIlllI, final IBlockState llllllllllllllllllllIIIIIIIIllIl) {
        return new ItemStack(Item.getItemFromBlock(this), 1, this.damageDropped(llllllllllllllllllllIIIIIIIIllIl));
    }
    
    public CreativeTabs getCreativeTabToDisplayOn() {
        return this.displayOnCreativeTab;
    }
    
    protected static boolean func_193384_b(final Block llllllllllllllllllllIIlIIIlIIIIl) {
        return llllllllllllllllllllIIlIIIlIIIIl instanceof BlockShulkerBox || llllllllllllllllllllIIlIIIlIIIIl instanceof BlockLeaves || llllllllllllllllllllIIlIIIlIIIIl instanceof BlockTrapDoor || llllllllllllllllllllIIlIIIlIIIIl == Blocks.BEACON || llllllllllllllllllllIIlIIIlIIIIl == Blocks.CAULDRON || llllllllllllllllllllIIlIIIlIIIIl == Blocks.GLASS || llllllllllllllllllllIIlIIIlIIIIl == Blocks.GLOWSTONE || llllllllllllllllllllIIlIIIlIIIIl == Blocks.ICE || llllllllllllllllllllIIlIIIlIIIIl == Blocks.SEA_LANTERN || llllllllllllllllllllIIlIIIlIIIIl == Blocks.STAINED_GLASS;
    }
    
    public SoundType getSoundType() {
        return this.blockSoundType;
    }
    
    public final void dropBlockAsItem(final World llllllllllllllllllllIIIlIIlllIlI, final BlockPos llllllllllllllllllllIIIlIIllIlII, final IBlockState llllllllllllllllllllIIIlIIlllIII, final int llllllllllllllllllllIIIlIIllIIlI) {
        this.dropBlockAsItemWithChance(llllllllllllllllllllIIIlIIlllIlI, llllllllllllllllllllIIIlIIllIlII, llllllllllllllllllllIIIlIIlllIII, 1.0f, llllllllllllllllllllIIIlIIllIIlI);
    }
    
    public boolean isReplaceable(final IBlockAccess llllllllllllllllllllIIlIIIIIIlIl, final BlockPos llllllllllllllllllllIIlIIIIIIlII) {
        return false;
    }
    
    protected Block setBlockUnbreakable() {
        this.setHardness(-1.0f);
        return this;
    }
    
    public void onEntityCollidedWithBlock(final World llllllllllllllllllllIIIIIlllllll, final BlockPos llllllllllllllllllllIIIIIllllllI, final IBlockState llllllllllllllllllllIIIIIlllllIl, final Entity llllllllllllllllllllIIIIIlllllII) {
    }
    
    public float getExplosionResistance(final Entity llllllllllllllllllllIIIIlllIllIl) {
        return this.blockResistance / 5.0f;
    }
    
    @Deprecated
    public Vec3d func_190949_e(final IBlockState lllllllllllllllllllIllllllIIlIII, final IBlockAccess lllllllllllllllllllIllllllIIIlll, final BlockPos lllllllllllllllllllIllllllIIIllI) {
        final EnumOffsetType lllllllllllllllllllIllllllIIIlIl = this.getOffsetType();
        if (lllllllllllllllllllIllllllIIIlIl == EnumOffsetType.NONE) {
            return Vec3d.ZERO;
        }
        final long lllllllllllllllllllIllllllIIIlII = MathHelper.getCoordinateRandom(lllllllllllllllllllIllllllIIIllI.getX(), 0, lllllllllllllllllllIllllllIIIllI.getZ());
        return new Vec3d(((lllllllllllllllllllIllllllIIIlII >> 16 & 0xFL) / 15.0f - 0.5) * 0.5, (lllllllllllllllllllIllllllIIIlIl == EnumOffsetType.XYZ) ? (((lllllllllllllllllllIllllllIIIlII >> 20 & 0xFL) / 15.0f - 1.0) * 0.2) : 0.0, ((lllllllllllllllllllIllllllIIIlII >> 24 & 0xFL) / 15.0f - 0.5) * 0.5);
    }
    
    @Deprecated
    public boolean isOpaqueCube(final IBlockState llllllllllllllllllllIIIllIIIllII) {
        return true;
    }
    
    private static void registerBlock(final int lllllllllllllllllllIllllIllIIllI, final ResourceLocation lllllllllllllllllllIllllIllIIIlI, final Block lllllllllllllllllllIllllIllIIlII) {
        Block.REGISTRY.register(lllllllllllllllllllIllllIllIIllI, lllllllllllllllllllIllllIllIIIlI, lllllllllllllllllllIllllIllIIlII);
    }
    
    public void randomTick(final World llllllllllllllllllllIIIlIllllIlI, final BlockPos llllllllllllllllllllIIIlIllllIIl, final IBlockState llllllllllllllllllllIIIlIlllllIl, final Random llllllllllllllllllllIIIlIlllIlll) {
        this.updateTick(llllllllllllllllllllIIIlIllllIlI, llllllllllllllllllllIIIlIllllIIl, llllllllllllllllllllIIIlIlllllIl, llllllllllllllllllllIIIlIlllIlll);
    }
    
    public enum EnumOffsetType
    {
        XYZ("XYZ", 2), 
        XZ("XZ", 1), 
        NONE("NONE", 0);
        
        private EnumOffsetType(final String lllllllllllllIlllIIlllllllIlllIl, final int lllllllllllllIlllIIlllllllIlllII) {
        }
    }
}
