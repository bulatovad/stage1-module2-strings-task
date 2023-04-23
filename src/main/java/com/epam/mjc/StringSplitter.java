package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        StringJoiner sj = new StringJoiner("|");
        for(String d:delimiters) {
            sj.add(d);
        }
        List<String> subStr = new ArrayList<>();

        for(String s: source.split(sj.toString())) {
            if(s.equals("")) continue;
            subStr.add(s);
        }
        return subStr;
    }
}
