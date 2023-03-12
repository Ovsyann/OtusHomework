package ru.homework;
import com.google.common.base.Joiner;

import java.util.List;
public class HelloOtus {
    public String concatenateStringsWithDelimiterNoGuava(List<String> strList, String delimiter) {
        StringBuilder builder = new StringBuilder();
        for (String str: strList){
            if (str != null){
                builder.append(str).append(delimiter);
            }
        }

        builder.setLength(builder.length() - delimiter.length());
        return builder.toString();
    }

    public String concatenateStringsWithDelimiterGuava(List<String> strList, String delimiter) {
        return Joiner.on(delimiter).skipNulls().join(strList);
    }
}
