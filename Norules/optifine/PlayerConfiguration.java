package optifine;

import net.minecraft.client.model.*;
import net.minecraft.client.entity.*;

public class PlayerConfiguration
{
    private /* synthetic */ boolean initialized;
    private /* synthetic */ PlayerItemModel[] playerItemModels;
    
    public void addPlayerItemModel(final PlayerItemModel llllllllllllllllIllIIlllIIlllllI) {
        this.playerItemModels = (PlayerItemModel[])Config.addObjectToArray(this.playerItemModels, llllllllllllllllIllIIlllIIlllllI);
    }
    
    public void renderPlayerItems(final ModelBiped llllllllllllllllIllIIlllIlIlIlIl, final AbstractClientPlayer llllllllllllllllIllIIlllIlIllIll, final float llllllllllllllllIllIIlllIlIllIlI, final float llllllllllllllllIllIIlllIlIllIIl) {
        if (this.initialized) {
            for (int llllllllllllllllIllIIlllIlIllIII = 0; llllllllllllllllIllIIlllIlIllIII < this.playerItemModels.length; ++llllllllllllllllIllIIlllIlIllIII) {
                final PlayerItemModel llllllllllllllllIllIIlllIlIlIlll = this.playerItemModels[llllllllllllllllIllIIlllIlIllIII];
                llllllllllllllllIllIIlllIlIlIlll.render(llllllllllllllllIllIIlllIlIlIlIl, llllllllllllllllIllIIlllIlIllIll, llllllllllllllllIllIIlllIlIllIlI, llllllllllllllllIllIIlllIlIllIIl);
            }
        }
    }
    
    public PlayerConfiguration() {
        this.playerItemModels = new PlayerItemModel[0];
        this.initialized = false;
    }
    
    public boolean isInitialized() {
        return this.initialized;
    }
    
    public void setInitialized(final boolean llllllllllllllllIllIIlllIlIIlIIl) {
        this.initialized = llllllllllllllllIllIIlllIlIIlIIl;
    }
    
    public PlayerItemModel[] getPlayerItemModels() {
        return this.playerItemModels;
    }
}
