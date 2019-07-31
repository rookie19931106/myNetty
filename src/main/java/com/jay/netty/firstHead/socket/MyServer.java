package com.jay.netty.firstHead.socket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author jay
 * @date 2019/7/31 22:02
 * netty的服务器端
 */
public class MyServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup wokerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup,wokerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new MyServerInitalizer());
            ChannelFuture future = serverBootstrap.bind(8899).sync();
            future.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            wokerGroup.shutdownGracefully();
        }
    }
}
