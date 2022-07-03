package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import java.util.*;

public class BlockPressurePlate extends BlockBasePressurePlate
{
    private final /* synthetic */ Sensitivity sensitivity;
    public static final /* synthetic */ PropertyBool POWERED;
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPressurePlate.POWERED });
    }
    
    @Override
    protected int getRedstoneStrength(final IBlockState llllllllllllllIlIIllIlIlIllIllII) {
        return llllllllllllllIlIIllIlIlIllIllII.getValue((IProperty<Boolean>)BlockPressurePlate.POWERED) ? 15 : 0;
    }
    
    protected BlockPressurePlate(final Material llllllllllllllIlIIllIlIlIllllIlI, final Sensitivity llllllllllllllIlIIllIlIlIllllIII) {
        super(llllllllllllllIlIIllIlIlIllllIlI);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockPressurePlate.POWERED, false));
        this.sensitivity = llllllllllllllIlIIllIlIlIllllIII;
    }
    
    @Override
    protected void playClickOffSound(final World llllllllllllllIlIIllIlIlIIllllII, final BlockPos llllllllllllllIlIIllIlIlIIlllIll) {
        if (this.blockMaterial == Material.WOOD) {
            llllllllllllllIlIIllIlIlIIllllII.playSound(null, llllllllllllllIlIIllIlIlIIlllIll, SoundEvents.BLOCK_WOOD_PRESSPLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3f, 0.7f);
        }
        else {
            llllllllllllllIlIIllIlIlIIllllII.playSound(null, llllllllllllllIlIIllIlIlIIlllIll, SoundEvents.BLOCK_STONE_PRESSPLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3f, 0.5f);
        }
    }
    
    @Override
    protected void playClickOnSound(final World llllllllllllllIlIIllIlIlIlIIlllI, final BlockPos llllllllllllllIlIIllIlIlIlIlIIlI) {
        if (this.blockMaterial == Material.WOOD) {
            llllllllllllllIlIIllIlIlIlIIlllI.playSound(null, llllllllllllllIlIIllIlIlIlIlIIlI, SoundEvents.BLOCK_WOOD_PRESSPLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3f, 0.8f);
        }
        else {
            llllllllllllllIlIIllIlIlIlIIlllI.playSound(null, llllllllllllllIlIIllIlIlIlIlIIlI, SoundEvents.BLOCK_STONE_PRESSPLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3f, 0.6f);
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockPressurePlate$Sensitivity() {
        final int[] $switch_TABLE$net$minecraft$block$BlockPressurePlate$Sensitivity = BlockPressurePlate.$SWITCH_TABLE$net$minecraft$block$BlockPressurePlate$Sensitivity;
        if ($switch_TABLE$net$minecraft$block$BlockPressurePlate$Sensitivity != null) {
            return $switch_TABLE$net$minecraft$block$BlockPressurePlate$Sensitivity;
        }
        final Exception llllllllllllllIlIIllIlIIllllIlll = (Object)new int[Sensitivity.values().length];
        try {
            llllllllllllllIlIIllIlIIllllIlll[Sensitivity.EVERYTHING.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIlIIllIlIIllllIlll[Sensitivity.MOBS.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        return BlockPressurePlate.$SWITCH_TABLE$net$minecraft$block$BlockPressurePlate$Sensitivity = (int[])(Object)llllllllllllllIlIIllIlIIllllIlll;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIIllIlIIllllllII) {
        return ((boolean)llllllllllllllIlIIllIlIIllllllII.getValue((IProperty<Boolean>)BlockPressurePlate.POWERED)) ? 1 : 0;
    }
    
    @Override
    protected IBlockState setRedstoneStrength(final IBlockState llllllllllllllIlIIllIlIlIllIIlII, final int llllllllllllllIlIIllIlIlIllIIIll) {
        return llllllllllllllIlIIllIlIlIllIIlII.withProperty((IProperty<Comparable>)BlockPressurePlate.POWERED, llllllllllllllIlIIllIlIlIllIIIll > 0);
    }
    
    @Override
    protected int computeRedstoneStrength(final World llllllllllllllIlIIllIlIlIIIlIIlI, final BlockPos llllllllllllllIlIIllIlIlIIIlIIIl) {
        final AxisAlignedBB llllllllllllllIlIIllIlIlIIIlllII = BlockPressurePlate.PRESSURE_AABB.offset(llllllllllllllIlIIllIlIlIIIlIIIl);
        switch ($SWITCH_TABLE$net$minecraft$block$BlockPressurePlate$Sensitivity()[this.sensitivity.ordinal()]) {
            case 1: {
                final List<? extends Entity> llllllllllllllIlIIllIlIlIIIllIll = llllllllllllllIlIIllIlIlIIIlIIlI.getEntitiesWithinAABBExcludingEntity(null, llllllllllllllIlIIllIlIlIIIlllII);
                break;
            }
            case 2: {
                final List<? extends Entity> llllllllllllllIlIIllIlIlIIIllIIl = llllllllllllllIlIIllIlIlIIIlIIlI.getEntitiesWithinAABB((Class<? extends Entity>)EntityLivingBase.class, llllllllllllllIlIIllIlIlIIIlllII);
                break;
            }
            default: {
                return 0;
            }
        }
        final List<? extends Entity> llllllllllllllIlIIllIlIlIIIlIlll;
        if (!llllllllllllllIlIIllIlIlIIIlIlll.isEmpty()) {
            for (final Entity llllllllllllllIlIIllIlIlIIIlIlIl : llllllllllllllIlIIllIlIlIIIlIlll) {
                if (!llllllllllllllIlIIllIlIlIIIlIlIl.doesEntityNotTriggerPressurePlate()) {
                    return 15;
                }
            }
        }
        return 0;
    }
    
    static {
        POWERED = PropertyBool.create("powered");
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIIllIlIlIIIIIIlI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockPressurePlate.POWERED, llllllllllllllIlIIllIlIlIIIIIIlI == 1);
    }
    
    public enum Sensitivity
    {
        EVERYTHING("EVERYTHING", 0), 
        MOBS("MOBS", 1);
        
        private Sensitivity(final String lIllllIlIlllIll, final int lIllllIlIlllIlI) {
        }
    }
}
