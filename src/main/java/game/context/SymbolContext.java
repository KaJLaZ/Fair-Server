package game.context;

import game.core.ObjectsWrapper;
import game.core.drawRuns.Symbol;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SymbolContext {
    @Bean
    public Symbol StandardRun() {

        boolean[][] standard = {{true, true, false, false},
                {true, false, true, false},
                {true, false, true, true},
                {true, false, false, true}
        };

        return new Symbol(standard);
    }

    @Bean
    public Symbol ColdRun() {

        boolean[][] cold = {{false, true, true, false},
                {false, true, true, false},
                {false, true, true, false},
                {false, true, true, false}
        };

        return new Symbol(cold);
    }

    @Bean
    public Symbol WarmRun() {

        boolean[][] warm = {{true, false, false, false},
                {true, false, true, true},
                {true, true, false, true},
                {false, false, false, true}
        };

        return new Symbol(warm);
    }

    @Bean
    public Symbol DangerRun() {

        boolean[][] danger = {{true, true, false, false},
                {true, false, true, false},
                {true, false, true, false},
                {true, true, false, false}
        };

        return new Symbol(danger);
    }

    @Bean
    public Symbol FragileRun() {

        boolean[][] fragile = {{true, false, true, true},
                {true, true, false, true},
                {true, false, true, false},
                {true, true, false, false}
        };

        return new Symbol(fragile);
    }

    @Bean
    public ObjectsWrapper<Symbol> symbols(Symbol[] symbols) {
        return new ObjectsWrapper<>(symbols);
    }
}
