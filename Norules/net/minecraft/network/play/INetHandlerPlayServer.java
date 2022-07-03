package net.minecraft.network.play;

import net.minecraft.network.*;
import net.minecraft.network.play.client.*;

public interface INetHandlerPlayServer extends INetHandler
{
    void processInput(final CPacketInput p0);
    
    void processPlayerAbilities(final CPacketPlayerAbilities p0);
    
    void handleAnimation(final CPacketAnimation p0);
    
    void processUseEntity(final CPacketUseEntity p0);
    
    void processTabComplete(final CPacketTabComplete p0);
    
    void processChatMessage(final CPacketChatMessage p0);
    
    void processClientStatus(final CPacketClientStatus p0);
    
    void processCloseWindow(final CPacketCloseWindow p0);
    
    void processEntityAction(final CPacketEntityAction p0);
    
    void func_194027_a(final CPacketSeenAdvancements p0);
    
    void processCreativeInventoryAction(final CPacketCreativeInventoryAction p0);
    
    void handleResourcePackStatus(final CPacketResourcePackStatus p0);
    
    void handleSpectate(final CPacketSpectate p0);
    
    void processPlayer(final CPacketPlayer p0);
    
    void processPlayerBlockPlacement(final CPacketPlayerTryUseItem p0);
    
    void processVehicleMove(final CPacketVehicleMove p0);
    
    void processUpdateSign(final CPacketUpdateSign p0);
    
    void processHeldItemChange(final CPacketHeldItemChange p0);
    
    void processEnchantItem(final CPacketEnchantItem p0);
    
    void processCustomPayload(final CPacketCustomPayload p0);
    
    void processSteerBoat(final CPacketSteerBoat p0);
    
    void processPlayerDigging(final CPacketPlayerDigging p0);
    
    void processRightClickBlock(final CPacketPlayerTryUseItemOnBlock p0);
    
    void processConfirmTransaction(final CPacketConfirmTransaction p0);
    
    void processClickWindow(final CPacketClickWindow p0);
    
    void processConfirmTeleport(final CPacketConfirmTeleport p0);
    
    void func_194308_a(final CPacketPlaceRecipe p0);
    
    void processClientSettings(final CPacketClientSettings p0);
    
    void func_191984_a(final CPacketRecipeInfo p0);
    
    void processKeepAlive(final CPacketKeepAlive p0);
}
