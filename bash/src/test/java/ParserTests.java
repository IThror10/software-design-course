import org.example.ast.concrete.UnresolvedCommandExpression;
import org.example.interfaces.IParser;
import org.example.parsing.Parser;
import org.example.parsing.exception.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ParserTests {
    static final IParser PARSER = new Parser();
    
    
    @Test
    void testParseString_Simple() {
        assertAll(
                () -> assertEquals(
                        new UnresolvedCommandExpression("pwd"),
                        PARSER.parse("pwd"),
                        "no spaces"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("echo a"),
                        PARSER.parse("echo a"),
                        "1 space"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("mv -f loc1 loc2"),
                        PARSER.parse("mv -f loc1 loc2"),
                        "multiple spaces"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("echo a"),
                        PARSER.parse("echo \t \t a"),
                        "tabs"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("echo a"),
                        PARSER.parse("echo\t \t \t a"),
                        "fst space is tab"
                )
        );
    }
    
    
    @Test
    void testParseString_Spaces() {
        assertAll(
                () -> assertEquals(
                        new UnresolvedCommandExpression("pwd"),
                        PARSER.parse("pwd "),
                        "right trim"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("pwd"),
                        PARSER.parse(" pwd"),
                        "left trim"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("pwd"),
                        PARSER.parse(" pwd "),
                        "both trims"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("pwd"),
                        PARSER.parse("   pwd  "),
                        "large trims"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("echo a"),
                        PARSER.parse("echo   a"),
                        "inner trim"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("mv -f loc1 loc2"),
                        PARSER.parse("mv   -f  loc1 loc2"),
                        "inner trims"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("echo '   '"),
                        PARSER.parse("echo '   '"),
                        "no trims in single quotes"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("echo \"   \""),
                        PARSER.parse("echo \"   \""),
                        "no trims in double quotes"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("( )"),
                        PARSER.parse("(   )"),
                        "trims in parens"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("{ }"),
                        PARSER.parse("{   }"),
                        "trims in braces"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("cmd { ( ) } '   \"  ' -a \"  '   \" -f1 -c22 3"),
                        PARSER.parse("  cmd  {  (   )   }   '   \"  '    -a  \"  '   \"   -f1  -c22   3 "),
                        "hard"
                )
        );
    }
    
    
    @Test
    void testParseString_Quotes() {
        assertAll(
                () -> assertEquals(
                        new UnresolvedCommandExpression("''"),
                        PARSER.parse("''"),
                        "single"
                ),
                () -> assertEquals(
                        "Mismatched parentheses / braces / quotes in \"'\"",
                        assertThrows(ParseException.class, () -> PARSER.parse("'")).getMessage(),
                        "one single"
                ),
                () -> assertEquals(
                        "Mismatched parentheses / braces / quotes in \"'''\"",
                        assertThrows(ParseException.class, () -> PARSER.parse("'''")).getMessage(),
                        "three single"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("\"\""),
                        PARSER.parse("\"\""),
                        "double"
                ),
                () -> assertEquals(
                        "Mismatched parentheses / braces / quotes in \"\"\"",
                        assertThrows(ParseException.class, () -> PARSER.parse("\"")).getMessage(),
                        "one double"
                ),
                () -> assertEquals(
                        "Mismatched parentheses / braces / quotes in \"\"\"\"\"",
                        assertThrows(ParseException.class, () -> PARSER.parse("\"\"\"")).getMessage(),
                        "three double"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("\"'\""),
                        PARSER.parse("\"'\""),
                        "single in double"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("\"''\""),
                        PARSER.parse("\"''\""),
                        "two single in double"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("\"'''\""),
                        PARSER.parse("\"'''\""),
                        "three single in double"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("'\"'"),
                        PARSER.parse("'\"'"),
                        "double in single"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("'\"\"'"),
                        PARSER.parse("'\"\"'"),
                        "two double in single"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("'\"\"\"'"),
                        PARSER.parse("'\"\"\"'"),
                        "three double in single"
                )
        );
    }
    
    
    @Test
    void testParseString_Parens() {
        assertAll(
                () -> assertEquals(
                        new UnresolvedCommandExpression("()"),
                        PARSER.parse("()"),
                        "one pair"
                ),
                () -> assertEquals(
                        "Mismatched parentheses / braces / quotes in \"(\"",
                        assertThrows(ParseException.class, () -> PARSER.parse("(")).getMessage(),
                        "only ("
                ),
                () -> assertEquals(
                        "Mismatched parentheses / braces / quotes in \")\"",
                        assertThrows(ParseException.class, () -> PARSER.parse(")")).getMessage(),
                        "only )"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("(())"),
                        PARSER.parse("(())"),
                        "parens in parens"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("()()"),
                        PARSER.parse("()()"),
                        "parens parens"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("()(smth)"),
                        PARSER.parse("()(smth)"),
                        "parens parens w/ smth"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("(()())()((()))(())"),
                        PARSER.parse("(()())()((()))(())"),
                        "many parens"
                ),
                () -> assertEquals(
                        "Mismatched parentheses / braces / quotes in \"()())()((()))(())\"",
                        assertThrows(ParseException.class, () -> PARSER.parse("()())()((()))(())")).getMessage(),
                        "many parens but not enough (first)"
                ),
                () -> assertEquals(
                        "Mismatched parentheses / braces / quotes in \"(()())()((()))(()\"",
                        assertThrows(ParseException.class, () -> PARSER.parse("(()())()((()))(()")).getMessage(),
                        "many parens but not enough (last)"
                ),
                () -> assertEquals(
                        "Mismatched parentheses / braces / quotes in \"(()())()(()))(())\"",
                        assertThrows(ParseException.class, () -> PARSER.parse("(()())()(()))(())")).getMessage(),
                        "many parens but not enough (inside)"
                )
        );
    }
    
    
    @Test
    void testParseString_Braces() {
        assertAll(
                () -> assertEquals(
                        new UnresolvedCommandExpression("{}"),
                        PARSER.parse("{}"),
                        "one pair"
                ),
                () -> assertEquals(
                        "Mismatched parentheses / braces / quotes in \"{\"",
                        assertThrows(ParseException.class, () -> PARSER.parse("{")).getMessage(),
                        "only {"
                ),
                () -> assertEquals(
                        "Mismatched parentheses / braces / quotes in \"}\"",
                        assertThrows(ParseException.class, () -> PARSER.parse("}")).getMessage(),
                        "only }"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("{{}}"),
                        PARSER.parse("{{}}"),
                        "braces in braces"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("{}{}"),
                        PARSER.parse("{}{}"),
                        "braces braces"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("{smth}{smth else}"),
                        PARSER.parse("{smth}{smth else}"),
                        "braces braces w/ smth"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("{{}{}}{}{{{}}}{{}}"),
                        PARSER.parse("{{}{}}{}{{{}}}{{}}"),
                        "many braces"
                ),
                () -> assertEquals(
                        "Mismatched parentheses / braces / quotes in \"{}{}}{}{{{}}}{{}}\"",
                        assertThrows(ParseException.class, () -> PARSER.parse("{}{}}{}{{{}}}{{}}")).getMessage(),
                        "many braces but not enough (first)"
                ),
                () -> assertEquals(
                        "Mismatched parentheses / braces / quotes in \"{{}{}}{}{{{}}}{{}\"",
                        assertThrows(ParseException.class, () -> PARSER.parse("{{}{}}{}{{{}}}{{}")).getMessage(),
                        "many braces but not enough (last)"
                ),
                () -> assertEquals(
                        "Mismatched parentheses / braces / quotes in \"{{}{}}{}{{}}}{{}}\"",
                        assertThrows(ParseException.class, () -> PARSER.parse("{{}{}}{}{{}}}{{}}")).getMessage(),
                        "many braces but not enough (inside)"
                )
        );
    }
    
    
    @Test
    void testParseString_ParensAndBraces() {
        assertAll(
                () -> assertEquals(
                        new UnresolvedCommandExpression("({})"),
                        PARSER.parse("({})"),
                        "braces in parens"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("{()}"),
                        PARSER.parse("{()}"),
                        "parens in braces"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("{}(){}()()"),
                        PARSER.parse("{}(){}()()"),
                        "train"
                ),
                () -> assertEquals(
                        new UnresolvedCommandExpression("({()}{()})({}){()}{(())({})}"),
                        PARSER.parse("({()}{()})({}){()}{(())({})}"),
                        "one more train"
                ),
                () -> assertEquals(
                        "Mismatched parentheses / braces / quotes in \"{}(){()()\"",
                        assertThrows(ParseException.class, () -> PARSER.parse("{}(){()()")).getMessage(),
                        "broken train"
                ),
                () -> assertEquals(
                        "Mismatched parentheses / braces / quotes in \"({()}{()})({}){()}{(()){})}\"",
                        assertThrows(ParseException.class, () -> PARSER.parse("({()}{()})({}){()}{(()){})}"))
                                .getMessage(),
                        "another broken train"
                )
        );
    }
    
    
    @Test
    void testParseString_Everything() {
        assertEquals(
                new UnresolvedCommandExpression("cmd1 -f \"  ' \" -t '\"' -u { a (0 + 1 \\ {}) }"),
                assertDoesNotThrow(() ->
                        PARSER.parse(" \t cmd1 \n  -f \"  ' \" \r  -t '\"' -u \t\n {   a (0 +    1  \\ {}) } ")
                )
        );
    }
}
