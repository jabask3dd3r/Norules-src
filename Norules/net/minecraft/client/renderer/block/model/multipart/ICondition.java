package net.minecraft.client.renderer.block.model.multipart;

import com.google.common.base.*;
import net.minecraft.block.state.*;
import javax.annotation.*;

public interface ICondition
{
    Predicate<IBlockState> getPredicate(final BlockStateContainer p0);
}
