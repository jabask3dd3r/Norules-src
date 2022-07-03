package com.viaversion.viaversion.libs.kyori.adventure.text;

import org.jetbrains.annotations.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import java.util.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;

abstract class NBTComponentImpl<C extends NBTComponent<C, B>, B extends NBTComponentBuilder<C, B>> extends AbstractComponent implements NBTComponent<C, B>
{
    @Nullable
    final /* synthetic */ Component separator;
    final /* synthetic */ boolean interpret;
    final /* synthetic */ String nbtPath;
    
    @Override
    public int hashCode() {
        int lllllllllllllIIlIIlIIIIIlIlIlIIl = super.hashCode();
        lllllllllllllIIlIIlIIIIIlIlIlIIl = 31 * lllllllllllllIIlIIlIIIIIlIlIlIIl + this.nbtPath.hashCode();
        lllllllllllllIIlIIlIIIIIlIlIlIIl = 31 * lllllllllllllIIlIIlIIIIIlIlIlIIl + Boolean.hashCode(this.interpret);
        lllllllllllllIIlIIlIIIIIlIlIlIIl = 31 * lllllllllllllIIlIIlIIIIIlIlIlIIl + Objects.hashCode(this.separator);
        return lllllllllllllIIlIIlIIIIIlIlIlIIl;
    }
    
    static {
        INTERPRET_DEFAULT = false;
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIIlIIlIIIIIlIllIIll) {
        if (this == lllllllllllllIIlIIlIIIIIlIllIIll) {
            return true;
        }
        if (!(lllllllllllllIIlIIlIIIIIlIllIIll instanceof NBTComponent)) {
            return false;
        }
        if (!super.equals(lllllllllllllIIlIIlIIIIIlIllIIll)) {
            return false;
        }
        final NBTComponent<?, ?> lllllllllllllIIlIIlIIIIIlIllIIII = (NBTComponent<?, ?>)lllllllllllllIIlIIlIIIIIlIllIIll;
        return Objects.equals(this.nbtPath, lllllllllllllIIlIIlIIIIIlIllIIII.nbtPath()) && this.interpret == lllllllllllllIIlIIlIIIIIlIllIIII.interpret() && Objects.equals(this.separator, lllllllllllllIIlIIlIIIIIlIllIIII.separator());
    }
    
    @NotNull
    @Override
    public String nbtPath() {
        return this.nbtPath;
    }
    
    @Override
    public boolean interpret() {
        return this.interpret;
    }
    
    @NotNull
    @Override
    protected Stream<? extends ExaminableProperty> examinablePropertiesWithoutChildren() {
        return Stream.concat((Stream<? extends ExaminableProperty>)Stream.of((T[])new ExaminableProperty[] { ExaminableProperty.of("nbtPath", this.nbtPath), ExaminableProperty.of("interpret", this.interpret), ExaminableProperty.of("separator", this.separator) }), super.examinablePropertiesWithoutChildren());
    }
    
    NBTComponentImpl(@NotNull final List<? extends ComponentLike> lllllllllllllIIlIIlIIIIIllIIllII, @NotNull final Style lllllllllllllIIlIIlIIIIIllIIllIl, final String lllllllllllllIIlIIlIIIIIllIIlIlI, final boolean lllllllllllllIIlIIlIIIIIllIIlIll, @Nullable final ComponentLike lllllllllllllIIlIIlIIIIIllIIlIIl) {
        super(lllllllllllllIIlIIlIIIIIllIIllII, lllllllllllllIIlIIlIIIIIllIIllIl);
        this.nbtPath = lllllllllllllIIlIIlIIIIIllIIlIlI;
        this.interpret = lllllllllllllIIlIIlIIIIIllIIlIll;
        this.separator = ComponentLike.unbox(lllllllllllllIIlIIlIIIIIllIIlIIl);
    }
    
    abstract static class BuilderImpl<C extends NBTComponent<C, B>, B extends NBTComponentBuilder<C, B>> extends AbstractComponentBuilder<C, B> implements NBTComponentBuilder<C, B>
    {
        @Nullable
        protected /* synthetic */ Component separator;
        protected /* synthetic */ boolean interpret;
        @Nullable
        protected /* synthetic */ String nbtPath;
        
        @NotNull
        @Override
        public B nbtPath(@NotNull final String lllllllllllllIIllIIIlIllIIlIIIll) {
            this.nbtPath = lllllllllllllIIllIIIlIllIIlIIIll;
            return (B)this;
        }
        
        @NotNull
        @Override
        public B separator(@Nullable final ComponentLike lllllllllllllIIllIIIlIllIIIlIlIl) {
            this.separator = ComponentLike.unbox(lllllllllllllIIllIIIlIllIIIlIlIl);
            return (B)this;
        }
        
        BuilderImpl(@NotNull final C lllllllllllllIIllIIIlIllIIlIlIlI) {
            super(lllllllllllllIIllIIIlIllIIlIlIlI);
            this.interpret = false;
            this.nbtPath = lllllllllllllIIllIIIlIllIIlIlIlI.nbtPath();
            this.interpret = lllllllllllllIIllIIIlIllIIlIlIlI.interpret();
        }
        
        @NotNull
        @Override
        public B interpret(final boolean lllllllllllllIIllIIIlIllIIIlllII) {
            this.interpret = lllllllllllllIIllIIIlIllIIIlllII;
            return (B)this;
        }
        
        BuilderImpl() {
            this.interpret = false;
        }
    }
}
