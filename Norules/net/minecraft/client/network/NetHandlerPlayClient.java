package net.minecraft.client.network;

import net.minecraft.network.play.*;
import com.mojang.authlib.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.crafting.*;
import java.util.function.*;
import net.minecraft.client.gui.toasts.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.player.inventory.*;
import net.minecraft.tileentity.*;
import net.minecraft.inventory.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.creativetab.*;
import io.netty.buffer.*;
import net.minecraft.network.*;
import net.minecraft.client.*;
import net.minecraft.entity.effect.*;
import javax.annotation.*;
import net.minecraft.village.*;
import net.minecraft.pathfinding.*;
import net.minecraft.client.renderer.debug.*;
import net.minecraft.realms.*;
import net.minecraft.nbt.*;
import net.minecraft.world.chunk.*;
import me.nrules.module.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.client.entity.*;
import net.minecraft.network.datasync.*;
import net.minecraft.entity.*;
import net.minecraft.stats.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.audio.*;
import net.minecraft.init.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraft.client.settings.*;
import net.minecraft.potion.*;
import net.minecraft.item.*;
import net.minecraft.world.storage.*;
import net.minecraft.client.particle.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.*;
import java.nio.charset.*;
import java.net.*;
import com.google.common.util.concurrent.*;
import java.io.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.gui.*;
import net.minecraft.entity.item.*;
import com.google.common.collect.*;
import net.minecraft.client.gui.recipebook.*;
import java.util.*;
import net.minecraft.network.play.client.*;
import net.minecraft.scoreboard.*;
import me.nrules.*;
import me.nrules.module.render.*;
import com.mojang.realmsclient.gui.*;
import net.minecraft.network.play.server.*;

public class NetHandlerPlayClient implements INetHandlerPlayClient
{
    private /* synthetic */ WorldClient clientWorldController;
    private /* synthetic */ Minecraft gameController;
    public /* synthetic */ int currentServerMaxPlayers;
    private final /* synthetic */ ClientAdvancementManager field_191983_k;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketRecipeBook$State;
    private final /* synthetic */ NetworkManager netManager;
    private final /* synthetic */ Random avRandomizer;
    private final /* synthetic */ GameProfile profile;
    private /* synthetic */ boolean doneLoadingTerrain;
    private final /* synthetic */ GuiScreen guiScreenServer;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ Map<UUID, NetworkPlayerInfo> playerInfoMap;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketTitle$Type;
    private /* synthetic */ boolean hasStatistics;
    
    @Override
    public void handleEffect(final SPacketEffect lllllllllllllIlIIllIIlllIlIlIIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlllIlIlIIIl, this, this.gameController);
        if (lllllllllllllIlIIllIIlllIlIlIIIl.isSoundServerwide()) {
            this.gameController.world.playBroadcastSound(lllllllllllllIlIIllIIlllIlIlIIIl.getSoundType(), lllllllllllllIlIIllIIlllIlIlIIIl.getSoundPos(), lllllllllllllIlIIllIIlllIlIlIIIl.getSoundData());
        }
        else {
            this.gameController.world.playEvent(lllllllllllllIlIIllIIlllIlIlIIIl.getSoundType(), lllllllllllllIlIIllIIlllIlIlIIIl.getSoundPos(), lllllllllllllIlIIllIIlllIlIlIIIl.getSoundData());
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public void handleAnimation(final SPacketAnimation lllllllllllllIlIIllIlIIIlIIIIIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIlIIIIIlI, this, this.gameController);
        final Entity lllllllllllllIlIIllIlIIIlIIIIIIl = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIlIIIlIIIIIlI.getEntityID());
        if (lllllllllllllIlIIllIlIIIlIIIIIIl != null) {
            if (lllllllllllllIlIIllIlIIIlIIIIIlI.getAnimationType() == 0) {
                final EntityLivingBase lllllllllllllIlIIllIlIIIlIIIIIII = (EntityLivingBase)lllllllllllllIlIIllIlIIIlIIIIIIl;
                lllllllllllllIlIIllIlIIIlIIIIIII.swingArm(EnumHand.MAIN_HAND);
            }
            else if (lllllllllllllIlIIllIlIIIlIIIIIlI.getAnimationType() == 3) {
                final EntityLivingBase lllllllllllllIlIIllIlIIIIlllllll = (EntityLivingBase)lllllllllllllIlIIllIlIIIlIIIIIIl;
                lllllllllllllIlIIllIlIIIIlllllll.swingArm(EnumHand.OFF_HAND);
            }
            else if (lllllllllllllIlIIllIlIIIlIIIIIlI.getAnimationType() == 1) {
                lllllllllllllIlIIllIlIIIlIIIIIIl.performHurtAnimation();
            }
            else if (lllllllllllllIlIIllIlIIIlIIIIIlI.getAnimationType() == 2) {
                final EntityPlayer lllllllllllllIlIIllIlIIIIllllllI = (EntityPlayer)lllllllllllllIlIIllIlIIIlIIIIIIl;
                lllllllllllllIlIIllIlIIIIllllllI.wakeUpPlayer(false, false, false);
            }
            else if (lllllllllllllIlIIllIlIIIlIIIIIlI.getAnimationType() == 4) {
                this.gameController.effectRenderer.emitParticleAtEntity(lllllllllllllIlIIllIlIIIlIIIIIIl, EnumParticleTypes.CRIT);
            }
            else if (lllllllllllllIlIIllIlIIIlIIIIIlI.getAnimationType() == 5) {
                this.gameController.effectRenderer.emitParticleAtEntity(lllllllllllllIlIIllIlIIIlIIIIIIl, EnumParticleTypes.CRIT_MAGIC);
            }
        }
    }
    
    @Override
    public void handleEntityMetadata(final SPacketEntityMetadata lllllllllllllIlIIllIlIIlIlIllIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIlIlIllIlI, this, this.gameController);
        final Entity lllllllllllllIlIIllIlIIlIlIlllII = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIlIIlIlIllIlI.getEntityId());
        if (lllllllllllllIlIIllIlIIlIlIlllII != null && lllllllllllllIlIIllIlIIlIlIllIlI.getDataManagerEntries() != null) {
            lllllllllllllIlIIllIlIIlIlIlllII.getDataManager().setEntryValues(lllllllllllllIlIIllIlIIlIlIllIlI.getDataManagerEntries());
        }
    }
    
    @Override
    public void handleSpawnObject(final SPacketSpawnObject lllllllllllllIlIIllIlIIllIlIllIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIllIlIllIl, this, this.gameController);
        final double lllllllllllllIlIIllIlIIllIlIllII = lllllllllllllIlIIllIlIIllIlIllIl.getX();
        final double lllllllllllllIlIIllIlIIllIlIlIll = lllllllllllllIlIIllIlIIllIlIllIl.getY();
        final double lllllllllllllIlIIllIlIIllIlIlIlI = lllllllllllllIlIIllIlIIllIlIllIl.getZ();
        Entity lllllllllllllIlIIllIlIIllIlIlIIl = null;
        if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 10) {
            lllllllllllllIlIIllIlIIllIlIlIIl = EntityMinecart.create(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI, EntityMinecart.Type.getById(lllllllllllllIlIIllIlIIllIlIllIl.getData()));
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 90) {
            final Entity lllllllllllllIlIIllIlIIllIlIlIII = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIlIIllIlIllIl.getData());
            if (lllllllllllllIlIIllIlIIllIlIlIII instanceof EntityPlayer) {
                lllllllllllllIlIIllIlIIllIlIlIIl = new EntityFishHook(this.clientWorldController, (EntityPlayer)lllllllllllllIlIIllIlIIllIlIlIII, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI);
            }
            lllllllllllllIlIIllIlIIllIlIllIl.setData(0);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 60) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityTippedArrow(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 91) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntitySpectralArrow(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 61) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntitySnowball(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 68) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityLlamaSpit(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedX() / 8000.0, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedY() / 8000.0, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedZ() / 8000.0);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 71) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityItemFrame(this.clientWorldController, new BlockPos(lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI), EnumFacing.getHorizontal(lllllllllllllIlIIllIlIIllIlIllIl.getData()));
            lllllllllllllIlIIllIlIIllIlIllIl.setData(0);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 77) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityLeashKnot(this.clientWorldController, new BlockPos(MathHelper.floor(lllllllllllllIlIIllIlIIllIlIllII), MathHelper.floor(lllllllllllllIlIIllIlIIllIlIlIll), MathHelper.floor(lllllllllllllIlIIllIlIIllIlIlIlI)));
            lllllllllllllIlIIllIlIIllIlIllIl.setData(0);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 65) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityEnderPearl(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 72) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityEnderEye(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 76) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityFireworkRocket(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI, ItemStack.field_190927_a);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 63) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityLargeFireball(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedX() / 8000.0, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedY() / 8000.0, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedZ() / 8000.0);
            lllllllllllllIlIIllIlIIllIlIllIl.setData(0);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 93) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityDragonFireball(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedX() / 8000.0, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedY() / 8000.0, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedZ() / 8000.0);
            lllllllllllllIlIIllIlIIllIlIllIl.setData(0);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 64) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntitySmallFireball(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedX() / 8000.0, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedY() / 8000.0, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedZ() / 8000.0);
            lllllllllllllIlIIllIlIIllIlIllIl.setData(0);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 66) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityWitherSkull(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedX() / 8000.0, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedY() / 8000.0, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedZ() / 8000.0);
            lllllllllllllIlIIllIlIIllIlIllIl.setData(0);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 67) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityShulkerBullet(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedX() / 8000.0, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedY() / 8000.0, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedZ() / 8000.0);
            lllllllllllllIlIIllIlIIllIlIllIl.setData(0);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 62) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityEgg(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 79) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityEvokerFangs(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI, 0.0f, 0, null);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 73) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityPotion(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI, ItemStack.field_190927_a);
            lllllllllllllIlIIllIlIIllIlIllIl.setData(0);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 75) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityExpBottle(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI);
            lllllllllllllIlIIllIlIIllIlIllIl.setData(0);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 1) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityBoat(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 50) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityTNTPrimed(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI, null);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 78) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityArmorStand(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 51) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityEnderCrystal(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 2) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityItem(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 70) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityFallingBlock(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI, Block.getStateById(lllllllllllllIlIIllIlIIllIlIllIl.getData() & 0xFFFF));
            lllllllllllllIlIIllIlIIllIlIllIl.setData(0);
        }
        else if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 3) {
            lllllllllllllIlIIllIlIIllIlIlIIl = new EntityAreaEffectCloud(this.clientWorldController, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI);
        }
        if (lllllllllllllIlIIllIlIIllIlIlIIl != null) {
            EntityTracker.updateServerPosition(lllllllllllllIlIIllIlIIllIlIlIIl, lllllllllllllIlIIllIlIIllIlIllII, lllllllllllllIlIIllIlIIllIlIlIll, lllllllllllllIlIIllIlIIllIlIlIlI);
            lllllllllllllIlIIllIlIIllIlIlIIl.rotationPitch = lllllllllllllIlIIllIlIIllIlIllIl.getPitch() * 360 / 256.0f;
            lllllllllllllIlIIllIlIIllIlIlIIl.rotationYaw = lllllllllllllIlIIllIlIIllIlIllIl.getYaw() * 360 / 256.0f;
            final Entity[] lllllllllllllIlIIllIlIIllIlIIlll = lllllllllllllIlIIllIlIIllIlIlIIl.getParts();
            if (lllllllllllllIlIIllIlIIllIlIIlll != null) {
                final int lllllllllllllIlIIllIlIIllIlIIllI = lllllllllllllIlIIllIlIIllIlIllIl.getEntityID() - lllllllllllllIlIIllIlIIllIlIlIIl.getEntityId();
                final char lllllllllllllIlIIllIlIIllIIllIII;
                final char lllllllllllllIlIIllIlIIllIIllIIl = (char)((Entity[])(Object)(lllllllllllllIlIIllIlIIllIIllIII = (char)(Object)lllllllllllllIlIIllIlIIllIlIIlll)).length;
                for (float lllllllllllllIlIIllIlIIllIIllIlI = 0; lllllllllllllIlIIllIlIIllIIllIlI < lllllllllllllIlIIllIlIIllIIllIIl; ++lllllllllllllIlIIllIlIIllIIllIlI) {
                    final Entity lllllllllllllIlIIllIlIIllIlIIlIl = lllllllllllllIlIIllIlIIllIIllIII[lllllllllllllIlIIllIlIIllIIllIlI];
                    lllllllllllllIlIIllIlIIllIlIIlIl.setEntityId(lllllllllllllIlIIllIlIIllIlIIlIl.getEntityId() + lllllllllllllIlIIllIlIIllIlIIllI);
                }
            }
            lllllllllllllIlIIllIlIIllIlIlIIl.setEntityId(lllllllllllllIlIIllIlIIllIlIllIl.getEntityID());
            lllllllllllllIlIIllIlIIllIlIlIIl.setUniqueId(lllllllllllllIlIIllIlIIllIlIllIl.getUniqueId());
            this.clientWorldController.addEntityToWorld(lllllllllllllIlIIllIlIIllIlIllIl.getEntityID(), lllllllllllllIlIIllIlIIllIlIlIIl);
            if (lllllllllllllIlIIllIlIIllIlIllIl.getData() > 0) {
                if (lllllllllllllIlIIllIlIIllIlIllIl.getType() == 60 || lllllllllllllIlIIllIlIIllIlIllIl.getType() == 91) {
                    final Entity lllllllllllllIlIIllIlIIllIlIIlII = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIlIIllIlIllIl.getData() - 1);
                    if (lllllllllllllIlIIllIlIIllIlIIlII instanceof EntityLivingBase && lllllllllllllIlIIllIlIIllIlIlIIl instanceof EntityArrow) {
                        ((EntityArrow)lllllllllllllIlIIllIlIIllIlIlIIl).shootingEntity = lllllllllllllIlIIllIlIIllIlIIlII;
                    }
                }
                lllllllllllllIlIIllIlIIllIlIlIIl.setVelocity(lllllllllllllIlIIllIlIIllIlIllIl.getSpeedX() / 8000.0, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedY() / 8000.0, lllllllllllllIlIIllIlIIllIlIllIl.getSpeedZ() / 8000.0);
            }
        }
    }
    
    @Override
    public void func_191980_a(final SPacketRecipeBook lllllllllllllIlIIllIIlllIIlIIllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlllIIlIIllI, this, this.gameController);
        final RecipeBook lllllllllllllIlIIllIIlllIIlIIlIl = this.gameController.player.func_192035_E();
        lllllllllllllIlIIllIIlllIIlIIlIl.func_192813_a(lllllllllllllIlIIllIIlllIIlIIllI.func_192593_c());
        lllllllllllllIlIIllIIlllIIlIIlIl.func_192810_b(lllllllllllllIlIIllIIlllIIlIIllI.func_192594_d());
        final SPacketRecipeBook.State lllllllllllllIlIIllIIlllIIlIIlII = lllllllllllllIlIIllIIlllIIlIIllI.func_194151_e();
        switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketRecipeBook$State()[lllllllllllllIlIIllIIlllIIlIIlII.ordinal()]) {
            case 3: {
                for (final IRecipe lllllllllllllIlIIllIIlllIIlIIIlI : lllllllllllllIlIIllIIlllIIlIIllI.func_192595_a()) {
                    lllllllllllllIlIIllIIlllIIlIIlIl.func_193831_b(lllllllllllllIlIIllIIlllIIlIIIlI);
                }
                break;
            }
            case 1: {
                lllllllllllllIlIIllIIlllIIlIIllI.func_192595_a().forEach(lllllllllllllIlIIllIIlllIIlIIlIl::func_194073_a);
                lllllllllllllIlIIllIIlllIIlIIllI.func_193644_b().forEach(lllllllllllllIlIIllIIlllIIlIIlIl::func_193825_e);
                break;
            }
            case 2: {
                final RecipeBook recipeBook;
                lllllllllllllIlIIllIIlllIIlIIllI.func_192595_a().forEach(lllllllllllllIlIIllIIlIlIllllIII -> {
                    recipeBook.func_194073_a(lllllllllllllIlIIllIIlIlIllllIII);
                    recipeBook.func_193825_e(lllllllllllllIlIIllIIlIlIllllIII);
                    RecipeToast.func_193665_a(this.gameController.func_193033_an(), lllllllllllllIlIIllIIlIlIllllIII);
                    return;
                });
                break;
            }
        }
        RecipeBookClient.field_194087_f.forEach(lllllllllllllIlIIllIIlIlIlllIlIl -> lllllllllllllIlIIllIIlIlIlllIlIl.func_194214_a(lllllllllllllIlIIllIIlllIIlIIlIl));
        if (this.gameController.currentScreen instanceof IRecipeShownListener) {
            ((IRecipeShownListener)this.gameController.currentScreen).func_192043_J_();
        }
    }
    
    @Override
    public void handleEntityVelocity(final SPacketEntityVelocity lllllllllllllIlIIllIlIIlIllIIIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIlIllIIIll, this, this.gameController);
        final Entity lllllllllllllIlIIllIlIIlIllIIlIl = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIlIIlIllIIIll.getEntityID());
        if (lllllllllllllIlIIllIlIIlIllIIlIl != null) {
            lllllllllllllIlIIllIlIIlIllIIlIl.setVelocity(lllllllllllllIlIIllIlIIlIllIIIll.getMotionX() / 8000.0, lllllllllllllIlIIllIlIIlIllIIIll.getMotionY() / 8000.0, lllllllllllllIlIIllIlIIlIllIIIll.getMotionZ() / 8000.0);
        }
    }
    
    public NetworkManager getNetworkManager() {
        return this.netManager;
    }
    
    @Override
    public void handleSpawnPosition(final SPacketSpawnPosition lllllllllllllIlIIllIlIIIIlIIIIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIIlIIIIlI, this, this.gameController);
        this.gameController.player.setSpawnPoint(lllllllllllllIlIIllIlIIIIlIIIIlI.getSpawnPos(), true);
        this.gameController.world.getWorldInfo().setSpawn(lllllllllllllIlIIllIlIIIIlIIIIlI.getSpawnPos());
    }
    
    @Override
    public void handleOpenWindow(final SPacketOpenWindow lllllllllllllIlIIllIIllllllIIlll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllllllIIlll, this, this.gameController);
        final EntityPlayerSP lllllllllllllIlIIllIIllllllIlIll = this.gameController.player;
        if ("minecraft:container".equals(lllllllllllllIlIIllIIllllllIIlll.getGuiId())) {
            lllllllllllllIlIIllIIllllllIlIll.displayGUIChest(new InventoryBasic(lllllllllllllIlIIllIIllllllIIlll.getWindowTitle(), lllllllllllllIlIIllIIllllllIIlll.getSlotCount()));
            lllllllllllllIlIIllIIllllllIlIll.openContainer.windowId = lllllllllllllIlIIllIIllllllIIlll.getWindowId();
        }
        else if ("minecraft:villager".equals(lllllllllllllIlIIllIIllllllIIlll.getGuiId())) {
            lllllllllllllIlIIllIIllllllIlIll.displayVillagerTradeGui(new NpcMerchant(lllllllllllllIlIIllIIllllllIlIll, lllllllllllllIlIIllIIllllllIIlll.getWindowTitle()));
            lllllllllllllIlIIllIIllllllIlIll.openContainer.windowId = lllllllllllllIlIIllIIllllllIIlll.getWindowId();
        }
        else if ("EntityHorse".equals(lllllllllllllIlIIllIIllllllIIlll.getGuiId())) {
            final Entity lllllllllllllIlIIllIIllllllIlIlI = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIllllllIIlll.getEntityId());
            if (lllllllllllllIlIIllIIllllllIlIlI instanceof AbstractHorse) {
                lllllllllllllIlIIllIIllllllIlIll.openGuiHorseInventory((AbstractHorse)lllllllllllllIlIIllIIllllllIlIlI, new ContainerHorseChest(lllllllllllllIlIIllIIllllllIIlll.getWindowTitle(), lllllllllllllIlIIllIIllllllIIlll.getSlotCount()));
                lllllllllllllIlIIllIIllllllIlIll.openContainer.windowId = lllllllllllllIlIIllIIllllllIIlll.getWindowId();
            }
        }
        else if (!lllllllllllllIlIIllIIllllllIIlll.hasSlots()) {
            lllllllllllllIlIIllIIllllllIlIll.displayGui(new LocalBlockIntercommunication(lllllllllllllIlIIllIIllllllIIlll.getGuiId(), lllllllllllllIlIIllIIllllllIIlll.getWindowTitle()));
            lllllllllllllIlIIllIIllllllIlIll.openContainer.windowId = lllllllllllllIlIIllIIllllllIIlll.getWindowId();
        }
        else {
            final IInventory lllllllllllllIlIIllIIllllllIlIIl = new ContainerLocalMenu(lllllllllllllIlIIllIIllllllIIlll.getGuiId(), lllllllllllllIlIIllIIllllllIIlll.getWindowTitle(), lllllllllllllIlIIllIIllllllIIlll.getSlotCount());
            lllllllllllllIlIIllIIllllllIlIll.displayGUIChest(lllllllllllllIlIIllIIllllllIlIIl);
            lllllllllllllIlIIllIIllllllIlIll.openContainer.windowId = lllllllllllllIlIIllIIllllllIIlll.getWindowId();
        }
    }
    
    @Override
    public void handleWorldBorder(final SPacketWorldBorder lllllllllllllIlIIllIIllIllllIIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllIllllIIIl, this, this.gameController);
        lllllllllllllIlIIllIIllIllllIIIl.apply(this.clientWorldController.getWorldBorder());
    }
    
    @Override
    public void handleEntityEquipment(final SPacketEntityEquipment lllllllllllllIlIIllIIllllIIlIIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllllIIlIIIl, this, this.gameController);
        final Entity lllllllllllllIlIIllIIllllIIlIIll = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIllllIIlIIIl.getEntityID());
        if (lllllllllllllIlIIllIIllllIIlIIll != null) {
            lllllllllllllIlIIllIIllllIIlIIll.setItemStackToSlot(lllllllllllllIlIIllIIllllIIlIIIl.getEquipmentSlot(), lllllllllllllIlIIllIIllllIIlIIIl.getItemStack());
        }
    }
    
    @Override
    public void handleUpdateTileEntity(final SPacketUpdateTileEntity lllllllllllllIlIIllIIllllIlIIlIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllllIlIIlIl, this, this.gameController);
        if (this.gameController.world.isBlockLoaded(lllllllllllllIlIIllIIllllIlIIlIl.getPos())) {
            final TileEntity lllllllllllllIlIIllIIllllIlIlIIl = this.gameController.world.getTileEntity(lllllllllllllIlIIllIIllllIlIIlIl.getPos());
            final int lllllllllllllIlIIllIIllllIlIlIII = lllllllllllllIlIIllIIllllIlIIlIl.getTileEntityType();
            final boolean lllllllllllllIlIIllIIllllIlIIlll = lllllllllllllIlIIllIIllllIlIlIII == 2 && lllllllllllllIlIIllIIllllIlIlIIl instanceof TileEntityCommandBlock;
            if ((lllllllllllllIlIIllIIllllIlIlIII == 1 && lllllllllllllIlIIllIIllllIlIlIIl instanceof TileEntityMobSpawner) || lllllllllllllIlIIllIIllllIlIIlll || (lllllllllllllIlIIllIIllllIlIlIII == 3 && lllllllllllllIlIIllIIllllIlIlIIl instanceof TileEntityBeacon) || (lllllllllllllIlIIllIIllllIlIlIII == 4 && lllllllllllllIlIIllIIllllIlIlIIl instanceof TileEntitySkull) || (lllllllllllllIlIIllIIllllIlIlIII == 5 && lllllllllllllIlIIllIIllllIlIlIIl instanceof TileEntityFlowerPot) || (lllllllllllllIlIIllIIllllIlIlIII == 6 && lllllllllllllIlIIllIIllllIlIlIIl instanceof TileEntityBanner) || (lllllllllllllIlIIllIIllllIlIlIII == 7 && lllllllllllllIlIIllIIllllIlIlIIl instanceof TileEntityStructure) || (lllllllllllllIlIIllIIllllIlIlIII == 8 && lllllllllllllIlIIllIIllllIlIlIIl instanceof TileEntityEndGateway) || (lllllllllllllIlIIllIIllllIlIlIII == 9 && lllllllllllllIlIIllIIllllIlIlIIl instanceof TileEntitySign) || (lllllllllllllIlIIllIIllllIlIlIII == 10 && lllllllllllllIlIIllIIllllIlIlIIl instanceof TileEntityShulkerBox) || (lllllllllllllIlIIllIIllllIlIlIII == 11 && lllllllllllllIlIIllIIllllIlIlIIl instanceof TileEntityBed)) {
                lllllllllllllIlIIllIIllllIlIlIIl.readFromNBT(lllllllllllllIlIIllIIllllIlIIlIl.getNbtCompound());
            }
            if (lllllllllllllIlIIllIIllllIlIIlll && this.gameController.currentScreen instanceof GuiCommandBlock) {
                ((GuiCommandBlock)this.gameController.currentScreen).updateGui();
            }
        }
    }
    
    @Override
    public void handleConfirmTransaction(final SPacketConfirmTransaction lllllllllllllIlIIllIIlllllIIIlIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlllllIIIlIl, this, this.gameController);
        Container lllllllllllllIlIIllIIlllllIIlIII = null;
        final EntityPlayer lllllllllllllIlIIllIIlllllIIIlll = this.gameController.player;
        if (lllllllllllllIlIIllIIlllllIIIlIl.getWindowId() == 0) {
            lllllllllllllIlIIllIIlllllIIlIII = lllllllllllllIlIIllIIlllllIIIlll.inventoryContainer;
        }
        else if (lllllllllllllIlIIllIIlllllIIIlIl.getWindowId() == lllllllllllllIlIIllIIlllllIIIlll.openContainer.windowId) {
            lllllllllllllIlIIllIIlllllIIlIII = lllllllllllllIlIIllIIlllllIIIlll.openContainer;
        }
        if (lllllllllllllIlIIllIIlllllIIlIII != null && !lllllllllllllIlIIllIIlllllIIIlIl.wasAccepted()) {
            this.sendPacket(new CPacketConfirmTransaction(lllllllllllllIlIIllIIlllllIIIlIl.getWindowId(), lllllllllllllIlIIllIIlllllIIIlIl.getActionNumber(), true));
        }
    }
    
    @Override
    public void handleEntityAttach(final SPacketEntityAttach lllllllllllllIlIIllIlIIIIIlIIIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIIIlIIIlI, this, this.gameController);
        final Entity lllllllllllllIlIIllIlIIIIIlIIIIl = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIlIIIIIlIIIlI.getEntityId());
        final Entity lllllllllllllIlIIllIlIIIIIlIIIII = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIlIIIIIlIIIlI.getVehicleEntityId());
        if (lllllllllllllIlIIllIlIIIIIlIIIIl instanceof EntityLiving) {
            if (lllllllllllllIlIIllIlIIIIIlIIIII != null) {
                ((EntityLiving)lllllllllllllIlIIllIlIIIIIlIIIIl).setLeashedToEntity(lllllllllllllIlIIllIlIIIIIlIIIII, false);
            }
            else {
                ((EntityLiving)lllllllllllllIlIIllIlIIIIIlIIIIl).clearLeashed(false, false);
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action() {
        final int[] $switch_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action = NetHandlerPlayClient.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action;
        if ($switch_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action != null) {
            return $switch_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action;
        }
        final char lllllllllllllIlIIllIIlIllIIIllIl = (Object)new int[SPacketPlayerListItem.Action.values().length];
        try {
            lllllllllllllIlIIllIIlIllIIIllIl[SPacketPlayerListItem.Action.ADD_PLAYER.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIIllIIlIllIIIllIl[SPacketPlayerListItem.Action.REMOVE_PLAYER.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIIllIIlIllIIIllIl[SPacketPlayerListItem.Action.UPDATE_DISPLAY_NAME.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlIIllIIlIllIIIllIl[SPacketPlayerListItem.Action.UPDATE_GAME_MODE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIlIIllIIlIllIIIllIl[SPacketPlayerListItem.Action.UPDATE_LATENCY.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        return NetHandlerPlayClient.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action = (int[])(Object)lllllllllllllIlIIllIIlIllIIIllIl;
    }
    
    @Override
    public void handleSetSlot(final SPacketSetSlot lllllllllllllIlIIllIIlllllIlIlII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlllllIlIlII, this, this.gameController);
        final EntityPlayer lllllllllllllIlIIllIIlllllIllIll = this.gameController.player;
        final ItemStack lllllllllllllIlIIllIIlllllIllIlI = lllllllllllllIlIIllIIlllllIlIlII.getStack();
        final int lllllllllllllIlIIllIIlllllIllIIl = lllllllllllllIlIIllIIlllllIlIlII.getSlot();
        this.gameController.func_193032_ao().func_193301_a(lllllllllllllIlIIllIIlllllIllIlI);
        if (lllllllllllllIlIIllIIlllllIlIlII.getWindowId() == -1) {
            lllllllllllllIlIIllIIlllllIllIll.inventory.setItemStack(lllllllllllllIlIIllIIlllllIllIlI);
        }
        else if (lllllllllllllIlIIllIIlllllIlIlII.getWindowId() == -2) {
            lllllllllllllIlIIllIIlllllIllIll.inventory.setInventorySlotContents(lllllllllllllIlIIllIIlllllIllIIl, lllllllllllllIlIIllIIlllllIllIlI);
        }
        else {
            boolean lllllllllllllIlIIllIIlllllIllIII = false;
            if (this.gameController.currentScreen instanceof GuiContainerCreative) {
                final GuiContainerCreative lllllllllllllIlIIllIIlllllIlIlll = (GuiContainerCreative)this.gameController.currentScreen;
                lllllllllllllIlIIllIIlllllIllIII = (lllllllllllllIlIIllIIlllllIlIlll.getSelectedTabIndex() != CreativeTabs.INVENTORY.getTabIndex());
            }
            if (lllllllllllllIlIIllIIlllllIlIlII.getWindowId() == 0 && lllllllllllllIlIIllIIlllllIlIlII.getSlot() >= 36 && lllllllllllllIlIIllIIlllllIllIIl < 45) {
                if (!lllllllllllllIlIIllIIlllllIllIlI.func_190926_b()) {
                    final ItemStack lllllllllllllIlIIllIIlllllIlIllI = lllllllllllllIlIIllIIlllllIllIll.inventoryContainer.getSlot(lllllllllllllIlIIllIIlllllIllIIl).getStack();
                    if (lllllllllllllIlIIllIIlllllIlIllI.func_190926_b() || lllllllllllllIlIIllIIlllllIlIllI.func_190916_E() < lllllllllllllIlIIllIIlllllIllIlI.func_190916_E()) {
                        lllllllllllllIlIIllIIlllllIllIlI.func_190915_d(5);
                    }
                }
                lllllllllllllIlIIllIIlllllIllIll.inventoryContainer.putStackInSlot(lllllllllllllIlIIllIIlllllIllIIl, lllllllllllllIlIIllIIlllllIllIlI);
            }
            else if (lllllllllllllIlIIllIIlllllIlIlII.getWindowId() == lllllllllllllIlIIllIIlllllIllIll.openContainer.windowId && (lllllllllllllIlIIllIIlllllIlIlII.getWindowId() != 0 || !lllllllllllllIlIIllIIlllllIllIII)) {
                lllllllllllllIlIIllIIlllllIllIll.openContainer.putStackInSlot(lllllllllllllIlIIllIIlllllIllIIl, lllllllllllllIlIIllIIlllllIllIlI);
            }
        }
    }
    
    @Override
    public void handleTimeUpdate(final SPacketTimeUpdate lllllllllllllIlIIllIlIIIIlIIIllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIIlIIIllI, this, this.gameController);
        this.gameController.world.setTotalWorldTime(lllllllllllllIlIIllIlIIIIlIIIllI.getTotalWorldTime());
        this.gameController.world.setWorldTime(lllllllllllllIlIIllIlIIIIlIIIllI.getWorldTime());
    }
    
    private boolean validateResourcePackUrl(final String lllllllllllllIlIIllIIllIIlllllll) {
        try {
            final URI lllllllllllllIlIIllIIllIIllllllI = new URI(lllllllllllllIlIIllIIllIIlllllll);
            final String lllllllllllllIlIIllIIllIIlllllIl = lllllllllllllIlIIllIIllIIllllllI.getScheme();
            final boolean lllllllllllllIlIIllIIllIIlllllII = "level".equals(lllllllllllllIlIIllIIllIIlllllIl);
            if (!"http".equals(lllllllllllllIlIIllIIllIIlllllIl) && !"https".equals(lllllllllllllIlIIllIIllIIlllllIl) && !lllllllllllllIlIIllIIllIIlllllII) {
                throw new URISyntaxException(lllllllllllllIlIIllIIllIIlllllll, "Wrong protocol");
            }
            if (!lllllllllllllIlIIllIIllIIlllllII || (!lllllllllllllIlIIllIIllIIlllllll.contains("..") && lllllllllllllIlIIllIIllIIlllllll.endsWith("/resources.zip"))) {
                return true;
            }
            throw new URISyntaxException(lllllllllllllIlIIllIIllIIlllllll, "Invalid levelstorage resourcepack path");
        }
        catch (URISyntaxException lllllllllllllIlIIllIIllIIllllIll) {
            this.netManager.sendPacket(new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.FAILED_DOWNLOAD));
            return false;
        }
    }
    
    @Override
    public void handleJoinGame(final SPacketJoinGame lllllllllllllIlIIllIlIIllIllllIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIllIllllIl, this, this.gameController);
        this.gameController.playerController = new PlayerControllerMP(this.gameController, this);
        this.clientWorldController = new WorldClient(this, new WorldSettings(0L, lllllllllllllIlIIllIlIIllIllllIl.getGameType(), false, lllllllllllllIlIIllIlIIllIllllIl.isHardcoreMode(), lllllllllllllIlIIllIlIIllIllllIl.getWorldType()), lllllllllllllIlIIllIlIIllIllllIl.getDimension(), lllllllllllllIlIIllIlIIllIllllIl.getDifficulty(), this.gameController.mcProfiler);
        this.gameController.gameSettings.difficulty = lllllllllllllIlIIllIlIIllIllllIl.getDifficulty();
        this.gameController.loadWorld(this.clientWorldController);
        this.gameController.player.dimension = lllllllllllllIlIIllIlIIllIllllIl.getDimension();
        this.gameController.displayGuiScreen(new GuiDownloadTerrain());
        this.gameController.player.setEntityId(lllllllllllllIlIIllIlIIllIllllIl.getPlayerId());
        this.currentServerMaxPlayers = lllllllllllllIlIIllIlIIllIllllIl.getMaxPlayers();
        this.gameController.player.setReducedDebug(lllllllllllllIlIIllIlIIllIllllIl.isReducedDebugInfo());
        this.gameController.playerController.setGameType(lllllllllllllIlIIllIlIIllIllllIl.getGameType());
        this.gameController.gameSettings.sendSettingsToServer();
        this.netManager.sendPacket(new CPacketCustomPayload("MC|Brand", new PacketBuffer(Unpooled.buffer()).writeString(ClientBrandRetriever.getClientModName())));
    }
    
    @Override
    public void handleCamera(final SPacketCamera lllllllllllllIlIIllIIllIllllIllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllIllllIllI, this, this.gameController);
        final Entity lllllllllllllIlIIllIIllIlllllIII = lllllllllllllIlIIllIIllIllllIllI.getEntity(this.clientWorldController);
        if (lllllllllllllIlIIllIIllIlllllIII != null) {
            this.gameController.setRenderViewEntity(lllllllllllllIlIIllIIllIlllllIII);
        }
    }
    
    @Override
    public void handleCloseWindow(final SPacketCloseWindow lllllllllllllIlIIllIIllllIIIlIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllllIIIlIlI, this, this.gameController);
        this.gameController.player.closeScreenAndDropStack();
    }
    
    @Override
    public void handleSpawnGlobalEntity(final SPacketSpawnGlobalEntity lllllllllllllIlIIllIlIIlIllllIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIlIllllIII, this, this.gameController);
        final double lllllllllllllIlIIllIlIIlIlllllIl = lllllllllllllIlIIllIlIIlIllllIII.getX();
        final double lllllllllllllIlIIllIlIIlIlllllII = lllllllllllllIlIIllIlIIlIllllIII.getY();
        final double lllllllllllllIlIIllIlIIlIllllIll = lllllllllllllIlIIllIlIIlIllllIII.getZ();
        Entity lllllllllllllIlIIllIlIIlIllllIlI = null;
        if (lllllllllllllIlIIllIlIIlIllllIII.getType() == 1) {
            lllllllllllllIlIIllIlIIlIllllIlI = new EntityLightningBolt(this.clientWorldController, lllllllllllllIlIIllIlIIlIlllllIl, lllllllllllllIlIIllIlIIlIlllllII, lllllllllllllIlIIllIlIIlIllllIll, false);
        }
        if (lllllllllllllIlIIllIlIIlIllllIlI != null) {
            EntityTracker.updateServerPosition(lllllllllllllIlIIllIlIIlIllllIlI, lllllllllllllIlIIllIlIIlIlllllIl, lllllllllllllIlIIllIlIIlIlllllII, lllllllllllllIlIIllIlIIlIllllIll);
            lllllllllllllIlIIllIlIIlIllllIlI.rotationYaw = 0.0f;
            lllllllllllllIlIIllIlIIlIllllIlI.rotationPitch = 0.0f;
            lllllllllllllIlIIllIlIIlIllllIlI.setEntityId(lllllllllllllIlIIllIlIIlIllllIII.getEntityId());
            this.clientWorldController.addWeatherEffect(lllllllllllllIlIIllIlIIlIllllIlI);
        }
    }
    
    @Override
    public void handleDisplayObjective(final SPacketDisplayObjective lllllllllllllIlIIllIIllIIIIlIlII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllIIIIlIlII, this, this.gameController);
        final Scoreboard lllllllllllllIlIIllIIllIIIIlIlll = this.clientWorldController.getScoreboard();
        if (lllllllllllllIlIIllIIllIIIIlIlII.getName().isEmpty()) {
            lllllllllllllIlIIllIIllIIIIlIlll.setObjectiveInDisplaySlot(lllllllllllllIlIIllIIllIIIIlIlII.getPosition(), null);
        }
        else {
            final ScoreObjective lllllllllllllIlIIllIIllIIIIlIllI = lllllllllllllIlIIllIIllIIIIlIlll.getObjective(lllllllllllllIlIIllIIllIIIIlIlII.getName());
            lllllllllllllIlIIllIIllIIIIlIlll.setObjectiveInDisplaySlot(lllllllllllllIlIIllIIllIIIIlIlII.getPosition(), lllllllllllllIlIIllIIllIIIIlIllI);
        }
    }
    
    private FutureCallback<Object> createDownloadCallback() {
        return (FutureCallback<Object>)new FutureCallback<Object>() {
            public void onFailure(final Throwable lllllllllllllIlIlIlllIIIllIlllII) {
                NetHandlerPlayClient.this.netManager.sendPacket(new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.FAILED_DOWNLOAD));
            }
            
            public void onSuccess(@Nullable final Object lllllllllllllIlIlIlllIIIlllIIIII) {
                NetHandlerPlayClient.this.netManager.sendPacket(new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.SUCCESSFULLY_LOADED));
            }
        };
    }
    
    @Override
    public void handlePlayerAbilities(final SPacketPlayerAbilities lllllllllllllIlIIllIIllIlIllIlIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllIlIllIlIl, this, this.gameController);
        final EntityPlayer lllllllllllllIlIIllIIllIlIllIlII = this.gameController.player;
        lllllllllllllIlIIllIIllIlIllIlII.capabilities.isFlying = lllllllllllllIlIIllIIllIlIllIlIl.isFlying();
        lllllllllllllIlIIllIIllIlIllIlII.capabilities.isCreativeMode = lllllllllllllIlIIllIIllIlIllIlIl.isCreativeMode();
        lllllllllllllIlIIllIIllIlIllIlII.capabilities.disableDamage = lllllllllllllIlIIllIIllIlIllIlIl.isInvulnerable();
        lllllllllllllIlIIllIIllIlIllIlII.capabilities.allowFlying = lllllllllllllIlIIllIIllIlIllIlIl.isAllowFlying();
        lllllllllllllIlIIllIIllIlIllIlII.capabilities.setFlySpeed(lllllllllllllIlIIllIIllIlIllIlIl.getFlySpeed());
        lllllllllllllIlIIllIIllIlIllIlII.capabilities.setPlayerWalkSpeed(lllllllllllllIlIIllIIllIlIllIlIl.getWalkSpeed());
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketRecipeBook$State() {
        final int[] $switch_TABLE$net$minecraft$network$play$server$SPacketRecipeBook$State = NetHandlerPlayClient.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketRecipeBook$State;
        if ($switch_TABLE$net$minecraft$network$play$server$SPacketRecipeBook$State != null) {
            return $switch_TABLE$net$minecraft$network$play$server$SPacketRecipeBook$State;
        }
        final long lllllllllllllIlIIllIIlIllIIlIIIl = (Object)new int[SPacketRecipeBook.State.values().length];
        try {
            lllllllllllllIlIIllIIlIllIIlIIIl[SPacketRecipeBook.State.ADD.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIIllIIlIllIIlIIIl[SPacketRecipeBook.State.INIT.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIIllIIlIllIIlIIIl[SPacketRecipeBook.State.REMOVE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return NetHandlerPlayClient.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketRecipeBook$State = (int[])(Object)lllllllllllllIlIIllIIlIllIIlIIIl;
    }
    
    @Override
    public void handleMultiBlockChange(final SPacketMultiBlockChange lllllllllllllIlIIllIlIIIllIlIIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIllIlIIll, this, this.gameController);
        final char lllllllllllllIlIIllIlIIIllIIllII;
        final String lllllllllllllIlIIllIlIIIllIIllIl = (String)((SPacketMultiBlockChange.BlockUpdateData[])(Object)(lllllllllllllIlIIllIlIIIllIIllII = (char)(Object)lllllllllllllIlIIllIlIIIllIlIIll.getChangedBlocks())).length;
        for (double lllllllllllllIlIIllIlIIIllIIlllI = 0; lllllllllllllIlIIllIlIIIllIIlllI < lllllllllllllIlIIllIlIIIllIIllIl; ++lllllllllllllIlIIllIlIIIllIIlllI) {
            final SPacketMultiBlockChange.BlockUpdateData lllllllllllllIlIIllIlIIIllIlIIlI = lllllllllllllIlIIllIlIIIllIIllII[lllllllllllllIlIIllIlIIIllIIlllI];
            this.clientWorldController.invalidateRegionAndSetBlock(lllllllllllllIlIIllIlIIIllIlIIlI.getPos(), lllllllllllllIlIIllIlIIIllIlIIlI.getBlockState());
        }
    }
    
    @Override
    public void handleUpdateScore(final SPacketUpdateScore lllllllllllllIlIIllIIllIIIlIIIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllIIIlIIIIl, this, this.gameController);
        final Scoreboard lllllllllllllIlIIllIIllIIIlIIlIl = this.clientWorldController.getScoreboard();
        final ScoreObjective lllllllllllllIlIIllIIllIIIlIIlII = lllllllllllllIlIIllIIllIIIlIIlIl.getObjective(lllllllllllllIlIIllIIllIIIlIIIIl.getObjectiveName());
        if (lllllllllllllIlIIllIIllIIIlIIIIl.getScoreAction() == SPacketUpdateScore.Action.CHANGE) {
            final Score lllllllllllllIlIIllIIllIIIlIIIll = lllllllllllllIlIIllIIllIIIlIIlIl.getOrCreateScore(lllllllllllllIlIIllIIllIIIlIIIIl.getPlayerName(), lllllllllllllIlIIllIIllIIIlIIlII);
            lllllllllllllIlIIllIIllIIIlIIIll.setScorePoints(lllllllllllllIlIIllIIllIIIlIIIIl.getScoreValue());
        }
        else if (lllllllllllllIlIIllIIllIIIlIIIIl.getScoreAction() == SPacketUpdateScore.Action.REMOVE) {
            if (StringUtils.isNullOrEmpty(lllllllllllllIlIIllIIllIIIlIIIIl.getObjectiveName())) {
                lllllllllllllIlIIllIIllIIIlIIlIl.removeObjectiveFromEntity(lllllllllllllIlIIllIIllIIIlIIIIl.getPlayerName(), null);
            }
            else if (lllllllllllllIlIIllIIllIIIlIIlII != null) {
                lllllllllllllIlIIllIIllIIIlIIlIl.removeObjectiveFromEntity(lllllllllllllIlIIllIIllIIIlIIIIl.getPlayerName(), lllllllllllllIlIIllIIllIIIlIIlII);
            }
        }
    }
    
    @Override
    public void handlePlayerListHeaderFooter(final SPacketPlayerListHeaderFooter lllllllllllllIlIIllIIllIllIlIlll) {
        this.gameController.ingameGUI.getTabList().setHeader(lllllllllllllIlIIllIIllIllIlIlll.getHeader().getFormattedText().isEmpty() ? null : lllllllllllllIlIIllIIllIllIlIlll.getHeader());
        this.gameController.ingameGUI.getTabList().setFooter(lllllllllllllIlIIllIIllIllIlIlll.getFooter().getFormattedText().isEmpty() ? null : lllllllllllllIlIIllIIllIllIlIlll.getFooter());
    }
    
    @Override
    public void handleTeams(final SPacketTeams lllllllllllllIlIIllIIllIIIIIlIlI) {
        if (lllllllllllllIlIIllIIllIIIIIlIlI != null) {
            PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllIIIIIlIlI, this, this.gameController);
            final Scoreboard lllllllllllllIlIIllIIllIIIIIlIIl = this.clientWorldController.getScoreboard();
            ScorePlayerTeam lllllllllllllIlIIllIIllIIIIIIlll = null;
            if (lllllllllllllIlIIllIIllIIIIIlIlI.getAction() == 0) {
                final ScorePlayerTeam lllllllllllllIlIIllIIllIIIIIlIII = lllllllllllllIlIIllIIllIIIIIlIIl.createTeam(lllllllllllllIlIIllIIllIIIIIlIlI.getName());
            }
            else {
                lllllllllllllIlIIllIIllIIIIIIlll = lllllllllllllIlIIllIIllIIIIIlIIl.getTeam(lllllllllllllIlIIllIIllIIIIIlIlI.getName());
            }
            if (lllllllllllllIlIIllIIllIIIIIlIlI.getAction() == 0 || lllllllllllllIlIIllIIllIIIIIlIlI.getAction() == 2) {
                lllllllllllllIlIIllIIllIIIIIIlll.setTeamName(lllllllllllllIlIIllIIllIIIIIlIlI.getDisplayName());
                lllllllllllllIlIIllIIllIIIIIIlll.setNamePrefix(lllllllllllllIlIIllIIllIIIIIlIlI.getPrefix());
                lllllllllllllIlIIllIIllIIIIIIlll.setNameSuffix(lllllllllllllIlIIllIIllIIIIIlIlI.getSuffix());
                lllllllllllllIlIIllIIllIIIIIIlll.setChatFormat(TextFormatting.fromColorIndex(lllllllllllllIlIIllIIllIIIIIlIlI.getColor()));
                lllllllllllllIlIIllIIllIIIIIIlll.setFriendlyFlags(lllllllllllllIlIIllIIllIIIIIlIlI.getFriendlyFlags());
                final Team.EnumVisible lllllllllllllIlIIllIIllIIIIIIllI = Team.EnumVisible.getByName(lllllllllllllIlIIllIIllIIIIIlIlI.getNameTagVisibility());
                if (lllllllllllllIlIIllIIllIIIIIIllI != null) {
                    lllllllllllllIlIIllIIllIIIIIIlll.setNameTagVisibility(lllllllllllllIlIIllIIllIIIIIIllI);
                }
                final Team.CollisionRule lllllllllllllIlIIllIIllIIIIIIlIl = Team.CollisionRule.getByName(lllllllllllllIlIIllIIllIIIIIlIlI.getCollisionRule());
                if (lllllllllllllIlIIllIIllIIIIIIlIl != null) {
                    lllllllllllllIlIIllIIllIIIIIIlll.setCollisionRule(lllllllllllllIlIIllIIllIIIIIIlIl);
                }
            }
            if (lllllllllllllIlIIllIIllIIIIIlIlI.getAction() == 0 || lllllllllllllIlIIllIIllIIIIIlIlI.getAction() == 3) {
                for (final String lllllllllllllIlIIllIIllIIIIIIlII : lllllllllllllIlIIllIIllIIIIIlIlI.getPlayers()) {
                    lllllllllllllIlIIllIIllIIIIIlIIl.addPlayerToTeam(lllllllllllllIlIIllIIllIIIIIIlII, lllllllllllllIlIIllIIllIIIIIlIlI.getName());
                }
            }
            if (lllllllllllllIlIIllIIllIIIIIlIlI.getAction() == 4) {
                for (final String lllllllllllllIlIIllIIllIIIIIIIll : lllllllllllllIlIIllIIllIIIIIlIlI.getPlayers()) {
                    lllllllllllllIlIIllIIllIIIIIlIIl.removePlayerFromTeam(lllllllllllllIlIIllIIllIIIIIIIll, lllllllllllllIlIIllIIllIIIIIIlll);
                }
            }
            if (lllllllllllllIlIIllIIllIIIIIlIlI.getAction() == 1) {
                lllllllllllllIlIIllIIllIIIIIlIIl.removeTeam(lllllllllllllIlIIllIIllIIIIIIlll);
            }
        }
    }
    
    @Override
    public void handleTitle(final SPacketTitle lllllllllllllIlIIllIIllIlllIIIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllIlllIIIIl, this, this.gameController);
        final SPacketTitle.Type lllllllllllllIlIIllIIllIlllIIllI = lllllllllllllIlIIllIIllIlllIIIIl.getType();
        String lllllllllllllIlIIllIIllIlllIIlIl = null;
        String lllllllllllllIlIIllIIllIlllIIlII = null;
        final String lllllllllllllIlIIllIIllIlllIIIll = (lllllllllllllIlIIllIIllIlllIIIIl.getMessage() != null) ? lllllllllllllIlIIllIIllIlllIIIIl.getMessage().getFormattedText() : "";
        switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketTitle$Type()[lllllllllllllIlIIllIIllIlllIIllI.ordinal()]) {
            case 1: {
                lllllllllllllIlIIllIIllIlllIIlIl = lllllllllllllIlIIllIIllIlllIIIll;
                break;
            }
            case 2: {
                lllllllllllllIlIIllIIllIlllIIlII = lllllllllllllIlIIllIIllIlllIIIll;
                break;
            }
            case 3: {
                this.gameController.ingameGUI.setRecordPlaying(lllllllllllllIlIIllIIllIlllIIIll, false);
                return;
            }
            case 6: {
                this.gameController.ingameGUI.displayTitle("", "", -1, -1, -1);
                this.gameController.ingameGUI.setDefaultTitlesTimes();
                return;
            }
        }
        this.gameController.ingameGUI.displayTitle(lllllllllllllIlIIllIIllIlllIIlIl, lllllllllllllIlIIllIIllIlllIIlII, lllllllllllllIlIIllIIllIlllIIIIl.getFadeInTime(), lllllllllllllIlIIllIIllIlllIIIIl.getDisplayTime(), lllllllllllllIlIIllIIllIlllIIIIl.getFadeOutTime());
    }
    
    @Override
    public void handleCustomPayload(final SPacketCustomPayload lllllllllllllIlIIllIIllIIlIlIlII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllIIlIlIlII, this, this.gameController);
        if ("MC|TrList".equals(lllllllllllllIlIIllIIllIIlIlIlII.getChannelName())) {
            final PacketBuffer lllllllllllllIlIIllIIllIIlIlIIll = lllllllllllllIlIIllIIllIIlIlIlII.getBufferData();
            try {
                final int lllllllllllllIlIIllIIllIIlIlIIlI = lllllllllllllIlIIllIIllIIlIlIIll.readInt();
                final GuiScreen lllllllllllllIlIIllIIllIIlIlIIIl = this.gameController.currentScreen;
                if (lllllllllllllIlIIllIIllIIlIlIIIl != null && lllllllllllllIlIIllIIllIIlIlIIIl instanceof GuiMerchant && lllllllllllllIlIIllIIllIIlIlIIlI == this.gameController.player.openContainer.windowId) {
                    final IMerchant lllllllllllllIlIIllIIllIIlIlIIII = ((GuiMerchant)lllllllllllllIlIIllIIllIIlIlIIIl).getMerchant();
                    final MerchantRecipeList lllllllllllllIlIIllIIllIIlIIllll = MerchantRecipeList.readFromBuf(lllllllllllllIlIIllIIllIIlIlIIll);
                    lllllllllllllIlIIllIIllIIlIlIIII.setRecipes(lllllllllllllIlIIllIIllIIlIIllll);
                }
            }
            catch (IOException lllllllllllllIlIIllIIllIIlIIlllI) {
                NetHandlerPlayClient.LOGGER.error("Couldn't load trade info", (Throwable)lllllllllllllIlIIllIIllIIlIIlllI);
                return;
            }
            finally {
                lllllllllllllIlIIllIIllIIlIlIIll.release();
            }
            lllllllllllllIlIIllIIllIIlIlIIll.release();
        }
        else if ("MC|Brand".equals(lllllllllllllIlIIllIIllIIlIlIlII.getChannelName())) {
            this.gameController.player.setServerBrand(lllllllllllllIlIIllIIllIIlIlIlII.getBufferData().readStringFromBuffer(32767));
        }
        else if ("MC|BOpen".equals(lllllllllllllIlIIllIIllIIlIlIlII.getChannelName())) {
            final EnumHand lllllllllllllIlIIllIIllIIlIIllIl = lllllllllllllIlIIllIIllIIlIlIlII.getBufferData().readEnumValue(EnumHand.class);
            final ItemStack lllllllllllllIlIIllIIllIIlIIllII = (lllllllllllllIlIIllIIllIIlIIllIl == EnumHand.OFF_HAND) ? this.gameController.player.getHeldItemOffhand() : this.gameController.player.getHeldItemMainhand();
            if (lllllllllllllIlIIllIIllIIlIIllII.getItem() == Items.WRITTEN_BOOK) {
                this.gameController.displayGuiScreen(new GuiScreenBook(this.gameController.player, lllllllllllllIlIIllIIllIIlIIllII, false));
            }
        }
        else if ("MC|DebugPath".equals(lllllllllllllIlIIllIIllIIlIlIlII.getChannelName())) {
            final PacketBuffer lllllllllllllIlIIllIIllIIlIIlIll = lllllllllllllIlIIllIIllIIlIlIlII.getBufferData();
            final int lllllllllllllIlIIllIIllIIlIIlIlI = lllllllllllllIlIIllIIllIIlIIlIll.readInt();
            final float lllllllllllllIlIIllIIllIIlIIlIIl = lllllllllllllIlIIllIIllIIlIIlIll.readFloat();
            final Path lllllllllllllIlIIllIIllIIlIIlIII = Path.read(lllllllllllllIlIIllIIllIIlIIlIll);
            ((DebugRendererPathfinding)this.gameController.debugRenderer.debugRendererPathfinding).addPath(lllllllllllllIlIIllIIllIIlIIlIlI, lllllllllllllIlIIllIIllIIlIIlIII, lllllllllllllIlIIllIIllIIlIIlIIl);
        }
        else if ("MC|DebugNeighborsUpdate".equals(lllllllllllllIlIIllIIllIIlIlIlII.getChannelName())) {
            final PacketBuffer lllllllllllllIlIIllIIllIIlIIIlll = lllllllllllllIlIIllIIllIIlIlIlII.getBufferData();
            final long lllllllllllllIlIIllIIllIIlIIIllI = lllllllllllllIlIIllIIllIIlIIIlll.readVarLong();
            final BlockPos lllllllllllllIlIIllIIllIIlIIIlIl = lllllllllllllIlIIllIIllIIlIIIlll.readBlockPos();
            ((DebugRendererNeighborsUpdate)this.gameController.debugRenderer.field_191557_f).func_191553_a(lllllllllllllIlIIllIIllIIlIIIllI, lllllllllllllIlIIllIIllIIlIIIlIl);
        }
        else if ("MC|StopSound".equals(lllllllllllllIlIIllIIllIIlIlIlII.getChannelName())) {
            final PacketBuffer lllllllllllllIlIIllIIllIIlIIIlII = lllllllllllllIlIIllIIllIIlIlIlII.getBufferData();
            final String lllllllllllllIlIIllIIllIIlIIIIll = lllllllllllllIlIIllIIllIIlIIIlII.readStringFromBuffer(32767);
            final String lllllllllllllIlIIllIIllIIlIIIIlI = lllllllllllllIlIIllIIllIIlIIIlII.readStringFromBuffer(256);
            this.gameController.getSoundHandler().stop(lllllllllllllIlIIllIIllIIlIIIIlI, SoundCategory.getByName(lllllllllllllIlIIllIIllIIlIIIIll));
        }
    }
    
    @Override
    public void handleCustomSound(final SPacketCustomSound lllllllllllllIlIIllIIllIlIIlllII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllIlIIlllII, this, this.gameController);
        this.gameController.getSoundHandler().playSound(new PositionedSoundRecord(new ResourceLocation(lllllllllllllIlIIllIIllIlIIlllII.getSoundName()), lllllllllllllIlIIllIIllIlIIlllII.getCategory(), lllllllllllllIlIIllIIllIlIIlllII.getVolume(), lllllllllllllIlIIllIIllIlIIlllII.getPitch(), false, 0, ISound.AttenuationType.LINEAR, (float)lllllllllllllIlIIllIIllIlIIlllII.getX(), (float)lllllllllllllIlIIllIIllIlIIlllII.getY(), (float)lllllllllllllIlIIllIIllIlIIlllII.getZ()));
    }
    
    @Override
    public void handleEntityMovement(final SPacketEntity lllllllllllllIlIIllIlIIlIIIlIllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIlIIIlIllI, this, this.gameController);
        final Entity lllllllllllllIlIIllIlIIlIIIlIlIl = lllllllllllllIlIIllIlIIlIIIlIllI.getEntity(this.clientWorldController);
        if (lllllllllllllIlIIllIlIIlIIIlIlIl != null) {
            final Entity entity = lllllllllllllIlIIllIlIIlIIIlIlIl;
            entity.serverPosX += lllllllllllllIlIIllIlIIlIIIlIllI.getX();
            final Entity entity2 = lllllllllllllIlIIllIlIIlIIIlIlIl;
            entity2.serverPosY += lllllllllllllIlIIllIlIIlIIIlIllI.getY();
            final Entity entity3 = lllllllllllllIlIIllIlIIlIIIlIlIl;
            entity3.serverPosZ += lllllllllllllIlIIllIlIIlIIIlIllI.getZ();
            final double lllllllllllllIlIIllIlIIlIIIlIlII = lllllllllllllIlIIllIlIIlIIIlIlIl.serverPosX / 4096.0;
            final double lllllllllllllIlIIllIlIIlIIIlIIll = lllllllllllllIlIIllIlIIlIIIlIlIl.serverPosY / 4096.0;
            final double lllllllllllllIlIIllIlIIlIIIlIIlI = lllllllllllllIlIIllIlIIlIIIlIlIl.serverPosZ / 4096.0;
            if (!lllllllllllllIlIIllIlIIlIIIlIlIl.canPassengerSteer()) {
                final float lllllllllllllIlIIllIlIIlIIIlIIIl = lllllllllllllIlIIllIlIIlIIIlIllI.isRotating() ? (lllllllllllllIlIIllIlIIlIIIlIllI.getYaw() * 360 / 256.0f) : lllllllllllllIlIIllIlIIlIIIlIlIl.rotationYaw;
                final float lllllllllllllIlIIllIlIIlIIIlIIII = lllllllllllllIlIIllIlIIlIIIlIllI.isRotating() ? (lllllllllllllIlIIllIlIIlIIIlIllI.getPitch() * 360 / 256.0f) : lllllllllllllIlIIllIlIIlIIIlIlIl.rotationPitch;
                lllllllllllllIlIIllIlIIlIIIlIlIl.setPositionAndRotationDirect(lllllllllllllIlIIllIlIIlIIIlIlII, lllllllllllllIlIIllIlIIlIIIlIIll, lllllllllllllIlIIllIlIIlIIIlIIlI, lllllllllllllIlIIllIlIIlIIIlIIIl, lllllllllllllIlIIllIlIIlIIIlIIII, 3, false);
                lllllllllllllIlIIllIlIIlIIIlIlIl.onGround = lllllllllllllIlIIllIlIIlIIIlIllI.getOnGround();
            }
        }
    }
    
    @Override
    public void handleCombatEvent(final SPacketCombatEvent lllllllllllllIlIIllIIlllIIIIlIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlllIIIIlIII, this, this.gameController);
        if (lllllllllllllIlIIllIIlllIIIIlIII.eventType == SPacketCombatEvent.Event.ENTITY_DIED) {
            final Entity lllllllllllllIlIIllIIlllIIIIIlll = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIlllIIIIlIII.playerId);
            if (lllllllllllllIlIIllIIlllIIIIIlll == this.gameController.player) {
                this.gameController.displayGuiScreen(new GuiGameOver(lllllllllllllIlIIllIIlllIIIIlIII.deathMessage));
            }
        }
    }
    
    @Override
    public void handleUseBed(final SPacketUseBed lllllllllllllIlIIllIlIIIIlllIllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIIlllIllI, this, this.gameController);
        lllllllllllllIlIIllIlIIIIlllIllI.getPlayer(this.clientWorldController).trySleep(lllllllllllllIlIIllIlIIIIlllIllI.getBedPosition());
    }
    
    @Override
    public void onDisconnect(final ITextComponent lllllllllllllIlIIllIlIIIlIlIIIlI) {
        this.gameController.loadWorld(null);
        if (this.guiScreenServer != null) {
            if (this.guiScreenServer instanceof GuiScreenRealmsProxy) {
                this.gameController.displayGuiScreen(new DisconnectedRealmsScreen(((GuiScreenRealmsProxy)this.guiScreenServer).getProxy(), "disconnect.lost", lllllllllllllIlIIllIlIIIlIlIIIlI).getProxy());
            }
            else {
                this.gameController.displayGuiScreen(new GuiDisconnected(this.guiScreenServer, "disconnect.lost", lllllllllllllIlIIllIlIIIlIlIIIlI));
            }
        }
        else {
            this.gameController.displayGuiScreen(new GuiDisconnected(new GuiMultiplayer(new GuiMainMenu()), "disconnect.lost", lllllllllllllIlIIllIlIIIlIlIIIlI));
        }
    }
    
    static /* synthetic */ void access$4(final NetHandlerPlayClient lllllllllllllIlIIllIIlIllIIIlIII, final Minecraft lllllllllllllIlIIllIIlIllIIIIlll) {
        lllllllllllllIlIIllIIlIllIIIlIII.gameController = lllllllllllllIlIIllIIlIllIIIIlll;
    }
    
    @Override
    public void handleParticles(final SPacketParticles lllllllllllllIlIIllIIlIllllIlllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIllllIlllI, this, this.gameController);
        if (lllllllllllllIlIIllIIlIllllIlllI.getParticleCount() == 0) {
            final double lllllllllllllIlIIllIIlIllllIllIl = lllllllllllllIlIIllIIlIllllIlllI.getParticleSpeed() * lllllllllllllIlIIllIIlIllllIlllI.getXOffset();
            final double lllllllllllllIlIIllIIlIllllIllII = lllllllllllllIlIIllIIlIllllIlllI.getParticleSpeed() * lllllllllllllIlIIllIIlIllllIlllI.getYOffset();
            final double lllllllllllllIlIIllIIlIllllIlIll = lllllllllllllIlIIllIIlIllllIlllI.getParticleSpeed() * lllllllllllllIlIIllIIlIllllIlllI.getZOffset();
            try {
                this.clientWorldController.spawnParticle(lllllllllllllIlIIllIIlIllllIlllI.getParticleType(), lllllllllllllIlIIllIIlIllllIlllI.isLongDistance(), lllllllllllllIlIIllIIlIllllIlllI.getXCoordinate(), lllllllllllllIlIIllIIlIllllIlllI.getYCoordinate(), lllllllllllllIlIIllIIlIllllIlllI.getZCoordinate(), lllllllllllllIlIIllIIlIllllIllIl, lllllllllllllIlIIllIIlIllllIllII, lllllllllllllIlIIllIIlIllllIlIll, lllllllllllllIlIIllIIlIllllIlllI.getParticleArgs());
            }
            catch (Throwable lllllllllllllIlIIllIIlIllllIlIlI) {
                NetHandlerPlayClient.LOGGER.warn("Could not spawn particle effect {}", (Object)lllllllllllllIlIIllIIlIllllIlllI.getParticleType());
            }
        }
        else {
            for (int lllllllllllllIlIIllIIlIllllIlIIl = 0; lllllllllllllIlIIllIIlIllllIlIIl < lllllllllllllIlIIllIIlIllllIlllI.getParticleCount(); ++lllllllllllllIlIIllIIlIllllIlIIl) {
                final double lllllllllllllIlIIllIIlIllllIlIII = this.avRandomizer.nextGaussian() * lllllllllllllIlIIllIIlIllllIlllI.getXOffset();
                final double lllllllllllllIlIIllIIlIllllIIlll = this.avRandomizer.nextGaussian() * lllllllllllllIlIIllIIlIllllIlllI.getYOffset();
                final double lllllllllllllIlIIllIIlIllllIIllI = this.avRandomizer.nextGaussian() * lllllllllllllIlIIllIIlIllllIlllI.getZOffset();
                final double lllllllllllllIlIIllIIlIllllIIlIl = this.avRandomizer.nextGaussian() * lllllllllllllIlIIllIIlIllllIlllI.getParticleSpeed();
                final double lllllllllllllIlIIllIIlIllllIIlII = this.avRandomizer.nextGaussian() * lllllllllllllIlIIllIIlIllllIlllI.getParticleSpeed();
                final double lllllllllllllIlIIllIIlIllllIIIll = this.avRandomizer.nextGaussian() * lllllllllllllIlIIllIIlIllllIlllI.getParticleSpeed();
                try {
                    this.clientWorldController.spawnParticle(lllllllllllllIlIIllIIlIllllIlllI.getParticleType(), lllllllllllllIlIIllIIlIllllIlllI.isLongDistance(), lllllllllllllIlIIllIIlIllllIlllI.getXCoordinate() + lllllllllllllIlIIllIIlIllllIlIII, lllllllllllllIlIIllIIlIllllIlllI.getYCoordinate() + lllllllllllllIlIIllIIlIllllIIlll, lllllllllllllIlIIllIIlIllllIlllI.getZCoordinate() + lllllllllllllIlIIllIIlIllllIIllI, lllllllllllllIlIIllIIlIllllIIlIl, lllllllllllllIlIIllIIlIllllIIlII, lllllllllllllIlIIllIIlIllllIIIll, lllllllllllllIlIIllIIlIllllIlllI.getParticleArgs());
                }
                catch (Throwable lllllllllllllIlIIllIIlIllllIIIlI) {
                    NetHandlerPlayClient.LOGGER.warn("Could not spawn particle effect {}", (Object)lllllllllllllIlIIllIIlIllllIlllI.getParticleType());
                    return;
                }
            }
        }
    }
    
    @Override
    public void handleChunkData(final SPacketChunkData lllllllllllllIlIIllIlIIIlIllllIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIlIllllIl, this, this.gameController);
        if (lllllllllllllIlIIllIlIIIlIllllIl.doChunkLoad()) {
            this.clientWorldController.doPreChunk(lllllllllllllIlIIllIlIIIlIllllIl.getChunkX(), lllllllllllllIlIIllIlIIIlIllllIl.getChunkZ(), true);
        }
        this.clientWorldController.invalidateBlockReceiveRegion(lllllllllllllIlIIllIlIIIlIllllIl.getChunkX() << 4, 0, lllllllllllllIlIIllIlIIIlIllllIl.getChunkZ() << 4, (lllllllllllllIlIIllIlIIIlIllllIl.getChunkX() << 4) + 15, 256, (lllllllllllllIlIIllIlIIIlIllllIl.getChunkZ() << 4) + 15);
        final Chunk lllllllllllllIlIIllIlIIIllIIIIlI = this.clientWorldController.getChunkFromChunkCoords(lllllllllllllIlIIllIlIIIlIllllIl.getChunkX(), lllllllllllllIlIIllIlIIIlIllllIl.getChunkZ());
        lllllllllllllIlIIllIlIIIllIIIIlI.fillChunk(lllllllllllllIlIIllIlIIIlIllllIl.getReadBuffer(), lllllllllllllIlIIllIlIIIlIllllIl.getExtractedSize(), lllllllllllllIlIIllIlIIIlIllllIl.doChunkLoad());
        this.clientWorldController.markBlockRangeForRenderUpdate(lllllllllllllIlIIllIlIIIlIllllIl.getChunkX() << 4, 0, lllllllllllllIlIIllIlIIIlIllllIl.getChunkZ() << 4, (lllllllllllllIlIIllIlIIIlIllllIl.getChunkX() << 4) + 15, 256, (lllllllllllllIlIIllIlIIIlIllllIl.getChunkZ() << 4) + 15);
        if (!lllllllllllllIlIIllIlIIIlIllllIl.doChunkLoad() || !(this.clientWorldController.provider instanceof WorldProviderSurface)) {
            lllllllllllllIlIIllIlIIIllIIIIlI.resetRelightChecks();
        }
        for (final NBTTagCompound lllllllllllllIlIIllIlIIIllIIIIIl : lllllllllllllIlIIllIlIIIlIllllIl.getTileEntityTags()) {
            final BlockPos lllllllllllllIlIIllIlIIIllIIIIII = new BlockPos(lllllllllllllIlIIllIlIIIllIIIIIl.getInteger("x"), lllllllllllllIlIIllIlIIIllIIIIIl.getInteger("y"), lllllllllllllIlIIllIlIIIllIIIIIl.getInteger("z"));
            final TileEntity lllllllllllllIlIIllIlIIIlIllllll = this.clientWorldController.getTileEntity(lllllllllllllIlIIllIlIIIllIIIIII);
            if (lllllllllllllIlIIllIlIIIlIllllll != null) {
                lllllllllllllIlIIllIlIIIlIllllll.readFromNBT(lllllllllllllIlIIllIlIIIllIIIIIl);
            }
        }
    }
    
    @Override
    public void handleBlockAction(final SPacketBlockAction lllllllllllllIlIIllIIllllIIIIlII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllllIIIIlII, this, this.gameController);
        this.gameController.world.addBlockEvent(lllllllllllllIlIIllIIllllIIIIlII.getBlockPosition(), lllllllllllllIlIIllIIllllIIIIlII.getBlockType(), lllllllllllllIlIIllIIllllIIIIlII.getData1(), lllllllllllllIlIIllIIllllIIIIlII.getData2());
    }
    
    @Override
    public void handleChat(final SPacketChat lllllllllllllIlIIllIlIIIlIIIlIlI) {
        if (ModuleManager.onReceiveChatMessage(lllllllllllllIlIIllIlIIIlIIIlIlI)) {
            PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIlIIIlIlI, this, this.gameController);
            this.gameController.ingameGUI.func_191742_a(lllllllllllllIlIIllIlIIIlIIIlIlI.func_192590_c(), lllllllllllllIlIIllIlIIIlIIIlIlI.getChatComponent());
        }
    }
    
    @Override
    public void handleWindowItems(final SPacketWindowItems lllllllllllllIlIIllIIllllIlllllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllllIlllllI, this, this.gameController);
        final EntityPlayer lllllllllllllIlIIllIIllllIllllIl = this.gameController.player;
        if (lllllllllllllIlIIllIIllllIlllllI.getWindowId() == 0) {
            lllllllllllllIlIIllIIllllIllllIl.inventoryContainer.func_190896_a(lllllllllllllIlIIllIIllllIlllllI.getItemStacks());
        }
        else if (lllllllllllllIlIIllIIllllIlllllI.getWindowId() == lllllllllllllIlIIllIIllllIllllIl.openContainer.windowId) {
            lllllllllllllIlIIllIIllllIllllIl.openContainer.func_190896_a(lllllllllllllIlIIllIIllllIlllllI.getItemStacks());
        }
    }
    
    @Override
    public void handleKeepAlive(final SPacketKeepAlive lllllllllllllIlIIllIIllIlIlllIlI) {
        this.sendPacket(new CPacketKeepAlive(lllllllllllllIlIIllIIllIlIlllIlI.getId()));
    }
    
    @Override
    public void handleDestroyEntities(final SPacketDestroyEntities lllllllllllllIlIIllIlIIIllllIlII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIllllIlII, this, this.gameController);
        for (int lllllllllllllIlIIllIlIIIllllIllI = 0; lllllllllllllIlIIllIlIIIllllIllI < lllllllllllllIlIIllIlIIIllllIlII.getEntityIDs().length; ++lllllllllllllIlIIllIlIIIllllIllI) {
            this.clientWorldController.removeEntityFromWorld(lllllllllllllIlIIllIlIIIllllIlII.getEntityIDs()[lllllllllllllIlIIllIlIIIllllIllI]);
        }
    }
    
    @Override
    public void handleEntityProperties(final SPacketEntityProperties lllllllllllllIlIIllIIlIlllIIIIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIlllIIIIll, this, this.gameController);
        final Entity lllllllllllllIlIIllIIlIlllIIlIIl = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIlIlllIIIIll.getEntityId());
        if (lllllllllllllIlIIllIIlIlllIIlIIl != null) {
            if (!(lllllllllllllIlIIllIIlIlllIIlIIl instanceof EntityLivingBase)) {
                throw new IllegalStateException(String.valueOf(new StringBuilder("Server tried to update attributes of a non-living entity (actually: ").append(lllllllllllllIlIIllIIlIlllIIlIIl).append(")")));
            }
            final AbstractAttributeMap lllllllllllllIlIIllIIlIlllIIlIII = ((EntityLivingBase)lllllllllllllIlIIllIIlIlllIIlIIl).getAttributeMap();
            for (final SPacketEntityProperties.Snapshot lllllllllllllIlIIllIIlIlllIIIlll : lllllllllllllIlIIllIIlIlllIIIIll.getSnapshots()) {
                IAttributeInstance lllllllllllllIlIIllIIlIlllIIIllI = lllllllllllllIlIIllIIlIlllIIlIII.getAttributeInstanceByName(lllllllllllllIlIIllIIlIlllIIIlll.getName());
                if (lllllllllllllIlIIllIIlIlllIIIllI == null) {
                    lllllllllllllIlIIllIIlIlllIIIllI = lllllllllllllIlIIllIIlIlllIIlIII.registerAttribute(new RangedAttribute(null, lllllllllllllIlIIllIIlIlllIIIlll.getName(), 0.0, Double.MIN_NORMAL, Double.MAX_VALUE));
                }
                lllllllllllllIlIIllIIlIlllIIIllI.setBaseValue(lllllllllllllIlIIllIIlIlllIIIlll.getBaseValue());
                lllllllllllllIlIIllIIlIlllIIIllI.removeAllModifiers();
                for (final AttributeModifier lllllllllllllIlIIllIIlIlllIIIlIl : lllllllllllllIlIIllIIlIlllIIIlll.getModifiers()) {
                    lllllllllllllIlIIllIIlIlllIIIllI.applyModifier(lllllllllllllIlIIllIIlIlllIIIlIl);
                }
            }
        }
    }
    
    @Override
    public void handleBlockBreakAnim(final SPacketBlockBreakAnim lllllllllllllIlIIllIIllllIIIIIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllllIIIIIII, this, this.gameController);
        this.gameController.world.sendBlockBreakProgress(lllllllllllllIlIIllIIllllIIIIIII.getBreakerId(), lllllllllllllIlIIllIIllllIIIIIII.getPosition(), lllllllllllllIlIIllIIllllIIIIIII.getProgress());
    }
    
    @Override
    public void handleUpdateHealth(final SPacketUpdateHealth lllllllllllllIlIIllIlIIIIIIIlIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIIIIIlIlI, this, this.gameController);
        this.gameController.player.setPlayerSPHealth(lllllllllllllIlIIllIlIIIIIIIlIlI.getHealth());
        this.gameController.player.getFoodStats().setFoodLevel(lllllllllllllIlIIllIlIIIIIIIlIlI.getFoodLevel());
        this.gameController.player.getFoodStats().setFoodSaturationLevel(lllllllllllllIlIIllIlIIIIIIIlIlI.getSaturationLevel());
    }
    
    @Override
    public void handleRemoveEntityEffect(final SPacketRemoveEntityEffect lllllllllllllIlIIllIIllIllIlIIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllIllIlIIlI, this, this.gameController);
        final Entity lllllllllllllIlIIllIIllIllIlIIIl = lllllllllllllIlIIllIIllIllIlIIlI.getEntity(this.clientWorldController);
        if (lllllllllllllIlIIllIIllIllIlIIIl instanceof EntityLivingBase) {
            ((EntityLivingBase)lllllllllllllIlIIllIIllIllIlIIIl).removeActivePotionEffect(lllllllllllllIlIIllIIllIllIlIIlI.getPotion());
        }
    }
    
    @Override
    public void handleHeldItemChange(final SPacketHeldItemChange lllllllllllllIlIIllIlIIlIIlIIIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIlIIlIIIII, this, this.gameController);
        if (InventoryPlayer.isHotbar(lllllllllllllIlIIllIlIIlIIlIIIII.getHeldItemHotbarIndex())) {
            this.gameController.player.inventory.currentItem = lllllllllllllIlIIllIlIIlIIlIIIII.getHeldItemHotbarIndex();
        }
    }
    
    @Override
    public void handleSetExperience(final SPacketSetExperience lllllllllllllIlIIllIlIIIIIIIIlII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIIIIIIlII, this, this.gameController);
        this.gameController.player.setXPStats(lllllllllllllIlIIllIlIIIIIIIIlII.getExperienceBar(), lllllllllllllIlIIllIlIIIIIIIIlII.getTotalExperience(), lllllllllllllIlIIllIlIIIIIIIIlII.getLevel());
    }
    
    public void sendPacket(final Packet<?> lllllllllllllIlIIllIlIIIlIIllIlI) {
        this.netManager.sendPacket(lllllllllllllIlIIllIlIIIlIIllIlI);
    }
    
    @Override
    public void func_194022_a(final SPacketSelectAdvancementsTab lllllllllllllIlIIllIIlllIlIIIIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlllIlIIIIIl, this, this.gameController);
        final ResourceLocation lllllllllllllIlIIllIIlllIlIIIlII = lllllllllllllIlIIllIIlllIlIIIIIl.func_194154_a();
        if (lllllllllllllIlIIllIIlllIlIIIlII == null) {
            this.field_191983_k.func_194230_a(null, false);
        }
        else {
            final Advancement lllllllllllllIlIIllIIlllIlIIIIll = this.field_191983_k.func_194229_a().func_192084_a(lllllllllllllIlIIllIIlllIlIIIlII);
            this.field_191983_k.func_194230_a(lllllllllllllIlIIllIIlllIlIIIIll, false);
        }
    }
    
    @Override
    public void handleSoundEffect(final SPacketSoundEffect lllllllllllllIlIIllIIllIlIlIIlII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllIlIlIIlII, this, this.gameController);
        this.gameController.world.playSound(this.gameController.player, lllllllllllllIlIIllIIllIlIlIIlII.getX(), lllllllllllllIlIIllIIllIlIlIIlII.getY(), lllllllllllllIlIIllIIllIlIlIIlII.getZ(), lllllllllllllIlIIllIIllIlIlIIlII.getSound(), lllllllllllllIlIIllIIllIlIlIIlII.getCategory(), lllllllllllllIlIIllIIllIlIlIIlII.getVolume(), lllllllllllllIlIIllIIllIlIlIIlII.getPitch());
    }
    
    @Override
    public void handleExplosion(final SPacketExplosion lllllllllllllIlIIllIIlllllllIIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlllllllIIll, this, this.gameController);
        final Explosion lllllllllllllIlIIllIIlllllllIlIl = new Explosion(this.gameController.world, null, lllllllllllllIlIIllIIlllllllIIll.getX(), lllllllllllllIlIIllIIlllllllIIll.getY(), lllllllllllllIlIIllIIlllllllIIll.getZ(), lllllllllllllIlIIllIIlllllllIIll.getStrength(), lllllllllllllIlIIllIIlllllllIIll.getAffectedBlockPositions());
        lllllllllllllIlIIllIIlllllllIlIl.doExplosionB(true);
        final EntityPlayerSP player = this.gameController.player;
        player.motionX += lllllllllllllIlIIllIIlllllllIIll.getMotionX();
        final EntityPlayerSP player2 = this.gameController.player;
        player2.motionY += lllllllllllllIlIIllIIlllllllIIll.getMotionY();
        final EntityPlayerSP player3 = this.gameController.player;
        player3.motionZ += lllllllllllllIlIIllIIlllllllIIll.getMotionZ();
    }
    
    public ClientAdvancementManager func_191982_f() {
        return this.field_191983_k;
    }
    
    @Override
    public void handleSpawnPlayer(final SPacketSpawnPlayer lllllllllllllIlIIllIlIIlIlIIIlIl) {
        if (lllllllllllllIlIIllIlIIlIlIIIlIl != null) {
            PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIlIlIIIlIl, this, this.gameController);
            final double lllllllllllllIlIIllIlIIlIlIIllIl = lllllllllllllIlIIllIlIIlIlIIIlIl.getX();
            final double lllllllllllllIlIIllIlIIlIlIIllII = lllllllllllllIlIIllIlIIlIlIIIlIl.getY();
            final double lllllllllllllIlIIllIlIIlIlIIlIll = lllllllllllllIlIIllIlIIlIlIIIlIl.getZ();
            final float lllllllllllllIlIIllIlIIlIlIIlIlI = lllllllllllllIlIIllIlIIlIlIIIlIl.getYaw() * 360 / 256.0f;
            final float lllllllllllllIlIIllIlIIlIlIIlIIl = lllllllllllllIlIIllIlIIlIlIIIlIl.getPitch() * 360 / 256.0f;
            final EntityOtherPlayerMP lllllllllllllIlIIllIlIIlIlIIlIII = new EntityOtherPlayerMP(this.gameController.world, this.getPlayerInfo(lllllllllllllIlIIllIlIIlIlIIIlIl.getUniqueId()).getGameProfile());
            lllllllllllllIlIIllIlIIlIlIIlIII.prevPosX = lllllllllllllIlIIllIlIIlIlIIllIl;
            lllllllllllllIlIIllIlIIlIlIIlIII.lastTickPosX = lllllllllllllIlIIllIlIIlIlIIllIl;
            lllllllllllllIlIIllIlIIlIlIIlIII.prevPosY = lllllllllllllIlIIllIlIIlIlIIllII;
            lllllllllllllIlIIllIlIIlIlIIlIII.lastTickPosY = lllllllllllllIlIIllIlIIlIlIIllII;
            lllllllllllllIlIIllIlIIlIlIIlIII.prevPosZ = lllllllllllllIlIIllIlIIlIlIIlIll;
            lllllllllllllIlIIllIlIIlIlIIlIII.lastTickPosZ = lllllllllllllIlIIllIlIIlIlIIlIll;
            EntityTracker.updateServerPosition(lllllllllllllIlIIllIlIIlIlIIlIII, lllllllllllllIlIIllIlIIlIlIIllIl, lllllllllllllIlIIllIlIIlIlIIllII, lllllllllllllIlIIllIlIIlIlIIlIll);
            lllllllllllllIlIIllIlIIlIlIIlIII.setPositionAndRotation(lllllllllllllIlIIllIlIIlIlIIllIl, lllllllllllllIlIIllIlIIlIlIIllII, lllllllllllllIlIIllIlIIlIlIIlIll, lllllllllllllIlIIllIlIIlIlIIlIlI, lllllllllllllIlIIllIlIIlIlIIlIIl);
            this.clientWorldController.addEntityToWorld(lllllllllllllIlIIllIlIIlIlIIIlIl.getEntityID(), lllllllllllllIlIIllIlIIlIlIIlIII);
            final List<EntityDataManager.DataEntry<?>> lllllllllllllIlIIllIlIIlIlIIIlll = lllllllllllllIlIIllIlIIlIlIIIlIl.getDataManagerEntries();
            if (lllllllllllllIlIIllIlIIlIlIIIlll != null) {
                lllllllllllllIlIIllIlIIlIlIIlIII.getDataManager().setEntryValues(lllllllllllllIlIIllIlIIlIlIIIlll);
            }
        }
    }
    
    @Override
    public void handlePlayerListItem(final SPacketPlayerListItem lllllllllllllIlIIllIIllIllIIIIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllIllIIIIll, this, this.gameController);
        for (final SPacketPlayerListItem.AddPlayerData lllllllllllllIlIIllIIllIllIIIllI : lllllllllllllIlIIllIIllIllIIIIll.getEntries()) {
            if (lllllllllllllIlIIllIIllIllIIIIll.getAction() == SPacketPlayerListItem.Action.REMOVE_PLAYER) {
                this.playerInfoMap.remove(lllllllllllllIlIIllIIllIllIIIllI.getProfile().getId());
            }
            else {
                NetworkPlayerInfo lllllllllllllIlIIllIIllIllIIIlIl = this.playerInfoMap.get(lllllllllllllIlIIllIIllIllIIIllI.getProfile().getId());
                if (lllllllllllllIlIIllIIllIllIIIIll.getAction() == SPacketPlayerListItem.Action.ADD_PLAYER) {
                    lllllllllllllIlIIllIIllIllIIIlIl = new NetworkPlayerInfo(lllllllllllllIlIIllIIllIllIIIllI);
                    this.playerInfoMap.put(lllllllllllllIlIIllIIllIllIIIlIl.getGameProfile().getId(), lllllllllllllIlIIllIIllIllIIIlIl);
                }
                if (lllllllllllllIlIIllIIllIllIIIlIl == null) {
                    continue;
                }
                switch ($SWITCH_TABLE$net$minecraft$network$play$server$SPacketPlayerListItem$Action()[lllllllllllllIlIIllIIllIllIIIIll.getAction().ordinal()]) {
                    default: {
                        continue;
                    }
                    case 1: {
                        lllllllllllllIlIIllIIllIllIIIlIl.setGameType(lllllllllllllIlIIllIIllIllIIIllI.getGameMode());
                        lllllllllllllIlIIllIIllIllIIIlIl.setResponseTime(lllllllllllllIlIIllIIllIllIIIllI.getPing());
                        continue;
                    }
                    case 2: {
                        lllllllllllllIlIIllIIllIllIIIlIl.setGameType(lllllllllllllIlIIllIIllIllIIIllI.getGameMode());
                        continue;
                    }
                    case 3: {
                        lllllllllllllIlIIllIIllIllIIIlIl.setResponseTime(lllllllllllllIlIIllIIllIllIIIllI.getPing());
                        continue;
                    }
                    case 4: {
                        lllllllllllllIlIIllIIllIllIIIlIl.setDisplayName(lllllllllllllIlIIllIIllIllIIIllI.getDisplayName());
                        continue;
                    }
                }
            }
        }
    }
    
    @Override
    public void handleSpawnMob(final SPacketSpawnMob lllllllllllllIlIIllIlIIIIlIllIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIIlIllIII, this, this.gameController);
        final double lllllllllllllIlIIllIlIIIIllIIIll = lllllllllllllIlIIllIlIIIIlIllIII.getX();
        final double lllllllllllllIlIIllIlIIIIllIIIlI = lllllllllllllIlIIllIlIIIIlIllIII.getY();
        final double lllllllllllllIlIIllIlIIIIllIIIIl = lllllllllllllIlIIllIlIIIIlIllIII.getZ();
        final float lllllllllllllIlIIllIlIIIIllIIIII = lllllllllllllIlIIllIlIIIIlIllIII.getYaw() * 360 / 256.0f;
        final float lllllllllllllIlIIllIlIIIIlIlllll = lllllllllllllIlIIllIlIIIIlIllIII.getPitch() * 360 / 256.0f;
        final EntityLivingBase lllllllllllllIlIIllIlIIIIlIllllI = (EntityLivingBase)EntityList.createEntityByID(lllllllllllllIlIIllIlIIIIlIllIII.getEntityType(), this.gameController.world);
        if (lllllllllllllIlIIllIlIIIIlIllllI != null) {
            EntityTracker.updateServerPosition(lllllllllllllIlIIllIlIIIIlIllllI, lllllllllllllIlIIllIlIIIIllIIIll, lllllllllllllIlIIllIlIIIIllIIIlI, lllllllllllllIlIIllIlIIIIllIIIIl);
            lllllllllllllIlIIllIlIIIIlIllllI.renderYawOffset = lllllllllllllIlIIllIlIIIIlIllIII.getHeadPitch() * 360 / 256.0f;
            lllllllllllllIlIIllIlIIIIlIllllI.rotationYawHead = lllllllllllllIlIIllIlIIIIlIllIII.getHeadPitch() * 360 / 256.0f;
            final Entity[] lllllllllllllIlIIllIlIIIIlIlllIl = lllllllllllllIlIIllIlIIIIlIllllI.getParts();
            if (lllllllllllllIlIIllIlIIIIlIlllIl != null) {
                final int lllllllllllllIlIIllIlIIIIlIlllII = lllllllllllllIlIIllIlIIIIlIllIII.getEntityID() - lllllllllllllIlIIllIlIIIIlIllllI.getEntityId();
                final boolean lllllllllllllIlIIllIlIIIIlIIllII;
                final float lllllllllllllIlIIllIlIIIIlIIllIl = ((Entity[])(Object)(lllllllllllllIlIIllIlIIIIlIIllII = (boolean)(Object)lllllllllllllIlIIllIlIIIIlIlllIl)).length;
                for (double lllllllllllllIlIIllIlIIIIlIIlllI = 0; lllllllllllllIlIIllIlIIIIlIIlllI < lllllllllllllIlIIllIlIIIIlIIllIl; ++lllllllllllllIlIIllIlIIIIlIIlllI) {
                    final Entity lllllllllllllIlIIllIlIIIIlIllIll = lllllllllllllIlIIllIlIIIIlIIllII[lllllllllllllIlIIllIlIIIIlIIlllI];
                    lllllllllllllIlIIllIlIIIIlIllIll.setEntityId(lllllllllllllIlIIllIlIIIIlIllIll.getEntityId() + lllllllllllllIlIIllIlIIIIlIlllII);
                }
            }
            lllllllllllllIlIIllIlIIIIlIllllI.setEntityId(lllllllllllllIlIIllIlIIIIlIllIII.getEntityID());
            lllllllllllllIlIIllIlIIIIlIllllI.setUniqueId(lllllllllllllIlIIllIlIIIIlIllIII.getUniqueId());
            lllllllllllllIlIIllIlIIIIlIllllI.setPositionAndRotation(lllllllllllllIlIIllIlIIIIllIIIll, lllllllllllllIlIIllIlIIIIllIIIlI, lllllllllllllIlIIllIlIIIIllIIIIl, lllllllllllllIlIIllIlIIIIllIIIII, lllllllllllllIlIIllIlIIIIlIlllll);
            lllllllllllllIlIIllIlIIIIlIllllI.motionX = lllllllllllllIlIIllIlIIIIlIllIII.getVelocityX() / 8000.0f;
            lllllllllllllIlIIllIlIIIIlIllllI.motionY = lllllllllllllIlIIllIlIIIIlIllIII.getVelocityY() / 8000.0f;
            lllllllllllllIlIIllIlIIIIlIllllI.motionZ = lllllllllllllIlIIllIlIIIIlIllIII.getVelocityZ() / 8000.0f;
            this.clientWorldController.addEntityToWorld(lllllllllllllIlIIllIlIIIIlIllIII.getEntityID(), lllllllllllllIlIIllIlIIIIlIllllI);
            final List<EntityDataManager.DataEntry<?>> lllllllllllllIlIIllIlIIIIlIllIlI = lllllllllllllIlIIllIlIIIIlIllIII.getDataManagerEntries();
            if (lllllllllllllIlIIllIlIIIIlIllIlI != null) {
                lllllllllllllIlIIllIlIIIIlIllllI.getDataManager().setEntryValues(lllllllllllllIlIIllIlIIIIlIllIlI);
            }
        }
        else {
            NetHandlerPlayClient.LOGGER.warn("Skipping Entity with id {}", (Object)lllllllllllllIlIIllIlIIIIlIllIII.getEntityType());
        }
    }
    
    @Override
    public void handleStatistics(final SPacketStatistics lllllllllllllIlIIllIIlllIIllIlll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlllIIllIlll, this, this.gameController);
        for (final Map.Entry<StatBase, Integer> lllllllllllllIlIIllIIlllIIllIllI : lllllllllllllIlIIllIIlllIIllIlll.getStatisticMap().entrySet()) {
            final StatBase lllllllllllllIlIIllIIlllIIllIlIl = lllllllllllllIlIIllIIlllIIllIllI.getKey();
            final int lllllllllllllIlIIllIIlllIIllIlII = lllllllllllllIlIIllIIlllIIllIllI.getValue();
            this.gameController.player.getStatFileWriter().unlockAchievement(this.gameController.player, lllllllllllllIlIIllIIlllIIllIlIl, lllllllllllllIlIIllIIlllIIllIlII);
        }
        this.hasStatistics = true;
        if (this.gameController.currentScreen instanceof IProgressMeter) {
            ((IProgressMeter)this.gameController.currentScreen).func_193026_g();
        }
    }
    
    @Override
    public void handleEntityStatus(final SPacketEntityStatus lllllllllllllIlIIllIlIIIIIIlIllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIIIIlIllI, this, this.gameController);
        final Entity lllllllllllllIlIIllIlIIIIIIlIlIl = lllllllllllllIlIIllIlIIIIIIlIllI.getEntity(this.clientWorldController);
        if (lllllllllllllIlIIllIlIIIIIIlIlIl != null) {
            if (lllllllllllllIlIIllIlIIIIIIlIllI.getOpCode() == 21) {
                this.gameController.getSoundHandler().playSound(new GuardianSound((EntityGuardian)lllllllllllllIlIIllIlIIIIIIlIlIl));
            }
            else if (lllllllllllllIlIIllIlIIIIIIlIllI.getOpCode() == 35) {
                final int lllllllllllllIlIIllIlIIIIIIlIlII = 40;
                this.gameController.effectRenderer.func_191271_a(lllllllllllllIlIIllIlIIIIIIlIlIl, EnumParticleTypes.TOTEM, 30);
                this.clientWorldController.playSound(lllllllllllllIlIIllIlIIIIIIlIlIl.posX, lllllllllllllIlIIllIlIIIIIIlIlIl.posY, lllllllllllllIlIIllIlIIIIIIlIlIl.posZ, SoundEvents.field_191263_gW, lllllllllllllIlIIllIlIIIIIIlIlIl.getSoundCategory(), 1.0f, 1.0f, false);
                if (lllllllllllllIlIIllIlIIIIIIlIlIl == this.gameController.player) {
                    this.gameController.entityRenderer.func_190565_a(new ItemStack(Items.field_190929_cY));
                }
            }
            else {
                lllllllllllllIlIIllIlIIIIIIlIlIl.handleStatusUpdate(lllllllllllllIlIIllIlIIIIIIlIllI.getOpCode());
            }
        }
    }
    
    @Override
    public void handleServerDifficulty(final SPacketServerDifficulty lllllllllllllIlIIllIIllIlllllllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllIlllllllI, this, this.gameController);
        this.gameController.world.getWorldInfo().setDifficulty(lllllllllllllIlIIllIIllIlllllllI.getDifficulty());
        this.gameController.world.getWorldInfo().setDifficultyLocked(lllllllllllllIlIIllIIllIlllllllI.isDifficultyLocked());
    }
    
    @Override
    public void processChunkUnload(final SPacketUnloadChunk lllllllllllllIlIIllIlIIIlIllIlII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIlIllIlII, this, this.gameController);
        this.clientWorldController.doPreChunk(lllllllllllllIlIIllIlIIIlIllIlII.getX(), lllllllllllllIlIIllIlIIIlIllIlII.getZ(), false);
    }
    
    @Override
    public void handleCooldown(final SPacketCooldown lllllllllllllIlIIllIIllIIllIlIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllIIllIlIIl, this, this.gameController);
        if (lllllllllllllIlIIllIIllIIllIlIIl.getTicks() == 0) {
            this.gameController.player.getCooldownTracker().removeCooldown(lllllllllllllIlIIllIIllIIllIlIIl.getItem());
        }
        else {
            this.gameController.player.getCooldownTracker().setCooldown(lllllllllllllIlIIllIIllIIllIlIIl.getItem(), lllllllllllllIlIIllIIllIIllIlIIl.getTicks());
        }
    }
    
    @Override
    public void handleUpdateEntityNBT(final SPacketUpdateBossInfo lllllllllllllIlIIllIIllIIllIllIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllIIllIllIl, this, this.gameController);
        this.gameController.ingameGUI.getBossOverlay().read(lllllllllllllIlIIllIIllIIllIllIl);
    }
    
    public void cleanup() {
        this.clientWorldController = null;
    }
    
    @Override
    public void handleChangeGameState(final SPacketChangeGameState lllllllllllllIlIIllIIlllIllIlllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlllIllIlllI, this, this.gameController);
        final EntityPlayer lllllllllllllIlIIllIIlllIlllIlII = this.gameController.player;
        final int lllllllllllllIlIIllIIlllIlllIIll = lllllllllllllIlIIllIIlllIllIlllI.getGameState();
        final float lllllllllllllIlIIllIIlllIlllIIlI = lllllllllllllIlIIllIIlllIllIlllI.getValue();
        final int lllllllllllllIlIIllIIlllIlllIIIl = MathHelper.floor(lllllllllllllIlIIllIIlllIlllIIlI + 0.5f);
        if (lllllllllllllIlIIllIIlllIlllIIll >= 0 && lllllllllllllIlIIllIIlllIlllIIll < SPacketChangeGameState.MESSAGE_NAMES.length && SPacketChangeGameState.MESSAGE_NAMES[lllllllllllllIlIIllIIlllIlllIIll] != null) {
            lllllllllllllIlIIllIIlllIlllIlII.addChatComponentMessage(new TextComponentTranslation(SPacketChangeGameState.MESSAGE_NAMES[lllllllllllllIlIIllIIlllIlllIIll], new Object[0]), false);
        }
        if (lllllllllllllIlIIllIIlllIlllIIll == 1) {
            this.clientWorldController.getWorldInfo().setRaining(true);
            this.clientWorldController.setRainStrength(0.0f);
        }
        else if (lllllllllllllIlIIllIIlllIlllIIll == 2) {
            this.clientWorldController.getWorldInfo().setRaining(false);
            this.clientWorldController.setRainStrength(1.0f);
        }
        else if (lllllllllllllIlIIllIIlllIlllIIll == 3) {
            this.gameController.playerController.setGameType(GameType.getByID(lllllllllllllIlIIllIIlllIlllIIIl));
        }
        else if (lllllllllllllIlIIllIIlllIlllIIll == 4) {
            if (lllllllllllllIlIIllIIlllIlllIIIl == 0) {
                this.gameController.player.connection.sendPacket(new CPacketClientStatus(CPacketClientStatus.State.PERFORM_RESPAWN));
                this.gameController.displayGuiScreen(new GuiDownloadTerrain());
            }
            else if (lllllllllllllIlIIllIIlllIlllIIIl == 1) {
                this.gameController.displayGuiScreen(new GuiWinGame(true, () -> this.gameController.player.connection.sendPacket(new CPacketClientStatus(CPacketClientStatus.State.PERFORM_RESPAWN))));
            }
        }
        else if (lllllllllllllIlIIllIIlllIlllIIll == 5) {
            final GameSettings lllllllllllllIlIIllIIlllIlllIIII = this.gameController.gameSettings;
            if (lllllllllllllIlIIllIIlllIlllIIlI == 0.0f) {
                this.gameController.displayGuiScreen(new GuiScreenDemo());
            }
            else if (lllllllllllllIlIIllIIlllIlllIIlI == 101.0f) {
                this.gameController.ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("demo.help.movement", new Object[] { GameSettings.getKeyDisplayString(lllllllllllllIlIIllIIlllIlllIIII.keyBindForward.getKeyCode()), GameSettings.getKeyDisplayString(lllllllllllllIlIIllIIlllIlllIIII.keyBindLeft.getKeyCode()), GameSettings.getKeyDisplayString(lllllllllllllIlIIllIIlllIlllIIII.keyBindBack.getKeyCode()), GameSettings.getKeyDisplayString(lllllllllllllIlIIllIIlllIlllIIII.keyBindRight.getKeyCode()) }));
            }
            else if (lllllllllllllIlIIllIIlllIlllIIlI == 102.0f) {
                this.gameController.ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("demo.help.jump", new Object[] { GameSettings.getKeyDisplayString(lllllllllllllIlIIllIIlllIlllIIII.keyBindJump.getKeyCode()) }));
            }
            else if (lllllllllllllIlIIllIIlllIlllIIlI == 103.0f) {
                this.gameController.ingameGUI.getChatGUI().printChatMessage(new TextComponentTranslation("demo.help.inventory", new Object[] { GameSettings.getKeyDisplayString(lllllllllllllIlIIllIIlllIlllIIII.keyBindInventory.getKeyCode()) }));
            }
        }
        else if (lllllllllllllIlIIllIIlllIlllIIll == 6) {
            this.clientWorldController.playSound(lllllllllllllIlIIllIIlllIlllIlII, lllllllllllllIlIIllIIlllIlllIlII.posX, lllllllllllllIlIIllIIlllIlllIlII.posY + lllllllllllllIlIIllIIlllIlllIlII.getEyeHeight(), lllllllllllllIlIIllIIlllIlllIlII.posZ, SoundEvents.ENTITY_ARROW_HIT_PLAYER, SoundCategory.PLAYERS, 0.18f, 0.45f);
        }
        else if (lllllllllllllIlIIllIIlllIlllIIll == 7) {
            this.clientWorldController.setRainStrength(lllllllllllllIlIIllIIlllIlllIIlI);
        }
        else if (lllllllllllllIlIIllIIlllIlllIIll == 8) {
            this.clientWorldController.setThunderStrength(lllllllllllllIlIIllIIlllIlllIIlI);
        }
        else if (lllllllllllllIlIIllIIlllIlllIIll == 10) {
            this.clientWorldController.spawnParticle(EnumParticleTypes.MOB_APPEARANCE, lllllllllllllIlIIllIIlllIlllIlII.posX, lllllllllllllIlIIllIIlllIlllIlII.posY, lllllllllllllIlIIllIIlllIlllIlII.posZ, 0.0, 0.0, 0.0, new int[0]);
            this.clientWorldController.playSound(lllllllllllllIlIIllIIlllIlllIlII, lllllllllllllIlIIllIIlllIlllIlII.posX, lllllllllllllIlIIllIIlllIlllIlII.posY, lllllllllllllIlIIllIIlllIlllIlII.posZ, SoundEvents.ENTITY_ELDER_GUARDIAN_CURSE, SoundCategory.HOSTILE, 1.0f, 1.0f);
        }
    }
    
    @Override
    public void handleEntityEffect(final SPacketEntityEffect lllllllllllllIlIIllIIlllIIIlIIII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlllIIIlIIII, this, this.gameController);
        final Entity lllllllllllllIlIIllIIlllIIIlIlII = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIIlllIIIlIIII.getEntityId());
        if (lllllllllllllIlIIllIIlllIIIlIlII instanceof EntityLivingBase) {
            final Potion lllllllllllllIlIIllIIlllIIIlIIll = Potion.getPotionById(lllllllllllllIlIIllIIlllIIIlIIII.getEffectId());
            if (lllllllllllllIlIIllIIlllIIIlIIll != null) {
                final PotionEffect lllllllllllllIlIIllIIlllIIIlIIlI = new PotionEffect(lllllllllllllIlIIllIIlllIIIlIIll, lllllllllllllIlIIllIIlllIIIlIIII.getDuration(), lllllllllllllIlIIllIIlllIIIlIIII.getAmplifier(), lllllllllllllIlIIllIIlllIIIlIIII.getIsAmbient(), lllllllllllllIlIIllIIlllIIIlIIII.doesShowParticles());
                lllllllllllllIlIIllIIlllIIIlIIlI.setPotionDurationMax(lllllllllllllIlIIllIIlllIIIlIIII.isMaxDuration());
                ((EntityLivingBase)lllllllllllllIlIIllIIlllIIIlIlII).addPotionEffect(lllllllllllllIlIIllIIlllIIIlIIlI);
            }
        }
    }
    
    @Override
    public void handleMaps(final SPacketMaps lllllllllllllIlIIllIIlllIlIllIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlllIlIllIll, this, this.gameController);
        final MapItemRenderer lllllllllllllIlIIllIIlllIllIIIII = this.gameController.entityRenderer.getMapItemRenderer();
        MapData lllllllllllllIlIIllIIlllIlIlllll = ItemMap.loadMapData(lllllllllllllIlIIllIIlllIlIllIll.getMapId(), this.gameController.world);
        if (lllllllllllllIlIIllIIlllIlIlllll == null) {
            final String lllllllllllllIlIIllIIlllIlIllllI = String.valueOf(new StringBuilder("map_").append(lllllllllllllIlIIllIIlllIlIllIll.getMapId()));
            lllllllllllllIlIIllIIlllIlIlllll = new MapData(lllllllllllllIlIIllIIlllIlIllllI);
            if (lllllllllllllIlIIllIIlllIllIIIII.func_191205_a(lllllllllllllIlIIllIIlllIlIllllI) != null) {
                final MapData lllllllllllllIlIIllIIlllIlIlllIl = lllllllllllllIlIIllIIlllIllIIIII.func_191207_a(lllllllllllllIlIIllIIlllIllIIIII.func_191205_a(lllllllllllllIlIIllIIlllIlIllllI));
                if (lllllllllllllIlIIllIIlllIlIlllIl != null) {
                    lllllllllllllIlIIllIIlllIlIlllll = lllllllllllllIlIIllIIlllIlIlllIl;
                }
            }
            this.gameController.world.setItemData(lllllllllllllIlIIllIIlllIlIllllI, lllllllllllllIlIIllIIlllIlIlllll);
        }
        lllllllllllllIlIIllIIlllIlIllIll.setMapdataTo(lllllllllllllIlIIllIIlllIlIlllll);
        lllllllllllllIlIIllIIlllIllIIIII.updateMapTexture(lllllllllllllIlIIllIIlllIlIlllll);
    }
    
    public NetworkPlayerInfo getPlayerInfo(final UUID lllllllllllllIlIIllIIlIllIlIIllI) {
        return this.playerInfoMap.get(lllllllllllllIlIIllIIlIllIlIIllI);
    }
    
    @Override
    public void handleEntityHeadLook(final SPacketEntityHeadLook lllllllllllllIlIIllIlIIIlllllllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIlllllllI, this, this.gameController);
        final Entity lllllllllllllIlIIllIlIIlIIIIIIIl = lllllllllllllIlIIllIlIIIlllllllI.getEntity(this.clientWorldController);
        if (lllllllllllllIlIIllIlIIlIIIIIIIl != null) {
            final float lllllllllllllIlIIllIlIIlIIIIIIII = lllllllllllllIlIIllIlIIIlllllllI.getYaw() * 360 / 256.0f;
            lllllllllllllIlIIllIlIIlIIIIIIIl.setRotationYawHead(lllllllllllllIlIIllIlIIlIIIIIIII);
        }
    }
    
    @Override
    public void handleCollectItem(final SPacketCollectItem lllllllllllllIlIIllIlIIIlIIlIlII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIlIIlIlII, this, this.gameController);
        final Entity lllllllllllllIlIIllIlIIIlIIlIIll = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIlIIIlIIlIlII.getCollectedItemEntityID());
        EntityLivingBase lllllllllllllIlIIllIlIIIlIIlIIlI = (EntityLivingBase)this.clientWorldController.getEntityByID(lllllllllllllIlIIllIlIIIlIIlIlII.getEntityID());
        if (lllllllllllllIlIIllIlIIIlIIlIIlI == null) {
            lllllllllllllIlIIllIlIIIlIIlIIlI = this.gameController.player;
        }
        if (lllllllllllllIlIIllIlIIIlIIlIIll != null) {
            if (lllllllllllllIlIIllIlIIIlIIlIIll instanceof EntityXPOrb) {
                this.clientWorldController.playSound(lllllllllllllIlIIllIlIIIlIIlIIll.posX, lllllllllllllIlIIllIlIIIlIIlIIll.posY, lllllllllllllIlIIllIlIIIlIIlIIll.posZ, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.1f, (this.avRandomizer.nextFloat() - this.avRandomizer.nextFloat()) * 0.35f + 0.9f, false);
            }
            else {
                this.clientWorldController.playSound(lllllllllllllIlIIllIlIIIlIIlIIll.posX, lllllllllllllIlIIllIlIIIlIIlIIll.posY, lllllllllllllIlIIllIlIIIlIIlIIll.posZ, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2f, (this.avRandomizer.nextFloat() - this.avRandomizer.nextFloat()) * 1.4f + 2.0f, false);
            }
            if (lllllllllllllIlIIllIlIIIlIIlIIll instanceof EntityItem) {
                ((EntityItem)lllllllllllllIlIIllIlIIIlIIlIIll).getEntityItem().func_190920_e(lllllllllllllIlIIllIlIIIlIIlIlII.func_191208_c());
            }
            this.gameController.effectRenderer.addEffect(new ParticleItemPickup(this.clientWorldController, lllllllllllllIlIIllIlIIIlIIlIIll, lllllllllllllIlIIllIlIIIlIIlIIlI, 0.5f));
            this.clientWorldController.removeEntityFromWorld(lllllllllllllIlIIllIlIIIlIIlIlII.getCollectedItemEntityID());
        }
    }
    
    @Override
    public void handleMoveVehicle(final SPacketMoveVehicle lllllllllllllIlIIllIIllIIllIIIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllIIllIIIlI, this, this.gameController);
        final Entity lllllllllllllIlIIllIIllIIllIIIIl = this.gameController.player.getLowestRidingEntity();
        if (lllllllllllllIlIIllIIllIIllIIIIl != this.gameController.player && lllllllllllllIlIIllIIllIIllIIIIl.canPassengerSteer()) {
            lllllllllllllIlIIllIIllIIllIIIIl.setPositionAndRotation(lllllllllllllIlIIllIIllIIllIIIlI.getX(), lllllllllllllIlIIllIIllIIllIIIlI.getY(), lllllllllllllIlIIllIIllIIllIIIlI.getZ(), lllllllllllllIlIIllIIllIIllIIIlI.getYaw(), lllllllllllllIlIIllIIllIIllIIIlI.getPitch());
            this.netManager.sendPacket(new CPacketVehicleMove(lllllllllllllIlIIllIIllIIllIIIIl));
        }
    }
    
    @Override
    public void handleRespawn(final SPacketRespawn lllllllllllllIlIIllIIlllllllllII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlllllllllII, this, this.gameController);
        if (lllllllllllllIlIIllIIlllllllllII.getDimensionID() != this.gameController.player.dimension) {
            this.doneLoadingTerrain = false;
            final Scoreboard lllllllllllllIlIIllIIllllllllllI = this.clientWorldController.getScoreboard();
            this.clientWorldController = new WorldClient(this, new WorldSettings(0L, lllllllllllllIlIIllIIlllllllllII.getGameType(), false, this.gameController.world.getWorldInfo().isHardcoreModeEnabled(), lllllllllllllIlIIllIIlllllllllII.getWorldType()), lllllllllllllIlIIllIIlllllllllII.getDimensionID(), lllllllllllllIlIIllIIlllllllllII.getDifficulty(), this.gameController.mcProfiler);
            this.clientWorldController.setWorldScoreboard(lllllllllllllIlIIllIIllllllllllI);
            this.gameController.loadWorld(this.clientWorldController);
            this.gameController.player.dimension = lllllllllllllIlIIllIIlllllllllII.getDimensionID();
            this.gameController.displayGuiScreen(new GuiDownloadTerrain());
        }
        this.gameController.setDimensionAndSpawnPlayer(lllllllllllllIlIIllIIlllllllllII.getDimensionID());
        this.gameController.playerController.setGameType(lllllllllllllIlIIllIIlllllllllII.getGameType());
    }
    
    @Override
    public void handleSetPassengers(final SPacketSetPassengers lllllllllllllIlIIllIlIIIIIllIlIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIIIllIlIl, this, this.gameController);
        final Entity lllllllllllllIlIIllIlIIIIIllIlII = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIlIIIIIllIlIl.getEntityId());
        if (lllllllllllllIlIIllIlIIIIIllIlII == null) {
            NetHandlerPlayClient.LOGGER.warn("Received passengers for unknown entity");
        }
        else {
            final boolean lllllllllllllIlIIllIlIIIIIllIIll = lllllllllllllIlIIllIlIIIIIllIlII.isRidingOrBeingRiddenBy(this.gameController.player);
            lllllllllllllIlIIllIlIIIIIllIlII.removePassengers();
            float lllllllllllllIlIIllIlIIIIIlIlIIl;
            for (boolean lllllllllllllIlIIllIlIIIIIlIlIlI = ((int[])(Object)(lllllllllllllIlIIllIlIIIIIlIlIIl = (float)(Object)lllllllllllllIlIIllIlIIIIIllIlIl.getPassengerIds())).length != 0, lllllllllllllIlIIllIlIIIIIlIlIll = false; lllllllllllllIlIIllIlIIIIIlIlIll < lllllllllllllIlIIllIlIIIIIlIlIlI; ++lllllllllllllIlIIllIlIIIIIlIlIll) {
                final int lllllllllllllIlIIllIlIIIIIllIIlI = lllllllllllllIlIIllIlIIIIIlIlIIl[lllllllllllllIlIIllIlIIIIIlIlIll];
                final Entity lllllllllllllIlIIllIlIIIIIllIIIl = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIlIIIIIllIIlI);
                if (lllllllllllllIlIIllIlIIIIIllIIIl != null) {
                    lllllllllllllIlIIllIlIIIIIllIIIl.startRiding(lllllllllllllIlIIllIlIIIIIllIlII, true);
                    if (lllllllllllllIlIIllIlIIIIIllIIIl == this.gameController.player && !lllllllllllllIlIIllIlIIIIIllIIll) {
                        this.gameController.ingameGUI.setRecordPlaying(I18n.format("mount.onboard", GameSettings.getKeyDisplayString(this.gameController.gameSettings.keyBindSneak.getKeyCode())), false);
                    }
                }
            }
        }
    }
    
    @Override
    public void handleDisconnect(final SPacketDisconnect lllllllllllllIlIIllIlIIIlIlIlIII) {
        this.netManager.closeChannel(lllllllllllllIlIIllIlIIIlIlIlIII.getReason());
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$play$server$SPacketTitle$Type() {
        final int[] $switch_TABLE$net$minecraft$network$play$server$SPacketTitle$Type = NetHandlerPlayClient.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketTitle$Type;
        if ($switch_TABLE$net$minecraft$network$play$server$SPacketTitle$Type != null) {
            return $switch_TABLE$net$minecraft$network$play$server$SPacketTitle$Type;
        }
        final int lllllllllllllIlIIllIIlIllIIIllll = (Object)new int[SPacketTitle.Type.values().length];
        try {
            lllllllllllllIlIIllIIlIllIIIllll[SPacketTitle.Type.ACTIONBAR.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIIllIIlIllIIIllll[SPacketTitle.Type.CLEAR.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIIllIIlIllIIIllll[SPacketTitle.Type.RESET.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlIIllIIlIllIIIllll[SPacketTitle.Type.SUBTITLE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIlIIllIIlIllIIIllll[SPacketTitle.Type.TIMES.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIlIIllIIlIllIIIllll[SPacketTitle.Type.TITLE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return NetHandlerPlayClient.$SWITCH_TABLE$net$minecraft$network$play$server$SPacketTitle$Type = (int[])(Object)lllllllllllllIlIIllIIlIllIIIllll;
    }
    
    @Override
    public void handleTabComplete(final SPacketTabComplete lllllllllllllIlIIllIIllIlIlIlIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllIlIlIlIIl, this, this.gameController);
        final String[] lllllllllllllIlIIllIIllIlIlIlIll = lllllllllllllIlIIllIIllIlIlIlIIl.getMatches();
        Arrays.sort(lllllllllllllIlIIllIIllIlIlIlIll);
        if (this.gameController.currentScreen instanceof ITabCompleter) {
            ((ITabCompleter)this.gameController.currentScreen).setCompletions(lllllllllllllIlIIllIIllIlIlIlIll);
        }
    }
    
    @Override
    public void handleWindowProperty(final SPacketWindowProperty lllllllllllllIlIIllIIllllIIllIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllllIIllIlI, this, this.gameController);
        final EntityPlayer lllllllllllllIlIIllIIllllIIlllII = this.gameController.player;
        if (lllllllllllllIlIIllIIllllIIlllII.openContainer != null && lllllllllllllIlIIllIIllllIIlllII.openContainer.windowId == lllllllllllllIlIIllIIllllIIllIlI.getWindowId()) {
            lllllllllllllIlIIllIIllllIIlllII.openContainer.updateProgressBar(lllllllllllllIlIIllIIllllIIllIlI.getProperty(), lllllllllllllIlIIllIIllllIIllIlI.getValue());
        }
    }
    
    @Override
    public void handleResourcePack(final SPacketResourcePackSend lllllllllllllIlIIllIIllIlIIIlIll) {
        final String lllllllllllllIlIIllIIllIlIIlIIlI = lllllllllllllIlIIllIIllIlIIIlIll.getURL();
        final String lllllllllllllIlIIllIIllIlIIlIIIl = lllllllllllllIlIIllIIllIlIIIlIll.getHash();
        if (this.validateResourcePackUrl(lllllllllllllIlIIllIIllIlIIlIIlI)) {
            if (lllllllllllllIlIIllIIllIlIIlIIlI.startsWith("level://")) {
                try {
                    final String lllllllllllllIlIIllIIllIlIIlIIII = URLDecoder.decode(lllllllllllllIlIIllIIllIlIIlIIlI.substring("level://".length()), StandardCharsets.UTF_8.toString());
                    final File lllllllllllllIlIIllIIllIlIIIllll = new File(this.gameController.mcDataDir, "saves");
                    final File lllllllllllllIlIIllIIllIlIIIlllI = new File(lllllllllllllIlIIllIIllIlIIIllll, lllllllllllllIlIIllIIllIlIIlIIII);
                    if (lllllllllllllIlIIllIIllIlIIIlllI.isFile()) {
                        this.netManager.sendPacket(new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.ACCEPTED));
                        Futures.addCallback((ListenableFuture)this.gameController.getResourcePackRepository().setResourcePackInstance(lllllllllllllIlIIllIIllIlIIIlllI), (FutureCallback)this.createDownloadCallback());
                        return;
                    }
                }
                catch (UnsupportedEncodingException ex) {}
                this.netManager.sendPacket(new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.FAILED_DOWNLOAD));
            }
            else {
                final ServerData lllllllllllllIlIIllIIllIlIIIllIl = this.gameController.getCurrentServerData();
                if (lllllllllllllIlIIllIIllIlIIIllIl != null && lllllllllllllIlIIllIIllIlIIIllIl.getResourceMode() == ServerData.ServerResourceMode.ENABLED) {
                    this.netManager.sendPacket(new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.ACCEPTED));
                    Futures.addCallback((ListenableFuture)this.gameController.getResourcePackRepository().downloadResourcePack(lllllllllllllIlIIllIIllIlIIlIIlI, lllllllllllllIlIIllIIllIlIIlIIIl), (FutureCallback)this.createDownloadCallback());
                }
                else if (lllllllllllllIlIIllIIllIlIIIllIl != null && lllllllllllllIlIIllIIllIlIIIllIl.getResourceMode() != ServerData.ServerResourceMode.PROMPT) {
                    this.netManager.sendPacket(new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.DECLINED));
                }
                else {
                    this.gameController.addScheduledTask(new Runnable() {
                        @Override
                        public void run() {
                            NetHandlerPlayClient.this.gameController.displayGuiScreen(new GuiYesNo(new GuiYesNoCallback() {
                                @Override
                                public void confirmClicked(final boolean llllllllllllllIllIIlIIIlIlIIIIlI, final int llllllllllllllIllIIlIIIlIlIIIlIl) {
                                    NetHandlerPlayClient.access$4(NetHandlerPlayClient.this, Minecraft.getMinecraft());
                                    final ServerData llllllllllllllIllIIlIIIlIlIIIlII = NetHandlerPlayClient.this.gameController.getCurrentServerData();
                                    if (llllllllllllllIllIIlIIIlIlIIIIlI) {
                                        if (llllllllllllllIllIIlIIIlIlIIIlII != null) {
                                            llllllllllllllIllIIlIIIlIlIIIlII.setResourceMode(ServerData.ServerResourceMode.ENABLED);
                                        }
                                        NetHandlerPlayClient.this.netManager.sendPacket(new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.ACCEPTED));
                                        Futures.addCallback((ListenableFuture)NetHandlerPlayClient.this.gameController.getResourcePackRepository().downloadResourcePack(lllllllllllllIlIIllIIllIlIIlIIlI, lllllllllllllIlIIllIIllIlIIlIIIl), NetHandlerPlayClient.this.createDownloadCallback());
                                    }
                                    else {
                                        if (llllllllllllllIllIIlIIIlIlIIIlII != null) {
                                            llllllllllllllIllIIlIIIlIlIIIlII.setResourceMode(ServerData.ServerResourceMode.DISABLED);
                                        }
                                        NetHandlerPlayClient.this.netManager.sendPacket(new CPacketResourcePackStatus(CPacketResourcePackStatus.Action.DECLINED));
                                    }
                                    ServerList.saveSingleServer(llllllllllllllIllIIlIIIlIlIIIlII);
                                    NetHandlerPlayClient.this.gameController.displayGuiScreen(null);
                                }
                            }, I18n.format("multiplayer.texturePrompt.line1", new Object[0]), I18n.format("multiplayer.texturePrompt.line2", new Object[0]), 0));
                        }
                    });
                }
            }
        }
    }
    
    public GameProfile getGameProfile() {
        return this.profile;
    }
    
    @Override
    public void handleEntityTeleport(final SPacketEntityTeleport lllllllllllllIlIIllIlIIlIIlIllII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIlIIlIllII, this, this.gameController);
        final Entity lllllllllllllIlIIllIlIIlIIllIIll = this.clientWorldController.getEntityByID(lllllllllllllIlIIllIlIIlIIlIllII.getEntityId());
        if (lllllllllllllIlIIllIlIIlIIllIIll != null) {
            final double lllllllllllllIlIIllIlIIlIIllIIlI = lllllllllllllIlIIllIlIIlIIlIllII.getX();
            final double lllllllllllllIlIIllIlIIlIIllIIIl = lllllllllllllIlIIllIlIIlIIlIllII.getY();
            final double lllllllllllllIlIIllIlIIlIIllIIII = lllllllllllllIlIIllIlIIlIIlIllII.getZ();
            EntityTracker.updateServerPosition(lllllllllllllIlIIllIlIIlIIllIIll, lllllllllllllIlIIllIlIIlIIllIIlI, lllllllllllllIlIIllIlIIlIIllIIIl, lllllllllllllIlIIllIlIIlIIllIIII);
            if (!lllllllllllllIlIIllIlIIlIIllIIll.canPassengerSteer()) {
                final float lllllllllllllIlIIllIlIIlIIlIllll = lllllllllllllIlIIllIlIIlIIlIllII.getYaw() * 360 / 256.0f;
                final float lllllllllllllIlIIllIlIIlIIlIlllI = lllllllllllllIlIIllIlIIlIIlIllII.getPitch() * 360 / 256.0f;
                if (Math.abs(lllllllllllllIlIIllIlIIlIIllIIll.posX - lllllllllllllIlIIllIlIIlIIllIIlI) < 0.03125 && Math.abs(lllllllllllllIlIIllIlIIlIIllIIll.posY - lllllllllllllIlIIllIlIIlIIllIIIl) < 0.015625 && Math.abs(lllllllllllllIlIIllIlIIlIIllIIll.posZ - lllllllllllllIlIIllIlIIlIIllIIII) < 0.03125) {
                    lllllllllllllIlIIllIlIIlIIllIIll.setPositionAndRotationDirect(lllllllllllllIlIIllIlIIlIIllIIll.posX, lllllllllllllIlIIllIlIIlIIllIIll.posY, lllllllllllllIlIIllIlIIlIIllIIll.posZ, lllllllllllllIlIIllIlIIlIIlIllll, lllllllllllllIlIIllIlIIlIIlIlllI, 0, true);
                }
                else {
                    lllllllllllllIlIIllIlIIlIIllIIll.setPositionAndRotationDirect(lllllllllllllIlIIllIlIIlIIllIIlI, lllllllllllllIlIIllIlIIlIIllIIIl, lllllllllllllIlIIllIlIIlIIllIIII, lllllllllllllIlIIllIlIIlIIlIllll, lllllllllllllIlIIllIlIIlIIlIlllI, 3, true);
                }
                lllllllllllllIlIIllIlIIlIIllIIll.onGround = lllllllllllllIlIIllIlIIlIIlIllII.getOnGround();
            }
        }
    }
    
    @Override
    public void handleSpawnPainting(final SPacketSpawnPainting lllllllllllllIlIIllIlIIlIllIllll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIlIllIllll, this, this.gameController);
        final EntityPainting lllllllllllllIlIIllIlIIlIllIlllI = new EntityPainting(this.clientWorldController, lllllllllllllIlIIllIlIIlIllIllll.getPosition(), lllllllllllllIlIIllIlIIlIllIllll.getFacing(), lllllllllllllIlIIllIlIIlIllIllll.getTitle());
        lllllllllllllIlIIllIlIIlIllIlllI.setUniqueId(lllllllllllllIlIIllIlIIlIllIllll.getUniqueId());
        this.clientWorldController.addEntityToWorld(lllllllllllllIlIIllIlIIlIllIllll.getEntityID(), lllllllllllllIlIIllIlIIlIllIlllI);
    }
    
    public NetHandlerPlayClient(final Minecraft lllllllllllllIlIIllIlIIlllIIIlll, final GuiScreen lllllllllllllIlIIllIlIIlllIIIllI, final NetworkManager lllllllllllllIlIIllIlIIlllIIlIlI, final GameProfile lllllllllllllIlIIllIlIIlllIIlIIl) {
        this.playerInfoMap = (Map<UUID, NetworkPlayerInfo>)Maps.newHashMap();
        this.currentServerMaxPlayers = 20;
        this.avRandomizer = new Random();
        this.gameController = lllllllllllllIlIIllIlIIlllIIIlll;
        this.guiScreenServer = lllllllllllllIlIIllIlIIlllIIIllI;
        this.netManager = lllllllllllllIlIIllIlIIlllIIlIlI;
        this.profile = lllllllllllllIlIIllIlIIlllIIlIIl;
        this.field_191983_k = new ClientAdvancementManager(lllllllllllllIlIIllIlIIlllIIIlll);
    }
    
    @Override
    public void func_194307_a(final SPacketPlaceGhostRecipe lllllllllllllIlIIllIIlIllIllIIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlIllIllIIlI, this, this.gameController);
        final Container lllllllllllllIlIIllIIlIllIllIlIl = this.gameController.player.openContainer;
        if (lllllllllllllIlIIllIIlIllIllIlIl.windowId == lllllllllllllIlIIllIIlIllIllIIlI.func_194313_b() && lllllllllllllIlIIllIIlIllIllIlIl.getCanCraft(this.gameController.player) && this.gameController.currentScreen instanceof IRecipeShownListener) {
            final GuiRecipeBook lllllllllllllIlIIllIIlIllIllIlII = ((IRecipeShownListener)this.gameController.currentScreen).func_194310_f();
            lllllllllllllIlIIllIIlIllIllIlII.func_193951_a(lllllllllllllIlIIllIIlIllIllIIlI.func_194311_a(), lllllllllllllIlIIllIIlIllIllIlIl.inventorySlots);
        }
    }
    
    @Nullable
    public NetworkPlayerInfo getPlayerInfo(final String lllllllllllllIlIIllIIlIllIIllllI) {
        for (final NetworkPlayerInfo lllllllllllllIlIIllIIlIllIIlllIl : this.playerInfoMap.values()) {
            if (lllllllllllllIlIIllIIlIllIIlllIl.getGameProfile().getName().equals(lllllllllllllIlIIllIIlIllIIllllI)) {
                return lllllllllllllIlIIllIIlIllIIlllIl;
            }
        }
        return null;
    }
    
    @Override
    public void handleSpawnExperienceOrb(final SPacketSpawnExperienceOrb lllllllllllllIlIIllIlIIllIIIlIlI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIllIIIlIlI, this, this.gameController);
        final double lllllllllllllIlIIllIlIIllIIIllll = lllllllllllllIlIIllIlIIllIIIlIlI.getX();
        final double lllllllllllllIlIIllIlIIllIIIlllI = lllllllllllllIlIIllIlIIllIIIlIlI.getY();
        final double lllllllllllllIlIIllIlIIllIIIllIl = lllllllllllllIlIIllIlIIllIIIlIlI.getZ();
        final Entity lllllllllllllIlIIllIlIIllIIIllII = new EntityXPOrb(this.clientWorldController, lllllllllllllIlIIllIlIIllIIIllll, lllllllllllllIlIIllIlIIllIIIlllI, lllllllllllllIlIIllIlIIllIIIllIl, lllllllllllllIlIIllIlIIllIIIlIlI.getXPValue());
        EntityTracker.updateServerPosition(lllllllllllllIlIIllIlIIllIIIllII, lllllllllllllIlIIllIlIIllIIIllll, lllllllllllllIlIIllIlIIllIIIlllI, lllllllllllllIlIIllIlIIllIIIllIl);
        lllllllllllllIlIIllIlIIllIIIllII.rotationYaw = 0.0f;
        lllllllllllllIlIIllIlIIllIIIllII.rotationPitch = 0.0f;
        lllllllllllllIlIIllIlIIllIIIllII.setEntityId(lllllllllllllIlIIllIlIIllIIIlIlI.getEntityID());
        this.clientWorldController.addEntityToWorld(lllllllllllllIlIIllIlIIllIIIlIlI.getEntityID(), lllllllllllllIlIIllIlIIllIIIllII);
    }
    
    public Collection<NetworkPlayerInfo> getPlayerInfoMap() {
        return this.playerInfoMap.values();
    }
    
    @Override
    public void handleBlockChange(final SPacketBlockChange lllllllllllllIlIIllIlIIIlIlIlllI) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIlIlIlllI, this, this.gameController);
        this.clientWorldController.invalidateRegionAndSetBlock(lllllllllllllIlIIllIlIIIlIlIlllI.getBlockPosition(), lllllllllllllIlIIllIlIIIlIlIlllI.getBlockState());
    }
    
    @Override
    public void func_191981_a(final SPacketAdvancementInfo lllllllllllllIlIIllIIlllIlIIlIll) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIlllIlIIlIll, this, this.gameController);
        this.field_191983_k.func_192799_a(lllllllllllllIlIIllIIlllIlIIlIll);
    }
    
    @Override
    public void handlePlayerPosLook(final SPacketPlayerPosLook lllllllllllllIlIIllIlIIIlllIlIIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIlIIIlllIlIIl, this, this.gameController);
        final EntityPlayer lllllllllllllIlIIllIlIIIlllIlIII = this.gameController.player;
        double lllllllllllllIlIIllIlIIIlllIIlll = lllllllllllllIlIIllIlIIIlllIlIIl.getX();
        double lllllllllllllIlIIllIlIIIlllIIllI = lllllllllllllIlIIllIlIIIlllIlIIl.getY();
        double lllllllllllllIlIIllIlIIIlllIIlIl = lllllllllllllIlIIllIlIIIlllIlIIl.getZ();
        float lllllllllllllIlIIllIlIIIlllIIlII = lllllllllllllIlIIllIlIIIlllIlIIl.getYaw();
        float lllllllllllllIlIIllIlIIIlllIIIll = lllllllllllllIlIIllIlIIIlllIlIIl.getPitch();
        if (lllllllllllllIlIIllIlIIIlllIlIIl.getFlags().contains(SPacketPlayerPosLook.EnumFlags.X)) {
            lllllllllllllIlIIllIlIIIlllIIlll += lllllllllllllIlIIllIlIIIlllIlIII.posX;
        }
        else {
            lllllllllllllIlIIllIlIIIlllIlIII.motionX = 0.0;
        }
        if (lllllllllllllIlIIllIlIIIlllIlIIl.getFlags().contains(SPacketPlayerPosLook.EnumFlags.Y)) {
            lllllllllllllIlIIllIlIIIlllIIllI += lllllllllllllIlIIllIlIIIlllIlIII.posY;
        }
        else {
            lllllllllllllIlIIllIlIIIlllIlIII.motionY = 0.0;
        }
        if (lllllllllllllIlIIllIlIIIlllIlIIl.getFlags().contains(SPacketPlayerPosLook.EnumFlags.Z)) {
            lllllllllllllIlIIllIlIIIlllIIlIl += lllllllllllllIlIIllIlIIIlllIlIII.posZ;
        }
        else {
            lllllllllllllIlIIllIlIIIlllIlIII.motionZ = 0.0;
        }
        if (lllllllllllllIlIIllIlIIIlllIlIIl.getFlags().contains(SPacketPlayerPosLook.EnumFlags.X_ROT)) {
            lllllllllllllIlIIllIlIIIlllIIIll += lllllllllllllIlIIllIlIIIlllIlIII.rotationPitch;
        }
        if (lllllllllllllIlIIllIlIIIlllIlIIl.getFlags().contains(SPacketPlayerPosLook.EnumFlags.Y_ROT)) {
            lllllllllllllIlIIllIlIIIlllIIlII += lllllllllllllIlIIllIlIIIlllIlIII.rotationYaw;
        }
        lllllllllllllIlIIllIlIIIlllIlIII.setPositionAndRotation(lllllllllllllIlIIllIlIIIlllIIlll, lllllllllllllIlIIllIlIIIlllIIllI, lllllllllllllIlIIllIlIIIlllIIlIl, lllllllllllllIlIIllIlIIIlllIIlII, lllllllllllllIlIIllIlIIIlllIIIll);
        this.netManager.sendPacket(new CPacketConfirmTeleport(lllllllllllllIlIIllIlIIIlllIlIIl.getTeleportId()));
        this.netManager.sendPacket(new CPacketPlayer.PositionRotation(lllllllllllllIlIIllIlIIIlllIlIII.posX, lllllllllllllIlIIllIlIIIlllIlIII.getEntityBoundingBox().minY, lllllllllllllIlIIllIlIIIlllIlIII.posZ, lllllllllllllIlIIllIlIIIlllIlIII.rotationYaw, lllllllllllllIlIIllIlIIIlllIlIII.rotationPitch, false));
        if (!this.doneLoadingTerrain) {
            this.gameController.player.prevPosX = this.gameController.player.posX;
            this.gameController.player.prevPosY = this.gameController.player.posY;
            this.gameController.player.prevPosZ = this.gameController.player.posZ;
            this.doneLoadingTerrain = true;
            this.gameController.displayGuiScreen(null);
        }
    }
    
    @Override
    public void handleScoreboardObjective(final SPacketScoreboardObjective lllllllllllllIlIIllIIllIIIllIlII) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllIIIllIlII, this, this.gameController);
        final Scoreboard lllllllllllllIlIIllIIllIIIllIIll = this.clientWorldController.getScoreboard();
        if (lllllllllllllIlIIllIIllIIIllIlII.getAction() == 0) {
            final ScoreObjective lllllllllllllIlIIllIIllIIIllIIlI = lllllllllllllIlIIllIIllIIIllIIll.addScoreObjective(lllllllllllllIlIIllIIllIIIllIlII.getObjectiveName(), IScoreCriteria.DUMMY);
            lllllllllllllIlIIllIIllIIIllIIlI.setDisplayName(lllllllllllllIlIIllIIllIIIllIlII.getObjectiveValue());
            lllllllllllllIlIIllIIllIIIllIIlI.setRenderType(lllllllllllllIlIIllIIllIIIllIlII.getRenderType());
        }
        else {
            final ScoreObjective lllllllllllllIlIIllIIllIIIllIIIl = lllllllllllllIlIIllIIllIIIllIIll.getObjective(lllllllllllllIlIIllIIllIIIllIlII.getObjectiveName());
            if (lllllllllllllIlIIllIIllIIIllIlII.getAction() == 1) {
                lllllllllllllIlIIllIIllIIIllIIll.removeObjective(lllllllllllllIlIIllIIllIIIllIIIl);
            }
            else if (lllllllllllllIlIIllIIllIIIllIlII.getAction() == 2) {
                if (Main.moduleManager.getModule(NameProtect.class).isToggled()) {
                    lllllllllllllIlIIllIIllIIIllIIIl.setDisplayName(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("NoRules Lite")));
                }
                else {
                    lllllllllllllIlIIllIIllIIIllIIIl.setDisplayName(lllllllllllllIlIIllIIllIIIllIlII.getObjectiveValue());
                }
                lllllllllllllIlIIllIIllIIIllIIIl.setRenderType(lllllllllllllIlIIllIIllIIIllIlII.getRenderType());
            }
        }
    }
    
    @Override
    public void handleSignEditorOpen(final SPacketSignEditorOpen lllllllllllllIlIIllIIllllIllIlIl) {
        PacketThreadUtil.checkThreadAndEnqueue((Packet<NetHandlerPlayClient>)lllllllllllllIlIIllIIllllIllIlIl, this, this.gameController);
        TileEntity lllllllllllllIlIIllIIllllIllIlII = this.clientWorldController.getTileEntity(lllllllllllllIlIIllIIllllIllIlIl.getSignPosition());
        if (!(lllllllllllllIlIIllIIllllIllIlII instanceof TileEntitySign)) {
            lllllllllllllIlIIllIIllllIllIlII = new TileEntitySign();
            lllllllllllllIlIIllIIllllIllIlII.setWorldObj(this.clientWorldController);
            lllllllllllllIlIIllIIllllIllIlII.setPos(lllllllllllllIlIIllIIllllIllIlIl.getSignPosition());
        }
        this.gameController.player.openEditSign((TileEntitySign)lllllllllllllIlIIllIIllllIllIlII);
    }
}
