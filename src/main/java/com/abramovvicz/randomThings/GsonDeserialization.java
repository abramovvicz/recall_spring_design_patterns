package com.abramovvicz.randomThings;

import com.abramovvicz.randomThings.dao.Actor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GsonDeserialization {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) {
        GsonDeserialization gsonDeserialization = new GsonDeserialization();
        System.out.println(gsonDeserialization.deserialization());
    }

    String deserialization() {
        Type type = TypeToken.getParameterized(List.class, Actor.class)
                             .getType();
        Gson gson = new GsonBuilder().serializeNulls()
                                     .registerTypeAdapter(Integer.class, new IntegerDeserializer())
                                     .registerTypeAdapter(Actor.class, new ActorDeserializer())
                                     .create();

        String jsonInput = "[{\"imdbId\":\"123\",\"dateOfBirth\":\"1982-09-21T12:00:00+01:00\"," +
                "\"filmography\":[\"Apocalypto\",\"Beatdown\",\"Wind Walkers\"]}, " +
                "{\"imdbId\":\"234\",\"dateOfBirth\":\"1982-09-21T12:00:00+01:00\"," +
                "\"filmography\":[\"Apocalypto\",\"Beatdown\",\"Wind Walkers\"]}]";
        Object o = gson.fromJson(jsonInput, type);
        return o.toString();

    }

    class IntegerDeserializer implements JsonDeserializer<Integer> {

        @Override
        public Integer deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return Optional.ofNullable(jsonElement.getAsString())
                           .filter(StringUtils::isNotBlank)
                           .map(Integer::valueOf)
                           .orElse(1);
        }
    }

    class ActorDeserializer implements JsonDeserializer<Actor> {

        @SneakyThrows
        @Override
        public Actor deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject asJsonObject = json.getAsJsonObject();
            JsonElement imdbId = asJsonObject.get("imdbId");
            JsonElement dateOfBirth = asJsonObject.get("dateOfBirth");
            JsonArray filmography = asJsonObject.getAsJsonArray("filmography");

            List<String> movies = new ArrayList<>();
            if (filmography != null) {
                movies = IntStream.range(0, filmography.size())
                                  .mapToObj(i -> filmography.get(i)
                                                            .getAsString())
                                  .collect(Collectors.toList());
            }

            Actor actor = new Actor(imdbId.getAsInt(), sdf.parse(dateOfBirth.getAsString()), movies);
            return actor;
        }
    }
}
