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
linksL firstCity secondCity (Lin cityA cityB quality) | (firstCity == cityA && secondCity == cityB) || (firstCity == cityB && secondCity == cityA) = True
                                                      | otherwise = False

capacityL :: Link -> Int
capacityL (Lin cityA cityB quality) = capacityQ quality

delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin cityA cityB  quality) = delayQ quality