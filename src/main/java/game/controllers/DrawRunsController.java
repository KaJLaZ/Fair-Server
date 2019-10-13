package game.controllers;

import game.context.MapDb;
import game.core.drawRuns.Box;
import game.utility.Utilities;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/gameCommands")
@Api(value = "gameCommands", description = "list of mini-game commands")
public class DrawRunsController {
    @RequestMapping(method = RequestMethod.GET, value = "/getBox")
    public Box getBox() {
        List allBoxes = Utilities.getAllBeanConcClass(Box.class);

        return (Box)Utilities.getRandomObjectOfList(allBoxes);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/issueSalary")
    public void issueSalary(@ApiIgnore MapDb mapBase, Boolean isIssueSalary) {
        mapBase.replace(isIssueSalary.getClass(), "isIssueSalary", isIssueSalary);
    }
}