package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data;

import java.util.concurrent.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.packets.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import java.util.*;

public class ParticleRewriter
{
    private static final /* synthetic */ List<NewParticle> particles;
    
    private static boolean randomBool() {
        return ThreadLocalRandom.current().nextBoolean();
    }
    
    private static void add(final int llllllllllllllIlIIlllIllIIllIllI, final ParticleDataHandler llllllllllllllIlIIlllIllIIllIlIl) {
        ParticleRewriter.particles.add(new NewParticle(llllllllllllllIlIIlllIllIIllIllI, llllllllllllllIlIIlllIllIIllIlIl));
    }
    
    private static ParticleDataHandler reddustHandler() {
        return new ParticleDataHandler() {
            @Override
            public Particle handler(final Particle lllllllllllllIlIIIlIlIlIIlIIIlll, final Integer[] lllllllllllllIlIIIlIlIlIIlIIIllI) {
                lllllllllllllIlIIIlIlIlIIlIIIlll.getArguments().add(new Particle.ParticleData(Type.FLOAT, randomBool() ? 1.0f : 0.0f));
                lllllllllllllIlIIIlIlIlIIlIIIlll.getArguments().add(new Particle.ParticleData(Type.FLOAT, 0.0f));
                lllllllllllllIlIIIlIlIlIIlIIIlll.getArguments().add(new Particle.ParticleData(Type.FLOAT, randomBool() ? 1.0f : 0.0f));
                lllllllllllllIlIIIlIlIlIIlIIIlll.getArguments().add(new Particle.ParticleData(Type.FLOAT, 1.0f));
                return lllllllllllllIlIIIlIlIlIIlIIIlll;
            }
        };
    }
    
    private static void add(final int llllllllllllllIlIIlllIllIIlllIlI) {
        ParticleRewriter.particles.add(new NewParticle(llllllllllllllIlIIlllIllIIlllIlI, null));
    }
    
    static {
        particles = new ArrayList<NewParticle>();
        add(34);
        add(19);
        add(18);
        add(21);
        add(4);
        add(43);
        add(22);
        add(42);
        add(42);
        add(6);
        add(14);
        add(37);
        add(30);
        add(12);
        add(26);
        add(17);
        add(0);
        add(44);
        add(10);
        add(9);
        add(1);
        add(24);
        add(32);
        add(33);
        add(35);
        add(15);
        add(23);
        add(31);
        add(-1);
        add(5);
        add(11, reddustHandler());
        add(29);
        add(34);
        add(28);
        add(25);
        add(2);
        add(27, iconcrackHandler());
        add(3, blockHandler());
        add(3, blockHandler());
        add(36);
        add(-1);
        add(13);
        add(8);
        add(16);
        add(7);
        add(40);
        add(20, blockHandler());
        add(41);
        add(38);
    }
    
    private static ParticleDataHandler blockHandler() {
        return new ParticleDataHandler() {
            @Override
            public Particle handler(final Particle lllllllllllllIllllIIlIIIIllIllll, final Integer[] lllllllllllllIllllIIlIIIIllIlllI) {
                final int lllllllllllllIllllIIlIIIIlllIIlI = lllllllllllllIllllIIlIIIIllIlllI[0];
                final int lllllllllllllIllllIIlIIIIlllIIIl = (lllllllllllllIllllIIlIIIIlllIIlI & 0xFFF) << 4 | (lllllllllllllIllllIIlIIIIlllIIlI >> 12 & 0xF);
                final int lllllllllllllIllllIIlIIIIlllIIII = WorldPackets.toNewId(lllllllllllllIllllIIlIIIIlllIIIl);
                lllllllllllllIllllIIlIIIIllIllll.getArguments().add(new Particle.ParticleData(Type.VAR_INT, lllllllllllllIllllIIlIIIIlllIIII));
                return lllllllllllllIllllIIlIIIIllIllll;
            }
        };
    }
    
    private static ParticleDataHandler iconcrackHandler() {
        return new ParticleDataHandler() {
            @Override
            public Particle handler(final Particle llllllllllllllIIIIllllIlIIIIIIII, final Integer[] llllllllllllllIIIIllllIIllllllll) {
                if (llllllllllllllIIIIllllIIllllllll.length == 1) {
                    final Item llllllllllllllIIIIllllIlIIIIIIll = new DataItem(llllllllllllllIIIIllllIIllllllll[0], (byte)1, (short)0, null);
                }
                else {
                    if (llllllllllllllIIIIllllIIllllllll.length != 2) {
                        return llllllllllllllIIIIllllIlIIIIIIII;
                    }
                    final Item llllllllllllllIIIIllllIlIIIIIIlI = new DataItem(llllllllllllllIIIIllllIIllllllll[0], (byte)1, llllllllllllllIIIIllllIIllllllll[1].shortValue(), null);
                }
                final Item llllllllllllllIIIIllllIIlllllllI;
                Via.getManager().getProtocolManager().getProtocol(Protocol1_13To1_12_2.class).getItemRewriter().handleItemToClient(llllllllllllllIIIIllllIIlllllllI);
                llllllllllllllIIIIllllIlIIIIIIII.getArguments().add(new Particle.ParticleData(Type.FLAT_ITEM, llllllllllllllIIIIllllIIlllllllI));
                return llllllllllllllIIIIllllIlIIIIIIII;
            }
        };
    }
    
    public static Particle rewriteParticle(final int llllllllllllllIlIIlllIllIlIIIlII, final Integer[] llllllllllllllIlIIlllIllIlIIIIll) {
        if (llllllllllllllIlIIlllIllIlIIIlII >= ParticleRewriter.particles.size()) {
            Via.getPlatform().getLogger().severe(String.valueOf(new StringBuilder().append("Failed to transform particles with id ").append(llllllllllllllIlIIlllIllIlIIIlII).append(" and data ").append(Arrays.toString(llllllllllllllIlIIlllIllIlIIIIll))));
            return null;
        }
        final NewParticle llllllllllllllIlIIlllIllIlIIIIIl = ParticleRewriter.particles.get(llllllllllllllIlIIlllIllIlIIIlII);
        return llllllllllllllIlIIlllIllIlIIIIIl.handle(new Particle(llllllllllllllIlIIlllIllIlIIIIIl.getId()), llllllllllllllIlIIlllIllIlIIIIll);
    }
    
    private static class NewParticle
    {
        private final /* synthetic */ ParticleDataHandler handler;
        private final /* synthetic */ int id;
        
        public ParticleDataHandler getHandler() {
            return this.handler;
        }
        
        public NewParticle(final int llllllllllllllIllIIIllIIllIlIIII, final ParticleDataHandler llllllllllllllIllIIIllIIllIIllII) {
            this.id = llllllllllllllIllIIIllIIllIlIIII;
            this.handler = llllllllllllllIllIIIllIIllIIllII;
        }
        
        public int getId() {
            return this.id;
        }
        
        public Particle handle(final Particle llllllllllllllIllIIIllIIllIIIlll, final Integer[] llllllllllllllIllIIIllIIllIIIIll) {
            if (this.handler != null) {
                return this.handler.handler(llllllllllllllIllIIIllIIllIIIlll, llllllllllllllIllIIIllIIllIIIIll);
            }
            return llllllllllllllIllIIIllIIllIIIlll;
        }
    }
    
    interface ParticleDataHandler
    {
        Particle handler(final Particle p0, final Integer[] p1);
    }
}
