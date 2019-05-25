package interview_questions.arrays;

public class BreakingRecords {
  /*
  Maria plays college basketball and wants to go pro. Each season she maintains a record of her play.
  She tabulates the number of times she breaks her season record for most points and least points in a game.
  Points scored in the first game establish her record for the season, and she begins counting from there.

  Given Maria's scores for a season, find and print the number of times she breaks her records for most and
  least points scored during the season.

  Example: Maria's scores for each game are  [10, 5, 20, 20, 4, 5, 2, 25, 1]
  The starting score for her games are:
    1. lowest score: 10
    2. highest score: 10

  She broke her best record twice (after games 2 and 7) and her worst record four times (after games
  1, 4, 6, and 8), so we print 2 4 as our answer. Note that she did not break her record for best
  score during game, as her score during that game was not strictly greater than her best record at the time.
   */

  public static int[] breakingRecords(int[] scores) {
    int highest = 0;
    int lowest = 0;
    int[] records = {0, 0};

    for (int i = 0; i < scores.length; i++) {
      if (i == 0) {
        lowest = scores[i];
        highest = scores[i];
      } else {
        if (scores[i] < lowest) {
          lowest = scores[i];
          records[1] = records[1] + 1;
        } else if (scores[i] > highest) {
          highest = scores[i];
          records[0] = records[0] + 1;
        }
      }
    }
    return records;
  }
}
