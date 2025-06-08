import sys
from collections import defaultdict

input = sys.stdin.readline


def to_base(num, base):
    if num == 0:
        return "0"

    result = ""
    while num > 0:
        result = str(num % base) + result
        num //= base
    return result

def solution(expressions):
    cExpressions = []
    iExpressions = []

    for expr in expressions:
        if 'X' in expr:
            iExpressions.append(expr)
        else:
            cExpressions.append(expr)

    max_digit = 0
    for expr in expressions:
        for char in expr:
            if char.isdigit():
                max_digit = max(max_digit, int(char))

    possible_bases = list(range(max_digit + 1, 10))

    valid_bases = []
    for base in possible_bases:
        is_valid = True
        for expr in cExpressions:
            parts = expr.split()
            left_num, operator, right_num, _, result_num = parts

            try:
                left_val = int(left_num, base)
                right_val = int(right_num, base)
                result_val = int(result_num, base)

                if operator == '+':
                    if left_val + right_val != result_val:
                        is_valid = False
                        break
                else:
                    if left_val - right_val != result_val:
                        is_valid = False
                        break
            except ValueError:
                is_valid = False
                break

        if is_valid:
            valid_bases.append(base)

    answer = []
    for expr in iExpressions:
        parts = expr.split()
        left_num, operator, right_num = parts[0], parts[1], parts[2]

        results = set()

        for base in valid_bases:
            try:
                left_val = int(left_num, base)
                right_val = int(right_num, base)

                if operator == '+':
                    calc_result = left_val + right_val
                else:
                    calc_result = left_val - right_val

                base_result = to_base(calc_result, base)
                results.add(base_result)

            except ValueError:
                continue

        if len(results) == 1:
            final_result = list(results)[0]
        else:
            final_result = "?"

        answer.append(f"{left_num} {operator} {right_num} = {final_result}")

    return answer
