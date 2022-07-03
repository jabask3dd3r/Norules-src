package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;

public abstract class BaseChunkType extends Type<Chunk>
{
    @Override
    public Class<? extends Type> getBaseClass() {
        return BaseChunkType.class;
    }
    
    protected BaseChunkType(final String lllllllllllllIlIlIllIlIllllIIIlI) {
        super(lllllllllllllIlIlIllIlIllllIIIlI, Chunk.class);
    }
    
    protected BaseChunkType() {
        super(Chunk.class);
    }
}
