package game.controllers;

import game.core.MapDb;
import game.core.lobby.Game;
import game.utility.Utilities;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import java.util.List;

@RestController
@RequestMapping("/gameCommands")
@Api(value = "gameCommands", description = "list of mini-game commands")
public class LobbyController {
    MapDb base = new MapDb();
    @RequestMapping(method = RequestMethod.GET, value = "/getGame")
    public Game getGame() {
        List games = Utilities.getAllBeanConcClass(Game.class);

        int order = (int) base.get(Integer.class, "gameCounter");
        base.replace(Integer.class, "gameCounter", order + 1);

        return (Game)games.get(order);
    }
}
