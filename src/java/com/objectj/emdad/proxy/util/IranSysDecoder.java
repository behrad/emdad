package com.objectj.emdad.proxy.util;

/**
 * @author m_amoui
 */
public class IranSysDecoder {

    //public static final char ZWJ = 0x200D;
    //public static final char ZWNJ = 0x200C;
    public static final char ZWNJ = 0x0020;
    //public static final char ZWJ = 0x0020;

    /*
         decode with Reverse for farsi TEXT fields
    */
    public String decode( byte[] in ) {

        String out = new String();
        int c;
        boolean isEng = false;
        String tmp = new String();

        if ( in == null || in.length == 0 ) {
            return out;
        }

        for ( int j = 1; j <= in.length; j++ ) {
            c = in[ in.length - j ];

            if ( c < 0 ) {
                c += 256;
            }

            if ( c > 0 && c < 137 ) { // 32 = space ( 0x20 ) ( 127~137 is for farsi digit)
                isEng = true;
                tmp += (char) c;
            } else {
                if ( isEng ) {
                    for ( int k = 1; k <= tmp.length(); k++ ) {
                        int s = tmp.charAt( tmp.length() - k );
                        if ( iranSys[ s ].length > 0 ) {
                            out += iranSys[ s ][ 0 ];
                        }
                    }
                    isEng = false;
                    tmp = new String();
                }


                for ( int i = 0; i < iranSys[ c ].length; i++ ) {
                    if ( iranSys[ c ].length > 0 ) {
                        out += iranSys[ c ][ i ];
                    }
                }
            }
        }

        // to print last ENGLISH buffer
        if ( isEng && ( tmp != null ) && ( tmp.length() != 0 ) ) {
            for ( int k = 1; k <= tmp.length(); k++ ) {
                int s = tmp.charAt( tmp.length() - k );
                if ( iranSys[ s ].length > 0 ) {
                    out += iranSys[ s ][ 0 ];
                }
            }
        }

        ////=-= System.out.println(out.trim());
        return out.trim();
    }

    /*
     *  decode with No Reverse is appropriate for CODE fields
     */
    public String decodeNoReverse( byte[] in ) {
        String out = new String();
        int c;
        for ( int j = 0; j < in.length; j++ ) {
            // get char j from input iransys string
            c = in[ j ];

            // char is negetive due to char range ( -127 < c < 127 )
            // change it to ( 0 < i < 255 )
            if ( c < 0 ) {
                c += 256;
            }

            if ( iranSys[ c ].length > 0 ) {
                out += iranSys[ c ][ 0 ];
            }

        }
        return out.trim();
    }

    public static final char[][] iranSys = new char[][]{{0x0000} // <control>
                                                        , {
                                                            0x0001} // <control>
                                                        , {
                                                            0x0002} // <control>
                                                        , {
                                                            0x0003} // <control>
                                                        , {
                                                            0x0004} // <control>
                                                        , {
                                                            0x0005} // <control>
                                                        , {
                                                            0x0006} // <control>
                                                        , {
                                                            0x0007} // <control>
                                                        , {
                                                            0x0008} // <control>
                                                        , {
                                                            0x0009} // <control>
                                                        , {
                                                            0x000A} // <control>
                                                        , {
                                                            0x000B} // <control>
                                                        , {
                                                            0x000C} // <control>
                                                        , {
                                                            0x000D} // <control>
                                                        , {
                                                            0x000E} // <control>
                                                        , {
                                                            0x000F} // <control>
                                                        , {
                                                            0x0010} // <control>
                                                        , {
                                                            0x0011} // <control>
                                                        , {
                                                            0x0012} // <control>
                                                        , {
                                                            0x0013} // <control>
                                                        , {
                                                            0x0014} // <control>
                                                        , {
                                                            0x0015} // <control>
                                                        , {
                                                            0x0016} // <control>
                                                        , {
                                                            0x0017} // <control>
                                                        , {
                                                            0x0018} // <control>
                                                        , {
                                                            0x0019} // <control>
                                                        , {
                                                            0x001A} // <control>
                                                        , {
                                                            0x001B} // <control>
                                                        , {
                                                            0x001C} // <control>
                                                        , {
                                                            0x001D} // <control>
                                                        , {
                                                            0x001E} // <control>
                                                        , {
                                                            0x001F} // <control>
                                                        , {
                                                            0x0020} // SPACE
                                                        , {
                                                            0x0021} // EXCLAMATION MARK
                                                        , {
                                                            0x0022} // QUOTATION MARK
                                                        , {
                                                            0x0023} // NUMBER SIGN
                                                        , {
                                                            0x0024} // DOLLAR SIGN
                                                        , {
                                                            0x0025} // PERCENT SIGN
                                                        , {
                                                            0x0026} // AMPERSAND
                                                        , {
                                                            0x0027} // APOSTROPHE
                                                        , {
                                                            0x0028} // LEFT PARENTHESIS
                                                        , {
                                                            0x0029} // RIGHT PARENTHESIS
                                                        , {
                                                            0x002A} // ASTERISK
                                                        , {
                                                            0x002B} // PLUS SIGN
                                                        , {
                                                            0x002C} // COMMA
                                                        , {
                                                            0x002D} // HYPHEN-MINUS
                                                        , {
                                                            0x002E} // FULL STOP
                                                        , {
                                                            0x002F} // SOLIDUS
                                                        , {
                                                            0x0030} // DIGIT ZERO
                                                        , {
                                                            0x0031} // DIGIT ONE
                                                        , {
                                                            0x0032} // DIGIT TWO
                                                        , {
                                                            0x0033} // DIGIT THREE
                                                        , {
                                                            0x0034} // DIGIT FOUR
                                                        , {
                                                            0x0035} // DIGIT FIVE
                                                        , {
                                                            0x0036} // DIGIT SIX
                                                        , {
                                                            0x0037} // DIGIT SEVEN
                                                        , {
                                                            0x0038} // DIGIT EIGHT
                                                        , {
                                                            0x0039} // DIGIT NINE
                                                        , {
                                                            0x003A} // COLON
                                                        , {
                                                            0x003B} // SEMICOLON
                                                        , {
                                                            0x003C} // LESS-THAN SIGN
                                                        , {
                                                            0x003D} // EQUALS SIGN
                                                        , {
                                                            0x003E} // GREATER-THAN SIGN
                                                        , {
                                                            0x003F} // QUESTION MARK
                                                        , {
                                                            0x0040} // COMMERCIAL AT
                                                        , {
                                                            0x0041} // LATIN CAPITAL LETTER A
                                                        , {
                                                            0x0042} // LATIN CAPITAL LETTER B
                                                        , {
                                                            0x0043} // LATIN CAPITAL LETTER C
                                                        , {
                                                            0x0044} // LATIN CAPITAL LETTER D
                                                        , {
                                                            0x0045} // LATIN CAPITAL LETTER E
                                                        , {
                                                            0x0046} // LATIN CAPITAL LETTER F
                                                        , {
                                                            0x0047} // LATIN CAPITAL LETTER G
                                                        , {
                                                            0x0048} // LATIN CAPITAL LETTER H
                                                        , {
                                                            0x0049} // LATIN CAPITAL LETTER I
                                                        , {
                                                            0x004A} // LATIN CAPITAL LETTER J
                                                        , {
                                                            0x004B} // LATIN CAPITAL LETTER K
                                                        , {
                                                            0x004C} // LATIN CAPITAL LETTER L
                                                        , {
                                                            0x004D} // LATIN CAPITAL LETTER M
                                                        , {
                                                            0x004E} // LATIN CAPITAL LETTER N
                                                        , {
                                                            0x004F} // LATIN CAPITAL LETTER O
                                                        , {
                                                            0x0050} // LATIN CAPITAL LETTER P
                                                        , {
                                                            0x0051} // LATIN CAPITAL LETTER Q
                                                        , {
                                                            0x0052} // LATIN CAPITAL LETTER R
                                                        , {
                                                            0x0053} // LATIN CAPITAL LETTER S
                                                        , {
                                                            0x0054} // LATIN CAPITAL LETTER T
                                                        , {
                                                            0x0055} // LATIN CAPITAL LETTER U
                                                        , {
                                                            0x0056} // LATIN CAPITAL LETTER V
                                                        , {
                                                            0x0057} // LATIN CAPITAL LETTER W
                                                        , {
                                                            0x0058} // LATIN CAPITAL LETTER X
                                                        , {
                                                            0x0059} // LATIN CAPITAL LETTER Y
                                                        , {
                                                            0x005A} // LATIN CAPITAL LETTER Z
                                                        , {
                                                            0x005B} // LEFT SQUARE BRACKET
                                                        , {
                                                            0x005C} // REVERSE SOLIDUS
                                                        , {
                                                            0x005D} // RIGHT SQUARE BRACKET
                                                        , {
                                                            0x005E} // CIRCUMFLEX ACCENT
                                                        , {
                                                            0x005F} // LOW LINE
                                                        , {
                                                            0x0060} // GRAVE ACCENT
                                                        , {
                                                            0x0061} // LATIN SMALL LETTER A
                                                        , {
                                                            0x0062} // LATIN SMALL LETTER B
                                                        , {
                                                            0x0063} // LATIN SMALL LETTER C
                                                        , {
                                                            0x0064} // LATIN SMALL LETTER D
                                                        , {
                                                            0x0065} // LATIN SMALL LETTER E
                                                        , {
                                                            0x0066} // LATIN SMALL LETTER F
                                                        , {
                                                            0x0067} // LATIN SMALL LETTER G
                                                        , {
                                                            0x0068} // LATIN SMALL LETTER H
                                                        , {
                                                            0x0069} // LATIN SMALL LETTER I
                                                        , {
                                                            0x006A} // LATIN SMALL LETTER J
                                                        , {
                                                            0x006B} // LATIN SMALL LETTER K
                                                        , {
                                                            0x006C} // LATIN SMALL LETTER L
                                                        , {
                                                            0x006D} // LATIN SMALL LETTER M
                                                        , {
                                                            0x006E} // LATIN SMALL LETTER N
                                                        , {
                                                            0x006F} // LATIN SMALL LETTER O
                                                        , {
                                                            0x0070} // LATIN SMALL LETTER P
                                                        , {
                                                            0x0071} // LATIN SMALL LETTER Q
                                                        , {
                                                            0x0072} // LATIN SMALL LETTER R
                                                        , {
                                                            0x0073} // LATIN SMALL LETTER S
                                                        , {
                                                            0x0074} // LATIN SMALL LETTER T
                                                        , {
                                                            0x0075} // LATIN SMALL LETTER U
                                                        , {
                                                            0x0076} // LATIN SMALL LETTER V
                                                        , {
                                                            0x0077} // LATIN SMALL LETTER W
                                                        , {
                                                            0x0078} // LATIN SMALL LETTER X
                                                        , {
                                                            0x0079} // LATIN SMALL LETTER Y
                                                        , {
                                                            0x007A} // LATIN SMALL LETTER Z
                                                        , {
                                                            0x007B} // LEFT CURLY BRACKET
                                                        , {
                                                            0x007C} // VERTICAL LINE
                                                        , {
                                                            0x007D} // RIGHT CURLY BRACKET
                                                        , {
                                                            0x007E} // TILDE
                                                        , {
                                                            0x007E} // error dasht inno ezafe kardam
                                                        , {// convert all digits to english digits
                                                            0x0030} //0x06F0 } // EXTENDED ARABIC-INDIC DIGIT ZERO
                                                        , {
                                                            0x0031} //0x06F1 } // EXTENDED ARABIC-INDIC DIGIT ONE
                                                        , {
                                                            0x0032} //0x06F2 } // EXTENDED ARABIC-INDIC DIGIT TWO
                                                        , {
                                                            0x0033} //0x06F3 } // EXTENDED ARABIC-INDIC DIGIT THREE
                                                        , {
                                                            0x0034} //0x06F4 } // EXTENDED ARABIC-INDIC DIGIT FOUR
                                                        , {
                                                            0x0035} //0x06F5 } // EXTENDED ARABIC-INDIC DIGIT FIVE
                                                        , {
                                                            0x0036} //0x06F6 } // EXTENDED ARABIC-INDIC DIGIT SIX
                                                        , {
                                                            0x0037} //0x06F7 } // EXTENDED ARABIC-INDIC DIGIT SEVEN
                                                        , {
                                                            0x0038} //0x06F8 } // EXTENDED ARABIC-INDIC DIGIT EIGHT
                                                        , {
                                                            0x0039} //0x06F9 } // EXTENDED ARABIC-INDIC DIGIT NINE
                                                        , {
                                                            0x060C} // ARABIC COMMA
                                                        , {}
                                                        //0x0640 } // ARABIC TATWEEL
                                                        , {
                                                            0x061F} // ARABIC QUESTION MARK
                                                        , {
                                                            0x0622} // ARABIC LETTER ALEF WITH MADDA ABOVE, isolated form
                                                        , {
                                                            0x0626} // ARABIC LETTER YEH WITH HAMZA ABOVE, initial-medial form
                                                        , {
                                                            0x0621} // ARABIC LETTER HAMZA
                                                        , {
                                                            0x0627} // ARABIC LETTER ALEF, isolated form
                                                        , {
                                                            0x0627} // ARABIC LETTER ALEF, final form
                                                        , {
                                                            0x0628, ZWNJ} // ARABIC LETTER BEH, final-isolated form
                                                        , {
                                                            0x0628} // ARABIC LETTER BEH, initial-medial form
                                                        , {
                                                            0x067E, ZWNJ} // ARABIC LETTER PEH, final-isolated form
                                                        , {
                                                            0x067E} // ARABIC LETTER PEH, initial-medial form
                                                        , {
                                                            0x062A, ZWNJ} // ARABIC LETTER TEH, final-isolated form
                                                        , {
                                                            0x062A} // ARABIC LETTER TEH, initial-medial form
                                                        , {
                                                            0x062B, ZWNJ} // ARABIC LETTER THEH, final-isolated form
                                                        , {
                                                            0x062B} // ARABIC LETTER THEH, initial-medial form
                                                        , {
                                                            0x062C, ZWNJ} // ARABIC LETTER JEEM, final-isolated form
                                                        , {
                                                            0x062C} // ARABIC LETTER JEEM, initial-medial form
                                                        , {
                                                            0x0686, ZWNJ} // ARABIC LETTER TCHEH, final-isolated form
                                                        , {
                                                            0x0686} // ARABIC LETTER TCHEH, initial-medial form
                                                        , {
                                                            0x062D, ZWNJ} // ARABIC LETTER HAH, final-isolated form
                                                        , {
                                                            0x062D} // ARABIC LETTER HAH, initial-medial form
                                                        , {
                                                            0x062E, ZWNJ} // ARABIC LETTER KHAH, final-isolated form
                                                        , {
                                                            0x062E} // ARABIC LETTER KHAH, initial-medial form
                                                        , {
                                                            0x062F} // ARABIC LETTER DAL
                                                        , {
                                                            0x0630} // ARABIC LETTER THAL
                                                        , {
                                                            0x0631} // ARABIC LETTER REH
                                                        , {
                                                            0x0632} // ARABIC LETTER ZAIN
                                                        , {
                                                            0x0698} // ARABIC LETTER JEH
                                                        , {
                                                            0x0633, ZWNJ} // ARABIC LETTER SEEN, final-isolated form
                                                        , {
                                                            0x0633} // ARABIC LETTER SEEN, initial-medial form
                                                        , {
                                                            0x0634, ZWNJ} // ARABIC LETTER SHEEN, final-isolated form
                                                        , {
                                                            0x0634} // ARABIC LETTER SHEEN, initial-medial form
                                                        , {
                                                            0x0635, ZWNJ} // ARABIC LETTER SAD, final-isolated form
                                                        , {
                                                            0x0635} // ARABIC LETTER SAD, initial-medial form
                                                        , {
                                                            0x0636, ZWNJ} // ARABIC LETTER DAD, final-isolated form
                                                        , {
                                                            0x0636} // ARABIC LETTER DAD, initial-medial form
                                                        , {
                                                            0x0637} // ARABIC LETTER TAH
                                                        , {
                                                            0x2591} // LIGHT SHADE
                                                        , {
                                                            0x2592} // MEDIUM SHADE
                                                        , {
                                                            0x2593} // DARK SHADE
                                                        , {
                                                            0x2502} // BOX DRAWINGS LIGHT VERTICAL
                                                        , {
                                                            0x2524} // BOX DRAWINGS LIGHT VERTICAL AND LEFT
                                                        , {
                                                            0x2561} // BOX DRAWINGS VERTICAL SINGLE AND LEFT DOUBLE
                                                        , {
                                                            0x2562} // BOX DRAWINGS VERTICAL DOUBLE AND LEFT SINGLE
                                                        , {
                                                            0x2556} // BOX DRAWINGS DOWN DOUBLE AND LEFT SINGLE
                                                        , {
                                                            0x2555} // BOX DRAWINGS DOWN SINGLE AND LEFT DOUBLE
                                                        , {
                                                            0x2563} // BOX DRAWINGS DOUBLE VERTICAL AND LEFT
                                                        , {
                                                            0x2551} // BOX DRAWINGS DOUBLE VERTICAL
                                                        , {
                                                            0x2557} // BOX DRAWINGS DOUBLE DOWN AND LEFT
                                                        , {
                                                            0x255D} // BOX DRAWINGS DOUBLE UP AND LEFT
                                                        , {
                                                            0x255C} // BOX DRAWINGS UP DOUBLE AND LEFT SINGLE
                                                        , {
                                                            0x255B} // BOX DRAWINGS UP SINGLE AND LEFT DOUBLE
                                                        , {
                                                            0x2510} // BOX DRAWINGS LIGHT DOWN AND LEFT
                                                        , {
                                                            0x2514} // BOX DRAWINGS LIGHT UP AND RIGHT
                                                        , {
                                                            0x2534} // BOX DRAWINGS LIGHT UP AND HORIZONTAL
                                                        , {
                                                            0x252C} // BOX DRAWINGS LIGHT DOWN AND HORIZONTAL
                                                        , {
                                                            0x251C} // BOX DRAWINGS LIGHT VERTICAL AND RIGHT
                                                        , {
                                                            0x2500} // BOX DRAWINGS LIGHT HORIZONTAL
                                                        , {
                                                            0x253C} // BOX DRAWINGS LIGHT VERTICAL AND HORIZONTAL
                                                        , {
                                                            0x255E} // BOX DRAWINGS VERTICAL SINGLE AND RIGHT DOUBLE
                                                        , {
                                                            0x255F} // BOX DRAWINGS VERTICAL DOUBLE AND RIGHT SINGLE
                                                        , {
                                                            0x255A} // BOX DRAWINGS DOUBLE UP AND RIGHT
                                                        , {
                                                            0x2554} // BOX DRAWINGS DOUBLE DOWN AND RIGHT
                                                        , {
                                                            0x2569} // BOX DRAWINGS DOUBLE UP AND HORIZONTAL
                                                        , {
                                                            0x2566} // BOX DRAWINGS DOUBLE DOWN AND HORIZONTAL
                                                        , {
                                                            0x2560} // BOX DRAWINGS DOUBLE VERTICAL AND RIGHT
                                                        , {
                                                            0x2550} // BOX DRAWINGS DOUBLE HORIZONTAL
                                                        , {
                                                            0x256C} // BOX DRAWINGS DOUBLE VERTICAL AND HORIZONTAL
                                                        , {
                                                            0x2567} // BOX DRAWINGS UP SINGLE AND HORIZONTAL DOUBLE
                                                        , {
                                                            0x2568} // BOX DRAWINGS UP DOUBLE AND HORIZONTAL SINGLE
                                                        , {
                                                            0x2564} // BOX DRAWINGS DOWN SINGLE AND HORIZONTAL DOUBLE
                                                        , {
                                                            0x2565} // BOX DRAWINGS DOWN DOUBLE AND HORIZONTAL SINGLE
                                                        , {
                                                            0x2559} // BOX DRAWINGS UP DOUBLE AND RIGHT SINGLE
                                                        , {
                                                            0x2558} // BOX DRAWINGS UP SINGLE AND RIGHT DOUBLE
                                                        , {
                                                            0x2552} // BOX DRAWINGS DOWN SINGLE AND RIGHT DOUBLE
                                                        , {
                                                            0x2553} // BOX DRAWINGS DOWN DOUBLE AND RIGHT SINGLE
                                                        , {
                                                            0x256B} // BOX DRAWINGS VERTICAL DOUBLE AND HORIZONTAL SINGLE
                                                        , {
                                                            0x256A} // BOX DRAWINGS VERTICAL SINGLE AND HORIZONTAL DOUBLE
                                                        , {
                                                            0x2518} // BOX DRAWINGS LIGHT UP AND LEFT
                                                        , {
                                                            0x250C} // BOX DRAWINGS LIGHT DOWN AND RIGHT
                                                        , {
                                                            0x2588} // FULL BLOCK
                                                        , {
                                                            0x2584} // LOWER HALF BLOCK
                                                        , {
                                                            0x258C} // LEFT HALF BLOCK
                                                        , {
                                                            0x2590} // RIGHT HALF BLOCK
                                                        , {
                                                            0x2580} // UPPER HALF BLOCK
                                                        , {
                                                            0x0638} // ARABIC LETTER ZAH
                                                        , {
                                                            0x0639, ZWNJ} // ARABIC LETTER AIN, isolated form
                                                        , {
                                                            0x0639, ZWNJ} // ARABIC LETTER AIN, final form
                                                        , {
                                                            0x0639} // ARABIC LETTER AIN, medial form
                                                        , {
                                                            0x0639} // ARABIC LETTER AIN, initial form
                                                        , {
                                                            0x063A, ZWNJ} // ARABIC LETTER GHAIN, isolated form
                                                        , {
                                                            0x063A, ZWNJ} // ARABIC LETTER GHAIN, final form
                                                        , {
                                                            0x063A} // ARABIC LETTER GHAIN, medial form
                                                        , {
                                                            0x063A} // ARABIC LETTER GHAIN, initial form
                                                        , {
                                                            0x0641, ZWNJ} // ARABIC LETTER FEH, final-isolated form
                                                        , {
                                                            0x0641} // ARABIC LETTER FEH, initial-medial form
                                                        , {
                                                            0x0642, ZWNJ} // ARABIC LETTER QAF, final-isolated form
                                                        , {
                                                            0x0642} // ARABIC LETTER QAF, initial-medial form
                                                        , {
                                                            0x0643, ZWNJ} // ARABIC LETTER KEHEH, final-isolated form
                                                        , {
                                                            0x0643} // ARABIC LETTER KEHEH, initial-medial form
                                                        , {
                                                            0x06AF, ZWNJ} // ARABIC LETTER GAF, final-isolated form
                                                        , {
                                                            0x06AF} // ARABIC LETTER GAF, initial-medial form
                                                        , {
                                                            0x0644, ZWNJ} // ARABIC LETTER LAM, final-isolated form
                                                        , {
                                                            0x0644, 0x0627} // ARABIC LIGATURE LAM WITH ALEF
                                                        , {
                                                            0x0644} // ARABIC LETTER LAM, initial-medial form
                                                        , {
                                                            0x0645, ZWNJ} // ARABIC LETTER MEEM, final-isolated form
                                                        , {
                                                            0x0645} // ARABIC LETTER MEEM, initial-medial form
                                                        , {
                                                            0x0646, ZWNJ} // ARABIC LETTER NOON, final-isolated form
                                                        , {
                                                            0x0646} // ARABIC LETTER NOON, initial-medial form
                                                        , {
                                                            0x0648} // ARABIC LETTER WAW
                                                        , {
                                                            0x0647, ZWNJ} // ARABIC LETTER HEH, final-isolated form
                                                        , {
                                                            0x0647} // ARABIC LETTER HEH, medial form
                                                        , {
                                                            0x0647} // ARABIC LETTER HEH, initial form
                                                        , {
                                                            // we'll use arabic letter YEH ( 0x064a ) instead of farsi YEH
                                                            //0x06CC, ZWNJ } // ARABIC LETTER FARSI YEH, final form
                                                            0x064A, ZWNJ} // ARABIC LETTER FARSI YEH, final form
                                                        , {
                                                            //0x06CC, ZWNJ } // ARABIC LETTER FARSI YEH, isolated form
                                                            0x064A, ZWNJ} // ARABIC LETTER FARSI YEH, isolated form
                                                        , {
                                                            //0x06CC } // ARABIC LETTER FARSI YEH, initial-medial form
                                                            0x064A} // ARABIC LETTER FARSI YEH, initial-medial form
                                                        , {
                                                            0x00A0} // NO-BREAK SPACE

    };
}
