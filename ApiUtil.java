// Source code is decompiled from a .class file using FernFlower decompiler.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ApiUtil {
   private static final String API_URL = "https://rickandmortyapi.com/api/character/";

   public ApiUtil() {
   }

   public static Character getCharacterById(int id) throws Exception {
      String urlString = "https://rickandmortyapi.com/api/character/" + id;
      URL url = new URL(urlString);
      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
      conn.setRequestMethod("GET");
      if (conn.getResponseCode() != 200) {
         throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
      } else {
         try {
            Throwable var4 = null;
            Object var5 = null;

            try {
               BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

               try {
                  StringBuilder output = new StringBuilder();

                  String line;
                  while((line = br.readLine()) != null) {
                     output.append(line);
                  }

                  Character var10 = parseCharacter(output.toString());
                  return var10;
               } finally {
                  if (br != null) {
                     br.close();
                  }

               }
            } catch (Throwable var21) {
               if (var4 == null) {
                  var4 = var21;
               } else if (var4 != var21) {
                  var4.addSuppressed(var21);
               }

               throw var4;
            }
         } finally {
            conn.disconnect();
         }
      }
   }

   private static Character parseCharacter(String json) {
      Character character = new Character();
      character.id = Integer.parseInt(getValue(json, "id"));
      character.name = getValue(json, "name");
      character.status = getValue(json, "status");
      character.species = getValue(json, "species");
      character.type = getValue(json, "type");
      character.gender = getValue(json, "gender");
      String originJson = getValue(json, "origin");
      character.origin = new Character$Origin();
      character.origin.name = getValue(originJson, "name");
      character.origin.url = getValue(originJson, "url");
      String locationJson = getValue(json, "location");
      character.location = new Character$Location();
      character.location.name = getValue(locationJson, "name");
      character.location.url = getValue(locationJson, "url");
      character.image = getValue(json, "image");
      parseEpisodes(character, json);
      character.url = getValue(json, "url");
      character.created = getValue(json, "created");
      return character;
   }

   private static void parseEpisodes(Character character, String json) {
      String episodeString = getValue(json, "episode");
      if (episodeString.startsWith("[") && episodeString.endsWith("]")) {
         episodeString = episodeString.substring(1, episodeString.length() - 1);
         String[] episodes = episodeString.split(",");
         character.episode = new ArrayList();
         String[] var7 = episodes;
         int var6 = episodes.length;

         for(int var5 = 0; var5 < var6; ++var5) {
            String episode = var7[var5];
            character.episode.add(episode.trim());
         }
      }

   }

   private static String getValue(String json, String key) {
      String searchKey = "\"" + key + "\":";
      int startIndex = json.indexOf(searchKey);
      if (startIndex == -1) {
         throw new IllegalArgumentException("Key \"" + key + "\" not found in JSON.");
      } else {
         for(startIndex += searchKey.length(); startIndex < json.length() && json.charAt(startIndex) == ' '; ++startIndex) {
         }

         char firstChar = json.charAt(startIndex);
         int endIndex;
         if (firstChar == '"') {
            for(endIndex = json.indexOf("\"", startIndex + 1); endIndex != -1 && json.charAt(endIndex - 1) == '\\'; endIndex = json.indexOf("\"", endIndex + 1)) {
            }

            if (endIndex == -1) {
               throw new IllegalArgumentException("Could not find closing quote for key \"" + key + "\".");
            } else {
               return json.substring(startIndex + 1, endIndex).trim();
            }
         } else {
            if (firstChar != '{' && firstChar != '[') {
               endIndex = json.indexOf(",", startIndex);
               if (endIndex == -1) {
                  endIndex = json.indexOf("}", startIndex);
               }

               if (endIndex == -1) {
                  throw new IllegalArgumentException("Could not find end of value for key \"" + key + "\".");
               }
            } else {
               endIndex = findClosingBracket(json, startIndex);
            }

            return json.substring(startIndex, endIndex).trim();
         }
      }
   }

   private static int findClosingBracket(String json, int startIndex) {
      int bracketCount = 0;

      for(int i = startIndex; i < json.length(); ++i) {
         if (json.charAt(i) != '{' && json.charAt(i) != '[') {
            if (json.charAt(i) == '}' || json.charAt(i) == ']') {
               --bracketCount;
               if (bracketCount == 0) {
                  return i + 1;
               }
            }
         } else {
            ++bracketCount;
         }
      }

      throw new IllegalArgumentException("Could not find closing bracket for JSON object or array.");
   }
}
