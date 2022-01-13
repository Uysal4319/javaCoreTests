package formaters.numberFormaters;

import java.math.BigDecimal;

public class NumberFormatTest {

    public static void main(String[] args) {

        BigDecimal blockageRatio = new BigDecimal(0);
        int totalSampleCount = 0;
        int blockageCount = 0;

        float blockagePercent = (blockageCount / (totalSampleCount * 1.0f));
        blockageRatio = new BigDecimal(Float.toString(blockagePercent));
        System.out.println(blockageRatio);
    }
}
