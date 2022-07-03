package com.viaversion.viaversion.api.type.types.version;

import com.viaversion.viaversion.api.type.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.type.types.minecraft.*;

public class Types1_9
{
    public static final /* synthetic */ Type<Metadata> METADATA;
    
    static {
        METADATA = new Metadata1_9Type();
        METADATA_LIST = new MetaListType(Types1_9.METADATA);
        CHUNK_SECTION = new ChunkSectionType1_9();
    }
}
