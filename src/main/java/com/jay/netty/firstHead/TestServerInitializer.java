package com.jay.netty.firstHead;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author jay
 * @date 2019/7/30 21:50
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

    //一个回调方法
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //把处理器都加入到管道中
        pipeline.addLast("httpServerCodec",new HttpServerCodec());
        pipeline.addLast("TestHttpServerHandler",new TestHttpServerHandler());
    }
}
