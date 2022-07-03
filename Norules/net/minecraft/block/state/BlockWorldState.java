package net.minecraft.block.state;

import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import com.google.common.base.*;

public class BlockWorldState
{
    private final /* synthetic */ boolean forceLoad;
    private final /* synthetic */ World world;
    private /* synthetic */ TileEntity tileEntity;
    private /* synthetic */ IBlockState state;
    private /* synthetic */ boolean tileEntityInitialized;
    private final /* synthetic */ BlockPos pos;
    
    public BlockWorldState(final World llllllllllllllIllIIllIIllIllllII, final BlockPos llllllllllllllIllIIllIIllIllIlll, final boolean llllllllllllllIllIIllIIllIllIllI) {
        this.world = llllllllllllllIllIIllIIllIllllII;
        this.pos = llllllllllllllIllIIllIIllIllIlll;
        this.forceLoad = llllllllllllllIllIIllIIllIllIllI;
    }
    
    @Nullable
    public TileEntity getTileEntity() {
        if (this.tileEntity == null && !this.tileEntityInitialized) {
            this.tileEntity = this.world.getTileEntity(this.pos);
            this.tileEntityInitialized = true;
        }
        return this.tileEntity;
    }
    
    public BlockPos getPos() {
        return this.pos;
    }
    
    public static Predicate<BlockWorldState> hasState(final Predicate<IBlockState> llllllllllllllIllIIllIIllIlIlIll) {
        return (Predicate<BlockWorldState>)new Predicate<BlockWorldState>() {
            public boolean apply(@Nullable final BlockWorldState llllllllllllllIlIIIllllIIIlllIll) {
                return llllllllllllllIlIIIllllIIIlllIll != null && llllllllllllllIllIIllIIllIlIlIll.apply((Object)llllllllllllllIlIIIllllIIIlllIll.getBlockState());
            }
        };
    }
    
    public IBlockState getBlockState() {
        if (this.state == null && (this.forceLoad || this.world.isBlockLoaded(this.pos))) {
            this.state = this.world.getBlockState(this.pos);
        }
        return this.state;
    }
}
