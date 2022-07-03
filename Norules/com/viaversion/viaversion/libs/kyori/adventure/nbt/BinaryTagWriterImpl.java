package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.util.*;
import org.jetbrains.annotations.*;
import java.io.*;
import java.nio.file.*;

final class BinaryTagWriterImpl implements BinaryTagIO.Writer
{
    @Override
    public void writeNamed(final Map.Entry<String, CompoundBinaryTag> lllllllllllllIIIlIIIIIIlIIlIllII, @NotNull final OutputStream lllllllllllllIIIlIIIIIIlIIlIlIlI, final BinaryTagIO.Compression lllllllllllllIIIlIIIIIIlIIlIlIll) throws IOException {
        final DataOutputStream lllllllllllllIIIlIIIIIIlIIlIlIIl = new DataOutputStream(new BufferedOutputStream(lllllllllllllIIIlIIIIIIlIIlIlIll.compress(IOStreamUtil.closeShield(lllllllllllllIIIlIIIIIIlIIlIlIlI))));
        try {
            this.writeNamed(lllllllllllllIIIlIIIIIIlIIlIllII, (DataOutput)lllllllllllllIIIlIIIIIIlIIlIlIIl);
            lllllllllllllIIIlIIIIIIlIIlIlIIl.close();
        }
        catch (Throwable lllllllllllllIIIlIIIIIIlIIIlllll) {
            try {
                lllllllllllllIIIlIIIIIIlIIlIlIIl.close();
            }
            catch (Throwable lllllllllllllIIIlIIIIIIlIIIllllI) {
                ((Throwable)lllllllllllllIIIlIIIIIIlIIIlllll).addSuppressed((Throwable)lllllllllllllIIIlIIIIIIlIIIllllI);
            }
            throw lllllllllllllIIIlIIIIIIlIIIlllll;
        }
    }
    
    static {
        INSTANCE = new BinaryTagWriterImpl();
    }
    
    @Override
    public void writeNamed(final Map.Entry<String, CompoundBinaryTag> lllllllllllllIIIlIIIIIIlIlIIIIIl, @NotNull final Path lllllllllllllIIIlIIIIIIlIlIIIIlI, final BinaryTagIO.Compression lllllllllllllIIIlIIIIIIlIlIIIIII) throws IOException {
        final OutputStream lllllllllllllIIIlIIIIIIlIIllllll = Files.newOutputStream(lllllllllllllIIIlIIIIIIlIlIIIIlI, new OpenOption[0]);
        try {
            this.writeNamed(lllllllllllllIIIlIIIIIIlIlIIIIIl, lllllllllllllIIIlIIIIIIlIIllllll, lllllllllllllIIIlIIIIIIlIlIIIIII);
            if (lllllllllllllIIIlIIIIIIlIIllllll != null) {
                lllllllllllllIIIlIIIIIIlIIllllll.close();
            }
        }
        catch (Throwable lllllllllllllIIIlIIIIIIlIIllIlIl) {
            if (lllllllllllllIIIlIIIIIIlIIllllll != null) {
                try {
                    lllllllllllllIIIlIIIIIIlIIllllll.close();
                }
                catch (Throwable lllllllllllllIIIlIIIIIIlIIllIlII) {
                    ((Throwable)lllllllllllllIIIlIIIIIIlIIllIlIl).addSuppressed((Throwable)lllllllllllllIIIlIIIIIIlIIllIlII);
                }
            }
            throw lllllllllllllIIIlIIIIIIlIIllIlIl;
        }
    }
    
    @Override
    public void write(@NotNull final CompoundBinaryTag lllllllllllllIIIlIIIIIIlIlllIllI, @NotNull final Path lllllllllllllIIIlIIIIIIlIlllIlIl, final BinaryTagIO.Compression lllllllllllllIIIlIIIIIIlIlllIlll) throws IOException {
        final OutputStream lllllllllllllIIIlIIIIIIlIlllIlII = Files.newOutputStream(lllllllllllllIIIlIIIIIIlIlllIlIl, new OpenOption[0]);
        try {
            this.write(lllllllllllllIIIlIIIIIIlIlllIllI, lllllllllllllIIIlIIIIIIlIlllIlII, lllllllllllllIIIlIIIIIIlIlllIlll);
            if (lllllllllllllIIIlIIIIIIlIlllIlII != null) {
                lllllllllllllIIIlIIIIIIlIlllIlII.close();
            }
        }
        catch (Throwable lllllllllllllIIIlIIIIIIlIllIlIlI) {
            if (lllllllllllllIIIlIIIIIIlIlllIlII != null) {
                try {
                    lllllllllllllIIIlIIIIIIlIlllIlII.close();
                }
                catch (Throwable lllllllllllllIIIlIIIIIIlIllIlIIl) {
                    ((Throwable)lllllllllllllIIIlIIIIIIlIllIlIlI).addSuppressed((Throwable)lllllllllllllIIIlIIIIIIlIllIlIIl);
                }
            }
            throw lllllllllllllIIIlIIIIIIlIllIlIlI;
        }
    }
    
    @Override
    public void write(@NotNull final CompoundBinaryTag lllllllllllllIIIlIIIIIIlIllIIIII, @NotNull final OutputStream lllllllllllllIIIlIIIIIIlIllIIIIl, final BinaryTagIO.Compression lllllllllllllIIIlIIIIIIlIlIlllll) throws IOException {
        final DataOutputStream lllllllllllllIIIlIIIIIIlIlIllllI = new DataOutputStream(new BufferedOutputStream(lllllllllllllIIIlIIIIIIlIlIlllll.compress(IOStreamUtil.closeShield(lllllllllllllIIIlIIIIIIlIllIIIIl))));
        try {
            this.write(lllllllllllllIIIlIIIIIIlIllIIIII, (DataOutput)lllllllllllllIIIlIIIIIIlIlIllllI);
            lllllllllllllIIIlIIIIIIlIlIllllI.close();
        }
        catch (Throwable lllllllllllllIIIlIIIIIIlIlIlIlII) {
            try {
                lllllllllllllIIIlIIIIIIlIlIllllI.close();
            }
            catch (Throwable lllllllllllllIIIlIIIIIIlIlIlIIll) {
                ((Throwable)lllllllllllllIIIlIIIIIIlIlIlIlII).addSuppressed((Throwable)lllllllllllllIIIlIIIIIIlIlIlIIll);
            }
            throw lllllllllllllIIIlIIIIIIlIlIlIlII;
        }
    }
    
    @Override
    public void writeNamed(final Map.Entry<String, CompoundBinaryTag> lllllllllllllIIIlIIIIIIlIIIllIll, @NotNull final DataOutput lllllllllllllIIIlIIIIIIlIIIllIlI) throws IOException {
        lllllllllllllIIIlIIIIIIlIIIllIlI.writeByte(BinaryTagTypes.COMPOUND.id());
        lllllllllllllIIIlIIIIIIlIIIllIlI.writeUTF(lllllllllllllIIIlIIIIIIlIIIllIll.getKey());
        BinaryTagTypes.COMPOUND.write(lllllllllllllIIIlIIIIIIlIIIllIll.getValue(), lllllllllllllIIIlIIIIIIlIIIllIlI);
    }
    
    @Override
    public void write(@NotNull final CompoundBinaryTag lllllllllllllIIIlIIIIIIlIlIlIIII, @NotNull final DataOutput lllllllllllllIIIlIIIIIIlIlIIllll) throws IOException {
        lllllllllllllIIIlIIIIIIlIlIIllll.writeByte(BinaryTagTypes.COMPOUND.id());
        lllllllllllllIIIlIIIIIIlIlIIllll.writeUTF("");
        BinaryTagTypes.COMPOUND.write(lllllllllllllIIIlIIIIIIlIlIlIIII, lllllllllllllIIIlIIIIIIlIlIIllll);
    }
}
