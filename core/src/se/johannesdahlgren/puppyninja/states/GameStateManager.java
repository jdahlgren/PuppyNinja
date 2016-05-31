/**
 * Created by Johannes on 2016-05-31.
 */
package se.johannesdahlgren.puppyninja.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {

    public Stack<State> states;

    public GameStateManager() {
        states = new Stack<State>();
    }

    public void pop(){
        states.pop();
    }

    public void push(State state) {
        states.push(state);
    }

    public void set(State state) {
        pop();
        push(state);
    }

    public void update(float dt) {
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}
