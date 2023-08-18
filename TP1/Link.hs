module Link ( Link, newL, linksL, connectsL, linkPosition, capacityL, delayL )
   where

import City
import Quality

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL cityA cityB quality = Lin cityA cityB quality

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL thisCity (Lin cityA cityB quality) | thisCity == cityA || thisCity == cityB = True
                                             | otherwise = False

linkPosition :: City -> Link -> Int
linkPosition thisCity (Lin cityA cityB quality) | thisCity == cityA = 1
                                                | thisCity == cityB = 2
                                                | otherwise = 0

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL firstCity secondCity (Lin cityA cityB quality) | (firstCity == cityA && secondCity == cityB) || (firstCity == cityB && secondCity == cityA) = True
                                                      | otherwise = False

capacityL :: Link -> Int
capacityL (Lin cityA cityB quality) = capacityQ quality

delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin cityA cityB  quality) = delayQ quality