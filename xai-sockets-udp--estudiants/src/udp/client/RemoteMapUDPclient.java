/*

* Copyright (c) Joan-Manuel Marques 2013. All rights reserved.
* DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
*
* This file is part of the practical assignment of Distributed Systems course.
*
* This code is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This code is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this code.  If not, see <http://www.gnu.org/licenses/>.
*/

package udp.client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.uoc.dpcs.lsim.logger.LoggerManager.Level;
import lsim.library.api.LSimLogger;


/**
 * @author Joan-Manuel Marques
 *
 */

public class RemoteMapUDPclient {

	public RemoteMapUDPclient() {
	}
	
	public Map<String, String> getMap (List<Key> keys) {
		try {
			Map<String, String> map = new HashMap<String, String>();
			int i = 1;
			for (Key key : keys) {
				LSimLogger.log(
						Level.TRACE,
						"["+i+"] Query for key "+key.getKey()+" at "+ key.getServerAddress() +":"+key.getServerPort()
						);

				String value = get(key.getKey(), key.getServerAddress(), key.getServerPort());

				LSimLogger.log(Level.TRACE, "["+i+"] RemoteMap("+key.getKey()+"): "+ value);
				i++;
				map.put(key.getKey(), value);
			}

			return map;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
	private String get(String key, String server_address, int server_port)  {
		try {
			LSimLogger.log(Level.INFO, "inici RemoteMapUDPclient.get ");
			LSimLogger.log(Level.TRACE, "key: " + key);
			LSimLogger.log(Level.TRACE, "server_address: " + server_address);
			LSimLogger.log(Level.TRACE, "server_port: " + server_port);

			String resposta = null;
			
			/* TODO: implementaciÃ³ de la part client UDP / implementaciÃ³n de la parte cliente UDP */
			//Creo canal de entrada
	    	BufferedReader inFromUser = 
	        new BufferedReader(new InputStreamReader(System.in)); 
	      //Creo Socket cliente
	      DatagramSocket clientSocket = new DatagramSocket(); 
	      //Traslada hostname a IP usando DNS

	      InetAddress IPAddress = InetAddress.getByName("localhost"); 
	  
	      byte[] sendData = new byte[1024]; 
	      byte[] receiveData = new byte[1024]; 
	  
	      System.out.println("Envío del key a consultar al servidor.");
	      String sentence = key; 
	      sendData = sentence.getBytes();   
	      //Crea datagrama con datos a enviar, longitud, dir IP y puerto
	      DatagramPacket sendPacket = 
	    	         new DatagramPacket(sendData, sendData.length, IPAddress, server_port); //antes 9876
	      //Envía datagrama al servidor  
	    	      clientSocket.send(sendPacket); 
	      //Lee datagrama desde servidor
	      DatagramPacket receivePacket = 
	    	         new DatagramPacket(receiveData, receiveData.length); 
	    //Lee datagrama desde servidor
	      clientSocket.receive(receivePacket); 
	    	  
	    	      resposta = 
	    	          new String(receivePacket.getData()).trim(); 
	    	  
	    	      
	    	      clientSocket.close(); 
			
			return resposta;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "";
		}
		
	}
}
