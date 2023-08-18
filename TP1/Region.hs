module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where

import Point
import City
import Quality
import Link
import Tunel


data Region = Reg [City] [Link] [Tunel]
newR :: Region
newR [cities] [links] [tunels] = Reg [cities] [links] [tunels]

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunels) city = Reg (cities ++ [city]) links tunels

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunels) cityA cityB quality = Reg cities (links ++ [newL cityA cityB quality]) tunels

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR = (Reg cities links tunels) [cityA, cityB] | 



connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel


linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas


delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora


availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades