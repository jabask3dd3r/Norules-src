package com.viaversion.viaversion.api.type;

import java.util.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.api.type.types.minecraft.*;

public abstract class Type<T> implements ByteBufReader<T>, ByteBufWriter<T>
{
    public static final /* synthetic */ BooleanType BOOLEAN;
    public static final /* synthetic */ Type<BlockChangeRecord> BLOCK_CHANGE_RECORD;
    private final /* synthetic */ Class<? super T> outputClass;
    public static final /* synthetic */ FloatType FLOAT;
    public static final /* synthetic */ Type<UUID> UUID;
    public static final /* synthetic */ ByteType BYTE;
    public static final /* synthetic */ DoubleType DOUBLE;
    public static final /* synthetic */ Type<Item> FLAT_VAR_INT_ITEM;
    public static final /* synthetic */ Type<Item> FLAT_ITEM;
    public static final /* synthetic */ LongType LONG;
    public static final /* synthetic */ IntType INT;
    private final /* synthetic */ String typeName;
    public static final /* synthetic */ ShortType SHORT;
    public static final /* synthetic */ UnsignedByteType UNSIGNED_BYTE;
    public static final /* synthetic */ VarIntType VAR_INT;
    public static final /* synthetic */ VarLongType VAR_LONG;
    public static final /* synthetic */ Type<CompoundTag> NBT;
    public static final /* synthetic */ Type<String> STRING;
    public static final /* synthetic */ Type<BlockChangeRecord> VAR_LONG_BLOCK_CHANGE_RECORD;
    public static final /* synthetic */ UnsignedShortType UNSIGNED_SHORT;
    
    protected Type(final Class<? super T> llllllllllllllIllllIlllIllIlllIl) {
        this(llllllllllllllIllllIlllIllIlllIl.getSimpleName(), llllllllllllllIllllIlllIllIlllIl);
    }
    
    protected Type(final String llllllllllllllIllllIlllIllIlIlIl, final Class<? super T> llllllllllllllIllllIlllIllIlIlll) {
        this.outputClass = llllllllllllllIllllIlllIllIlIlll;
        this.typeName = llllllllllllllIllllIlllIllIlIlIl;
    }
    
    public String getTypeName() {
        return this.typeName;
    }
    
    public Class<? super T> getOutputClass() {
        return this.outputClass;
    }
    
    static {
        BYTE = new ByteType();
        UNSIGNED_BYTE = new UnsignedByteType();
        BYTE_ARRAY_PRIMITIVE = new ByteArrayType();
        SHORT_BYTE_ARRAY = new ShortByteArrayType();
        REMAINING_BYTES = new RemainingBytesType();
        SHORT = new ShortType();
        UNSIGNED_SHORT = new UnsignedShortType();
        INT = new IntType();
        FLOAT = new FloatType();
        DOUBLE = new DoubleType();
        LONG = new LongType();
        LONG_ARRAY_PRIMITIVE = new LongArrayType();
        BOOLEAN = new BooleanType();
        COMPONENT = new ComponentType();
        OPTIONAL_COMPONENT = new OptionalComponentType();
        STRING = new StringType();
        STRING_ARRAY = new ArrayType((Type<Object>)Type.STRING);
        UUID = new UUIDType();
        OPTIONAL_UUID = new OptUUIDType();
        UUID_INT_ARRAY = new UUIDIntArrayType();
        UUID_ARRAY = new ArrayType((Type<Object>)Type.UUID);
        VAR_INT = new VarIntType();
        OPTIONAL_VAR_INT = new OptionalVarIntType();
        VAR_INT_ARRAY_PRIMITIVE = new VarIntArrayType();
        VAR_LONG = new VarLongType();
        BYTE_ARRAY = new ArrayType((Type<Object>)Type.BYTE);
        UNSIGNED_BYTE_ARRAY = new ArrayType((Type<Object>)Type.UNSIGNED_BYTE);
        BOOLEAN_ARRAY = new ArrayType((Type<Object>)Type.BOOLEAN);
        INT_ARRAY = new ArrayType((Type<Object>)Type.INT);
        SHORT_ARRAY = new ArrayType((Type<Object>)Type.SHORT);
        UNSIGNED_SHORT_ARRAY = new ArrayType((Type<Object>)Type.UNSIGNED_SHORT);
        DOUBLE_ARRAY = new ArrayType((Type<Object>)Type.DOUBLE);
        LONG_ARRAY = new ArrayType((Type<Object>)Type.LONG);
        FLOAT_ARRAY = new ArrayType((Type<Object>)Type.FLOAT);
        VAR_INT_ARRAY = new ArrayType((Type<Object>)Type.VAR_INT);
        VAR_LONG_ARRAY = new ArrayType((Type<Object>)Type.VAR_LONG);
        NOTHING = new VoidType();
        POSITION = new PositionType();
        POSITION1_14 = new Position1_14Type();
        ROTATION = new EulerAngleType();
        VECTOR = new VectorType();
        NBT = new NBTType();
        NBT_ARRAY = new ArrayType((Type<Object>)Type.NBT);
        OPTIONAL_POSITION = new OptPositionType();
        OPTIONAL_POSITION_1_14 = new OptPosition1_14Type();
        BLOCK_CHANGE_RECORD = new BlockChangeRecordType();
        BLOCK_CHANGE_RECORD_ARRAY = new ArrayType((Type<Object>)Type.BLOCK_CHANGE_RECORD);
        VAR_LONG_BLOCK_CHANGE_RECORD = new VarLongBlockChangeRecordType();
        VAR_LONG_BLOCK_CHANGE_RECORD_ARRAY = new ArrayType((Type<Object>)Type.VAR_LONG_BLOCK_CHANGE_RECORD);
        VILLAGER_DATA = new VillagerDataType();
        ITEM = new ItemType();
        ITEM_ARRAY = new ItemArrayType();
        FLAT_ITEM = new FlatItemType();
        FLAT_VAR_INT_ITEM = new FlatVarIntItemType();
        FLAT_ITEM_ARRAY = new FlatItemArrayType();
        FLAT_VAR_INT_ITEM_ARRAY = new FlatVarIntItemArrayType();
        FLAT_ITEM_ARRAY_VAR_INT = new ArrayType((Type<Object>)Type.FLAT_ITEM);
        FLAT_VAR_INT_ITEM_ARRAY_VAR_INT = new ArrayType((Type<Object>)Type.FLAT_VAR_INT_ITEM);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("Type|").append(this.typeName));
    }
    
    public Class<? extends Type> getBaseClass() {
        return this.getClass();
    }
}
