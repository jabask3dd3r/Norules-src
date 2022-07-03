package net.optifine.entity.model;

import java.util.*;
import optifine.*;

public class CustomModelRegistry
{
    private static /* synthetic */ Map<String, ModelAdapter> mapModelAdapters;
    
    static {
        CustomModelRegistry.mapModelAdapters = makeMapModelAdapters();
    }
    
    private static Map<String, ModelAdapter> makeMapModelAdapters() {
        final Map<String, ModelAdapter> lllllllllllllIllIIlIlIIIIIlIlIIl = new LinkedHashMap<String, ModelAdapter>();
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterArmorStand());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterBat());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterBlaze());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterBoat());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterCaveSpider());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterChicken());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterCow());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterCreeper());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterDragon());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterDonkey());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterEnderCrystal());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterEnderCrystalNoBase());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterEnderman());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterEndermite());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterEvoker());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterEvokerFangs());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterGhast());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterGuardian());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterHorse());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterHusk());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterIronGolem());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterLeadKnot());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterLlama());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterMagmaCube());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterMinecart());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterMinecartTnt());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterMinecartMobSpawner());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterMooshroom());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterMule());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterOcelot());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterPig());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterPigZombie());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterPolarBear());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterRabbit());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterSheep());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterShulker());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterShulkerBullet());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterSilverfish());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterSkeleton());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterSkeletonHorse());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterSlime());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterSnowman());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterSpider());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterSquid());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterStray());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterVex());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterVillager());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterVindicator());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterWitch());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterWither());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterWitherSkeleton());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterWitherSkull());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterWolf());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterZombie());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterZombieHorse());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterZombieVillager());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterSheepWool());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterBanner());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterBook());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterChest());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterChestLarge());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterEnderChest());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterHeadDragon());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterHeadHumanoid());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterHeadSkeleton());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterShulkerBox());
        addModelAdapter(lllllllllllllIllIIlIlIIIIIlIlIIl, new ModelAdapterSign());
        return lllllllllllllIllIIlIlIIIIIlIlIIl;
    }
    
    public static String[] getModelNames() {
        final Set<String> lllllllllllllIllIIlIlIIIIIIlllII = CustomModelRegistry.mapModelAdapters.keySet();
        final String[] lllllllllllllIllIIlIlIIIIIIllIll = lllllllllllllIllIIlIlIIIIIIlllII.toArray(new String[lllllllllllllIllIIlIlIIIIIIlllII.size()]);
        return lllllllllllllIllIIlIlIIIIIIllIll;
    }
    
    private static void addModelAdapter(final Map<String, ModelAdapter> lllllllllllllIllIIlIlIIIIIlIIIll, final ModelAdapter lllllllllllllIllIIlIlIIIIIlIIIlI) {
        if (lllllllllllllIllIIlIlIIIIIlIIIll.containsKey(lllllllllllllIllIIlIlIIIIIlIIIlI.getName())) {
            Config.warn(String.valueOf(new StringBuilder("Model adapter already registered for id: ").append(lllllllllllllIllIIlIlIIIIIlIIIlI.getName()).append(", class: ").append(lllllllllllllIllIIlIlIIIIIlIIIlI.getEntityClass().getName())));
        }
        lllllllllllllIllIIlIlIIIIIlIIIll.put(lllllllllllllIllIIlIlIIIIIlIIIlI.getName(), lllllllllllllIllIIlIlIIIIIlIIIlI);
    }
    
    public static ModelAdapter getModelAdapter(final String lllllllllllllIllIIlIlIIIIIlIIIII) {
        return CustomModelRegistry.mapModelAdapters.get(lllllllllllllIllIIlIlIIIIIlIIIII);
    }
}
