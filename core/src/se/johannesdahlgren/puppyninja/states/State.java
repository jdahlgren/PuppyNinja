/**
 * Created by Johannes on 2016-05-31.
 */
package se.johannesdahlgren.puppyninja.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class State {

    protected OrthographicCamera camera;
    protected GameStateManager gsm;

    protected State(GameStateManager gsm) {
        this.gsm = gsm;
        camera = new OrthographicCamera();
    }

    protected abstract void handleInput();
    protected abstract void update(float dt);
    protected abstract void render(SpriteBatch sb);
    protected abstract void dispose();
}
