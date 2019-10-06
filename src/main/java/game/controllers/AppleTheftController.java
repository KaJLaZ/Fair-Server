package game.controllers;

import game.core.appleTheft.Garden;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game commands")
@Api(value = "game commands", description = "list of mini-game commands")
public class AppleTheftController {
    static Garden garden = new Garden();

    @RequestMapping(method = RequestMethod.GET, value = "/string")
    public String drawMap() {
        return garden.gameStatus();
    }

    @RequestMapping(method = RequestMethod.GET, value =  "/array")
    public int[][] array() {
        return garden.getMap();
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/up")
    public int[][] up() {
        garden.up();
        return garden.getMap();
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/down")
    public int[][] down() {
        garden.down();
        return garden.getMap();
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/left")
    public int[][] left() {
        garden.left();
        return garden.getMap();
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/right")
    public int[][] right() {
        garden.right();
        return garden.getMap();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/end")
    public boolean end() {
        return garden.isGameEnded();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/win")
    public boolean win() {
        return garden.isWon();
    }
}
