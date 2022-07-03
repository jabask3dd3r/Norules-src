package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;

public class WorldGenDoublePlant extends WorldGenerator
{
    private /* synthetic */ BlockDoublePlant.EnumPlantType plantType;
    
    @Override
    public boolean generate(final World llllllllllllllIIIIIlIlllIlIlIIIl, final Random llllllllllllllIIIIIlIlllIlIlIIII, final BlockPos llllllllllllllIIIIIlIlllIlIIlIII) {
        boolean llllllllllllllIIIIIlIlllIlIIlllI = false;
        for (int llllllllllllllIIIIIlIlllIlIIllIl = 0; llllllllllllllIIIIIlIlllIlIIllIl < 64; ++llllllllllllllIIIIIlIlllIlIIllIl) {
            final BlockPos llllllllllllllIIIIIlIlllIlIIllII = llllllllllllllIIIIIlIlllIlIIlIII.add(llllllllllllllIIIIIlIlllIlIlIIII.nextInt(8) - llllllllllllllIIIIIlIlllIlIlIIII.nextInt(8), llllllllllllllIIIIIlIlllIlIlIIII.nextInt(4) - llllllllllllllIIIIIlIlllIlIlIIII.nextInt(4), llllllllllllllIIIIIlIlllIlIlIIII.nextInt(8) - llllllllllllllIIIIIlIlllIlIlIIII.nextInt(8));
            if (llllllllllllllIIIIIlIlllIlIlIIIl.isAirBlock(llllllllllllllIIIIIlIlllIlIIllII) && (!llllllllllllllIIIIIlIlllIlIlIIIl.provider.getHasNoSky() || llllllllllllllIIIIIlIlllIlIIllII.getY() < 254) && Blocks.DOUBLE_PLANT.canPlaceBlockAt(llllllllllllllIIIIIlIlllIlIlIIIl, llllllllllllllIIIIIlIlllIlIIllII)) {
                Blocks.DOUBLE_PLANT.placeAt(llllllllllllllIIIIIlIlllIlIlIIIl, llllllllllllllIIIIIlIlllIlIIllII, this.plantType, 2);
                llllllllllllllIIIIIlIlllIlIIlllI = true;
            }
        }
        return llllllllllllllIIIIIlIlllIlIIlllI;
    }
    
    public void setPlantType(final BlockDoublePlant.EnumPlantType llllllllllllllIIIIIlIlllIlIllIlI) {
        this.plantType = llllllllllllllIIIIIlIlllIlIllIlI;
    }
}
