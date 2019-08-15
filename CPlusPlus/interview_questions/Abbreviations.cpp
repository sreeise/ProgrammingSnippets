#include <iostream>
using namespace std;

class Abbreviation {
/*
You can perform the following operations on the string, a:

  1. Capitalize zero or more of a's lowercase letters.
  2. Delete all of the remaining lowercase letters in a.

Given two strings, a and b, determine if it's possible to make a equal to b as described.
If so, print YES on a new line. Otherwise, print NO.

String a consists only of uppercase and lowercase English letters, ascii[A-Za-z].
String b consists only of uppercase English letters, ascii[A-Z].
*/

public:
    static bool isUpcase(char c){
      return (c >= 'A') && (c <= 'Z');
    }

    static char upcase(char c){
      if (isUpcase(c)) return c;
      return (char)(c - 32);
    }

    static void abbreviation(string s1, string s2) {
      bool dp[1011][1011];
      for (int i = 0; i < s1.length(); i++) {
        for (int j = 0; j < s2.length(); j++) {
          dp[i][j] = false;
        }
      }
      dp[0][0] = true;

      for (int i = 0; i < s1.length(); i++){
        for (int j = 0; j <= s2.length(); j++) {
          if (dp[i][j]) {
            if(j < s2.length() && (upcase(s1[i]) == s2[j])) {
              dp[i + 1][j + 1] = true;
            }

            if(!isUpcase(s1[i])) {
              dp[i + 1][j] = true;
            }
          }
        }
      }

      if (dp[s1.length()][s2.length()]) cout << "YES" << endl; else cout << "NO" << endl;
    }
};

