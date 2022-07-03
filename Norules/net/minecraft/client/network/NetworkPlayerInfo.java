package net.minecraft.client.network;

import com.mojang.authlib.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import java.util.*;
import com.mojang.authlib.minecraft.*;
import net.minecraft.util.*;
import com.google.common.base.*;
import javax.annotation.*;
import com.google.common.collect.*;
import net.minecraft.network.play.server.*;
import net.minecraft.client.*;
import net.minecraft.client.resources.*;
import net.minecraft.scoreboard.*;

public class NetworkPlayerInfo
{
    private final /* synthetic */ GameProfile gameProfile;
    private /* synthetic */ long renderVisibilityId;
    private /* synthetic */ int lastHealth;
    private /* synthetic */ boolean playerTexturesLoaded;
    private /* synthetic */ ITextComponent displayName;
    private /* synthetic */ int displayHealth;
    private /* synthetic */ long lastHealthTime;
    private /* synthetic */ String skinType;
    private /* synthetic */ int responseTime;
    private /* synthetic */ GameType gameType;
    /* synthetic */ Map<MinecraftProfileTexture.Type, ResourceLocation> playerTextures;
    private /* synthetic */ long healthBlinkTime;
    
    public ResourceLocation getLocationSkin() {
        this.loadPlayerTextures();
        return (ResourceLocation)MoreObjects.firstNonNull((Object)this.playerTextures.get(MinecraftProfileTexture.Type.SKIN), (Object)DefaultPlayerSkin.getDefaultSkin(this.gameProfile.getId()));
    }
    
    public boolean hasLocationSkin() {
        return this.getLocationSkin() != null;
    }
    
    @Nullable
    public ResourceLocation getLocationElytra() {
        this.loadPlayerTextures();
        return this.playerTextures.get(MinecraftProfileTexture.Type.ELYTRA);
    }
    
    public GameProfile getGameProfile() {
        return this.gameProfile;
    }
    
    public long getHealthBlinkTime() {
        return this.healthBlinkTime;
    }
    
    public int getResponseTime() {
        return this.responseTime;
    }
    
    public String getSkinType() {
        return (this.skinType == null) ? DefaultPlayerSkin.getSkinType(this.gameProfile.getId()) : this.skinType;
    }
    
    public void setDisplayName(@Nullable final ITextComponent llllllllllllllIIIIllIlIlIlIIlIlI) {
        this.displayName = llllllllllllllIIIIllIlIlIlIIlIlI;
    }
    
    static /* synthetic */ void access$0(final NetworkPlayerInfo llllllllllllllIIIIllIlIlIIIlIlll, final String llllllllllllllIIIIllIlIlIIIlIllI) {
        llllllllllllllIIIIllIlIlIIIlIlll.skinType = llllllllllllllIIIIllIlIlIIIlIllI;
    }
    
    public int getLastHealth() {
        return this.lastHealth;
    }
    
    public NetworkPlayerInfo(final GameProfile llllllllllllllIIIIllIlIllIIIIlII) {
        this.playerTextures = (Map<MinecraftProfileTexture.Type, ResourceLocation>)Maps.newEnumMap((Class)MinecraftProfileTexture.Type.class);
        this.gameProfile = llllllllllllllIIIIllIlIllIIIIlII;
    }
    
    public NetworkPlayerInfo(final SPacketPlayerListItem.AddPlayerData llllllllllllllIIIIllIlIlIllllllI) {
        this.playerTextures = (Map<MinecraftProfileTexture.Type, ResourceLocation>)Maps.newEnumMap((Class)MinecraftProfileTexture.Type.class);
        this.gameProfile = llllllllllllllIIIIllIlIlIllllllI.getProfile();
        this.gameType = llllllllllllllIIIIllIlIlIllllllI.getGameMode();
        this.responseTime = llllllllllllllIIIIllIlIlIllllllI.getPing();
        this.displayName = llllllllllllllIIIIllIlIlIllllllI.getDisplayName();
    }
    
    public void setLastHealthTime(final long llllllllllllllIIIIllIlIlIIlIlllI) {
        this.lastHealthTime = llllllllllllllIIIIllIlIlIIlIlllI;
    }
    
    public long getLastHealthTime() {
        return this.lastHealthTime;
    }
    
    protected void setGameType(final GameType llllllllllllllIIIIllIlIlIlllIIII) {
        this.gameType = llllllllllllllIIIIllIlIlIlllIIII;
    }
    
    @Nullable
    public ITextComponent getDisplayName() {
        return this.displayName;
    }
    
    public void setHealthBlinkTime(final long llllllllllllllIIIIllIlIlIIlIIIll) {
        this.healthBlinkTime = llllllllllllllIIIIllIlIlIIlIIIll;
    }
    
    protected void setResponseTime(final int llllllllllllllIIIIllIlIlIllIIlll) {
        this.responseTime = llllllllllllllIIIIllIlIlIllIIlll;
    }
    
    protected void loadPlayerTextures() {
        final double llllllllllllllIIIIllIlIlIlIlIIII = (double)this;
        synchronized (this) {
            if (!this.playerTexturesLoaded) {
                this.playerTexturesLoaded = true;
                Minecraft.getMinecraft().getSkinManager().loadProfileTextures(this.gameProfile, new SkinManager.SkinAvailableCallback() {
                    private static volatile /* synthetic */ int[] $SWITCH_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type;
                    
                    @Override
                    public void skinAvailable(final MinecraftProfileTexture.Type lIlIIIIlIIllIlI, final ResourceLocation lIlIIIIlIIlllIl, final MinecraftProfileTexture lIlIIIIlIIllIII) {
                        switch ($SWITCH_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type()[lIlIIIIlIIllIlI.ordinal()]) {
                            case 1: {
                                NetworkPlayerInfo.this.playerTextures.put(MinecraftProfileTexture.Type.SKIN, lIlIIIIlIIlllIl);
                                NetworkPlayerInfo.access$0(NetworkPlayerInfo.this, lIlIIIIlIIllIII.getMetadata("model"));
                                if (NetworkPlayerInfo.this.skinType == null) {
                                    NetworkPlayerInfo.access$0(NetworkPlayerInfo.this, "default");
                                    break;
                                }
                                break;
                            }
                            case 2: {
                                NetworkPlayerInfo.this.playerTextures.put(MinecraftProfileTexture.Type.CAPE, lIlIIIIlIIlllIl);
                                break;
                            }
                            case 3: {
                                NetworkPlayerInfo.this.playerTextures.put(MinecraftProfileTexture.Type.ELYTRA, lIlIIIIlIIlllIl);
                                break;
                            }
                        }
                    }
                    
                    static /* synthetic */ int[] $SWITCH_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type() {
                        final int[] $switch_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type = NetworkPlayerInfo$1.$SWITCH_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type;
                        if ($switch_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type != null) {
                            return $switch_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type;
                        }
                        final long lIlIIIIlIIlIllI = (Object)new int[MinecraftProfileTexture.Type.values().length];
                        try {
                            lIlIIIIlIIlIllI[MinecraftProfileTexture.Type.CAPE.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError noSuchFieldError) {}
                        try {
                            lIlIIIIlIIlIllI[MinecraftProfileTexture.Type.ELYTRA.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError noSuchFieldError2) {}
                        try {
                            lIlIIIIlIIlIllI[MinecraftProfileTexture.Type.SKIN.ordinal()] = true;
                        }
                        catch (NoSuchFieldError noSuchFieldError3) {}
                        return NetworkPlayerInfo$1.$SWITCH_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type = (int[])(Object)lIlIIIIlIIlIllI;
                    }
                }, true);
            }
        }
    }
    
    @Nullable
    public ResourceLocation getLocationCape() {
        this.loadPlayerTextures();
        return this.playerTextures.get(MinecraftProfileTexture.Type.CAPE);
    }
    
    public GameType getGameType() {
        return this.gameType;
    }
    
    public void setLastHealth(final int llllllllllllllIIIIllIlIlIIlllllI) {
        this.lastHealth = llllllllllllllIIIIllIlIlIIlllllI;
    }
    
    public void setRenderVisibilityId(final long llllllllllllllIIIIllIlIlIIIlllII) {
        this.renderVisibilityId = llllllllllllllIIIIllIlIlIIIlllII;
    }
    
    public void setDisplayHealth(final int llllllllllllllIIIIllIlIlIIllIlIl) {
        this.displayHealth = llllllllllllllIIIIllIlIlIIllIlIl;
    }
    
    @Nullable
    public ScorePlayerTeam getPlayerTeam() {
        return Minecraft.getMinecraft().world.getScoreboard().getPlayersTeam(this.getGameProfile().getName());
    }
    
    public long getRenderVisibilityId() {
        return this.renderVisibilityId;
    }
    
    public int getDisplayHealth() {
        return this.displayHealth;
    }
}
