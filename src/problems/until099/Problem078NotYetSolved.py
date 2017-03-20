partitionNumbers = [1, 1]


def getPartitionNumber(n):
    sum = 0
    for k in range(1, n):
        firstIndex = int(n - 0.5 * k * (3 * k - 1));
        secondIndex = int(n - 0.5 * k * (3 * k + 1));
        firstNumber = 0
        if firstIndex >= 0:
            firstNumber = partitionNumbers[firstIndex]
        secondNumber = 0
        if secondIndex >= 0:
            secondNumber = partitionNumbers[secondIndex]
            #print("k", k)
            #print("first",firstIndex)
            #print("second",secondIndex)
        sum += (-1) ** (k + 1) * (firstNumber + secondNumber)
    return sum


i = 2
while True:
    newPartitionNumber = getPartitionNumber(i)
    if newPartitionNumber % 1000000 == 0:
        print(newPartitionNumber)
        print(len(partitionNumbers))
        break
    partitionNumbers.append(newPartitionNumber)
    #print(partitionNumbers)
    print(i)
    i+=1
