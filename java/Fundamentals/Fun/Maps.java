// To use a HashMap we first need to create one:

import java.util.HashMap;
HashMap<String, String> userMap = new HashMap<>();

// Once you've created it you can put your key-value pairs into it:

userMap.put("nninja@codingdojo.com", "Nancy Ninja");
userMap.put("ssamurai@codingdojo.com", "Sam Samurai");

// And get them out:

String name = userMap.get("nninja@codingdojo.com");