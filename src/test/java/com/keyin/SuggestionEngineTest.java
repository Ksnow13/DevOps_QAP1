/*

Kyle Snow
Software Development Semester 4
Software Design, Architecture, Testing & DevOps
Started  June 1st, 2023
Finished June 5th, 2023

 */

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
    @DisplayName("Test Suggestion Engine With Given Word")
    public void testSuggestion() throws IOException, URISyntaxException {

        URI uri =  ClassLoader.getSystemResource("words.txt").toURI();
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath);

        suggestionEngine.loadDictionaryData(Paths.get(path.toUri()));

        Assertions.assertTrue(suggestionEngine.generateSuggestions("hell-").contains("hello"));
    }

    @Test
    @DisplayName("Test Suggestion Engine Failure")
    public void testSuggestionFail() throws IOException, URISyntaxException {
        URI uri =  ClassLoader.getSystemResource("words.txt").toURI();
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath);

        suggestionEngine.loadDictionaryData(Paths.get(path.toUri()));

        Assertions.assertFalse(suggestionEngine.generateSuggestions("class").contains("class"));
    }

    // SuggestionEngine had a bug where it would not find suggestions when given a word with a capital letter
    // The bug has been fixed and this test method makes sure it is working.
    @Test
    @DisplayName("Test Suggestion Engine With Capital Words")
    public void testSuggestionCaseSensitive() throws IOException, URISyntaxException {
        URI uri =  ClassLoader.getSystemResource("words.txt").toURI();
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath);

        suggestionEngine.loadDictionaryData(Paths.get(path.toUri()));

        Assertions.assertTrue(suggestionEngine.generateSuggestions("Hell-").contains("hello"));
    }

    // testing if the loadDictionary method successfully loads the words.txt file data
    // if loadDictionary method works it returns true, else it returns false
    @Test
    @DisplayName("Test If Dictionary Data Loads")
    public void testLoadDictionaryData() throws URISyntaxException, IOException {
        URI uri =  ClassLoader.getSystemResource("words.txt").toURI();
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath);

        Assertions.assertTrue(suggestionEngine.loadDictionaryData(Paths.get(path.toUri())));

    }

    @Test
    @DisplayName("Test Load Dictionary Data Failure")
    public void testLoadDictionaryDataFail() throws URISyntaxException, IOException {
        Assertions.assertFalse(suggestionEngine.loadDictionaryData( Path.of("noWords.txt")));
    }

}
