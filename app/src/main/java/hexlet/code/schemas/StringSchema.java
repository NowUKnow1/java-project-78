package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {

    @Override
    public final StringSchema required() {
        setRequired();
        return this;
    }

    @Override
    protected final boolean isInvalidInput(Object input) {
        return !(input instanceof String);
    }

    @Override
    protected final boolean isEmptyValue(String input) {
        return input == null || input.isEmpty();
    }

    public final StringSchema contains(String substring) {
        Predicate<String> validationValue = input -> input.contains(substring);
        addConditions("contains", validationValue);
        return this;
    }

    public final StringSchema minLength(int minLength) {
        Predicate<String> validationValue = input -> input.length() >= minLength;
        addConditions("minLength", validationValue);
        return this;
    }
}
