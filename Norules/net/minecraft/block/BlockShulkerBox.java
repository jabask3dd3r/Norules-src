package net.minecraft.block;

import net.minecraft.init.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.client.util.*;
import net.minecraft.util.text.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.tileentity.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.stats.*;

public class BlockShulkerBox extends BlockContainer
{
    public static final /* synthetic */ PropertyEnum<EnumFacing> field_190957_a;
    private final /* synthetic */ EnumDyeColor field_190958_b;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$item$EnumDyeColor;
    
    @Override
    public boolean causesSuffocation(final IBlockState lllllllllllllIIlIlIlIIlIlIIIIIll) {
        return true;
    }
    
    @Override
    public boolean func_190946_v(final IBlockState lllllllllllllIIlIlIlIIlIIlllllll) {
        return true;
    }
    
    public static Block func_190952_a(final EnumDyeColor lllllllllllllIIlIlIlIIIllIlIlIIl) {
        switch ($SWITCH_TABLE$net$minecraft$item$EnumDyeColor()[lllllllllllllIIlIlIlIIIllIlIlIIl.ordinal()]) {
            case 1: {
                return Blocks.field_190977_dl;
            }
            case 2: {
                return Blocks.field_190978_dm;
            }
            case 3: {
                return Blocks.field_190979_dn;
            }
            case 4: {
                return Blocks.field_190980_do;
            }
            case 5: {
                return Blocks.field_190981_dp;
            }
            case 6: {
                return Blocks.field_190982_dq;
            }
            case 7: {
                return Blocks.field_190983_dr;
            }
            case 8: {
                return Blocks.field_190984_ds;
            }
            case 9: {
                return Blocks.field_190985_dt;
            }
            case 10: {
                return Blocks.field_190986_du;
            }
            default: {
                return Blocks.field_190987_dv;
            }
            case 12: {
                return Blocks.field_190988_dw;
            }
            case 13: {
                return Blocks.field_190989_dx;
            }
            case 14: {
                return Blocks.field_190990_dy;
            }
            case 15: {
                return Blocks.field_190991_dz;
            }
            case 16: {
                return Blocks.field_190975_dA;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$item$EnumDyeColor() {
        final int[] $switch_TABLE$net$minecraft$item$EnumDyeColor = BlockShulkerBox.$SWITCH_TABLE$net$minecraft$item$EnumDyeColor;
        if ($switch_TABLE$net$minecraft$item$EnumDyeColor != null) {
            return $switch_TABLE$net$minecraft$item$EnumDyeColor;
        }
        final String lllllllllllllIIlIlIlIIIlIllllllI = (Object)new int[EnumDyeColor.values().length];
        try {
            lllllllllllllIIlIlIlIIIlIllllllI[EnumDyeColor.BLACK.ordinal()] = 16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIlIlIlIIIlIllllllI[EnumDyeColor.BLUE.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIlIlIlIIIlIllllllI[EnumDyeColor.BROWN.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIlIlIlIIIlIllllllI[EnumDyeColor.CYAN.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIlIlIlIIIlIllllllI[EnumDyeColor.GRAY.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIIlIlIlIIIlIllllllI[EnumDyeColor.GREEN.ordinal()] = 14;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllllIIlIlIlIIIlIllllllI[EnumDyeColor.LIGHT_BLUE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            lllllllllllllIIlIlIlIIIlIllllllI[EnumDyeColor.LIME.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            lllllllllllllIIlIlIlIIIlIllllllI[EnumDyeColor.MAGENTA.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            lllllllllllllIIlIlIlIIIlIllllllI[EnumDyeColor.ORANGE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        try {
            lllllllllllllIIlIlIlIIIlIllllllI[EnumDyeColor.PINK.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError11) {}
        try {
            lllllllllllllIIlIlIlIIIlIllllllI[EnumDyeColor.PURPLE.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError12) {}
        try {
            lllllllllllllIIlIlIlIIIlIllllllI[EnumDyeColor.RED.ordinal()] = 15;
        }
        catch (NoSuchFieldError noSuchFieldError13) {}
        try {
            lllllllllllllIIlIlIlIIIlIllllllI[EnumDyeColor.SILVER.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError14) {}
        try {
            lllllllllllllIIlIlIlIIIlIllllllI[EnumDyeColor.WHITE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError15) {}
        try {
            lllllllllllllIIlIlIlIIIlIllllllI[EnumDyeColor.YELLOW.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError16) {}
        return BlockShulkerBox.$SWITCH_TABLE$net$minecraft$item$EnumDyeColor = (int[])(Object)lllllllllllllIIlIlIlIIIlIllllllI;
    }
    
    @Override
    public void func_190948_a(final ItemStack lllllllllllllIIlIlIlIIIlllllIlIl, @Nullable final World lllllllllllllIIlIlIlIIIllllIlIIl, final List<String> lllllllllllllIIlIlIlIIIlllllIIll, final ITooltipFlag lllllllllllllIIlIlIlIIIllllIIlll) {
        super.func_190948_a(lllllllllllllIIlIlIlIIIlllllIlIl, lllllllllllllIIlIlIlIIIllllIlIIl, lllllllllllllIIlIlIlIIIlllllIIll, lllllllllllllIIlIlIlIIIllllIIlll);
        final NBTTagCompound lllllllllllllIIlIlIlIIIlllllIIIl = lllllllllllllIIlIlIlIIIlllllIlIl.getTagCompound();
        if (lllllllllllllIIlIlIlIIIlllllIIIl != null && lllllllllllllIIlIlIlIIIlllllIIIl.hasKey("BlockEntityTag", 10)) {
            final NBTTagCompound lllllllllllllIIlIlIlIIIlllllIIII = lllllllllllllIIlIlIlIIIlllllIIIl.getCompoundTag("BlockEntityTag");
            if (lllllllllllllIIlIlIlIIIlllllIIII.hasKey("LootTable", 8)) {
                lllllllllllllIIlIlIlIIIlllllIIll.add("???????");
            }
            if (lllllllllllllIIlIlIlIIIlllllIIII.hasKey("Items", 9)) {
                final NonNullList<ItemStack> lllllllllllllIIlIlIlIIIllllIllll = NonNullList.func_191197_a(27, ItemStack.field_190927_a);
                ItemStackHelper.func_191283_b(lllllllllllllIIlIlIlIIIlllllIIII, lllllllllllllIIlIlIlIIIllllIllll);
                int lllllllllllllIIlIlIlIIIllllIlllI = 0;
                int lllllllllllllIIlIlIlIIIllllIllIl = 0;
                for (final ItemStack lllllllllllllIIlIlIlIIIllllIllII : lllllllllllllIIlIlIlIIIllllIllll) {
                    if (!lllllllllllllIIlIlIlIIIllllIllII.func_190926_b()) {
                        ++lllllllllllllIIlIlIlIIIllllIllIl;
                        if (lllllllllllllIIlIlIlIIIllllIlllI > 4) {
                            continue;
                        }
                        ++lllllllllllllIIlIlIlIIIllllIlllI;
                        lllllllllllllIIlIlIlIIIlllllIIll.add(String.format("%s x%d", lllllllllllllIIlIlIlIIIllllIllII.getDisplayName(), lllllllllllllIIlIlIlIIIllllIllII.func_190916_E()));
                    }
                }
                if (lllllllllllllIIlIlIlIIIllllIllIl - lllllllllllllIIlIlIlIIIllllIlllI > 0) {
                    lllllllllllllIIlIlIlIIIlllllIIll.add(String.format(String.valueOf(new StringBuilder().append(TextFormatting.ITALIC).append(I18n.translateToLocal("container.shulkerBox.more"))), lllllllllllllIIlIlIlIIIllllIllIl - lllllllllllllIIlIlIlIIIllllIlllI));
                }
            }
        }
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIIlIlIlIIIlllIlIlII, final IBlockAccess lllllllllllllIIlIlIlIIIlllIlIIll, final BlockPos lllllllllllllIIlIlIlIIIlllIlIIlI) {
        final TileEntity lllllllllllllIIlIlIlIIIlllIlIlIl = lllllllllllllIIlIlIlIIIlllIlIIll.getTileEntity(lllllllllllllIIlIlIlIIIlllIlIIlI);
        return (lllllllllllllIIlIlIlIIIlllIlIlIl instanceof TileEntityShulkerBox) ? ((TileEntityShulkerBox)lllllllllllllIIlIlIlIIIlllIlIlIl).func_190584_a(lllllllllllllIIlIlIlIIIlllIlIlII) : BlockShulkerBox.FULL_BLOCK_AABB;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIIlIlIlIIlIlIIIIIIl) {
        return false;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIlIlIlIIlIIlIIIlIl) {
        final EnumFacing lllllllllllllIIlIlIlIIlIIlIIIlII = EnumFacing.getFront(lllllllllllllIIlIlIlIIlIIlIIIlIl);
        return this.getDefaultState().withProperty(BlockShulkerBox.field_190957_a, lllllllllllllIIlIlIlIIlIIlIIIlII);
    }
    
    @Override
    public void breakBlock(final World lllllllllllllIIlIlIlIIlIIIIlIIll, final BlockPos lllllllllllllIIlIlIlIIlIIIIlIIlI, final IBlockState lllllllllllllIIlIlIlIIlIIIIIlIII) {
        final TileEntity lllllllllllllIIlIlIlIIlIIIIlIIII = lllllllllllllIIlIlIlIIlIIIIlIIll.getTileEntity(lllllllllllllIIlIlIlIIlIIIIlIIlI);
        if (lllllllllllllIIlIlIlIIlIIIIlIIII instanceof TileEntityShulkerBox) {
            final TileEntityShulkerBox lllllllllllllIIlIlIlIIlIIIIIllll = (TileEntityShulkerBox)lllllllllllllIIlIlIlIIlIIIIlIIII;
            if (!lllllllllllllIIlIlIlIIlIIIIIllll.func_190590_r() && lllllllllllllIIlIlIlIIlIIIIIllll.func_190582_F()) {
                final ItemStack lllllllllllllIIlIlIlIIlIIIIIlllI = new ItemStack(Item.getItemFromBlock(this));
                final NBTTagCompound lllllllllllllIIlIlIlIIlIIIIIllIl = new NBTTagCompound();
                final NBTTagCompound lllllllllllllIIlIlIlIIlIIIIIllII = new NBTTagCompound();
                lllllllllllllIIlIlIlIIlIIIIIllIl.setTag("BlockEntityTag", ((TileEntityShulkerBox)lllllllllllllIIlIlIlIIlIIIIlIIII).func_190580_f(lllllllllllllIIlIlIlIIlIIIIIllII));
                lllllllllllllIIlIlIlIIlIIIIIlllI.setTagCompound(lllllllllllllIIlIlIlIIlIIIIIllIl);
                if (lllllllllllllIIlIlIlIIlIIIIIllll.hasCustomName()) {
                    lllllllllllllIIlIlIlIIlIIIIIlllI.setStackDisplayName(lllllllllllllIIlIlIlIIlIIIIIllll.getName());
                    lllllllllllllIIlIlIlIIlIIIIIllll.func_190575_a("");
                }
                Block.spawnAsEntity(lllllllllllllIIlIlIlIIlIIIIlIIll, lllllllllllllIIlIlIlIIlIIIIlIIlI, lllllllllllllIIlIlIlIIlIIIIIlllI);
            }
            lllllllllllllIIlIlIlIIlIIIIlIIll.updateComparatorOutputLevel(lllllllllllllIIlIlIlIIlIIIIlIIlI, lllllllllllllIIlIlIlIIlIIIIIlIII.getBlock());
        }
        super.breakBlock(lllllllllllllIIlIlIlIIlIIIIlIIll, lllllllllllllIIlIlIlIIlIIIIlIIlI, lllllllllllllIIlIlIlIIlIIIIIlIII);
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllIIlIlIlIIlIlIIIlIIl, final int lllllllllllllIIlIlIlIIlIlIIIlIII) {
        return new TileEntityShulkerBox(this.field_190958_b);
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllllIIlIlIlIIlIIlllllIl) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllllIIlIlIlIIlIIIllIIIl, final BlockPos lllllllllllllIIlIlIlIIlIIIllIIII, final IBlockState lllllllllllllIIlIlIlIIlIIIlIllll, final float lllllllllllllIIlIlIlIIlIIIlIlllI, final int lllllllllllllIIlIlIlIIlIIIlIllIl) {
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllIIlIlIlIIlIIlIllIlI, final BlockPos lllllllllllllIIlIlIlIIlIIlIllIIl, final EnumFacing lllllllllllllIIlIlIlIIlIIlIllIII, final float lllllllllllllIIlIlIlIIlIIlIlIlll, final float lllllllllllllIIlIlIlIIlIIlIlIllI, final float lllllllllllllIIlIlIlIIlIIlIlIlIl, final int lllllllllllllIIlIlIlIIlIIlIlIlII, final EntityLivingBase lllllllllllllIIlIlIlIIlIIlIlIIll) {
        return this.getDefaultState().withProperty(BlockShulkerBox.field_190957_a, lllllllllllllIIlIlIlIIlIIlIllIII);
    }
    
    public static EnumDyeColor func_190954_c(final Block lllllllllllllIIlIlIlIIIllIlIllII) {
        return (lllllllllllllIIlIlIlIIIllIlIllII instanceof BlockShulkerBox) ? ((BlockShulkerBox)lllllllllllllIIlIlIlIIIllIlIllII).func_190956_e() : EnumDyeColor.PURPLE;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIlIlIlIIlIIlIIlIlI) {
        return lllllllllllllIIlIlIlIIlIIlIIlIlI.getValue(BlockShulkerBox.field_190957_a).getIndex();
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIIlIlIlIIIllIIlIllI, final Mirror lllllllllllllIIlIlIlIIIllIIlIlll) {
        return lllllllllllllIIlIlIlIIIllIIlIllI.withRotation(lllllllllllllIIlIlIlIIIllIIlIlll.toRotation(lllllllllllllIIlIlIlIIIllIIlIllI.getValue(BlockShulkerBox.field_190957_a)));
    }
    
    static {
        field_190957_a = PropertyDirection.create("facing");
    }
    
    public static ItemStack func_190953_b(final EnumDyeColor lllllllllllllIIlIlIlIIIllIlIIlII) {
        return new ItemStack(func_190952_a(lllllllllllllIIlIlIlIIIllIlIIlII));
    }
    
    public BlockShulkerBox(final EnumDyeColor lllllllllllllIIlIlIlIIlIlIIIlllI) {
        super(Material.ROCK, MapColor.AIR);
        this.field_190958_b = lllllllllllllIIlIlIlIIlIlIIIlllI;
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockShulkerBox.field_190957_a, EnumFacing.UP));
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIIlIlIlIIlIlIIIIlIl) {
        return false;
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllllIIlIlIlIIlIIIlIIIIl, final BlockPos lllllllllllllIIlIlIlIIlIIIlIIIII, final IBlockState lllllllllllllIIlIlIlIIlIIIlIIlIl, final EntityLivingBase lllllllllllllIIlIlIlIIlIIIlIIlII, final ItemStack lllllllllllllIIlIlIlIIlIIIlIIIll) {
        if (lllllllllllllIIlIlIlIIlIIIlIIIll.hasDisplayName()) {
            final TileEntity lllllllllllllIIlIlIlIIlIIIlIIIlI = lllllllllllllIIlIlIlIIlIIIlIIIIl.getTileEntity(lllllllllllllIIlIlIlIIlIIIlIIIII);
            if (lllllllllllllIIlIlIlIIlIIIlIIIlI instanceof TileEntityShulkerBox) {
                ((TileEntityShulkerBox)lllllllllllllIIlIlIlIIlIIIlIIIlI).func_190575_a(lllllllllllllIIlIlIlIIlIIIlIIIll.getDisplayName());
            }
        }
    }
    
    @Override
    public void onBlockHarvested(final World lllllllllllllIIlIlIlIIlIIIlllIll, final BlockPos lllllllllllllIIlIlIlIIlIIIllIlIl, final IBlockState lllllllllllllIIlIlIlIIlIIIlllIIl, final EntityPlayer lllllllllllllIIlIlIlIIlIIIlllIII) {
        if (lllllllllllllIIlIlIlIIlIIIlllIll.getTileEntity(lllllllllllllIIlIlIlIIlIIIllIlIl) instanceof TileEntityShulkerBox) {
            final TileEntityShulkerBox lllllllllllllIIlIlIlIIlIIIllIlll = (TileEntityShulkerBox)lllllllllllllIIlIlIlIIlIIIlllIll.getTileEntity(lllllllllllllIIlIlIlIIlIIIllIlIl);
            lllllllllllllIIlIlIlIIlIIIllIlll.func_190579_a(lllllllllllllIIlIlIlIIlIIIlllIII.capabilities.isCreativeMode);
            lllllllllllllIIlIlIlIIlIIIllIlll.fillWithLoot(lllllllllllllIIlIlIlIIlIIIlllIII);
        }
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState lllllllllllllIIlIlIlIIIlllIIlIll, final World lllllllllllllIIlIlIlIIIlllIIlIII, final BlockPos lllllllllllllIIlIlIlIIIlllIIlIIl) {
        return Container.calcRedstoneFromInventory((IInventory)lllllllllllllIIlIlIlIIIlllIIlIII.getTileEntity(lllllllllllllIIlIlIlIIIlllIIlIIl));
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIIlIlIlIIIllIIIIlIl, IBlockState lllllllllllllIIlIlIlIIIllIIIIlII, final BlockPos lllllllllllllIIlIlIlIIIllIIIIIll, final EnumFacing lllllllllllllIIlIlIlIIIllIIIIIlI) {
        lllllllllllllIIlIlIlIIIllIIIIlII = (boolean)this.getActualState((IBlockState)lllllllllllllIIlIlIlIIIllIIIIlII, lllllllllllllIIlIlIlIIIllIIIIlIl, lllllllllllllIIlIlIlIIIllIIIIIll);
        final EnumFacing lllllllllllllIIlIlIlIIIllIIIlIII = ((IBlockState)lllllllllllllIIlIlIlIIIllIIIIlII).getValue(BlockShulkerBox.field_190957_a);
        final TileEntityShulkerBox.AnimationStatus lllllllllllllIIlIlIlIIIllIIIIlll = ((TileEntityShulkerBox)lllllllllllllIIlIlIlIIIllIIIIlIl.getTileEntity(lllllllllllllIIlIlIlIIIllIIIIIll)).func_190591_p();
        return (lllllllllllllIIlIlIlIIIllIIIIlll != TileEntityShulkerBox.AnimationStatus.CLOSED && (lllllllllllllIIlIlIlIIIllIIIIlll != TileEntityShulkerBox.AnimationStatus.OPENED || (lllllllllllllIIlIlIlIIIllIIIlIII != lllllllllllllIIlIlIlIIIllIIIIIlI.getOpposite() && lllllllllllllIIlIlIlIIIllIIIlIII != lllllllllllllIIlIlIlIIIllIIIIIlI))) ? BlockFaceShape.UNDEFINED : BlockFaceShape.SOLID;
    }
    
    @Override
    public EnumPushReaction getMobilityFlag(final IBlockState lllllllllllllIIlIlIlIIIlllIllllI) {
        return EnumPushReaction.DESTROY;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIIlIlIlIIIllIIlllll, final Rotation lllllllllllllIIlIlIlIIIllIIlllII) {
        return lllllllllllllIIlIlIlIIIllIIlllll.withProperty(BlockShulkerBox.field_190957_a, lllllllllllllIIlIlIlIIIllIIlllII.rotate(lllllllllllllIIlIlIlIIIllIIlllll.getValue(BlockShulkerBox.field_190957_a)));
    }
    
    public static EnumDyeColor func_190955_b(final Item lllllllllllllIIlIlIlIIIllIllIIII) {
        return func_190954_c(Block.getBlockFromItem(lllllllllllllIIlIlIlIIIllIllIIII));
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIIlIlIlIIIllIlllllI, final BlockPos lllllllllllllIIlIlIlIIIllIllIllI, final IBlockState lllllllllllllIIlIlIlIIIllIllllII) {
        final ItemStack lllllllllllllIIlIlIlIIIllIlllIll = super.getItem(lllllllllllllIIlIlIlIIIllIlllllI, lllllllllllllIIlIlIlIIIllIllIllI, lllllllllllllIIlIlIlIIIllIllllII);
        final TileEntityShulkerBox lllllllllllllIIlIlIlIIIllIlllIlI = (TileEntityShulkerBox)lllllllllllllIIlIlIlIIIllIlllllI.getTileEntity(lllllllllllllIIlIlIlIIIllIllIllI);
        final NBTTagCompound lllllllllllllIIlIlIlIIIllIlllIIl = lllllllllllllIIlIlIlIIIllIlllIlI.func_190580_f(new NBTTagCompound());
        if (!lllllllllllllIIlIlIlIIIllIlllIIl.hasNoTags()) {
            lllllllllllllIIlIlIlIIIllIlllIll.setTagInfo("BlockEntityTag", lllllllllllllIIlIlIlIIIllIlllIIl);
        }
        return lllllllllllllIIlIlIlIIIllIlllIll;
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState lllllllllllllIIlIlIlIIIlllIIllll) {
        return true;
    }
    
    public EnumDyeColor func_190956_e() {
        return this.field_190958_b;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockShulkerBox.field_190957_a });
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllIIlIlIlIIlIIlllIIll, final BlockPos lllllllllllllIIlIlIlIIlIIllIIlII, final IBlockState lllllllllllllIIlIlIlIIlIIlllIIIl, final EntityPlayer lllllllllllllIIlIlIlIIlIIlllIIII, final EnumHand lllllllllllllIIlIlIlIIlIIllIllll, final EnumFacing lllllllllllllIIlIlIlIIlIIllIlllI, final float lllllllllllllIIlIlIlIIlIIllIllIl, final float lllllllllllllIIlIlIlIIlIIllIllII, final float lllllllllllllIIlIlIlIIlIIllIlIll) {
        if (lllllllllllllIIlIlIlIIlIIlllIIll.isRemote) {
            return true;
        }
        if (lllllllllllllIIlIlIlIIlIIlllIIII.isSpectator()) {
            return true;
        }
        final TileEntity lllllllllllllIIlIlIlIIlIIllIlIlI = lllllllllllllIIlIlIlIIlIIlllIIll.getTileEntity(lllllllllllllIIlIlIlIIlIIllIIlII);
        if (lllllllllllllIIlIlIlIIlIIllIlIlI instanceof TileEntityShulkerBox) {
            final EnumFacing lllllllllllllIIlIlIlIIlIIllIlIIl = lllllllllllllIIlIlIlIIlIIlllIIIl.getValue(BlockShulkerBox.field_190957_a);
            boolean lllllllllllllIIlIlIlIIlIIllIIlll = false;
            if (((TileEntityShulkerBox)lllllllllllllIIlIlIlIIlIIllIlIlI).func_190591_p() == TileEntityShulkerBox.AnimationStatus.CLOSED) {
                final AxisAlignedBB lllllllllllllIIlIlIlIIlIIllIIllI = BlockShulkerBox.FULL_BLOCK_AABB.addCoord(0.5f * lllllllllllllIIlIlIlIIlIIllIlIIl.getFrontOffsetX(), 0.5f * lllllllllllllIIlIlIlIIlIIllIlIIl.getFrontOffsetY(), 0.5f * lllllllllllllIIlIlIlIIlIIllIlIIl.getFrontOffsetZ()).func_191195_a(lllllllllllllIIlIlIlIIlIIllIlIIl.getFrontOffsetX(), lllllllllllllIIlIlIlIIlIIllIlIIl.getFrontOffsetY(), lllllllllllllIIlIlIlIIlIIllIlIIl.getFrontOffsetZ());
                final boolean lllllllllllllIIlIlIlIIlIIllIlIII = !lllllllllllllIIlIlIlIIlIIlllIIll.collidesWithAnyBlock(lllllllllllllIIlIlIlIIlIIllIIllI.offset(lllllllllllllIIlIlIlIIlIIllIIlII.offset(lllllllllllllIIlIlIlIIlIIllIlIIl)));
            }
            else {
                lllllllllllllIIlIlIlIIlIIllIIlll = true;
            }
            if (lllllllllllllIIlIlIlIIlIIllIIlll) {
                lllllllllllllIIlIlIlIIlIIlllIIII.addStat(StatList.field_191272_ae);
                lllllllllllllIIlIlIlIIlIIlllIIII.displayGUIChest((IInventory)lllllllllllllIIlIlIlIIlIIllIlIlI);
            }
            return true;
        }
        return false;
    }
}
