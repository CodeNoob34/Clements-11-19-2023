import java.util.*;
import java.io.*;

public class table {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("table.dat"));
        //Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            ArrayList<String> statements = new ArrayList<>();
            int salads = sc.nextInt();
            int soups = sc.nextInt();
            int steaks = sc.nextInt();
            //salads
            int lettuce = (salads + 1)/2;
            int croutons = (salads + 2)/3;
            int dressing = (salads + 9)/10;
            if (lettuce > 0) statements.add(lettuce + " head(s) of lettuce");
            if (croutons > 0) statements.add(croutons + " bag(s) of croutons");
            if (dressing > 0) statements.add(dressing + " bottle(s) of dressing");
            //soups
            int pots = (14 + soups)/15;
            int packs = (2 + soups)/3;
            if (pots > 0) statements.add(pots + " pot(s) of soup");
            if (packs > 0) statements.add(packs + " bag(s) of crackers");
            //steak
            int num = (2 + steaks)/3;
            int plates = steaks;
            if (num > 0) statements.add(num + " steak(s)");
            if (plates > 0) statements.add(plates + " plate(s)");

            int bowls = salads + soups;
            if (bowls > 0) statements.add(bowls + " bowl(s)");
            int parm = (14 + bowls)/15;
            if (parm > 0) statements.add(parm + " block(s) of parmesan");
            for(int i = 0; i<statements.size(); i++){
                System.out.print(statements.get(i));
                if (i != statements.size() - 1) System.out.print(", ");
            }
            System.out.println();
        }

        sc.close();
    }

}