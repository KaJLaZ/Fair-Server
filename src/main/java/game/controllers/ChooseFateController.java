package game.controllers;


import game.context.MapDb;
import game.core.chooseFate.History;
import game.core.chooseFate.Litigation;
import game.utility.Utilities;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Random;

@RestController
@RequestMapping("/gameCommands")
@Api(value = "gameCommands", description = "list of mini-game commands")
public class ChooseFateController {
    History history;
    @RequestMapping(method = RequestMethod.GET, value = "/getLigation")
        public Litigation getLigation() {
        Object[] allHistories = Utilities.getAllBeanConcClass(History.class);

        Random random = new Random();
        int boxNumber = random.nextInt(allHistories.length);

        history = (History)allHistories[boxNumber];

        return history.getLitigation();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/setSequence")
    public void setSequence(@ApiIgnore MapDb mapBase, boolean choice)
    {
        if(choice)
            mapBase.replace(String.class,"consequence", history.getPosSequence());

        else
            mapBase.replace(String.class,"consequence", history.getNegSequence());
    }
}