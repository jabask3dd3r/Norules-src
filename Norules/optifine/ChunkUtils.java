package optifine;

import net.minecraft.world.chunk.*;
import java.lang.reflect.*;
import java.util.*;

public class ChunkUtils
{
    private static /* synthetic */ ReflectorField fieldHasEntities;
    
    public static boolean hasEntities(final Chunk llllllllllllllIIllIlIlIIlIIlIlIl) {
        if (ChunkUtils.fieldHasEntities == null) {
            ChunkUtils.fieldHasEntities = findFieldHasEntities(llllllllllllllIIllIlIlIIlIIlIlIl);
        }
        if (!ChunkUtils.fieldHasEntities.exists()) {
            return true;
        }
        final Boolean llllllllllllllIIllIlIlIIlIIlIlII = (Boolean)Reflector.getFieldValue(llllllllllllllIIllIlIlIIlIIlIlIl, ChunkUtils.fieldHasEntities);
        return llllllllllllllIIllIlIlIIlIIlIlII == null || llllllllllllllIIllIlIlIIlIIlIlII;
    }
    
    private static ReflectorField findFieldHasEntities(final Chunk llllllllllllllIIllIlIlIIlIIIIlIl) {
        try {
            final List llllllllllllllIIllIlIlIIlIIIIlII = new ArrayList();
            final List llllllllllllllIIllIlIlIIlIIIIIll = new ArrayList();
            final Field[] llllllllllllllIIllIlIlIIlIIIIIlI = Chunk.class.getDeclaredFields();
            for (int llllllllllllllIIllIlIlIIlIIIIIIl = 0; llllllllllllllIIllIlIlIIlIIIIIIl < llllllllllllllIIllIlIlIIlIIIIIlI.length; ++llllllllllllllIIllIlIlIIlIIIIIIl) {
                final Field llllllllllllllIIllIlIlIIlIIIIIII = llllllllllllllIIllIlIlIIlIIIIIlI[llllllllllllllIIllIlIlIIlIIIIIIl];
                if (llllllllllllllIIllIlIlIIlIIIIIII.getType() == Boolean.TYPE) {
                    llllllllllllllIIllIlIlIIlIIIIIII.setAccessible(true);
                    llllllllllllllIIllIlIlIIlIIIIlII.add(llllllllllllllIIllIlIlIIlIIIIIII);
                    llllllllllllllIIllIlIlIIlIIIIIll.add(llllllllllllllIIllIlIlIIlIIIIIII.get(llllllllllllllIIllIlIlIIlIIIIlIl));
                }
            }
            llllllllllllllIIllIlIlIIlIIIIlIl.setHasEntities(false);
            final List llllllllllllllIIllIlIlIIIlllllll = new ArrayList();
            for (final Object llllllllllllllIIllIlIlIIIllllllI : llllllllllllllIIllIlIlIIlIIIIlII) {
                llllllllllllllIIllIlIlIIIlllllll.add(((Field)llllllllllllllIIllIlIlIIIllllllI).get(llllllllllllllIIllIlIlIIlIIIIlIl));
            }
            llllllllllllllIIllIlIlIIlIIIIlIl.setHasEntities(true);
            final List llllllllllllllIIllIlIlIIIlllllIl = new ArrayList();
            for (final Object llllllllllllllIIllIlIlIIIlllllII : llllllllllllllIIllIlIlIIlIIIIlII) {
                llllllllllllllIIllIlIlIIIlllllIl.add(((Field)llllllllllllllIIllIlIlIIIlllllII).get(llllllllllllllIIllIlIlIIlIIIIlIl));
            }
            final List llllllllllllllIIllIlIlIIIllllIll = new ArrayList();
            for (int llllllllllllllIIllIlIlIIIllllIlI = 0; llllllllllllllIIllIlIlIIIllllIlI < llllllllllllllIIllIlIlIIlIIIIlII.size(); ++llllllllllllllIIllIlIlIIIllllIlI) {
                final Field llllllllllllllIIllIlIlIIIllllIIl = llllllllllllllIIllIlIlIIlIIIIlII.get(llllllllllllllIIllIlIlIIIllllIlI);
                final Boolean llllllllllllllIIllIlIlIIIllllIII = llllllllllllllIIllIlIlIIIlllllll.get(llllllllllllllIIllIlIlIIIllllIlI);
                final Boolean llllllllllllllIIllIlIlIIIlllIlll = llllllllllllllIIllIlIlIIIlllllIl.get(llllllllllllllIIllIlIlIIIllllIlI);
                if (!llllllllllllllIIllIlIlIIIllllIII && llllllllllllllIIllIlIlIIIlllIlll) {
                    llllllllllllllIIllIlIlIIIllllIll.add(llllllllllllllIIllIlIlIIIllllIIl);
                    final Boolean llllllllllllllIIllIlIlIIIlllIllI = llllllllllllllIIllIlIlIIlIIIIIll.get(llllllllllllllIIllIlIlIIIllllIlI);
                    llllllllllllllIIllIlIlIIIllllIIl.set(llllllllllllllIIllIlIlIIlIIIIlIl, llllllllllllllIIllIlIlIIIlllIllI);
                }
            }
            if (llllllllllllllIIllIlIlIIIllllIll.size() == 1) {
                final Field llllllllllllllIIllIlIlIIIlllIlIl = llllllllllllllIIllIlIlIIIllllIll.get(0);
                return new ReflectorField(llllllllllllllIIllIlIlIIIlllIlIl);
            }
        }
        catch (Exception llllllllllllllIIllIlIlIIIlllIlII) {
            Config.warn(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIllIlIlIIIlllIlII.getClass().getName())).append(" ").append(llllllllllllllIIllIlIlIIIlllIlII.getMessage())));
        }
        Config.warn("Error finding Chunk.hasEntities");
        return new ReflectorField(new ReflectorClass(Chunk.class), "hasEntities");
    }
    
    static {
        ChunkUtils.fieldHasEntities = null;
    }
}
