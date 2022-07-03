package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.data;

import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.*;
import java.util.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.item.*;

public class ParticleMapping
{
    private static final /* synthetic */ ParticleData[] particles;
    
    private static ParticleData rewrite(final int lllllllllllllIlIlIllIIIlIlIlIIII) {
        return new ParticleData(lllllllllllllIlIlIllIIIlIlIlIIII);
    }
    
    private static ParticleData rewrite(final int lllllllllllllIlIlIllIIIlIlIIlIlI, final ParticleHandler lllllllllllllIlIlIllIIIlIlIIlIIl) {
        return new ParticleData(lllllllllllllIlIlIllIIIlIlIIlIlI, lllllllllllllIlIlIllIIIlIlIIlIIl);
    }
    
    public static ParticleData getMapping(final int lllllllllllllIlIlIllIIIlIlIlIIlI) {
        return ParticleMapping.particles[lllllllllllllIlIlIllIIIlIlIlIIlI];
    }
    
    static {
        final ParticleHandler lllllllllllllIlIlIllIIIlIlIIIlll = new ParticleHandler() {
            private int[] rewrite(final int lllllllllllllIIlIIIIlIIIIlIIIlII) {
                final int lllllllllllllIIlIIIIlIIIIlIIIlll = Protocol1_12_2To1_13.MAPPINGS.getNewBlockStateId(lllllllllllllIIlIIIIlIIIIlIIIlII);
                final int lllllllllllllIIlIIIIlIIIIlIIIllI = lllllllllllllIIlIIIIlIIIIlIIIlll >> 4;
                final int lllllllllllllIIlIIIIlIIIIlIIIlIl = lllllllllllllIIlIIIIlIIIIlIIIlll & 0xF;
                return new int[] { lllllllllllllIIlIIIIlIIIIlIIIllI + (lllllllllllllIIlIIIIlIIIIlIIIlIl << 12) };
            }
            
            @Override
            public boolean isBlockHandler() {
                return true;
            }
            
            @Override
            public int[] rewrite(final Protocol1_12_2To1_13 lllllllllllllIIlIIIIlIIIIlIlIIIl, final List<Particle.ParticleData> lllllllllllllIIlIIIIlIIIIlIlIIII) {
                return this.rewrite((int)lllllllllllllIIlIIIIlIIIIlIlIIII.get(0).getValue());
            }
            
            @Override
            public int[] rewrite(final Protocol1_12_2To1_13 lllllllllllllIIlIIIIlIIIIlIllIII, final PacketWrapper lllllllllllllIIlIIIIlIIIIlIlIlll) throws Exception {
                return this.rewrite(lllllllllllllIIlIIIIlIIIIlIlIlll.read((Type<Integer>)Type.VAR_INT));
            }
        };
        particles = new ParticleData[] { rewrite(16), rewrite(20), rewrite(35), rewrite(37, lllllllllllllIlIlIllIIIlIlIIIlll), rewrite(4), rewrite(29), rewrite(9), rewrite(44), rewrite(42), rewrite(19), rewrite(18), rewrite(30, new ParticleHandler() {
                @Override
                public int[] rewrite(final Protocol1_12_2To1_13 lllllllllllllIllIIIlllIllIlIIlIl, final List<Particle.ParticleData> lllllllllllllIllIIIlllIllIlIIlII) {
                    return null;
                }
                
                @Override
                public int[] rewrite(final Protocol1_12_2To1_13 lllllllllllllIllIIIlllIllIllIIIl, final PacketWrapper lllllllllllllIllIIIlllIllIllIIII) throws Exception {
                    final float lllllllllllllIllIIIlllIllIlIllll = lllllllllllllIllIIIlllIllIllIIII.read((Type<Float>)Type.FLOAT);
                    final float lllllllllllllIllIIIlllIllIlIlllI = lllllllllllllIllIIIlllIllIllIIII.read((Type<Float>)Type.FLOAT);
                    final float lllllllllllllIllIIIlllIllIlIllIl = lllllllllllllIllIIIlllIllIllIIII.read((Type<Float>)Type.FLOAT);
                    final float lllllllllllllIllIIIlllIllIlIllII = lllllllllllllIllIIIlllIllIllIIII.read((Type<Float>)Type.FLOAT);
                    lllllllllllllIllIIIlllIllIllIIII.set(Type.FLOAT, 3, lllllllllllllIllIIIlllIllIlIllll);
                    lllllllllllllIllIIIlllIllIllIIII.set(Type.FLOAT, 4, lllllllllllllIllIIIlllIllIlIlllI);
                    lllllllllllllIllIIIlllIllIllIIII.set(Type.FLOAT, 5, lllllllllllllIllIIIlllIllIlIllIl);
                    lllllllllllllIllIIIlllIllIllIIII.set(Type.FLOAT, 6, lllllllllllllIllIIIlllIllIlIllII);
                    lllllllllllllIllIIIlllIllIllIIII.set(Type.INT, 1, 0);
                    return null;
                }
            }), rewrite(13), rewrite(41), rewrite(10), rewrite(25), rewrite(43), rewrite(15), rewrite(2), rewrite(1), rewrite(46, lllllllllllllIlIlIllIIIlIlIIIlll), rewrite(3), rewrite(6), rewrite(26), rewrite(21), rewrite(34), rewrite(14), rewrite(36, new ParticleHandler() {
                @Override
                public int[] rewrite(final Protocol1_12_2To1_13 lllllllllllllIllIIIllIllIIlllllI, final PacketWrapper lllllllllllllIllIIIllIllIIllllIl) throws Exception {
                    return this.rewrite(lllllllllllllIllIIIllIllIIlllllI, lllllllllllllIllIIIllIllIIllllIl.read(Type.FLAT_ITEM));
                }
                
                private int[] rewrite(final Protocol1_12_2To1_13 lllllllllllllIllIIIllIllIIlIllll, final Item lllllllllllllIllIIIllIllIIlIlIll) {
                    final Item lllllllllllllIllIIIllIllIIlIllIl = lllllllllllllIllIIIllIllIIlIllll.getItemRewriter().handleItemToClient(lllllllllllllIllIIIllIllIIlIlIll);
                    return new int[] { lllllllllllllIllIIIllIllIIlIllIl.identifier(), lllllllllllllIllIIIllIllIIlIllIl.data() };
                }
                
                @Override
                public int[] rewrite(final Protocol1_12_2To1_13 lllllllllllllIllIIIllIllIIllIlIl, final List<Particle.ParticleData> lllllllllllllIllIIIllIllIIllIlll) {
                    return this.rewrite(lllllllllllllIllIIIllIllIIllIlIl, (Item)lllllllllllllIllIIIllIllIIllIlll.get(0).getValue());
                }
            }), rewrite(33), rewrite(31), rewrite(12), rewrite(27), rewrite(22), rewrite(23), rewrite(0), rewrite(24), rewrite(39), rewrite(11), rewrite(48), rewrite(12), rewrite(45), rewrite(47), rewrite(7), rewrite(5), rewrite(17), rewrite(4), rewrite(4), rewrite(4), rewrite(18), rewrite(18) };
    }
    
    public static final class ParticleData
    {
        private final /* synthetic */ ParticleHandler handler;
        private final /* synthetic */ int historyId;
        
        public int getHistoryId() {
            return this.historyId;
        }
        
        public ParticleHandler getHandler() {
            return this.handler;
        }
        
        public int[] rewriteMeta(final Protocol1_12_2To1_13 lllllllllllllllIllIIIlIllIllllll, final List<Particle.ParticleData> lllllllllllllllIllIIIlIllIlllllI) {
            if (this.handler == null) {
                return null;
            }
            return this.handler.rewrite(lllllllllllllllIllIIIlIllIllllll, lllllllllllllllIllIIIlIllIlllllI);
        }
        
        public int[] rewriteData(final Protocol1_12_2To1_13 lllllllllllllllIllIIIlIlllIIlIll, final PacketWrapper lllllllllllllllIllIIIlIlllIIlIlI) throws Exception {
            if (this.handler == null) {
                return null;
            }
            return this.handler.rewrite(lllllllllllllllIllIIIlIlllIIlIll, lllllllllllllllIllIIIlIlllIIlIlI);
        }
        
        private ParticleData(final int lllllllllllllllIllIIIlIlllIlIlll, final ParticleHandler lllllllllllllllIllIIIlIlllIllIIl) {
            this.historyId = lllllllllllllllIllIIIlIlllIlIlll;
            this.handler = lllllllllllllllIllIIIlIlllIllIIl;
        }
        
        private ParticleData(final int lllllllllllllllIllIIIlIlllIlIIlI) {
            this(lllllllllllllllIllIIIlIlllIlIIlI, (ParticleHandler)null);
        }
    }
    
    public interface ParticleHandler
    {
        int[] rewrite(final Protocol1_12_2To1_13 p0, final List<Particle.ParticleData> p1);
        
        default boolean isBlockHandler() {
            return false;
        }
        
        int[] rewrite(final Protocol1_12_2To1_13 p0, final PacketWrapper p1) throws Exception;
    }
}
