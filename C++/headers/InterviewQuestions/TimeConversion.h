//
// Created by sreeise on 5/22/19.
//

#ifndef C___TIMECONVERSION_H
#define C___TIMECONVERSION_H
#include <sstream>
using namespace std;
/*
 Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.

 Example: 07:05:45PM
 Answer: 19:05:45
 */
class TimeConversion {
public:
    static void timeConversion(string s) {
      int n = s.length();
      int hh, mm, ss;
      hh = (s[0] - '0') * 10 + (s[1] - '0');
      mm = (s[3] - '0') * 10 + (s[4] - '0');
      ss = (s[6] - '0') * 10 + (s[7] - '0');

      if (hh < 12 && s[8] == 'P') hh += 12;
      if (hh == 12 && s[8] == 'A') hh = 0;
      printf("%02d:%02d:%02d", hh, mm, ss);
    }
};

#endif //C___TIMECONVERSION_H
