package item;

public class ItemStack {
    private int count;
    private Item item;
    public ItemStack(Item item,int count)
    {
        this.item = item;
        this.count = count;
    }

    public Item getItem() {
        return item;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
