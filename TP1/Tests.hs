import Point
import City
import Quality
import Link
import GHC.Exts.Heap (GenClosure(link))
import Tunel

punto1 = newP 1 1
punto2 = newP 2 2
punto3 = newP 3 3

madrid = newC "Madrid" punto1
berlin = newC "Berlin" punto2
bsas = newC "Buenos Aires" punto3

calidad1 = newQ "calidad1" 1 1.0
calidad2 = newQ "calidad2" 2 2.0

linkMB = newL madrid berlin calidad1
linkBM = newL berlin madrid calidad1
linkBBSAS = newL berlin bsas calidad2
linkBSASB = newL bsas berlin calidad2

tunelMBSAS = newT [linkMB, linkBBSAS]



punto1
punto2
punto3

substraction punto1 punto2
substraction punto2 punto1
substraction punto1 punto3
substraction punto3 punto1
substraction punto2 punto3
substraction punto3 punto2

norm punto1 
norm punto2
norm punto3

difP punto1 punto2
difP punto1 punto3
difP punto2 punto3


madrid
berlin
bsas

nameC madrid
nameC berlin
nameC bsas

distanceC madrid berlin
distanceC berlin bsas
distanceC madrdi bsas


calidad1
calidad2

capacityQ calidad1
capacityQ calidad2

delayQ calidad1
delayQ calidad2


linkMB
linkBBSAS

samelink linkMB linkBM
samelink linkBM linkMB
samelink linkBBSAS linkBSASB
samelink linkBSASB linkBBSAS
samelink linkMB linkBBSAS
samelink linkBBSAS linkMB

connectsL madrid linkMB
connectsL berlin linkMB
connectsL bsas linkMB

linkPosition madrid linkMB
linkPosition berlin linkMB
linkPosition bsas linkMB

linksL madrid berlin linkMB
linksL berlin madrid linkMB
linksL madrid bsas linkMB

capacityL linkMB
capacityL linkBBSAS

delayL linkMB
delayL linkBBSAS


tunelMBSAS

connectsT madrid berlin tunelMBSAS
connectsT berlin madrid tunelMBSAS
connectsT madrid bsas tunelMBSAS
connectsT bsas madrid tunelMBSAS
connectsT berlin bsas tunelMBSAS
connectsT bsas berlin tunelMBSAS

usesT linkMB tunelMBSAS
usesT linkBBSAS tunelMBSAS
usesT linkBM tunelMBSAS
usesT linkBSASB tunelMBSAS

delayT tunelMBSAS