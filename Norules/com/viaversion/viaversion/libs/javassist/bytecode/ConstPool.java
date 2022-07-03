package com.viaversion.viaversion.libs.javassist.bytecode;

import com.viaversion.viaversion.libs.javassist.*;
import java.io.*;
import java.util.*;

public final class ConstPool
{
    /* synthetic */ int thisClassInfo;
    /* synthetic */ int numOfItems;
    /* synthetic */ Map<ConstInfo, ConstInfo> itemsCache;
    public static final /* synthetic */ CtClass THIS;
    /* synthetic */ LongVector items;
    
    public int getInterfaceMethodrefClass(final int lllllllllllllllllIlllIIIIIlIIlll) {
        final MemberrefInfo lllllllllllllllllIlllIIIIIlIIllI = (MemberrefInfo)this.getItem(lllllllllllllllllIlllIIIIIlIIlll);
        return lllllllllllllllllIlllIIIIIlIIllI.classIndex;
    }
    
    public int addInvokeDynamicInfo(final int lllllllllllllllllIllIllIIIIlllII, final int lllllllllllllllllIllIllIIIIllIll) {
        return this.addItem(new InvokeDynamicInfo(lllllllllllllllllIllIllIIIIlllII, lllllllllllllllllIllIllIIIIllIll, this.numOfItems));
    }
    
    public int addIntegerInfo(final int lllllllllllllllllIllIllIIlIlIIIl) {
        return this.addItem(new IntegerInfo(lllllllllllllllllIllIllIIlIlIIIl, this.numOfItems));
    }
    
    public int addNameAndTypeInfo(final int lllllllllllllllllIllIllIlIlIllII, final int lllllllllllllllllIllIllIlIlIlIll) {
        return this.addItem(new NameAndTypeInfo(lllllllllllllllllIllIllIlIlIllII, lllllllllllllllllIllIllIlIlIlIll, this.numOfItems));
    }
    
    public long getLongInfo(final int lllllllllllllllllIllIlllllIlIllI) {
        final LongInfo lllllllllllllllllIllIlllllIlIlIl = (LongInfo)this.getItem(lllllllllllllllllIllIlllllIlIllI);
        return lllllllllllllllllIllIlllllIlIlIl.value;
    }
    
    public int addMethodTypeInfo(final int lllllllllllllllllIllIllIIIlIIlII) {
        return this.addItem(new MethodTypeInfo(lllllllllllllllllIllIllIIIlIIlII, this.numOfItems));
    }
    
    public String getFieldrefClassName(final int lllllllllllllllllIlllIIIlIIIIIIl) {
        final FieldrefInfo lllllllllllllllllIlllIIIlIIIIIll = (FieldrefInfo)this.getItem(lllllllllllllllllIlllIIIlIIIIIIl);
        if (lllllllllllllllllIlllIIIlIIIIIll == null) {
            return null;
        }
        return this.getClassInfo(lllllllllllllllllIlllIIIlIIIIIll.classIndex);
    }
    
    public int getIntegerInfo(final int lllllllllllllllllIllIllllllIIlIl) {
        final IntegerInfo lllllllllllllllllIllIllllllIIlll = (IntegerInfo)this.getItem(lllllllllllllllllIllIllllllIIlIl);
        return lllllllllllllllllIllIllllllIIlll.value;
    }
    
    public String getFieldrefType(final int lllllllllllllllllIlllIIIIllIIIIl) {
        final FieldrefInfo lllllllllllllllllIlllIIIIllIIlII = (FieldrefInfo)this.getItem(lllllllllllllllllIlllIIIIllIIIIl);
        if (lllllllllllllllllIlllIIIIllIIlII == null) {
            return null;
        }
        final NameAndTypeInfo lllllllllllllllllIlllIIIIllIIIll = (NameAndTypeInfo)this.getItem(lllllllllllllllllIlllIIIIllIIlII.nameAndTypeIndex);
        if (lllllllllllllllllIlllIIIIllIIIll == null) {
            return null;
        }
        return this.getUtf8Info(lllllllllllllllllIlllIIIIllIIIll.typeDescriptor);
    }
    
    public int addNameAndTypeInfo(final String lllllllllllllllllIllIllIlIllIIlI, final String lllllllllllllllllIllIllIlIllIlII) {
        return this.addNameAndTypeInfo(this.addUtf8Info(lllllllllllllllllIllIllIlIllIIlI), this.addUtf8Info(lllllllllllllllllIllIllIlIllIlII));
    }
    
    public int getMemberClass(final int lllllllllllllllllIlllIIIlIIlllll) {
        final MemberrefInfo lllllllllllllllllIlllIIIlIIllllI = (MemberrefInfo)this.getItem(lllllllllllllllllIlllIIIlIIlllll);
        return lllllllllllllllllIlllIIIlIIllllI.classIndex;
    }
    
    public String getPackageInfo(final int lllllllllllllllllIllIlllIIllIlII) {
        final PackageInfo lllllllllllllllllIllIlllIIllIllI = (PackageInfo)this.getItem(lllllllllllllllllIllIlllIIllIlII);
        return this.getUtf8Info(lllllllllllllllllIllIlllIIllIllI.name);
    }
    
    private int addItem(final ConstInfo lllllllllllllllllIllIllIllllIIII) {
        if (this.itemsCache == null) {
            this.itemsCache = makeItemsCache(this.items);
        }
        final ConstInfo lllllllllllllllllIllIllIlllIllll = this.itemsCache.get(lllllllllllllllllIllIllIllllIIII);
        if (lllllllllllllllllIllIllIlllIllll != null) {
            return lllllllllllllllllIllIllIlllIllll.index;
        }
        this.items.addElement(lllllllllllllllllIllIllIllllIIII);
        this.itemsCache.put(lllllllllllllllllIllIllIllllIIII, lllllllllllllllllIllIllIllllIIII);
        return this.numOfItems++;
    }
    
    public String eqMember(final String lllllllllllllllllIllIlllIIIIlIlI, final String lllllllllllllllllIllIlllIIIIlIIl, final int lllllllllllllllllIllIlllIIIIlIII) {
        final MemberrefInfo lllllllllllllllllIllIlllIIIIllIl = (MemberrefInfo)this.getItem(lllllllllllllllllIllIlllIIIIlIII);
        final NameAndTypeInfo lllllllllllllllllIllIlllIIIIllII = (NameAndTypeInfo)this.getItem(lllllllllllllllllIllIlllIIIIllIl.nameAndTypeIndex);
        if (this.getUtf8Info(lllllllllllllllllIllIlllIIIIllII.memberName).equals(lllllllllllllllllIllIlllIIIIlIlI) && this.getUtf8Info(lllllllllllllllllIllIlllIIIIllII.typeDescriptor).equals(lllllllllllllllllIllIlllIIIIlIIl)) {
            return this.getClassInfo(lllllllllllllllllIllIlllIIIIllIl.classIndex);
        }
        return null;
    }
    
    public int getMethodrefClass(final int lllllllllllllllllIlllIIIIlIlIlll) {
        final MemberrefInfo lllllllllllllllllIlllIIIIlIllIIl = (MemberrefInfo)this.getItem(lllllllllllllllllIlllIIIIlIlIlll);
        return lllllllllllllllllIlllIIIIlIllIIl.classIndex;
    }
    
    public int addLongInfo(final long lllllllllllllllllIllIllIIlIIIllI) {
        final int lllllllllllllllllIllIllIIlIIIlIl = this.addItem(new LongInfo(lllllllllllllllllIllIllIIlIIIllI, this.numOfItems));
        if (lllllllllllllllllIllIllIIlIIIlIl == this.numOfItems - 1) {
            this.addConstInfoPadding();
        }
        return lllllllllllllllllIllIllIIlIIIlIl;
    }
    
    public void print(final PrintWriter lllllllllllllllllIllIlIlIlllllll) {
        for (int lllllllllllllllllIllIlIlIllllllI = this.numOfItems, lllllllllllllllllIllIlIllIIIIIIl = 1; lllllllllllllllllIllIlIllIIIIIIl < lllllllllllllllllIllIlIlIllllllI; ++lllllllllllllllllIllIlIllIIIIIIl) {
            lllllllllllllllllIllIlIlIlllllll.print(lllllllllllllllllIllIlIllIIIIIIl);
            lllllllllllllllllIllIlIlIlllllll.print(" ");
            this.items.elementAt(lllllllllllllllllIllIlIllIIIIIIl).print(lllllllllllllllllIllIlIlIlllllll);
        }
    }
    
    public String getClassInfoByDescriptor(final int lllllllllllllllllIlllIIIlIlllIII) {
        final ClassInfo lllllllllllllllllIlllIIIlIlllIll = (ClassInfo)this.getItem(lllllllllllllllllIlllIIIlIlllIII);
        if (lllllllllllllllllIlllIIIlIlllIll == null) {
            return null;
        }
        final String lllllllllllllllllIlllIIIlIlllIlI = this.getUtf8Info(lllllllllllllllllIlllIIIlIlllIll.name);
        if (lllllllllllllllllIlllIIIlIlllIlI.charAt(0) == '[') {
            return lllllllllllllllllIlllIIIlIlllIlI;
        }
        return Descriptor.of(lllllllllllllllllIlllIIIlIlllIlI);
    }
    
    public int getInvokeDynamicNameAndType(final int lllllllllllllllllIllIlllIllllIIl) {
        final InvokeDynamicInfo lllllllllllllllllIllIlllIllllIll = (InvokeDynamicInfo)this.getItem(lllllllllllllllllIllIlllIllllIIl);
        return lllllllllllllllllIllIlllIllllIll.nameAndType;
    }
    
    private int readOne(final DataInputStream lllllllllllllllllIllIlIllIIllllI) throws IOException {
        final int lllllllllllllllllIllIlIllIIlllII = lllllllllllllllllIllIlIllIIllllI.readUnsignedByte();
        switch (lllllllllllllllllIllIlIllIIlllII) {
            case 1: {
                final ConstInfo lllllllllllllllllIllIlIllIllIIII = new Utf8Info(lllllllllllllllllIllIlIllIIllllI, this.numOfItems);
                break;
            }
            case 3: {
                final ConstInfo lllllllllllllllllIllIlIllIlIllll = new IntegerInfo(lllllllllllllllllIllIlIllIIllllI, this.numOfItems);
                break;
            }
            case 4: {
                final ConstInfo lllllllllllllllllIllIlIllIlIlllI = new FloatInfo(lllllllllllllllllIllIlIllIIllllI, this.numOfItems);
                break;
            }
            case 5: {
                final ConstInfo lllllllllllllllllIllIlIllIlIllIl = new LongInfo(lllllllllllllllllIllIlIllIIllllI, this.numOfItems);
                break;
            }
            case 6: {
                final ConstInfo lllllllllllllllllIllIlIllIlIllII = new DoubleInfo(lllllllllllllllllIllIlIllIIllllI, this.numOfItems);
                break;
            }
            case 7: {
                final ConstInfo lllllllllllllllllIllIlIllIlIlIll = new ClassInfo(lllllllllllllllllIllIlIllIIllllI, this.numOfItems);
                break;
            }
            case 8: {
                final ConstInfo lllllllllllllllllIllIlIllIlIlIlI = new StringInfo(lllllllllllllllllIllIlIllIIllllI, this.numOfItems);
                break;
            }
            case 9: {
                final ConstInfo lllllllllllllllllIllIlIllIlIlIIl = new FieldrefInfo(lllllllllllllllllIllIlIllIIllllI, this.numOfItems);
                break;
            }
            case 10: {
                final ConstInfo lllllllllllllllllIllIlIllIlIlIII = new MethodrefInfo(lllllllllllllllllIllIlIllIIllllI, this.numOfItems);
                break;
            }
            case 11: {
                final ConstInfo lllllllllllllllllIllIlIllIlIIlll = new InterfaceMethodrefInfo(lllllllllllllllllIllIlIllIIllllI, this.numOfItems);
                break;
            }
            case 12: {
                final ConstInfo lllllllllllllllllIllIlIllIlIIllI = new NameAndTypeInfo(lllllllllllllllllIllIlIllIIllllI, this.numOfItems);
                break;
            }
            case 15: {
                final ConstInfo lllllllllllllllllIllIlIllIlIIlIl = new MethodHandleInfo(lllllllllllllllllIllIlIllIIllllI, this.numOfItems);
                break;
            }
            case 16: {
                final ConstInfo lllllllllllllllllIllIlIllIlIIlII = new MethodTypeInfo(lllllllllllllllllIllIlIllIIllllI, this.numOfItems);
                break;
            }
            case 17: {
                final ConstInfo lllllllllllllllllIllIlIllIlIIIll = new DynamicInfo(lllllllllllllllllIllIlIllIIllllI, this.numOfItems);
                break;
            }
            case 18: {
                final ConstInfo lllllllllllllllllIllIlIllIlIIIlI = new InvokeDynamicInfo(lllllllllllllllllIllIlIllIIllllI, this.numOfItems);
                break;
            }
            case 19: {
                final ConstInfo lllllllllllllllllIllIlIllIlIIIIl = new ModuleInfo(lllllllllllllllllIllIlIllIIllllI, this.numOfItems);
                break;
            }
            case 20: {
                final ConstInfo lllllllllllllllllIllIlIllIlIIIII = new PackageInfo(lllllllllllllllllIllIlIllIIllllI, this.numOfItems);
                break;
            }
            default: {
                throw new IOException(String.valueOf(new StringBuilder().append("invalid constant type: ").append(lllllllllllllllllIllIlIllIIlllII).append(" at ").append(this.numOfItems)));
            }
        }
        final ConstInfo lllllllllllllllllIllIlIllIIlllIl;
        this.addItem0(lllllllllllllllllIllIlIllIIlllIl);
        return lllllllllllllllllIllIlIllIIlllII;
    }
    
    public String getStringInfo(final int lllllllllllllllllIllIlllllIIIIIl) {
        final StringInfo lllllllllllllllllIllIlllllIIIIll = (StringInfo)this.getItem(lllllllllllllllllIllIlllllIIIIIl);
        return this.getUtf8Info(lllllllllllllllllIllIlllllIIIIll.string);
    }
    
    public void write(final DataOutputStream lllllllllllllllllIllIlIllIIlIIII) throws IOException {
        lllllllllllllllllIllIlIllIIlIIII.writeShort(this.numOfItems);
        final LongVector lllllllllllllllllIllIlIllIIIllll = this.items;
        for (int lllllllllllllllllIllIlIllIIIlllI = this.numOfItems, lllllllllllllllllIllIlIllIIlIIlI = 1; lllllllllllllllllIllIlIllIIlIIlI < lllllllllllllllllIllIlIllIIIlllI; ++lllllllllllllllllIllIlIllIIlIIlI) {
            lllllllllllllllllIllIlIllIIIllll.elementAt(lllllllllllllllllIllIlIllIIlIIlI).write(lllllllllllllllllIllIlIllIIlIIII);
        }
    }
    
    ConstInfo getItem(final int lllllllllllllllllIlllIIIllIlIIll) {
        return this.items.elementAt(lllllllllllllllllIlllIIIllIlIIll);
    }
    
    public String getFieldrefName(final int lllllllllllllllllIlllIIIIllIllIl) {
        final FieldrefInfo lllllllllllllllllIlllIIIIlllIIII = (FieldrefInfo)this.getItem(lllllllllllllllllIlllIIIIllIllIl);
        if (lllllllllllllllllIlllIIIIlllIIII == null) {
            return null;
        }
        final NameAndTypeInfo lllllllllllllllllIlllIIIIllIllll = (NameAndTypeInfo)this.getItem(lllllllllllllllllIlllIIIIlllIIII.nameAndTypeIndex);
        if (lllllllllllllllllIlllIIIIllIllll == null) {
            return null;
        }
        return this.getUtf8Info(lllllllllllllllllIlllIIIIllIllll.memberName);
    }
    
    public int getThisClassInfo() {
        return this.thisClassInfo;
    }
    
    public int addModuleInfo(final int lllllllllllllllllIllIllIIIIIllII) {
        return this.addItem(new ModuleInfo(lllllllllllllllllIllIllIIIIIllII, this.numOfItems));
    }
    
    public String getInterfaceMethodrefType(final int lllllllllllllllllIllIllllllllIll) {
        final MemberrefInfo lllllllllllllllllIllIllllllllllI = (MemberrefInfo)this.getItem(lllllllllllllllllIllIllllllllIll);
        if (lllllllllllllllllIllIllllllllllI == null) {
            return null;
        }
        final NameAndTypeInfo lllllllllllllllllIllIlllllllllIl = (NameAndTypeInfo)this.getItem(lllllllllllllllllIllIllllllllllI.nameAndTypeIndex);
        if (lllllllllllllllllIllIlllllllllIl == null) {
            return null;
        }
        return this.getUtf8Info(lllllllllllllllllIllIlllllllllIl.typeDescriptor);
    }
    
    public int addClassInfo(final CtClass lllllllllllllllllIllIllIllIIIIll) {
        if (lllllllllllllllllIllIllIllIIIIll == ConstPool.THIS) {
            return this.thisClassInfo;
        }
        if (!lllllllllllllllllIllIllIllIIIIll.isArray()) {
            return this.addClassInfo(lllllllllllllllllIllIllIllIIIIll.getName());
        }
        return this.addClassInfo(Descriptor.toJvmName(lllllllllllllllllIllIllIllIIIIll));
    }
    
    public void renameClass(final String lllllllllllllllllIllIlIllllIlIIl, final String lllllllllllllllllIllIlIllllIIIll) {
        final LongVector lllllllllllllllllIllIlIllllIIlll = this.items;
        for (int lllllllllllllllllIllIlIllllIIllI = this.numOfItems, lllllllllllllllllIllIlIllllIlIll = 1; lllllllllllllllllIllIlIllllIlIll < lllllllllllllllllIllIlIllllIIllI; ++lllllllllllllllllIllIlIllllIlIll) {
            final ConstInfo lllllllllllllllllIllIlIllllIllII = lllllllllllllllllIllIlIllllIIlll.elementAt(lllllllllllllllllIllIlIllllIlIll);
            lllllllllllllllllIllIlIllllIllII.renameClass(this, lllllllllllllllllIllIlIllllIlIIl, lllllllllllllllllIllIlIllllIIIll, this.itemsCache);
        }
    }
    
    public int getSize() {
        return this.numOfItems;
    }
    
    public String getMethodrefName(final int lllllllllllllllllIlllIIIIIlllIlI) {
        final MemberrefInfo lllllllllllllllllIlllIIIIIllllIl = (MemberrefInfo)this.getItem(lllllllllllllllllIlllIIIIIlllIlI);
        if (lllllllllllllllllIlllIIIIIllllIl == null) {
            return null;
        }
        final NameAndTypeInfo lllllllllllllllllIlllIIIIIllllII = (NameAndTypeInfo)this.getItem(lllllllllllllllllIlllIIIIIllllIl.nameAndTypeIndex);
        if (lllllllllllllllllIlllIIIIIllllII == null) {
            return null;
        }
        return this.getUtf8Info(lllllllllllllllllIlllIIIIIllllII.memberName);
    }
    
    public int getFieldrefNameAndType(final int lllllllllllllllllIlllIIIIllllIll) {
        final FieldrefInfo lllllllllllllllllIlllIIIIllllIlI = (FieldrefInfo)this.getItem(lllllllllllllllllIlllIIIIllllIll);
        return lllllllllllllllllIlllIIIIllllIlI.nameAndTypeIndex;
    }
    
    public String getInterfaceMethodrefClassName(final int lllllllllllllllllIlllIIIIIIllIll) {
        final MemberrefInfo lllllllllllllllllIlllIIIIIIlllIl = (MemberrefInfo)this.getItem(lllllllllllllllllIlllIIIIIIllIll);
        return this.getClassInfo(lllllllllllllllllIlllIIIIIIlllIl.classIndex);
    }
    
    public String getModuleInfo(final int lllllllllllllllllIllIlllIIllllIl) {
        final ModuleInfo lllllllllllllllllIllIlllIIllllll = (ModuleInfo)this.getItem(lllllllllllllllllIllIlllIIllllIl);
        return this.getUtf8Info(lllllllllllllllllIllIlllIIllllll.name);
    }
    
    public int addInterfaceMethodrefInfo(final int lllllllllllllllllIllIllIIllIllII, final String lllllllllllllllllIllIllIIlllIIII, final String lllllllllllllllllIllIllIIllIlIlI) {
        final int lllllllllllllllllIllIllIIllIlllI = this.addNameAndTypeInfo(lllllllllllllllllIllIllIIlllIIII, lllllllllllllllllIllIllIIllIlIlI);
        return this.addInterfaceMethodrefInfo(lllllllllllllllllIllIllIIllIllII, lllllllllllllllllIllIllIIllIlllI);
    }
    
    public int addInterfaceMethodrefInfo(final int lllllllllllllllllIllIllIIllIIlII, final int lllllllllllllllllIllIllIIllIIIII) {
        return this.addItem(new InterfaceMethodrefInfo(lllllllllllllllllIllIllIIllIIlII, lllllllllllllllllIllIllIIllIIIII, this.numOfItems));
    }
    
    public int addFieldrefInfo(final int lllllllllllllllllIllIllIlIIlIlII, final int lllllllllllllllllIllIllIlIIlIIII) {
        return this.addItem(new FieldrefInfo(lllllllllllllllllIllIllIlIIlIlII, lllllllllllllllllIllIllIlIIlIIII, this.numOfItems));
    }
    
    public int addFieldrefInfo(final int lllllllllllllllllIllIllIlIlIIIIl, final String lllllllllllllllllIllIllIlIIllIll, final String lllllllllllllllllIllIllIlIIlllll) {
        final int lllllllllllllllllIllIllIlIIllllI = this.addNameAndTypeInfo(lllllllllllllllllIllIllIlIIllIll, lllllllllllllllllIllIllIlIIlllll);
        return this.addFieldrefInfo(lllllllllllllllllIllIllIlIlIIIIl, lllllllllllllllllIllIllIlIIllllI);
    }
    
    private void read(final DataInputStream lllllllllllllllllIllIlIlllIIIllI) throws IOException {
        int lllllllllllllllllIllIlIlllIIIlIl = lllllllllllllllllIllIlIlllIIIllI.readUnsignedShort();
        this.items = new LongVector(lllllllllllllllllIllIlIlllIIIlIl);
        this.numOfItems = 0;
        this.addItem0(null);
        while (--lllllllllllllllllIllIlIlllIIIlIl > 0) {
            final int lllllllllllllllllIllIlIlllIIlIII = this.readOne(lllllllllllllllllIllIlIlllIIIllI);
            if (lllllllllllllllllIllIlIlllIIlIII == 5 || lllllllllllllllllIllIlIlllIIlIII == 6) {
                this.addConstInfoPadding();
                --lllllllllllllllllIllIlIlllIIIlIl;
            }
        }
    }
    
    public void renameClass(final Map<String, String> lllllllllllllllllIllIlIlllIlIIIl) {
        final LongVector lllllllllllllllllIllIlIlllIlIlII = this.items;
        for (int lllllllllllllllllIllIlIlllIlIIll = this.numOfItems, lllllllllllllllllIllIlIlllIlIlll = 1; lllllllllllllllllIllIlIlllIlIlll < lllllllllllllllllIllIlIlllIlIIll; ++lllllllllllllllllIllIlIlllIlIlll) {
            final ConstInfo lllllllllllllllllIllIlIlllIllIII = lllllllllllllllllIllIlIlllIlIlII.elementAt(lllllllllllllllllIllIlIlllIlIlll);
            lllllllllllllllllIllIlIlllIllIII.renameClass(this, lllllllllllllllllIllIlIlllIlIIIl, this.itemsCache);
        }
    }
    
    void setThisClassInfo(final int lllllllllllllllllIlllIIIllIllIIl) {
        this.thisClassInfo = lllllllllllllllllIlllIIIllIllIIl;
    }
    
    public String getClassName() {
        return this.getClassInfo(this.thisClassInfo);
    }
    
    public int getMethodHandleIndex(final int lllllllllllllllllIllIllllIlIIIll) {
        final MethodHandleInfo lllllllllllllllllIllIllllIlIIlIl = (MethodHandleInfo)this.getItem(lllllllllllllllllIllIllllIlIIIll);
        return lllllllllllllllllIllIllllIlIIlIl.refIndex;
    }
    
    public int getDynamicNameAndType(final int lllllllllllllllllIllIlllIlIlIlIl) {
        final DynamicInfo lllllllllllllllllIllIlllIlIlIlII = (DynamicInfo)this.getItem(lllllllllllllllllIllIlllIlIlIlIl);
        return lllllllllllllllllIllIlllIlIlIlII.nameAndType;
    }
    
    public void print() {
        this.print(new PrintWriter(System.out, true));
    }
    
    public int addPackageInfo(final int lllllllllllllllllIllIllIIIIIIllI) {
        return this.addItem(new PackageInfo(lllllllllllllllllIllIllIIIIIIllI, this.numOfItems));
    }
    
    public int addMethodrefInfo(final int lllllllllllllllllIllIllIIlllllII, final int lllllllllllllllllIllIllIIllllIll) {
        return this.addItem(new MethodrefInfo(lllllllllllllllllIllIllIIlllllII, lllllllllllllllllIllIllIIllllIll, this.numOfItems));
    }
    
    public int addFloatInfo(final float lllllllllllllllllIllIllIIlIIlIll) {
        return this.addItem(new FloatInfo(lllllllllllllllllIllIllIIlIIlIll, this.numOfItems));
    }
    
    public int getFieldrefClass(final int lllllllllllllllllIlllIIIlIIIlIlI) {
        final FieldrefInfo lllllllllllllllllIlllIIIlIIIllII = (FieldrefInfo)this.getItem(lllllllllllllllllIlllIIIlIIIlIlI);
        return lllllllllllllllllIlllIIIlIIIllII.classIndex;
    }
    
    int addConstInfoPadding() {
        return this.addItem0(new ConstInfoPadding(this.numOfItems));
    }
    
    public int addClassInfo(final String lllllllllllllllllIllIllIlIlllllI) {
        final int lllllllllllllllllIllIllIlIllllIl = this.addUtf8Info(Descriptor.toJvmName(lllllllllllllllllIllIllIlIlllllI));
        return this.addItem(new ClassInfo(lllllllllllllllllIllIllIlIllllIl, this.numOfItems));
    }
    
    private int addItem0(final ConstInfo lllllllllllllllllIllIlllIIIIIIlI) {
        this.items.addElement(lllllllllllllllllIllIlllIIIIIIlI);
        return this.numOfItems++;
    }
    
    public int getNameAndTypeDescriptor(final int lllllllllllllllllIlllIIIlIlIIlIl) {
        final NameAndTypeInfo lllllllllllllllllIlllIIIlIlIIlll = (NameAndTypeInfo)this.getItem(lllllllllllllllllIlllIIIlIlIIlIl);
        return lllllllllllllllllIlllIIIlIlIIlll.typeDescriptor;
    }
    
    public int getNameAndTypeName(final int lllllllllllllllllIlllIIIlIlIlllI) {
        final NameAndTypeInfo lllllllllllllllllIlllIIIlIllIIII = (NameAndTypeInfo)this.getItem(lllllllllllllllllIlllIIIlIlIlllI);
        return lllllllllllllllllIlllIIIlIllIIII.memberName;
    }
    
    public double getDoubleInfo(final int lllllllllllllllllIllIlllllIIlIlI) {
        final DoubleInfo lllllllllllllllllIllIlllllIIllII = (DoubleInfo)this.getItem(lllllllllllllllllIllIlllllIIlIlI);
        return lllllllllllllllllIllIlllllIIllII.value;
    }
    
    public ConstPool(final String lllllllllllllllllIlllIIIllllIIIl) {
        this.items = new LongVector();
        this.itemsCache = null;
        this.numOfItems = 0;
        this.addItem0(null);
        this.thisClassInfo = this.addClassInfo(lllllllllllllllllIlllIIIllllIIIl);
    }
    
    public String getMethodrefClassName(final int lllllllllllllllllIlllIIIIlIlIIIl) {
        final MemberrefInfo lllllllllllllllllIlllIIIIlIlIIII = (MemberrefInfo)this.getItem(lllllllllllllllllIlllIIIIlIlIIIl);
        if (lllllllllllllllllIlllIIIIlIlIIII == null) {
            return null;
        }
        return this.getClassInfo(lllllllllllllllllIlllIIIIlIlIIII.classIndex);
    }
    
    public int addMethodHandleInfo(final int lllllllllllllllllIllIllIIIlIlllI, final int lllllllllllllllllIllIllIIIlIlIlI) {
        return this.addItem(new MethodHandleInfo(lllllllllllllllllIllIllIIIlIlllI, lllllllllllllllllIllIllIIIlIlIlI, this.numOfItems));
    }
    
    public Set<String> getClassNames() {
        final Set<String> lllllllllllllllllIllIlIlllllllII = new HashSet<String>();
        final LongVector lllllllllllllllllIllIlIllllllIll = this.items;
        for (int lllllllllllllllllIllIlIllllllIlI = this.numOfItems, lllllllllllllllllIllIlIllllllllI = 1; lllllllllllllllllIllIlIllllllllI < lllllllllllllllllIllIlIllllllIlI; ++lllllllllllllllllIllIlIllllllllI) {
            final String lllllllllllllllllIllIlIlllllllll = lllllllllllllllllIllIlIllllllIll.elementAt(lllllllllllllllllIllIlIllllllllI).getClassName(this);
            if (lllllllllllllllllIllIlIlllllllll != null) {
                lllllllllllllllllIllIlIlllllllII.add(lllllllllllllllllIllIlIlllllllll);
            }
        }
        return lllllllllllllllllIllIlIlllllllII;
    }
    
    public Object getLdcValue(final int lllllllllllllllllIllIllllllIllll) {
        final ConstInfo lllllllllllllllllIllIlllllllIIlI = this.getItem(lllllllllllllllllIllIllllllIllll);
        Object lllllllllllllllllIllIlllllllIIIl = null;
        if (lllllllllllllllllIllIlllllllIIlI instanceof StringInfo) {
            lllllllllllllllllIllIlllllllIIIl = this.getStringInfo(lllllllllllllllllIllIllllllIllll);
        }
        else if (lllllllllllllllllIllIlllllllIIlI instanceof FloatInfo) {
            lllllllllllllllllIllIlllllllIIIl = this.getFloatInfo(lllllllllllllllllIllIllllllIllll);
        }
        else if (lllllllllllllllllIllIlllllllIIlI instanceof IntegerInfo) {
            lllllllllllllllllIllIlllllllIIIl = this.getIntegerInfo(lllllllllllllllllIllIllllllIllll);
        }
        else if (lllllllllllllllllIllIlllllllIIlI instanceof LongInfo) {
            lllllllllllllllllIllIlllllllIIIl = this.getLongInfo(lllllllllllllllllIllIllllllIllll);
        }
        else if (lllllllllllllllllIllIlllllllIIlI instanceof DoubleInfo) {
            lllllllllllllllllIllIlllllllIIIl = this.getDoubleInfo(lllllllllllllllllIllIllllllIllll);
        }
        return lllllllllllllllllIllIlllllllIIIl;
    }
    
    public String getDynamicType(final int lllllllllllllllllIllIlllIlIIIlll) {
        final DynamicInfo lllllllllllllllllIllIlllIlIIlIlI = (DynamicInfo)this.getItem(lllllllllllllllllIllIlllIlIIIlll);
        if (lllllllllllllllllIllIlllIlIIlIlI == null) {
            return null;
        }
        final NameAndTypeInfo lllllllllllllllllIllIlllIlIIlIIl = (NameAndTypeInfo)this.getItem(lllllllllllllllllIllIlllIlIIlIlI.nameAndType);
        if (lllllllllllllllllIllIlllIlIIlIIl == null) {
            return null;
        }
        return this.getUtf8Info(lllllllllllllllllIllIlllIlIIlIIl.typeDescriptor);
    }
    
    public int getDynamicBootstrap(final int lllllllllllllllllIllIlllIlIllllI) {
        final DynamicInfo lllllllllllllllllIllIlllIlIlllIl = (DynamicInfo)this.getItem(lllllllllllllllllIllIlllIlIllllI);
        return lllllllllllllllllIllIlllIlIlllIl.bootstrap;
    }
    
    static {
        CONST_MethodType = 16;
        CONST_String = 8;
        CONST_NameAndType = 12;
        REF_invokeSpecial = 7;
        CONST_Methodref = 10;
        CONST_Float = 4;
        REF_getField = 1;
        REF_invokeStatic = 6;
        REF_newInvokeSpecial = 8;
        CONST_InterfaceMethodref = 11;
        CONST_Utf8 = 1;
        CONST_DynamicCallSite = 18;
        REF_putStatic = 4;
        REF_putField = 3;
        REF_invokeVirtual = 5;
        CONST_Fieldref = 9;
        CONST_Dynamic = 17;
        CONST_Long = 5;
        CONST_Double = 6;
        REF_invokeInterface = 9;
        CONST_Integer = 3;
        CONST_Package = 20;
        CONST_Class = 7;
        CONST_MethodHandle = 15;
        REF_getStatic = 2;
        CONST_Module = 19;
        CONST_InvokeDynamic = 18;
        THIS = null;
    }
    
    private static Map<ConstInfo, ConstInfo> makeItemsCache(final LongVector lllllllllllllllllIllIlIllIlllIll) {
        final Map<ConstInfo, ConstInfo> lllllllllllllllllIllIlIllIlllIlI = new HashMap<ConstInfo, ConstInfo>();
        int lllllllllllllllllIllIlIllIlllIIl = 1;
        while (true) {
            final ConstInfo lllllllllllllllllIllIlIllIllllII = lllllllllllllllllIllIlIllIlllIll.elementAt(lllllllllllllllllIllIlIllIlllIIl++);
            if (lllllllllllllllllIllIlIllIllllII == null) {
                break;
            }
            lllllllllllllllllIllIlIllIlllIlI.put(lllllllllllllllllIllIlIllIllllII, lllllllllllllllllIllIlIllIllllII);
        }
        return lllllllllllllllllIllIlIllIlllIlI;
    }
    
    public int getMemberNameAndType(final int lllllllllllllllllIlllIIIlIIlIIll) {
        final MemberrefInfo lllllllllllllllllIlllIIIlIIlIlIl = (MemberrefInfo)this.getItem(lllllllllllllllllIlllIIIlIIlIIll);
        return lllllllllllllllllIlllIIIlIIlIlIl.nameAndTypeIndex;
    }
    
    public int addDoubleInfo(final double lllllllllllllllllIllIllIIIllllIl) {
        final int lllllllllllllllllIllIllIIIllllII = this.addItem(new DoubleInfo(lllllllllllllllllIllIllIIIllllIl, this.numOfItems));
        if (lllllllllllllllllIllIllIIIllllII == this.numOfItems - 1) {
            this.addConstInfoPadding();
        }
        return lllllllllllllllllIllIllIIIllllII;
    }
    
    public int getMethodrefNameAndType(final int lllllllllllllllllIlllIIIIlIIIlIl) {
        final MemberrefInfo lllllllllllllllllIlllIIIIlIIIlll = (MemberrefInfo)this.getItem(lllllllllllllllllIlllIIIIlIIIlIl);
        return lllllllllllllllllIlllIIIIlIIIlll.nameAndTypeIndex;
    }
    
    public String getClassInfo(final int lllllllllllllllllIlllIIIllIIIllI) {
        final ClassInfo lllllllllllllllllIlllIIIllIIIlIl = (ClassInfo)this.getItem(lllllllllllllllllIlllIIIllIIIllI);
        if (lllllllllllllllllIlllIIIllIIIlIl == null) {
            return null;
        }
        return Descriptor.toJavaName(this.getUtf8Info(lllllllllllllllllIlllIIIllIIIlIl.name));
    }
    
    public int addStringInfo(final String lllllllllllllllllIllIllIIlIllIll) {
        final int lllllllllllllllllIllIllIIlIllIlI = this.addUtf8Info(lllllllllllllllllIllIllIIlIllIll);
        return this.addItem(new StringInfo(lllllllllllllllllIllIllIIlIllIlI, this.numOfItems));
    }
    
    public int getInvokeDynamicBootstrap(final int lllllllllllllllllIllIllllIIIIIlI) {
        final InvokeDynamicInfo lllllllllllllllllIllIllllIIIIlII = (InvokeDynamicInfo)this.getItem(lllllllllllllllllIllIllllIIIIIlI);
        return lllllllllllllllllIllIllllIIIIlII.bootstrap;
    }
    
    public float getFloatInfo(final int lllllllllllllllllIllIlllllIlllll) {
        final FloatInfo lllllllllllllllllIllIlllllIllllI = (FloatInfo)this.getItem(lllllllllllllllllIllIlllllIlllll);
        return lllllllllllllllllIllIlllllIllllI.value;
    }
    
    public int isConstructor(final String lllllllllllllllllIllIlllIIlIlllI, final int lllllllllllllllllIllIlllIIlIlIlI) {
        return this.isMember(lllllllllllllllllIllIlllIIlIlllI, "<init>", lllllllllllllllllIllIlllIIlIlIlI);
    }
    
    public int getTag(final int lllllllllllllllllIlllIIIllIIllIl) {
        return this.getItem(lllllllllllllllllIlllIIIllIIllIl).getTag();
    }
    
    public int addUtf8Info(final String lllllllllllllllllIllIllIIIllIIll) {
        return this.addItem(new Utf8Info(lllllllllllllllllIllIllIIIllIIll, this.numOfItems));
    }
    
    public int isMember(final String lllllllllllllllllIllIlllIIlIIIIl, final String lllllllllllllllllIllIlllIIlIIIII, final int lllllllllllllllllIllIlllIIIlllll) {
        final MemberrefInfo lllllllllllllllllIllIlllIIIllllI = (MemberrefInfo)this.getItem(lllllllllllllllllIllIlllIIIlllll);
        if (this.getClassInfo(lllllllllllllllllIllIlllIIIllllI.classIndex).equals(lllllllllllllllllIllIlllIIlIIIIl)) {
            final NameAndTypeInfo lllllllllllllllllIllIlllIIlIIIll = (NameAndTypeInfo)this.getItem(lllllllllllllllllIllIlllIIIllllI.nameAndTypeIndex);
            if (this.getUtf8Info(lllllllllllllllllIllIlllIIlIIIll.memberName).equals(lllllllllllllllllIllIlllIIlIIIII)) {
                return lllllllllllllllllIllIlllIIlIIIll.typeDescriptor;
            }
        }
        return 0;
    }
    
    public int getMethodHandleKind(final int lllllllllllllllllIllIllllIlIllII) {
        final MethodHandleInfo lllllllllllllllllIllIllllIlIllll = (MethodHandleInfo)this.getItem(lllllllllllllllllIllIllllIlIllII);
        return lllllllllllllllllIllIllllIlIllll.refKind;
    }
    
    public int addMethodrefInfo(final int lllllllllllllllllIllIllIlIIIlIIl, final String lllllllllllllllllIllIllIlIIIlIII, final String lllllllllllllllllIllIllIlIIIIIlI) {
        final int lllllllllllllllllIllIllIlIIIIllI = this.addNameAndTypeInfo(lllllllllllllllllIllIllIlIIIlIII, lllllllllllllllllIllIllIlIIIIIlI);
        return this.addMethodrefInfo(lllllllllllllllllIllIllIlIIIlIIl, lllllllllllllllllIllIllIlIIIIllI);
    }
    
    public String getInterfaceMethodrefName(final int lllllllllllllllllIlllIIIIIIIIlll) {
        final MemberrefInfo lllllllllllllllllIlllIIIIIIIlIlI = (MemberrefInfo)this.getItem(lllllllllllllllllIlllIIIIIIIIlll);
        if (lllllllllllllllllIlllIIIIIIIlIlI == null) {
            return null;
        }
        final NameAndTypeInfo lllllllllllllllllIlllIIIIIIIlIIl = (NameAndTypeInfo)this.getItem(lllllllllllllllllIlllIIIIIIIlIlI.nameAndTypeIndex);
        if (lllllllllllllllllIlllIIIIIIIlIIl == null) {
            return null;
        }
        return this.getUtf8Info(lllllllllllllllllIlllIIIIIIIlIIl.memberName);
    }
    
    public int copy(final int lllllllllllllllllIllIllIllIllIlI, final ConstPool lllllllllllllllllIllIllIllIllIIl, final Map<String, String> lllllllllllllllllIllIllIllIlIIll) {
        if (lllllllllllllllllIllIllIllIllIlI == 0) {
            return 0;
        }
        final ConstInfo lllllllllllllllllIllIllIllIlIlll = this.getItem(lllllllllllllllllIllIllIllIllIlI);
        return lllllllllllllllllIllIllIllIlIlll.copy(this, lllllllllllllllllIllIllIllIllIIl, lllllllllllllllllIllIllIllIlIIll);
    }
    
    public String getUtf8Info(final int lllllllllllllllllIllIllllIlllIII) {
        final Utf8Info lllllllllllllllllIllIllllIlllIlI = (Utf8Info)this.getItem(lllllllllllllllllIllIllllIlllIII);
        return lllllllllllllllllIllIllllIlllIlI.string;
    }
    
    void prune() {
        this.itemsCache = null;
    }
    
    public ConstPool(final DataInputStream lllllllllllllllllIlllIIIlllIlIIl) throws IOException {
        this.itemsCache = null;
        this.thisClassInfo = 0;
        this.read(lllllllllllllllllIlllIIIlllIlIIl);
    }
    
    public String getMethodrefType(final int lllllllllllllllllIlllIIIIIlIlllI) {
        final MemberrefInfo lllllllllllllllllIlllIIIIIllIIIl = (MemberrefInfo)this.getItem(lllllllllllllllllIlllIIIIIlIlllI);
        if (lllllllllllllllllIlllIIIIIllIIIl == null) {
            return null;
        }
        final NameAndTypeInfo lllllllllllllllllIlllIIIIIllIIII = (NameAndTypeInfo)this.getItem(lllllllllllllllllIlllIIIIIllIIIl.nameAndTypeIndex);
        if (lllllllllllllllllIlllIIIIIllIIII == null) {
            return null;
        }
        return this.getUtf8Info(lllllllllllllllllIlllIIIIIllIIII.typeDescriptor);
    }
    
    public int addDynamicInfo(final int lllllllllllllllllIllIllIIIIlIIll, final int lllllllllllllllllIllIllIIIIlIIlI) {
        return this.addItem(new DynamicInfo(lllllllllllllllllIllIllIIIIlIIll, lllllllllllllllllIllIllIIIIlIIlI, this.numOfItems));
    }
    
    public String getInvokeDynamicType(final int lllllllllllllllllIllIlllIllIIlIl) {
        final InvokeDynamicInfo lllllllllllllllllIllIlllIllIlIII = (InvokeDynamicInfo)this.getItem(lllllllllllllllllIllIlllIllIIlIl);
        if (lllllllllllllllllIllIlllIllIlIII == null) {
            return null;
        }
        final NameAndTypeInfo lllllllllllllllllIllIlllIllIIlll = (NameAndTypeInfo)this.getItem(lllllllllllllllllIllIlllIllIlIII.nameAndType);
        if (lllllllllllllllllIllIlllIllIIlll == null) {
            return null;
        }
        return this.getUtf8Info(lllllllllllllllllIllIlllIllIIlll.typeDescriptor);
    }
    
    public int getMethodTypeInfo(final int lllllllllllllllllIllIllllIIlIlll) {
        final MethodTypeInfo lllllllllllllllllIllIllllIIlIlIl = (MethodTypeInfo)this.getItem(lllllllllllllllllIllIllllIIlIlll);
        return lllllllllllllllllIllIllllIIlIlIl.descriptor;
    }
    
    public int getInterfaceMethodrefNameAndType(final int lllllllllllllllllIlllIIIIIIlIlIl) {
        final MemberrefInfo lllllllllllllllllIlllIIIIIIlIlII = (MemberrefInfo)this.getItem(lllllllllllllllllIlllIIIIIIlIlIl);
        return lllllllllllllllllIlllIIIIIIlIlII.nameAndTypeIndex;
    }
}
