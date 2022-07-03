package net.minecraft.world.gen.structure;

import net.minecraft.world.*;
import java.util.*;

public class StructureMineshaftStart extends StructureStart
{
    private /* synthetic */ MapGenMineshaft.Type mineShaftType;
    
    public StructureMineshaftStart(final World lllllllllllllIlIlIIIllIIlIIlIlIl, final Random lllllllllllllIlIlIIIllIIlIlIIIll, final int lllllllllllllIlIlIIIllIIlIIlIIIl, final int lllllllllllllIlIlIIIllIIlIIIllll, final MapGenMineshaft.Type lllllllllllllIlIlIIIllIIlIIIllIl) {
        super(lllllllllllllIlIlIIIllIIlIIlIIIl, lllllllllllllIlIlIIIllIIlIIIllll);
        this.mineShaftType = lllllllllllllIlIlIIIllIIlIIIllIl;
        final StructureMineshaftPieces.Room lllllllllllllIlIlIIIllIIlIIlllIl = new StructureMineshaftPieces.Room(0, lllllllllllllIlIlIIIllIIlIlIIIll, (lllllllllllllIlIlIIIllIIlIIlIIIl << 4) + 2, (lllllllllllllIlIlIIIllIIlIIIllll << 4) + 2, this.mineShaftType);
        this.components.add(lllllllllllllIlIlIIIllIIlIIlllIl);
        lllllllllllllIlIlIIIllIIlIIlllIl.buildComponent(lllllllllllllIlIlIIIllIIlIIlllIl, this.components, lllllllllllllIlIlIIIllIIlIlIIIll);
        this.updateBoundingBox();
        if (lllllllllllllIlIlIIIllIIlIIIllIl == MapGenMineshaft.Type.MESA) {
            final int lllllllllllllIlIlIIIllIIlIIllIll = -5;
            final int lllllllllllllIlIlIIIllIIlIIllIIl = lllllllllllllIlIlIIIllIIlIIlIlIl.getSeaLevel() - this.boundingBox.maxY + this.boundingBox.getYSize() / 2 + 5;
            this.boundingBox.offset(0, lllllllllllllIlIlIIIllIIlIIllIIl, 0);
            for (final StructureComponent lllllllllllllIlIlIIIllIIlIIllIII : this.components) {
                lllllllllllllIlIlIIIllIIlIIllIII.offset(0, lllllllllllllIlIlIIIllIIlIIllIIl, 0);
            }
        }
        else {
            this.markAvailableHeight(lllllllllllllIlIlIIIllIIlIIlIlIl, lllllllllllllIlIlIIIllIIlIlIIIll, 10);
        }
    }
    
    public StructureMineshaftStart() {
    }
}
