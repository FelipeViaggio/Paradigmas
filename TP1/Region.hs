module Region ( Region, newR, foundR, linkR, linksForR, tunelR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where

import Point
import City
import Quality
import Link
import Tunel


data Region = Reg [City] [Link] [Tunel] deriving (Eq, Show)

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunels) city = Reg (cities ++ [city]) links tunels

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunels) cityA cityB quality = Reg cities (links ++ [newL cityA cityB quality]) tunels

linksForR :: Region -> City -> City -> [Link] -- indica los enlaces que hay que seguir para ir de una ciudad a otra
linksForR (Reg cities links tunels) city1 city2 = foldr findLinks [] links
      where findLinks link acc | connectsL city2 link = link : takeWhile (/= link) acc
                               | otherwise = acc 


tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg cities links tunels) [city1, city2] = Reg cities links (tunels ++ [newT (linksForR (Reg cities links tunels) city1 city2)])

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities links tunels) city1 city2 = any (\tunel -> connectsT city1 city2 tunel) tunels

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cities links tunels) city1 city2 = any (\link -> linksL city1 city2 link) links

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg cities links tunels) city1 city2 = foldr(\tunel acc -> if connectsT city1 city2 tunel then delayT tunel else acc) 0.0 tunels

usedCapacityForR :: Region -> City -> City -> Int -- indica la capacidad utilizada entre dos ciudades
usedCapacityForR (Reg cities links tunels) city1 city2 = foldr(\link acc -> if linksL city1 city2 link then capacityL link + acc else acc) 0 links

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg cities links tunels) city1 city2 = (foldr(\link acc -> if linksL city1 city2 link then capacityL link else acc) 0 links)