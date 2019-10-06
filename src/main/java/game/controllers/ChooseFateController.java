package game.controllers;


import game.context.GameContext;
import game.core.chooseFate.History;
import game.core.chooseFate.Litigation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import game.utility.Utilities;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Random;

@RestController
@RequestMapping("/game commands")
@Api(value = "game commands", description = "list of mini-game commands")
public class ChooseFateController {
    History history;
    @RequestMapping(method = RequestMethod.GET, value = "/get ligation")
        public Litigation getLigation() {
        Object[] allHistories = Utilities.getAllBeanConcClass(History.class);

        Random random = new Random();
        int boxNumber = random.nextInt(allHistories.length);

        history = (History)allHistories[boxNumber];

        return history.getLitigation();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/set  sequence")
    public void setSequence(@ApiIgnore GameContext gameContext, boolean choice)
    {
        if(choice)
            gameContext.setSequence(history.getPosSequence());

        else
            gameContext.setSequence(history.getNegSequence());
    }
}