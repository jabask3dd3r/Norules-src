package net.minecraft.client.entity;

import net.minecraft.entity.player.*;
import net.minecraft.client.network.*;
import com.mojang.authlib.*;
import net.minecraft.util.*;
import net.minecraft.client.resources.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.entity.ai.attributes.*;
import optifine.*;
import javax.annotation.*;
import net.minecraft.client.*;
import java.io.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.world.*;

public abstract class AbstractClientPlayer extends EntityPlayer
{
    private /* synthetic */ ResourceLocation locationOfCape;
    private /* synthetic */ String nameClear;
    private /* synthetic */ NetworkPlayerInfo playerInfo;
    
    public AbstractClientPlayer(final World llllllllllllllIIIlllIllllIlIIlII, final GameProfile llllllllllllllIIIlllIllllIlIIIll) {
        super(llllllllllllllIIIlllIllllIlIIlII, llllllllllllllIIIlllIllllIlIIIll);
        this.locationOfCape = null;
        this.nameClear = null;
        this.nameClear = llllllllllllllIIIlllIllllIlIIIll.getName();
        if (this.nameClear != null && !this.nameClear.isEmpty()) {
            this.nameClear = StringUtils.stripControlCodes(this.nameClear);
        }
        CapeUtils.downloadCape(this);
        PlayerConfigurations.getPlayerConfiguration(this);
    }
    
    public ResourceLocation getLocationOfCape() {
        return this.locationOfCape;
    }
    
    public boolean hasPlayerInfo() {
        return this.getPlayerInfo() != null;
    }
    
    public String getNameClear() {
        return this.nameClear;
    }
    
    public void setLocationOfCape(final ResourceLocation llllllllllllllIIIlllIlllIlIIIIll) {
        this.locationOfCape = llllllllllllllIIIlllIlllIlIIIIll;
    }
    
    public String getSkinType() {
        final NetworkPlayerInfo llllllllllllllIIIlllIlllIllIIIII = this.getPlayerInfo();
        return (llllllllllllllIIIlllIlllIllIIIII == null) ? DefaultPlayerSkin.getSkinType(this.getUniqueID()) : llllllllllllllIIIlllIlllIllIIIII.getSkinType();
    }
    
    public float getFovModifier() {
        float llllllllllllllIIIlllIlllIlIlIlll = 1.0f;
        if (this.capabilities.isFlying) {
            llllllllllllllIIIlllIlllIlIlIlll *= 1.1f;
        }
        final IAttributeInstance llllllllllllllIIIlllIlllIlIlIllI = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
        llllllllllllllIIIlllIlllIlIlIlll *= (float)((llllllllllllllIIIlllIlllIlIlIllI.getAttributeValue() / this.capabilities.getWalkSpeed() + 1.0) / 2.0);
        if (this.capabilities.getWalkSpeed() == 0.0f || Float.isNaN(llllllllllllllIIIlllIlllIlIlIlll) || Float.isInfinite(llllllllllllllIIIlllIlllIlIlIlll)) {
            llllllllllllllIIIlllIlllIlIlIlll = 1.0f;
        }
        if (this.isHandActive() && this.getActiveItemStack().getItem() == Items.BOW) {
            final int llllllllllllllIIIlllIlllIlIlIlIl = this.getItemInUseMaxCount();
            float llllllllllllllIIIlllIlllIlIlIlII = llllllllllllllIIIlllIlllIlIlIlIl / 20.0f;
            if (llllllllllllllIIIlllIlllIlIlIlII > 1.0f) {
                llllllllllllllIIIlllIlllIlIlIlII = 1.0f;
            }
            else {
                llllllllllllllIIIlllIlllIlIlIlII *= llllllllllllllIIIlllIlllIlIlIlII;
            }
            llllllllllllllIIIlllIlllIlIlIlll *= 1.0f - llllllllllllllIIIlllIlllIlIlIlII * 0.15f;
        }
        return Reflector.ForgeHooksClient_getOffsetFOV.exists() ? Reflector.callFloat(Reflector.ForgeHooksClient_getOffsetFOV, this, llllllllllllllIIIlllIlllIlIlIlll) : llllllllllllllIIIlllIlllIlIlIlll;
    }
    
    public static ResourceLocation getLocationSkin(final String llllllllllllllIIIlllIlllIllIIlIl) {
        return new ResourceLocation(String.valueOf(new StringBuilder("skins/").append(StringUtils.stripControlCodes(llllllllllllllIIIlllIlllIllIIlIl))));
    }
    
    @Nullable
    public ResourceLocation getLocationCape() {
        if (!Config.isShowCapes()) {
            return null;
        }
        if (this.locationOfCape != null) {
            return this.locationOfCape;
        }
        final NetworkPlayerInfo llllllllllllllIIIlllIlllIllllllI = this.getPlayerInfo();
        return (llllllllllllllIIIlllIlllIllllllI == null) ? null : llllllllllllllIIIlllIlllIllllllI.getLocationCape();
    }
    
    public static ThreadDownloadImageData getDownloadImageSkin(final ResourceLocation llllllllllllllIIIlllIlllIllIlllI, final String llllllllllllllIIIlllIlllIllIlIIl) {
        final TextureManager llllllllllllllIIIlllIlllIllIllII = Minecraft.getMinecraft().getTextureManager();
        ITextureObject llllllllllllllIIIlllIlllIllIlIll = llllllllllllllIIIlllIlllIllIllII.getTexture(llllllllllllllIIIlllIlllIllIlllI);
        if (llllllllllllllIIIlllIlllIllIlIll == null) {
            llllllllllllllIIIlllIlllIllIlIll = new ThreadDownloadImageData(null, String.format("http://skins.minecraft.net/MinecraftSkins/%s.png", StringUtils.stripControlCodes(llllllllllllllIIIlllIlllIllIlIIl)), DefaultPlayerSkin.getDefaultSkin(EntityPlayer.getOfflineUUID(llllllllllllllIIIlllIlllIllIlIIl)), new ImageBufferDownload());
            llllllllllllllIIIlllIlllIllIllII.loadTexture(llllllllllllllIIIlllIlllIllIlllI, llllllllllllllIIIlllIlllIllIlIll);
        }
        return (ThreadDownloadImageData)llllllllllllllIIIlllIlllIllIlIll;
    }
    
    @Nullable
    protected NetworkPlayerInfo getPlayerInfo() {
        if (this.playerInfo == null) {
            this.playerInfo = Minecraft.getMinecraft().getConnection().getPlayerInfo(this.getUniqueID());
        }
        return this.playerInfo;
    }
    
    @Override
    public boolean isCreative() {
        final NetworkPlayerInfo llllllllllllllIIIlllIllllIIlIllI = Minecraft.getMinecraft().getConnection().getPlayerInfo(this.getGameProfile().getId());
        return llllllllllllllIIIlllIllllIIlIllI != null && llllllllllllllIIIlllIllllIIlIllI.getGameType() == GameType.CREATIVE;
    }
    
    public boolean hasSkin() {
        final NetworkPlayerInfo llllllllllllllIIIlllIllllIIIlIlI = this.getPlayerInfo();
        return llllllllllllllIIIlllIllllIIIlIlI != null && llllllllllllllIIIlllIllllIIIlIlI.hasLocationSkin();
    }
    
    public boolean isPlayerInfoSet() {
        return this.getPlayerInfo() != null;
    }
    
    @Override
    public boolean isSpectator() {
        final NetworkPlayerInfo llllllllllllllIIIlllIllllIIlllII = Minecraft.getMinecraft().getConnection().getPlayerInfo(this.getGameProfile().getId());
        return llllllllllllllIIIlllIllllIIlllII != null && llllllllllllllIIIlllIllllIIlllII.getGameType() == GameType.SPECTATOR;
    }
    
    public ResourceLocation getLocationSkin() {
        final NetworkPlayerInfo llllllllllllllIIIlllIllllIIIIlII = this.getPlayerInfo();
        return (llllllllllllllIIIlllIllllIIIIlII == null) ? DefaultPlayerSkin.getDefaultSkin(this.getUniqueID()) : llllllllllllllIIIlllIllllIIIIlII.getLocationSkin();
    }
    
    @Nullable
    public ResourceLocation getLocationElytra() {
        final NetworkPlayerInfo llllllllllllllIIIlllIlllIlllIlIl = this.getPlayerInfo();
        return (llllllllllllllIIIlllIlllIlllIlIl == null) ? null : llllllllllllllIIIlllIlllIlllIlIl.getLocationElytra();
    }
    
    static {
        TEXTURE_ELYTRA = new ResourceLocation("textures/entity/elytra.png");
    }
    
    public boolean hasElytraCape() {
        final ResourceLocation llllllllllllllIIIlllIlllIIllllll = this.getLocationCape();
        return llllllllllllllIIIlllIlllIIllllll != null && llllllllllllllIIIlllIlllIIllllll != this.locationOfCape;
    }
}
