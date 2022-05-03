package test;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class RunClient {
    public static void main(String[] args) {
        RunClient r = new RunClient();

        System.out.println("Hello World!");
        if (args.length < 4) {
            System.out.println("Usage: " + r.getClass().getName() + " <arg1> <arg2> <arg3> <arg4>");
            System.out.println("  arg1 - path to the input data (Sample.csv)" + "");
            System.out.println("  arg2 - path to flight details to populate DB (flights.csv)" + "");
            System.out.println("  arg3 - path to Output.csv" + " - e.g.for successful result");
            System.out.println("  arg4 - path to Output.txt" + " - e.g.for error message");

            System.exit(64); /* exit(64) command line usage error */
        }

        // for(String s: args)
        // System.out.println(s);

        String input = args[0];
        String flights = args[1];
        String out_csv = args[2];
        String out_txt = args[3];

        System.out.println("Input Data use File : " + input);
        System.out.println("Populate DB use File: " + flights);

        DataSet ds = DataSet.getInstance();

        DataSetCSVHandler dshandler = new DataSetCSVHandler(flights);
        try {
            dshandler.createDataSet();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        // System.out.println(ds.getFlightsMap());

        BookingCSVHandler bhandler = new BookingCSVHandler(input);
        try {
            bhandler.createBookingList();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        // System.out.println(ds.getBooking());

        QueryBookingTool qt = new QueryBookingTool();

        qt.executeQuery();
        qt.run();

        System.out.println(" -= Final view of Flights DataSet =-");
        // System.out.println(ds.getFlightsMap());
        ds.printFlights();
        System.out.println(" -=================================-");

        // System.out.println(ds.getBookeds());

        FileCreator outputCSV = new FileCreator(out_csv, "csv");
        try {
            outputCSV.Save(true);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // System.out.println(ds.getInvalids());

        FileCreator outputTXT = new FileCreator(out_txt, "txt");
        try {
            outputTXT.Save(true);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        System.out.println("Output saved to File : " + out_csv);
        System.out.println("Message saved to File: " + out_txt);

    }
}
