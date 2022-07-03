package com.viaversion.viaversion.api.type.types.version;

import com.viaversion.viaversion.api.type.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.api.type.types.minecraft.*;

public class Types1_13_2
{
    public static final /* synthetic */ Type<Metadata> METADATA;
    
    static {
        METADATA = new Metadata1_13_2Type();
        METADATA_LIST = new MetaListType(Types1_13_2.METADATA);
        PARTICLE = new Particle1_13_2Type();
    }
}
