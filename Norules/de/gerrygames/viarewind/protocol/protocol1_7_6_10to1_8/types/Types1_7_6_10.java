package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;

public class Types1_7_6_10
{
    static {
        COMPRESSED_NBT = new CompressedNBTType();
        ITEM_ARRAY = new ItemArrayType(false);
        COMPRESSED_NBT_ITEM_ARRAY = new ItemArrayType(true);
        ITEM = new ItemType(false);
        COMPRESSED_NBT_ITEM = new ItemType(true);
        METADATA_LIST = new MetadataListType();
        METADATA = new MetadataType();
        NBT = new NBTType();
        INT_ARRAY = new IntArrayType();
    }
}
