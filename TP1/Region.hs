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
                              | elem 0 (map (distanceC city) cities) = error "That city's coordinates already exist"
                              | elem (nameC city) (map nameC cities) = error "That city's name already exists"
                              | otherwise = Reg (cities ++ [city]) links tunnels
 
linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunnels) cityA cityB quality 
                              | notElem cityA cities || notElem cityB cities = error "At least one city doesn't exist"
                              | linkedR (Reg cities links tunnels) cityA cityB = error "That link already exists"
                              | otherwise = Reg cities (links ++ [newL cityA cityB quality]) tunnels

linkSearch :: [Link] -> City -> City -> Link
linkSearch [] city1 city2 = error "That link doesn't exist"
linkSearch (link:links) city1 city2 | linksL city1 city2 link = link
                                    | otherwise = linkSearch links city1 city2

linksForTunnel :: [Link] -> [City] -> [Link]
linksForTunnel links (city:cities)  | length (city:cities) == 1 = []
                                    | otherwise = linkSearch links city (head cities) : linksForTunnel links cities

isThereCapacity :: Region -> [City] -> Bool
isThereCapacity (Reg regionCities links tunnels) (city:cities) | length (city:cities) == 1 = True
                                                         | availableCapacityForR (Reg regionCities links tunnels) city (head cities) > 0 = isThereCapacity (Reg regionCities links tunnels) cities
                                                         | otherwise = error "There's no available capacity"

tunelR :: Region -> [City] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg regionCities links tunnels) (city:cities) | length (city:cities) == 1 = error "You need at least two cities"
                                                      | isThereCapacity (Reg regionCities links tunnels) (city:cities) = Reg regionCities links (tunnels ++ [newT (linksForTunnel links (city:cities))])
                                                      | otherwise = error "It was not able to create the tunnel"
                           

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities links tunnels) city1 city2 = any (connectsT city1 city2) tunnels

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cities links tunnels) city1 city2 = any (linksL city1 city2) links

connectingTunnel :: [Tunel] -> City -> City -> Tunel
connectingTunnel (tunnel:tunnels) city1 city2 | connectsT city1 city2 tunnel = tunnel
                                              | otherwise = connectingTunnel tunnels city1 city2

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg cities links tunnels) city1 city2 = delayT (connectingTunnel tunnels city1 city2)

countingTrues :: [Bool] -> Int
countingTrues bools = sum [1 | True <- bools]

usedCapacityforR :: Link -> [Tunel] -> Int
usedCapacityforR link tunnels = countingTrues [usesT link tunnel | tunnel <- tunnels]

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg cities links tunnels) city1 city2 
                         | notElem city1 cities || notElem city2 cities = error "At least one city doesn't exist!!"
                         | otherwise = capacityL (linkSearch links city1 city2) - usedCapacityforR (linkSearch links city1 city2) tunnels

-- Pruebas

punto1 = newP 1 1
punto2 = newP 2 2
punto3 = newP 3 3
punto4 = newP 4 4

madrid = newC "Madrid" punto1
berlin = newC "Berlin" punto2
bsas = newC "Buenos Aires" punto3

calidad1 = newQ "calidad1" 1 1.0
calidad2 = newQ "calidad2" 2 2.0
calidad3 = newQ "calidad3" 3 3.0

linkMB = newL madrid berlin calidad1
linkBM = newL berlin madrid calidad1
linkBBSAS = newL berlin bsas calidad2

tunelMBSAS = newT [linkMB, linkBBSAS]

region = tunelR (linkR (linkR (foundR (foundR (foundR newR madrid) berlin) bsas) madrid berlin calidad1) berlin bsas calidad2) [madrid, berlin, bsas]



lista = [ 
         linkSearch [linkMB, linkBM, linkBBSAS] madrid berlin == linkMB,
         linkSearch [linkBM, linkBBSAS] berlin madrid == linkBM,
         linkSearch [linkMB, linkBM, linkBBSAS] berlin bsas == linkBBSAS,
         not (elem linkBM [linkMB, linkBBSAS]),
         not (elem linkMB [linkBM, linkBBSAS]),
         not (elem linkBBSAS [linkMB, linkBM]),
         linksForTunnel [linkMB, linkBM, linkBBSAS] [madrid, berlin, bsas] == [linkMB, linkBBSAS],
         isThereCapacity region [berlin, bsas],
         isThereCapacity region [madrid],
         isThereCapacity region [berlin],
         isThereCapacity region [bsas],
         connectedR region madrid bsas, not (connectedR region madrid berlin), not (connectedR region berlin bsas),
         linkedR region madrid berlin, linkedR region berlin bsas, not (linkedR region madrid bsas),
         delayR region madrid bsas == 4.2426405,
         availableCapacityForR region madrid berlin == 0, availableCapacityForR region berlin bsas == 1
         ]