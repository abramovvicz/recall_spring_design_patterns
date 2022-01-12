package com.abramovvicz.randomThings;

import com.abramovvicz.randomThings.dao.Actor;
import com.abramovvicz.randomThings.dao.Movie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class GsonSerialization {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) throws ParseException {
        GsonSerialization gsonEx = new GsonSerialization();

        String s = gsonEx.serializeStringToJson();
        System.out.println(s);
    }

    String serializeStringToJson() throws ParseException {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .disableHtmlEscaping()
                .registerTypeAdapter(Actor.class, new ActorGsonSerializer())
                .create();

        Actor rudyYoungblood = new Actor(1,
                sdf.parse("21-09-1982"), Arrays.asList("Apocalypto","Beatdown", "Wind Walkers"));

        Movie movieWithNullValue = new Movie(null,
                "Mel Gibson", Arrays.asList(rudyYoungblood));

        String serializedMovie = gson.toJson(movieWithNullValue);


        return serializedMovie;
    }

    class ActorGsonSerializer implements JsonSerializer<Actor> {

        @Override
        public JsonElement serialize(Actor actor, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject actorJsonObject = new JsonObject();

            actorJsonObject.addProperty("ActorName", actor.getImdbId());
            actorJsonObject.addProperty("Actor DateOfBirth", actor.getDateOfBirth() != null ? sdf.format(actor.getDateOfBirth()) : null);
            actorJsonObject.addProperty("Number of films", actor.getFilmography() != null ? actor.getFilmography().size() : null);
            actorJsonObject.addProperty("Movies", actor.getFilmography() != null ? convertFilmography(actor.getFilmography()) : null);

            return actorJsonObject;
        }

        private String convertFilmography(List<String> filmography) {
            return String.join("-", filmography);
        }
    }




}
