public class Inventory 
{
    InventoryNode inventoryHead;


    public Inventory()
    {
        inventoryHead = null;
    }

    public void addProduct(String productName, String location, int quantity, double price) throws ProductException
    {
        InventoryNode new_node = null;

        //checks to see if proper input was given
        try
        {
            new_node = new InventoryNode(productName, location, quantity, price);
        }
        catch(ProductException e)
        {
            throw new ProductException("Improper input");
        }

        new_node = new InventoryNode(productName, location, quantity, price);

        //if inventory is empty set head node
        if(this.inventoryHead == null)
        {
            this.inventoryHead = new_node;
        }
        else
        //add to inventory if product doesn't already exist
        {
            InventoryNode cur = this.inventoryHead;
            while(cur.next != null)
            {
                if(cur.name == productName && cur.location == location)
                {
                    throw new ProductException("Dupplicate item");
                }
                else
                {
                    cur = cur.next;
                }
                
            }
            
            cur.next = new_node;
        }
        
    }



    public void showInventory()
    {
        //goes through each node and prints its data
        for(InventoryNode cur = inventoryHead; cur != null; cur = cur.next)
        {
            System.out.println(cur.name + ", " + cur.quantity + ", " + cur.location + ", " + cur.price);
        }
        System.out.println();
    }

    public InventoryNode removeMaximum()
    {
        int max = 0;
        InventoryNode pointer = null;

        //finds the maximum quantity and the node asociated with it
        for(InventoryNode cur = inventoryHead; cur != null; cur = cur.next)
        {
            if(cur.quantity > max)
            {
                max = cur.quantity;
                pointer = cur;
            }
        }

        //deletes the node with the maximum
        if(pointer == null)
        {
            System.out.println("The inventory is empty");
        }
        else
        {
            this.removeProduct(pointer.name, pointer.location);
        }
        
        
        return pointer;
    }

    public void sortInventoryDesc()
    {
        Inventory temp = new Inventory();

        //repeatedly finds the node with the maximum and moves it to a new inventory
        while(inventoryHead != null)
        {
           InventoryNode node = this.removeMaximum();
           temp.addProduct(node.name, node.location, node.quantity, node.price);
        }

        //sets the original head to the sorted head
        inventoryHead = temp.inventoryHead;
        
    }

    public InventoryNode removeMinimum()
    {
        int min = 100000;
        InventoryNode pointer = null;

        //finds the minimum quantity and the node asociated with it
        for(InventoryNode cur = inventoryHead; cur != null; cur = cur.next)
        {
            if(cur.quantity < min)
            {
                min = cur.quantity;
                pointer = cur;
            }
        }

        //deletes the node with the minimum
        if(pointer == null)
        {
            System.out.println("The inventory is empty");
        }
        else
        {
            this.removeProduct(pointer.name, pointer.location);
        }
        
        
        return pointer;
    }

    public void sortInventoryAsc()
    {
        Inventory temp = new Inventory();

        //repeatedly finds the node with the minimum and moves it to a new inventory
        while(inventoryHead != null)
        {
           InventoryNode node = this.removeMinimum();
           temp.addProduct(node.name, node.location, node.quantity, node.price);
        }

        //sets the original head to the sorted head
        inventoryHead = temp.inventoryHead;
        
    }

    public InventoryNode removeAlpha()
    {
        String min = "zzzzzzzzzzzzzzzzzz";
        InventoryNode pointer = null;

        //finds the minimum name and the node asociated with it
        for(InventoryNode cur = inventoryHead; cur != null; cur = cur.next)
        {
            if(cur.name.compareTo(min) < 0)
            {
                min = cur.name;
                pointer = cur;
            }
        }

        //deletes the node with the minimum
        if(pointer == null)
        {
            System.out.println("The inventory is empty");
        }
        else
        {
            this.removeProduct(pointer.name, pointer.location);
        }
        
        
        return pointer;
    }

    public void sortInventoryAlpha()
    {
        Inventory temp = new Inventory();

        //repeatedly finds the node with the minimum and moves it to a new inventory
        while(inventoryHead != null)
        {
           InventoryNode node = this.removeAlpha();
           temp.addProduct(node.name, node.location, node.quantity, node.price);
        }

        //sets the original head to the sorted head
        inventoryHead = temp.inventoryHead;
        
    }

    public void removeProduct(String productName, String location)
    {
        InventoryNode prev  = null;

        //searches the inventory until it finds the requested node and deletes it
        for(InventoryNode cur = inventoryHead; cur != null; cur = cur.next)
        {
            if(cur.name == productName && cur.location == location)
            {
                if(cur == inventoryHead)
                {
                    inventoryHead = cur.next;
                }
                else
                {
                    prev.next = cur.next;
                }
                break;
            }
            prev = cur;

        }
    }

    public int countProduct(String productName)
    {
        int result = 0;

        //goes through the inventory and adds up the quantities of all items with the same name
        for(InventoryNode cur = inventoryHead; cur != null; cur = cur.next)
        {
            if(cur.name == productName)
            {
                result += cur.quantity;
            }
        }

        return result;
        
    }

    public int countNeededQuantity(String productName, int neededQuantity)
    {
        //computes the difference between 
        //the needed quantity of a product and the quantity of that product that is in the inventory
        return neededQuantity - countProduct(productName);
    }

    class ProductException extends RuntimeException 
    {
        public ProductException(String s) 
        {
            super(s);
        }
    }
}
