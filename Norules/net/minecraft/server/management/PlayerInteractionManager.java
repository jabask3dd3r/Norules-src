package net.minecraft.server.management;

import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.inventory.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.network.play.server.*;

public class PlayerInteractionManager
{
    private /* synthetic */ int curblockDamage;
    public /* synthetic */ World theWorld;
    private /* synthetic */ int durabilityRemainingOnBlock;
    private /* synthetic */ BlockPos destroyPos;
    private /* synthetic */ int initialDamage;
    private /* synthetic */ boolean isDestroyingBlock;
    private /* synthetic */ GameType gameType;
    private /* synthetic */ int initialBlockDamage;
    public /* synthetic */ EntityPlayerMP thisPlayerMP;
    private /* synthetic */ boolean receivedFinishDiggingPacket;
    private /* synthetic */ BlockPos delayedDestroyPos;
    
    public void setWorld(final WorldServer lllllllllllllllIIlllIIlllllIlllI) {
        this.theWorld = lllllllllllllllIIlllIIlllllIlllI;
    }
    
    public void initializeGameType(final GameType lllllllllllllllIIlllIlIIlIlIIIII) {
        if (this.gameType == GameType.NOT_SET) {
            this.gameType = lllllllllllllllIIlllIlIIlIlIIIII;
        }
        this.setGameType(this.gameType);
    }
    
    public EnumActionResult processRightClickBlock(final EntityPlayer lllllllllllllllIIlllIIllllllllll, final World lllllllllllllllIIlllIlIIIIIlIIII, final ItemStack lllllllllllllllIIlllIlIIIIIIllll, final EnumHand lllllllllllllllIIlllIIllllllllII, final BlockPos lllllllllllllllIIlllIIlllllllIll, final EnumFacing lllllllllllllllIIlllIlIIIIIIllII, final float lllllllllllllllIIlllIlIIIIIIlIll, final float lllllllllllllllIIlllIIlllllllIII, final float lllllllllllllllIIlllIIllllllIlll) {
        if (this.gameType == GameType.SPECTATOR) {
            final TileEntity lllllllllllllllIIlllIlIIIIIIlIII = lllllllllllllllIIlllIlIIIIIlIIII.getTileEntity(lllllllllllllllIIlllIIlllllllIll);
            if (lllllllllllllllIIlllIlIIIIIIlIII instanceof ILockableContainer) {
                final Block lllllllllllllllIIlllIlIIIIIIIlll = lllllllllllllllIIlllIlIIIIIlIIII.getBlockState(lllllllllllllllIIlllIIlllllllIll).getBlock();
                ILockableContainer lllllllllllllllIIlllIlIIIIIIIllI = (ILockableContainer)lllllllllllllllIIlllIlIIIIIIlIII;
                if (lllllllllllllllIIlllIlIIIIIIIllI instanceof TileEntityChest && lllllllllllllllIIlllIlIIIIIIIlll instanceof BlockChest) {
                    lllllllllllllllIIlllIlIIIIIIIllI = ((BlockChest)lllllllllllllllIIlllIlIIIIIIIlll).getLockableContainer(lllllllllllllllIIlllIlIIIIIlIIII, lllllllllllllllIIlllIIlllllllIll);
                }
                if (lllllllllllllllIIlllIlIIIIIIIllI != null) {
                    lllllllllllllllIIlllIIllllllllll.displayGUIChest(lllllllllllllllIIlllIlIIIIIIIllI);
                    return EnumActionResult.SUCCESS;
                }
            }
            else if (lllllllllllllllIIlllIlIIIIIIlIII instanceof IInventory) {
                lllllllllllllllIIlllIIllllllllll.displayGUIChest((IInventory)lllllllllllllllIIlllIlIIIIIIlIII);
                return EnumActionResult.SUCCESS;
            }
            return EnumActionResult.PASS;
        }
        if (!lllllllllllllllIIlllIIllllllllll.isSneaking() || (lllllllllllllllIIlllIIllllllllll.getHeldItemMainhand().func_190926_b() && lllllllllllllllIIlllIIllllllllll.getHeldItemOffhand().func_190926_b())) {
            final IBlockState lllllllllllllllIIlllIlIIIIIIIlIl = lllllllllllllllIIlllIlIIIIIlIIII.getBlockState(lllllllllllllllIIlllIIlllllllIll);
            if (lllllllllllllllIIlllIlIIIIIIIlIl.getBlock().onBlockActivated(lllllllllllllllIIlllIlIIIIIlIIII, lllllllllllllllIIlllIIlllllllIll, lllllllllllllllIIlllIlIIIIIIIlIl, lllllllllllllllIIlllIIllllllllll, lllllllllllllllIIlllIIllllllllII, lllllllllllllllIIlllIlIIIIIIllII, lllllllllllllllIIlllIlIIIIIIlIll, lllllllllllllllIIlllIIlllllllIII, lllllllllllllllIIlllIIllllllIlll)) {
                return EnumActionResult.SUCCESS;
            }
        }
        if (lllllllllllllllIIlllIlIIIIIIllll.func_190926_b()) {
            return EnumActionResult.PASS;
        }
        if (lllllllllllllllIIlllIIllllllllll.getCooldownTracker().hasCooldown(lllllllllllllllIIlllIlIIIIIIllll.getItem())) {
            return EnumActionResult.PASS;
        }
        if (lllllllllllllllIIlllIlIIIIIIllll.getItem() instanceof ItemBlock && !lllllllllllllllIIlllIIllllllllll.canUseCommandBlock()) {
            final Block lllllllllllllllIIlllIlIIIIIIIlII = ((ItemBlock)lllllllllllllllIIlllIlIIIIIIllll.getItem()).getBlock();
            if (lllllllllllllllIIlllIlIIIIIIIlII instanceof BlockCommandBlock || lllllllllllllllIIlllIlIIIIIIIlII instanceof BlockStructure) {
                return EnumActionResult.FAIL;
            }
        }
        if (this.isCreative()) {
            final int lllllllllllllllIIlllIlIIIIIIIIll = lllllllllllllllIIlllIlIIIIIIllll.getMetadata();
            final int lllllllllllllllIIlllIlIIIIIIIIlI = lllllllllllllllIIlllIlIIIIIIllll.func_190916_E();
            final EnumActionResult lllllllllllllllIIlllIlIIIIIIIIIl = lllllllllllllllIIlllIlIIIIIIllll.onItemUse(lllllllllllllllIIlllIIllllllllll, lllllllllllllllIIlllIlIIIIIlIIII, lllllllllllllllIIlllIIlllllllIll, lllllllllllllllIIlllIIllllllllII, lllllllllllllllIIlllIlIIIIIIllII, lllllllllllllllIIlllIlIIIIIIlIll, lllllllllllllllIIlllIIlllllllIII, lllllllllllllllIIlllIIllllllIlll);
            lllllllllllllllIIlllIlIIIIIIllll.setItemDamage(lllllllllllllllIIlllIlIIIIIIIIll);
            lllllllllllllllIIlllIlIIIIIIllll.func_190920_e(lllllllllllllllIIlllIlIIIIIIIIlI);
            return lllllllllllllllIIlllIlIIIIIIIIIl;
        }
        return lllllllllllllllIIlllIlIIIIIIllll.onItemUse(lllllllllllllllIIlllIIllllllllll, lllllllllllllllIIlllIlIIIIIlIIII, lllllllllllllllIIlllIIlllllllIll, lllllllllllllllIIlllIIllllllllII, lllllllllllllllIIlllIlIIIIIIllII, lllllllllllllllIIlllIlIIIIIIlIll, lllllllllllllllIIlllIIlllllllIII, lllllllllllllllIIlllIIllllllIlll);
    }
    
    public void updateBlockRemoving() {
        ++this.curblockDamage;
        if (this.receivedFinishDiggingPacket) {
            final int lllllllllllllllIIlllIlIIlIIlIlll = this.curblockDamage - this.initialBlockDamage;
            final IBlockState lllllllllllllllIIlllIlIIlIIlIllI = this.theWorld.getBlockState(this.delayedDestroyPos);
            if (lllllllllllllllIIlllIlIIlIIlIllI.getMaterial() == Material.AIR) {
                this.receivedFinishDiggingPacket = false;
            }
            else {
                final float lllllllllllllllIIlllIlIIlIIlIlIl = lllllllllllllllIIlllIlIIlIIlIllI.getPlayerRelativeBlockHardness(this.thisPlayerMP, this.thisPlayerMP.world, this.delayedDestroyPos) * (lllllllllllllllIIlllIlIIlIIlIlll + 1);
                final int lllllllllllllllIIlllIlIIlIIlIlII = (int)(lllllllllllllllIIlllIlIIlIIlIlIl * 10.0f);
                if (lllllllllllllllIIlllIlIIlIIlIlII != this.durabilityRemainingOnBlock) {
                    this.theWorld.sendBlockBreakProgress(this.thisPlayerMP.getEntityId(), this.delayedDestroyPos, lllllllllllllllIIlllIlIIlIIlIlII);
                    this.durabilityRemainingOnBlock = lllllllllllllllIIlllIlIIlIIlIlII;
                }
                if (lllllllllllllllIIlllIlIIlIIlIlIl >= 1.0f) {
                    this.receivedFinishDiggingPacket = false;
                    this.tryHarvestBlock(this.delayedDestroyPos);
                }
            }
        }
        else if (this.isDestroyingBlock) {
            final IBlockState lllllllllllllllIIlllIlIIlIIlIIll = this.theWorld.getBlockState(this.destroyPos);
            if (lllllllllllllllIIlllIlIIlIIlIIll.getMaterial() == Material.AIR) {
                this.theWorld.sendBlockBreakProgress(this.thisPlayerMP.getEntityId(), this.destroyPos, -1);
                this.durabilityRemainingOnBlock = -1;
                this.isDestroyingBlock = false;
            }
            else {
                final int lllllllllllllllIIlllIlIIlIIlIIlI = this.curblockDamage - this.initialDamage;
                final float lllllllllllllllIIlllIlIIlIIlIIIl = lllllllllllllllIIlllIlIIlIIlIIll.getPlayerRelativeBlockHardness(this.thisPlayerMP, this.thisPlayerMP.world, this.delayedDestroyPos) * (lllllllllllllllIIlllIlIIlIIlIIlI + 1);
                final int lllllllllllllllIIlllIlIIlIIlIIII = (int)(lllllllllllllllIIlllIlIIlIIlIIIl * 10.0f);
                if (lllllllllllllllIIlllIlIIlIIlIIII != this.durabilityRemainingOnBlock) {
                    this.theWorld.sendBlockBreakProgress(this.thisPlayerMP.getEntityId(), this.destroyPos, lllllllllllllllIIlllIlIIlIIlIIII);
                    this.durabilityRemainingOnBlock = lllllllllllllllIIlllIlIIlIIlIIII;
                }
            }
        }
    }
    
    private boolean removeBlock(final BlockPos lllllllllllllllIIlllIlIIIlIllIIl) {
        final IBlockState lllllllllllllllIIlllIlIIIlIlllII = this.theWorld.getBlockState(lllllllllllllllIIlllIlIIIlIllIIl);
        lllllllllllllllIIlllIlIIIlIlllII.getBlock().onBlockHarvested(this.theWorld, lllllllllllllllIIlllIlIIIlIllIIl, lllllllllllllllIIlllIlIIIlIlllII, this.thisPlayerMP);
        final boolean lllllllllllllllIIlllIlIIIlIllIll = this.theWorld.setBlockToAir(lllllllllllllllIIlllIlIIIlIllIIl);
        if (lllllllllllllllIIlllIlIIIlIllIll) {
            lllllllllllllllIIlllIlIIIlIlllII.getBlock().onBlockDestroyedByPlayer(this.theWorld, lllllllllllllllIIlllIlIIIlIllIIl, lllllllllllllllIIlllIlIIIlIlllII);
        }
        return lllllllllllllllIIlllIlIIIlIllIll;
    }
    
    public void cancelDestroyingBlock() {
        this.isDestroyingBlock = false;
        this.theWorld.sendBlockBreakProgress(this.thisPlayerMP.getEntityId(), this.destroyPos, -1);
    }
    
    public void setGameType(final GameType lllllllllllllllIIlllIlIIlIlIllIl) {
        this.gameType = lllllllllllllllIIlllIlIIlIlIllIl;
        lllllllllllllllIIlllIlIIlIlIllIl.configurePlayerCapabilities(this.thisPlayerMP.capabilities);
        this.thisPlayerMP.sendPlayerAbilities();
        this.thisPlayerMP.mcServer.getPlayerList().sendPacketToAllPlayers(new SPacketPlayerListItem(SPacketPlayerListItem.Action.UPDATE_GAME_MODE, new EntityPlayerMP[] { this.thisPlayerMP }));
        this.theWorld.updateAllPlayersSleepingFlag();
    }
    
    public void onBlockClicked(final BlockPos lllllllllllllllIIlllIlIIlIIIIIlI, final EnumFacing lllllllllllllllIIlllIlIIIllllIIl) {
        if (this.isCreative()) {
            if (!this.theWorld.extinguishFire(null, lllllllllllllllIIlllIlIIlIIIIIlI, lllllllllllllllIIlllIlIIIllllIIl)) {
                this.tryHarvestBlock(lllllllllllllllIIlllIlIIlIIIIIlI);
            }
        }
        else {
            final IBlockState lllllllllllllllIIlllIlIIlIIIIIII = this.theWorld.getBlockState(lllllllllllllllIIlllIlIIlIIIIIlI);
            final Block lllllllllllllllIIlllIlIIIlllllll = lllllllllllllllIIlllIlIIlIIIIIII.getBlock();
            if (this.gameType.isAdventure()) {
                if (this.gameType == GameType.SPECTATOR) {
                    return;
                }
                if (!this.thisPlayerMP.isAllowEdit()) {
                    final ItemStack lllllllllllllllIIlllIlIIIllllllI = this.thisPlayerMP.getHeldItemMainhand();
                    if (lllllllllllllllIIlllIlIIIllllllI.func_190926_b()) {
                        return;
                    }
                    if (!lllllllllllllllIIlllIlIIIllllllI.canDestroy(lllllllllllllllIIlllIlIIIlllllll)) {
                        return;
                    }
                }
            }
            this.theWorld.extinguishFire(null, lllllllllllllllIIlllIlIIlIIIIIlI, lllllllllllllllIIlllIlIIIllllIIl);
            this.initialDamage = this.curblockDamage;
            float lllllllllllllllIIlllIlIIIlllllIl = 1.0f;
            if (lllllllllllllllIIlllIlIIlIIIIIII.getMaterial() != Material.AIR) {
                lllllllllllllllIIlllIlIIIlllllll.onBlockClicked(this.theWorld, lllllllllllllllIIlllIlIIlIIIIIlI, this.thisPlayerMP);
                lllllllllllllllIIlllIlIIIlllllIl = lllllllllllllllIIlllIlIIlIIIIIII.getPlayerRelativeBlockHardness(this.thisPlayerMP, this.thisPlayerMP.world, lllllllllllllllIIlllIlIIlIIIIIlI);
            }
            if (lllllllllllllllIIlllIlIIlIIIIIII.getMaterial() != Material.AIR && lllllllllllllllIIlllIlIIIlllllIl >= 1.0f) {
                this.tryHarvestBlock(lllllllllllllllIIlllIlIIlIIIIIlI);
            }
            else {
                this.isDestroyingBlock = true;
                this.destroyPos = lllllllllllllllIIlllIlIIlIIIIIlI;
                final int lllllllllllllllIIlllIlIIIlllllII = (int)(lllllllllllllllIIlllIlIIIlllllIl * 10.0f);
                this.theWorld.sendBlockBreakProgress(this.thisPlayerMP.getEntityId(), lllllllllllllllIIlllIlIIlIIIIIlI, lllllllllllllllIIlllIlIIIlllllII);
                this.durabilityRemainingOnBlock = lllllllllllllllIIlllIlIIIlllllII;
            }
        }
    }
    
    public boolean isCreative() {
        return this.gameType.isCreative();
    }
    
    public EnumActionResult processRightClick(final EntityPlayer lllllllllllllllIIlllIlIIIIllIIII, final World lllllllllllllllIIlllIlIIIIlIllll, final ItemStack lllllllllllllllIIlllIlIIIIlIIlIl, final EnumHand lllllllllllllllIIlllIlIIIIlIIlII) {
        if (this.gameType == GameType.SPECTATOR) {
            return EnumActionResult.PASS;
        }
        if (lllllllllllllllIIlllIlIIIIllIIII.getCooldownTracker().hasCooldown(lllllllllllllllIIlllIlIIIIlIIlIl.getItem())) {
            return EnumActionResult.PASS;
        }
        final int lllllllllllllllIIlllIlIIIIlIllII = lllllllllllllllIIlllIlIIIIlIIlIl.func_190916_E();
        final int lllllllllllllllIIlllIlIIIIlIlIll = lllllllllllllllIIlllIlIIIIlIIlIl.getMetadata();
        final ActionResult<ItemStack> lllllllllllllllIIlllIlIIIIlIlIlI = lllllllllllllllIIlllIlIIIIlIIlIl.useItemRightClick(lllllllllllllllIIlllIlIIIIlIllll, lllllllllllllllIIlllIlIIIIllIIII, lllllllllllllllIIlllIlIIIIlIIlII);
        final ItemStack lllllllllllllllIIlllIlIIIIlIlIIl = lllllllllllllllIIlllIlIIIIlIlIlI.getResult();
        if (lllllllllllllllIIlllIlIIIIlIlIIl == lllllllllllllllIIlllIlIIIIlIIlIl && lllllllllllllllIIlllIlIIIIlIlIIl.func_190916_E() == lllllllllllllllIIlllIlIIIIlIllII && lllllllllllllllIIlllIlIIIIlIlIIl.getMaxItemUseDuration() <= 0 && lllllllllllllllIIlllIlIIIIlIlIIl.getMetadata() == lllllllllllllllIIlllIlIIIIlIlIll) {
            return lllllllllllllllIIlllIlIIIIlIlIlI.getType();
        }
        if (lllllllllllllllIIlllIlIIIIlIlIlI.getType() == EnumActionResult.FAIL && lllllllllllllllIIlllIlIIIIlIlIIl.getMaxItemUseDuration() > 0 && !lllllllllllllllIIlllIlIIIIllIIII.isHandActive()) {
            return lllllllllllllllIIlllIlIIIIlIlIlI.getType();
        }
        lllllllllllllllIIlllIlIIIIllIIII.setHeldItem(lllllllllllllllIIlllIlIIIIlIIlII, lllllllllllllllIIlllIlIIIIlIlIIl);
        if (this.isCreative()) {
            lllllllllllllllIIlllIlIIIIlIlIIl.func_190920_e(lllllllllllllllIIlllIlIIIIlIllII);
            if (lllllllllllllllIIlllIlIIIIlIlIIl.isItemStackDamageable()) {
                lllllllllllllllIIlllIlIIIIlIlIIl.setItemDamage(lllllllllllllllIIlllIlIIIIlIlIll);
            }
        }
        if (lllllllllllllllIIlllIlIIIIlIlIIl.func_190926_b()) {
            lllllllllllllllIIlllIlIIIIllIIII.setHeldItem(lllllllllllllllIIlllIlIIIIlIIlII, ItemStack.field_190927_a);
        }
        if (!lllllllllllllllIIlllIlIIIIllIIII.isHandActive()) {
            ((EntityPlayerMP)lllllllllllllllIIlllIlIIIIllIIII).sendContainerToPlayer(lllllllllllllllIIlllIlIIIIllIIII.inventoryContainer);
        }
        return lllllllllllllllIIlllIlIIIIlIlIlI.getType();
    }
    
    public PlayerInteractionManager(final World lllllllllllllllIIlllIlIIlIllIIll) {
        this.gameType = GameType.NOT_SET;
        this.destroyPos = BlockPos.ORIGIN;
        this.delayedDestroyPos = BlockPos.ORIGIN;
        this.durabilityRemainingOnBlock = -1;
        this.theWorld = lllllllllllllllIIlllIlIIlIllIIll;
    }
    
    public boolean survivalOrAdventure() {
        return this.gameType.isSurvivalOrAdventure();
    }
    
    public void blockRemoving(final BlockPos lllllllllllllllIIlllIlIIIllIlllI) {
        if (lllllllllllllllIIlllIlIIIllIlllI.equals(this.destroyPos)) {
            final int lllllllllllllllIIlllIlIIIllIllIl = this.curblockDamage - this.initialDamage;
            final IBlockState lllllllllllllllIIlllIlIIIllIllII = this.theWorld.getBlockState(lllllllllllllllIIlllIlIIIllIlllI);
            if (lllllllllllllllIIlllIlIIIllIllII.getMaterial() != Material.AIR) {
                final float lllllllllllllllIIlllIlIIIllIlIll = lllllllllllllllIIlllIlIIIllIllII.getPlayerRelativeBlockHardness(this.thisPlayerMP, this.thisPlayerMP.world, lllllllllllllllIIlllIlIIIllIlllI) * (lllllllllllllllIIlllIlIIIllIllIl + 1);
                if (lllllllllllllllIIlllIlIIIllIlIll >= 0.7f) {
                    this.isDestroyingBlock = false;
                    this.theWorld.sendBlockBreakProgress(this.thisPlayerMP.getEntityId(), lllllllllllllllIIlllIlIIIllIlllI, -1);
                    this.tryHarvestBlock(lllllllllllllllIIlllIlIIIllIlllI);
                }
                else if (!this.receivedFinishDiggingPacket) {
                    this.isDestroyingBlock = false;
                    this.receivedFinishDiggingPacket = true;
                    this.delayedDestroyPos = lllllllllllllllIIlllIlIIIllIlllI;
                    this.initialBlockDamage = this.initialDamage;
                }
            }
        }
    }
    
    public GameType getGameType() {
        return this.gameType;
    }
    
    public boolean tryHarvestBlock(final BlockPos lllllllllllllllIIlllIlIIIlIIllII) {
        if (this.gameType.isCreative() && !this.thisPlayerMP.getHeldItemMainhand().func_190926_b() && this.thisPlayerMP.getHeldItemMainhand().getItem() instanceof ItemSword) {
            return false;
        }
        final IBlockState lllllllllllllllIIlllIlIIIlIIlIll = this.theWorld.getBlockState(lllllllllllllllIIlllIlIIIlIIllII);
        final TileEntity lllllllllllllllIIlllIlIIIlIIlIlI = this.theWorld.getTileEntity(lllllllllllllllIIlllIlIIIlIIllII);
        final Block lllllllllllllllIIlllIlIIIlIIlIIl = lllllllllllllllIIlllIlIIIlIIlIll.getBlock();
        if ((lllllllllllllllIIlllIlIIIlIIlIIl instanceof BlockCommandBlock || lllllllllllllllIIlllIlIIIlIIlIIl instanceof BlockStructure) && !this.thisPlayerMP.canUseCommandBlock()) {
            this.theWorld.notifyBlockUpdate(lllllllllllllllIIlllIlIIIlIIllII, lllllllllllllllIIlllIlIIIlIIlIll, lllllllllllllllIIlllIlIIIlIIlIll, 3);
            return false;
        }
        if (this.gameType.isAdventure()) {
            if (this.gameType == GameType.SPECTATOR) {
                return false;
            }
            if (!this.thisPlayerMP.isAllowEdit()) {
                final ItemStack lllllllllllllllIIlllIlIIIlIIlIII = this.thisPlayerMP.getHeldItemMainhand();
                if (lllllllllllllllIIlllIlIIIlIIlIII.func_190926_b()) {
                    return false;
                }
                if (!lllllllllllllllIIlllIlIIIlIIlIII.canDestroy(lllllllllllllllIIlllIlIIIlIIlIIl)) {
                    return false;
                }
            }
        }
        this.theWorld.playEvent(this.thisPlayerMP, 2001, lllllllllllllllIIlllIlIIIlIIllII, Block.getStateId(lllllllllllllllIIlllIlIIIlIIlIll));
        final boolean lllllllllllllllIIlllIlIIIlIIIlll = this.removeBlock(lllllllllllllllIIlllIlIIIlIIllII);
        if (this.isCreative()) {
            this.thisPlayerMP.connection.sendPacket(new SPacketBlockChange(this.theWorld, lllllllllllllllIIlllIlIIIlIIllII));
        }
        else {
            final ItemStack lllllllllllllllIIlllIlIIIlIIIllI = this.thisPlayerMP.getHeldItemMainhand();
            final ItemStack lllllllllllllllIIlllIlIIIlIIIlIl = lllllllllllllllIIlllIlIIIlIIIllI.func_190926_b() ? ItemStack.field_190927_a : lllllllllllllllIIlllIlIIIlIIIllI.copy();
            final boolean lllllllllllllllIIlllIlIIIlIIIlII = this.thisPlayerMP.canHarvestBlock(lllllllllllllllIIlllIlIIIlIIlIll);
            if (!lllllllllllllllIIlllIlIIIlIIIllI.func_190926_b()) {
                lllllllllllllllIIlllIlIIIlIIIllI.onBlockDestroyed(this.theWorld, lllllllllllllllIIlllIlIIIlIIlIll, lllllllllllllllIIlllIlIIIlIIllII, this.thisPlayerMP);
            }
            if (lllllllllllllllIIlllIlIIIlIIIlll && lllllllllllllllIIlllIlIIIlIIIlII) {
                lllllllllllllllIIlllIlIIIlIIlIll.getBlock().harvestBlock(this.theWorld, this.thisPlayerMP, lllllllllllllllIIlllIlIIIlIIllII, lllllllllllllllIIlllIlIIIlIIlIll, lllllllllllllllIIlllIlIIIlIIlIlI, lllllllllllllllIIlllIlIIIlIIIlIl);
            }
        }
        return lllllllllllllllIIlllIlIIIlIIIlll;
    }
}
