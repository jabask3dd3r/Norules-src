package net.minecraft.network.status.server;

import net.minecraft.network.status.*;
import java.lang.reflect.*;
import net.minecraft.util.text.*;
import com.google.gson.*;
import java.io.*;
import net.minecraft.network.*;
import net.minecraft.util.*;

public class SPacketServerInfo implements Packet<INetHandlerStatusClient>
{
    private /* synthetic */ ServerStatusResponse response;
    private static final /* synthetic */ Gson GSON;
    
    static {
        GSON = new GsonBuilder().registerTypeAdapter((Type)ServerStatusResponse.Version.class, (Object)new ServerStatusResponse.Version.Serializer()).registerTypeAdapter((Type)ServerStatusResponse.Players.class, (Object)new ServerStatusResponse.Players.Serializer()).registerTypeAdapter((Type)ServerStatusResponse.class, (Object)new ServerStatusResponse.Serializer()).registerTypeHierarchyAdapter((Class)ITextComponent.class, (Object)new ITextComponent.Serializer()).registerTypeHierarchyAdapter((Class)Style.class, (Object)new Style.Serializer()).registerTypeAdapterFactory((TypeAdapterFactory)new EnumTypeAdapterFactory()).create();
    }
    
    @Override
    public void processPacket(final INetHandlerStatusClient lllllllllllllIlIIIIIIlllIIlIIIll) {
        lllllllllllllIlIIIIIIlllIIlIIIll.handleServerInfo(this);
    }
    
    public SPacketServerInfo() {
    }
    
    @Override
    public void writePacketData(final PacketBuffer lllllllllllllIlIIIIIIlllIIlIIlll) throws IOException {
        lllllllllllllIlIIIIIIlllIIlIIlll.writeString(SPacketServerInfo.GSON.toJson((Object)this.response));
    }
    
    public ServerStatusResponse getResponse() {
        return this.response;
    }
    
    public SPacketServerInfo(final ServerStatusResponse lllllllllllllIlIIIIIIlllIIllIIll) {
        this.response = lllllllllllllIlIIIIIIlllIIllIIll;
    }
    
    @Override
    public void readPacketData(final PacketBuffer lllllllllllllIlIIIIIIlllIIlIllIl) throws IOException {
        this.response = JsonUtils.gsonDeserialize(SPacketServerInfo.GSON, lllllllllllllIlIIIIIIlllIIlIllIl.readStringFromBuffer(32767), ServerStatusResponse.class);
    }
}
