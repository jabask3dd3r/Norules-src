package com.viaversion.viaversion.libs.gson;

import java.lang.reflect.*;

public interface JsonSerializationContext
{
    JsonElement serialize(final Object p0, final Type p1);
    
    JsonElement serialize(final Object p0);
}
