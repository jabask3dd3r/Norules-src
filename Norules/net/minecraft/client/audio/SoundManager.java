package net.minecraft.client.audio;

import net.minecraft.client.settings.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import org.apache.logging.log4j.*;
import com.google.common.collect.*;
import paulscode.sound.libraries.*;
import paulscode.sound.codecs.*;
import net.minecraft.client.*;
import java.io.*;
import java.net.*;
import io.netty.util.internal.*;
import java.util.*;
import paulscode.sound.*;

public class SoundManager
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ List<ISoundEventListener> listeners;
    private final /* synthetic */ Map<ISound, String> invPlayingSounds;
    private final /* synthetic */ Map<ISound, Integer> delayedSounds;
    private /* synthetic */ int playTime;
    private /* synthetic */ boolean loaded;
    private final /* synthetic */ List<ITickableSound> tickableSounds;
    private /* synthetic */ SoundSystemStarterThread sndSystem;
    private final /* synthetic */ Map<String, ISound> playingSounds;
    private final /* synthetic */ Map<String, Integer> playingSoundsStopTime;
    private static final /* synthetic */ Set<ResourceLocation> UNABLE_TO_PLAY;
    private final /* synthetic */ Multimap<SoundCategory, String> categorySounds;
    private final /* synthetic */ SoundHandler sndHandler;
    private static final /* synthetic */ Marker LOG_MARKER;
    private final /* synthetic */ GameSettings options;
    private final /* synthetic */ List<String> pausedChannels;
    
    public void resumeAllSounds() {
        for (final String llllllllllllllIIllIlllllIlllIIIl : this.pausedChannels) {
            SoundManager.LOGGER.debug(SoundManager.LOG_MARKER, "Resuming channel {}", (Object)llllllllllllllIIllIlllllIlllIIIl);
            this.sndSystem.play(llllllllllllllIIllIlllllIlllIIIl);
        }
        this.pausedChannels.clear();
    }
    
    private float getClampedPitch(final ISound llllllllllllllIIllIllllllIIIlIll) {
        return MathHelper.clamp(llllllllllllllIIllIllllllIIIlIll.getPitch(), 0.5f, 2.0f);
    }
    
    public void stopSound(final ISound llllllllllllllIIllIllllllIlllIlI) {
        if (this.loaded) {
            final String llllllllllllllIIllIllllllIlllIIl = this.invPlayingSounds.get(llllllllllllllIIllIllllllIlllIlI);
            if (llllllllllllllIIllIllllllIlllIIl != null) {
                this.sndSystem.stop(llllllllllllllIIllIllllllIlllIIl);
            }
        }
    }
    
    public void playDelayedSound(final ISound llllllllllllllIIllIlllllIllIlIIl, final int llllllllllllllIIllIlllllIllIlIII) {
        this.delayedSounds.put(llllllllllllllIIllIlllllIllIlIIl, this.playTime + llllllllllllllIIllIlllllIllIlIII);
    }
    
    public void setVolume(final SoundCategory llllllllllllllIIlllIIIIIIIIIIllI, final float llllllllllllllIIllIlllllllllllll) {
        if (this.loaded) {
            if (llllllllllllllIIlllIIIIIIIIIIllI == SoundCategory.MASTER) {
                this.sndSystem.setMasterVolume(llllllllllllllIIllIlllllllllllll);
            }
            else {
                for (final String llllllllllllllIIlllIIIIIIIIIIlII : this.categorySounds.get((Object)llllllllllllllIIlllIIIIIIIIIIllI)) {
                    final ISound llllllllllllllIIlllIIIIIIIIIIIll = this.playingSounds.get(llllllllllllllIIlllIIIIIIIIIIlII);
                    final float llllllllllllllIIlllIIIIIIIIIIIlI = this.getClampedVolume(llllllllllllllIIlllIIIIIIIIIIIll);
                    if (llllllllllllllIIlllIIIIIIIIIIIlI <= 0.0f) {
                        this.stopSound(llllllllllllllIIlllIIIIIIIIIIIll);
                    }
                    else {
                        this.sndSystem.setVolume(llllllllllllllIIlllIIIIIIIIIIlII, llllllllllllllIIlllIIIIIIIIIIIlI);
                    }
                }
            }
        }
    }
    
    public void reloadSoundSystem() {
        SoundManager.UNABLE_TO_PLAY.clear();
        for (final SoundEvent llllllllllllllIIlllIIIIIIIlIIIII : SoundEvent.REGISTRY) {
            final ResourceLocation llllllllllllllIIlllIIIIIIIIlllll = llllllllllllllIIlllIIIIIIIlIIIII.getSoundName();
            if (this.sndHandler.getAccessor(llllllllllllllIIlllIIIIIIIIlllll) == null) {
                SoundManager.LOGGER.warn("Missing sound for event: {}", (Object)SoundEvent.REGISTRY.getNameForObject(llllllllllllllIIlllIIIIIIIlIIIII));
                SoundManager.UNABLE_TO_PLAY.add(llllllllllllllIIlllIIIIIIIIlllll);
            }
        }
        this.unloadSoundSystem();
        this.loadSoundSystem();
    }
    
    public void unloadSoundSystem() {
        if (this.loaded) {
            this.stopAllSounds();
            this.sndSystem.cleanup();
            this.loaded = false;
        }
    }
    
    public void stop(final String llllllllllllllIIllIllllIlllIIIlI, final SoundCategory llllllllllllllIIllIllllIlllIIIII) {
        if (llllllllllllllIIllIllllIlllIIIII != null) {
            for (final String llllllllllllllIIllIllllIlllIlIII : this.categorySounds.get((Object)llllllllllllllIIllIllllIlllIIIII)) {
                final ISound llllllllllllllIIllIllllIlllIIllI = this.playingSounds.get(llllllllllllllIIllIllllIlllIlIII);
                if (llllllllllllllIIllIllllIlllIIIlI.isEmpty()) {
                    this.stopSound(llllllllllllllIIllIllllIlllIIllI);
                }
                else {
                    if (!llllllllllllllIIllIllllIlllIIllI.getSoundLocation().equals(new ResourceLocation(llllllllllllllIIllIllllIlllIIIlI))) {
                        continue;
                    }
                    this.stopSound(llllllllllllllIIllIllllIlllIIllI);
                }
            }
        }
        else if (llllllllllllllIIllIllllIlllIIIlI.isEmpty()) {
            this.stopAllSounds();
        }
        else {
            for (final ISound llllllllllllllIIllIllllIlllIIlIl : this.playingSounds.values()) {
                if (llllllllllllllIIllIllllIlllIIlIl.getSoundLocation().equals(new ResourceLocation(llllllllllllllIIllIllllIlllIIIlI))) {
                    this.stopSound(llllllllllllllIIllIllllIlllIIlIl);
                }
            }
        }
    }
    
    private float getVolume(final SoundCategory llllllllllllllIIlllIIIIIIIIIllll) {
        return (llllllllllllllIIlllIIIIIIIIIllll != null && llllllllllllllIIlllIIIIIIIIIllll != SoundCategory.MASTER) ? this.options.getSoundLevel(llllllllllllllIIlllIIIIIIIIIllll) : 1.0f;
    }
    
    static /* synthetic */ void access$2(final SoundManager llllllllllllllIIllIllllIllIIllII, final boolean llllllllllllllIIllIllllIllIIlIlI) {
        llllllllllllllIIllIllllIllIIllII.loaded = llllllllllllllIIllIllllIllIIlIlI;
    }
    
    public void pauseAllSounds() {
        for (final Map.Entry<String, ISound> llllllllllllllIIllIlllllIlllllIl : this.playingSounds.entrySet()) {
            final String llllllllllllllIIllIlllllIlllllII = llllllllllllllIIllIlllllIlllllIl.getKey();
            final boolean llllllllllllllIIllIlllllIllllIll = this.isSoundPlaying(llllllllllllllIIllIlllllIlllllIl.getValue());
            if (llllllllllllllIIllIlllllIllllIll) {
                SoundManager.LOGGER.debug(SoundManager.LOG_MARKER, "Pausing channel {}", (Object)llllllllllllllIIllIlllllIlllllII);
                this.sndSystem.pause(llllllllllllllIIllIlllllIlllllII);
                this.pausedChannels.add(llllllllllllllIIllIlllllIlllllII);
            }
        }
    }
    
    public void updateAllSounds() {
        ++this.playTime;
        for (final ITickableSound llllllllllllllIIllIlllllllIllIlI : this.tickableSounds) {
            llllllllllllllIIllIlllllllIllIlI.update();
            if (llllllllllllllIIllIlllllllIllIlI.isDonePlaying()) {
                this.stopSound(llllllllllllllIIllIlllllllIllIlI);
            }
            else {
                final String llllllllllllllIIllIlllllllIllIIl = this.invPlayingSounds.get(llllllllllllllIIllIlllllllIllIlI);
                this.sndSystem.setVolume(llllllllllllllIIllIlllllllIllIIl, this.getClampedVolume(llllllllllllllIIllIlllllllIllIlI));
                this.sndSystem.setPitch(llllllllllllllIIllIlllllllIllIIl, this.getClampedPitch(llllllllllllllIIllIlllllllIllIlI));
                this.sndSystem.setPosition(llllllllllllllIIllIlllllllIllIIl, llllllllllllllIIllIlllllllIllIlI.getXPosF(), llllllllllllllIIllIlllllllIllIlI.getYPosF(), llllllllllllllIIllIlllllllIllIlI.getZPosF());
            }
        }
        final Iterator<Map.Entry<String, ISound>> llllllllllllllIIllIlllllllIllIII = this.playingSounds.entrySet().iterator();
        while (llllllllllllllIIllIlllllllIllIII.hasNext()) {
            final Map.Entry<String, ISound> llllllllllllllIIllIlllllllIlIlll = llllllllllllllIIllIlllllllIllIII.next();
            final String llllllllllllllIIllIlllllllIlIllI = llllllllllllllIIllIlllllllIlIlll.getKey();
            final ISound llllllllllllllIIllIlllllllIlIlIl = llllllllllllllIIllIlllllllIlIlll.getValue();
            if (!this.sndSystem.playing(llllllllllllllIIllIlllllllIlIllI)) {
                final int llllllllllllllIIllIlllllllIlIlII = this.playingSoundsStopTime.get(llllllllllllllIIllIlllllllIlIllI);
                if (llllllllllllllIIllIlllllllIlIlII > this.playTime) {
                    continue;
                }
                final int llllllllllllllIIllIlllllllIlIIll = llllllllllllllIIllIlllllllIlIlIl.getRepeatDelay();
                if (llllllllllllllIIllIlllllllIlIlIl.canRepeat() && llllllllllllllIIllIlllllllIlIIll > 0) {
                    this.delayedSounds.put(llllllllllllllIIllIlllllllIlIlIl, this.playTime + llllllllllllllIIllIlllllllIlIIll);
                }
                llllllllllllllIIllIlllllllIllIII.remove();
                SoundManager.LOGGER.debug(SoundManager.LOG_MARKER, "Removed channel {} because it's not playing anymore", (Object)llllllllllllllIIllIlllllllIlIllI);
                this.sndSystem.removeSource(llllllllllllllIIllIlllllllIlIllI);
                this.playingSoundsStopTime.remove(llllllllllllllIIllIlllllllIlIllI);
                try {
                    this.categorySounds.remove((Object)llllllllllllllIIllIlllllllIlIlIl.getCategory(), (Object)llllllllllllllIIllIlllllllIlIllI);
                }
                catch (RuntimeException ex) {}
                if (!(llllllllllllllIIllIlllllllIlIlIl instanceof ITickableSound)) {
                    continue;
                }
                this.tickableSounds.remove(llllllllllllllIIllIlllllllIlIlIl);
            }
        }
        final Iterator<Map.Entry<ISound, Integer>> llllllllllllllIIllIlllllllIlIIlI = this.delayedSounds.entrySet().iterator();
        while (llllllllllllllIIllIlllllllIlIIlI.hasNext()) {
            final Map.Entry<ISound, Integer> llllllllllllllIIllIlllllllIlIIIl = llllllllllllllIIllIlllllllIlIIlI.next();
            if (this.playTime >= llllllllllllllIIllIlllllllIlIIIl.getValue()) {
                final ISound llllllllllllllIIllIlllllllIlIIII = llllllllllllllIIllIlllllllIlIIIl.getKey();
                if (llllllllllllllIIllIlllllllIlIIII instanceof ITickableSound) {
                    ((ITickableSound)llllllllllllllIIllIlllllllIlIIII).update();
                }
                this.playSound(llllllllllllllIIllIlllllllIlIIII);
                llllllllllllllIIllIlllllllIlIIlI.remove();
            }
        }
    }
    
    public void setListener(final EntityPlayer llllllllllllllIIllIlllllIIlIIIII, final float llllllllllllllIIllIlllllIIlllllI) {
        if (this.loaded && llllllllllllllIIllIlllllIIlIIIII != null) {
            final float llllllllllllllIIllIlllllIIllllII = llllllllllllllIIllIlllllIIlIIIII.prevRotationPitch + (llllllllllllllIIllIlllllIIlIIIII.rotationPitch - llllllllllllllIIllIlllllIIlIIIII.prevRotationPitch) * llllllllllllllIIllIlllllIIlllllI;
            final float llllllllllllllIIllIlllllIIlllIlI = llllllllllllllIIllIlllllIIlIIIII.prevRotationYaw + (llllllllllllllIIllIlllllIIlIIIII.rotationYaw - llllllllllllllIIllIlllllIIlIIIII.prevRotationYaw) * llllllllllllllIIllIlllllIIlllllI;
            final double llllllllllllllIIllIlllllIIlllIII = llllllllllllllIIllIlllllIIlIIIII.prevPosX + (llllllllllllllIIllIlllllIIlIIIII.posX - llllllllllllllIIllIlllllIIlIIIII.prevPosX) * llllllllllllllIIllIlllllIIlllllI;
            final double llllllllllllllIIllIlllllIIllIllI = llllllllllllllIIllIlllllIIlIIIII.prevPosY + (llllllllllllllIIllIlllllIIlIIIII.posY - llllllllllllllIIllIlllllIIlIIIII.prevPosY) * llllllllllllllIIllIlllllIIlllllI + llllllllllllllIIllIlllllIIlIIIII.getEyeHeight();
            final double llllllllllllllIIllIlllllIIllIlIl = llllllllllllllIIllIlllllIIlIIIII.prevPosZ + (llllllllllllllIIllIlllllIIlIIIII.posZ - llllllllllllllIIllIlllllIIlIIIII.prevPosZ) * llllllllllllllIIllIlllllIIlllllI;
            final float llllllllllllllIIllIlllllIIllIIll = MathHelper.cos((llllllllllllllIIllIlllllIIlllIlI + 90.0f) * 0.017453292f);
            final float llllllllllllllIIllIlllllIIllIIIl = MathHelper.sin((llllllllllllllIIllIlllllIIlllIlI + 90.0f) * 0.017453292f);
            final float llllllllllllllIIllIlllllIIlIllll = MathHelper.cos(-llllllllllllllIIllIlllllIIllllII * 0.017453292f);
            final float llllllllllllllIIllIlllllIIlIllIl = MathHelper.sin(-llllllllllllllIIllIlllllIIllllII * 0.017453292f);
            final float llllllllllllllIIllIlllllIIlIlIll = MathHelper.cos((-llllllllllllllIIllIlllllIIllllII + 90.0f) * 0.017453292f);
            final float llllllllllllllIIllIlllllIIlIlIlI = MathHelper.sin((-llllllllllllllIIllIlllllIIllllII + 90.0f) * 0.017453292f);
            final float llllllllllllllIIllIlllllIIlIlIII = llllllllllllllIIllIlllllIIllIIll * llllllllllllllIIllIlllllIIlIllll;
            final float llllllllllllllIIllIlllllIIlIIllI = llllllllllllllIIllIlllllIIllIIIl * llllllllllllllIIllIlllllIIlIllll;
            final float llllllllllllllIIllIlllllIIlIIlII = llllllllllllllIIllIlllllIIllIIll * llllllllllllllIIllIlllllIIlIlIll;
            final float llllllllllllllIIllIlllllIIlIIIll = llllllllllllllIIllIlllllIIllIIIl * llllllllllllllIIllIlllllIIlIlIll;
            this.sndSystem.setListenerPosition((float)llllllllllllllIIllIlllllIIlllIII, (float)llllllllllllllIIllIlllllIIllIllI, (float)llllllllllllllIIllIlllllIIllIlIl);
            this.sndSystem.setListenerOrientation(llllllllllllllIIllIlllllIIlIlIII, llllllllllllllIIllIlllllIIlIllIl, llllllllllllllIIllIlllllIIlIIllI, llllllllllllllIIllIlllllIIlIIlII, llllllllllllllIIllIlllllIIlIlIlI, llllllllllllllIIllIlllllIIlIIIll);
        }
    }
    
    static {
        LOG_MARKER = MarkerManager.getMarker("SOUNDS");
        LOGGER = LogManager.getLogger();
        UNABLE_TO_PLAY = Sets.newHashSet();
    }
    
    public SoundManager(final SoundHandler llllllllllllllIIlllIIIIIIIlIlIII, final GameSettings llllllllllllllIIlllIIIIIIIlIlIll) {
        this.playingSounds = (Map<String, ISound>)HashBiMap.create();
        this.invPlayingSounds = (Map<ISound, String>)((BiMap)this.playingSounds).inverse();
        this.categorySounds = (Multimap<SoundCategory, String>)HashMultimap.create();
        this.tickableSounds = (List<ITickableSound>)Lists.newArrayList();
        this.delayedSounds = (Map<ISound, Integer>)Maps.newHashMap();
        this.playingSoundsStopTime = (Map<String, Integer>)Maps.newHashMap();
        this.listeners = (List<ISoundEventListener>)Lists.newArrayList();
        this.pausedChannels = (List<String>)Lists.newArrayList();
        this.sndHandler = llllllllllllllIIlllIIIIIIIlIlIII;
        this.options = llllllllllllllIIlllIIIIIIIlIlIll;
        try {
            SoundSystemConfig.addLibrary((Class)LibraryLWJGLOpenAL.class);
            SoundSystemConfig.setCodec("ogg", (Class)CodecJOrbis.class);
        }
        catch (SoundSystemException llllllllllllllIIlllIIIIIIIlIlIlI) {
            SoundManager.LOGGER.error(SoundManager.LOG_MARKER, "Error linking with the LibraryJavaSound plug-in", (Throwable)llllllllllllllIIlllIIIIIIIlIlIlI);
        }
    }
    
    private synchronized void loadSoundSystem() {
        if (!this.loaded) {
            try {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SoundSystemConfig.setLogger((SoundSystemLogger)new SoundSystemLogger() {
                            public void errorMessage(final String llllllllllllllIllllIllIIlllllIII, final String llllllllllllllIllllIllIIlllllIlI, final int llllllllllllllIllllIllIIlllllIIl) {
                                if (!llllllllllllllIllllIllIIlllllIlI.isEmpty()) {
                                    SoundManager.LOGGER.error("Error in class '{}'", (Object)llllllllllllllIllllIllIIlllllIII);
                                    SoundManager.LOGGER.error(llllllllllllllIllllIllIIlllllIlI);
                                }
                            }
                            
                            public void importantMessage(final String llllllllllllllIllllIllIIllllllll, final int llllllllllllllIllllIllIlIIIIIIII) {
                                if (!llllllllllllllIllllIllIIllllllll.isEmpty()) {
                                    SoundManager.LOGGER.warn(llllllllllllllIllllIllIIllllllll);
                                }
                            }
                            
                            public void message(final String llllllllllllllIllllIllIlIIIIIllI, final int llllllllllllllIllllIllIlIIIIIlIl) {
                                if (!llllllllllllllIllllIllIlIIIIIllI.isEmpty()) {
                                    SoundManager.LOGGER.info(llllllllllllllIllllIllIlIIIIIllI);
                                }
                            }
                        });
                        SoundManager.access$1(SoundManager.this, new SoundSystemStarterThread((SoundSystemStarterThread)null));
                        SoundManager.access$2(SoundManager.this, true);
                        SoundManager.this.sndSystem.setMasterVolume(SoundManager.this.options.getSoundLevel(SoundCategory.MASTER));
                        SoundManager.LOGGER.info(SoundManager.LOG_MARKER, "Sound engine started");
                    }
                }, "Sound Library Loader").start();
            }
            catch (RuntimeException llllllllllllllIIlllIIIIIIIIlIlll) {
                SoundManager.LOGGER.error(SoundManager.LOG_MARKER, "Error starting SoundSystem. Turning off sounds & music", (Throwable)llllllllllllllIIlllIIIIIIIIlIlll);
                this.options.setSoundLevel(SoundCategory.MASTER, 0.0f);
                this.options.saveOptions();
            }
        }
    }
    
    static /* synthetic */ void access$1(final SoundManager llllllllllllllIIllIllllIllIlIlII, final SoundSystemStarterThread llllllllllllllIIllIllllIllIlIIll) {
        llllllllllllllIIllIllllIllIlIlII.sndSystem = llllllllllllllIIllIllllIllIlIIll;
    }
    
    public boolean isSoundPlaying(final ISound llllllllllllllIIllIlllllllIIIIII) {
        if (!this.loaded) {
            return false;
        }
        final String llllllllllllllIIllIlllllllIIIIlI = this.invPlayingSounds.get(llllllllllllllIIllIlllllllIIIIII);
        return llllllllllllllIIllIlllllllIIIIlI != null && (this.sndSystem.playing(llllllllllllllIIllIlllllllIIIIlI) || (this.playingSoundsStopTime.containsKey(llllllllllllllIIllIlllllllIIIIlI) && this.playingSoundsStopTime.get(llllllllllllllIIllIlllllllIIIIlI) <= this.playTime));
    }
    
    private static URL getURLForSoundResource(final ResourceLocation llllllllllllllIIllIlllllIllIIIII) {
        final String llllllllllllllIIllIlllllIlIlllll = String.format("%s:%s:%s", "mcsounddomain", llllllllllllllIIllIlllllIllIIIII.getResourceDomain(), llllllllllllllIIllIlllllIllIIIII.getResourcePath());
        final URLStreamHandler llllllllllllllIIllIlllllIlIllllI = new URLStreamHandler() {
            @Override
            protected URLConnection openConnection(final URL llllllllllllllllIIIlllIllIllllll) {
                return new URLConnection(llllllllllllllllIIIlllIllIllllll) {
                    @Override
                    public InputStream getInputStream() throws IOException {
                        return Minecraft.getMinecraft().getResourceManager().getResource(llllllllllllllIIllIlllllIllIIIII).getInputStream();
                    }
                    
                    @Override
                    public void connect() throws IOException {
                    }
                };
            }
        };
        try {
            return new URL(null, llllllllllllllIIllIlllllIlIlllll, llllllllllllllIIllIlllllIlIllllI);
        }
        catch (MalformedURLException llllllllllllllIIllIlllllIlIlllIl) {
            throw new Error("TODO: Sanely handle url exception! :D");
        }
    }
    
    public void addListener(final ISoundEventListener llllllllllllllIIllIllllllllIlIlI) {
        this.listeners.add(llllllllllllllIIllIllllllllIlIlI);
    }
    
    public void playSound(final ISound llllllllllllllIIllIllllllIlIIlll) {
        if (this.loaded) {
            final SoundEventAccessor llllllllllllllIIllIllllllIlIIllI = llllllllllllllIIllIllllllIlIIlll.createAccessor(this.sndHandler);
            final ResourceLocation llllllllllllllIIllIllllllIlIIlIl = llllllllllllllIIllIllllllIlIIlll.getSoundLocation();
            if (llllllllllllllIIllIllllllIlIIllI == null) {
                if (SoundManager.UNABLE_TO_PLAY.add(llllllllllllllIIllIllllllIlIIlIl)) {
                    SoundManager.LOGGER.warn(SoundManager.LOG_MARKER, "Unable to play unknown soundEvent: {}", (Object)llllllllllllllIIllIllllllIlIIlIl);
                }
            }
            else {
                if (!this.listeners.isEmpty()) {
                    for (final ISoundEventListener llllllllllllllIIllIllllllIlIIlII : this.listeners) {
                        llllllllllllllIIllIllllllIlIIlII.soundPlay(llllllllllllllIIllIllllllIlIIlll, llllllllllllllIIllIllllllIlIIllI);
                    }
                }
                if (this.sndSystem.getMasterVolume() <= 0.0f) {
                    SoundManager.LOGGER.debug(SoundManager.LOG_MARKER, "Skipped playing soundEvent: {}, master volume was zero", (Object)llllllllllllllIIllIllllllIlIIlIl);
                }
                else {
                    final Sound llllllllllllllIIllIllllllIlIIIll = llllllllllllllIIllIllllllIlIIlll.getSound();
                    if (llllllllllllllIIllIllllllIlIIIll == SoundHandler.MISSING_SOUND) {
                        if (SoundManager.UNABLE_TO_PLAY.add(llllllllllllllIIllIllllllIlIIlIl)) {
                            SoundManager.LOGGER.warn(SoundManager.LOG_MARKER, "Unable to play empty soundEvent: {}", (Object)llllllllllllllIIllIllllllIlIIlIl);
                        }
                    }
                    else {
                        final float llllllllllllllIIllIllllllIlIIIlI = llllllllllllllIIllIllllllIlIIlll.getVolume();
                        float llllllllllllllIIllIllllllIlIIIIl = 16.0f;
                        if (llllllllllllllIIllIllllllIlIIIlI > 1.0f) {
                            llllllllllllllIIllIllllllIlIIIIl *= llllllllllllllIIllIllllllIlIIIlI;
                        }
                        final SoundCategory llllllllllllllIIllIllllllIlIIIII = llllllllllllllIIllIllllllIlIIlll.getCategory();
                        final float llllllllllllllIIllIllllllIIlllll = this.getClampedVolume(llllllllllllllIIllIllllllIlIIlll);
                        final float llllllllllllllIIllIllllllIIllllI = this.getClampedPitch(llllllllllllllIIllIllllllIlIIlll);
                        if (llllllllllllllIIllIllllllIIlllll == 0.0f) {
                            SoundManager.LOGGER.debug(SoundManager.LOG_MARKER, "Skipped playing sound {}, volume was zero.", (Object)llllllllllllllIIllIllllllIlIIIll.getSoundLocation());
                        }
                        else {
                            final boolean llllllllllllllIIllIllllllIIlllIl = llllllllllllllIIllIllllllIlIIlll.canRepeat() && llllllllllllllIIllIllllllIlIIlll.getRepeatDelay() == 0;
                            final String llllllllllllllIIllIllllllIIlllII = MathHelper.getRandomUUID((Random)ThreadLocalRandom.current()).toString();
                            final ResourceLocation llllllllllllllIIllIllllllIIllIll = llllllllllllllIIllIllllllIlIIIll.getSoundAsOggLocation();
                            if (llllllllllllllIIllIllllllIlIIIll.isStreaming()) {
                                this.sndSystem.newStreamingSource(false, llllllllllllllIIllIllllllIIlllII, getURLForSoundResource(llllllllllllllIIllIllllllIIllIll), llllllllllllllIIllIllllllIIllIll.toString(), llllllllllllllIIllIllllllIIlllIl, llllllllllllllIIllIllllllIlIIlll.getXPosF(), llllllllllllllIIllIllllllIlIIlll.getYPosF(), llllllllllllllIIllIllllllIlIIlll.getZPosF(), llllllllllllllIIllIllllllIlIIlll.getAttenuationType().getTypeInt(), llllllllllllllIIllIllllllIlIIIIl);
                            }
                            else {
                                this.sndSystem.newSource(false, llllllllllllllIIllIllllllIIlllII, getURLForSoundResource(llllllllllllllIIllIllllllIIllIll), llllllllllllllIIllIllllllIIllIll.toString(), llllllllllllllIIllIllllllIIlllIl, llllllllllllllIIllIllllllIlIIlll.getXPosF(), llllllllllllllIIllIllllllIlIIlll.getYPosF(), llllllllllllllIIllIllllllIlIIlll.getZPosF(), llllllllllllllIIllIllllllIlIIlll.getAttenuationType().getTypeInt(), llllllllllllllIIllIllllllIlIIIIl);
                            }
                            SoundManager.LOGGER.debug(SoundManager.LOG_MARKER, "Playing sound {} for event {} as channel {}", (Object)llllllllllllllIIllIllllllIlIIIll.getSoundLocation(), (Object)llllllllllllllIIllIllllllIlIIlIl, (Object)llllllllllllllIIllIllllllIIlllII);
                            this.sndSystem.setPitch(llllllllllllllIIllIllllllIIlllII, llllllllllllllIIllIllllllIIllllI);
                            this.sndSystem.setVolume(llllllllllllllIIllIllllllIIlllII, llllllllllllllIIllIllllllIIlllll);
                            this.sndSystem.play(llllllllllllllIIllIllllllIIlllII);
                            this.playingSoundsStopTime.put(llllllllllllllIIllIllllllIIlllII, this.playTime + 20);
                            this.playingSounds.put(llllllllllllllIIllIllllllIIlllII, llllllllllllllIIllIllllllIlIIlll);
                            this.categorySounds.put((Object)llllllllllllllIIllIllllllIlIIIII, (Object)llllllllllllllIIllIllllllIIlllII);
                            if (llllllllllllllIIllIllllllIlIIlll instanceof ITickableSound) {
                                this.tickableSounds.add((ITickableSound)llllllllllllllIIllIllllllIlIIlll);
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void stopAllSounds() {
        if (this.loaded) {
            for (final String llllllllllllllIIllIlllllllllIIll : this.playingSounds.keySet()) {
                this.sndSystem.stop(llllllllllllllIIllIlllllllllIIll);
            }
            this.playingSounds.clear();
            this.delayedSounds.clear();
            this.tickableSounds.clear();
            this.categorySounds.clear();
            this.playingSoundsStopTime.clear();
        }
    }
    
    private float getClampedVolume(final ISound llllllllllllllIIllIllllllIIIIllI) {
        return MathHelper.clamp(llllllllllllllIIllIllllllIIIIllI.getVolume() * this.getVolume(llllllllllllllIIllIllllllIIIIllI.getCategory()), 0.0f, 1.0f);
    }
    
    public void removeListener(final ISoundEventListener llllllllllllllIIllIllllllllIIllI) {
        this.listeners.remove(llllllllllllllIIllIllllllllIIllI);
    }
    
    class SoundSystemStarterThread extends SoundSystem
    {
        public boolean playing(final String lllllllllllllIIlIllIIIIlIllllllI) {
            synchronized (SoundSystemConfig.THREAD_SYNC) {
                if (this.soundLibrary == null) {
                    // monitorexit(SoundSystemConfig.THREAD_SYNC)
                    return false;
                }
                final Source lllllllllllllIIlIllIIIIlIlllllIl = this.soundLibrary.getSources().get(lllllllllllllIIlIllIIIIlIllllllI);
                if (lllllllllllllIIlIllIIIIlIlllllIl == null) {
                    // monitorexit(SoundSystemConfig.THREAD_SYNC)
                    return false;
                }
                // monitorexit(SoundSystemConfig.THREAD_SYNC)
                return lllllllllllllIIlIllIIIIlIlllllIl.playing() || lllllllllllllIIlIllIIIIlIlllllIl.paused() || lllllllllllllIIlIllIIIIlIlllllIl.preLoad;
            }
        }
        
        private SoundSystemStarterThread() {
        }
    }
}
