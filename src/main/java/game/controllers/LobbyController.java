package game.controllers;

import game.context.MapDb;
import game.core.lobby.Game;
import game.utility.Utilities;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

public class LobbyController {
    @RequestMapping(method = RequestMethod.GET, value = "/getGame")
    public Game getGame(@ApiIgnore MapDb base) {
        List games = Utilities.getAllBeanConcClass(Game.class);

        int order = (int) base.get(Integer.class, "gameCounter");
        base.replace(Integer.class, "gameCounter", order + 1);

        return (Game)games.get(order);
    }
}
