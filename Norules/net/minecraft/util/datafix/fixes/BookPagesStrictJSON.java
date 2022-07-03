package net.minecraft.util.datafix.fixes;

import net.minecraft.util.datafix.*;
import net.minecraft.util.text.*;
import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.nbt.*;

public class BookPagesStrictJSON implements IFixableData
{
    @Override
    public NBTTagCompound fixTagCompound(final NBTTagCompound lIllIlIlIlIllll) {
        if ("minecraft:written_book".equals(lIllIlIlIlIllll.getString("id"))) {
            final NBTTagCompound lIllIlIlIlIlllI = lIllIlIlIlIllll.getCompoundTag("tag");
            if (lIllIlIlIlIlllI.hasKey("pages", 9)) {
                final NBTTagList lIllIlIlIlIllIl = lIllIlIlIlIlllI.getTagList("pages", 8);
                for (int lIllIlIlIlIllII = 0; lIllIlIlIlIllII < lIllIlIlIlIllIl.tagCount(); ++lIllIlIlIlIllII) {
                    final String lIllIlIlIlIlIll = lIllIlIlIlIllIl.getStringTagAt(lIllIlIlIlIllII);
                    ITextComponent lIllIlIlIlIlIlI = null;
                    Label_0247: {
                        if (!"null".equals(lIllIlIlIlIlIll) && !StringUtils.isNullOrEmpty(lIllIlIlIlIlIll)) {
                            if (lIllIlIlIlIlIll.charAt(0) != '\"' || lIllIlIlIlIlIll.charAt(lIllIlIlIlIlIll.length() - 1) != '\"') {
                                if (lIllIlIlIlIlIll.charAt(0) != '{' || lIllIlIlIlIlIll.charAt(lIllIlIlIlIlIll.length() - 1) != '}') {
                                    lIllIlIlIlIlIlI = new TextComponentString(lIllIlIlIlIlIll);
                                    break Label_0247;
                                }
                            }
                            try {
                                lIllIlIlIlIlIlI = JsonUtils.gsonDeserialize(SignStrictJSON.GSON_INSTANCE, lIllIlIlIlIlIll, ITextComponent.class, true);
                                if (lIllIlIlIlIlIlI == null) {
                                    lIllIlIlIlIlIlI = new TextComponentString("");
                                }
                            }
                            catch (JsonParseException ex) {}
                            if (lIllIlIlIlIlIlI == null) {
                                try {
                                    lIllIlIlIlIlIlI = ITextComponent.Serializer.jsonToComponent(lIllIlIlIlIlIll);
                                }
                                catch (JsonParseException ex2) {}
                            }
                            if (lIllIlIlIlIlIlI == null) {
                                try {
                                    lIllIlIlIlIlIlI = ITextComponent.Serializer.fromJsonLenient(lIllIlIlIlIlIll);
                                }
                                catch (JsonParseException ex3) {}
                            }
                            if (lIllIlIlIlIlIlI == null) {
                                lIllIlIlIlIlIlI = new TextComponentString(lIllIlIlIlIlIll);
                            }
                        }
                        else {
                            lIllIlIlIlIlIlI = new TextComponentString("");
                        }
                    }
                    lIllIlIlIlIllIl.set(lIllIlIlIlIllII, new NBTTagString(ITextComponent.Serializer.componentToJson(lIllIlIlIlIlIlI)));
                }
                lIllIlIlIlIlllI.setTag("pages", lIllIlIlIlIllIl);
            }
        }
        return lIllIlIlIlIllll;
    }
    
    @Override
    public int getFixVersion() {
        return 165;
    }
}
