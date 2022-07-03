package net.minecraft.tileentity;

import net.minecraft.world.*;
import net.minecraft.util.registry.*;
import net.minecraft.util.math.*;
import net.minecraft.nbt.*;
import net.minecraft.util.text.*;
import javax.annotation.*;
import org.apache.logging.log4j.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import net.minecraft.network.play.server.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.crash.*;

public abstract class TileEntity
{
    protected /* synthetic */ World world;
    private static final /* synthetic */ Logger LOGGER;
    protected /* synthetic */ Block blockType;
    private static final /* synthetic */ RegistryNamespaced<ResourceLocation, Class<? extends TileEntity>> field_190562_f;
    protected /* synthetic */ boolean tileEntityInvalid;
    private /* synthetic */ int blockMetadata;
    protected /* synthetic */ BlockPos pos;
    
    public NBTTagCompound getUpdateTag() {
        return this.writeInternal(new NBTTagCompound());
    }
    
    public void readFromNBT(final NBTTagCompound lllllllllllllIIllIllIIIlIlllllIl) {
        this.pos = new BlockPos(lllllllllllllIIllIllIIIlIlllllIl.getInteger("x"), lllllllllllllIIllIllIIIlIlllllIl.getInteger("y"), lllllllllllllIIllIllIIIlIlllllIl.getInteger("z"));
    }
    
    @Nullable
    public ITextComponent getDisplayName() {
        return null;
    }
    
    public void setWorldObj(final World lllllllllllllIIllIllIIIllIIIIllI) {
        this.world = lllllllllllllIIllIllIIIllIIIIllI;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        field_190562_f = new RegistryNamespaced<ResourceLocation, Class<? extends TileEntity>>();
        func_190560_a("furnace", TileEntityFurnace.class);
        func_190560_a("chest", TileEntityChest.class);
        func_190560_a("ender_chest", TileEntityEnderChest.class);
        func_190560_a("jukebox", BlockJukebox.TileEntityJukebox.class);
        func_190560_a("dispenser", TileEntityDispenser.class);
        func_190560_a("dropper", TileEntityDropper.class);
        func_190560_a("sign", TileEntitySign.class);
        func_190560_a("mob_spawner", TileEntityMobSpawner.class);
        func_190560_a("noteblock", TileEntityNote.class);
        func_190560_a("piston", TileEntityPiston.class);
        func_190560_a("brewing_stand", TileEntityBrewingStand.class);
        func_190560_a("enchanting_table", TileEntityEnchantmentTable.class);
        func_190560_a("end_portal", TileEntityEndPortal.class);
        func_190560_a("beacon", TileEntityBeacon.class);
        func_190560_a("skull", TileEntitySkull.class);
        func_190560_a("daylight_detector", TileEntityDaylightDetector.class);
        func_190560_a("hopper", TileEntityHopper.class);
        func_190560_a("comparator", TileEntityComparator.class);
        func_190560_a("flower_pot", TileEntityFlowerPot.class);
        func_190560_a("banner", TileEntityBanner.class);
        func_190560_a("structure_block", TileEntityStructure.class);
        func_190560_a("end_gateway", TileEntityEndGateway.class);
        func_190560_a("command_block", TileEntityCommandBlock.class);
        func_190560_a("shulker_box", TileEntityShulkerBox.class);
        func_190560_a("bed", TileEntityBed.class);
    }
    
    public void mirror(final Mirror lllllllllllllIIllIllIIIlIIIIlllI) {
    }
    
    public int getBlockMetadata() {
        if (this.blockMetadata == -1) {
            final IBlockState lllllllllllllIIllIllIIIlIlIlIlll = this.world.getBlockState(this.pos);
            this.blockMetadata = lllllllllllllIIllIllIIIlIlIlIlll.getBlock().getMetaFromState(lllllllllllllIIllIllIIIlIlIlIlll);
        }
        return this.blockMetadata;
    }
    
    @Nullable
    public SPacketUpdateTileEntity getUpdatePacket() {
        return null;
    }
    
    public void setPos(final BlockPos lllllllllllllIIllIllIIIlIIIlIlII) {
        this.pos = lllllllllllllIIllIllIIIlIIIlIlII.toImmutable();
    }
    
    public boolean receiveClientEvent(final int lllllllllllllIIllIllIIIlIIlIIlII, final int lllllllllllllIIllIllIIIlIIlIIIll) {
        return false;
    }
    
    public void rotate(final Rotation lllllllllllllIIllIllIIIlIIIlIIII) {
    }
    
    public void validate() {
        this.tileEntityInvalid = false;
    }
    
    protected void setWorldCreate(final World lllllllllllllIIllIllIIIlIlIllIll) {
    }
    
    public double getDistanceSq(final double lllllllllllllIIllIllIIIlIlIIIllI, final double lllllllllllllIIllIllIIIlIIlllllI, final double lllllllllllllIIllIllIIIlIlIIIlII) {
        final double lllllllllllllIIllIllIIIlIlIIIIll = this.pos.getX() + 0.5 - lllllllllllllIIllIllIIIlIlIIIllI;
        final double lllllllllllllIIllIllIIIlIlIIIIlI = this.pos.getY() + 0.5 - lllllllllllllIIllIllIIIlIIlllllI;
        final double lllllllllllllIIllIllIIIlIlIIIIIl = this.pos.getZ() + 0.5 - lllllllllllllIIllIllIIIlIlIIIlII;
        return lllllllllllllIIllIllIIIlIlIIIIll * lllllllllllllIIllIllIIIlIlIIIIll + lllllllllllllIIllIllIIIlIlIIIIlI * lllllllllllllIIllIllIIIlIlIIIIlI + lllllllllllllIIllIllIIIlIlIIIIIl * lllllllllllllIIllIllIIIlIlIIIIIl;
    }
    
    private NBTTagCompound writeInternal(final NBTTagCompound lllllllllllllIIllIllIIIlIlllIIlI) {
        final ResourceLocation lllllllllllllIIllIllIIIlIlllIIIl = TileEntity.field_190562_f.getNameForObject(this.getClass());
        if (lllllllllllllIIllIllIIIlIlllIIIl == null) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append(this.getClass()).append(" is missing a mapping! This is a bug!")));
        }
        lllllllllllllIIllIllIIIlIlllIIlI.setString("id", lllllllllllllIIllIllIIIlIlllIIIl.toString());
        lllllllllllllIIllIllIIIlIlllIIlI.setInteger("x", this.pos.getX());
        lllllllllllllIIllIllIIIlIlllIIlI.setInteger("y", this.pos.getY());
        lllllllllllllIIllIllIIIlIlllIIlI.setInteger("z", this.pos.getZ());
        return lllllllllllllIIllIllIIIlIlllIIlI;
    }
    
    public TileEntity() {
        this.pos = BlockPos.ORIGIN;
        this.blockMetadata = -1;
    }
    
    @Nullable
    public static TileEntity create(final World lllllllllllllIIllIllIIIlIllIIIIl, final NBTTagCompound lllllllllllllIIllIllIIIlIllIIIII) {
        TileEntity lllllllllllllIIllIllIIIlIllIIllI = null;
        final String lllllllllllllIIllIllIIIlIllIIlIl = lllllllllllllIIllIllIIIlIllIIIII.getString("id");
        try {
            final Class<? extends TileEntity> lllllllllllllIIllIllIIIlIllIIlII = TileEntity.field_190562_f.getObject(new ResourceLocation(lllllllllllllIIllIllIIIlIllIIlIl));
            if (lllllllllllllIIllIllIIIlIllIIlII != null) {
                lllllllllllllIIllIllIIIlIllIIllI = (TileEntity)lllllllllllllIIllIllIIIlIllIIlII.newInstance();
            }
        }
        catch (Throwable lllllllllllllIIllIllIIIlIllIIIll) {
            TileEntity.LOGGER.error("Failed to create block entity {}", (Object)lllllllllllllIIllIllIIIlIllIIlIl, (Object)lllllllllllllIIllIllIIIlIllIIIll);
        }
        if (lllllllllllllIIllIllIIIlIllIIllI != null) {
            try {
                lllllllllllllIIllIllIIIlIllIIllI.setWorldCreate(lllllllllllllIIllIllIIIlIllIIIIl);
                lllllllllllllIIllIllIIIlIllIIllI.readFromNBT(lllllllllllllIIllIllIIIlIllIIIII);
            }
            catch (Throwable lllllllllllllIIllIllIIIlIllIIIlI) {
                TileEntity.LOGGER.error("Failed to load data for block entity {}", (Object)lllllllllllllIIllIllIIIlIllIIlIl, (Object)lllllllllllllIIllIllIIIlIllIIIlI);
                lllllllllllllIIllIllIIIlIllIIllI = null;
            }
        }
        else {
            TileEntity.LOGGER.warn("Skipping BlockEntity with id {}", (Object)lllllllllllllIIllIllIIIlIllIIlIl);
        }
        return lllllllllllllIIllIllIIIlIllIIllI;
    }
    
    @Nullable
    public static ResourceLocation func_190559_a(final Class<? extends TileEntity> lllllllllllllIIllIllIIIllIIlIIII) {
        return TileEntity.field_190562_f.getNameForObject(lllllllllllllIIllIllIIIllIIlIIII);
    }
    
    public boolean onlyOpsCanSetNbt() {
        return false;
    }
    
    public double getMaxRenderDistanceSquared() {
        return 4096.0;
    }
    
    public boolean isInvalid() {
        return this.tileEntityInvalid;
    }
    
    public void markDirty() {
        if (this.world != null) {
            final IBlockState lllllllllllllIIllIllIIIlIlIlIIIl = this.world.getBlockState(this.pos);
            this.blockMetadata = lllllllllllllIIllIllIIIlIlIlIIIl.getBlock().getMetaFromState(lllllllllllllIIllIllIIIlIlIlIIIl);
            this.world.markChunkDirty(this.pos, this);
            if (this.getBlockType() != Blocks.AIR) {
                this.world.updateComparatorOutputLevel(this.pos, this.getBlockType());
            }
        }
    }
    
    public Block getBlockType() {
        if (this.blockType == null && this.world != null) {
            this.blockType = this.world.getBlockState(this.pos).getBlock();
        }
        return this.blockType;
    }
    
    public boolean hasWorldObj() {
        return this.world != null;
    }
    
    public World getWorld() {
        return this.world;
    }
    
    public void updateContainingBlockInfo() {
        this.blockType = null;
        this.blockMetadata = -1;
    }
    
    public void invalidate() {
        this.tileEntityInvalid = true;
    }
    
    private static void func_190560_a(final String lllllllllllllIIllIllIIIllIIlIlIl, final Class<? extends TileEntity> lllllllllllllIIllIllIIIllIIlIIlI) {
        TileEntity.field_190562_f.putObject(new ResourceLocation(lllllllllllllIIllIllIIIllIIlIlIl), lllllllllllllIIllIllIIIllIIlIIlI);
    }
    
    public void addInfoToCrashReport(final CrashReportCategory lllllllllllllIIllIllIIIlIIIlllII) {
        lllllllllllllIIllIllIIIlIIIlllII.setDetail("Name", new ICrashReportDetail<String>() {
            @Override
            public String call() throws Exception {
                return String.valueOf(new StringBuilder().append(TileEntity.field_190562_f.getNameForObject(TileEntity.this.getClass())).append(" // ").append(TileEntity.this.getClass().getCanonicalName()));
            }
        });
        if (this.world != null) {
            CrashReportCategory.addBlockInfo(lllllllllllllIIllIllIIIlIIIlllII, this.pos, this.getBlockType(), this.getBlockMetadata());
            lllllllllllllIIllIllIIIlIIIlllII.setDetail("Actual block type", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    final int lllllllllllllIllIIlllIllllIIlIIl = Block.getIdFromBlock(TileEntity.this.world.getBlockState(TileEntity.this.pos).getBlock());
                    try {
                        return String.format("ID #%d (%s // %s)", lllllllllllllIllIIlllIllllIIlIIl, Block.getBlockById(lllllllllllllIllIIlllIllllIIlIIl).getUnlocalizedName(), Block.getBlockById(lllllllllllllIllIIlllIllllIIlIIl).getClass().getCanonicalName());
                    }
                    catch (Throwable lllllllllllllIllIIlllIllllIIIlll) {
                        return String.valueOf(new StringBuilder("ID #").append(lllllllllllllIllIIlllIllllIIlIIl));
                    }
                }
            });
            lllllllllllllIIllIllIIIlIIIlllII.setDetail("Actual block data value", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    final IBlockState lllllllllllllIIlIIlIlIIllIlIlIIl = TileEntity.this.world.getBlockState(TileEntity.this.pos);
                    final int lllllllllllllIIlIIlIlIIllIlIlIII = lllllllllllllIIlIIlIlIIllIlIlIIl.getBlock().getMetaFromState(lllllllllllllIIlIIlIlIIllIlIlIIl);
                    if (lllllllllllllIIlIIlIlIIllIlIlIII < 0) {
                        return String.valueOf(new StringBuilder("Unknown? (Got ").append(lllllllllllllIIlIIlIlIIllIlIlIII).append(")"));
                    }
                    final String lllllllllllllIIlIIlIlIIllIlIIlll = String.format("%4s", Integer.toBinaryString(lllllllllllllIIlIIlIlIIllIlIlIII)).replace(" ", "0");
                    return String.format("%1$d / 0x%1$X / 0b%2$s", lllllllllllllIIlIIlIlIIllIlIlIII, lllllllllllllIIlIIlIlIIllIlIIlll);
                }
            });
        }
    }
    
    public BlockPos getPos() {
        return this.pos;
    }
    
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllIIllIllIIIlIllllIIl) {
        return this.writeInternal(lllllllllllllIIllIllIIIlIllllIIl);
    }
}
