module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import City
import Link

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT (link:listaLinks) = Tun (link:listaLinks)

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
-- connectsT firstCity secondCity (Tun (link:listaLinks)) | 

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link (Tun l:listaLinks) = elem link listaLinks

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel