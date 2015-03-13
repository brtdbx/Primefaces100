package guis.page100;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import org.primefaces.component.themeswitcher.ThemeSwitcher;

@Named
@SessionScoped
public class ThemeSwitcherSvm implements Serializable {

    ArrayList<ThemeInfo> selectableThemes;

    public ArrayList<ThemeInfo> getSelectableThemes() {
        return selectableThemes;
    }

    public void setSelectableThemes(ArrayList<ThemeInfo> selectableThemes) {
        this.selectableThemes = selectableThemes;
    }

    private String preferredTheme;

    public String getPreferredTheme() {
        return preferredTheme;
    }

    public void setPreferredTheme(String preferredTheme) {
        this.preferredTheme = preferredTheme;
        System.out.println("preferredTheme=" + preferredTheme);
    }

    public void saveTheme(AjaxBehaviorEvent ajax) {
        String themeKey = (String) ((ThemeSwitcher) ajax.getSource()).getValue();
        System.out.println((String) ((ThemeSwitcher) ajax.getSource()).toString());
        System.out.println("setting preferredTheme to " + themeKey);
        setPreferredTheme(themeKey);
    }

    public void onThemeChange() {
        System.out.println("theme switched to: ...");
    }    
    
            
            
    @PostConstruct
    public void init() {

        System.out.println("init ThemeSwitcherSvm");

        ThemeInfo t1 = new ThemeInfo("bootstrap", "Bootstrap");
        ThemeInfo t2 = new ThemeInfo("afterdark", "Afterdark");
        ThemeInfo t3 = new ThemeInfo("south-street", "South Street");
        ThemeInfo t4 = new ThemeInfo("bluesky", "Bluesky");
        ThemeInfo t5 = new ThemeInfo("casablanca", "Casablanca");
        ThemeInfo t6 = new ThemeInfo("excite-bike", "Excite-Bike");

        selectableThemes = new ArrayList<>();
        selectableThemes.add(t1);
        selectableThemes.add(t2);
        selectableThemes.add(t3);
        selectableThemes.add(t4);
        selectableThemes.add(t5);
        selectableThemes.add(t6);

        preferredTheme = "south-street";

        // theme = "south-street"; // init
//        themes = new TreeMap<>();
//        themes.put("Bootstrap", "bootstrap");
//        themes.put("Afterdark", "afterdark");
//        themes.put("Afternoon", "afternoon");
//        themes.put("Aristo", "aristo");
//        themes.put("Black-Tie", "black-tie");
//        themes.put("Blitzer", "blitzer");
//        themes.put("Bluesky", "bluesky");
//        themes.put("Casablanca", "casablanca");
//        themes.put("Cupertino", "cupertino");
//        themes.put("Cruze", "cruze");
//        themes.put("Dark-Hive", "dark-hive");
//        themes.put("Delta", "delta");
//        themes.put("Dot-Luv", "dot-luv");
//        themes.put("Eggplant", "eggplant");
//        themes.put("Excite-Bike", "excite-bike");
//        themes.put("Flick", "flick");
//        themes.put("Glass-X", "glass-x");
//        themes.put("Home", "home");
//        themes.put("Hot-Sneaks", "hot-sneaks");
//        themes.put("Humanity", "humanity");
//        themes.put("Le-Frog", "le-frog");
//        themes.put("Midnight", "midnight");
//        themes.put("Mint-Choc", "mint-choc");
//        themes.put("Overcast", "overcast");
//        themes.put("Pepper-Grinder", "pepper-grinder");
//        themes.put("Redmond", "redmond");
//        themes.put("Rocket", "rocket");
//        themes.put("Sam", "sam");
//        themes.put("Smoothness", "smoothness");
//        themes.put("South-Street", "south-street");
//        themes.put("Start", "start");
//        themes.put("Sunny", "sunny");
//        themes.put("Swanky-Purse", "swanky-purse");
//        themes.put("Trontastic", "trontastic");
//        themes.put("UI-Darkness", "ui-darkness");
//        themes.put("UI-Lightness", "ui-lightness");
//        themes.put("Vader", "vader");
    }

    public class ThemeInfo {

        private String name;
        private String key;

        public ThemeInfo(String key, String name) {
            this.name = name;
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

    }

}
