# Common regular expression characters.
    
    .  Any character except a newline

    \d  Any digit, including non-ASCII digits (for example, Arabic)

    \D  Any non-digit

    [A-Za-z0-9]  Any character of the alphabet or any digit

    \w  Any alphanumeric character, usually including underscores and periods

    \W  Any character not in the class 
    
    \s  Any whitespace character, including spaces, tabs, and sometimes also 
            newlines (depending on which modifiers are used)

    \S  Any character not in the class \s

    *  Match 0 or more tiems
    
    +  Match 1 or more times
    
    ?  Match 1 or 0 times
    
    {n}  Match exactly n times
    
    {n,}  Match at least n times
    
    {n,m}  Match at least n but not more than m times
