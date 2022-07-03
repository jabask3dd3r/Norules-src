package net.minecraft.client.audio;

import java.util.*;
import javax.annotation.*;
import org.apache.logging.log4j.*;
import com.google.gson.*;
import java.lang.reflect.*;
import net.minecraft.util.text.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.*;
import net.minecraft.client.settings.*;
import org.apache.commons.io.*;
import java.io.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.registry.*;

public class SoundHandler implements ITickable, IResourceManagerReloadListener
{
    public static final /* synthetic */ Sound MISSING_SOUND;
    private final /* synthetic */ IResourceManager mcResourceManager;
    private final /* synthetic */ SoundManager sndManager;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ SoundRegistry soundRegistry;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$audio$Sound$Type;
    
    @Nullable
    protected Map<String, SoundList> getSoundMap(final InputStream lllllllllllllIlIllllIlIIIIIIIIlI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: new             Ljava/io/InputStreamReader;
        //     6: dup            
        //     7: aload_1         /* lllllllllllllIlIllllIlIIIIIIIlIl */
        //     8: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
        //    11: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
        //    14: getstatic       net/minecraft/client/audio/SoundHandler.TYPE:Ljava/lang/reflect/ParameterizedType;
        //    17: invokestatic    net/minecraft/util/JsonUtils.func_193841_a:(Lcom/google/gson/Gson;Ljava/io/Reader;Ljava/lang/reflect/Type;)Ljava/lang/Object;
        //    20: checkcast       Ljava/util/Map;
        //    23: astore_2        /* lllllllllllllIlIllllIlIIIIIIIlII */
        //    24: goto            34
        //    27: astore_3        /* lllllllllllllIlIllllIlIIIIIIIIII */
        //    28: aload_1         /* lllllllllllllIlIllllIlIIIIIIIlIl */
        //    29: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    32: aload_3         /* lllllllllllllIlIllllIlIIIIIIIIII */
        //    33: athrow         
        //    34: aload_1         /* lllllllllllllIlIllllIlIIIIIIIlIl */
        //    35: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
        //    38: aload_2         /* lllllllllllllIlIllllIlIIIIIIIIll */
        //    39: areturn        
        //    Signature:
        //  (Ljava/io/InputStream;)Ljava/util/Map<Ljava/lang/String;Lnet/minecraft/client/audio/SoundList;>;
        //    RuntimeVisibleTypeAnnotations: 00 01 14 00 00 2F 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  0      27     27     34     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void playDelayedSound(final ISound lllllllllllllIlIllllIIlllIllIlll, final int lllllllllllllIlIllllIIlllIllIIll) {
        this.sndManager.playDelayedSound(lllllllllllllIlIllllIIlllIllIlll, lllllllllllllIlIllllIIlllIllIIll);
    }
    
    static {
        MISSING_SOUND = new Sound("meta:missing_sound", 1.0f, 1.0f, 1, Sound.Type.FILE, false);
        LOGGER = LogManager.getLogger();
        GSON = new GsonBuilder().registerTypeHierarchyAdapter((Class)ITextComponent.class, (Object)new ITextComponent.Serializer()).registerTypeAdapter((Type)SoundList.class, (Object)new SoundListSerializer()).create();
        TYPE = new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[] { String.class, SoundList.class };
            }
            
            @Override
            public Type getRawType() {
                return Map.class;
            }
            
            @Override
            public Type getOwnerType() {
                return null;
            }
        };
    }
    
    public void setSoundLevel(final SoundCategory lllllllllllllIlIllllIIlllIIlIIll, final float lllllllllllllIlIllllIIlllIIlIIlI) {
        if (lllllllllllllIlIllllIIlllIIlIIll == SoundCategory.MASTER && lllllllllllllIlIllllIIlllIIlIIlI <= 0.0f) {
            this.stopSounds();
        }
        this.sndManager.setVolume(lllllllllllllIlIllllIIlllIIlIIll, lllllllllllllIlIllllIIlllIIlIIlI);
    }
    
    public boolean isSoundPlaying(final ISound lllllllllllllIlIllllIIlllIIIIllI) {
        return this.sndManager.isSoundPlaying(lllllllllllllIlIllllIIlllIIIIllI);
    }
    
    public void stopSound(final ISound lllllllllllllIlIllllIIlllIIIlllI) {
        this.sndManager.stopSound(lllllllllllllIlIllllIIlllIIIlllI);
    }
    
    public void unloadSounds() {
        this.sndManager.unloadSoundSystem();
    }
    
    @Override
    public void update() {
        this.sndManager.updateAllSounds();
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager lllllllllllllIlIllllIlIIIIIlllII) {
        this.soundRegistry.clearMap();
        for (final String lllllllllllllIlIllllIlIIIIIllIll : lllllllllllllIlIllllIlIIIIIlllII.getResourceDomains()) {
            try {
                for (final IResource lllllllllllllIlIllllIlIIIIIllIlI : lllllllllllllIlIllllIlIIIIIlllII.getAllResources(new ResourceLocation(lllllllllllllIlIllllIlIIIIIllIll, "sounds.json"))) {
                    try {
                        final Map<String, SoundList> lllllllllllllIlIllllIlIIIIIllIIl = this.getSoundMap(lllllllllllllIlIllllIlIIIIIllIlI.getInputStream());
                        for (final Map.Entry<String, SoundList> lllllllllllllIlIllllIlIIIIIllIII : lllllllllllllIlIllllIlIIIIIllIIl.entrySet()) {
                            this.loadSoundResource(new ResourceLocation(lllllllllllllIlIllllIlIIIIIllIll, lllllllllllllIlIllllIlIIIIIllIII.getKey()), lllllllllllllIlIllllIlIIIIIllIII.getValue());
                        }
                    }
                    catch (RuntimeException lllllllllllllIlIllllIlIIIIIlIlll) {
                        SoundHandler.LOGGER.warn("Invalid sounds.json", (Throwable)lllllllllllllIlIllllIlIIIIIlIlll);
                    }
                }
            }
            catch (IOException ex) {}
        }
        for (final ResourceLocation lllllllllllllIlIllllIlIIIIIlIllI : ((RegistrySimple<ResourceLocation, V>)this.soundRegistry).getKeys()) {
            final SoundEventAccessor lllllllllllllIlIllllIlIIIIIlIlIl = this.soundRegistry.getObject(lllllllllllllIlIllllIlIIIIIlIllI);
            if (lllllllllllllIlIllllIlIIIIIlIlIl.getSubtitle() instanceof TextComponentTranslation) {
                final String lllllllllllllIlIllllIlIIIIIlIlII = ((TextComponentTranslation)lllllllllllllIlIllllIlIIIIIlIlIl.getSubtitle()).getKey();
                if (I18n.hasKey(lllllllllllllIlIllllIlIIIIIlIlII)) {
                    continue;
                }
                SoundHandler.LOGGER.debug("Missing subtitle {} for event: {}", (Object)lllllllllllllIlIllllIlIIIIIlIlII, (Object)lllllllllllllIlIllllIlIIIIIlIllI);
            }
        }
        for (final ResourceLocation lllllllllllllIlIllllIlIIIIIlIIll : ((RegistrySimple<ResourceLocation, V>)this.soundRegistry).getKeys()) {
            if (SoundEvent.REGISTRY.getObject(lllllllllllllIlIllllIlIIIIIlIIll) == null) {
                SoundHandler.LOGGER.debug("Not having sound event for: {}", (Object)lllllllllllllIlIllllIlIIIIIlIIll);
            }
        }
        this.sndManager.reloadSoundSystem();
    }
    
    private void loadSoundResource(final ResourceLocation lllllllllllllIlIllllIIlllllIlIll, final SoundList lllllllllllllIlIllllIIllllllIlII) {
        SoundEventAccessor lllllllllllllIlIllllIIllllllIIll = this.soundRegistry.getObject(lllllllllllllIlIllllIIlllllIlIll);
        final boolean lllllllllllllIlIllllIIllllllIIlI = lllllllllllllIlIllllIIllllllIIll == null;
        if (lllllllllllllIlIllllIIllllllIIlI || lllllllllllllIlIllllIIllllllIlII.canReplaceExisting()) {
            if (!lllllllllllllIlIllllIIllllllIIlI) {
                SoundHandler.LOGGER.debug("Replaced sound event location {}", (Object)lllllllllllllIlIllllIIlllllIlIll);
            }
            lllllllllllllIlIllllIIllllllIIll = new SoundEventAccessor(lllllllllllllIlIllllIIlllllIlIll, lllllllllllllIlIllllIIllllllIlII.getSubtitle());
            this.soundRegistry.add(lllllllllllllIlIllllIIllllllIIll);
        }
        for (final Sound lllllllllllllIlIllllIIllllllIIIl : lllllllllllllIlIllllIIllllllIlII.getSounds()) {
            final ResourceLocation lllllllllllllIlIllllIIllllllIIII = lllllllllllllIlIllllIIllllllIIIl.getSoundLocation();
            switch ($SWITCH_TABLE$net$minecraft$client$audio$Sound$Type()[lllllllllllllIlIllllIIllllllIIIl.getType().ordinal()]) {
                case 1: {
                    if (!this.validateSoundResource(lllllllllllllIlIllllIIllllllIIIl, lllllllllllllIlIllllIIlllllIlIll)) {
                        continue;
                    }
                    final ISoundEventAccessor<Sound> lllllllllllllIlIllllIIlllllIllll = lllllllllllllIlIllllIIllllllIIIl;
                    break;
                }
                case 2: {
                    final ISoundEventAccessor<Sound> lllllllllllllIlIllllIIlllllIlllI = new ISoundEventAccessor<Sound>() {
                        @Override
                        public Sound cloneEntry() {
                            final SoundEventAccessor lllllllllllllIIIIllIlllllllllIll = SoundHandler.this.soundRegistry.getObject(lllllllllllllIlIllllIIllllllIIII);
                            if (lllllllllllllIIIIllIlllllllllIll == null) {
                                return SoundHandler.MISSING_SOUND;
                            }
                            final Sound lllllllllllllIIIIllIlllllllllIlI = lllllllllllllIIIIllIlllllllllIll.cloneEntry();
                            return new Sound(lllllllllllllIIIIllIlllllllllIlI.getSoundLocation().toString(), lllllllllllllIIIIllIlllllllllIlI.getVolume() * lllllllllllllIlIllllIIllllllIIIl.getVolume(), lllllllllllllIIIIllIlllllllllIlI.getPitch() * lllllllllllllIlIllllIIllllllIIIl.getPitch(), lllllllllllllIlIllllIIllllllIIIl.getWeight(), Sound.Type.FILE, lllllllllllllIIIIllIlllllllllIlI.isStreaming() || lllllllllllllIlIllllIIllllllIIIl.isStreaming());
                        }
                        
                        @Override
                        public int getWeight() {
                            final SoundEventAccessor lllllllllllllIIIIlllIIIIIIIIIIlI = SoundHandler.this.soundRegistry.getObject(lllllllllllllIlIllllIIllllllIIII);
                            return (lllllllllllllIIIIlllIIIIIIIIIIlI == null) ? 0 : lllllllllllllIIIIlllIIIIIIIIIIlI.getWeight();
                        }
                    };
                    break;
                }
                default: {
                    throw new IllegalStateException(String.valueOf(new StringBuilder("Unknown SoundEventRegistration type: ").append(lllllllllllllIlIllllIIllllllIIIl.getType())));
                }
            }
            final ISoundEventAccessor<Sound> lllllllllllllIlIllllIIlllllIllIl;
            lllllllllllllIlIllllIIllllllIIll.addSound(lllllllllllllIlIllllIIlllllIllIl);
        }
    }
    
    public void resumeSounds() {
        this.sndManager.resumeAllSounds();
    }
    
    public SoundHandler(final IResourceManager lllllllllllllIlIllllIlIIIIlIlIII, final GameSettings lllllllllllllIlIllllIlIIIIlIlIlI) {
        this.soundRegistry = new SoundRegistry();
        this.mcResourceManager = lllllllllllllIlIllllIlIIIIlIlIII;
        this.sndManager = new SoundManager(this, lllllllllllllIlIllllIlIIIIlIlIlI);
    }
    
    public void stopSounds() {
        this.sndManager.stopAllSounds();
    }
    
    private boolean validateSoundResource(final Sound lllllllllllllIlIllllIIllllIllIIl, final ResourceLocation lllllllllllllIlIllllIIllllIllIII) {
        final ResourceLocation lllllllllllllIlIllllIIllllIlIlll = lllllllllllllIlIllllIIllllIllIIl.getSoundAsOggLocation();
        IResource lllllllllllllIlIllllIIllllIlIllI = null;
        try {
            lllllllllllllIlIllllIIllllIlIllI = this.mcResourceManager.getResource(lllllllllllllIlIllllIIllllIlIlll);
            lllllllllllllIlIllllIIllllIlIllI.getInputStream();
            return true;
        }
        catch (FileNotFoundException lllllllllllllIlIllllIIllllIlIIlI) {
            SoundHandler.LOGGER.warn("File {} does not exist, cannot add it to event {}", (Object)lllllllllllllIlIllllIIllllIlIlll, (Object)lllllllllllllIlIllllIIllllIllIII);
            final boolean lllllllllllllIlIllllIIllllIlIlIl = false;
        }
        catch (IOException lllllllllllllIlIllllIIllllIlIIIl) {
            SoundHandler.LOGGER.warn("Could not load sound file {}, cannot add it to event {}", (Object)lllllllllllllIlIllllIIllllIlIlll, (Object)lllllllllllllIlIllllIIllllIllIII, (Object)lllllllllllllIlIllllIIllllIlIIIl);
            final int lllllllllllllIlIllllIIllllIIlIII;
            final boolean lllllllllllllIlIllllIIllllIlIlII = (lllllllllllllIlIllllIIllllIIlIII = 0) != 0;
            return lllllllllllllIlIllllIIllllIIlIII != 0;
        }
        finally {
            IOUtils.closeQuietly((Closeable)lllllllllllllIlIllllIIllllIlIllI);
        }
        final boolean lllllllllllllIlIllllIIllllIlIIll;
        return lllllllllllllIlIllllIIllllIlIIll;
    }
    
    public void stop(final String lllllllllllllIlIllllIIllIlllIIlI, final SoundCategory lllllllllllllIlIllllIIllIlllIlII) {
        this.sndManager.stop(lllllllllllllIlIllllIIllIlllIIlI, lllllllllllllIlIllllIIllIlllIlII);
    }
    
    public void removeListener(final ISoundEventListener lllllllllllllIlIllllIIllIllllIlI) {
        this.sndManager.removeListener(lllllllllllllIlIllllIIllIllllIlI);
    }
    
    public void playSound(final ISound lllllllllllllIlIllllIIlllIllllII) {
        this.sndManager.playSound(lllllllllllllIlIllllIIlllIllllII);
    }
    
    @Nullable
    public SoundEventAccessor getAccessor(final ResourceLocation lllllllllllllIlIllllIIllllIIIlII) {
        return this.soundRegistry.getObject(lllllllllllllIlIllllIIllllIIIlII);
    }
    
    public void setListener(final EntityPlayer lllllllllllllIlIllllIIlllIlIlllI, final float lllllllllllllIlIllllIIlllIlIlIlI) {
        this.sndManager.setListener(lllllllllllllIlIllllIIlllIlIlllI, lllllllllllllIlIllllIIlllIlIlIlI);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$audio$Sound$Type() {
        final int[] $switch_TABLE$net$minecraft$client$audio$Sound$Type = SoundHandler.$SWITCH_TABLE$net$minecraft$client$audio$Sound$Type;
        if ($switch_TABLE$net$minecraft$client$audio$Sound$Type != null) {
            return $switch_TABLE$net$minecraft$client$audio$Sound$Type;
        }
        final Exception lllllllllllllIlIllllIIllIllIllIl = (Object)new int[Sound.Type.values().length];
        try {
            lllllllllllllIlIllllIIllIllIllIl[Sound.Type.FILE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIllllIIllIllIllIl[Sound.Type.SOUND_EVENT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        return SoundHandler.$SWITCH_TABLE$net$minecraft$client$audio$Sound$Type = (int[])(Object)lllllllllllllIlIllllIIllIllIllIl;
    }
    
    public void pauseSounds() {
        this.sndManager.pauseAllSounds();
    }
    
    public void addListener(final ISoundEventListener lllllllllllllIlIllllIIlllIIIIIII) {
        this.sndManager.addListener(lllllllllllllIlIllllIIlllIIIIIII);
    }
}
