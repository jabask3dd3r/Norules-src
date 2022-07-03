package net.minecraft.world;

import net.minecraft.server.*;
import net.minecraft.profiler.*;
import net.minecraft.world.border.*;
import net.minecraft.village.*;
import net.minecraft.world.storage.*;

public class WorldServerMulti extends WorldServer
{
    private final /* synthetic */ WorldServer delegate;
    
    public WorldServerMulti(final MinecraftServer lllllllllllllIIlIlIllllllIIlllII, final ISaveHandler lllllllllllllIIlIlIllllllIIllIll, final int lllllllllllllIIlIlIllllllIIlIlII, final WorldServer lllllllllllllIIlIlIllllllIIllIIl, final Profiler lllllllllllllIIlIlIllllllIIllIII) {
        super(lllllllllllllIIlIlIllllllIIlllII, lllllllllllllIIlIlIllllllIIllIll, new DerivedWorldInfo(lllllllllllllIIlIlIllllllIIllIIl.getWorldInfo()), lllllllllllllIIlIlIllllllIIlIlII, lllllllllllllIIlIlIllllllIIllIII);
        this.delegate = lllllllllllllIIlIlIllllllIIllIIl;
        lllllllllllllIIlIlIllllllIIllIIl.getWorldBorder().addListener(new IBorderListener() {
            @Override
            public void onTransitionStarted(final WorldBorder llllllllllllIllllllIlIIIlIIIllIl, final double llllllllllllIllllllIlIIIlIIIlIII, final double llllllllllllIllllllIlIIIlIIIlIll, final long llllllllllllIllllllIlIIIlIIIlIlI) {
                WorldServerMulti.this.getWorldBorder().setTransition(llllllllllllIllllllIlIIIlIIIlIII, llllllllllllIllllllIlIIIlIIIlIll, llllllllllllIllllllIlIIIlIIIlIlI);
            }
            
            @Override
            public void onWarningDistanceChanged(final WorldBorder llllllllllllIllllllIlIIIIlllIIIl, final int llllllllllllIllllllIlIIIIlllIIII) {
                WorldServerMulti.this.getWorldBorder().setWarningDistance(llllllllllllIllllllIlIIIIlllIIII);
            }
            
            @Override
            public void onDamageAmountChanged(final WorldBorder llllllllllllIllllllIlIIIIllIlIlI, final double llllllllllllIllllllIlIIIIllIlIIl) {
                WorldServerMulti.this.getWorldBorder().setDamageAmount(llllllllllllIllllllIlIIIIllIlIIl);
            }
            
            @Override
            public void onCenterChanged(final WorldBorder llllllllllllIllllllIlIIIlIIIIIIl, final double llllllllllllIllllllIlIIIIlllllIl, final double llllllllllllIllllllIlIIIIlllllll) {
                WorldServerMulti.this.getWorldBorder().setCenter(llllllllllllIllllllIlIIIIlllllIl, llllllllllllIllllllIlIIIIlllllll);
            }
            
            @Override
            public void onWarningTimeChanged(final WorldBorder llllllllllllIllllllIlIIIIllllIII, final int llllllllllllIllllllIlIIIIlllIlll) {
                WorldServerMulti.this.getWorldBorder().setWarningTime(llllllllllllIllllllIlIIIIlllIlll);
            }
            
            @Override
            public void onDamageBufferChanged(final WorldBorder llllllllllllIllllllIlIIIIllIIIll, final double llllllllllllIllllllIlIIIIllIIIlI) {
                WorldServerMulti.this.getWorldBorder().setDamageBuffer(llllllllllllIllllllIlIIIIllIIIlI);
            }
            
            @Override
            public void onSizeChanged(final WorldBorder llllllllllllIllllllIlIIIlIIlIllI, final double llllllllllllIllllllIlIIIlIIlIIll) {
                WorldServerMulti.this.getWorldBorder().setTransition(llllllllllllIllllllIlIIIlIIlIIll);
            }
        });
    }
    
    @Override
    public World init() {
        this.mapStorage = this.delegate.getMapStorage();
        this.worldScoreboard = this.delegate.getScoreboard();
        this.lootTable = this.delegate.getLootTableManager();
        this.field_191951_C = this.delegate.func_191952_z();
        final String lllllllllllllIIlIlIllllllIIIllII = VillageCollection.fileNameForProvider(this.provider);
        final VillageCollection lllllllllllllIIlIlIllllllIIIlIll = (VillageCollection)this.mapStorage.getOrLoadData(VillageCollection.class, lllllllllllllIIlIlIllllllIIIllII);
        if (lllllllllllllIIlIlIllllllIIIlIll == null) {
            this.villageCollectionObj = new VillageCollection(this);
            this.mapStorage.setData(lllllllllllllIIlIlIllllllIIIllII, this.villageCollectionObj);
        }
        else {
            this.villageCollectionObj = lllllllllllllIIlIlIllllllIIIlIll;
            this.villageCollectionObj.setWorldsForAll(this);
        }
        return this;
    }
    
    public void saveAdditionalData() {
        this.provider.onWorldSave();
    }
    
    @Override
    protected void saveLevel() throws MinecraftException {
    }
}
