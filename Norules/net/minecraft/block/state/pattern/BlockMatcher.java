package net.minecraft.block.state.pattern;

import com.google.common.base.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import javax.annotation.*;

public class BlockMatcher implements Predicate<IBlockState>
{
    private final /* synthetic */ Block block;
    
    private BlockMatcher(final Block llllllllllllllIlIlIIIIIIlllIllIl) {
        this.block = llllllllllllllIlIlIIIIIIlllIllIl;
    }
    
    public static BlockMatcher forBlock(final Block llllllllllllllIlIlIIIIIIlllIlIII) {
        return new BlockMatcher(llllllllllllllIlIlIIIIIIlllIlIII);
    }
    
    public boolean apply(@Nullable final IBlockState llllllllllllllIlIlIIIIIIlllIIlII) {
        return llllllllllllllIlIlIIIIIIlllIIlII != null && llllllllllllllIlIlIIIIIIlllIIlII.getBlock() == this.block;
    }
}
