package net.minecraft.block.state.pattern;

import com.google.common.base.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import javax.annotation.*;

public class BlockMaterialMatcher implements Predicate<IBlockState>
{
    private final /* synthetic */ Material material;
    
    private BlockMaterialMatcher(final Material lIllIllIllIlIll) {
        this.material = lIllIllIllIlIll;
    }
    
    public static BlockMaterialMatcher forMaterial(final Material lIllIllIllIIllI) {
        return new BlockMaterialMatcher(lIllIllIllIIllI);
    }
    
    public boolean apply(@Nullable final IBlockState lIllIllIllIIIII) {
        return lIllIllIllIIIII != null && lIllIllIllIIIII.getMaterial() == this.material;
    }
}
