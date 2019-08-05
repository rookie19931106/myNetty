package com.jay.netty.firstHead.heartBeat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author jay
 * @date 2019/8/5 21:57
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //用于对读写空闲时间的判断
        pipeline.addLast(new IdleStateHandler(5,7,10, TimeUnit.SECONDS));
        //对于空闲检测的处理
        pipeline.addLast(new MyServerHandler());
    }
}
