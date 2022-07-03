package net.minecraft.util;

public abstract class LazyLoadBase<T>
{
    private /* synthetic */ T value;
    private /* synthetic */ boolean isLoaded;
    
    public T getValue() {
        if (!this.isLoaded) {
            this.isLoaded = true;
            this.value = this.load();
        }
        return this.value;
    }
    
    protected abstract T load();
}
