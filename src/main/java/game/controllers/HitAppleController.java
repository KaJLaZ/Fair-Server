package game.controllers;

import game.core.lobby.Game;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameCommands")
@Api(value = "gameCommands", description = "list of mini-game commands")
public class HitAppleController {

    @RequestMapping(method = RequestMethod.POST, value = "/checkHit")
    public boolean checkHit(double x, double y) {
        double x1 = x;
        double y1 = y;

        boolean isBelongByX = x >= (Game.CENTER_OF_SQUARE_X - Game.LENGTH_OF_HALF_SIDE)
                &&( x <= Game.CENTER_OF_SQUARE_X + Game.LENGTH_OF_HALF_SIDE);
        boolean isBelongByY = (y >= (Game.CENTER_OF_SQUARE_Y - Game.LENGTH_OF_HALF_SIDE)
                && y <= Game.CENTER_OF_SQUARE_Y + Game.LENGTH_OF_HALF_SIDE );

        if(isBelongByX && isBelongByY)
            return true;
        else
            return false;

    }
}
