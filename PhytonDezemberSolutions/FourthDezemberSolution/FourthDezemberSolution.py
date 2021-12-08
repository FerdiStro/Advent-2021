from sun.management.counter import Counter

with open( "inputfourthDezember.txt") as f:
    roundCount = 0
    for x in f:
        if roundCount == 0:
            bingoCount = x
            roundCount =  1
            split = Counter(map(int, bingoCount.split(",")))
        else:
            splitAllNummbers = Counter(map(int, f.read().strip().split()))



















    print(split)








# def retunrBingoNummbers():

