package com.jay.netty.firstHead.keepalive;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author jay
 * @date 2019/8/5 22:43
 * netty对webSocket的支持
 */
public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //webSocket是基于http的，需要http的
        pipeline.addLast(new HttpServerCodec());
        //块状写的处理器
        pipeline.addLast(new ChunkedWriteHandler());
        //聚合
        pipeline.addLast(new HttpObjectAggregator(8192));
        //webSocket的处理
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        //自定义处理器
        pipeline.addLast(new WebSocketChannelHandler());
    }
}
