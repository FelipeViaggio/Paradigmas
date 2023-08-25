module City ( City, newC, nameC, distanceC )
   where

import Point

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
newC = Cit

nameC :: City -> String
nameC (Cit name place) = name

distanceC :: City -> City -> Float
distanceC (Cit name1 place1) (Cit name2 place2) = difP place1 place2

-- Pruebas

city1 = newC "city1" (newP 1 1)
city2 = newC "city2" (newP 2 2)

nameCtest = nameC city1
nameCtest2 = nameC city2

distanceCtest = distanceC city1 city2

lista = [
         nameCtest == "city1",
         nameCtest /= "city2",
         nameCtest2 == "city2",
         nameCtest2 /= "city1",
         distanceCtest == sqrt(2),
         distanceCtest /= sqrt(4)
         ]