package doppio.controller;

import doppio.db.Context;

public class AbstractController {
    protected Context context;
    public AbstractController() {
        context = new Context();
    }
}
