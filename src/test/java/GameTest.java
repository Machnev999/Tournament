import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Game;
import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;



public class GameTest {


    Game game = new Game();

    Player player1 = new Player(1, "Batman", 200);
    Player player2 = new Player(2, "Superman", 400);
    Player player3 = new Player(3, "Ironman", 200);


    @BeforeEach
    @Test
    public void setUp() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

    }

    @Test
    public void shouldDraw() {
        Assertions.assertEquals(0, game.round("Batman", "Ironman"));
    }

    @Test
    public void shouldWinPlayerName1() {
        Assertions.assertEquals(1, game.round("Superman", "Ironman"));
    }

    @Test
    public void shouldWinPlayerName2() {
        Assertions.assertEquals(2, game.round("Batman", "Superman"));
    }

    @Test
    public void shouldNoTRegisteredPlayerName1() {
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Halk", "IronMan"));
    }

    @Test
    public void shouldNoTRegisteredPlayerName2() {
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("IronMan", "Halk"));
    }
    @Test
    public void shouldNoTRegisteredNoOne() {
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Grut", "Halk"));
    }

}
