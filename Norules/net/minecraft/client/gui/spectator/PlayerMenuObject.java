package net.minecraft.client.gui.spectator;

import com.mojang.authlib.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.text.*;
import net.minecraft.client.entity.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;

public class PlayerMenuObject implements ISpectatorMenuObject
{
    private final /* synthetic */ GameProfile profile;
    private final /* synthetic */ ResourceLocation resourceLocation;
    
    @Override
    public void renderIcon(final float lllllllllllllIIlIIIllllIlIIIlIII, final int lllllllllllllIIlIIIllllIlIIIIlIl) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.resourceLocation);
        GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllllIIlIIIllllIlIIIIlIl / 255.0f);
        Gui.drawScaledCustomSizeModalRect(2, 2, 8.0f, 8.0f, 8, 8, 12, 12, 64.0f, 64.0f);
        Gui.drawScaledCustomSizeModalRect(2, 2, 40.0f, 8.0f, 8, 8, 12, 12, 64.0f, 64.0f);
    }
    
    @Override
    public ITextComponent getSpectatorName() {
        return new TextComponentString(this.profile.getName());
    }
    
    public PlayerMenuObject(final GameProfile lllllllllllllIIlIIIllllIlIIlIIll) {
        this.profile = lllllllllllllIIlIIIllllIlIIlIIll;
        this.resourceLocation = AbstractClientPlayer.getLocationSkin(lllllllllllllIIlIIIllllIlIIlIIll.getName());
        AbstractClientPlayer.getDownloadImageSkin(this.resourceLocation, lllllllllllllIIlIIIllllIlIIlIIll.getName());
    }
    
    @Override
    public boolean isEnabled() {
        return true;
    }
    
    @Override
    public void selectItem(final SpectatorMenu lllllllllllllIIlIIIllllIlIIlIIII) {
        Minecraft.getMinecraft().getConnection().sendPacket(new CPacketSpectate(this.profile.getId()));
    }
}
