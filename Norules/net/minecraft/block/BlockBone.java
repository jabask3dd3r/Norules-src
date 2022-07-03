package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlockBone extends BlockRotatedPillar
{
    public BlockBone() {
        super(Material.ROCK, MapColor.SAND);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setHardness(2.0f);
        this.setSoundType(SoundType.STONE);
    }
}
