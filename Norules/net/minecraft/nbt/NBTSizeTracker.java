package net.minecraft.nbt;

public class NBTSizeTracker
{
    private /* synthetic */ long read;
    private final /* synthetic */ long max;
    
    public void read(final long lllllllllllllIlIIIIlllIIIIIllIll) {
        this.read += lllllllllllllIlIIIIlllIIIIIllIll / 8L;
        if (this.read > this.max) {
            throw new RuntimeException(String.valueOf(new StringBuilder("Tried to read NBT tag that was too big; tried to allocate: ").append(this.read).append("bytes where max allowed: ").append(this.max)));
        }
    }
    
    static {
        INFINITE = new NBTSizeTracker() {
            @Override
            public void read(final long llllllllllllllIlIlIIllllIlIIIlll) {
            }
        };
    }
    
    public NBTSizeTracker(final long lllllllllllllIlIIIIlllIIIIIlllll) {
        this.max = lllllllllllllIlIIIIlllIIIIIlllll;
    }
}
