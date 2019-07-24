def divide(x, y):
    if y == 0:
        raise ZeroDivisionError("Division by zero")

    quotient = 0
    power = 32
    y_power = y << power
    remainder = x
    while remainder >= y:
        while y_power > remainder:
            y_power >>= 1
            power -= 1
        quotient += 1 << power
        remainder -= y_power
    return quotient
