package net.minecraft.tileentity;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.server.*;
import net.minecraft.world.gen.structure.template.*;
import net.minecraft.block.state.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.world.gen.structure.*;
import io.netty.buffer.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.text.*;
import javax.annotation.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.network.play.server.*;
import net.minecraft.entity.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import net.minecraft.util.*;

public class TileEntityStructure extends TileEntity
{
    private /* synthetic */ String name;
    private /* synthetic */ Mode mode;
    private /* synthetic */ String metadata;
    private /* synthetic */ float integrity;
    private /* synthetic */ boolean ignoreEntities;
    private /* synthetic */ BlockPos position;
    private /* synthetic */ boolean powered;
    private /* synthetic */ Rotation rotation;
    private /* synthetic */ boolean showBoundingBox;
    private /* synthetic */ boolean showAir;
    private /* synthetic */ long seed;
    private /* synthetic */ Mirror mirror;
    private /* synthetic */ BlockPos size;
    private /* synthetic */ String author;
    
    public void setMirror(final Mirror lllllllllllllIlIlIllIlIlIIIlllII) {
        this.mirror = lllllllllllllIlIlIllIlIlIIIlllII;
    }
    
    public float getIntegrity() {
        return this.integrity;
    }
    
    public boolean load(final boolean lllllllllllllIlIlIllIlIIIIlIIIIl) {
        if (this.mode != Mode.LOAD || this.world.isRemote || StringUtils.isNullOrEmpty(this.name)) {
            return false;
        }
        final BlockPos lllllllllllllIlIlIllIlIIIIlIllII = this.getPos();
        final BlockPos lllllllllllllIlIlIllIlIIIIlIlIll = lllllllllllllIlIlIllIlIIIIlIllII.add(this.position);
        final WorldServer lllllllllllllIlIlIllIlIIIIlIlIlI = (WorldServer)this.world;
        final MinecraftServer lllllllllllllIlIlIllIlIIIIlIlIIl = this.world.getMinecraftServer();
        final TemplateManager lllllllllllllIlIlIllIlIIIIlIlIII = lllllllllllllIlIlIllIlIIIIlIlIlI.getStructureTemplateManager();
        final Template lllllllllllllIlIlIllIlIIIIlIIlll = lllllllllllllIlIlIllIlIIIIlIlIII.get(lllllllllllllIlIlIllIlIIIIlIlIIl, new ResourceLocation(this.name));
        if (lllllllllllllIlIlIllIlIIIIlIIlll == null) {
            return false;
        }
        if (!StringUtils.isNullOrEmpty(lllllllllllllIlIlIllIlIIIIlIIlll.getAuthor())) {
            this.author = lllllllllllllIlIlIllIlIIIIlIIlll.getAuthor();
        }
        final BlockPos lllllllllllllIlIlIllIlIIIIlIIllI = lllllllllllllIlIlIllIlIIIIlIIlll.getSize();
        final boolean lllllllllllllIlIlIllIlIIIIlIIlIl = this.size.equals(lllllllllllllIlIlIllIlIIIIlIIllI);
        if (!lllllllllllllIlIlIllIlIIIIlIIlIl) {
            this.size = lllllllllllllIlIlIllIlIIIIlIIllI;
            this.markDirty();
            final IBlockState lllllllllllllIlIlIllIlIIIIlIIlII = this.world.getBlockState(lllllllllllllIlIlIllIlIIIIlIllII);
            this.world.notifyBlockUpdate(lllllllllllllIlIlIllIlIIIIlIllII, lllllllllllllIlIlIllIlIIIIlIIlII, lllllllllllllIlIlIllIlIIIIlIIlII, 3);
        }
        if (lllllllllllllIlIlIllIlIIIIlIIIIl && !lllllllllllllIlIlIllIlIIIIlIIlIl) {
            return false;
        }
        final PlacementSettings lllllllllllllIlIlIllIlIIIIlIIIll = new PlacementSettings().setMirror(this.mirror).setRotation(this.rotation).setIgnoreEntities(this.ignoreEntities).setChunk(null).setReplacedBlock(null).setIgnoreStructureBlock(false);
        if (this.integrity < 1.0f) {
            lllllllllllllIlIlIllIlIIIIlIIIll.setIntegrity(MathHelper.clamp(this.integrity, 0.0f, 1.0f)).setSeed(this.seed);
        }
        lllllllllllllIlIlIllIlIIIIlIIlll.addBlocksToWorldChunk(this.world, lllllllllllllIlIlIllIlIIIIlIlIll, lllllllllllllIlIlIllIlIIIIlIIIll);
        return true;
    }
    
    public void setRotation(final Rotation lllllllllllllIlIlIllIlIlIIIlIIlI) {
        this.rotation = lllllllllllllIlIlIllIlIlIIIlIIlI;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode() {
        final int[] $switch_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode = TileEntityStructure.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode;
        if ($switch_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode != null) {
            return $switch_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode;
        }
        final short lllllllllllllIlIlIllIIlllllIIIll = (Object)new int[Mode.values().length];
        try {
            lllllllllllllIlIlIllIIlllllIIIll[Mode.CORNER.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIlIllIIlllllIIIll[Mode.DATA.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIlIllIIlllllIIIll[Mode.LOAD.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlIlIllIIlllllIIIll[Mode.SAVE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return TileEntityStructure.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode = (int[])(Object)lllllllllllllIlIlIllIIlllllIIIll;
    }
    
    public boolean isStructureLoadable() {
        if (this.mode == Mode.LOAD && !this.world.isRemote) {
            final WorldServer lllllllllllllIlIlIllIlIIIIIIlIIl = (WorldServer)this.world;
            final MinecraftServer lllllllllllllIlIlIllIlIIIIIIlIII = this.world.getMinecraftServer();
            final TemplateManager lllllllllllllIlIlIllIlIIIIIIIlll = lllllllllllllIlIlIllIlIIIIIIlIIl.getStructureTemplateManager();
            return lllllllllllllIlIlIllIlIIIIIIIlll.get(lllllllllllllIlIlIllIlIIIIIIlIII, new ResourceLocation(this.name)) != null;
        }
        return false;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllIlIlIllIlIllIIIIllI) {
        super.writeToNBT(lllllllllllllIlIlIllIlIllIIIIllI);
        lllllllllllllIlIlIllIlIllIIIIllI.setString("name", this.name);
        lllllllllllllIlIlIllIlIllIIIIllI.setString("author", this.author);
        lllllllllllllIlIlIllIlIllIIIIllI.setString("metadata", this.metadata);
        lllllllllllllIlIlIllIlIllIIIIllI.setInteger("posX", this.position.getX());
        lllllllllllllIlIlIllIlIllIIIIllI.setInteger("posY", this.position.getY());
        lllllllllllllIlIlIllIlIllIIIIllI.setInteger("posZ", this.position.getZ());
        lllllllllllllIlIlIllIlIllIIIIllI.setInteger("sizeX", this.size.getX());
        lllllllllllllIlIlIllIlIllIIIIllI.setInteger("sizeY", this.size.getY());
        lllllllllllllIlIlIllIlIllIIIIllI.setInteger("sizeZ", this.size.getZ());
        lllllllllllllIlIlIllIlIllIIIIllI.setString("rotation", this.rotation.toString());
        lllllllllllllIlIlIllIlIllIIIIllI.setString("mirror", this.mirror.toString());
        lllllllllllllIlIlIllIlIllIIIIllI.setString("mode", this.mode.toString());
        lllllllllllllIlIlIllIlIllIIIIllI.setBoolean("ignoreEntities", this.ignoreEntities);
        lllllllllllllIlIlIllIlIllIIIIllI.setBoolean("powered", this.powered);
        lllllllllllllIlIlIllIlIllIIIIllI.setBoolean("showair", this.showAir);
        lllllllllllllIlIlIllIlIllIIIIllI.setBoolean("showboundingbox", this.showBoundingBox);
        lllllllllllllIlIlIllIlIllIIIIllI.setFloat("integrity", this.integrity);
        lllllllllllllIlIlIllIlIllIIIIllI.setLong("seed", this.seed);
        return lllllllllllllIlIlIllIlIllIIIIllI;
    }
    
    public void setIgnoresEntities(final boolean lllllllllllllIlIlIllIlIIlIlllllI) {
        this.ignoreEntities = lllllllllllllIlIlIllIlIIlIlllllI;
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setIntegrity(final float lllllllllllllIlIlIllIlIIlIllIlIl) {
        this.integrity = lllllllllllllIlIlIllIlIIlIllIlIl;
    }
    
    private StructureBoundingBox calculateEnclosingBoundingBox(final BlockPos lllllllllllllIlIlIllIlIIIllIIlll, final List<TileEntityStructure> lllllllllllllIlIlIllIlIIIlIlllll) {
        StructureBoundingBox lllllllllllllIlIlIllIlIIIllIIlII = null;
        if (lllllllllllllIlIlIllIlIIIlIlllll.size() > 1) {
            final BlockPos lllllllllllllIlIlIllIlIIIllIIIll = lllllllllllllIlIlIllIlIIIlIlllll.get(0).getPos();
            final StructureBoundingBox lllllllllllllIlIlIllIlIIIllIIlIl = new StructureBoundingBox(lllllllllllllIlIlIllIlIIIllIIIll, lllllllllllllIlIlIllIlIIIllIIIll);
        }
        else {
            lllllllllllllIlIlIllIlIIIllIIlII = new StructureBoundingBox(lllllllllllllIlIlIllIlIIIllIIlll, lllllllllllllIlIlIllIlIIIllIIlll);
        }
        for (final TileEntityStructure lllllllllllllIlIlIllIlIIIllIIIlI : lllllllllllllIlIlIllIlIIIlIlllll) {
            final BlockPos lllllllllllllIlIlIllIlIIIllIIIIl = lllllllllllllIlIlIllIlIIIllIIIlI.getPos();
            if (lllllllllllllIlIlIllIlIIIllIIIIl.getX() < lllllllllllllIlIlIllIlIIIllIIlII.minX) {
                lllllllllllllIlIlIllIlIIIllIIlII.minX = lllllllllllllIlIlIllIlIIIllIIIIl.getX();
            }
            else if (lllllllllllllIlIlIllIlIIIllIIIIl.getX() > lllllllllllllIlIlIllIlIIIllIIlII.maxX) {
                lllllllllllllIlIlIllIlIIIllIIlII.maxX = lllllllllllllIlIlIllIlIIIllIIIIl.getX();
            }
            if (lllllllllllllIlIlIllIlIIIllIIIIl.getY() < lllllllllllllIlIlIllIlIIIllIIlII.minY) {
                lllllllllllllIlIlIllIlIIIllIIlII.minY = lllllllllllllIlIlIllIlIIIllIIIIl.getY();
            }
            else if (lllllllllllllIlIlIllIlIIIllIIIIl.getY() > lllllllllllllIlIlIllIlIIIllIIlII.maxY) {
                lllllllllllllIlIlIllIlIIIllIIlII.maxY = lllllllllllllIlIlIllIlIIIllIIIIl.getY();
            }
            if (lllllllllllllIlIlIllIlIIIllIIIIl.getZ() < lllllllllllllIlIlIllIlIIIllIIlII.minZ) {
                lllllllllllllIlIlIllIlIIIllIIlII.minZ = lllllllllllllIlIlIllIlIIIllIIIIl.getZ();
            }
            else {
                if (lllllllllllllIlIlIllIlIIIllIIIIl.getZ() <= lllllllllllllIlIlIllIlIIIllIIlII.maxZ) {
                    continue;
                }
                lllllllllllllIlIlIllIlIIIllIIlII.maxZ = lllllllllllllIlIlIllIlIIIllIIIIl.getZ();
            }
        }
        return lllllllllllllIlIlIllIlIIIllIIlII;
    }
    
    public BlockPos getStructureSize() {
        return this.size;
    }
    
    public void writeCoordinates(final ByteBuf lllllllllllllIlIlIllIlIIIlIlIlIl) {
        lllllllllllllIlIlIllIlIIIlIlIlIl.writeInt(this.pos.getX());
        lllllllllllllIlIlIllIlIIIlIlIlIl.writeInt(this.pos.getY());
        lllllllllllllIlIlIllIlIIIlIlIlIl.writeInt(this.pos.getZ());
    }
    
    public void setMetadata(final String lllllllllllllIlIlIllIlIlIIIIIIIl) {
        this.metadata = lllllllllllllIlIlIllIlIlIIIIIIIl;
    }
    
    public String getMetadata() {
        return this.metadata;
    }
    
    public boolean save() {
        return this.save(true);
    }
    
    public boolean save(final boolean lllllllllllllIlIlIllIlIIIlIIlIIl) {
        if (this.mode == Mode.SAVE && !this.world.isRemote && !StringUtils.isNullOrEmpty(this.name)) {
            final BlockPos lllllllllllllIlIlIllIlIIIlIIlIII = this.getPos().add(this.position);
            final WorldServer lllllllllllllIlIlIllIlIIIlIIIlll = (WorldServer)this.world;
            final MinecraftServer lllllllllllllIlIlIllIlIIIlIIIllI = this.world.getMinecraftServer();
            final TemplateManager lllllllllllllIlIlIllIlIIIlIIIlIl = lllllllllllllIlIlIllIlIIIlIIIlll.getStructureTemplateManager();
            final Template lllllllllllllIlIlIllIlIIIlIIIlII = lllllllllllllIlIlIllIlIIIlIIIlIl.getTemplate(lllllllllllllIlIlIllIlIIIlIIIllI, new ResourceLocation(this.name));
            lllllllllllllIlIlIllIlIIIlIIIlII.takeBlocksFromWorld(this.world, lllllllllllllIlIlIllIlIIIlIIlIII, this.size, !this.ignoreEntities, Blocks.STRUCTURE_VOID);
            lllllllllllllIlIlIllIlIIIlIIIlII.setAuthor(this.author);
            return !lllllllllllllIlIlIllIlIIIlIIlIIl || lllllllllllllIlIlIllIlIIIlIIIlIl.writeTemplate(lllllllllllllIlIlIllIlIIIlIIIllI, new ResourceLocation(this.name));
        }
        return false;
    }
    
    public boolean showsAir() {
        return this.showAir;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllIlIlIllIlIlIllllIIl) {
        super.readFromNBT(lllllllllllllIlIlIllIlIlIllllIIl);
        this.setName(lllllllllllllIlIlIllIlIlIllllIIl.getString("name"));
        this.author = lllllllllllllIlIlIllIlIlIllllIIl.getString("author");
        this.metadata = lllllllllllllIlIlIllIlIlIllllIIl.getString("metadata");
        final int lllllllllllllIlIlIllIlIlIllllIII = MathHelper.clamp(lllllllllllllIlIlIllIlIlIllllIIl.getInteger("posX"), -32, 32);
        final int lllllllllllllIlIlIllIlIlIlllIlll = MathHelper.clamp(lllllllllllllIlIlIllIlIlIllllIIl.getInteger("posY"), -32, 32);
        final int lllllllllllllIlIlIllIlIlIlllIllI = MathHelper.clamp(lllllllllllllIlIlIllIlIlIllllIIl.getInteger("posZ"), -32, 32);
        this.position = new BlockPos(lllllllllllllIlIlIllIlIlIllllIII, lllllllllllllIlIlIllIlIlIlllIlll, lllllllllllllIlIlIllIlIlIlllIllI);
        final int lllllllllllllIlIlIllIlIlIlllIlIl = MathHelper.clamp(lllllllllllllIlIlIllIlIlIllllIIl.getInteger("sizeX"), 0, 32);
        final int lllllllllllllIlIlIllIlIlIlllIlII = MathHelper.clamp(lllllllllllllIlIlIllIlIlIllllIIl.getInteger("sizeY"), 0, 32);
        final int lllllllllllllIlIlIllIlIlIlllIIll = MathHelper.clamp(lllllllllllllIlIlIllIlIlIllllIIl.getInteger("sizeZ"), 0, 32);
        this.size = new BlockPos(lllllllllllllIlIlIllIlIlIlllIlIl, lllllllllllllIlIlIllIlIlIlllIlII, lllllllllllllIlIlIllIlIlIlllIIll);
        try {
            this.rotation = Rotation.valueOf(lllllllllllllIlIlIllIlIlIllllIIl.getString("rotation"));
        }
        catch (IllegalArgumentException lllllllllllllIlIlIllIlIlIlllIIlI) {
            this.rotation = Rotation.NONE;
        }
        try {
            this.mirror = Mirror.valueOf(lllllllllllllIlIlIllIlIlIllllIIl.getString("mirror"));
        }
        catch (IllegalArgumentException lllllllllllllIlIlIllIlIlIlllIIIl) {
            this.mirror = Mirror.NONE;
        }
        try {
            this.mode = Mode.valueOf(lllllllllllllIlIlIllIlIlIllllIIl.getString("mode"));
        }
        catch (IllegalArgumentException lllllllllllllIlIlIllIlIlIlllIIII) {
            this.mode = Mode.DATA;
        }
        this.ignoreEntities = lllllllllllllIlIlIllIlIlIllllIIl.getBoolean("ignoreEntities");
        this.powered = lllllllllllllIlIlIllIlIlIllllIIl.getBoolean("powered");
        this.showAir = lllllllllllllIlIlIllIlIlIllllIIl.getBoolean("showair");
        this.showBoundingBox = lllllllllllllIlIlIllIlIlIllllIIl.getBoolean("showboundingbox");
        if (lllllllllllllIlIlIllIlIlIllllIIl.hasKey("integrity")) {
            this.integrity = lllllllllllllIlIlIllIlIlIllllIIl.getFloat("integrity");
        }
        else {
            this.integrity = 1.0f;
        }
        this.seed = lllllllllllllIlIlIllIlIlIllllIIl.getLong("seed");
        this.updateBlockState();
    }
    
    public void setSeed(final long lllllllllllllIlIlIllIlIIlIlIlIlI) {
        this.seed = lllllllllllllIlIlIllIlIIlIlIlIlI;
    }
    
    public boolean detectSize() {
        if (this.mode != Mode.SAVE) {
            return false;
        }
        final BlockPos lllllllllllllIlIlIllIlIIlIIlllll = this.getPos();
        final int lllllllllllllIlIlIllIlIIlIIllllI = 80;
        final BlockPos lllllllllllllIlIlIllIlIIlIIlllIl = new BlockPos(lllllllllllllIlIlIllIlIIlIIlllll.getX() - 80, 0, lllllllllllllIlIlIllIlIIlIIlllll.getZ() - 80);
        final BlockPos lllllllllllllIlIlIllIlIIlIIlllII = new BlockPos(lllllllllllllIlIlIllIlIIlIIlllll.getX() + 80, 255, lllllllllllllIlIlIllIlIIlIIlllll.getZ() + 80);
        final List<TileEntityStructure> lllllllllllllIlIlIllIlIIlIIllIll = this.getNearbyCornerBlocks(lllllllllllllIlIlIllIlIIlIIlllIl, lllllllllllllIlIlIllIlIIlIIlllII);
        final List<TileEntityStructure> lllllllllllllIlIlIllIlIIlIIllIlI = this.filterRelatedCornerBlocks(lllllllllllllIlIlIllIlIIlIIllIll);
        if (lllllllllllllIlIlIllIlIIlIIllIlI.size() < 1) {
            return false;
        }
        final StructureBoundingBox lllllllllllllIlIlIllIlIIlIIllIIl = this.calculateEnclosingBoundingBox(lllllllllllllIlIlIllIlIIlIIlllll, lllllllllllllIlIlIllIlIIlIIllIlI);
        if (lllllllllllllIlIlIllIlIIlIIllIIl.maxX - lllllllllllllIlIlIllIlIIlIIllIIl.minX > 1 && lllllllllllllIlIlIllIlIIlIIllIIl.maxY - lllllllllllllIlIlIllIlIIlIIllIIl.minY > 1 && lllllllllllllIlIlIllIlIIlIIllIIl.maxZ - lllllllllllllIlIlIllIlIIlIIllIIl.minZ > 1) {
            this.position = new BlockPos(lllllllllllllIlIlIllIlIIlIIllIIl.minX - lllllllllllllIlIlIllIlIIlIIlllll.getX() + 1, lllllllllllllIlIlIllIlIIlIIllIIl.minY - lllllllllllllIlIlIllIlIIlIIlllll.getY() + 1, lllllllllllllIlIlIllIlIIlIIllIIl.minZ - lllllllllllllIlIlIllIlIIlIIlllll.getZ() + 1);
            this.size = new BlockPos(lllllllllllllIlIlIllIlIIlIIllIIl.maxX - lllllllllllllIlIlIllIlIIlIIllIIl.minX - 1, lllllllllllllIlIlIllIlIIlIIllIIl.maxY - lllllllllllllIlIlIllIlIIlIIllIIl.minY - 1, lllllllllllllIlIlIllIlIIlIIllIIl.maxZ - lllllllllllllIlIlIllIlIIlIIllIIl.minZ - 1);
            this.markDirty();
            final IBlockState lllllllllllllIlIlIllIlIIlIIllIII = this.world.getBlockState(lllllllllllllIlIlIllIlIIlIIlllll);
            this.world.notifyBlockUpdate(lllllllllllllIlIlIllIlIIlIIlllll, lllllllllllllIlIlIllIlIIlIIllIII, lllllllllllllIlIlIllIlIIlIIllIII, 3);
            return true;
        }
        return false;
    }
    
    public boolean usedBy(final EntityPlayer lllllllllllllIlIlIllIlIlIlIlIIlI) {
        if (!lllllllllllllIlIlIllIlIlIlIlIIlI.canUseCommandBlock()) {
            return false;
        }
        if (lllllllllllllIlIlIllIlIlIlIlIIlI.getEntityWorld().isRemote) {
            lllllllllllllIlIlIllIlIlIlIlIIlI.openEditStructure(this);
        }
        return true;
    }
    
    public boolean load() {
        return this.load(true);
    }
    
    public void setShowBoundingBox(final boolean lllllllllllllIlIlIllIIlllllIlIlI) {
        this.showBoundingBox = lllllllllllllIlIlIllIIlllllIlIlI;
    }
    
    public void setShowAir(final boolean lllllllllllllIlIlIllIIllllllIIll) {
        this.showAir = lllllllllllllIlIlIllIIllllllIIll;
    }
    
    public Mode getMode() {
        return this.mode;
    }
    
    public Mirror getMirror() {
        return this.mirror;
    }
    
    public void nextMode() {
        switch ($SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode()[this.getMode().ordinal()]) {
            case 1: {
                this.setMode(Mode.LOAD);
                break;
            }
            case 2: {
                this.setMode(Mode.CORNER);
                break;
            }
            case 3: {
                this.setMode(Mode.DATA);
                break;
            }
            case 4: {
                this.setMode(Mode.SAVE);
                break;
            }
        }
    }
    
    public void unloadStructure() {
        final WorldServer lllllllllllllIlIlIllIlIIIIIlIIll = (WorldServer)this.world;
        final TemplateManager lllllllllllllIlIlIllIlIIIIIlIIlI = lllllllllllllIlIlIllIlIIIIIlIIll.getStructureTemplateManager();
        lllllllllllllIlIlIllIlIIIIIlIIlI.remove(new ResourceLocation(this.name));
    }
    
    public void setSize(final BlockPos lllllllllllllIlIlIllIlIlIIlIIlIl) {
        this.size = lllllllllllllIlIlIllIlIlIIlIIlIl;
    }
    
    @Nullable
    @Override
    public ITextComponent getDisplayName() {
        return new TextComponentTranslation(String.valueOf(new StringBuilder("structure_block.hover.").append(this.mode.modeName)), new Object[] { (this.mode == Mode.DATA) ? this.metadata : this.name });
    }
    
    private void updateBlockState() {
        if (this.world != null) {
            final BlockPos lllllllllllllIlIlIllIlIlIllIIIlI = this.getPos();
            final IBlockState lllllllllllllIlIlIllIlIlIllIIIIl = this.world.getBlockState(lllllllllllllIlIlIllIlIlIllIIIlI);
            if (lllllllllllllIlIlIllIlIlIllIIIIl.getBlock() == Blocks.STRUCTURE_BLOCK) {
                this.world.setBlockState(lllllllllllllIlIlIllIlIlIllIIIlI, lllllllllllllIlIlIllIlIlIllIIIIl.withProperty(BlockStructure.MODE, this.mode), 2);
            }
        }
    }
    
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.pos, 7, this.getUpdateTag());
    }
    
    public boolean ignoresEntities() {
        return this.ignoreEntities;
    }
    
    private List<TileEntityStructure> getNearbyCornerBlocks(final BlockPos lllllllllllllIlIlIllIlIIIlllIlIl, final BlockPos lllllllllllllIlIlIllIlIIIllllIll) {
        final List<TileEntityStructure> lllllllllllllIlIlIllIlIIIllllIlI = (List<TileEntityStructure>)Lists.newArrayList();
        for (final BlockPos.MutableBlockPos lllllllllllllIlIlIllIlIIIllllIIl : BlockPos.getAllInBoxMutable(lllllllllllllIlIlIllIlIIIlllIlIl, lllllllllllllIlIlIllIlIIIllllIll)) {
            final IBlockState lllllllllllllIlIlIllIlIIIllllIII = this.world.getBlockState(lllllllllllllIlIlIllIlIIIllllIIl);
            if (lllllllllllllIlIlIllIlIIIllllIII.getBlock() == Blocks.STRUCTURE_BLOCK) {
                final TileEntity lllllllllllllIlIlIllIlIIIlllIlll = this.world.getTileEntity(lllllllllllllIlIlIllIlIIIllllIIl);
                if (lllllllllllllIlIlIllIlIIIlllIlll == null || !(lllllllllllllIlIlIllIlIIIlllIlll instanceof TileEntityStructure)) {
                    continue;
                }
                lllllllllllllIlIlIllIlIIIllllIlI.add((TileEntityStructure)lllllllllllllIlIlIllIlIIIlllIlll);
            }
        }
        return lllllllllllllIlIlIllIlIIIllllIlI;
    }
    
    public void setMode(final Mode lllllllllllllIlIlIllIlIIlllIIIII) {
        this.mode = lllllllllllllIlIlIllIlIIlllIIIII;
        final IBlockState lllllllllllllIlIlIllIlIIllIllllI = this.world.getBlockState(this.getPos());
        if (lllllllllllllIlIlIllIlIIllIllllI.getBlock() == Blocks.STRUCTURE_BLOCK) {
            this.world.setBlockState(this.getPos(), lllllllllllllIlIlIllIlIIllIllllI.withProperty(BlockStructure.MODE, lllllllllllllIlIlIllIlIIlllIIIII), 2);
        }
    }
    
    public void createdBy(final EntityLivingBase lllllllllllllIlIlIllIlIlIIllIlll) {
        if (!StringUtils.isNullOrEmpty(lllllllllllllIlIlIllIlIlIIllIlll.getName())) {
            this.author = lllllllllllllIlIlIllIlIlIIllIlll.getName();
        }
    }
    
    public void setName(final String lllllllllllllIlIlIllIlIlIlIIIllI) {
        String lllllllllllllIlIlIllIlIlIlIIIlIl = lllllllllllllIlIlIllIlIlIlIIIllI;
        final char lllllllllllllIlIlIllIlIlIIllllIl;
        final boolean lllllllllllllIlIlIllIlIlIIlllllI = ((char[])(Object)(lllllllllllllIlIlIllIlIlIIllllIl = (char)(Object)ChatAllowedCharacters.ILLEGAL_STRUCTURE_CHARACTERS)).length != 0;
        for (double lllllllllllllIlIlIllIlIlIIllllll = 0; lllllllllllllIlIlIllIlIlIIllllll < (lllllllllllllIlIlIllIlIlIIlllllI ? 1 : 0); ++lllllllllllllIlIlIllIlIlIIllllll) {
            final char lllllllllllllIlIlIllIlIlIlIIIlII = lllllllllllllIlIlIllIlIlIIllllIl[lllllllllllllIlIlIllIlIlIIllllll];
            lllllllllllllIlIlIllIlIlIlIIIlIl = lllllllllllllIlIlIllIlIlIlIIIlIl.replace(lllllllllllllIlIlIllIlIlIlIIIlII, '_');
        }
        this.name = lllllllllllllIlIlIllIlIlIlIIIlIl;
    }
    
    public void setPowered(final boolean lllllllllllllIlIlIllIIllllllllII) {
        this.powered = lllllllllllllIlIlIllIIllllllllII;
    }
    
    private List<TileEntityStructure> filterRelatedCornerBlocks(final List<TileEntityStructure> lllllllllllllIlIlIllIlIIlIIIlIlI) {
        final Iterable<TileEntityStructure> lllllllllllllIlIlIllIlIIlIIIlIIl = (Iterable<TileEntityStructure>)Iterables.filter((Iterable)lllllllllllllIlIlIllIlIIlIIIlIlI, (Predicate)new Predicate<TileEntityStructure>() {
            public boolean apply(@Nullable final TileEntityStructure llllllllllllllIlIIllIIIllIlIIlIl) {
                return llllllllllllllIlIIllIIIllIlIIlIl.mode == Mode.CORNER && TileEntityStructure.this.name.equals(llllllllllllllIlIIllIIIllIlIIlIl.name);
            }
        });
        return (List<TileEntityStructure>)Lists.newArrayList((Iterable)lllllllllllllIlIlIllIlIIlIIIlIIl);
    }
    
    public Rotation getRotation() {
        return this.rotation;
    }
    
    public boolean isPowered() {
        return this.powered;
    }
    
    public void setPosition(final BlockPos lllllllllllllIlIlIllIlIlIIllIIII) {
        this.position = lllllllllllllIlIlIllIlIlIIllIIII;
    }
    
    public TileEntityStructure() {
        this.name = "";
        this.author = "";
        this.metadata = "";
        this.position = new BlockPos(0, 1, 0);
        this.size = BlockPos.ORIGIN;
        this.mirror = Mirror.NONE;
        this.rotation = Rotation.NONE;
        this.mode = Mode.DATA;
        this.ignoreEntities = true;
        this.showBoundingBox = true;
        this.integrity = 1.0f;
    }
    
    public long getSeed() {
        return this.seed;
    }
    
    public BlockPos getPosition() {
        return this.position;
    }
    
    public boolean showsBoundingBox() {
        return this.showBoundingBox;
    }
    
    public enum Mode implements IStringSerializable
    {
        SAVE("SAVE", 0, "save", 0), 
        LOAD("LOAD", 1, "load", 1);
        
        private static final /* synthetic */ Mode[] MODES;
        
        DATA("DATA", 3, "data", 3);
        
        private final /* synthetic */ int modeId;
        
        CORNER("CORNER", 2, "corner", 2);
        
        private final /* synthetic */ String modeName;
        
        public int getModeId() {
            return this.modeId;
        }
        
        @Override
        public String getName() {
            return this.modeName;
        }
        
        private Mode(final String llllllllllllllIIlIlllIIIIlIIIIIl, final int llllllllllllllIIlIlllIIIIlIIIIII, final String llllllllllllllIIlIlllIIIIIllllll, final int llllllllllllllIIlIlllIIIIlIIIIll) {
            this.modeName = llllllllllllllIIlIlllIIIIIllllll;
            this.modeId = llllllllllllllIIlIlllIIIIlIIIIll;
        }
        
        static {
            MODES = new Mode[values().length];
            final char llllllllllllllIIlIlllIIIIlIIlIll;
            final Exception llllllllllllllIIlIlllIIIIlIIllII = (Exception)((Mode[])(Object)(llllllllllllllIIlIlllIIIIlIIlIll = (char)(Object)values())).length;
            for (double llllllllllllllIIlIlllIIIIlIIllIl = 0; llllllllllllllIIlIlllIIIIlIIllIl < llllllllllllllIIlIlllIIIIlIIllII; ++llllllllllllllIIlIlllIIIIlIIllIl) {
                final Mode llllllllllllllIIlIlllIIIIlIIllll = llllllllllllllIIlIlllIIIIlIIlIll[llllllllllllllIIlIlllIIIIlIIllIl];
                Mode.MODES[llllllllllllllIIlIlllIIIIlIIllll.getModeId()] = llllllllllllllIIlIlllIIIIlIIllll;
            }
        }
        
        public static Mode getById(final int llllllllllllllIIlIlllIIIIIllIllI) {
            return (llllllllllllllIIlIlllIIIIIllIllI >= 0 && llllllllllllllIIlIlllIIIIIllIllI < Mode.MODES.length) ? Mode.MODES[llllllllllllllIIlIlllIIIIIllIllI] : Mode.MODES[0];
        }
    }
}
