
result = 0

dictionary = {}

dictionary["black"] = 0
dictionary["brown"] = 1
dictionary["red"] = 2
dictionary["orange"] = 3
dictionary["yellow"] = 4
dictionary["green"] = 5
dictionary["blue"] = 6
dictionary["violet"] = 7
dictionary["grey"] = 8
dictionary["white"] = 9

result += dictionary[input()] * 10
result += dictionary[input()]

counter = dictionary[input()]

while counter > 0:
    result = result * 10
    counter -= 1

print(result)