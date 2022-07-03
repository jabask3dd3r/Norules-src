package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types;

import com.viaversion.viaversion.api.type.types.minecraft.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import java.util.*;

public class MetadataListType extends MetaListTypeTemplate
{
    private /* synthetic */ MetadataType metadataType;
    
    public MetadataListType() {
        this.metadataType = new MetadataType();
    }
    
    @Override
    public void write(final ByteBuf llIllIllIIlIllI, final List<Metadata> llIllIllIIlIlIl) throws Exception {
        for (final Metadata llIllIllIIllIII : llIllIllIIlIlIl) {
            Types1_7_6_10.METADATA.write(llIllIllIIlIllI, llIllIllIIllIII);
        }
        if (llIllIllIIlIlIl.isEmpty()) {
            Types1_7_6_10.METADATA.write(llIllIllIIlIllI, new Metadata(0, MetaType1_7_6_10.Byte, 0));
        }
        llIllIllIIlIllI.writeByte(127);
    }
    
    private Metadata find(final int llIllIllIlIIIIl, final String llIllIllIlIIIll, final List<Metadata> llIllIllIlIIIlI) {
        for (final Metadata llIllIllIlIIllI : llIllIllIlIIIlI) {
            if (llIllIllIlIIllI.id() == llIllIllIlIIIIl && llIllIllIlIIllI.metaType().toString().equals(llIllIllIlIIIll)) {
                return llIllIllIlIIllI;
            }
        }
        return null;
    }
    
    @Override
    public List<Metadata> read(final ByteBuf llIllIllIllIIlI) throws Exception {
        final ArrayList<Metadata> llIllIllIllIIIl = new ArrayList<Metadata>();
        Metadata llIllIllIllIIII;
        do {
            llIllIllIllIIII = Types1_7_6_10.METADATA.read(llIllIllIllIIlI);
            if (llIllIllIllIIII != null) {
                llIllIllIllIIIl.add(llIllIllIllIIII);
            }
        } while (llIllIllIllIIII != null);
        if (this.find(2, "Slot", llIllIllIllIIIl) != null && this.find(8, "Slot", llIllIllIllIIIl) != null) {
            llIllIllIllIIIl.removeIf(llIllIllIIIIIlI -> llIllIllIIIIIlI.id() == 2 || llIllIllIIIIIlI.id() == 3);
        }
        return llIllIllIllIIIl;
    }
}
