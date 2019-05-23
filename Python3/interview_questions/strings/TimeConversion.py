
# Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
# Example: 07:05:45PM
# Answer: 19:05:45


def time_conversion(s):
    zn = s[-2:]
    if zn == "PM" and s[:2] != "12":
        s = str(12 + int(s[:2])) + s[2:]
    if zn == "AM" and s[:2] == "12":
        s = "00" + s[2:]
    return s[:-2]


if __name__ == "__main__":
    print(time_conversion("07:05:45PM"))
