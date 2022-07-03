package com.viaversion.viaversion.libs.opennbt.tag.builtin;

import com.viaversion.viaversion.libs.opennbt.tag.*;
import com.google.common.base.*;
import java.io.*;
import java.util.*;
import org.jetbrains.annotations.*;

public class ListTag extends Tag implements Iterable<Tag>
{
    private /* synthetic */ Class<? extends Tag> type;
    private final /* synthetic */ List<Tag> value;
    
    public int size() {
        return this.value.size();
    }
    
    @Override
    public void write(final DataOutput lllllllllllllIIllllllIIllIIIIlIl) throws IOException {
        if (this.type == null) {
            lllllllllllllIIllllllIIllIIIIlIl.writeByte(0);
        }
        else {
            final int lllllllllllllIIllllllIIllIIIlIII = TagRegistry.getIdFor(this.type);
            if (lllllllllllllIIllllllIIllIIIlIII == -1) {
                throw new IOException("ListTag contains unregistered tag class.");
            }
            lllllllllllllIIllllllIIllIIIIlIl.writeByte(lllllllllllllIIllllllIIllIIIlIII);
        }
        lllllllllllllIIllllllIIllIIIIlIl.writeInt(this.value.size());
        for (final Tag lllllllllllllIIllllllIIllIIIIlll : this.value) {
            lllllllllllllIIllllllIIllIIIIlll.write(lllllllllllllIIllllllIIllIIIIlIl);
        }
    }
    
    @Override
    public List<Tag> getValue() {
        return this.value;
    }
    
    public void setValue(final List<Tag> lllllllllllllIIllllllIIlllIIIIlI) throws IllegalArgumentException {
        Preconditions.checkNotNull((Object)lllllllllllllIIllllllIIlllIIIIlI);
        this.type = null;
        this.value.clear();
        for (final Tag lllllllllllllIIllllllIIlllIIIlII : lllllllllllllIIllllllIIlllIIIIlI) {
            this.add(lllllllllllllIIllllllIIlllIIIlII);
        }
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIllllllIIlIlllIIIl) {
        if (this == lllllllllllllIIllllllIIlIlllIIIl) {
            return true;
        }
        if (lllllllllllllIIllllllIIlIlllIIIl == null || this.getClass() != lllllllllllllIIllllllIIlIlllIIIl.getClass()) {
            return false;
        }
        final ListTag lllllllllllllIIllllllIIlIlllIIII = (ListTag)lllllllllllllIIllllllIIlIlllIIIl;
        return Objects.equals(this.type, lllllllllllllIIllllllIIlIlllIIII.type) && this.value.equals(lllllllllllllIIllllllIIlIlllIIII.value);
    }
    
    public ListTag() {
        this.value = new ArrayList<Tag>();
    }
    
    @Override
    public void read(final DataInput lllllllllllllIIllllllIIllIIlIIlI) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aconst_null    
        //     2: putfield        com/viaversion/viaversion/libs/opennbt/tag/builtin/ListTag.type:Ljava/lang/Class;
        //     5: aload_1         /* lllllllllllllIIllllllIIllIIlIllI */
        //     6: invokeinterface java/io/DataInput.readByte:()B
        //    11: istore_2        /* lllllllllllllIIllllllIIllIIlIlIl */
        //    12: iload_2         /* lllllllllllllIIllllllIIllIIlIlIl */
        //    13: ifeq            58
        //    16: aload_0         /* lllllllllllllIIllllllIIllIIlIIll */
        //    17: iload_2         /* lllllllllllllIIllllllIIllIIlIlIl */
        //    18: invokestatic    com/viaversion/viaversion/libs/opennbt/tag/TagRegistry.getClassFor:(I)Ljava/lang/Class;
        //    21: putfield        com/viaversion/viaversion/libs/opennbt/tag/builtin/ListTag.type:Ljava/lang/Class;
        //    24: aload_0         /* lllllllllllllIIllllllIIllIIlIIll */
        //    25: getfield        com/viaversion/viaversion/libs/opennbt/tag/builtin/ListTag.type:Ljava/lang/Class;
        //    28: ifnonnull       58
        //    31: new             Ljava/io/IOException;
        //    34: dup            
        //    35: new             Ljava/lang/StringBuilder;
        //    38: dup            
        //    39: invokespecial   java/lang/StringBuilder.<init>:()V
        //    42: ldc             "Unknown tag ID in ListTag: "
        //    44: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    47: iload_2         /* lllllllllllllIIllllllIIllIIlIlIl */
        //    48: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    51: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    54: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //    57: athrow         
        //    58: aload_1         /* lllllllllllllIIllllllIIllIIlIllI */
        //    59: invokeinterface java/io/DataInput.readInt:()I
        //    64: istore_3        /* lllllllllllllIIllllllIIllIIlIlII */
        //    65: iconst_0       
        //    66: istore          lllllllllllllIIllllllIIllIIllIII
        //    68: iload           lllllllllllllIIllllllIIllIIllIII
        //    70: iload_3         /* lllllllllllllIIllllllIIllIIlIlII */
        //    71: if_icmpge       116
        //    74: iload_2         /* lllllllllllllIIllllllIIllIIlIlIl */
        //    75: invokestatic    com/viaversion/viaversion/libs/opennbt/tag/TagRegistry.createInstance:(I)Lcom/viaversion/viaversion/libs/opennbt/tag/builtin/Tag;
        //    78: astore          lllllllllllllIIllllllIIllIIllIll
        //    80: goto            97
        //    83: astore          lllllllllllllIIllllllIIllIIllIlI
        //    85: new             Ljava/io/IOException;
        //    88: dup            
        //    89: ldc             "Failed to create tag."
        //    91: aload           lllllllllllllIIllllllIIllIIllIlI
        //    93: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //    96: athrow         
        //    97: aload           lllllllllllllIIllllllIIllIIllIIl
        //    99: aload_1         /* lllllllllllllIIllllllIIllIIlIllI */
        //   100: invokevirtual   com/viaversion/viaversion/libs/opennbt/tag/builtin/Tag.read:(Ljava/io/DataInput;)V
        //   103: aload_0         /* lllllllllllllIIllllllIIllIIlIIll */
        //   104: aload           lllllllllllllIIllllllIIllIIllIIl
        //   106: invokevirtual   com/viaversion/viaversion/libs/opennbt/tag/builtin/ListTag.add:(Lcom/viaversion/viaversion/libs/opennbt/tag/builtin/Tag;)Z
        //   109: pop            
        //   110: iinc            lllllllllllllIIllllllIIllIIllIII, 1
        //   113: goto            68
        //   116: return         
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 05 FC 00 3A 01 FD 00 09 01 01 4E 07 00 A6 FC 00 0D 07 00 05 FA 00 12
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                           
        //  -----  -----  -----  -----  ---------------------------------------------------------------
        //  74     80     83     97     Lcom/viaversion/viaversion/libs/opennbt/tag/TagCreateException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Iterator<Tag> iterator() {
        return this.value.iterator();
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIIllllllIIlIllIlIIl = (this.type != null) ? this.type.hashCode() : 0;
        lllllllllllllIIllllllIIlIllIlIIl = 31 * lllllllllllllIIllllllIIlIllIlIIl + this.value.hashCode();
        return lllllllllllllIIllllllIIlIllIlIIl;
    }
    
    public boolean add(final Tag lllllllllllllIIllllllIIllIllIlIl) throws IllegalArgumentException {
        Preconditions.checkNotNull((Object)lllllllllllllIIllllllIIllIllIlIl);
        if (this.type == null) {
            this.type = lllllllllllllIIllllllIIllIllIlIl.getClass();
        }
        else if (lllllllllllllIIllllllIIllIllIlIl.getClass() != this.type) {
            throw new IllegalArgumentException("Tag type cannot differ from ListTag type.");
        }
        return this.value.add(lllllllllllllIIllllllIIllIllIlIl);
    }
    
    public boolean remove(final Tag lllllllllllllIIllllllIIllIllIIIl) {
        return this.value.remove(lllllllllllllIIllllllIIllIllIIIl);
    }
    
    public <T extends Tag> T get(final int lllllllllllllIIllllllIIllIlIlIIl) {
        return (T)this.value.get(lllllllllllllIIllllllIIllIlIlIIl);
    }
    
    public ListTag(final List<Tag> lllllllllllllIIllllllIIlllIIlllI) throws IllegalArgumentException {
        this.value = new ArrayList<Tag>(lllllllllllllIIllllllIIlllIIlllI.size());
        this.setValue(lllllllllllllIIllllllIIlllIIlllI);
    }
    
    public ListTag(@Nullable final Class<? extends Tag> lllllllllllllIIllllllIIlllIlIIlI) {
        this.type = lllllllllllllIIllllllIIlllIlIIlI;
        this.value = new ArrayList<Tag>();
    }
    
    @Override
    public int getTagId() {
        return 9;
    }
    
    @Override
    public final ListTag clone() {
        final List<Tag> lllllllllllllIIllllllIIlIllllIlI = new ArrayList<Tag>();
        for (final Tag lllllllllllllIIllllllIIlIlllllII : this.value) {
            lllllllllllllIIllllllIIlIllllIlI.add(lllllllllllllIIllllllIIlIlllllII.clone());
        }
        return new ListTag(lllllllllllllIIllllllIIlIllllIlI);
    }
    
    public Class<? extends Tag> getElementType() {
        return this.type;
    }
    
    static {
        ID = 9;
    }
}
