# DevOps_QAP1

Software Development Semester 4

Software Design, Architecture, Testing & DevOps
Started  June 1st, 2023
Finished June 5th, 2023

*** Read Me ***
- Make sure the word.txt is in the resources folder.
- For windows users all the code provided will work fine.
- For Mac users, in SuggestionEngine.java delete lines 100-104 and replace with, suggestionEngine.loadDictionaryData(Paths.get( ClassLoader.getSystemResource("words.txt").getPath()));
- Also in SuggestionEngineTest.java, in all test methods replace the following
URI uri =  ClassLoader.getSystemResource("words.txt").toURI();
String mainPath = Paths.get(uri).toString();
Path path = Paths.get(mainPath);
suggestionEngine.loadDictionaryData(Paths.get(path.toUri()));

- with, suggestionEngine.loadDictionaryData( Path.of("words.txt"));
