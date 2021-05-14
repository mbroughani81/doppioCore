package doppio.log;

import java.util.HashMap;

public interface AdvancedLog {
    void log(String message, HashMap<?, ?> map);
}
