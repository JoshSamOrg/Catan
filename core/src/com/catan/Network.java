package com.catan;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

//class that holds all network information
public class Network {
   private static int port = 42511; //pick from ports 42511-42999, all should be open
   private static String serverName;
   private static String ipAddress;
   private static HashMap<String, String> map = new HashMap<String, String>();
   
   
   //sets the ipAddress, and fills the map with the serverName and ipAddress
   public Network(){
	   try{
	   ipAddress = InetAddress.getLocalHost().getHostAddress(); 
   }
	   catch(UnknownHostException e){
		   System.out.println("Unknown Host");
	   }
	   map.put(serverName, ipAddress);
   }
   
   //method that registers the two classes Request and Response
   public static void register(EndPoint ep){
	   Kryo kryo = ep.getKryo();
	   kryo.register(Request.class);
	   kryo.register(Response.class);
	   kryo.register(HashMap.class);
   }
   
   //private ip address of this computer
   public static String getIPAddress(){
	   return ipAddress;
   }
   
   //returns the serverName 
   public static String getServerName(){
	   return serverName;
   }
   
   //sets the server name
   public static void setServerName(String s){
	   serverName = s;
   }
   
   //returns the port number
   public static int getPort(){
	   return port;
   }
   
   //sets the port number
   public static void setPort(int s){
	   port = s;
   }
   
   //returns the map, which stores the serverName and the ipAddress
   public static HashMap<String, String> getMap(){
	   return map;
   }
   
   //static inner class
   public static class Request{
	   public HashMap<String, String> request;
   }
   
   //static inner class
   public static class Response{
	   public String response;
   }
}
