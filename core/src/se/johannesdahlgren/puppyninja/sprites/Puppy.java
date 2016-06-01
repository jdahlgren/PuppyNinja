/**
 * Created by Johannes on 2016-05-31.
 */
package se.johannesdahlgren.puppyninja.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import se.johannesdahlgren.puppyninja.PuppyNinja;

public class Puppy {

    public static final int OUT_OF_PICTURE_Y = 0;
    private static final int PUPPY_TEXTURE_WIDTH = 150;
    public static final int PUPPY_TEXTURE_OFFSET_X_RIGHT = PuppyNinja.WIDTH - (PUPPY_TEXTURE_WIDTH * 2);
    public static final int PUPPY_TEXTURE_OFFSET_X_LEFT = PUPPY_TEXTURE_WIDTH;
    private static final int GRAVITY = -15;

    private Vector2 position;
    private Vector2 velocity;
    private Texture puppyTexture;

    public Puppy(int x, int y, Texture texture) {
        position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        puppyTexture = texture;
    }

    public void update(float dt) {
        if (position.y > OUT_OF_PICTURE_Y) {
            velocity.add(0, GRAVITY);
        }
        velocity.scl(dt);
        position.add(0, velocity.y);
        velocity.scl(1 / dt);
        if (position.y < OUT_OF_PICTURE_Y) {
            position.y = 0;
        }
        if (position.x > PUPPY_TEXTURE_OFFSET_X_RIGHT) {
            position.x = PUPPY_TEXTURE_OFFSET_X_RIGHT;
        }
    }

    public Vector2 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return puppyTexture;
    }
}
