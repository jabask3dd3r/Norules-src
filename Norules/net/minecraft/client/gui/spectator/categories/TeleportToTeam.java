package net.minecraft.client.gui.spectator.categories;

import net.minecraft.client.*;
import com.google.common.collect.*;
import net.minecraft.scoreboard.*;
import net.minecraft.client.gui.spectator.*;
import net.minecraft.util.*;
import net.minecraft.client.network.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.entity.*;
import net.minecraft.util.text.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;
import java.util.*;

public class TeleportToTeam implements ISpectatorMenuObject, ISpectatorMenuView
{
    private final /* synthetic */ List<ISpectatorMenuObject> items;
    
    @Override
    public void renderIcon(final float lllllllllllllIIIIIlIIIIllIIIllIl, final int lllllllllllllIIIIIlIIIIllIIIllII) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(GuiSpectator.SPECTATOR_WIDGETS);
        Gui.drawModalRectWithCustomSizedTexture(0.0, 0.0, 16.0f, 0.0f, 16, 16, 256.0f, 256.0f);
    }
    
    public TeleportToTeam() {
        this.items = (List<ISpectatorMenuObject>)Lists.newArrayList();
        final Minecraft lllllllllllllIIIIIlIIIIllIIlllll = Minecraft.getMinecraft();
        for (final ScorePlayerTeam lllllllllllllIIIIIlIIIIllIIllllI : lllllllllllllIIIIIlIIIIllIIlllll.world.getScoreboard().getTeams()) {
            this.items.add(new TeamSelectionObject(lllllllllllllIIIIIlIIIIllIIllllI));
        }
    }
    
    @Override
    public ITextComponent getSpectatorName() {
        return new TextComponentTranslation("spectatorMenu.team_teleport", new Object[0]);
    }
    
    @Override
    public List<ISpectatorMenuObject> getItems() {
        return this.items;
    }
    
    @Override
    public void selectItem(final SpectatorMenu lllllllllllllIIIIIlIIIIllIIlIIlI) {
        lllllllllllllIIIIIlIIIIllIIlIIlI.selectCategory(this);
    }
    
    @Override
    public boolean isEnabled() {
        for (final ISpectatorMenuObject lllllllllllllIIIIIlIIIIllIIIIlll : this.items) {
            if (lllllllllllllIIIIIlIIIIllIIIIlll.isEnabled()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public ITextComponent getPrompt() {
        return new TextComponentTranslation("spectatorMenu.team_teleport.prompt", new Object[0]);
    }
    
    class TeamSelectionObject implements ISpectatorMenuObject
    {
        private final /* synthetic */ ResourceLocation location;
        private final /* synthetic */ ScorePlayerTeam team;
        private final /* synthetic */ List<NetworkPlayerInfo> players;
        
        @Override
        public boolean isEnabled() {
            return !this.players.isEmpty();
        }
        
        public TeamSelectionObject(final ScorePlayerTeam lllllllllllllIlIIIIIIlIllIlIllII) {
            this.team = lllllllllllllIlIIIIIIlIllIlIllII;
            this.players = (List<NetworkPlayerInfo>)Lists.newArrayList();
            for (final String lllllllllllllIlIIIIIIlIllIlIlIll : lllllllllllllIlIIIIIIlIllIlIllII.getMembershipCollection()) {
                final NetworkPlayerInfo lllllllllllllIlIIIIIIlIllIlIlIlI = Minecraft.getMinecraft().getConnection().getPlayerInfo(lllllllllllllIlIIIIIIlIllIlIlIll);
                if (lllllllllllllIlIIIIIIlIllIlIlIlI != null) {
                    this.players.add(lllllllllllllIlIIIIIIlIllIlIlIlI);
                }
            }
            if (this.players.isEmpty()) {
                this.location = DefaultPlayerSkin.getDefaultSkinLegacy();
            }
            else {
                final String lllllllllllllIlIIIIIIlIllIlIlIIl = this.players.get(new Random().nextInt(this.players.size())).getGameProfile().getName();
                this.location = AbstractClientPlayer.getLocationSkin(lllllllllllllIlIIIIIIlIllIlIlIIl);
                AbstractClientPlayer.getDownloadImageSkin(this.location, lllllllllllllIlIIIIIIlIllIlIlIIl);
            }
        }
        
        @Override
        public ITextComponent getSpectatorName() {
            return new TextComponentString(this.team.getTeamName());
        }
        
        @Override
        public void renderIcon(final float lllllllllllllIlIIIIIIlIllIIIlIII, final int lllllllllllllIlIIIIIIlIllIIIIlll) {
            int lllllllllllllIlIIIIIIlIllIIIlllI = -1;
            final String lllllllllllllIlIIIIIIlIllIIIllIl = FontRenderer.getFormatFromString(this.team.getColorPrefix());
            if (lllllllllllllIlIIIIIIlIllIIIllIl.length() >= 2) {
                lllllllllllllIlIIIIIIlIllIIIlllI = Minecraft.getMinecraft().fontRendererObj.getColorCode(lllllllllllllIlIIIIIIlIllIIIllIl.charAt(1));
            }
            if (lllllllllllllIlIIIIIIlIllIIIlllI >= 0) {
                final float lllllllllllllIlIIIIIIlIllIIIllII = (lllllllllllllIlIIIIIIlIllIIIlllI >> 16 & 0xFF) / 255.0f;
                final float lllllllllllllIlIIIIIIlIllIIIlIll = (lllllllllllllIlIIIIIIlIllIIIlllI >> 8 & 0xFF) / 255.0f;
                final float lllllllllllllIlIIIIIIlIllIIIlIlI = (lllllllllllllIlIIIIIIlIllIIIlllI & 0xFF) / 255.0f;
                Gui.drawRect(1.0, 1.0, 15.0, 15.0, MathHelper.rgb(lllllllllllllIlIIIIIIlIllIIIllII * lllllllllllllIlIIIIIIlIllIIIlIII, lllllllllllllIlIIIIIIlIllIIIlIll * lllllllllllllIlIIIIIIlIllIIIlIII, lllllllllllllIlIIIIIIlIllIIIlIlI * lllllllllllllIlIIIIIIlIllIIIlIII) | lllllllllllllIlIIIIIIlIllIIIIlll << 24);
            }
            Minecraft.getMinecraft().getTextureManager().bindTexture(this.location);
            GlStateManager.color(lllllllllllllIlIIIIIIlIllIIIlIII, lllllllllllllIlIIIIIIlIllIIIlIII, lllllllllllllIlIIIIIIlIllIIIlIII, lllllllllllllIlIIIIIIlIllIIIIlll / 255.0f);
            Gui.drawScaledCustomSizeModalRect(2, 2, 8.0f, 8.0f, 8, 8, 12, 12, 64.0f, 64.0f);
            Gui.drawScaledCustomSizeModalRect(2, 2, 40.0f, 8.0f, 8, 8, 12, 12, 64.0f, 64.0f);
        }
        
        @Override
        public void selectItem(final SpectatorMenu lllllllllllllIlIIIIIIlIllIIlllIl) {
            lllllllllllllIlIIIIIIlIllIIlllIl.selectCategory(new TeleportToPlayer(this.players));
        }
    }
}
