package io.egen.apollo;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;

import static io.egen.apollo.JsonKeys.*;

/**
 * Hello world!
 */
public class App {
    public static final String fileLoc = "/Users/san/Garrage/EGen/Training/Project/data/movielist.json";

    public static void main(String[] args) {
        JsonFactory factory = new JsonFactory();
        try (JsonParser jp = factory.createParser(new File(fileLoc))) {
            if(jp.nextToken() == JsonToken.START_ARRAY) {
                while (jp.nextToken() == JsonToken.START_OBJECT){
                    parseEachJsonObject(jp);
                }
            }

            if (jp.getCurrentToken() != JsonToken.END_ARRAY)
                System.err.println("Last Token was not END_ARRAY");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseEachJsonObject(JsonParser jp) throws IOException {
        jp.nextToken();
        String key = jp.getCurrentName();
        switch (key) {
            case TITLE:
                printValue(jp);
                break;
            case YEAR:
                printValue(jp);
                break;
            case RATED:
                printValue(jp);
                break;
            case RELEASED:
                printValue(jp);
                break;
            case RUNTIME:
                printValue(jp);
                break;
            case GENRE:
                printValue(jp);
                break;
            case DIRECTOR:
                printValue(jp);
                break;
            case WRITER:
                printValue(jp);
                break;
            case ACTORS:
                printValue(jp);
                break;
            case PLOT:
                printValue(jp);
                break;
            case LANGUAGE:
                printValue(jp);
                break;
            case COUNTRY:
                printValue(jp);
                break;
            case AWARDS:
                printValue(jp);
                break;
            case POSTER:
                printValue(jp);
                break;
            case METASCORE:
                printValue(jp);
                break;
            case IMDB_RATING:
                printValue(jp);
                break;
            case IMDB_VOTES:
                printValue(jp);
                break;
            case IMDB_ID:
                printValue(jp);
                break;
            case TYPE:
                printValue(jp);
                break;
            default:
                throw new AssertionError("Something is Missing");
        }

        if (jp.nextToken() == JsonToken.END_OBJECT)
            return;
        else
            parseEachJsonObject(jp);
    }

    public static void printValue(JsonParser jp) throws IOException {
        if (jp.nextToken() == JsonToken.VALUE_STRING)
            System.out.println(jp.getValueAsString());
    }
}
