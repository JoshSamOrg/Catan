package com.catan;

import java.io.IOException;

import com.catan.Network.Request;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

public class Host {
   
   public static void startServer(){
	   Server server = new Server();
	   server.start();
	   try{
	   server.bind(Network.getPort());
	   System.out.println(Network.getPort());
	   }
	   catch(IOException e){
		   server.close();
		   Network.setPort(Network.getPort()+1);
		   startServer();
	   }
	   Network.register(server);
	   server.addListener(new Listener(){
		   public void received (Connection connection, Object object) {
			   if(object instanceof Request){
				   Request r = (Request) object;
				   connection.setName(r.request);
				   System.out.println(r.request);
			   }
		}
	   });
   }
  
}
