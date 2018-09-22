package netty;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TcpServerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		EventLoopGroup group = new NioEventLoopGroup();

		try{
		    ServerBootstrap serverBootstrap = new ServerBootstrap();
		    serverBootstrap.group(group);
		    serverBootstrap.channel(NioServerSocketChannel.class);
		    serverBootstrap.localAddress(new InetSocketAddress("localhost", 9999));

		    serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
		        protected void initChannel(SocketChannel socketChannel) throws Exception {
		            socketChannel.pipeline().addLast(new HelloServerHandler());
		        }
		    });
		    ChannelFuture channelFuture = serverBootstrap.bind().sync();
		    channelFuture.channel().closeFuture().sync();
		} catch(Exception e){
		    e.printStackTrace();
		} finally {
		    try {
				group.shutdownGracefully().sync();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
