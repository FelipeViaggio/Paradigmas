module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import City
import Link
import GHC.Exts.Heap (GenClosure(link))

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT (link:listaLinks) = Tun (link:listaLinks)

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT city1 city2 (Tun links) = (connectsL city1 (head links)) && (connectsL city2 (last links)) || 
                                    (connectsL city2 (head links)) && (connectsL city1 (last links))

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link (Tun listaLinks) = elem link listaLinks

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun []) = 0
delayT (Tun (link:listaLinks)) = delayL link + delayT (Tun listaLinks)