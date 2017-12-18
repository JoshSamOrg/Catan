package com.catan;

import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

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
   private static HashMap<String, Integer> nameToID;
	//starts the server
   public static void startServer(){
	   server = new Server();
	   server.start(); //starts the server
	   nameToID = new HashMap<String, Integer>();
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
				   if(r.request != null){
				      processBuild(r.request);
			      }
				   else if(!r.nameAndID.equals("")){
					  processID(r.nameAndID, connection);
				   }
				   else if(!r.hello.equals("")){
					   processHello(connection);
				   }
			   }
		}
	   });
   }
   
 //send the valid names to all the clients
   public static void processHello(Connection connection) {
	   Response r = new Response();
		if(r.validNames == null){
			System.out.println("Initializing server valid names");
			r.validNames = new HashMap<String, String>();
			outer: for(int i = 0; i<GamePlayers.getGamePlayers().size(); i++){
				String name = GamePlayers.getGamePlayers().get(i).getName();
				Connection[] connections = server.getConnections();
				//Ensures that the current client does not try to take
				//an already taken name (by a different client)
				for(int j = 0; j<connections.length; j++){
				if(connections[j].toString().equals(name)){
					continue outer;
				}
				}
				r.validNames.put(name, name);
			}
		}
		server.sendToTCP(connection.getID(), r);	 
}


public static void processID(String nameAndID, Connection connection) {
	StringTokenizer st = new StringTokenizer(nameAndID);
	String name = "";
	int ID = 0;
	while(st.hasMoreTokens()){
		if(name.equals("")){
			name = st.nextToken();
		}
		else{
			ID = Integer.parseInt(st.nextToken());
		}
	}
	nameToID.put(name, ID);
	
	//update connection name to be used so that you are able to not let clients
	//obtain names that have already been selected (by a different client)
	connection.setName(name);
}

//processes the request sent by a client
   public static void processBuild(HashMap<String, String> map){
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
   
   //sends the current player to all clients
   public static void sendCurrentPlayer(String message){
	   Response r = new Response();
	   r.response = message;
	   server.sendToAllTCP(r);
   }

//sends a hashmap specifying if the user still has pieces of a current type 
public static void sendBuildCount(String currentPlayer) {
	Response r = new Response();
	r.buildCount = new HashMap<String, Boolean>();
	r.buildCount.put("Crew", GamePlayers.getBasedOnName(currentPlayer).hasCrews());
	r.buildCount.put("HarborSettlement", GamePlayers.getBasedOnName(currentPlayer).hasHarborSettlements());
	r.buildCount.put("Road", GamePlayers.getBasedOnName(currentPlayer).hasRoads());
	r.buildCount.put("Settlement", GamePlayers.getBasedOnName(currentPlayer).hasSettlements());
	r.buildCount.put("Settler", GamePlayers.getBasedOnName(currentPlayer).hasSettlers());
	r.buildCount.put("Ship", GamePlayers.getBasedOnName(currentPlayer).hasShips());
	server.sendToTCP(nameToID.get(currentPlayer), r);
}
}
