package game.context;

import game.core.drawRuns.Symbol;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SymbolContext {
    @Bean("standardRun")
    public Symbol getStandartRun() {

        boolean[][] standart =  {{true, true, false, false},
                {true, false, true, false},
                {true, false, true, true},
                {true, false, false, true}
        };

        return new Symbol(standart);
    }

    @Bean("coldRun")
    public Symbol getColdRun() {

        boolean[][] cold = {{false, true, true, false},
                {false, true, true, false},
                {false, true, true, false},
                {false, true, true, false}
        };

        return new Symbol(cold);
    }

    @Bean("warmRun")
    public Symbol getWarmRun() {

        boolean[][] warm = {{true, false, false, false},
                {true, false, true, true},
                {true, true, false, true},
                {false, false, false, true}
        };

        return new Symbol(warm);
    }

    @Bean("dangerRun")
    public Symbol getDangerRun() {

        boolean[][] danger = {{true, true, false, false},
                {true, false, true, false},
                {true, false, true, false},
                {true, true, false, false}
        };

        return new Symbol(danger);
    }

    @Bean("fragileRun")
    public Symbol getFragileRun() {

        boolean[][] fragile = {{true, false, true, true},
                {true, true, false, true},
                {true, false, true, false},
                {true, true, false, false}
        };

        return new Symbol(fragile);
    }
}
