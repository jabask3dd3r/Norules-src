package net.minecraft.entity;

import net.minecraft.block.material.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;

public enum EnumCreatureType
{
    AMBIENT((Class<? extends IAnimals>)EntityAmbientCreature.class, 15, Material.AIR, true, false);
    
    private final /* synthetic */ Class<? extends IAnimals> creatureClass;
    private final /* synthetic */ int maxNumberOfCreature;
    
    WATER_CREATURE((Class<? extends IAnimals>)EntityWaterMob.class, 5, Material.WATER, true, false);
    
    private final /* synthetic */ Material creatureMaterial;
    private final /* synthetic */ boolean isAnimal;
    
    MONSTER((Class<? extends IAnimals>)IMob.class, 70, Material.AIR, false, false);
    
    private final /* synthetic */ boolean isPeacefulCreature;
    
    CREATURE((Class<? extends IAnimals>)EntityAnimal.class, 10, Material.AIR, true, true);
    
    public boolean getPeacefulCreature() {
        return this.isPeacefulCreature;
    }
    
    public Class<? extends IAnimals> getCreatureClass() {
        return this.creatureClass;
    }
    
    public int getMaxNumberOfCreature() {
        return this.maxNumberOfCreature;
    }
    
    private EnumCreatureType(final Class<? extends IAnimals> lllllllllllllllIIIlllllIlIllIIlI, final int lllllllllllllllIIIlllllIlIlllIIl, final Material lllllllllllllllIIIlllllIlIlllIII, final boolean lllllllllllllllIIIlllllIlIlIllll, final boolean lllllllllllllllIIIlllllIlIllIllI) {
        this.creatureClass = lllllllllllllllIIIlllllIlIllIIlI;
        this.maxNumberOfCreature = lllllllllllllllIIIlllllIlIlllIIl;
        this.creatureMaterial = lllllllllllllllIIIlllllIlIlllIII;
        this.isPeacefulCreature = lllllllllllllllIIIlllllIlIlIllll;
        this.isAnimal = lllllllllllllllIIIlllllIlIllIllI;
    }
    
    public boolean getAnimal() {
        return this.isAnimal;
    }
}
