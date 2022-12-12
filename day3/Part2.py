from sys import stdin

def prioCalc(item):
    if(ord(item) >= 97):
        return ord(item) - 96
    return ord(item)-38

def commonPrio(group):
    for r0 in group[0]:
        for r1 in group[1]:
            for r2 in group[2]:
                if r1 == r2 and r1 == r0:
                    return prioCalc(r1)

prioSum = 0

currGroup = []
groups = []

i = 0
for rucksack in stdin:
    currGroup.append(rucksack)
    i+=1
    if i == 3:
        i=0
        groups.append(currGroup)
        currGroup = []

for group in groups:
    prioSum += commonPrio(group)


print(prioSum)

