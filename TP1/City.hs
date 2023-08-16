module City ( City, newC, nameC, distanceC )
   where

import Point

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
newC name place = Cit name place

nameC :: City -> String
nameC (Cit name place) = name

distanceC :: City -> City -> Float
distanceC (Cit name1 place1) (Cit name2 place2) = difP place1 place2
