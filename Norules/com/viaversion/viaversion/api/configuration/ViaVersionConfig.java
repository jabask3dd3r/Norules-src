package com.viaversion.viaversion.api.configuration;

import com.viaversion.viaversion.libs.fastutil.ints.*;
import com.viaversion.viaversion.libs.gson.*;

public interface ViaVersionConfig
{
    boolean isShowShieldWhenSwordInHand();
    
    boolean isItemCache();
    
    boolean is1_13TeamColourFix();
    
    IntSet getBlockedProtocols();
    
    boolean is1_12QuickMoveActionFix();
    
    String getMaxPPSKickMessage();
    
    String getBlockedDisconnectMsg();
    
    boolean isForcedUse1_17ResourcePack();
    
    boolean isNonFullBlockLightFix();
    
    boolean isReplacePistons();
    
    boolean isNMSPlayerTicking();
    
    boolean isStemWhenBlockAbove();
    
    boolean isBossbarPatch();
    
    boolean isLeftHandedHandling();
    
    boolean isNoDelayShieldBlocking();
    
    String getMaxWarningsKickMessage();
    
    int getTrackingPeriod();
    
    boolean isNewEffectIndicator();
    
    boolean isSendSupportedVersions();
    
    boolean isSuppressConversionWarnings();
    
    int get1_13TabCompleteDelay();
    
    boolean isShieldBlocking();
    
    boolean isReduceBlockStorageMemory();
    
    boolean is1_9HitboxFix();
    
    boolean isServersideBlockConnections();
    
    boolean isMinimizeCooldown();
    
    int getPistonReplacementId();
    
    boolean isAutoTeam();
    
    boolean isVineClimbFix();
    
    boolean is1_14HitboxFix();
    
    boolean isInfestedBlocksFix();
    
    int getMaxWarnings();
    
    boolean is1_14HealthNaNFix();
    
    boolean isAntiXRay();
    
    boolean isShowNewDeathMessages();
    
    boolean isForceJsonTransform();
    
    boolean isSuppressMetadataErrors();
    
    boolean is1_15InstantRespawn();
    
    boolean is1_12NBTArrayFix();
    
    boolean isTruncate1_14Books();
    
    void setCheckForUpdates(final boolean p0);
    
    boolean isPistonAnimationPatch();
    
    String getReloadDisconnectMsg();
    
    boolean isSnowCollisionFix();
    
    int getMaxPPS();
    
    int getWarningPPS();
    
    JsonElement get1_17ResourcePackPrompt();
    
    boolean isHologramPatch();
    
    double getHologramYOffset();
    
    String getBlockConnectionMethod();
    
    boolean isIgnoreLong1_16ChannelNames();
    
    boolean isDisable1_13AutoComplete();
    
    boolean isSimulatePlayerTick();
    
    boolean isBossbarAntiflicker();
    
    boolean isCheckForUpdates();
    
    boolean isPreventCollision();
}
