package com.viaversion.viaversion.protocol.packet;

import io.netty.buffer.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.util.*;
import com.google.common.base.*;
import com.viaversion.viaversion.exception.*;
import java.io.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.*;
import io.netty.channel.*;
import java.util.*;

public class PacketWrapperImpl implements PacketWrapper
{
    private /* synthetic */ int id;
    private final /* synthetic */ ByteBuf inputBuffer;
    private /* synthetic */ boolean send;
    private static final /* synthetic */ Protocol[] PROTOCOL_ARRAY;
    private final /* synthetic */ UserConnection userConnection;
    private /* synthetic */ PacketType packetType;
    private final /* synthetic */ List<Pair<Type, Object>> packetValues;
    private final /* synthetic */ Deque<Pair<Type, Object>> readableObjects;
    
    @Override
    public PacketType getPacketType() {
        return this.packetType;
    }
    
    private void sendRaw(final boolean lIlIIlIlIIIIIl) throws Exception {
        if (this.isCancelled()) {
            return;
        }
        final ByteBuf lIlIIlIlIIIIII = (this.inputBuffer == null) ? this.user().getChannel().alloc().buffer() : this.inputBuffer.alloc().buffer();
        try {
            this.writeToBuffer(lIlIIlIlIIIIII);
            if (lIlIIlIlIIIIIl) {
                this.user().sendRawPacket(lIlIIlIlIIIIII.retain());
            }
            else {
                this.user().scheduleSendRawPacket(lIlIIlIlIIIIII.retain());
            }
        }
        finally {
            lIlIIlIlIIIIII.release();
        }
    }
    
    @Override
    public <T> void write(final Type<T> lIlIIlllIIlIIl, final T lIlIIlllIIIlIl) {
        this.packetValues.add(new Pair<Type, Object>(lIlIIlllIIlIIl, this.attemptTransform(lIlIIlllIIlIIl, lIlIIlllIIIlIl)));
    }
    
    @Override
    public void scheduleSend(final Class<? extends Protocol> lIlIIllIIIIlII, final boolean lIlIIllIIIIIll) throws Exception {
        this.send0(lIlIIllIIIIlII, lIlIIllIIIIIll, false);
    }
    
    @Override
    public boolean isCancelled() {
        return !this.send;
    }
    
    private ByteBuf constructPacket(final Class<? extends Protocol> lIlIIlIllIIllI, final boolean lIlIIlIllIIlIl, final Direction lIlIIlIlIlllII) throws Exception {
        final Protocol[] lIlIIlIllIIIll = this.user().getProtocolInfo().getPipeline().pipes().toArray(PacketWrapperImpl.PROTOCOL_ARRAY);
        final boolean lIlIIlIllIIIlI = lIlIIlIlIlllII == Direction.CLIENTBOUND;
        int lIlIIlIllIIIIl = -1;
        for (int lIlIIlIllIlIII = 0; lIlIIlIllIlIII < lIlIIlIllIIIll.length; ++lIlIIlIllIlIII) {
            if (lIlIIlIllIIIll[lIlIIlIllIlIII].getClass() == lIlIIlIllIIllI) {
                lIlIIlIllIIIIl = lIlIIlIllIlIII;
                break;
            }
        }
        if (lIlIIlIllIIIIl == -1) {
            throw new NoSuchElementException(lIlIIlIllIIllI.getCanonicalName());
        }
        if (lIlIIlIllIIlIl) {
            lIlIIlIllIIIIl = (lIlIIlIllIIIlI ? (lIlIIlIllIIIIl - 1) : (lIlIIlIllIIIIl + 1));
        }
        this.resetReader();
        this.apply(lIlIIlIlIlllII, this.user().getProtocolInfo().getState(), lIlIIlIllIIIIl, lIlIIlIllIIIll, lIlIIlIllIIIlI);
        final ByteBuf lIlIIlIllIIIII = (this.inputBuffer == null) ? this.user().getChannel().alloc().buffer() : this.inputBuffer.alloc().buffer();
        try {
            this.writeToBuffer(lIlIIlIllIIIII);
            final short lIlIIlIlIlIlll = (short)lIlIIlIllIIIII.retain();
            return (ByteBuf)lIlIIlIlIlIlll;
        }
        finally {
            lIlIIlIllIIIII.release();
        }
    }
    
    @Override
    public boolean is(final Type lIlIlIIIIIlIII, final int lIlIlIIIIIIlll) {
        int lIlIlIIIIIlIlI = 0;
        for (final Pair<Type, Object> lIlIlIIIIIlllI : this.packetValues) {
            if (lIlIlIIIIIlllI.getKey() != lIlIlIIIIIlIII) {
                continue;
            }
            if (lIlIlIIIIIlIlI == lIlIlIIIIIIlll) {
                return true;
            }
            ++lIlIlIIIIIlIlI;
        }
        return false;
    }
    
    @Override
    public PacketWrapperImpl create(final int lIlIIlIIlllIII) {
        return new PacketWrapperImpl(lIlIIlIIlllIII, null, this.user());
    }
    
    @Override
    public void clearInputBuffer() {
        if (this.inputBuffer != null) {
            this.inputBuffer.clear();
        }
        this.readableObjects.clear();
    }
    
    @Deprecated
    @Override
    public void setId(final int lIlIIIlIIlllII) {
        this.packetType = null;
        this.id = lIlIIIlIIlllII;
    }
    
    private PacketWrapperImpl apply(final Direction lIlIIIllllIlIl, final State lIlIIIllllIlII, final int lIlIIIlllllIIl, final Protocol[] lIlIIIllllIIlI, final boolean lIlIIIllllIlll) throws Exception {
        if (lIlIIIllllIlll) {
            for (int lIlIIIlllllllI = lIlIIIlllllIIl; lIlIIIlllllllI >= 0; --lIlIIIlllllllI) {
                lIlIIIllllIIlI[lIlIIIlllllllI].transform(lIlIIIllllIlIl, lIlIIIllllIlII, this);
                this.resetReader();
            }
        }
        else {
            for (int lIlIIIllllllIl = lIlIIIlllllIIl; lIlIIIllllllIl < lIlIIIllllIIlI.length; ++lIlIIIllllllIl) {
                lIlIIIllllIIlI[lIlIIIllllllIl].transform(lIlIIIllllIlIl, lIlIIIllllIlII, this);
                this.resetReader();
            }
        }
        return this;
    }
    
    private void sendToServer0(final Class<? extends Protocol> lIlIIIlIllIlIl, final boolean lIlIIIlIllIIII, final boolean lIlIIIlIllIIll) throws Exception {
        if (this.isCancelled()) {
            return;
        }
        try {
            final ByteBuf lIlIIIlIlllIII = this.constructPacket(lIlIIIlIllIlIl, lIlIIIlIllIIII, Direction.SERVERBOUND);
            if (lIlIIIlIllIIll) {
                this.user().sendRawPacketToServer(lIlIIIlIlllIII);
            }
            else {
                this.user().scheduleSendRawPacketToServer(lIlIIIlIlllIII);
            }
        }
        catch (Exception lIlIIIlIllIlll) {
            if (!PipelineUtil.containsCause(lIlIIIlIllIlll, CancelException.class)) {
                throw lIlIIIlIllIlll;
            }
        }
    }
    
    @Override
    public void scheduleSendToServer(final Class<? extends Protocol> lIlIIIllIIIIlI, final boolean lIlIIIllIIIIIl) throws Exception {
        this.sendToServer0(lIlIIIllIIIIlI, lIlIIIllIIIIIl, false);
    }
    
    @Override
    public <T> T read(final Type<T> lIlIIlllIlIIIl) throws Exception {
        if (lIlIIlllIlIIIl == Type.NOTHING) {
            return null;
        }
        if (this.readableObjects.isEmpty()) {
            Preconditions.checkNotNull((Object)this.inputBuffer, (Object)"This packet does not have an input buffer.");
            try {
                return lIlIIlllIlIIIl.read(this.inputBuffer);
            }
            catch (Exception lIlIIlllIllIII) {
                throw new InformativeException(lIlIIlllIllIII).set("Type", lIlIIlllIlIIIl.getTypeName()).set("Packet ID", this.getId()).set("Packet Type", this.packetType).set("Data", this.packetValues);
            }
        }
        final Pair<Type, Object> lIlIIlllIlIlII = this.readableObjects.poll();
        final Type lIlIIlllIlIIll = lIlIIlllIlIlII.getKey();
        if (lIlIIlllIlIIll == lIlIIlllIlIIIl || (lIlIIlllIlIIIl.getBaseClass() == lIlIIlllIlIIll.getBaseClass() && lIlIIlllIlIIIl.getOutputClass() == lIlIIlllIlIIll.getOutputClass())) {
            return (T)lIlIIlllIlIlII.getValue();
        }
        if (lIlIIlllIlIIll == Type.NOTHING) {
            return (T)this.read((Type<Object>)lIlIIlllIlIIIl);
        }
        final Exception lIlIIlllIlIlll = new IOException(String.valueOf(new StringBuilder().append("Unable to read type ").append(lIlIIlllIlIIIl.getTypeName()).append(", found ").append(lIlIIlllIlIlII.getKey().getTypeName())));
        throw new InformativeException(lIlIIlllIlIlll).set("Type", lIlIIlllIlIIIl.getTypeName()).set("Packet ID", this.getId()).set("Packet Type", this.packetType).set("Data", this.packetValues);
    }
    
    @Override
    public void setPacketType(final PacketType lIlIIIlIlIIlll) {
        this.packetType = lIlIIIlIlIIlll;
        this.id = ((lIlIIIlIlIIlll != null) ? lIlIIIlIlIIlll.getId() : -1);
    }
    
    @Override
    public void sendRaw() throws Exception {
        this.sendRaw(true);
    }
    
    private Object attemptTransform(final Type<?> lIlIIllIllllll, final Object lIlIIlllIIIIII) {
        if (lIlIIlllIIIIII != null && !lIlIIllIllllll.getOutputClass().isAssignableFrom(lIlIIlllIIIIII.getClass())) {
            if (lIlIIllIllllll instanceof TypeConverter) {
                return ((TypeConverter)lIlIIllIllllll).from(lIlIIlllIIIIII);
            }
            Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Possible type mismatch: ").append(lIlIIlllIIIIII.getClass().getName()).append(" -> ").append(lIlIIllIllllll.getOutputClass())));
        }
        return lIlIIlllIIIIII;
    }
    
    @Override
    public void scheduleSendRaw() throws Exception {
        this.sendRaw(false);
    }
    
    private void writeRemaining(final ByteBuf lIlIIllIIlIlll) {
        if (this.inputBuffer != null) {
            lIlIIllIIlIlll.writeBytes(this.inputBuffer);
        }
    }
    
    private void sendToServerRaw(final boolean lIlIIIllIlIlIl) throws Exception {
        if (this.isCancelled()) {
            return;
        }
        final ByteBuf lIlIIIllIlIlII = (this.inputBuffer == null) ? this.user().getChannel().alloc().buffer() : this.inputBuffer.alloc().buffer();
        try {
            this.writeToBuffer(lIlIIIllIlIlII);
            if (lIlIIIllIlIlIl) {
                this.user().sendRawPacketToServer(lIlIIIllIlIlII.retain());
            }
            else {
                this.user().scheduleSendRawPacketToServer(lIlIIIllIlIlII.retain());
            }
        }
        finally {
            lIlIIIllIlIlII.release();
        }
    }
    
    @Override
    public int getId() {
        return this.id;
    }
    
    @Override
    public void passthroughAll() throws Exception {
        this.packetValues.addAll(this.readableObjects);
        this.readableObjects.clear();
        if (this.inputBuffer.isReadable()) {
            this.passthrough(Type.REMAINING_BYTES);
        }
    }
    
    @Override
    public void sendToServerRaw() throws Exception {
        this.sendToServerRaw(true);
    }
    
    @Override
    public ChannelFuture sendFuture(final Class<? extends Protocol> lIlIIlIlIIlllI) throws Exception {
        if (!this.isCancelled()) {
            final ByteBuf lIlIIlIlIlIIlI = this.constructPacket(lIlIIlIlIIlllI, true, Direction.CLIENTBOUND);
            return this.user().sendRawPacketFuture(lIlIIlIlIlIIlI);
        }
        return this.user().getChannel().newFailedFuture((Throwable)new Exception("Cancelled packet"));
    }
    
    @Override
    public void send(final Class<? extends Protocol> lIlIIllIIIllIl, final boolean lIlIIllIIIllII) throws Exception {
        this.send0(lIlIIllIIIllIl, lIlIIllIIIllII, true);
    }
    
    @Override
    public <T> T passthrough(final Type<T> lIlIIllIllIllI) throws Exception {
        final T lIlIIllIlllIII = (T)this.read((Type<Object>)lIlIIllIllIllI);
        this.write(lIlIIllIllIllI, lIlIIllIlllIII);
        return lIlIIllIlllIII;
    }
    
    public ByteBuf getInputBuffer() {
        return this.inputBuffer;
    }
    
    @Override
    public void writeToBuffer(final ByteBuf lIlIIllIlIlIII) throws Exception {
        if (this.id != -1) {
            Type.VAR_INT.writePrimitive(lIlIIllIlIlIII, this.id);
        }
        if (!this.readableObjects.isEmpty()) {
            this.packetValues.addAll(this.readableObjects);
            this.readableObjects.clear();
        }
        int lIlIIllIlIIlll = 0;
        for (final Pair<Type, Object> lIlIIllIlIlIlI : this.packetValues) {
            try {
                lIlIIllIlIlIlI.getKey().write(lIlIIllIlIlIII, lIlIIllIlIlIlI.getValue());
            }
            catch (Exception lIlIIllIlIlIll) {
                throw new InformativeException(lIlIIllIlIlIll).set("Index", lIlIIllIlIIlll).set("Type", lIlIIllIlIlIlI.getKey().getTypeName()).set("Packet ID", this.getId()).set("Packet Type", this.packetType).set("Data", this.packetValues);
            }
            ++lIlIIllIlIIlll;
        }
        this.writeRemaining(lIlIIllIlIlIII);
    }
    
    @Override
    public PacketWrapperImpl create(final int lIlIIlIIlIllII, final PacketHandler lIlIIlIIlIllll) throws Exception {
        final PacketWrapperImpl lIlIIlIIlIlllI = this.create(lIlIIlIIlIllII);
        lIlIIlIIlIllll.handle(lIlIIlIIlIlllI);
        return lIlIIlIIlIlllI;
    }
    
    @Override
    public void resetReader() {
        for (int lIlIIIlllIIlII = this.packetValues.size() - 1; lIlIIIlllIIlII >= 0; --lIlIIIlllIIlII) {
            this.readableObjects.addFirst(this.packetValues.get(lIlIIIlllIIlII));
        }
        this.packetValues.clear();
    }
    
    public PacketWrapperImpl(final PacketType lIlIlIIIlIlIIl, final ByteBuf lIlIlIIIlIllII, final UserConnection lIlIlIIIlIlIll) {
        this.send = true;
        this.readableObjects = new ArrayDeque<Pair<Type, Object>>();
        this.packetValues = new ArrayList<Pair<Type, Object>>();
        this.packetType = lIlIlIIIlIlIIl;
        this.id = ((lIlIlIIIlIlIIl != null) ? lIlIlIIIlIlIIl.getId() : -1);
        this.inputBuffer = lIlIlIIIlIllII;
        this.userConnection = lIlIlIIIlIlIll;
    }
    
    private void send0(final Class<? extends Protocol> lIlIIlIllllIlI, final boolean lIlIIlIllllIIl, final boolean lIlIIlIllllIII) throws Exception {
        if (this.isCancelled()) {
            return;
        }
        try {
            final ByteBuf lIlIIlIlllllIl = this.constructPacket(lIlIIlIllllIlI, lIlIIlIllllIIl, Direction.CLIENTBOUND);
            if (lIlIIlIllllIII) {
                this.user().sendRawPacket(lIlIIlIlllllIl);
            }
            else {
                this.user().scheduleSendRawPacket(lIlIIlIlllllIl);
            }
        }
        catch (Exception lIlIIlIlllllII) {
            if (!PipelineUtil.containsCause(lIlIIlIlllllII, CancelException.class)) {
                throw lIlIIlIlllllII;
            }
        }
    }
    
    static {
        PROTOCOL_ARRAY = new Protocol[0];
    }
    
    @Override
    public void clearPacket() {
        this.clearInputBuffer();
        this.packetValues.clear();
    }
    
    @Override
    public void sendToServer(final Class<? extends Protocol> lIlIIIllIIlIll, final boolean lIlIIIllIIlIlI) throws Exception {
        this.sendToServer0(lIlIIIllIIlIll, lIlIIIllIIlIlI, true);
    }
    
    @Override
    public boolean isReadable(final Type lIlIIllllllIll, final int lIlIIllllllIlI) {
        int lIlIIllllllIIl = 0;
        for (final Pair<Type, Object> lIlIIlllllllIl : this.readableObjects) {
            if (lIlIIlllllllIl.getKey().getBaseClass() != lIlIIllllllIll.getBaseClass()) {
                continue;
            }
            if (lIlIIllllllIIl == lIlIIllllllIlI) {
                return true;
            }
            ++lIlIIllllllIIl;
        }
        return false;
    }
    
    @Override
    public UserConnection user() {
        return this.userConnection;
    }
    
    @Override
    public void cancel() {
        this.send = false;
    }
    
    @Override
    public <T> T get(final Type<T> lIlIlIIIIllllI, final int lIlIlIIIIllIII) throws Exception {
        int lIlIlIIIIlllII = 0;
        for (final Pair<Type, Object> lIlIlIIIlIIIII : this.packetValues) {
            if (lIlIlIIIlIIIII.getKey() != lIlIlIIIIllllI) {
                continue;
            }
            if (lIlIlIIIIlllII == lIlIlIIIIllIII) {
                return (T)lIlIlIIIlIIIII.getValue();
            }
            ++lIlIlIIIIlllII;
        }
        final Exception lIlIlIIIIllIll = new ArrayIndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Could not find type ").append(lIlIlIIIIllllI.getTypeName()).append(" at ").append(lIlIlIIIIllIII)));
        throw new InformativeException(lIlIlIIIIllIll).set("Type", lIlIlIIIIllllI.getTypeName()).set("Index", lIlIlIIIIllIII).set("Packet ID", this.getId()).set("Packet Type", this.packetType).set("Data", this.packetValues);
    }
    
    @Override
    public <T> void set(final Type<T> lIlIIllllIIIll, final int lIlIIllllIlIII, final T lIlIIllllIIIIl) throws Exception {
        int lIlIIllllIIllI = 0;
        for (final Pair<Type, Object> lIlIIllllIlIll : this.packetValues) {
            if (lIlIIllllIlIll.getKey() != lIlIIllllIIIll) {
                continue;
            }
            if (lIlIIllllIIllI == lIlIIllllIlIII) {
                lIlIIllllIlIll.setValue(this.attemptTransform(lIlIIllllIIIll, lIlIIllllIIIIl));
                return;
            }
            ++lIlIIllllIIllI;
        }
        final Exception lIlIIllllIIlIl = new ArrayIndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Could not find type ").append(lIlIIllllIIIll.getTypeName()).append(" at ").append(lIlIIllllIlIII)));
        throw new InformativeException(lIlIIllllIIlIl).set("Type", lIlIIllllIIIll.getTypeName()).set("Index", lIlIIllllIlIII).set("Packet ID", this.getId()).set("Packet Type", this.packetType);
    }
    
    public PacketWrapperImpl(final int lIlIlIIIlllIIl, final ByteBuf lIlIlIIIllIlII, final UserConnection lIlIlIIIllIIll) {
        this.send = true;
        this.readableObjects = new ArrayDeque<Pair<Type, Object>>();
        this.packetValues = new ArrayList<Pair<Type, Object>>();
        this.id = lIlIlIIIlllIIl;
        this.inputBuffer = lIlIlIIIllIlII;
        this.userConnection = lIlIlIIIllIIll;
    }
    
    @Override
    public void scheduleSendToServerRaw() throws Exception {
        this.sendToServerRaw(false);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("PacketWrapper{packetValues=").append(this.packetValues).append(", readableObjects=").append(this.readableObjects).append(", id=").append(this.id).append(", packetType").append(this.packetType).append('}'));
    }
    
    @Override
    public PacketWrapperImpl apply(final Direction lIlIIlIIlIIIIl, final State lIlIIlIIlIIIII, final int lIlIIlIIIlllll, final List<Protocol> lIlIIlIIIllllI, final boolean lIlIIlIIIlllIl) throws Exception {
        final Protocol[] lIlIIlIIIlllII = lIlIIlIIIllllI.toArray(PacketWrapperImpl.PROTOCOL_ARRAY);
        return this.apply(lIlIIlIIlIIIIl, lIlIIlIIlIIIII, lIlIIlIIIlllIl ? (lIlIIlIIIlllII.length - 1) : lIlIIlIIIlllll, lIlIIlIIIlllII, lIlIIlIIIlllIl);
    }
    
    @Override
    public PacketWrapperImpl apply(final Direction lIlIIlIIIIlIIl, final State lIlIIlIIIIllIl, final int lIlIIlIIIIllII, final List<Protocol> lIlIIlIIIIIllI) throws Exception {
        return this.apply(lIlIIlIIIIlIIl, lIlIIlIIIIllIl, lIlIIlIIIIllII, lIlIIlIIIIIllI.toArray(PacketWrapperImpl.PROTOCOL_ARRAY), false);
    }
}
