# Checks if all characters of a string are alphanumeric (a-z, A-Z and 0-9).
c = "qA2"
print(c.isalnum())

# Checks if all the characters of a string are alphabetical (a-z and A-Z).
print(c.isalpha())

# Checks if all characters in a string are digits.
print(c.isdigit())

# Checks if all characters in a string are lowercase
print(c.islower())

# Checks if all characters of a string are uppercase
print(c.isupper())


def is_al_num(s):
    return s.isalnum()


def alpha(s):
    return s.isalpha()


def run_method_for_each_char(s):
    print(any([char.isalnum() for char in s]))
    print(any([char.isalpha() for char in s]))
    print(any([char.isdigit() for char in s]))
    print(any([char.islower() for char in s]))
    print(any([char.isupper() for char in s]))


if __name__ == "__main__":
    run_method_for_each_char(c)