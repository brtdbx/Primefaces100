package demos.viewmodels.themeSwitcher;

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
