from sys import stdin

def prioCalc(item):
    if(ord(item) >= 97):
        return ord(item) - 96
    return ord(item)-38

def splitlist(inputlist,n):
  first_half=inputlist[:n]
  sec_half=inputlist[n:]
  return first_half,sec_half


prioSum = 0
for rucksack in stdin:
    commonList = []
    comp1, comp2 = splitlist(rucksack, int(len(rucksack)/2))
    for item1 in comp1:
        for item2 in comp2:
            if item1 == item2:
                if not item1 in commonList:
                    commonList.append(item1)
    for item in commonList:
        prioSum += prioCalc(item)

print(prioSum)

