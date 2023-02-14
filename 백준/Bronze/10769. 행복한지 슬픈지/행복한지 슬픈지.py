import sys
input = sys.stdin.readline

message = list(input().strip())

length = len(message) - 2

happy = 0
sad = 0

while length >= 0 :
    if message[length] == ":" :
        if message[length + 1] == "-" :
            if message[length + 2] == ")":
                happy += 1
                length -= 1
            elif message[length + 2] == "(" :
                sad += 1
                length -= 1
    length -= 1

if happy + sad == 0 :
    print("none")
elif happy < sad :
    print("sad")
elif happy > sad :
    print("happy")
else :
    print("unsure")