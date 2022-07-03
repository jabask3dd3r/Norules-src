package net.minecraft.tileentity;

import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import net.minecraft.nbt.*;
import net.minecraft.util.datafix.walkers.*;
import net.minecraft.util.datafix.*;
import javax.annotation.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.network.play.server.*;

public class TileEntityShulkerBox extends TileEntityLockableLoot implements ITickable, ISidedInventory
{
    private /* synthetic */ float field_190600_j;
    private /* synthetic */ EnumDyeColor field_190602_l;
    private /* synthetic */ int field_190598_h;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityShulkerBox$AnimationStatus;
    private /* synthetic */ boolean field_190597_g;
    private static final /* synthetic */ int[] field_190595_a;
    private /* synthetic */ NonNullList<ItemStack> field_190596_f;
    private /* synthetic */ boolean field_190594_p;
    private /* synthetic */ float field_190601_k;
    private /* synthetic */ AnimationStatus field_190599_i;
    
    @Override
    public boolean canInsertItem(final int lllllllllllllllIIlIIIlIIIlIllllI, final ItemStack lllllllllllllllIIlIIIlIIIlIlllIl, final EnumFacing lllllllllllllllIIlIIIlIIIlIlllII) {
        return !(Block.getBlockFromItem(lllllllllllllllIIlIIIlIIIlIlllIl.getItem()) instanceof BlockShulkerBox);
    }
    
    public AxisAlignedBB func_190587_b(final EnumFacing lllllllllllllllIIlIIIlIIllIllIll) {
        return Block.FULL_BLOCK_AABB.addCoord(0.5f * this.func_190585_a(1.0f) * lllllllllllllllIIlIIIlIIllIllIll.getFrontOffsetX(), 0.5f * this.func_190585_a(1.0f) * lllllllllllllllIIlIIIlIIllIllIll.getFrontOffsetY(), 0.5f * this.func_190585_a(1.0f) * lllllllllllllllIIlIIIlIIllIllIll.getFrontOffsetZ());
    }
    
    public TileEntityShulkerBox() {
        this(null);
    }
    
    public float func_190585_a(final float lllllllllllllllIIlIIIlIIIlIIllIl) {
        return this.field_190601_k + (this.field_190600_j - this.field_190601_k) * lllllllllllllllIIlIIIlIIIlIIllIl;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllllIIlIIIlIIIlllllII) {
        super.writeToNBT(lllllllllllllllIIlIIIlIIIlllllII);
        return this.func_190580_f(lllllllllllllllIIlIIIlIIIlllllII);
    }
    
    @Override
    protected NonNullList<ItemStack> func_190576_q() {
        return this.field_190596_f;
    }
    
    public EnumDyeColor func_190592_s() {
        if (this.field_190602_l == null) {
            this.field_190602_l = BlockShulkerBox.func_190954_c(this.getBlockType());
        }
        return this.field_190602_l;
    }
    
    @Override
    public boolean receiveClientEvent(final int lllllllllllllllIIlIIIlIIlIlIIllI, final int lllllllllllllllIIlIIIlIIlIlIIlIl) {
        if (lllllllllllllllIIlIIIlIIlIlIIllI == 1) {
            if ((this.field_190598_h = lllllllllllllllIIlIIIlIIlIlIIlIl) == 0) {
                this.field_190599_i = AnimationStatus.CLOSING;
            }
            if (lllllllllllllllIIlIIIlIIlIlIIlIl == 1) {
                this.field_190599_i = AnimationStatus.OPENING;
            }
            return true;
        }
        return super.receiveClientEvent(lllllllllllllllIIlIIIlIIlIlIIllI, lllllllllllllllIIlIIIlIIlIlIIlIl);
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllllIIlIIIlIIlIIIIIlI) {
        super.readFromNBT(lllllllllllllllIIlIIIlIIlIIIIIlI);
        this.func_190586_e(lllllllllllllllIIlIIIlIIlIIIIIlI);
    }
    
    public static void func_190593_a(final DataFixer lllllllllllllllIIlIIIlIIlIIIIlll) {
        lllllllllllllllIIlIIIlIIlIIIIlll.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityShulkerBox.class, new String[] { "Items" }));
    }
    
    @Override
    public int[] getSlotsForFace(final EnumFacing lllllllllllllllIIlIIIlIIIllIIIIl) {
        return TileEntityShulkerBox.field_190595_a;
    }
    
    public TileEntityShulkerBox(@Nullable final EnumDyeColor lllllllllllllllIIlIIIlIIllllIIII) {
        this.field_190596_f = NonNullList.func_191197_a(27, ItemStack.field_190927_a);
        this.field_190599_i = AnimationStatus.CLOSED;
        this.field_190602_l = lllllllllllllllIIlIIIlIIllllIIII;
    }
    
    public boolean func_190590_r() {
        return this.field_190597_g;
    }
    
    @Override
    public int getSizeInventory() {
        return this.field_190596_f.size();
    }
    
    public void func_190586_e(final NBTTagCompound lllllllllllllllIIlIIIlIIIlllIlII) {
        this.field_190596_f = NonNullList.func_191197_a(this.getSizeInventory(), ItemStack.field_190927_a);
        if (!this.checkLootAndRead(lllllllllllllllIIlIIIlIIIlllIlII) && lllllllllllllllIIlIIIlIIIlllIlII.hasKey("Items", 9)) {
            ItemStackHelper.func_191283_b(lllllllllllllllIIlIIIlIIIlllIlII, this.field_190596_f);
        }
        if (lllllllllllllllIIlIIIlIIIlllIlII.hasKey("CustomName", 8)) {
            this.field_190577_o = lllllllllllllllIIlIIIlIIIlllIlII.getString("CustomName");
        }
    }
    
    public boolean func_190582_F() {
        return !this.func_190581_E() || !this.func_191420_l() || this.hasCustomName() || this.lootTable != null;
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:shulker_box";
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = TileEntityShulkerBox.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
        if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
        }
        final byte lllllllllllllllIIlIIIlIIIIllIlIl = (Object)new int[EnumFacing.Axis.values().length];
        try {
            lllllllllllllllIIlIIIlIIIIllIlIl[EnumFacing.Axis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllIIlIIIlIIIIllIlIl[EnumFacing.Axis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllIIlIIIlIIIIllIlIl[EnumFacing.Axis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return TileEntityShulkerBox.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)lllllllllllllllIIlIIIlIIIIllIlIl;
    }
    
    @Override
    public boolean canExtractItem(final int lllllllllllllllIIlIIIlIIIlIllIIl, final ItemStack lllllllllllllllIIlIIIlIIIlIllIII, final EnumFacing lllllllllllllllIIlIIIlIIIlIlIlll) {
        return true;
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack lllllllllllllllIIlIIIlIIIllIIllI : this.field_190596_f) {
            if (!lllllllllllllllIIlIIIlIIIllIIllI.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    public AnimationStatus func_190591_p() {
        return this.field_190599_i;
    }
    
    static {
        field_190595_a = new int[27];
        for (int lllllllllllllllIIlIIIlIIlllllIII = 0; lllllllllllllllIIlIIIlIIlllllIII < TileEntityShulkerBox.field_190595_a.length; TileEntityShulkerBox.field_190595_a[lllllllllllllllIIlIIIlIIlllllIII] = lllllllllllllllIIlIIIlIIlllllIII++) {}
    }
    
    @Override
    public void clear() {
        this.field_190597_g = true;
        super.clear();
    }
    
    @Override
    public void openInventory(final EntityPlayer lllllllllllllllIIlIIIlIIlIIlllII) {
        if (!lllllllllllllllIIlIIIlIIlIIlllII.isSpectator()) {
            if (this.field_190598_h < 0) {
                this.field_190598_h = 0;
            }
            ++this.field_190598_h;
            this.world.addBlockEvent(this.pos, this.getBlockType(), 1, this.field_190598_h);
            if (this.field_190598_h == 1) {
                this.world.playSound(null, this.pos, SoundEvents.field_191262_fB, SoundCategory.BLOCKS, 0.5f, this.world.rand.nextFloat() * 0.1f + 0.9f);
            }
        }
    }
    
    private AxisAlignedBB func_190588_c(final EnumFacing lllllllllllllllIIlIIIlIIllIlIlII) {
        final EnumFacing lllllllllllllllIIlIIIlIIllIlIIll = lllllllllllllllIIlIIIlIIllIlIlII.getOpposite();
        return this.func_190587_b(lllllllllllllllIIlIIIlIIllIlIlII).func_191195_a(lllllllllllllllIIlIIIlIIllIlIIll.getFrontOffsetX(), lllllllllllllllIIlIIIlIIllIlIIll.getFrontOffsetY(), lllllllllllllllIIlIIIlIIllIlIIll.getFrontOffsetZ());
    }
    
    protected void func_190583_o() {
        this.field_190601_k = this.field_190600_j;
        switch ($SWITCH_TABLE$net$minecraft$tileentity$TileEntityShulkerBox$AnimationStatus()[this.field_190599_i.ordinal()]) {
            case 1: {
                this.field_190600_j = 0.0f;
                break;
            }
            case 2: {
                this.field_190600_j += 0.1f;
                if (this.field_190600_j >= 1.0f) {
                    this.func_190589_G();
                    this.field_190599_i = AnimationStatus.OPENED;
                    this.field_190600_j = 1.0f;
                    break;
                }
                break;
            }
            case 4: {
                this.field_190600_j -= 0.1f;
                if (this.field_190600_j <= 0.0f) {
                    this.field_190599_i = AnimationStatus.CLOSED;
                    this.field_190600_j = 0.0f;
                    break;
                }
                break;
            }
            case 3: {
                this.field_190600_j = 1.0f;
                break;
            }
        }
    }
    
    private void func_190589_G() {
        final IBlockState lllllllllllllllIIlIIIlIIllIIIIll = this.world.getBlockState(this.getPos());
        if (lllllllllllllllIIlIIIlIIllIIIIll.getBlock() instanceof BlockShulkerBox) {
            final EnumFacing lllllllllllllllIIlIIIlIIllIIIIlI = lllllllllllllllIIlIIIlIIllIIIIll.getValue(BlockShulkerBox.field_190957_a);
            final AxisAlignedBB lllllllllllllllIIlIIIlIIllIIIIIl = this.func_190588_c(lllllllllllllllIIlIIIlIIllIIIIlI).offset(this.pos);
            final List<Entity> lllllllllllllllIIlIIIlIIllIIIIII = this.world.getEntitiesWithinAABBExcludingEntity(null, lllllllllllllllIIlIIIlIIllIIIIIl);
            if (!lllllllllllllllIIlIIIlIIllIIIIII.isEmpty()) {
                for (int lllllllllllllllIIlIIIlIIlIllllll = 0; lllllllllllllllIIlIIIlIIlIllllll < lllllllllllllllIIlIIIlIIllIIIIII.size(); ++lllllllllllllllIIlIIIlIIlIllllll) {
                    final Entity lllllllllllllllIIlIIIlIIlIlllllI = lllllllllllllllIIlIIIlIIllIIIIII.get(lllllllllllllllIIlIIIlIIlIllllll);
                    if (lllllllllllllllIIlIIIlIIlIlllllI.getPushReaction() != EnumPushReaction.IGNORE) {
                        double lllllllllllllllIIlIIIlIIlIllllIl = 0.0;
                        double lllllllllllllllIIlIIIlIIlIllllII = 0.0;
                        double lllllllllllllllIIlIIIlIIlIlllIll = 0.0;
                        final AxisAlignedBB lllllllllllllllIIlIIIlIIlIlllIlI = lllllllllllllllIIlIIIlIIlIlllllI.getEntityBoundingBox();
                        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllllllIIlIIIlIIllIIIIlI.getAxis().ordinal()]) {
                            case 1: {
                                if (lllllllllllllllIIlIIIlIIllIIIIlI.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) {
                                    lllllllllllllllIIlIIIlIIlIllllIl = lllllllllllllllIIlIIIlIIllIIIIIl.maxX - lllllllllllllllIIlIIIlIIlIlllIlI.minX;
                                }
                                else {
                                    lllllllllllllllIIlIIIlIIlIllllIl = lllllllllllllllIIlIIIlIIlIlllIlI.maxX - lllllllllllllllIIlIIIlIIllIIIIIl.minX;
                                }
                                lllllllllllllllIIlIIIlIIlIllllIl += 0.01;
                                break;
                            }
                            case 2: {
                                if (lllllllllllllllIIlIIIlIIllIIIIlI.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) {
                                    lllllllllllllllIIlIIIlIIlIllllII = lllllllllllllllIIlIIIlIIllIIIIIl.maxY - lllllllllllllllIIlIIIlIIlIlllIlI.minY;
                                }
                                else {
                                    lllllllllllllllIIlIIIlIIlIllllII = lllllllllllllllIIlIIIlIIlIlllIlI.maxY - lllllllllllllllIIlIIIlIIllIIIIIl.minY;
                                }
                                lllllllllllllllIIlIIIlIIlIllllII += 0.01;
                                break;
                            }
                            case 3: {
                                if (lllllllllllllllIIlIIIlIIllIIIIlI.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE) {
                                    lllllllllllllllIIlIIIlIIlIlllIll = lllllllllllllllIIlIIIlIIllIIIIIl.maxZ - lllllllllllllllIIlIIIlIIlIlllIlI.minZ;
                                }
                                else {
                                    lllllllllllllllIIlIIIlIIlIlllIll = lllllllllllllllIIlIIIlIIlIlllIlI.maxZ - lllllllllllllllIIlIIIlIIllIIIIIl.minZ;
                                }
                                lllllllllllllllIIlIIIlIIlIlllIll += 0.01;
                                break;
                            }
                        }
                        lllllllllllllllIIlIIIlIIlIlllllI.moveEntity(MoverType.SHULKER_BOX, lllllllllllllllIIlIIIlIIlIllllIl * lllllllllllllllIIlIIIlIIllIIIIlI.getFrontOffsetX(), lllllllllllllllIIlIIIlIIlIllllII * lllllllllllllllIIlIIIlIIllIIIIlI.getFrontOffsetY(), lllllllllllllllIIlIIIlIIlIlllIll * lllllllllllllllIIlIIIlIIllIIIIlI.getFrontOffsetZ());
                    }
                }
            }
        }
    }
    
    @Override
    public void closeInventory(final EntityPlayer lllllllllllllllIIlIIIlIIlIIllIII) {
        if (!lllllllllllllllIIlIIIlIIlIIllIII.isSpectator()) {
            --this.field_190598_h;
            this.world.addBlockEvent(this.pos, this.getBlockType(), 1, this.field_190598_h);
            if (this.field_190598_h <= 0) {
                this.world.playSound(null, this.pos, SoundEvents.field_191261_fA, SoundCategory.BLOCKS, 0.5f, this.world.rand.nextFloat() * 0.1f + 0.9f);
            }
        }
    }
    
    @Override
    public Container createContainer(final InventoryPlayer lllllllllllllllIIlIIIlIIlIIlIIIl, final EntityPlayer lllllllllllllllIIlIIIlIIlIIIllIl) {
        return new ContainerShulkerBox(lllllllllllllllIIlIIIlIIlIIlIIIl, this, lllllllllllllllIIlIIIlIIlIIIllIl);
    }
    
    public NBTTagCompound func_190580_f(final NBTTagCompound lllllllllllllllIIlIIIlIIIllIlllI) {
        if (!this.checkLootAndWrite(lllllllllllllllIIlIIIlIIIllIlllI)) {
            ItemStackHelper.func_191281_a(lllllllllllllllIIlIIIlIIIllIlllI, this.field_190596_f, false);
        }
        if (this.hasCustomName()) {
            lllllllllllllllIIlIIIlIIIllIlllI.setString("CustomName", this.field_190577_o);
        }
        if (!lllllllllllllllIIlIIIlIIIllIlllI.hasKey("Lock") && this.isLocked()) {
            this.getLockCode().toNBT(lllllllllllllllIIlIIIlIIIllIlllI);
        }
        return lllllllllllllllIIlIIIlIIIllIlllI;
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.field_190577_o : "container.shulkerBox";
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityShulkerBox$AnimationStatus() {
        final int[] $switch_TABLE$net$minecraft$tileentity$TileEntityShulkerBox$AnimationStatus = TileEntityShulkerBox.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityShulkerBox$AnimationStatus;
        if ($switch_TABLE$net$minecraft$tileentity$TileEntityShulkerBox$AnimationStatus != null) {
            return $switch_TABLE$net$minecraft$tileentity$TileEntityShulkerBox$AnimationStatus;
        }
        final short lllllllllllllllIIlIIIlIIIIllIlll = (Object)new int[AnimationStatus.values().length];
        try {
            lllllllllllllllIIlIIIlIIIIllIlll[AnimationStatus.CLOSED.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllIIlIIIlIIIIllIlll[AnimationStatus.CLOSING.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllIIlIIIlIIIIllIlll[AnimationStatus.OPENED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllIIlIIIlIIIIllIlll[AnimationStatus.OPENING.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return TileEntityShulkerBox.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityShulkerBox$AnimationStatus = (int[])(Object)lllllllllllllllIIlIIIlIIIIllIlll;
    }
    
    @Override
    public void update() {
        this.func_190583_o();
        if (this.field_190599_i == AnimationStatus.OPENING || this.field_190599_i == AnimationStatus.CLOSING) {
            this.func_190589_G();
        }
    }
    
    public boolean func_190581_E() {
        return this.field_190594_p;
    }
    
    public void func_190579_a(final boolean lllllllllllllllIIlIIIlIIIIllllII) {
        this.field_190594_p = lllllllllllllllIIlIIIlIIIIllllII;
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 10, this.getUpdateTag());
    }
    
    public AxisAlignedBB func_190584_a(final IBlockState lllllllllllllllIIlIIIlIIlllIIIIl) {
        return this.func_190587_b(lllllllllllllllIIlIIIlIIlllIIIIl.getValue(BlockShulkerBox.field_190957_a));
    }
    
    public enum AnimationStatus
    {
        OPENED("OPENED", 2), 
        OPENING("OPENING", 1), 
        CLOSED("CLOSED", 0), 
        CLOSING("CLOSING", 3);
        
        private AnimationStatus(final String lllllllllllllIIIllllllIlIllllIII, final int lllllllllllllIIIllllllIlIlllIlll) {
        }
    }
}
