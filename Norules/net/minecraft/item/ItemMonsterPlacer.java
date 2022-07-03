package net.minecraft.item;

import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.*;
import net.minecraft.stats.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.server.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import net.minecraft.util.text.translation.*;

public class ItemMonsterPlacer extends Item
{
    public static void applyEntityIdToItemStack(final ItemStack lllllllllllllllllllIIIlIlllIlIIl, final ResourceLocation lllllllllllllllllllIIIlIlllIlIII) {
        final NBTTagCompound lllllllllllllllllllIIIlIlllIlIll = lllllllllllllllllllIIIlIlllIlIIl.hasTagCompound() ? lllllllllllllllllllIIIlIlllIlIIl.getTagCompound() : new NBTTagCompound();
        final NBTTagCompound lllllllllllllllllllIIIlIlllIlIlI = new NBTTagCompound();
        lllllllllllllllllllIIIlIlllIlIlI.setString("id", lllllllllllllllllllIIIlIlllIlIII.toString());
        lllllllllllllllllllIIIlIlllIlIll.setTag("EntityTag", lllllllllllllllllllIIIlIlllIlIlI);
        lllllllllllllllllllIIIlIlllIlIIl.setTagCompound(lllllllllllllllllllIIIlIlllIlIll);
    }
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer lllllllllllllllllllIIIllIllIlIlI, final World lllllllllllllllllllIIIllIllllIlI, final BlockPos lllllllllllllllllllIIIllIllllIIl, final EnumHand lllllllllllllllllllIIIllIllIIlll, final EnumFacing lllllllllllllllllllIIIllIlllIlll, final float lllllllllllllllllllIIIllIlllIllI, final float lllllllllllllllllllIIIllIlllIlIl, final float lllllllllllllllllllIIIllIlllIlII) {
        final ItemStack lllllllllllllllllllIIIllIlllIIll = lllllllllllllllllllIIIllIllIlIlI.getHeldItem(lllllllllllllllllllIIIllIllIIlll);
        if (lllllllllllllllllllIIIllIllllIlI.isRemote) {
            return EnumActionResult.SUCCESS;
        }
        if (!lllllllllllllllllllIIIllIllIlIlI.canPlayerEdit(lllllllllllllllllllIIIllIllllIIl.offset(lllllllllllllllllllIIIllIlllIlll), lllllllllllllllllllIIIllIlllIlll, lllllllllllllllllllIIIllIlllIIll)) {
            return EnumActionResult.FAIL;
        }
        final IBlockState lllllllllllllllllllIIIllIlllIIlI = lllllllllllllllllllIIIllIllllIlI.getBlockState(lllllllllllllllllllIIIllIllllIIl);
        final Block lllllllllllllllllllIIIllIlllIIIl = lllllllllllllllllllIIIllIlllIIlI.getBlock();
        if (lllllllllllllllllllIIIllIlllIIIl == Blocks.MOB_SPAWNER) {
            final TileEntity lllllllllllllllllllIIIllIlllIIII = lllllllllllllllllllIIIllIllllIlI.getTileEntity(lllllllllllllllllllIIIllIllllIIl);
            if (lllllllllllllllllllIIIllIlllIIII instanceof TileEntityMobSpawner) {
                final MobSpawnerBaseLogic lllllllllllllllllllIIIllIllIllll = ((TileEntityMobSpawner)lllllllllllllllllllIIIllIlllIIII).getSpawnerBaseLogic();
                lllllllllllllllllllIIIllIllIllll.func_190894_a(func_190908_h(lllllllllllllllllllIIIllIlllIIll));
                lllllllllllllllllllIIIllIlllIIII.markDirty();
                lllllllllllllllllllIIIllIllllIlI.notifyBlockUpdate(lllllllllllllllllllIIIllIllllIIl, lllllllllllllllllllIIIllIlllIIlI, lllllllllllllllllllIIIllIlllIIlI, 3);
                if (!lllllllllllllllllllIIIllIllIlIlI.capabilities.isCreativeMode) {
                    lllllllllllllllllllIIIllIlllIIll.func_190918_g(1);
                }
                return EnumActionResult.SUCCESS;
            }
        }
        final BlockPos lllllllllllllllllllIIIllIllIlllI = lllllllllllllllllllIIIllIllllIIl.offset(lllllllllllllllllllIIIllIlllIlll);
        final double lllllllllllllllllllIIIllIllIllIl = this.func_190909_a(lllllllllllllllllllIIIllIllllIlI, lllllllllllllllllllIIIllIllIlllI);
        final Entity lllllllllllllllllllIIIllIllIllII = spawnCreature(lllllllllllllllllllIIIllIllllIlI, func_190908_h(lllllllllllllllllllIIIllIlllIIll), lllllllllllllllllllIIIllIllIlllI.getX() + 0.5, lllllllllllllllllllIIIllIllIlllI.getY() + lllllllllllllllllllIIIllIllIllIl, lllllllllllllllllllIIIllIllIlllI.getZ() + 0.5);
        if (lllllllllllllllllllIIIllIllIllII != null) {
            if (lllllllllllllllllllIIIllIllIllII instanceof EntityLivingBase && lllllllllllllllllllIIIllIlllIIll.hasDisplayName()) {
                lllllllllllllllllllIIIllIllIllII.setCustomNameTag(lllllllllllllllllllIIIllIlllIIll.getDisplayName());
            }
            applyItemEntityDataToEntity(lllllllllllllllllllIIIllIllllIlI, lllllllllllllllllllIIIllIllIlIlI, lllllllllllllllllllIIIllIlllIIll, lllllllllllllllllllIIIllIllIllII);
            if (!lllllllllllllllllllIIIllIllIlIlI.capabilities.isCreativeMode) {
                lllllllllllllllllllIIIllIlllIIll.func_190918_g(1);
            }
        }
        return EnumActionResult.SUCCESS;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lllllllllllllllllllIIIllIIlIlIIl, final EntityPlayer lllllllllllllllllllIIIllIIlIIIII, final EnumHand lllllllllllllllllllIIIllIIIlllll) {
        final ItemStack lllllllllllllllllllIIIllIIlIIllI = lllllllllllllllllllIIIllIIlIIIII.getHeldItem(lllllllllllllllllllIIIllIIIlllll);
        if (lllllllllllllllllllIIIllIIlIlIIl.isRemote) {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, lllllllllllllllllllIIIllIIlIIllI);
        }
        final RayTraceResult lllllllllllllllllllIIIllIIlIIlIl = this.rayTrace(lllllllllllllllllllIIIllIIlIlIIl, lllllllllllllllllllIIIllIIlIIIII, true);
        if (lllllllllllllllllllIIIllIIlIIlIl == null || lllllllllllllllllllIIIllIIlIIlIl.typeOfHit != RayTraceResult.Type.BLOCK) {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, lllllllllllllllllllIIIllIIlIIllI);
        }
        final BlockPos lllllllllllllllllllIIIllIIlIIlII = lllllllllllllllllllIIIllIIlIIlIl.getBlockPos();
        if (!(lllllllllllllllllllIIIllIIlIlIIl.getBlockState(lllllllllllllllllllIIIllIIlIIlII).getBlock() instanceof BlockLiquid)) {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, lllllllllllllllllllIIIllIIlIIllI);
        }
        if (!lllllllllllllllllllIIIllIIlIlIIl.isBlockModifiable(lllllllllllllllllllIIIllIIlIIIII, lllllllllllllllllllIIIllIIlIIlII) || !lllllllllllllllllllIIIllIIlIIIII.canPlayerEdit(lllllllllllllllllllIIIllIIlIIlII, lllllllllllllllllllIIIllIIlIIlIl.sideHit, lllllllllllllllllllIIIllIIlIIllI)) {
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, lllllllllllllllllllIIIllIIlIIllI);
        }
        final Entity lllllllllllllllllllIIIllIIlIIIll = spawnCreature(lllllllllllllllllllIIIllIIlIlIIl, func_190908_h(lllllllllllllllllllIIIllIIlIIllI), lllllllllllllllllllIIIllIIlIIlII.getX() + 0.5, lllllllllllllllllllIIIllIIlIIlII.getY() + 0.5, lllllllllllllllllllIIIllIIlIIlII.getZ() + 0.5);
        if (lllllllllllllllllllIIIllIIlIIIll == null) {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, lllllllllllllllllllIIIllIIlIIllI);
        }
        if (lllllllllllllllllllIIIllIIlIIIll instanceof EntityLivingBase && lllllllllllllllllllIIIllIIlIIllI.hasDisplayName()) {
            lllllllllllllllllllIIIllIIlIIIll.setCustomNameTag(lllllllllllllllllllIIIllIIlIIllI.getDisplayName());
        }
        applyItemEntityDataToEntity(lllllllllllllllllllIIIllIIlIlIIl, lllllllllllllllllllIIIllIIlIIIII, lllllllllllllllllllIIIllIIlIIllI, lllllllllllllllllllIIIllIIlIIIll);
        if (!lllllllllllllllllllIIIllIIlIIIII.capabilities.isCreativeMode) {
            lllllllllllllllllllIIIllIIlIIllI.func_190918_g(1);
        }
        lllllllllllllllllllIIIllIIlIIIII.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllllllllIIIllIIlIIllI);
    }
    
    @Nullable
    public static Entity spawnCreature(final World lllllllllllllllllllIIIllIIIlIIlI, @Nullable final ResourceLocation lllllllllllllllllllIIIllIIIIlIIl, final double lllllllllllllllllllIIIllIIIIlIII, final double lllllllllllllllllllIIIllIIIIIlll, final double lllllllllllllllllllIIIllIIIIlllI) {
        if (lllllllllllllllllllIIIllIIIIlIIl != null && EntityList.ENTITY_EGGS.containsKey(lllllllllllllllllllIIIllIIIIlIIl)) {
            Entity lllllllllllllllllllIIIllIIIIllIl = null;
            for (int lllllllllllllllllllIIIllIIIIllII = 0; lllllllllllllllllllIIIllIIIIllII < 1; ++lllllllllllllllllllIIIllIIIIllII) {
                lllllllllllllllllllIIIllIIIIllIl = EntityList.createEntityByIDFromName(lllllllllllllllllllIIIllIIIIlIIl, lllllllllllllllllllIIIllIIIlIIlI);
                if (lllllllllllllllllllIIIllIIIIllIl instanceof EntityLiving) {
                    final EntityLiving lllllllllllllllllllIIIllIIIIlIll = (EntityLiving)lllllllllllllllllllIIIllIIIIllIl;
                    lllllllllllllllllllIIIllIIIIllIl.setLocationAndAngles(lllllllllllllllllllIIIllIIIIlIII, lllllllllllllllllllIIIllIIIIIlll, lllllllllllllllllllIIIllIIIIlllI, MathHelper.wrapDegrees(lllllllllllllllllllIIIllIIIlIIlI.rand.nextFloat() * 360.0f), 0.0f);
                    lllllllllllllllllllIIIllIIIIlIll.rotationYawHead = lllllllllllllllllllIIIllIIIIlIll.rotationYaw;
                    lllllllllllllllllllIIIllIIIIlIll.renderYawOffset = lllllllllllllllllllIIIllIIIIlIll.rotationYaw;
                    lllllllllllllllllllIIIllIIIIlIll.onInitialSpawn(lllllllllllllllllllIIIllIIIlIIlI.getDifficultyForLocation(new BlockPos(lllllllllllllllllllIIIllIIIIlIll)), null);
                    lllllllllllllllllllIIIllIIIlIIlI.spawnEntityInWorld(lllllllllllllllllllIIIllIIIIllIl);
                    lllllllllllllllllllIIIllIIIIlIll.playLivingSound();
                }
            }
            return lllllllllllllllllllIIIllIIIIllIl;
        }
        return null;
    }
    
    public static void applyItemEntityDataToEntity(final World lllllllllllllllllllIIIllIlIIIIlI, @Nullable final EntityPlayer lllllllllllllllllllIIIllIlIIIIIl, final ItemStack lllllllllllllllllllIIIllIlIIIIII, @Nullable final Entity lllllllllllllllllllIIIllIIllllll) {
        final MinecraftServer lllllllllllllllllllIIIllIIlllllI = lllllllllllllllllllIIIllIlIIIIlI.getMinecraftServer();
        if (lllllllllllllllllllIIIllIIlllllI != null && lllllllllllllllllllIIIllIIllllll != null) {
            final NBTTagCompound lllllllllllllllllllIIIllIIllllIl = lllllllllllllllllllIIIllIlIIIIII.getTagCompound();
            if (lllllllllllllllllllIIIllIIllllIl != null && lllllllllllllllllllIIIllIIllllIl.hasKey("EntityTag", 10)) {
                if (!lllllllllllllllllllIIIllIlIIIIlI.isRemote && lllllllllllllllllllIIIllIIllllll.ignoreItemEntityData() && (lllllllllllllllllllIIIllIlIIIIIl == null || !lllllllllllllllllllIIIllIIlllllI.getPlayerList().canSendCommands(lllllllllllllllllllIIIllIlIIIIIl.getGameProfile()))) {
                    return;
                }
                final NBTTagCompound lllllllllllllllllllIIIllIIllllII = lllllllllllllllllllIIIllIIllllll.writeToNBT(new NBTTagCompound());
                final UUID lllllllllllllllllllIIIllIIlllIll = lllllllllllllllllllIIIllIIllllll.getUniqueID();
                lllllllllllllllllllIIIllIIllllII.merge(lllllllllllllllllllIIIllIIllllIl.getCompoundTag("EntityTag"));
                lllllllllllllllllllIIIllIIllllll.setUniqueId(lllllllllllllllllllIIIllIIlllIll);
                lllllllllllllllllllIIIllIIllllll.readFromNBT(lllllllllllllllllllIIIllIIllllII);
            }
        }
    }
    
    protected double func_190909_a(final World lllllllllllllllllllIIIllIlIlIlll, final BlockPos lllllllllllllllllllIIIllIlIlIllI) {
        final AxisAlignedBB lllllllllllllllllllIIIllIlIlIlIl = new AxisAlignedBB(lllllllllllllllllllIIIllIlIlIllI).addCoord(0.0, -1.0, 0.0);
        final List<AxisAlignedBB> lllllllllllllllllllIIIllIlIlIlII = lllllllllllllllllllIIIllIlIlIlll.getCollisionBoxes(null, lllllllllllllllllllIIIllIlIlIlIl);
        if (lllllllllllllllllllIIIllIlIlIlII.isEmpty()) {
            return 0.0;
        }
        double lllllllllllllllllllIIIllIlIlIIll = lllllllllllllllllllIIIllIlIlIlIl.minY;
        for (final AxisAlignedBB lllllllllllllllllllIIIllIlIlIIlI : lllllllllllllllllllIIIllIlIlIlII) {
            lllllllllllllllllllIIIllIlIlIIll = Math.max(lllllllllllllllllllIIIllIlIlIIlI.maxY, lllllllllllllllllllIIIllIlIlIIll);
        }
        return lllllllllllllllllllIIIllIlIlIIll - lllllllllllllllllllIIIllIlIlIllI.getY();
    }
    
    @Nullable
    public static ResourceLocation func_190908_h(final ItemStack lllllllllllllllllllIIIlIllIllIll) {
        final NBTTagCompound lllllllllllllllllllIIIlIllIlllll = lllllllllllllllllllIIIlIllIllIll.getTagCompound();
        if (lllllllllllllllllllIIIlIllIlllll == null) {
            return null;
        }
        if (!lllllllllllllllllllIIIlIllIlllll.hasKey("EntityTag", 10)) {
            return null;
        }
        final NBTTagCompound lllllllllllllllllllIIIlIllIllllI = lllllllllllllllllllIIIlIllIlllll.getCompoundTag("EntityTag");
        if (!lllllllllllllllllllIIIlIllIllllI.hasKey("id", 8)) {
            return null;
        }
        final String lllllllllllllllllllIIIlIllIlllIl = lllllllllllllllllllIIIlIllIllllI.getString("id");
        final ResourceLocation lllllllllllllllllllIIIlIllIlllII = new ResourceLocation(lllllllllllllllllllIIIlIllIlllIl);
        if (!lllllllllllllllllllIIIlIllIlllIl.contains(":")) {
            lllllllllllllllllllIIIlIllIllllI.setString("id", lllllllllllllllllllIIIlIllIlllII.toString());
        }
        return lllllllllllllllllllIIIlIllIlllII;
    }
    
    public ItemMonsterPlacer() {
        this.setCreativeTab(CreativeTabs.MISC);
    }
    
    @Override
    public void getSubItems(final CreativeTabs lllllllllllllllllllIIIlIlllllIll, final NonNullList<ItemStack> lllllllllllllllllllIIIlIlllllIlI) {
        if (this.func_194125_a(lllllllllllllllllllIIIlIlllllIll)) {
            for (final EntityList.EntityEggInfo lllllllllllllllllllIIIlIlllllIIl : EntityList.ENTITY_EGGS.values()) {
                final ItemStack lllllllllllllllllllIIIlIlllllIII = new ItemStack(this, 1);
                applyEntityIdToItemStack(lllllllllllllllllllIIIlIlllllIII, lllllllllllllllllllIIIlIlllllIIl.spawnedID);
                lllllllllllllllllllIIIlIlllllIlI.add(lllllllllllllllllllIIIlIlllllIII);
            }
        }
    }
    
    @Override
    public String getItemStackDisplayName(final ItemStack lllllllllllllllllllIIIlllIIIlIll) {
        String lllllllllllllllllllIIIlllIIIlllI = String.valueOf(new StringBuilder().append(I18n.translateToLocal(String.valueOf(new StringBuilder(String.valueOf(this.getUnlocalizedName())).append(".name"))))).trim();
        final String lllllllllllllllllllIIIlllIIIllIl = EntityList.func_191302_a(func_190908_h(lllllllllllllllllllIIIlllIIIlIll));
        if (lllllllllllllllllllIIIlllIIIllIl != null) {
            lllllllllllllllllllIIIlllIIIlllI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllllllIIIlllIIIlllI)).append(" ").append(I18n.translateToLocal(String.valueOf(new StringBuilder("entity.").append(lllllllllllllllllllIIIlllIIIllIl).append(".name")))));
        }
        return lllllllllllllllllllIIIlllIIIlllI;
    }
}
