package annotation;

/**
 * @author hr.han
 * @date 2018/12/1 15:46
 */

public enum OperateSystem {
    /**
     * win
     */
    WINDOWS,

    /**
     * linux & mac
     */
    UNIX;

    private static final String PROPERTY_NAME = "os.name";
    private static final String WIN_PREFIX = "win";

    public static OperateSystem system() {
        if (System.getProperty(PROPERTY_NAME).toLowerCase().startsWith(WIN_PREFIX)) {
            return WINDOWS;
        }
        return UNIX;
    }
}
