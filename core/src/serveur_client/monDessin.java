package serveur_client;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class monDessin {

	private float monDiametre = 10;
	private float monDiametreDivPar2 = monDiametre / 2;
	private float pX, pY;
	
	private Color maCouleur = Color.RED;

	ShapeRenderer shapeRenderer;
		
	public monDessin(float x, float y) {
		pX = x;
		pY = y;
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setColor(maCouleur);
	}
	public void dessiner() {
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.ellipse(pX - monDiametreDivPar2, pY - monDiametreDivPar2, monDiametre, monDiametre);
		shapeRenderer.end();
	}	
}
