package game.core.dataBase.services;

import game.core.ObjectsWrapper;
import game.core.chooseFate.History;
import game.core.dataBase.entities.*;
import game.core.dataBase.repositories.BoxRepository;
import game.core.dataBase.repositories.DayRepository;
import game.core.dataBase.repositories.HistoryRepository;
import game.core.drawRuns.Box;
import game.core.drawRuns.Symbol;
import game.core.lobby.Day;
import game.utility.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class PrepDB implements PreparableDB {
    @Autowired
    private DayRepository dayRepository;
    @Autowired
    private BoxRepository boxRepository;
    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public void prepareDB() {
        Box[] boxes = (Box[]) Utilities.getBean("boxes").getObjects();
        History[] histories = (History[]) Utilities.getBean("histories").getObjects();
        Day[] days = (Day[]) Utilities.getBean("days").getObjects();


        updateBoxes(boxes);
        updateHistories(histories);
        updateDays(days);
    }

    private void updateBoxes(Box[] boxes) {
        for(Box i : boxes)
            boxRepository.save(i);
    }

    private void updateHistories(History[] histories) {
        for(History i : histories)
            historyRepository.save(i);
    }

    private void updateDays(Day[] days) {
        for(Day i : days)
            dayRepository.save(i);
    }
}

