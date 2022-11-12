package ru.netology.domain;

public class Player {

    protected String name;
    protected Integer strength;

    public Player(String name, Integer strength) {
        this.name = name;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public Integer getStrength() {
        return strength;
    }
}
