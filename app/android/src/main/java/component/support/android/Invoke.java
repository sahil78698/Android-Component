package component.support.android;


public class Invoke {
    public static boolean start() {
        if (Component.Main_itemRe.equals(Component.Main_itemMainRe) && Component.Main_itemInRe.equals(Component.Main_itemMainInre)) {
            return false;
        } else {
            return true;
        }

    }
}
