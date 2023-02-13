package com.ticketweasel.marketplace;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TestUtil {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static double randomTicketPrice() {
        return new BigDecimal((Math.random() * (350 - 1) + 1)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
