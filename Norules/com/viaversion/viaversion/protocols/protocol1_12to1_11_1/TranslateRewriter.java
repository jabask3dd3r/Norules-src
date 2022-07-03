package com.viaversion.viaversion.protocols.protocol1_12to1_11_1;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_12to1_11_1.data.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.connection.*;

public class TranslateRewriter
{
    private static final /* synthetic */ ComponentRewriter achievementTextRewriter;
    
    static {
        achievementTextRewriter = new ComponentRewriter() {
            @Override
            protected void handleTranslate(final JsonObject llllllllllllllIIIIlIIllIlllIlllI, final String llllllllllllllIIIIlIIllIlllIllIl) {
                final String llllllllllllllIIIIlIIllIlllIllll = AchievementTranslationMapping.get(llllllllllllllIIIIlIIllIlllIllIl);
                if (llllllllllllllIIIIlIIllIlllIllll != null) {
                    llllllllllllllIIIIlIIllIlllIlllI.addProperty("translate", llllllllllllllIIIIlIIllIlllIllll);
                }
            }
            
            @Override
            protected void handleHoverEvent(final JsonObject llllllllllllllIIIIlIIllIllIlIIlI) {
                final String llllllllllllllIIIIlIIllIllIlIllI = llllllllllllllIIIIlIIllIllIlIIlI.getAsJsonPrimitive("action").getAsString();
                if (!llllllllllllllIIIIlIIllIllIlIllI.equals("show_achievement")) {
                    super.handleHoverEvent(llllllllllllllIIIIlIIllIllIlIIlI);
                    return;
                }
                final JsonElement llllllllllllllIIIIlIIllIllIlIlII = llllllllllllllIIIIlIIllIllIlIIlI.get("value");
                String llllllllllllllIIIIlIIllIllIlIlIl = null;
                if (llllllllllllllIIIIlIIllIllIlIlII.isJsonObject()) {
                    final String llllllllllllllIIIIlIIllIlllIIIIl = llllllllllllllIIIIlIIllIllIlIlII.getAsJsonObject().get("text").getAsString();
                }
                else {
                    llllllllllllllIIIIlIIllIllIlIlIl = llllllllllllllIIIIlIIllIllIlIlII.getAsJsonPrimitive().getAsString();
                }
                if (AchievementTranslationMapping.get(llllllllllllllIIIIlIIllIllIlIlIl) == null) {
                    final JsonObject llllllllllllllIIIIlIIllIlllIIIII = new JsonObject();
                    llllllllllllllIIIIlIIllIlllIIIII.addProperty("text", "Invalid statistic/achievement!");
                    llllllllllllllIIIIlIIllIlllIIIII.addProperty("color", "red");
                    llllllllllllllIIIIlIIllIllIlIIlI.addProperty("action", "show_text");
                    llllllllllllllIIIIlIIllIllIlIIlI.add("value", llllllllllllllIIIIlIIllIlllIIIII);
                    super.handleHoverEvent(llllllllllllllIIIIlIIllIllIlIIlI);
                    return;
                }
                try {
                    final JsonObject llllllllllllllIIIIlIIllIllIllllI = new JsonObject();
                    llllllllllllllIIIIlIIllIllIllllI.addProperty("text", "\n");
                    final JsonArray llllllllllllllIIIIlIIllIllIlllIl = new JsonArray();
                    llllllllllllllIIIIlIIllIllIlllIl.add("");
                    final JsonObject llllllllllllllIIIIlIIllIllIlllII = new JsonObject();
                    final JsonObject llllllllllllllIIIIlIIllIllIllIll = new JsonObject();
                    llllllllllllllIIIIlIIllIllIlllIl.add(llllllllllllllIIIIlIIllIllIlllII);
                    llllllllllllllIIIIlIIllIllIlllIl.add(llllllllllllllIIIIlIIllIllIllllI);
                    llllllllllllllIIIIlIIllIllIlllIl.add(llllllllllllllIIIIlIIllIllIllIll);
                    if (llllllllllllllIIIIlIIllIllIlIlIl.startsWith("achievement")) {
                        llllllllllllllIIIIlIIllIllIlllII.addProperty("translate", llllllllllllllIIIIlIIllIllIlIlIl);
                        llllllllllllllIIIIlIIllIllIlllII.addProperty("color", AchievementTranslationMapping.isSpecial(llllllllllllllIIIIlIIllIllIlIlIl) ? "dark_purple" : "green");
                        llllllllllllllIIIIlIIllIllIllIll.addProperty("translate", "stats.tooltip.type.achievement");
                        final JsonObject llllllllllllllIIIIlIIllIllIlllll = new JsonObject();
                        llllllllllllllIIIIlIIllIllIllIll.addProperty("italic", true);
                        llllllllllllllIIIIlIIllIllIlllll.addProperty("translate", String.valueOf(new StringBuilder().append(llllllllllllllIIIIlIIllIllIlIlII).append(".desc")));
                        llllllllllllllIIIIlIIllIllIlllIl.add(llllllllllllllIIIIlIIllIllIllllI);
                        llllllllllllllIIIIlIIllIllIlllIl.add(llllllllllllllIIIIlIIllIllIlllll);
                    }
                    else if (llllllllllllllIIIIlIIllIllIlIlIl.startsWith("stat")) {
                        llllllllllllllIIIIlIIllIllIlllII.addProperty("translate", llllllllllllllIIIIlIIllIllIlIlIl);
                        llllllllllllllIIIIlIIllIllIlllII.addProperty("color", "gray");
                        llllllllllllllIIIIlIIllIllIllIll.addProperty("translate", "stats.tooltip.type.statistic");
                        llllllllllllllIIIIlIIllIllIllIll.addProperty("italic", true);
                    }
                    llllllllllllllIIIIlIIllIllIlIIlI.addProperty("action", "show_text");
                    llllllllllllllIIIIlIIllIllIlIIlI.add("value", llllllllllllllIIIIlIIllIllIlllIl);
                }
                catch (Exception llllllllllllllIIIIlIIllIllIllIIl) {
                    Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Error rewriting show_achievement: ").append(llllllllllllllIIIIlIIllIllIlIIlI)));
                    llllllllllllllIIIIlIIllIllIllIIl.printStackTrace();
                    final JsonObject llllllllllllllIIIIlIIllIllIllIlI = new JsonObject();
                    llllllllllllllIIIIlIIllIllIllIlI.addProperty("text", "Invalid statistic/achievement!");
                    llllllllllllllIIIIlIIllIllIllIlI.addProperty("color", "red");
                    llllllllllllllIIIIlIIllIllIlIIlI.addProperty("action", "show_text");
                    llllllllllllllIIIIlIIllIllIlIIlI.add("value", llllllllllllllIIIIlIIllIllIllIlI);
                }
                super.handleHoverEvent(llllllllllllllIIIIlIIllIllIlIIlI);
            }
        };
    }
    
    public static void toClient(final JsonElement lllllllllllllIIllllIIIlllllIIIll, final UserConnection lllllllllllllIIllllIIIlllllIIlII) {
        if (lllllllllllllIIllllIIIlllllIIIll instanceof JsonObject) {
            final JsonObject lllllllllllllIIllllIIIlllllIIlll = (JsonObject)lllllllllllllIIllllIIIlllllIIIll;
            final JsonElement lllllllllllllIIllllIIIlllllIIllI = lllllllllllllIIllllIIIlllllIIlll.get("translate");
            if (lllllllllllllIIllllIIIlllllIIllI != null && lllllllllllllIIllllIIIlllllIIllI.getAsString().startsWith("chat.type.achievement")) {
                TranslateRewriter.achievementTextRewriter.processText(lllllllllllllIIllllIIIlllllIIlll);
            }
        }
    }
}
