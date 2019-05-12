import unittest

"""
  Lena is preparing for an important coding competition that is preceded by a number of sequential preliminary
  contests. She believes in "saving luck", and wants to check her theory. Each contest is described by two
  integers, L[i] and L[j].

  L[i] is the amount of luck associated with a contest. If Lena wins the contest, her luck balance
  will decrease by L[i] if she loses it, her luck balance will increase by L[i].

  T[i] denotes the contest's importance rating. It's equal to 1 if the contest is important, and it's equal
  to 0 if it's unimportant.

  If Lena loses no more than k important contests, what is the maximum amount of luck she can have after
  competing in all the preliminary contests? This value may be negative.

  For example, k = 2, and:

  Contest		 L[i]	T[i]
    1		      5	     1
    2		      1	     1
    3		      4	     0

  If Lena loses all of the contests, her luck will be 5 + 1 + 4 = 10.  Since she is allowed to lose 2 important
  contests, and there are only important contests. She can lose all three contests to maximize her luck at 10.

  If k = 1, she has to win at least of the important contests. She would choose to win the lowest value
  important contest worth 1. Her final luck will be 5 + 4 - 1 = 8.
"""


def luck_balance(k, contests):
    important_list = []
    luck_count = 0
    for i in range(len(contests)):
        if contests[i][1] == 1:
            important_list.append(contests[i][0])
        else:
            luck_count += contests[i][0]

    important_list.sort()
    lowest_to_lose = len(important_list) - k

    for i in range(len(important_list)):
        if i < lowest_to_lose:
            luck_count -= important_list[i]
        else:
            luck_count += important_list[i]

    return luck_count


class TestWindow(unittest.TestCase):
    def test_window(self):
        luck_count = luck_balance(2, [[5, 1], [1, 1], [4, 0]])
        self.assertEqual(10, luck_count)
        luck_count = luck_balance(1, [[5, 1], [1, 1], [4, 0]])
        self.assertEqual(8, luck_count)


if __name__ == "__main__":
    unittest.main()
