package net.minecraft.world.chunk;

import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import javax.annotation.*;
import net.minecraft.util.math.*;
import com.google.common.base.*;
import net.minecraft.tileentity.*;
import java.util.*;
import net.minecraft.world.*;

public class EmptyChunk extends Chunk
{
    @Override
    public void removeEntityAtIndex(final Entity llllllllllllllIlIIIlllIIIIllIIIl, final int llllllllllllllIlIIIlllIIIIlIllll) {
    }
    
    @Override
    public int getLightSubtracted(final BlockPos llllllllllllllIlIIIlllIIIIllllll, final int llllllllllllllIlIIIlllIIIIlllllI) {
        return 0;
    }
    
    @Override
    public void onChunkLoad() {
    }
    
    @Override
    public boolean isAtLocation(final int llllllllllllllIlIIIlllIIIllIlllI, final int llllllllllllllIlIIIlllIIIllIIlll) {
        return llllllllllllllIlIIIlllIIIllIlllI == this.xPosition && llllllllllllllIlIIIlllIIIllIIlll == this.zPosition;
    }
    
    @Override
    public IBlockState getBlockState(final BlockPos llllllllllllllIlIIIlllIIIlIlIlll) {
        return Blocks.AIR.getDefaultState();
    }
    
    @Override
    public void setLightFor(final EnumSkyBlock llllllllllllllIlIIIlllIIIlIIIIll, final BlockPos llllllllllllllIlIIIlllIIIlIIIIlI, final int llllllllllllllIlIIIlllIIIlIIIIIl) {
    }
    
    @Override
    public void getEntitiesWithinAABBForEntity(@Nullable final Entity llllllllllllllIlIIIlllIIIIIIlllI, final AxisAlignedBB llllllllllllllIlIIIlllIIIIIIllII, final List<Entity> llllllllllllllIlIIIlllIIIIIIlIlI, final Predicate<? super Entity> llllllllllllllIlIIIlllIIIIIIlIIl) {
    }
    
    @Override
    public boolean canSeeSky(final BlockPos llllllllllllllIlIIIlllIIIIlIlIIl) {
        return false;
    }
    
    @Nullable
    @Override
    public TileEntity getTileEntity(final BlockPos llllllllllllllIlIIIlllIIIIlIIllI, final EnumCreateEntityType llllllllllllllIlIIIlllIIIIlIIlIl) {
        return null;
    }
    
    @Override
    public void setChunkModified() {
    }
    
    @Override
    public void removeTileEntity(final BlockPos llllllllllllllIlIIIlllIIIIIlllII) {
    }
    
    @Override
    public int getBlockLightOpacity(final BlockPos llllllllllllllIlIIIlllIIIlIlIIlI) {
        return 255;
    }
    
    @Override
    public void addEntity(final Entity llllllllllllllIlIIIlllIIIIlllIlI) {
    }
    
    @Override
    public boolean getAreLevelsEmpty(final int llllllllllllllIlIIIllIllllllIlII, final int llllllllllllllIlIIIllIllllllIIlI) {
        return true;
    }
    
    @Override
    public int getLightFor(final EnumSkyBlock llllllllllllllIlIIIlllIIIlIIlIlI, final BlockPos llllllllllllllIlIIIlllIIIlIIlIII) {
        return llllllllllllllIlIIIlllIIIlIIlIlI.defaultLightValue;
    }
    
    @Override
    public void generateSkylightMap() {
    }
    
    @Override
    public int getHeightValue(final int llllllllllllllIlIIIlllIIIllIIIll, final int llllllllllllllIlIIIlllIIIllIIIlI) {
        return 0;
    }
    
    @Override
    public Random getRandomWithSeed(final long llllllllllllllIlIIIllIllllllllIl) {
        return new Random(this.getWorld().getSeed() + this.xPosition * this.xPosition * 4987142 + this.xPosition * 5947611 + this.zPosition * this.zPosition * 4392871L + this.zPosition * 389711 ^ llllllllllllllIlIIIllIllllllllIl);
    }
    
    @Override
    public <T extends Entity> void getEntitiesOfTypeWithinAAAB(final Class<? extends T> llllllllllllllIlIIIlllIIIIIIIlll, final AxisAlignedBB llllllllllllllIlIIIlllIIIIIIIllI, final List<T> llllllllllllllIlIIIlllIIIIIIIlIl, final Predicate<? super T> llllllllllllllIlIIIlllIIIIIIIlII) {
    }
    
    @Override
    public boolean needsSaving(final boolean llllllllllllllIlIIIlllIIIIIIIIlI) {
        return false;
    }
    
    @Override
    public void onChunkUnload() {
    }
    
    @Override
    public void removeEntity(final Entity llllllllllllllIlIIIlllIIIIllIlIl) {
    }
    
    public EmptyChunk(final World llllllllllllllIlIIIlllIIIllllIIl, final int llllllllllllllIlIIIlllIIIllllIII, final int llllllllllllllIlIIIlllIIIlllIlll) {
        super(llllllllllllllIlIIIlllIIIllllIIl, llllllllllllllIlIIIlllIIIllllIII, llllllllllllllIlIIIlllIIIlllIlll);
    }
    
    @Override
    public boolean isEmpty() {
        return true;
    }
    
    public void generateHeightMap() {
    }
    
    @Override
    public void addTileEntity(final TileEntity llllllllllllllIlIIIlllIIIIlIIIll) {
    }
    
    @Override
    public void addTileEntity(final BlockPos llllllllllllllIlIIIlllIIIIlIIIIl, final TileEntity llllllllllllllIlIIIlllIIIIlIIIII) {
    }
}
