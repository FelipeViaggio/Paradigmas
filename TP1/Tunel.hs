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
usesT link (Tun linkslist) = elem link linkslist
                           

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun linkslist) = sum (map delayL linkslist)

-- Pruebas
c1 = newC "c1" (newP 1 1)
c2 = newC "c2" (newP 2 2)
c3 = newC "c3" (newP 3 3)
c4 = newC "c4" (newP 4 4)
c5 = newC "c5" (newP 5 5)
c6 = newC "c6" (newP 6 6)
c7 = newC "c7" (newP 7 7)

q1 = newQ "q1" 1 1.0
q2 = newQ "q2" 2 2.0
q3 = newQ "q3" 3 3.0
q4 = newQ "q4" 4 4.0
q5 = newQ "q5" 5 5.0

l1 = newL c1 c2 q1
l2 = newL c2 c3 q2
l3 = newL c4 c5 q3
l4 = newL c5 c6 q4
l5 = newL c6 c7 q5

t1 = newT [l1, l2]
t2 = newT [l3, l4, l5]

lista = [
         isFirst c1 t1,
         not (isFirst c2 t1),
         isLast c3 t1,
         not (isLast c2 t1),
         areExtremes c1 c3 t1,
         not (areExtremes c1 c2 t1),
         connectsT c1 c3 t1,
         not (connectsT c1 c2 t1),
         usesT l1 t1,
         not (usesT l1 t2),
         delayT t1 == 4.2426405,
         not (delayT t1 /= 4.2426405),
         delayT t2 == 16.970562,
         not (delayT t2 /= 16.970562)
         ]