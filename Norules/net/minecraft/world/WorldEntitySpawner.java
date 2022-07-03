package net.minecraft.world;

import net.minecraft.world.biome.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.*;

public final class WorldEntitySpawner
{
    private final /* synthetic */ Set<ChunkPos> eligibleChunksForSpawning;
    
    public static void performWorldGenSpawning(final World llllllllllllllIIllIIllIIIIlIIIIl, final Biome llllllllllllllIIllIIllIIIIllIllI, final int llllllllllllllIIllIIllIIIIIlllll, final int llllllllllllllIIllIIllIIIIIllllI, final int llllllllllllllIIllIIllIIIIllIIll, final int llllllllllllllIIllIIllIIIIllIIlI, final Random llllllllllllllIIllIIllIIIIllIIIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getstatic       net/minecraft/entity/EnumCreatureType.CREATURE:Lnet/minecraft/entity/EnumCreatureType;
        //     4: invokevirtual   net/minecraft/world/biome/Biome.getSpawnableList:(Lnet/minecraft/entity/EnumCreatureType;)Ljava/util/List;
        //     7: astore          llllllllllllllIIllIIllIIIIllIIII
        //     9: aload           llllllllllllllIIllIIllIIIIllIIII
        //    11: invokeinterface java/util/List.isEmpty:()Z
        //    16: ifne            394
        //    19: goto            381
        //    22: aload_0         /* llllllllllllllIIllIIllIIIIllIlll */
        //    23: getfield        net/minecraft/world/World.rand:Ljava/util/Random;
        //    26: aload           llllllllllllllIIllIIllIIIIllIIII
        //    28: invokestatic    net/minecraft/util/WeightedRandom.getRandomItem:(Ljava/util/Random;Ljava/util/List;)Lnet/minecraft/util/WeightedRandom$Item;
        //    31: checkcast       Lnet/minecraft/world/biome/Biome$SpawnListEntry;
        //    34: astore          llllllllllllllIIllIIllIIIIlIllll
        //    36: aload           llllllllllllllIIllIIllIIIIlIllll
        //    38: getfield        net/minecraft/world/biome/Biome$SpawnListEntry.minGroupCount:I
        //    41: aload           llllllllllllllIIllIIllIIIIIllIll
        //    43: iconst_1       
        //    44: aload           llllllllllllllIIllIIllIIIIlIllll
        //    46: getfield        net/minecraft/world/biome/Biome$SpawnListEntry.maxGroupCount:I
        //    49: iadd           
        //    50: aload           llllllllllllllIIllIIllIIIIlIllll
        //    52: getfield        net/minecraft/world/biome/Biome$SpawnListEntry.minGroupCount:I
        //    55: isub           
        //    56: invokevirtual   java/util/Random.nextInt:(I)I
        //    59: iadd           
        //    60: istore          llllllllllllllIIllIIllIIIIlIlllI
        //    62: aconst_null    
        //    63: astore          llllllllllllllIIllIIllIIIIlIllIl
        //    65: iload_2         /* llllllllllllllIIllIIllIIIIllIlIl */
        //    66: aload           llllllllllllllIIllIIllIIIIIllIll
        //    68: iload           llllllllllllllIIllIIllIIIIIlllIl
        //    70: invokevirtual   java/util/Random.nextInt:(I)I
        //    73: iadd           
        //    74: istore          llllllllllllllIIllIIllIIIIlIllII
        //    76: iload_3         /* llllllllllllllIIllIIllIIIIllIlII */
        //    77: aload           llllllllllllllIIllIIllIIIIIllIll
        //    79: iload           llllllllllllllIIllIIllIIIIIlllII
        //    81: invokevirtual   java/util/Random.nextInt:(I)I
        //    84: iadd           
        //    85: istore          llllllllllllllIIllIIllIIIIlIlIll
        //    87: iload           llllllllllllllIIllIIllIIIIlIllII
        //    89: istore          llllllllllllllIIllIIllIIIIlIlIlI
        //    91: iload           llllllllllllllIIllIIllIIIIlIlIll
        //    93: istore          llllllllllllllIIllIIllIIIIlIlIIl
        //    95: iconst_0       
        //    96: istore          llllllllllllllIIllIIllIIIIlIlIII
        //    98: goto            374
        //   101: iconst_0       
        //   102: istore          llllllllllllllIIllIIllIIIIlIIlll
        //   104: iconst_0       
        //   105: istore          llllllllllllllIIllIIllIIIIlIIllI
        //   107: goto            360
        //   110: aload_0         /* llllllllllllllIIllIIllIIIIllIlll */
        //   111: new             Lnet/minecraft/util/math/BlockPos;
        //   114: dup            
        //   115: iload           llllllllllllllIIllIIllIIIIlIllII
        //   117: iconst_0       
        //   118: iload           llllllllllllllIIllIIllIIIIlIlIll
        //   120: invokespecial   net/minecraft/util/math/BlockPos.<init>:(III)V
        //   123: invokevirtual   net/minecraft/world/World.getTopSolidOrLiquidBlock:(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/util/math/BlockPos;
        //   126: astore          llllllllllllllIIllIIllIIIIlIIlIl
        //   128: getstatic       net/minecraft/entity/EntityLiving$SpawnPlacementType.ON_GROUND:Lnet/minecraft/entity/EntityLiving$SpawnPlacementType;
        //   131: aload_0         /* llllllllllllllIIllIIllIIIIllIlll */
        //   132: aload           llllllllllllllIIllIIllIIIIlIIlIl
        //   134: invokestatic    net/minecraft/world/WorldEntitySpawner.canCreatureTypeSpawnAtLocation:(Lnet/minecraft/entity/EntityLiving$SpawnPlacementType;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)Z
        //   137: ifeq            252
        //   140: aload           llllllllllllllIIllIIllIIIIlIllll
        //   142: getfield        net/minecraft/world/biome/Biome$SpawnListEntry.entityClass:Ljava/lang/Class;
        //   145: iconst_1       
        //   146: anewarray       Ljava/lang/Class;
        //   149: dup            
        //   150: iconst_0       
        //   151: ldc             Lnet/minecraft/world/World;.class
        //   153: aastore        
        //   154: invokevirtual   java/lang/Class.getConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //   157: iconst_1       
        //   158: anewarray       Ljava/lang/Object;
        //   161: dup            
        //   162: iconst_0       
        //   163: aload_0         /* llllllllllllllIIllIIllIIIIllIlll */
        //   164: aastore        
        //   165: invokevirtual   java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
        //   168: checkcast       Lnet/minecraft/entity/EntityLiving;
        //   171: astore          llllllllllllllIIllIIllIIIIlIIlII
        //   173: goto            186
        //   176: astore          llllllllllllllIIllIIllIIIIlIIIlI
        //   178: aload           llllllllllllllIIllIIllIIIIlIIIlI
        //   180: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   183: goto            357
        //   186: aload           llllllllllllllIIllIIllIIIIlIIIll
        //   188: iload           llllllllllllllIIllIIllIIIIlIllII
        //   190: i2f            
        //   191: ldc             0.5
        //   193: fadd           
        //   194: f2d            
        //   195: aload           llllllllllllllIIllIIllIIIIlIIlIl
        //   197: invokevirtual   net/minecraft/util/math/BlockPos.getY:()I
        //   200: i2d            
        //   201: iload           llllllllllllllIIllIIllIIIIlIlIll
        //   203: i2f            
        //   204: ldc             0.5
        //   206: fadd           
        //   207: f2d            
        //   208: aload           llllllllllllllIIllIIllIIIIIllIll
        //   210: invokevirtual   java/util/Random.nextFloat:()F
        //   213: ldc             360.0
        //   215: fmul           
        //   216: fconst_0       
        //   217: invokevirtual   net/minecraft/entity/EntityLiving.setLocationAndAngles:(DDDFF)V
        //   220: aload_0         /* llllllllllllllIIllIIllIIIIllIlll */
        //   221: aload           llllllllllllllIIllIIllIIIIlIIIll
        //   223: invokevirtual   net/minecraft/world/World.spawnEntityInWorld:(Lnet/minecraft/entity/Entity;)Z
        //   226: pop            
        //   227: aload           llllllllllllllIIllIIllIIIIlIIIll
        //   229: aload_0         /* llllllllllllllIIllIIllIIIIllIlll */
        //   230: new             Lnet/minecraft/util/math/BlockPos;
        //   233: dup            
        //   234: aload           llllllllllllllIIllIIllIIIIlIIIll
        //   236: invokespecial   net/minecraft/util/math/BlockPos.<init>:(Lnet/minecraft/entity/Entity;)V
        //   239: invokevirtual   net/minecraft/world/World.getDifficultyForLocation:(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/world/DifficultyInstance;
        //   242: aload           llllllllllllllIIllIIllIIIIlIllIl
        //   244: invokevirtual   net/minecraft/entity/EntityLiving.onInitialSpawn:(Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/entity/IEntityLivingData;)Lnet/minecraft/entity/IEntityLivingData;
        //   247: astore          llllllllllllllIIllIIllIIIIlIllIl
        //   249: iconst_1       
        //   250: istore          llllllllllllllIIllIIllIIIIlIIlll
        //   252: iload           llllllllllllllIIllIIllIIIIlIllII
        //   254: aload           llllllllllllllIIllIIllIIIIIllIll
        //   256: iconst_5       
        //   257: invokevirtual   java/util/Random.nextInt:(I)I
        //   260: aload           llllllllllllllIIllIIllIIIIIllIll
        //   262: iconst_5       
        //   263: invokevirtual   java/util/Random.nextInt:(I)I
        //   266: isub           
        //   267: iadd           
        //   268: istore          llllllllllllllIIllIIllIIIIlIllII
        //   270: iload           llllllllllllllIIllIIllIIIIlIlIll
        //   272: aload           llllllllllllllIIllIIllIIIIIllIll
        //   274: iconst_5       
        //   275: invokevirtual   java/util/Random.nextInt:(I)I
        //   278: aload           llllllllllllllIIllIIllIIIIIllIll
        //   280: iconst_5       
        //   281: invokevirtual   java/util/Random.nextInt:(I)I
        //   284: isub           
        //   285: iadd           
        //   286: istore          llllllllllllllIIllIIllIIIIlIlIll
        //   288: goto            327
        //   291: iload           llllllllllllllIIllIIllIIIIlIlIlI
        //   293: aload           llllllllllllllIIllIIllIIIIIllIll
        //   295: iconst_5       
        //   296: invokevirtual   java/util/Random.nextInt:(I)I
        //   299: iadd           
        //   300: aload           llllllllllllllIIllIIllIIIIIllIll
        //   302: iconst_5       
        //   303: invokevirtual   java/util/Random.nextInt:(I)I
        //   306: isub           
        //   307: istore          llllllllllllllIIllIIllIIIIlIllII
        //   309: iload           llllllllllllllIIllIIllIIIIlIlIIl
        //   311: aload           llllllllllllllIIllIIllIIIIIllIll
        //   313: iconst_5       
        //   314: invokevirtual   java/util/Random.nextInt:(I)I
        //   317: iadd           
        //   318: aload           llllllllllllllIIllIIllIIIIIllIll
        //   320: iconst_5       
        //   321: invokevirtual   java/util/Random.nextInt:(I)I
        //   324: isub           
        //   325: istore          llllllllllllllIIllIIllIIIIlIlIll
        //   327: iload           llllllllllllllIIllIIllIIIIlIllII
        //   329: iload_2         /* llllllllllllllIIllIIllIIIIllIlIl */
        //   330: if_icmplt       291
        //   333: iload           llllllllllllllIIllIIllIIIIlIllII
        //   335: iload_2         /* llllllllllllllIIllIIllIIIIllIlIl */
        //   336: iload           llllllllllllllIIllIIllIIIIIlllIl
        //   338: iadd           
        //   339: if_icmpge       291
        //   342: iload           llllllllllllllIIllIIllIIIIlIlIll
        //   344: iload_3         /* llllllllllllllIIllIIllIIIIllIlII */
        //   345: if_icmplt       291
        //   348: iload           llllllllllllllIIllIIllIIIIlIlIll
        //   350: iload_3         /* llllllllllllllIIllIIllIIIIllIlII */
        //   351: iload           llllllllllllllIIllIIllIIIIIlllIl
        //   353: iadd           
        //   354: if_icmpge       291
        //   357: iinc            llllllllllllllIIllIIllIIIIlIIllI, 1
        //   360: iload           llllllllllllllIIllIIllIIIIlIIlll
        //   362: ifne            371
        //   365: iload           llllllllllllllIIllIIllIIIIlIIllI
        //   367: iconst_4       
        //   368: if_icmplt       110
        //   371: iinc            llllllllllllllIIllIIllIIIIlIlIII, 1
        //   374: iload           llllllllllllllIIllIIllIIIIlIlIII
        //   376: iload           llllllllllllllIIllIIllIIIIlIlllI
        //   378: if_icmplt       101
        //   381: aload           llllllllllllllIIllIIllIIIIIllIll
        //   383: invokevirtual   java/util/Random.nextFloat:()F
        //   386: aload_1         /* llllllllllllllIIllIIllIIIIlIIIII */
        //   387: invokevirtual   net/minecraft/world/biome/Biome.getSpawningChance:()F
        //   390: fcmpg          
        //   391: iflt            22
        //   394: return         
        //    StackMapTable: 00 0E FC 00 16 07 00 2D FF 00 4E 00 10 07 00 33 07 00 0D 01 01 01 01 07 00 43 07 00 2D 07 00 0B 01 07 00 C8 01 01 01 01 01 00 00 FD 00 08 01 01 FF 00 41 00 13 07 00 33 07 00 0D 01 01 01 01 07 00 43 07 00 2D 07 00 0B 01 07 00 C8 01 01 01 01 01 01 01 07 00 17 00 01 07 00 21 FC 00 09 07 00 08 FA 00 41 26 23 1D FA 00 02 0A F9 00 02 FF 00 06 00 08 07 00 33 07 00 0D 01 01 01 01 07 00 43 07 00 2D 00 00 0C
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  140    173    176    186    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public WorldEntitySpawner() {
        this.eligibleChunksForSpawning = (Set<ChunkPos>)Sets.newHashSet();
    }
    
    public static boolean canCreatureTypeSpawnAtLocation(final EntityLiving.SpawnPlacementType llllllllllllllIIllIIllIIIlIllIlI, final World llllllllllllllIIllIIllIIIlIllIIl, final BlockPos llllllllllllllIIllIIllIIIlIllIII) {
        if (!llllllllllllllIIllIIllIIIlIllIIl.getWorldBorder().contains(llllllllllllllIIllIIllIIIlIllIII)) {
            return false;
        }
        final IBlockState llllllllllllllIIllIIllIIIlIlIlll = llllllllllllllIIllIIllIIIlIllIIl.getBlockState(llllllllllllllIIllIIllIIIlIllIII);
        if (llllllllllllllIIllIIllIIIlIllIlI == EntityLiving.SpawnPlacementType.IN_WATER) {
            return llllllllllllllIIllIIllIIIlIlIlll.getMaterial() == Material.WATER && llllllllllllllIIllIIllIIIlIllIIl.getBlockState(llllllllllllllIIllIIllIIIlIllIII.down()).getMaterial() == Material.WATER && !llllllllllllllIIllIIllIIIlIllIIl.getBlockState(llllllllllllllIIllIIllIIIlIllIII.up()).isNormalCube();
        }
        final BlockPos llllllllllllllIIllIIllIIIlIlIllI = llllllllllllllIIllIIllIIIlIllIII.down();
        if (!llllllllllllllIIllIIllIIIlIllIIl.getBlockState(llllllllllllllIIllIIllIIIlIlIllI).isFullyOpaque()) {
            return false;
        }
        final Block llllllllllllllIIllIIllIIIlIlIlIl = llllllllllllllIIllIIllIIIlIllIIl.getBlockState(llllllllllllllIIllIIllIIIlIlIllI).getBlock();
        final boolean llllllllllllllIIllIIllIIIlIlIlII = llllllllllllllIIllIIllIIIlIlIlIl != Blocks.BEDROCK && llllllllllllllIIllIIllIIIlIlIlIl != Blocks.BARRIER;
        return llllllllllllllIIllIIllIIIlIlIlII && isValidEmptySpawnBlock(llllllllllllllIIllIIllIIIlIlIlll) && isValidEmptySpawnBlock(llllllllllllllIIllIIllIIIlIllIIl.getBlockState(llllllllllllllIIllIIllIIIlIllIII.up()));
    }
    
    private static BlockPos getRandomChunkPosition(final World llllllllllllllIIllIIllIIIlllIlII, final int llllllllllllllIIllIIllIIIlllIIll, final int llllllllllllllIIllIIllIIIllIlIlI) {
        final Chunk llllllllllllllIIllIIllIIIlllIIIl = llllllllllllllIIllIIllIIIlllIlII.getChunkFromChunkCoords(llllllllllllllIIllIIllIIIlllIIll, llllllllllllllIIllIIllIIIllIlIlI);
        final int llllllllllllllIIllIIllIIIlllIIII = llllllllllllllIIllIIllIIIlllIIll * 16 + llllllllllllllIIllIIllIIIlllIlII.rand.nextInt(16);
        final int llllllllllllllIIllIIllIIIllIllll = llllllllllllllIIllIIllIIIllIlIlI * 16 + llllllllllllllIIllIIllIIIlllIlII.rand.nextInt(16);
        final int llllllllllllllIIllIIllIIIllIlllI = MathHelper.roundUp(llllllllllllllIIllIIllIIIlllIIIl.getHeight(new BlockPos(llllllllllllllIIllIIllIIIlllIIII, 0, llllllllllllllIIllIIllIIIllIllll)) + 1, 16);
        final int llllllllllllllIIllIIllIIIllIllIl = llllllllllllllIIllIIllIIIlllIlII.rand.nextInt((llllllllllllllIIllIIllIIIllIlllI > 0) ? llllllllllllllIIllIIllIIIllIlllI : (llllllllllllllIIllIIllIIIlllIIIl.getTopFilledSegment() + 16 - 1));
        return new BlockPos(llllllllllllllIIllIIllIIIlllIIII, llllllllllllllIIllIIllIIIllIllIl, llllllllllllllIIllIIllIIIllIllll);
    }
    
    public int findChunksForSpawning(final WorldServer llllllllllllllIIllIIllIIlIIlllll, final boolean llllllllllllllIIllIIllIIllIIlIII, final boolean llllllllllllllIIllIIllIIlIIlllIl, final boolean llllllllllllllIIllIIllIIlIIlllII) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifne            10
        //     4: iload_3         /* llllllllllllllIIllIIllIIllIIIlll */
        //     5: ifne            10
        //     8: iconst_0       
        //     9: ireturn        
        //    10: aload_0         /* llllllllllllllIIllIIllIIlIlIIIII */
        //    11: getfield        net/minecraft/world/WorldEntitySpawner.eligibleChunksForSpawning:Ljava/util/Set;
        //    14: invokeinterface java/util/Set.clear:()V
        //    19: iconst_0       
        //    20: istore          llllllllllllllIIllIIllIIllIIIlIl
        //    22: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //    23: getfield        net/minecraft/world/WorldServer.playerEntities:Ljava/util/List;
        //    26: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //    31: astore          7
        //    33: goto            254
        //    36: aload           7
        //    38: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    43: checkcast       Lnet/minecraft/entity/player/EntityPlayer;
        //    46: astore          llllllllllllllIIllIIllIIllIIIlII
        //    48: aload           llllllllllllllIIllIIllIIllIIIlII
        //    50: invokevirtual   net/minecraft/entity/player/EntityPlayer.isSpectator:()Z
        //    53: ifne            254
        //    56: aload           llllllllllllllIIllIIllIIllIIIlII
        //    58: getfield        net/minecraft/entity/player/EntityPlayer.posX:D
        //    61: ldc2_w          16.0
        //    64: ddiv           
        //    65: invokestatic    net/minecraft/util/math/MathHelper.floor:(D)I
        //    68: istore          llllllllllllllIIllIIllIIllIIIIll
        //    70: aload           llllllllllllllIIllIIllIIllIIIlII
        //    72: getfield        net/minecraft/entity/player/EntityPlayer.posZ:D
        //    75: ldc2_w          16.0
        //    78: ddiv           
        //    79: invokestatic    net/minecraft/util/math/MathHelper.floor:(D)I
        //    82: istore          llllllllllllllIIllIIllIIllIIIIlI
        //    84: bipush          8
        //    86: istore          llllllllllllllIIllIIllIIllIIIIIl
        //    88: bipush          -8
        //    90: istore          llllllllllllllIIllIIllIIllIIIIII
        //    92: goto            247
        //    95: bipush          -8
        //    97: istore          llllllllllllllIIllIIllIIlIllllll
        //    99: goto            237
        //   102: iload           llllllllllllllIIllIIllIIllIIIIII
        //   104: bipush          -8
        //   106: if_icmpeq       134
        //   109: iload           llllllllllllllIIllIIllIIllIIIIII
        //   111: bipush          8
        //   113: if_icmpeq       134
        //   116: iload           llllllllllllllIIllIIllIIlIllllll
        //   118: bipush          -8
        //   120: if_icmpeq       134
        //   123: iload           llllllllllllllIIllIIllIIlIllllll
        //   125: bipush          8
        //   127: if_icmpeq       134
        //   130: iconst_0       
        //   131: goto            135
        //   134: iconst_1       
        //   135: istore          llllllllllllllIIllIIllIIlIlllllI
        //   137: new             Lnet/minecraft/util/math/ChunkPos;
        //   140: dup            
        //   141: iload           llllllllllllllIIllIIllIIllIIIIII
        //   143: iload           llllllllllllllIIllIIllIIllIIIIll
        //   145: iadd           
        //   146: iload           llllllllllllllIIllIIllIIlIllllll
        //   148: iload           llllllllllllllIIllIIllIIllIIIIlI
        //   150: iadd           
        //   151: invokespecial   net/minecraft/util/math/ChunkPos.<init>:(II)V
        //   154: astore          llllllllllllllIIllIIllIIlIllllIl
        //   156: aload_0         /* llllllllllllllIIllIIllIIlIlIIIII */
        //   157: getfield        net/minecraft/world/WorldEntitySpawner.eligibleChunksForSpawning:Ljava/util/Set;
        //   160: aload           llllllllllllllIIllIIllIIlIllllIl
        //   162: invokeinterface java/util/Set.contains:(Ljava/lang/Object;)Z
        //   167: ifne            234
        //   170: iinc            llllllllllllllIIllIIllIIllIIIlIl, 1
        //   173: iload           llllllllllllllIIllIIllIIlIlllllI
        //   175: ifne            234
        //   178: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   179: invokevirtual   net/minecraft/world/WorldServer.getWorldBorder:()Lnet/minecraft/world/border/WorldBorder;
        //   182: aload           llllllllllllllIIllIIllIIlIllllIl
        //   184: invokevirtual   net/minecraft/world/border/WorldBorder.contains:(Lnet/minecraft/util/math/ChunkPos;)Z
        //   187: ifeq            234
        //   190: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   191: invokevirtual   net/minecraft/world/WorldServer.getPlayerChunkMap:()Lnet/minecraft/server/management/PlayerChunkMap;
        //   194: aload           llllllllllllllIIllIIllIIlIllllIl
        //   196: getfield        net/minecraft/util/math/ChunkPos.chunkXPos:I
        //   199: aload           llllllllllllllIIllIIllIIlIllllIl
        //   201: getfield        net/minecraft/util/math/ChunkPos.chunkZPos:I
        //   204: invokevirtual   net/minecraft/server/management/PlayerChunkMap.getEntry:(II)Lnet/minecraft/server/management/PlayerChunkMapEntry;
        //   207: astore          llllllllllllllIIllIIllIIlIllllII
        //   209: aload           llllllllllllllIIllIIllIIlIllllII
        //   211: ifnull          234
        //   214: aload           llllllllllllllIIllIIllIIlIllllII
        //   216: invokevirtual   net/minecraft/server/management/PlayerChunkMapEntry.isSentToPlayers:()Z
        //   219: ifeq            234
        //   222: aload_0         /* llllllllllllllIIllIIllIIlIlIIIII */
        //   223: getfield        net/minecraft/world/WorldEntitySpawner.eligibleChunksForSpawning:Ljava/util/Set;
        //   226: aload           llllllllllllllIIllIIllIIlIllllIl
        //   228: invokeinterface java/util/Set.add:(Ljava/lang/Object;)Z
        //   233: pop            
        //   234: iinc            llllllllllllllIIllIIllIIlIllllll, 1
        //   237: iload           llllllllllllllIIllIIllIIlIllllll
        //   239: bipush          8
        //   241: if_icmple       102
        //   244: iinc            llllllllllllllIIllIIllIIllIIIIII, 1
        //   247: iload           llllllllllllllIIllIIllIIllIIIIII
        //   249: bipush          8
        //   251: if_icmple       95
        //   254: aload           7
        //   256: invokeinterface java/util/Iterator.hasNext:()Z
        //   261: ifne            36
        //   264: iconst_0       
        //   265: istore          llllllllllllllIIllIIllIIlIlllIll
        //   267: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   268: invokevirtual   net/minecraft/world/WorldServer.getSpawnPoint:()Lnet/minecraft/util/math/BlockPos;
        //   271: astore          llllllllllllllIIllIIllIIlIlllIlI
        //   273: invokestatic    net/minecraft/entity/EnumCreatureType.values:()[Lnet/minecraft/entity/EnumCreatureType;
        //   276: dup            
        //   277: astore          llllllllllllllIIllIIllIIlIIlIlIl
        //   279: arraylength    
        //   280: istore          10
        //   282: iconst_0       
        //   283: istore          9
        //   285: goto            881
        //   288: aload           llllllllllllllIIllIIllIIlIIlIlIl
        //   290: iload           9
        //   292: aaload         
        //   293: astore          llllllllllllllIIllIIllIIlIlllIIl
        //   295: aload           llllllllllllllIIllIIllIIlIlllIIl
        //   297: invokevirtual   net/minecraft/entity/EnumCreatureType.getPeacefulCreature:()Z
        //   300: ifeq            307
        //   303: iload_3         /* llllllllllllllIIllIIllIIllIIIlll */
        //   304: ifeq            878
        //   307: aload           llllllllllllllIIllIIllIIlIlllIIl
        //   309: invokevirtual   net/minecraft/entity/EnumCreatureType.getPeacefulCreature:()Z
        //   312: ifne            319
        //   315: iload_2         /* llllllllllllllIIllIIllIIlIIllllI */
        //   316: ifeq            878
        //   319: aload           llllllllllllllIIllIIllIIlIlllIIl
        //   321: invokevirtual   net/minecraft/entity/EnumCreatureType.getAnimal:()Z
        //   324: ifeq            332
        //   327: iload           llllllllllllllIIllIIllIIllIIIllI
        //   329: ifeq            878
        //   332: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   333: aload           llllllllllllllIIllIIllIIlIlllIIl
        //   335: invokevirtual   net/minecraft/entity/EnumCreatureType.getCreatureClass:()Ljava/lang/Class;
        //   338: invokevirtual   net/minecraft/world/WorldServer.countEntities:(Ljava/lang/Class;)I
        //   341: istore          llllllllllllllIIllIIllIIlIlllIII
        //   343: aload           llllllllllllllIIllIIllIIlIlllIIl
        //   345: invokevirtual   net/minecraft/entity/EnumCreatureType.getMaxNumberOfCreature:()I
        //   348: iload           llllllllllllllIIllIIllIIllIIIlIl
        //   350: imul           
        //   351: getstatic       net/minecraft/world/WorldEntitySpawner.MOB_COUNT_DIV:I
        //   354: idiv           
        //   355: istore          llllllllllllllIIllIIllIIlIllIlll
        //   357: iload           llllllllllllllIIllIIllIIlIlllIII
        //   359: iload           llllllllllllllIIllIIllIIlIllIlll
        //   361: if_icmpgt       878
        //   364: new             Lnet/minecraft/util/math/BlockPos$MutableBlockPos;
        //   367: dup            
        //   368: invokespecial   net/minecraft/util/math/BlockPos$MutableBlockPos.<init>:()V
        //   371: astore          llllllllllllllIIllIIllIIlIllIllI
        //   373: aload_0         /* llllllllllllllIIllIIllIIlIlIIIII */
        //   374: getfield        net/minecraft/world/WorldEntitySpawner.eligibleChunksForSpawning:Ljava/util/Set;
        //   377: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   382: astore          llllllllllllllIIllIIllIIlIIlIIII
        //   384: goto            868
        //   387: aload           llllllllllllllIIllIIllIIlIIlIIII
        //   389: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   394: checkcast       Lnet/minecraft/util/math/ChunkPos;
        //   397: astore          llllllllllllllIIllIIllIIlIllIlIl
        //   399: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   400: aload           llllllllllllllIIllIIllIIlIllIlIl
        //   402: getfield        net/minecraft/util/math/ChunkPos.chunkXPos:I
        //   405: aload           llllllllllllllIIllIIllIIlIllIlIl
        //   407: getfield        net/minecraft/util/math/ChunkPos.chunkZPos:I
        //   410: invokestatic    net/minecraft/world/WorldEntitySpawner.getRandomChunkPosition:(Lnet/minecraft/world/World;II)Lnet/minecraft/util/math/BlockPos;
        //   413: astore          llllllllllllllIIllIIllIIlIllIlII
        //   415: aload           llllllllllllllIIllIIllIIlIllIlII
        //   417: invokevirtual   net/minecraft/util/math/BlockPos.getX:()I
        //   420: istore          llllllllllllllIIllIIllIIlIllIIll
        //   422: aload           llllllllllllllIIllIIllIIlIllIlII
        //   424: invokevirtual   net/minecraft/util/math/BlockPos.getY:()I
        //   427: istore          llllllllllllllIIllIIllIIlIllIIlI
        //   429: aload           llllllllllllllIIllIIllIIlIllIlII
        //   431: invokevirtual   net/minecraft/util/math/BlockPos.getZ:()I
        //   434: istore          llllllllllllllIIllIIllIIlIllIIIl
        //   436: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   437: aload           llllllllllllllIIllIIllIIlIllIlII
        //   439: invokevirtual   net/minecraft/world/WorldServer.getBlockState:(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/state/IBlockState;
        //   442: astore          llllllllllllllIIllIIllIIlIllIIII
        //   444: aload           llllllllllllllIIllIIllIIlIllIIII
        //   446: invokeinterface net/minecraft/block/state/IBlockState.isNormalCube:()Z
        //   451: ifne            868
        //   454: iconst_0       
        //   455: istore          llllllllllllllIIllIIllIIlIlIllll
        //   457: iconst_0       
        //   458: istore          llllllllllllllIIllIIllIIlIlIlllI
        //   460: goto            862
        //   463: iload           llllllllllllllIIllIIllIIlIllIIll
        //   465: istore          llllllllllllllIIllIIllIIlIlIllIl
        //   467: iload           llllllllllllllIIllIIllIIlIllIIlI
        //   469: istore          llllllllllllllIIllIIllIIlIlIllII
        //   471: iload           llllllllllllllIIllIIllIIlIllIIIl
        //   473: istore          llllllllllllllIIllIIllIIlIlIlIll
        //   475: bipush          6
        //   477: istore          llllllllllllllIIllIIllIIlIlIlIlI
        //   479: aconst_null    
        //   480: astore          llllllllllllllIIllIIllIIlIlIlIIl
        //   482: aconst_null    
        //   483: astore          llllllllllllllIIllIIllIIlIlIlIII
        //   485: invokestatic    java/lang/Math.random:()D
        //   488: ldc2_w          4.0
        //   491: dmul           
        //   492: invokestatic    net/minecraft/util/math/MathHelper.ceil:(D)I
        //   495: istore          llllllllllllllIIllIIllIIlIlIIlll
        //   497: iconst_0       
        //   498: istore          llllllllllllllIIllIIllIIlIlIIllI
        //   500: goto            852
        //   503: iload           llllllllllllllIIllIIllIIlIlIllIl
        //   505: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   506: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   509: bipush          6
        //   511: invokevirtual   java/util/Random.nextInt:(I)I
        //   514: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   515: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   518: bipush          6
        //   520: invokevirtual   java/util/Random.nextInt:(I)I
        //   523: isub           
        //   524: iadd           
        //   525: istore          llllllllllllllIIllIIllIIlIlIllIl
        //   527: iload           llllllllllllllIIllIIllIIlIlIllII
        //   529: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   530: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   533: iconst_1       
        //   534: invokevirtual   java/util/Random.nextInt:(I)I
        //   537: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   538: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   541: iconst_1       
        //   542: invokevirtual   java/util/Random.nextInt:(I)I
        //   545: isub           
        //   546: iadd           
        //   547: istore          llllllllllllllIIllIIllIIlIlIllII
        //   549: iload           llllllllllllllIIllIIllIIlIlIlIll
        //   551: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   552: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   555: bipush          6
        //   557: invokevirtual   java/util/Random.nextInt:(I)I
        //   560: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   561: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   564: bipush          6
        //   566: invokevirtual   java/util/Random.nextInt:(I)I
        //   569: isub           
        //   570: iadd           
        //   571: istore          llllllllllllllIIllIIllIIlIlIlIll
        //   573: aload           llllllllllllllIIllIIllIIlIllIllI
        //   575: iload           llllllllllllllIIllIIllIIlIlIllIl
        //   577: iload           llllllllllllllIIllIIllIIlIlIllII
        //   579: iload           llllllllllllllIIllIIllIIlIlIlIll
        //   581: invokevirtual   net/minecraft/util/math/BlockPos$MutableBlockPos.setPos:(III)Lnet/minecraft/util/math/BlockPos$MutableBlockPos;
        //   584: pop            
        //   585: iload           llllllllllllllIIllIIllIIlIlIllIl
        //   587: i2f            
        //   588: ldc             0.5
        //   590: fadd           
        //   591: fstore          llllllllllllllIIllIIllIIlIlIIlIl
        //   593: iload           llllllllllllllIIllIIllIIlIlIlIll
        //   595: i2f            
        //   596: ldc             0.5
        //   598: fadd           
        //   599: fstore          llllllllllllllIIllIIllIIlIlIIlII
        //   601: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   602: fload           llllllllllllllIIllIIllIIlIlIIlIl
        //   604: f2d            
        //   605: iload           llllllllllllllIIllIIllIIlIlIllII
        //   607: i2d            
        //   608: fload           llllllllllllllIIllIIllIIlIlIIlII
        //   610: f2d            
        //   611: ldc2_w          24.0
        //   614: invokevirtual   net/minecraft/world/WorldServer.isAnyPlayerWithinRangeAt:(DDDD)Z
        //   617: ifne            849
        //   620: aload           llllllllllllllIIllIIllIIlIlllIlI
        //   622: fload           llllllllllllllIIllIIllIIlIlIIlIl
        //   624: f2d            
        //   625: iload           llllllllllllllIIllIIllIIlIlIllII
        //   627: i2d            
        //   628: fload           llllllllllllllIIllIIllIIlIlIIlII
        //   630: f2d            
        //   631: invokevirtual   net/minecraft/util/math/BlockPos.distanceSq:(DDD)D
        //   634: ldc2_w          576.0
        //   637: dcmpl          
        //   638: iflt            849
        //   641: aload           llllllllllllllIIllIIllIIlIlIlIIl
        //   643: ifnonnull       664
        //   646: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   647: aload           llllllllllllllIIllIIllIIlIlllIIl
        //   649: aload           llllllllllllllIIllIIllIIlIllIllI
        //   651: invokevirtual   net/minecraft/world/WorldServer.getSpawnListEntryForTypeAt:(Lnet/minecraft/entity/EnumCreatureType;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/world/biome/Biome$SpawnListEntry;
        //   654: astore          llllllllllllllIIllIIllIIlIlIlIIl
        //   656: aload           llllllllllllllIIllIIllIIlIlIlIIl
        //   658: ifnonnull       664
        //   661: goto            859
        //   664: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   665: aload           llllllllllllllIIllIIllIIlIlllIIl
        //   667: aload           llllllllllllllIIllIIllIIlIlIlIIl
        //   669: aload           llllllllllllllIIllIIllIIlIllIllI
        //   671: invokevirtual   net/minecraft/world/WorldServer.canCreatureTypeSpawnHere:(Lnet/minecraft/entity/EnumCreatureType;Lnet/minecraft/world/biome/Biome$SpawnListEntry;Lnet/minecraft/util/math/BlockPos;)Z
        //   674: ifeq            849
        //   677: aload           llllllllllllllIIllIIllIIlIlIlIIl
        //   679: getfield        net/minecraft/world/biome/Biome$SpawnListEntry.entityClass:Ljava/lang/Class;
        //   682: invokestatic    net/minecraft/entity/EntitySpawnPlacementRegistry.getPlacementForEntity:(Ljava/lang/Class;)Lnet/minecraft/entity/EntityLiving$SpawnPlacementType;
        //   685: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   686: aload           llllllllllllllIIllIIllIIlIllIllI
        //   688: invokestatic    net/minecraft/world/WorldEntitySpawner.canCreatureTypeSpawnAtLocation:(Lnet/minecraft/entity/EntityLiving$SpawnPlacementType;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)Z
        //   691: ifeq            849
        //   694: aload           llllllllllllllIIllIIllIIlIlIlIIl
        //   696: getfield        net/minecraft/world/biome/Biome$SpawnListEntry.entityClass:Ljava/lang/Class;
        //   699: iconst_1       
        //   700: anewarray       Ljava/lang/Class;
        //   703: dup            
        //   704: iconst_0       
        //   705: ldc             Lnet/minecraft/world/World;.class
        //   707: aastore        
        //   708: invokevirtual   java/lang/Class.getConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
        //   711: iconst_1       
        //   712: anewarray       Ljava/lang/Object;
        //   715: dup            
        //   716: iconst_0       
        //   717: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   718: aastore        
        //   719: invokevirtual   java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
        //   722: checkcast       Lnet/minecraft/entity/EntityLiving;
        //   725: astore          llllllllllllllIIllIIllIIlIlIIIll
        //   727: goto            740
        //   730: astore          llllllllllllllIIllIIllIIlIlIIIIl
        //   732: aload           llllllllllllllIIllIIllIIlIlIIIIl
        //   734: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   737: iload           llllllllllllllIIllIIllIIlIlllIll
        //   739: ireturn        
        //   740: aload           llllllllllllllIIllIIllIIlIlIIIlI
        //   742: fload           llllllllllllllIIllIIllIIlIlIIlIl
        //   744: f2d            
        //   745: iload           llllllllllllllIIllIIllIIlIlIllII
        //   747: i2d            
        //   748: fload           llllllllllllllIIllIIllIIlIlIIlII
        //   750: f2d            
        //   751: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   752: getfield        net/minecraft/world/WorldServer.rand:Ljava/util/Random;
        //   755: invokevirtual   java/util/Random.nextFloat:()F
        //   758: ldc             360.0
        //   760: fmul           
        //   761: fconst_0       
        //   762: invokevirtual   net/minecraft/entity/EntityLiving.setLocationAndAngles:(DDDFF)V
        //   765: aload           llllllllllllllIIllIIllIIlIlIIIlI
        //   767: invokevirtual   net/minecraft/entity/EntityLiving.getCanSpawnHere:()Z
        //   770: ifeq            842
        //   773: aload           llllllllllllllIIllIIllIIlIlIIIlI
        //   775: invokevirtual   net/minecraft/entity/EntityLiving.isNotColliding:()Z
        //   778: ifeq            842
        //   781: aload           llllllllllllllIIllIIllIIlIlIIIlI
        //   783: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   784: new             Lnet/minecraft/util/math/BlockPos;
        //   787: dup            
        //   788: aload           llllllllllllllIIllIIllIIlIlIIIlI
        //   790: invokespecial   net/minecraft/util/math/BlockPos.<init>:(Lnet/minecraft/entity/Entity;)V
        //   793: invokevirtual   net/minecraft/world/WorldServer.getDifficultyForLocation:(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/world/DifficultyInstance;
        //   796: aload           llllllllllllllIIllIIllIIlIlIlIII
        //   798: invokevirtual   net/minecraft/entity/EntityLiving.onInitialSpawn:(Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/entity/IEntityLivingData;)Lnet/minecraft/entity/IEntityLivingData;
        //   801: astore          llllllllllllllIIllIIllIIlIlIlIII
        //   803: aload           llllllllllllllIIllIIllIIlIlIIIlI
        //   805: invokevirtual   net/minecraft/entity/EntityLiving.isNotColliding:()Z
        //   808: ifeq            824
        //   811: iinc            llllllllllllllIIllIIllIIlIlIllll, 1
        //   814: aload_1         /* llllllllllllllIIllIIllIIllIIlIIl */
        //   815: aload           llllllllllllllIIllIIllIIlIlIIIlI
        //   817: invokevirtual   net/minecraft/world/WorldServer.spawnEntityInWorld:(Lnet/minecraft/entity/Entity;)Z
        //   820: pop            
        //   821: goto            829
        //   824: aload           llllllllllllllIIllIIllIIlIlIIIlI
        //   826: invokevirtual   net/minecraft/entity/EntityLiving.setDead:()V
        //   829: iload           llllllllllllllIIllIIllIIlIlIllll
        //   831: aload           llllllllllllllIIllIIllIIlIlIIIlI
        //   833: invokevirtual   net/minecraft/entity/EntityLiving.getMaxSpawnedInChunk:()I
        //   836: if_icmplt       842
        //   839: goto            868
        //   842: iload           llllllllllllllIIllIIllIIlIlllIll
        //   844: iload           llllllllllllllIIllIIllIIlIlIllll
        //   846: iadd           
        //   847: istore          llllllllllllllIIllIIllIIlIlllIll
        //   849: iinc            llllllllllllllIIllIIllIIlIlIIllI, 1
        //   852: iload           llllllllllllllIIllIIllIIlIlIIllI
        //   854: iload           llllllllllllllIIllIIllIIlIlIIlll
        //   856: if_icmplt       503
        //   859: iinc            llllllllllllllIIllIIllIIlIlIlllI, 1
        //   862: iload           llllllllllllllIIllIIllIIlIlIlllI
        //   864: iconst_3       
        //   865: if_icmplt       463
        //   868: aload           llllllllllllllIIllIIllIIlIIlIIII
        //   870: invokeinterface java/util/Iterator.hasNext:()Z
        //   875: ifne            387
        //   878: iinc            9, 1
        //   881: iload           9
        //   883: iload           10
        //   885: if_icmplt       288
        //   888: iload           llllllllllllllIIllIIllIIlIlllIll
        //   890: ireturn        
        //    StackMapTable: 00 1E 0A FE 00 19 01 00 07 01 5A FF 00 3A 00 0C 07 00 02 07 01 51 01 01 01 01 07 01 60 07 01 5A 01 01 01 01 00 00 FC 00 06 01 1F 40 01 FD 00 62 01 07 01 71 F9 00 02 FA 00 09 FF 00 06 00 08 07 00 02 07 01 51 01 01 01 01 00 07 01 5A 00 00 FF 00 21 00 0C 07 00 02 07 01 51 01 01 01 01 01 07 00 17 00 01 01 07 02 48 00 00 FF 00 12 00 0C 07 00 02 07 01 51 01 01 01 01 01 07 00 17 07 00 23 01 01 07 02 48 00 00 0B 0C FF 00 36 00 11 07 00 02 07 01 51 01 01 01 01 01 07 00 17 07 00 23 01 01 07 02 48 01 01 07 00 15 00 07 01 5A 00 00 FF 00 4B 00 18 07 00 02 07 01 51 01 01 01 01 01 07 00 17 07 00 23 01 01 07 02 48 01 01 07 00 15 07 01 71 07 01 5A 07 00 17 01 01 01 07 00 E8 01 01 00 00 FF 00 27 00 20 07 00 02 07 01 51 01 01 01 01 01 07 00 17 07 00 23 01 01 07 02 48 01 01 07 00 15 07 01 71 07 01 5A 07 00 17 01 01 01 07 00 E8 01 01 01 01 01 01 07 00 0B 07 00 C8 01 01 00 00 FD 00 A0 02 02 F7 00 41 07 00 21 FC 00 09 07 00 08 FB 00 53 04 0C FA 00 06 F9 00 02 06 FF 00 02 00 18 07 00 02 07 01 51 01 01 01 01 01 07 00 17 07 00 23 01 01 07 02 48 01 01 07 00 15 07 01 71 07 01 5A 07 00 17 01 01 01 07 00 E8 01 01 00 00 FF 00 05 00 11 07 00 02 07 01 51 01 01 01 01 01 07 00 17 07 00 23 01 01 07 02 48 01 01 07 00 15 00 07 01 5A 00 00 FF 00 09 00 0C 07 00 02 07 01 51 01 01 01 01 01 07 00 17 07 00 23 01 01 07 02 48 00 00 FF 00 02 00 0C 07 00 02 07 01 51 01 01 01 01 01 07 00 17 00 01 01 07 02 48 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  694    727    730    740    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static boolean isValidEmptySpawnBlock(final IBlockState llllllllllllllIIllIIllIIIllIIIll) {
        return !llllllllllllllIIllIIllIIIllIIIll.isBlockNormalCube() && !llllllllllllllIIllIIllIIIllIIIll.canProvidePower() && !llllllllllllllIIllIIllIIIllIIIll.getMaterial().isLiquid() && !BlockRailBase.isRailBlock(llllllllllllllIIllIIllIIIllIIIll);
    }
    
    static {
        MOB_COUNT_DIV = (int)Math.pow(17.0, 2.0);
    }
}
