package net.minecraft.client.player.inventory;

import java.util.*;
import net.minecraft.util.text.*;
import com.google.common.collect.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;

public class ContainerLocalMenu extends InventoryBasic implements ILockableContainer
{
    private final /* synthetic */ String guiID;
    private final /* synthetic */ Map<Integer, Integer> dataValues;
    
    public ContainerLocalMenu(final String lllllllllllllIllIlIIIIlllIlIlIIl, final ITextComponent lllllllllllllIllIlIIIIlllIlIIlII, final int lllllllllllllIllIlIIIIlllIlIIIll) {
        super(lllllllllllllIllIlIIIIlllIlIIlII, lllllllllllllIllIlIIIIlllIlIIIll);
        this.dataValues = (Map<Integer, Integer>)Maps.newHashMap();
        this.guiID = lllllllllllllIllIlIIIIlllIlIlIIl;
    }
    
    @Override
    public LockCode getLockCode() {
        return LockCode.EMPTY_CODE;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer lllllllllllllIllIlIIIIlllIIIlIII, final EntityPlayer lllllllllllllIllIlIIIIlllIIIIlll) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String getGuiID() {
        return this.guiID;
    }
    
    @Override
    public void setLockCode(final LockCode lllllllllllllIllIlIIIIlllIIIlllI) {
    }
    
    @Override
    public boolean isLocked() {
        return false;
    }
    
    @Override
    public int getFieldCount() {
        return this.dataValues.size();
    }
    
    @Override
    public int getField(final int lllllllllllllIllIlIIIIlllIIlllIl) {
        return this.dataValues.containsKey(lllllllllllllIllIlIIIIlllIIlllIl) ? this.dataValues.get(lllllllllllllIllIlIIIIlllIIlllIl) : 0;
    }
    
    @Override
    public void setField(final int lllllllllllllIllIlIIIIlllIIllIII, final int lllllllllllllIllIlIIIIlllIIlIlll) {
        this.dataValues.put(lllllllllllllIllIlIIIIlllIIllIII, lllllllllllllIllIlIIIIlllIIlIlll);
    }
}
