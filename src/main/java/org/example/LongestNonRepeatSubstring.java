package org.example;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LongestNonRepeatSubstring {

    public int lengthOfLongestSubstring(String s) {

        int maxCount = 0;
        LinkedHashSet<Character> characters = new LinkedHashSet<>();
        for(char letter : s.toCharArray()) {
            if (characters.contains(letter)) {
                maxCount = Math.max(maxCount, characters.size());

                Iterator<Character> characterIterator = characters.iterator();

                while (characterIterator.hasNext()) {
                    Character character = characterIterator.next();
                    boolean needBreak = character.equals(letter);
                    characterIterator.remove();
                    if (needBreak) {
                        break;
                    }
                }

            }

            characters.add(letter);
        }

        return Math.max(maxCount, characters.size());
    }
}
