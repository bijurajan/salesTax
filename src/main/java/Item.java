public class Item {
    private final String description;
    private final boolean isExempt;
    private final boolean isImported;

    public Item(String description, boolean isExempt, boolean isImported) {
        this.description = description;
        this.isExempt = isExempt;
        this.isImported = isImported;
    }

    public boolean isExempt() {
        return isExempt;
    }

    public boolean isImported() {
        return isImported;
    }
}
