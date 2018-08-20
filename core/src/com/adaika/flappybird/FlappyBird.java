package com.adaika.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBird extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	Texture topTube;
	Texture bottomTube;

	Texture[] birds;
	int flapState;
	float birdY = 0;
	float velocity = 0;
	int gameState = 0;
	float gravity = 2;
	float gap = 200;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
        background = new Texture("bg.png");
        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        birds = new Texture[2];
        birds[0] = new Texture("bird.png");
        birds[1] = new Texture("bird2.png");
        birdY = Gdx.graphics.getHeight() / 2 - birds[1].getHeight() / 2;

	}

	@Override
	public void render () {

        batch.begin();
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		if (gameState != 0) {


		    batch.draw(topTube, Gdx.graphics.getWidth() / 2 - topTube.getWidth() / 2, Gdx.graphics.getHeight() / 2 + gap / 2);
            batch.draw(bottomTube, Gdx.graphics.getWidth() / 2 - bottomTube.getWidth() / 2, Gdx.graphics.getHeight() / 2 - gap / 2 - bottomTube.getHeight());


			if (Gdx.input.justTouched()) {
				velocity = -30;
			}
				if (birdY > 0 || velocity < 0) {
					velocity = velocity + gravity;
	    			birdY -= velocity;
				}

		} else {
	    	if (Gdx.input.justTouched()) {
	    		gameState = 1;
			}
		}

		if (flapState == 0) {
			flapState = 1;
		} else {
			flapState = 0;
		}


	    batch.draw(birds[flapState], Gdx.graphics.getWidth() / 2 - birds[flapState].getWidth() / 2, birdY);
	    batch.end();


	}
	

}
