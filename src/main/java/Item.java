public class Item {
    private final String description;
    private final boolean isExempt;

    public Item(String description, boolean isExempt) {
        this.description = description;
        this.isExempt = isExempt;
    }

    public boolean isExempt() {
        return isExempt;
    }
}
