package me.whiteship.chapter01.item01;

/**
 * 이 클래스의 인스턴스는 #getInstacne()를 통해 사용한다.
 * @see #getInstance()
 */
public class Settings {

    private boolean useAutoSteering;

    private boolean useABS;

    private Difficulty difficulty;

    public static void main(String[] args) {
        System.out.println(new Settings());
        System.out.println(new Settings());
        System.out.println(new Settings());
    }

//    private Settings() {}

    public Settings() {}

    public Settings(boolean useAutoSteering, boolean useABS, Difficulty difficulty) {
        this.useAutoSteering = useAutoSteering;
        this.useABS = useABS;
        this.difficulty = difficulty;
    }

    private static final Settings SETTINGS = new Settings();

    public static Settings getInstance() {
        return SETTINGS;
    }
}
