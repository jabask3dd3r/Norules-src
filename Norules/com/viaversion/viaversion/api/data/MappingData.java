package com.viaversion.viaversion.api.data;

import java.util.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.util.*;

public interface MappingData
{
    int getNewBlockStateId(final int p0);
    
    Mappings getStatisticsMappings();
    
    ParticleMappings getParticleMappings();
    
    List<TagData> getTags(final RegistryType p0);
    
    Mappings getSoundMappings();
    
    void load();
    
    Int2IntBiMap getItemMappings();
    
    Mappings getBlockStateMappings();
    
    int getNewBlockId(final int p0);
    
    int getOldItemId(final int p0);
    
    int getNewParticleId(final int p0);
    
    Mappings getBlockMappings();
    
    int getNewItemId(final int p0);
}
