package game.controllers;

import game.core.MapDb;
import game.core.lobby.Game;
import game.utility.Utilities;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/gameCommands")
@Api(value = "gameCommands", description = "list of mini-game commands")
public class LobbyController extends Controller{
    @RequestMapping(method = RequestMethod.GET, value = "/getGame")
    public Game getGame() {
        List games = Utilities.getAllBeanConcClass(Game.class);

        int order = (int) mapBase.get(Integer.class, "gameCounter");
        mapBase.replace(Integer.class, "gameCounter", order + 1);

        return (Game)games.get(order);
    }
}
