package com.viaversion.viaversion.handlers;

import io.netty.util.*;
import java.net.*;
import io.netty.util.concurrent.*;
import io.netty.buffer.*;
import io.netty.channel.*;

public class ChannelHandlerContextWrapper implements ChannelHandlerContext
{
    private final /* synthetic */ ViaCodecHandler handler;
    private final /* synthetic */ ChannelHandlerContext base;
    
    public ChannelFuture newFailedFuture(final Throwable lllllllllllllIIIIIlIIlIIlIllIllI) {
        return this.base.newFailedFuture(lllllllllllllIIIIIlIIlIIlIllIllI);
    }
    
    public ChannelFuture writeAndFlush(final Object lllllllllllllIIIIIlIIlIIllIIllII) {
        final ChannelFuture lllllllllllllIIIIIlIIlIIllIIlllI = this.write(lllllllllllllIIIIIlIIlIIllIIllII);
        this.flush();
        return lllllllllllllIIIIIlIIlIIllIIlllI;
    }
    
    public <T> Attribute<T> attr(final AttributeKey<T> lllllllllllllIIIIIlIIlIIlIlIllIl) {
        return (Attribute<T>)this.base.attr((AttributeKey)lllllllllllllIIIIIlIIlIIlIlIllIl);
    }
    
    public ChannelHandlerContext flush() {
        this.base.flush();
        return (ChannelHandlerContext)this;
    }
    
    public ChannelFuture write(final Object lllllllllllllIIIIIlIIlIIllllIIll, final ChannelPromise lllllllllllllIIIIIlIIlIIllllIIlI) {
        if (lllllllllllllIIIIIlIIlIIllllIIll instanceof ByteBuf && this.transform((ByteBuf)lllllllllllllIIIIIlIIlIIllllIIll)) {
            return this.base.newFailedFuture(new Throwable());
        }
        return this.base.write(lllllllllllllIIIIIlIIlIIllllIIll, lllllllllllllIIIIIlIIlIIllllIIlI);
    }
    
    public ChannelFuture connect(final SocketAddress lllllllllllllIIIIIlIIlIlIlIIIlIl) {
        return this.base.connect(lllllllllllllIIIIIlIIlIlIlIIIlIl);
    }
    
    public ChannelFuture disconnect(final ChannelPromise lllllllllllllIIIIIlIIlIlIIIIllll) {
        return this.base.disconnect(lllllllllllllIIIIIlIIlIlIIIIllll);
    }
    
    public ChannelFuture close() {
        return this.base.close();
    }
    
    public ChannelFuture connect(final SocketAddress lllllllllllllIIIIIlIIlIlIIlllllI, final SocketAddress lllllllllllllIIIIIlIIlIlIIlllIlI) {
        return this.base.connect(lllllllllllllIIIIIlIIlIlIIlllllI, lllllllllllllIIIIIlIIlIlIIlllIlI);
    }
    
    public ChannelFuture disconnect() {
        return this.base.disconnect();
    }
    
    public ChannelFuture writeAndFlush(final Object lllllllllllllIIIIIlIIlIIllIllIlI, final ChannelPromise lllllllllllllIIIIIlIIlIIllIlIlIl) {
        final ChannelFuture lllllllllllllIIIIIlIIlIIllIllIII = this.write(lllllllllllllIIIIIlIIlIIllIllIlI, lllllllllllllIIIIIlIIlIIllIlIlIl);
        this.flush();
        return lllllllllllllIIIIIlIIlIIllIllIII;
    }
    
    public boolean isRemoved() {
        return this.base.isRemoved();
    }
    
    public ChannelPipeline pipeline() {
        return this.base.pipeline();
    }
    
    public ChannelHandlerContext fireChannelUnregistered() {
        this.base.fireChannelUnregistered();
        return (ChannelHandlerContext)this;
    }
    
    public ChannelFuture deregister(final ChannelPromise lllllllllllllIIIIIlIIlIlIIIIIIIl) {
        return this.base.deregister(lllllllllllllIIIIIlIIlIlIIIIIIIl);
    }
    
    public ChannelPromise voidPromise() {
        return this.base.voidPromise();
    }
    
    public ChannelHandler handler() {
        return this.base.handler();
    }
    
    public ChannelFuture connect(final SocketAddress lllllllllllllIIIIIlIIlIlIIlIIIII, final ChannelPromise lllllllllllllIIIIIlIIlIlIIlIIIlI) {
        return this.base.connect(lllllllllllllIIIIIlIIlIlIIlIIIII, lllllllllllllIIIIIlIIlIlIIlIIIlI);
    }
    
    public EventExecutor executor() {
        return this.base.executor();
    }
    
    public ChannelFuture connect(final SocketAddress lllllllllllllIIIIIlIIlIlIIIllIIl, final SocketAddress lllllllllllllIIIIIlIIlIlIIIllIII, final ChannelPromise lllllllllllllIIIIIlIIlIlIIIlIlll) {
        return this.base.connect(lllllllllllllIIIIIlIIlIlIIIllIIl, lllllllllllllIIIIIlIIlIlIIIllIII, lllllllllllllIIIIIlIIlIlIIIlIlll);
    }
    
    public ChannelFuture bind(final SocketAddress lllllllllllllIIIIIlIIlIlIlIIlIIl) {
        return this.base.bind(lllllllllllllIIIIIlIIlIlIlIIlIIl);
    }
    
    public ChannelHandlerContext fireChannelInactive() {
        this.base.fireChannelInactive();
        return (ChannelHandlerContext)this;
    }
    
    public ChannelFuture close(final ChannelPromise lllllllllllllIIIIIlIIlIlIIIIlIIl) {
        return this.base.close(lllllllllllllIIIIIlIIlIlIIIIlIIl);
    }
    
    public Channel channel() {
        return this.base.channel();
    }
    
    public boolean transform(final ByteBuf lllllllllllllIIIIIlIIlIIlllIIlll) {
        try {
            this.handler.transform(lllllllllllllIIIIIlIIlIIlllIIlll);
            return false;
        }
        catch (Exception lllllllllllllIIIIIlIIlIIlllIlIIl) {
            try {
                this.handler.exceptionCaught(this.base, lllllllllllllIIIIIlIIlIIlllIlIIl);
            }
            catch (Exception lllllllllllllIIIIIlIIlIIlllIlIlI) {
                this.base.fireExceptionCaught((Throwable)lllllllllllllIIIIIlIIlIIlllIlIlI);
            }
            return true;
        }
    }
    
    public ChannelHandlerContext fireChannelRead(final Object lllllllllllllIIIIIlIIlIlIlIlIlll) {
        this.base.fireChannelRead(lllllllllllllIIIIIlIIlIlIlIlIlll);
        return (ChannelHandlerContext)this;
    }
    
    public ChannelHandlerContext fireChannelActive() {
        this.base.fireChannelActive();
        return (ChannelHandlerContext)this;
    }
    
    public ChannelPromise newPromise() {
        return this.base.newPromise();
    }
    
    public ChannelHandlerContext fireChannelWritabilityChanged() {
        this.base.fireChannelWritabilityChanged();
        return (ChannelHandlerContext)this;
    }
    
    public ChannelFuture newSucceededFuture() {
        return this.base.newSucceededFuture();
    }
    
    public ChannelFuture bind(final SocketAddress lllllllllllllIIIIIlIIlIlIIlIlIIl, final ChannelPromise lllllllllllllIIIIIlIIlIlIIlIlIII) {
        return this.base.bind(lllllllllllllIIIIIlIIlIlIIlIlIIl, lllllllllllllIIIIIlIIlIlIIlIlIII);
    }
    
    public ChannelHandlerContext fireExceptionCaught(final Throwable lllllllllllllIIIIIlIIlIlIllIIIIl) {
        this.base.fireExceptionCaught(lllllllllllllIIIIIlIIlIlIllIIIIl);
        return (ChannelHandlerContext)this;
    }
    
    public String name() {
        return this.base.name();
    }
    
    public ByteBufAllocator alloc() {
        return this.base.alloc();
    }
    
    public ChannelHandlerContext fireUserEventTriggered(final Object lllllllllllllIIIIIlIIlIlIlIllIll) {
        this.base.fireUserEventTriggered(lllllllllllllIIIIIlIIlIlIlIllIll);
        return (ChannelHandlerContext)this;
    }
    
    public ChannelHandlerContext read() {
        this.base.read();
        return (ChannelHandlerContext)this;
    }
    
    public ChannelFuture deregister() {
        return this.base.deregister();
    }
    
    public ChannelHandlerContext fireChannelReadComplete() {
        this.base.fireChannelReadComplete();
        return (ChannelHandlerContext)this;
    }
    
    public ChannelFuture write(final Object lllllllllllllIIIIIlIIlIIlllllIII) {
        if (lllllllllllllIIIIIlIIlIIlllllIII instanceof ByteBuf && this.transform((ByteBuf)lllllllllllllIIIIIlIIlIIlllllIII)) {
            return this.base.newFailedFuture(new Throwable());
        }
        return this.base.write(lllllllllllllIIIIIlIIlIIlllllIII);
    }
    
    public ChannelHandlerContext fireChannelRegistered() {
        this.base.fireChannelRegistered();
        return (ChannelHandlerContext)this;
    }
    
    public ChannelProgressivePromise newProgressivePromise() {
        return this.base.newProgressivePromise();
    }
    
    public ChannelHandlerContextWrapper(final ChannelHandlerContext lllllllllllllIIIIIlIIlIllIIIIIll, final ViaCodecHandler lllllllllllllIIIIIlIIlIllIIIIlIl) {
        this.base = lllllllllllllIIIIIlIIlIllIIIIIll;
        this.handler = lllllllllllllIIIIIlIIlIllIIIIlIl;
    }
}
