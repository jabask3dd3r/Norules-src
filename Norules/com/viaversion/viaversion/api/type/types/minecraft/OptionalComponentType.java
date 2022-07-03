package com.viaversion.viaversion.api.type.types.minecraft;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.libs.gson.*;
import io.netty.buffer.*;

public class OptionalComponentType extends Type<JsonElement>
{
    @Override
    public void write(final ByteBuf lllllllllllllIlIIIlIIlIIlIllllIl, final JsonElement lllllllllllllIlIIIlIIlIIlIlllllI) throws Exception {
        if (lllllllllllllIlIIIlIIlIIlIlllllI == null) {
            lllllllllllllIlIIIlIIlIIlIllllIl.writeBoolean(false);
        }
        else {
            lllllllllllllIlIIIlIIlIIlIllllIl.writeBoolean(true);
            Type.COMPONENT.write(lllllllllllllIlIIIlIIlIIlIllllIl, lllllllllllllIlIIIlIIlIIlIlllllI);
        }
    }
    
    @Override
    public JsonElement read(final ByteBuf lllllllllllllIlIIIlIIlIIllIIIlII) throws Exception {
        final boolean lllllllllllllIlIIIlIIlIIllIIIlIl = lllllllllllllIlIIIlIIlIIllIIIlII.readBoolean();
        return lllllllllllllIlIIIlIIlIIllIIIlIl ? Type.COMPONENT.read(lllllllllllllIlIIIlIIlIIllIIIlII) : null;
    }
    
    public OptionalComponentType() {
        super(JsonElement.class);
    }
}
