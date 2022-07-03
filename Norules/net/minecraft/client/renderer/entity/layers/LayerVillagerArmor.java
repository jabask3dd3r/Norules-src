package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.*;

public class LayerVillagerArmor extends LayerBipedArmor
{
    @Override
    protected void initArmor() {
        this.modelLeggings = (T)new ModelZombieVillager(0.5f, 0.0f, true);
        this.modelArmor = (T)new ModelZombieVillager(1.0f, 0.0f, true);
    }
    
    public LayerVillagerArmor(final RenderLivingBase<?> lllllllllllllIlIIIIlIIlllIllIIlI) {
        super(lllllllllllllIlIIIIlIIlllIllIIlI);
    }
}
