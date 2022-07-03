package com.viaversion.viaversion.api.type.types.version;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import java.util.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.type.types.minecraft.*;

public final class Types1_16
{
    public static final /* synthetic */ Type<Metadata> METADATA;
    
    static {
        CHUNK_SECTION = new ChunkSectionType1_16();
        METADATA = new Metadata1_16Type();
        METADATA_LIST = new MetaListType(Types1_16.METADATA);
        PARTICLE = new Particle1_16Type();
    }
}
