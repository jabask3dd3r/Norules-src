package net.minecraft.network;

import net.minecraft.network.play.*;
import net.minecraft.server.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.advancements.*;
import java.io.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.inventory.*;
import net.minecraft.crash.*;
import net.minecraft.util.text.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import net.minecraft.command.*;
import io.netty.util.concurrent.*;
import com.google.common.util.concurrent.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import com.google.common.primitives.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.network.play.server.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.network.play.client.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.projectile.*;

public class NetHandlerPlayServer implements ITickable, INetHandlerPlayServer
{
    private /* synthetic */ int movePacketCounter;
    private /* synthetic */ ServerRecipeBookHelper field_194309_H;
    private /* synthetic */ double lowestRiddenY1;
    private /* synthetic */ double lowestRiddenX1;
    private /* synthetic */ int itemDropThreshold;
    private /* synthetic */ double lastGoodZ;
    private /* synthetic */ double lowestRiddenY;
    private /* synthetic */ double firstGoodY;
    private /* synthetic */ int teleportId;
    private /* synthetic */ double lastGoodX;
    private /* synthetic */ Entity lowestRiddenEnt;
    private /* synthetic */ double lowestRiddenZ1;
    private final /* synthetic */ MinecraftServer serverController;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$client$CPacketClientStatus$State;
    private /* synthetic */ int floatingTickCount;
    private /* synthetic */ boolean field_194403_g;
    private final /* synthetic */ IntHashMap<Short> pendingTransactions;
    private /* synthetic */ double firstGoodZ;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ int networkTickCount;
    private /* synthetic */ double lowestRiddenX;
    private /* synthetic */ double firstGoodX;
    public /* synthetic */ EntityPlayerMP playerEntity;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$client$CPacketPlayerDigging$Action;
    private /* synthetic */ double lastGoodY;
    private /* synthetic */ double lowestRiddenZ;
    private /* synthetic */ int vehicleFloatingTickCount;
    private /* synthetic */ int lastPositionUpdate;
    private /* synthetic */ int chatSpamThresholdCount;
    private /* synthetic */ int lastMovePacketCounter;
    private /* synthetic */ long field_194404_h;
    private /* synthetic */ long field_194402_f;
    private /* synthetic */ Vec3d targetPos;
    private /* synthetic */ boolean vehicleFloating;
    public final /* synthetic */ NetworkManager netManager;
    private /* synthetic */ boolean floating;
    
    @Override
    public void processPlayerDigging(final CPacketPlayerDigging llllllllllllllIIlIlIIIIlIlIlIlII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIlIlIlIlII, this, this.playerEntity.getServerWorld());
        final WorldServer llllllllllllllIIlIlIIIIlIlIlIIll = this.serverController.worldServerForDimension(this.playerEntity.dimension);
        final BlockPos llllllllllllllIIlIlIIIIlIlIlIIlI = llllllllllllllIIlIlIIIIlIlIlIlII.getPosition();
        this.playerEntity.markPlayerActive();
        switch ($SWITCH_TABLE$net$minecraft$network$play$client$CPacketPlayerDigging$Action()[llllllllllllllIIlIlIIIIlIlIlIlII.getAction().ordinal()]) {
            case 7: {
                if (!this.playerEntity.isSpectator()) {
                    final ItemStack llllllllllllllIIlIlIIIIlIlIlIIIl = this.playerEntity.getHeldItem(EnumHand.OFF_HAND);
                    this.playerEntity.setHeldItem(EnumHand.OFF_HAND, this.playerEntity.getHeldItem(EnumHand.MAIN_HAND));
                    this.playerEntity.setHeldItem(EnumHand.MAIN_HAND, llllllllllllllIIlIlIIIIlIlIlIIIl);
                }
            }
            case 5: {
                if (!this.playerEntity.isSpectator()) {
                    this.playerEntity.dropItem(false);
                }
            }
            case 4: {
                if (!this.playerEntity.isSpectator()) {
                    this.playerEntity.dropItem(true);
                }
            }
            case 6: {
                this.playerEntity.stopActiveHand();
            }
            case 1:
            case 2:
            case 3: {
                final double llllllllllllllIIlIlIIIIlIlIlIIII = this.playerEntity.posX - (llllllllllllllIIlIlIIIIlIlIlIIlI.getX() + 0.5);
                final double llllllllllllllIIlIlIIIIlIlIIllll = this.playerEntity.posY - (llllllllllllllIIlIlIIIIlIlIlIIlI.getY() + 0.5) + 1.5;
                final double llllllllllllllIIlIlIIIIlIlIIlllI = this.playerEntity.posZ - (llllllllllllllIIlIlIIIIlIlIlIIlI.getZ() + 0.5);
                final double llllllllllllllIIlIlIIIIlIlIIllIl = llllllllllllllIIlIlIIIIlIlIlIIII * llllllllllllllIIlIlIIIIlIlIlIIII + llllllllllllllIIlIlIIIIlIlIIllll * llllllllllllllIIlIlIIIIlIlIIllll + llllllllllllllIIlIlIIIIlIlIIlllI * llllllllllllllIIlIlIIIIlIlIIlllI;
                if (llllllllllllllIIlIlIIIIlIlIIllIl > 36.0) {
                    return;
                }
                if (llllllllllllllIIlIlIIIIlIlIlIIlI.getY() >= this.serverController.getBuildLimit()) {
                    return;
                }
                if (llllllllllllllIIlIlIIIIlIlIlIlII.getAction() == CPacketPlayerDigging.Action.START_DESTROY_BLOCK) {
                    if (!this.serverController.isBlockProtected(llllllllllllllIIlIlIIIIlIlIlIIll, llllllllllllllIIlIlIIIIlIlIlIIlI, this.playerEntity) && llllllllllllllIIlIlIIIIlIlIlIIll.getWorldBorder().contains(llllllllllllllIIlIlIIIIlIlIlIIlI)) {
                        this.playerEntity.interactionManager.onBlockClicked(llllllllllllllIIlIlIIIIlIlIlIIlI, llllllllllllllIIlIlIIIIlIlIlIlII.getFacing());
                    }
                    else {
                        this.playerEntity.connection.sendPacket(new SPacketBlockChange(llllllllllllllIIlIlIIIIlIlIlIIll, llllllllllllllIIlIlIIIIlIlIlIIlI));
                    }
                }
                else {
                    if (llllllllllllllIIlIlIIIIlIlIlIlII.getAction() == CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK) {
                        this.playerEntity.interactionManager.blockRemoving(llllllllllllllIIlIlIIIIlIlIlIIlI);
                    }
                    else if (llllllllllllllIIlIlIIIIlIlIlIlII.getAction() == CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK) {
                        this.playerEntity.interactionManager.cancelDestroyingBlock();
                    }
                    if (llllllllllllllIIlIlIIIIlIlIlIIll.getBlockState(llllllllllllllIIlIlIIIIlIlIlIIlI).getMaterial() != Material.AIR) {
                        this.playerEntity.connection.sendPacket(new SPacketBlockChange(llllllllllllllIIlIlIIIIlIlIlIIll, llllllllllllllIIlIlIIIIlIlIlIIlI));
                    }
                }
            }
            default: {
                throw new IllegalArgumentException("Invalid player action");
            }
        }
    }
    
    @Override
    public void handleSpectate(final CPacketSpectate llllllllllllllIIlIlIIIIlIIIlIlIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIlIIIlIlIl, this, this.playerEntity.getServerWorld());
        if (this.playerEntity.isSpectator()) {
            Entity llllllllllllllIIlIlIIIIlIIIlIlII = null;
            long llllllllllllllIIlIlIIIIlIIIIlIlI;
            for (String llllllllllllllIIlIlIIIIlIIIIlIll = (String)((WorldServer[])(Object)(llllllllllllllIIlIlIIIIlIIIIlIlI = (long)(Object)this.serverController.worldServers)).length, llllllllllllllIIlIlIIIIlIIIIllII = (String)0; llllllllllllllIIlIlIIIIlIIIIllII < llllllllllllllIIlIlIIIIlIIIIlIll; ++llllllllllllllIIlIlIIIIlIIIIllII) {
                final WorldServer llllllllllllllIIlIlIIIIlIIIlIIll = llllllllllllllIIlIlIIIIlIIIIlIlI[llllllllllllllIIlIlIIIIlIIIIllII];
                if (llllllllllllllIIlIlIIIIlIIIlIIll != null) {
                    llllllllllllllIIlIlIIIIlIIIlIlII = llllllllllllllIIlIlIIIIlIIIlIlIl.getEntity(llllllllllllllIIlIlIIIIlIIIlIIll);
                    if (llllllllllllllIIlIlIIIIlIIIlIlII != null) {
                        break;
                    }
                }
            }
            if (llllllllllllllIIlIlIIIIlIIIlIlII != null) {
                this.playerEntity.setSpectatingEntity(this.playerEntity);
                this.playerEntity.dismountRidingEntity();
                if (llllllllllllllIIlIlIIIIlIIIlIlII.world == this.playerEntity.world) {
                    this.playerEntity.setPositionAndUpdate(llllllllllllllIIlIlIIIIlIIIlIlII.posX, llllllllllllllIIlIlIIIIlIIIlIlII.posY, llllllllllllllIIlIlIIIIlIIIlIlII.posZ);
                }
                else {
                    final WorldServer llllllllllllllIIlIlIIIIlIIIlIIlI = this.playerEntity.getServerWorld();
                    final WorldServer llllllllllllllIIlIlIIIIlIIIlIIIl = (WorldServer)llllllllllllllIIlIlIIIIlIIIlIlII.world;
                    this.playerEntity.dimension = llllllllllllllIIlIlIIIIlIIIlIlII.dimension;
                    this.sendPacket(new SPacketRespawn(this.playerEntity.dimension, llllllllllllllIIlIlIIIIlIIIlIIlI.getDifficulty(), llllllllllllllIIlIlIIIIlIIIlIIlI.getWorldInfo().getTerrainType(), this.playerEntity.interactionManager.getGameType()));
                    this.serverController.getPlayerList().updatePermissionLevel(this.playerEntity);
                    llllllllllllllIIlIlIIIIlIIIlIIlI.removeEntityDangerously(this.playerEntity);
                    this.playerEntity.isDead = false;
                    this.playerEntity.setLocationAndAngles(llllllllllllllIIlIlIIIIlIIIlIlII.posX, llllllllllllllIIlIlIIIIlIIIlIlII.posY, llllllllllllllIIlIlIIIIlIIIlIlII.posZ, llllllllllllllIIlIlIIIIlIIIlIlII.rotationYaw, llllllllllllllIIlIlIIIIlIIIlIlII.rotationPitch);
                    if (this.playerEntity.isEntityAlive()) {
                        llllllllllllllIIlIlIIIIlIIIlIIlI.updateEntityWithOptionalForce(this.playerEntity, false);
                        llllllllllllllIIlIlIIIIlIIIlIIIl.spawnEntityInWorld(this.playerEntity);
                        llllllllllllllIIlIlIIIIlIIIlIIIl.updateEntityWithOptionalForce(this.playerEntity, false);
                    }
                    this.playerEntity.setWorld(llllllllllllllIIlIlIIIIlIIIlIIIl);
                    this.serverController.getPlayerList().preparePlayer(this.playerEntity, llllllllllllllIIlIlIIIIlIIIlIIlI);
                    this.playerEntity.setPositionAndUpdate(llllllllllllllIIlIlIIIIlIIIlIlII.posX, llllllllllllllIIlIlIIIIlIIIlIlII.posY, llllllllllllllIIlIlIIIIlIIIlIlII.posZ);
                    this.playerEntity.interactionManager.setWorld(llllllllllllllIIlIlIIIIlIIIlIIIl);
                    this.serverController.getPlayerList().updateTimeAndWeatherForPlayer(this.playerEntity, llllllllllllllIIlIlIIIIlIIIlIIIl);
                    this.serverController.getPlayerList().syncPlayerInventory(this.playerEntity);
                }
            }
        }
    }
    
    @Override
    public void processClientStatus(final CPacketClientStatus llllllllllllllIIlIlIIIIIIllIlIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIIIllIlIlI, this, this.playerEntity.getServerWorld());
        this.playerEntity.markPlayerActive();
        final CPacketClientStatus.State llllllllllllllIIlIlIIIIIIllIllII = llllllllllllllIIlIlIIIIIIllIlIlI.getStatus();
        switch ($SWITCH_TABLE$net$minecraft$network$play$client$CPacketClientStatus$State()[llllllllllllllIIlIlIIIIIIllIllII.ordinal()]) {
            case 1: {
                if (this.playerEntity.playerConqueredTheEnd) {
                    this.playerEntity.playerConqueredTheEnd = false;
                    this.playerEntity = this.serverController.getPlayerList().recreatePlayerEntity(this.playerEntity, 0, true);
                    CriteriaTriggers.field_193134_u.func_193143_a(this.playerEntity, DimensionType.THE_END, DimensionType.OVERWORLD);
                    break;
                }
                if (this.playerEntity.getHealth() > 0.0f) {
                    return;
                }
                this.playerEntity = this.serverController.getPlayerList().recreatePlayerEntity(this.playerEntity, 0, false);
                if (this.serverController.isHardcore()) {
                    this.playerEntity.setGameType(GameType.SPECTATOR);
                    this.playerEntity.getServerWorld().getGameRules().setOrCreateGameRule("spectatorsGenerateChunks", "false");
                    break;
                }
                break;
            }
            case 2: {
                this.playerEntity.getStatFile().sendStats(this.playerEntity);
                break;
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode() {
        final int[] $switch_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode = NetHandlerPlayServer.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode;
        if ($switch_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode != null) {
            return $switch_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode;
        }
        final float llllllllllllllIIlIIlllllIIllIIIl = (Object)new int[TileEntityCommandBlock.Mode.values().length];
        try {
            llllllllllllllIIlIIlllllIIllIIIl[TileEntityCommandBlock.Mode.AUTO.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIlIIlllllIIllIIIl[TileEntityCommandBlock.Mode.REDSTONE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIlIIlllllIIllIIIl[TileEntityCommandBlock.Mode.SEQUENCE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return NetHandlerPlayServer.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode = (int[])(Object)llllllllllllllIIlIIlllllIIllIIIl;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$client$CPacketPlayerDigging$Action() {
        final int[] $switch_TABLE$net$minecraft$network$play$client$CPacketPlayerDigging$Action = NetHandlerPlayServer.$SWITCH_TABLE$net$minecraft$network$play$client$CPacketPlayerDigging$Action;
        if ($switch_TABLE$net$minecraft$network$play$client$CPacketPlayerDigging$Action != null) {
            return $switch_TABLE$net$minecraft$network$play$client$CPacketPlayerDigging$Action;
        }
        final char llllllllllllllIIlIIlllllIIllIlll = (Object)new int[CPacketPlayerDigging.Action.values().length];
        try {
            llllllllllllllIIlIIlllllIIllIlll[CPacketPlayerDigging.Action.ABORT_DESTROY_BLOCK.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIlIIlllllIIllIlll[CPacketPlayerDigging.Action.DROP_ALL_ITEMS.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIlIIlllllIIllIlll[CPacketPlayerDigging.Action.DROP_ITEM.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIlIIlllllIIllIlll[CPacketPlayerDigging.Action.RELEASE_USE_ITEM.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIIlIIlllllIIllIlll[CPacketPlayerDigging.Action.START_DESTROY_BLOCK.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIIlIIlllllIIllIlll[CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllllIIlIIlllllIIllIlll[CPacketPlayerDigging.Action.SWAP_HELD_ITEMS.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        return NetHandlerPlayServer.$SWITCH_TABLE$net$minecraft$network$play$client$CPacketPlayerDigging$Action = (int[])(Object)llllllllllllllIIlIIlllllIIllIlll;
    }
    
    @Override
    public void processVehicleMove(final CPacketVehicleMove llllllllllllllIIlIlIIIlIIIIIIIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIlIIIIIIIIl, this, this.playerEntity.getServerWorld());
        if (isMoveVehiclePacketInvalid(llllllllllllllIIlIlIIIlIIIIIIIIl)) {
            this.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.invalid_vehicle_movement", new Object[0]));
        }
        else {
            final Entity llllllllllllllIIlIlIIIlIIIIlIllI = this.playerEntity.getLowestRidingEntity();
            if (llllllllllllllIIlIlIIIlIIIIlIllI != this.playerEntity && llllllllllllllIIlIlIIIlIIIIlIllI.getControllingPassenger() == this.playerEntity && llllllllllllllIIlIlIIIlIIIIlIllI == this.lowestRiddenEnt) {
                final WorldServer llllllllllllllIIlIlIIIlIIIIlIlIl = this.playerEntity.getServerWorld();
                final double llllllllllllllIIlIlIIIlIIIIlIlII = llllllllllllllIIlIlIIIlIIIIlIllI.posX;
                final double llllllllllllllIIlIlIIIlIIIIlIIll = llllllllllllllIIlIlIIIlIIIIlIllI.posY;
                final double llllllllllllllIIlIlIIIlIIIIlIIlI = llllllllllllllIIlIlIIIlIIIIlIllI.posZ;
                final double llllllllllllllIIlIlIIIlIIIIlIIIl = llllllllllllllIIlIlIIIlIIIIIIIIl.getX();
                final double llllllllllllllIIlIlIIIlIIIIlIIII = llllllllllllllIIlIlIIIlIIIIIIIIl.getY();
                final double llllllllllllllIIlIlIIIlIIIIIllll = llllllllllllllIIlIlIIIlIIIIIIIIl.getZ();
                final float llllllllllllllIIlIlIIIlIIIIIlllI = llllllllllllllIIlIlIIIlIIIIIIIIl.getYaw();
                final float llllllllllllllIIlIlIIIlIIIIIllIl = llllllllllllllIIlIlIIIlIIIIIIIIl.getPitch();
                double llllllllllllllIIlIlIIIlIIIIIllII = llllllllllllllIIlIlIIIlIIIIlIIIl - this.lowestRiddenX;
                double llllllllllllllIIlIlIIIlIIIIIlIll = llllllllllllllIIlIlIIIlIIIIlIIII - this.lowestRiddenY;
                double llllllllllllllIIlIlIIIlIIIIIlIlI = llllllllllllllIIlIlIIIlIIIIIllll - this.lowestRiddenZ;
                final double llllllllllllllIIlIlIIIlIIIIIlIIl = llllllllllllllIIlIlIIIlIIIIlIllI.motionX * llllllllllllllIIlIlIIIlIIIIlIllI.motionX + llllllllllllllIIlIlIIIlIIIIlIllI.motionY * llllllllllllllIIlIlIIIlIIIIlIllI.motionY + llllllllllllllIIlIlIIIlIIIIlIllI.motionZ * llllllllllllllIIlIlIIIlIIIIlIllI.motionZ;
                double llllllllllllllIIlIlIIIlIIIIIlIII = llllllllllllllIIlIlIIIlIIIIIllII * llllllllllllllIIlIlIIIlIIIIIllII + llllllllllllllIIlIlIIIlIIIIIlIll * llllllllllllllIIlIlIIIlIIIIIlIll + llllllllllllllIIlIlIIIlIIIIIlIlI * llllllllllllllIIlIlIIIlIIIIIlIlI;
                if (llllllllllllllIIlIlIIIlIIIIIlIII - llllllllllllllIIlIlIIIlIIIIIlIIl > 100.0 && (!this.serverController.isSinglePlayer() || !this.serverController.getServerOwner().equals(llllllllllllllIIlIlIIIlIIIIlIllI.getName()))) {
                    NetHandlerPlayServer.LOGGER.warn("{} (vehicle of {}) moved too quickly! {},{},{}", (Object)llllllllllllllIIlIlIIIlIIIIlIllI.getName(), (Object)this.playerEntity.getName(), (Object)llllllllllllllIIlIlIIIlIIIIIllII, (Object)llllllllllllllIIlIlIIIlIIIIIlIll, (Object)llllllllllllllIIlIlIIIlIIIIIlIlI);
                    this.netManager.sendPacket(new SPacketMoveVehicle(llllllllllllllIIlIlIIIlIIIIlIllI));
                    return;
                }
                final boolean llllllllllllllIIlIlIIIlIIIIIIlll = llllllllllllllIIlIlIIIlIIIIlIlIl.getCollisionBoxes(llllllllllllllIIlIlIIIlIIIIlIllI, llllllllllllllIIlIlIIIlIIIIlIllI.getEntityBoundingBox().contract(0.0625)).isEmpty();
                llllllllllllllIIlIlIIIlIIIIIllII = llllllllllllllIIlIlIIIlIIIIlIIIl - this.lowestRiddenX1;
                llllllllllllllIIlIlIIIlIIIIIlIll = llllllllllllllIIlIlIIIlIIIIlIIII - this.lowestRiddenY1 - 1.0E-6;
                llllllllllllllIIlIlIIIlIIIIIlIlI = llllllllllllllIIlIlIIIlIIIIIllll - this.lowestRiddenZ1;
                llllllllllllllIIlIlIIIlIIIIlIllI.moveEntity(MoverType.PLAYER, llllllllllllllIIlIlIIIlIIIIIllII, llllllllllllllIIlIlIIIlIIIIIlIll, llllllllllllllIIlIlIIIlIIIIIlIlI);
                final double llllllllllllllIIlIlIIIlIIIIIIllI = llllllllllllllIIlIlIIIlIIIIIlIll;
                llllllllllllllIIlIlIIIlIIIIIllII = llllllllllllllIIlIlIIIlIIIIlIIIl - llllllllllllllIIlIlIIIlIIIIlIllI.posX;
                llllllllllllllIIlIlIIIlIIIIIlIll = llllllllllllllIIlIlIIIlIIIIlIIII - llllllllllllllIIlIlIIIlIIIIlIllI.posY;
                if (llllllllllllllIIlIlIIIlIIIIIlIll > -0.5 || llllllllllllllIIlIlIIIlIIIIIlIll < 0.5) {
                    llllllllllllllIIlIlIIIlIIIIIlIll = 0.0;
                }
                llllllllllllllIIlIlIIIlIIIIIlIlI = llllllllllllllIIlIlIIIlIIIIIllll - llllllllllllllIIlIlIIIlIIIIlIllI.posZ;
                llllllllllllllIIlIlIIIlIIIIIlIII = llllllllllllllIIlIlIIIlIIIIIllII * llllllllllllllIIlIlIIIlIIIIIllII + llllllllllllllIIlIlIIIlIIIIIlIll * llllllllllllllIIlIlIIIlIIIIIlIll + llllllllllllllIIlIlIIIlIIIIIlIlI * llllllllllllllIIlIlIIIlIIIIIlIlI;
                boolean llllllllllllllIIlIlIIIlIIIIIIlIl = false;
                if (llllllllllllllIIlIlIIIlIIIIIlIII > 0.0625) {
                    llllllllllllllIIlIlIIIlIIIIIIlIl = true;
                    NetHandlerPlayServer.LOGGER.warn("{} moved wrongly!", (Object)llllllllllllllIIlIlIIIlIIIIlIllI.getName());
                }
                llllllllllllllIIlIlIIIlIIIIlIllI.setPositionAndRotation(llllllllllllllIIlIlIIIlIIIIlIIIl, llllllllllllllIIlIlIIIlIIIIlIIII, llllllllllllllIIlIlIIIlIIIIIllll, llllllllllllllIIlIlIIIlIIIIIlllI, llllllllllllllIIlIlIIIlIIIIIllIl);
                final boolean llllllllllllllIIlIlIIIlIIIIIIlII = llllllllllllllIIlIlIIIlIIIIlIlIl.getCollisionBoxes(llllllllllllllIIlIlIIIlIIIIlIllI, llllllllllllllIIlIlIIIlIIIIlIllI.getEntityBoundingBox().contract(0.0625)).isEmpty();
                if (llllllllllllllIIlIlIIIlIIIIIIlll && (llllllllllllllIIlIlIIIlIIIIIIlIl || !llllllllllllllIIlIlIIIlIIIIIIlII)) {
                    llllllllllllllIIlIlIIIlIIIIlIllI.setPositionAndRotation(llllllllllllllIIlIlIIIlIIIIlIlII, llllllllllllllIIlIlIIIlIIIIlIIll, llllllllllllllIIlIlIIIlIIIIlIIlI, llllllllllllllIIlIlIIIlIIIIIlllI, llllllllllllllIIlIlIIIlIIIIIllIl);
                    this.netManager.sendPacket(new SPacketMoveVehicle(llllllllllllllIIlIlIIIlIIIIlIllI));
                    return;
                }
                this.serverController.getPlayerList().serverUpdateMovingPlayer(this.playerEntity);
                this.playerEntity.addMovementStat(this.playerEntity.posX - llllllllllllllIIlIlIIIlIIIIlIlII, this.playerEntity.posY - llllllllllllllIIlIlIIIlIIIIlIIll, this.playerEntity.posZ - llllllllllllllIIlIlIIIlIIIIlIIlI);
                this.vehicleFloating = (llllllllllllllIIlIlIIIlIIIIIIllI >= -0.03125 && !this.serverController.isFlightAllowed() && !llllllllllllllIIlIlIIIlIIIIlIlIl.checkBlockCollision(llllllllllllllIIlIlIIIlIIIIlIllI.getEntityBoundingBox().expandXyz(0.0625).addCoord(0.0, -0.55, 0.0)));
                this.lowestRiddenX1 = llllllllllllllIIlIlIIIlIIIIlIllI.posX;
                this.lowestRiddenY1 = llllllllllllllIIlIlIIIlIIIIlIllI.posY;
                this.lowestRiddenZ1 = llllllllllllllIIlIlIIIlIIIIlIllI.posZ;
            }
        }
    }
    
    @Override
    public void update() {
        this.captureCurrentPosition();
        this.playerEntity.onUpdateEntity();
        this.playerEntity.setPositionAndRotation(this.firstGoodX, this.firstGoodY, this.firstGoodZ, this.playerEntity.rotationYaw, this.playerEntity.rotationPitch);
        ++this.networkTickCount;
        this.lastMovePacketCounter = this.movePacketCounter;
        if (this.floating) {
            if (++this.floatingTickCount > 80) {
                NetHandlerPlayServer.LOGGER.warn("{} was kicked for floating too long!", (Object)this.playerEntity.getName());
                this.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.flying", new Object[0]));
                return;
            }
        }
        else {
            this.floating = false;
            this.floatingTickCount = 0;
        }
        this.lowestRiddenEnt = this.playerEntity.getLowestRidingEntity();
        if (this.lowestRiddenEnt != this.playerEntity && this.lowestRiddenEnt.getControllingPassenger() == this.playerEntity) {
            this.lowestRiddenX = this.lowestRiddenEnt.posX;
            this.lowestRiddenY = this.lowestRiddenEnt.posY;
            this.lowestRiddenZ = this.lowestRiddenEnt.posZ;
            this.lowestRiddenX1 = this.lowestRiddenEnt.posX;
            this.lowestRiddenY1 = this.lowestRiddenEnt.posY;
            this.lowestRiddenZ1 = this.lowestRiddenEnt.posZ;
            if (this.vehicleFloating && this.playerEntity.getLowestRidingEntity().getControllingPassenger() == this.playerEntity) {
                if (++this.vehicleFloatingTickCount > 80) {
                    NetHandlerPlayServer.LOGGER.warn("{} was kicked for floating a vehicle too long!", (Object)this.playerEntity.getName());
                    this.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.flying", new Object[0]));
                    return;
                }
            }
            else {
                this.vehicleFloating = false;
                this.vehicleFloatingTickCount = 0;
            }
        }
        else {
            this.lowestRiddenEnt = null;
            this.vehicleFloating = false;
            this.vehicleFloatingTickCount = 0;
        }
        this.serverController.theProfiler.startSection("keepAlive");
        final long llllllllllllllIIlIlIIIlIIlIIlIII = this.currentTimeMillis();
        if (llllllllllllllIIlIlIIIlIIlIIlIII - this.field_194402_f >= 15000L) {
            if (this.field_194403_g) {
                this.func_194028_b(new TextComponentTranslation("disconnect.timeout", new Object[0]));
            }
            else {
                this.field_194403_g = true;
                this.field_194402_f = llllllllllllllIIlIlIIIlIIlIIlIII;
                this.field_194404_h = llllllllllllllIIlIlIIIlIIlIIlIII;
                this.sendPacket(new SPacketKeepAlive(this.field_194404_h));
            }
        }
        this.serverController.theProfiler.endSection();
        if (this.chatSpamThresholdCount > 0) {
            --this.chatSpamThresholdCount;
        }
        if (this.itemDropThreshold > 0) {
            --this.itemDropThreshold;
        }
        if (this.playerEntity.getLastActiveTime() > 0L && this.serverController.getMaxPlayerIdleMinutes() > 0 && MinecraftServer.getCurrentTimeMillis() - this.playerEntity.getLastActiveTime() > this.serverController.getMaxPlayerIdleMinutes() * 1000 * 60) {
            this.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.idling", new Object[0]));
        }
    }
    
    @Override
    public void processKeepAlive(final CPacketKeepAlive llllllllllllllIIlIIlllllllllllII) {
        if (this.field_194403_g && llllllllllllllIIlIIlllllllllllII.getKey() == this.field_194404_h) {
            final int llllllllllllllIIlIIllllllllllIll = (int)(this.currentTimeMillis() - this.field_194402_f);
            this.playerEntity.ping = (this.playerEntity.ping * 3 + llllllllllllllIIlIIllllllllllIll) / 4;
            this.field_194403_g = false;
        }
        else if (!this.playerEntity.getName().equals(this.serverController.getServerOwner())) {
            this.func_194028_b(new TextComponentTranslation("disconnect.timeout", new Object[0]));
        }
    }
    
    public NetHandlerPlayServer(final MinecraftServer llllllllllllllIIlIlIIIlIIlIlIIlI, final NetworkManager llllllllllllllIIlIlIIIlIIlIlIIIl, final EntityPlayerMP llllllllllllllIIlIlIIIlIIlIIllII) {
        this.pendingTransactions = new IntHashMap<Short>();
        this.field_194309_H = new ServerRecipeBookHelper();
        this.serverController = llllllllllllllIIlIlIIIlIIlIlIIlI;
        this.netManager = llllllllllllllIIlIlIIIlIIlIlIIIl;
        llllllllllllllIIlIlIIIlIIlIlIIIl.setNetHandler(this);
        this.playerEntity = llllllllllllllIIlIlIIIlIIlIIllII;
        llllllllllllllIIlIlIIIlIIlIIllII.connection = this;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$client$CPacketEntityAction$Action() {
        final int[] $switch_TABLE$net$minecraft$network$play$client$CPacketEntityAction$Action = NetHandlerPlayServer.$SWITCH_TABLE$net$minecraft$network$play$client$CPacketEntityAction$Action;
        if ($switch_TABLE$net$minecraft$network$play$client$CPacketEntityAction$Action != null) {
            return $switch_TABLE$net$minecraft$network$play$client$CPacketEntityAction$Action;
        }
        final String llllllllllllllIIlIIlllllIIllIlIl = (Object)new int[CPacketEntityAction.Action.values().length];
        try {
            llllllllllllllIIlIIlllllIIllIlIl[CPacketEntityAction.Action.OPEN_INVENTORY.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIlIIlllllIIllIlIl[CPacketEntityAction.Action.START_FALL_FLYING.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIlIIlllllIIllIlIl[CPacketEntityAction.Action.START_RIDING_JUMP.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIlIIlllllIIllIlIl[CPacketEntityAction.Action.START_SNEAKING.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIIlIIlllllIIllIlIl[CPacketEntityAction.Action.START_SPRINTING.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIIlIIlllllIIllIlIl[CPacketEntityAction.Action.STOP_RIDING_JUMP.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllllIIlIIlllllIIllIlIl[CPacketEntityAction.Action.STOP_SLEEPING.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            llllllllllllllIIlIIlllllIIllIlIl[CPacketEntityAction.Action.STOP_SNEAKING.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            llllllllllllllIIlIIlllllIIllIlIl[CPacketEntityAction.Action.STOP_SPRINTING.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        return NetHandlerPlayServer.$SWITCH_TABLE$net$minecraft$network$play$client$CPacketEntityAction$Action = (int[])(Object)llllllllllllllIIlIIlllllIIllIlIl;
    }
    
    @Override
    public void processConfirmTransaction(final CPacketConfirmTransaction llllllllllllllIIlIlIIIIIIIIlllIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIIIIIlllIl, this, this.playerEntity.getServerWorld());
        final Short llllllllllllllIIlIlIIIIIIIIlllll = this.pendingTransactions.lookup(this.playerEntity.openContainer.windowId);
        if (llllllllllllllIIlIlIIIIIIIIlllll != null && llllllllllllllIIlIlIIIIIIIIlllIl.getUid() == llllllllllllllIIlIlIIIIIIIIlllll && this.playerEntity.openContainer.windowId == llllllllllllllIIlIlIIIIIIIIlllIl.getWindowId() && !this.playerEntity.openContainer.getCanCraft(this.playerEntity) && !this.playerEntity.isSpectator()) {
            this.playerEntity.openContainer.setCanCraft(this.playerEntity, true);
        }
    }
    
    @Override
    public void handleAnimation(final CPacketAnimation llllllllllllllIIlIlIIIIIlIIlIllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIIlIIlIllI, this, this.playerEntity.getServerWorld());
        this.playerEntity.markPlayerActive();
        this.playerEntity.swingArm(llllllllllllllIIlIlIIIIIlIIlIllI.getHand());
    }
    
    @Override
    public void func_194027_a(final CPacketSeenAdvancements llllllllllllllIIlIlIIIIlllIlllIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIlllIlllIl, this, this.playerEntity.getServerWorld());
        if (llllllllllllllIIlIlIIIIlllIlllIl.func_194162_b() == CPacketSeenAdvancements.Action.OPENED_TAB) {
            final ResourceLocation llllllllllllllIIlIlIIIIlllIlllII = llllllllllllllIIlIlIIIIlllIlllIl.func_194165_c();
            final Advancement llllllllllllllIIlIlIIIIlllIllIll = this.serverController.func_191949_aK().func_192778_a(llllllllllllllIIlIlIIIIlllIlllII);
            if (llllllllllllllIIlIlIIIIlllIllIll != null) {
                this.playerEntity.func_192039_O().func_194220_a(llllllllllllllIIlIlIIIIlllIllIll);
            }
        }
    }
    
    @Override
    public void processCustomPayload(final CPacketCustomPayload llllllllllllllIIlIIlllllIlIIlIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIIlllllIlIIlIlI, this, this.playerEntity.getServerWorld());
        final String llllllllllllllIIlIIllllllIIlIIII = llllllllllllllIIlIIlllllIlIIlIlI.getChannelName();
        if ("MC|BEdit".equals(llllllllllllllIIlIIllllllIIlIIII)) {
            final PacketBuffer llllllllllllllIIlIIllllllIIIllll = llllllllllllllIIlIIlllllIlIIlIlI.getBufferData();
            try {
                final ItemStack llllllllllllllIIlIIllllllIIIlllI = llllllllllllllIIlIIllllllIIIllll.readItemStackFromBuffer();
                if (llllllllllllllIIlIIllllllIIIlllI.func_190926_b()) {
                    return;
                }
                if (!ItemWritableBook.isNBTValid(llllllllllllllIIlIIllllllIIIlllI.getTagCompound())) {
                    throw new IOException("Invalid book tag!");
                }
                final ItemStack llllllllllllllIIlIIllllllIIIllIl = this.playerEntity.getHeldItemMainhand();
                if (llllllllllllllIIlIIllllllIIIllIl.func_190926_b()) {
                    return;
                }
                if (llllllllllllllIIlIIllllllIIIlllI.getItem() == Items.WRITABLE_BOOK && llllllllllllllIIlIIllllllIIIlllI.getItem() == llllllllllllllIIlIIllllllIIIllIl.getItem()) {
                    llllllllllllllIIlIIllllllIIIllIl.setTagInfo("pages", llllllllllllllIIlIIllllllIIIlllI.getTagCompound().getTagList("pages", 8));
                }
            }
            catch (Exception llllllllllllllIIlIIllllllIIIllII) {
                NetHandlerPlayServer.LOGGER.error("Couldn't handle book info", (Throwable)llllllllllllllIIlIIllllllIIIllII);
            }
        }
        else if ("MC|BSign".equals(llllllllllllllIIlIIllllllIIlIIII)) {
            final PacketBuffer llllllllllllllIIlIIllllllIIIlIll = llllllllllllllIIlIIlllllIlIIlIlI.getBufferData();
            try {
                final ItemStack llllllllllllllIIlIIllllllIIIlIlI = llllllllllllllIIlIIllllllIIIlIll.readItemStackFromBuffer();
                if (llllllllllllllIIlIIllllllIIIlIlI.func_190926_b()) {
                    return;
                }
                if (!ItemWrittenBook.validBookTagContents(llllllllllllllIIlIIllllllIIIlIlI.getTagCompound())) {
                    throw new IOException("Invalid book tag!");
                }
                final ItemStack llllllllllllllIIlIIllllllIIIlIIl = this.playerEntity.getHeldItemMainhand();
                if (llllllllllllllIIlIIllllllIIIlIIl.func_190926_b()) {
                    return;
                }
                if (llllllllllllllIIlIIllllllIIIlIlI.getItem() == Items.WRITABLE_BOOK && llllllllllllllIIlIIllllllIIIlIIl.getItem() == Items.WRITABLE_BOOK) {
                    final ItemStack llllllllllllllIIlIIllllllIIIlIII = new ItemStack(Items.WRITTEN_BOOK);
                    llllllllllllllIIlIIllllllIIIlIII.setTagInfo("author", new NBTTagString(this.playerEntity.getName()));
                    llllllllllllllIIlIIllllllIIIlIII.setTagInfo("title", new NBTTagString(llllllllllllllIIlIIllllllIIIlIlI.getTagCompound().getString("title")));
                    final NBTTagList llllllllllllllIIlIIllllllIIIIlll = llllllllllllllIIlIIllllllIIIlIlI.getTagCompound().getTagList("pages", 8);
                    for (int llllllllllllllIIlIIllllllIIIIllI = 0; llllllllllllllIIlIIllllllIIIIllI < llllllllllllllIIlIIllllllIIIIlll.tagCount(); ++llllllllllllllIIlIIllllllIIIIllI) {
                        String llllllllllllllIIlIIllllllIIIIlIl = llllllllllllllIIlIIllllllIIIIlll.getStringTagAt(llllllllllllllIIlIIllllllIIIIllI);
                        final ITextComponent llllllllllllllIIlIIllllllIIIIlII = new TextComponentString(llllllllllllllIIlIIllllllIIIIlIl);
                        llllllllllllllIIlIIllllllIIIIlIl = ITextComponent.Serializer.componentToJson(llllllllllllllIIlIIllllllIIIIlII);
                        llllllllllllllIIlIIllllllIIIIlll.set(llllllllllllllIIlIIllllllIIIIllI, new NBTTagString(llllllllllllllIIlIIllllllIIIIlIl));
                    }
                    llllllllllllllIIlIIllllllIIIlIII.setTagInfo("pages", llllllllllllllIIlIIllllllIIIIlll);
                    this.playerEntity.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, llllllllllllllIIlIIllllllIIIlIII);
                }
            }
            catch (Exception llllllllllllllIIlIIllllllIIIIIll) {
                NetHandlerPlayServer.LOGGER.error("Couldn't sign book", (Throwable)llllllllllllllIIlIIllllllIIIIIll);
            }
        }
        else if ("MC|TrSel".equals(llllllllllllllIIlIIllllllIIlIIII)) {
            try {
                final int llllllllllllllIIlIIllllllIIIIIlI = llllllllllllllIIlIIlllllIlIIlIlI.getBufferData().readInt();
                final Container llllllllllllllIIlIIllllllIIIIIIl = this.playerEntity.openContainer;
                if (llllllllllllllIIlIIllllllIIIIIIl instanceof ContainerMerchant) {
                    ((ContainerMerchant)llllllllllllllIIlIIllllllIIIIIIl).setCurrentRecipeIndex(llllllllllllllIIlIIllllllIIIIIlI);
                }
            }
            catch (Exception llllllllllllllIIlIIllllllIIIIIII) {
                NetHandlerPlayServer.LOGGER.error("Couldn't select trade", (Throwable)llllllllllllllIIlIIllllllIIIIIII);
            }
        }
        else if ("MC|AdvCmd".equals(llllllllllllllIIlIIllllllIIlIIII)) {
            if (!this.serverController.isCommandBlockEnabled()) {
                this.playerEntity.addChatMessage(new TextComponentTranslation("advMode.notEnabled", new Object[0]));
                return;
            }
            if (!this.playerEntity.canUseCommandBlock()) {
                this.playerEntity.addChatMessage(new TextComponentTranslation("advMode.notAllowed", new Object[0]));
                return;
            }
            final PacketBuffer llllllllllllllIIlIIlllllIlllllll = llllllllllllllIIlIIlllllIlIIlIlI.getBufferData();
            try {
                final int llllllllllllllIIlIIlllllIllllllI = llllllllllllllIIlIIlllllIlllllll.readByte();
                CommandBlockBaseLogic llllllllllllllIIlIIlllllIlllllIl = null;
                if (llllllllllllllIIlIIlllllIllllllI == 0) {
                    final TileEntity llllllllllllllIIlIIlllllIlllllII = this.playerEntity.world.getTileEntity(new BlockPos(llllllllllllllIIlIIlllllIlllllll.readInt(), llllllllllllllIIlIIlllllIlllllll.readInt(), llllllllllllllIIlIIlllllIlllllll.readInt()));
                    if (llllllllllllllIIlIIlllllIlllllII instanceof TileEntityCommandBlock) {
                        llllllllllllllIIlIIlllllIlllllIl = ((TileEntityCommandBlock)llllllllllllllIIlIIlllllIlllllII).getCommandBlockLogic();
                    }
                }
                else if (llllllllllllllIIlIIlllllIllllllI == 1) {
                    final Entity llllllllllllllIIlIIlllllIllllIll = this.playerEntity.world.getEntityByID(llllllllllllllIIlIIlllllIlllllll.readInt());
                    if (llllllllllllllIIlIIlllllIllllIll instanceof EntityMinecartCommandBlock) {
                        llllllllllllllIIlIIlllllIlllllIl = ((EntityMinecartCommandBlock)llllllllllllllIIlIIlllllIllllIll).getCommandBlockLogic();
                    }
                }
                final String llllllllllllllIIlIIlllllIllllIlI = llllllllllllllIIlIIlllllIlllllll.readStringFromBuffer(llllllllllllllIIlIIlllllIlllllll.readableBytes());
                final boolean llllllllllllllIIlIIlllllIllllIIl = llllllllllllllIIlIIlllllIlllllll.readBoolean();
                if (llllllllllllllIIlIIlllllIlllllIl != null) {
                    llllllllllllllIIlIIlllllIlllllIl.setCommand(llllllllllllllIIlIIlllllIllllIlI);
                    llllllllllllllIIlIIlllllIlllllIl.setTrackOutput(llllllllllllllIIlIIlllllIllllIIl);
                    if (!llllllllllllllIIlIIlllllIllllIIl) {
                        llllllllllllllIIlIIlllllIlllllIl.setLastOutput(null);
                    }
                    llllllllllllllIIlIIlllllIlllllIl.updateCommand();
                    this.playerEntity.addChatMessage(new TextComponentTranslation("advMode.setCommand.success", new Object[] { llllllllllllllIIlIIlllllIllllIlI }));
                }
            }
            catch (Exception llllllllllllllIIlIIlllllIllllIII) {
                NetHandlerPlayServer.LOGGER.error("Couldn't set command block", (Throwable)llllllllllllllIIlIIlllllIllllIII);
            }
        }
        else if ("MC|AutoCmd".equals(llllllllllllllIIlIIllllllIIlIIII)) {
            if (!this.serverController.isCommandBlockEnabled()) {
                this.playerEntity.addChatMessage(new TextComponentTranslation("advMode.notEnabled", new Object[0]));
                return;
            }
            if (!this.playerEntity.canUseCommandBlock()) {
                this.playerEntity.addChatMessage(new TextComponentTranslation("advMode.notAllowed", new Object[0]));
                return;
            }
            final PacketBuffer llllllllllllllIIlIIlllllIlllIlll = llllllllllllllIIlIIlllllIlIIlIlI.getBufferData();
            try {
                CommandBlockBaseLogic llllllllllllllIIlIIlllllIlllIllI = null;
                TileEntityCommandBlock llllllllllllllIIlIIlllllIlllIlIl = null;
                final BlockPos llllllllllllllIIlIIlllllIlllIlII = new BlockPos(llllllllllllllIIlIIlllllIlllIlll.readInt(), llllllllllllllIIlIIlllllIlllIlll.readInt(), llllllllllllllIIlIIlllllIlllIlll.readInt());
                final TileEntity llllllllllllllIIlIIlllllIlllIIll = this.playerEntity.world.getTileEntity(llllllllllllllIIlIIlllllIlllIlII);
                if (llllllllllllllIIlIIlllllIlllIIll instanceof TileEntityCommandBlock) {
                    llllllllllllllIIlIIlllllIlllIlIl = (TileEntityCommandBlock)llllllllllllllIIlIIlllllIlllIIll;
                    llllllllllllllIIlIIlllllIlllIllI = llllllllllllllIIlIIlllllIlllIlIl.getCommandBlockLogic();
                }
                final String llllllllllllllIIlIIlllllIlllIIlI = llllllllllllllIIlIIlllllIlllIlll.readStringFromBuffer(llllllllllllllIIlIIlllllIlllIlll.readableBytes());
                final boolean llllllllllllllIIlIIlllllIlllIIIl = llllllllllllllIIlIIlllllIlllIlll.readBoolean();
                final TileEntityCommandBlock.Mode llllllllllllllIIlIIlllllIlllIIII = TileEntityCommandBlock.Mode.valueOf(llllllllllllllIIlIIlllllIlllIlll.readStringFromBuffer(16));
                final boolean llllllllllllllIIlIIlllllIllIllll = llllllllllllllIIlIIlllllIlllIlll.readBoolean();
                final boolean llllllllllllllIIlIIlllllIllIlllI = llllllllllllllIIlIIlllllIlllIlll.readBoolean();
                if (llllllllllllllIIlIIlllllIlllIllI != null) {
                    final EnumFacing llllllllllllllIIlIIlllllIllIllIl = this.playerEntity.world.getBlockState(llllllllllllllIIlIIlllllIlllIlII).getValue((IProperty<EnumFacing>)BlockCommandBlock.FACING);
                    switch ($SWITCH_TABLE$net$minecraft$tileentity$TileEntityCommandBlock$Mode()[llllllllllllllIIlIIlllllIlllIIII.ordinal()]) {
                        case 1: {
                            final IBlockState llllllllllllllIIlIIlllllIllIllII = Blocks.CHAIN_COMMAND_BLOCK.getDefaultState();
                            this.playerEntity.world.setBlockState(llllllllllllllIIlIIlllllIlllIlII, llllllllllllllIIlIIlllllIllIllII.withProperty((IProperty<Comparable>)BlockCommandBlock.FACING, llllllllllllllIIlIIlllllIllIllIl).withProperty((IProperty<Comparable>)BlockCommandBlock.CONDITIONAL, llllllllllllllIIlIIlllllIllIllll), 2);
                            break;
                        }
                        case 2: {
                            final IBlockState llllllllllllllIIlIIlllllIllIlIll = Blocks.REPEATING_COMMAND_BLOCK.getDefaultState();
                            this.playerEntity.world.setBlockState(llllllllllllllIIlIIlllllIlllIlII, llllllllllllllIIlIIlllllIllIlIll.withProperty((IProperty<Comparable>)BlockCommandBlock.FACING, llllllllllllllIIlIIlllllIllIllIl).withProperty((IProperty<Comparable>)BlockCommandBlock.CONDITIONAL, llllllllllllllIIlIIlllllIllIllll), 2);
                            break;
                        }
                        case 3: {
                            final IBlockState llllllllllllllIIlIIlllllIllIlIlI = Blocks.COMMAND_BLOCK.getDefaultState();
                            this.playerEntity.world.setBlockState(llllllllllllllIIlIIlllllIlllIlII, llllllllllllllIIlIIlllllIllIlIlI.withProperty((IProperty<Comparable>)BlockCommandBlock.FACING, llllllllllllllIIlIIlllllIllIllIl).withProperty((IProperty<Comparable>)BlockCommandBlock.CONDITIONAL, llllllllllllllIIlIIlllllIllIllll), 2);
                            break;
                        }
                    }
                    llllllllllllllIIlIIlllllIlllIIll.validate();
                    this.playerEntity.world.setTileEntity(llllllllllllllIIlIIlllllIlllIlII, llllllllllllllIIlIIlllllIlllIIll);
                    llllllllllllllIIlIIlllllIlllIllI.setCommand(llllllllllllllIIlIIlllllIlllIIlI);
                    llllllllllllllIIlIIlllllIlllIllI.setTrackOutput(llllllllllllllIIlIIlllllIlllIIIl);
                    if (!llllllllllllllIIlIIlllllIlllIIIl) {
                        llllllllllllllIIlIIlllllIlllIllI.setLastOutput(null);
                    }
                    llllllllllllllIIlIIlllllIlllIlIl.setAuto(llllllllllllllIIlIIlllllIllIlllI);
                    llllllllllllllIIlIIlllllIlllIllI.updateCommand();
                    if (!StringUtils.isNullOrEmpty(llllllllllllllIIlIIlllllIlllIIlI)) {
                        this.playerEntity.addChatMessage(new TextComponentTranslation("advMode.setCommand.success", new Object[] { llllllllllllllIIlIIlllllIlllIIlI }));
                    }
                }
            }
            catch (Exception llllllllllllllIIlIIlllllIllIlIIl) {
                NetHandlerPlayServer.LOGGER.error("Couldn't set command block", (Throwable)llllllllllllllIIlIIlllllIllIlIIl);
            }
        }
        else if ("MC|Beacon".equals(llllllllllllllIIlIIllllllIIlIIII)) {
            if (this.playerEntity.openContainer instanceof ContainerBeacon) {
                try {
                    final PacketBuffer llllllllllllllIIlIIlllllIllIlIII = llllllllllllllIIlIIlllllIlIIlIlI.getBufferData();
                    final int llllllllllllllIIlIIlllllIllIIlll = llllllllllllllIIlIIlllllIllIlIII.readInt();
                    final int llllllllllllllIIlIIlllllIllIIllI = llllllllllllllIIlIIlllllIllIlIII.readInt();
                    final ContainerBeacon llllllllllllllIIlIIlllllIllIIlIl = (ContainerBeacon)this.playerEntity.openContainer;
                    final Slot llllllllllllllIIlIIlllllIllIIlII = llllllllllllllIIlIIlllllIllIIlIl.getSlot(0);
                    if (llllllllllllllIIlIIlllllIllIIlII.getHasStack()) {
                        llllllllllllllIIlIIlllllIllIIlII.decrStackSize(1);
                        final IInventory llllllllllllllIIlIIlllllIllIIIll = llllllllllllllIIlIIlllllIllIIlIl.getTileEntity();
                        llllllllllllllIIlIIlllllIllIIIll.setField(1, llllllllllllllIIlIIlllllIllIIlll);
                        llllllllllllllIIlIIlllllIllIIIll.setField(2, llllllllllllllIIlIIlllllIllIIllI);
                        llllllllllllllIIlIIlllllIllIIIll.markDirty();
                    }
                }
                catch (Exception llllllllllllllIIlIIlllllIllIIIlI) {
                    NetHandlerPlayServer.LOGGER.error("Couldn't set beacon", (Throwable)llllllllllllllIIlIIlllllIllIIIlI);
                }
            }
        }
        else if ("MC|ItemName".equals(llllllllllllllIIlIIllllllIIlIIII)) {
            if (this.playerEntity.openContainer instanceof ContainerRepair) {
                final ContainerRepair llllllllllllllIIlIIlllllIllIIIIl = (ContainerRepair)this.playerEntity.openContainer;
                if (llllllllllllllIIlIIlllllIlIIlIlI.getBufferData() != null && llllllllllllllIIlIIlllllIlIIlIlI.getBufferData().readableBytes() >= 1) {
                    final String llllllllllllllIIlIIlllllIllIIIII = ChatAllowedCharacters.filterAllowedCharacters(llllllllllllllIIlIIlllllIlIIlIlI.getBufferData().readStringFromBuffer(32767));
                    if (llllllllllllllIIlIIlllllIllIIIII.length() <= 35) {
                        llllllllllllllIIlIIlllllIllIIIIl.updateItemName(llllllllllllllIIlIIlllllIllIIIII);
                    }
                }
                else {
                    llllllllllllllIIlIIlllllIllIIIIl.updateItemName("");
                }
            }
        }
        else if ("MC|Struct".equals(llllllllllllllIIlIIllllllIIlIIII)) {
            if (!this.playerEntity.canUseCommandBlock()) {
                return;
            }
            final PacketBuffer llllllllllllllIIlIIlllllIlIlllll = llllllllllllllIIlIIlllllIlIIlIlI.getBufferData();
            try {
                final BlockPos llllllllllllllIIlIIlllllIlIllllI = new BlockPos(llllllllllllllIIlIIlllllIlIlllll.readInt(), llllllllllllllIIlIIlllllIlIlllll.readInt(), llllllllllllllIIlIIlllllIlIlllll.readInt());
                final IBlockState llllllllllllllIIlIIlllllIlIlllIl = this.playerEntity.world.getBlockState(llllllllllllllIIlIIlllllIlIllllI);
                final TileEntity llllllllllllllIIlIIlllllIlIlllII = this.playerEntity.world.getTileEntity(llllllllllllllIIlIIlllllIlIllllI);
                if (llllllllllllllIIlIIlllllIlIlllII instanceof TileEntityStructure) {
                    final TileEntityStructure llllllllllllllIIlIIlllllIlIllIll = (TileEntityStructure)llllllllllllllIIlIIlllllIlIlllII;
                    final int llllllllllllllIIlIIlllllIlIllIlI = llllllllllllllIIlIIlllllIlIlllll.readByte();
                    final String llllllllllllllIIlIIlllllIlIllIIl = llllllllllllllIIlIIlllllIlIlllll.readStringFromBuffer(32);
                    llllllllllllllIIlIIlllllIlIllIll.setMode(TileEntityStructure.Mode.valueOf(llllllllllllllIIlIIlllllIlIllIIl));
                    llllllllllllllIIlIIlllllIlIllIll.setName(llllllllllllllIIlIIlllllIlIlllll.readStringFromBuffer(64));
                    final int llllllllllllllIIlIIlllllIlIllIII = MathHelper.clamp(llllllllllllllIIlIIlllllIlIlllll.readInt(), -32, 32);
                    final int llllllllllllllIIlIIlllllIlIlIlll = MathHelper.clamp(llllllllllllllIIlIIlllllIlIlllll.readInt(), -32, 32);
                    final int llllllllllllllIIlIIlllllIlIlIllI = MathHelper.clamp(llllllllllllllIIlIIlllllIlIlllll.readInt(), -32, 32);
                    llllllllllllllIIlIIlllllIlIllIll.setPosition(new BlockPos(llllllllllllllIIlIIlllllIlIllIII, llllllllllllllIIlIIlllllIlIlIlll, llllllllllllllIIlIIlllllIlIlIllI));
                    final int llllllllllllllIIlIIlllllIlIlIlIl = MathHelper.clamp(llllllllllllllIIlIIlllllIlIlllll.readInt(), 0, 32);
                    final int llllllllllllllIIlIIlllllIlIlIlII = MathHelper.clamp(llllllllllllllIIlIIlllllIlIlllll.readInt(), 0, 32);
                    final int llllllllllllllIIlIIlllllIlIlIIll = MathHelper.clamp(llllllllllllllIIlIIlllllIlIlllll.readInt(), 0, 32);
                    llllllllllllllIIlIIlllllIlIllIll.setSize(new BlockPos(llllllllllllllIIlIIlllllIlIlIlIl, llllllllllllllIIlIIlllllIlIlIlII, llllllllllllllIIlIIlllllIlIlIIll));
                    final String llllllllllllllIIlIIlllllIlIlIIlI = llllllllllllllIIlIIlllllIlIlllll.readStringFromBuffer(32);
                    llllllllllllllIIlIIlllllIlIllIll.setMirror(Mirror.valueOf(llllllllllllllIIlIIlllllIlIlIIlI));
                    final String llllllllllllllIIlIIlllllIlIlIIIl = llllllllllllllIIlIIlllllIlIlllll.readStringFromBuffer(32);
                    llllllllllllllIIlIIlllllIlIllIll.setRotation(Rotation.valueOf(llllllllllllllIIlIIlllllIlIlIIIl));
                    llllllllllllllIIlIIlllllIlIllIll.setMetadata(llllllllllllllIIlIIlllllIlIlllll.readStringFromBuffer(128));
                    llllllllllllllIIlIIlllllIlIllIll.setIgnoresEntities(llllllllllllllIIlIIlllllIlIlllll.readBoolean());
                    llllllllllllllIIlIIlllllIlIllIll.setShowAir(llllllllllllllIIlIIlllllIlIlllll.readBoolean());
                    llllllllllllllIIlIIlllllIlIllIll.setShowBoundingBox(llllllllllllllIIlIIlllllIlIlllll.readBoolean());
                    llllllllllllllIIlIIlllllIlIllIll.setIntegrity(MathHelper.clamp(llllllllllllllIIlIIlllllIlIlllll.readFloat(), 0.0f, 1.0f));
                    llllllllllllllIIlIIlllllIlIllIll.setSeed(llllllllllllllIIlIIlllllIlIlllll.readVarLong());
                    final String llllllllllllllIIlIIlllllIlIlIIII = llllllllllllllIIlIIlllllIlIllIll.getName();
                    if (llllllllllllllIIlIIlllllIlIllIlI == 2) {
                        if (llllllllllllllIIlIIlllllIlIllIll.save()) {
                            this.playerEntity.addChatComponentMessage(new TextComponentTranslation("structure_block.save_success", new Object[] { llllllllllllllIIlIIlllllIlIlIIII }), false);
                        }
                        else {
                            this.playerEntity.addChatComponentMessage(new TextComponentTranslation("structure_block.save_failure", new Object[] { llllllllllllllIIlIIlllllIlIlIIII }), false);
                        }
                    }
                    else if (llllllllllllllIIlIIlllllIlIllIlI == 3) {
                        if (!llllllllllllllIIlIIlllllIlIllIll.isStructureLoadable()) {
                            this.playerEntity.addChatComponentMessage(new TextComponentTranslation("structure_block.load_not_found", new Object[] { llllllllllllllIIlIIlllllIlIlIIII }), false);
                        }
                        else if (llllllllllllllIIlIIlllllIlIllIll.load()) {
                            this.playerEntity.addChatComponentMessage(new TextComponentTranslation("structure_block.load_success", new Object[] { llllllllllllllIIlIIlllllIlIlIIII }), false);
                        }
                        else {
                            this.playerEntity.addChatComponentMessage(new TextComponentTranslation("structure_block.load_prepare", new Object[] { llllllllllllllIIlIIlllllIlIlIIII }), false);
                        }
                    }
                    else if (llllllllllllllIIlIIlllllIlIllIlI == 4) {
                        if (llllllllllllllIIlIIlllllIlIllIll.detectSize()) {
                            this.playerEntity.addChatComponentMessage(new TextComponentTranslation("structure_block.size_success", new Object[] { llllllllllllllIIlIIlllllIlIlIIII }), false);
                        }
                        else {
                            this.playerEntity.addChatComponentMessage(new TextComponentTranslation("structure_block.size_failure", new Object[0]), false);
                        }
                    }
                    llllllllllllllIIlIIlllllIlIllIll.markDirty();
                    this.playerEntity.world.notifyBlockUpdate(llllllllllllllIIlIIlllllIlIllllI, llllllllllllllIIlIIlllllIlIlllIl, llllllllllllllIIlIIlllllIlIlllIl, 3);
                }
            }
            catch (Exception llllllllllllllIIlIIlllllIlIIllll) {
                NetHandlerPlayServer.LOGGER.error("Couldn't set structure block", (Throwable)llllllllllllllIIlIIlllllIlIIllll);
            }
        }
        else if ("MC|PickItem".equals(llllllllllllllIIlIIllllllIIlIIII)) {
            final PacketBuffer llllllllllllllIIlIIlllllIlIIlllI = llllllllllllllIIlIIlllllIlIIlIlI.getBufferData();
            try {
                final int llllllllllllllIIlIIlllllIlIIllIl = llllllllllllllIIlIIlllllIlIIlllI.readVarIntFromBuffer();
                this.playerEntity.inventory.pickItem(llllllllllllllIIlIIlllllIlIIllIl);
                this.playerEntity.connection.sendPacket(new SPacketSetSlot(-2, this.playerEntity.inventory.currentItem, this.playerEntity.inventory.getStackInSlot(this.playerEntity.inventory.currentItem)));
                this.playerEntity.connection.sendPacket(new SPacketSetSlot(-2, llllllllllllllIIlIIlllllIlIIllIl, this.playerEntity.inventory.getStackInSlot(llllllllllllllIIlIIlllllIlIIllIl)));
                this.playerEntity.connection.sendPacket(new SPacketHeldItemChange(this.playerEntity.inventory.currentItem));
            }
            catch (Exception llllllllllllllIIlIIlllllIlIIllII) {
                NetHandlerPlayServer.LOGGER.error("Couldn't pick item", (Throwable)llllllllllllllIIlIIlllllIlIIllII);
            }
        }
    }
    
    public void sendPacket(final Packet<?> llllllllllllllIIlIlIIIIIllIlIllI) {
        if (llllllllllllllIIlIlIIIIIllIlIllI instanceof SPacketChat) {
            final SPacketChat llllllllllllllIIlIlIIIIIlllIIIlI = (SPacketChat)llllllllllllllIIlIlIIIIIllIlIllI;
            final EntityPlayer.EnumChatVisibility llllllllllllllIIlIlIIIIIlllIIIII = this.playerEntity.getChatVisibility();
            if (llllllllllllllIIlIlIIIIIlllIIIII == EntityPlayer.EnumChatVisibility.HIDDEN && llllllllllllllIIlIlIIIIIlllIIIlI.func_192590_c() != ChatType.GAME_INFO) {
                return;
            }
            if (llllllllllllllIIlIlIIIIIlllIIIII == EntityPlayer.EnumChatVisibility.SYSTEM && !llllllllllllllIIlIlIIIIIlllIIIlI.isSystem()) {
                return;
            }
        }
        try {
            this.netManager.sendPacket(llllllllllllllIIlIlIIIIIllIlIllI);
        }
        catch (Throwable llllllllllllllIIlIlIIIIIllIllllI) {
            final CrashReport llllllllllllllIIlIlIIIIIllIlllII = CrashReport.makeCrashReport(llllllllllllllIIlIlIIIIIllIllllI, "Sending packet");
            final CrashReportCategory llllllllllllllIIlIlIIIIIllIllIlI = llllllllllllllIIlIlIIIIIllIlllII.makeCategory("Packet being sent");
            llllllllllllllIIlIlIIIIIllIllIlI.setDetail("Packet class", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    return llllllllllllllIIlIlIIIIIllIlIllI.getClass().getCanonicalName();
                }
            });
            throw new ReportedException(llllllllllllllIIlIlIIIIIllIlllII);
        }
    }
    
    @Override
    public void processClientSettings(final CPacketClientSettings llllllllllllllIIlIIlllllllIlllll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIIlllllllIlllll, this, this.playerEntity.getServerWorld());
        this.playerEntity.handleClientSettings(llllllllllllllIIlIIlllllllIlllll);
    }
    
    @Override
    public void processRightClickBlock(final CPacketPlayerTryUseItemOnBlock llllllllllllllIIlIlIIIIlIIllIIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIlIIllIIll, this, this.playerEntity.getServerWorld());
        final WorldServer llllllllllllllIIlIlIIIIlIIlllIlI = this.serverController.worldServerForDimension(this.playerEntity.dimension);
        final EnumHand llllllllllllllIIlIlIIIIlIIlllIIl = llllllllllllllIIlIlIIIIlIIllIIll.getHand();
        final ItemStack llllllllllllllIIlIlIIIIlIIlllIII = this.playerEntity.getHeldItem(llllllllllllllIIlIlIIIIlIIlllIIl);
        final BlockPos llllllllllllllIIlIlIIIIlIIllIlll = llllllllllllllIIlIlIIIIlIIllIIll.getPos();
        final EnumFacing llllllllllllllIIlIlIIIIlIIllIllI = llllllllllllllIIlIlIIIIlIIllIIll.getDirection();
        this.playerEntity.markPlayerActive();
        if (llllllllllllllIIlIlIIIIlIIllIlll.getY() < this.serverController.getBuildLimit() - 1 || (llllllllllllllIIlIlIIIIlIIllIllI != EnumFacing.UP && llllllllllllllIIlIlIIIIlIIllIlll.getY() < this.serverController.getBuildLimit())) {
            if (this.targetPos == null && this.playerEntity.getDistanceSq(llllllllllllllIIlIlIIIIlIIllIlll.getX() + 0.5, llllllllllllllIIlIlIIIIlIIllIlll.getY() + 0.5, llllllllllllllIIlIlIIIIlIIllIlll.getZ() + 0.5) < 64.0 && !this.serverController.isBlockProtected(llllllllllllllIIlIlIIIIlIIlllIlI, llllllllllllllIIlIlIIIIlIIllIlll, this.playerEntity) && llllllllllllllIIlIlIIIIlIIlllIlI.getWorldBorder().contains(llllllllllllllIIlIlIIIIlIIllIlll)) {
                this.playerEntity.interactionManager.processRightClickBlock(this.playerEntity, llllllllllllllIIlIlIIIIlIIlllIlI, llllllllllllllIIlIlIIIIlIIlllIII, llllllllllllllIIlIlIIIIlIIlllIIl, llllllllllllllIIlIlIIIIlIIllIlll, llllllllllllllIIlIlIIIIlIIllIllI, llllllllllllllIIlIlIIIIlIIllIIll.getFacingX(), llllllllllllllIIlIlIIIIlIIllIIll.getFacingY(), llllllllllllllIIlIlIIIIlIIllIIll.getFacingZ());
            }
        }
        else {
            final TextComponentTranslation llllllllllllllIIlIlIIIIlIIllIlIl = new TextComponentTranslation("build.tooHigh", new Object[] { this.serverController.getBuildLimit() });
            llllllllllllllIIlIlIIIIlIIllIlIl.getStyle().setColor(TextFormatting.RED);
            this.playerEntity.connection.sendPacket(new SPacketChat(llllllllllllllIIlIlIIIIlIIllIlIl, ChatType.GAME_INFO));
        }
        this.playerEntity.connection.sendPacket(new SPacketBlockChange(llllllllllllllIIlIlIIIIlIIlllIlI, llllllllllllllIIlIlIIIIlIIllIlll));
        this.playerEntity.connection.sendPacket(new SPacketBlockChange(llllllllllllllIIlIlIIIIlIIlllIlI, llllllllllllllIIlIlIIIIlIIllIlll.offset(llllllllllllllIIlIlIIIIlIIllIllI)));
    }
    
    @Override
    public void processPlayerAbilities(final CPacketPlayerAbilities llllllllllllllIIlIIlllllllllIIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIIlllllllllIIll, this, this.playerEntity.getServerWorld());
        this.playerEntity.capabilities.isFlying = (llllllllllllllIIlIIlllllllllIIll.isFlying() && this.playerEntity.capabilities.allowFlying);
    }
    
    @Override
    public void processChatMessage(final CPacketChatMessage llllllllllllllIIlIlIIIIIlIlIlIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIIlIlIlIlI, this, this.playerEntity.getServerWorld());
        if (this.playerEntity.getChatVisibility() == EntityPlayer.EnumChatVisibility.HIDDEN) {
            final TextComponentTranslation llllllllllllllIIlIlIIIIIlIlIlIIl = new TextComponentTranslation("chat.cannotSend", new Object[0]);
            llllllllllllllIIlIlIIIIIlIlIlIIl.getStyle().setColor(TextFormatting.RED);
            this.sendPacket(new SPacketChat(llllllllllllllIIlIlIIIIIlIlIlIIl));
        }
        else {
            this.playerEntity.markPlayerActive();
            String llllllllllllllIIlIlIIIIIlIlIlIII = llllllllllllllIIlIlIIIIIlIlIlIlI.getMessage();
            llllllllllllllIIlIlIIIIIlIlIlIII = org.apache.commons.lang3.StringUtils.normalizeSpace(llllllllllllllIIlIlIIIIIlIlIlIII);
            for (int llllllllllllllIIlIlIIIIIlIlIIlll = 0; llllllllllllllIIlIlIIIIIlIlIIlll < llllllllllllllIIlIlIIIIIlIlIlIII.length(); ++llllllllllllllIIlIlIIIIIlIlIIlll) {
                if (!ChatAllowedCharacters.isAllowedCharacter(llllllllllllllIIlIlIIIIIlIlIlIII.charAt(llllllllllllllIIlIlIIIIIlIlIIlll))) {
                    this.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.illegal_characters", new Object[0]));
                    return;
                }
            }
            if (llllllllllllllIIlIlIIIIIlIlIlIII.startsWith("/")) {
                this.handleSlashCommand(llllllllllllllIIlIlIIIIIlIlIlIII);
            }
            else {
                final ITextComponent llllllllllllllIIlIlIIIIIlIlIIllI = new TextComponentTranslation("chat.type.text", new Object[] { this.playerEntity.getDisplayName(), llllllllllllllIIlIlIIIIIlIlIlIII });
                this.serverController.getPlayerList().sendChatMsgImpl(llllllllllllllIIlIlIIIIIlIlIIllI, false);
            }
            this.chatSpamThresholdCount += 20;
            if (this.chatSpamThresholdCount > 200 && !this.serverController.getPlayerList().canSendCommands(this.playerEntity.getGameProfile())) {
                this.func_194028_b(new TextComponentTranslation("disconnect.spam", new Object[0]));
            }
        }
    }
    
    @Override
    public void func_191984_a(final CPacketRecipeInfo llllllllllllllIIlIlIIIIllllIIIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIllllIIIll, this, this.playerEntity.getServerWorld());
        if (llllllllllllllIIlIlIIIIllllIIIll.func_194156_a() == CPacketRecipeInfo.Purpose.SHOWN) {
            this.playerEntity.func_192037_E().func_194074_f(llllllllllllllIIlIlIIIIllllIIIll.func_193648_b());
        }
        else if (llllllllllllllIIlIlIIIIllllIIIll.func_194156_a() == CPacketRecipeInfo.Purpose.SETTINGS) {
            this.playerEntity.func_192037_E().func_192813_a(llllllllllllllIIlIlIIIIllllIIIll.func_192624_c());
            this.playerEntity.func_192037_E().func_192810_b(llllllllllllllIIlIlIIIIllllIIIll.func_192625_d());
        }
    }
    
    @Override
    public void onDisconnect(final ITextComponent llllllllllllllIIlIlIIIIIllllIllI) {
        NetHandlerPlayServer.LOGGER.info("{} lost connection: {}", (Object)this.playerEntity.getName(), (Object)llllllllllllllIIlIlIIIIIllllIllI.getUnformattedText());
        this.serverController.refreshStatusNextTick();
        final TextComponentTranslation llllllllllllllIIlIlIIIIIlllllIII = new TextComponentTranslation("multiplayer.player.left", new Object[] { this.playerEntity.getDisplayName() });
        llllllllllllllIIlIlIIIIIlllllIII.getStyle().setColor(TextFormatting.YELLOW);
        this.serverController.getPlayerList().sendChatMsg(llllllllllllllIIlIlIIIIIlllllIII);
        this.playerEntity.mountEntityAndWakeUp();
        this.serverController.getPlayerList().playerLoggedOut(this.playerEntity);
        if (this.serverController.isSinglePlayer() && this.playerEntity.getName().equals(this.serverController.getServerOwner())) {
            NetHandlerPlayServer.LOGGER.info("Stopping singleplayer server as player logged out");
            this.serverController.initiateShutdown();
        }
    }
    
    @Override
    public void handleResourcePackStatus(final CPacketResourcePackStatus llllllllllllllIIlIlIIIIlIIIIlIII) {
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public void processTabComplete(final CPacketTabComplete llllllllllllllIIlIIllllllllIlIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIIllllllllIlIlI, this, this.playerEntity.getServerWorld());
        final List<String> llllllllllllllIIlIIllllllllIlIIl = (List<String>)Lists.newArrayList();
        for (final String llllllllllllllIIlIIllllllllIlIII : this.serverController.getTabCompletions(this.playerEntity, llllllllllllllIIlIIllllllllIlIlI.getMessage(), llllllllllllllIIlIIllllllllIlIlI.getTargetBlock(), llllllllllllllIIlIIllllllllIlIlI.hasTargetBlock())) {
            llllllllllllllIIlIIllllllllIlIIl.add(llllllllllllllIIlIIllllllllIlIII);
        }
        this.playerEntity.connection.sendPacket(new SPacketTabComplete(llllllllllllllIIlIIllllllllIlIIl.toArray(new String[llllllllllllllIIlIIllllllllIlIIl.size()])));
    }
    
    @Override
    public void processPlayerBlockPlacement(final CPacketPlayerTryUseItem llllllllllllllIIlIlIIIIlIIlIIllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIlIIlIIllI, this, this.playerEntity.getServerWorld());
        final WorldServer llllllllllllllIIlIlIIIIlIIlIIlIl = this.serverController.worldServerForDimension(this.playerEntity.dimension);
        final EnumHand llllllllllllllIIlIlIIIIlIIlIIlII = llllllllllllllIIlIlIIIIlIIlIIllI.getHand();
        final ItemStack llllllllllllllIIlIlIIIIlIIlIIIll = this.playerEntity.getHeldItem(llllllllllllllIIlIlIIIIlIIlIIlII);
        this.playerEntity.markPlayerActive();
        if (!llllllllllllllIIlIlIIIIlIIlIIIll.func_190926_b()) {
            this.playerEntity.interactionManager.processRightClick(this.playerEntity, llllllllllllllIIlIlIIIIlIIlIIlIl, llllllllllllllIIlIlIIIIlIIlIIIll, llllllllllllllIIlIlIIIIlIIlIIlII);
        }
    }
    
    public void func_194028_b(final ITextComponent llllllllllllllIIlIlIIIlIIIllllII) {
        this.netManager.sendPacket(new SPacketDisconnect(llllllllllllllIIlIlIIIlIIIllllII), (GenericFutureListener<? extends Future<? super Void>>)new GenericFutureListener<Future<? super Void>>() {
            public void operationComplete(final Future<? super Void> llllllllllllllIlIIIlIIIIIlIIIIIl) throws Exception {
                NetHandlerPlayServer.this.netManager.closeChannel(llllllllllllllIIlIlIIIlIIIllllII);
            }
        }, (GenericFutureListener<? extends Future<? super Void>>[])new GenericFutureListener[0]);
        this.netManager.disableAutoRead();
        Futures.getUnchecked((java.util.concurrent.Future)this.serverController.addScheduledTask(new Runnable() {
            @Override
            public void run() {
                NetHandlerPlayServer.this.netManager.checkDisconnected();
            }
        }));
    }
    
    @Override
    public void processClickWindow(final CPacketClickWindow llllllllllllllIIlIlIIIIIIlIllIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIIIlIllIlI, this, this.playerEntity.getServerWorld());
        this.playerEntity.markPlayerActive();
        if (this.playerEntity.openContainer.windowId == llllllllllllllIIlIlIIIIIIlIllIlI.getWindowId() && this.playerEntity.openContainer.getCanCraft(this.playerEntity)) {
            if (this.playerEntity.isSpectator()) {
                final NonNullList<ItemStack> llllllllllllllIIlIlIIIIIIlIllIIl = NonNullList.func_191196_a();
                for (int llllllllllllllIIlIlIIIIIIlIllIII = 0; llllllllllllllIIlIlIIIIIIlIllIII < this.playerEntity.openContainer.inventorySlots.size(); ++llllllllllllllIIlIlIIIIIIlIllIII) {
                    llllllllllllllIIlIlIIIIIIlIllIIl.add(this.playerEntity.openContainer.inventorySlots.get(llllllllllllllIIlIlIIIIIIlIllIII).getStack());
                }
                this.playerEntity.updateCraftingInventory(this.playerEntity.openContainer, llllllllllllllIIlIlIIIIIIlIllIIl);
            }
            else {
                final ItemStack llllllllllllllIIlIlIIIIIIlIlIlll = this.playerEntity.openContainer.slotClick(llllllllllllllIIlIlIIIIIIlIllIlI.getSlotId(), llllllllllllllIIlIlIIIIIIlIllIlI.getUsedButton(), llllllllllllllIIlIlIIIIIIlIllIlI.getClickType(), this.playerEntity);
                if (ItemStack.areItemStacksEqual(llllllllllllllIIlIlIIIIIIlIllIlI.getClickedItem(), llllllllllllllIIlIlIIIIIIlIlIlll)) {
                    this.playerEntity.connection.sendPacket(new SPacketConfirmTransaction(llllllllllllllIIlIlIIIIIIlIllIlI.getWindowId(), llllllllllllllIIlIlIIIIIIlIllIlI.getActionNumber(), true));
                    this.playerEntity.isChangingQuantityOnly = true;
                    this.playerEntity.openContainer.detectAndSendChanges();
                    this.playerEntity.updateHeldItem();
                    this.playerEntity.isChangingQuantityOnly = false;
                }
                else {
                    this.pendingTransactions.addKey(this.playerEntity.openContainer.windowId, llllllllllllllIIlIlIIIIIIlIllIlI.getActionNumber());
                    this.playerEntity.connection.sendPacket(new SPacketConfirmTransaction(llllllllllllllIIlIlIIIIIIlIllIlI.getWindowId(), llllllllllllllIIlIlIIIIIIlIllIlI.getActionNumber(), false));
                    this.playerEntity.openContainer.setCanCraft(this.playerEntity, false);
                    final NonNullList<ItemStack> llllllllllllllIIlIlIIIIIIlIlIllI = NonNullList.func_191196_a();
                    for (int llllllllllllllIIlIlIIIIIIlIlIlIl = 0; llllllllllllllIIlIlIIIIIIlIlIlIl < this.playerEntity.openContainer.inventorySlots.size(); ++llllllllllllllIIlIlIIIIIIlIlIlIl) {
                        final ItemStack llllllllllllllIIlIlIIIIIIlIlIlII = this.playerEntity.openContainer.inventorySlots.get(llllllllllllllIIlIlIIIIIIlIlIlIl).getStack();
                        final ItemStack llllllllllllllIIlIlIIIIIIlIlIIll = llllllllllllllIIlIlIIIIIIlIlIlII.func_190926_b() ? ItemStack.field_190927_a : llllllllllllllIIlIlIIIIIIlIlIlII;
                        llllllllllllllIIlIlIIIIIIlIlIllI.add(llllllllllllllIIlIlIIIIIIlIlIIll);
                    }
                    this.playerEntity.updateCraftingInventory(this.playerEntity.openContainer, llllllllllllllIIlIlIIIIIIlIlIllI);
                }
            }
        }
    }
    
    @Override
    public void processSteerBoat(final CPacketSteerBoat llllllllllllllIIlIlIIIIlIIIIIIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIlIIIIIIII, this, this.playerEntity.getServerWorld());
        final Entity llllllllllllllIIlIlIIIIlIIIIIIlI = this.playerEntity.getRidingEntity();
        if (llllllllllllllIIlIlIIIIlIIIIIIlI instanceof EntityBoat) {
            ((EntityBoat)llllllllllllllIIlIlIIIIlIIIIIIlI).setPaddleState(llllllllllllllIIlIlIIIIlIIIIIIII.getLeft(), llllllllllllllIIlIlIIIIlIIIIIIII.getRight());
        }
    }
    
    @Override
    public void processHeldItemChange(final CPacketHeldItemChange llllllllllllllIIlIlIIIIIllIIIlIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIIllIIIlIl, this, this.playerEntity.getServerWorld());
        if (llllllllllllllIIlIlIIIIIllIIIlIl.getSlotId() >= 0 && llllllllllllllIIlIlIIIIIllIIIlIl.getSlotId() < InventoryPlayer.getHotbarSize()) {
            this.playerEntity.inventory.currentItem = llllllllllllllIIlIlIIIIIllIIIlIl.getSlotId();
            this.playerEntity.markPlayerActive();
        }
        else {
            NetHandlerPlayServer.LOGGER.warn("{} tried to set an invalid carried item", (Object)this.playerEntity.getName());
        }
    }
    
    private void captureCurrentPosition() {
        this.firstGoodX = this.playerEntity.posX;
        this.firstGoodY = this.playerEntity.posY;
        this.firstGoodZ = this.playerEntity.posZ;
        this.lastGoodX = this.playerEntity.posX;
        this.lastGoodY = this.playerEntity.posY;
        this.lastGoodZ = this.playerEntity.posZ;
    }
    
    private static boolean isMoveVehiclePacketInvalid(final CPacketVehicleMove llllllllllllllIIlIlIIIlIIIlIlllI) {
        return !Doubles.isFinite(llllllllllllllIIlIlIIIlIIIlIlllI.getX()) || !Doubles.isFinite(llllllllllllllIIlIlIIIlIIIlIlllI.getY()) || !Doubles.isFinite(llllllllllllllIIlIlIIIlIIIlIlllI.getZ()) || !Floats.isFinite(llllllllllllllIIlIlIIIlIIIlIlllI.getPitch()) || !Floats.isFinite(llllllllllllllIIlIlIIIlIIIlIlllI.getYaw());
    }
    
    @Override
    public void processConfirmTeleport(final CPacketConfirmTeleport llllllllllllllIIlIlIIIIllllIlIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIllllIlIIl, this, this.playerEntity.getServerWorld());
        if (llllllllllllllIIlIlIIIIllllIlIIl.getTeleportId() == this.teleportId) {
            this.playerEntity.setPositionAndRotation(this.targetPos.xCoord, this.targetPos.yCoord, this.targetPos.zCoord, this.playerEntity.rotationYaw, this.playerEntity.rotationPitch);
            if (this.playerEntity.isInvulnerableDimensionChange()) {
                this.lastGoodX = this.targetPos.xCoord;
                this.lastGoodY = this.targetPos.yCoord;
                this.lastGoodZ = this.targetPos.zCoord;
                this.playerEntity.clearInvulnerableDimensionChange();
            }
            this.targetPos = null;
        }
    }
    
    public void setPlayerLocation(final double llllllllllllllIIlIlIIIIllIIIIllI, final double llllllllllllllIIlIlIIIIllIIIlIll, final double llllllllllllllIIlIlIIIIllIIIlIlI, final float llllllllllllllIIlIlIIIIllIIIIIll, final float llllllllllllllIIlIlIIIIllIIIlIII) {
        this.setPlayerLocation(llllllllllllllIIlIlIIIIllIIIIllI, llllllllllllllIIlIlIIIIllIIIlIll, llllllllllllllIIlIlIIIIllIIIlIlI, llllllllllllllIIlIlIIIIllIIIIIll, llllllllllllllIIlIlIIIIllIIIlIII, Collections.emptySet());
    }
    
    @Override
    public void processPlayer(final CPacketPlayer llllllllllllllIIlIlIIIIllIllllll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIllIllllll, this, this.playerEntity.getServerWorld());
        if (isMovePlayerPacketInvalid(llllllllllllllIIlIlIIIIllIllllll)) {
            this.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.invalid_player_movement", new Object[0]));
        }
        else {
            final WorldServer llllllllllllllIIlIlIIIIllIlllllI = this.serverController.worldServerForDimension(this.playerEntity.dimension);
            if (!this.playerEntity.playerConqueredTheEnd) {
                if (this.networkTickCount == 0) {
                    this.captureCurrentPosition();
                }
                if (this.targetPos != null) {
                    if (this.networkTickCount - this.lastPositionUpdate > 20) {
                        this.lastPositionUpdate = this.networkTickCount;
                        this.setPlayerLocation(this.targetPos.xCoord, this.targetPos.yCoord, this.targetPos.zCoord, this.playerEntity.rotationYaw, this.playerEntity.rotationPitch);
                    }
                }
                else {
                    this.lastPositionUpdate = this.networkTickCount;
                    if (this.playerEntity.isRiding()) {
                        this.playerEntity.setPositionAndRotation(this.playerEntity.posX, this.playerEntity.posY, this.playerEntity.posZ, llllllllllllllIIlIlIIIIllIllllll.getYaw(this.playerEntity.rotationYaw), llllllllllllllIIlIlIIIIllIllllll.getPitch(this.playerEntity.rotationPitch));
                        this.serverController.getPlayerList().serverUpdateMovingPlayer(this.playerEntity);
                    }
                    else {
                        final double llllllllllllllIIlIlIIIIllIllllIl = this.playerEntity.posX;
                        final double llllllllllllllIIlIlIIIIllIllllII = this.playerEntity.posY;
                        final double llllllllllllllIIlIlIIIIllIlllIll = this.playerEntity.posZ;
                        final double llllllllllllllIIlIlIIIIllIlllIlI = this.playerEntity.posY;
                        final double llllllllllllllIIlIlIIIIllIlllIIl = llllllllllllllIIlIlIIIIllIllllll.getX(this.playerEntity.posX);
                        final double llllllllllllllIIlIlIIIIllIlllIII = llllllllllllllIIlIlIIIIllIllllll.getY(this.playerEntity.posY);
                        final double llllllllllllllIIlIlIIIIllIllIlll = llllllllllllllIIlIlIIIIllIllllll.getZ(this.playerEntity.posZ);
                        final float llllllllllllllIIlIlIIIIllIllIllI = llllllllllllllIIlIlIIIIllIllllll.getYaw(this.playerEntity.rotationYaw);
                        final float llllllllllllllIIlIlIIIIllIllIlIl = llllllllllllllIIlIlIIIIllIllllll.getPitch(this.playerEntity.rotationPitch);
                        double llllllllllllllIIlIlIIIIllIllIlII = llllllllllllllIIlIlIIIIllIlllIIl - this.firstGoodX;
                        double llllllllllllllIIlIlIIIIllIllIIll = llllllllllllllIIlIlIIIIllIlllIII - this.firstGoodY;
                        double llllllllllllllIIlIlIIIIllIllIIlI = llllllllllllllIIlIlIIIIllIllIlll - this.firstGoodZ;
                        final double llllllllllllllIIlIlIIIIllIllIIIl = this.playerEntity.motionX * this.playerEntity.motionX + this.playerEntity.motionY * this.playerEntity.motionY + this.playerEntity.motionZ * this.playerEntity.motionZ;
                        double llllllllllllllIIlIlIIIIllIllIIII = llllllllllllllIIlIlIIIIllIllIlII * llllllllllllllIIlIlIIIIllIllIlII + llllllllllllllIIlIlIIIIllIllIIll * llllllllllllllIIlIlIIIIllIllIIll + llllllllllllllIIlIlIIIIllIllIIlI * llllllllllllllIIlIlIIIIllIllIIlI;
                        if (this.playerEntity.isPlayerSleeping()) {
                            if (llllllllllllllIIlIlIIIIllIllIIII > 1.0) {
                                this.setPlayerLocation(this.playerEntity.posX, this.playerEntity.posY, this.playerEntity.posZ, llllllllllllllIIlIlIIIIllIllllll.getYaw(this.playerEntity.rotationYaw), llllllllllllllIIlIlIIIIllIllllll.getPitch(this.playerEntity.rotationPitch));
                            }
                        }
                        else {
                            ++this.movePacketCounter;
                            int llllllllllllllIIlIlIIIIllIlIllll = this.movePacketCounter - this.lastMovePacketCounter;
                            if (llllllllllllllIIlIlIIIIllIlIllll > 5) {
                                NetHandlerPlayServer.LOGGER.debug("{} is sending move packets too frequently ({} packets since last tick)", (Object)this.playerEntity.getName(), (Object)llllllllllllllIIlIlIIIIllIlIllll);
                                llllllllllllllIIlIlIIIIllIlIllll = 1;
                            }
                            if (!this.playerEntity.isInvulnerableDimensionChange() && (!this.playerEntity.getServerWorld().getGameRules().getBoolean("disableElytraMovementCheck") || !this.playerEntity.isElytraFlying())) {
                                final float llllllllllllllIIlIlIIIIllIlIlllI = this.playerEntity.isElytraFlying() ? 300.0f : 100.0f;
                                if (llllllllllllllIIlIlIIIIllIllIIII - llllllllllllllIIlIlIIIIllIllIIIl > llllllllllllllIIlIlIIIIllIlIlllI * llllllllllllllIIlIlIIIIllIlIllll && (!this.serverController.isSinglePlayer() || !this.serverController.getServerOwner().equals(this.playerEntity.getName()))) {
                                    NetHandlerPlayServer.LOGGER.warn("{} moved too quickly! {},{},{}", (Object)this.playerEntity.getName(), (Object)llllllllllllllIIlIlIIIIllIllIlII, (Object)llllllllllllllIIlIlIIIIllIllIIll, (Object)llllllllllllllIIlIlIIIIllIllIIlI);
                                    this.setPlayerLocation(this.playerEntity.posX, this.playerEntity.posY, this.playerEntity.posZ, this.playerEntity.rotationYaw, this.playerEntity.rotationPitch);
                                    return;
                                }
                            }
                            final boolean llllllllllllllIIlIlIIIIllIlIllIl = llllllllllllllIIlIlIIIIllIlllllI.getCollisionBoxes(this.playerEntity, this.playerEntity.getEntityBoundingBox().contract(0.0625)).isEmpty();
                            llllllllllllllIIlIlIIIIllIllIlII = llllllllllllllIIlIlIIIIllIlllIIl - this.lastGoodX;
                            llllllllllllllIIlIlIIIIllIllIIll = llllllllllllllIIlIlIIIIllIlllIII - this.lastGoodY;
                            llllllllllllllIIlIlIIIIllIllIIlI = llllllllllllllIIlIlIIIIllIllIlll - this.lastGoodZ;
                            if (this.playerEntity.onGround && !llllllllllllllIIlIlIIIIllIllllll.isOnGround() && llllllllllllllIIlIlIIIIllIllIIll > 0.0) {
                                this.playerEntity.jump();
                            }
                            this.playerEntity.moveEntity(MoverType.PLAYER, llllllllllllllIIlIlIIIIllIllIlII, llllllllllllllIIlIlIIIIllIllIIll, llllllllllllllIIlIlIIIIllIllIIlI);
                            this.playerEntity.onGround = llllllllllllllIIlIlIIIIllIllllll.isOnGround();
                            final double llllllllllllllIIlIlIIIIllIlIllII = llllllllllllllIIlIlIIIIllIllIIll;
                            llllllllllllllIIlIlIIIIllIllIlII = llllllllllllllIIlIlIIIIllIlllIIl - this.playerEntity.posX;
                            llllllllllllllIIlIlIIIIllIllIIll = llllllllllllllIIlIlIIIIllIlllIII - this.playerEntity.posY;
                            if (llllllllllllllIIlIlIIIIllIllIIll > -0.5 || llllllllllllllIIlIlIIIIllIllIIll < 0.5) {
                                llllllllllllllIIlIlIIIIllIllIIll = 0.0;
                            }
                            llllllllllllllIIlIlIIIIllIllIIlI = llllllllllllllIIlIlIIIIllIllIlll - this.playerEntity.posZ;
                            llllllllllllllIIlIlIIIIllIllIIII = llllllllllllllIIlIlIIIIllIllIlII * llllllllllllllIIlIlIIIIllIllIlII + llllllllllllllIIlIlIIIIllIllIIll * llllllllllllllIIlIlIIIIllIllIIll + llllllllllllllIIlIlIIIIllIllIIlI * llllllllllllllIIlIlIIIIllIllIIlI;
                            boolean llllllllllllllIIlIlIIIIllIlIlIll = false;
                            if (!this.playerEntity.isInvulnerableDimensionChange() && llllllllllllllIIlIlIIIIllIllIIII > 0.0625 && !this.playerEntity.isPlayerSleeping() && !this.playerEntity.interactionManager.isCreative() && this.playerEntity.interactionManager.getGameType() != GameType.SPECTATOR) {
                                llllllllllllllIIlIlIIIIllIlIlIll = true;
                                NetHandlerPlayServer.LOGGER.warn("{} moved wrongly!", (Object)this.playerEntity.getName());
                            }
                            this.playerEntity.setPositionAndRotation(llllllllllllllIIlIlIIIIllIlllIIl, llllllllllllllIIlIlIIIIllIlllIII, llllllllllllllIIlIlIIIIllIllIlll, llllllllllllllIIlIlIIIIllIllIllI, llllllllllllllIIlIlIIIIllIllIlIl);
                            this.playerEntity.addMovementStat(this.playerEntity.posX - llllllllllllllIIlIlIIIIllIllllIl, this.playerEntity.posY - llllllllllllllIIlIlIIIIllIllllII, this.playerEntity.posZ - llllllllllllllIIlIlIIIIllIlllIll);
                            if (!this.playerEntity.noClip && !this.playerEntity.isPlayerSleeping()) {
                                final boolean llllllllllllllIIlIlIIIIllIlIlIlI = llllllllllllllIIlIlIIIIllIlllllI.getCollisionBoxes(this.playerEntity, this.playerEntity.getEntityBoundingBox().contract(0.0625)).isEmpty();
                                if (llllllllllllllIIlIlIIIIllIlIllIl && (llllllllllllllIIlIlIIIIllIlIlIll || !llllllllllllllIIlIlIIIIllIlIlIlI)) {
                                    this.setPlayerLocation(llllllllllllllIIlIlIIIIllIllllIl, llllllllllllllIIlIlIIIIllIllllII, llllllllllllllIIlIlIIIIllIlllIll, llllllllllllllIIlIlIIIIllIllIllI, llllllllllllllIIlIlIIIIllIllIlIl);
                                    return;
                                }
                            }
                            this.floating = (llllllllllllllIIlIlIIIIllIlIllII >= -0.03125);
                            this.floating &= (!this.serverController.isFlightAllowed() && !this.playerEntity.capabilities.allowFlying);
                            this.floating &= (!this.playerEntity.isPotionActive(MobEffects.LEVITATION) && !this.playerEntity.isElytraFlying() && !llllllllllllllIIlIlIIIIllIlllllI.checkBlockCollision(this.playerEntity.getEntityBoundingBox().expandXyz(0.0625).addCoord(0.0, -0.55, 0.0)));
                            this.playerEntity.onGround = llllllllllllllIIlIlIIIIllIllllll.isOnGround();
                            this.serverController.getPlayerList().serverUpdateMovingPlayer(this.playerEntity);
                            this.playerEntity.handleFalling(this.playerEntity.posY - llllllllllllllIIlIlIIIIllIlllIlI, llllllllllllllIIlIlIIIIllIllllll.isOnGround());
                            this.lastGoodX = this.playerEntity.posX;
                            this.lastGoodY = this.playerEntity.posY;
                            this.lastGoodZ = this.playerEntity.posZ;
                        }
                    }
                }
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$client$CPacketClientStatus$State() {
        final int[] $switch_TABLE$net$minecraft$network$play$client$CPacketClientStatus$State = NetHandlerPlayServer.$SWITCH_TABLE$net$minecraft$network$play$client$CPacketClientStatus$State;
        if ($switch_TABLE$net$minecraft$network$play$client$CPacketClientStatus$State != null) {
            return $switch_TABLE$net$minecraft$network$play$client$CPacketClientStatus$State;
        }
        final int llllllllllllllIIlIIlllllIIllIIll = (Object)new int[CPacketClientStatus.State.values().length];
        try {
            llllllllllllllIIlIIlllllIIllIIll[CPacketClientStatus.State.PERFORM_RESPAWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIlIIlllllIIllIIll[CPacketClientStatus.State.REQUEST_STATS.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        return NetHandlerPlayServer.$SWITCH_TABLE$net$minecraft$network$play$client$CPacketClientStatus$State = (int[])(Object)llllllllllllllIIlIIlllllIIllIIll;
    }
    
    public NetworkManager getNetworkManager() {
        return this.netManager;
    }
    
    @Override
    public void processInput(final CPacketInput llllllllllllllIIlIlIIIlIIIllIllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIlIIIllIllI, this, this.playerEntity.getServerWorld());
        this.playerEntity.setEntityActionState(llllllllllllllIIlIlIIIlIIIllIllI.getStrafeSpeed(), llllllllllllllIIlIlIIIlIIIllIllI.func_192620_b(), llllllllllllllIIlIlIIIlIIIllIllI.isJumping(), llllllllllllllIIlIlIIIlIIIllIllI.isSneaking());
    }
    
    private long currentTimeMillis() {
        return System.nanoTime() / 1000000L;
    }
    
    private void handleSlashCommand(final String llllllllllllllIIlIlIIIIIlIIllllI) {
        this.serverController.getCommandManager().executeCommand(this.playerEntity, llllllllllllllIIlIlIIIIIlIIllllI);
    }
    
    public void setPlayerLocation(final double llllllllllllllIIlIlIIIIlIlllIlII, final double llllllllllllllIIlIlIIIIlIlllIIll, final double llllllllllllllIIlIlIIIIlIllIIlII, final float llllllllllllllIIlIlIIIIlIllIIIll, final float llllllllllllllIIlIlIIIIlIlllIIII, final Set<SPacketPlayerPosLook.EnumFlags> llllllllllllllIIlIlIIIIlIllIllll) {
        final double llllllllllllllIIlIlIIIIlIllIlllI = llllllllllllllIIlIlIIIIlIllIllll.contains(SPacketPlayerPosLook.EnumFlags.X) ? this.playerEntity.posX : 0.0;
        final double llllllllllllllIIlIlIIIIlIllIllIl = llllllllllllllIIlIlIIIIlIllIllll.contains(SPacketPlayerPosLook.EnumFlags.Y) ? this.playerEntity.posY : 0.0;
        final double llllllllllllllIIlIlIIIIlIllIllII = llllllllllllllIIlIlIIIIlIllIllll.contains(SPacketPlayerPosLook.EnumFlags.Z) ? this.playerEntity.posZ : 0.0;
        this.targetPos = new Vec3d(llllllllllllllIIlIlIIIIlIlllIlII + llllllllllllllIIlIlIIIIlIllIlllI, llllllllllllllIIlIlIIIIlIlllIIll + llllllllllllllIIlIlIIIIlIllIllIl, llllllllllllllIIlIlIIIIlIllIIlII + llllllllllllllIIlIlIIIIlIllIllII);
        float llllllllllllllIIlIlIIIIlIllIlIll = llllllllllllllIIlIlIIIIlIllIIIll;
        float llllllllllllllIIlIlIIIIlIllIlIlI = llllllllllllllIIlIlIIIIlIlllIIII;
        if (llllllllllllllIIlIlIIIIlIllIllll.contains(SPacketPlayerPosLook.EnumFlags.Y_ROT)) {
            llllllllllllllIIlIlIIIIlIllIlIll = llllllllllllllIIlIlIIIIlIllIIIll + this.playerEntity.rotationYaw;
        }
        if (llllllllllllllIIlIlIIIIlIllIllll.contains(SPacketPlayerPosLook.EnumFlags.X_ROT)) {
            llllllllllllllIIlIlIIIIlIllIlIlI = llllllllllllllIIlIlIIIIlIlllIIII + this.playerEntity.rotationPitch;
        }
        if (++this.teleportId == Integer.MAX_VALUE) {
            this.teleportId = 0;
        }
        this.lastPositionUpdate = this.networkTickCount;
        this.playerEntity.setPositionAndRotation(this.targetPos.xCoord, this.targetPos.yCoord, this.targetPos.zCoord, llllllllllllllIIlIlIIIIlIllIlIll, llllllllllllllIIlIlIIIIlIllIlIlI);
        this.playerEntity.connection.sendPacket(new SPacketPlayerPosLook(llllllllllllllIIlIlIIIIlIlllIlII, llllllllllllllIIlIlIIIIlIlllIIll, llllllllllllllIIlIlIIIIlIllIIlII, llllllllllllllIIlIlIIIIlIllIIIll, llllllllllllllIIlIlIIIIlIlllIIII, llllllllllllllIIlIlIIIIlIllIllll, this.teleportId));
    }
    
    @Override
    public void processCloseWindow(final CPacketCloseWindow llllllllllllllIIlIlIIIIIIllIIlIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIIIllIIlIl, this, this.playerEntity.getServerWorld());
        this.playerEntity.closeContainer();
    }
    
    @Override
    public void processEntityAction(final CPacketEntityAction llllllllllllllIIlIlIIIIIlIIIlIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIIlIIIlIlI, this, this.playerEntity.getServerWorld());
        this.playerEntity.markPlayerActive();
        switch ($SWITCH_TABLE$net$minecraft$network$play$client$CPacketEntityAction$Action()[llllllllllllllIIlIlIIIIIlIIIlIlI.getAction().ordinal()]) {
            case 1: {
                this.playerEntity.setSneaking(true);
                break;
            }
            case 2: {
                this.playerEntity.setSneaking(false);
                break;
            }
            case 4: {
                this.playerEntity.setSprinting(true);
                break;
            }
            case 5: {
                this.playerEntity.setSprinting(false);
                break;
            }
            case 3: {
                if (this.playerEntity.isPlayerSleeping()) {
                    this.playerEntity.wakeUpPlayer(false, true, true);
                    this.targetPos = new Vec3d(this.playerEntity.posX, this.playerEntity.posY, this.playerEntity.posZ);
                    break;
                }
                break;
            }
            case 6: {
                if (!(this.playerEntity.getRidingEntity() instanceof IJumpingMount)) {
                    break;
                }
                final IJumpingMount llllllllllllllIIlIlIIIIIlIIIllll = (IJumpingMount)this.playerEntity.getRidingEntity();
                final int llllllllllllllIIlIlIIIIIlIIIlllI = llllllllllllllIIlIlIIIIIlIIIlIlI.getAuxData();
                if (llllllllllllllIIlIlIIIIIlIIIllll.canJump() && llllllllllllllIIlIlIIIIIlIIIlllI > 0) {
                    llllllllllllllIIlIlIIIIIlIIIllll.handleStartJump(llllllllllllllIIlIlIIIIIlIIIlllI);
                    break;
                }
                break;
            }
            case 7: {
                if (this.playerEntity.getRidingEntity() instanceof IJumpingMount) {
                    final IJumpingMount llllllllllllllIIlIlIIIIIlIIIllIl = (IJumpingMount)this.playerEntity.getRidingEntity();
                    llllllllllllllIIlIlIIIIIlIIIllIl.handleStopJump();
                    break;
                }
                break;
            }
            case 8: {
                if (this.playerEntity.getRidingEntity() instanceof AbstractHorse) {
                    ((AbstractHorse)this.playerEntity.getRidingEntity()).openGUI(this.playerEntity);
                    break;
                }
                break;
            }
            case 9: {
                if (this.playerEntity.onGround || this.playerEntity.motionY >= 0.0 || this.playerEntity.isElytraFlying() || this.playerEntity.isInWater()) {
                    this.playerEntity.clearElytraFlying();
                    break;
                }
                final ItemStack llllllllllllllIIlIlIIIIIlIIIllII = this.playerEntity.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
                if (llllllllllllllIIlIlIIIIIlIIIllII.getItem() == Items.ELYTRA && ItemElytra.isBroken(llllllllllllllIIlIlIIIIIlIIIllII)) {
                    this.playerEntity.setElytraFlying();
                    break;
                }
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid client command!");
            }
        }
    }
    
    @Override
    public void processCreativeInventoryAction(final CPacketCreativeInventoryAction llllllllllllllIIlIlIIIIIIIlIlIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIIIIlIlIll, this, this.playerEntity.getServerWorld());
        if (this.playerEntity.interactionManager.isCreative()) {
            final boolean llllllllllllllIIlIlIIIIIIIllIlIl = llllllllllllllIIlIlIIIIIIIlIlIll.getSlotId() < 0;
            final ItemStack llllllllllllllIIlIlIIIIIIIllIlII = llllllllllllllIIlIlIIIIIIIlIlIll.getStack();
            if (!llllllllllllllIIlIlIIIIIIIllIlII.func_190926_b() && llllllllllllllIIlIlIIIIIIIllIlII.hasTagCompound() && llllllllllllllIIlIlIIIIIIIllIlII.getTagCompound().hasKey("BlockEntityTag", 10)) {
                final NBTTagCompound llllllllllllllIIlIlIIIIIIIllIIll = llllllllllllllIIlIlIIIIIIIllIlII.getTagCompound().getCompoundTag("BlockEntityTag");
                if (llllllllllllllIIlIlIIIIIIIllIIll.hasKey("x") && llllllllllllllIIlIlIIIIIIIllIIll.hasKey("y") && llllllllllllllIIlIlIIIIIIIllIIll.hasKey("z")) {
                    final BlockPos llllllllllllllIIlIlIIIIIIIllIIlI = new BlockPos(llllllllllllllIIlIlIIIIIIIllIIll.getInteger("x"), llllllllllllllIIlIlIIIIIIIllIIll.getInteger("y"), llllllllllllllIIlIlIIIIIIIllIIll.getInteger("z"));
                    final TileEntity llllllllllllllIIlIlIIIIIIIllIIIl = this.playerEntity.world.getTileEntity(llllllllllllllIIlIlIIIIIIIllIIlI);
                    if (llllllllllllllIIlIlIIIIIIIllIIIl != null) {
                        final NBTTagCompound llllllllllllllIIlIlIIIIIIIllIIII = llllllllllllllIIlIlIIIIIIIllIIIl.writeToNBT(new NBTTagCompound());
                        llllllllllllllIIlIlIIIIIIIllIIII.removeTag("x");
                        llllllllllllllIIlIlIIIIIIIllIIII.removeTag("y");
                        llllllllllllllIIlIlIIIIIIIllIIII.removeTag("z");
                        llllllllllllllIIlIlIIIIIIIllIlII.setTagInfo("BlockEntityTag", llllllllllllllIIlIlIIIIIIIllIIII);
                    }
                }
            }
            final boolean llllllllllllllIIlIlIIIIIIIlIllll = llllllllllllllIIlIlIIIIIIIlIlIll.getSlotId() >= 1 && llllllllllllllIIlIlIIIIIIIlIlIll.getSlotId() <= 45;
            final boolean llllllllllllllIIlIlIIIIIIIlIlllI = llllllllllllllIIlIlIIIIIIIllIlII.func_190926_b() || (llllllllllllllIIlIlIIIIIIIllIlII.getMetadata() >= 0 && llllllllllllllIIlIlIIIIIIIllIlII.func_190916_E() <= 64 && !llllllllllllllIIlIlIIIIIIIllIlII.func_190926_b());
            if (llllllllllllllIIlIlIIIIIIIlIllll && llllllllllllllIIlIlIIIIIIIlIlllI) {
                if (llllllllllllllIIlIlIIIIIIIllIlII.func_190926_b()) {
                    this.playerEntity.inventoryContainer.putStackInSlot(llllllllllllllIIlIlIIIIIIIlIlIll.getSlotId(), ItemStack.field_190927_a);
                }
                else {
                    this.playerEntity.inventoryContainer.putStackInSlot(llllllllllllllIIlIlIIIIIIIlIlIll.getSlotId(), llllllllllllllIIlIlIIIIIIIllIlII);
                }
                this.playerEntity.inventoryContainer.setCanCraft(this.playerEntity, true);
            }
            else if (llllllllllllllIIlIlIIIIIIIllIlIl && llllllllllllllIIlIlIIIIIIIlIlllI && this.itemDropThreshold < 200) {
                this.itemDropThreshold += 20;
                final EntityItem llllllllllllllIIlIlIIIIIIIlIllIl = this.playerEntity.dropItem(llllllllllllllIIlIlIIIIIIIllIlII, true);
                if (llllllllllllllIIlIlIIIIIIIlIllIl != null) {
                    llllllllllllllIIlIlIIIIIIIlIllIl.setAgeToCreativeDespawnTime();
                }
            }
        }
    }
    
    @Override
    public void processEnchantItem(final CPacketEnchantItem llllllllllllllIIlIlIIIIIIlIIIIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIIIlIIIIlI, this, this.playerEntity.getServerWorld());
        this.playerEntity.markPlayerActive();
        if (this.playerEntity.openContainer.windowId == llllllllllllllIIlIlIIIIIIlIIIIlI.getWindowId() && this.playerEntity.openContainer.getCanCraft(this.playerEntity) && !this.playerEntity.isSpectator()) {
            this.playerEntity.openContainer.enchantItem(this.playerEntity, llllllllllllllIIlIlIIIIIIlIIIIlI.getButton());
            this.playerEntity.openContainer.detectAndSendChanges();
        }
    }
    
    @Override
    public void func_194308_a(final CPacketPlaceRecipe llllllllllllllIIlIlIIIIIIlIIlIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIIIlIIlIII, this, this.playerEntity.getServerWorld());
        this.playerEntity.markPlayerActive();
        if (!this.playerEntity.isSpectator() && this.playerEntity.openContainer.windowId == llllllllllllllIIlIlIIIIIIlIIlIII.func_194318_a() && this.playerEntity.openContainer.getCanCraft(this.playerEntity)) {
            this.field_194309_H.func_194327_a(this.playerEntity, llllllllllllllIIlIlIIIIIIlIIlIII.func_194317_b(), llllllllllllllIIlIlIIIIIIlIIlIII.func_194319_c());
        }
    }
    
    private static boolean isMovePlayerPacketInvalid(final CPacketPlayer llllllllllllllIIlIlIIIlIIIllIIIl) {
        return !Doubles.isFinite(llllllllllllllIIlIlIIIlIIIllIIIl.getX(0.0)) || !Doubles.isFinite(llllllllllllllIIlIlIIIlIIIllIIIl.getY(0.0)) || !Doubles.isFinite(llllllllllllllIIlIlIIIlIIIllIIIl.getZ(0.0)) || !Floats.isFinite(llllllllllllllIIlIlIIIlIIIllIIIl.getPitch(0.0f)) || !Floats.isFinite(llllllllllllllIIlIlIIIlIIIllIIIl.getYaw(0.0f)) || Math.abs(llllllllllllllIIlIlIIIlIIIllIIIl.getX(0.0)) > 3.0E7 || Math.abs(llllllllllllllIIlIlIIIlIIIllIIIl.getY(0.0)) > 3.0E7 || Math.abs(llllllllllllllIIlIlIIIlIIIllIIIl.getZ(0.0)) > 3.0E7;
    }
    
    @Override
    public void processUpdateSign(final CPacketUpdateSign llllllllllllllIIlIlIIIIIIIIlIIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIIIIIlIIIl, this, this.playerEntity.getServerWorld());
        this.playerEntity.markPlayerActive();
        final WorldServer llllllllllllllIIlIlIIIIIIIIlIIII = this.serverController.worldServerForDimension(this.playerEntity.dimension);
        final BlockPos llllllllllllllIIlIlIIIIIIIIIllll = llllllllllllllIIlIlIIIIIIIIlIIIl.getPosition();
        if (llllllllllllllIIlIlIIIIIIIIlIIII.isBlockLoaded(llllllllllllllIIlIlIIIIIIIIIllll)) {
            final IBlockState llllllllllllllIIlIlIIIIIIIIIlllI = llllllllllllllIIlIlIIIIIIIIlIIII.getBlockState(llllllllllllllIIlIlIIIIIIIIIllll);
            final TileEntity llllllllllllllIIlIlIIIIIIIIIllIl = llllllllllllllIIlIlIIIIIIIIlIIII.getTileEntity(llllllllllllllIIlIlIIIIIIIIIllll);
            if (!(llllllllllllllIIlIlIIIIIIIIIllIl instanceof TileEntitySign)) {
                return;
            }
            final TileEntitySign llllllllllllllIIlIlIIIIIIIIIllII = (TileEntitySign)llllllllllllllIIlIlIIIIIIIIIllIl;
            if (!llllllllllllllIIlIlIIIIIIIIIllII.getIsEditable() || llllllllllllllIIlIlIIIIIIIIIllII.getPlayer() != this.playerEntity) {
                this.serverController.logWarning(String.valueOf(new StringBuilder("Player ").append(this.playerEntity.getName()).append(" just tried to change non-editable sign")));
                return;
            }
            final String[] llllllllllllllIIlIlIIIIIIIIIlIll = llllllllllllllIIlIlIIIIIIIIlIIIl.getLines();
            for (int llllllllllllllIIlIlIIIIIIIIIlIlI = 0; llllllllllllllIIlIlIIIIIIIIIlIlI < llllllllllllllIIlIlIIIIIIIIIlIll.length; ++llllllllllllllIIlIlIIIIIIIIIlIlI) {
                llllllllllllllIIlIlIIIIIIIIIllII.signText[llllllllllllllIIlIlIIIIIIIIIlIlI] = new TextComponentString(TextFormatting.getTextWithoutFormattingCodes(llllllllllllllIIlIlIIIIIIIIIlIll[llllllllllllllIIlIlIIIIIIIIIlIlI]));
            }
            llllllllllllllIIlIlIIIIIIIIIllII.markDirty();
            llllllllllllllIIlIlIIIIIIIIlIIII.notifyBlockUpdate(llllllllllllllIIlIlIIIIIIIIIllll, llllllllllllllIIlIlIIIIIIIIIlllI, llllllllllllllIIlIlIIIIIIIIIlllI, 3);
        }
    }
    
    @Override
    public void processUseEntity(final CPacketUseEntity llllllllllllllIIlIlIIIIIIlllllll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayServer>)llllllllllllllIIlIlIIIIIIlllllll, this, this.playerEntity.getServerWorld());
        final WorldServer llllllllllllllIIlIlIIIIIIllllllI = this.serverController.worldServerForDimension(this.playerEntity.dimension);
        final Entity llllllllllllllIIlIlIIIIIIlllllIl = llllllllllllllIIlIlIIIIIIlllllll.getEntityFromWorld(llllllllllllllIIlIlIIIIIIllllllI);
        this.playerEntity.markPlayerActive();
        if (llllllllllllllIIlIlIIIIIIlllllIl != null) {
            final boolean llllllllllllllIIlIlIIIIIIlllllII = this.playerEntity.canEntityBeSeen(llllllllllllllIIlIlIIIIIIlllllIl);
            double llllllllllllllIIlIlIIIIIIllllIll = 36.0;
            if (!llllllllllllllIIlIlIIIIIIlllllII) {
                llllllllllllllIIlIlIIIIIIllllIll = 9.0;
            }
            if (this.playerEntity.getDistanceSqToEntity(llllllllllllllIIlIlIIIIIIlllllIl) < llllllllllllllIIlIlIIIIIIllllIll) {
                if (llllllllllllllIIlIlIIIIIIlllllll.getAction() == CPacketUseEntity.Action.INTERACT) {
                    final EnumHand llllllllllllllIIlIlIIIIIIllllIlI = llllllllllllllIIlIlIIIIIIlllllll.getHand();
                    this.playerEntity.func_190775_a(llllllllllllllIIlIlIIIIIIlllllIl, llllllllllllllIIlIlIIIIIIllllIlI);
                }
                else if (llllllllllllllIIlIlIIIIIIlllllll.getAction() == CPacketUseEntity.Action.INTERACT_AT) {
                    final EnumHand llllllllllllllIIlIlIIIIIIllllIIl = llllllllllllllIIlIlIIIIIIlllllll.getHand();
                    llllllllllllllIIlIlIIIIIIlllllIl.applyPlayerInteraction(this.playerEntity, llllllllllllllIIlIlIIIIIIlllllll.getHitVec(), llllllllllllllIIlIlIIIIIIllllIIl);
                }
                else if (llllllllllllllIIlIlIIIIIIlllllll.getAction() == CPacketUseEntity.Action.ATTACK) {
                    if (llllllllllllllIIlIlIIIIIIlllllIl instanceof EntityItem || llllllllllllllIIlIlIIIIIIlllllIl instanceof EntityXPOrb || llllllllllllllIIlIlIIIIIIlllllIl instanceof EntityArrow || llllllllllllllIIlIlIIIIIIlllllIl == this.playerEntity) {
                        this.func_194028_b(new TextComponentTranslation("multiplayer.disconnect.invalid_entity_attacked", new Object[0]));
                        this.serverController.logWarning(String.valueOf(new StringBuilder("Player ").append(this.playerEntity.getName()).append(" tried to attack an invalid entity")));
                        return;
                    }
                    this.playerEntity.attackTargetEntityWithCurrentItem(llllllllllllllIIlIlIIIIIIlllllIl);
                }
            }
        }
    }
}
