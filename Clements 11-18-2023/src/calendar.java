import java.util.*;
import java.io.*;

public class calendar {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("calendar.dat"));
        //Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        while (t-- > 0) {
            String[] arr = sc.next().split("/");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(arr[2]), Integer.parseInt(arr[0]) - 1, Integer.parseInt(arr[1]));
            calendar.add(Calendar.DAY_OF_MONTH, sc.nextInt());
            System.out.println(months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DAY_OF_MONTH) + ", " + calendar.get(Calendar.YEAR));
        }
        sc.close();
    }

}