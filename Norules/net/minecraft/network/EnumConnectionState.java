package net.minecraft.network;

import java.util.*;
import org.apache.logging.log4j.*;
import javax.annotation.*;
import net.minecraft.network.handshake.client.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.status.client.*;
import net.minecraft.network.status.server.*;
import net.minecraft.network.login.server.*;
import net.minecraft.network.login.client.*;
import com.google.common.collect.*;

public enum EnumConnectionState
{
    HANDSHAKING(0, -1) {
        {
            this.registerPacket(EnumPacketDirection.SERVERBOUND, C00Handshake.class);
        }
    };
    
    private static final /* synthetic */ Map<Class<? extends Packet<?>>, EnumConnectionState> STATES_BY_CLASS;
    
    STATUS(2, 1) {
        {
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketServerQuery.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketServerInfo.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPing.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketPong.class);
        }
    }, 
    PLAY(1, 0) {
        {
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSpawnObject.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSpawnExperienceOrb.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSpawnGlobalEntity.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSpawnMob.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSpawnPainting.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSpawnPlayer.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketAnimation.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketStatistics.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketBlockBreakAnim.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketUpdateTileEntity.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketBlockAction.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketBlockChange.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketUpdateBossInfo.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketServerDifficulty.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketTabComplete.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketChat.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketMultiBlockChange.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketConfirmTransaction.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketCloseWindow.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketOpenWindow.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketWindowItems.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketWindowProperty.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSetSlot.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketCooldown.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketCustomPayload.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketCustomSound.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketDisconnect.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntityStatus.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketExplosion.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketUnloadChunk.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketChangeGameState.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketKeepAlive.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketChunkData.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEffect.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketParticles.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketJoinGame.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketMaps.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntity.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntity.S15PacketEntityRelMove.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntity.S17PacketEntityLookMove.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntity.S16PacketEntityLook.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketMoveVehicle.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSignEditorOpen.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketPlaceGhostRecipe.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketPlayerAbilities.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketCombatEvent.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketPlayerListItem.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketPlayerPosLook.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketUseBed.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketRecipeBook.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketDestroyEntities.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketRemoveEntityEffect.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketResourcePackSend.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketRespawn.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntityHeadLook.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSelectAdvancementsTab.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketWorldBorder.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketCamera.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketHeldItemChange.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketDisplayObjective.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntityMetadata.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntityAttach.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntityVelocity.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntityEquipment.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSetExperience.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketUpdateHealth.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketScoreboardObjective.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSetPassengers.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketTeams.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketUpdateScore.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSpawnPosition.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketTimeUpdate.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketTitle.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketSoundEffect.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketPlayerListHeaderFooter.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketCollectItem.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntityTeleport.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketAdvancementInfo.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntityProperties.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEntityEffect.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketConfirmTeleport.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketTabComplete.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketChatMessage.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketClientStatus.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketClientSettings.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketConfirmTransaction.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketEnchantItem.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketClickWindow.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketCloseWindow.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketCustomPayload.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketUseEntity.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketKeepAlive.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPlayer.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPlayer.Position.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPlayer.PositionRotation.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPlayer.Rotation.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketVehicleMove.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketSteerBoat.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPlaceRecipe.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPlayerAbilities.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPlayerDigging.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketEntityAction.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketInput.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketRecipeInfo.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketResourcePackStatus.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketSeenAdvancements.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketHeldItemChange.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketCreativeInventoryAction.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketUpdateSign.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketAnimation.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketSpectate.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPlayerTryUseItemOnBlock.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketPlayerTryUseItem.class);
        }
    };
    
    private final /* synthetic */ Map<EnumPacketDirection, BiMap<Integer, Class<? extends Packet<?>>>> directionMaps;
    private final /* synthetic */ int id;
    
    LOGIN(3, 2) {
        {
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, net.minecraft.network.login.server.SPacketDisconnect.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEncryptionRequest.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketLoginSuccess.class);
            this.registerPacket(EnumPacketDirection.CLIENTBOUND, SPacketEnableCompression.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketLoginStart.class);
            this.registerPacket(EnumPacketDirection.SERVERBOUND, CPacketEncryptionResponse.class);
        }
    };
    
    private static final /* synthetic */ EnumConnectionState[] STATES_BY_ID;
    
    protected EnumConnectionState registerPacket(final EnumPacketDirection lllllllllllllIIIlllIIIlIIllllIll, final Class<? extends Packet<?>> lllllllllllllIIIlllIIIlIIllllIlI) {
        BiMap<Integer, Class<? extends Packet<?>>> lllllllllllllIIIlllIIIlIIllllllI = this.directionMaps.get(lllllllllllllIIIlllIIIlIIllllIll);
        if (lllllllllllllIIIlllIIIlIIllllllI == null) {
            lllllllllllllIIIlllIIIlIIllllllI = (BiMap<Integer, Class<? extends Packet<?>>>)HashBiMap.create();
            this.directionMaps.put(lllllllllllllIIIlllIIIlIIllllIll, lllllllllllllIIIlllIIIlIIllllllI);
        }
        if (lllllllllllllIIIlllIIIlIIllllllI.containsValue((Object)lllllllllllllIIIlllIIIlIIllllIlI)) {
            final String lllllllllllllIIIlllIIIlIIlllllIl = String.valueOf(new StringBuilder().append(lllllllllllllIIIlllIIIlIIllllIll).append(" packet ").append(lllllllllllllIIIlllIIIlIIllllIlI).append(" is already known to ID ").append(lllllllllllllIIIlllIIIlIIllllllI.inverse().get((Object)lllllllllllllIIIlllIIIlIIllllIlI)));
            LogManager.getLogger().fatal(lllllllllllllIIIlllIIIlIIlllllIl);
            throw new IllegalArgumentException(lllllllllllllIIIlllIIIlIIlllllIl);
        }
        lllllllllllllIIIlllIIIlIIllllllI.put((Object)lllllllllllllIIIlllIIIlIIllllllI.size(), (Object)lllllllllllllIIIlllIIIlIIllllIlI);
        return this;
    }
    
    public static EnumConnectionState getFromPacket(final Packet<?> lllllllllllllIIIlllIIIlIIlIllIll) {
        return EnumConnectionState.STATES_BY_CLASS.get(lllllllllllllIIIlllIIIlIIlIllIll.getClass());
    }
    
    public int getId() {
        return this.id;
    }
    
    public Integer getPacketId(final EnumPacketDirection lllllllllllllIIIlllIIIlIIlllIIll, final Packet<?> lllllllllllllIIIlllIIIlIIlllIIlI) throws Exception {
        return (Integer)this.directionMaps.get(lllllllllllllIIIlllIIIlIIlllIIll).inverse().get((Object)lllllllllllllIIIlllIIIlIIlllIIlI.getClass());
    }
    
    @Nullable
    public Packet<?> getPacket(final EnumPacketDirection lllllllllllllIIIlllIIIlIIllIIlIl, final int lllllllllllllIIIlllIIIlIIllIIlII) throws IllegalAccessException, InstantiationException {
        final Class<? extends Packet<?>> lllllllllllllIIIlllIIIlIIllIIlll = (Class<? extends Packet<?>>)this.directionMaps.get(lllllllllllllIIIlllIIIlIIllIIlIl).get((Object)lllllllllllllIIIlllIIIlIIllIIlII);
        return (Packet<?>)((lllllllllllllIIIlllIIIlIIllIIlll == null) ? null : ((Packet)lllllllllllllIIIlllIIIlIIllIIlll.newInstance()));
    }
    
    public static EnumConnectionState getById(final int lllllllllllllIIIlllIIIlIIlIllllI) {
        return (lllllllllllllIIIlllIIIlIIlIllllI >= -1 && lllllllllllllIIIlllIIIlIIlIllllI <= 2) ? EnumConnectionState.STATES_BY_ID[lllllllllllllIIIlllIIIlIIlIllllI + 1] : null;
    }
    
    static {
        STATES_BY_ID = new EnumConnectionState[4];
        STATES_BY_CLASS = Maps.newHashMap();
        float lllllllllllllIIIlllIIIlIlIIlIlll;
        for (short lllllllllllllIIIlllIIIlIlIIllIII = (short)((EnumConnectionState[])(Object)(lllllllllllllIIIlllIIIlIlIIlIlll = (float)(Object)values())).length, lllllllllllllIIIlllIIIlIlIIllIIl = 0; lllllllllllllIIIlllIIIlIlIIllIIl < lllllllllllllIIIlllIIIlIlIIllIII; ++lllllllllllllIIIlllIIIlIlIIllIIl) {
            final EnumConnectionState lllllllllllllIIIlllIIIlIlIIlllll = lllllllllllllIIIlllIIIlIlIIlIlll[lllllllllllllIIIlllIIIlIlIIllIIl];
            final int lllllllllllllIIIlllIIIlIlIIllllI = lllllllllllllIIIlllIIIlIlIIlllll.getId();
            if (lllllllllllllIIIlllIIIlIlIIllllI < -1 || lllllllllllllIIIlllIIIlIlIIllllI > 2) {
                throw new Error(String.valueOf(new StringBuilder("Invalid protocol ID ").append(Integer.toString(lllllllllllllIIIlllIIIlIlIIllllI))));
            }
            EnumConnectionState.STATES_BY_ID[lllllllllllllIIIlllIIIlIlIIllllI + 1] = lllllllllllllIIIlllIIIlIlIIlllll;
            for (final EnumPacketDirection lllllllllllllIIIlllIIIlIlIIlllIl : lllllllllllllIIIlllIIIlIlIIlllll.directionMaps.keySet()) {
                for (final Class<? extends Packet<?>> lllllllllllllIIIlllIIIlIlIIlllII : lllllllllllllIIIlllIIIlIlIIlllll.directionMaps.get(lllllllllllllIIIlllIIIlIlIIlllIl).values()) {
                    if (EnumConnectionState.STATES_BY_CLASS.containsKey(lllllllllllllIIIlllIIIlIlIIlllII) && EnumConnectionState.STATES_BY_CLASS.get(lllllllllllllIIIlllIIIlIlIIlllII) != lllllllllllllIIIlllIIIlIlIIlllll) {
                        throw new Error(String.valueOf(new StringBuilder("Packet ").append(lllllllllllllIIIlllIIIlIlIIlllII).append(" is already assigned to protocol ").append(EnumConnectionState.STATES_BY_CLASS.get(lllllllllllllIIIlllIIIlIlIIlllII)).append(" - can't reassign to ").append(lllllllllllllIIIlllIIIlIlIIlllll)));
                    }
                    try {
                        lllllllllllllIIIlllIIIlIlIIlllII.newInstance();
                    }
                    catch (Throwable lllllllllllllIIIlllIIIlIlIIllIll) {
                        throw new Error(String.valueOf(new StringBuilder("Packet ").append(lllllllllllllIIIlllIIIlIlIIlllII).append(" fails instantiation checks! ").append(lllllllllllllIIIlllIIIlIlIIlllII)));
                    }
                    EnumConnectionState.STATES_BY_CLASS.put(lllllllllllllIIIlllIIIlIlIIlllII, lllllllllllllIIIlllIIIlIlIIlllll);
                }
            }
        }
    }
    
    private EnumConnectionState(final String lllllllllllllIIIlllIIIlIlIIIlIIl, final int lllllllllllllIIIlllIIIlIlIIIlIII, final int lllllllllllllIIIlllIIIlIlIIIlIll) {
        this.directionMaps = (Map<EnumPacketDirection, BiMap<Integer, Class<? extends Packet<?>>>>)Maps.newEnumMap((Class)EnumPacketDirection.class);
        this.id = lllllllllllllIIIlllIIIlIlIIIlIll;
    }
}
