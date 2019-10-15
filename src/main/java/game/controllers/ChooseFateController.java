package game.controllers;

import game.core.MapDb;
import game.core.chooseFate.History;
import game.core.chooseFate.Litigation;
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
public class ChooseFateController extends Controller{
    History history;
    @RequestMapping(method = RequestMethod.GET, value = "/getLigation")
        public Litigation getLigation() {
        List allHistories = Utilities.getAllBeanConcClass(History.class);

        history = ((History)Utilities.getRandomObjectOfList(allHistories));

        return history.getLitigation();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/setSequence")
    public void setSequence(boolean choice)
    {
        System.out.println("Worked");
        if(choice)
            mapBase.replace(String.class,"consequence", history.getPosSequence());

        else
            mapBase.replace(String.class,"consequence", history.getNegSequence());
    }
}