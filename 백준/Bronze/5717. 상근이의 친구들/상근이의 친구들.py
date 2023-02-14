male, female = input().split()

male = int(male)
female = int(female)

while male != 0 and female != 0 :
    print(male + female)
    
    male, female = input().split()
    
    male = int(male)
    female = int(female)