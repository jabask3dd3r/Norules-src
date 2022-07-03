package net.minecraft.advancements;

import java.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.server.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraft.command.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.item.*;
import java.lang.reflect.*;
import net.minecraft.util.*;
import com.google.gson.*;
import net.minecraft.item.crafting.*;

public class AdvancementRewards
{
    private final /* synthetic */ ResourceLocation[] field_192116_c;
    private final /* synthetic */ ResourceLocation[] field_192117_d;
    private final /* synthetic */ FunctionObject.CacheableFunction field_193129_e;
    private final /* synthetic */ int field_192115_b;
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("AdvancementRewards{experience=").append(this.field_192115_b).append(", loot=").append(Arrays.toString(this.field_192116_c)).append(", recipes=").append(Arrays.toString(this.field_192117_d)).append(", function=").append(this.field_193129_e).append('}'));
    }
    
    static {
        field_192114_a = new AdvancementRewards(0, new ResourceLocation[0], new ResourceLocation[0], FunctionObject.CacheableFunction.field_193519_a);
    }
    
    public void func_192113_a(final EntityPlayerMP lllllllllllllIIIIllIIlllllllllll) {
        lllllllllllllIIIIllIIlllllllllll.addExperience(this.field_192115_b);
        final LootContext lllllllllllllIIIIllIIllllllllllI = new LootContext.Builder(lllllllllllllIIIIllIIlllllllllll.getServerWorld()).withLootedEntity(lllllllllllllIIIIllIIlllllllllll).build();
        boolean lllllllllllllIIIIllIIlllllllllIl = false;
        final char lllllllllllllIIIIllIIllllllIllll;
        final long lllllllllllllIIIIllIIlllllllIIII = ((ResourceLocation[])(Object)(lllllllllllllIIIIllIIllllllIllll = (char)(Object)this.field_192116_c)).length;
        for (String lllllllllllllIIIIllIIlllllllIIIl = (String)0; lllllllllllllIIIIllIIlllllllIIIl < lllllllllllllIIIIllIIlllllllIIII; ++lllllllllllllIIIIllIIlllllllIIIl) {
            final ResourceLocation lllllllllllllIIIIllIIlllllllllII = lllllllllllllIIIIllIIllllllIllll[lllllllllllllIIIIllIIlllllllIIIl];
            for (final ItemStack lllllllllllllIIIIllIIllllllllIll : lllllllllllllIIIIllIIlllllllllll.world.getLootTableManager().getLootTableFromLocation(lllllllllllllIIIIllIIlllllllllII).generateLootForPools(lllllllllllllIIIIllIIlllllllllll.getRNG(), lllllllllllllIIIIllIIllllllllllI)) {
                if (lllllllllllllIIIIllIIlllllllllll.func_191521_c(lllllllllllllIIIIllIIllllllllIll)) {
                    lllllllllllllIIIIllIIlllllllllll.world.playSound(null, lllllllllllllIIIIllIIlllllllllll.posX, lllllllllllllIIIIllIIlllllllllll.posY, lllllllllllllIIIIllIIlllllllllll.posZ, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2f, ((lllllllllllllIIIIllIIlllllllllll.getRNG().nextFloat() - lllllllllllllIIIIllIIlllllllllll.getRNG().nextFloat()) * 0.7f + 1.0f) * 2.0f);
                    lllllllllllllIIIIllIIlllllllllIl = true;
                }
                else {
                    final EntityItem lllllllllllllIIIIllIIllllllllIlI = lllllllllllllIIIIllIIlllllllllll.dropItem(lllllllllllllIIIIllIIllllllllIll, false);
                    if (lllllllllllllIIIIllIIllllllllIlI == null) {
                        continue;
                    }
                    lllllllllllllIIIIllIIllllllllIlI.setNoPickupDelay();
                    lllllllllllllIIIIllIIllllllllIlI.setOwner(lllllllllllllIIIIllIIlllllllllll.getName());
                }
            }
        }
        if (lllllllllllllIIIIllIIlllllllllIl) {
            lllllllllllllIIIIllIIlllllllllll.inventoryContainer.detectAndSendChanges();
        }
        if (this.field_192117_d.length > 0) {
            lllllllllllllIIIIllIIlllllllllll.func_193102_a(this.field_192117_d);
        }
        final MinecraftServer lllllllllllllIIIIllIIllllllllIIl = lllllllllllllIIIIllIIlllllllllll.mcServer;
        final FunctionObject lllllllllllllIIIIllIIllllllllIII = this.field_193129_e.func_193518_a(lllllllllllllIIIIllIIllllllllIIl.func_193030_aL());
        if (lllllllllllllIIIIllIIllllllllIII != null) {
            final ICommandSender lllllllllllllIIIIllIIlllllllIlll = new ICommandSender() {
                @Override
                public ITextComponent getDisplayName() {
                    return lllllllllllllIIIIllIIlllllllllll.getDisplayName();
                }
                
                @Override
                public Vec3d getPositionVector() {
                    return lllllllllllllIIIIllIIlllllllllll.getPositionVector();
                }
                
                @Override
                public boolean canCommandSenderUseCommand(final int llllllllllllllIIlIIIIIIlIIlIlIIl, final String llllllllllllllIIlIIIIIIlIIlIlIII) {
                    return llllllllllllllIIlIIIIIIlIIlIlIIl <= 2;
                }
                
                @Override
                public World getEntityWorld() {
                    return lllllllllllllIIIIllIIlllllllllll.world;
                }
                
                @Override
                public MinecraftServer getServer() {
                    return lllllllllllllIIIIllIIlllllllllll.getServer();
                }
                
                @Override
                public String getName() {
                    return lllllllllllllIIIIllIIlllllllllll.getName();
                }
                
                @Override
                public void addChatMessage(final ITextComponent llllllllllllllIIlIIIIIIlIIlIllII) {
                }
                
                @Override
                public void setCommandStat(final CommandResultStats.Type llllllllllllllIIlIIIIIIlIIIlIIll, final int llllllllllllllIIlIIIIIIlIIIIllll) {
                    lllllllllllllIIIIllIIlllllllllll.setCommandStat(llllllllllllllIIlIIIIIIlIIIlIIll, llllllllllllllIIlIIIIIIlIIIIllll);
                }
                
                @Override
                public Entity getCommandSenderEntity() {
                    return lllllllllllllIIIIllIIlllllllllll;
                }
                
                @Override
                public boolean sendCommandFeedback() {
                    return lllllllllllllIIIIllIIllllllllIIl.worldServers[0].getGameRules().getBoolean("commandBlockOutput");
                }
                
                @Override
                public BlockPos getPosition() {
                    return lllllllllllllIIIIllIIlllllllllll.getPosition();
                }
            };
            lllllllllllllIIIIllIIllllllllIIl.func_193030_aL().func_194019_a(lllllllllllllIIIIllIIllllllllIII, lllllllllllllIIIIllIIlllllllIlll);
        }
    }
    
    public AdvancementRewards(final int lllllllllllllIIIIllIlIIIIIIIllll, final ResourceLocation[] lllllllllllllIIIIllIlIIIIIIlIIll, final ResourceLocation[] lllllllllllllIIIIllIlIIIIIIIllIl, final FunctionObject.CacheableFunction lllllllllllllIIIIllIlIIIIIIIllII) {
        this.field_192115_b = lllllllllllllIIIIllIlIIIIIIIllll;
        this.field_192116_c = lllllllllllllIIIIllIlIIIIIIlIIll;
        this.field_192117_d = lllllllllllllIIIIllIlIIIIIIIllIl;
        this.field_193129_e = lllllllllllllIIIIllIlIIIIIIIllII;
    }
    
    public static class Deserializer implements JsonDeserializer<AdvancementRewards>
    {
        public AdvancementRewards deserialize(final JsonElement lllllllllllllIllIIIlIlIlIlllIllI, final Type lllllllllllllIllIIIlIlIllIIIIIll, final JsonDeserializationContext lllllllllllllIllIIIlIlIllIIIIIlI) throws JsonParseException {
            final JsonObject lllllllllllllIllIIIlIlIllIIIIIIl = JsonUtils.getJsonObject(lllllllllllllIllIIIlIlIlIlllIllI, "rewards");
            final int lllllllllllllIllIIIlIlIllIIIIIII = JsonUtils.getInt(lllllllllllllIllIIIlIlIllIIIIIIl, "experience", 0);
            final JsonArray lllllllllllllIllIIIlIlIlIlllllll = JsonUtils.getJsonArray(lllllllllllllIllIIIlIlIllIIIIIIl, "loot", new JsonArray());
            final ResourceLocation[] lllllllllllllIllIIIlIlIlIllllllI = new ResourceLocation[lllllllllllllIllIIIlIlIlIlllllll.size()];
            for (int lllllllllllllIllIIIlIlIlIlllllIl = 0; lllllllllllllIllIIIlIlIlIlllllIl < lllllllllllllIllIIIlIlIlIllllllI.length; ++lllllllllllllIllIIIlIlIlIlllllIl) {
                lllllllllllllIllIIIlIlIlIllllllI[lllllllllllllIllIIIlIlIlIlllllIl] = new ResourceLocation(JsonUtils.getString(lllllllllllllIllIIIlIlIlIlllllll.get(lllllllllllllIllIIIlIlIlIlllllIl), String.valueOf(new StringBuilder("loot[").append(lllllllllllllIllIIIlIlIlIlllllIl).append("]"))));
            }
            final JsonArray lllllllllllllIllIIIlIlIlIlllllII = JsonUtils.getJsonArray(lllllllllllllIllIIIlIlIllIIIIIIl, "recipes", new JsonArray());
            final ResourceLocation[] lllllllllllllIllIIIlIlIlIllllIll = new ResourceLocation[lllllllllllllIllIIIlIlIlIlllllII.size()];
            for (int lllllllllllllIllIIIlIlIlIllllIlI = 0; lllllllllllllIllIIIlIlIlIllllIlI < lllllllllllllIllIIIlIlIlIllllIll.length; ++lllllllllllllIllIIIlIlIlIllllIlI) {
                lllllllllllllIllIIIlIlIlIllllIll[lllllllllllllIllIIIlIlIlIllllIlI] = new ResourceLocation(JsonUtils.getString(lllllllllllllIllIIIlIlIlIlllllII.get(lllllllllllllIllIIIlIlIlIllllIlI), String.valueOf(new StringBuilder("recipes[").append(lllllllllllllIllIIIlIlIlIllllIlI).append("]"))));
                final IRecipe lllllllllllllIllIIIlIlIlIllllIIl = CraftingManager.func_193373_a(lllllllllllllIllIIIlIlIlIllllIll[lllllllllllllIllIIIlIlIlIllllIlI]);
                if (lllllllllllllIllIIIlIlIlIllllIIl == null) {
                    throw new JsonSyntaxException(String.valueOf(new StringBuilder("Unknown recipe '").append(lllllllllllllIllIIIlIlIlIllllIll[lllllllllllllIllIIIlIlIlIllllIlI]).append("'")));
                }
            }
            FunctionObject.CacheableFunction lllllllllllllIllIIIlIlIlIlllIlll = null;
            if (lllllllllllllIllIIIlIlIllIIIIIIl.has("function")) {
                final FunctionObject.CacheableFunction lllllllllllllIllIIIlIlIlIllllIII = new FunctionObject.CacheableFunction(new ResourceLocation(JsonUtils.getString(lllllllllllllIllIIIlIlIllIIIIIIl, "function")));
            }
            else {
                lllllllllllllIllIIIlIlIlIlllIlll = FunctionObject.CacheableFunction.field_193519_a;
            }
            return new AdvancementRewards(lllllllllllllIllIIIlIlIllIIIIIII, lllllllllllllIllIIIlIlIlIllllllI, lllllllllllllIllIIIlIlIlIllllIll, lllllllllllllIllIIIlIlIlIlllIlll);
        }
    }
}
