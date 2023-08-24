import Point
import City
import Quality
import Link
import GHC.Exts.Heap (GenClosure(link))
import Tunel
import Region

-- Creación de puntos
punto1 = newP 1 1
punto2 = newP 2 2
punto3 = newP 3 3
punto4 = newP 4 4

-- Creación de ciudades
madrid = newC "Madrid" punto1
berlin = newC "Berlin" punto2
bsas = newC "Buenos Aires" punto3

-- Creación de calidades
calidad1 = newQ "calidad1" 1 1.0
calidad2 = newQ "calidad2" 2 2.0
calidad3 = newQ "calidad3" 3 3.0

-- Creación de links
linkMB = newL madrid berlin calidad1
linkBM = newL berlin madrid calidad1
linkBBSAS = newL berlin bsas calidad2
linkBSASB = newL bsas berlin calidad2
linkMBSAS = newL madrid bsas calidad3
linkBSASM = newL bsas madrid calidad3

-- Creación de túneles
tunelMBSAS = newT [linkMB, linkBBSAS]

-- Creación de la región
region = tunelR (linkR (linkR (foundR (foundR (foundR newR madrid) berlin) bsas) madrid berlin calidad1) berlin bsas calidad2) [madrid, berlin, bsas]

---------------
lista = [connectedR region madrid bsas, not (connectedR region madrid berlin), not (connectedR region berlin bsas),
         linkedR region madrid berlin, linkedR region berlin bsas, not (linkedR region madrid bsas),
         delayR region madrid bsas == 3.0,
         availableCapacityForR region madrid berlin == 0, availableCapacityForR region berlin bsas == 1
        ]

main = print lista