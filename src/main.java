import Player.Player;
import field.Field;
import ships.Admiral;
import utils.Controller;

/**
 * @author Stepan Morgachev
 * @date 14.09.2023 20:05
 */
public class main {
    public static void main(String[] args) {
        Player player = new Player();
        Admiral admiral = new Admiral(player);
        admiral.arrangeShips();
        Controller controller = new Controller(player);
        while (player.isAlive()){
            controller.fire();
        }
    }
}
