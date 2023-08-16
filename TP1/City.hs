module City ( City, newC, nameC, distanceC )
   where

import Point

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
newC nombre ubicacion = Cit nombre ubicacion

nameC :: City -> String
nameC (Cit nombre ubicacion) = nombre

distanceC :: City -> City -> Float
distanceC (Cit nombre1 ubicacion1) (Cit nombre2 ubicacion2) = difP ubicacion1 ubicacion2
