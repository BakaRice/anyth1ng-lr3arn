package com.ricemarch.accesslambda.customizedcollectors;

/**
 * @author tanwentao
 * @since 2021/12/3
 */

public class StringCombiner {

    private final String prefix;
    private final String suffix;
    private final String delim;
    private final StringBuilder builder;

    public StringCombiner(String prefix, String suffix, String delim) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.delim = delim;
        this.builder = new StringBuilder();
    }

    public StringCombiner add(String element) {
        if (this.areNoAtStart()) {
            this.builder.append(delim);
        }
        this.builder.append(element);
        return this;
    }


    private boolean areNoAtStart() {
        return builder.length() != 0;
    }

    @Override
    public String toString() {
        return prefix + builder + suffix;
    }

    public StringCombiner merge(StringCombiner other) {
        if (!other.equals(this)) {
            if (other.areNoAtStart() && this.areNoAtStart()) {
                other.builder.insert(0, this.delim);
            }
            this.builder.append(other.builder);
        }
        return this;
    }
}
