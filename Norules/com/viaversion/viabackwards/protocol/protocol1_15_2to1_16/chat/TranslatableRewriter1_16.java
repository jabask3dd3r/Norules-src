package com.viaversion.viabackwards.protocol.protocol1_15_2to1_16.chat;

import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import com.viaversion.viabackwards.api.*;

public class TranslatableRewriter1_16 extends TranslatableRewriter
{
    private static final /* synthetic */ ChatColor[] COLORS;
    
    @Override
    public void processText(final JsonElement lllllllllllllllIlIIIIIlIIIlIlIll) {
        super.processText(lllllllllllllllIlIIIIIlIIIlIlIll);
        if (lllllllllllllllIlIIIIIlIIIlIlIll == null || !lllllllllllllllIlIIIIIlIIIlIlIll.isJsonObject()) {
            return;
        }
        final JsonObject lllllllllllllllIlIIIIIlIIIlIlIlI = lllllllllllllllIlIIIIIlIIIlIlIll.getAsJsonObject();
        final JsonPrimitive lllllllllllllllIlIIIIIlIIIlIlIIl = lllllllllllllllIlIIIIIlIIIlIlIlI.getAsJsonPrimitive("color");
        if (lllllllllllllllIlIIIIIlIIIlIlIIl != null) {
            final String lllllllllllllllIlIIIIIlIIIllIIII = lllllllllllllllIlIIIIIlIIIlIlIIl.getAsString();
            if (!lllllllllllllllIlIIIIIlIIIllIIII.isEmpty() && lllllllllllllllIlIIIIIlIIIllIIII.charAt(0) == '#') {
                final int lllllllllllllllIlIIIIIlIIIllIIlI = Integer.parseInt(lllllllllllllllIlIIIIIlIIIllIIII.substring(1), 16);
                final String lllllllllllllllIlIIIIIlIIIllIIIl = this.getClosestChatColor(lllllllllllllllIlIIIIIlIIIllIIlI);
                lllllllllllllllIlIIIIIlIIIlIlIlI.addProperty("color", lllllllllllllllIlIIIIIlIIIllIIIl);
            }
        }
        final JsonObject lllllllllllllllIlIIIIIlIIIlIlIII = lllllllllllllllIlIIIIIlIIIlIlIlI.getAsJsonObject("hoverEvent");
        if (lllllllllllllllIlIIIIIlIIIlIlIII != null) {
            try {
                final Component lllllllllllllllIlIIIIIlIIIlIllll = ChatRewriter.HOVER_GSON_SERIALIZER.deserializeFromTree(lllllllllllllllIlIIIIIlIIIlIlIlI);
                final JsonObject lllllllllllllllIlIIIIIlIIIlIlllI = ((JsonObject)ChatRewriter.HOVER_GSON_SERIALIZER.serializeToTree(lllllllllllllllIlIIIIIlIIIlIllll)).getAsJsonObject("hoverEvent");
                lllllllllllllllIlIIIIIlIIIlIlllI.remove("contents");
                lllllllllllllllIlIIIIIlIIIlIlIlI.add("hoverEvent", lllllllllllllllIlIIIIIlIIIlIlllI);
            }
            catch (Exception lllllllllllllllIlIIIIIlIIIlIllIl) {
                ViaBackwards.getPlatform().getLogger().severe(String.valueOf(new StringBuilder().append("Error converting hover event component: ").append(lllllllllllllllIlIIIIIlIIIlIlIlI)));
                lllllllllllllllIlIIIIIlIIIlIllIl.printStackTrace();
            }
        }
    }
    
    private String getClosestChatColor(final int lllllllllllllllIlIIIIIlIIIIIlIlI) {
        final int lllllllllllllllIlIIIIIlIIIIIlIIl = lllllllllllllllIlIIIIIlIIIIIlIlI >> 16 & 0xFF;
        final int lllllllllllllllIlIIIIIlIIIIIlIII = lllllllllllllllIlIIIIIlIIIIIlIlI >> 8 & 0xFF;
        final int lllllllllllllllIlIIIIIlIIIIIIlll = lllllllllllllllIlIIIIIlIIIIIlIlI & 0xFF;
        ChatColor lllllllllllllllIlIIIIIlIIIIIIllI = null;
        int lllllllllllllllIlIIIIIlIIIIIIlIl = 0;
        final double lllllllllllllllIlIIIIIIllllllllI = (Object)TranslatableRewriter1_16.COLORS;
        final byte lllllllllllllllIlIIIIIIlllllllIl = (byte)lllllllllllllllIlIIIIIIllllllllI.length;
        for (boolean lllllllllllllllIlIIIIIIlllllllII = false; (lllllllllllllllIlIIIIIIlllllllII ? 1 : 0) < lllllllllllllllIlIIIIIIlllllllIl; ++lllllllllllllllIlIIIIIIlllllllII) {
            final ChatColor lllllllllllllllIlIIIIIlIIIIIllII = lllllllllllllllIlIIIIIIllllllllI[lllllllllllllllIlIIIIIIlllllllII];
            if (lllllllllllllllIlIIIIIlIIIIIllII.rgb == lllllllllllllllIlIIIIIlIIIIIlIlI) {
                return lllllllllllllllIlIIIIIlIIIIIllII.colorName;
            }
            final int lllllllllllllllIlIIIIIlIIIIlIIIl = (lllllllllllllllIlIIIIIlIIIIIllII.r + lllllllllllllllIlIIIIIlIIIIIlIIl) / 2;
            final int lllllllllllllllIlIIIIIlIIIIlIIII = lllllllllllllllIlIIIIIlIIIIIllII.r - lllllllllllllllIlIIIIIlIIIIIlIIl;
            final int lllllllllllllllIlIIIIIlIIIIIllll = lllllllllllllllIlIIIIIlIIIIIllII.g - lllllllllllllllIlIIIIIlIIIIIlIII;
            final int lllllllllllllllIlIIIIIlIIIIIlllI = lllllllllllllllIlIIIIIlIIIIIllII.b - lllllllllllllllIlIIIIIlIIIIIIlll;
            final int lllllllllllllllIlIIIIIlIIIIIllIl = (2 + (lllllllllllllllIlIIIIIlIIIIlIIIl >> 8)) * lllllllllllllllIlIIIIIlIIIIlIIII * lllllllllllllllIlIIIIIlIIIIlIIII + 4 * lllllllllllllllIlIIIIIlIIIIIllll * lllllllllllllllIlIIIIIlIIIIIllll + (2 + (255 - lllllllllllllllIlIIIIIlIIIIlIIIl >> 8)) * lllllllllllllllIlIIIIIlIIIIIlllI * lllllllllllllllIlIIIIIlIIIIIlllI;
            if (lllllllllllllllIlIIIIIlIIIIIIllI == null || lllllllllllllllIlIIIIIlIIIIIllIl < lllllllllllllllIlIIIIIlIIIIIIlIl) {
                lllllllllllllllIlIIIIIlIIIIIIllI = lllllllllllllllIlIIIIIlIIIIIllII;
                lllllllllllllllIlIIIIIlIIIIIIlIl = lllllllllllllllIlIIIIIlIIIIIllIl;
            }
        }
        return lllllllllllllllIlIIIIIlIIIIIIllI.colorName;
    }
    
    public TranslatableRewriter1_16(final BackwardsProtocol lllllllllllllllIlIIIIIlIIIlllIlI) {
        super(lllllllllllllllIlIIIIIlIIIlllIlI);
    }
    
    static {
        COLORS = new ChatColor[] { new ChatColor("black", 0), new ChatColor("dark_blue", 170), new ChatColor("dark_green", 43520), new ChatColor("dark_aqua", 43690), new ChatColor("dark_red", 11141120), new ChatColor("dark_purple", 11141290), new ChatColor("gold", 16755200), new ChatColor("gray", 11184810), new ChatColor("dark_gray", 5592405), new ChatColor("blue", 5592575), new ChatColor("green", 5635925), new ChatColor("aqua", 5636095), new ChatColor("red", 16733525), new ChatColor("light_purple", 16733695), new ChatColor("yellow", 16777045), new ChatColor("white", 16777215) };
    }
    
    private static final class ChatColor
    {
        private final /* synthetic */ int g;
        private final /* synthetic */ int r;
        private final /* synthetic */ String colorName;
        private final /* synthetic */ int b;
        private final /* synthetic */ int rgb;
        
        ChatColor(final String lllllllllllllIllIlIIIIllIlllllIl, final int lllllllllllllIllIlIIIIllIlllllII) {
            this.colorName = lllllllllllllIllIlIIIIllIlllllIl;
            this.rgb = lllllllllllllIllIlIIIIllIlllllII;
            this.r = (lllllllllllllIllIlIIIIllIlllllII >> 16 & 0xFF);
            this.g = (lllllllllllllIllIlIIIIllIlllllII >> 8 & 0xFF);
            this.b = (lllllllllllllIllIlIIIIllIlllllII & 0xFF);
        }
    }
}
