package com.foo.test.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
 
@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //将客户端传入的消息转换为Netty的ByteBuf类型
        ByteBuf in = (ByteBuf) msg;
 
        // 在控制台打印传入的消息
        System.out.println(
                "Server received: " + in.toString(CharsetUtil.UTF_8)
        );
        //将接收到的消息写给发送者，而不冲刷出站消息
        ctx.write(in);
    }
 
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // 将未处决消息冲刷到远程节点， 并且关闭该Channel
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);
    }
 
    /**
     * 异常处理
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //打印异常栈跟踪
        cause.printStackTrace();
 
        // 关闭该Channel
        ctx.close();
    }
}
