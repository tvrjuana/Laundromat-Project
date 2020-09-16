import java.util.ArrayList;
import java.util.List;

public class EmployeeSchedule 
{
    List<List<String>> schedule;

    //creates a new schedule with the days of the week listed as the 1st row
    public EmployeeSchedule()
    {
        schedule = new ArrayList<List<String>>();

        List<String> row1 = new ArrayList<String>(1);
        row1.add("\t\t");
        row1.add("Sun" + "\t\t");
        row1.add("Mon" + "\t\t");
        row1.add("Tue" + "\t\t");
        row1.add("Wed" + "\t\t");
        row1.add("Thu" + "\t\t");
        row1.add("Fri" + "\t\t");
        row1.add("Sat" + "\t\t");
        schedule.add(row1);
    }

    public void addEmployee(String employee)
    {
        boolean noDupe = true;

        //checks to see if the name being entered is already in the schedule
        for(int i = 0; i < this.schedule.size(); i++) 
        {
            if(this.schedule.get(i).get(0).trim().compareTo(employee) == 0) 
            {
                noDupe = false;
                System.out.println("Duplicate employee" + employee);
                
            }
            
        }

        //if the name is new adds a new row to the schedule
        if(noDupe)
        {
            List<String> row = new ArrayList<String>(1);
            row.add(employee + "\t\t");
            row.add("off\t\t");
            row.add("off\t\t");
            row.add("off\t\t");
            row.add("off\t\t");
            row.add("off\t\t");
            row.add("off\t\t");
            row.add("off\t\t");
            this.schedule.add(row);
        }
        
    }

    public void removeEmployee(String employee)
    {
        //checks to see if the name is blank to prevent the 1st row from being deleted
        if(employee.trim().compareTo("") == 0)
        {
            throw new ScheduleException("Cannot delete first row");
        }

        //searches the 1st column of the schedule for the employee and deletes the row if found
        for(int i = 0; i < this.schedule.size(); i++) 
        {
            if(this.schedule.get(i).get(0).trim().compareTo(employee) == 0) 
            {
                this.schedule.remove(i);
            }
            
        }
        
    }

    public void changeTime(String employee, int day, String time)
    {
        //goes through each element in the schedule until it finds
        //the index of the specified employee and the specified day
        //then it changes the element at that index
        for(int i = 0; i < this.schedule.size(); i++) 
        {
            for(int j = 0; j < 8; j++) 
            {
                if(this.schedule.get(i).get(0).trim().compareTo(employee) == 0 && j == day) 
                {
                    //this is just for visuals
                    //it does 2 tabs instead of one if the length of the string is small
                    if(time.length() <= 5)
                    {
                        this.schedule.get(i).set(j,time + "\t\t");
                    }
                    else
                    {
                        this.schedule.get(i).set(j,time + "\t");
                    }
                    
                }            
            }
        }
    }

    //goes through the schedule and builds up a result string then prints the string
    public void printSchedule()
    {
        String result = "";

        for(int i = 0; i < this.schedule.size(); i++) 
        {
            for(int j = 0; j < 8; j++) 
            {
                result += this.schedule.get(i).get(j) + " ";
            }
            result += "\n";
        }

        System.out.print(result + "\n");
    }

    class ScheduleException extends RuntimeException 
    {
        public ScheduleException(String s) 
        {
            super(s);
        }
    }
}

    

