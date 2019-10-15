package game.controllers;

import game.core.chooseFate.PointOfHit;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameCommands")
@Api(value = "gameCommands", description = "list of mini-game commands")
public class HitAppleController {
    @RequestMapping(method = RequestMethod.GET, value = "/checkHit")
    public boolean checkHit(PointOfHit pointOfHit) {


        return true;
    }
}
