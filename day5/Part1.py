from sys import stdin

read_state = 0 #0 = reading stacks, 1 = reading transactions

transactions = []

stacks = []

n = 0
for line in stdin:
    if read_state == 0:
        if "1" in line:
            read_state = 1
            continue
        for i in range(0, len(line), 4):
            if(n == 0):
                for a in range(int(len(line)/4)):
                    stacks.append([])
            token = line[i:i+4].strip()
            if(not token == ""):
                stacks[int(i/4)].append(token)
    n+=1

print(stacks)
    