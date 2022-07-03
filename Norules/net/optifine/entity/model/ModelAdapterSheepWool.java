package net.optifine.entity.model;

import net.minecraft.entity.passive.*;
import net.minecraft.client.*;
import optifine.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import java.util.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.*;

public class ModelAdapterSheepWool extends ModelAdapterQuadruped
{
    public ModelAdapterSheepWool() {
        super(EntitySheep.class, "sheep_wool", 0.7f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelSheep1();
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIIIIIlllIIlIIIllIll, final float lllllllllllllIIIIIlllIIlIIIllIlI) {
        final RenderManager lllllllllllllIIIIIlllIIlIIIllIIl = Minecraft.getMinecraft().getRenderManager();
        Render lllllllllllllIIIIIlllIIlIIIllIII = lllllllllllllIIIIIlllIIlIIIllIIl.getEntityRenderMap().get(EntitySheep.class);
        if (!(lllllllllllllIIIIIlllIIlIIIllIII instanceof RenderSheep)) {
            Config.warn(String.valueOf(new StringBuilder("Not a RenderSheep: ").append(lllllllllllllIIIIIlllIIlIIIllIII)));
            return null;
        }
        if (lllllllllllllIIIIIlllIIlIIIllIII.getEntityClass() == null) {
            final RenderSheep lllllllllllllIIIIIlllIIlIIIlIlll = new RenderSheep(lllllllllllllIIIIIlllIIlIIIllIIl);
            lllllllllllllIIIIIlllIIlIIIlIlll.mainModel = new ModelSheep2();
            lllllllllllllIIIIIlllIIlIIIlIlll.shadowSize = 0.7f;
            lllllllllllllIIIIIlllIIlIIIllIII = lllllllllllllIIIIIlllIIlIIIlIlll;
        }
        final RenderSheep lllllllllllllIIIIIlllIIlIIIlIllI = (RenderSheep)lllllllllllllIIIIIlllIIlIIIllIII;
        final List<LayerRenderer<EntitySheep>> lllllllllllllIIIIIlllIIlIIIlIlIl = lllllllllllllIIIIIlllIIlIIIlIllI.getLayerRenderers();
        final Iterator lllllllllllllIIIIIlllIIlIIIlIlII = lllllllllllllIIIIIlllIIlIIIlIlIl.iterator();
        while (lllllllllllllIIIIIlllIIlIIIlIlII.hasNext()) {
            final LayerRenderer lllllllllllllIIIIIlllIIlIIIlIIll = lllllllllllllIIIIIlllIIlIIIlIlII.next();
            if (lllllllllllllIIIIIlllIIlIIIlIIll instanceof LayerSheepWool) {
                lllllllllllllIIIIIlllIIlIIIlIlII.remove();
            }
        }
        final LayerSheepWool lllllllllllllIIIIIlllIIlIIIlIIlI = new LayerSheepWool(lllllllllllllIIIIIlllIIlIIIlIllI);
        lllllllllllllIIIIIlllIIlIIIlIIlI.sheepModel = (ModelSheep1)lllllllllllllIIIIIlllIIlIIIllIll;
        ((RenderLivingBase<EntityLivingBase>)lllllllllllllIIIIIlllIIlIIIlIllI).addLayer(lllllllllllllIIIIIlllIIlIIIlIIlI);
        return lllllllllllllIIIIIlllIIlIIIlIllI;
    }
}
