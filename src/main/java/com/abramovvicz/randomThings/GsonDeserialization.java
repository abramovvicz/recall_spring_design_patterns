package com.abramovvicz.randomThings;

import com.abramovvicz.randomThings.dao.Movie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.netty.util.internal.StringUtil;
import org.apache.zookeeper.common.StringUtils;

import java.lang.reflect.Type;
import java.util.Optional;

public class GsonDeserialization {

    public static void main(String[] args) {
        GsonDeserialization gsonDeserialization = new GsonDeserialization();
        System.out.println(gsonDeserialization.deserialization());
    }

    String deserialization() {
//        Type type = TypeToken.getParameterized(List.class, Movie.class).getType();
        Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapter(Boolean.class, new BooleanDeserialization()).create();


        String jsonInput = "{\"imdbId\":       \"tt0472043\",\"actors\":" + "[{\"imdbId\":\"nm2199632\",\"dateOfBirth\":\"1982-09-21T12:00:00+01:00\"," + "\"filmography\":[\"Apocalypto\",\"Beatdown\",\"Wind Walkers\"]}]}";
        String jsonInput2 = "{\"imdbId\":       \"}";
        Object o = gson.fromJson(jsonInput, Movie.class);
        return o.toString();
    }

    class BooleanDeserialization implements JsonDeserializer<Integer> {

        @Override
        public Integer deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return Optional.ofNullable(jsonElement.getAsString())
                    .map(StringUti::is)
                    .filter(x -> String.valueOf(x)).orElse(1);
        }
    }
}
