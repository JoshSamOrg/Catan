package com.catan;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

public class Network {
   private static int port = 42511; //pick from ports 42511-42999, all should be open
   private static String serverName;
   private static String ipAddress;
   private static HashMap<String, String> map = new HashMap<String, String>();
   
   public Network(){
	   try{
	   ipAddress = InetAddress.getLocalHost().getHostAddress(); 
   }
	   catch(UnknownHostException e){
		   System.out.println("Unknown Host");
	   }
	   map.put(serverName, ipAddress);
   }
   
   public static void register(EndPoint ep){
	   Kryo kryo = ep.getKryo();
	   kryo.register(Request.class);
	   kryo.register(Response.class);
   }
   
   //private ip address of this computer
   public static String getIPAddress(){
	   return ipAddress;
   }
   
   public static String getServerName(){
	   return serverName;
   }
   
   public static void setServerName(String s){
	   serverName = s;
   }
   
   public static int getPort(){
	   return port;
   }
   
   public static void setPort(int s){
	   port = s;
   }
   
   public static HashMap<String, String> getMap(){
	   return map;
   }
   
   public static class Request{
	   public String request;
   }
   
   public static class Response{
	   public String response;
   }
}
