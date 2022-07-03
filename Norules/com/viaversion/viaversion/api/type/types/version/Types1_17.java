package com.viaversion.viaversion.api.type.types.version;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.types.*;
import java.util.*;
import com.viaversion.viaversion.api.type.types.minecraft.*;

public final class Types1_17
{
    public static final /* synthetic */ Type<Metadata> METADATA;
    
    static {
        METADATA = new Metadata1_17Type();
        METADATA_LIST = new MetaListType(Types1_17.METADATA);
        PARTICLE = new Particle1_17Type();
    }
}
