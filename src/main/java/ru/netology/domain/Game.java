package ru.netology.domain;



import java.util.HashMap;

public class Game {
    protected HashMap<String,Integer> map = new HashMap<>();

    public void register(Player player) { // регистрация пользователя
        map.put(player.getName(), player.getStrength());
    }


    public int round(String PlayerName1, String PlayerName2) {
        String p1 = null;
        String p2 = null;
        for (String key : map.keySet()) {

            if (key.equals(PlayerName1)) { // имя которое берем равно имени игрока
                p1 = key;
            }
            if (key.equals(PlayerName2)) {
                p2 = key;
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
        if (map.get(p1) == map.get(p2)) {
            return 0; // ничья
        }
        if (map.get(p1) > map.get(p2)) {
            return 1; // выйграл 1 игрок
        } else {
            return 2; // выйграл 2 игрок

        }
    }


}
