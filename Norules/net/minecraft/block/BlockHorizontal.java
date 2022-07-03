package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import com.google.common.base.*;

public abstract class BlockHorizontal extends Block
{
    protected BlockHorizontal(final Material llllllllllllllIIIlIlllIIlIlIIlII) {
        super(llllllllllllllIIIlIlllIIlIlIIlII);
    }
    
    protected BlockHorizontal(final Material llllllllllllllIIIlIlllIIlIIlllIl, final MapColor llllllllllllllIIIlIlllIIlIIlllII) {
        super(llllllllllllllIIIlIlllIIlIIlllIl, llllllllllllllIIIlIlllIIlIIlllII);
    }
    
    static {
        FACING = PropertyDirection.create("facing", (Predicate<EnumFacing>)EnumFacing.Plane.HORIZONTAL);
    }
}
