package com.viaversion.viaversion.util;

import com.viaversion.viaversion.libs.gson.*;

public final class GsonUtil
{
    private static final /* synthetic */ Gson GSON;
    
    static {
        GSON = new GsonBuilder().create();
    }
    
    public static Gson getGson() {
        return GsonUtil.GSON;
    }
}
