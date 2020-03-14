package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {
    protected OrthographicCamera camera;
    protected Vector3 mouse;

    protected GameStateManager gsm;

    // конструктор класса. служит для получения значений из других классов
    public State(GameStateManager gsm) {
        // this - это контекст, означающий, что мы работаем с данными в пределах класса
        this.gsm = gsm;
        camera = new OrthographicCamera();
        mouse = new Vector3();
    }

    protected abstract void handleInput(); // обработка нажатия для запуска игры
    public abstract void update(float dt); // обновление экрана раз в какой-то промежуток времени
    public abstract void render(SpriteBatch sb); // отрисовка объектов на экране
    public abstract void dispose(); // удаление экземпляра(объекта) когда он не нужен
}
