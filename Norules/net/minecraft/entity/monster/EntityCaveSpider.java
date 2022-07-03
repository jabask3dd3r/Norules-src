package net.minecraft.entity.monster;

import javax.annotation.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.*;

public class EntityCaveSpider extends EntitySpider
{
    @Override
    public float getEyeHeight() {
        return 0.45f;
    }
    
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance lllllllllllllIlllllIIIllIllIlIII, @Nullable final IEntityLivingData lllllllllllllIlllllIIIllIllIIllI) {
        return lllllllllllllIlllllIIIllIllIIllI;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12.0);
    }
    
    public EntityCaveSpider(final World lllllllllllllIlllllIIIllIlllllII) {
        super(lllllllllllllIlllllIIIllIlllllII);
        this.setSize(0.7f, 0.5f);
    }
    
    public static void registerFixesCaveSpider(final DataFixer lllllllllllllIlllllIIIllIlllIlll) {
        EntityLiving.registerFixesMob(lllllllllllllIlllllIIIllIlllIlll, EntityCaveSpider.class);
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity lllllllllllllIlllllIIIllIllIllll) {
        if (super.attackEntityAsMob(lllllllllllllIlllllIIIllIllIllll)) {
            if (lllllllllllllIlllllIIIllIllIllll instanceof EntityLivingBase) {
                int lllllllllllllIlllllIIIllIllIlllI = 0;
                if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
                    lllllllllllllIlllllIIIllIllIlllI = 7;
                }
                else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
                    lllllllllllllIlllllIIIllIllIlllI = 15;
                }
                if (lllllllllllllIlllllIIIllIllIlllI > 0) {
                    ((EntityLivingBase)lllllllllllllIlllllIIIllIllIllll).addPotionEffect(new PotionEffect(MobEffects.POISON, lllllllllllllIlllllIIIllIllIlllI * 20, 0));
                }
            }
            return true;
        }
        return false;
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_CAVE_SPIDER;
    }
}
