package tempconversionclient;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mybean.TempConversionBeanRemote;

public class MyThread extends Thread {
    TempConversionBeanRemote conversionBean = lookupTempConversionBeanRemote();
    @Override
    public void run() {
        System.out.println("Press 'q' to quit the program.");
        Scanner sc = new Scanner(System.in);
        String input = "";
        while(true) {
            System.out.print("Enter degree in Farenheit: ");
            input = sc.nextLine();
            if(input.equals("q")) {
                System.out.println("Program stops working.");
                break;
            }
            double celsius = conversionBean.fToC(Double.parseDouble(input));
            System.out.printf("%s Farenheit = %.2f Celsius\n\n",input, celsius);
        }
    }
    private TempConversionBeanRemote lookupTempConversionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (TempConversionBeanRemote) c.lookup("java:comp/env/TempConversionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
