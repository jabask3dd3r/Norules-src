package net.minecraft.item;

import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.inventory.*;
import com.google.common.collect.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.creativetab.*;

public class ItemSword extends Item
{
    private final /* synthetic */ ToolMaterial material;
    private final /* synthetic */ float attackDamage;
    
    @Override
    public boolean onBlockDestroyed(final ItemStack llllllllllllllIlIlIllllIlllIlIII, final World llllllllllllllIlIlIllllIlllIIlll, final IBlockState llllllllllllllIlIlIllllIlllIIllI, final BlockPos llllllllllllllIlIlIllllIlllIlIlI, final EntityLivingBase llllllllllllllIlIlIllllIlllIIlII) {
        if (llllllllllllllIlIlIllllIlllIIllI.getBlockHardness(llllllllllllllIlIlIllllIlllIIlll, llllllllllllllIlIlIllllIlllIlIlI) != 0.0) {
            llllllllllllllIlIlIllllIlllIlIII.damageItem(2, llllllllllllllIlIlIllllIlllIIlII);
        }
        return true;
    }
    
    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(final EntityEquipmentSlot llllllllllllllIlIlIllllIllIIlIII) {
        final Multimap<String, AttributeModifier> llllllllllllllIlIlIllllIllIIlIlI = super.getItemAttributeModifiers(llllllllllllllIlIlIllllIllIIlIII);
        if (llllllllllllllIlIlIllllIllIIlIII == EntityEquipmentSlot.MAINHAND) {
            llllllllllllllIlIlIllllIllIIlIlI.put((Object)SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), (Object)new AttributeModifier(ItemSword.ATTACK_DAMAGE_MODIFIER, "Weapon modifier", this.attackDamage, 0));
            llllllllllllllIlIlIllllIllIIlIlI.put((Object)SharedMonsterAttributes.ATTACK_SPEED.getAttributeUnlocalizedName(), (Object)new AttributeModifier(ItemSword.ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316, 0));
        }
        return llllllllllllllIlIlIllllIllIIlIlI;
    }
    
    @Override
    public float getStrVsBlock(final ItemStack llllllllllllllIlIlIlllllIIIIIIlI, final IBlockState llllllllllllllIlIlIllllIlllllllI) {
        final Block llllllllllllllIlIlIlllllIIIIIIII = llllllllllllllIlIlIllllIlllllllI.getBlock();
        if (llllllllllllllIlIlIlllllIIIIIIII == Blocks.WEB) {
            return 15.0f;
        }
        final Material llllllllllllllIlIlIllllIllllllll = llllllllllllllIlIlIllllIlllllllI.getMaterial();
        return (llllllllllllllIlIlIllllIllllllll != Material.PLANTS && llllllllllllllIlIlIllllIllllllll != Material.VINE && llllllllllllllIlIlIllllIllllllll != Material.CORAL && llllllllllllllIlIlIllllIllllllll != Material.LEAVES && llllllllllllllIlIlIllllIllllllll != Material.GOURD) ? 1.0f : 1.5f;
    }
    
    public ItemSword(final ToolMaterial llllllllllllllIlIlIlllllIIIIlIlI) {
        this.material = llllllllllllllIlIlIlllllIIIIlIlI;
        this.maxStackSize = 1;
        this.setMaxDamage(llllllllllllllIlIlIlllllIIIIlIlI.getMaxUses());
        this.setCreativeTab(CreativeTabs.COMBAT);
        this.attackDamage = 3.0f + llllllllllllllIlIlIlllllIIIIlIlI.getDamageVsEntity();
    }
    
    public float getDamageVsEntity() {
        return this.material.getDamageVsEntity();
    }
    
    @Override
    public boolean hitEntity(final ItemStack llllllllllllllIlIlIllllIllllIlIl, final EntityLivingBase llllllllllllllIlIlIllllIllllIlll, final EntityLivingBase llllllllllllllIlIlIllllIllllIllI) {
        llllllllllllllIlIlIllllIllllIlIl.damageItem(1, llllllllllllllIlIlIllllIllllIllI);
        return true;
    }
    
    @Override
    public int getItemEnchantability() {
        return this.material.getEnchantability();
    }
    
    @Override
    public boolean isFull3D() {
        return true;
    }
    
    @Override
    public boolean getIsRepairable(final ItemStack llllllllllllllIlIlIllllIllIlIIIl, final ItemStack llllllllllllllIlIlIllllIllIlIIll) {
        return this.material.getRepairItem() == llllllllllllllIlIlIllllIllIlIIll.getItem() || super.getIsRepairable(llllllllllllllIlIlIllllIllIlIIIl, llllllllllllllIlIlIllllIllIlIIll);
    }
    
    public String getToolMaterialName() {
        return this.material.toString();
    }
    
    @Override
    public boolean canHarvestBlock(final IBlockState llllllllllllllIlIlIllllIlllIIIII) {
        return llllllllllllllIlIlIllllIlllIIIII.getBlock() == Blocks.WEB;
    }
}
