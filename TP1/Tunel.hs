module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Point
import City
import Quality
import Link

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun 

areExtremes :: City -> City -> Tunel -> Bool
areExtremes city1 city2 (Tun links) | length links == 1 = linksL city1 city2 (head links)
                                    | length links > 1 = (connectsL city1 (head (take 2 links)) && not (connectsL city1 (last (take 2 links)))) && 
                                                         (not (connectsL city2 (head (drop (length links - 2) links))) && connectsL city2 (last (drop (length links -2) links))) ||
                                                         (connectsL city2 (head (take 2 links)) && not (connectsL city2 (last (take 2 links)))) && 
                                                         (not (connectsL city1 (head (drop (length links - 2) links))) && connectsL city1 (last (drop (length links -2) links)))

connectsT :: City -> City -> Tunel -> Bool -- indica si este tunel conecta estas dos ciudades distintas
connectsT city1 city2 (Tun links) = areExtremes city1 city2 (Tun links)
                                 
      
usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link (Tun linkslist) = True-- | elem link linkslist || reverseLink elem link linkslist = True
                           -- | otherwise = False
                           

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun []) = 0
delayT (Tun (link:listaLinks)) = delayL link + delayT (Tun listaLinks)