package net.minecraft.client.renderer.block.statemap;

import net.minecraft.block.state.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import java.util.*;
import net.minecraft.block.properties.*;

public class DefaultStateMapper extends StateMapperBase
{
    @Override
    protected ModelResourceLocation getModelResourceLocation(final IBlockState lllllllllllllIlIlIllllllllIllIll) {
        return new ModelResourceLocation(Block.REGISTRY.getNameForObject(lllllllllllllIlIlIllllllllIllIll.getBlock()), this.getPropertyString((Map<IProperty<?>, Comparable<?>>)lllllllllllllIlIlIllllllllIllIll.getProperties()));
    }
}
