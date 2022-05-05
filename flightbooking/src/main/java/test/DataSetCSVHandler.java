package test;

import java.util.LinkedList;
import java.util.zip.DataFormatException;

import model.Flight;

public class DataSetCSVHandler {
    private DataSet dataset = DataSet.getInstance();
    private CSVHandler datafile;

    public DataSetCSVHandler(String pathToFile) {
        this.datafile = new CSVHandler(pathToFile);
    }

    public void createDataSet() throws Exception {
        datafile.Load(1);
        LinkedList<String> content = datafile.getContent();

        for (String row : content) {
            String[] col = row.split(",");
            if (col.length < 6) {
                String message = String.format("Insufficient data fields, please check line '%s' in file '%s'", row,
                        datafile.getFilePath());
                throw new DataFormatException(message);
            }
            String category = col[0];
            String flightNumber = col[1];
            int availableSeats = Integer.parseInt(col[2]);
            double price = Double.parseDouble(col[3]);
            String arrival = col[4];
            String departure = col[5];
            dataset.getFlightsMap().put(DataSet.createKeyString(flightNumber, category), // FileghtNumber_Category
                    new Flight(category, flightNumber, availableSeats, price, arrival, departure));
        }
    }

}
