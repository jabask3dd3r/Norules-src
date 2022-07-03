package net.minecraft.network.datasync;

import net.minecraft.util.math.*;
import net.minecraft.nbt.*;
import com.google.common.base.*;
import net.minecraft.util.text.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import javax.annotation.*;
import net.minecraft.network.*;
import java.io.*;
import net.minecraft.block.*;

public class DataSerializers
{
    public static final /* synthetic */ DataSerializer<BlockPos> BLOCK_POS;
    public static final /* synthetic */ DataSerializer<Rotations> ROTATIONS;
    public static final /* synthetic */ DataSerializer<NBTTagCompound> field_192734_n;
    public static final /* synthetic */ DataSerializer<Optional<BlockPos>> OPTIONAL_BLOCK_POS;
    public static final /* synthetic */ DataSerializer<ITextComponent> TEXT_COMPONENT;
    public static final /* synthetic */ DataSerializer<Byte> BYTE;
    public static final /* synthetic */ DataSerializer<Optional<UUID>> OPTIONAL_UNIQUE_ID;
    public static final /* synthetic */ DataSerializer<ItemStack> OPTIONAL_ITEM_STACK;
    public static final /* synthetic */ DataSerializer<EnumFacing> FACING;
    public static final /* synthetic */ DataSerializer<Float> FLOAT;
    public static final /* synthetic */ DataSerializer<Boolean> BOOLEAN;
    public static final /* synthetic */ DataSerializer<Integer> VARINT;
    private static final /* synthetic */ IntIdentityHashBiMap<DataSerializer<?>> REGISTRY;
    public static final /* synthetic */ DataSerializer<Optional<IBlockState>> OPTIONAL_BLOCK_STATE;
    public static final /* synthetic */ DataSerializer<String> STRING;
    
    public static int getSerializerId(final DataSerializer<?> lllllllllllllIIIlIlIlIllIlllIIll) {
        return DataSerializers.REGISTRY.getId(lllllllllllllIIIlIlIlIllIlllIIll);
    }
    
    @Nullable
    public static DataSerializer<?> getSerializer(final int lllllllllllllIIIlIlIlIllIlllIllI) {
        return DataSerializers.REGISTRY.get(lllllllllllllIIIlIlIlIllIlllIllI);
    }
    
    static {
        REGISTRY = new IntIdentityHashBiMap<DataSerializer<?>>(16);
        BYTE = new DataSerializer<Byte>() {
            @Override
            public Byte read(final PacketBuffer lllllllllllllIlllIlIlllIIIIIllll) throws IOException {
                return lllllllllllllIlllIlIlllIIIIIllll.readByte();
            }
            
            @Override
            public void write(final PacketBuffer lllllllllllllIlllIlIlllIIIIlIIll, final Byte lllllllllllllIlllIlIlllIIIIlIIlI) {
                lllllllllllllIlllIlIlllIIIIlIIll.writeByte(lllllllllllllIlllIlIlllIIIIlIIlI);
            }
            
            @Override
            public DataParameter<Byte> createKey(final int lllllllllllllIlllIlIlllIIIIIlIII) {
                return new DataParameter<Byte>(lllllllllllllIlllIlIlllIIIIIlIII, this);
            }
            
            @Override
            public Byte func_192717_a(final Byte lllllllllllllIlllIlIlllIIIIIIlIl) {
                return lllllllllllllIlllIlIlllIIIIIIlIl;
            }
        };
        VARINT = new DataSerializer<Integer>() {
            @Override
            public void write(final PacketBuffer llllllllllllllIIllIlIIlllIIlIIlI, final Integer llllllllllllllIIllIlIIlllIIlIIIl) {
                llllllllllllllIIllIlIIlllIIlIIlI.writeVarIntToBuffer(llllllllllllllIIllIlIIlllIIlIIIl);
            }
            
            @Override
            public Integer read(final PacketBuffer llllllllllllllIIllIlIIlllIIIlIll) throws IOException {
                return llllllllllllllIIllIlIIlllIIIlIll.readVarIntFromBuffer();
            }
            
            @Override
            public Integer func_192717_a(final Integer llllllllllllllIIllIlIIlllIIIIIlI) {
                return llllllllllllllIIllIlIIlllIIIIIlI;
            }
            
            @Override
            public DataParameter<Integer> createKey(final int llllllllllllllIIllIlIIlllIIIIlll) {
                return new DataParameter<Integer>(llllllllllllllIIllIlIIlllIIIIlll, this);
            }
        };
        FLOAT = new DataSerializer<Float>() {
            @Override
            public void write(final PacketBuffer llllllllllllllIlllIlIlIlIlIIIllI, final Float llllllllllllllIlllIlIlIlIlIIIlIl) {
                llllllllllllllIlllIlIlIlIlIIIllI.writeFloat(llllllllllllllIlllIlIlIlIlIIIlIl);
            }
            
            @Override
            public Float read(final PacketBuffer llllllllllllllIlllIlIlIlIlIIIIII) throws IOException {
                return llllllllllllllIlllIlIlIlIlIIIIII.readFloat();
            }
            
            @Override
            public Float func_192717_a(final Float llllllllllllllIlllIlIlIlIIllIlIl) {
                return llllllllllllllIlllIlIlIlIIllIlIl;
            }
            
            @Override
            public DataParameter<Float> createKey(final int llllllllllllllIlllIlIlIlIIlllIIl) {
                return new DataParameter<Float>(llllllllllllllIlllIlIlIlIIlllIIl, this);
            }
        };
        STRING = new DataSerializer<String>() {
            @Override
            public DataParameter<String> createKey(final int lllllllllllllIIIIIlllllllIIlIIIl) {
                return new DataParameter<String>(lllllllllllllIIIIIlllllllIIlIIIl, this);
            }
            
            @Override
            public String read(final PacketBuffer lllllllllllllIIIIIlllllllIIlIlll) throws IOException {
                return lllllllllllllIIIIIlllllllIIlIlll.readStringFromBuffer(32767);
            }
            
            @Override
            public void write(final PacketBuffer lllllllllllllIIIIIlllllllIIllllI, final String lllllllllllllIIIIIlllllllIIlllIl) {
                lllllllllllllIIIIIlllllllIIllllI.writeString(lllllllllllllIIIIIlllllllIIlllIl);
            }
            
            @Override
            public String func_192717_a(final String lllllllllllllIIIIIlllllllIIIllIl) {
                return lllllllllllllIIIIIlllllllIIIllIl;
            }
        };
        TEXT_COMPONENT = new DataSerializer<ITextComponent>() {
            @Override
            public ITextComponent func_192717_a(final ITextComponent lllllllllllllllIlIIIllllIllIIIlI) {
                return lllllllllllllllIlIIIllllIllIIIlI.createCopy();
            }
            
            @Override
            public void write(final PacketBuffer lllllllllllllllIlIIIllllIlllIIIl, final ITextComponent lllllllllllllllIlIIIllllIlllIIlI) {
                lllllllllllllllIlIIIllllIlllIIIl.writeTextComponent(lllllllllllllllIlIIIllllIlllIIlI);
            }
            
            @Override
            public DataParameter<ITextComponent> createKey(final int lllllllllllllllIlIIIllllIllIlIII) {
                return new DataParameter<ITextComponent>(lllllllllllllllIlIIIllllIllIlIII, this);
            }
            
            @Override
            public ITextComponent read(final PacketBuffer lllllllllllllllIlIIIllllIllIllII) throws IOException {
                return lllllllllllllllIlIIIllllIllIllII.readTextComponent();
            }
        };
        OPTIONAL_ITEM_STACK = new DataSerializer<ItemStack>() {
            @Override
            public void write(final PacketBuffer llIIIIIIIIIlIIl, final ItemStack llIIIIIIIIIlIII) {
                llIIIIIIIIIlIIl.writeItemStackToBuffer(llIIIIIIIIIlIII);
            }
            
            @Override
            public ItemStack read(final PacketBuffer llIIIIIIIIIIIlI) throws IOException {
                return llIIIIIIIIIIIlI.readItemStackFromBuffer();
            }
            
            @Override
            public ItemStack func_192717_a(final ItemStack lIllllllllllIII) {
                return lIllllllllllIII.copy();
            }
            
            @Override
            public DataParameter<ItemStack> createKey(final int lIlllllllllllII) {
                return new DataParameter<ItemStack>(lIlllllllllllII, this);
            }
        };
        OPTIONAL_BLOCK_STATE = new DataSerializer<Optional<IBlockState>>() {
            @Override
            public Optional<IBlockState> read(final PacketBuffer llllllllllllllllIIlIlIllllIIllll) throws IOException {
                final int llllllllllllllllIIlIlIllllIIlllI = llllllllllllllllIIlIlIllllIIllll.readVarIntFromBuffer();
                return (Optional<IBlockState>)((llllllllllllllllIIlIlIllllIIlllI == 0) ? Optional.absent() : Optional.of((Object)Block.getStateById(llllllllllllllllIIlIlIllllIIlllI)));
            }
            
            @Override
            public DataParameter<Optional<IBlockState>> createKey(final int llllllllllllllllIIlIlIllllIIIllI) {
                return new DataParameter<Optional<IBlockState>>(llllllllllllllllIIlIlIllllIIIllI, this);
            }
            
            @Override
            public void write(final PacketBuffer llllllllllllllllIIlIlIllllIlIlII, final Optional<IBlockState> llllllllllllllllIIlIlIllllIlIIll) {
                if (llllllllllllllllIIlIlIllllIlIIll.isPresent()) {
                    llllllllllllllllIIlIlIllllIlIlII.writeVarIntToBuffer(Block.getStateId((IBlockState)llllllllllllllllIIlIlIllllIlIIll.get()));
                }
                else {
                    llllllllllllllllIIlIlIllllIlIlII.writeVarIntToBuffer(0);
                }
            }
            
            @Override
            public Optional<IBlockState> func_192717_a(final Optional<IBlockState> llllllllllllllllIIlIlIllllIIIIll) {
                return llllllllllllllllIIlIlIllllIIIIll;
            }
        };
        BOOLEAN = new DataSerializer<Boolean>() {
            @Override
            public Boolean read(final PacketBuffer lllllllllllllIIlIlllIllIIIIIllII) throws IOException {
                return lllllllllllllIIlIlllIllIIIIIllII.readBoolean();
            }
            
            @Override
            public void write(final PacketBuffer lllllllllllllIIlIlllIllIIIIlIIlI, final Boolean lllllllllllllIIlIlllIllIIIIlIlII) {
                lllllllllllllIIlIlllIllIIIIlIIlI.writeBoolean(lllllllllllllIIlIlllIllIIIIlIlII);
            }
            
            @Override
            public Boolean func_192717_a(final Boolean lllllllllllllIIlIlllIllIIIIIIIIl) {
                return lllllllllllllIIlIlllIllIIIIIIIIl;
            }
            
            @Override
            public DataParameter<Boolean> createKey(final int lllllllllllllIIlIlllIllIIIIIIlIl) {
                return new DataParameter<Boolean>(lllllllllllllIIlIlllIllIIIIIIlIl, this);
            }
        };
        ROTATIONS = new DataSerializer<Rotations>() {
            @Override
            public void write(final PacketBuffer lllllllllllllIlIIIlllllllIllIIIl, final Rotations lllllllllllllIlIIIlllllllIllIIII) {
                lllllllllllllIlIIIlllllllIllIIIl.writeFloat(lllllllllllllIlIIIlllllllIllIIII.getX());
                lllllllllllllIlIIIlllllllIllIIIl.writeFloat(lllllllllllllIlIIIlllllllIllIIII.getY());
                lllllllllllllIlIIIlllllllIllIIIl.writeFloat(lllllllllllllIlIIIlllllllIllIIII.getZ());
            }
            
            @Override
            public DataParameter<Rotations> createKey(final int lllllllllllllIlIIIlllllllIlIIlII) {
                return new DataParameter<Rotations>(lllllllllllllIlIIIlllllllIlIIlII, this);
            }
            
            @Override
            public Rotations func_192717_a(final Rotations lllllllllllllIlIIIlllllllIlIIIIl) {
                return lllllllllllllIlIIIlllllllIlIIIIl;
            }
            
            @Override
            public Rotations read(final PacketBuffer lllllllllllllIlIIIlllllllIlIlIll) throws IOException {
                return new Rotations(lllllllllllllIlIIIlllllllIlIlIll.readFloat(), lllllllllllllIlIIIlllllllIlIlIll.readFloat(), lllllllllllllIlIIIlllllllIlIlIll.readFloat());
            }
        };
        BLOCK_POS = new DataSerializer<BlockPos>() {
            @Override
            public void write(final PacketBuffer llIIlIIIlIlIl, final BlockPos llIIlIIIlIllI) {
                llIIlIIIlIlIl.writeBlockPos(llIIlIIIlIllI);
            }
            
            @Override
            public BlockPos func_192717_a(final BlockPos llIIlIIIIIlll) {
                return llIIlIIIIIlll;
            }
            
            @Override
            public BlockPos read(final PacketBuffer llIIlIIIlIIIl) throws IOException {
                return llIIlIIIlIIIl.readBlockPos();
            }
            
            @Override
            public DataParameter<BlockPos> createKey(final int llIIlIIIIlIlI) {
                return new DataParameter<BlockPos>(llIIlIIIIlIlI, this);
            }
        };
        OPTIONAL_BLOCK_POS = new DataSerializer<Optional<BlockPos>>() {
            @Override
            public Optional<BlockPos> read(final PacketBuffer lllllllllllllllIlIlIIIlIIIlIllll) throws IOException {
                return (Optional<BlockPos>)(lllllllllllllllIlIlIIIlIIIlIllll.readBoolean() ? Optional.of((Object)lllllllllllllllIlIlIIIlIIIlIllll.readBlockPos()) : Optional.absent());
            }
            
            @Override
            public Optional<BlockPos> func_192717_a(final Optional<BlockPos> lllllllllllllllIlIlIIIlIIIlIIlII) {
                return lllllllllllllllIlIlIIIlIIIlIIlII;
            }
            
            @Override
            public DataParameter<Optional<BlockPos>> createKey(final int lllllllllllllllIlIlIIIlIIIlIlIII) {
                return new DataParameter<Optional<BlockPos>>(lllllllllllllllIlIlIIIlIIIlIlIII, this);
            }
            
            @Override
            public void write(final PacketBuffer lllllllllllllllIlIlIIIlIIIllIIll, final Optional<BlockPos> lllllllllllllllIlIlIIIlIIIllIIlI) {
                lllllllllllllllIlIlIIIlIIIllIIll.writeBoolean(lllllllllllllllIlIlIIIlIIIllIIlI.isPresent());
                if (lllllllllllllllIlIlIIIlIIIllIIlI.isPresent()) {
                    lllllllllllllllIlIlIIIlIIIllIIll.writeBlockPos((BlockPos)lllllllllllllllIlIlIIIlIIIllIIlI.get());
                }
            }
        };
        FACING = new DataSerializer<EnumFacing>() {
            @Override
            public EnumFacing read(final PacketBuffer lllllllllllllIIIIIlIlIlllIIIllIl) throws IOException {
                return lllllllllllllIIIIIlIlIlllIIIllIl.readEnumValue(EnumFacing.class);
            }
            
            @Override
            public EnumFacing func_192717_a(final EnumFacing lllllllllllllIIIIIlIlIlllIIIIlII) {
                return lllllllllllllIIIIIlIlIlllIIIIlII;
            }
            
            @Override
            public DataParameter<EnumFacing> createKey(final int lllllllllllllIIIIIlIlIlllIIIlIIl) {
                return new DataParameter<EnumFacing>(lllllllllllllIIIIIlIlIlllIIIlIIl, this);
            }
            
            @Override
            public void write(final PacketBuffer lllllllllllllIIIIIlIlIlllIIlIlII, final EnumFacing lllllllllllllIIIIIlIlIlllIIlIIll) {
                lllllllllllllIIIIIlIlIlllIIlIlII.writeEnumValue(lllllllllllllIIIIIlIlIlllIIlIIll);
            }
        };
        OPTIONAL_UNIQUE_ID = new DataSerializer<Optional<UUID>>() {
            @Override
            public void write(final PacketBuffer lllllllllllllIIlIlllllIlIlIlllll, final Optional<UUID> lllllllllllllIIlIlllllIlIlIllllI) {
                lllllllllllllIIlIlllllIlIlIlllll.writeBoolean(lllllllllllllIIlIlllllIlIlIllllI.isPresent());
                if (lllllllllllllIIlIlllllIlIlIllllI.isPresent()) {
                    lllllllllllllIIlIlllllIlIlIlllll.writeUuid((UUID)lllllllllllllIIlIlllllIlIlIllllI.get());
                }
            }
            
            @Override
            public DataParameter<Optional<UUID>> createKey(final int lllllllllllllIIlIlllllIlIlIlIIlI) {
                return new DataParameter<Optional<UUID>>(lllllllllllllIIlIlllllIlIlIlIIlI, this);
            }
            
            @Override
            public Optional<UUID> read(final PacketBuffer lllllllllllllIIlIlllllIlIlIllIIl) throws IOException {
                return (Optional<UUID>)(lllllllllllllIIlIlllllIlIlIllIIl.readBoolean() ? Optional.of((Object)lllllllllllllIIlIlllllIlIlIllIIl.readUuid()) : Optional.absent());
            }
            
            @Override
            public Optional<UUID> func_192717_a(final Optional<UUID> lllllllllllllIIlIlllllIlIlIIllll) {
                return lllllllllllllIIlIlllllIlIlIIllll;
            }
        };
        field_192734_n = new DataSerializer<NBTTagCompound>() {
            @Override
            public NBTTagCompound func_192717_a(final NBTTagCompound llllllllllllllIlIIIIIllIlllllIll) {
                return llllllllllllllIlIIIIIllIlllllIll.copy();
            }
            
            @Override
            public void write(final PacketBuffer llllllllllllllIlIIIIIlllIIIIlIlI, final NBTTagCompound llllllllllllllIlIIIIIlllIIIIlIIl) {
                llllllllllllllIlIIIIIlllIIIIlIlI.writeNBTTagCompoundToBuffer(llllllllllllllIlIIIIIlllIIIIlIIl);
            }
            
            @Override
            public NBTTagCompound read(final PacketBuffer llllllllllllllIlIIIIIlllIIIIIlIl) throws IOException {
                return llllllllllllllIlIIIIIlllIIIIIlIl.readNBTTagCompoundFromBuffer();
            }
            
            @Override
            public DataParameter<NBTTagCompound> createKey(final int llllllllllllllIlIIIIIllIllllllll) {
                return new DataParameter<NBTTagCompound>(llllllllllllllIlIIIIIllIllllllll, this);
            }
        };
        registerSerializer(DataSerializers.BYTE);
        registerSerializer(DataSerializers.VARINT);
        registerSerializer(DataSerializers.FLOAT);
        registerSerializer(DataSerializers.STRING);
        registerSerializer(DataSerializers.TEXT_COMPONENT);
        registerSerializer(DataSerializers.OPTIONAL_ITEM_STACK);
        registerSerializer(DataSerializers.BOOLEAN);
        registerSerializer(DataSerializers.ROTATIONS);
        registerSerializer(DataSerializers.BLOCK_POS);
        registerSerializer(DataSerializers.OPTIONAL_BLOCK_POS);
        registerSerializer(DataSerializers.FACING);
        registerSerializer(DataSerializers.OPTIONAL_UNIQUE_ID);
        registerSerializer(DataSerializers.OPTIONAL_BLOCK_STATE);
        registerSerializer(DataSerializers.field_192734_n);
    }
    
    public static void registerSerializer(final DataSerializer<?> lllllllllllllIIIlIlIlIllIllllIIl) {
        DataSerializers.REGISTRY.add(lllllllllllllIIIlIlIlIllIllllIIl);
    }
}
