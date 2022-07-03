package com.viaversion.viaversion.configuration;

import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.api.configuration.*;
import com.viaversion.viaversion.libs.gson.*;
import java.io.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import java.util.*;

public abstract class AbstractViaConfig extends Config implements ViaVersionConfig
{
    private /* synthetic */ boolean instantRespawn;
    private /* synthetic */ boolean forceJsonTransform;
    private /* synthetic */ boolean snowCollisionFix;
    private /* synthetic */ boolean serversideBlockConnections;
    private /* synthetic */ boolean disable1_13TabComplete;
    private /* synthetic */ int warningPPS;
    private /* synthetic */ boolean simulatePlayerTick;
    private /* synthetic */ boolean checkForUpdates;
    private /* synthetic */ boolean sendSupportedVersions;
    private /* synthetic */ boolean nbtArrayFix;
    private /* synthetic */ String reloadDisconnectMessage;
    private /* synthetic */ int maxPPS;
    private /* synthetic */ boolean reduceBlockStorageMemory;
    private /* synthetic */ boolean pistonAnimationPatch;
    private /* synthetic */ boolean shieldBlocking;
    private /* synthetic */ boolean fullBlockLightFix;
    private /* synthetic */ String blockedDisconnectMessage;
    private /* synthetic */ boolean healthNaNFix;
    private /* synthetic */ boolean autoTeam;
    private /* synthetic */ boolean suppressConversionWarnings;
    private /* synthetic */ int maxPPSWarnings;
    private /* synthetic */ boolean hologramPatch;
    private /* synthetic */ boolean noDelayShieldBlocking;
    private /* synthetic */ boolean showShieldWhenSwordInHand;
    private /* synthetic */ boolean bossbarAntiFlicker;
    private /* synthetic */ boolean useNewEffectIndicator;
    private /* synthetic */ JsonElement resourcePack1_17PromptMessage;
    private /* synthetic */ boolean useNewDeathmessages;
    private /* synthetic */ boolean itemCache;
    private /* synthetic */ boolean nmsPlayerTicking;
    private /* synthetic */ boolean forcedUse1_17ResourcePack;
    private /* synthetic */ String maxPPSKickMessage;
    private /* synthetic */ boolean flowerStemWhenBlockAbove;
    private /* synthetic */ int tabCompleteDelay;
    private /* synthetic */ boolean replacePistons;
    private /* synthetic */ boolean minimizeCooldown;
    private /* synthetic */ double hologramOffset;
    private /* synthetic */ int trackingPeriod;
    private /* synthetic */ boolean truncate1_14Books;
    private /* synthetic */ boolean bossbarPatch;
    private /* synthetic */ boolean infestedBlocksFix;
    private /* synthetic */ boolean leftHandedHandling;
    private /* synthetic */ boolean teamColourFix;
    private /* synthetic */ int pistonReplacementId;
    private /* synthetic */ boolean preventCollision;
    private /* synthetic */ boolean ignoreLongChannelNames;
    private /* synthetic */ IntSet blockedProtocols;
    private /* synthetic */ boolean suppressMetadataErrors;
    private /* synthetic */ boolean vineClimbFix;
    private /* synthetic */ String maxPPSWarningsKickMessage;
    
    @Override
    public boolean isShieldBlocking() {
        return this.shieldBlocking;
    }
    
    @Override
    public String getBlockConnectionMethod() {
        return "packet";
    }
    
    @Override
    public boolean isInfestedBlocksFix() {
        return this.infestedBlocksFix;
    }
    
    @Override
    public boolean is1_13TeamColourFix() {
        return this.teamColourFix;
    }
    
    @Override
    public boolean isSuppressMetadataErrors() {
        return this.suppressMetadataErrors;
    }
    
    @Override
    public boolean isIgnoreLong1_16ChannelNames() {
        return this.ignoreLongChannelNames;
    }
    
    @Override
    public boolean isDisable1_13AutoComplete() {
        return this.disable1_13TabComplete;
    }
    
    @Override
    public String getMaxPPSKickMessage() {
        return this.maxPPSKickMessage;
    }
    
    @Override
    public boolean isPistonAnimationPatch() {
        return this.pistonAnimationPatch;
    }
    
    @Override
    public int getMaxPPS() {
        return this.maxPPS;
    }
    
    @Override
    public void reloadConfig() {
        super.reloadConfig();
        this.loadFields();
    }
    
    @Override
    public boolean isReplacePistons() {
        return this.replacePistons;
    }
    
    @Override
    public boolean isSnowCollisionFix() {
        return this.snowCollisionFix;
    }
    
    @Override
    public boolean isLeftHandedHandling() {
        return this.leftHandedHandling;
    }
    
    @Override
    public boolean isNewEffectIndicator() {
        return this.useNewEffectIndicator;
    }
    
    @Override
    public boolean is1_14HealthNaNFix() {
        return this.healthNaNFix;
    }
    
    @Override
    public boolean isSendSupportedVersions() {
        return this.sendSupportedVersions;
    }
    
    @Override
    public int get1_13TabCompleteDelay() {
        return this.tabCompleteDelay;
    }
    
    protected AbstractViaConfig(final File lllllllllllllIlIlIllIIIIllIIIlII) {
        super(lllllllllllllIlIlIllIIIIllIIIlII);
    }
    
    @Override
    public int getMaxWarnings() {
        return this.maxPPSWarnings;
    }
    
    @Override
    public String getBlockedDisconnectMsg() {
        return this.blockedDisconnectMessage;
    }
    
    @Override
    public boolean isSimulatePlayerTick() {
        return this.simulatePlayerTick;
    }
    
    @Override
    public IntSet getBlockedProtocols() {
        return this.blockedProtocols;
    }
    
    @Override
    public String getMaxWarningsKickMessage() {
        return this.maxPPSWarningsKickMessage;
    }
    
    @Override
    public boolean is1_14HitboxFix() {
        return false;
    }
    
    @Override
    public int getWarningPPS() {
        return this.warningPPS;
    }
    
    @Override
    public boolean isBossbarPatch() {
        return this.bossbarPatch;
    }
    
    @Override
    public boolean isServersideBlockConnections() {
        return this.serversideBlockConnections;
    }
    
    @Override
    public boolean isBossbarAntiflicker() {
        return this.bossbarAntiFlicker;
    }
    
    @Override
    public boolean isAutoTeam() {
        return this.preventCollision && this.autoTeam;
    }
    
    @Override
    public void setCheckForUpdates(final boolean lllllllllllllIlIlIllIIIIlIllIlIl) {
        this.checkForUpdates = lllllllllllllIlIlIllIIIIlIllIlIl;
        this.set("checkforupdates", lllllllllllllIlIlIllIIIIlIllIlIl);
    }
    
    @Override
    public int getPistonReplacementId() {
        return this.pistonReplacementId;
    }
    
    @Override
    public int getTrackingPeriod() {
        return this.trackingPeriod;
    }
    
    @Override
    public boolean isHologramPatch() {
        return this.hologramPatch;
    }
    
    @Override
    public boolean isNoDelayShieldBlocking() {
        return this.noDelayShieldBlocking;
    }
    
    @Override
    public boolean isShowNewDeathMessages() {
        return this.useNewDeathmessages;
    }
    
    @Override
    public boolean is1_9HitboxFix() {
        return false;
    }
    
    @Override
    public boolean isStemWhenBlockAbove() {
        return this.flowerStemWhenBlockAbove;
    }
    
    @Override
    public boolean is1_12QuickMoveActionFix() {
        return false;
    }
    
    @Override
    public boolean is1_15InstantRespawn() {
        return this.instantRespawn;
    }
    
    @Override
    public boolean isShowShieldWhenSwordInHand() {
        return this.showShieldWhenSwordInHand;
    }
    
    @Override
    public boolean isForcedUse1_17ResourcePack() {
        return this.forcedUse1_17ResourcePack;
    }
    
    @Override
    public boolean isNonFullBlockLightFix() {
        return this.fullBlockLightFix;
    }
    
    @Override
    public boolean isItemCache() {
        return this.itemCache;
    }
    
    @Override
    public boolean isMinimizeCooldown() {
        return this.minimizeCooldown;
    }
    
    @Override
    public String getReloadDisconnectMsg() {
        return this.reloadDisconnectMessage;
    }
    
    @Override
    public boolean isVineClimbFix() {
        return this.vineClimbFix;
    }
    
    @Override
    public boolean isTruncate1_14Books() {
        return this.truncate1_14Books;
    }
    
    @Override
    public boolean isAntiXRay() {
        return false;
    }
    
    @Override
    public boolean isPreventCollision() {
        return this.preventCollision;
    }
    
    @Override
    public JsonElement get1_17ResourcePackPrompt() {
        return this.resourcePack1_17PromptMessage;
    }
    
    @Override
    public double getHologramYOffset() {
        return this.hologramOffset;
    }
    
    @Override
    public boolean isSuppressConversionWarnings() {
        return this.suppressConversionWarnings;
    }
    
    protected void loadFields() {
        this.checkForUpdates = this.getBoolean("checkforupdates", true);
        this.preventCollision = this.getBoolean("prevent-collision", true);
        this.useNewEffectIndicator = this.getBoolean("use-new-effect-indicator", true);
        this.useNewDeathmessages = this.getBoolean("use-new-deathmessages", true);
        this.suppressMetadataErrors = this.getBoolean("suppress-metadata-errors", false);
        this.shieldBlocking = this.getBoolean("shield-blocking", true);
        this.noDelayShieldBlocking = this.getBoolean("no-delay-shield-blocking", false);
        this.showShieldWhenSwordInHand = this.getBoolean("show-shield-when-sword-in-hand", false);
        this.hologramPatch = this.getBoolean("hologram-patch", false);
        this.pistonAnimationPatch = this.getBoolean("piston-animation-patch", false);
        this.bossbarPatch = this.getBoolean("bossbar-patch", true);
        this.bossbarAntiFlicker = this.getBoolean("bossbar-anti-flicker", false);
        this.hologramOffset = this.getDouble("hologram-y", -0.96);
        this.maxPPS = this.getInt("max-pps", 800);
        this.maxPPSKickMessage = this.getString("max-pps-kick-msg", "Sending packets too fast? lag?");
        this.trackingPeriod = this.getInt("tracking-period", 6);
        this.warningPPS = this.getInt("tracking-warning-pps", 120);
        this.maxPPSWarnings = this.getInt("tracking-max-warnings", 3);
        this.maxPPSWarningsKickMessage = this.getString("tracking-max-kick-msg", "You are sending too many packets, :(");
        this.sendSupportedVersions = this.getBoolean("send-supported-versions", false);
        this.simulatePlayerTick = this.getBoolean("simulate-pt", true);
        this.itemCache = this.getBoolean("item-cache", true);
        this.nmsPlayerTicking = this.getBoolean("nms-player-ticking", true);
        this.replacePistons = this.getBoolean("replace-pistons", false);
        this.pistonReplacementId = this.getInt("replacement-piston-id", 0);
        this.autoTeam = this.getBoolean("auto-team", true);
        this.forceJsonTransform = this.getBoolean("force-json-transform", false);
        this.nbtArrayFix = this.getBoolean("chat-nbt-fix", true);
        this.blockedProtocols = new IntOpenHashSet(this.getIntegerList("block-protocols"));
        this.blockedDisconnectMessage = this.getString("block-disconnect-msg", "You are using an unsupported Minecraft version!");
        this.reloadDisconnectMessage = this.getString("reload-disconnect-msg", "Server reload, please rejoin!");
        this.minimizeCooldown = this.getBoolean("minimize-cooldown", true);
        this.teamColourFix = this.getBoolean("team-colour-fix", true);
        this.suppressConversionWarnings = this.getBoolean("suppress-conversion-warnings", false);
        this.disable1_13TabComplete = this.getBoolean("disable-1_13-auto-complete", false);
        this.serversideBlockConnections = this.getBoolean("serverside-blockconnections", true);
        this.reduceBlockStorageMemory = this.getBoolean("reduce-blockstorage-memory", false);
        this.flowerStemWhenBlockAbove = this.getBoolean("flowerstem-when-block-above", false);
        this.vineClimbFix = this.getBoolean("vine-climb-fix", false);
        this.snowCollisionFix = this.getBoolean("fix-low-snow-collision", false);
        this.infestedBlocksFix = this.getBoolean("fix-infested-block-breaking", true);
        this.tabCompleteDelay = this.getInt("1_13-tab-complete-delay", 0);
        this.truncate1_14Books = this.getBoolean("truncate-1_14-books", false);
        this.leftHandedHandling = this.getBoolean("left-handed-handling", true);
        this.fullBlockLightFix = this.getBoolean("fix-non-full-blocklight", false);
        this.healthNaNFix = this.getBoolean("fix-1_14-health-nan", true);
        this.instantRespawn = this.getBoolean("use-1_15-instant-respawn", false);
        this.ignoreLongChannelNames = this.getBoolean("ignore-long-1_16-channel-names", true);
        this.forcedUse1_17ResourcePack = this.getBoolean("forced-use-1_17-resource-pack", false);
        this.resourcePack1_17PromptMessage = this.getSerializedComponent("resource-pack-1_17-prompt");
    }
    
    @Override
    public boolean is1_12NBTArrayFix() {
        return this.nbtArrayFix;
    }
    
    @Override
    public boolean isReduceBlockStorageMemory() {
        return this.reduceBlockStorageMemory;
    }
    
    @Override
    public boolean isCheckForUpdates() {
        return this.checkForUpdates;
    }
    
    @Override
    public boolean isForceJsonTransform() {
        return this.forceJsonTransform;
    }
    
    @Override
    public boolean isNMSPlayerTicking() {
        return this.nmsPlayerTicking;
    }
}
