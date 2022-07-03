package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import javax.annotation.*;

public class BlockButtonWood extends BlockButton
{
    @Override
    protected void playReleaseSound(final World lllllllllllllllllIIIIIIIIllIllII, final BlockPos lllllllllllllllllIIIIIIIIllIlIll) {
        lllllllllllllllllIIIIIIIIllIllII.playSound(null, lllllllllllllllllIIIIIIIIllIlIll, SoundEvents.BLOCK_WOOD_BUTTON_CLICK_OFF, SoundCategory.BLOCKS, 0.3f, 0.5f);
    }
    
    protected BlockButtonWood() {
        super(true);
    }
    
    @Override
    protected void playClickSound(@Nullable final EntityPlayer lllllllllllllllllIIIIIIIIlllIlIl, final World lllllllllllllllllIIIIIIIIlllIIIl, final BlockPos lllllllllllllllllIIIIIIIIlllIIII) {
        lllllllllllllllllIIIIIIIIlllIIIl.playSound(lllllllllllllllllIIIIIIIIlllIlIl, lllllllllllllllllIIIIIIIIlllIIII, SoundEvents.BLOCK_WOOD_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.3f, 0.6f);
    }
}
