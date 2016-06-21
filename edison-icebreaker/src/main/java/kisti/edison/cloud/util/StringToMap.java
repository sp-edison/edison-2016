package kisti.edison.cloud.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: it-bubbles.blogspot.com, bubbles.way@gmail.com
 * Date: 20090105
 * $Date: 2009-02-13 05:46:08 +0900 (2009-02-13, 금) $
 * $Revision: 8 $
 * $Author: bubbles.way $
 */

/**
 * Utility class with support of mapping of character array to map.
 */
public final class StringToMap {
        /**
         * Key that is used for string item without key.
         */
        public static final String MAIN_KEY = "#main#"; // default key, if item has no key

        /**
         * default item separator character.
         */
        private static final char DEFAULT_ITEM_SEPARATOR = '|';

        /**
         * default key separator character.
         */
        private static final char DEFAULT_KEY_SEPARATOR = ':';

        /**
         * default escape separator.
         */
        private static final char DEFAULT_ESCAPE_CHARACTER = '&';

        /**
         * Convert array of characters (string) to map.
         * The individual map items separated by iSep, key/value in each item is separated by keySep.
         * Escape character is used to specify iSep or keySep in character array.
         * E.g.: "key1:value1|key2:value2" will be converted to map of size 2 with content: ["key1":"value1", "key2":"value2"]
         * One item can be without key, in this case it will be mapped under 'MAIN_KEY' key
         *
         * @param string the character array representing string to be converted
         * @param iSep   item separator character
         * @param keySep key separator character
         * @param escape escpae character
         * @return Map representing map mapping of given character array or empty map.
         * @see cz.atlas.bubbles.it.stringtomap.StringToMap#MAIN_KEY
         */
        public static Map toMap(final char[] string, final char iSep,
                                final char keySep, final char escape) {
                final HashMap retVal = new HashMap();
                int ikey1 = 0, ikey2 = -1;
                int ival1 = 0, ival2 = -1;
                boolean wasEscape = false;
                for (int i = 0; i < string.length; i++) {
                        if (string[i] == escape) {
                                wasEscape = true; // remember there was at leas on escape
                                i++; // skip char that is being escaped
                                continue;
                        }
                        if ((string[i] == keySep) && (ikey2 < 0)) { // process this only if we have not found key yet
                                ikey2 = i; // remember position of key separator
                                ival1 = i + 1; // values should start at next position
                        }
                        if (string[i] == iSep) {
                                ival2 = i; //remember position of value separator
                        } else {
                                if (i == string.length - 1) {  //end of string?
                                        ival2 = string.length;
                                }
                        }
                        if (ival2 > ival1) { // we have found value
                                String key;
                                if (ikey2 <= ikey1) { //value without key
                                        key = MAIN_KEY;
                                } else {
                                        key = new String(string, ikey1, ikey2 - ikey1);
                                }
                                final String value = new String(string, ival1, ival2 - ival1);
                                if (wasEscape) {
                                        removeCharacter(key, escape);
                                        removeCharacter(value, escape);
                                        wasEscape = false;
                                }
                                ikey1 = i + 1; // next key should start at next position
                                ikey2 = -1;
                                ival1 = ikey1;
                                ival2 = -1;
                                retVal.put(key, value);
                        }
                }
                return retVal;
        }

        /**
         * Convert array of characters (string) to map.
         * The individual map items separated by defaultSeparator, key/value in each item is separated by defaultKeySeparator.
         * Escape character used is defaultEscape
         *
         * @param chars array of characters (String) to be converted to map
         * @return Map mpa representation of the passed array of characters
         * @see StringToMap#toMap(char[], char, char, char)
         */
        public static Map toMap(final char[] chars) {
                return toMap(chars, DEFAULT_ITEM_SEPARATOR, DEFAULT_KEY_SEPARATOR, DEFAULT_ESCAPE_CHARACTER);
        }

        /**
         * Remove all occurences of (escape) character in the string.
         * This helper method was inspired by http://www.rgagnon.com/javadetails/java-0030.html
         *
         * @param s string to remove character from
         * @param c character to be removed from the string
         * @return the string with all occurences of the character removed
         */
        private static String removeCharacter(final String s, final char c) {
                final StringBuffer buffer = new StringBuffer();
                for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == c) {
                                if (i == s.length() - 1) {
                                        break;  // end of string
                                }
                                i++; // skip escape, but preserve if double escape
                        }
                        buffer.append(s.charAt(i));
                }
                return buffer.toString();
        }
}


