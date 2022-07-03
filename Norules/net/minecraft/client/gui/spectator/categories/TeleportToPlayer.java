package net.minecraft.client.gui.spectator.categories;

import net.minecraft.client.network.*;
import net.minecraft.world.*;
import net.minecraft.client.*;
import net.minecraft.util.text.*;
import net.minecraft.client.gui.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.client.gui.spectator.*;

public class TeleportToPlayer implements ISpectatorMenuObject, ISpectatorMenuView
{
    private static final /* synthetic */ Ordering<NetworkPlayerInfo> PROFILE_ORDER;
    private final /* synthetic */ List<ISpectatorMenuObject> items;
    
    @Override
    public List<ISpectatorMenuObject> getItems() {
        return this.items;
    }
    
    public TeleportToPlayer(final Collection<NetworkPlayerInfo> lllIIIlIIlIII) {
        this.items = (List<ISpectatorMenuObject>)Lists.newArrayList();
        for (final NetworkPlayerInfo lllIIIlIIIlll : TeleportToPlayer.PROFILE_ORDER.sortedCopy((Iterable)lllIIIlIIlIII)) {
            if (lllIIIlIIIlll.getGameType() != GameType.SPECTATOR) {
                this.items.add(new PlayerMenuObject(lllIIIlIIIlll.getGameProfile()));
            }
        }
    }
    
    public TeleportToPlayer() {
        this(TeleportToPlayer.PROFILE_ORDER.sortedCopy((Iterable)Minecraft.getMinecraft().getConnection().getPlayerInfoMap()));
    }
    
    @Override
    public ITextComponent getSpectatorName() {
        return new TextComponentTranslation("spectatorMenu.teleport", new Object[0]);
    }
    
    @Override
    public ITextComponent getPrompt() {
        return new TextComponentTranslation("spectatorMenu.teleport.prompt", new Object[0]);
    }
    
    @Override
    public void renderIcon(final float lllIIIIllIllI, final int lllIIIIllIlIl) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(GuiSpectator.SPECTATOR_WIDGETS);
        Gui.drawModalRectWithCustomSizedTexture(0.0, 0.0, 0.0f, 0.0f, 16, 16, 256.0f, 256.0f);
    }
    
    static {
        PROFILE_ORDER = Ordering.from((Comparator)new Comparator<NetworkPlayerInfo>() {
            @Override
            public int compare(final NetworkPlayerInfo lllllllllllllIllIIlIIIlIIIlIIlll, final NetworkPlayerInfo lllllllllllllIllIIlIIIlIIIlIIllI) {
                return ComparisonChain.start().compare((Comparable)lllllllllllllIllIIlIIIlIIIlIIlll.getGameProfile().getId(), (Comparable)lllllllllllllIllIIlIIIlIIIlIIllI.getGameProfile().getId()).result();
            }
        });
    }
    
    @Override
    public boolean isEnabled() {
        return !this.items.isEmpty();
    }
    
    @Override
    public void selectItem(final SpectatorMenu lllIIIIlllIIl) {
        lllIIIIlllIIl.selectCategory(this);
    }
}
