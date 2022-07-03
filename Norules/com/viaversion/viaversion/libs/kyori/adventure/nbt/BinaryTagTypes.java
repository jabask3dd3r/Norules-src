package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.io.*;
import java.util.*;

public final class BinaryTagTypes
{
    public static final /* synthetic */ BinaryTagType<EndBinaryTag> END;
    
    private BinaryTagTypes() {
    }
    
    static {
        END = BinaryTagType.register(EndBinaryTag.class, (byte)0, lllllllllllllIllIlIIlIllIllllIIl -> EndBinaryTag.get(), null);
        BYTE = BinaryTagType.registerNumeric(ByteBinaryTag.class, (byte)1, lllllllllllllIllIlIIlIllIllllIll -> ByteBinaryTag.of(lllllllllllllIllIlIIlIllIllllIll.readByte()), (lllllllllllllIllIlIIlIlllIIIIIII, lllllllllllllIllIlIIlIllIlllllIl) -> lllllllllllllIllIlIIlIllIlllllIl.writeByte(lllllllllllllIllIlIIlIlllIIIIIII.value()));
        SHORT = BinaryTagType.registerNumeric(ShortBinaryTag.class, (byte)2, lllllllllllllIllIlIIlIlllIIIIlII -> ShortBinaryTag.of(lllllllllllllIllIlIIlIlllIIIIlII.readShort()), (lllllllllllllIllIlIIlIlllIIIIlll, lllllllllllllIllIlIIlIlllIIIIllI) -> lllllllllllllIllIlIIlIlllIIIIllI.writeShort(lllllllllllllIllIlIIlIlllIIIIlll.value()));
        INT = BinaryTagType.registerNumeric(IntBinaryTag.class, (byte)3, lllllllllllllIllIlIIlIlllIIIllIl -> IntBinaryTag.of(lllllllllllllIllIlIIlIlllIIIllIl.readInt()), (lllllllllllllIllIlIIlIlllIIlIIlI, lllllllllllllIllIlIIlIlllIIlIIIl) -> lllllllllllllIllIlIIlIlllIIlIIIl.writeInt(lllllllllllllIllIlIIlIlllIIlIIlI.value()));
        LONG = BinaryTagType.registerNumeric(LongBinaryTag.class, (byte)4, lllllllllllllIllIlIIlIlllIIlIllI -> LongBinaryTag.of(lllllllllllllIllIlIIlIlllIIlIllI.readLong()), (lllllllllllllIllIlIIlIlllIIllIll, lllllllllllllIllIlIIlIlllIIllIlI) -> lllllllllllllIllIlIIlIlllIIllIlI.writeLong(lllllllllllllIllIlIIlIlllIIllIll.value()));
        FLOAT = BinaryTagType.registerNumeric(FloatBinaryTag.class, (byte)5, lllllllllllllIllIlIIlIlllIIlllll -> FloatBinaryTag.of(lllllllllllllIllIlIIlIlllIIlllll.readFloat()), (lllllllllllllIllIlIIlIlllIlIIlII, lllllllllllllIllIlIIlIlllIlIIIIl) -> lllllllllllllIllIlIIlIlllIlIIIIl.writeFloat(lllllllllllllIllIlIIlIlllIlIIlII.value()));
        DOUBLE = BinaryTagType.registerNumeric(DoubleBinaryTag.class, (byte)6, lllllllllllllIllIlIIlIlllIlIlIII -> DoubleBinaryTag.of(lllllllllllllIllIlIIlIlllIlIlIII.readDouble()), (lllllllllllllIllIlIIlIlllIlIllIl, lllllllllllllIllIlIIlIlllIlIllII) -> lllllllllllllIllIlIIlIlllIlIllII.writeDouble(lllllllllllllIllIlIIlIlllIlIllIl.value()));
        final int lllllllllllllIllIlIIlIlllIllIlIl;
        final BinaryTagScope lllllllllllllIllIlIIlIlllIllIlll;
        byte[] lllllllllllllIllIlIIlIlllIlllIII;
        ByteArrayBinaryTag lllllllllllllIllIlIIlIlllIllIIII;
        final byte[] lllllllllllllIllIlIIlIllllIIIIIl;
        BYTE_ARRAY = BinaryTagType.register(ByteArrayBinaryTag.class, (byte)7, lllllllllllllIllIlIIlIlllIllIlII -> {
            lllllllllllllIllIlIIlIlllIllIlIl = lllllllllllllIllIlIIlIlllIllIlII.readInt();
            lllllllllllllIllIlIIlIlllIllIlll = TrackingDataInput.enter(lllllllllllllIllIlIIlIlllIllIlII, lllllllllllllIllIlIIlIlllIllIlIl);
            try {
                lllllllllllllIllIlIIlIlllIlllIII = new byte[lllllllllllllIllIlIIlIlllIllIlIl];
                lllllllllllllIllIlIIlIlllIllIlII.readFully(lllllllllllllIllIlIIlIlllIlllIII);
                lllllllllllllIllIlIIlIlllIllIIII = ByteArrayBinaryTag.of(lllllllllllllIllIlIIlIlllIlllIII);
                if (lllllllllllllIllIlIIlIlllIllIlll != null) {
                    lllllllllllllIllIlIIlIlllIllIlll.close();
                }
                return lllllllllllllIllIlIIlIlllIllIIII;
            }
            catch (Throwable t) {
                if (lllllllllllllIllIlIIlIlllIllIlll != null) {
                    try {
                        lllllllllllllIllIlIIlIlllIllIlll.close();
                    }
                    catch (Throwable lllllllllllllIllIlIIlIlllIllIIII2) {
                        t.addSuppressed((Throwable)lllllllllllllIllIlIIlIlllIllIIII2);
                    }
                }
                throw t;
            }
        }, (lllllllllllllIllIlIIlIllllIIIIII, lllllllllllllIllIlIIlIlllIllllll) -> {
            lllllllllllllIllIlIIlIllllIIIIIl = ByteArrayBinaryTagImpl.value(lllllllllllllIllIlIIlIllllIIIIII);
            lllllllllllllIllIlIIlIlllIllllll.writeInt(lllllllllllllIllIlIIlIllllIIIIIl.length);
            lllllllllllllIllIlIIlIlllIllllll.write(lllllllllllllIllIlIIlIllllIIIIIl);
            return;
        });
        STRING = BinaryTagType.register(StringBinaryTag.class, (byte)8, lllllllllllllIllIlIIlIllllIIlIII -> StringBinaryTag.of(lllllllllllllIllIlIIlIllllIIlIII.readUTF()), (lllllllllllllIllIlIIlIllllIIlIll, lllllllllllllIllIlIIlIllllIIllII) -> lllllllllllllIllIlIIlIllllIIllII.writeUTF(lllllllllllllIllIlIIlIllllIIlIll.value()));
        final BinaryTagType<? extends BinaryTag> lllllllllllllIllIlIIlIllllIlIlll;
        final int lllllllllllllIllIlIIlIllllIlIllI;
        final BinaryTagScope lllllllllllllIllIlIIlIllllIllIIl;
        ArrayList lllllllllllllIllIlIIlIllllIllIlI;
        int lllllllllllllIllIlIIlIllllIllIll;
        ListBinaryTag lllllllllllllIllIlIIlIllllIlIIII;
        final int lllllllllllllIllIlIIlIlllllIIlll;
        final Iterator<BinaryTag> lllllllllllllIllIlIIlIlllllIIIll;
        BinaryTag lllllllllllllIllIlIIlIlllllIlIlI;
        LIST = BinaryTagType.register(ListBinaryTag.class, (byte)9, lllllllllllllIllIlIIlIllllIlIlIl -> {
            lllllllllllllIllIlIIlIllllIlIlll = BinaryTagType.of(lllllllllllllIllIlIIlIllllIlIlIl.readByte());
            lllllllllllllIllIlIIlIllllIlIllI = lllllllllllllIllIlIIlIllllIlIlIl.readInt();
            lllllllllllllIllIlIIlIllllIllIIl = TrackingDataInput.enter(lllllllllllllIllIlIIlIllllIlIlIl, lllllllllllllIllIlIIlIllllIlIllI * 8L);
            try {
                lllllllllllllIllIlIIlIllllIllIlI = new ArrayList<BinaryTag>(lllllllllllllIllIlIIlIllllIlIllI);
                for (lllllllllllllIllIlIIlIllllIllIll = 0; lllllllllllllIllIlIIlIllllIllIll < lllllllllllllIllIlIIlIllllIlIllI; ++lllllllllllllIllIlIIlIllllIllIll) {
                    lllllllllllllIllIlIIlIllllIllIlI.add((BinaryTag)lllllllllllllIllIlIIlIllllIlIlll.read(lllllllllllllIllIlIIlIllllIlIlIl));
                }
                lllllllllllllIllIlIIlIllllIlIIII = ListBinaryTag.of(lllllllllllllIllIlIIlIllllIlIlll, (List<BinaryTag>)lllllllllllllIllIlIIlIllllIllIlI);
                if (lllllllllllllIllIlIIlIllllIllIIl != null) {
                    lllllllllllllIllIlIIlIllllIllIIl.close();
                }
                return lllllllllllllIllIlIIlIllllIlIIII;
            }
            catch (Throwable t2) {
                if (lllllllllllllIllIlIIlIllllIllIIl != null) {
                    try {
                        lllllllllllllIllIlIIlIllllIllIIl.close();
                    }
                    catch (Throwable lllllllllllllIllIlIIlIllllIlIIII2) {
                        t2.addSuppressed((Throwable)lllllllllllllIllIlIIlIllllIlIIII2);
                    }
                }
                throw t2;
            }
        }, (lllllllllllllIllIlIIlIlllllIlIIl, lllllllllllllIllIlIIlIlllllIlIII) -> {
            lllllllllllllIllIlIIlIlllllIlIII.writeByte(lllllllllllllIllIlIIlIlllllIlIIl.elementType().id());
            lllllllllllllIllIlIIlIlllllIIlll = lllllllllllllIllIlIIlIlllllIlIIl.size();
            lllllllllllllIllIlIIlIlllllIlIII.writeInt(lllllllllllllIllIlIIlIlllllIIlll);
            lllllllllllllIllIlIIlIlllllIIIll = lllllllllllllIllIlIIlIlllllIlIIl.iterator();
            while (lllllllllllllIllIlIIlIlllllIIIll.hasNext()) {
                lllllllllllllIllIlIIlIlllllIlIlI = lllllllllllllIllIlIIlIlllllIIIll.next();
                BinaryTagType.write(lllllllllllllIllIlIIlIlllllIlIlI.type(), lllllllllllllIllIlIIlIlllllIlIlI, lllllllllllllIllIlIIlIlllllIlIII);
            }
            return;
        });
        final BinaryTagScope lllllllllllllIllIlIIlIllllllllll;
        HashMap<String, BinaryTag> lllllllllllllIllIlIIllIIIIIIIIlI;
        BinaryTagType<? extends BinaryTag> lllllllllllllIllIlIIllIIIIIIIIIl;
        final Object o;
        String lllllllllllllIllIlIIllIIIIIIIlII;
        BinaryTag lllllllllllllIllIlIIllIIIIIIIIll;
        CompoundBinaryTagImpl lllllllllllllIllIlIIlIllllllIllI;
        final Iterator<Map.Entry<String, ? extends BinaryTag>> lllllllllllllIllIlIIllIIIIIllIll;
        Map.Entry<String, ? extends BinaryTag> lllllllllllllIllIlIIllIIIIlIIIIl;
        BinaryTag lllllllllllllIllIlIIllIIIIlIIlII;
        BinaryTagType<? extends BinaryTag> lllllllllllllIllIlIIllIIIIlIIllI;
        COMPOUND = BinaryTagType.register(CompoundBinaryTag.class, (byte)10, lllllllllllllIllIlIIlIlllllllIll -> {
            lllllllllllllIllIlIIlIllllllllll = TrackingDataInput.enter(lllllllllllllIllIlIIlIlllllllIll);
            try {
                lllllllllllllIllIlIIllIIIIIIIIlI = new HashMap<String, BinaryTag>();
                while (true) {
                    lllllllllllllIllIlIIllIIIIIIIIIl = BinaryTagType.of(lllllllllllllIllIlIIlIlllllllIll.readByte());
                    if (o != BinaryTagTypes.END) {
                        lllllllllllllIllIlIIllIIIIIIIlII = lllllllllllllIllIlIIlIlllllllIll.readUTF();
                        lllllllllllllIllIlIIllIIIIIIIIll = (BinaryTag)lllllllllllllIllIlIIllIIIIIIIIIl.read(lllllllllllllIllIlIIlIlllllllIll);
                        lllllllllllllIllIlIIllIIIIIIIIlI.put(lllllllllllllIllIlIIllIIIIIIIlII, lllllllllllllIllIlIIllIIIIIIIIll);
                    }
                    else {
                        break;
                    }
                }
                lllllllllllllIllIlIIlIllllllIllI = new CompoundBinaryTagImpl(lllllllllllllIllIlIIllIIIIIIIIlI);
                if (lllllllllllllIllIlIIlIllllllllll != null) {
                    lllllllllllllIllIlIIlIllllllllll.close();
                }
                return lllllllllllllIllIlIIlIllllllIllI;
            }
            catch (Throwable lllllllllllllIllIlIIlIlllllllIIl) {
                if (lllllllllllllIllIlIIlIllllllllll != null) {
                    try {
                        lllllllllllllIllIlIIlIllllllllll.close();
                    }
                    catch (Throwable lllllllllllllIllIlIIlIlllllllIII) {
                        ((Throwable)lllllllllllllIllIlIIlIlllllllIIl).addSuppressed((Throwable)lllllllllllllIllIlIIlIlllllllIII);
                    }
                }
                throw lllllllllllllIllIlIIlIlllllllIIl;
            }
        }, (lllllllllllllIllIlIIllIIIIIlllll, lllllllllllllIllIlIIllIIIIIllllI) -> {
            lllllllllllllIllIlIIllIIIIIllIll = lllllllllllllIllIlIIllIIIIIlllll.iterator();
            while (lllllllllllllIllIlIIllIIIIIllIll.hasNext()) {
                lllllllllllllIllIlIIllIIIIlIIIIl = lllllllllllllIllIlIIllIIIIIllIll.next();
                lllllllllllllIllIlIIllIIIIlIIlII = (BinaryTag)lllllllllllllIllIlIIllIIIIlIIIIl.getValue();
                if (lllllllllllllIllIlIIllIIIIlIIlII != null) {
                    lllllllllllllIllIlIIllIIIIlIIllI = lllllllllllllIllIlIIllIIIIlIIlII.type();
                    lllllllllllllIllIlIIllIIIIIllllI.writeByte(lllllllllllllIllIlIIllIIIIlIIllI.id());
                    if (lllllllllllllIllIlIIllIIIIlIIllI != BinaryTagTypes.END) {
                        lllllllllllllIllIlIIllIIIIIllllI.writeUTF(lllllllllllllIllIlIIllIIIIlIIIIl.getKey());
                        BinaryTagType.write(lllllllllllllIllIlIIllIIIIlIIllI, lllllllllllllIllIlIIllIIIIlIIlII, lllllllllllllIllIlIIllIIIIIllllI);
                    }
                    else {
                        continue;
                    }
                }
            }
            lllllllllllllIllIlIIllIIIIIllllI.writeByte(BinaryTagTypes.END.id());
            return;
        });
        final int lllllllllllllIllIlIIllIIIlIIIlII;
        final BinaryTagScope lllllllllllllIllIlIIllIIIlIIIllI;
        int[] lllllllllllllIllIlIIllIIIlIIIlll;
        int lllllllllllllIllIlIIllIIIlIIlIII;
        IntArrayBinaryTag lllllllllllllIllIlIIllIIIIllllIl;
        final int[] lllllllllllllIllIlIIllIIIllIIIIl;
        final int lllllllllllllIllIlIIllIIIllIIIII;
        int lllllllllllllIllIlIIllIIIllIIlII;
        INT_ARRAY = BinaryTagType.register(IntArrayBinaryTag.class, (byte)11, lllllllllllllIllIlIIllIIIlIIIIll -> {
            lllllllllllllIllIlIIllIIIlIIIlII = lllllllllllllIllIlIIllIIIlIIIIll.readInt();
            lllllllllllllIllIlIIllIIIlIIIllI = TrackingDataInput.enter(lllllllllllllIllIlIIllIIIlIIIIll, lllllllllllllIllIlIIllIIIlIIIlII * 4L);
            try {
                lllllllllllllIllIlIIllIIIlIIIlll = new int[lllllllllllllIllIlIIllIIIlIIIlII];
                for (lllllllllllllIllIlIIllIIIlIIlIII = 0; lllllllllllllIllIlIIllIIIlIIlIII < lllllllllllllIllIlIIllIIIlIIIlII; ++lllllllllllllIllIlIIllIIIlIIlIII) {
                    lllllllllllllIllIlIIllIIIlIIIlll[lllllllllllllIllIlIIllIIIlIIlIII] = lllllllllllllIllIlIIllIIIlIIIIll.readInt();
                }
                lllllllllllllIllIlIIllIIIIllllIl = IntArrayBinaryTag.of(lllllllllllllIllIlIIllIIIlIIIlll);
                if (lllllllllllllIllIlIIllIIIlIIIllI != null) {
                    lllllllllllllIllIlIIllIIIlIIIllI.close();
                }
                return lllllllllllllIllIlIIllIIIIllllIl;
            }
            catch (Throwable t3) {
                if (lllllllllllllIllIlIIllIIIlIIIllI != null) {
                    try {
                        lllllllllllllIllIlIIllIIIlIIIllI.close();
                    }
                    catch (Throwable lllllllllllllIllIlIIllIIIIllllIl2) {
                        t3.addSuppressed((Throwable)lllllllllllllIllIlIIllIIIIllllIl2);
                    }
                }
                throw t3;
            }
        }, (lllllllllllllIllIlIIllIIIlIlllll, lllllllllllllIllIlIIllIIIllIIIlI) -> {
            lllllllllllllIllIlIIllIIIllIIIIl = IntArrayBinaryTagImpl.value(lllllllllllllIllIlIIllIIIlIlllll);
            lllllllllllllIllIlIIllIIIllIIIII = lllllllllllllIllIlIIllIIIllIIIIl.length;
            lllllllllllllIllIlIIllIIIllIIIlI.writeInt(lllllllllllllIllIlIIllIIIllIIIII);
            for (lllllllllllllIllIlIIllIIIllIIlII = 0; lllllllllllllIllIlIIllIIIllIIlII < lllllllllllllIllIlIIllIIIllIIIII; ++lllllllllllllIllIlIIllIIIllIIlII) {
                lllllllllllllIllIlIIllIIIllIIIlI.writeInt(lllllllllllllIllIlIIllIIIllIIIIl[lllllllllllllIllIlIIllIIIllIIlII]);
            }
            return;
        });
        final int lllllllllllllIllIlIIllIIIllllIlI;
        final BinaryTagScope lllllllllllllIllIlIIllIIIlllllII;
        long[] lllllllllllllIllIlIIllIIIlllllIl;
        int lllllllllllllIllIlIIllIIIllllllI;
        LongArrayBinaryTag lllllllllllllIllIlIIllIIIlllIIll;
        final long[] lllllllllllllIllIlIIllIIlIIllIll;
        final int lllllllllllllIllIlIIllIIlIIllIlI;
        int lllllllllllllIllIlIIllIIlIIllllI;
        LONG_ARRAY = BinaryTagType.register(LongArrayBinaryTag.class, (byte)12, lllllllllllllIllIlIIllIIIllllIll -> {
            lllllllllllllIllIlIIllIIIllllIlI = lllllllllllllIllIlIIllIIIllllIll.readInt();
            lllllllllllllIllIlIIllIIIlllllII = TrackingDataInput.enter(lllllllllllllIllIlIIllIIIllllIll, lllllllllllllIllIlIIllIIIllllIlI * 8L);
            try {
                lllllllllllllIllIlIIllIIIlllllIl = new long[lllllllllllllIllIlIIllIIIllllIlI];
                for (lllllllllllllIllIlIIllIIIllllllI = 0; lllllllllllllIllIlIIllIIIllllllI < lllllllllllllIllIlIIllIIIllllIlI; ++lllllllllllllIllIlIIllIIIllllllI) {
                    lllllllllllllIllIlIIllIIIlllllIl[lllllllllllllIllIlIIllIIIllllllI] = lllllllllllllIllIlIIllIIIllllIll.readLong();
                }
                lllllllllllllIllIlIIllIIIlllIIll = LongArrayBinaryTag.of(lllllllllllllIllIlIIllIIIlllllIl);
                if (lllllllllllllIllIlIIllIIIlllllII != null) {
                    lllllllllllllIllIlIIllIIIlllllII.close();
                }
                return lllllllllllllIllIlIIllIIIlllIIll;
            }
            catch (Throwable lllllllllllllIllIlIIllIIIlllIlIl) {
                if (lllllllllllllIllIlIIllIIIlllllII != null) {
                    try {
                        lllllllllllllIllIlIIllIIIlllllII.close();
                    }
                    catch (Throwable lllllllllllllIllIlIIllIIIlllIIll2) {
                        ((Throwable)lllllllllllllIllIlIIllIIIlllIlIl).addSuppressed((Throwable)lllllllllllllIllIlIIllIIIlllIIll2);
                    }
                }
                throw lllllllllllllIllIlIIllIIIlllIlIl;
            }
        }, (lllllllllllllIllIlIIllIIlIIllIIl, lllllllllllllIllIlIIllIIlIIlllII) -> {
            lllllllllllllIllIlIIllIIlIIllIll = LongArrayBinaryTagImpl.value(lllllllllllllIllIlIIllIIlIIllIIl);
            lllllllllllllIllIlIIllIIlIIllIlI = lllllllllllllIllIlIIllIIlIIllIll.length;
            lllllllllllllIllIlIIllIIlIIlllII.writeInt(lllllllllllllIllIlIIllIIlIIllIlI);
            for (lllllllllllllIllIlIIllIIlIIllllI = 0; lllllllllllllIllIlIIllIIlIIllllI < lllllllllllllIllIlIIllIIlIIllIlI; ++lllllllllllllIllIlIIllIIlIIllllI) {
                lllllllllllllIllIlIIllIIlIIlllII.writeLong(lllllllllllllIllIlIIllIIlIIllIll[lllllllllllllIllIlIIllIIlIIllllI]);
            }
        });
    }
}
