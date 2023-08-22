import Point
import City
import Quality
import Link
import GHC.Exts.Heap (GenClosure(link))
import Tunel
import Region


import Point
import City
import Quality
import Link
import Tunel
import Region

-- Creación de puntos
punto1 = newP 1 1
punto2 = newP 2 2
punto3 = newP 3 3

-- Creación de ciudades
madrid = newC "Madrid" punto1
berlin = newC "Berlin" punto2
bsas = newC "Buenos Aires" punto3

-- Creación de calidades
calidad1 = newQ "calidad1" 1 1.0
calidad2 = newQ "calidad2" 2 2.0
calidad3 = newQ "calidad3" 3 3.0

-- Creación de la región
region1 = (newR `foundR` madrid `foundR` berlin `foundR` bsas)
    `linkR` madrid berlin calidad1
    `linkR` berlin bsas calidad2
    `linkR` madrid bsas calidad3

-- Prueba de linksForR
camino1 = linksForR region1 bsas
camino2 = linksForR region1 berlin



---------------
lista = [difP punto1 punto2 == 1.4142135, difP punto1 punto3 == 2.828427, difP punto2 punto3 == 1.4142135,
        nameC madrid == "Madrid", nameC berlin == "Berlin", nameC bsas == "Buenos Aires",
        distanceC madrid berlin == 1.4142135, distanceC berlin bsas == 1.4142135, distanceC madrid bsas == 2.828427,
        capacityQ calidad1 == 1, capacityQ calidad2 == 2,
        delayQ calidad1 == 1.0, delayQ calidad2 == 2.0,
        connectsL madrid linkMB == True, connectsL berlin linkMB == True, connectsL bsas linkMB == False,
        linksL madrid berlin linkMB == True, linksL berlin madrid linkMB == True, linksL madrid bsas linkMB == False,
        capacityL linkMB == 1, capacityL linkBBSAS == 2,
        delayL linkMB == 1.0, delayL linkBBSAS == 2.0,
        connectsT madrid berlin tunelMBSAS == False, connectsT berlin madrid tunelMBSAS == False, connectsT madrid bsas tunelMBSAS == True, connectsT bsas madrid tunelMBSAS == True, connectsT berlin bsas tunelMBSAS == False, connectsT bsas berlin tunelMBSAS == False,
        usesT linkMB tunelMBSAS == True, usesT linkBBSAS tunelMBSAS == True, usesT linkBM tunelMBSAS == True, usesT linkBSASB tunelMBSAS == True, usesT linkMBSAS tunelMBSAS == False, usesT linkBSASM tunelMBSAS == False,
        delayT tunelMBSAS == 3.0
        ]

--main = print lista