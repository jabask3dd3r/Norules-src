package optifine;

import net.minecraft.client.renderer.entity.layers.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.*;

public class PlayerItemsLayer implements LayerRenderer
{
    private /* synthetic */ RenderPlayer renderPlayer;
    
    public PlayerItemsLayer(final RenderPlayer lllllllllllllIlIlIIlIIIlIIIIIllI) {
        this.renderPlayer = null;
        this.renderPlayer = lllllllllllllIlIlIIlIIIlIIIIIllI;
    }
    
    public static void register(final Map lllllllllllllIlIlIIlIIIIllIIllII) {
        final Set lllllllllllllIlIlIIlIIIIllIIlIll = lllllllllllllIlIlIIlIIIIllIIllII.keySet();
        boolean lllllllllllllIlIlIIlIIIIllIIlIlI = false;
        for (final Object lllllllllllllIlIlIIlIIIIllIIlIIl : lllllllllllllIlIlIIlIIIIllIIlIll) {
            final Object lllllllllllllIlIlIIlIIIIllIIlIII = lllllllllllllIlIlIIlIIIIllIIllII.get(lllllllllllllIlIlIIlIIIIllIIlIIl);
            if (lllllllllllllIlIlIIlIIIIllIIlIII instanceof RenderPlayer) {
                final RenderPlayer lllllllllllllIlIlIIlIIIIllIIIlll = (RenderPlayer)lllllllllllllIlIlIIlIIIIllIIlIII;
                ((RenderLivingBase<EntityLivingBase>)lllllllllllllIlIlIIlIIIIllIIIlll).addLayer(new PlayerItemsLayer(lllllllllllllIlIlIIlIIIIllIIIlll));
                lllllllllllllIlIlIIlIIIIllIIlIlI = true;
            }
        }
        if (!lllllllllllllIlIlIIlIIIIllIIlIlI) {
            Config.warn("PlayerItemsLayer not registered");
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase lllllllllllllIlIlIIlIIIIlllllIlI, final float lllllllllllllIlIlIIlIIIIlllllIII, final float lllllllllllllIlIlIIlIIIIllllIllI, final float lllllllllllllIlIlIIlIIIIllllIlIl, final float lllllllllllllIlIlIIlIIIIllllIlII, final float lllllllllllllIlIlIIlIIIIllllIIlI, final float lllllllllllllIlIlIIlIIIIllllIIII, final float lllllllllllllIlIlIIlIIIIlllIIlll) {
        this.renderEquippedItems(lllllllllllllIlIlIIlIIIIlllllIlI, lllllllllllllIlIlIIlIIIIlllIIlll, lllllllllllllIlIlIIlIIIIllllIlIl);
    }
    
    protected void renderEquippedItems(final EntityLivingBase lllllllllllllIlIlIIlIIIIllIllIIl, final float lllllllllllllIlIlIIlIIIIllIllllI, final float lllllllllllllIlIlIIlIIIIllIlIlll) {
        if (Config.isShowCapes() && lllllllllllllIlIlIIlIIIIllIllIIl instanceof AbstractClientPlayer) {
            final AbstractClientPlayer lllllllllllllIlIlIIlIIIIllIlllII = (AbstractClientPlayer)lllllllllllllIlIlIIlIIIIllIllIIl;
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableRescaleNormal();
            GlStateManager.enableCull();
            final ModelBiped lllllllllllllIlIlIIlIIIIllIllIll = this.renderPlayer.getMainModel();
            PlayerConfigurations.renderPlayerItems(lllllllllllllIlIlIIlIIIIllIllIll, lllllllllllllIlIlIIlIIIIllIlllII, lllllllllllllIlIlIIlIIIIllIllllI, lllllllllllllIlIlIIlIIIIllIlIlll);
            GlStateManager.disableCull();
        }
    }
}
