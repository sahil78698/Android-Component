package component.support.android;

public class Return {
    public static boolean data() {
        return ContextAware.completed;
    }

    public static boolean dataMain() {
        return Context.completed;
    }

    public static boolean MainData() {
        return Context.isCompleted;
    }
}
