countingTrues :: [Bool] -> Int
countingTrues bools = sum [1 | True <- bools]

