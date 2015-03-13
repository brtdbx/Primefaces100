package demos.viewmodels.selectOne;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class SelectOneBean implements Serializable {

    private Item selectedItem;

    ArrayList<Item> selectableItems;

    public ArrayList<Item> getSelectableItems() {
        return selectableItems;
    }

    public void setSelectableItems(ArrayList<Item> selectableItems) {
        this.selectableItems = selectableItems;
    }

    private Long selectedId;

    public Long getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(Long selectedId) {
        this.selectedId = selectedId;

        System.out.println("selectedId, findSelectedItem.label=" + selectedId + ", "
                + findSelectedItem(selectedId).label
        );

    }

    private Item findSelectedItem(Long itemId) {

        selectedItem = null;
        for (Item it : selectableItems) {
            if (it.getId() == selectedId) {
                selectedItem = it;
                break; //should be unique as an id
            }
        }
        return selectedItem;

    }

    @PostConstruct
    public void init() {

        Item i1 = new Item("Label1", "val1", 1L);
        Item i2 = new Item("Label2", "val2", 2L);
        Item i3 = new Item("Label3", "val3", 3L);

        selectableItems = new ArrayList<>();
        selectableItems.add(i1);
        selectableItems.add(i2);
        selectableItems.add(i3);

    }

    public class Item {

        private String value;
        private String label;
        private Long id;

        public Item(String label, String value, long id) {
            this.value = value;
            this.label = label;
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

    }

}
