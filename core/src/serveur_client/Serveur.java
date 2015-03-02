package serveur_client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Serveur {
	Socket socket;
	ServerSocket serverSocket;
	public Serveur(){
	}
	public void ouvrirConnexion() throws IOException{
		serverSocket = new ServerSocket(10666); 
		socket = serverSocket.accept();
	}
	
	public Object recupererObjet() throws IOException, ClassNotFoundException{
		
			//Récupère le message du Client
		ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
		Object messageFromClient = in.readObject(); 
		
		return messageFromClient;

	}
	public void fermerConnexion() throws IOException{
		//Ferme la connexion
		serverSocket.close();
	}
}
