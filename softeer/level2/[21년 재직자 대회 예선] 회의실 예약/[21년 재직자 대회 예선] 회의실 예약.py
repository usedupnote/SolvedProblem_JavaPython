import sys
input = sys.stdin.readline

N, M = map(int, input().split());

meetingRoom = {}

for _ in range(N) :
    roomName = input().rstrip();
    meetingRoom[roomName] = [0 for _ in range(9)];

for i in range(M) :
    roomName, start, end = input().split();
    start = int(start) - 9;
    end = int(end) - 9;
    meetingRoom[roomName][start : end] = [1] * (end - start);

sortedKeys = sorted(meetingRoom.keys())

for roomName in sortedKeys :
    if roomName != sortedKeys[0] :
        print("-----")
    print("Room ", roomName, ":", sep="")

    count = 2 if meetingRoom[roomName][0] == 0 else 1
    for i in range(1, 9) :
        if meetingRoom[roomName][i] + meetingRoom[roomName][i-1] == 1 :
            count += 1

    if count == 1 :
        print("Not available")
    else :
        print(count//2, "available:")
        check = 0
        if meetingRoom[roomName][0] == 0 :
            print("09-", end="")
            check += 1

        for i in range(1, 9) :
            if meetingRoom[roomName][i] + meetingRoom[roomName][i-1] == 1 :
                print(i + 9, end="")

                if check%2 == 1:
                    print("")
                else :
                    print("-", end="")

                check += 1

        if meetingRoom[roomName][8] == 0:
            print("18")