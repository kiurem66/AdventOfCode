from sys import stdin

def doMove(line, stacks):
    source = int(line.split(" ")[3])
    dest = int(line.split(" ")[5])
    amt = int(line.split(" ")[1])
    temp = []
    for i in range(amt):
        temp.append(stacks[source-1].pop())
    for i in range(amt):
        stacks[dest-1].append(temp.pop())

read_state = 0 #0 = reading stacks, 1 = reading transactions

transactions = []

stacks = []

n = 0
for line in stdin:
    if read_state == 0:
        if "1" in line:
            for stack in stacks:
                stack.reverse()
            read_state = 1
            continue
        if(n == 0):
            for a in range(int(len(line)/4)):
                stacks.append([])
        for i in range(0, len(line), 4):
            token = line[i:i+4].strip()
            if(not token == ""):
                stacks[int(i/4)].append(token)
    else:
        doMove(line, stacks)
    n+=1

for stack in stacks:
    print(stack.pop()[1], end="")
print()