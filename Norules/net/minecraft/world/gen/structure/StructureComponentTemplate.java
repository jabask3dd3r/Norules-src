package net.minecraft.world.gen.structure;

import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.world.gen.structure.template.*;
import java.util.*;

public abstract class StructureComponentTemplate extends StructureComponent
{
    protected /* synthetic */ PlacementSettings placeSettings;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    protected /* synthetic */ Template template;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    private static final /* synthetic */ PlacementSettings DEFAULT_PLACE_SETTINGS;
    protected /* synthetic */ BlockPos templatePosition;
    
    @Override
    public void offset(final int lllllllllllllllIlllllllIIllIIlll, final int lllllllllllllllIlllllllIIllIIllI, final int lllllllllllllllIlllllllIIllIlIIl) {
        super.offset(lllllllllllllllIlllllllIIllIIlll, lllllllllllllllIlllllllIIllIIllI, lllllllllllllllIlllllllIIllIlIIl);
        this.templatePosition = this.templatePosition.add(lllllllllllllllIlllllllIIllIIlll, lllllllllllllllIlllllllIIllIIllI, lllllllllllllllIlllllllIIllIlIIl);
    }
    
    protected abstract void handleDataMarker(final String p0, final BlockPos p1, final World p2, final Random p3, final StructureBoundingBox p4);
    
    static {
        DEFAULT_PLACE_SETTINGS = new PlacementSettings();
    }
    
    private void setBoundingBoxFromTemplate() {
        final Rotation lllllllllllllllIlllllllIIllllIll = this.placeSettings.getRotation();
        final BlockPos lllllllllllllllIlllllllIIllllIlI = this.template.transformedSize(lllllllllllllllIlllllllIIllllIll);
        final Mirror lllllllllllllllIlllllllIIllllIIl = this.placeSettings.getMirror();
        this.boundingBox = new StructureBoundingBox(0, 0, 0, lllllllllllllllIlllllllIIllllIlI.getX(), lllllllllllllllIlllllllIIllllIlI.getY() - 1, lllllllllllllllIlllllllIIllllIlI.getZ());
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllllllIlllllllIIllllIll.ordinal()]) {
            case 2: {
                this.boundingBox.offset(-lllllllllllllllIlllllllIIllllIlI.getX(), 0, 0);
                break;
            }
            case 4: {
                this.boundingBox.offset(0, 0, -lllllllllllllllIlllllllIIllllIlI.getZ());
                break;
            }
            case 3: {
                this.boundingBox.offset(-lllllllllllllllIlllllllIIllllIlI.getX(), 0, -lllllllllllllllIlllllllIIllllIlI.getZ());
                break;
            }
        }
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[lllllllllllllllIlllllllIIllllIIl.ordinal()]) {
            case 3: {
                BlockPos lllllllllllllllIlllllllIIllllIII = BlockPos.ORIGIN;
                if (lllllllllllllllIlllllllIIllllIll != Rotation.CLOCKWISE_90 && lllllllllllllllIlllllllIIllllIll != Rotation.COUNTERCLOCKWISE_90) {
                    if (lllllllllllllllIlllllllIIllllIll == Rotation.CLOCKWISE_180) {
                        lllllllllllllllIlllllllIIllllIII = lllllllllllllllIlllllllIIllllIII.offset(EnumFacing.EAST, lllllllllllllllIlllllllIIllllIlI.getX());
                    }
                    else {
                        lllllllllllllllIlllllllIIllllIII = lllllllllllllllIlllllllIIllllIII.offset(EnumFacing.WEST, lllllllllllllllIlllllllIIllllIlI.getX());
                    }
                }
                else {
                    lllllllllllllllIlllllllIIllllIII = lllllllllllllllIlllllllIIllllIII.offset(lllllllllllllllIlllllllIIllllIll.rotate(EnumFacing.WEST), lllllllllllllllIlllllllIIllllIlI.getZ());
                }
                this.boundingBox.offset(lllllllllllllllIlllllllIIllllIII.getX(), 0, lllllllllllllllIlllllllIIllllIII.getZ());
                break;
            }
            case 2: {
                BlockPos lllllllllllllllIlllllllIIlllIlll = BlockPos.ORIGIN;
                if (lllllllllllllllIlllllllIIllllIll != Rotation.CLOCKWISE_90 && lllllllllllllllIlllllllIIllllIll != Rotation.COUNTERCLOCKWISE_90) {
                    if (lllllllllllllllIlllllllIIllllIll == Rotation.CLOCKWISE_180) {
                        lllllllllllllllIlllllllIIlllIlll = lllllllllllllllIlllllllIIlllIlll.offset(EnumFacing.SOUTH, lllllllllllllllIlllllllIIllllIlI.getZ());
                    }
                    else {
                        lllllllllllllllIlllllllIIlllIlll = lllllllllllllllIlllllllIIlllIlll.offset(EnumFacing.NORTH, lllllllllllllllIlllllllIIllllIlI.getZ());
                    }
                }
                else {
                    lllllllllllllllIlllllllIIlllIlll = lllllllllllllllIlllllllIIlllIlll.offset(lllllllllllllllIlllllllIIllllIll.rotate(EnumFacing.NORTH), lllllllllllllllIlllllllIIllllIlI.getX());
                }
                this.boundingBox.offset(lllllllllllllllIlllllllIIlllIlll.getX(), 0, lllllllllllllllIlllllllIIlllIlll.getZ());
                break;
            }
        }
        this.boundingBox.offset(this.templatePosition.getX(), this.templatePosition.getY(), this.templatePosition.getZ());
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = StructureComponentTemplate.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final Exception lllllllllllllllIlllllllIIllIIIIl = (Object)new int[Mirror.values().length];
        try {
            lllllllllllllllIlllllllIIllIIIIl[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllIlllllllIIllIIIIl[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllIlllllllIIllIIIIl[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return StructureComponentTemplate.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllllllIlllllllIIllIIIIl;
    }
    
    public StructureComponentTemplate(final int lllllllllllllllIlllllllIlllIIllI) {
        super(lllllllllllllllIlllllllIlllIIllI);
        this.placeSettings = StructureComponentTemplate.DEFAULT_PLACE_SETTINGS.setIgnoreEntities(true).setReplacedBlock(Blocks.AIR);
    }
    
    @Override
    protected void writeStructureToNBT(final NBTTagCompound lllllllllllllllIlllllllIllIIIllI) {
        lllllllllllllllIlllllllIllIIIllI.setInteger("TPX", this.templatePosition.getX());
        lllllllllllllllIlllllllIllIIIllI.setInteger("TPY", this.templatePosition.getY());
        lllllllllllllllIlllllllIllIIIllI.setInteger("TPZ", this.templatePosition.getZ());
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = StructureComponentTemplate.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final float lllllllllllllllIlllllllIIllIIIll = (Object)new int[Rotation.values().length];
        try {
            lllllllllllllllIlllllllIIllIIIll[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllIlllllllIIllIIIll[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllIlllllllIIllIIIll[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllIlllllllIIllIIIll[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return StructureComponentTemplate.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllllllIlllllllIIllIIIll;
    }
    
    public StructureComponentTemplate() {
        this.placeSettings = StructureComponentTemplate.DEFAULT_PLACE_SETTINGS.setIgnoreEntities(true).setReplacedBlock(Blocks.AIR);
    }
    
    @Override
    protected void readStructureFromNBT(final NBTTagCompound lllllllllllllllIlllllllIlIllllII, final TemplateManager lllllllllllllllIlllllllIlIlllIlI) {
        this.templatePosition = new BlockPos(lllllllllllllllIlllllllIlIllllII.getInteger("TPX"), lllllllllllllllIlllllllIlIllllII.getInteger("TPY"), lllllllllllllllIlllllllIlIllllII.getInteger("TPZ"));
    }
    
    @Override
    public boolean addComponentParts(final World lllllllllllllllIlllllllIlIIllIlI, final Random lllllllllllllllIlllllllIlIlIIlII, final StructureBoundingBox lllllllllllllllIlllllllIlIIlIllI) {
        this.placeSettings.setBoundingBox(lllllllllllllllIlllllllIlIIlIllI);
        this.template.addBlocksToWorld(lllllllllllllllIlllllllIlIIllIlI, this.templatePosition, this.placeSettings, 18);
        final Map<BlockPos, String> lllllllllllllllIlllllllIlIlIIIII = this.template.getDataBlocks(this.templatePosition, this.placeSettings);
        for (final Map.Entry<BlockPos, String> lllllllllllllllIlllllllIlIIllllI : lllllllllllllllIlllllllIlIlIIIII.entrySet()) {
            final String lllllllllllllllIlllllllIlIIlllII = lllllllllllllllIlllllllIlIIllllI.getValue();
            this.handleDataMarker(lllllllllllllllIlllllllIlIIlllII, lllllllllllllllIlllllllIlIIllllI.getKey(), lllllllllllllllIlllllllIlIIllIlI, lllllllllllllllIlllllllIlIlIIlII, lllllllllllllllIlllllllIlIIlIllI);
        }
        return true;
    }
    
    protected void setup(final Template lllllllllllllllIlllllllIllIllIIl, final BlockPos lllllllllllllllIlllllllIllIlIIII, final PlacementSettings lllllllllllllllIlllllllIllIIlllI) {
        this.template = lllllllllllllllIlllllllIllIllIIl;
        this.setCoordBaseMode(EnumFacing.NORTH);
        this.templatePosition = lllllllllllllllIlllllllIllIlIIII;
        this.placeSettings = lllllllllllllllIlllllllIllIIlllI;
        this.setBoundingBoxFromTemplate();
    }
}
