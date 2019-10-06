package game.context;

import game.core.chooseFate.History;
import game.core.chooseFate.Litigation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HistoryContext {
    @Bean("painter")
    public History getpainter(){
        Litigation litigation = new Litigation("personDescription", "faultDesc",
                                                 "descPosChoice", "descNegChoice");

        return new History(litigation, "posSequence", "negSequence");
    }
}
