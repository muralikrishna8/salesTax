package com.twu.salestax;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class RoundDoubleTest {
    @Test
    public void shouldRoundTheDoubleToNearestZeroPointZeroFive() {
        RoundDouble roundDouble = new RoundDouble();

        Double actualRoundedValue = roundDouble.roundUp(6.125, 0.05);

        assertThat(actualRoundedValue, is(6.15));
    }
}