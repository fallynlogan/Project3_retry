package restaurant;

import java.util.Random;

public class CustomerFactory {
    public CustomerFactory(){

    }

    public static String[] shuffleNames(String[] names)
    {
        Random rand = new Random();

        for(int i=0 ; i<names.length ; i++){
            int randomIndexToSwap = rand.nextInt(names.length);
            String temp = names[randomIndexToSwap];
            names[randomIndexToSwap] = names[i];
            names[i] = temp;
        }
        return names;
    }

    public static Customer[] shuffleCustomers(Customer[] customers)
    {
        Random rand = new Random();

        for(int i=0 ; i<customers.length ; i++)
        {
            int randomIndexToSwap = rand.nextInt(customers.length);
            Customer temp = customers[randomIndexToSwap];
            customers[randomIndexToSwap] = customers[i];
            customers[i] = temp;
        }
        return customers;
    }

    public static Customer[] createDailyCustomers()
    {
        Random rand = new Random();

        String[] possibleNames = {"Chad","Cathy","Karen","Susan","Mary","Wendy","Adam","Naomi","Boone","Jane","Ellie","Brandon","Amy","Oliver","Mason","Mia","James","Martin"};
        int nameIndex = 0;
        String[] shuffledNames = shuffleNames(possibleNames);


        int numCasual = rand.nextInt(12) + 1;
        int numBusiness = rand.nextInt(3) + 1;
        int numCatering = rand.nextInt(3) + 1;
        int totalCustomers = numBusiness + numCasual + numCatering;

        Customer[] dailyCustomers = new Customer[totalCustomers];
        int currentIndex = 0;

        for(int i=0 ; i<numCasual ; i++)
        {
            dailyCustomers[currentIndex] = new CasualCustomer(shuffledNames[nameIndex]);
            nameIndex = nameIndex + 1;
            currentIndex++;
        }

        for(int i=0 ; i<numBusiness ; i++)
        {
            dailyCustomers[currentIndex] = new BusinessCustomer(shuffledNames[nameIndex]);
            nameIndex++;
            currentIndex++;
        }

        for(int i=0 ; i<numCatering ; i++)
        {
            dailyCustomers[currentIndex] = new CateringCustomer(shuffledNames[nameIndex]);
            nameIndex++;
            currentIndex++;
        }

        return shuffleCustomers(dailyCustomers);
    }
}
