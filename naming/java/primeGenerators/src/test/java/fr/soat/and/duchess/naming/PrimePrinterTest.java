package fr.soat.and.duchess.naming;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class PrimePrinterTest {
    private String leadFilePath;
    private String goldFilePath;

    @Before
    public void setup() throws Exception {
        leadFilePath = generateLeadFile();
        goldFilePath = getGoldFile();
    }

    @Test
    public void should_generate_output_matching_gold() throws Exception {
        PrimePrinter.main(new String[0]);
        BufferedReader lead = new BufferedReader(new FileReader(leadFilePath));
        BufferedReader gold = new BufferedReader(new FileReader(goldFilePath));

        String line;
        while ((line = gold.readLine()) != null)
            Assertions.assertThat(line).isEqualTo(lead.readLine());

        Assertions.assertThat(lead.readLine()).isNull();

    }

    private String getGoldFile() {
        return new File("gold.txt").getAbsolutePath();
    }

    private String generateLeadFile() throws FileNotFoundException {
         String leadFile = new File("lead.txt").getAbsolutePath();
        FileOutputStream fileOutputStream = new FileOutputStream(leadFile);
        System.setOut(new PrintStream(fileOutputStream));
        return leadFile;
    }


}