package optifine;

import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.minecraft.client.entity.*;
import java.awt.image.*;

public class CapeImageBuffer extends ImageBufferDownload
{
    private /* synthetic */ ResourceLocation resourceLocation;
    private /* synthetic */ AbstractClientPlayer player;
    
    public void cleanup() {
        this.player = null;
    }
    
    @Override
    public BufferedImage parseUserSkin(final BufferedImage lllllllllllllllIlIlllIIlIlIIIlIl) {
        return CapeUtils.parseCape(lllllllllllllllIlIlllIIlIlIIIlIl);
    }
    
    @Override
    public void skinAvailable() {
        if (this.player != null) {
            this.player.setLocationOfCape(this.resourceLocation);
        }
    }
    
    public CapeImageBuffer(final AbstractClientPlayer lllllllllllllllIlIlllIIlIlIIlIIl, final ResourceLocation lllllllllllllllIlIlllIIlIlIIlIII) {
        this.player = lllllllllllllllIlIlllIIlIlIIlIIl;
        this.resourceLocation = lllllllllllllllIlIlllIIlIlIIlIII;
    }
}
