package net.minecraft.item;

import java.util.*;
import net.minecraft.block.*;
import net.minecraft.inventory.*;
import com.google.common.collect.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.creativetab.*;

public class ItemTool extends Item
{
    protected /* synthetic */ float efficiencyOnProperMaterial;
    protected /* synthetic */ ToolMaterial toolMaterial;
    protected /* synthetic */ float attackSpeed;
    private final /* synthetic */ Set<Block> effectiveBlocks;
    protected /* synthetic */ float damageVsEntity;
    
    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(final EntityEquipmentSlot llllllllllllllIlIlIllIIIIIlIIIII) {
        final Multimap<String, AttributeModifier> llllllllllllllIlIlIllIIIIIlIIIlI = super.getItemAttributeModifiers(llllllllllllllIlIlIllIIIIIlIIIII);
        if (llllllllllllllIlIlIllIIIIIlIIIII == EntityEquipmentSlot.MAINHAND) {
            llllllllllllllIlIlIllIIIIIlIIIlI.put((Object)SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), (Object)new AttributeModifier(ItemTool.ATTACK_DAMAGE_MODIFIER, "Tool modifier", this.damageVsEntity, 0));
            llllllllllllllIlIlIllIIIIIlIIIlI.put((Object)SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), (Object)new AttributeModifier(ItemTool.ATTACK_SPEED_MODIFIER, "Tool modifier", this.attackSpeed, 0));
        }
        return llllllllllllllIlIlIllIIIIIlIIIlI;
    }
    
    @Override
    public boolean getIsRepairable(final ItemStack llllllllllllllIlIlIllIIIIIlIlIIl, final ItemStack llllllllllllllIlIlIllIIIIIlIlIll) {
        return this.toolMaterial.getRepairItem() == llllllllllllllIlIlIllIIIIIlIlIll.getItem() || super.getIsRepairable(llllllllllllllIlIlIllIIIIIlIlIIl, llllllllllllllIlIlIllIIIIIlIlIll);
    }
    
    @Override
    public boolean isFull3D() {
        return true;
    }
    
    public String getToolMaterialName() {
        return this.toolMaterial.toString();
    }
    
    @Override
    public float getStrVsBlock(final ItemStack llllllllllllllIlIlIllIIIIlIlIIll, final IBlockState llllllllllllllIlIlIllIIIIlIlIIII) {
        return this.effectiveBlocks.contains(llllllllllllllIlIlIllIIIIlIlIIII.getBlock()) ? this.efficiencyOnProperMaterial : 1.0f;
    }
    
    @Override
    public int getItemEnchantability() {
        return this.toolMaterial.getEnchantability();
    }
    
    @Override
    public boolean onBlockDestroyed(final ItemStack llllllllllllllIlIlIllIIIIlIIIIIl, final World llllllllllllllIlIlIllIIIIlIIIIII, final IBlockState llllllllllllllIlIlIllIIIIIlllIlI, final BlockPos llllllllllllllIlIlIllIIIIIlllIIl, final EntityLivingBase llllllllllllllIlIlIllIIIIIlllIII) {
        if (!llllllllllllllIlIlIllIIIIlIIIIII.isRemote && llllllllllllllIlIlIllIIIIIlllIlI.getBlockHardness(llllllllllllllIlIlIllIIIIlIIIIII, llllllllllllllIlIlIllIIIIIlllIIl) != 0.0) {
            llllllllllllllIlIlIllIIIIlIIIIIl.damageItem(1, llllllllllllllIlIlIllIIIIIlllIII);
        }
        return true;
    }
    
    protected ItemTool(final float llllllllllllllIlIlIllIIIIllIIIll, final float llllllllllllllIlIlIllIIIIllIIlll, final ToolMaterial llllllllllllllIlIlIllIIIIllIIllI, final Set<Block> llllllllllllllIlIlIllIIIIllIIlIl) {
        this.efficiencyOnProperMaterial = 4.0f;
        this.toolMaterial = llllllllllllllIlIlIllIIIIllIIllI;
        this.effectiveBlocks = llllllllllllllIlIlIllIIIIllIIlIl;
        this.maxStackSize = 1;
        this.setMaxDamage(llllllllllllllIlIlIllIIIIllIIllI.getMaxUses());
        this.efficiencyOnProperMaterial = llllllllllllllIlIlIllIIIIllIIllI.getEfficiencyOnProperMaterial();
        this.damageVsEntity = llllllllllllllIlIlIllIIIIllIIIll + llllllllllllllIlIlIllIIIIllIIllI.getDamageVsEntity();
        this.attackSpeed = llllllllllllllIlIlIllIIIIllIIlll;
        this.setCreativeTab(CreativeTabs.TOOLS);
    }
    
    @Override
    public boolean hitEntity(final ItemStack llllllllllllllIlIlIllIIIIlIIllII, final EntityLivingBase llllllllllllllIlIlIllIIIIlIIlIll, final EntityLivingBase llllllllllllllIlIlIllIIIIlIIlIlI) {
        llllllllllllllIlIlIllIIIIlIIllII.damageItem(2, llllllllllllllIlIlIllIIIIlIIlIlI);
        return true;
    }
    
    protected ItemTool(final ToolMaterial llllllllllllllIlIlIllIIIIlIllIll, final Set<Block> llllllllllllllIlIlIllIIIIlIllIlI) {
        this(0.0f, 0.0f, llllllllllllllIlIlIllIIIIlIllIll, llllllllllllllIlIlIllIIIIlIllIlI);
    }
}
