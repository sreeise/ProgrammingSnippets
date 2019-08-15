package tests;

import interview_questions.arrays.ReorderLogFiles;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReorderLogFilesTest {
  private String[] logs = {
        "6p tzwmh ige mc",
        "ns 566543603829",
        "ubd cujg j d yf",
        "ha6 1 938 376 5",
        "3yx 97 666 56 5",
        "d 84 34353 2249",
        "0 tllgmf qp znc",
        "s 1088746413789",
        "ys0 splqqxoflgx",
        "uhb rfrwt qzx r",
        "u lrvmdt ykmox",
        "ah4 4209164350",
        "rap 7729 8 125",
        "4 nivgc qo z i",
        "apx 814023338 8"
  };

  private String[] ans = {
        "ubd cujg j d yf",
        "u lrvmdt ykmox",
        "4 nivgc qo z i",
        "uhb rfrwt qzx r",
        "ys0 splqqxoflgx",
        "0 tllgmf qp znc",
        "6p tzwmh ige mc",
        "ns 566543603829",
        "ha6 1 938 376 5",
        "3yx 97 666 56 5",
        "d 84 34353 2249",
        "s 1088746413789",
        "ah4 4209164350",
        "rap 7729 8 125",
        "apx 814023338 8"
  };

  @Test
  public void reorderLogFilesTest() {
    assertEquals(ReorderLogFiles.reorder(logs), ans);
  }
}
