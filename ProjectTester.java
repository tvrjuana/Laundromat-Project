public class ProjectTester 
{
    public static void main(String[] args)
    {
        /*
        //registers a new piece of clothing and adds it to the queue
        Clothes test1 = new Clothes ("John Doe", "Suit", "HandL", "6783339874");
        //displays the clothing
		System.out.println(test1.toString());
		Clothes test2 = new Clothes ("Ron Miller", "Cap and Gown", "GlyCE", "1296873330");
		Clothes test3 = new Clothes ("Marian Hill", "Blouse", "Co2", "9404597180");
		Clothes test4 = new Clothes ("Ron Miller", "Cap and Gown", "GlyCE", "1296873330");
        //adds the clothing to the machine and removes it from queue
        test1.process();
		System.out.println(test2.toString());
		Clothes test5 = new Clothes ("Donald Johnson", "Button Shirt", "Perc", "4045789268");
		Clothes test6 = new Clothes ("Jon Quenton", "Suit", "Perc", "4045931257");
		System.out.println(test3.toString());
		test2.process();
		Clothes test7 = new Clothes ("Ron Miller", "Sweater", "HandL", "1296873330");
		Clothes test8 = new Clothes ("Mavis McCormick", "Blouse", "EcoDC", "4054597180");
		Clothes test9 = new Clothes ("Kenny Lofton", "Uniform", "GlyCE", "7709873330");
		Clothes test0 = new Clothes ("Donna Gilmore", "Blouse", "Co2", "7705689153");
		System.out.println(test4.toString());
		test3.process();
		System.out.println(test7.toString());
		System.out.println(test9.toString());
	*/

        EmployeeSchedule schedule = new EmployeeSchedule();

        //adding employees to schedule
        schedule.addEmployee("Bob");
        schedule.addEmployee("Jill");
        schedule.addEmployee("Zack");
        //schedule.addEmployee(employee);
        ////show schedule
        System.out.println("After adding employees\n");
        schedule.printSchedule();

        //user is not allowed to add duplicate employees
        schedule.addEmployee("Bob");
        System.out.println("After attempting to add duplicate employee\n");
        schedule.printSchedule();

        //removing employee from schedule
        schedule.removeEmployee("Bob");
        System.out.println("After removing an employee\n");
        schedule.printSchedule();
        
        //causes an exception because it is the 1st row
        schedule.removeEmployee("");


        //changing the times for the employees

        //off to time frame
        schedule.changeTime("Jill", 1, "8:00am-1:00pm");
        schedule.changeTime("Jill", 2, "1:00pm-5:00pm");
        schedule.changeTime("Jill", 4, "8:00am-1:00pm");
        schedule.changeTime("Jill", 6, "4:00pm-7:00pm");
        schedule.changeTime("Zack", 5, "4:00pm-7:00pm");
        schedule.changeTime("Zack", 3, "1:00pm-5:00pm");
        schedule.changeTime("Zack", 7, "8:00am-1:00pm");
        schedule.changeTime("Zack", 1, "1:00pm-5:00pm");
        System.out.println("After changing the times\n");
        schedule.printSchedule();

        //time frame to off
        schedule.changeTime("Jill", 1, "off");
        System.out.println("After changing the times again\n");
        schedule.printSchedule();

        
       Inventory inventory = new Inventory();

        // Add Products to inventory
        inventory.addProduct("Some kind of cleaning product", "box256", 10, 19.80);
        inventory.addProduct("Some kind of cleaning product", "shelf4", 4, 19.80);
        inventory.addProduct("Hangers", "box15", 24, 2.87);
        inventory.addProduct("Plastic covers", "shelf10", 12, 1.54);

        // Show inventory
        System.out.println("Inventory after adding products\n");
        inventory.showInventory();

        //causes an exception due to duplicate item
        //inventory.addProduct("Plastic covers", "shelf10", 32, 1.54);

        // Sort Products in inventory
        inventory.sortInventoryAsc();
        System.out.println("Inventory after ascending sort\n");
        inventory.showInventory();

        inventory.sortInventoryDesc();
        System.out.println("Inventory after descending sort\n");
        inventory.showInventory();

        inventory.sortInventoryAlpha();
        System.out.println("Inventory after alphabetical sort\n");
        inventory.showInventory();
        
        //Counting the amount of a product
        System.out.println("The amount of Some kind of cleaning product " + inventory.countProduct("Some kind of cleaning product"));

        //determining the needed amout of a product
        System.out.println("The amount of Plastic covers needed " + inventory.countNeededQuantity("Plastic covers", 15));
        System.out.println();

        //removing a product
        inventory.removeProduct("Some kind of cleaning product", "shelf4");
        System.out.println("Inventory after removing Some kind of cleaning product on shelf4\n");
        inventory.showInventory();
       

      /*BinaryTree<String> tree = new BinaryTree("The Best Grocery Store tm:  $380,438");
		
      BinaryTree<String> rightsubtree1 = new BinaryTree("Max Retail:  $306,718");
      
      BinaryTree<String> leftsubtree1 = new BinaryTree("Used Clothes Ubiquitous:  $490,168");
      leftsubtree1.attachLeft("Super Security:  $540,102");
      
      BinaryTree<String> rightsubtree2 = new BinaryTree("Unclassy Butlers:  $106,238");      
      rightsubtree2.attachLeft("Classy Butlers:  $265,980");
      
      BinaryTree<String> leftsubtree2 = new BinaryTree("The Next Hotel:  $430,625");  
      leftsubtree2.attachRight("Construction United:  $400,098");     
      leftsubtree2.attachLeft("The Hotel:  $487,189");
      
      rightsubtree1.attachRightSubtree(rightsubtree2);
      leftsubtree1.attachRightSubtree(leftsubtree2);
      tree.attachRightSubtree(rightsubtree1);
      tree.attachLeftSubtree(leftsubtree1);
  
      System.out.println("Shows all the businesses and the profit we gain from them using an inorder binary tree search:");
      tree.printsAll(tree);
      System.out.println("\n");
      
      
      System.out.println("Examples of passing business names as a parameter to the function that checks using string methods and binary search tree iterations: ");
      
      System.out.println("For Super Security: ");
      tree.findsProfit(tree, "Super Security");
      System.out.println("\n");
      
      System.out.println("For Unclassy Butlers: ");
      tree.findsProfit(tree, "Unclassy Butlers");
      System.out.println("\n");
      
      System.out.println("For Max Retail: ");
      tree.findsProfit(tree, "Max Retail");
      System.out.println("\n");*/
    }
    
}
