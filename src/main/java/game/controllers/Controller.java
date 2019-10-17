package game.controllers;

import game.core.dataBase.MapDb;

public abstract class Controller {
    public static final MapDb mapBase = MapDb.getMapDb();
}
