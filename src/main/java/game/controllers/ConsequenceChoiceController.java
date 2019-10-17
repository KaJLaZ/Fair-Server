package game.controllers;

import game.core.dataBase.ConsequenceState;
import game.core.dataBase.IsDrunkState;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameCommands")
@Api(value = "gameCommands", description = "list of mini-game commands")
public class ConsequenceChoiceController extends Controller {
    @RequestMapping(method = RequestMethod.GET, value = "/getConsequence")
    public String getConsequence() {
        return (String) mapBase.get(ConsequenceState.class).get();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/isDrunk")
    public boolean isDrunk() {
        return (boolean) mapBase.get(IsDrunkState.class).get();
    }
}


