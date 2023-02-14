c = ord(input())
password = list("ILOVEYONSEI")

counter = abs(ord(password[0]) - c)

for i in range(1, len(password)) :
    counter += abs(ord(password[i]) - ord(password[i - 1]))
print(counter)