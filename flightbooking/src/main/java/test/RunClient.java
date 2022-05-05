package test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class RunClient {
    public static void main(String[] args) {
        RunClient r = new RunClient();
        Logger logger = Logger.getAnonymousLogger();

        logger.log(Level.INFO, "Hello World!");
        if (args.length < 4) {
            String msg1 = "   arg1 - path to the input data (Sample.csv)";
            String msg2 = "   arg2 - path to flight details to populate DB (flights.csv)";
            String msg3 = "   arg3 - path to Output.csv - e.g.for successful result";
            String msg4 = "   arg4 - path to Output.txt - e.g.for error message";
            logger.log(Level.INFO, 
                  String.format("%n Usage: %s <arg1> <arg2> <arg3> <arg4> %n %s %n %s %n %s %n %s", 
                                r.getClass().getName(), msg1, msg2, msg3, msg4 ) );
                                
            System.exit(64); /* exit(64) command line usage error */
        }

        // for(String s: args)
        // System.out.println(s);

        String input = args[0];
        String flights = args[1];
        String out_csv = args[2];
        String out_txt = args[3];

        logger.log(Level.INFO, "Input Data use File : " + input);
        logger.log(Level.INFO, "Populate DB use File: " + flights);

        DataSet ds = DataSet.getInstance();

        DataSetCSVHandler dshandler = new DataSetCSVHandler(flights);
        try {
            dshandler.createDataSet();
        } catch (Exception e) { 
            logger.log(Level.SEVERE, e.toString());
            System.exit(1);
        }

        // System.out.println(ds.getFlightsMap());

        BookingCSVHandler bhandler = new BookingCSVHandler(input);
        try {
            bhandler.createBookingList();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.toString());
            System.exit(1);
        }

        // System.out.println(ds.getBooking());

        QueryBookingTool qt = new QueryBookingTool();

        qt.executeQuery();
        qt.run();

        logger.log(Level.INFO, " -= Final view of Flights DataSet =-");
        // System.out.println(ds.getFlightsMap());
        ds.printFlights();
        logger.log(Level.INFO, " -=================================-");

        // System.out.println(ds.getBookeds());
        // System.out.println(ds.getInvalids());

        FileCreator outputCSV = new FileCreator(out_csv, "csv");
        try {
            outputCSV.Save(true);
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.toString());
            System.exit(1);
        }

        System.out.println("Output saved to File : " + out_csv);
        
        FileCreator outputTXT = new FileCreator(out_txt, "txt");
        try {
            outputTXT.Save(true);
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.toString());
            System.exit(1);
        }

        System.out.println("Message saved to File: " + out_txt);

    }
}
