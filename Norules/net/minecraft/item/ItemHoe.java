package net.minecraft.item;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.inventory.*;
import com.google.common.collect.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.*;
import net.minecraft.creativetab.*;

public class ItemHoe extends Item
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockDirt$DirtType;
    private final /* synthetic */ float speed;
    protected /* synthetic */ ToolMaterial theToolMaterial;
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer llllllllllllllIllIIllIllIlllllll, final World llllllllllllllIllIIllIllIllllllI, final BlockPos llllllllllllllIllIIllIllIlllllIl, final EnumHand llllllllllllllIllIIllIllIlllllII, final EnumFacing llllllllllllllIllIIllIllIllllIll, final float llllllllllllllIllIIllIlllIIIIllI, final float llllllllllllllIllIIllIlllIIIIlIl, final float llllllllllllllIllIIllIlllIIIIlII) {
        final ItemStack llllllllllllllIllIIllIlllIIIIIll = llllllllllllllIllIIllIllIlllllll.getHeldItem(llllllllllllllIllIIllIllIlllllII);
        if (!llllllllllllllIllIIllIllIlllllll.canPlayerEdit(llllllllllllllIllIIllIllIlllllIl.offset(llllllllllllllIllIIllIllIllllIll), llllllllllllllIllIIllIllIllllIll, llllllllllllllIllIIllIlllIIIIIll)) {
            return EnumActionResult.FAIL;
        }
        final IBlockState llllllllllllllIllIIllIlllIIIIIlI = llllllllllllllIllIIllIllIllllllI.getBlockState(llllllllllllllIllIIllIllIlllllIl);
        final Block llllllllllllllIllIIllIlllIIIIIIl = llllllllllllllIllIIllIlllIIIIIlI.getBlock();
        if (llllllllllllllIllIIllIllIllllIll != EnumFacing.DOWN && llllllllllllllIllIIllIllIllllllI.getBlockState(llllllllllllllIllIIllIllIlllllIl.up()).getMaterial() == Material.AIR) {
            if (llllllllllllllIllIIllIlllIIIIIIl == Blocks.GRASS || llllllllllllllIllIIllIlllIIIIIIl == Blocks.GRASS_PATH) {
                this.setBlock(llllllllllllllIllIIllIlllIIIIIll, llllllllllllllIllIIllIllIlllllll, llllllllllllllIllIIllIllIllllllI, llllllllllllllIllIIllIllIlllllIl, Blocks.FARMLAND.getDefaultState());
                return EnumActionResult.SUCCESS;
            }
            if (llllllllllllllIllIIllIlllIIIIIIl == Blocks.DIRT) {
                switch ($SWITCH_TABLE$net$minecraft$block$BlockDirt$DirtType()[llllllllllllllIllIIllIlllIIIIIlI.getValue(BlockDirt.VARIANT).ordinal()]) {
                    case 1: {
                        this.setBlock(llllllllllllllIllIIllIlllIIIIIll, llllllllllllllIllIIllIllIlllllll, llllllllllllllIllIIllIllIllllllI, llllllllllllllIllIIllIllIlllllIl, Blocks.FARMLAND.getDefaultState());
                        return EnumActionResult.SUCCESS;
                    }
                    case 2: {
                        this.setBlock(llllllllllllllIllIIllIlllIIIIIll, llllllllllllllIllIIllIllIlllllll, llllllllllllllIllIIllIllIllllllI, llllllllllllllIllIIllIllIlllllIl, Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
                        return EnumActionResult.SUCCESS;
                    }
                }
            }
        }
        return EnumActionResult.PASS;
    }
    
    @Override
    public boolean hitEntity(final ItemStack llllllllllllllIllIIllIllIlllIIIl, final EntityLivingBase llllllllllllllIllIIllIllIlllIIll, final EntityLivingBase llllllllllllllIllIIllIllIlllIIII) {
        llllllllllllllIllIIllIllIlllIIIl.damageItem(1, llllllllllllllIllIIllIllIlllIIII);
        return true;
    }
    
    protected void setBlock(final ItemStack llllllllllllllIllIIllIllIllIIlII, final EntityPlayer llllllllllllllIllIIllIllIllIIIll, final World llllllllllllllIllIIllIllIllIIlll, final BlockPos llllllllllllllIllIIllIllIllIIllI, final IBlockState llllllllllllllIllIIllIllIllIIIII) {
        llllllllllllllIllIIllIllIllIIlll.playSound(llllllllllllllIllIIllIllIllIIIll, llllllllllllllIllIIllIllIllIIllI, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0f, 1.0f);
        if (!llllllllllllllIllIIllIllIllIIlll.isRemote) {
            llllllllllllllIllIIllIllIllIIlll.setBlockState(llllllllllllllIllIIllIllIllIIllI, llllllllllllllIllIIllIllIllIIIII, 11);
            llllllllllllllIllIIllIllIllIIlII.damageItem(1, llllllllllllllIllIIllIllIllIIIll);
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockDirt$DirtType() {
        final int[] $switch_TABLE$net$minecraft$block$BlockDirt$DirtType = ItemHoe.$SWITCH_TABLE$net$minecraft$block$BlockDirt$DirtType;
        if ($switch_TABLE$net$minecraft$block$BlockDirt$DirtType != null) {
            return $switch_TABLE$net$minecraft$block$BlockDirt$DirtType;
        }
        final Exception llllllllllllllIllIIllIllIlIlIIIl = (Object)new int[BlockDirt.DirtType.values().length];
        try {
            llllllllllllllIllIIllIllIlIlIIIl[BlockDirt.DirtType.COARSE_DIRT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIllIIllIllIlIlIIIl[BlockDirt.DirtType.DIRT.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIllIIllIllIlIlIIIl[BlockDirt.DirtType.PODZOL.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return ItemHoe.$SWITCH_TABLE$net$minecraft$block$BlockDirt$DirtType = (int[])(Object)llllllllllllllIllIIllIllIlIlIIIl;
    }
    
    public String getMaterialName() {
        return this.theToolMaterial.toString();
    }
    
    @Override
    public boolean isFull3D() {
        return true;
    }
    
    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(final EntityEquipmentSlot llllllllllllllIllIIllIllIlIlIlII) {
        final Multimap<String, AttributeModifier> llllllllllllllIllIIllIllIlIlIllI = super.getItemAttributeModifiers(llllllllllllllIllIIllIllIlIlIlII);
        if (llllllllllllllIllIIllIllIlIlIlII == EntityEquipmentSlot.MAINHAND) {
            llllllllllllllIllIIllIllIlIlIllI.put((Object)SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), (Object)new AttributeModifier(ItemHoe.ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 0.0, 0));
            llllllllllllllIllIIllIllIlIlIllI.put((Object)SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), (Object)new AttributeModifier(ItemHoe.ATTACK_SPEED_MODIFIER, "Weapon modifier", this.speed - 4.0f, 0));
        }
        return llllllllllllllIllIIllIllIlIlIllI;
    }
    
    public ItemHoe(final ToolMaterial llllllllllllllIllIIllIlllIIllIII) {
        this.theToolMaterial = llllllllllllllIllIIllIlllIIllIII;
        this.maxStackSize = 1;
        this.setMaxDamage(llllllllllllllIllIIllIlllIIllIII.getMaxUses());
        this.setCreativeTab(CreativeTabs.TOOLS);
        this.speed = llllllllllllllIllIIllIlllIIllIII.getDamageVsEntity() + 1.0f;
    }
}
