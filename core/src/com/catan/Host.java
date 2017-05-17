package com.catan;

import java.io.IOException;

import com.catan.Network.Request;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

//class that handles the server side of the kryonet framework
public class Host {
   
   public static void startServer(){
	   Server server = new Server();
	   server.start(); //starts the server
	   try{
	   server.bind(Network.getPort()); //binds the server to the specified port
	   System.out.println(Network.getPort());
	   }
	   catch(IOException e){
		   server.close();
		   Network.setPort(Network.getPort()+1); //Sets the Network port
		   startServer();
	   }
	   Network.register(server); //registers the server
	   server.addListener(new Listener(){
		   //called when the server receives an incoming message
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
