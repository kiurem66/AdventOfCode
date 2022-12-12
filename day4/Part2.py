from sys import stdin

c = 0

for line in stdin:
    elf0 = line.split(",")[0]
    elf1 = line.split(",")[1]

    min0 = int(elf0.split("-")[0])
    max0 = int(elf0.split("-")[1])
    min1 = int(elf1.split("-")[0])
    max1 = int(elf1.split("-")[1])

    if(min0 >= min1 and min0 <= max1) or (min1 >= min0 and min1 <= max0):
        c+=1

print(c)