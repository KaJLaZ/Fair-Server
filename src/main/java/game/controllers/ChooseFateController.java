package game.controllers;

import game.core.chooseFate.History;
import game.core.chooseFate.HitApple;
import game.core.chooseFate.Litigation;
import game.core.dataBase.ConsequenceState;
import game.core.dataBase.DayCounterState;
import game.core.dataBase.HasMoneyState;
import game.core.dataBase.IsStolenApplesState;
import game.utility.Utilities;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/gameCommands")
@Api(value = "gameCommands", description = "list of mini-game commands")
public class ChooseFateController extends Controller {
    private History history;

    @RequestMapping(method = RequestMethod.GET, value = "/getLigation")
    public Litigation getLigation() {
        Object[] allHistories = Utilities.getBean("histories").getObjects();
        int dayNumber = (Integer) mapBase.get(DayCounterState.class).get() - 1;

        history = (History) allHistories[dayNumber];

        return history.getLitigation();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/forgivePrisoner")
    public void forgivePrisoner() {
        mapBase.replace(ConsequenceState.class, new ConsequenceState(history.getNegSequence()));

        if (isPrisonerDonated())
            mapBase.replace(HasMoneyState.class, new HasMoneyState(true));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hasApple")
    public boolean hasApple() {
        boolean hasApple = (boolean) mapBase.get(IsStolenApplesState.class).get();

        return hasApple;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/checkHit")
    public void checkHit(double x, double y) {

        if (HitApple.isHited(x, y)) {
            mapBase.replace(ConsequenceState.class, new ConsequenceState(history.getPosSequence()));
        } else {
            mapBase.replace(ConsequenceState.class, new ConsequenceState(history.getNegSequence()));
        }
    }

    private boolean isPrisonerDonated() {
        return new Random().nextBoolean();
    }
}