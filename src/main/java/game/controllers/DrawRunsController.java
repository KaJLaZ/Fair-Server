package game.controllers;

import game.utility.Utilities;
import game.core.drawRuns.Box;
import game.context.GameContext;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import java.util.Random;

@RestController
@RequestMapping("/game commands")
@Api(value = "game commands", description = "list of mini-game commands")
public class DrawRunsController {
    @RequestMapping(method = RequestMethod.GET, value = "/get box")
    public Box getBox() {
        Object[] allBoxes = Utilities.getAllBeanConcClass(Box.class);

        Random random = new Random();
        int boxNumber = random.nextInt(allBoxes.length);

        return (Box)allBoxes[boxNumber];
    }

    @RequestMapping(method = RequestMethod.POST, value = "/issue salary")
    public void issueSalary(@ApiIgnore GameContext gameContext, boolean isIssueSalary) {
        gameContext.setHasMoney(isIssueSalary);
    }
}