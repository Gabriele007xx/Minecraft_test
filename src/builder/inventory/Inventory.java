
package builder.inventory;

import item.Item;
import item.ItemStack;

public class Inventory {
    public int index_selected;
    private int capacity;
    private int nitems;
    private ItemStack[] items;
    private Slot[] slots;
    public Inventory(int capacity)
    {
        this.capacity = capacity;
        items = new ItemStack[capacity];
        nitems = 0;
        slots = new Slot[capacity];
        for(int i=0;i<this.capacity;i++)
        {
            slots[i] = new Slot();
        }
        for(int i=0;i <  capacity;i++)
        {
            items[i].setCount(0);
        }
    }
    public boolean add(Item item,int index)
    {
        if(nitems < capacity)
        {
            if(item.getMaxStackSize() == 1)
            {
                items[FindFreeSlot()] = new ItemStack(item,1);
                return true;
            }
            else
            {
                if(items[index].getCount() < 64)
                {
                    items[index] = new ItemStack(item, items[index].getCount() + 1);
                    return true;
                }
                else
                {
                    items[FindFreeSlot()] = new ItemStack(item, items[FindFreeSlot()].getCount() + 1);
                }
            }

        }
        return false;
    }
    public int FindSameItemSlot(Item item)
    {
        for(int i =0;i < capacity;i++)
        {
            if(items[i].getItem() == item)
            {
                return i;
            }
        }
        return -1;
    }
    public int FindFreeSlot()
    {
        for(int i =0;i < capacity;i++)
        {
            if(items[i].getItem() == null)
            {
                return i;
            }
        }
        return -1;
    }

}
