package net.minecraft.world.biome;

import net.minecraft.util.math.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.world.gen.feature.*;

public class BiomeDecorator
{
    protected /* synthetic */ WorldGenerator cactusGen;
    protected /* synthetic */ BlockPos chunkPos;
    protected /* synthetic */ WorldGenerator mushroomRedGen;
    protected /* synthetic */ WorldGenerator diamondGen;
    protected /* synthetic */ WorldGenerator bigMushroomGen;
    protected /* synthetic */ WorldGenerator graniteGen;
    protected /* synthetic */ int sandPerChunk;
    protected /* synthetic */ int deadBushPerChunk;
    protected /* synthetic */ int mushroomsPerChunk;
    protected /* synthetic */ WorldGenerator clayGen;
    protected /* synthetic */ WorldGenFlowers yellowFlowerGen;
    protected /* synthetic */ ChunkGeneratorSettings chunkProviderSettings;
    protected /* synthetic */ WorldGenerator andesiteGen;
    protected /* synthetic */ int cactiPerChunk;
    protected /* synthetic */ WorldGenerator gravelAsSandGen;
    protected /* synthetic */ WorldGenerator ironGen;
    protected /* synthetic */ int waterlilyPerChunk;
    protected /* synthetic */ int bigMushroomsPerChunk;
    protected /* synthetic */ int reedsPerChunk;
    protected /* synthetic */ boolean decorating;
    protected /* synthetic */ WorldGenerator mushroomBrownGen;
    protected /* synthetic */ WorldGenerator lapisGen;
    protected /* synthetic */ int clayPerChunk;
    protected /* synthetic */ int grassPerChunk;
    public /* synthetic */ boolean generateLakes;
    protected /* synthetic */ WorldGenerator dirtGen;
    protected /* synthetic */ WorldGenerator sandGen;
    protected /* synthetic */ WorldGenerator reedGen;
    protected /* synthetic */ WorldGenerator dioriteGen;
    protected /* synthetic */ WorldGenerator redstoneGen;
    protected /* synthetic */ int flowersPerChunk;
    protected /* synthetic */ int sandPerChunk2;
    protected /* synthetic */ float extraTreeChance;
    protected /* synthetic */ WorldGenerator gravelGen;
    protected /* synthetic */ WorldGenerator coalGen;
    protected /* synthetic */ WorldGenerator waterlilyGen;
    protected /* synthetic */ int treesPerChunk;
    protected /* synthetic */ WorldGenerator goldGen;
    
    public void decorate(final World lllllllllllllIIlIllllIIIlIIllIIl, final Random lllllllllllllIIlIllllIIIlIIllIII, final Biome lllllllllllllIIlIllllIIIlIIlIlll, final BlockPos lllllllllllllIIlIllllIIIlIIlIllI) {
        if (this.decorating) {
            throw new RuntimeException("Already decorating");
        }
        this.chunkProviderSettings = ChunkGeneratorSettings.Factory.jsonToFactory(lllllllllllllIIlIllllIIIlIIllIIl.getWorldInfo().getGeneratorOptions()).build();
        this.chunkPos = lllllllllllllIIlIllllIIIlIIlIllI;
        this.dirtGen = new WorldGenMinable(Blocks.DIRT.getDefaultState(), this.chunkProviderSettings.dirtSize);
        this.gravelGen = new WorldGenMinable(Blocks.GRAVEL.getDefaultState(), this.chunkProviderSettings.gravelSize);
        this.graniteGen = new WorldGenMinable(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE), this.chunkProviderSettings.graniteSize);
        this.dioriteGen = new WorldGenMinable(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE), this.chunkProviderSettings.dioriteSize);
        this.andesiteGen = new WorldGenMinable(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE), this.chunkProviderSettings.andesiteSize);
        this.coalGen = new WorldGenMinable(Blocks.COAL_ORE.getDefaultState(), this.chunkProviderSettings.coalSize);
        this.ironGen = new WorldGenMinable(Blocks.IRON_ORE.getDefaultState(), this.chunkProviderSettings.ironSize);
        this.goldGen = new WorldGenMinable(Blocks.GOLD_ORE.getDefaultState(), this.chunkProviderSettings.goldSize);
        this.redstoneGen = new WorldGenMinable(Blocks.REDSTONE_ORE.getDefaultState(), this.chunkProviderSettings.redstoneSize);
        this.diamondGen = new WorldGenMinable(Blocks.DIAMOND_ORE.getDefaultState(), this.chunkProviderSettings.diamondSize);
        this.lapisGen = new WorldGenMinable(Blocks.LAPIS_ORE.getDefaultState(), this.chunkProviderSettings.lapisSize);
        this.genDecorations(lllllllllllllIIlIllllIIIlIIlIlll, lllllllllllllIIlIllllIIIlIIllIIl, lllllllllllllIIlIllllIIIlIIllIII);
        this.decorating = false;
    }
    
    protected void genStandardOre1(final World lllllllllllllIIlIllllIIIIIIIIlIl, final Random lllllllllllllIIlIllllIIIIIIIIlII, final int lllllllllllllIIlIlllIllllllllIIl, final WorldGenerator lllllllllllllIIlIlllIllllllllIII, int lllllllllllllIIlIlllIlllllllIlll, int lllllllllllllIIlIlllIlllllllIllI) {
        if (lllllllllllllIIlIlllIlllllllIllI < lllllllllllllIIlIlllIlllllllIlll) {
            final int lllllllllllllIIlIlllIlllllllllll = lllllllllllllIIlIlllIlllllllIlll;
            lllllllllllllIIlIlllIlllllllIlll = lllllllllllllIIlIlllIlllllllIllI;
            lllllllllllllIIlIlllIlllllllIllI = lllllllllllllIIlIlllIlllllllllll;
        }
        else if (lllllllllllllIIlIlllIlllllllIllI == lllllllllllllIIlIlllIlllllllIlll) {
            if (lllllllllllllIIlIlllIlllllllIlll < 255) {
                ++lllllllllllllIIlIlllIlllllllIllI;
            }
            else {
                --lllllllllllllIIlIlllIlllllllIlll;
            }
        }
        for (int lllllllllllllIIlIlllIllllllllllI = 0; lllllllllllllIIlIlllIllllllllllI < lllllllllllllIIlIlllIllllllllIIl; ++lllllllllllllIIlIlllIllllllllllI) {
            final BlockPos lllllllllllllIIlIlllIlllllllllIl = this.chunkPos.add(lllllllllllllIIlIllllIIIIIIIIlII.nextInt(16), lllllllllllllIIlIllllIIIIIIIIlII.nextInt(lllllllllllllIIlIlllIlllllllIllI - lllllllllllllIIlIlllIlllllllIlll) + lllllllllllllIIlIlllIlllllllIlll, lllllllllllllIIlIllllIIIIIIIIlII.nextInt(16));
            lllllllllllllIIlIlllIllllllllIII.generate(lllllllllllllIIlIllllIIIIIIIIlIl, lllllllllllllIIlIllllIIIIIIIIlII, lllllllllllllIIlIlllIlllllllllIl);
        }
    }
    
    public BiomeDecorator() {
        this.clayGen = new WorldGenClay(4);
        this.sandGen = new WorldGenSand(Blocks.SAND, 7);
        this.gravelAsSandGen = new WorldGenSand(Blocks.GRAVEL, 6);
        this.yellowFlowerGen = new WorldGenFlowers(Blocks.YELLOW_FLOWER, BlockFlower.EnumFlowerType.DANDELION);
        this.mushroomBrownGen = new WorldGenBush(Blocks.BROWN_MUSHROOM);
        this.mushroomRedGen = new WorldGenBush(Blocks.RED_MUSHROOM);
        this.bigMushroomGen = new WorldGenBigMushroom();
        this.reedGen = new WorldGenReed();
        this.cactusGen = new WorldGenCactus();
        this.waterlilyGen = new WorldGenWaterlily();
        this.extraTreeChance = 0.1f;
        this.flowersPerChunk = 2;
        this.grassPerChunk = 1;
        this.sandPerChunk = 1;
        this.sandPerChunk2 = 3;
        this.clayPerChunk = 1;
        this.generateLakes = true;
    }
    
    protected void genDecorations(final Biome lllllllllllllIIlIllllIIIIIlIIlII, final World lllllllllllllIIlIllllIIIIIlIIIll, final Random lllllllllllllIIlIllllIIIlIIIIIII) {
        this.generateOres(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII);
        for (int lllllllllllllIIlIllllIIIIlllllll = 0; lllllllllllllIIlIllllIIIIlllllll < this.sandPerChunk2; ++lllllllllllllIIlIllllIIIIlllllll) {
            final int lllllllllllllIIlIllllIIIIllllllI = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIlllllIl = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            this.sandGen.generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, lllllllllllllIIlIllllIIIIIlIIIll.getTopSolidOrLiquidBlock(this.chunkPos.add(lllllllllllllIIlIllllIIIIllllllI, 0, lllllllllllllIIlIllllIIIIlllllIl)));
        }
        for (int lllllllllllllIIlIllllIIIIlllllII = 0; lllllllllllllIIlIllllIIIIlllllII < this.clayPerChunk; ++lllllllllllllIIlIllllIIIIlllllII) {
            final int lllllllllllllIIlIllllIIIIllllIll = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIllllIlI = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            this.clayGen.generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, lllllllllllllIIlIllllIIIIIlIIIll.getTopSolidOrLiquidBlock(this.chunkPos.add(lllllllllllllIIlIllllIIIIllllIll, 0, lllllllllllllIIlIllllIIIIllllIlI)));
        }
        for (int lllllllllllllIIlIllllIIIIllllIIl = 0; lllllllllllllIIlIllllIIIIllllIIl < this.sandPerChunk; ++lllllllllllllIIlIllllIIIIllllIIl) {
            final int lllllllllllllIIlIllllIIIIllllIII = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIlllIlll = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            this.gravelAsSandGen.generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, lllllllllllllIIlIllllIIIIIlIIIll.getTopSolidOrLiquidBlock(this.chunkPos.add(lllllllllllllIIlIllllIIIIllllIII, 0, lllllllllllllIIlIllllIIIIlllIlll)));
        }
        int lllllllllllllIIlIllllIIIIlllIllI = this.treesPerChunk;
        if (lllllllllllllIIlIllllIIIlIIIIIII.nextFloat() < this.extraTreeChance) {
            ++lllllllllllllIIlIllllIIIIlllIllI;
        }
        for (int lllllllllllllIIlIllllIIIIlllIlIl = 0; lllllllllllllIIlIllllIIIIlllIlIl < lllllllllllllIIlIllllIIIIlllIllI; ++lllllllllllllIIlIllllIIIIlllIlIl) {
            final int lllllllllllllIIlIllllIIIIlllIlII = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIlllIIll = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final WorldGenAbstractTree lllllllllllllIIlIllllIIIIlllIIlI = lllllllllllllIIlIllllIIIIIlIIlII.genBigTreeChance(lllllllllllllIIlIllllIIIlIIIIIII);
            lllllllllllllIIlIllllIIIIlllIIlI.setDecorationDefaults();
            final BlockPos lllllllllllllIIlIllllIIIIlllIIIl = lllllllllllllIIlIllllIIIIIlIIIll.getHeight(this.chunkPos.add(lllllllllllllIIlIllllIIIIlllIlII, 0, lllllllllllllIIlIllllIIIIlllIIll));
            if (lllllllllllllIIlIllllIIIIlllIIlI.generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, lllllllllllllIIlIllllIIIIlllIIIl)) {
                lllllllllllllIIlIllllIIIIlllIIlI.generateSaplings(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, lllllllllllllIIlIllllIIIIlllIIIl);
            }
        }
        for (int lllllllllllllIIlIllllIIIIlllIIII = 0; lllllllllllllIIlIllllIIIIlllIIII < this.bigMushroomsPerChunk; ++lllllllllllllIIlIllllIIIIlllIIII) {
            final int lllllllllllllIIlIllllIIIIllIllll = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIllIlllI = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            this.bigMushroomGen.generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, lllllllllllllIIlIllllIIIIIlIIIll.getHeight(this.chunkPos.add(lllllllllllllIIlIllllIIIIllIllll, 0, lllllllllllllIIlIllllIIIIllIlllI)));
        }
        for (int lllllllllllllIIlIllllIIIIllIllIl = 0; lllllllllllllIIlIllllIIIIllIllIl < this.flowersPerChunk; ++lllllllllllllIIlIllllIIIIllIllIl) {
            final int lllllllllllllIIlIllllIIIIllIllII = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIllIlIll = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIllIlIlI = lllllllllllllIIlIllllIIIIIlIIIll.getHeight(this.chunkPos.add(lllllllllllllIIlIllllIIIIllIllII, 0, lllllllllllllIIlIllllIIIIllIlIll)).getY() + 32;
            if (lllllllllllllIIlIllllIIIIllIlIlI > 0) {
                final int lllllllllllllIIlIllllIIIIllIlIIl = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(lllllllllllllIIlIllllIIIIllIlIlI);
                final BlockPos lllllllllllllIIlIllllIIIIllIlIII = this.chunkPos.add(lllllllllllllIIlIllllIIIIllIllII, lllllllllllllIIlIllllIIIIllIlIIl, lllllllllllllIIlIllllIIIIllIlIll);
                final BlockFlower.EnumFlowerType lllllllllllllIIlIllllIIIIllIIlll = lllllllllllllIIlIllllIIIIIlIIlII.pickRandomFlower(lllllllllllllIIlIllllIIIlIIIIIII, lllllllllllllIIlIllllIIIIllIlIII);
                final BlockFlower lllllllllllllIIlIllllIIIIllIIllI = lllllllllllllIIlIllllIIIIllIIlll.getBlockType().getBlock();
                if (lllllllllllllIIlIllllIIIIllIIllI.getDefaultState().getMaterial() != Material.AIR) {
                    this.yellowFlowerGen.setGeneratedBlock(lllllllllllllIIlIllllIIIIllIIllI, lllllllllllllIIlIllllIIIIllIIlll);
                    this.yellowFlowerGen.generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, lllllllllllllIIlIllllIIIIllIlIII);
                }
            }
        }
        for (int lllllllllllllIIlIllllIIIIllIIlIl = 0; lllllllllllllIIlIllllIIIIllIIlIl < this.grassPerChunk; ++lllllllllllllIIlIllllIIIIllIIlIl) {
            final int lllllllllllllIIlIllllIIIIllIIlII = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIllIIIll = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIllIIIlI = lllllllllllllIIlIllllIIIIIlIIIll.getHeight(this.chunkPos.add(lllllllllllllIIlIllllIIIIllIIlII, 0, lllllllllllllIIlIllllIIIIllIIIll)).getY() * 2;
            if (lllllllllllllIIlIllllIIIIllIIIlI > 0) {
                final int lllllllllllllIIlIllllIIIIllIIIIl = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(lllllllllllllIIlIllllIIIIllIIIlI);
                lllllllllllllIIlIllllIIIIIlIIlII.getRandomWorldGenForGrass(lllllllllllllIIlIllllIIIlIIIIIII).generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, this.chunkPos.add(lllllllllllllIIlIllllIIIIllIIlII, lllllllllllllIIlIllllIIIIllIIIIl, lllllllllllllIIlIllllIIIIllIIIll));
            }
        }
        for (int lllllllllllllIIlIllllIIIIllIIIII = 0; lllllllllllllIIlIllllIIIIllIIIII < this.deadBushPerChunk; ++lllllllllllllIIlIllllIIIIllIIIII) {
            final int lllllllllllllIIlIllllIIIIlIlllll = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIlIllllI = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIlIlllIl = lllllllllllllIIlIllllIIIIIlIIIll.getHeight(this.chunkPos.add(lllllllllllllIIlIllllIIIIlIlllll, 0, lllllllllllllIIlIllllIIIIlIllllI)).getY() * 2;
            if (lllllllllllllIIlIllllIIIIlIlllIl > 0) {
                final int lllllllllllllIIlIllllIIIIlIlllII = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(lllllllllllllIIlIllllIIIIlIlllIl);
                new WorldGenDeadBush().generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, this.chunkPos.add(lllllllllllllIIlIllllIIIIlIlllll, lllllllllllllIIlIllllIIIIlIlllII, lllllllllllllIIlIllllIIIIlIllllI));
            }
        }
        for (int lllllllllllllIIlIllllIIIIlIllIll = 0; lllllllllllllIIlIllllIIIIlIllIll < this.waterlilyPerChunk; ++lllllllllllllIIlIllllIIIIlIllIll) {
            final int lllllllllllllIIlIllllIIIIlIllIlI = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIlIllIIl = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIlIllIII = lllllllllllllIIlIllllIIIIIlIIIll.getHeight(this.chunkPos.add(lllllllllllllIIlIllllIIIIlIllIlI, 0, lllllllllllllIIlIllllIIIIlIllIIl)).getY() * 2;
            if (lllllllllllllIIlIllllIIIIlIllIII > 0) {
                final int lllllllllllllIIlIllllIIIIlIlIlll = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(lllllllllllllIIlIllllIIIIlIllIII);
                BlockPos lllllllllllllIIlIllllIIIIlIlIllI;
                BlockPos lllllllllllllIIlIllllIIIIlIlIlIl;
                for (lllllllllllllIIlIllllIIIIlIlIllI = this.chunkPos.add(lllllllllllllIIlIllllIIIIlIllIlI, lllllllllllllIIlIllllIIIIlIlIlll, lllllllllllllIIlIllllIIIIlIllIIl); lllllllllllllIIlIllllIIIIlIlIllI.getY() > 0; lllllllllllllIIlIllllIIIIlIlIllI = lllllllllllllIIlIllllIIIIlIlIlIl) {
                    lllllllllllllIIlIllllIIIIlIlIlIl = lllllllllllllIIlIllllIIIIlIlIllI.down();
                    if (!lllllllllllllIIlIllllIIIIIlIIIll.isAirBlock(lllllllllllllIIlIllllIIIIlIlIlIl)) {
                        break;
                    }
                }
                this.waterlilyGen.generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, lllllllllllllIIlIllllIIIIlIlIllI);
            }
        }
        for (int lllllllllllllIIlIllllIIIIlIlIlII = 0; lllllllllllllIIlIllllIIIIlIlIlII < this.mushroomsPerChunk; ++lllllllllllllIIlIllllIIIIlIlIlII) {
            if (lllllllllllllIIlIllllIIIlIIIIIII.nextInt(4) == 0) {
                final int lllllllllllllIIlIllllIIIIlIlIIll = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
                final int lllllllllllllIIlIllllIIIIlIlIIlI = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
                final BlockPos lllllllllllllIIlIllllIIIIlIlIIIl = lllllllllllllIIlIllllIIIIIlIIIll.getHeight(this.chunkPos.add(lllllllllllllIIlIllllIIIIlIlIIll, 0, lllllllllllllIIlIllllIIIIlIlIIlI));
                this.mushroomBrownGen.generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, lllllllllllllIIlIllllIIIIlIlIIIl);
            }
            if (lllllllllllllIIlIllllIIIlIIIIIII.nextInt(8) == 0) {
                final int lllllllllllllIIlIllllIIIIlIlIIII = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
                final int lllllllllllllIIlIllllIIIIlIIllll = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
                final int lllllllllllllIIlIllllIIIIlIIlllI = lllllllllllllIIlIllllIIIIIlIIIll.getHeight(this.chunkPos.add(lllllllllllllIIlIllllIIIIlIlIIII, 0, lllllllllllllIIlIllllIIIIlIIllll)).getY() * 2;
                if (lllllllllllllIIlIllllIIIIlIIlllI > 0) {
                    final int lllllllllllllIIlIllllIIIIlIIllIl = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(lllllllllllllIIlIllllIIIIlIIlllI);
                    final BlockPos lllllllllllllIIlIllllIIIIlIIllII = this.chunkPos.add(lllllllllllllIIlIllllIIIIlIlIIII, lllllllllllllIIlIllllIIIIlIIllIl, lllllllllllllIIlIllllIIIIlIIllll);
                    this.mushroomRedGen.generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, lllllllllllllIIlIllllIIIIlIIllII);
                }
            }
        }
        if (lllllllllllllIIlIllllIIIlIIIIIII.nextInt(4) == 0) {
            final int lllllllllllllIIlIllllIIIIlIIlIll = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIlIIlIlI = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIlIIlIIl = lllllllllllllIIlIllllIIIIIlIIIll.getHeight(this.chunkPos.add(lllllllllllllIIlIllllIIIIlIIlIll, 0, lllllllllllllIIlIllllIIIIlIIlIlI)).getY() * 2;
            if (lllllllllllllIIlIllllIIIIlIIlIIl > 0) {
                final int lllllllllllllIIlIllllIIIIlIIlIII = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(lllllllllllllIIlIllllIIIIlIIlIIl);
                this.mushroomBrownGen.generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, this.chunkPos.add(lllllllllllllIIlIllllIIIIlIIlIll, lllllllllllllIIlIllllIIIIlIIlIII, lllllllllllllIIlIllllIIIIlIIlIlI));
            }
        }
        if (lllllllllllllIIlIllllIIIlIIIIIII.nextInt(8) == 0) {
            final int lllllllllllllIIlIllllIIIIlIIIlll = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIlIIIllI = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIlIIIlIl = lllllllllllllIIlIllllIIIIIlIIIll.getHeight(this.chunkPos.add(lllllllllllllIIlIllllIIIIlIIIlll, 0, lllllllllllllIIlIllllIIIIlIIIllI)).getY() * 2;
            if (lllllllllllllIIlIllllIIIIlIIIlIl > 0) {
                final int lllllllllllllIIlIllllIIIIlIIIlII = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(lllllllllllllIIlIllllIIIIlIIIlIl);
                this.mushroomRedGen.generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, this.chunkPos.add(lllllllllllllIIlIllllIIIIlIIIlll, lllllllllllllIIlIllllIIIIlIIIlII, lllllllllllllIIlIllllIIIIlIIIllI));
            }
        }
        for (int lllllllllllllIIlIllllIIIIlIIIIll = 0; lllllllllllllIIlIllllIIIIlIIIIll < this.reedsPerChunk; ++lllllllllllllIIlIllllIIIIlIIIIll) {
            final int lllllllllllllIIlIllllIIIIlIIIIlI = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIlIIIIIl = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIlIIIIII = lllllllllllllIIlIllllIIIIIlIIIll.getHeight(this.chunkPos.add(lllllllllllllIIlIllllIIIIlIIIIlI, 0, lllllllllllllIIlIllllIIIIlIIIIIl)).getY() * 2;
            if (lllllllllllllIIlIllllIIIIlIIIIII > 0) {
                final int lllllllllllllIIlIllllIIIIIllllll = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(lllllllllllllIIlIllllIIIIlIIIIII);
                this.reedGen.generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, this.chunkPos.add(lllllllllllllIIlIllllIIIIlIIIIlI, lllllllllllllIIlIllllIIIIIllllll, lllllllllllllIIlIllllIIIIlIIIIIl));
            }
        }
        for (int lllllllllllllIIlIllllIIIIIlllllI = 0; lllllllllllllIIlIllllIIIIIlllllI < 10; ++lllllllllllllIIlIllllIIIIIlllllI) {
            final int lllllllllllllIIlIllllIIIIIllllIl = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIIllllII = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIIlllIll = lllllllllllllIIlIllllIIIIIlIIIll.getHeight(this.chunkPos.add(lllllllllllllIIlIllllIIIIIllllIl, 0, lllllllllllllIIlIllllIIIIIllllII)).getY() * 2;
            if (lllllllllllllIIlIllllIIIIIlllIll > 0) {
                final int lllllllllllllIIlIllllIIIIIlllIlI = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(lllllllllllllIIlIllllIIIIIlllIll);
                this.reedGen.generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, this.chunkPos.add(lllllllllllllIIlIllllIIIIIllllIl, lllllllllllllIIlIllllIIIIIlllIlI, lllllllllllllIIlIllllIIIIIllllII));
            }
        }
        if (lllllllllllllIIlIllllIIIlIIIIIII.nextInt(32) == 0) {
            final int lllllllllllllIIlIllllIIIIIlllIIl = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIIlllIII = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIIllIlll = lllllllllllllIIlIllllIIIIIlIIIll.getHeight(this.chunkPos.add(lllllllllllllIIlIllllIIIIIlllIIl, 0, lllllllllllllIIlIllllIIIIIlllIII)).getY() * 2;
            if (lllllllllllllIIlIllllIIIIIllIlll > 0) {
                final int lllllllllllllIIlIllllIIIIIllIllI = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(lllllllllllllIIlIllllIIIIIllIlll);
                new WorldGenPumpkin().generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, this.chunkPos.add(lllllllllllllIIlIllllIIIIIlllIIl, lllllllllllllIIlIllllIIIIIllIllI, lllllllllllllIIlIllllIIIIIlllIII));
            }
        }
        for (int lllllllllllllIIlIllllIIIIIllIlIl = 0; lllllllllllllIIlIllllIIIIIllIlIl < this.cactiPerChunk; ++lllllllllllllIIlIllllIIIIIllIlIl) {
            final int lllllllllllllIIlIllllIIIIIllIlII = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIIllIIll = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
            final int lllllllllllllIIlIllllIIIIIllIIlI = lllllllllllllIIlIllllIIIIIlIIIll.getHeight(this.chunkPos.add(lllllllllllllIIlIllllIIIIIllIlII, 0, lllllllllllllIIlIllllIIIIIllIIll)).getY() * 2;
            if (lllllllllllllIIlIllllIIIIIllIIlI > 0) {
                final int lllllllllllllIIlIllllIIIIIllIIIl = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(lllllllllllllIIlIllllIIIIIllIIlI);
                this.cactusGen.generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, this.chunkPos.add(lllllllllllllIIlIllllIIIIIllIlII, lllllllllllllIIlIllllIIIIIllIIIl, lllllllllllllIIlIllllIIIIIllIIll));
            }
        }
        if (this.generateLakes) {
            for (int lllllllllllllIIlIllllIIIIIllIIII = 0; lllllllllllllIIlIllllIIIIIllIIII < 50; ++lllllllllllllIIlIllllIIIIIllIIII) {
                final int lllllllllllllIIlIllllIIIIIlIllll = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
                final int lllllllllllllIIlIllllIIIIIlIlllI = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
                final int lllllllllllllIIlIllllIIIIIlIllIl = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(248) + 8;
                if (lllllllllllllIIlIllllIIIIIlIllIl > 0) {
                    final int lllllllllllllIIlIllllIIIIIlIllII = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(lllllllllllllIIlIllllIIIIIlIllIl);
                    final BlockPos lllllllllllllIIlIllllIIIIIlIlIll = this.chunkPos.add(lllllllllllllIIlIllllIIIIIlIllll, lllllllllllllIIlIllllIIIIIlIllII, lllllllllllllIIlIllllIIIIIlIlllI);
                    new WorldGenLiquids(Blocks.FLOWING_WATER).generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, lllllllllllllIIlIllllIIIIIlIlIll);
                }
            }
            for (int lllllllllllllIIlIllllIIIIIlIlIlI = 0; lllllllllllllIIlIllllIIIIIlIlIlI < 20; ++lllllllllllllIIlIllllIIIIIlIlIlI) {
                final int lllllllllllllIIlIllllIIIIIlIlIIl = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
                final int lllllllllllllIIlIllllIIIIIlIlIII = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(16) + 8;
                final int lllllllllllllIIlIllllIIIIIlIIlll = lllllllllllllIIlIllllIIIlIIIIIII.nextInt(lllllllllllllIIlIllllIIIlIIIIIII.nextInt(lllllllllllllIIlIllllIIIlIIIIIII.nextInt(240) + 8) + 8);
                final BlockPos lllllllllllllIIlIllllIIIIIlIIllI = this.chunkPos.add(lllllllllllllIIlIllllIIIIIlIlIIl, lllllllllllllIIlIllllIIIIIlIIlll, lllllllllllllIIlIllllIIIIIlIlIII);
                new WorldGenLiquids(Blocks.FLOWING_LAVA).generate(lllllllllllllIIlIllllIIIIIlIIIll, lllllllllllllIIlIllllIIIlIIIIIII, lllllllllllllIIlIllllIIIIIlIIllI);
            }
        }
    }
    
    protected void genStandardOre2(final World lllllllllllllIIlIlllIlllllIlllII, final Random lllllllllllllIIlIlllIlllllIllIll, final int lllllllllllllIIlIlllIlllllIllIlI, final WorldGenerator lllllllllllllIIlIlllIlllllIllIIl, final int lllllllllllllIIlIlllIlllllIIlIII, final int lllllllllllllIIlIlllIlllllIIIlll) {
        for (int lllllllllllllIIlIlllIlllllIlIIII = 0; lllllllllllllIIlIlllIlllllIlIIII < lllllllllllllIIlIlllIlllllIllIlI; ++lllllllllllllIIlIlllIlllllIlIIII) {
            final BlockPos lllllllllllllIIlIlllIlllllIIlllI = this.chunkPos.add(lllllllllllllIIlIlllIlllllIllIll.nextInt(16), lllllllllllllIIlIlllIlllllIllIll.nextInt(lllllllllllllIIlIlllIlllllIIIlll) + lllllllllllllIIlIlllIlllllIllIll.nextInt(lllllllllllllIIlIlllIlllllIIIlll) + lllllllllllllIIlIlllIlllllIIlIII - lllllllllllllIIlIlllIlllllIIIlll, lllllllllllllIIlIlllIlllllIllIll.nextInt(16));
            lllllllllllllIIlIlllIlllllIllIIl.generate(lllllllllllllIIlIlllIlllllIlllII, lllllllllllllIIlIlllIlllllIllIll, lllllllllllllIIlIlllIlllllIIlllI);
        }
    }
    
    protected void generateOres(final World lllllllllllllIIlIllllIIIIIIlIlII, final Random lllllllllllllIIlIllllIIIIIIlIIll) {
        this.genStandardOre1(lllllllllllllIIlIllllIIIIIIlIlII, lllllllllllllIIlIllllIIIIIIlIIll, this.chunkProviderSettings.dirtCount, this.dirtGen, this.chunkProviderSettings.dirtMinHeight, this.chunkProviderSettings.dirtMaxHeight);
        this.genStandardOre1(lllllllllllllIIlIllllIIIIIIlIlII, lllllllllllllIIlIllllIIIIIIlIIll, this.chunkProviderSettings.gravelCount, this.gravelGen, this.chunkProviderSettings.gravelMinHeight, this.chunkProviderSettings.gravelMaxHeight);
        this.genStandardOre1(lllllllllllllIIlIllllIIIIIIlIlII, lllllllllllllIIlIllllIIIIIIlIIll, this.chunkProviderSettings.dioriteCount, this.dioriteGen, this.chunkProviderSettings.dioriteMinHeight, this.chunkProviderSettings.dioriteMaxHeight);
        this.genStandardOre1(lllllllllllllIIlIllllIIIIIIlIlII, lllllllllllllIIlIllllIIIIIIlIIll, this.chunkProviderSettings.graniteCount, this.graniteGen, this.chunkProviderSettings.graniteMinHeight, this.chunkProviderSettings.graniteMaxHeight);
        this.genStandardOre1(lllllllllllllIIlIllllIIIIIIlIlII, lllllllllllllIIlIllllIIIIIIlIIll, this.chunkProviderSettings.andesiteCount, this.andesiteGen, this.chunkProviderSettings.andesiteMinHeight, this.chunkProviderSettings.andesiteMaxHeight);
        this.genStandardOre1(lllllllllllllIIlIllllIIIIIIlIlII, lllllllllllllIIlIllllIIIIIIlIIll, this.chunkProviderSettings.coalCount, this.coalGen, this.chunkProviderSettings.coalMinHeight, this.chunkProviderSettings.coalMaxHeight);
        this.genStandardOre1(lllllllllllllIIlIllllIIIIIIlIlII, lllllllllllllIIlIllllIIIIIIlIIll, this.chunkProviderSettings.ironCount, this.ironGen, this.chunkProviderSettings.ironMinHeight, this.chunkProviderSettings.ironMaxHeight);
        this.genStandardOre1(lllllllllllllIIlIllllIIIIIIlIlII, lllllllllllllIIlIllllIIIIIIlIIll, this.chunkProviderSettings.goldCount, this.goldGen, this.chunkProviderSettings.goldMinHeight, this.chunkProviderSettings.goldMaxHeight);
        this.genStandardOre1(lllllllllllllIIlIllllIIIIIIlIlII, lllllllllllllIIlIllllIIIIIIlIIll, this.chunkProviderSettings.redstoneCount, this.redstoneGen, this.chunkProviderSettings.redstoneMinHeight, this.chunkProviderSettings.redstoneMaxHeight);
        this.genStandardOre1(lllllllllllllIIlIllllIIIIIIlIlII, lllllllllllllIIlIllllIIIIIIlIIll, this.chunkProviderSettings.diamondCount, this.diamondGen, this.chunkProviderSettings.diamondMinHeight, this.chunkProviderSettings.diamondMaxHeight);
        this.genStandardOre2(lllllllllllllIIlIllllIIIIIIlIlII, lllllllllllllIIlIllllIIIIIIlIIll, this.chunkProviderSettings.lapisCount, this.lapisGen, this.chunkProviderSettings.lapisCenterHeight, this.chunkProviderSettings.lapisSpread);
    }
}
