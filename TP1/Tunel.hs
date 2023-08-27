module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Point
import City
import Quality
import Link

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun

isFirst :: City -> Tunel -> Bool
isFirst currentCity (Tun links) = connectsL currentCity (head (take 2 links)) && not (connectsL currentCity (last (take 2 links)))

isLast :: City -> Tunel -> Bool
isLast currentCity (Tun links) = not (connectsL currentCity (head (drop (length links - 2) links))) && connectsL currentCity (last (drop (length links -2) links))

areExtremes :: City -> City -> Tunel -> Bool
areExtremes city1 city2 (Tun links) | length links == 1 = linksL city1 city2 (head links)
                                    | length links > 1 = isFirst city1 (Tun links) && isLast city2 (Tun links) ||
                                                         isFirst city2 (Tun links) && isLast city1 (Tun links)

connectsT :: City -> City -> Tunel -> Bool -- indica si este tunel conecta estas dos ciudades distintas
connectsT city1 city2 (Tun links) = areExtremes city1 city2 (Tun links)
                                 
      
usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link (Tun linksList) = elem link linksList
                           

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun linksList) = sum (map delayL linksList)
