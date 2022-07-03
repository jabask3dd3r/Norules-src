package net.minecraft.network.play;

import net.minecraft.network.*;
import net.minecraft.network.play.server.*;

public interface INetHandlerPlayClient extends INetHandler
{
    void handleCustomSound(final SPacketCustomSound p0);
    
    void handleDestroyEntities(final SPacketDestroyEntities p0);
    
    void handleMoveVehicle(final SPacketMoveVehicle p0);
    
    void handleEntityAttach(final SPacketEntityAttach p0);
    
    void handleWindowProperty(final SPacketWindowProperty p0);
    
    void handleDisconnect(final SPacketDisconnect p0);
    
    void handleEntityVelocity(final SPacketEntityVelocity p0);
    
    void handleEntityEffect(final SPacketEntityEffect p0);
    
    void handleResourcePack(final SPacketResourcePackSend p0);
    
    void handleSetSlot(final SPacketSetSlot p0);
    
    void handleSpawnPlayer(final SPacketSpawnPlayer p0);
    
    void handleAnimation(final SPacketAnimation p0);
    
    void handleEntityEquipment(final SPacketEntityEquipment p0);
    
    void handleEntityStatus(final SPacketEntityStatus p0);
    
    void handleCamera(final SPacketCamera p0);
    
    void handleChat(final SPacketChat p0);
    
    void handleKeepAlive(final SPacketKeepAlive p0);
    
    void handleChunkData(final SPacketChunkData p0);
    
    void handleTitle(final SPacketTitle p0);
    
    void handleWindowItems(final SPacketWindowItems p0);
    
    void handleUpdateTileEntity(final SPacketUpdateTileEntity p0);
    
    void handleUpdateScore(final SPacketUpdateScore p0);
    
    void handleUpdateEntityNBT(final SPacketUpdateBossInfo p0);
    
    void handleRespawn(final SPacketRespawn p0);
    
    void handleStatistics(final SPacketStatistics p0);
    
    void handleOpenWindow(final SPacketOpenWindow p0);
    
    void func_194022_a(final SPacketSelectAdvancementsTab p0);
    
    void handleEntityTeleport(final SPacketEntityTeleport p0);
    
    void handleCollectItem(final SPacketCollectItem p0);
    
    void handleMaps(final SPacketMaps p0);
    
    void func_191980_a(final SPacketRecipeBook p0);
    
    void handleSpawnMob(final SPacketSpawnMob p0);
    
    void handleSetExperience(final SPacketSetExperience p0);
    
    void handleEntityMetadata(final SPacketEntityMetadata p0);
    
    void handleEffect(final SPacketEffect p0);
    
    void handleHeldItemChange(final SPacketHeldItemChange p0);
    
    void handleExplosion(final SPacketExplosion p0);
    
    void handleBlockChange(final SPacketBlockChange p0);
    
    void handleTabComplete(final SPacketTabComplete p0);
    
    void handleUpdateHealth(final SPacketUpdateHealth p0);
    
    void handlePlayerPosLook(final SPacketPlayerPosLook p0);
    
    void handleSoundEffect(final SPacketSoundEffect p0);
    
    void func_191981_a(final SPacketAdvancementInfo p0);
    
    void handleCooldown(final SPacketCooldown p0);
    
    void handleCloseWindow(final SPacketCloseWindow p0);
    
    void processChunkUnload(final SPacketUnloadChunk p0);
    
    void handleUseBed(final SPacketUseBed p0);
    
    void handleRemoveEntityEffect(final SPacketRemoveEntityEffect p0);
    
    void handleScoreboardObjective(final SPacketScoreboardObjective p0);
    
    void handleTimeUpdate(final SPacketTimeUpdate p0);
    
    void handleSpawnPosition(final SPacketSpawnPosition p0);
    
    void func_194307_a(final SPacketPlaceGhostRecipe p0);
    
    void handleServerDifficulty(final SPacketServerDifficulty p0);
    
    void handleSignEditorOpen(final SPacketSignEditorOpen p0);
    
    void handleSpawnGlobalEntity(final SPacketSpawnGlobalEntity p0);
    
    void handleSpawnPainting(final SPacketSpawnPainting p0);
    
    void handleBlockBreakAnim(final SPacketBlockBreakAnim p0);
    
    void handleCombatEvent(final SPacketCombatEvent p0);
    
    void handleJoinGame(final SPacketJoinGame p0);
    
    void handleSpawnExperienceOrb(final SPacketSpawnExperienceOrb p0);
    
    void handleChangeGameState(final SPacketChangeGameState p0);
    
    void handleParticles(final SPacketParticles p0);
    
    void handleEntityMovement(final SPacketEntity p0);
    
    void handleSpawnObject(final SPacketSpawnObject p0);
    
    void handleCustomPayload(final SPacketCustomPayload p0);
    
    void handleBlockAction(final SPacketBlockAction p0);
    
    void handleEntityHeadLook(final SPacketEntityHeadLook p0);
    
    void handleEntityProperties(final SPacketEntityProperties p0);
    
    void handleDisplayObjective(final SPacketDisplayObjective p0);
    
    void handleSetPassengers(final SPacketSetPassengers p0);
    
    void handlePlayerAbilities(final SPacketPlayerAbilities p0);
    
    void handleTeams(final SPacketTeams p0);
    
    void handlePlayerListHeaderFooter(final SPacketPlayerListHeaderFooter p0);
    
    void handleWorldBorder(final SPacketWorldBorder p0);
    
    void handlePlayerListItem(final SPacketPlayerListItem p0);
    
    void handleMultiBlockChange(final SPacketMultiBlockChange p0);
    
    void handleConfirmTransaction(final SPacketConfirmTransaction p0);
}
