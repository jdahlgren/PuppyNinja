/**
 * Created by Johannes on 2016-05-31.
 */
package se.johannesdahlgren.puppyninja.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import se.johannesdahlgren.puppyninja.PuppyNinja;

public class MenuState extends State {

    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("background.jpg");
        playBtn = new Texture("playbutton.png");
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        camera.setToOrtho(false, PuppyNinja.WIDTH, PuppyNinja.HEIGHT);
        sb.draw(background, 0, 0, PuppyNinja.WIDTH, PuppyNinja.HEIGHT);
        sb.draw(playBtn, (PuppyNinja.WIDTH / 2) - playBtn.getWidth() / 2, (PuppyNinja.HEIGHT / 2));
        sb.end();
    }

    @Override
    protected void dispose() {

    }
}
