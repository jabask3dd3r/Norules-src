package net.minecraft.entity.ai;

import java.util.*;
import net.minecraft.entity.*;
import com.google.common.collect.*;

public class EntitySenses
{
    /* synthetic */ List<Entity> unseenEntities;
    /* synthetic */ EntityLiving entityObj;
    /* synthetic */ List<Entity> seenEntities;
    
    public EntitySenses(final EntityLiving lllllllllllllIIlllllllIIIIllllll) {
        this.seenEntities = (List<Entity>)Lists.newArrayList();
        this.unseenEntities = (List<Entity>)Lists.newArrayList();
        this.entityObj = lllllllllllllIIlllllllIIIIllllll;
    }
    
    public boolean canSee(final Entity lllllllllllllIIlllllllIIIIllIlll) {
        if (this.seenEntities.contains(lllllllllllllIIlllllllIIIIllIlll)) {
            return true;
        }
        if (this.unseenEntities.contains(lllllllllllllIIlllllllIIIIllIlll)) {
            return false;
        }
        this.entityObj.world.theProfiler.startSection("canSee");
        final boolean lllllllllllllIIlllllllIIIIllIllI = this.entityObj.canEntityBeSeen(lllllllllllllIIlllllllIIIIllIlll);
        this.entityObj.world.theProfiler.endSection();
        if (lllllllllllllIIlllllllIIIIllIllI) {
            this.seenEntities.add(lllllllllllllIIlllllllIIIIllIlll);
        }
        else {
            this.unseenEntities.add(lllllllllllllIIlllllllIIIIllIlll);
        }
        return lllllllllllllIIlllllllIIIIllIllI;
    }
    
    public void clearSensingCache() {
        this.seenEntities.clear();
        this.unseenEntities.clear();
    }
}
