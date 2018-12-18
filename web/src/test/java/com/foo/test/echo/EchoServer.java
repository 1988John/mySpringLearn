package com.foo.test.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
 
import java.net.InetSocketAddress;
 
public class EchoServer {
    private final static int port = 8080;
 
    public static void main(String[] args) {
        start();
    }
 
    private static void start() {
        final EchoServerHandler serverHandler = new EchoServerHandler();
        // 创建EventLoopGroup
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        // 创建EventLoopGroup
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup)
                //指定所使用的NIO传输Channel
        .channel(NioServerSocketChannel.class)
                //使用指定的端口设置套接字地址
        .localAddress(new InetSocketAddress(port))
                // 添加一个EchoServerHandler到Channle的ChannelPipeline
        .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                //EchoServerHandler被标注为@shareable,所以我们可以总是使用同样的案例
                socketChannel.pipeline().addLast(serverHandler);
            }
        });
 
        try {
            // 异步地绑定服务器;调用sync方法阻塞等待直到绑定完成
            ChannelFuture f = b.bind().sync();
            // 获取Channel的CloseFuture，并且阻塞当前线程直到它完成
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 优雅的关闭EventLoopGroup，释放所有的资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
