package config;

import com.google.gson.*;

public interface Serializable
{
    void load(final JsonObject p0);
    
    JsonObject save();
}
