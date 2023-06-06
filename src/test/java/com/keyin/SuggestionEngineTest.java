package com.keyin;

import com.keyin.SuggestionEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SuggestionEngineTest {

    private final SuggestionEngine suggestionEngine = new SuggestionEngine();

    @Test
    @DisplayName("Test Suggestion With Given Word")
    public void testSuggestion() throws IOException, URISyntaxException {

        //SuggestionEngine suggestionEngine = new SuggestionEngine();

        URI uri =  ClassLoader.getSystemResource("words.txt").toURI();
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath);

        suggestionEngine.loadDictionaryData(Paths.get(path.toUri()));

        Assertions.assertTrue(suggestionEngine.generateSuggestions("hell-").contains("hello"));
    }

    @Test
    public void testSuggestionFail() throws IOException, URISyntaxException {
       //SuggestionEngine suggestionEngine = new SuggestionEngine();
        URI uri =  ClassLoader.getSystemResource("words.txt").toURI();
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath);

        suggestionEngine.loadDictionaryData(Paths.get(path.toUri()));

        Assertions.assertFalse(suggestionEngine.generateSuggestions("class").contains("class"));
    }

    @Test
    public void testSuggestionCaseSensitive() throws IOException, URISyntaxException {
        //SuggestionEngine suggestionEngine = new SuggestionEngine();
        URI uri =  ClassLoader.getSystemResource("words.txt").toURI();
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath);

        suggestionEngine.loadDictionaryData(Paths.get(path.toUri()));

        Assertions.assertTrue(suggestionEngine.generateSuggestions("Clas").contains("class"));
    }

    @Test
    public void testLoadDictionaryData() throws URISyntaxException, IOException {

        URI uri =  ClassLoader.getSystemResource("words.txt").toURI();
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath);

        Assertions.assertTrue(suggestionEngine.loadDictionaryData(Paths.get(path.toUri())));

    }

    @Test
    public void testLoadDictionaryDataFail() throws URISyntaxException, IOException {
        Assertions.assertFalse(suggestionEngine.loadDictionaryData( Path.of("noWords.txt")));
    }

}
