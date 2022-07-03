package net.minecraft.world.gen.structure.template;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import javax.annotation.*;

public interface ITemplateProcessor
{
    @Nullable
    Template.BlockInfo processBlock(final World p0, final BlockPos p1, final Template.BlockInfo p2);
}
