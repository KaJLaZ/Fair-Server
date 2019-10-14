package game.context;

import game.core.MapDb;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BaseContext {
    @Bean("base")
    public MapDb Db(){
        return new MapDb();
    }
}
