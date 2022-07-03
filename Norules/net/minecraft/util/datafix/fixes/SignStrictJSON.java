package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import java.lang.reflect.*;
import net.minecraft.util.text.*;
import com.google.gson.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;

public class SignStrictJSON implements IFixableData
{
    public static final /* synthetic */ Gson GSON_INSTANCE;
    
    static {
        GSON_INSTANCE = new GsonBuilder().registerTypeAdapter((Type)ITextComponent.class, (Object)new JsonDeserializer<ITextComponent>() {
            public ITextComponent deserialize(final JsonElement lllllllllllllIIllIIlIlIlIlIllllI, final Type lllllllllllllIIllIIlIlIlIlIlllIl, final JsonDeserializationContext lllllllllllllIIllIIlIlIlIlIlllII) throws JsonParseException {
                if (lllllllllllllIIllIIlIlIlIlIllllI.isJsonPrimitive()) {
                    return new TextComponentString(lllllllllllllIIllIIlIlIlIlIllllI.getAsString());
                }
                if (lllllllllllllIIllIIlIlIlIlIllllI.isJsonArray()) {
                    final JsonArray lllllllllllllIIllIIlIlIlIlIllIll = lllllllllllllIIllIIlIlIlIlIllllI.getAsJsonArray();
                    ITextComponent lllllllllllllIIllIIlIlIlIlIllIlI = null;
                    for (final JsonElement lllllllllllllIIllIIlIlIlIlIllIIl : lllllllllllllIIllIIlIlIlIlIllIll) {
                        final ITextComponent lllllllllllllIIllIIlIlIlIlIllIII = this.deserialize(lllllllllllllIIllIIlIlIlIlIllIIl, lllllllllllllIIllIIlIlIlIlIllIIl.getClass(), lllllllllllllIIllIIlIlIlIlIlllII);
                        if (lllllllllllllIIllIIlIlIlIlIllIlI == null) {
                            lllllllllllllIIllIIlIlIlIlIllIlI = lllllllllllllIIllIIlIlIlIlIllIII;
                        }
                        else {
                            lllllllllllllIIllIIlIlIlIlIllIlI.appendSibling(lllllllllllllIIllIIlIlIlIlIllIII);
                        }
                    }
                    return lllllllllllllIIllIIlIlIlIlIllIlI;
                }
                throw new JsonParseException(String.valueOf(new StringBuilder("Don't know how to turn ").append(lllllllllllllIIllIIlIlIlIlIllllI).append(" into a Component")));
            }
        }).create();
    }
    
    private void updateLine(final NBTTagCompound lllllllllllllIlIIIIlIllllIllIIIl, final String lllllllllllllIlIIIIlIllllIllIIII) {
        final String lllllllllllllIlIIIIlIllllIllIIll = lllllllllllllIlIIIIlIllllIllIIIl.getString(lllllllllllllIlIIIIlIllllIllIIII);
        ITextComponent lllllllllllllIlIIIIlIllllIllIIlI = null;
        Label_0185: {
            if (!"null".equals(lllllllllllllIlIIIIlIllllIllIIll) && !StringUtils.isNullOrEmpty(lllllllllllllIlIIIIlIllllIllIIll)) {
                if (lllllllllllllIlIIIIlIllllIllIIll.charAt(0) != '\"' || lllllllllllllIlIIIIlIllllIllIIll.charAt(lllllllllllllIlIIIIlIllllIllIIll.length() - 1) != '\"') {
                    if (lllllllllllllIlIIIIlIllllIllIIll.charAt(0) != '{' || lllllllllllllIlIIIIlIllllIllIIll.charAt(lllllllllllllIlIIIIlIllllIllIIll.length() - 1) != '}') {
                        lllllllllllllIlIIIIlIllllIllIIlI = new TextComponentString(lllllllllllllIlIIIIlIllllIllIIll);
                        break Label_0185;
                    }
                }
                try {
                    lllllllllllllIlIIIIlIllllIllIIlI = JsonUtils.gsonDeserialize(SignStrictJSON.GSON_INSTANCE, lllllllllllllIlIIIIlIllllIllIIll, ITextComponent.class, true);
                    if (lllllllllllllIlIIIIlIllllIllIIlI == null) {
                        lllllllllllllIlIIIIlIllllIllIIlI = new TextComponentString("");
                    }
                }
                catch (JsonParseException ex) {}
                if (lllllllllllllIlIIIIlIllllIllIIlI == null) {
                    try {
                        lllllllllllllIlIIIIlIllllIllIIlI = ITextComponent.Serializer.jsonToComponent(lllllllllllllIlIIIIlIllllIllIIll);
                    }
                    catch (JsonParseException ex2) {}
                }
                if (lllllllllllllIlIIIIlIllllIllIIlI == null) {
                    try {
                        lllllllllllllIlIIIIlIllllIllIIlI = ITextComponent.Serializer.fromJsonLenient(lllllllllllllIlIIIIlIllllIllIIll);
                    }
                    catch (JsonParseException ex3) {}
                }
                if (lllllllllllllIlIIIIlIllllIllIIlI == null) {
                    lllllllllllllIlIIIIlIllllIllIIlI = new TextComponentString(lllllllllllllIlIIIIlIllllIllIIll);
                }
            }
            else {
                lllllllllllllIlIIIIlIllllIllIIlI = new TextComponentString("");
            }
        }
        lllllllllllllIlIIIIlIllllIllIIIl.setString(lllllllllllllIlIIIIlIllllIllIIII, ITextComponent.Serializer.componentToJson(lllllllllllllIlIIIIlIllllIllIIlI));
    }
    
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lllllllllllllIlIIIIlIllllIlllllI) {
        if ("Sign".equals(lllllllllllllIlIIIIlIllllIlllllI.getString("id"))) {
            this.updateLine(lllllllllllllIlIIIIlIllllIlllllI, "Text1");
            this.updateLine(lllllllllllllIlIIIIlIllllIlllllI, "Text2");
            this.updateLine(lllllllllllllIlIIIIlIllllIlllllI, "Text3");
            this.updateLine(lllllllllllllIlIIIIlIllllIlllllI, "Text4");
        }
        return lllllllllllllIlIIIIlIllllIlllllI;
    }
    
    @Override
    public int getFixVersion() {
        return 101;
    }
}
