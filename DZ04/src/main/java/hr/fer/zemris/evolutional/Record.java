package hr.fer.zemris.evolutional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Record {
    public double x;
    public double y;
    public double out;

    public Record(double x, double y, double out) {
        this.x = x;
        this.y = y;
        this.out = out;
    }

    public static List<Record> loadRecordsFromFile(String filepath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filepath));

        List<Record> records = new ArrayList<>();
        for (String line : lines) {
            String[] splitted = line.split("\t");

            records.add(new Record(Double.valueOf(splitted[0]), Double.valueOf(splitted[1]), Double.valueOf(splitted[2])));
        }
        return records;
    }
}
