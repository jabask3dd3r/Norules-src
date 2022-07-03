package net.minecraft.world.gen.structure.template;

import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import javax.annotation.*;

public class BlockRotationProcessor implements ITemplateProcessor
{
    private final /* synthetic */ Random random;
    private final /* synthetic */ float chance;
    
    @Nullable
    @Override
    public Template.BlockInfo processBlock(final World lllllllllllllIIllIIllIlIIIIlIlll, final BlockPos lllllllllllllIIllIIllIlIIIIlIllI, final Template.BlockInfo lllllllllllllIIllIIllIlIIIIlIIll) {
        return (this.chance < 1.0f && this.random.nextFloat() > this.chance) ? null : lllllllllllllIIllIIllIlIIIIlIIll;
    }
    
    public BlockRotationProcessor(final BlockPos lllllllllllllIIllIIllIlIIIIlllll, final PlacementSettings lllllllllllllIIllIIllIlIIIIllllI) {
        this.chance = lllllllllllllIIllIIllIlIIIIllllI.getIntegrity();
        this.random = lllllllllllllIIllIIllIlIIIIllllI.getRandom(lllllllllllllIIllIIllIlIIIIlllll);
    }
}
