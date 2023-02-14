L = int(input())
string = list(input())

hashCount = 1
result = 0

for i in range(L) :
    string[i] = ord(string[i]) - (ord("a") - 1)

for i in range(L) :
    result += string[i] * hashCount
    hashCount *= 31

print(result % 1234567891)