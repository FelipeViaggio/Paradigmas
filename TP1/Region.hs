module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR )
   where

import Point
import City
import Quality
import Link
import Tunel


data Region = Reg [City] [Link] [Tunel] deriving (Show)

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunnels) city 
                              | elem city cities = error "That city already exists"
                              | elem 0 (map distanceC city cities) = error "That city's coordinates already exist"
                              | elem (nameC city) (map nameC cities) = error "That city's name already exists"
                              | otherwise = Reg (cities ++ [city]) links tunnels

isRepeatedLink :: [Link] -> City -> City -> Bool
isRepeatedLink links city1 city2 = any (linksL city1 city2) links
 
linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunnels) cityA cityB quality 
                              | notElem cityA cities || notElem cityB cities = error "At least one city doesn't exist"
                              | isRepeatedLink links cityA cityB = error "That link already exists"
                              | otherwise = Reg cities (links ++ [newL cityA cityB quality]) tunnels

tunelR :: Region -> [City] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg cities links tunels) citiesToConnect = 

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities links tunnels) city1 city2 = any (connectsT city1 city2) tunnels

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cities links tunnels) city1 city2 = any (linksL city1 city2) links

connectingTunnel :: [Tunel] -> City -> City -> Tunel
connectingTunnel (tunnel:tunnels) city1 city2 | connectsT city1 city2 tunnel = tunnel
                                              | otherwise = connectingTunnel tunnels city1 city2

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg cities links tunnels) city1 city2 = delayT (connectingTunnel tunnels city1 city2)

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg cities links tunels) city1 city2 = 