package de.gerrygames.viarewind.protocol.protocol1_8to1_9.util;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage.*;

public class RelativeMoveUtil
{
    public static Vector[] calculateRelativeMoves(final UserConnection lllllllllllllIlllllIIIIIlIlIlIII, final int lllllllllllllIlllllIIIIIlIllIIlI, int lllllllllllllIlllllIIIIIlIlIIllI, int lllllllllllllIlllllIIIIIlIlIIlIl, int lllllllllllllIlllllIIIIIlIlIIlII) {
        final EntityTracker lllllllllllllIlllllIIIIIlIlIlllI = lllllllllllllIlllllIIIIIlIlIlIII.get(EntityTracker.class);
        final Vector lllllllllllllIlllllIIIIIlIlIllIl = lllllllllllllIlllllIIIIIlIlIlllI.getEntityOffset(lllllllllllllIlllllIIIIIlIllIIlI);
        lllllllllllllIlllllIIIIIlIlIIllI += (String)lllllllllllllIlllllIIIIIlIlIllIl.getBlockX();
        lllllllllllllIlllllIIIIIlIlIIlIl += lllllllllllllIlllllIIIIIlIlIllIl.getBlockY();
        lllllllllllllIlllllIIIIIlIlIIlII += lllllllllllllIlllllIIIIIlIlIllIl.getBlockZ();
        if (lllllllllllllIlllllIIIIIlIlIIllI > 32767) {
            lllllllllllllIlllllIIIIIlIlIllIl.setBlockX((int)(lllllllllllllIlllllIIIIIlIlIIllI - 32767));
            lllllllllllllIlllllIIIIIlIlIIllI = (String)32767;
        }
        else if (lllllllllllllIlllllIIIIIlIlIIllI < -32768) {
            lllllllllllllIlllllIIIIIlIlIllIl.setBlockX((int)(lllllllllllllIlllllIIIIIlIlIIllI - -32768));
            lllllllllllllIlllllIIIIIlIlIIllI = (String)(-32768);
        }
        else {
            lllllllllllllIlllllIIIIIlIlIllIl.setBlockX(0);
        }
        if (lllllllllllllIlllllIIIIIlIlIIlIl > 32767) {
            lllllllllllllIlllllIIIIIlIlIllIl.setBlockY((int)(lllllllllllllIlllllIIIIIlIlIIlIl - 32767));
            lllllllllllllIlllllIIIIIlIlIIlIl = 32767;
        }
        else if (lllllllllllllIlllllIIIIIlIlIIlIl < -32768) {
            lllllllllllllIlllllIIIIIlIlIllIl.setBlockY((int)(lllllllllllllIlllllIIIIIlIlIIlIl + 32768));
            lllllllllllllIlllllIIIIIlIlIIlIl = -32768;
        }
        else {
            lllllllllllllIlllllIIIIIlIlIllIl.setBlockY(0);
        }
        if (lllllllllllllIlllllIIIIIlIlIIlII > 32767) {
            lllllllllllllIlllllIIIIIlIlIllIl.setBlockZ((int)(lllllllllllllIlllllIIIIIlIlIIlII - 32767));
            lllllllllllllIlllllIIIIIlIlIIlII = 32767;
        }
        else if (lllllllllllllIlllllIIIIIlIlIIlII < -32768) {
            lllllllllllllIlllllIIIIIlIlIllIl.setBlockZ((int)(lllllllllllllIlllllIIIIIlIlIIlII + 32768));
            lllllllllllllIlllllIIIIIlIlIIlII = -32768;
        }
        else {
            lllllllllllllIlllllIIIIIlIlIllIl.setBlockZ(0);
        }
        int lllllllllllllIlllllIIIIIlIlIllII = 0;
        int lllllllllllllIlllllIIIIIlIlIlIll;
        int lllllllllllllIlllllIIIIIlIlIlIlI;
        Vector[] lllllllllllllIlllllIIIIIlIlIlIIl;
        if (lllllllllllllIlllllIIIIIlIlIIllI > 16256 || lllllllllllllIlllllIIIIIlIlIIllI < -16384 || lllllllllllllIlllllIIIIIlIlIIlIl > 16256 || lllllllllllllIlllllIIIIIlIlIIlIl < -16384 || lllllllllllllIlllllIIIIIlIlIIlII > 16256 || lllllllllllllIlllllIIIIIlIlIIlII < -16384) {
            final byte lllllllllllllIlllllIIIIIlIllllIl = (byte)(lllllllllllllIlllllIIIIIlIlIIllI / 256);
            final byte lllllllllllllIlllllIIIIIlIllllII = (byte)Math.round((float)(lllllllllllllIlllllIIIIIlIlIIllI - lllllllllllllIlllllIIIIIlIllllIl * 128) / 128.0f);
            final byte lllllllllllllIlllllIIIIIlIlllIll = (byte)(lllllllllllllIlllllIIIIIlIlIIlIl / 256);
            final byte lllllllllllllIlllllIIIIIlIlllIlI = (byte)Math.round((lllllllllllllIlllllIIIIIlIlIIlIl - lllllllllllllIlllllIIIIIlIlllIll * 128) / 128.0f);
            final byte lllllllllllllIlllllIIIIIlIlllIIl = (byte)(lllllllllllllIlllllIIIIIlIlIIlII / 256);
            final byte lllllllllllllIlllllIIIIIlIlllIII = (byte)Math.round((lllllllllllllIlllllIIIIIlIlIIlII - lllllllllllllIlllllIIIIIlIlllIIl * 128) / 128.0f);
            final int lllllllllllllIlllllIIIIIlIllIlll = lllllllllllllIlllllIIIIIlIllllIl + lllllllllllllIlllllIIIIIlIllllII;
            final int lllllllllllllIlllllIIIIIlIllIllI = lllllllllllllIlllllIIIIIlIlllIll + lllllllllllllIlllllIIIIIlIlllIlI;
            final int lllllllllllllIlllllIIIIIlIllIlIl = lllllllllllllIlllllIIIIIlIlllIIl + lllllllllllllIlllllIIIIIlIlllIII;
            final Vector[] lllllllllllllIlllllIIIIIlIllIlII = { new Vector(lllllllllllllIlllllIIIIIlIllllIl, lllllllllllllIlllllIIIIIlIlllIll, lllllllllllllIlllllIIIIIlIlllIIl), new Vector(lllllllllllllIlllllIIIIIlIllllII, lllllllllllllIlllllIIIIIlIlllIlI, lllllllllllllIlllllIIIIIlIlllIII) };
        }
        else {
            lllllllllllllIlllllIIIIIlIlIllII = Math.round((float)lllllllllllllIlllllIIIIIlIlIIllI / 128.0f);
            lllllllllllllIlllllIIIIIlIlIlIll = Math.round(lllllllllllllIlllllIIIIIlIlIIlIl / 128.0f);
            lllllllllllllIlllllIIIIIlIlIlIlI = Math.round(lllllllllllllIlllllIIIIIlIlIIlII / 128.0f);
            lllllllllllllIlllllIIIIIlIlIlIIl = new Vector[] { new Vector(lllllllllllllIlllllIIIIIlIlIllII, lllllllllllllIlllllIIIIIlIlIlIll, lllllllllllllIlllllIIIIIlIlIlIlI) };
        }
        lllllllllllllIlllllIIIIIlIlIllIl.setBlockX((int)(lllllllllllllIlllllIIIIIlIlIllIl.getBlockX() + lllllllllllllIlllllIIIIIlIlIIllI - lllllllllllllIlllllIIIIIlIlIllII * 128));
        lllllllllllllIlllllIIIIIlIlIllIl.setBlockY((int)(lllllllllllllIlllllIIIIIlIlIllIl.getBlockY() + lllllllllllllIlllllIIIIIlIlIIlIl - lllllllllllllIlllllIIIIIlIlIlIll * 128));
        lllllllllllllIlllllIIIIIlIlIllIl.setBlockZ((int)(lllllllllllllIlllllIIIIIlIlIllIl.getBlockZ() + lllllllllllllIlllllIIIIIlIlIIlII - lllllllllllllIlllllIIIIIlIlIlIlI * 128));
        lllllllllllllIlllllIIIIIlIlIlllI.setEntityOffset(lllllllllllllIlllllIIIIIlIllIIlI, lllllllllllllIlllllIIIIIlIlIllIl);
        return lllllllllllllIlllllIIIIIlIlIlIIl;
    }
}
