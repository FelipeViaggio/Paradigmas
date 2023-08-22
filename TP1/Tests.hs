import Point
import City
import Quality
import Link
import GHC.Exts.Heap (GenClosure(link))
import Tunel
import Region


punto1 = newP 1 1
punto2 = newP 2 2
punto3 = newP 3 3

madrid = newC "Madrid" punto1
berlin = newC "Berlin" punto2
bsas = newC "Buenos Aires" punto3

calidad1 = newQ "calidad1" 1 1.0
calidad2 = newQ "calidad2" 2 2.0
calidad3 = newQ "calidad3" 3 3.0

linkMB = newL madrid berlin calidad1
linkBM = newL berlin madrid calidad1
linkBBSAS = newL berlin bsas calidad2
linkBSASB = newL bsas berlin calidad2
linkMBSAS = newL madrid bsas calidad3
linkBSASM = newL bsas madrid calidad3

tunelMBSAS = newT [linkMB, linkBBSAS]

region1 = newR
city1 = foundR region1 madrid
city2 = foundR region1 berlin
city3 = foundR region1 bsas

primerlink = linkR region1 madrid berlin calidad1
segundolink = linkR region1 berlin bsas calidad2

camino1 = linksForR region1 madrid bsas
---------------
lista = [difP punto1 punto2 == 1.4142135, difP punto1 punto3 == 2.828427, difP punto2 punto3 == 1.4142135,
        nameC madrid == "Madrid", nameC berlin == "Berlin", nameC bsas == "Buenos Aires",
        distanceC madrid berlin == 1.4142135, distanceC berlin bsas == 1.4142135, distanceC madrid bsas == 2.828427,
        capacityQ calidad1 == 1, capacityQ calidad2 == 2,
        delayQ calidad1 == 1.0, delayQ calidad2 == 2.0,
        connectsL madrid linkMB, connectsL berlin linkMB, not (connectsL bsas linkMB),
        linksL madrid berlin linkMB, linksL berlin madrid linkMB, not (linksL madrid bsas linkMB),
        capacityL linkMB == 1, capacityL linkBBSAS == 2,
        delayL linkMB == 1.0, delayL linkBBSAS == 2.0,
        not (connectsT madrid berlin tunelMBSAS), not (connectsT berlin madrid tunelMBSAS), connectsT madrid bsas tunelMBSAS, connectsT bsas madrid tunelMBSAS, not (connectsT berlin bsas tunelMBSAS), not (connectsT bsas berlin tunelMBSAS),
        usesT linkMB tunelMBSAS, usesT linkBBSAS tunelMBSAS, usesT linkBM tunelMBSAS, usesT linkBSASB tunelMBSAS, not (usesT linkMBSAS tunelMBSAS), not (usesT linkBSASM tunelMBSAS),
        delayT tunelMBSAS == 3.0
        ]

main = print lista