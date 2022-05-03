package test;

import java.util.ArrayList;

public class OutputTXTFactory implements OutputFile {

    @Override
    public ArrayList<String> prepare() {
        ArrayList<String> content = new ArrayList<>();
        for (String s : DataSet.getInstance().getInvalids()) {
            content.add(s);
        }
        return content;
    }
}
