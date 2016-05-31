/**
 * Created by Johannes on 2016-05-31.
 */
package se.johannesdahlgren.puppyninja.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Puppy {
    private Vector2 position;
    private Vector2 velocity;

    private Texture puppyTexture;

    public Puppy() {
        position = new Vector2(10, 10);
        velocity = new Vector2(0, 0);
        puppyTexture = new Texture("puppy1.png");
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public Texture getPuppyTexture() {
        return puppyTexture;
    }
}
