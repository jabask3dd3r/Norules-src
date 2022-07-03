package com.viaversion.viaversion.libs.kyori.adventure.text;

import com.viaversion.viaversion.libs.kyori.adventure.text.format.*;
import org.jetbrains.annotations.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.kyori.examination.*;
import java.util.*;
import java.util.regex.*;
import com.viaversion.viaversion.libs.kyori.adventure.util.*;

final class BlockNBTComponentImpl extends NBTComponentImpl<BlockNBTComponent, BlockNBTComponent.Builder> implements BlockNBTComponent
{
    private final /* synthetic */ Pos pos;
    
    @Override
    public BlockNBTComponent.Builder toBuilder() {
        return new BuilderImpl(this);
    }
    
    @NotNull
    @Override
    public Pos pos() {
        return this.pos;
    }
    
    @NotNull
    @Override
    public BlockNBTComponent style(@NotNull final Style lllllllllllllIIIlIlllIlIIlIlllll) {
        return new BlockNBTComponentImpl(this.children, lllllllllllllIIIlIlllIlIIlIlllll, this.nbtPath, this.interpret, this.separator, this.pos);
    }
    
    @NotNull
    @Override
    public BlockNBTComponent pos(@NotNull final Pos lllllllllllllIIIlIlllIlIIllIllIl) {
        return new BlockNBTComponentImpl(this.children, this.style, this.nbtPath, this.interpret, this.separator, lllllllllllllIIIlIlllIlIIllIllIl);
    }
    
    @Nullable
    @Override
    public Component separator() {
        return this.separator;
    }
    
    @NotNull
    @Override
    public BlockNBTComponent separator(@Nullable final ComponentLike lllllllllllllIIIlIlllIlIIlllIlll) {
        return new BlockNBTComponentImpl(this.children, this.style, this.nbtPath, this.interpret, lllllllllllllIIIlIlllIlIIlllIlll, this.pos);
    }
    
    @NotNull
    @Override
    public BlockNBTComponent children(@NotNull final List<? extends ComponentLike> lllllllllllllIIIlIlllIlIIllIIllI) {
        return new BlockNBTComponentImpl(lllllllllllllIIIlIlllIlIIllIIllI, this.style, this.nbtPath, this.interpret, this.separator, this.pos);
    }
    
    @NotNull
    @Override
    protected Stream<? extends ExaminableProperty> examinablePropertiesWithoutChildren() {
        return Stream.concat((Stream<? extends ExaminableProperty>)Stream.of((T)ExaminableProperty.of("pos", this.pos)), super.examinablePropertiesWithoutChildren());
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIIIlIlllIlIIlIIllIl = super.hashCode();
        lllllllllllllIIIlIlllIlIIlIIllIl = 31 * lllllllllllllIIIlIlllIlIIlIIllIl + this.pos.hashCode();
        return lllllllllllllIIIlIlllIlIIlIIllIl;
    }
    
    @NotNull
    @Override
    public BlockNBTComponent interpret(final boolean lllllllllllllIIIlIlllIlIlIIIIIIl) {
        if (this.interpret == lllllllllllllIIIlIlllIlIlIIIIIIl) {
            return this;
        }
        return new BlockNBTComponentImpl(this.children, this.style, this.nbtPath, lllllllllllllIIIlIlllIlIlIIIIIIl, this.separator, this.pos);
    }
    
    BlockNBTComponentImpl(@NotNull final List<? extends ComponentLike> lllllllllllllIIIlIlllIlIlIIlllIl, @NotNull final Style lllllllllllllIIIlIlllIlIlIIlllII, final String lllllllllllllIIIlIlllIlIlIIllIlI, final boolean lllllllllllllIIIlIlllIlIlIIllllI, @Nullable final ComponentLike lllllllllllllIIIlIlllIlIlIIllIIl, @NotNull final Pos lllllllllllllIIIlIlllIlIlIIllIll) {
        super(lllllllllllllIIIlIlllIlIlIIlllIl, lllllllllllllIIIlIlllIlIlIIlllII, lllllllllllllIIIlIlllIlIlIIllIlI, lllllllllllllIIIlIlllIlIlIIllllI, lllllllllllllIIIlIlllIlIlIIllIIl);
        this.pos = lllllllllllllIIIlIlllIlIlIIllIll;
    }
    
    @Override
    public boolean equals(@Nullable final Object lllllllllllllIIIlIlllIlIIlIlIlll) {
        if (this == lllllllllllllIIIlIlllIlIIlIlIlll) {
            return true;
        }
        if (!(lllllllllllllIIIlIlllIlIIlIlIlll instanceof BlockNBTComponent)) {
            return false;
        }
        if (!super.equals(lllllllllllllIIIlIlllIlIIlIlIlll)) {
            return false;
        }
        final BlockNBTComponent lllllllllllllIIIlIlllIlIIlIlIlII = (BlockNBTComponent)lllllllllllllIIIlIlllIlIIlIlIlll;
        return Objects.equals(this.pos, lllllllllllllIIIlIlllIlIIlIlIlII.pos());
    }
    
    @NotNull
    @Override
    public BlockNBTComponent nbtPath(@NotNull final String lllllllllllllIIIlIlllIlIlIIIlIII) {
        if (Objects.equals(this.nbtPath, lllllllllllllIIIlIlllIlIlIIIlIII)) {
            return this;
        }
        return new BlockNBTComponentImpl(this.children, this.style, lllllllllllllIIIlIlllIlIlIIIlIII, this.interpret, this.separator, this.pos);
    }
    
    static final class WorldPosImpl implements WorldPos
    {
        private final /* synthetic */ Coordinate x;
        private final /* synthetic */ Coordinate y;
        private final /* synthetic */ Coordinate z;
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append(this.x.toString()).append(' ').append(this.y.toString()).append(' ').append(this.z.toString()));
        }
        
        @NotNull
        @Override
        public Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("x", this.x), ExaminableProperty.of("y", this.y), ExaminableProperty.of("z", this.z) });
        }
        
        @NotNull
        @Override
        public Coordinate y() {
            return this.y;
        }
        
        WorldPosImpl(final Coordinate lllllllllllllIllllIlIIlIIIIIllII, final Coordinate lllllllllllllIllllIlIIlIIIIIllIl, final Coordinate lllllllllllllIllllIlIIlIIIIIlllI) {
            this.x = Objects.requireNonNull(lllllllllllllIllllIlIIlIIIIIllII, "x");
            this.y = Objects.requireNonNull(lllllllllllllIllllIlIIlIIIIIllIl, "y");
            this.z = Objects.requireNonNull(lllllllllllllIllllIlIIlIIIIIlllI, "z");
        }
        
        @NotNull
        @Override
        public String asString() {
            return String.valueOf(new StringBuilder().append(Tokens.serializeCoordinate(this.x())).append(' ').append(Tokens.serializeCoordinate(this.y())).append(' ').append(Tokens.serializeCoordinate(this.z())));
        }
        
        @Override
        public int hashCode() {
            int lllllllllllllIllllIlIIIllllIlIlI = this.x.hashCode();
            lllllllllllllIllllIlIIIllllIlIlI = 31 * lllllllllllllIllllIlIIIllllIlIlI + this.y.hashCode();
            lllllllllllllIllllIlIIIllllIlIlI = 31 * lllllllllllllIllllIlIIIllllIlIlI + this.z.hashCode();
            return lllllllllllllIllllIlIIIllllIlIlI;
        }
        
        @NotNull
        @Override
        public Coordinate z() {
            return this.z;
        }
        
        @NotNull
        @Override
        public Coordinate x() {
            return this.x;
        }
        
        @Override
        public boolean equals(@Nullable final Object lllllllllllllIllllIlIIIlllllIlII) {
            if (this == lllllllllllllIllllIlIIIlllllIlII) {
                return true;
            }
            if (!(lllllllllllllIllllIlIIIlllllIlII instanceof WorldPos)) {
                return false;
            }
            final WorldPos lllllllllllllIllllIlIIIlllllIIIl = (WorldPos)lllllllllllllIllllIlIIIlllllIlII;
            return this.x.equals(lllllllllllllIllllIlIIIlllllIIIl.x()) && this.y.equals(lllllllllllllIllllIlIIIlllllIIIl.y()) && this.z.equals(lllllllllllllIllllIlIIIlllllIIIl.z());
        }
        
        static final class CoordinateImpl implements Coordinate
        {
            private final /* synthetic */ Type type;
            private final /* synthetic */ int value;
            
            @Override
            public String toString() {
                return String.valueOf(new StringBuilder().append((this.type == Type.RELATIVE) ? "~" : "").append(this.value));
            }
            
            @NotNull
            @Override
            public Type type() {
                return this.type;
            }
            
            @Override
            public int hashCode() {
                int lllllllllllllllllIllIIlIIlIIIlII = this.value;
                lllllllllllllllllIllIIlIIlIIIlII = 31 * lllllllllllllllllIllIIlIIlIIIlII + this.type.hashCode();
                return lllllllllllllllllIllIIlIIlIIIlII;
            }
            
            @Override
            public int value() {
                return this.value;
            }
            
            @NotNull
            @Override
            public Stream<? extends ExaminableProperty> examinableProperties() {
                return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("value", this.value), ExaminableProperty.of("type", this.type) });
            }
            
            CoordinateImpl(final int lllllllllllllllllIllIIlIIllIIIIl, @NotNull final Type lllllllllllllllllIllIIlIIllIIIlI) {
                this.value = lllllllllllllllllIllIIlIIllIIIIl;
                this.type = Objects.requireNonNull(lllllllllllllllllIllIIlIIllIIIlI, "type");
            }
            
            @Override
            public boolean equals(@Nullable final Object lllllllllllllllllIllIIlIIlIIlllI) {
                if (this == lllllllllllllllllIllIIlIIlIIlllI) {
                    return true;
                }
                if (!(lllllllllllllllllIllIIlIIlIIlllI instanceof Coordinate)) {
                    return false;
                }
                final Coordinate lllllllllllllllllIllIIlIIlIIlIll = (Coordinate)lllllllllllllllllIllIIlIIlIIlllI;
                return this.value() == lllllllllllllllllIllIIlIIlIIlIll.value() && this.type() == lllllllllllllllllIllIIlIIlIIlIll.type();
            }
        }
    }
    
    static final class Tokens
    {
        static String serializeCoordinate(final WorldPos.Coordinate lllllllllllllIIIIIlllIlIllIllIll) {
            return String.valueOf(new StringBuilder().append((lllllllllllllIIIIIlllIlIllIllIll.type() == WorldPos.Coordinate.Type.RELATIVE) ? "~" : "").append(lllllllllllllIIIIIlllIlIllIllIll.value()));
        }
        
        static String serializeLocal(final double lllllllllllllIIIIIlllIlIllIlllll) {
            return String.valueOf(new StringBuilder().append("^").append(lllllllllllllIIIIIlllIlIllIlllll));
        }
        
        static WorldPos.Coordinate deserializeCoordinate(final String lllllllllllllIIIIIlllIlIlllIlIII, final String lllllllllllllIIIIIlllIlIlllIIlll) {
            final int lllllllllllllIIIIIlllIlIlllIIlII = Integer.parseInt(lllllllllllllIIIIIlllIlIlllIIlll);
            if (lllllllllllllIIIIIlllIlIlllIlIII.equals("")) {
                return WorldPos.Coordinate.absolute(lllllllllllllIIIIIlllIlIlllIIlII);
            }
            if (lllllllllllllIIIIIlllIlIlllIlIII.equals("~")) {
                return WorldPos.Coordinate.relative(lllllllllllllIIIIIlllIlIlllIIlII);
            }
            throw new AssertionError();
        }
        
        static {
            LOCAL_SYMBOL = "^";
            RELATIVE_SYMBOL = "~";
            ABSOLUTE_SYMBOL = "";
            LOCAL_PATTERN = Pattern.compile("^\\^(\\d+(\\.\\d+)?) \\^(\\d+(\\.\\d+)?) \\^(\\d+(\\.\\d+)?)$");
            WORLD_PATTERN = Pattern.compile("^(~?)(\\d+) (~?)(\\d+) (~?)(\\d+)$");
        }
        
        private Tokens() {
        }
    }
    
    static final class LocalPosImpl implements LocalPos
    {
        private final /* synthetic */ double up;
        private final /* synthetic */ double forwards;
        private final /* synthetic */ double left;
        
        @Override
        public double forwards() {
            return this.forwards;
        }
        
        @Override
        public double left() {
            return this.left;
        }
        
        @Override
        public boolean equals(@Nullable final Object lllllllllllllIllIlllIIlllllIIllI) {
            if (this == lllllllllllllIllIlllIIlllllIIllI) {
                return true;
            }
            if (!(lllllllllllllIllIlllIIlllllIIllI instanceof LocalPos)) {
                return false;
            }
            final LocalPos lllllllllllllIllIlllIIlllllIIIll = (LocalPos)lllllllllllllIllIlllIIlllllIIllI;
            return ShadyPines.equals(lllllllllllllIllIlllIIlllllIIIll.left(), this.left()) && ShadyPines.equals(lllllllllllllIllIlllIIlllllIIIll.up(), this.up()) && ShadyPines.equals(lllllllllllllIllIlllIIlllllIIIll.forwards(), this.forwards());
        }
        
        LocalPosImpl(final double lllllllllllllIllIlllIlIIIIIIIIII, final double lllllllllllllIllIlllIIlllllllllI, final double lllllllllllllIllIlllIIllllllllll) {
            this.left = lllllllllllllIllIlllIlIIIIIIIIII;
            this.up = lllllllllllllIllIlllIIlllllllllI;
            this.forwards = lllllllllllllIllIlllIIllllllllll;
        }
        
        @Override
        public double up() {
            return this.up;
        }
        
        @NotNull
        @Override
        public Stream<? extends ExaminableProperty> examinableProperties() {
            return Stream.of((ExaminableProperty[])new ExaminableProperty[] { ExaminableProperty.of("left", this.left), ExaminableProperty.of("up", this.up), ExaminableProperty.of("forwards", this.forwards) });
        }
        
        @NotNull
        @Override
        public String asString() {
            return String.valueOf(new StringBuilder().append(Tokens.serializeLocal(this.left)).append(' ').append(Tokens.serializeLocal(this.up)).append(' ').append(Tokens.serializeLocal(this.forwards)));
        }
        
        @Override
        public int hashCode() {
            int lllllllllllllIllIlllIIllllIlllII = Double.hashCode(this.left);
            lllllllllllllIllIlllIIllllIlllII = 31 * lllllllllllllIllIlllIIllllIlllII + Double.hashCode(this.up);
            lllllllllllllIllIlllIIllllIlllII = 31 * lllllllllllllIllIlllIIllllIlllII + Double.hashCode(this.forwards);
            return lllllllllllllIllIlllIIllllIlllII;
        }
        
        @Override
        public String toString() {
            return String.format("^%f ^%f ^%f", this.left, this.up, this.forwards);
        }
    }
    
    static final class BuilderImpl extends NBTComponentImpl.BuilderImpl<BlockNBTComponent, BlockNBTComponent.Builder> implements BlockNBTComponent.Builder
    {
        @Nullable
        private /* synthetic */ Pos pos;
        
        BuilderImpl(@NotNull final BlockNBTComponent llllllllllllllIIllIllIIlIllIlllI) {
            super(llllllllllllllIIllIllIIlIllIlllI);
            this.pos = llllllllllllllIIllIllIIlIllIlllI.pos();
        }
        
        BuilderImpl() {
        }
        
        @Override
        public BlockNBTComponent.Builder pos(@NotNull final Pos llllllllllllllIIllIllIIlIllIIlll) {
            this.pos = llllllllllllllIIllIllIIlIllIIlll;
            return this;
        }
        
        @NotNull
        @Override
        public BlockNBTComponent build() {
            if (this.nbtPath == null) {
                throw new IllegalStateException("nbt path must be set");
            }
            if (this.pos == null) {
                throw new IllegalStateException("pos must be set");
            }
            return new BlockNBTComponentImpl(this.children, this.buildStyle(), this.nbtPath, this.interpret, this.separator, this.pos);
        }
    }
}
