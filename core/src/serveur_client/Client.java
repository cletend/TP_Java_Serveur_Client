package serveur_client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	Socket client;
	
	public Client(){
	}
	
	public void ouvrirConnexion() throws UnknownHostException, IOException{
		System.out.println("Je vais écouter le port 10666");
		client = new Socket("127.0.0.1",10666);
	}
	public void envoyer(monDessin cercle) throws IOException{
			//Initialisation des variables
		OutputStream out = client.getOutputStream();
		ObjectOutputStream outToServer = new ObjectOutputStream(out);
				
			//Envoi le message au serveur
		outToServer.writeObject(cercle);

	}
	
	public void fermerConnexion() throws IOException{
		//Ferme la connexion
		client.close();
	}
}