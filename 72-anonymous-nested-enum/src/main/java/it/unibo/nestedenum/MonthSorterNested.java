package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    enum Month {
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private final int days;

        private Month(final int days) {
            this.days = days;
        }

        public int getDays() {
            return days;
        }

        public Month fromString(final String name) throws IllegalArgumentException {
            final String upperCaseName = Objects.requireNonNull(name.toUpperCase());
            Month returnValue = null;
            int monthsThatContainsName = 0;
            for (final Month month : Month.values()) {
                if (month.name().contains(upperCaseName)) {
                    returnValue = month;
                    monthsThatContainsName++;
                }
            }
            if (returnValue == null) {
                throw new IllegalArgumentException("Invalid month name");
            } else if (monthsThatContainsName != 1) {
                throw new IllegalArgumentException("Ambiguous month name");
            } else {
                return returnValue;
            }
        }
    };

    @Override
    public Comparator<String> sortByDays() {

        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }
}
