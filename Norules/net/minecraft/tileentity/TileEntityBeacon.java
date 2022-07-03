package net.minecraft.tileentity;

import javax.annotation.*;
import net.minecraft.util.*;
import com.google.common.collect.*;
import net.minecraft.network.play.server.*;
import net.minecraft.nbt.*;
import net.minecraft.inventory.*;
import net.minecraft.potion.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import java.util.*;

public class TileEntityBeacon extends TileEntityLockable implements ITickable, ISidedInventory
{
    public static final /* synthetic */ Potion[][] EFFECTS_LIST;
    @Nullable
    private /* synthetic */ Potion secondaryEffect;
    private static final /* synthetic */ Set<Potion> VALID_EFFECTS;
    private /* synthetic */ float beamRenderScale;
    private /* synthetic */ ItemStack payment;
    private /* synthetic */ long beamRenderCounter;
    @Nullable
    private /* synthetic */ Potion primaryEffect;
    private /* synthetic */ boolean isComplete;
    private /* synthetic */ String customName;
    private /* synthetic */ int levels;
    private final /* synthetic */ List<BeamSegment> beamSegments;
    
    @Override
    public int getField(final int lllllllllllllIlllllIlllIIIllIlIl) {
        switch (lllllllllllllIlllllIlllIIIllIlIl) {
            case 0: {
                return this.levels;
            }
            case 1: {
                return Potion.getIdFromPotion(this.primaryEffect);
            }
            case 2: {
                return Potion.getIdFromPotion(this.secondaryEffect);
            }
            default: {
                return 0;
            }
        }
    }
    
    @Override
    public void setField(final int lllllllllllllIlllllIlllIIIlIllIl, final int lllllllllllllIlllllIlllIIIlIllII) {
        switch (lllllllllllllIlllllIlllIIIlIllIl) {
            case 0: {
                this.levels = lllllllllllllIlllllIlllIIIlIllII;
                break;
            }
            case 1: {
                this.primaryEffect = isBeaconEffect(lllllllllllllIlllllIlllIIIlIllII);
                break;
            }
            case 2: {
                this.secondaryEffect = isBeaconEffect(lllllllllllllIlllllIlllIIIlIllII);
                break;
            }
        }
    }
    
    @Override
    public boolean canInsertItem(final int lllllllllllllIlllllIlllIIIIllIll, final ItemStack lllllllllllllIlllllIlllIIIIllIlI, final EnumFacing lllllllllllllIlllllIlllIIIIllIIl) {
        return false;
    }
    
    @Override
    public void update() {
        if (this.world.getTotalWorldTime() % 80L == 0L) {
            this.updateBeacon();
        }
    }
    
    static {
        EFFECTS_LIST = new Potion[][] { { MobEffects.SPEED, MobEffects.HASTE }, { MobEffects.RESISTANCE, MobEffects.JUMP_BOOST }, { MobEffects.STRENGTH }, { MobEffects.REGENERATION } };
        VALID_EFFECTS = Sets.newHashSet();
        final Exception lllllllllllllIlllllIllllIIIIIlIl;
        final float lllllllllllllIlllllIllllIIIIIllI = ((Potion[][])(Object)(lllllllllllllIlllllIllllIIIIIlIl = (Exception)(Object)TileEntityBeacon.EFFECTS_LIST)).length;
        for (char lllllllllllllIlllllIllllIIIIIlll = '\0'; lllllllllllllIlllllIllllIIIIIlll < lllllllllllllIlllllIllllIIIIIllI; ++lllllllllllllIlllllIllllIIIIIlll) {
            final Potion[] lllllllllllllIlllllIllllIIIIlIIl = lllllllllllllIlllllIllllIIIIIlIl[lllllllllllllIlllllIllllIIIIIlll];
            Collections.addAll(TileEntityBeacon.VALID_EFFECTS, lllllllllllllIlllllIllllIIIIlIIl);
        }
    }
    
    @Override
    public void clear() {
        this.payment = ItemStack.field_190927_a;
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer lllllllllllllIlllllIlllIIlIIllII) {
        return this.world.getTileEntity(this.pos) == this && lllllllllllllIlllllIlllIIlIIllII.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public int[] getSlotsForFace(final EnumFacing lllllllllllllIlllllIlllIIIIlllIl) {
        return new int[0];
    }
    
    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }
    
    @Override
    public boolean receiveClientEvent(final int lllllllllllllIlllllIlllIIIlIIIll, final int lllllllllllllIlllllIlllIIIIlllll) {
        if (lllllllllllllIlllllIlllIIIlIIIll == 1) {
            this.updateBeacon();
            return true;
        }
        return super.receiveClientEvent(lllllllllllllIlllllIlllIIIlIIIll, lllllllllllllIlllllIlllIIIIlllll);
    }
    
    public void setName(final String lllllllllllllIlllllIlllIIlIlIIll) {
        this.customName = lllllllllllllIlllllIlllIIlIlIIll;
    }
    
    public int func_191979_s() {
        return this.levels;
    }
    
    @Override
    public boolean func_191420_l() {
        return this.payment.func_190926_b();
    }
    
    public TileEntityBeacon() {
        this.beamSegments = (List<BeamSegment>)Lists.newArrayList();
        this.levels = -1;
        this.payment = ItemStack.field_190927_a;
    }
    
    @Override
    public boolean isItemValidForSlot(final int lllllllllllllIlllllIlllIIlIIIlIl, final ItemStack lllllllllllllIlllllIlllIIlIIIlII) {
        return lllllllllllllIlllllIlllIIlIIIlII.getItem() == Items.EMERALD || lllllllllllllIlllllIlllIIlIIIlII.getItem() == Items.DIAMOND || lllllllllllllIlllllIlllIIlIIIlII.getItem() == Items.GOLD_INGOT || lllllllllllllIlllllIlllIIlIIIlII.getItem() == Items.IRON_INGOT;
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 3, this.getUpdateTag());
    }
    
    @Override
    public void setInventorySlotContents(final int lllllllllllllIlllllIlllIIllIIIll, final ItemStack lllllllllllllIlllllIlllIIlIlllll) {
        if (lllllllllllllIlllllIlllIIllIIIll == 0) {
            this.payment = lllllllllllllIlllllIlllIIlIlllll;
        }
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllIlllllIlllIlIIIIlll) {
        super.writeToNBT(lllllllllllllIlllllIlllIlIIIIlll);
        lllllllllllllIlllllIlllIlIIIIlll.setInteger("Primary", Potion.getIdFromPotion(this.primaryEffect));
        lllllllllllllIlllllIlllIlIIIIlll.setInteger("Secondary", Potion.getIdFromPotion(this.secondaryEffect));
        lllllllllllllIlllllIlllIlIIIIlll.setInteger("Levels", this.levels);
        return lllllllllllllIlllllIlllIlIIIIlll;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer lllllllllllllIlllllIlllIIIlllIll, final EntityPlayer lllllllllllllIlllllIlllIIIllllIl) {
        return new ContainerBeacon(lllllllllllllIlllllIlllIIIlllIll, this);
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "container.beacon";
    }
    
    public float shouldBeamRender() {
        if (!this.isComplete) {
            return 0.0f;
        }
        final int lllllllllllllIlllllIlllIlIlIIlIl = (int)(this.world.getTotalWorldTime() - this.beamRenderCounter);
        this.beamRenderCounter = this.world.getTotalWorldTime();
        if (lllllllllllllIlllllIlllIlIlIIlIl > 1) {
            this.beamRenderScale -= lllllllllllllIlllllIlllIlIlIIlIl / 40.0f;
            if (this.beamRenderScale < 0.0f) {
                this.beamRenderScale = 0.0f;
            }
        }
        this.beamRenderScale += 0.025f;
        if (this.beamRenderScale > 1.0f) {
            this.beamRenderScale = 1.0f;
        }
        return this.beamRenderScale;
    }
    
    @Override
    public boolean canExtractItem(final int lllllllllllllIlllllIlllIIIIlIlll, final ItemStack lllllllllllllIlllllIlllIIIIlIllI, final EnumFacing lllllllllllllIlllllIlllIIIIlIlIl) {
        return false;
    }
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllllIlllllIlllIIlllIIll, final int lllllllllllllIlllllIlllIIlllIllI) {
        if (lllllllllllllIlllllIlllIIlllIIll != 0 || this.payment.func_190926_b()) {
            return ItemStack.field_190927_a;
        }
        if (lllllllllllllIlllllIlllIIlllIllI >= this.payment.func_190916_E()) {
            final ItemStack lllllllllllllIlllllIlllIIlllIlIl = this.payment;
            this.payment = ItemStack.field_190927_a;
            return lllllllllllllIlllllIlllIIlllIlIl;
        }
        return this.payment.splitStack(lllllllllllllIlllllIlllIIlllIllI);
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
    
    @Override
    public ItemStack getStackInSlot(final int lllllllllllllIlllllIlllIIlllllIl) {
        return (lllllllllllllIlllllIlllIIlllllIl == 0) ? this.payment : ItemStack.field_190927_a;
    }
    
    @Override
    public double getMaxRenderDistanceSquared() {
        return 65536.0;
    }
    
    @Override
    public void openInventory(final EntityPlayer lllllllllllllIlllllIlllIIlIIlIlI) {
    }
    
    private void addEffectsToPlayers() {
        if (this.isComplete && this.levels > 0 && !this.world.isRemote && this.primaryEffect != null) {
            final double lllllllllllllIlllllIlllIlllIllll = this.levels * 10 + 10;
            int lllllllllllllIlllllIlllIlllIlllI = 0;
            if (this.levels >= 4 && this.primaryEffect == this.secondaryEffect) {
                lllllllllllllIlllllIlllIlllIlllI = 1;
            }
            final int lllllllllllllIlllllIlllIlllIllIl = (9 + this.levels * 2) * 20;
            final int lllllllllllllIlllllIlllIlllIllII = this.pos.getX();
            final int lllllllllllllIlllllIlllIlllIlIll = this.pos.getY();
            final int lllllllllllllIlllllIlllIlllIlIlI = this.pos.getZ();
            final AxisAlignedBB lllllllllllllIlllllIlllIlllIlIIl = new AxisAlignedBB(lllllllllllllIlllllIlllIlllIllII, lllllllllllllIlllllIlllIlllIlIll, lllllllllllllIlllllIlllIlllIlIlI, lllllllllllllIlllllIlllIlllIllII + 1, lllllllllllllIlllllIlllIlllIlIll + 1, lllllllllllllIlllllIlllIlllIlIlI + 1).expandXyz(lllllllllllllIlllllIlllIlllIllll).addCoord(0.0, this.world.getHeight(), 0.0);
            final List<EntityPlayer> lllllllllllllIlllllIlllIlllIlIII = this.world.getEntitiesWithinAABB((Class<? extends EntityPlayer>)EntityPlayer.class, lllllllllllllIlllllIlllIlllIlIIl);
            for (final EntityPlayer lllllllllllllIlllllIlllIlllIIlll : lllllllllllllIlllllIlllIlllIlIII) {
                lllllllllllllIlllllIlllIlllIIlll.addPotionEffect(new PotionEffect(this.primaryEffect, lllllllllllllIlllllIlllIlllIllIl, lllllllllllllIlllllIlllIlllIlllI, true, true));
            }
            if (this.levels >= 4 && this.primaryEffect != this.secondaryEffect && this.secondaryEffect != null) {
                for (final EntityPlayer lllllllllllllIlllllIlllIlllIIllI : lllllllllllllIlllllIlllIlllIlIII) {
                    lllllllllllllIlllllIlllIlllIIllI.addPotionEffect(new PotionEffect(this.secondaryEffect, lllllllllllllIlllllIlllIlllIllIl, 0, true, true));
                }
            }
        }
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int lllllllllllllIlllllIlllIIllIllII) {
        if (lllllllllllllIlllllIlllIIllIllII == 0) {
            final ItemStack lllllllllllllIlllllIlllIIllIlIll = this.payment;
            this.payment = ItemStack.field_190927_a;
            return lllllllllllllIlllllIlllIIllIlIll;
        }
        return ItemStack.field_190927_a;
    }
    
    @Nullable
    private static Potion isBeaconEffect(final int lllllllllllllIlllllIlllIlIIlIllI) {
        final Potion lllllllllllllIlllllIlllIlIIlIlIl = Potion.getPotionById(lllllllllllllIlllllIlllIlIIlIllI);
        return TileEntityBeacon.VALID_EFFECTS.contains(lllllllllllllIlllllIlllIlIIlIlIl) ? lllllllllllllIlllllIlllIlIIlIlIl : null;
    }
    
    @Override
    public void closeInventory(final EntityPlayer lllllllllllllIlllllIlllIIlIIlIII) {
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 1;
    }
    
    @Override
    public int getSizeInventory() {
        return 1;
    }
    
    private void updateSegmentColors() {
        final int lllllllllllllIlllllIlllIllIIlIll = this.pos.getX();
        final int lllllllllllllIlllllIlllIllIIlIlI = this.pos.getY();
        final int lllllllllllllIlllllIlllIllIIlIIl = this.pos.getZ();
        final int lllllllllllllIlllllIlllIllIIlIII = this.levels;
        this.levels = 0;
        this.beamSegments.clear();
        this.isComplete = true;
        BeamSegment lllllllllllllIlllllIlllIllIIIlll = new BeamSegment(EnumDyeColor.WHITE.func_193349_f());
        this.beamSegments.add(lllllllllllllIlllllIlllIllIIIlll);
        boolean lllllllllllllIlllllIlllIllIIIllI = true;
        final BlockPos.MutableBlockPos lllllllllllllIlllllIlllIllIIIlIl = new BlockPos.MutableBlockPos();
        for (int lllllllllllllIlllllIlllIllIIIlII = lllllllllllllIlllllIlllIllIIlIlI + 1; lllllllllllllIlllllIlllIllIIIlII < 256; ++lllllllllllllIlllllIlllIllIIIlII) {
            final IBlockState lllllllllllllIlllllIlllIllIIIIll = this.world.getBlockState(lllllllllllllIlllllIlllIllIIIlIl.setPos(lllllllllllllIlllllIlllIllIIlIll, lllllllllllllIlllllIlllIllIIIlII, lllllllllllllIlllllIlllIllIIlIIl));
            float[] lllllllllllllIlllllIlllIllIIIIIl = null;
            if (lllllllllllllIlllllIlllIllIIIIll.getBlock() == Blocks.STAINED_GLASS) {
                final float[] lllllllllllllIlllllIlllIllIIIIlI = lllllllllllllIlllllIlllIllIIIIll.getValue(BlockStainedGlass.COLOR).func_193349_f();
            }
            else if (lllllllllllllIlllllIlllIllIIIIll.getBlock() != Blocks.STAINED_GLASS_PANE) {
                if (lllllllllllllIlllllIlllIllIIIIll.getLightOpacity() >= 15 && lllllllllllllIlllllIlllIllIIIIll.getBlock() != Blocks.BEDROCK) {
                    this.isComplete = false;
                    this.beamSegments.clear();
                    break;
                }
                lllllllllllllIlllllIlllIllIIIlll.incrementHeight();
                continue;
            }
            else {
                lllllllllllllIlllllIlllIllIIIIIl = lllllllllllllIlllllIlllIllIIIIll.getValue(BlockStainedGlassPane.COLOR).func_193349_f();
            }
            if (!lllllllllllllIlllllIlllIllIIIllI) {
                lllllllllllllIlllllIlllIllIIIIIl = new float[] { (lllllllllllllIlllllIlllIllIIIlll.getColors()[0] + lllllllllllllIlllllIlllIllIIIIIl[0]) / 2.0f, (lllllllllllllIlllllIlllIllIIIlll.getColors()[1] + lllllllllllllIlllllIlllIllIIIIIl[1]) / 2.0f, (lllllllllllllIlllllIlllIllIIIlll.getColors()[2] + lllllllllllllIlllllIlllIllIIIIIl[2]) / 2.0f };
            }
            if (Arrays.equals(lllllllllllllIlllllIlllIllIIIIIl, lllllllllllllIlllllIlllIllIIIlll.getColors())) {
                lllllllllllllIlllllIlllIllIIIlll.incrementHeight();
            }
            else {
                lllllllllllllIlllllIlllIllIIIlll = new BeamSegment(lllllllllllllIlllllIlllIllIIIIIl);
                this.beamSegments.add(lllllllllllllIlllllIlllIllIIIlll);
            }
            lllllllllllllIlllllIlllIllIIIllI = false;
        }
        if (this.isComplete) {
            for (int lllllllllllllIlllllIlllIllIIIIII = 1; lllllllllllllIlllllIlllIllIIIIII <= 4; this.levels = lllllllllllllIlllllIlllIllIIIIII++) {
                final int lllllllllllllIlllllIlllIlIllllll = lllllllllllllIlllllIlllIllIIlIlI - lllllllllllllIlllllIlllIllIIIIII;
                if (lllllllllllllIlllllIlllIlIllllll < 0) {
                    break;
                }
                boolean lllllllllllllIlllllIlllIlIlllllI = true;
                for (int lllllllllllllIlllllIlllIlIllllIl = lllllllllllllIlllllIlllIllIIlIll - lllllllllllllIlllllIlllIllIIIIII; lllllllllllllIlllllIlllIlIllllIl <= lllllllllllllIlllllIlllIllIIlIll + lllllllllllllIlllllIlllIllIIIIII && lllllllllllllIlllllIlllIlIlllllI; ++lllllllllllllIlllllIlllIlIllllIl) {
                    for (int lllllllllllllIlllllIlllIlIllllII = lllllllllllllIlllllIlllIllIIlIIl - lllllllllllllIlllllIlllIllIIIIII; lllllllllllllIlllllIlllIlIllllII <= lllllllllllllIlllllIlllIllIIlIIl + lllllllllllllIlllllIlllIllIIIIII; ++lllllllllllllIlllllIlllIlIllllII) {
                        final Block lllllllllllllIlllllIlllIlIlllIll = this.world.getBlockState(new BlockPos(lllllllllllllIlllllIlllIlIllllIl, lllllllllllllIlllllIlllIlIllllll, lllllllllllllIlllllIlllIlIllllII)).getBlock();
                        if (lllllllllllllIlllllIlllIlIlllIll != Blocks.EMERALD_BLOCK && lllllllllllllIlllllIlllIlIlllIll != Blocks.GOLD_BLOCK && lllllllllllllIlllllIlllIlIlllIll != Blocks.DIAMOND_BLOCK && lllllllllllllIlllllIlllIlIlllIll != Blocks.IRON_BLOCK) {
                            lllllllllllllIlllllIlllIlIlllllI = false;
                            break;
                        }
                    }
                }
                if (!lllllllllllllIlllllIlllIlIlllllI) {
                    break;
                }
            }
            if (this.levels == 0) {
                this.isComplete = false;
            }
        }
        if (!this.world.isRemote && lllllllllllllIlllllIlllIllIIlIII < this.levels) {
            for (final EntityPlayerMP lllllllllllllIlllllIlllIlIlllIlI : this.world.getEntitiesWithinAABB((Class<? extends EntityPlayerMP>)EntityPlayerMP.class, new AxisAlignedBB(lllllllllllllIlllllIlllIllIIlIll, lllllllllllllIlllllIlllIllIIlIlI, lllllllllllllIlllllIlllIllIIlIIl, lllllllllllllIlllllIlllIllIIlIll, lllllllllllllIlllllIlllIllIIlIlI - 4, lllllllllllllIlllllIlllIllIIlIIl).expand(10.0, 5.0, 10.0))) {
                CriteriaTriggers.field_192131_k.func_192180_a(lllllllllllllIlllllIlllIlIlllIlI, this);
            }
        }
    }
    
    @Override
    public int getFieldCount() {
        return 3;
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:beacon";
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllIlllllIlllIlIIIllIl) {
        super.readFromNBT(lllllllllllllIlllllIlllIlIIIllIl);
        this.primaryEffect = isBeaconEffect(lllllllllllllIlllllIlllIlIIIllIl.getInteger("Primary"));
        this.secondaryEffect = isBeaconEffect(lllllllllllllIlllllIlllIlIIIllIl.getInteger("Secondary"));
        this.levels = lllllllllllllIlllllIlllIlIIIllIl.getInteger("Levels");
    }
    
    public List<BeamSegment> getBeamSegments() {
        return this.beamSegments;
    }
    
    public void updateBeacon() {
        if (this.world != null) {
            this.updateSegmentColors();
            this.addEffectsToPlayers();
        }
    }
    
    public static class BeamSegment
    {
        private /* synthetic */ int height;
        private final /* synthetic */ float[] colors;
        
        public float[] getColors() {
            return this.colors;
        }
        
        public BeamSegment(final float[] lllllllllllllIlllllllIIIlIIllIII) {
            this.colors = lllllllllllllIlllllllIIIlIIllIII;
            this.height = 1;
        }
        
        public int getHeight() {
            return this.height;
        }
        
        protected void incrementHeight() {
            ++this.height;
        }
    }
}
