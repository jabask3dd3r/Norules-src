package ViaMCP.minecraft.viamcp1_12.platform;

import com.viaversion.viaversion.api.platform.*;
import com.viaversion.viaversion.libs.gson.*;

public class VRInjector implements ViaInjector
{
    @Override
    public void uninject() {
    }
    
    @Override
    public String getDecoderName() {
        return "via-decoder";
    }
    
    @Override
    public JsonObject getDump() {
        final JsonObject lllllllllllllIlllllIlIIlIIlIlIlI = new JsonObject();
        return lllllllllllllIlllllIlIIlIIlIlIlI;
    }
    
    @Override
    public String getEncoderName() {
        return "via-encoder";
    }
    
    @Override
    public int getServerProtocolVersion() {
        return 340;
    }
    
    @Override
    public void inject() {
    }
}
