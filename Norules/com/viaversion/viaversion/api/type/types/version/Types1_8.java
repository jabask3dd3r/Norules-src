package com.viaversion.viaversion.api.type.types.version;

import com.viaversion.viaversion.api.type.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;

public class Types1_8
{
    static {
        METADATA = new Metadata1_8Type();
        METADATA_LIST = new MetadataList1_8Type();
        CHUNK_SECTION = new ChunkSectionType1_8();
    }
}
