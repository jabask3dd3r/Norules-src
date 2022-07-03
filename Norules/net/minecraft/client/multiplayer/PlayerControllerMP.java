package net.minecraft.client.multiplayer;

import net.minecraft.client.network.*;
import net.minecraft.client.*;
import io.netty.buffer.*;
import net.minecraft.network.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.client.audio.*;
import net.minecraft.block.*;
import net.minecraft.stats.*;
import net.minecraft.client.entity.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import me.nrules.event.events.*;
import net.minecraft.item.*;
import me.nrules.module.combat.*;
import me.nrules.*;
import net.minecraft.item.crafting.*;
import net.minecraft.network.play.client.*;

public class PlayerControllerMP
{
    private /* synthetic */ float curBlockDamageMP;
    private /* synthetic */ float stepSoundTickCounter;
    private /* synthetic */ BlockPos currentBlock;
    private final /* synthetic */ NetHandlerPlayClient connection;
    private /* synthetic */ GameType currentGameType;
    private /* synthetic */ int currentPlayerItem;
    private final /* synthetic */ Minecraft mc;
    private /* synthetic */ boolean isHittingBlock;
    private /* synthetic */ ItemStack currentItemHittingBlock;
    private /* synthetic */ int blockHitDelay;
    
    public void pickItem(final int lllIlllIlllIlIl) {
        this.connection.sendPacket(new CPacketCustomPayload("MC|PickItem", new PacketBuffer(Unpooled.buffer()).writeVarIntToBuffer(lllIlllIlllIlIl)));
    }
    
    public boolean isSpectatorMode() {
        return this.currentGameType == GameType.SPECTATOR;
    }
    
    public boolean getIsHittingBlock() {
        return this.isHittingBlock;
    }
    
    public boolean onPlayerDestroyBlock(final BlockPos llllIIIlIIlIllI) {
        if (this.currentGameType.isAdventure()) {
            if (this.currentGameType == GameType.SPECTATOR) {
                return false;
            }
            if (!this.mc.player.isAllowEdit()) {
                final ItemStack llllIIIlIIlllIl = this.mc.player.getHeldItemMainhand();
                if (llllIIIlIIlllIl.func_190926_b()) {
                    return false;
                }
                if (!llllIIIlIIlllIl.canDestroy(this.mc.world.getBlockState(llllIIIlIIlIllI).getBlock())) {
                    return false;
                }
            }
        }
        if (this.currentGameType.isCreative() && !this.mc.player.getHeldItemMainhand().func_190926_b() && this.mc.player.getHeldItemMainhand().getItem() instanceof ItemSword) {
            return false;
        }
        final World llllIIIlIIlllII = this.mc.world;
        final IBlockState llllIIIlIIllIll = llllIIIlIIlllII.getBlockState(llllIIIlIIlIllI);
        final Block llllIIIlIIllIlI = llllIIIlIIllIll.getBlock();
        if ((llllIIIlIIllIlI instanceof BlockCommandBlock || llllIIIlIIllIlI instanceof BlockStructure) && !this.mc.player.canUseCommandBlock()) {
            return false;
        }
        if (llllIIIlIIllIll.getMaterial() == Material.AIR) {
            return false;
        }
        llllIIIlIIlllII.playEvent(2001, llllIIIlIIlIllI, Block.getStateId(llllIIIlIIllIll));
        llllIIIlIIllIlI.onBlockHarvested(llllIIIlIIlllII, llllIIIlIIlIllI, llllIIIlIIllIll, this.mc.player);
        final boolean llllIIIlIIllIIl = llllIIIlIIlllII.setBlockState(llllIIIlIIlIllI, Blocks.AIR.getDefaultState(), 11);
        if (llllIIIlIIllIIl) {
            llllIIIlIIllIlI.onBlockDestroyedByPlayer(llllIIIlIIlllII, llllIIIlIIlIllI, llllIIIlIIllIll);
        }
        this.currentBlock = new BlockPos(this.currentBlock.getX(), -1, this.currentBlock.getZ());
        if (!this.currentGameType.isCreative()) {
            final ItemStack llllIIIlIIllIII = this.mc.player.getHeldItemMainhand();
            if (!llllIIIlIIllIII.func_190926_b()) {
                llllIIIlIIllIII.onBlockDestroyed(llllIIIlIIlllII, llllIIIlIIllIll, llllIIIlIIlIllI, this.mc.player);
                if (llllIIIlIIllIII.func_190926_b()) {
                    this.mc.player.setHeldItem(EnumHand.MAIN_HAND, ItemStack.field_190927_a);
                }
            }
        }
        return llllIIIlIIllIIl;
    }
    
    public static void clickBlockCreative(final Minecraft llllIIIllIIIlII, final PlayerControllerMP llllIIIlIllllll, final BlockPos llllIIIlIlllllI, final EnumFacing llllIIIllIIIIIl) {
        if (!llllIIIllIIIlII.world.extinguishFire(llllIIIllIIIlII.player, llllIIIlIlllllI, llllIIIllIIIIIl)) {
            llllIIIlIllllll.onPlayerDestroyBlock(llllIIIlIlllllI);
        }
    }
    
    public EnumActionResult processRightClick(final EntityPlayer llllIIIIIIllIlI, final World llllIIIIIIlIIIl, final EnumHand llllIIIIIIlIIII) {
        if (this.currentGameType == GameType.SPECTATOR) {
            return EnumActionResult.PASS;
        }
        this.syncCurrentPlayItem();
        this.connection.sendPacket(new CPacketPlayerTryUseItem(llllIIIIIIlIIII));
        final ItemStack llllIIIIIIlIlll = llllIIIIIIllIlI.getHeldItem(llllIIIIIIlIIII);
        if (llllIIIIIIllIlI.getCooldownTracker().hasCooldown(llllIIIIIIlIlll.getItem())) {
            return EnumActionResult.PASS;
        }
        final int llllIIIIIIlIllI = llllIIIIIIlIlll.func_190916_E();
        final ActionResult<ItemStack> llllIIIIIIlIlIl = llllIIIIIIlIlll.useItemRightClick(llllIIIIIIlIIIl, llllIIIIIIllIlI, llllIIIIIIlIIII);
        final ItemStack llllIIIIIIlIlII = llllIIIIIIlIlIl.getResult();
        if (llllIIIIIIlIlII != llllIIIIIIlIlll || llllIIIIIIlIlII.func_190916_E() != llllIIIIIIlIllI) {
            llllIIIIIIllIlI.setHeldItem(llllIIIIIIlIIII, llllIIIIIIlIlII);
        }
        return llllIIIIIIlIlIl.getType();
    }
    
    public void setPlayerCapabilities(final EntityPlayer llllIIIlIllIlll) {
        this.currentGameType.configurePlayerCapabilities(llllIIIlIllIlll.capabilities);
    }
    
    public void updateController() {
        this.syncCurrentPlayItem();
        if (this.connection.getNetworkManager().isChannelOpen()) {
            this.connection.getNetworkManager().processReceivedPackets();
        }
        else {
            this.connection.getNetworkManager().checkDisconnected();
        }
    }
    
    public void onStoppedUsingItem(final EntityPlayer lllIllllIIlIIll) {
        this.syncCurrentPlayItem();
        this.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.DOWN));
        lllIllllIIlIIll.stopActiveHand();
    }
    
    public boolean isRidingHorse() {
        return this.mc.player.isRiding() && this.mc.player.getRidingEntity() instanceof AbstractHorse;
    }
    
    public boolean shouldDrawHUD() {
        return this.currentGameType.isSurvivalOrAdventure();
    }
    
    public boolean onPlayerDamageBlock(final BlockPos llllIIIIlllIllI, final EnumFacing llllIIIIllIllll) {
        this.syncCurrentPlayItem();
        if (this.blockHitDelay > 0) {
            --this.blockHitDelay;
            return true;
        }
        if (this.currentGameType.isCreative() && this.mc.world.getWorldBorder().contains(llllIIIIlllIllI)) {
            this.blockHitDelay = 5;
            this.mc.func_193032_ao().func_193294_a(this.mc.world, llllIIIIlllIllI, this.mc.world.getBlockState(llllIIIIlllIllI), 1.0f);
            this.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, llllIIIIlllIllI, llllIIIIllIllll));
            clickBlockCreative(this.mc, this, llllIIIIlllIllI, llllIIIIllIllll);
            return true;
        }
        if (!this.isHittingPosition(llllIIIIlllIllI)) {
            return this.clickBlock(llllIIIIlllIllI, llllIIIIllIllll);
        }
        final IBlockState llllIIIIlllIlII = this.mc.world.getBlockState(llllIIIIlllIllI);
        final Block llllIIIIlllIIll = llllIIIIlllIlII.getBlock();
        if (llllIIIIlllIlII.getMaterial() == Material.AIR) {
            this.isHittingBlock = false;
            return false;
        }
        this.curBlockDamageMP += llllIIIIlllIlII.getPlayerRelativeBlockHardness(this.mc.player, this.mc.player.world, llllIIIIlllIllI);
        if (this.stepSoundTickCounter % 4.0f == 0.0f) {
            final SoundType llllIIIIlllIIlI = llllIIIIlllIIll.getSoundType();
            this.mc.getSoundHandler().playSound(new PositionedSoundRecord(llllIIIIlllIIlI.getHitSound(), SoundCategory.NEUTRAL, (llllIIIIlllIIlI.getVolume() + 1.0f) / 8.0f, llllIIIIlllIIlI.getPitch() * 0.5f, llllIIIIlllIllI));
        }
        ++this.stepSoundTickCounter;
        this.mc.func_193032_ao().func_193294_a(this.mc.world, llllIIIIlllIllI, llllIIIIlllIlII, MathHelper.clamp(this.curBlockDamageMP, 0.0f, 1.0f));
        if (this.curBlockDamageMP >= 1.0f) {
            this.isHittingBlock = false;
            this.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, llllIIIIlllIllI, llllIIIIllIllll));
            this.onPlayerDestroyBlock(llllIIIIlllIllI);
            this.curBlockDamageMP = 0.0f;
            this.stepSoundTickCounter = 0.0f;
            this.blockHitDelay = 5;
        }
        this.mc.world.sendBlockBreakProgress(this.mc.player.getEntityId(), this.currentBlock, (int)(this.curBlockDamageMP * 10.0f) - 1);
        return true;
    }
    
    public EntityPlayerSP func_192830_a(final World llllIIIIIIIIllI, final StatisticsManager llllIIIIIIIIIIl, final RecipeBook llllIIIIIIIIIII) {
        return new EntityPlayerSP(this.mc, llllIIIIIIIIllI, this.connection, llllIIIIIIIIIIl, llllIIIIIIIIIII);
    }
    
    public void sendEnchantPacket(final int lllIllllIlIllII, final int lllIllllIlIlIll) {
        this.connection.sendPacket(new CPacketEnchantItem(lllIllllIlIllII, lllIllllIlIlIll));
    }
    
    public boolean isNotCreative() {
        return !this.currentGameType.isCreative();
    }
    
    public float getBlockReachDistance() {
        return this.currentGameType.isCreative() ? 5.0f : 4.5f;
    }
    
    public EnumActionResult processRightClickBlock(final EntityPlayerSP llllIIIIIllIIIl, final WorldClient llllIIIIIllIIII, final BlockPos llllIIIIlIIIIIl, final EnumFacing llllIIIIlIIIIII, final Vec3d llllIIIIIlIllIl, final EnumHand llllIIIIIlllllI) {
        this.syncCurrentPlayItem();
        final ItemStack llllIIIIIllllIl = llllIIIIIllIIIl.getHeldItem(llllIIIIIlllllI);
        final float llllIIIIIllllII = (float)(llllIIIIIlIllIl.xCoord - llllIIIIlIIIIIl.getX());
        final float llllIIIIIlllIll = (float)(llllIIIIIlIllIl.yCoord - llllIIIIlIIIIIl.getY());
        final float llllIIIIIlllIlI = (float)(llllIIIIIlIllIl.zCoord - llllIIIIlIIIIIl.getZ());
        boolean llllIIIIIlllIIl = false;
        if (!this.mc.world.getWorldBorder().contains(llllIIIIlIIIIIl)) {
            return EnumActionResult.FAIL;
        }
        if (this.currentGameType != GameType.SPECTATOR) {
            final IBlockState llllIIIIIlllIII = llllIIIIIllIIII.getBlockState(llllIIIIlIIIIIl);
            if ((!llllIIIIIllIIIl.isSneaking() || (llllIIIIIllIIIl.getHeldItemMainhand().func_190926_b() && llllIIIIIllIIIl.getHeldItemOffhand().func_190926_b())) && llllIIIIIlllIII.getBlock().onBlockActivated(llllIIIIIllIIII, llllIIIIlIIIIIl, llllIIIIIlllIII, llllIIIIIllIIIl, llllIIIIIlllllI, llllIIIIlIIIIII, llllIIIIIllllII, llllIIIIIlllIll, llllIIIIIlllIlI)) {
                llllIIIIIlllIIl = true;
            }
            if (!llllIIIIIlllIIl && llllIIIIIllllIl.getItem() instanceof ItemBlock) {
                final ItemBlock llllIIIIIllIlll = (ItemBlock)llllIIIIIllllIl.getItem();
                if (!llllIIIIIllIlll.canPlaceBlockOnSide(llllIIIIIllIIII, llllIIIIlIIIIIl, llllIIIIlIIIIII, llllIIIIIllIIIl, llllIIIIIllllIl)) {
                    return EnumActionResult.FAIL;
                }
            }
        }
        this.connection.sendPacket(new CPacketPlayerTryUseItemOnBlock(llllIIIIlIIIIIl, llllIIIIlIIIIII, llllIIIIIlllllI, llllIIIIIllllII, llllIIIIIlllIll, llllIIIIIlllIlI));
        if (llllIIIIIlllIIl || this.currentGameType == GameType.SPECTATOR) {
            return EnumActionResult.SUCCESS;
        }
        if (llllIIIIIllllIl.func_190926_b()) {
            return EnumActionResult.PASS;
        }
        if (llllIIIIIllIIIl.getCooldownTracker().hasCooldown(llllIIIIIllllIl.getItem())) {
            return EnumActionResult.PASS;
        }
        if (llllIIIIIllllIl.getItem() instanceof ItemBlock && !llllIIIIIllIIIl.canUseCommandBlock()) {
            final Block llllIIIIIllIllI = ((ItemBlock)llllIIIIIllllIl.getItem()).getBlock();
            if (llllIIIIIllIllI instanceof BlockCommandBlock || llllIIIIIllIllI instanceof BlockStructure) {
                return EnumActionResult.FAIL;
            }
        }
        if (this.currentGameType.isCreative()) {
            final int llllIIIIIllIlIl = llllIIIIIllllIl.getMetadata();
            final int llllIIIIIllIlII = llllIIIIIllllIl.func_190916_E();
            final EnumActionResult llllIIIIIllIIll = llllIIIIIllllIl.onItemUse(llllIIIIIllIIIl, llllIIIIIllIIII, llllIIIIlIIIIIl, llllIIIIIlllllI, llllIIIIlIIIIII, llllIIIIIllllII, llllIIIIIlllIll, llllIIIIIlllIlI);
            llllIIIIIllllIl.setItemDamage(llllIIIIIllIlIl);
            llllIIIIIllllIl.func_190920_e(llllIIIIIllIlII);
            return llllIIIIIllIIll;
        }
        return llllIIIIIllllIl.onItemUse(llllIIIIIllIIIl, llllIIIIIllIIII, llllIIIIlIIIIIl, llllIIIIIlllllI, llllIIIIlIIIIII, llllIIIIIllllII, llllIIIIIlllIll, llllIIIIIlllIlI);
    }
    
    public ItemStack windowClick(final int lllIlllllIIllII, final int lllIlllllIIIIll, final int lllIlllllIIlIlI, final ClickType lllIlllllIIlIIl, final EntityPlayer lllIlllllIIlIII) {
        final short lllIlllllIIIlll = lllIlllllIIlIII.openContainer.getNextTransactionID(lllIlllllIIlIII.inventory);
        final ItemStack lllIlllllIIIllI = lllIlllllIIlIII.openContainer.slotClick(lllIlllllIIIIll, lllIlllllIIlIlI, lllIlllllIIlIIl, lllIlllllIIlIII);
        this.connection.sendPacket(new CPacketClickWindow(lllIlllllIIllII, lllIlllllIIIIll, lllIlllllIIlIlI, lllIlllllIIlIIl, lllIlllllIIIllI, lllIlllllIIIlll));
        return lllIlllllIIIllI;
    }
    
    public void flipPlayer(final EntityPlayer llllIIIlIlIlIll) {
        llllIIIlIlIlIll.rotationYaw = -180.0f;
    }
    
    public EnumActionResult interactWithEntity(final EntityPlayer lllIllllllIlllI, final Entity lllIllllllIlIIl, final EnumHand lllIllllllIllII) {
        this.syncCurrentPlayItem();
        this.connection.sendPacket(new CPacketUseEntity(lllIllllllIlIIl, lllIllllllIllII));
        return (this.currentGameType == GameType.SPECTATOR) ? EnumActionResult.PASS : lllIllllllIlllI.func_190775_a(lllIllllllIlIIl, lllIllllllIllII);
    }
    
    public void setGameType(final GameType llllIIIlIllIIII) {
        this.currentGameType = llllIIIlIllIIII;
        this.currentGameType.configurePlayerCapabilities(this.mc.player.capabilities);
    }
    
    public boolean clickBlock(final BlockPos llllIIIlIIIIlII, final EnumFacing llllIIIlIIIIIll) {
        if (this.currentGameType.isAdventure()) {
            if (this.currentGameType == GameType.SPECTATOR) {
                return false;
            }
            if (!this.mc.player.isAllowEdit()) {
                final ItemStack llllIIIlIIIlIII = this.mc.player.getHeldItemMainhand();
                if (llllIIIlIIIlIII.func_190926_b()) {
                    return false;
                }
                if (!llllIIIlIIIlIII.canDestroy(this.mc.world.getBlockState(llllIIIlIIIIlII).getBlock())) {
                    return false;
                }
            }
        }
        if (!this.mc.world.getWorldBorder().contains(llllIIIlIIIIlII)) {
            return false;
        }
        if (this.currentGameType.isCreative()) {
            this.mc.func_193032_ao().func_193294_a(this.mc.world, llllIIIlIIIIlII, this.mc.world.getBlockState(llllIIIlIIIIlII), 1.0f);
            this.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, llllIIIlIIIIlII, llllIIIlIIIIIll));
            clickBlockCreative(this.mc, this, llllIIIlIIIIlII, llllIIIlIIIIIll);
            this.blockHitDelay = 5;
        }
        else if (!this.isHittingBlock || !this.isHittingPosition(llllIIIlIIIIlII)) {
            if (this.isHittingBlock) {
                this.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, this.currentBlock, llllIIIlIIIIIll));
            }
            final IBlockState llllIIIlIIIIlll = this.mc.world.getBlockState(llllIIIlIIIIlII);
            this.mc.func_193032_ao().func_193294_a(this.mc.world, llllIIIlIIIIlII, llllIIIlIIIIlll, 0.0f);
            this.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, llllIIIlIIIIlII, llllIIIlIIIIIll));
            final boolean llllIIIlIIIIllI = llllIIIlIIIIlll.getMaterial() != Material.AIR;
            if (llllIIIlIIIIllI && this.curBlockDamageMP == 0.0f) {
                llllIIIlIIIIlll.getBlock().onBlockClicked(this.mc.world, llllIIIlIIIIlII, this.mc.player);
            }
            if (llllIIIlIIIIllI && llllIIIlIIIIlll.getPlayerRelativeBlockHardness(this.mc.player, this.mc.player.world, llllIIIlIIIIlII) >= 1.0f) {
                this.onPlayerDestroyBlock(llllIIIlIIIIlII);
            }
            else {
                this.isHittingBlock = true;
                this.currentBlock = llllIIIlIIIIlII;
                this.currentItemHittingBlock = this.mc.player.getHeldItemMainhand();
                this.curBlockDamageMP = 0.0f;
                this.stepSoundTickCounter = 0.0f;
                this.mc.world.sendBlockBreakProgress(this.mc.player.getEntityId(), this.currentBlock, (int)(this.curBlockDamageMP * 10.0f) - 1);
            }
        }
        return true;
    }
    
    public boolean gameIsSurvivalOrAdventure() {
        return this.currentGameType.isSurvivalOrAdventure();
    }
    
    public void sendPacketDropItem(final ItemStack lllIllllIIllIll) {
        if (this.currentGameType.isCreative() && !lllIllllIIllIll.func_190926_b()) {
            this.connection.sendPacket(new CPacketCreativeInventoryAction(-1, lllIllllIIllIll));
        }
    }
    
    private boolean isHittingPosition(final BlockPos llllIIIIlIlllII) {
        final ItemStack llllIIIIlIlllll = this.mc.player.getHeldItemMainhand();
        boolean llllIIIIlIllllI = this.currentItemHittingBlock.func_190926_b() && llllIIIIlIlllll.func_190926_b();
        if (!this.currentItemHittingBlock.func_190926_b() && !llllIIIIlIlllll.func_190926_b()) {
            llllIIIIlIllllI = (llllIIIIlIlllll.getItem() == this.currentItemHittingBlock.getItem() && ItemStack.areItemStackTagsEqual(llllIIIIlIlllll, this.currentItemHittingBlock) && (llllIIIIlIlllll.isItemStackDamageable() || llllIIIIlIlllll.getMetadata() == this.currentItemHittingBlock.getMetadata()));
        }
        return llllIIIIlIlllII.equals(this.currentBlock) && llllIIIIlIllllI;
    }
    
    public boolean isSpectator() {
        return this.currentGameType == GameType.SPECTATOR;
    }
    
    public boolean isInCreativeMode() {
        return this.currentGameType.isCreative();
    }
    
    public boolean extendedReach() {
        return this.currentGameType.isCreative();
    }
    
    public void sendSlotPacket(final ItemStack lllIllllIlIIIll, final int lllIllllIIlllll) {
        if (this.currentGameType.isCreative()) {
            this.connection.sendPacket(new CPacketCreativeInventoryAction(lllIllllIIlllll, lllIllllIlIIIll));
        }
    }
    
    public void resetBlockRemoving() {
        if (this.isHittingBlock) {
            this.mc.func_193032_ao().func_193294_a(this.mc.world, this.currentBlock, this.mc.world.getBlockState(this.currentBlock), -1.0f);
            this.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK, this.currentBlock, EnumFacing.DOWN));
            this.isHittingBlock = false;
            this.curBlockDamageMP = 0.0f;
            this.mc.world.sendBlockBreakProgress(this.mc.player.getEntityId(), this.currentBlock, -1);
            this.mc.player.resetCooldown();
        }
    }
    
    public PlayerControllerMP(final Minecraft llllIIIllIIlIlI, final NetHandlerPlayClient llllIIIllIIllII) {
        this.currentBlock = new BlockPos(-1, -1, -1);
        this.currentItemHittingBlock = ItemStack.field_190927_a;
        this.currentGameType = GameType.SURVIVAL;
        this.mc = llllIIIllIIlIlI;
        this.connection = llllIIIllIIllII;
    }
    
    public EnumActionResult interactWithEntity(final EntityPlayer lllIllllllIIIII, final Entity lllIlllllIllIIl, final RayTraceResult lllIlllllIllIII, final EnumHand lllIlllllIlIlll) {
        this.syncCurrentPlayItem();
        final Vec3d lllIlllllIlllII = new Vec3d(lllIlllllIllIII.hitVec.xCoord - lllIlllllIllIIl.posX, lllIlllllIllIII.hitVec.yCoord - lllIlllllIllIIl.posY, lllIlllllIllIII.hitVec.zCoord - lllIlllllIllIIl.posZ);
        this.connection.sendPacket(new CPacketUseEntity(lllIlllllIllIIl, lllIlllllIlIlll, lllIlllllIlllII));
        return (this.currentGameType == GameType.SPECTATOR) ? EnumActionResult.PASS : lllIlllllIllIIl.applyPlayerInteraction(lllIllllllIIIII, lllIlllllIlllII, lllIlllllIlIlll);
    }
    
    public void syncCurrentPlayItem() {
        final int llllIIIIlIlIllI = this.mc.player.inventory.currentItem;
        if (llllIIIIlIlIllI != this.currentPlayerItem) {
            this.currentPlayerItem = llllIIIIlIlIllI;
            this.connection.sendPacket(new CPacketHeldItemChange(this.currentPlayerItem));
        }
    }
    
    public void attackEntity(final EntityPlayer lllIllllllllIlI, final Entity lllIllllllllIIl) {
        final EventAttack lllIllllllllIII = new EventAttack(lllIllllllllIIl);
        lllIllllllllIII.call();
        if (this.mc.player.isHandActive() && this.mc.player.getHeldItemOffhand().getItem() instanceof ItemShield && Killaura.shieldblock.getValBoolean()) {
            this.mc.playerController.onStoppedUsingItem(this.mc.player);
        }
        this.syncCurrentPlayItem();
        this.connection.sendPacket(new CPacketUseEntity(lllIllllllllIIl));
        if (this.currentGameType != GameType.SPECTATOR) {
            lllIllllllllIlI.attackTargetEntityWithCurrentItem(lllIllllllllIIl);
            lllIllllllllIlI.resetCooldown();
        }
        if (!this.mc.player.isHandActive() && this.mc.player.getHeldItemOffhand().getItem() instanceof ItemShield && Main.settingsManager.getSettingByName(Main.moduleManager.getModule(Killaura.class), "ShieldBlock").getValBoolean()) {
            this.mc.gameSettings.keyBindUseItem.pressed = true;
        }
    }
    
    public void func_194338_a(final int lllIllllIlllIII, final IRecipe lllIllllIllIIlI, final boolean lllIllllIllIIIl, final EntityPlayer lllIllllIllIlIl) {
        this.connection.sendPacket(new CPacketPlaceRecipe(lllIllllIlllIII, lllIllllIllIIlI, lllIllllIllIIIl));
    }
    
    public GameType getCurrentGameType() {
        return this.currentGameType;
    }
}
