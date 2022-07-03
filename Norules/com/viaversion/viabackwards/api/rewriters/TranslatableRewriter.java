package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import java.util.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viabackwards.api.data.*;
import com.viaversion.viaversion.api.protocol.packet.*;

public class TranslatableRewriter extends ComponentRewriter
{
    protected final /* synthetic */ Map<String, String> newTranslatables;
    private static final /* synthetic */ Map<String, Map<String, String>> TRANSLATABLES;
    
    public TranslatableRewriter(final BackwardsProtocol llllllllllllllIlIIlIIIllIllIIllI) {
        this(llllllllllllllIlIIlIIIllIllIIllI, llllllllllllllIlIIlIIIllIllIIllI.getClass().getSimpleName().split("To")[1].replace("_", "."));
    }
    
    public void registerOpenWindow(final ClientboundPacketType llllllllllllllIlIIlIIIllIIllllIl) {
        this.protocol.registerClientbound(llllllllllllllIlIIlIIIllIIllllIl, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.handler(lllllllllllllllIlIIlIlIIIlIIllIl -> TranslatableRewriter.this.processText(lllllllllllllllIlIIlIlIIIlIIllIl.passthrough(Type.COMPONENT)));
            }
        });
    }
    
    @Override
    public void registerChatMessage(final ClientboundPacketType llllllllllllllIlIIlIIIllIlIIlIll) {
        this.protocol.registerClientbound(llllllllllllllIlIIlIIIllIlIIlIll, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(llllllllllllllllIIIlIlllIIlIIlIl -> TranslatableRewriter.this.processText(llllllllllllllllIIIlIlllIIlIIlIl.passthrough(Type.COMPONENT)));
            }
        });
    }
    
    public void registerDisconnect(final ClientboundPacketType llllllllllllllIlIIlIIIllIlIlIIIl) {
        this.protocol.registerClientbound(llllllllllllllIlIIlIIIllIlIlIIIl, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllIIlllIlIlIIllIIIlll -> TranslatableRewriter.this.processText(lllllllllllllIIlllIlIlIIllIIIlll.passthrough(Type.COMPONENT)));
            }
        });
    }
    
    static {
        TRANSLATABLES = new HashMap<String, Map<String, String>>();
    }
    
    public TranslatableRewriter(final BackwardsProtocol llllllllllllllIlIIlIIIllIlIllIlI, final String llllllllllllllIlIIlIIIllIlIlllIl) {
        super(llllllllllllllIlIIlIIIllIlIllIlI);
        final Map<String, String> llllllllllllllIlIIlIIIllIlIlllII = TranslatableRewriter.TRANSLATABLES.get(llllllllllllllIlIIlIIIllIlIlllIl);
        if (llllllllllllllIlIIlIIIllIlIlllII == null) {
            ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Error loading ").append(llllllllllllllIlIIlIIIllIlIlllIl).append(" translatables!")));
            this.newTranslatables = new HashMap<String, String>();
        }
        else {
            this.newTranslatables = llllllllllllllIlIIlIIIllIlIlllII;
        }
    }
    
    @Override
    protected void handleTranslate(final JsonObject llllllllllllllIlIIlIIIllIIllIIIl, final String llllllllllllllIlIIlIIIllIIlIllII) {
        final String llllllllllllllIlIIlIIIllIIlIllll = this.newTranslatables.get(llllllllllllllIlIIlIIIllIIlIllII);
        if (llllllllllllllIlIIlIIIllIIlIllll != null) {
            llllllllllllllIlIIlIIIllIIllIIIl.addProperty("translate", llllllllllllllIlIIlIIIllIIlIllll);
        }
    }
    
    public static void loadTranslatables() {
        final JsonObject llllllllllllllIlIIlIIIllIlllIIII = VBMappingDataLoader.loadData("translation-mappings.json");
        for (final Map.Entry<String, JsonElement> llllllllllllllIlIIlIIIllIlllIIIl : llllllllllllllIlIIlIIIllIlllIIII.entrySet()) {
            final Map<String, String> llllllllllllllIlIIlIIIllIlllIIlI = new HashMap<String, String>();
            TranslatableRewriter.TRANSLATABLES.put(llllllllllllllIlIIlIIIllIlllIIIl.getKey(), llllllllllllllIlIIlIIIllIlllIIlI);
            for (final Map.Entry<String, JsonElement> llllllllllllllIlIIlIIIllIlllIIll : llllllllllllllIlIIlIIIllIlllIIIl.getValue().getAsJsonObject().entrySet()) {
                llllllllllllllIlIIlIIIllIlllIIlI.put(llllllllllllllIlIIlIIIllIlllIIll.getKey(), llllllllllllllIlIIlIIIllIlllIIll.getValue().getAsString());
            }
        }
    }
    
    public void registerPing() {
        this.protocol.registerClientbound(State.LOGIN, 0, 0, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllIlIIIIIlIIllIllIllI -> TranslatableRewriter.this.processText(lllllllllllllIlIIIIIlIIllIllIllI.passthrough(Type.COMPONENT)));
            }
        });
    }
    
    public void registerTabList(final ClientboundPacketType llllllllllllllIlIIlIIIllIIllIlll) {
        this.protocol.registerClientbound(llllllllllllllIlIIlIIIllIIllIlll, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllIIIIllllllIlllIlIll -> {
                    TranslatableRewriter.this.processText(lllllllllllllIIIIllllllIlllIlIll.passthrough(Type.COMPONENT));
                    TranslatableRewriter.this.processText(lllllllllllllIIIIllllllIlllIlIll.passthrough(Type.COMPONENT));
                });
            }
        });
    }
    
    public void registerLegacyOpenWindow(final ClientboundPacketType llllllllllllllIlIIlIIIllIlIIIIll) {
        this.protocol.registerClientbound(llllllllllllllIlIIlIIIllIlIIIIll, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.STRING);
                this.handler(llllllllllllllIIIIlIllIllllIIlll -> TranslatableRewriter.this.processText(llllllllllllllIIIIlIllIllllIIlll.passthrough(Type.COMPONENT)));
            }
        });
    }
}
