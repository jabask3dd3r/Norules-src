package org.yaml.snakeyaml.serializer;

import org.yaml.snakeyaml.nodes.*;
import java.text.*;

public class NumberAnchorGenerator implements AnchorGenerator
{
    private /* synthetic */ int lastAnchorId;
    
    @Override
    public String nextAnchor(final Node llllllllllllllIllllIIllIIIIlllIl) {
        ++this.lastAnchorId;
        final NumberFormat llllllllllllllIllllIIllIIIIlllII = NumberFormat.getNumberInstance();
        llllllllllllllIllllIIllIIIIlllII.setMinimumIntegerDigits(3);
        llllllllllllllIllllIIllIIIIlllII.setMaximumFractionDigits(0);
        llllllllllllllIllllIIllIIIIlllII.setGroupingUsed(false);
        final String llllllllllllllIllllIIllIIIIllIll = llllllllllllllIllllIIllIIIIlllII.format(this.lastAnchorId);
        return String.valueOf(new StringBuilder().append("id").append(llllllllllllllIllllIIllIIIIllIll));
    }
    
    public NumberAnchorGenerator(final int llllllllllllllIllllIIllIIIlIIIlI) {
        this.lastAnchorId = 0;
        this.lastAnchorId = llllllllllllllIllllIIllIIIlIIIlI;
    }
}
