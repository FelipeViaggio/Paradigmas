module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Point
import City
import Quality
import Link
import GHC.Exts.Heap (GenClosure(link))

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT (link:linkslist) = Tun (link:linkslist)

connectsT :: City -> City -> Tunel -> Bool -- indica si este tunel conecta estas dos ciudades distintas
connectsT city1 city2 (Tun links) 

-- esta falta tambien
usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link (Tun linkslist) = any (samelink link) linkslist

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun []) = 0
delayT (Tun (link:listaLinks)) = delayL link + delayT (Tun listaLinks)

--podemos usar
samelink :: Link -> Link -> Bool
samelink (Lin cityA cityB quality) (Lin cityC cityD quality2) | (cityA == cityC && cityB == cityD) || (cityA == cityD && cityB == cityC) = True
                                                              | otherwise = False


counter :: [Link] -> City -> City -> Int -- indica la cantidad de enlaces entre dos ciudades
counter links city1 city2 = foldr(\link acc -> if linksL city1 city2 link then acc +1 else acc) 0 links

counterintunnels:: Region -> City -> City -> Int
counterintunnels (Reg cities links tunels) city1 city2 = foldr(\tunel acc -> counterfortunel tunel city1 city2 + acc) 0 tunels
         where counterfortunel (Tun )


-- Pathr, linksforR, usedcapacity, available capavity revisar, borrar el deriving de region