import Point
import City
import Quality
import Link
import GHC.Exts.Heap (GenClosure(link))
import Tunel
import Region
import Control.Exception
import System.IO.Unsafe

-- Creación de puntos
point1 = newP 1 1
point2 = newP 2 2
point3 = newP 3 3
point4 = newP 4 4

-- Creación de ciudades
madrid = newC "Madrid" point1
berlin = newC "Berlin" point2
bsas = newC "Buenos Aires" point3

-- Creación de calidades
quality1 = newQ "quality1" 1 1.0
quality2 = newQ "quality2" 2 2.0
quality3 = newQ "quality3" 3 3.0

-- Creación de links
linkM_B = newL madrid berlin quality1
linkB_M = newL berlin madrid quality1
linkB_BSAS = newL berlin bsas quality2
linkBSAS_B = newL bsas berlin quality2
linkM_BSAS = newL madrid bsas quality3
linkBSAS_M = newL bsas madrid quality3

-- Creación de túneles
tunelM_BSAS = newT [linkM_B, linkB_BSAS]

-- Creación de la región
region = tunelR (linkR (linkR (foundR (foundR (foundR newR madrid) berlin) bsas) madrid berlin quality1) berlin bsas quality2) [madrid, berlin, bsas]

-- Variables para tests
difPtest = difP point1 point2
nameCtest1 = nameC madrid
nameCtest2 = nameC berlin
capacityQtest = capacityQ quality1
delayQtest = delayQ quality2
distanceCtest = distanceC madrid berlin

-- -- Manipulación de excepciones
testF :: Show a => a -> Bool
testF action = unsafePerformIO $ do
    result <- tryJust isException (evaluate action)
    return $ case result of
        Left _ -> True
        Right _ -> False
    where
        isException :: SomeException -> Maybe ()
        isException _ = Just ()

existingcity1 = foundR region madrid
existingcity2 = foundR region berlin
existingpoint1 = foundR region (newC "Madrid2" point1)
existingpoint2 = foundR region (newC "Berlin2" point2)
existingname1 = foundR region (newC "Madrid" point4)
existingname2 = foundR region (newC "Berlin" point4)
existinglink1 = linkR region madrid berlin quality1
nonexistingcity1 = linkR region madrid (newC "Tokyo" point4) quality1
missingcities = tunelR region [berlin]
notavailablecapacity = tunelR region [madrid, berlin, bsas]
nonexistingcity2 = availableCapacityForR region madrid (newC "Tokyo" point4) 

functionsList = [
         difPtest == sqrt 2, 
         nameCtest1 == "Madrid",
         nameCtest2 == "Berlin",
         distanceCtest == sqrt 2,
         capacityQtest == 1,
         delayQtest == 2.0,
         connectsL madrid linkM_B,
         connectsL berlin linkB_BSAS,
         not (connectsL madrid linkB_BSAS),
         not (connectsL berlin linkM_BSAS),
         linksL madrid berlin linkM_B,
         linksL berlin bsas linkB_BSAS,
         capacityL linkM_B == 1,
         capacityL linkB_BSAS == 2,
         delayL linkM_B == sqrt 2,
         delayL linkB_BSAS == 2 * sqrt 2,
         connectsT madrid bsas tunelM_BSAS,
         not (connectsT madrid berlin tunelM_BSAS),
         usesT linkM_B tunelM_BSAS,
         not (usesT linkM_BSAS tunelM_BSAS),
         delayT tunelM_BSAS == 4.2426405,
         connectedR region madrid bsas,
         not (connectedR region madrid berlin),
         not (connectedR region berlin bsas),
         linkedR region madrid berlin,
         linkedR region berlin bsas,
         not (linkedR region madrid bsas),
         delayR region madrid bsas == 3 * sqrt 2,
         availableCapacityForR region madrid berlin == 0,
         availableCapacityForR region berlin bsas == 1
        ]

exceptionsList = [testF existingcity1, 
                  testF existingcity2, 
                  testF existingpoint1, 
                  testF existingpoint2, 
                  testF existingname1,
                  testF existingname2,
                  testF existinglink1,
                  testF nonexistingcity1,
                  testF missingcities,
                  testF notavailablecapacity,
                  testF nonexistingcity2
                  ]
      
main = do
    putStrLn "Testing Functions: "
    print functionsList

    putStrLn "Exception Handling: "
    print exceptionsList