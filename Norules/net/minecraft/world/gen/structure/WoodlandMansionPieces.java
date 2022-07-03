package net.minecraft.world.gen.structure;

import net.minecraft.util.math.*;
import javax.annotation.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.server.*;
import net.minecraft.world.gen.structure.template.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;

public class WoodlandMansionPieces
{
    public static void func_191152_a(final TemplateManager lllllllllllllIlIlllllIlIIIIIllll, final BlockPos lllllllllllllIlIlllllIlIIIIlIlIl, final Rotation lllllllllllllIlIlllllIlIIIIlIlII, final List<MansionTemplate> lllllllllllllIlIlllllIlIIIIlIIll, final Random lllllllllllllIlIlllllIlIIIIlIIlI) {
        final Grid lllllllllllllIlIlllllIlIIIIlIIIl = new Grid(lllllllllllllIlIlllllIlIIIIlIIlI);
        final Placer lllllllllllllIlIlllllIlIIIIlIIII = new Placer(lllllllllllllIlIlllllIlIIIIIllll, lllllllllllllIlIlllllIlIIIIlIIlI);
        lllllllllllllIlIlllllIlIIIIlIIII.func_191125_a(lllllllllllllIlIlllllIlIIIIlIlIl, lllllllllllllIlIlllllIlIIIIlIlII, lllllllllllllIlIlllllIlIIIIlIIll, lllllllllllllIlIlllllIlIIIIlIIIl);
    }
    
    public static void func_191153_a() {
        MapGenStructureIO.registerStructureComponent(MansionTemplate.class, "WMP");
    }
    
    static class SecondFloor extends RoomCollection
    {
        @Override
        public String func_191102_c(final Random lllllllllllllIlIlIlIIllIlIIIIIlI) {
            return String.valueOf(new StringBuilder("1x2_se").append(lllllllllllllIlIlIlIIllIlIIIIIlI.nextInt(1) + 1));
        }
        
        @Override
        public String func_191103_e(final Random lllllllllllllIlIlIlIIllIIllllIll) {
            return "2x2_s1";
        }
        
        @Override
        public String func_191100_a(final Random lllllllllllllIlIlIlIIllIlIIIllIl, final boolean lllllllllllllIlIlIlIIllIlIIIllII) {
            return lllllllllllllIlIlIlIIllIlIIIllII ? "1x2_c_stairs" : String.valueOf(new StringBuilder("1x2_c").append(lllllllllllllIlIlIlIIllIlIIIllIl.nextInt(4) + 1));
        }
        
        @Override
        public String func_191098_b(final Random lllllllllllllIlIlIlIIllIlIIIlIII, final boolean lllllllllllllIlIlIlIIllIlIIIIlIl) {
            return lllllllllllllIlIlIlIIllIlIIIIlIl ? "1x2_d_stairs" : String.valueOf(new StringBuilder("1x2_d").append(lllllllllllllIlIlIlIIllIlIIIlIII.nextInt(5) + 1));
        }
        
        private SecondFloor() {
            super(null);
        }
        
        @Override
        public String func_191101_d(final Random lllllllllllllIlIlIlIIllIIllllllI) {
            return String.valueOf(new StringBuilder("2x2_b").append(lllllllllllllIlIlIlIIllIIllllllI.nextInt(5) + 1));
        }
        
        @Override
        public String func_191104_a(final Random lllllllllllllIlIlIlIIllIlIIlIlll) {
            return String.valueOf(new StringBuilder("1x1_b").append(lllllllllllllIlIlIlIIllIlIIlIlll.nextInt(4) + 1));
        }
        
        @Override
        public String func_191099_b(final Random lllllllllllllIlIlIlIIllIlIIlIlII) {
            return String.valueOf(new StringBuilder("1x1_as").append(lllllllllllllIlIlIlIIllIlIIlIlII.nextInt(4) + 1));
        }
    }
    
    abstract static class RoomCollection
    {
        private RoomCollection() {
        }
        
        public abstract String func_191104_a(final Random p0);
        
        public abstract String func_191099_b(final Random p0);
        
        public abstract String func_191100_a(final Random p0, final boolean p1);
        
        public abstract String func_191103_e(final Random p0);
        
        public abstract String func_191098_b(final Random p0, final boolean p1);
        
        public abstract String func_191102_c(final Random p0);
        
        public abstract String func_191101_d(final Random p0);
    }
    
    static class ThirdFloor extends SecondFloor
    {
        private ThirdFloor() {
            super(null, null);
        }
    }
    
    static class FirstFloor extends RoomCollection
    {
        private FirstFloor() {
            super(null);
        }
        
        @Override
        public String func_191100_a(final Random lllllllllllllIlIlIllIllIIIlllIII, final boolean lllllllllllllIlIlIllIllIIIlllIIl) {
            return String.valueOf(new StringBuilder("1x2_a").append(lllllllllllllIlIlIllIllIIIlllIII.nextInt(9) + 1));
        }
        
        @Override
        public String func_191098_b(final Random lllllllllllllIlIlIllIllIIIllIlIl, final boolean lllllllllllllIlIlIllIllIIIllIlII) {
            return String.valueOf(new StringBuilder("1x2_b").append(lllllllllllllIlIlIllIllIIIllIlIl.nextInt(5) + 1));
        }
        
        @Override
        public String func_191099_b(final Random lllllllllllllIlIlIllIllIIIllllIl) {
            return String.valueOf(new StringBuilder("1x1_as").append(lllllllllllllIlIlIllIllIIIllllIl.nextInt(4) + 1));
        }
        
        @Override
        public String func_191102_c(final Random lllllllllllllIlIlIllIllIIIlIllll) {
            return String.valueOf(new StringBuilder("1x2_s").append(lllllllllllllIlIlIllIllIIIlIllll.nextInt(2) + 1));
        }
        
        @Override
        public String func_191101_d(final Random lllllllllllllIlIlIllIllIIIlIllII) {
            return String.valueOf(new StringBuilder("2x2_a").append(lllllllllllllIlIlIllIllIIIlIllII.nextInt(4) + 1));
        }
        
        @Override
        public String func_191103_e(final Random lllllllllllllIlIlIllIllIIIlIlIIl) {
            return "2x2_s1";
        }
        
        @Override
        public String func_191104_a(final Random lllllllllllllIlIlIllIllIIlIIIIIl) {
            return String.valueOf(new StringBuilder("1x1_a").append(lllllllllllllIlIlIllIllIIlIIIIIl.nextInt(5) + 1));
        }
    }
    
    static class Placer
    {
        private final /* synthetic */ TemplateManager field_191134_a;
        private /* synthetic */ int field_191137_d;
        private /* synthetic */ int field_191136_c;
        private final /* synthetic */ Random field_191135_b;
        
        private void func_191127_a(final List<MansionTemplate> llllllllllllllllllIIlIlIlIIlIllI, final BlockPos llllllllllllllllllIIlIlIlIIIlIIl, final Rotation llllllllllllllllllIIlIlIlIIIlIII, final EnumFacing llllllllllllllllllIIlIlIlIIlIIll, final EnumFacing llllllllllllllllllIIlIlIlIIIIllI, final RoomCollection llllllllllllllllllIIlIlIlIIlIIIl) {
            int llllllllllllllllllIIlIlIlIIlIIII = 0;
            int llllllllllllllllllIIlIlIlIIIllll = 0;
            Rotation llllllllllllllllllIIlIlIlIIIlllI = llllllllllllllllllIIlIlIlIIIlIII;
            Mirror llllllllllllllllllIIlIlIlIIIllIl = Mirror.NONE;
            if (llllllllllllllllllIIlIlIlIIIIllI == EnumFacing.EAST && llllllllllllllllllIIlIlIlIIlIIll == EnumFacing.SOUTH) {
                llllllllllllllllllIIlIlIlIIlIIII = -7;
            }
            else if (llllllllllllllllllIIlIlIlIIIIllI == EnumFacing.EAST && llllllllllllllllllIIlIlIlIIlIIll == EnumFacing.NORTH) {
                llllllllllllllllllIIlIlIlIIlIIII = -7;
                llllllllllllllllllIIlIlIlIIIllll = 6;
                llllllllllllllllllIIlIlIlIIIllIl = Mirror.LEFT_RIGHT;
            }
            else if (llllllllllllllllllIIlIlIlIIIIllI == EnumFacing.NORTH && llllllllllllllllllIIlIlIlIIlIIll == EnumFacing.EAST) {
                llllllllllllllllllIIlIlIlIIlIIII = 1;
                llllllllllllllllllIIlIlIlIIIllll = 14;
                llllllllllllllllllIIlIlIlIIIlllI = llllllllllllllllllIIlIlIlIIIlIII.add(Rotation.COUNTERCLOCKWISE_90);
            }
            else if (llllllllllllllllllIIlIlIlIIIIllI == EnumFacing.NORTH && llllllllllllllllllIIlIlIlIIlIIll == EnumFacing.WEST) {
                llllllllllllllllllIIlIlIlIIlIIII = 7;
                llllllllllllllllllIIlIlIlIIIllll = 14;
                llllllllllllllllllIIlIlIlIIIlllI = llllllllllllllllllIIlIlIlIIIlIII.add(Rotation.COUNTERCLOCKWISE_90);
                llllllllllllllllllIIlIlIlIIIllIl = Mirror.LEFT_RIGHT;
            }
            else if (llllllllllllllllllIIlIlIlIIIIllI == EnumFacing.SOUTH && llllllllllllllllllIIlIlIlIIlIIll == EnumFacing.WEST) {
                llllllllllllllllllIIlIlIlIIlIIII = 7;
                llllllllllllllllllIIlIlIlIIIllll = -8;
                llllllllllllllllllIIlIlIlIIIlllI = llllllllllllllllllIIlIlIlIIIlIII.add(Rotation.CLOCKWISE_90);
            }
            else if (llllllllllllllllllIIlIlIlIIIIllI == EnumFacing.SOUTH && llllllllllllllllllIIlIlIlIIlIIll == EnumFacing.EAST) {
                llllllllllllllllllIIlIlIlIIlIIII = 1;
                llllllllllllllllllIIlIlIlIIIllll = -8;
                llllllllllllllllllIIlIlIlIIIlllI = llllllllllllllllllIIlIlIlIIIlIII.add(Rotation.CLOCKWISE_90);
                llllllllllllllllllIIlIlIlIIIllIl = Mirror.LEFT_RIGHT;
            }
            else if (llllllllllllllllllIIlIlIlIIIIllI == EnumFacing.WEST && llllllllllllllllllIIlIlIlIIlIIll == EnumFacing.NORTH) {
                llllllllllllllllllIIlIlIlIIlIIII = 15;
                llllllllllllllllllIIlIlIlIIIllll = 6;
                llllllllllllllllllIIlIlIlIIIlllI = llllllllllllllllllIIlIlIlIIIlIII.add(Rotation.CLOCKWISE_180);
            }
            else if (llllllllllllllllllIIlIlIlIIIIllI == EnumFacing.WEST && llllllllllllllllllIIlIlIlIIlIIll == EnumFacing.SOUTH) {
                llllllllllllllllllIIlIlIlIIlIIII = 15;
                llllllllllllllllllIIlIlIlIIIllIl = Mirror.FRONT_BACK;
            }
            BlockPos llllllllllllllllllIIlIlIlIIIllII = llllllllllllllllllIIlIlIlIIIlIIl.offset(llllllllllllllllllIIlIlIlIIIlIII.rotate(EnumFacing.EAST), llllllllllllllllllIIlIlIlIIlIIII);
            llllllllllllllllllIIlIlIlIIIllII = llllllllllllllllllIIlIlIlIIIllII.offset(llllllllllllllllllIIlIlIlIIIlIII.rotate(EnumFacing.SOUTH), llllllllllllllllllIIlIlIlIIIllll);
            llllllllllllllllllIIlIlIlIIlIllI.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlIlIIlIIIl.func_191101_d(this.field_191135_b), llllllllllllllllllIIlIlIlIIIllII, llllllllllllllllllIIlIlIlIIIlllI, llllllllllllllllllIIlIlIlIIIllIl));
        }
        
        private void func_191128_a(final List<MansionTemplate> llllllllllllllllllIIlIlIIllllIII, final BlockPos llllllllllllllllllIIlIlIIlllIIIl, final Rotation llllllllllllllllllIIlIlIIlllIIII, final RoomCollection llllllllllllllllllIIlIlIIllIllll) {
            final BlockPos llllllllllllllllllIIlIlIIlllIlII = llllllllllllllllllIIlIlIIlllIIIl.offset(llllllllllllllllllIIlIlIIlllIIII.rotate(EnumFacing.EAST), 1);
            llllllllllllllllllIIlIlIIllllIII.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlIIllIllll.func_191103_e(this.field_191135_b), llllllllllllllllllIIlIlIIlllIlII, llllllllllllllllllIIlIlIIlllIIII, Mirror.NONE));
        }
        
        private void func_191131_b(final List<MansionTemplate> llllllllllllllllllIIlIlIlllllIIl, final PlacementData llllllllllllllllllIIlIlIlllllIII) {
            llllllllllllllllllIIlIlIlllllIIl.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlIlllllIII.field_191140_c, llllllllllllllllllIIlIlIlllllIII.field_191139_b.offset(llllllllllllllllllIIlIlIlllllIII.field_191138_a.rotate(EnumFacing.EAST), 7), llllllllllllllllllIIlIlIlllllIII.field_191138_a));
            llllllllllllllllllIIlIlIlllllIII.field_191139_b = llllllllllllllllllIIlIlIlllllIII.field_191139_b.offset(llllllllllllllllllIIlIlIlllllIII.field_191138_a.rotate(EnumFacing.SOUTH), 8);
        }
        
        private void func_191129_a(final List<MansionTemplate> llllllllllllllllllIIlIlIllIllllI, final BlockPos llllllllllllllllllIIlIlIllIlIIll, final Rotation llllllllllllllllllIIlIlIllIlIIlI, final EnumFacing llllllllllllllllllIIlIlIllIllIll, final RoomCollection llllllllllllllllllIIlIlIllIllIlI) {
            Rotation llllllllllllllllllIIlIlIllIllIIl = Rotation.NONE;
            String llllllllllllllllllIIlIlIllIllIII = llllllllllllllllllIIlIlIllIllIlI.func_191104_a(this.field_191135_b);
            if (llllllllllllllllllIIlIlIllIllIll != EnumFacing.EAST) {
                if (llllllllllllllllllIIlIlIllIllIll == EnumFacing.NORTH) {
                    llllllllllllllllllIIlIlIllIllIIl = llllllllllllllllllIIlIlIllIllIIl.add(Rotation.COUNTERCLOCKWISE_90);
                }
                else if (llllllllllllllllllIIlIlIllIllIll == EnumFacing.WEST) {
                    llllllllllllllllllIIlIlIllIllIIl = llllllllllllllllllIIlIlIllIllIIl.add(Rotation.CLOCKWISE_180);
                }
                else if (llllllllllllllllllIIlIlIllIllIll == EnumFacing.SOUTH) {
                    llllllllllllllllllIIlIlIllIllIIl = llllllllllllllllllIIlIlIllIllIIl.add(Rotation.CLOCKWISE_90);
                }
                else {
                    llllllllllllllllllIIlIlIllIllIII = llllllllllllllllllIIlIlIllIllIlI.func_191099_b(this.field_191135_b);
                }
            }
            BlockPos llllllllllllllllllIIlIlIllIlIlll = Template.func_191157_a(new BlockPos(1, 0, 0), Mirror.NONE, llllllllllllllllllIIlIlIllIllIIl, 7, 7);
            llllllllllllllllllIIlIlIllIllIIl = llllllllllllllllllIIlIlIllIllIIl.add(llllllllllllllllllIIlIlIllIlIIlI);
            llllllllllllllllllIIlIlIllIlIlll = llllllllllllllllllIIlIlIllIlIlll.func_190942_a(llllllllllllllllllIIlIlIllIlIIlI);
            final BlockPos llllllllllllllllllIIlIlIllIlIllI = llllllllllllllllllIIlIlIllIlIIll.add(llllllllllllllllllIIlIlIllIlIlll.getX(), 0, llllllllllllllllllIIlIlIllIlIlll.getZ());
            llllllllllllllllllIIlIlIllIllllI.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlIllIllIII, llllllllllllllllllIIlIlIllIlIllI, llllllllllllllllllIIlIlIllIllIIl));
        }
        
        private void func_191130_a(final List<MansionTemplate> llllllllllllllllllIIlIllIlIlIlIl, final PlacementData llllllllllllllllllIIlIllIllIIIII, final SimpleGrid llllllllllllllllllIIlIllIlIlIIll, EnumFacing llllllllllllllllllIIlIllIlIlIIlI, final int llllllllllllllllllIIlIllIlIlIIIl, final int llllllllllllllllllIIlIllIlIlIIII, final int llllllllllllllllllIIlIllIlIllIll, final int llllllllllllllllllIIlIllIlIllIlI) {
            int llllllllllllllllllIIlIllIlIllIIl = llllllllllllllllllIIlIllIlIlIIIl;
            int llllllllllllllllllIIlIllIlIllIII = llllllllllllllllllIIlIllIlIlIIII;
            final EnumFacing llllllllllllllllllIIlIllIlIlIlll = llllllllllllllllllIIlIllIlIlIIlI;
            do {
                if (!Grid.func_191109_a(llllllllllllllllllIIlIllIlIlIIll, llllllllllllllllllIIlIllIlIllIIl + llllllllllllllllllIIlIllIlIlIIlI.getFrontOffsetX(), llllllllllllllllllIIlIllIlIllIII + llllllllllllllllllIIlIllIlIlIIlI.getFrontOffsetZ())) {
                    this.func_191124_c(llllllllllllllllllIIlIllIlIlIlIl, llllllllllllllllllIIlIllIllIIIII);
                    llllllllllllllllllIIlIllIlIlIIlI = llllllllllllllllllIIlIllIlIlIIlI.rotateY();
                    if (llllllllllllllllllIIlIllIlIllIIl == llllllllllllllllllIIlIllIlIllIll && llllllllllllllllllIIlIllIlIllIII == llllllllllllllllllIIlIllIlIllIlI && llllllllllllllllllIIlIllIlIlIlll == llllllllllllllllllIIlIllIlIlIIlI) {
                        continue;
                    }
                    this.func_191131_b(llllllllllllllllllIIlIllIlIlIlIl, llllllllllllllllllIIlIllIllIIIII);
                }
                else if (Grid.func_191109_a(llllllllllllllllllIIlIllIlIlIIll, llllllllllllllllllIIlIllIlIllIIl + llllllllllllllllllIIlIllIlIlIIlI.getFrontOffsetX(), llllllllllllllllllIIlIllIlIllIII + llllllllllllllllllIIlIllIlIlIIlI.getFrontOffsetZ()) && Grid.func_191109_a(llllllllllllllllllIIlIllIlIlIIll, llllllllllllllllllIIlIllIlIllIIl + llllllllllllllllllIIlIllIlIlIIlI.getFrontOffsetX() + llllllllllllllllllIIlIllIlIlIIlI.rotateYCCW().getFrontOffsetX(), llllllllllllllllllIIlIllIlIllIII + llllllllllllllllllIIlIllIlIlIIlI.getFrontOffsetZ() + llllllllllllllllllIIlIllIlIlIIlI.rotateYCCW().getFrontOffsetZ())) {
                    this.func_191126_d(llllllllllllllllllIIlIllIlIlIlIl, llllllllllllllllllIIlIllIllIIIII);
                    llllllllllllllllllIIlIllIlIllIIl += llllllllllllllllllIIlIllIlIlIIlI.getFrontOffsetX();
                    llllllllllllllllllIIlIllIlIllIII += llllllllllllllllllIIlIllIlIlIIlI.getFrontOffsetZ();
                    llllllllllllllllllIIlIllIlIlIIlI = llllllllllllllllllIIlIllIlIlIIlI.rotateYCCW();
                }
                else {
                    llllllllllllllllllIIlIllIlIllIIl += llllllllllllllllllIIlIllIlIlIIlI.getFrontOffsetX();
                    llllllllllllllllllIIlIllIlIllIII += llllllllllllllllllIIlIllIlIlIIlI.getFrontOffsetZ();
                    if (llllllllllllllllllIIlIllIlIllIIl == llllllllllllllllllIIlIllIlIllIll && llllllllllllllllllIIlIllIlIllIII == llllllllllllllllllIIlIllIlIllIlI && llllllllllllllllllIIlIllIlIlIlll == llllllllllllllllllIIlIllIlIlIIlI) {
                        continue;
                    }
                    this.func_191131_b(llllllllllllllllllIIlIllIlIlIlIl, llllllllllllllllllIIlIllIllIIIII);
                }
            } while (llllllllllllllllllIIlIllIlIllIIl != llllllllllllllllllIIlIllIlIllIll || llllllllllllllllllIIlIllIlIllIII != llllllllllllllllllIIlIllIlIllIlI || llllllllllllllllllIIlIllIlIlIlll != llllllllllllllllllIIlIllIlIlIIlI);
        }
        
        private void func_191123_a(final List<MansionTemplate> llllllllllllllllllIIlIllIIllllIl, final BlockPos llllllllllllllllllIIlIllIIIlIllI, final Rotation llllllllllllllllllIIlIllIIlllIll, final SimpleGrid llllllllllllllllllIIlIllIIlllIlI, @Nullable final SimpleGrid llllllllllllllllllIIlIllIIIlIIll) {
            for (int llllllllllllllllllIIlIllIIlllIII = 0; llllllllllllllllllIIlIllIIlllIII < llllllllllllllllllIIlIllIIlllIlI.field_191150_c; ++llllllllllllllllllIIlIllIIlllIII) {
                for (int llllllllllllllllllIIlIllIIllIlll = 0; llllllllllllllllllIIlIllIIllIlll < llllllllllllllllllIIlIllIIlllIlI.field_191149_b; ++llllllllllllllllllIIlIllIIllIlll) {
                    BlockPos llllllllllllllllllIIlIllIIllIllI = llllllllllllllllllIIlIllIIIlIllI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.SOUTH), 8 + (llllllllllllllllllIIlIllIIlllIII - this.field_191137_d) * 8);
                    llllllllllllllllllIIlIllIIllIllI = llllllllllllllllllIIlIllIIllIllI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.EAST), (llllllllllllllllllIIlIllIIllIlll - this.field_191136_c) * 8);
                    final boolean llllllllllllllllllIIlIllIIllIlIl = llllllllllllllllllIIlIllIIIlIIll != null && Grid.func_191109_a(llllllllllllllllllIIlIllIIIlIIll, llllllllllllllllllIIlIllIIllIlll, llllllllllllllllllIIlIllIIlllIII);
                    if (Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIllIlll, llllllllllllllllllIIlIllIIlllIII) && !llllllllllllllllllIIlIllIIllIlIl) {
                        llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "roof", llllllllllllllllllIIlIllIIllIllI.up(3), llllllllllllllllllIIlIllIIlllIll));
                        if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIllIlll + 1, llllllllllllllllllIIlIllIIlllIII)) {
                            final BlockPos llllllllllllllllllIIlIllIIllIlII = llllllllllllllllllIIlIllIIllIllI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.EAST), 6);
                            llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "roof_front", llllllllllllllllllIIlIllIIllIlII, llllllllllllllllllIIlIllIIlllIll));
                        }
                        if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIllIlll - 1, llllllllllllllllllIIlIllIIlllIII)) {
                            BlockPos llllllllllllllllllIIlIllIIllIIll = llllllllllllllllllIIlIllIIllIllI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.EAST), 0);
                            llllllllllllllllllIIlIllIIllIIll = llllllllllllllllllIIlIllIIllIIll.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.SOUTH), 7);
                            llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "roof_front", llllllllllllllllllIIlIllIIllIIll, llllllllllllllllllIIlIllIIlllIll.add(Rotation.CLOCKWISE_180)));
                        }
                        if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIllIlll, llllllllllllllllllIIlIllIIlllIII - 1)) {
                            final BlockPos llllllllllllllllllIIlIllIIllIIlI = llllllllllllllllllIIlIllIIllIllI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.WEST), 1);
                            llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "roof_front", llllllllllllllllllIIlIllIIllIIlI, llllllllllllllllllIIlIllIIlllIll.add(Rotation.COUNTERCLOCKWISE_90)));
                        }
                        if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIllIlll, llllllllllllllllllIIlIllIIlllIII + 1)) {
                            BlockPos llllllllllllllllllIIlIllIIllIIIl = llllllllllllllllllIIlIllIIllIllI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.EAST), 6);
                            llllllllllllllllllIIlIllIIllIIIl = llllllllllllllllllIIlIllIIllIIIl.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.SOUTH), 6);
                            llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "roof_front", llllllllllllllllllIIlIllIIllIIIl, llllllllllllllllllIIlIllIIlllIll.add(Rotation.CLOCKWISE_90)));
                        }
                    }
                }
            }
            if (llllllllllllllllllIIlIllIIIlIIll != null) {
                for (int llllllllllllllllllIIlIllIIllIIII = 0; llllllllllllllllllIIlIllIIllIIII < llllllllllllllllllIIlIllIIlllIlI.field_191150_c; ++llllllllllllllllllIIlIllIIllIIII) {
                    for (int llllllllllllllllllIIlIllIIlIllll = 0; llllllllllllllllllIIlIllIIlIllll < llllllllllllllllllIIlIllIIlllIlI.field_191149_b; ++llllllllllllllllllIIlIllIIlIllll) {
                        BlockPos llllllllllllllllllIIlIllIIlIlllI = llllllllllllllllllIIlIllIIIlIllI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.SOUTH), 8 + (llllllllllllllllllIIlIllIIllIIII - this.field_191137_d) * 8);
                        llllllllllllllllllIIlIllIIlIlllI = llllllllllllllllllIIlIllIIlIlllI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.EAST), (llllllllllllllllllIIlIllIIlIllll - this.field_191136_c) * 8);
                        final boolean llllllllllllllllllIIlIllIIlIllIl = Grid.func_191109_a(llllllllllllllllllIIlIllIIIlIIll, llllllllllllllllllIIlIllIIlIllll, llllllllllllllllllIIlIllIIllIIII);
                        if (Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIllll, llllllllllllllllllIIlIllIIllIIII) && llllllllllllllllllIIlIllIIlIllIl) {
                            if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIllll + 1, llllllllllllllllllIIlIllIIllIIII)) {
                                final BlockPos llllllllllllllllllIIlIllIIlIllII = llllllllllllllllllIIlIllIIlIlllI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.EAST), 7);
                                llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "small_wall", llllllllllllllllllIIlIllIIlIllII, llllllllllllllllllIIlIllIIlllIll));
                            }
                            if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIllll - 1, llllllllllllllllllIIlIllIIllIIII)) {
                                BlockPos llllllllllllllllllIIlIllIIlIlIll = llllllllllllllllllIIlIllIIlIlllI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.WEST), 1);
                                llllllllllllllllllIIlIllIIlIlIll = llllllllllllllllllIIlIllIIlIlIll.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.SOUTH), 6);
                                llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "small_wall", llllllllllllllllllIIlIllIIlIlIll, llllllllllllllllllIIlIllIIlllIll.add(Rotation.CLOCKWISE_180)));
                            }
                            if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIllll, llllllllllllllllllIIlIllIIllIIII - 1)) {
                                BlockPos llllllllllllllllllIIlIllIIlIlIlI = llllllllllllllllllIIlIllIIlIlllI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.WEST), 0);
                                llllllllllllllllllIIlIllIIlIlIlI = llllllllllllllllllIIlIllIIlIlIlI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.NORTH), 1);
                                llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "small_wall", llllllllllllllllllIIlIllIIlIlIlI, llllllllllllllllllIIlIllIIlllIll.add(Rotation.COUNTERCLOCKWISE_90)));
                            }
                            if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIllll, llllllllllllllllllIIlIllIIllIIII + 1)) {
                                BlockPos llllllllllllllllllIIlIllIIlIlIIl = llllllllllllllllllIIlIllIIlIlllI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.EAST), 6);
                                llllllllllllllllllIIlIllIIlIlIIl = llllllllllllllllllIIlIllIIlIlIIl.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.SOUTH), 7);
                                llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "small_wall", llllllllllllllllllIIlIllIIlIlIIl, llllllllllllllllllIIlIllIIlllIll.add(Rotation.CLOCKWISE_90)));
                            }
                            if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIllll + 1, llllllllllllllllllIIlIllIIllIIII)) {
                                if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIllll, llllllllllllllllllIIlIllIIllIIII - 1)) {
                                    BlockPos llllllllllllllllllIIlIllIIlIlIII = llllllllllllllllllIIlIllIIlIlllI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.EAST), 7);
                                    llllllllllllllllllIIlIllIIlIlIII = llllllllllllllllllIIlIllIIlIlIII.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.NORTH), 2);
                                    llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "small_wall_corner", llllllllllllllllllIIlIllIIlIlIII, llllllllllllllllllIIlIllIIlllIll));
                                }
                                if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIllll, llllllllllllllllllIIlIllIIllIIII + 1)) {
                                    BlockPos llllllllllllllllllIIlIllIIlIIlll = llllllllllllllllllIIlIllIIlIlllI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.EAST), 8);
                                    llllllllllllllllllIIlIllIIlIIlll = llllllllllllllllllIIlIllIIlIIlll.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.SOUTH), 7);
                                    llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "small_wall_corner", llllllllllllllllllIIlIllIIlIIlll, llllllllllllllllllIIlIllIIlllIll.add(Rotation.CLOCKWISE_90)));
                                }
                            }
                            if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIllll - 1, llllllllllllllllllIIlIllIIllIIII)) {
                                if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIllll, llllllllllllllllllIIlIllIIllIIII - 1)) {
                                    BlockPos llllllllllllllllllIIlIllIIlIIllI = llllllllllllllllllIIlIllIIlIlllI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.WEST), 2);
                                    llllllllllllllllllIIlIllIIlIIllI = llllllllllllllllllIIlIllIIlIIllI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.NORTH), 1);
                                    llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "small_wall_corner", llllllllllllllllllIIlIllIIlIIllI, llllllllllllllllllIIlIllIIlllIll.add(Rotation.COUNTERCLOCKWISE_90)));
                                }
                                if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIllll, llllllllllllllllllIIlIllIIllIIII + 1)) {
                                    BlockPos llllllllllllllllllIIlIllIIlIIlIl = llllllllllllllllllIIlIllIIlIlllI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.WEST), 1);
                                    llllllllllllllllllIIlIllIIlIIlIl = llllllllllllllllllIIlIllIIlIIlIl.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.SOUTH), 8);
                                    llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "small_wall_corner", llllllllllllllllllIIlIllIIlIIlIl, llllllllllllllllllIIlIllIIlllIll.add(Rotation.CLOCKWISE_180)));
                                }
                            }
                        }
                    }
                }
            }
            for (int llllllllllllllllllIIlIllIIlIIlII = 0; llllllllllllllllllIIlIllIIlIIlII < llllllllllllllllllIIlIllIIlllIlI.field_191150_c; ++llllllllllllllllllIIlIllIIlIIlII) {
                for (int llllllllllllllllllIIlIllIIlIIIll = 0; llllllllllllllllllIIlIllIIlIIIll < llllllllllllllllllIIlIllIIlllIlI.field_191149_b; ++llllllllllllllllllIIlIllIIlIIIll) {
                    BlockPos llllllllllllllllllIIlIllIIlIIIlI = llllllllllllllllllIIlIllIIIlIllI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.SOUTH), 8 + (llllllllllllllllllIIlIllIIlIIlII - this.field_191137_d) * 8);
                    llllllllllllllllllIIlIllIIlIIIlI = llllllllllllllllllIIlIllIIlIIIlI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.EAST), (llllllllllllllllllIIlIllIIlIIIll - this.field_191136_c) * 8);
                    final boolean llllllllllllllllllIIlIllIIlIIIIl = llllllllllllllllllIIlIllIIIlIIll != null && Grid.func_191109_a(llllllllllllllllllIIlIllIIIlIIll, llllllllllllllllllIIlIllIIlIIIll, llllllllllllllllllIIlIllIIlIIlII);
                    if (Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIIIll, llllllllllllllllllIIlIllIIlIIlII) && !llllllllllllllllllIIlIllIIlIIIIl) {
                        if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIIIll + 1, llllllllllllllllllIIlIllIIlIIlII)) {
                            final BlockPos llllllllllllllllllIIlIllIIlIIIII = llllllllllllllllllIIlIllIIlIIIlI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.EAST), 6);
                            if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIIIll, llllllllllllllllllIIlIllIIlIIlII + 1)) {
                                final BlockPos llllllllllllllllllIIlIllIIIlllll = llllllllllllllllllIIlIllIIlIIIII.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.SOUTH), 6);
                                llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "roof_corner", llllllllllllllllllIIlIllIIIlllll, llllllllllllllllllIIlIllIIlllIll));
                            }
                            else if (Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIIIll + 1, llllllllllllllllllIIlIllIIlIIlII + 1)) {
                                final BlockPos llllllllllllllllllIIlIllIIIllllI = llllllllllllllllllIIlIllIIlIIIII.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.SOUTH), 5);
                                llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "roof_inner_corner", llllllllllllllllllIIlIllIIIllllI, llllllllllllllllllIIlIllIIlllIll));
                            }
                            if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIIIll, llllllllllllllllllIIlIllIIlIIlII - 1)) {
                                llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "roof_corner", llllllllllllllllllIIlIllIIlIIIII, llllllllllllllllllIIlIllIIlllIll.add(Rotation.COUNTERCLOCKWISE_90)));
                            }
                            else if (Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIIIll + 1, llllllllllllllllllIIlIllIIlIIlII - 1)) {
                                BlockPos llllllllllllllllllIIlIllIIIlllIl = llllllllllllllllllIIlIllIIlIIIlI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.EAST), 9);
                                llllllllllllllllllIIlIllIIIlllIl = llllllllllllllllllIIlIllIIIlllIl.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.NORTH), 2);
                                llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "roof_inner_corner", llllllllllllllllllIIlIllIIIlllIl, llllllllllllllllllIIlIllIIlllIll.add(Rotation.CLOCKWISE_90)));
                            }
                        }
                        if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIIIll - 1, llllllllllllllllllIIlIllIIlIIlII)) {
                            BlockPos llllllllllllllllllIIlIllIIIlllII = llllllllllllllllllIIlIllIIlIIIlI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.EAST), 0);
                            llllllllllllllllllIIlIllIIIlllII = llllllllllllllllllIIlIllIIIlllII.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.SOUTH), 0);
                            if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIIIll, llllllllllllllllllIIlIllIIlIIlII + 1)) {
                                final BlockPos llllllllllllllllllIIlIllIIIllIll = llllllllllllllllllIIlIllIIIlllII.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.SOUTH), 6);
                                llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "roof_corner", llllllllllllllllllIIlIllIIIllIll, llllllllllllllllllIIlIllIIlllIll.add(Rotation.CLOCKWISE_90)));
                            }
                            else if (Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIIIll - 1, llllllllllllllllllIIlIllIIlIIlII + 1)) {
                                BlockPos llllllllllllllllllIIlIllIIIllIlI = llllllllllllllllllIIlIllIIIlllII.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.SOUTH), 8);
                                llllllllllllllllllIIlIllIIIllIlI = llllllllllllllllllIIlIllIIIllIlI.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.WEST), 3);
                                llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "roof_inner_corner", llllllllllllllllllIIlIllIIIllIlI, llllllllllllllllllIIlIllIIlllIll.add(Rotation.COUNTERCLOCKWISE_90)));
                            }
                            if (!Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIIIll, llllllllllllllllllIIlIllIIlIIlII - 1)) {
                                llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "roof_corner", llllllllllllllllllIIlIllIIIlllII, llllllllllllllllllIIlIllIIlllIll.add(Rotation.CLOCKWISE_180)));
                            }
                            else if (Grid.func_191109_a(llllllllllllllllllIIlIllIIlllIlI, llllllllllllllllllIIlIllIIlIIIll - 1, llllllllllllllllllIIlIllIIlIIlII - 1)) {
                                final BlockPos llllllllllllllllllIIlIllIIIllIIl = llllllllllllllllllIIlIllIIIlllII.offset(llllllllllllllllllIIlIllIIlllIll.rotate(EnumFacing.SOUTH), 1);
                                llllllllllllllllllIIlIllIIllllIl.add(new MansionTemplate(this.field_191134_a, "roof_inner_corner", llllllllllllllllllIIlIllIIIllIIl, llllllllllllllllllIIlIllIIlllIll.add(Rotation.CLOCKWISE_180)));
                            }
                        }
                    }
                }
            }
        }
        
        public void func_191125_a(final BlockPos llllllllllllllllllIIlIlllIlllIIl, final Rotation llllllllllllllllllIIlIlllIIIllIl, final List<MansionTemplate> llllllllllllllllllIIlIlllIIIllII, final Grid llllllllllllllllllIIlIlllIIIlIll) {
            final PlacementData llllllllllllllllllIIlIlllIllIlIl = new PlacementData(null);
            llllllllllllllllllIIlIlllIllIlIl.field_191139_b = llllllllllllllllllIIlIlllIlllIIl;
            llllllllllllllllllIIlIlllIllIlIl.field_191138_a = llllllllllllllllllIIlIlllIIIllIl;
            llllllllllllllllllIIlIlllIllIlIl.field_191140_c = "wall_flat";
            final PlacementData llllllllllllllllllIIlIlllIllIlII = new PlacementData(null);
            this.func_191133_a(llllllllllllllllllIIlIlllIIIllII, llllllllllllllllllIIlIlllIllIlIl);
            llllllllllllllllllIIlIlllIllIlII.field_191139_b = llllllllllllllllllIIlIlllIllIlIl.field_191139_b.up(8);
            llllllllllllllllllIIlIlllIllIlII.field_191138_a = llllllllllllllllllIIlIlllIllIlIl.field_191138_a;
            llllllllllllllllllIIlIlllIllIlII.field_191140_c = "wall_window";
            if (!llllllllllllllllllIIlIlllIIIllII.isEmpty()) {}
            final SimpleGrid llllllllllllllllllIIlIlllIllIIll = llllllllllllllllllIIlIlllIIIlIll.field_191118_b;
            final SimpleGrid llllllllllllllllllIIlIlllIllIIlI = llllllllllllllllllIIlIlllIIIlIll.field_191119_c;
            this.field_191136_c = llllllllllllllllllIIlIlllIIIlIll.field_191121_e + 1;
            this.field_191137_d = llllllllllllllllllIIlIlllIIIlIll.field_191122_f + 1;
            final int llllllllllllllllllIIlIlllIllIIIl = llllllllllllllllllIIlIlllIIIlIll.field_191121_e + 1;
            final int llllllllllllllllllIIlIlllIllIIII = llllllllllllllllllIIlIlllIIIlIll.field_191122_f;
            this.func_191130_a(llllllllllllllllllIIlIlllIIIllII, llllllllllllllllllIIlIlllIllIlIl, llllllllllllllllllIIlIlllIllIIll, EnumFacing.SOUTH, this.field_191136_c, this.field_191137_d, llllllllllllllllllIIlIlllIllIIIl, llllllllllllllllllIIlIlllIllIIII);
            this.func_191130_a(llllllllllllllllllIIlIlllIIIllII, llllllllllllllllllIIlIlllIllIlII, llllllllllllllllllIIlIlllIllIIll, EnumFacing.SOUTH, this.field_191136_c, this.field_191137_d, llllllllllllllllllIIlIlllIllIIIl, llllllllllllllllllIIlIlllIllIIII);
            final PlacementData llllllllllllllllllIIlIlllIlIllll = new PlacementData(null);
            llllllllllllllllllIIlIlllIlIllll.field_191139_b = llllllllllllllllllIIlIlllIllIlIl.field_191139_b.up(19);
            llllllllllllllllllIIlIlllIlIllll.field_191138_a = llllllllllllllllllIIlIlllIllIlIl.field_191138_a;
            llllllllllllllllllIIlIlllIlIllll.field_191140_c = "wall_window";
            boolean llllllllllllllllllIIlIlllIlIlllI = false;
            for (int llllllllllllllllllIIlIlllIlIllIl = 0; llllllllllllllllllIIlIlllIlIllIl < llllllllllllllllllIIlIlllIllIIlI.field_191150_c && !llllllllllllllllllIIlIlllIlIlllI; ++llllllllllllllllllIIlIlllIlIllIl) {
                for (int llllllllllllllllllIIlIlllIlIllII = llllllllllllllllllIIlIlllIllIIlI.field_191149_b - 1; llllllllllllllllllIIlIlllIlIllII >= 0 && !llllllllllllllllllIIlIlllIlIlllI; --llllllllllllllllllIIlIlllIlIllII) {
                    if (Grid.func_191109_a(llllllllllllllllllIIlIlllIllIIlI, llllllllllllllllllIIlIlllIlIllII, llllllllllllllllllIIlIlllIlIllIl)) {
                        llllllllllllllllllIIlIlllIlIllll.field_191139_b = llllllllllllllllllIIlIlllIlIllll.field_191139_b.offset(llllllllllllllllllIIlIlllIIIllIl.rotate(EnumFacing.SOUTH), 8 + (llllllllllllllllllIIlIlllIlIllIl - this.field_191137_d) * 8);
                        llllllllllllllllllIIlIlllIlIllll.field_191139_b = llllllllllllllllllIIlIlllIlIllll.field_191139_b.offset(llllllllllllllllllIIlIlllIIIllIl.rotate(EnumFacing.EAST), (llllllllllllllllllIIlIlllIlIllII - this.field_191136_c) * 8);
                        this.func_191131_b(llllllllllllllllllIIlIlllIIIllII, llllllllllllllllllIIlIlllIlIllll);
                        this.func_191130_a(llllllllllllllllllIIlIlllIIIllII, llllllllllllllllllIIlIlllIlIllll, llllllllllllllllllIIlIlllIllIIlI, EnumFacing.SOUTH, llllllllllllllllllIIlIlllIlIllII, llllllllllllllllllIIlIlllIlIllIl, llllllllllllllllllIIlIlllIlIllII, llllllllllllllllllIIlIlllIlIllIl);
                        llllllllllllllllllIIlIlllIlIlllI = true;
                    }
                }
            }
            this.func_191123_a(llllllllllllllllllIIlIlllIIIllII, llllllllllllllllllIIlIlllIlllIIl.up(16), llllllllllllllllllIIlIlllIIIllIl, llllllllllllllllllIIlIlllIllIIll, llllllllllllllllllIIlIlllIllIIlI);
            this.func_191123_a(llllllllllllllllllIIlIlllIIIllII, llllllllllllllllllIIlIlllIlllIIl.up(27), llllllllllllllllllIIlIlllIIIllIl, llllllllllllllllllIIlIlllIllIIlI, null);
            if (!llllllllllllllllllIIlIlllIIIllII.isEmpty()) {}
            final RoomCollection[] llllllllllllllllllIIlIlllIlIlIll = { new FirstFloor(null), new SecondFloor(null), new ThirdFloor(null) };
            for (int llllllllllllllllllIIlIlllIlIlIlI = 0; llllllllllllllllllIIlIlllIlIlIlI < 3; ++llllllllllllllllllIIlIlllIlIlIlI) {
                final BlockPos llllllllllllllllllIIlIlllIlIlIIl = llllllllllllllllllIIlIlllIlllIIl.up(8 * llllllllllllllllllIIlIlllIlIlIlI + ((llllllllllllllllllIIlIlllIlIlIlI == 2) ? 3 : 0));
                final SimpleGrid llllllllllllllllllIIlIlllIlIlIII = llllllllllllllllllIIlIlllIIIlIll.field_191120_d[llllllllllllllllllIIlIlllIlIlIlI];
                final SimpleGrid llllllllllllllllllIIlIlllIlIIlll = (llllllllllllllllllIIlIlllIlIlIlI == 2) ? llllllllllllllllllIIlIlllIllIIlI : llllllllllllllllllIIlIlllIllIIll;
                final String llllllllllllllllllIIlIlllIlIIllI = (llllllllllllllllllIIlIlllIlIlIlI == 0) ? "carpet_south" : "carpet_south_2";
                final String llllllllllllllllllIIlIlllIlIIlIl = (llllllllllllllllllIIlIlllIlIlIlI == 0) ? "carpet_west" : "carpet_west_2";
                for (int llllllllllllllllllIIlIlllIlIIlII = 0; llllllllllllllllllIIlIlllIlIIlII < llllllllllllllllllIIlIlllIlIIlll.field_191150_c; ++llllllllllllllllllIIlIlllIlIIlII) {
                    for (int llllllllllllllllllIIlIlllIlIIIll = 0; llllllllllllllllllIIlIlllIlIIIll < llllllllllllllllllIIlIlllIlIIlll.field_191149_b; ++llllllllllllllllllIIlIlllIlIIIll) {
                        if (llllllllllllllllllIIlIlllIlIIlll.func_191145_a(llllllllllllllllllIIlIlllIlIIIll, llllllllllllllllllIIlIlllIlIIlII) == 1) {
                            BlockPos llllllllllllllllllIIlIlllIlIIIlI = llllllllllllllllllIIlIlllIlIlIIl.offset(llllllllllllllllllIIlIlllIIIllIl.rotate(EnumFacing.SOUTH), 8 + (llllllllllllllllllIIlIlllIlIIlII - this.field_191137_d) * 8);
                            llllllllllllllllllIIlIlllIlIIIlI = llllllllllllllllllIIlIlllIlIIIlI.offset(llllllllllllllllllIIlIlllIIIllIl.rotate(EnumFacing.EAST), (llllllllllllllllllIIlIlllIlIIIll - this.field_191136_c) * 8);
                            llllllllllllllllllIIlIlllIIIllII.add(new MansionTemplate(this.field_191134_a, "corridor_floor", llllllllllllllllllIIlIlllIlIIIlI, llllllllllllllllllIIlIlllIIIllIl));
                            if (llllllllllllllllllIIlIlllIlIIlll.func_191145_a(llllllllllllllllllIIlIlllIlIIIll, llllllllllllllllllIIlIlllIlIIlII - 1) == 1 || (llllllllllllllllllIIlIlllIlIlIII.func_191145_a(llllllllllllllllllIIlIlllIlIIIll, llllllllllllllllllIIlIlllIlIIlII - 1) & 0x800000) == 0x800000) {
                                llllllllllllllllllIIlIlllIIIllII.add(new MansionTemplate(this.field_191134_a, "carpet_north", llllllllllllllllllIIlIlllIlIIIlI.offset(llllllllllllllllllIIlIlllIIIllIl.rotate(EnumFacing.EAST), 1).up(), llllllllllllllllllIIlIlllIIIllIl));
                            }
                            if (llllllllllllllllllIIlIlllIlIIlll.func_191145_a(llllllllllllllllllIIlIlllIlIIIll + 1, llllllllllllllllllIIlIlllIlIIlII) == 1 || (llllllllllllllllllIIlIlllIlIlIII.func_191145_a(llllllllllllllllllIIlIlllIlIIIll + 1, llllllllllllllllllIIlIlllIlIIlII) & 0x800000) == 0x800000) {
                                llllllllllllllllllIIlIlllIIIllII.add(new MansionTemplate(this.field_191134_a, "carpet_east", llllllllllllllllllIIlIlllIlIIIlI.offset(llllllllllllllllllIIlIlllIIIllIl.rotate(EnumFacing.SOUTH), 1).offset(llllllllllllllllllIIlIlllIIIllIl.rotate(EnumFacing.EAST), 5).up(), llllllllllllllllllIIlIlllIIIllIl));
                            }
                            if (llllllllllllllllllIIlIlllIlIIlll.func_191145_a(llllllllllllllllllIIlIlllIlIIIll, llllllllllllllllllIIlIlllIlIIlII + 1) == 1 || (llllllllllllllllllIIlIlllIlIlIII.func_191145_a(llllllllllllllllllIIlIlllIlIIIll, llllllllllllllllllIIlIlllIlIIlII + 1) & 0x800000) == 0x800000) {
                                llllllllllllllllllIIlIlllIIIllII.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlllIlIIllI, llllllllllllllllllIIlIlllIlIIIlI.offset(llllllllllllllllllIIlIlllIIIllIl.rotate(EnumFacing.SOUTH), 5).offset(llllllllllllllllllIIlIlllIIIllIl.rotate(EnumFacing.WEST), 1), llllllllllllllllllIIlIlllIIIllIl));
                            }
                            if (llllllllllllllllllIIlIlllIlIIlll.func_191145_a(llllllllllllllllllIIlIlllIlIIIll - 1, llllllllllllllllllIIlIlllIlIIlII) == 1 || (llllllllllllllllllIIlIlllIlIlIII.func_191145_a(llllllllllllllllllIIlIlllIlIIIll - 1, llllllllllllllllllIIlIlllIlIIlII) & 0x800000) == 0x800000) {
                                llllllllllllllllllIIlIlllIIIllII.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlllIlIIlIl, llllllllllllllllllIIlIlllIlIIIlI.offset(llllllllllllllllllIIlIlllIIIllIl.rotate(EnumFacing.WEST), 1).offset(llllllllllllllllllIIlIlllIIIllIl.rotate(EnumFacing.NORTH), 1), llllllllllllllllllIIlIlllIIIllIl));
                            }
                        }
                    }
                }
                final String llllllllllllllllllIIlIlllIlIIIIl = (llllllllllllllllllIIlIlllIlIlIlI == 0) ? "indoors_wall" : "indoors_wall_2";
                final String llllllllllllllllllIIlIlllIlIIIII = (llllllllllllllllllIIlIlllIlIlIlI == 0) ? "indoors_door" : "indoors_door_2";
                final List<EnumFacing> llllllllllllllllllIIlIlllIIlllll = (List<EnumFacing>)Lists.newArrayList();
                for (int llllllllllllllllllIIlIlllIIllllI = 0; llllllllllllllllllIIlIlllIIllllI < llllllllllllllllllIIlIlllIlIIlll.field_191150_c; ++llllllllllllllllllIIlIlllIIllllI) {
                    for (int llllllllllllllllllIIlIlllIIlllIl = 0; llllllllllllllllllIIlIlllIIlllIl < llllllllllllllllllIIlIlllIlIIlll.field_191149_b; ++llllllllllllllllllIIlIlllIIlllIl) {
                        boolean llllllllllllllllllIIlIlllIIlllII = llllllllllllllllllIIlIlllIlIlIlI == 2 && llllllllllllllllllIIlIlllIlIIlll.func_191145_a(llllllllllllllllllIIlIlllIIlllIl, llllllllllllllllllIIlIlllIIllllI) == 3;
                        if (llllllllllllllllllIIlIlllIlIIlll.func_191145_a(llllllllllllllllllIIlIlllIIlllIl, llllllllllllllllllIIlIlllIIllllI) == 2 || llllllllllllllllllIIlIlllIIlllII) {
                            final int llllllllllllllllllIIlIlllIIllIll = llllllllllllllllllIIlIlllIlIlIII.func_191145_a(llllllllllllllllllIIlIlllIIlllIl, llllllllllllllllllIIlIlllIIllllI);
                            final int llllllllllllllllllIIlIlllIIllIlI = llllllllllllllllllIIlIlllIIllIll & 0xF0000;
                            final int llllllllllllllllllIIlIlllIIllIIl = llllllllllllllllllIIlIlllIIllIll & 0xFFFF;
                            llllllllllllllllllIIlIlllIIlllII = (llllllllllllllllllIIlIlllIIlllII && (llllllllllllllllllIIlIlllIIllIll & 0x800000) == 0x800000);
                            llllllllllllllllllIIlIlllIIlllll.clear();
                            if ((llllllllllllllllllIIlIlllIIllIll & 0x200000) == 0x200000) {
                                EnumFacing[] facings;
                                for (byte llllllllllllllllllIIlIllIlllIIII = (byte)(facings = EnumFacing.Plane.HORIZONTAL.facings()).length, b = 0; b < llllllllllllllllllIIlIllIlllIIII; ++b) {
                                    final EnumFacing llllllllllllllllllIIlIlllIIllIII = facings[b];
                                    if (llllllllllllllllllIIlIlllIlIIlll.func_191145_a(llllllllllllllllllIIlIlllIIlllIl + llllllllllllllllllIIlIlllIIllIII.getFrontOffsetX(), llllllllllllllllllIIlIlllIIllllI + llllllllllllllllllIIlIlllIIllIII.getFrontOffsetZ()) == 1) {
                                        llllllllllllllllllIIlIlllIIlllll.add(llllllllllllllllllIIlIlllIIllIII);
                                    }
                                }
                            }
                            EnumFacing llllllllllllllllllIIlIlllIIlIlll = null;
                            if (!llllllllllllllllllIIlIlllIIlllll.isEmpty()) {
                                llllllllllllllllllIIlIlllIIlIlll = llllllllllllllllllIIlIlllIIlllll.get(this.field_191135_b.nextInt(llllllllllllllllllIIlIlllIIlllll.size()));
                            }
                            else if ((llllllllllllllllllIIlIlllIIllIll & 0x100000) == 0x100000) {
                                llllllllllllllllllIIlIlllIIlIlll = EnumFacing.UP;
                            }
                            BlockPos llllllllllllllllllIIlIlllIIlIllI = llllllllllllllllllIIlIlllIlIlIIl.offset(llllllllllllllllllIIlIlllIIIllIl.rotate(EnumFacing.SOUTH), 8 + (llllllllllllllllllIIlIlllIIllllI - this.field_191137_d) * 8);
                            llllllllllllllllllIIlIlllIIlIllI = llllllllllllllllllIIlIlllIIlIllI.offset(llllllllllllllllllIIlIlllIIIllIl.rotate(EnumFacing.EAST), -1 + (llllllllllllllllllIIlIlllIIlllIl - this.field_191136_c) * 8);
                            if (Grid.func_191109_a(llllllllllllllllllIIlIlllIlIIlll, llllllllllllllllllIIlIlllIIlllIl - 1, llllllllllllllllllIIlIlllIIllllI) && !llllllllllllllllllIIlIlllIIIlIll.func_191114_a(llllllllllllllllllIIlIlllIlIIlll, llllllllllllllllllIIlIlllIIlllIl - 1, llllllllllllllllllIIlIlllIIllllI, llllllllllllllllllIIlIlllIlIlIlI, llllllllllllllllllIIlIlllIIllIIl)) {
                                llllllllllllllllllIIlIlllIIIllII.add(new MansionTemplate(this.field_191134_a, (llllllllllllllllllIIlIlllIIlIlll == EnumFacing.WEST) ? llllllllllllllllllIIlIlllIlIIIII : llllllllllllllllllIIlIlllIlIIIIl, llllllllllllllllllIIlIlllIIlIllI, llllllllllllllllllIIlIlllIIIllIl));
                            }
                            if (llllllllllllllllllIIlIlllIlIIlll.func_191145_a(llllllllllllllllllIIlIlllIIlllIl + 1, llllllllllllllllllIIlIlllIIllllI) == 1 && !llllllllllllllllllIIlIlllIIlllII) {
                                final BlockPos llllllllllllllllllIIlIlllIIlIlIl = llllllllllllllllllIIlIlllIIlIllI.offset(llllllllllllllllllIIlIlllIIIllIl.rotate(EnumFacing.EAST), 8);
                                llllllllllllllllllIIlIlllIIIllII.add(new MansionTemplate(this.field_191134_a, (llllllllllllllllllIIlIlllIIlIlll == EnumFacing.EAST) ? llllllllllllllllllIIlIlllIlIIIII : llllllllllllllllllIIlIlllIlIIIIl, llllllllllllllllllIIlIlllIIlIlIl, llllllllllllllllllIIlIlllIIIllIl));
                            }
                            if (Grid.func_191109_a(llllllllllllllllllIIlIlllIlIIlll, llllllllllllllllllIIlIlllIIlllIl, llllllllllllllllllIIlIlllIIllllI + 1) && !llllllllllllllllllIIlIlllIIIlIll.func_191114_a(llllllllllllllllllIIlIlllIlIIlll, llllllllllllllllllIIlIlllIIlllIl, llllllllllllllllllIIlIlllIIllllI + 1, llllllllllllllllllIIlIlllIlIlIlI, llllllllllllllllllIIlIlllIIllIIl)) {
                                BlockPos llllllllllllllllllIIlIlllIIlIlII = llllllllllllllllllIIlIlllIIlIllI.offset(llllllllllllllllllIIlIlllIIIllIl.rotate(EnumFacing.SOUTH), 7);
                                llllllllllllllllllIIlIlllIIlIlII = llllllllllllllllllIIlIlllIIlIlII.offset(llllllllllllllllllIIlIlllIIIllIl.rotate(EnumFacing.EAST), 7);
                                llllllllllllllllllIIlIlllIIIllII.add(new MansionTemplate(this.field_191134_a, (llllllllllllllllllIIlIlllIIlIlll == EnumFacing.SOUTH) ? llllllllllllllllllIIlIlllIlIIIII : llllllllllllllllllIIlIlllIlIIIIl, llllllllllllllllllIIlIlllIIlIlII, llllllllllllllllllIIlIlllIIIllIl.add(Rotation.CLOCKWISE_90)));
                            }
                            if (llllllllllllllllllIIlIlllIlIIlll.func_191145_a(llllllllllllllllllIIlIlllIIlllIl, llllllllllllllllllIIlIlllIIllllI - 1) == 1 && !llllllllllllllllllIIlIlllIIlllII) {
                                BlockPos llllllllllllllllllIIlIlllIIlIIll = llllllllllllllllllIIlIlllIIlIllI.offset(llllllllllllllllllIIlIlllIIIllIl.rotate(EnumFacing.NORTH), 1);
                                llllllllllllllllllIIlIlllIIlIIll = llllllllllllllllllIIlIlllIIlIIll.offset(llllllllllllllllllIIlIlllIIIllIl.rotate(EnumFacing.EAST), 7);
                                llllllllllllllllllIIlIlllIIIllII.add(new MansionTemplate(this.field_191134_a, (llllllllllllllllllIIlIlllIIlIlll == EnumFacing.NORTH) ? llllllllllllllllllIIlIlllIlIIIII : llllllllllllllllllIIlIlllIlIIIIl, llllllllllllllllllIIlIlllIIlIIll, llllllllllllllllllIIlIlllIIIllIl.add(Rotation.CLOCKWISE_90)));
                            }
                            if (llllllllllllllllllIIlIlllIIllIlI == 65536) {
                                this.func_191129_a(llllllllllllllllllIIlIlllIIIllII, llllllllllllllllllIIlIlllIIlIllI, llllllllllllllllllIIlIlllIIIllIl, llllllllllllllllllIIlIlllIIlIlll, llllllllllllllllllIIlIlllIlIlIll[llllllllllllllllllIIlIlllIlIlIlI]);
                            }
                            else if (llllllllllllllllllIIlIlllIIllIlI == 131072 && llllllllllllllllllIIlIlllIIlIlll != null) {
                                final EnumFacing llllllllllllllllllIIlIlllIIlIIlI = llllllllllllllllllIIlIlllIIIlIll.func_191113_b(llllllllllllllllllIIlIlllIlIIlll, llllllllllllllllllIIlIlllIIlllIl, llllllllllllllllllIIlIlllIIllllI, llllllllllllllllllIIlIlllIlIlIlI, llllllllllllllllllIIlIlllIIllIIl);
                                final boolean llllllllllllllllllIIlIlllIIlIIIl = (llllllllllllllllllIIlIlllIIllIll & 0x400000) == 0x400000;
                                this.func_191132_a(llllllllllllllllllIIlIlllIIIllII, llllllllllllllllllIIlIlllIIlIllI, llllllllllllllllllIIlIlllIIIllIl, llllllllllllllllllIIlIlllIIlIIlI, llllllllllllllllllIIlIlllIIlIlll, llllllllllllllllllIIlIlllIlIlIll[llllllllllllllllllIIlIlllIlIlIlI], llllllllllllllllllIIlIlllIIlIIIl);
                            }
                            else if (llllllllllllllllllIIlIlllIIllIlI == 262144 && llllllllllllllllllIIlIlllIIlIlll != null && llllllllllllllllllIIlIlllIIlIlll != EnumFacing.UP) {
                                EnumFacing llllllllllllllllllIIlIlllIIlIIII = llllllllllllllllllIIlIlllIIlIlll.rotateY();
                                if (!llllllllllllllllllIIlIlllIIIlIll.func_191114_a(llllllllllllllllllIIlIlllIlIIlll, llllllllllllllllllIIlIlllIIlllIl + llllllllllllllllllIIlIlllIIlIIII.getFrontOffsetX(), llllllllllllllllllIIlIlllIIllllI + llllllllllllllllllIIlIlllIIlIIII.getFrontOffsetZ(), llllllllllllllllllIIlIlllIlIlIlI, llllllllllllllllllIIlIlllIIllIIl)) {
                                    llllllllllllllllllIIlIlllIIlIIII = llllllllllllllllllIIlIlllIIlIIII.getOpposite();
                                }
                                this.func_191127_a(llllllllllllllllllIIlIlllIIIllII, llllllllllllllllllIIlIlllIIlIllI, llllllllllllllllllIIlIlllIIIllIl, llllllllllllllllllIIlIlllIIlIIII, llllllllllllllllllIIlIlllIIlIlll, llllllllllllllllllIIlIlllIlIlIll[llllllllllllllllllIIlIlllIlIlIlI]);
                            }
                            else if (llllllllllllllllllIIlIlllIIllIlI == 262144 && llllllllllllllllllIIlIlllIIlIlll == EnumFacing.UP) {
                                this.func_191128_a(llllllllllllllllllIIlIlllIIIllII, llllllllllllllllllIIlIlllIIlIllI, llllllllllllllllllIIlIlllIIIllIl, llllllllllllllllllIIlIlllIlIlIll[llllllllllllllllllIIlIlllIlIlIlI]);
                            }
                        }
                    }
                }
            }
        }
        
        public Placer(final TemplateManager llllllllllllllllllIIlIllllIlllIl, final Random llllllllllllllllllIIlIllllIlllII) {
            this.field_191134_a = llllllllllllllllllIIlIllllIlllIl;
            this.field_191135_b = llllllllllllllllllIIlIllllIlllII;
        }
        
        private void func_191126_d(final List<MansionTemplate> llllllllllllllllllIIlIlIlllIllII, final PlacementData llllllllllllllllllIIlIlIlllIlIlI) {
            llllllllllllllllllIIlIlIlllIlIlI.field_191139_b = llllllllllllllllllIIlIlIlllIlIlI.field_191139_b.offset(llllllllllllllllllIIlIlIlllIlIlI.field_191138_a.rotate(EnumFacing.SOUTH), 6);
            llllllllllllllllllIIlIlIlllIlIlI.field_191139_b = llllllllllllllllllIIlIlIlllIlIlI.field_191139_b.offset(llllllllllllllllllIIlIlIlllIlIlI.field_191138_a.rotate(EnumFacing.EAST), 8);
            llllllllllllllllllIIlIlIlllIlIlI.field_191138_a = llllllllllllllllllIIlIlIlllIlIlI.field_191138_a.add(Rotation.COUNTERCLOCKWISE_90);
        }
        
        private void func_191124_c(final List<MansionTemplate> llllllllllllllllllIIlIlIllllIIll, final PlacementData llllllllllllllllllIIlIlIllllIIlI) {
            llllllllllllllllllIIlIlIllllIIlI.field_191139_b = llllllllllllllllllIIlIlIllllIIlI.field_191139_b.offset(llllllllllllllllllIIlIlIllllIIlI.field_191138_a.rotate(EnumFacing.SOUTH), -1);
            llllllllllllllllllIIlIlIllllIIll.add(new MansionTemplate(this.field_191134_a, "wall_corner", llllllllllllllllllIIlIlIllllIIlI.field_191139_b, llllllllllllllllllIIlIlIllllIIlI.field_191138_a));
            llllllllllllllllllIIlIlIllllIIlI.field_191139_b = llllllllllllllllllIIlIlIllllIIlI.field_191139_b.offset(llllllllllllllllllIIlIlIllllIIlI.field_191138_a.rotate(EnumFacing.SOUTH), -7);
            llllllllllllllllllIIlIlIllllIIlI.field_191139_b = llllllllllllllllllIIlIlIllllIIlI.field_191139_b.offset(llllllllllllllllllIIlIlIllllIIlI.field_191138_a.rotate(EnumFacing.WEST), -6);
            llllllllllllllllllIIlIlIllllIIlI.field_191138_a = llllllllllllllllllIIlIlIllllIIlI.field_191138_a.add(Rotation.CLOCKWISE_90);
        }
        
        private void func_191133_a(final List<MansionTemplate> llllllllllllllllllIIlIllIIIIIIll, final PlacementData llllllllllllllllllIIlIllIIIIIIlI) {
            final EnumFacing llllllllllllllllllIIlIllIIIIIlIl = llllllllllllllllllIIlIllIIIIIIlI.field_191138_a.rotate(EnumFacing.WEST);
            llllllllllllllllllIIlIllIIIIIIll.add(new MansionTemplate(this.field_191134_a, "entrance", llllllllllllllllllIIlIllIIIIIIlI.field_191139_b.offset(llllllllllllllllllIIlIllIIIIIlIl, 9), llllllllllllllllllIIlIllIIIIIIlI.field_191138_a));
            llllllllllllllllllIIlIllIIIIIIlI.field_191139_b = llllllllllllllllllIIlIllIIIIIIlI.field_191139_b.offset(llllllllllllllllllIIlIllIIIIIIlI.field_191138_a.rotate(EnumFacing.SOUTH), 16);
        }
        
        private void func_191132_a(final List<MansionTemplate> llllllllllllllllllIIlIlIllIIIIIl, final BlockPos llllllllllllllllllIIlIlIllIIIIII, final Rotation llllllllllllllllllIIlIlIlIlIlIIl, final EnumFacing llllllllllllllllllIIlIlIlIlllllI, final EnumFacing llllllllllllllllllIIlIlIlIllllIl, final RoomCollection llllllllllllllllllIIlIlIlIllllII, final boolean llllllllllllllllllIIlIlIlIlllIll) {
            if (llllllllllllllllllIIlIlIlIllllIl == EnumFacing.EAST && llllllllllllllllllIIlIlIlIlllllI == EnumFacing.SOUTH) {
                final BlockPos llllllllllllllllllIIlIlIlIlllIlI = llllllllllllllllllIIlIlIllIIIIII.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.EAST), 1);
                llllllllllllllllllIIlIlIllIIIIIl.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlIlIllllII.func_191100_a(this.field_191135_b, llllllllllllllllllIIlIlIlIlllIll), llllllllllllllllllIIlIlIlIlllIlI, llllllllllllllllllIIlIlIlIlIlIIl));
            }
            else if (llllllllllllllllllIIlIlIlIllllIl == EnumFacing.EAST && llllllllllllllllllIIlIlIlIlllllI == EnumFacing.NORTH) {
                BlockPos llllllllllllllllllIIlIlIlIlllIIl = llllllllllllllllllIIlIlIllIIIIII.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.EAST), 1);
                llllllllllllllllllIIlIlIlIlllIIl = llllllllllllllllllIIlIlIlIlllIIl.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.SOUTH), 6);
                llllllllllllllllllIIlIlIllIIIIIl.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlIlIllllII.func_191100_a(this.field_191135_b, llllllllllllllllllIIlIlIlIlllIll), llllllllllllllllllIIlIlIlIlllIIl, llllllllllllllllllIIlIlIlIlIlIIl, Mirror.LEFT_RIGHT));
            }
            else if (llllllllllllllllllIIlIlIlIllllIl == EnumFacing.WEST && llllllllllllllllllIIlIlIlIlllllI == EnumFacing.NORTH) {
                BlockPos llllllllllllllllllIIlIlIlIlllIII = llllllllllllllllllIIlIlIllIIIIII.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.EAST), 7);
                llllllllllllllllllIIlIlIlIlllIII = llllllllllllllllllIIlIlIlIlllIII.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.SOUTH), 6);
                llllllllllllllllllIIlIlIllIIIIIl.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlIlIllllII.func_191100_a(this.field_191135_b, llllllllllllllllllIIlIlIlIlllIll), llllllllllllllllllIIlIlIlIlllIII, llllllllllllllllllIIlIlIlIlIlIIl.add(Rotation.CLOCKWISE_180)));
            }
            else if (llllllllllllllllllIIlIlIlIllllIl == EnumFacing.WEST && llllllllllllllllllIIlIlIlIlllllI == EnumFacing.SOUTH) {
                final BlockPos llllllllllllllllllIIlIlIlIllIlll = llllllllllllllllllIIlIlIllIIIIII.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.EAST), 7);
                llllllllllllllllllIIlIlIllIIIIIl.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlIlIllllII.func_191100_a(this.field_191135_b, llllllllllllllllllIIlIlIlIlllIll), llllllllllllllllllIIlIlIlIllIlll, llllllllllllllllllIIlIlIlIlIlIIl, Mirror.FRONT_BACK));
            }
            else if (llllllllllllllllllIIlIlIlIllllIl == EnumFacing.SOUTH && llllllllllllllllllIIlIlIlIlllllI == EnumFacing.EAST) {
                final BlockPos llllllllllllllllllIIlIlIlIllIllI = llllllllllllllllllIIlIlIllIIIIII.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.EAST), 1);
                llllllllllllllllllIIlIlIllIIIIIl.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlIlIllllII.func_191100_a(this.field_191135_b, llllllllllllllllllIIlIlIlIlllIll), llllllllllllllllllIIlIlIlIllIllI, llllllllllllllllllIIlIlIlIlIlIIl.add(Rotation.CLOCKWISE_90), Mirror.LEFT_RIGHT));
            }
            else if (llllllllllllllllllIIlIlIlIllllIl == EnumFacing.SOUTH && llllllllllllllllllIIlIlIlIlllllI == EnumFacing.WEST) {
                final BlockPos llllllllllllllllllIIlIlIlIllIlIl = llllllllllllllllllIIlIlIllIIIIII.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.EAST), 7);
                llllllllllllllllllIIlIlIllIIIIIl.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlIlIllllII.func_191100_a(this.field_191135_b, llllllllllllllllllIIlIlIlIlllIll), llllllllllllllllllIIlIlIlIllIlIl, llllllllllllllllllIIlIlIlIlIlIIl.add(Rotation.CLOCKWISE_90)));
            }
            else if (llllllllllllllllllIIlIlIlIllllIl == EnumFacing.NORTH && llllllllllllllllllIIlIlIlIlllllI == EnumFacing.WEST) {
                BlockPos llllllllllllllllllIIlIlIlIllIlII = llllllllllllllllllIIlIlIllIIIIII.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.EAST), 7);
                llllllllllllllllllIIlIlIlIllIlII = llllllllllllllllllIIlIlIlIllIlII.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.SOUTH), 6);
                llllllllllllllllllIIlIlIllIIIIIl.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlIlIllllII.func_191100_a(this.field_191135_b, llllllllllllllllllIIlIlIlIlllIll), llllllllllllllllllIIlIlIlIllIlII, llllllllllllllllllIIlIlIlIlIlIIl.add(Rotation.CLOCKWISE_90), Mirror.FRONT_BACK));
            }
            else if (llllllllllllllllllIIlIlIlIllllIl == EnumFacing.NORTH && llllllllllllllllllIIlIlIlIlllllI == EnumFacing.EAST) {
                BlockPos llllllllllllllllllIIlIlIlIllIIll = llllllllllllllllllIIlIlIllIIIIII.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.EAST), 1);
                llllllllllllllllllIIlIlIlIllIIll = llllllllllllllllllIIlIlIlIllIIll.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.SOUTH), 6);
                llllllllllllllllllIIlIlIllIIIIIl.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlIlIllllII.func_191100_a(this.field_191135_b, llllllllllllllllllIIlIlIlIlllIll), llllllllllllllllllIIlIlIlIllIIll, llllllllllllllllllIIlIlIlIlIlIIl.add(Rotation.COUNTERCLOCKWISE_90)));
            }
            else if (llllllllllllllllllIIlIlIlIllllIl == EnumFacing.SOUTH && llllllllllllllllllIIlIlIlIlllllI == EnumFacing.NORTH) {
                BlockPos llllllllllllllllllIIlIlIlIllIIlI = llllllllllllllllllIIlIlIllIIIIII.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.EAST), 1);
                llllllllllllllllllIIlIlIlIllIIlI = llllllllllllllllllIIlIlIlIllIIlI.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.NORTH), 8);
                llllllllllllllllllIIlIlIllIIIIIl.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlIlIllllII.func_191098_b(this.field_191135_b, llllllllllllllllllIIlIlIlIlllIll), llllllllllllllllllIIlIlIlIllIIlI, llllllllllllllllllIIlIlIlIlIlIIl));
            }
            else if (llllllllllllllllllIIlIlIlIllllIl == EnumFacing.NORTH && llllllllllllllllllIIlIlIlIlllllI == EnumFacing.SOUTH) {
                BlockPos llllllllllllllllllIIlIlIlIllIIIl = llllllllllllllllllIIlIlIllIIIIII.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.EAST), 7);
                llllllllllllllllllIIlIlIlIllIIIl = llllllllllllllllllIIlIlIlIllIIIl.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.SOUTH), 14);
                llllllllllllllllllIIlIlIllIIIIIl.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlIlIllllII.func_191098_b(this.field_191135_b, llllllllllllllllllIIlIlIlIlllIll), llllllllllllllllllIIlIlIlIllIIIl, llllllllllllllllllIIlIlIlIlIlIIl.add(Rotation.CLOCKWISE_180)));
            }
            else if (llllllllllllllllllIIlIlIlIllllIl == EnumFacing.WEST && llllllllllllllllllIIlIlIlIlllllI == EnumFacing.EAST) {
                final BlockPos llllllllllllllllllIIlIlIlIllIIII = llllllllllllllllllIIlIlIllIIIIII.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.EAST), 15);
                llllllllllllllllllIIlIlIllIIIIIl.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlIlIllllII.func_191098_b(this.field_191135_b, llllllllllllllllllIIlIlIlIlllIll), llllllllllllllllllIIlIlIlIllIIII, llllllllllllllllllIIlIlIlIlIlIIl.add(Rotation.CLOCKWISE_90)));
            }
            else if (llllllllllllllllllIIlIlIlIllllIl == EnumFacing.EAST && llllllllllllllllllIIlIlIlIlllllI == EnumFacing.WEST) {
                BlockPos llllllllllllllllllIIlIlIlIlIllll = llllllllllllllllllIIlIlIllIIIIII.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.WEST), 7);
                llllllllllllllllllIIlIlIlIlIllll = llllllllllllllllllIIlIlIlIlIllll.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.SOUTH), 6);
                llllllllllllllllllIIlIlIllIIIIIl.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlIlIllllII.func_191098_b(this.field_191135_b, llllllllllllllllllIIlIlIlIlllIll), llllllllllllllllllIIlIlIlIlIllll, llllllllllllllllllIIlIlIlIlIlIIl.add(Rotation.COUNTERCLOCKWISE_90)));
            }
            else if (llllllllllllllllllIIlIlIlIllllIl == EnumFacing.UP && llllllllllllllllllIIlIlIlIlllllI == EnumFacing.EAST) {
                final BlockPos llllllllllllllllllIIlIlIlIlIlllI = llllllllllllllllllIIlIlIllIIIIII.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.EAST), 15);
                llllllllllllllllllIIlIlIllIIIIIl.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlIlIllllII.func_191102_c(this.field_191135_b), llllllllllllllllllIIlIlIlIlIlllI, llllllllllllllllllIIlIlIlIlIlIIl.add(Rotation.CLOCKWISE_90)));
            }
            else if (llllllllllllllllllIIlIlIlIllllIl == EnumFacing.UP && llllllllllllllllllIIlIlIlIlllllI == EnumFacing.SOUTH) {
                BlockPos llllllllllllllllllIIlIlIlIlIllIl = llllllllllllllllllIIlIlIllIIIIII.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.EAST), 1);
                llllllllllllllllllIIlIlIlIlIllIl = llllllllllllllllllIIlIlIlIlIllIl.offset(llllllllllllllllllIIlIlIlIlIlIIl.rotate(EnumFacing.NORTH), 0);
                llllllllllllllllllIIlIlIllIIIIIl.add(new MansionTemplate(this.field_191134_a, llllllllllllllllllIIlIlIlIllllII.func_191102_c(this.field_191135_b), llllllllllllllllllIIlIlIlIlIllIl, llllllllllllllllllIIlIlIlIlIlIIl));
            }
        }
    }
    
    static class Grid
    {
        private final /* synthetic */ int field_191121_e;
        private final /* synthetic */ SimpleGrid[] field_191120_d;
        private final /* synthetic */ Random field_191117_a;
        private final /* synthetic */ int field_191122_f;
        private final /* synthetic */ SimpleGrid field_191119_c;
        private final /* synthetic */ SimpleGrid field_191118_b;
        
        private void func_191110_a(final SimpleGrid lllllllllllllIIIIlllIIllIIlIlIIl, final int lllllllllllllIIIIlllIIllIIlIlIII, final int lllllllllllllIIIIlllIIllIIllIIll, final EnumFacing lllllllllllllIIIIlllIIllIIllIIlI, final int lllllllllllllIIIIlllIIllIIlIIlIl) {
            if (lllllllllllllIIIIlllIIllIIlIIlIl > 0) {
                lllllllllllllIIIIlllIIllIIlIlIIl.func_191144_a(lllllllllllllIIIIlllIIllIIlIlIII, lllllllllllllIIIIlllIIllIIllIIll, 1);
                lllllllllllllIIIIlllIIllIIlIlIIl.func_191141_a(lllllllllllllIIIIlllIIllIIlIlIII + lllllllllllllIIIIlllIIllIIllIIlI.getFrontOffsetX(), lllllllllllllIIIIlllIIllIIllIIll + lllllllllllllIIIIlllIIllIIllIIlI.getFrontOffsetZ(), 0, 1);
                for (int lllllllllllllIIIIlllIIllIIllIIII = 0; lllllllllllllIIIIlllIIllIIllIIII < 8; ++lllllllllllllIIIIlllIIllIIllIIII) {
                    final EnumFacing lllllllllllllIIIIlllIIllIIlIllll = EnumFacing.getHorizontal(this.field_191117_a.nextInt(4));
                    if (lllllllllllllIIIIlllIIllIIlIllll != lllllllllllllIIIIlllIIllIIllIIlI.getOpposite() && (lllllllllllllIIIIlllIIllIIlIllll != EnumFacing.EAST || !this.field_191117_a.nextBoolean())) {
                        final int lllllllllllllIIIIlllIIllIIlIlllI = lllllllllllllIIIIlllIIllIIlIlIII + lllllllllllllIIIIlllIIllIIllIIlI.getFrontOffsetX();
                        final int lllllllllllllIIIIlllIIllIIlIllIl = lllllllllllllIIIIlllIIllIIllIIll + lllllllllllllIIIIlllIIllIIllIIlI.getFrontOffsetZ();
                        if (lllllllllllllIIIIlllIIllIIlIlIIl.func_191145_a(lllllllllllllIIIIlllIIllIIlIlllI + lllllllllllllIIIIlllIIllIIlIllll.getFrontOffsetX(), lllllllllllllIIIIlllIIllIIlIllIl + lllllllllllllIIIIlllIIllIIlIllll.getFrontOffsetZ()) == 0 && lllllllllllllIIIIlllIIllIIlIlIIl.func_191145_a(lllllllllllllIIIIlllIIllIIlIlllI + lllllllllllllIIIIlllIIllIIlIllll.getFrontOffsetX() * 2, lllllllllllllIIIIlllIIllIIlIllIl + lllllllllllllIIIIlllIIllIIlIllll.getFrontOffsetZ() * 2) == 0) {
                            this.func_191110_a(lllllllllllllIIIIlllIIllIIlIlIIl, lllllllllllllIIIIlllIIllIIlIlIII + lllllllllllllIIIIlllIIllIIllIIlI.getFrontOffsetX() + lllllllllllllIIIIlllIIllIIlIllll.getFrontOffsetX(), lllllllllllllIIIIlllIIllIIllIIll + lllllllllllllIIIIlllIIllIIllIIlI.getFrontOffsetZ() + lllllllllllllIIIIlllIIllIIlIllll.getFrontOffsetZ(), lllllllllllllIIIIlllIIllIIlIllll, lllllllllllllIIIIlllIIllIIlIIlIl - 1);
                            break;
                        }
                    }
                }
                final EnumFacing lllllllllllllIIIIlllIIllIIlIllII = lllllllllllllIIIIlllIIllIIllIIlI.rotateY();
                final EnumFacing lllllllllllllIIIIlllIIllIIlIlIll = lllllllllllllIIIIlllIIllIIllIIlI.rotateYCCW();
                lllllllllllllIIIIlllIIllIIlIlIIl.func_191141_a(lllllllllllllIIIIlllIIllIIlIlIII + lllllllllllllIIIIlllIIllIIlIllII.getFrontOffsetX(), lllllllllllllIIIIlllIIllIIllIIll + lllllllllllllIIIIlllIIllIIlIllII.getFrontOffsetZ(), 0, 2);
                lllllllllllllIIIIlllIIllIIlIlIIl.func_191141_a(lllllllllllllIIIIlllIIllIIlIlIII + lllllllllllllIIIIlllIIllIIlIlIll.getFrontOffsetX(), lllllllllllllIIIIlllIIllIIllIIll + lllllllllllllIIIIlllIIllIIlIlIll.getFrontOffsetZ(), 0, 2);
                lllllllllllllIIIIlllIIllIIlIlIIl.func_191141_a(lllllllllllllIIIIlllIIllIIlIlIII + lllllllllllllIIIIlllIIllIIllIIlI.getFrontOffsetX() + lllllllllllllIIIIlllIIllIIlIllII.getFrontOffsetX(), lllllllllllllIIIIlllIIllIIllIIll + lllllllllllllIIIIlllIIllIIllIIlI.getFrontOffsetZ() + lllllllllllllIIIIlllIIllIIlIllII.getFrontOffsetZ(), 0, 2);
                lllllllllllllIIIIlllIIllIIlIlIIl.func_191141_a(lllllllllllllIIIIlllIIllIIlIlIII + lllllllllllllIIIIlllIIllIIllIIlI.getFrontOffsetX() + lllllllllllllIIIIlllIIllIIlIlIll.getFrontOffsetX(), lllllllllllllIIIIlllIIllIIllIIll + lllllllllllllIIIIlllIIllIIllIIlI.getFrontOffsetZ() + lllllllllllllIIIIlllIIllIIlIlIll.getFrontOffsetZ(), 0, 2);
                lllllllllllllIIIIlllIIllIIlIlIIl.func_191141_a(lllllllllllllIIIIlllIIllIIlIlIII + lllllllllllllIIIIlllIIllIIllIIlI.getFrontOffsetX() * 2, lllllllllllllIIIIlllIIllIIllIIll + lllllllllllllIIIIlllIIllIIllIIlI.getFrontOffsetZ() * 2, 0, 2);
                lllllllllllllIIIIlllIIllIIlIlIIl.func_191141_a(lllllllllllllIIIIlllIIllIIlIlIII + lllllllllllllIIIIlllIIllIIlIllII.getFrontOffsetX() * 2, lllllllllllllIIIIlllIIllIIllIIll + lllllllllllllIIIIlllIIllIIlIllII.getFrontOffsetZ() * 2, 0, 2);
                lllllllllllllIIIIlllIIllIIlIlIIl.func_191141_a(lllllllllllllIIIIlllIIllIIlIlIII + lllllllllllllIIIIlllIIllIIlIlIll.getFrontOffsetX() * 2, lllllllllllllIIIIlllIIllIIllIIll + lllllllllllllIIIIlllIIllIIlIlIll.getFrontOffsetZ() * 2, 0, 2);
            }
        }
        
        private void func_191115_b() {
            final List<Tuple<Integer, Integer>> lllllllllllllIIIIlllIIlIllllllll = (List<Tuple<Integer, Integer>>)Lists.newArrayList();
            final SimpleGrid lllllllllllllIIIIlllIIlIlllllllI = this.field_191120_d[1];
            for (int lllllllllllllIIIIlllIIlIllllllIl = 0; lllllllllllllIIIIlllIIlIllllllIl < this.field_191119_c.field_191150_c; ++lllllllllllllIIIIlllIIlIllllllIl) {
                for (int lllllllllllllIIIIlllIIlIllllllII = 0; lllllllllllllIIIIlllIIlIllllllII < this.field_191119_c.field_191149_b; ++lllllllllllllIIIIlllIIlIllllllII) {
                    final int lllllllllllllIIIIlllIIlIlllllIll = lllllllllllllIIIIlllIIlIlllllllI.func_191145_a(lllllllllllllIIIIlllIIlIllllllII, lllllllllllllIIIIlllIIlIllllllIl);
                    final int lllllllllllllIIIIlllIIlIlllllIlI = lllllllllllllIIIIlllIIlIlllllIll & 0xF0000;
                    if (lllllllllllllIIIIlllIIlIlllllIlI == 131072 && (lllllllllllllIIIIlllIIlIlllllIll & 0x200000) == 0x200000) {
                        lllllllllllllIIIIlllIIlIllllllll.add(new Tuple<Integer, Integer>(lllllllllllllIIIIlllIIlIllllllII, lllllllllllllIIIIlllIIlIllllllIl));
                    }
                }
            }
            if (lllllllllllllIIIIlllIIlIllllllll.isEmpty()) {
                this.field_191119_c.func_191142_a(0, 0, this.field_191119_c.field_191149_b, this.field_191119_c.field_191150_c, 5);
            }
            else {
                final Tuple<Integer, Integer> lllllllllllllIIIIlllIIlIlllllIIl = lllllllllllllIIIIlllIIlIllllllll.get(this.field_191117_a.nextInt(lllllllllllllIIIIlllIIlIllllllll.size()));
                final int lllllllllllllIIIIlllIIlIlllllIII = lllllllllllllIIIIlllIIlIlllllllI.func_191145_a(lllllllllllllIIIIlllIIlIlllllIIl.getFirst(), lllllllllllllIIIIlllIIlIlllllIIl.getSecond());
                lllllllllllllIIIIlllIIlIlllllllI.func_191144_a(lllllllllllllIIIIlllIIlIlllllIIl.getFirst(), lllllllllllllIIIIlllIIlIlllllIIl.getSecond(), lllllllllllllIIIIlllIIlIlllllIII | 0x400000);
                final EnumFacing lllllllllllllIIIIlllIIlIllllIlll = this.func_191113_b(this.field_191118_b, lllllllllllllIIIIlllIIlIlllllIIl.getFirst(), lllllllllllllIIIIlllIIlIlllllIIl.getSecond(), 1, lllllllllllllIIIIlllIIlIlllllIII & 0xFFFF);
                final int lllllllllllllIIIIlllIIlIllllIllI = lllllllllllllIIIIlllIIlIlllllIIl.getFirst() + lllllllllllllIIIIlllIIlIllllIlll.getFrontOffsetX();
                final int lllllllllllllIIIIlllIIlIllllIlIl = lllllllllllllIIIIlllIIlIlllllIIl.getSecond() + lllllllllllllIIIIlllIIlIllllIlll.getFrontOffsetZ();
                for (int lllllllllllllIIIIlllIIlIllllIlII = 0; lllllllllllllIIIIlllIIlIllllIlII < this.field_191119_c.field_191150_c; ++lllllllllllllIIIIlllIIlIllllIlII) {
                    for (int lllllllllllllIIIIlllIIlIllllIIll = 0; lllllllllllllIIIIlllIIlIllllIIll < this.field_191119_c.field_191149_b; ++lllllllllllllIIIIlllIIlIllllIIll) {
                        if (!func_191109_a(this.field_191118_b, lllllllllllllIIIIlllIIlIllllIIll, lllllllllllllIIIIlllIIlIllllIlII)) {
                            this.field_191119_c.func_191144_a(lllllllllllllIIIIlllIIlIllllIIll, lllllllllllllIIIIlllIIlIllllIlII, 5);
                        }
                        else if (lllllllllllllIIIIlllIIlIllllIIll == lllllllllllllIIIIlllIIlIlllllIIl.getFirst() && lllllllllllllIIIIlllIIlIllllIlII == lllllllllllllIIIIlllIIlIlllllIIl.getSecond()) {
                            this.field_191119_c.func_191144_a(lllllllllllllIIIIlllIIlIllllIIll, lllllllllllllIIIIlllIIlIllllIlII, 3);
                        }
                        else if (lllllllllllllIIIIlllIIlIllllIIll == lllllllllllllIIIIlllIIlIllllIllI && lllllllllllllIIIIlllIIlIllllIlII == lllllllllllllIIIIlllIIlIllllIlIl) {
                            this.field_191119_c.func_191144_a(lllllllllllllIIIIlllIIlIllllIIll, lllllllllllllIIIIlllIIlIllllIlII, 3);
                            this.field_191120_d[2].func_191144_a(lllllllllllllIIIIlllIIlIllllIIll, lllllllllllllIIIIlllIIlIllllIlII, 8388608);
                        }
                    }
                }
                final List<EnumFacing> lllllllllllllIIIIlllIIlIllllIIlI = (List<EnumFacing>)Lists.newArrayList();
                final byte lllllllllllllIIIIlllIIlIlllIIIll;
                final boolean lllllllllllllIIIIlllIIlIlllIIlII = ((EnumFacing[])(Object)(lllllllllllllIIIIlllIIlIlllIIIll = (byte)(Object)EnumFacing.Plane.HORIZONTAL.facings())).length != 0;
                for (float lllllllllllllIIIIlllIIlIlllIIlIl = 0; lllllllllllllIIIIlllIIlIlllIIlIl < (lllllllllllllIIIIlllIIlIlllIIlII ? 1 : 0); ++lllllllllllllIIIIlllIIlIlllIIlIl) {
                    final EnumFacing lllllllllllllIIIIlllIIlIllllIIIl = lllllllllllllIIIIlllIIlIlllIIIll[lllllllllllllIIIIlllIIlIlllIIlIl];
                    if (this.field_191119_c.func_191145_a(lllllllllllllIIIIlllIIlIllllIllI + lllllllllllllIIIIlllIIlIllllIIIl.getFrontOffsetX(), lllllllllllllIIIIlllIIlIllllIlIl + lllllllllllllIIIIlllIIlIllllIIIl.getFrontOffsetZ()) == 0) {
                        lllllllllllllIIIIlllIIlIllllIIlI.add(lllllllllllllIIIIlllIIlIllllIIIl);
                    }
                }
                if (lllllllllllllIIIIlllIIlIllllIIlI.isEmpty()) {
                    this.field_191119_c.func_191142_a(0, 0, this.field_191119_c.field_191149_b, this.field_191119_c.field_191150_c, 5);
                    lllllllllllllIIIIlllIIlIlllllllI.func_191144_a(lllllllllllllIIIIlllIIlIlllllIIl.getFirst(), lllllllllllllIIIIlllIIlIlllllIIl.getSecond(), lllllllllllllIIIIlllIIlIlllllIII);
                }
                else {
                    final EnumFacing lllllllllllllIIIIlllIIlIllllIIII = lllllllllllllIIIIlllIIlIllllIIlI.get(this.field_191117_a.nextInt(lllllllllllllIIIIlllIIlIllllIIlI.size()));
                    this.func_191110_a(this.field_191119_c, lllllllllllllIIIIlllIIlIllllIllI + lllllllllllllIIIIlllIIlIllllIIII.getFrontOffsetX(), lllllllllllllIIIIlllIIlIllllIlIl + lllllllllllllIIIIlllIIlIllllIIII.getFrontOffsetZ(), lllllllllllllIIIIlllIIlIllllIIII, 4);
                    while (this.func_191111_a(this.field_191119_c)) {}
                }
            }
        }
        
        public static boolean func_191109_a(final SimpleGrid lllllllllllllIIIIlllIIllIlllIIll, final int lllllllllllllIIIIlllIIllIlllIIlI, final int lllllllllllllIIIIlllIIllIllIllIl) {
            final int lllllllllllllIIIIlllIIllIlllIIII = lllllllllllllIIIIlllIIllIlllIIll.func_191145_a(lllllllllllllIIIIlllIIllIlllIIlI, lllllllllllllIIIIlllIIllIllIllIl);
            return lllllllllllllIIIIlllIIllIlllIIII == 1 || lllllllllllllIIIIlllIIllIlllIIII == 2 || lllllllllllllIIIIlllIIllIlllIIII == 3 || lllllllllllllIIIIlllIIllIlllIIII == 4;
        }
        
        public Grid(final Random lllllllllllllIIIIlllIIllIllllIIl) {
            this.field_191117_a = lllllllllllllIIIIlllIIllIllllIIl;
            final int lllllllllllllIIIIlllIIllIllllIll = 11;
            this.field_191121_e = 7;
            this.field_191122_f = 4;
            this.field_191118_b = new SimpleGrid(11, 11, 5);
            this.field_191118_b.func_191142_a(this.field_191121_e, this.field_191122_f, this.field_191121_e + 1, this.field_191122_f + 1, 3);
            this.field_191118_b.func_191142_a(this.field_191121_e - 1, this.field_191122_f, this.field_191121_e - 1, this.field_191122_f + 1, 2);
            this.field_191118_b.func_191142_a(this.field_191121_e + 2, this.field_191122_f - 2, this.field_191121_e + 3, this.field_191122_f + 3, 5);
            this.field_191118_b.func_191142_a(this.field_191121_e + 1, this.field_191122_f - 2, this.field_191121_e + 1, this.field_191122_f - 1, 1);
            this.field_191118_b.func_191142_a(this.field_191121_e + 1, this.field_191122_f + 2, this.field_191121_e + 1, this.field_191122_f + 3, 1);
            this.field_191118_b.func_191144_a(this.field_191121_e - 1, this.field_191122_f - 1, 1);
            this.field_191118_b.func_191144_a(this.field_191121_e - 1, this.field_191122_f + 2, 1);
            this.field_191118_b.func_191142_a(0, 0, 11, 1, 5);
            this.field_191118_b.func_191142_a(0, 9, 11, 11, 5);
            this.func_191110_a(this.field_191118_b, this.field_191121_e, this.field_191122_f - 2, EnumFacing.WEST, 6);
            this.func_191110_a(this.field_191118_b, this.field_191121_e, this.field_191122_f + 3, EnumFacing.WEST, 6);
            this.func_191110_a(this.field_191118_b, this.field_191121_e - 2, this.field_191122_f - 1, EnumFacing.WEST, 3);
            this.func_191110_a(this.field_191118_b, this.field_191121_e - 2, this.field_191122_f + 2, EnumFacing.WEST, 3);
            while (this.func_191111_a(this.field_191118_b)) {}
            this.field_191120_d = new SimpleGrid[3];
            this.field_191120_d[0] = new SimpleGrid(11, 11, 5);
            this.field_191120_d[1] = new SimpleGrid(11, 11, 5);
            this.field_191120_d[2] = new SimpleGrid(11, 11, 5);
            this.func_191116_a(this.field_191118_b, this.field_191120_d[0]);
            this.func_191116_a(this.field_191118_b, this.field_191120_d[1]);
            this.field_191120_d[0].func_191142_a(this.field_191121_e + 1, this.field_191122_f, this.field_191121_e + 1, this.field_191122_f + 1, 8388608);
            this.field_191120_d[1].func_191142_a(this.field_191121_e + 1, this.field_191122_f, this.field_191121_e + 1, this.field_191122_f + 1, 8388608);
            this.field_191119_c = new SimpleGrid(this.field_191118_b.field_191149_b, this.field_191118_b.field_191150_c, 5);
            this.func_191115_b();
            this.func_191116_a(this.field_191119_c, this.field_191120_d[2]);
        }
        
        private boolean func_191111_a(final SimpleGrid lllllllllllllIIIIlllIIllIIIllIIl) {
            boolean lllllllllllllIIIIlllIIllIIIllIII = false;
            for (int lllllllllllllIIIIlllIIllIIIlIlll = 0; lllllllllllllIIIIlllIIllIIIlIlll < lllllllllllllIIIIlllIIllIIIllIIl.field_191150_c; ++lllllllllllllIIIIlllIIllIIIlIlll) {
                for (int lllllllllllllIIIIlllIIllIIIlIllI = 0; lllllllllllllIIIIlllIIllIIIlIllI < lllllllllllllIIIIlllIIllIIIllIIl.field_191149_b; ++lllllllllllllIIIIlllIIllIIIlIllI) {
                    if (lllllllllllllIIIIlllIIllIIIllIIl.func_191145_a(lllllllllllllIIIIlllIIllIIIlIllI, lllllllllllllIIIIlllIIllIIIlIlll) == 0) {
                        int lllllllllllllIIIIlllIIllIIIlIlIl = 0;
                        lllllllllllllIIIIlllIIllIIIlIlIl += (func_191109_a(lllllllllllllIIIIlllIIllIIIllIIl, lllllllllllllIIIIlllIIllIIIlIllI + 1, lllllllllllllIIIIlllIIllIIIlIlll) ? 1 : 0);
                        lllllllllllllIIIIlllIIllIIIlIlIl += (func_191109_a(lllllllllllllIIIIlllIIllIIIllIIl, lllllllllllllIIIIlllIIllIIIlIllI - 1, lllllllllllllIIIIlllIIllIIIlIlll) ? 1 : 0);
                        lllllllllllllIIIIlllIIllIIIlIlIl += (func_191109_a(lllllllllllllIIIIlllIIllIIIllIIl, lllllllllllllIIIIlllIIllIIIlIllI, lllllllllllllIIIIlllIIllIIIlIlll + 1) ? 1 : 0);
                        lllllllllllllIIIIlllIIllIIIlIlIl += (func_191109_a(lllllllllllllIIIIlllIIllIIIllIIl, lllllllllllllIIIIlllIIllIIIlIllI, lllllllllllllIIIIlllIIllIIIlIlll - 1) ? 1 : 0);
                        if (lllllllllllllIIIIlllIIllIIIlIlIl >= 3) {
                            lllllllllllllIIIIlllIIllIIIllIIl.func_191144_a(lllllllllllllIIIIlllIIllIIIlIllI, lllllllllllllIIIIlllIIllIIIlIlll, 2);
                            lllllllllllllIIIIlllIIllIIIllIII = true;
                        }
                        else if (lllllllllllllIIIIlllIIllIIIlIlIl == 2) {
                            int lllllllllllllIIIIlllIIllIIIlIlII = 0;
                            lllllllllllllIIIIlllIIllIIIlIlII += (func_191109_a(lllllllllllllIIIIlllIIllIIIllIIl, lllllllllllllIIIIlllIIllIIIlIllI + 1, lllllllllllllIIIIlllIIllIIIlIlll + 1) ? 1 : 0);
                            lllllllllllllIIIIlllIIllIIIlIlII += (func_191109_a(lllllllllllllIIIIlllIIllIIIllIIl, lllllllllllllIIIIlllIIllIIIlIllI - 1, lllllllllllllIIIIlllIIllIIIlIlll + 1) ? 1 : 0);
                            lllllllllllllIIIIlllIIllIIIlIlII += (func_191109_a(lllllllllllllIIIIlllIIllIIIllIIl, lllllllllllllIIIIlllIIllIIIlIllI + 1, lllllllllllllIIIIlllIIllIIIlIlll - 1) ? 1 : 0);
                            lllllllllllllIIIIlllIIllIIIlIlII += (func_191109_a(lllllllllllllIIIIlllIIllIIIllIIl, lllllllllllllIIIIlllIIllIIIlIllI - 1, lllllllllllllIIIIlllIIllIIIlIlll - 1) ? 1 : 0);
                            if (lllllllllllllIIIIlllIIllIIIlIlII <= 1) {
                                lllllllllllllIIIIlllIIllIIIllIIl.func_191144_a(lllllllllllllIIIIlllIIllIIIlIllI, lllllllllllllIIIIlllIIllIIIlIlll, 2);
                                lllllllllllllIIIIlllIIllIIIllIII = true;
                            }
                        }
                    }
                }
            }
            return lllllllllllllIIIIlllIIllIIIllIII;
        }
        
        @Nullable
        public EnumFacing func_191113_b(final SimpleGrid lllllllllllllIIIIlllIIllIlIlIIII, final int lllllllllllllIIIIlllIIllIlIIlIII, final int lllllllllllllIIIIlllIIllIlIIlllI, final int lllllllllllllIIIIlllIIllIlIIllIl, final int lllllllllllllIIIIlllIIllIlIIllII) {
            int lllllllllllllIIIIlllIIllIlIIIIIl;
            for (Exception lllllllllllllIIIIlllIIllIlIIIIlI = (Exception)((EnumFacing[])(Object)(lllllllllllllIIIIlllIIllIlIIIIIl = (int)(Object)EnumFacing.Plane.HORIZONTAL.facings())).length, lllllllllllllIIIIlllIIllIlIIIIll = (Exception)0; lllllllllllllIIIIlllIIllIlIIIIll < lllllllllllllIIIIlllIIllIlIIIIlI; ++lllllllllllllIIIIlllIIllIlIIIIll) {
                final EnumFacing lllllllllllllIIIIlllIIllIlIIlIll = lllllllllllllIIIIlllIIllIlIIIIIl[lllllllllllllIIIIlllIIllIlIIIIll];
                if (this.func_191114_a(lllllllllllllIIIIlllIIllIlIlIIII, lllllllllllllIIIIlllIIllIlIIlIII + lllllllllllllIIIIlllIIllIlIIlIll.getFrontOffsetX(), lllllllllllllIIIIlllIIllIlIIlllI + lllllllllllllIIIIlllIIllIlIIlIll.getFrontOffsetZ(), lllllllllllllIIIIlllIIllIlIIllIl, lllllllllllllIIIIlllIIllIlIIllII)) {
                    return lllllllllllllIIIIlllIIllIlIIlIll;
                }
            }
            return null;
        }
        
        private void func_191116_a(final SimpleGrid lllllllllllllIIIIlllIIlIllIIlllI, final SimpleGrid lllllllllllllIIIIlllIIlIllIIllIl) {
            final List<Tuple<Integer, Integer>> lllllllllllllIIIIlllIIlIllIIllII = (List<Tuple<Integer, Integer>>)Lists.newArrayList();
            for (int lllllllllllllIIIIlllIIlIllIIlIll = 0; lllllllllllllIIIIlllIIlIllIIlIll < lllllllllllllIIIIlllIIlIllIIlllI.field_191150_c; ++lllllllllllllIIIIlllIIlIllIIlIll) {
                for (int lllllllllllllIIIIlllIIlIllIIlIlI = 0; lllllllllllllIIIIlllIIlIllIIlIlI < lllllllllllllIIIIlllIIlIllIIlllI.field_191149_b; ++lllllllllllllIIIIlllIIlIllIIlIlI) {
                    if (lllllllllllllIIIIlllIIlIllIIlllI.func_191145_a(lllllllllllllIIIIlllIIlIllIIlIlI, lllllllllllllIIIIlllIIlIllIIlIll) == 2) {
                        lllllllllllllIIIIlllIIlIllIIllII.add(new Tuple<Integer, Integer>(lllllllllllllIIIIlllIIlIllIIlIlI, lllllllllllllIIIIlllIIlIllIIlIll));
                    }
                }
            }
            Collections.shuffle(lllllllllllllIIIIlllIIlIllIIllII, this.field_191117_a);
            int lllllllllllllIIIIlllIIlIllIIlIIl = 10;
            for (final Tuple<Integer, Integer> lllllllllllllIIIIlllIIlIllIIlIII : lllllllllllllIIIIlllIIlIllIIllII) {
                final int lllllllllllllIIIIlllIIlIllIIIlll = lllllllllllllIIIIlllIIlIllIIlIII.getFirst();
                final int lllllllllllllIIIIlllIIlIllIIIllI = lllllllllllllIIIIlllIIlIllIIlIII.getSecond();
                if (lllllllllllllIIIIlllIIlIllIIllIl.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll, lllllllllllllIIIIlllIIlIllIIIllI) == 0) {
                    int lllllllllllllIIIIlllIIlIllIIIlIl = lllllllllllllIIIIlllIIlIllIIIlll;
                    int lllllllllllllIIIIlllIIlIllIIIlII = lllllllllllllIIIIlllIIlIllIIIlll;
                    int lllllllllllllIIIIlllIIlIllIIIIll = lllllllllllllIIIIlllIIlIllIIIllI;
                    int lllllllllllllIIIIlllIIlIllIIIIlI = lllllllllllllIIIIlllIIlIllIIIllI;
                    int lllllllllllllIIIIlllIIlIllIIIIIl = 65536;
                    if (lllllllllllllIIIIlllIIlIllIIllIl.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll + 1, lllllllllllllIIIIlllIIlIllIIIllI) == 0 && lllllllllllllIIIIlllIIlIllIIllIl.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll, lllllllllllllIIIIlllIIlIllIIIllI + 1) == 0 && lllllllllllllIIIIlllIIlIllIIllIl.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll + 1, lllllllllllllIIIIlllIIlIllIIIllI + 1) == 0 && lllllllllllllIIIIlllIIlIllIIlllI.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll + 1, lllllllllllllIIIIlllIIlIllIIIllI) == 2 && lllllllllllllIIIIlllIIlIllIIlllI.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll, lllllllllllllIIIIlllIIlIllIIIllI + 1) == 2 && lllllllllllllIIIIlllIIlIllIIlllI.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll + 1, lllllllllllllIIIIlllIIlIllIIIllI + 1) == 2) {
                        lllllllllllllIIIIlllIIlIllIIIlII = lllllllllllllIIIIlllIIlIllIIIlll + 1;
                        lllllllllllllIIIIlllIIlIllIIIIlI = lllllllllllllIIIIlllIIlIllIIIllI + 1;
                        lllllllllllllIIIIlllIIlIllIIIIIl = 262144;
                    }
                    else if (lllllllllllllIIIIlllIIlIllIIllIl.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll - 1, lllllllllllllIIIIlllIIlIllIIIllI) == 0 && lllllllllllllIIIIlllIIlIllIIllIl.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll, lllllllllllllIIIIlllIIlIllIIIllI + 1) == 0 && lllllllllllllIIIIlllIIlIllIIllIl.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll - 1, lllllllllllllIIIIlllIIlIllIIIllI + 1) == 0 && lllllllllllllIIIIlllIIlIllIIlllI.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll - 1, lllllllllllllIIIIlllIIlIllIIIllI) == 2 && lllllllllllllIIIIlllIIlIllIIlllI.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll, lllllllllllllIIIIlllIIlIllIIIllI + 1) == 2 && lllllllllllllIIIIlllIIlIllIIlllI.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll - 1, lllllllllllllIIIIlllIIlIllIIIllI + 1) == 2) {
                        lllllllllllllIIIIlllIIlIllIIIlIl = lllllllllllllIIIIlllIIlIllIIIlll - 1;
                        lllllllllllllIIIIlllIIlIllIIIIlI = lllllllllllllIIIIlllIIlIllIIIllI + 1;
                        lllllllllllllIIIIlllIIlIllIIIIIl = 262144;
                    }
                    else if (lllllllllllllIIIIlllIIlIllIIllIl.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll - 1, lllllllllllllIIIIlllIIlIllIIIllI) == 0 && lllllllllllllIIIIlllIIlIllIIllIl.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll, lllllllllllllIIIIlllIIlIllIIIllI - 1) == 0 && lllllllllllllIIIIlllIIlIllIIllIl.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll - 1, lllllllllllllIIIIlllIIlIllIIIllI - 1) == 0 && lllllllllllllIIIIlllIIlIllIIlllI.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll - 1, lllllllllllllIIIIlllIIlIllIIIllI) == 2 && lllllllllllllIIIIlllIIlIllIIlllI.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll, lllllllllllllIIIIlllIIlIllIIIllI - 1) == 2 && lllllllllllllIIIIlllIIlIllIIlllI.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll - 1, lllllllllllllIIIIlllIIlIllIIIllI - 1) == 2) {
                        lllllllllllllIIIIlllIIlIllIIIlIl = lllllllllllllIIIIlllIIlIllIIIlll - 1;
                        lllllllllllllIIIIlllIIlIllIIIIll = lllllllllllllIIIIlllIIlIllIIIllI - 1;
                        lllllllllllllIIIIlllIIlIllIIIIIl = 262144;
                    }
                    else if (lllllllllllllIIIIlllIIlIllIIllIl.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll + 1, lllllllllllllIIIIlllIIlIllIIIllI) == 0 && lllllllllllllIIIIlllIIlIllIIlllI.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll + 1, lllllllllllllIIIIlllIIlIllIIIllI) == 2) {
                        lllllllllllllIIIIlllIIlIllIIIlII = lllllllllllllIIIIlllIIlIllIIIlll + 1;
                        lllllllllllllIIIIlllIIlIllIIIIIl = 131072;
                    }
                    else if (lllllllllllllIIIIlllIIlIllIIllIl.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll, lllllllllllllIIIIlllIIlIllIIIllI + 1) == 0 && lllllllllllllIIIIlllIIlIllIIlllI.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll, lllllllllllllIIIIlllIIlIllIIIllI + 1) == 2) {
                        lllllllllllllIIIIlllIIlIllIIIIlI = lllllllllllllIIIIlllIIlIllIIIllI + 1;
                        lllllllllllllIIIIlllIIlIllIIIIIl = 131072;
                    }
                    else if (lllllllllllllIIIIlllIIlIllIIllIl.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll - 1, lllllllllllllIIIIlllIIlIllIIIllI) == 0 && lllllllllllllIIIIlllIIlIllIIlllI.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll - 1, lllllllllllllIIIIlllIIlIllIIIllI) == 2) {
                        lllllllllllllIIIIlllIIlIllIIIlIl = lllllllllllllIIIIlllIIlIllIIIlll - 1;
                        lllllllllllllIIIIlllIIlIllIIIIIl = 131072;
                    }
                    else if (lllllllllllllIIIIlllIIlIllIIllIl.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll, lllllllllllllIIIIlllIIlIllIIIllI - 1) == 0 && lllllllllllllIIIIlllIIlIllIIlllI.func_191145_a(lllllllllllllIIIIlllIIlIllIIIlll, lllllllllllllIIIIlllIIlIllIIIllI - 1) == 2) {
                        lllllllllllllIIIIlllIIlIllIIIIll = lllllllllllllIIIIlllIIlIllIIIllI - 1;
                        lllllllllllllIIIIlllIIlIllIIIIIl = 131072;
                    }
                    int lllllllllllllIIIIlllIIlIllIIIIII = this.field_191117_a.nextBoolean() ? lllllllllllllIIIIlllIIlIllIIIlIl : lllllllllllllIIIIlllIIlIllIIIlII;
                    int lllllllllllllIIIIlllIIlIlIllllll = this.field_191117_a.nextBoolean() ? lllllllllllllIIIIlllIIlIllIIIIll : lllllllllllllIIIIlllIIlIllIIIIlI;
                    int lllllllllllllIIIIlllIIlIlIlllllI = 2097152;
                    if (!lllllllllllllIIIIlllIIlIllIIlllI.func_191147_b(lllllllllllllIIIIlllIIlIllIIIIII, lllllllllllllIIIIlllIIlIlIllllll, 1)) {
                        lllllllllllllIIIIlllIIlIllIIIIII = ((lllllllllllllIIIIlllIIlIllIIIIII == lllllllllllllIIIIlllIIlIllIIIlIl) ? lllllllllllllIIIIlllIIlIllIIIlII : lllllllllllllIIIIlllIIlIllIIIlIl);
                        lllllllllllllIIIIlllIIlIlIllllll = ((lllllllllllllIIIIlllIIlIlIllllll == lllllllllllllIIIIlllIIlIllIIIIll) ? lllllllllllllIIIIlllIIlIllIIIIlI : lllllllllllllIIIIlllIIlIllIIIIll);
                        if (!lllllllllllllIIIIlllIIlIllIIlllI.func_191147_b(lllllllllllllIIIIlllIIlIllIIIIII, lllllllllllllIIIIlllIIlIlIllllll, 1)) {
                            lllllllllllllIIIIlllIIlIlIllllll = ((lllllllllllllIIIIlllIIlIlIllllll == lllllllllllllIIIIlllIIlIllIIIIll) ? lllllllllllllIIIIlllIIlIllIIIIlI : lllllllllllllIIIIlllIIlIllIIIIll);
                            if (!lllllllllllllIIIIlllIIlIllIIlllI.func_191147_b(lllllllllllllIIIIlllIIlIllIIIIII, lllllllllllllIIIIlllIIlIlIllllll, 1)) {
                                lllllllllllllIIIIlllIIlIllIIIIII = ((lllllllllllllIIIIlllIIlIllIIIIII == lllllllllllllIIIIlllIIlIllIIIlIl) ? lllllllllllllIIIIlllIIlIllIIIlII : lllllllllllllIIIIlllIIlIllIIIlIl);
                                lllllllllllllIIIIlllIIlIlIllllll = ((lllllllllllllIIIIlllIIlIlIllllll == lllllllllllllIIIIlllIIlIllIIIIll) ? lllllllllllllIIIIlllIIlIllIIIIlI : lllllllllllllIIIIlllIIlIllIIIIll);
                                if (!lllllllllllllIIIIlllIIlIllIIlllI.func_191147_b(lllllllllllllIIIIlllIIlIllIIIIII, lllllllllllllIIIIlllIIlIlIllllll, 1)) {
                                    lllllllllllllIIIIlllIIlIlIlllllI = 0;
                                    lllllllllllllIIIIlllIIlIllIIIIII = lllllllllllllIIIIlllIIlIllIIIlIl;
                                    lllllllllllllIIIIlllIIlIlIllllll = lllllllllllllIIIIlllIIlIllIIIIll;
                                }
                            }
                        }
                    }
                    for (int lllllllllllllIIIIlllIIlIlIllllIl = lllllllllllllIIIIlllIIlIllIIIIll; lllllllllllllIIIIlllIIlIlIllllIl <= lllllllllllllIIIIlllIIlIllIIIIlI; ++lllllllllllllIIIIlllIIlIlIllllIl) {
                        for (int lllllllllllllIIIIlllIIlIlIllllII = lllllllllllllIIIIlllIIlIllIIIlIl; lllllllllllllIIIIlllIIlIlIllllII <= lllllllllllllIIIIlllIIlIllIIIlII; ++lllllllllllllIIIIlllIIlIlIllllII) {
                            if (lllllllllllllIIIIlllIIlIlIllllII == lllllllllllllIIIIlllIIlIllIIIIII && lllllllllllllIIIIlllIIlIlIllllIl == lllllllllllllIIIIlllIIlIlIllllll) {
                                lllllllllllllIIIIlllIIlIllIIllIl.func_191144_a(lllllllllllllIIIIlllIIlIlIllllII, lllllllllllllIIIIlllIIlIlIllllIl, 0x100000 | lllllllllllllIIIIlllIIlIlIlllllI | lllllllllllllIIIIlllIIlIllIIIIIl | lllllllllllllIIIIlllIIlIllIIlIIl);
                            }
                            else {
                                lllllllllllllIIIIlllIIlIllIIllIl.func_191144_a(lllllllllllllIIIIlllIIlIlIllllII, lllllllllllllIIIIlllIIlIlIllllIl, lllllllllllllIIIIlllIIlIllIIIIIl | lllllllllllllIIIIlllIIlIllIIlIIl);
                            }
                        }
                    }
                    ++lllllllllllllIIIIlllIIlIllIIlIIl;
                }
            }
        }
        
        public boolean func_191114_a(final SimpleGrid lllllllllllllIIIIlllIIllIllIIlIl, final int lllllllllllllIIIIlllIIllIllIIlII, final int lllllllllllllIIIIlllIIllIllIIIll, final int lllllllllllllIIIIlllIIllIlIlllIl, final int lllllllllllllIIIIlllIIllIllIIIIl) {
            return (this.field_191120_d[lllllllllllllIIIIlllIIllIlIlllIl].func_191145_a(lllllllllllllIIIIlllIIllIllIIlII, lllllllllllllIIIIlllIIllIllIIIll) & 0xFFFF) == lllllllllllllIIIIlllIIllIllIIIIl;
        }
    }
    
    static class SimpleGrid
    {
        private final /* synthetic */ int field_191151_d;
        private final /* synthetic */ int[][] field_191148_a;
        private final /* synthetic */ int field_191149_b;
        private final /* synthetic */ int field_191150_c;
        
        public boolean func_191147_b(final int lllllllllllllIlIllIIIlIIIlllIlII, final int lllllllllllllIlIllIIIlIIIlllIIll, final int lllllllllllllIlIllIIIlIIIlllIIlI) {
            return this.func_191145_a(lllllllllllllIlIllIIIlIIIlllIlII - 1, lllllllllllllIlIllIIIlIIIlllIIll) == lllllllllllllIlIllIIIlIIIlllIIlI || this.func_191145_a(lllllllllllllIlIllIIIlIIIlllIlII + 1, lllllllllllllIlIllIIIlIIIlllIIll) == lllllllllllllIlIllIIIlIIIlllIIlI || this.func_191145_a(lllllllllllllIlIllIIIlIIIlllIlII, lllllllllllllIlIllIIIlIIIlllIIll + 1) == lllllllllllllIlIllIIIlIIIlllIIlI || this.func_191145_a(lllllllllllllIlIllIIIlIIIlllIlII, lllllllllllllIlIllIIIlIIIlllIIll - 1) == lllllllllllllIlIllIIIlIIIlllIIlI;
        }
        
        public int func_191145_a(final int lllllllllllllIlIllIIIlIIlIIIlIlI, final int lllllllllllllIlIllIIIlIIlIIIlIIl) {
            return (lllllllllllllIlIllIIIlIIlIIIlIlI >= 0 && lllllllllllllIlIllIIIlIIlIIIlIlI < this.field_191149_b && lllllllllllllIlIllIIIlIIlIIIlIIl >= 0 && lllllllllllllIlIllIIIlIIlIIIlIIl < this.field_191150_c) ? this.field_191148_a[lllllllllllllIlIllIIIlIIlIIIlIlI][lllllllllllllIlIllIIIlIIlIIIlIIl] : this.field_191151_d;
        }
        
        public SimpleGrid(final int lllllllllllllIlIllIIIlIIlIllllII, final int lllllllllllllIlIllIIIlIIlIlllIll, final int lllllllllllllIlIllIIIlIIlIlllIlI) {
            this.field_191149_b = lllllllllllllIlIllIIIlIIlIllllII;
            this.field_191150_c = lllllllllllllIlIllIIIlIIlIlllIll;
            this.field_191151_d = lllllllllllllIlIllIIIlIIlIlllIlI;
            this.field_191148_a = new int[lllllllllllllIlIllIIIlIIlIllllII][lllllllllllllIlIllIIIlIIlIlllIll];
        }
        
        public void func_191141_a(final int lllllllllllllIlIllIIIlIIIlllllIl, final int lllllllllllllIlIllIIIlIIlIIIIIIl, final int lllllllllllllIlIllIIIlIIlIIIIIII, final int lllllllllllllIlIllIIIlIIIllllIlI) {
            if (this.func_191145_a(lllllllllllllIlIllIIIlIIIlllllIl, lllllllllllllIlIllIIIlIIlIIIIIIl) == lllllllllllllIlIllIIIlIIlIIIIIII) {
                this.func_191144_a(lllllllllllllIlIllIIIlIIIlllllIl, lllllllllllllIlIllIIIlIIlIIIIIIl, lllllllllllllIlIllIIIlIIIllllIlI);
            }
        }
        
        public void func_191144_a(final int lllllllllllllIlIllIIIlIIlIlIllII, final int lllllllllllllIlIllIIIlIIlIlIlIll, final int lllllllllllllIlIllIIIlIIlIlIlIlI) {
            if (lllllllllllllIlIllIIIlIIlIlIllII >= 0 && lllllllllllllIlIllIIIlIIlIlIllII < this.field_191149_b && lllllllllllllIlIllIIIlIIlIlIlIll >= 0 && lllllllllllllIlIllIIIlIIlIlIlIll < this.field_191150_c) {
                this.field_191148_a[lllllllllllllIlIllIIIlIIlIlIllII][lllllllllllllIlIllIIIlIIlIlIlIll] = lllllllllllllIlIllIIIlIIlIlIlIlI;
            }
        }
        
        public void func_191142_a(final int lllllllllllllIlIllIIIlIIlIIllIII, final int lllllllllllllIlIllIIIlIIlIIlllll, final int lllllllllllllIlIllIIIlIIlIIllllI, final int lllllllllllllIlIllIIIlIIlIIlllIl, final int lllllllllllllIlIllIIIlIIlIIlllII) {
            for (int lllllllllllllIlIllIIIlIIlIIllIll = lllllllllllllIlIllIIIlIIlIIlllll; lllllllllllllIlIllIIIlIIlIIllIll <= lllllllllllllIlIllIIIlIIlIIlllIl; ++lllllllllllllIlIllIIIlIIlIIllIll) {
                for (int lllllllllllllIlIllIIIlIIlIIllIlI = lllllllllllllIlIllIIIlIIlIIllIII; lllllllllllllIlIllIIIlIIlIIllIlI <= lllllllllllllIlIllIIIlIIlIIllllI; ++lllllllllllllIlIllIIIlIIlIIllIlI) {
                    this.func_191144_a(lllllllllllllIlIllIIIlIIlIIllIlI, lllllllllllllIlIllIIIlIIlIIllIll, lllllllllllllIlIllIIIlIIlIIlllII);
                }
            }
        }
    }
    
    public static class MansionTemplate extends StructureComponentTemplate
    {
        private /* synthetic */ Rotation field_191083_e;
        private /* synthetic */ Mirror field_191084_f;
        private /* synthetic */ String field_191082_d;
        
        @Override
        protected void readStructureFromNBT(final NBTTagCompound llllllllllllllIlIllIlllIIIlIlIIl, final TemplateManager llllllllllllllIlIllIlllIIIlIlIII) {
            super.readStructureFromNBT(llllllllllllllIlIllIlllIIIlIlIIl, llllllllllllllIlIllIlllIIIlIlIII);
            this.field_191082_d = llllllllllllllIlIllIlllIIIlIlIIl.getString("Template");
            this.field_191083_e = Rotation.valueOf(llllllllllllllIlIllIlllIIIlIlIIl.getString("Rot"));
            this.field_191084_f = Mirror.valueOf(llllllllllllllIlIllIlllIIIlIlIIl.getString("Mi"));
            this.func_191081_a(llllllllllllllIlIllIlllIIIlIlIII);
        }
        
        public MansionTemplate(final TemplateManager llllllllllllllIlIllIlllIIlIlIlIl, final String llllllllllllllIlIllIlllIIlIllIIl, final BlockPos llllllllllllllIlIllIlllIIlIlIIll, final Rotation llllllllllllllIlIllIlllIIlIlIlll) {
            this(llllllllllllllIlIllIlllIIlIlIlIl, llllllllllllllIlIllIlllIIlIllIIl, llllllllllllllIlIllIlllIIlIlIIll, llllllllllllllIlIllIlllIIlIlIlll, Mirror.NONE);
        }
        
        public MansionTemplate(final TemplateManager llllllllllllllIlIllIlllIIlIIIlII, final String llllllllllllllIlIllIlllIIlIIlIIl, final BlockPos llllllllllllllIlIllIlllIIlIIlIII, final Rotation llllllllllllllIlIllIlllIIlIIIIIl, final Mirror llllllllllllllIlIllIlllIIlIIIllI) {
            super(0);
            this.field_191082_d = llllllllllllllIlIllIlllIIlIIlIIl;
            this.templatePosition = llllllllllllllIlIllIlllIIlIIlIII;
            this.field_191083_e = llllllllllllllIlIllIlllIIlIIIIIl;
            this.field_191084_f = llllllllllllllIlIllIlllIIlIIIllI;
            this.func_191081_a(llllllllllllllIlIllIlllIIlIIIlII);
        }
        
        private void func_191081_a(final TemplateManager llllllllllllllIlIllIlllIIIllIllI) {
            final Template llllllllllllllIlIllIlllIIIlllIIl = llllllllllllllIlIllIlllIIIllIllI.getTemplate(null, new ResourceLocation(String.valueOf(new StringBuilder("mansion/").append(this.field_191082_d))));
            final PlacementSettings llllllllllllllIlIllIlllIIIlllIII = new PlacementSettings().setIgnoreEntities(true).setRotation(this.field_191083_e).setMirror(this.field_191084_f);
            this.setup(llllllllllllllIlIllIlllIIIlllIIl, this.templatePosition, llllllllllllllIlIllIlllIIIlllIII);
        }
        
        @Override
        protected void handleDataMarker(final String llllllllllllllIlIllIlllIIIIllIll, final BlockPos llllllllllllllIlIllIlllIIIIlIIII, final World llllllllllllllIlIllIlllIIIIIllll, final Random llllllllllllllIlIllIlllIIIIllIII, final StructureBoundingBox llllllllllllllIlIllIlllIIIIIllIl) {
            if (llllllllllllllIlIllIlllIIIIllIll.startsWith("Chest")) {
                final Rotation llllllllllllllIlIllIlllIIIIlIllI = this.placeSettings.getRotation();
                IBlockState llllllllllllllIlIllIlllIIIIlIlIl = Blocks.CHEST.getDefaultState();
                if ("ChestWest".equals(llllllllllllllIlIllIlllIIIIllIll)) {
                    llllllllllllllIlIllIlllIIIIlIlIl = llllllllllllllIlIllIlllIIIIlIlIl.withProperty((IProperty<Comparable>)BlockChest.FACING, llllllllllllllIlIllIlllIIIIlIllI.rotate(EnumFacing.WEST));
                }
                else if ("ChestEast".equals(llllllllllllllIlIllIlllIIIIllIll)) {
                    llllllllllllllIlIllIlllIIIIlIlIl = llllllllllllllIlIllIlllIIIIlIlIl.withProperty((IProperty<Comparable>)BlockChest.FACING, llllllllllllllIlIllIlllIIIIlIllI.rotate(EnumFacing.EAST));
                }
                else if ("ChestSouth".equals(llllllllllllllIlIllIlllIIIIllIll)) {
                    llllllllllllllIlIllIlllIIIIlIlIl = llllllllllllllIlIllIlllIIIIlIlIl.withProperty((IProperty<Comparable>)BlockChest.FACING, llllllllllllllIlIllIlllIIIIlIllI.rotate(EnumFacing.SOUTH));
                }
                else if ("ChestNorth".equals(llllllllllllllIlIllIlllIIIIllIll)) {
                    llllllllllllllIlIllIlllIIIIlIlIl = llllllllllllllIlIllIlllIIIIlIlIl.withProperty((IProperty<Comparable>)BlockChest.FACING, llllllllllllllIlIllIlllIIIIlIllI.rotate(EnumFacing.NORTH));
                }
                this.func_191080_a(llllllllllllllIlIllIlllIIIIIllll, llllllllllllllIlIllIlllIIIIIllIl, llllllllllllllIlIllIlllIIIIllIII, llllllllllllllIlIllIlllIIIIlIIII, LootTableList.field_191192_o, llllllllllllllIlIllIlllIIIIlIlIl);
            }
            else if ("Mage".equals(llllllllllllllIlIllIlllIIIIllIll)) {
                final EntityEvoker llllllllllllllIlIllIlllIIIIlIlII = new EntityEvoker(llllllllllllllIlIllIlllIIIIIllll);
                llllllllllllllIlIllIlllIIIIlIlII.enablePersistence();
                llllllllllllllIlIllIlllIIIIlIlII.moveToBlockPosAndAngles(llllllllllllllIlIllIlllIIIIlIIII, 0.0f, 0.0f);
                llllllllllllllIlIllIlllIIIIIllll.spawnEntityInWorld(llllllllllllllIlIllIlllIIIIlIlII);
                llllllllllllllIlIllIlllIIIIIllll.setBlockState(llllllllllllllIlIllIlllIIIIlIIII, Blocks.AIR.getDefaultState(), 2);
            }
            else if ("Warrior".equals(llllllllllllllIlIllIlllIIIIllIll)) {
                final EntityVindicator llllllllllllllIlIllIlllIIIIlIIll = new EntityVindicator(llllllllllllllIlIllIlllIIIIIllll);
                llllllllllllllIlIllIlllIIIIlIIll.enablePersistence();
                llllllllllllllIlIllIlllIIIIlIIll.moveToBlockPosAndAngles(llllllllllllllIlIllIlllIIIIlIIII, 0.0f, 0.0f);
                llllllllllllllIlIllIlllIIIIlIIll.onInitialSpawn(llllllllllllllIlIllIlllIIIIIllll.getDifficultyForLocation(new BlockPos(llllllllllllllIlIllIlllIIIIlIIll)), null);
                llllllllllllllIlIllIlllIIIIIllll.spawnEntityInWorld(llllllllllllllIlIllIlllIIIIlIIll);
                llllllllllllllIlIllIlllIIIIIllll.setBlockState(llllllllllllllIlIllIlllIIIIlIIII, Blocks.AIR.getDefaultState(), 2);
            }
        }
        
        @Override
        protected void writeStructureToNBT(final NBTTagCompound llllllllllllllIlIllIlllIIIllIIII) {
            super.writeStructureToNBT(llllllllllllllIlIllIlllIIIllIIII);
            llllllllllllllIlIllIlllIIIllIIII.setString("Template", this.field_191082_d);
            llllllllllllllIlIllIlllIIIllIIII.setString("Rot", this.placeSettings.getRotation().name());
            llllllllllllllIlIllIlllIIIllIIII.setString("Mi", this.placeSettings.getMirror().name());
        }
        
        public MansionTemplate() {
        }
    }
    
    static class PlacementData
    {
        public /* synthetic */ String field_191140_c;
        public /* synthetic */ Rotation field_191138_a;
        public /* synthetic */ BlockPos field_191139_b;
        
        private PlacementData() {
        }
    }
}
