package optifine;

import com.google.gson.*;

public class Json
{
    public static float[] parseFloatArray(final JsonElement lIllIIlllIlllIl, final int lIllIIlllIlllII) {
        return parseFloatArray(lIllIIlllIlllIl, lIllIIlllIlllII, null);
    }
    
    public static float[] parseFloatArray(final JsonElement lIllIIlllIIllIl, final int lIllIIlllIlIIlI, final float[] lIllIIlllIlIIIl) {
        if (lIllIIlllIIllIl == null) {
            return lIllIIlllIlIIIl;
        }
        final JsonArray lIllIIlllIlIIII = lIllIIlllIIllIl.getAsJsonArray();
        if (lIllIIlllIlIIII.size() != lIllIIlllIlIIlI) {
            throw new JsonParseException(String.valueOf(new StringBuilder("Wrong array length: ").append(lIllIIlllIlIIII.size()).append(", should be: ").append(lIllIIlllIlIIlI).append(", array: ").append(lIllIIlllIlIIII)));
        }
        final float[] lIllIIlllIIllll = new float[lIllIIlllIlIIII.size()];
        for (int lIllIIlllIIlllI = 0; lIllIIlllIIlllI < lIllIIlllIIllll.length; ++lIllIIlllIIlllI) {
            lIllIIlllIIllll[lIllIIlllIIlllI] = lIllIIlllIlIIII.get(lIllIIlllIIlllI).getAsFloat();
        }
        return lIllIIlllIIllll;
    }
    
    public static int[] parseIntArray(final JsonElement lIllIIllIllIlIl, final int lIllIIllIlllIlI, final int[] lIllIIllIllIIll) {
        if (lIllIIllIllIlIl == null) {
            return lIllIIllIllIIll;
        }
        final JsonArray lIllIIllIlllIII = lIllIIllIllIlIl.getAsJsonArray();
        if (lIllIIllIlllIII.size() != lIllIIllIlllIlI) {
            throw new JsonParseException(String.valueOf(new StringBuilder("Wrong array length: ").append(lIllIIllIlllIII.size()).append(", should be: ").append(lIllIIllIlllIlI).append(", array: ").append(lIllIIllIlllIII)));
        }
        final int[] lIllIIllIllIlll = new int[lIllIIllIlllIII.size()];
        for (int lIllIIllIllIllI = 0; lIllIIllIllIllI < lIllIIllIllIlll.length; ++lIllIIllIllIllI) {
            lIllIIllIllIlll[lIllIIllIllIllI] = lIllIIllIlllIII.get(lIllIIllIllIllI).getAsInt();
        }
        return lIllIIllIllIlll;
    }
    
    public static boolean getBoolean(final JsonObject lIllIIlllllIlIl, final String lIllIIllllllIII, final boolean lIllIIlllllIIll) {
        final JsonElement lIllIIlllllIllI = lIllIIlllllIlIl.get(lIllIIllllllIII);
        return (lIllIIlllllIllI == null) ? lIllIIlllllIIll : lIllIIlllllIllI.getAsBoolean();
    }
    
    public static String getString(final JsonObject lIllIIllllIIlll, final String lIllIIllllIIIlI, final String lIllIIllllIIlIl) {
        final JsonElement lIllIIllllIIlII = lIllIIllllIIlll.get(lIllIIllllIIIlI);
        return (lIllIIllllIIlII == null) ? lIllIIllllIIlIl : lIllIIllllIIlII.getAsString();
    }
    
    public static String getString(final JsonObject lIllIIllllIllIl, final String lIllIIllllIllII) {
        return getString(lIllIIllllIllIl, lIllIIllllIllII, null);
    }
    
    public static int[] parseIntArray(final JsonElement lIllIIlllIIIIll, final int lIllIIlllIIIIlI) {
        return parseIntArray(lIllIIlllIIIIll, lIllIIlllIIIIlI, null);
    }
    
    public static float getFloat(final JsonObject lIllIlIIIIIIIIl, final String lIllIlIIIIIIIII, final float lIllIIlllllllll) {
        final JsonElement lIllIlIIIIIIIlI = lIllIlIIIIIIIIl.get(lIllIlIIIIIIIII);
        return (lIllIlIIIIIIIlI == null) ? lIllIIlllllllll : lIllIlIIIIIIIlI.getAsFloat();
    }
}
