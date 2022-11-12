package ru.netology.domain;


import java.util.ArrayList;

public class Game {
    protected ArrayList<Player> players = new ArrayList<>();



    public void register(Player player) { // регистрация пользователя
        players.add(player);
    }

    public int round(String PlayerName1, String PlayerName2) {
        Player p1 = null;
        Player p2 = null;
        for (Player player : players) {
            if (player.getName().equals(PlayerName1)) { // имя которое берем равно имени игрока
            p1 = player;
            }
            if (player.getName().equals(PlayerName2)) {
                p2 = player;

            }
        }
// если имя не зарег ( null )  - выдаем ошибку
        if (p1 == null) {
            throw new NotRegisteredException( PlayerName1 + " is not registered");
        }
        if (p2 == null) {
            throw new NotRegisteredException(PlayerName2 + " is not registered");
        }

// правило игры. сравниваем силу
        if (p1.getStrength() == p2.getStrength()) {
            return 0; // ничья
        }
        if (p1.getStrength() > p2.getStrength()) {
            return 1; // выйграл 1 игрок
        } else {
            return 2; // выйграл 2 игрок

        }
    }


}