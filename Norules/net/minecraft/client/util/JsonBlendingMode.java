package net.minecraft.client.util;

import net.minecraft.client.renderer.*;
import com.google.gson.*;
import net.minecraft.util.*;
import java.util.*;

public class JsonBlendingMode
{
    private final /* synthetic */ int srcAlphaFactor;
    private final /* synthetic */ boolean separateBlend;
    private final /* synthetic */ int srcColorFactor;
    private final /* synthetic */ int destAlphaFactor;
    private static /* synthetic */ JsonBlendingMode lastApplied;
    private final /* synthetic */ int destColorFactor;
    private final /* synthetic */ boolean opaque;
    private final /* synthetic */ int blendFunction;
    
    public void apply() {
        if (!this.equals(JsonBlendingMode.lastApplied)) {
            if (JsonBlendingMode.lastApplied == null || this.opaque != JsonBlendingMode.lastApplied.isOpaque()) {
                JsonBlendingMode.lastApplied = this;
                if (this.opaque) {
                    GlStateManager.disableBlend();
                    return;
                }
                GlStateManager.enableBlend();
            }
            GlStateManager.glBlendEquation(this.blendFunction);
            if (this.separateBlend) {
                GlStateManager.tryBlendFuncSeparate(this.srcColorFactor, this.destColorFactor, this.srcAlphaFactor, this.destAlphaFactor);
            }
            else {
                GlStateManager.blendFunc(this.srcColorFactor, this.destColorFactor);
            }
        }
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIlIlIllIIllIIlIlII) {
        if (this == llllllllllllllIlIlIllIIllIIlIlII) {
            return true;
        }
        if (!(llllllllllllllIlIlIllIIllIIlIlII instanceof JsonBlendingMode)) {
            return false;
        }
        final JsonBlendingMode llllllllllllllIlIlIllIIllIIlIIlI = (JsonBlendingMode)llllllllllllllIlIlIllIIllIIlIlII;
        return this.blendFunction == llllllllllllllIlIlIllIIllIIlIIlI.blendFunction && this.destAlphaFactor == llllllllllllllIlIlIllIIllIIlIIlI.destAlphaFactor && this.destColorFactor == llllllllllllllIlIlIllIIllIIlIIlI.destColorFactor && this.opaque == llllllllllllllIlIlIllIIllIIlIIlI.opaque && this.separateBlend == llllllllllllllIlIlIllIIllIIlIIlI.separateBlend && this.srcAlphaFactor == llllllllllllllIlIlIllIIllIIlIIlI.srcAlphaFactor && this.srcColorFactor == llllllllllllllIlIlIllIIllIIlIIlI.srcColorFactor;
    }
    
    public static JsonBlendingMode parseBlendNode(final JsonObject llllllllllllllIlIlIllIIlIlIlIlIl) {
        if (llllllllllllllIlIlIllIIlIlIlIlIl == null) {
            return new JsonBlendingMode();
        }
        int llllllllllllllIlIlIllIIlIlIlIlII = 32774;
        int llllllllllllllIlIlIllIIlIlIlIIll = 1;
        int llllllllllllllIlIlIllIIlIlIlIIlI = 0;
        int llllllllllllllIlIlIllIIlIlIlIIIl = 1;
        int llllllllllllllIlIlIllIIlIlIlIIII = 0;
        boolean llllllllllllllIlIlIllIIlIlIIllll = true;
        boolean llllllllllllllIlIlIllIIlIlIIlllI = false;
        if (JsonUtils.isString(llllllllllllllIlIlIllIIlIlIlIlIl, "func")) {
            llllllllllllllIlIlIllIIlIlIlIlII = stringToBlendFunction(llllllllllllllIlIlIllIIlIlIlIlIl.get("func").getAsString());
            if (llllllllllllllIlIlIllIIlIlIlIlII != 32774) {
                llllllllllllllIlIlIllIIlIlIIllll = false;
            }
        }
        if (JsonUtils.isString(llllllllllllllIlIlIllIIlIlIlIlIl, "srcrgb")) {
            llllllllllllllIlIlIllIIlIlIlIIll = stringToBlendFactor(llllllllllllllIlIlIllIIlIlIlIlIl.get("srcrgb").getAsString());
            if (llllllllllllllIlIlIllIIlIlIlIIll != 1) {
                llllllllllllllIlIlIllIIlIlIIllll = false;
            }
        }
        if (JsonUtils.isString(llllllllllllllIlIlIllIIlIlIlIlIl, "dstrgb")) {
            llllllllllllllIlIlIllIIlIlIlIIlI = stringToBlendFactor(llllllllllllllIlIlIllIIlIlIlIlIl.get("dstrgb").getAsString());
            if (llllllllllllllIlIlIllIIlIlIlIIlI != 0) {
                llllllllllllllIlIlIllIIlIlIIllll = false;
            }
        }
        if (JsonUtils.isString(llllllllllllllIlIlIllIIlIlIlIlIl, "srcalpha")) {
            llllllllllllllIlIlIllIIlIlIlIIIl = stringToBlendFactor(llllllllllllllIlIlIllIIlIlIlIlIl.get("srcalpha").getAsString());
            if (llllllllllllllIlIlIllIIlIlIlIIIl != 1) {
                llllllllllllllIlIlIllIIlIlIIllll = false;
            }
            llllllllllllllIlIlIllIIlIlIIlllI = true;
        }
        if (JsonUtils.isString(llllllllllllllIlIlIllIIlIlIlIlIl, "dstalpha")) {
            llllllllllllllIlIlIllIIlIlIlIIII = stringToBlendFactor(llllllllllllllIlIlIllIIlIlIlIlIl.get("dstalpha").getAsString());
            if (llllllllllllllIlIlIllIIlIlIlIIII != 0) {
                llllllllllllllIlIlIllIIlIlIIllll = false;
            }
            llllllllllllllIlIlIllIIlIlIIlllI = true;
        }
        if (llllllllllllllIlIlIllIIlIlIIllll) {
            return new JsonBlendingMode();
        }
        return llllllllllllllIlIlIllIIlIlIIlllI ? new JsonBlendingMode(llllllllllllllIlIlIllIIlIlIlIIll, llllllllllllllIlIlIllIIlIlIlIIlI, llllllllllllllIlIlIllIIlIlIlIIIl, llllllllllllllIlIlIllIIlIlIlIIII, llllllllllllllIlIlIllIIlIlIlIlII) : new JsonBlendingMode(llllllllllllllIlIlIllIIlIlIlIIll, llllllllllllllIlIlIllIIlIlIlIIlI, llllllllllllllIlIlIllIIlIlIlIlII);
    }
    
    private JsonBlendingMode(final boolean llllllllllllllIlIlIllIIlllllllll, final boolean llllllllllllllIlIlIllIIlllllIIIl, final int llllllllllllllIlIlIllIIllllllIll, final int llllllllllllllIlIlIllIIllllIllll, final int llllllllllllllIlIlIllIIlllllIlll, final int llllllllllllllIlIlIllIIlllllIlIl, final int llllllllllllllIlIlIllIIlllllIlII) {
        this.separateBlend = llllllllllllllIlIlIllIIlllllllll;
        this.srcColorFactor = llllllllllllllIlIlIllIIllllllIll;
        this.destColorFactor = llllllllllllllIlIlIllIIllllIllll;
        this.srcAlphaFactor = llllllllllllllIlIlIllIIlllllIlll;
        this.destAlphaFactor = llllllllllllllIlIlIllIIlllllIlIl;
        this.opaque = llllllllllllllIlIlIllIIlllllIIIl;
        this.blendFunction = llllllllllllllIlIlIllIIlllllIlII;
    }
    
    private static int stringToBlendFunction(final String llllllllllllllIlIlIllIIlIIllIIII) {
        final String llllllllllllllIlIlIllIIlIIlIllll = llllllllllllllIlIlIllIIlIIllIIII.trim().toLowerCase(Locale.ROOT);
        if ("add".equals(llllllllllllllIlIlIllIIlIIlIllll)) {
            return 32774;
        }
        if ("subtract".equals(llllllllllllllIlIlIllIIlIIlIllll)) {
            return 32778;
        }
        if ("reversesubtract".equals(llllllllllllllIlIlIllIIlIIlIllll)) {
            return 32779;
        }
        if ("reverse_subtract".equals(llllllllllllllIlIlIllIIlIIlIllll)) {
            return 32779;
        }
        if ("min".equals(llllllllllllllIlIlIllIIlIIlIllll)) {
            return 32775;
        }
        return "max".equals(llllllllllllllIlIlIllIIlIIlIllll) ? 32776 : 32774;
    }
    
    public boolean isOpaque() {
        return this.opaque;
    }
    
    public JsonBlendingMode(final int llllllllllllllIlIlIllIIlllIIIIII, final int llllllllllllllIlIlIllIIllIllllll, final int llllllllllllllIlIlIllIIllIlllllI, final int llllllllllllllIlIlIllIIllIllIlll, final int llllllllllllllIlIlIllIIllIllIlIl) {
        this(true, false, llllllllllllllIlIlIllIIlllIIIIII, llllllllllllllIlIlIllIIllIllllll, llllllllllllllIlIlIllIIllIlllllI, llllllllllllllIlIlIllIIllIllIlll, llllllllllllllIlIlIllIIllIllIlIl);
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIlIlIllIIlIlllllII = this.srcColorFactor;
        llllllllllllllIlIlIllIIlIlllllII = 31 * llllllllllllllIlIlIllIIlIlllllII + this.srcAlphaFactor;
        llllllllllllllIlIlIllIIlIlllllII = 31 * llllllllllllllIlIlIllIIlIlllllII + this.destColorFactor;
        llllllllllllllIlIlIllIIlIlllllII = 31 * llllllllllllllIlIlIllIIlIlllllII + this.destAlphaFactor;
        llllllllllllllIlIlIllIIlIlllllII = 31 * llllllllllllllIlIlIllIIlIlllllII + this.blendFunction;
        llllllllllllllIlIlIllIIlIlllllII = 31 * llllllllllllllIlIlIllIIlIlllllII + (this.separateBlend ? 1 : 0);
        llllllllllllllIlIlIllIIlIlllllII = 31 * llllllllllllllIlIlIllIIlIlllllII + (this.opaque ? 1 : 0);
        return llllllllllllllIlIlIllIIlIlllllII;
    }
    
    public JsonBlendingMode(final int llllllllllllllIlIlIllIIlllIllIII, final int llllllllllllllIlIlIllIIlllIIllll, final int llllllllllllllIlIlIllIIlllIIlllI) {
        this(false, false, llllllllllllllIlIlIllIIlllIllIII, llllllllllllllIlIlIllIIlllIIllll, llllllllllllllIlIlIllIIlllIllIII, llllllllllllllIlIlIllIIlllIIllll, llllllllllllllIlIlIllIIlllIIlllI);
    }
    
    public JsonBlendingMode() {
        this(false, true, 1, 0, 1, 0, 32774);
    }
    
    private static int stringToBlendFactor(final String llllllllllllllIlIlIllIIlIIlIIllI) {
        String llllllllllllllIlIlIllIIlIIlIIlIl = llllllllllllllIlIlIllIIlIIlIIllI.trim().toLowerCase(Locale.ROOT);
        llllllllllllllIlIlIllIIlIIlIIlIl = llllllllllllllIlIlIllIIlIIlIIlIl.replaceAll("_", "");
        llllllllllllllIlIlIllIIlIIlIIlIl = llllllllllllllIlIlIllIIlIIlIIlIl.replaceAll("one", "1");
        llllllllllllllIlIlIllIIlIIlIIlIl = llllllllllllllIlIlIllIIlIIlIIlIl.replaceAll("zero", "0");
        llllllllllllllIlIlIllIIlIIlIIlIl = llllllllllllllIlIlIllIIlIIlIIlIl.replaceAll("minus", "-");
        if ("0".equals(llllllllllllllIlIlIllIIlIIlIIlIl)) {
            return 0;
        }
        if ("1".equals(llllllllllllllIlIlIllIIlIIlIIlIl)) {
            return 1;
        }
        if ("srccolor".equals(llllllllllllllIlIlIllIIlIIlIIlIl)) {
            return 768;
        }
        if ("1-srccolor".equals(llllllllllllllIlIlIllIIlIIlIIlIl)) {
            return 769;
        }
        if ("dstcolor".equals(llllllllllllllIlIlIllIIlIIlIIlIl)) {
            return 774;
        }
        if ("1-dstcolor".equals(llllllllllllllIlIlIllIIlIIlIIlIl)) {
            return 775;
        }
        if ("srcalpha".equals(llllllllllllllIlIlIllIIlIIlIIlIl)) {
            return 770;
        }
        if ("1-srcalpha".equals(llllllllllllllIlIlIllIIlIIlIIlIl)) {
            return 771;
        }
        if ("dstalpha".equals(llllllllllllllIlIlIllIIlIIlIIlIl)) {
            return 772;
        }
        return "1-dstalpha".equals(llllllllllllllIlIlIllIIlIIlIIlIl) ? 773 : -1;
    }
}
