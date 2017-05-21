package com.catan;

import java.io.IOException;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.catan.Network.Request;
import com.catan.Network.Response;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

//class that handles the server side of the kryonet framework
public class Host {
   private static Server server;
	//starts the server
   public static void startServer(){
	   server = new Server();
	   server.start(); //starts the server
	   try{
	   server.bind(Network.getPort()); //binds the server to the specified port
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
				   processRequest(r.request);
			   }
		}
	   });
   }
   
   
   //processes the request sent by a client
   public static void processRequest(HashMap<String, String> map){
	   final String key = (String) map.keySet().toArray()[0];
	   final String value = map.get(key);
	   final String color = findAtlas(key);
	   //tricky, but any graphics operations directly involving 
	   //OpenGL (the atlas in this case) need to be executed on the rendering thread
	   //postRunnable passes data from the current thread to the rendering thread
	   Gdx.app.postRunnable(new Runnable(){
		   public void run(){
	        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(color));
		     Build.build(key, value, atlas);
		   }
	   });
   }
   
   //returns a valid texture atlas internal file, (.txt)
   public static String findAtlas(String name){
		for(int i = 0; i<GamePlayers.getGamePlayers().size(); i++){
			if(GamePlayers.getGamePlayers().get(i).getName().equals(name)){
				switch(GamePlayers.getGamePlayers().get(i).getColor()){
				case "orange": return "Orange.txt";
				case "blue": return "Blue.txt";
				case "red": return "Red.txt";
				case "white": return "White.txt";
				}
			}
		}
		return null;
	}
  
   //returns the server object
   public static Server getServer(){
	   return server;
   }
   
   //sends a message to all the clients
   public static void sendMessage(String message){
	   Response r = new Response();
	   r.response = message;
	   server.sendToAllTCP(r);
   }
}
