/**
 * Created by Johannes on 2016-05-31.
 */
package se.johannesdahlgren.puppyninja.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

import se.johannesdahlgren.puppyninja.PuppyNinja;
import se.johannesdahlgren.puppyninja.sprites.Puppy;

public class GameState extends State {

    private static final int MAX_TEXTURES = 2;
    private final Texture background;
    private final Texture pauseButton;
    private final Rectangle pauseRect;
    private Array<Texture> puppyTextures;
    private Random random;
    private Array<Puppy> puppies;
    private boolean isPaused;
    private ShapeRenderer sr;

    protected GameState(GameStateManager gsm) {
        super(gsm);
        isPaused = false;
        random = new Random();
        background = new Texture("background.jpg");
        pauseButton = new Texture("pausebutton.png");
        pauseRect = new Rectangle(PuppyNinja.WIDTH - pauseButton.getWidth(), PuppyNinja.HEIGHT - pauseButton.getHeight(), pauseButton.getWidth(), pauseButton.getHeight());
        
        puppyTextures = new Array<>();
        puppies = new Array<>();
        sr = new ShapeRenderer();

        for (int i = 1; i <= MAX_TEXTURES; i++) {
            puppyTextures.add(new Texture("puppy" + i + ".png"));
        }
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);

            if (pauseRect.contains(touchPos.x, touchPos.y)) {
                isPaused = !isPaused;
            }


            if (!isPaused) {
                for (Puppy puppy : puppies) {
                    if (puppy.getBoundingBox().contains(touchPos.x, touchPos.y)) {
                        puppy.setDead(true);
                    }
                }
            }
        }
    }

    @Override
    protected void update(float dt) {
        handleInput();
        if (!isPaused) {
            if (isAllPuppiesGone()) {
                resetPuppies();
            }
            for (Puppy puppy : puppies) {
                puppy.update(dt);
            }
        }
    }

    @Override
    protected void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sr.setProjectionMatrix(camera.combined);
        camera.setToOrtho(false, PuppyNinja.WIDTH, PuppyNinja.HEIGHT);

        // Draw background & pause
        sb.begin();
        sb.draw(background, 0, 0, PuppyNinja.WIDTH, PuppyNinja.HEIGHT);
        sb.draw(pauseButton, PuppyNinja.WIDTH - pauseButton.getWidth(), PuppyNinja.HEIGHT - pauseButton.getHeight(), pauseButton.getWidth(), pauseButton.getHeight());
        sb.end();

        // Draw Boundingboxes
        sr.setColor(0, 1, 0, 1);
        sr.begin(ShapeRenderer.ShapeType.Filled);
        for (Puppy puppy : puppies) {
            sr.rect(puppy.getBoundingBox().getX(), puppy.getBoundingBox().getY(), puppy.getBoundingBox().getWidth(), puppy.getBoundingBox().getHeight());
        }
        sr.end();

        // Draw alive puppies
        sb.begin();
        for (Puppy puppy : puppies) {
            if (!puppy.isDead()) {
                sb.draw(puppy.getTexture(), puppy.getPosition().x, puppy.getPosition().y);
            }
        }
        sb.end();
    }

    @Override
    protected void dispose() {
        background.dispose();
        for (Texture puppyTexture : puppyTextures) {
            puppyTexture.dispose();
        }
        System.out.println("Disposed Gamestate");
    }

    private void resetPuppies() {
        puppies.clear();
        addNewPuppies();
    }

    private void addNewPuppies() {
        int numberOfPuppies = random.nextInt(5) + 1;
        int textureNr;
        for (int i = 0; i < numberOfPuppies; i++) {
            int x = random.nextInt(Puppy.PUPPY_TEXTURE_OFFSET_X_RIGHT) + Puppy.PUPPY_TEXTURE_OFFSET_X_LEFT;
            int y = random.nextInt(PuppyNinja.HEIGHT / 2) + PuppyNinja.HEIGHT / 2;
            textureNr = random.nextInt(MAX_TEXTURES);
            puppies.add(new Puppy(x, y, puppyTextures.get(textureNr)));
        }
        System.out.println("Puppies: " + puppies.size);
        for (Puppy puppy : puppies) {
            System.out.println("X: " + puppy.getPosition().x + " Y: " + puppy.getPosition().y);
        }
    }

    private boolean isAllPuppiesGone() {
        if (puppies.size == 0) {
            return true;
        }
        for (Puppy puppy : puppies) {
            if (puppy.getPosition().y > Puppy.OUT_OF_PICTURE_Y) {
                return false;
            }
        }
        return true;
    }
}
