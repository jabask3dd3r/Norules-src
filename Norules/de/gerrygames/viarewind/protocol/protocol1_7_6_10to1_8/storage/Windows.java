package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage;

import java.util.*;
import com.viaversion.viaversion.api.connection.*;

public class Windows extends StoredObject
{
    public /* synthetic */ HashMap<Short, Short> types;
    public /* synthetic */ short anvilId;
    public /* synthetic */ short levelCost;
    public /* synthetic */ HashMap<Short, Furnace> furnace;
    
    public void remove(final short llIlllIllllIIl) {
        this.types.remove(llIlllIllllIIl);
        this.furnace.remove(llIlllIllllIIl);
    }
    
    public short get(final short llIlllIlllllll) {
        return this.types.getOrDefault(llIlllIlllllll, (Short)(-1));
    }
    
    public static int getInventoryType(final String llIlllIlllIIlI) {
        final byte llIlllIlllIIIl = (byte)llIlllIlllIIlI;
        int llIlllIlllIIII = -1;
        switch (((String)llIlllIlllIIIl).hashCode()) {
            case 1438413556: {
                if (((String)llIlllIlllIIIl).equals("minecraft:container")) {
                    llIlllIlllIIII = 0;
                    break;
                }
                break;
            }
            case -1149092108: {
                if (((String)llIlllIlllIIIl).equals("minecraft:chest")) {
                    llIlllIlllIIII = 1;
                    break;
                }
                break;
            }
            case -1124126594: {
                if (((String)llIlllIlllIIIl).equals("minecraft:crafting_table")) {
                    llIlllIlllIIII = 2;
                    break;
                }
                break;
            }
            case -1719356277: {
                if (((String)llIlllIlllIIIl).equals("minecraft:furnace")) {
                    llIlllIlllIIII = 3;
                    break;
                }
                break;
            }
            case 2090881320: {
                if (((String)llIlllIlllIIIl).equals("minecraft:dispenser")) {
                    llIlllIlllIIII = 4;
                    break;
                }
                break;
            }
            case 319164197: {
                if (((String)llIlllIlllIIIl).equals("minecraft:enchanting_table")) {
                    llIlllIlllIIII = 5;
                    break;
                }
                break;
            }
            case 1649065834: {
                if (((String)llIlllIlllIIIl).equals("minecraft:brewing_stand")) {
                    llIlllIlllIIII = 6;
                    break;
                }
                break;
            }
            case -1879003021: {
                if (((String)llIlllIlllIIIl).equals("minecraft:villager")) {
                    llIlllIlllIIII = 7;
                    break;
                }
                break;
            }
            case -1293651279: {
                if (((String)llIlllIlllIIIl).equals("minecraft:beacon")) {
                    llIlllIlllIIII = 8;
                    break;
                }
                break;
            }
            case -1150744385: {
                if (((String)llIlllIlllIIIl).equals("minecraft:anvil")) {
                    llIlllIlllIIII = 9;
                    break;
                }
                break;
            }
            case -1112182111: {
                if (((String)llIlllIlllIIIl).equals("minecraft:hopper")) {
                    llIlllIlllIIII = 10;
                    break;
                }
                break;
            }
            case 712019713: {
                if (((String)llIlllIlllIIIl).equals("minecraft:dropper")) {
                    llIlllIlllIIII = 11;
                    break;
                }
                break;
            }
            case -1366784614: {
                if (((String)llIlllIlllIIIl).equals("EntityHorse")) {
                    llIlllIlllIIII = 12;
                    break;
                }
                break;
            }
        }
        switch (llIlllIlllIIII) {
            case 0: {
                return 0;
            }
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 3;
            }
            case 5: {
                return 4;
            }
            case 6: {
                return 5;
            }
            case 7: {
                return 6;
            }
            case 8: {
                return 7;
            }
            case 9: {
                return 8;
            }
            case 10: {
                return 9;
            }
            case 11: {
                return 10;
            }
            case 12: {
                return 11;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Unknown type ").append(llIlllIlllIIlI)));
            }
        }
    }
    
    public Windows(final UserConnection llIllllIIIIlIl) {
        super(llIllllIIIIlIl);
        this.types = new HashMap<Short, Short>();
        this.furnace = new HashMap<Short, Furnace>();
        this.levelCost = 0;
        this.anvilId = -1;
    }
    
    public static class Furnace
    {
        private /* synthetic */ short maxFuel;
        private /* synthetic */ short progress;
        private /* synthetic */ short maxProgress;
        private /* synthetic */ short fuelLeft;
        
        public short getMaxProgress() {
            return this.maxProgress;
        }
        
        public void setMaxFuel(final short lllllllllllllIlllllIIllIlIIIllll) {
            this.maxFuel = lllllllllllllIlllllIIllIlIIIllll;
        }
        
        public short getProgress() {
            return this.progress;
        }
        
        public void setFuelLeft(final short lllllllllllllIlllllIIllIlIIlIIll) {
            this.fuelLeft = lllllllllllllIlllllIIllIlIIlIIll;
        }
        
        public Furnace() {
            this.fuelLeft = 0;
            this.maxFuel = 0;
            this.progress = 0;
            this.maxProgress = 200;
        }
        
        public void setMaxProgress(final short lllllllllllllIlllllIIllIlIIIIIIl) {
            this.maxProgress = lllllllllllllIlllllIIllIlIIIIIIl;
        }
        
        public void setProgress(final short lllllllllllllIlllllIIllIlIIIlIIl) {
            this.progress = lllllllllllllIlllllIIllIlIIIlIIl;
        }
        
        public short getFuelLeft() {
            return this.fuelLeft;
        }
        
        public short getMaxFuel() {
            return this.maxFuel;
        }
        
        protected boolean canEqual(final Object lllllllllllllIlllllIIllIIlllIlIl) {
            return lllllllllllllIlllllIIllIIlllIlIl instanceof Furnace;
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append("Windows.Furnace(fuelLeft=").append(this.getFuelLeft()).append(", maxFuel=").append(this.getMaxFuel()).append(", progress=").append(this.getProgress()).append(", maxProgress=").append(this.getMaxProgress()).append(")"));
        }
        
        @Override
        public boolean equals(final Object lllllllllllllIlllllIIllIIllllIIl) {
            if (lllllllllllllIlllllIIllIIllllIIl == this) {
                return true;
            }
            if (!(lllllllllllllIlllllIIllIIllllIIl instanceof Furnace)) {
                return false;
            }
            final Furnace lllllllllllllIlllllIIllIIllllIll = (Furnace)lllllllllllllIlllllIIllIIllllIIl;
            return lllllllllllllIlllllIIllIIllllIll.canEqual(this) && this.getFuelLeft() == lllllllllllllIlllllIIllIIllllIll.getFuelLeft() && this.getMaxFuel() == lllllllllllllIlllllIIllIIllllIll.getMaxFuel() && this.getProgress() == lllllllllllllIlllllIIllIIllllIll.getProgress() && this.getMaxProgress() == lllllllllllllIlllllIIllIIllllIll.getMaxProgress();
        }
        
        @Override
        public int hashCode() {
            final int lllllllllllllIlllllIIllIIllIllll = 59;
            int lllllllllllllIlllllIIllIIllIlllI = 1;
            lllllllllllllIlllllIIllIIllIlllI = lllllllllllllIlllllIIllIIllIlllI * 59 + this.getFuelLeft();
            lllllllllllllIlllllIIllIIllIlllI = lllllllllllllIlllllIIllIIllIlllI * 59 + this.getMaxFuel();
            lllllllllllllIlllllIIllIIllIlllI = lllllllllllllIlllllIIllIIllIlllI * 59 + this.getProgress();
            lllllllllllllIlllllIIllIIllIlllI = lllllllllllllIlllllIIllIIllIlllI * 59 + this.getMaxProgress();
            return lllllllllllllIlllllIIllIIllIlllI;
        }
    }
}
