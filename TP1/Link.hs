module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where

import Point
import City
import Quality

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL = Lin

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL thisCity (Lin cityA cityB quality) = thisCity == cityA || thisCity == cityB 

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL firstCity secondCity (Lin cityA cityB quality) = (firstCity == cityA && secondCity == cityB) || (firstCity == cityB && secondCity == cityA)
                                    
capacityL :: Link -> Int
capacityL (Lin cityA cityB quality) = capacityQ quality

delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin cityA cityB quality) = delayQ quality * distanceC cityA cityB

-- Pruebas

link1 = newL (newC "city1" (newP 1 1)) (newC "city2" (newP 2 2)) (newQ "c1" 1 1.0)
link2 = newL (newC "city3" (newP 3 3)) (newC "city4" (newP 4 4)) (newQ "c2" 2 2.0)

lista = [
         connectsL (newC "city1" (newP 1 1)) link1,
         connectsL (newC "city2" (newP 2 2)) link1,
         not (connectsL (newC "city3" (newP 3 3)) link1),
         not (connectsL (newC "city4" (newP 4 4)) link1),
         linksL (newC "city1" (newP 1 1)) (newC "city2" (newP 2 2)) link1,
         linksL (newC "city2" (newP 2 2)) (newC "city1" (newP 1 1)) link1,
         not (linksL (newC "city3" (newP 3 3)) (newC "city4" (newP 4 4)) link1),
         not (linksL (newC "city4" (newP 4 4)) (newC "city3" (newP 3 3)) link1),
         capacityL link1 == 1,
         capacityL link2 == 2,
         delayL link1 == sqrt(2), -- 1 * sqrt(2)
         delayL link2 == 2 * sqrt(2) -- 2 * sqrt(2)
            ]