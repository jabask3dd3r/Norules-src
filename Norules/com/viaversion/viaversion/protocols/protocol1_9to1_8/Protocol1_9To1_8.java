package com.viaversion.viaversion.protocols.protocol1_9to1_8;

import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.metadata.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.providers.*;
import com.viaversion.viaversion.api.platform.providers.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.packets.*;

public class Protocol1_9To1_8 extends AbstractProtocol<ClientboundPackets1_8, ClientboundPackets1_9, ServerboundPackets1_8, ServerboundPackets1_9>
{
    private final /* synthetic */ EntityRewriter metadataRewriter;
    
    public static JsonElement fixJson(String lllIIIIIIIIll) {
        if (lllIIIIIIIIll == null || lllIIIIIIIIll.equalsIgnoreCase("null")) {
            lllIIIIIIIIll = "{\"text\":\"\"}";
        }
        else {
            if ((!lllIIIIIIIIll.startsWith("\"") || !lllIIIIIIIIll.endsWith("\"")) && (!lllIIIIIIIIll.startsWith("{") || !lllIIIIIIIIll.endsWith("}"))) {
                return constructJson(lllIIIIIIIIll);
            }
            if (lllIIIIIIIIll.startsWith("\"") && lllIIIIIIIIll.endsWith("\"")) {
                lllIIIIIIIIll = String.valueOf(new StringBuilder().append("{\"text\":").append(lllIIIIIIIIll).append("}"));
            }
        }
        try {
            return GsonUtil.getGson().fromJson(lllIIIIIIIIll, JsonObject.class);
        }
        catch (Exception lllIIIIIIIlIl) {
            if (Via.getConfig().isForceJsonTransform()) {
                return constructJson(lllIIIIIIIIll);
            }
            Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Invalid JSON String: \"").append(lllIIIIIIIIll).append("\" Please report this issue to the ViaVersion Github: ").append(lllIIIIIIIlIl.getMessage())));
            return GsonUtil.getGson().fromJson("{\"text\":\"\"}", JsonObject.class);
        }
    }
    
    public Protocol1_9To1_8() {
        super(ClientboundPackets1_8.class, ClientboundPackets1_9.class, ServerboundPackets1_8.class, ServerboundPackets1_9.class);
        this.metadataRewriter = new MetadataRewriter1_9To1_8(this);
    }
    
    static {
        FIX_JSON = new ValueTransformer<String, JsonElement>() {
            @Override
            public JsonElement transform(final PacketWrapper lllllllllllllllIlIIllIlIlllIIIll, final String lllllllllllllllIlIIllIlIlllIIIIl) {
                return Protocol1_9To1_8.fixJson(lllllllllllllllIlIIllIlIlllIIIIl);
            }
        };
    }
    
    @Override
    public void register(final ViaProviders llIllllllIIII) {
        llIllllllIIII.register(HandItemProvider.class, new HandItemProvider());
        llIllllllIIII.register(CommandBlockProvider.class, new CommandBlockProvider());
        llIllllllIIII.register(EntityIdProvider.class, new EntityIdProvider());
        llIllllllIIII.register(BossBarProvider.class, new BossBarProvider());
        llIllllllIIII.register(MainHandProvider.class, new MainHandProvider());
        llIllllllIIII.require(MovementTransmitterProvider.class);
    }
    
    public static Item getHandItem(final UserConnection llIlllllllIIl) {
        return Via.getManager().getProviders().get(HandItemProvider.class).getHandItem(llIlllllllIIl);
    }
    
    @Override
    public void init(final UserConnection llIlllllIlIll) {
        llIlllllIlIll.addEntityTracker(this.getClass(), new EntityTracker1_9(llIlllllIlIll));
        llIlllllIlIll.put(new ClientChunks(llIlllllIlIll));
        llIlllllIlIll.put(new MovementTracker());
        llIlllllIlIll.put(new InventoryTracker());
        llIlllllIlIll.put(new CommandBlockStorage());
    }
    
    private static JsonElement constructJson(final String llIllllllllll) {
        final JsonObject llIlllllllllI = new JsonObject();
        llIlllllllllI.addProperty("text", llIllllllllll);
        return llIlllllllllI;
    }
    
    @Override
    protected void registerPackets() {
        this.metadataRewriter.register();
        this.registerClientbound(State.LOGIN, 0, 0, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(llllllllllllllIIIIlIlIlllllllIIl -> {
                    if (!llllllllllllllIIIIlIlIlllllllIIl.isReadable(Type.COMPONENT, 0)) {
                        llllllllllllllIIIIlIlIlllllllIIl.write(Type.COMPONENT, Protocol1_9To1_8.fixJson(llllllllllllllIIIIlIlIlllllllIIl.read(Type.STRING)));
                    }
                });
            }
        });
        SpawnPackets.register(this);
        InventoryPackets.register(this);
        EntityPackets.register(this);
        PlayerPackets.register(this);
        WorldPackets.register(this);
    }
    
    @Override
    public EntityRewriter getEntityRewriter() {
        return this.metadataRewriter;
    }
    
    public static boolean isSword(final int llIllllllIllI) {
        return llIllllllIllI == 267 || llIllllllIllI == 268 || llIllllllIllI == 272 || llIllllllIllI == 276 || llIllllllIllI == 283;
    }
}
