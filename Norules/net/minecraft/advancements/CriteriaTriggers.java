package net.minecraft.advancements;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.advancements.critereon.*;
import com.google.common.collect.*;
import javax.annotation.*;

public class CriteriaTriggers
{
    private static final /* synthetic */ Map<ResourceLocation, ICriterionTrigger<?>> field_192139_s;
    
    private static <T extends ICriterionTrigger> T func_192118_a(final T lllllllllllllIIllIlIIIIllllIlIII) {
        if (CriteriaTriggers.field_192139_s.containsKey(lllllllllllllIIllIlIIIIllllIlIII.func_192163_a())) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Duplicate criterion id ").append(lllllllllllllIIllIlIIIIllllIlIII.func_192163_a())));
        }
        CriteriaTriggers.field_192139_s.put(lllllllllllllIIllIlIIIIllllIlIII.func_192163_a(), lllllllllllllIIllIlIIIIllllIlIII);
        return lllllllllllllIIllIlIIIIllllIlIII;
    }
    
    static {
        field_192139_s = Maps.newHashMap();
        field_192121_a = func_192118_a(new ImpossibleTrigger());
        field_192122_b = func_192118_a(new KilledTrigger(new ResourceLocation("player_killed_entity")));
        field_192123_c = func_192118_a(new KilledTrigger(new ResourceLocation("entity_killed_player")));
        field_192124_d = func_192118_a(new EnterBlockTrigger());
        field_192125_e = func_192118_a(new InventoryChangeTrigger());
        field_192126_f = func_192118_a(new RecipeUnlockedTrigger());
        field_192127_g = func_192118_a(new PlayerHurtEntityTrigger());
        field_192128_h = func_192118_a(new EntityHurtPlayerTrigger());
        field_192129_i = func_192118_a(new EnchantedItemTrigger());
        field_192130_j = func_192118_a(new BrewedPotionTrigger());
        field_192131_k = func_192118_a(new ConstructBeaconTrigger());
        field_192132_l = func_192118_a(new UsedEnderEyeTrigger());
        field_192133_m = func_192118_a(new SummonedEntityTrigger());
        field_192134_n = func_192118_a(new BredAnimalsTrigger());
        field_192135_o = func_192118_a(new PositionTrigger(new ResourceLocation("location")));
        field_192136_p = func_192118_a(new PositionTrigger(new ResourceLocation("slept_in_bed")));
        field_192137_q = func_192118_a(new CuredZombieVillagerTrigger());
        field_192138_r = func_192118_a(new VillagerTradeTrigger());
        field_193132_s = func_192118_a(new ItemDurabilityTrigger());
        field_193133_t = func_192118_a(new LevitationTrigger());
        field_193134_u = func_192118_a(new ChangeDimensionTrigger());
        field_193135_v = func_192118_a(new TickTrigger());
        field_193136_w = func_192118_a(new TameAnimalTrigger());
        field_193137_x = func_192118_a(new PlacedBlockTrigger());
        field_193138_y = func_192118_a(new ConsumeItemTrigger());
        field_193139_z = func_192118_a(new EffectsChangedTrigger());
        field_193130_A = func_192118_a(new UsedTotemTrigger());
        field_193131_B = func_192118_a(new NetherTravelTrigger());
    }
    
    public static Iterable<? extends ICriterionTrigger<?>> func_192120_a() {
        return CriteriaTriggers.field_192139_s.values();
    }
    
    @Nullable
    public static <T extends ICriterionInstance> ICriterionTrigger<T> func_192119_a(final ResourceLocation lllllllllllllIIllIlIIIIllllIIllI) {
        return (ICriterionTrigger<T>)CriteriaTriggers.field_192139_s.get(lllllllllllllIIllIlIIIIllllIIllI);
    }
}
