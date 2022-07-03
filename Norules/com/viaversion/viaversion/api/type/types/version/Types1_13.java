package com.viaversion.viaversion.api.type.types.version;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import java.util.*;
import com.viaversion.viaversion.api.type.types.minecraft.*;

public class Types1_13
{
    public static final /* synthetic */ Type<Metadata> METADATA;
    
    static {
        METADATA = new Metadata1_13Type();
        METADATA_LIST = new MetaListType(Types1_13.METADATA);
        CHUNK_SECTION = new ChunkSectionType1_13();
        PARTICLE = new Particle1_13Type();
    }
}
