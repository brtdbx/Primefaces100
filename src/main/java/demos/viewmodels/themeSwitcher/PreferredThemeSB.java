package demos.viewmodels.themeSwitcher;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class PreferredThemeSB implements Serializable {

    ThemeInfo preferredThemeInfo;

    public ThemeInfo getPreferredThemeInfo() {
        return preferredThemeInfo;
    }

    public void setPreferredThemeInfo(ThemeInfo preferredThemeInfo) {
        this.preferredThemeInfo = preferredThemeInfo;
    }

    @PostConstruct
    public void init() {
        System.out.println("init PreferredThemeSB");
//        preferredThemeInfo = new ThemeInfo("south-street", "South Street");
        preferredThemeInfo = new ThemeInfo("bluesky", "Bluesky");
    }

}