
public class InventoryNode 
{
    public String name;
    public String location;
    public int quantity;
    public double price;
    public InventoryNode next;

    //Constructor # 1
    public InventoryNode()
    {
        name = "";
        location = "";
        quantity = 0;
        price = 0;
        next= null;
    }
    
    //Constructor # 2
    public InventoryNode(String p_name, String p_location, int p_quantity, double p_price)
    {
        name = p_name;
        location = p_location;
        quantity = p_quantity;
        price = p_price;
        next= null;
    }
    
}
