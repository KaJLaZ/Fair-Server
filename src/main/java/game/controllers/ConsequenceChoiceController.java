package game.controllers;

import game.context.GameContext;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/gameCommands")
@Api(value = "gameCommands", description = "list of mini-game commands")
public class ConsequenceChoiceController {
    @RequestMapping(method = RequestMethod.GET, value = "/getConsequence")
    public String getConsequence(@ApiIgnore GameContext gameContext) {
        return gameContext.getSequence();
    }
}
