package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.client.*;
import net.minecraft.entity.item.*;
import optifine.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterEnderCrystalNoBase extends ModelAdapterEnderCrystal
{
    @Override
    public ModelBase makeModel() {
        return new ModelEnderCrystal(0.0f, false);
    }
    
    public ModelAdapterEnderCrystalNoBase() {
        super("end_crystal_no_base");
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llIIlllIIlIIllI, final float llIIlllIIlIIlIl) {
        final RenderManager llIIlllIIlIIlII = Minecraft.getMinecraft().getRenderManager();
        final Render llIIlllIIlIIIll = llIIlllIIlIIlII.getEntityRenderMap().get(EntityEnderCrystal.class);
        if (!(llIIlllIIlIIIll instanceof RenderEnderCrystal)) {
            Config.warn(String.valueOf(new StringBuilder("Not an instance of RenderEnderCrystal: ").append(llIIlllIIlIIIll)));
            return null;
        }
        final RenderEnderCrystal llIIlllIIlIIIlI = (RenderEnderCrystal)llIIlllIIlIIIll;
        if (!Reflector.RenderEnderCrystal_modelEnderCrystalNoBase.exists()) {
            Config.warn("Field not found: RenderEnderCrystal.modelEnderCrystalNoBase");
            return null;
        }
        Reflector.setFieldValue(llIIlllIIlIIIlI, Reflector.RenderEnderCrystal_modelEnderCrystalNoBase, llIIlllIIlIIllI);
        llIIlllIIlIIIlI.shadowSize = llIIlllIIlIIlIl;
        return llIIlllIIlIIIlI;
    }
}
