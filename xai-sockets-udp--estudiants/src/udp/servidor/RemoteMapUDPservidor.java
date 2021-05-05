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

package udp.servidor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Map;

import edu.uoc.dpcs.lsim.logger.LoggerManager.Level;
import lsim.library.api.LSimLogger;

/**
 * @author Joan-Manuel Marques
 *
 */

public class RemoteMapUDPservidor {
	
	public RemoteMapUDPservidor(int server_port, Map<String, String> map) {
		try {
			LSimLogger.log(Level.INFO, "Inici RemoteMapUDPservidor ");
			LSimLogger.log(Level.INFO, "server_port: " + server_port);
			LSimLogger.log(Level.INFO, "map: " + map);
		
			// Implementation of the server

			/* TODO: implementaci√≥ de la part servidor UDP / implementaci√≥n de la parte servidor UDP */
			
			//Crea Socket de datagrama en puerto 9876

					DatagramSocket serverSocket = new DatagramSocket(server_port);//antes 9876

					byte[] receiveData = new byte[1024];
					byte[] sendData = new byte[1024];

					while (true) {

						//Crea espacio para recibir datagrama
						DatagramPacket receivePacket = new DatagramPacket(receiveData,
								receiveData.length);
						//REcibe datagrama
						serverSocket.receive(receivePacket);
						String sentence = new String(receivePacket.getData()).trim();

						//Obtiene dir IP puerto #, del cliente

						InetAddress IPAddress = receivePacket.getAddress();
						int port = receivePacket.getPort();
						//Crea datagrama a enviar al cliente
						
						/*StringBuffer mensajeDeSalida=new StringBuffer();
						System.out.print("data de entrada:"+sentence+"");
						mensajeDeSalida.append("La respuesta del servidor a la key "+sentence+" es "+map.get(sentence));*/
						
						//System.out.println("data de entrada:"+sentence+"");
						String mensajeDeSalida=map.get(sentence);
						
						//String capitalizedSentence = sentence.toUpperCase();
						String capitalizedSentence = mensajeDeSalida;

						sendData = capitalizedSentence.getBytes();
						//Envia datagrama a travÈs del socket
						DatagramPacket sendPacket = new DatagramPacket(sendData,
								sendData.length, IPAddress, port);

						serverSocket.send(sendPacket);
					}//TÈrmino el cuerpo del while, Vuelve a su inicio y espera otro datagrama
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
