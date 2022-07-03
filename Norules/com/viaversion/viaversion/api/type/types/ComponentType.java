package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.libs.gson.*;

public class ComponentType extends Type<JsonElement>
{
    private static final /* synthetic */ StringType STRING_TAG;
    
    public ComponentType() {
        super(JsonElement.class);
    }
    
    static {
        STRING_TAG = new StringType(262144);
    }
    
    @Override
    public void write(final ByteBuf llllllllllllllIIlIIIIllllIIlIlIl, final JsonElement llllllllllllllIIlIIIIllllIIlIlII) throws Exception {
        ComponentType.STRING_TAG.write(llllllllllllllIIlIIIIllllIIlIlIl, llllllllllllllIIlIIIIllllIIlIlII.toString());
    }
    
    @Override
    public JsonElement read(final ByteBuf llllllllllllllIIlIIIIllllIIlllIl) throws Exception {
        final String llllllllllllllIIlIIIIllllIIlllII = ComponentType.STRING_TAG.read(llllllllllllllIIlIIIIllllIIlllIl);
        try {
            return JsonParser.parseString(llllllllllllllIIlIIIIllllIIlllII);
        }
        catch (JsonSyntaxException llllllllllllllIIlIIIIllllIIlllll) {
            Via.getPlatform().getLogger().severe(String.valueOf(new StringBuilder().append("Error when trying to parse json: ").append(llllllllllllllIIlIIIIllllIIlllII)));
            throw llllllllllllllIIlIIIIllllIIlllll;
        }
    }
}
