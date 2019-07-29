package com.jay.netty.firstHead;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

import java.net.ServerSocket;

/**
 * @author jay
 * @date 2019/7/24 0:20
 * 自定义初始化类
 */
public class TestServerinitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("httpServerCode",new HttpServerCodec());
        pipeline.addLast("testHttpServerHandler",new TestHttpServerHandler());
        ServerSocket serverSocket= new ServerSocket();
        serverSocket.accept();
    }
}
