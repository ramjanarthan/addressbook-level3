package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's priority in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPriority(String)}
 * Default value is 1 if not set by user.
 */
public class Priority {

    public static final String EXAMPLE = "HIGH";
    public static final String MESSAGE_PRIORITY_CONSTRAINTS = "Person priority should be 'LOW', 'MEDIUM' or 'HIGH'";

    public enum PriorityLevel {
        LOW, MEDIUM, HIGH
    }
    public final PriorityLevel priority;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Priority(String priority) throws IllegalValueException {
        if (!isValidPriority(priority)) {
            System.out.println(priority);
            throw new IllegalValueException(MESSAGE_PRIORITY_CONSTRAINTS);
        }
        this.priority = PriorityLevel.valueOf(priority);
    }

    /**
     * Returns true if a given integer is a valid priority string
     */
    public static boolean isValidPriority(String priority) {
        return priority.equals(PriorityLevel.HIGH.toString())
                || priority.equals(PriorityLevel.MEDIUM.toString())
                || priority.equals(PriorityLevel.LOW.toString());
    }

    @Override
    public String toString() {
        return priority.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Priority // instanceof handles nulls
                && this.priority.equals((((Priority) other).priority))); // state check
    }

    @Override
    public int hashCode() {
        return priority.hashCode();
    }

}
