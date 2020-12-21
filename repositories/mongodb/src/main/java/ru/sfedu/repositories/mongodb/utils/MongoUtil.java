package ru.sfedu.repositories.mongodb.utils;

import javax.persistence.Table;
import java.util.Arrays;

import static ru.sfedu.repositories.mongodb.Constant.*;

public class MongoUtil {
    private MongoUtil() {

    }

    public static String getNativeName(Class<?> clazz) {
        StringBuilder stringBuilder = new StringBuilder(MONGO_DB);
        Arrays.stream(clazz.getAnnotations())
                .filter(annotation -> annotation.annotationType() == Table.class)
                .map(annotation -> clazz.getAnnotation(Table.class))
                .findFirst().ifPresentOrElse(table -> {
            if (!table.schema().equals(EMPTY)) stringBuilder.append(POINT).append(table.schema());
            if (!table.name().equals(EMPTY)) stringBuilder.append(POINT).append(table.name());
            else stringBuilder.append(POINT).append(clazz.getSimpleName());
        }, () -> stringBuilder.append(POINT).append(clazz.getSimpleName()));
        return stringBuilder.toString();
    }

}
