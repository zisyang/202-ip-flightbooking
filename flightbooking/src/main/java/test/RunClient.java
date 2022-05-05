package test;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class RunClient {
    public static void main(String[] args) {
        RunClient r = new RunClient();
        Logger logger = Logger.getAnonymousLogger();

        logger.info("Hello World!");
        if (args.length < 4) {
            String msg1 = "   arg1 - path to the input data (Sample.csv)";
            String msg2 = "   arg2 - path to flight details to populate DB (flights.csv)";
            String msg3 = "   arg3 - path to Output.csv - e.g.for successful result";
            String msg4 = "   arg4 - path to Output.txt - e.g.for error message";
            String msg = String.format("%n Usage: %s <arg1> <arg2> <arg3> <arg4> %n %s %n %s %n %s %n %s",
                          r.getClass().getName(), msg1, msg2, msg3, msg4 );

            logger.info(msg);

            System.exit(64); /* exit(64) command line usage error */
        }

        // for(String s: args)
        // System.out.println(s);

        String input = args[0];
        String flights = args[1];
        String out_csv = args[2];
        String out_txt = args[3];

        logger.info("Input Data use File : " + input);
        logger.info("Populate DB use File: " + flights);

        DataSet ds = DataSet.getInstance();

        DataSetCSVHandler dshandler = new DataSetCSVHandler(flights);
        try {
            dshandler.createDataSet();
        } catch (Exception e) {
            logger.severe(e.toString());
            System.exit(1);
        }

        // System.out.println(ds.getFlightsMap());

        BookingCSVHandler bhandler = new BookingCSVHandler(input);
        try {
            bhandler.createBookingList();
        } catch (Exception e) {
            logger.severe(e.toString());
            System.exit(1);
        }

        // System.out.println(ds.getBooking());

        QueryBookingTool qt = new QueryBookingTool();

        qt.executeQuery();
        qt.run();

        logger.info(" -= Final view of Flights DataSet =-");
        // System.out.println(ds.getFlightsMap());
        ds.printFlights();
        logger.info(" -=================================-");

        // System.out.println(ds.getBookeds());
        // System.out.println(ds.getInvalids());

        FileCreator outputCSV = new FileCreator(out_csv, "csv");
        try {
            outputCSV.Save(true);
        } catch (IOException e) {
            logger.severe(e.toString());
            System.exit(1);
        }

        logger.info("Output saved to File : " + out_csv);

        FileCreator outputTXT = new FileCreator(out_txt, "txt");
        try {
            outputTXT.Save(true);
        } catch (IOException e) {
            logger.severe(e.toString());
            System.exit(1);
        }

        logger.info("Message saved to File: " + out_txt);

    }
}
