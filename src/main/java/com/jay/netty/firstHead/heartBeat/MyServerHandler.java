package com.jay.netty.firstHead.heartBeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author jay
 * @date 2019/8/5 22:02
 * 对空闲时间的处理
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 用户事件触发
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent)evt;

            String eventType = null;

            switch (event.state()){
                case WRITER_IDLE:
                    eventType = "写空闲";
                    break;
                case READER_IDLE:
                    eventType = "读空闲";
                    break;
                case ALL_IDLE:
                    eventType = "读写空闲";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress()+"超时事件"+eventType);
        }
    }
}
