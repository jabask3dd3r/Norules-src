package de.gerrygames.viarewind.utils.math;

public class RayTracing
{
    public static Vector3d trace(final Ray3d lllllllllllllIlllIIIIllIlIIIIlII, final AABB lllllllllllllIlllIIIIllIIlllIlIl, final double lllllllllllllIlllIIIIllIlIIIIIlI) {
        final Vector3d lllllllllllllIlllIIIIllIlIIIIIIl = new Vector3d(1.0 / lllllllllllllIlllIIIIllIlIIIIlII.dir.x, 1.0 / lllllllllllllIlllIIIIllIlIIIIlII.dir.y, 1.0 / lllllllllllllIlllIIIIllIlIIIIlII.dir.z);
        final boolean lllllllllllllIlllIIIIllIlIIIIIII = lllllllllllllIlllIIIIllIlIIIIIIl.x < 0.0;
        final boolean lllllllllllllIlllIIIIllIIlllllll = lllllllllllllIlllIIIIllIlIIIIIIl.y < 0.0;
        final boolean lllllllllllllIlllIIIIllIIllllllI = lllllllllllllIlllIIIIllIlIIIIIIl.z < 0.0;
        Vector3d lllllllllllllIlllIIIIllIIlllllIl = lllllllllllllIlllIIIIllIlIIIIIII ? lllllllllllllIlllIIIIllIIlllIlIl.max : lllllllllllllIlllIIIIllIIlllIlIl.min;
        double lllllllllllllIlllIIIIllIIlllllII = (lllllllllllllIlllIIIIllIIlllllIl.x - lllllllllllllIlllIIIIllIlIIIIlII.start.x) * lllllllllllllIlllIIIIllIlIIIIIIl.x;
        lllllllllllllIlllIIIIllIIlllllIl = (lllllllllllllIlllIIIIllIlIIIIIII ? lllllllllllllIlllIIIIllIIlllIlIl.min : lllllllllllllIlllIIIIllIIlllIlIl.max);
        double lllllllllllllIlllIIIIllIIllllIll = (lllllllllllllIlllIIIIllIIlllllIl.x - lllllllllllllIlllIIIIllIlIIIIlII.start.x) * lllllllllllllIlllIIIIllIlIIIIIIl.x;
        lllllllllllllIlllIIIIllIIlllllIl = (lllllllllllllIlllIIIIllIIlllllll ? lllllllllllllIlllIIIIllIIlllIlIl.max : lllllllllllllIlllIIIIllIIlllIlIl.min);
        final double lllllllllllllIlllIIIIllIIllllIlI = (lllllllllllllIlllIIIIllIIlllllIl.y - lllllllllllllIlllIIIIllIlIIIIlII.start.y) * lllllllllllllIlllIIIIllIlIIIIIIl.y;
        lllllllllllllIlllIIIIllIIlllllIl = (lllllllllllllIlllIIIIllIIlllllll ? lllllllllllllIlllIIIIllIIlllIlIl.min : lllllllllllllIlllIIIIllIIlllIlIl.max);
        final double lllllllllllllIlllIIIIllIIllllIIl = (lllllllllllllIlllIIIIllIIlllllIl.y - lllllllllllllIlllIIIIllIlIIIIlII.start.y) * lllllllllllllIlllIIIIllIlIIIIIIl.y;
        if (lllllllllllllIlllIIIIllIIlllllII > lllllllllllllIlllIIIIllIIllllIIl || lllllllllllllIlllIIIIllIIllllIlI > lllllllllllllIlllIIIIllIIllllIll) {
            return null;
        }
        if (lllllllllllllIlllIIIIllIIllllIlI > lllllllllllllIlllIIIIllIIlllllII) {
            lllllllllllllIlllIIIIllIIlllllII = lllllllllllllIlllIIIIllIIllllIlI;
        }
        if (lllllllllllllIlllIIIIllIIllllIIl < lllllllllllllIlllIIIIllIIllllIll) {
            lllllllllllllIlllIIIIllIIllllIll = lllllllllllllIlllIIIIllIIllllIIl;
        }
        lllllllllllllIlllIIIIllIIlllllIl = (lllllllllllllIlllIIIIllIIllllllI ? lllllllllllllIlllIIIIllIIlllIlIl.max : lllllllllllllIlllIIIIllIIlllIlIl.min);
        final double lllllllllllllIlllIIIIllIIllllIII = (lllllllllllllIlllIIIIllIIlllllIl.z - lllllllllllllIlllIIIIllIlIIIIlII.start.z) * lllllllllllllIlllIIIIllIlIIIIIIl.z;
        lllllllllllllIlllIIIIllIIlllllIl = (lllllllllllllIlllIIIIllIIllllllI ? lllllllllllllIlllIIIIllIIlllIlIl.min : lllllllllllllIlllIIIIllIIlllIlIl.max);
        final double lllllllllllllIlllIIIIllIIlllIlll = (lllllllllllllIlllIIIIllIIlllllIl.z - lllllllllllllIlllIIIIllIlIIIIlII.start.z) * lllllllllllllIlllIIIIllIlIIIIIIl.z;
        if (lllllllllllllIlllIIIIllIIlllllII > lllllllllllllIlllIIIIllIIlllIlll || lllllllllllllIlllIIIIllIIllllIII > lllllllllllllIlllIIIIllIIllllIll) {
            return null;
        }
        if (lllllllllllllIlllIIIIllIIllllIII > lllllllllllllIlllIIIIllIIlllllII) {
            lllllllllllllIlllIIIIllIIlllllII = lllllllllllllIlllIIIIllIIllllIII;
        }
        if (lllllllllllllIlllIIIIllIIlllIlll < lllllllllllllIlllIIIIllIIllllIll) {
            lllllllllllllIlllIIIIllIIllllIll = lllllllllllllIlllIIIIllIIlllIlll;
        }
        return (lllllllllllllIlllIIIIllIIlllllII <= lllllllllllllIlllIIIIllIlIIIIIlI && lllllllllllllIlllIIIIllIIllllIll > 0.0) ? lllllllllllllIlllIIIIllIlIIIIlII.start.clone().add(lllllllllllllIlllIIIIllIlIIIIlII.dir.clone().normalize().multiply(lllllllllllllIlllIIIIllIIlllllII)) : null;
    }
}
