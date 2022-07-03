package net.minecraft.world.storage.loot.functions;

import net.minecraft.item.*;
import java.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import com.google.gson.*;

public class SetNBT extends LootFunction
{
    private final /* synthetic */ NBTTagCompound tag;
    
    @Override
    public ItemStack apply(final ItemStack llllllllllllllIIllllllllllllIlIl, final Random llllllllllllllIIllllllllllllIlII, final LootContext llllllllllllllIIllllllllllllIIll) {
        NBTTagCompound llllllllllllllIIllllllllllllIIlI = llllllllllllllIIllllllllllllIlIl.getTagCompound();
        if (llllllllllllllIIllllllllllllIIlI == null) {
            llllllllllllllIIllllllllllllIIlI = this.tag.copy();
        }
        else {
            llllllllllllllIIllllllllllllIIlI.merge(this.tag);
        }
        llllllllllllllIIllllllllllllIlIl.setTagCompound(llllllllllllllIIllllllllllllIIlI);
        return llllllllllllllIIllllllllllllIlIl;
    }
    
    public SetNBT(final LootCondition[] llllllllllllllIIlllllllllllllllI, final NBTTagCompound llllllllllllllIIllllllllllllllIl) {
        super(llllllllllllllIIlllllllllllllllI);
        this.tag = llllllllllllllIIllllllllllllllIl;
    }
    
    public static class Serializer extends LootFunction.Serializer<SetNBT>
    {
        @Override
        public SetNBT deserialize(final JsonObject lllllllllllllIIIIllIlIlIIIIIIlll, final JsonDeserializationContext lllllllllllllIIIIllIlIlIIIIIlIll, final LootCondition[] lllllllllllllIIIIllIlIlIIIIIlIlI) {
            try {
                final NBTTagCompound lllllllllllllIIIIllIlIlIIIIIlIIl = JsonToNBT.getTagFromJson(JsonUtils.getString(lllllllllllllIIIIllIlIlIIIIIIlll, "tag"));
                return new SetNBT(lllllllllllllIIIIllIlIlIIIIIlIlI, lllllllllllllIIIIllIlIlIIIIIlIIl);
            }
            catch (NBTException lllllllllllllIIIIllIlIlIIIIIlIII) {
                throw new JsonSyntaxException((Throwable)lllllllllllllIIIIllIlIlIIIIIlIII);
            }
        }
        
        public Serializer() {
            super(new ResourceLocation("set_nbt"), SetNBT.class);
        }
        
        @Override
        public void serialize(final JsonObject lllllllllllllIIIIllIlIlIIIIlIlIl, final SetNBT lllllllllllllIIIIllIlIlIIIIlIIIl, final JsonSerializationContext lllllllllllllIIIIllIlIlIIIIlIIll) {
            lllllllllllllIIIIllIlIlIIIIlIlIl.addProperty("tag", lllllllllllllIIIIllIlIlIIIIlIIIl.tag.toString());
        }
    }
}
