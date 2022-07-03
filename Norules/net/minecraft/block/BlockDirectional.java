package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;

public abstract class BlockDirectional extends Block
{
    static {
        FACING = PropertyDirection.create("facing");
    }
    
    protected BlockDirectional(final Material lllllllllllllIIlIIIllllIlIIIIIII) {
        super(lllllllllllllIIlIIIllllIlIIIIIII);
    }
}
