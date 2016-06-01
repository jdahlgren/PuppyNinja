package se.johannesdahlgren.puppyninja;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import se.johannesdahlgren.puppyninja.states.GameStateManager;
import se.johannesdahlgren.puppyninja.states.MenuState;

public class PuppyNinja extends ApplicationAdapter {
    public static final String TITLE = "Puppy Ninja";
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1280;
    private SpriteBatch batch;
    private GameStateManager gsm;

    @Override
    public void create () {
        batch = new SpriteBatch();
        gsm = new GameStateManager();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        gsm.push(new MenuState(gsm));

    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
    }
}
