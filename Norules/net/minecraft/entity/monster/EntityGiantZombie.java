package net.minecraft.entity.monster;

import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class EntityGiantZombie extends EntityMob
{
    public EntityGiantZombie(final World lllllllllllllllIIIllllIlllIIlIIl) {
        super(lllllllllllllllIIIllllIlllIIlIIl);
        this.setSize(this.width * 6.0f, this.height * 6.0f);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_GIANT;
    }
    
    @Override
    public float getEyeHeight() {
        return 10.440001f;
    }
    
    public static void registerFixesGiantZombie(final DataFixer lllllllllllllllIIIllllIlllIIIlIl) {
        EntityLiving.registerFixesMob(lllllllllllllllIIIllllIlllIIIlIl, EntityGiantZombie.class);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(50.0);
    }
    
    @Override
    public float getBlockPathWeight(final BlockPos lllllllllllllllIIIllllIllIlllIlI) {
        return this.world.getLightBrightness(lllllllllllllllIIIllllIllIlllIlI) - 0.5f;
    }
}
