package net.minecraft.client.util;

import net.minecraft.client.gui.recipebook.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.client.resources.*;
import com.google.common.collect.*;

public class SearchTreeManager implements IResourceManagerReloadListener
{
    private final /* synthetic */ Map<Key<?>, SearchTree<?>> field_194013_c;
    
    @Override
    public void onResourceManagerReload(final IResourceManager lllllllllllllIllIlIlIIlIllIIlIII) {
        for (final SearchTree<?> lllllllllllllIllIlIlIIlIllIIIlll : this.field_194013_c.values()) {
            lllllllllllllIllIlIlIIlIllIIIlll.func_194040_a();
        }
    }
    
    public SearchTreeManager() {
        this.field_194013_c = (Map<Key<?>, SearchTree<?>>)Maps.newHashMap();
    }
    
    public <T> void func_194009_a(final Key<T> lllllllllllllIllIlIlIIlIlIllllll, final SearchTree<T> lllllllllllllIllIlIlIIlIlIlllllI) {
        this.field_194013_c.put(lllllllllllllIllIlIlIIlIlIllllll, lllllllllllllIllIlIlIIlIlIlllllI);
    }
    
    static {
        field_194011_a = new Key<ItemStack>();
        field_194012_b = new Key<RecipeList>();
    }
    
    public <T> ISearchTree<T> func_194010_a(final Key<T> lllllllllllllIllIlIlIIlIlIllIlll) {
        return (ISearchTree<T>)this.field_194013_c.get(lllllllllllllIllIlIlIIlIlIllIlll);
    }
    
    public static class Key<T>
    {
    }
}
