package serveur_client;

import java.io.IOException;
import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Serveur_Client extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	ShapeRenderer renderer;
	ArrayList<monDessin> mesDessins;
	Serveur serveur;
	Client client;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		renderer = new ShapeRenderer();
		mesDessins = new ArrayList<monDessin>();
//		monDessin cercle = new monDessin(50,50);
//		mesDessins.add(cercle);
		serveur = new Serveur();
		client = new Client();
		
		Gdx.input.setInputProcessor(new InputAdapter () {
			public boolean touchDown (int x, int y, int pointer, int button) {
				if ((button == Input.Buttons.LEFT)) {
					monDessin cercle = new monDessin((float) Gdx.input.getX(), (float) Gdx.graphics.getHeight() - Gdx.input.getY());
					try {
						client.envoyer(cercle);
						mesDessins.add((monDessin) serveur.recupererObjet());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return true;
			}
		});

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		try {
			serveur.ouvrirConnexion();
			client.ouvrirConnexion();
			for (monDessin dessin : mesDessins) dessin.dessiner();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
