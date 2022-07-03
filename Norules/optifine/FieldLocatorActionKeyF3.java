package optifine;

import java.lang.reflect.*;
import net.minecraft.client.*;
import java.util.*;

public class FieldLocatorActionKeyF3 implements IFieldLocator
{
    private Field getFieldRenderChunksMany() {
        final Minecraft llllllllllllllIllIIlllIIIIlIlIII = Minecraft.getMinecraft();
        final boolean llllllllllllllIllIIlllIIIIlIIlll = llllllllllllllIllIIlllIIIIlIlIII.renderChunksMany;
        final Field[] llllllllllllllIllIIlllIIIIlIIllI = Minecraft.class.getDeclaredFields();
        llllllllllllllIllIIlllIIIIlIlIII.renderChunksMany = true;
        final Field[] llllllllllllllIllIIlllIIIIlIIlIl = ReflectorRaw.getFields(llllllllllllllIllIIlllIIIIlIlIII, llllllllllllllIllIIlllIIIIlIIllI, Boolean.TYPE, Boolean.TRUE);
        llllllllllllllIllIIlllIIIIlIlIII.renderChunksMany = false;
        final Field[] llllllllllllllIllIIlllIIIIlIIlII = ReflectorRaw.getFields(llllllllllllllIllIIlllIIIIlIlIII, llllllllllllllIllIIlllIIIIlIIllI, Boolean.TYPE, Boolean.FALSE);
        llllllllllllllIllIIlllIIIIlIlIII.renderChunksMany = llllllllllllllIllIIlllIIIIlIIlll;
        final Set<Field> llllllllllllllIllIIlllIIIIlIIIll = new HashSet<Field>(Arrays.asList(llllllllllllllIllIIlllIIIIlIIlIl));
        final Set<Field> llllllllllllllIllIIlllIIIIlIIIlI = new HashSet<Field>(Arrays.asList(llllllllllllllIllIIlllIIIIlIIlII));
        final Set<Field> llllllllllllllIllIIlllIIIIlIIIIl = new HashSet<Field>(llllllllllllllIllIIlllIIIIlIIIll);
        llllllllllllllIllIIlllIIIIlIIIIl.retainAll(llllllllllllllIllIIlllIIIIlIIIlI);
        final Field[] llllllllllllllIllIIlllIIIIlIIIII = llllllllllllllIllIIlllIIIIlIIIIl.toArray(new Field[llllllllllllllIllIIlllIIIIlIIIIl.size()]);
        return (llllllllllllllIllIIlllIIIIlIIIII.length != 1) ? null : llllllllllllllIllIIlllIIIIlIIIII[0];
    }
    
    @Override
    public Field getField() {
        final Class llllllllllllllIllIIlllIIIIlllIIl = Minecraft.class;
        final Field llllllllllllllIllIIlllIIIIlllIII = this.getFieldRenderChunksMany();
        if (llllllllllllllIllIIlllIIIIlllIII == null) {
            Config.log(String.valueOf(new StringBuilder("(Reflector) Field not present: ").append(llllllllllllllIllIIlllIIIIlllIIl.getName()).append(".actionKeyF3 (field renderChunksMany not found)")));
            return null;
        }
        final Field llllllllllllllIllIIlllIIIIllIlll = ReflectorRaw.getFieldAfter(Minecraft.class, llllllllllllllIllIIlllIIIIlllIII, Boolean.TYPE, 0);
        if (llllllllllllllIllIIlllIIIIllIlll == null) {
            Config.log(String.valueOf(new StringBuilder("(Reflector) Field not present: ").append(llllllllllllllIllIIlllIIIIlllIIl.getName()).append(".actionKeyF3")));
            return null;
        }
        return llllllllllllllIllIIlllIIIIllIlll;
    }
}
