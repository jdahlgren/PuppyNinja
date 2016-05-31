/**
 * Created by Johannes on 2016-05-31.
 */
package se.johannesdahlgren.puppyninja.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import se.johannesdahlgren.puppyninja.PuppyNinja;

public class GameState extends State {

    private Texture puppy;

    protected GameState(GameStateManager gsm) {
        super(gsm);
        puppy = new Texture("puppy1.png");
    }

    @Override
    protected void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        camera.setToOrtho(false, PuppyNinja.WIDTH, PuppyNinja.HEIGHT);
        //sb.draw(background, 0, 0, PuppyNinja.WIDTH, PuppyNinja.HEIGHT);
        sb.draw(puppy, (PuppyNinja.WIDTH / 2) - puppy.getWidth() / 2, (PuppyNinja.HEIGHT / 2));
        sb.end();
    }

    @Override
    protected void handleInput() {


    }

    @Override
    protected void update(float dt) {

    }

    @Override
    protected void dispose() {

    }

}
