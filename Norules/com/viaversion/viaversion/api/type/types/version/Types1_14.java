package com.viaversion.viaversion.api.type.types.version;

import com.viaversion.viaversion.api.type.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.api.type.types.minecraft.*;

public final class Types1_14
{
    public static final /* synthetic */ Type<Metadata> METADATA;
    
    static {
        METADATA = new Metadata1_14Type();
        METADATA_LIST = new MetaListType(Types1_14.METADATA);
        PARTICLE = new Particle1_14Type();
    }
}
