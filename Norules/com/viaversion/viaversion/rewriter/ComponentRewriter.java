package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;

public class ComponentRewriter
{
    protected final /* synthetic */ Protocol protocol;
    
    public JsonElement processText(final String llllllllllllllllIlllIlIllIIlIlll) {
        try {
            final JsonElement llllllllllllllllIlllIlIllIIlllII = JsonParser.parseString(llllllllllllllllIlllIlIllIIlIlll);
            this.processText(llllllllllllllllIlllIlIllIIlllII);
            return llllllllllllllllIlllIlIllIIlllII;
        }
        catch (JsonSyntaxException llllllllllllllllIlllIlIllIIllIll) {
            if (Via.getManager().isDebug()) {
                Via.getPlatform().getLogger().severe(String.valueOf(new StringBuilder().append("Error when trying to parse json: ").append(llllllllllllllllIlllIlIllIIlIlll)));
                throw llllllllllllllllIlllIlIllIIllIll;
            }
            return new JsonPrimitive(llllllllllllllllIlllIlIllIIlIlll);
        }
    }
    
    public void processText(final JsonElement llllllllllllllllIlllIlIlIIllllII) {
        if (llllllllllllllllIlllIlIlIIllllII == null || llllllllllllllllIlllIlIlIIllllII.isJsonNull()) {
            return;
        }
        if (llllllllllllllllIlllIlIlIIllllII.isJsonArray()) {
            this.processAsArray(llllllllllllllllIlllIlIlIIllllII);
            return;
        }
        if (llllllllllllllllIlllIlIlIIllllII.isJsonPrimitive()) {
            this.handleText(llllllllllllllllIlllIlIlIIllllII.getAsJsonPrimitive());
            return;
        }
        final JsonObject llllllllllllllllIlllIlIlIIlllIlI = llllllllllllllllIlllIlIlIIllllII.getAsJsonObject();
        final JsonPrimitive llllllllllllllllIlllIlIlIIlllIII = llllllllllllllllIlllIlIlIIlllIlI.getAsJsonPrimitive("text");
        if (llllllllllllllllIlllIlIlIIlllIII != null) {
            this.handleText(llllllllllllllllIlllIlIlIIlllIII);
        }
        final JsonElement llllllllllllllllIlllIlIlIIllIllI = llllllllllllllllIlllIlIlIIlllIlI.get("translate");
        if (llllllllllllllllIlllIlIlIIllIllI != null) {
            this.handleTranslate(llllllllllllllllIlllIlIlIIlllIlI, llllllllllllllllIlllIlIlIIllIllI.getAsString());
            final JsonElement llllllllllllllllIlllIlIlIIllllll = llllllllllllllllIlllIlIlIIlllIlI.get("with");
            if (llllllllllllllllIlllIlIlIIllllll != null) {
                this.processAsArray(llllllllllllllllIlllIlIlIIllllll);
            }
        }
        final JsonElement llllllllllllllllIlllIlIlIIllIlII = llllllllllllllllIlllIlIlIIlllIlI.get("extra");
        if (llllllllllllllllIlllIlIlIIllIlII != null) {
            this.processAsArray(llllllllllllllllIlllIlIlIIllIlII);
        }
        final JsonObject llllllllllllllllIlllIlIlIIllIIll = llllllllllllllllIlllIlIlIIlllIlI.getAsJsonObject("hoverEvent");
        if (llllllllllllllllIlllIlIlIIllIIll != null) {
            this.handleHoverEvent(llllllllllllllllIlllIlIlIIllIIll);
        }
    }
    
    public void registerTitle(final ClientboundPacketType llllllllllllllllIlllIlIllIlIIIlI) {
        this.protocol.registerClientbound(llllllllllllllllIlllIlIllIlIIIlI, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllIIlllllIllIIIIIIIll;
                this.handler(lllllllllllllIIlllllIllIIIIIIlII -> {
                    lllllllllllllIIlllllIllIIIIIIIll = lllllllllllllIIlllllIllIIIIIIlII.passthrough((Type<Integer>)Type.VAR_INT);
                    if (lllllllllllllIIlllllIllIIIIIIIll >= 0 && lllllllllllllIIlllllIllIIIIIIIll <= 2) {
                        ComponentRewriter.this.processText(lllllllllllllIIlllllIllIIIIIIlII.passthrough(Type.COMPONENT));
                    }
                });
            }
        });
    }
    
    public void registerComponentPacket(final ClientboundPacketType llllllllllllllllIlllIlIllIlllIII) {
        this.protocol.registerClientbound(llllllllllllllllIlllIlIllIlllIII, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(llllllllllllIllllllllIIllIIIIIll -> ComponentRewriter.this.processText(llllllllllllIllllllllIIllIIIIIll.passthrough(Type.COMPONENT)));
            }
        });
    }
    
    protected void handleHoverEvent(final JsonObject llllllllllllllllIlllIlIlIIIIlIlI) {
        final String llllllllllllllllIlllIlIlIIIIlIIl = llllllllllllllllIlllIlIlIIIIlIlI.getAsJsonPrimitive("action").getAsString();
        if (llllllllllllllllIlllIlIlIIIIlIIl.equals("show_text")) {
            final JsonElement llllllllllllllllIlllIlIlIIIIllll = llllllllllllllllIlllIlIlIIIIlIlI.get("value");
            this.processText((llllllllllllllllIlllIlIlIIIIllll != null) ? llllllllllllllllIlllIlIlIIIIllll : llllllllllllllllIlllIlIlIIIIlIlI.get("contents"));
        }
        else if (llllllllllllllllIlllIlIlIIIIlIIl.equals("show_entity")) {
            final JsonObject llllllllllllllllIlllIlIlIIIIllIl = llllllllllllllllIlllIlIlIIIIlIlI.getAsJsonObject("contents");
            if (llllllllllllllllIlllIlIlIIIIllIl != null) {
                this.processText(llllllllllllllllIlllIlIlIIIIllIl.get("name"));
            }
        }
    }
    
    public <T extends Protocol> T getProtocol() {
        return (T)this.protocol;
    }
    
    public void registerCombatEvent(final ClientboundPacketType llllllllllllllllIlllIlIllIlIlIII) {
        this.protocol.registerClientbound(llllllllllllllllIlllIlIllIlIlIII, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllllIIIIIIlIIIIIllIII -> {
                    if (lllllllllllllllIIIIIIlIIIIIllIII.passthrough((Type<Integer>)Type.VAR_INT) == 2) {
                        lllllllllllllllIIIIIIlIIIIIllIII.passthrough((Type<Object>)Type.VAR_INT);
                        lllllllllllllllIIIIIIlIIIIIllIII.passthrough((Type<Object>)Type.INT);
                        ComponentRewriter.this.processText(lllllllllllllllIIIIIIlIIIIIllIII.passthrough(Type.COMPONENT));
                    }
                });
            }
        });
    }
    
    protected void handleTranslate(final JsonObject llllllllllllllllIlllIlIlIIlIIIlI, final String llllllllllllllllIlllIlIlIIlIIIIl) {
    }
    
    public ComponentRewriter(final Protocol llllllllllllllllIlllIlIlllIIIIIl) {
        this.protocol = llllllllllllllllIlllIlIlllIIIIIl;
    }
    
    public ComponentRewriter() {
        this.protocol = null;
    }
    
    private void processAsArray(final JsonElement llllllllllllllllIlllIlIIlllIllll) {
        for (final JsonElement llllllllllllllllIlllIlIIllllIlll : llllllllllllllllIlllIlIIlllIllll.getAsJsonArray()) {
            this.processText(llllllllllllllllIlllIlIIllllIlll);
        }
    }
    
    public void registerBossBar(final ClientboundPacketType llllllllllllllllIlllIlIllIlIllII) {
        this.protocol.registerClientbound(llllllllllllllllIlllIlIllIlIllII, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UUID);
                this.map(Type.VAR_INT);
                final int lllllllllllllllIIlIIIIllIllIlIll;
                this.handler(lllllllllllllllIIlIIIIllIllIllII -> {
                    lllllllllllllllIIlIIIIllIllIlIll = lllllllllllllllIIlIIIIllIllIllII.get((Type<Integer>)Type.VAR_INT, 0);
                    if (lllllllllllllllIIlIIIIllIllIlIll == 0 || lllllllllllllllIIlIIIIllIllIlIll == 3) {
                        ComponentRewriter.this.processText(lllllllllllllllIIlIIIIllIllIllII.passthrough(Type.COMPONENT));
                    }
                });
            }
        });
    }
    
    protected void handleText(final JsonPrimitive llllllllllllllllIlllIlIlIIlIIlll) {
    }
    
    public void registerChatMessage(final ClientboundPacketType llllllllllllllllIlllIlIllIllIlII) {
        this.registerComponentPacket(llllllllllllllllIlllIlIllIllIlII);
    }
}
