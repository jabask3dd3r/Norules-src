package net.minecraft.world.gen.structure;

import java.util.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import javax.annotation.*;

public class MapGenStructureIO
{
    private static final /* synthetic */ Map<Class<? extends StructureComponent>, String> componentClassToNameMap;
    private static final /* synthetic */ Map<String, Class<? extends StructureStart>> startNameToClassMap;
    private static final /* synthetic */ Logger LOGGER;
    private static final /* synthetic */ Map<String, Class<? extends StructureComponent>> componentNameToClassMap;
    private static final /* synthetic */ Map<Class<? extends StructureStart>, String> startClassToNameMap;
    
    private static void registerStructure(final Class<? extends StructureStart> llllllllllllllIIIllIlIIlIlIlIllI, final String llllllllllllllIIIllIlIIlIlIlIlll) {
        MapGenStructureIO.startNameToClassMap.put(llllllllllllllIIIllIlIIlIlIlIlll, llllllllllllllIIIllIlIIlIlIlIllI);
        MapGenStructureIO.startClassToNameMap.put(llllllllllllllIIIllIlIIlIlIlIllI, llllllllllllllIIIllIlIIlIlIlIlll);
    }
    
    public static String getStructureComponentName(final StructureComponent llllllllllllllIIIllIlIIlIlIIlIlI) {
        return MapGenStructureIO.componentClassToNameMap.get(llllllllllllllIIIllIlIIlIlIIlIlI.getClass());
    }
    
    static {
        LOGGER = LogManager.getLogger();
        startNameToClassMap = Maps.newHashMap();
        startClassToNameMap = Maps.newHashMap();
        componentNameToClassMap = Maps.newHashMap();
        componentClassToNameMap = Maps.newHashMap();
        registerStructure(StructureMineshaftStart.class, "Mineshaft");
        registerStructure(MapGenVillage.Start.class, "Village");
        registerStructure(MapGenNetherBridge.Start.class, "Fortress");
        registerStructure(MapGenStronghold.Start.class, "Stronghold");
        registerStructure(MapGenScatteredFeature.Start.class, "Temple");
        registerStructure(StructureOceanMonument.StartMonument.class, "Monument");
        registerStructure(MapGenEndCity.Start.class, "EndCity");
        registerStructure(WoodlandMansion.Start.class, "Mansion");
        StructureMineshaftPieces.registerStructurePieces();
        StructureVillagePieces.registerVillagePieces();
        StructureNetherBridgePieces.registerNetherFortressPieces();
        StructureStrongholdPieces.registerStrongholdPieces();
        ComponentScatteredFeaturePieces.registerScatteredFeaturePieces();
        StructureOceanMonumentPieces.registerOceanMonumentPieces();
        StructureEndCityPieces.registerPieces();
        WoodlandMansionPieces.func_191153_a();
    }
    
    static void registerStructureComponent(final Class<? extends StructureComponent> llllllllllllllIIIllIlIIlIlIlIIlI, final String llllllllllllllIIIllIlIIlIlIlIIIl) {
        MapGenStructureIO.componentNameToClassMap.put(llllllllllllllIIIllIlIIlIlIlIIIl, llllllllllllllIIIllIlIIlIlIlIIlI);
        MapGenStructureIO.componentClassToNameMap.put(llllllllllllllIIIllIlIIlIlIlIIlI, llllllllllllllIIIllIlIIlIlIlIIIl);
    }
    
    public static StructureComponent getStructureComponent(final NBTTagCompound llllllllllllllIIIllIlIIlIIllIlll, final World llllllllllllllIIIllIlIIlIIllIllI) {
        StructureComponent llllllllllllllIIIllIlIIlIIllIlIl = null;
        try {
            final Class<? extends StructureComponent> llllllllllllllIIIllIlIIlIIllIlII = MapGenStructureIO.componentNameToClassMap.get(llllllllllllllIIIllIlIIlIIllIlll.getString("id"));
            if (llllllllllllllIIIllIlIIlIIllIlII != null) {
                llllllllllllllIIIllIlIIlIIllIlIl = (StructureComponent)llllllllllllllIIIllIlIIlIIllIlII.newInstance();
            }
        }
        catch (Exception llllllllllllllIIIllIlIIlIIllIIll) {
            MapGenStructureIO.LOGGER.warn("Failed Piece with id {}", (Object)llllllllllllllIIIllIlIIlIIllIlll.getString("id"));
            llllllllllllllIIIllIlIIlIIllIIll.printStackTrace();
        }
        if (llllllllllllllIIIllIlIIlIIllIlIl != null) {
            llllllllllllllIIIllIlIIlIIllIlIl.readStructureBaseNBT(llllllllllllllIIIllIlIIlIIllIllI, llllllllllllllIIIllIlIIlIIllIlll);
        }
        else {
            MapGenStructureIO.LOGGER.warn("Skipping Piece with id {}", (Object)llllllllllllllIIIllIlIIlIIllIlll.getString("id"));
        }
        return llllllllllllllIIIllIlIIlIIllIlIl;
    }
    
    public static String getStructureStartName(final StructureStart llllllllllllllIIIllIlIIlIlIIllIl) {
        return MapGenStructureIO.startClassToNameMap.get(llllllllllllllIIIllIlIIlIlIIllIl.getClass());
    }
    
    @Nullable
    public static StructureStart getStructureStart(final NBTTagCompound llllllllllllllIIIllIlIIlIlIIIlII, final World llllllllllllllIIIllIlIIlIlIIIIll) {
        StructureStart llllllllllllllIIIllIlIIlIlIIIIlI = null;
        try {
            final Class<? extends StructureStart> llllllllllllllIIIllIlIIlIlIIIIIl = MapGenStructureIO.startNameToClassMap.get(llllllllllllllIIIllIlIIlIlIIIlII.getString("id"));
            if (llllllllllllllIIIllIlIIlIlIIIIIl != null) {
                llllllllllllllIIIllIlIIlIlIIIIlI = (StructureStart)llllllllllllllIIIllIlIIlIlIIIIIl.newInstance();
            }
        }
        catch (Exception llllllllllllllIIIllIlIIlIlIIIIII) {
            MapGenStructureIO.LOGGER.warn("Failed Start with id {}", (Object)llllllllllllllIIIllIlIIlIlIIIlII.getString("id"));
            llllllllllllllIIIllIlIIlIlIIIIII.printStackTrace();
        }
        if (llllllllllllllIIIllIlIIlIlIIIIlI != null) {
            llllllllllllllIIIllIlIIlIlIIIIlI.readStructureComponentsFromNBT(llllllllllllllIIIllIlIIlIlIIIIll, llllllllllllllIIIllIlIIlIlIIIlII);
        }
        else {
            MapGenStructureIO.LOGGER.warn("Skipping Structure with id {}", (Object)llllllllllllllIIIllIlIIlIlIIIlII.getString("id"));
        }
        return llllllllllllllIIIllIlIIlIlIIIIlI;
    }
}
