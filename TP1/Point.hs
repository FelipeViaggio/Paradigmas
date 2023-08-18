module Point ( Point, newP, difP )
   where
data Point = Poi Int Int deriving (Eq, Show)

newP :: Int -> Int -> Point
newP cordX cordY = Poi cordX cordY

substraction :: Point -> Point -> Point
substraction (Poi x1 y1) (Poi x2 y2) = Poi (x1 - x2) (y1 - y2)

norm :: Point -> Float
norm (Poi z1 z2) = sqrt(fromIntegral(z1^2 + z2^2))

difP :: Point -> Point -> Float  -- distancia absoluta
difP point1 point2 = norm(substraction point1 point2)