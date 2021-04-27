package doppio.listener;

public interface StringInvoker {
    void checkListeners(String s);
    void addListener(StringListener listener);
}
