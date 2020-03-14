package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {

    // стэк это структура данных, которая позволяет следить за состоянием текущего окна приложения
    // реализуя подход "последний вошел-первый вышел"
    // Stack<State> - State - это уже объект LibGdx
    private Stack<State> states;


    // создаем конструктор
    public GameStateManager() {
        states = new Stack<State>();
    }

    // void - означает, что метод не возвращает значений, т.е. нет смысла писать оператор return
    // метод push - будет добавлять окно в конец стэка
    public void push(State state) {
        states.push(state);
    }

    // метод pop будет удалять последнее окно в стэке
    public void pop() {
        states.pop().dispose();
    }

    // удаляет последнее окно с конца и добавляет новое
    public void set(State state) {
        states.pop().dispose();
        states.push(state);
    }

    public void update(float dt) {
        // peek() - метод, который просматривает верхний элемент стэка, но не удаляет его
        states.peek().update(dt);
    }


    // перерисовка текстур через поступаемый извне SpriteBatch
    public void render(SpriteBatch sb) {
        states.peek().render(sb);
    }
}
