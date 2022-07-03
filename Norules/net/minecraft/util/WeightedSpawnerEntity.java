package net.minecraft.util;

import net.minecraft.nbt.*;

public class WeightedSpawnerEntity extends WeightedRandom.Item
{
    private final /* synthetic */ NBTTagCompound nbt;
    
    public WeightedSpawnerEntity(final NBTTagCompound lllllllllllllIlllllllIllIlIIIlII) {
        this(lllllllllllllIlllllllIllIlIIIlII.hasKey("Weight", 99) ? lllllllllllllIlllllllIllIlIIIlII.getInteger("Weight") : 1, lllllllllllllIlllllllIllIlIIIlII.getCompoundTag("Entity"));
    }
    
    public NBTTagCompound getNbt() {
        return this.nbt;
    }
    
    public WeightedSpawnerEntity() {
        super(1);
        this.nbt = new NBTTagCompound();
        this.nbt.setString("id", "minecraft:pig");
    }
    
    public WeightedSpawnerEntity(final int lllllllllllllIlllllllIllIIllllll, final NBTTagCompound lllllllllllllIlllllllIllIIlllllI) {
        super(lllllllllllllIlllllllIllIIllllll);
        this.nbt = lllllllllllllIlllllllIllIIlllllI;
    }
    
    public NBTTagCompound toCompoundTag() {
        final NBTTagCompound lllllllllllllIlllllllIllIIllIlll = new NBTTagCompound();
        if (!this.nbt.hasKey("id", 8)) {
            this.nbt.setString("id", "minecraft:pig");
        }
        else if (!this.nbt.getString("id").contains(":")) {
            this.nbt.setString("id", new ResourceLocation(this.nbt.getString("id")).toString());
        }
        lllllllllllllIlllllllIllIIllIlll.setTag("Entity", this.nbt);
        lllllllllllllIlllllllIllIIllIlll.setInteger("Weight", this.itemWeight);
        return lllllllllllllIlllllllIllIIllIlll;
    }
}
