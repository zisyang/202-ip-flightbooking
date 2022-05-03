package test;

import java.util.ArrayList;

import model.Booked;

public class OutputCSVFactory implements OutputFile {

    @Override
    public ArrayList<String> prepare() {
        ArrayList<String> content = new ArrayList<>();
        boolean isFirst = true;
        for (Booked b : DataSet.getInstance().getBookeds()) {
            if (isFirst) {
                content.add(b.headerString());
                isFirst = false;
            }
            content.add(b.toString());
        }
        return content;
    }

}
