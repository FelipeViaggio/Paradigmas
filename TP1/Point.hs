module Point ( Point, newP, difP )
   where
data Point = Poi Int Int deriving (Eq, Show)

newP :: Int -> Int -> Point
newP = Poi

substraction :: Point -> Point -> Point
substraction (Poi x1 y1) (Poi x2 y2) = Poi (x1 - x2) (y1 - y2)

norm :: Point -> Float
norm (Poi z1 z2) = sqrt(fromIntegral(z1^2 + z2^2))

difP :: Point -> Point -> Float  -- distancia absoluta
difP point1 point2 = norm(substraction point1 point2)

-- Pruebas

point1 = newP 1 1
point2 = newP 2 2

substractiontest = substraction point1 point2
normtest = norm point1
normtest2 = norm point2
difPtest = difP point1 point2

lista = [
         substractiontest == newP (-1) (-1),
         substractiontest /= newP 1 1,
         normtest == sqrt(2),
         normtest /= sqrt(4),
         normtest2 == sqrt(8),
         normtest2 /= sqrt(2),
         difPtest == sqrt(2), 
         difPtest /= sqrt(4)
        ]