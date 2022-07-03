package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import javax.annotation.*;

public class BlockButtonStone extends BlockButton
{
    @Override
    protected void playReleaseSound(final World lllllllllllllIIIlIIllIlIIIllIIll, final BlockPos lllllllllllllIIIlIIllIlIIIllIIlI) {
        lllllllllllllIIIlIIllIlIIIllIIll.playSound(null, lllllllllllllIIIlIIllIlIIIllIIlI, SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF, SoundCategory.BLOCKS, 0.3f, 0.5f);
    }
    
    @Override
    protected void playClickSound(@Nullable final EntityPlayer lllllllllllllIIIlIIllIlIIIllllII, final World lllllllllllllIIIlIIllIlIIIlllIll, final BlockPos lllllllllllllIIIlIIllIlIIIllIlll) {
        lllllllllllllIIIlIIllIlIIIlllIll.playSound(lllllllllllllIIIlIIllIlIIIllllII, lllllllllllllIIIlIIllIlIIIllIlll, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.3f, 0.6f);
    }
    
    protected BlockButtonStone() {
        super(false);
    }
}
